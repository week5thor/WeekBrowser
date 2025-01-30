package com.a525team.weekbrowser;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class HomeActivity extends Activity {
	
	private ArrayList<HashMap<String, Object>> recommendation = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> history = new ArrayList<>();
	
	private ListView listview1;
	
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		
		if (Build.VERSION.SDK_INT >= 23) {
			if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
				requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
			} else {
				initializeLogic();
			}
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		listview1 = findViewById(R.id.listview1);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				intent.setClass(getApplicationContext(), IntentActivity.class);
				intent.setData(Uri.parse(recommendation.get((int)_position).get("url").toString()));
				startActivity(intent);
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		history = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/history.json"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		// Створюємо Map для зберігання унікальних значень та їх кількості
		Map<String, Integer> urlCounts = new LinkedHashMap<>();
		
		// Проходимо через список history та додаємо унікальні значення під ключем "url" до Map з підрахунком кількості збігів
		for (HashMap<String, Object> entry : history) {
			    Object url = entry.get("url");
			    if (url instanceof String) {
				        urlCounts.put((String) url, urlCounts.getOrDefault((String) url, 0) + 1);
				    }
		}
		
		// Очищуємо список recommendation
		recommendation.clear();
		
		// Додаємо унікальні значення з Map до списку recommendation у вигляді нових Map з кількістю збігів
		for (Map.Entry<String, Integer> entry : urlCounts.entrySet()) {
			    HashMap<String, Object> map = new HashMap<>();
			    map.put("url", entry.getKey());
			    map.put("rep", String.valueOf(entry.getValue()));
			    recommendation.add(map);
		}
		
		// Сортуємо список recommendation в порядку спадання по значенню "rep" за допомогою анонімного класу
		Collections.sort(recommendation, new Comparator<HashMap<String, Object>>() {
			    @Override
			    public int compare(HashMap<String, Object> map1, HashMap<String, Object> map2) {
				        int rep1 = Integer.parseInt((String) map1.get("rep"));
				        int rep2 = Integer.parseInt((String) map2.get("rep"));
				        return Integer.compare(rep2, rep1); // Порядок спадання
				    }
		});
		
		listview1.setAdapter(new Listview1Adapter(recommendation));
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.histori, null);
			}
			
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			
			textview2.setText(_data.get((int)_position).get("url").toString());
			textview3.setText(_data.get((int)_position).get("rep").toString());
			textview2.setTextColor(0xFFFFFFFF);
			textview3.setTextColor(0xFFFFFFFF);
			
			return _view;
		}
	}
}