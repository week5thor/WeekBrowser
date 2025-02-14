package com.a525team.weekbrowser;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class LoadresActivity extends Activity {
	
	ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	
	private ArrayList<HashMap<String, Object>> lr = new ArrayList<>();
	
	private ListView listview1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.loadres);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		ThemeManager.applyTheme(this); // Встановлення теми
		    super.onCreate(_savedInstanceState);
		 
		        setContentView(R.layout.loadres);
		listview1 = findViewById(R.id.listview1);
	}
	
	private void initializeLogic() {
		SafeMarginUtils.init(this, findViewById(android.R.id.content));
		// Ініціалізація Skin
		Skin skin = new Skin();
		
		skin.setBG(listview1, 2, true);
		lr = new Gson().fromJson(dataHolder.getData("loadres"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		listview1.setAdapter(new Listview1Adapter(lr));
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
				_view = _inflater.inflate(R.layout.load_res, null);
			}
			
			final LinearLayout bg = _view.findViewById(R.id.bg);
			final TextView url = _view.findViewById(R.id.url);
			final TextView method = _view.findViewById(R.id.method);
			final TextView headers = _view.findViewById(R.id.headers);
			final TextView ismf = _view.findViewById(R.id.ismf);
			
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			
			// Ініціалізація Skin
			Skin skin = new Skin();
			
			//Colorify Colorify = new Colorify();
			
			//Colorify.setButtonColor(enable, Color.parseColor("#" + dataHolder.getData("cb")));
			
			url.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			
			method.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			headers.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			ismf.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			
			//skin.setBG(bg, 2, true);
			
			Animator2.anim(getApplicationContext(), bg, 0, 200);
			try{
				url.setText(_data.get((int)_position).get("url").toString());
				method.setText(_data.get((int)_position).get("method").toString());
				headers.setText(_data.get((int)_position).get("headers").toString());
				ismf.setText(_data.get((int)_position).get("isMainFrame").toString());
			}catch(Exception e){
				 
			}
			
			return _view;
		}
	}
}