package com.a525team.weekbrowser;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import com.google.gson.Gson;
import android.provider.Settings;

public class AnimActivity extends Activity {
	
	private ArrayList<HashMap<String, Object>> example = new ArrayList<>();
	private ArrayList<String> properties = new ArrayList<>();
	private ArrayList<String> interpolat = new ArrayList<>();
	
	private ListView listview1;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private TextView title;
	private TextView listanimt;
	private Spinner lap;
	private Spinner lai;
	private TextView bpanimt;
	private Spinner bap;
	private Spinner bai;
	private TextView spanimt;
	private Spinner sap;
	private Spinner sai;
	private Button ssh;
	private TextView textview1;
	private Button bsh;
	private TextView textview2;
	
	private SharedPreferences sf;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		ThemeManager.applyTheme(this);
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.anim);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		listview1 = findViewById(R.id.listview1);
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		title = findViewById(R.id.title);
		listanimt = findViewById(R.id.listanimt);
		lap = findViewById(R.id.lap);
		lai = findViewById(R.id.lai);
		bpanimt = findViewById(R.id.bpanimt);
		bap = findViewById(R.id.bap);
		bai = findViewById(R.id.bai);
		spanimt = findViewById(R.id.spanimt);
		sap = findViewById(R.id.sap);
		sai = findViewById(R.id.sai);
		ssh = findViewById(R.id.ssh);
		textview1 = findViewById(R.id.textview1);
		bsh = findViewById(R.id.bsh);
		textview2 = findViewById(R.id.textview2);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		
		lap.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("listanimp", String.valueOf((long)(_position))).commit();
				Skin skin = new Skin();
				skin.colorToRam(AnimActivity.this);
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		lai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("listanimi", String.valueOf((long)(_position))).commit();
				Skin skin = new Skin();
				skin.colorToRam(AnimActivity.this);
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		bap.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("bpanimp", String.valueOf((long)(_position))).commit();
				Skin skin = new Skin();
				skin.colorToRam(AnimActivity.this);
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		bai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("bpanimi", String.valueOf((long)(_position))).commit();
				Skin skin = new Skin();
				skin.colorToRam(AnimActivity.this);
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		sap.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("spanimp", String.valueOf((long)(_position))).commit();
				Skin skin = new Skin();
				skin.colorToRam(AnimActivity.this);
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		sai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("spanimi", String.valueOf((long)(_position))).commit();
				Skin skin = new Skin();
				skin.colorToRam(AnimActivity.this);
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		ssh.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (textview1.getVisibility() == View.VISIBLE) {
					textview1.setVisibility(View.INVISIBLE);
				} else {
					textview1.setVisibility(View.VISIBLE);
					Animator2.anim(getApplicationContext(), textview1, 2, 300);
				}
			}
		});
		
		bsh.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (textview2.getVisibility() == View.VISIBLE) {
					textview2.setVisibility(View.INVISIBLE);
				} else {
					textview2.setVisibility(View.VISIBLE);
					Animator2.anim(getApplicationContext(), textview2, 1, 300);
				}
			}
		});
	}
	
	private void initializeLogic() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		
		// Перевірка масштабу анімації
		if (Settings.Global.getFloat(
		        getContentResolver(), 
		        Settings.Global.ANIMATOR_DURATION_SCALE, 
		        1.0f) == 0.0f) {
			    // Умова виконується, якщо масштаб анімації == 0
			title.setText(getString(R.string.animerror));
		} else {
			
		}
		for (int i = 0; i < (int)(1000); i++) {
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("name", "Example №".concat(String.valueOf((long)(i))));
				example.add(_item);
			}
		}
		listview1.setAdapter(new Listview1Adapter(example));
		properties.add(getString(R.string.alpha));
		properties.add(getString(R.string.ho));
		properties.add(getString(R.string.vo));
		properties.add(getString(R.string.al));
		properties.add(getString(R.string.ar));
		properties.add(getString(R.string.rot));
		properties.add(getString(R.string.rot180));
		properties.add(getString(R.string.rot90));
		properties.add(getString(R.string.rot_90));
		properties.add(getString(R.string.rot_180));
		properties.add(getString(R.string.rot_360));
		properties.add(getString(R.string.zoomin));
		properties.add(getString(R.string.turnoff));
		interpolat.add(getString(R.string.lin));
		interpolat.add(getString(R.string.accel));
		interpolat.add(getString(R.string.decel));
		interpolat.add(getString(R.string.both));
		interpolat.add(getString(R.string.bounce));
		ThemeManager.setSpinner(AnimActivity.this, properties, lap);
		ThemeManager.setSpinner(AnimActivity.this, properties, bap);
		ThemeManager.setSpinner(AnimActivity.this, properties, sap);
		
		ThemeManager.setSpinner(AnimActivity.this, interpolat, lai);
		ThemeManager.setSpinner(AnimActivity.this, interpolat, bai);
		ThemeManager.setSpinner(AnimActivity.this, interpolat, sai);
		lap.setSelection((int)(Integer.parseInt(sf.getString("listanimp", ""))));
		lai.setSelection((int)(Integer.parseInt(sf.getString("listanimi", ""))));
		bap.setSelection((int)(Integer.parseInt(sf.getString("bpanimp", ""))));
		bai.setSelection((int)(Integer.parseInt(sf.getString("bpanimi", ""))));
		sap.setSelection((int)(Integer.parseInt(sf.getString("spanimp", ""))));
		sai.setSelection((int)(Integer.parseInt(sf.getString("spanimi", ""))));
	}
	
	@Override
	public void onResume() {
		super.onResume();
		SafeMarginUtils.init(this, findViewById(android.R.id.content));
		_skin();
	}
	
	
	@Override
	public void onPause() {
		super.onPause();
		SafeMarginUtils.cleanup();
	}
	public void _skin() {
		colorify.applyColorifyToAll(getWindow().getDecorView().getRootView());
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		Skin skin = new Skin();
		skin.setBG(findViewById(android.R.id.content), 2, false);
		skin.setBG(ssh, 0, false);
		skin.setBG(bsh, 0, false);
		title.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		listanimt.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		bpanimt.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		spanimt.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		ssh.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		bsh.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
	}
	
	
	public void _lang() {
	}
	
	@Override
	protected void attachBaseContext(Context newBase) {
		    if (newBase != null) {
			        SharedPreferences sf = newBase.getSharedPreferences("sf", Context.MODE_PRIVATE);
			        String languageCode = sf.getString("lang", "en");
			        Context context = LocaleHelper.setLocale(newBase, languageCode);
			        super.attachBaseContext(context);
			    } else {
			        super.attachBaseContext(newBase);
			    }
	}
	
	{
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
				_view = _inflater.inflate(R.layout.extension, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final TextView name = _view.findViewById(R.id.name);
			final CheckBox enable = _view.findViewById(R.id.enable);
			final Button share = _view.findViewById(R.id.share);
			final Button editname = _view.findViewById(R.id.editname);
			final Button delete = _view.findViewById(R.id.delete);
			
			Animator2.anim(getApplicationContext(), linear1, 0, 200);
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			
			// Ініціалізація Skin
			Skin skin = new Skin();
			
			colorify.setButtonColor(enable, Color.parseColor("#" + dataHolder.getData("cb")));
			
			name.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			
			share.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			editname.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			delete.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			
			skin.setBG(share, 0, true);
			skin.setBG(editname, 0, true);
			skin.setBG(delete, 1, true);
			try{
				share.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
				editname.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
				delete.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
				name.setText(example.get((int)_position).get("name").toString());
			}catch(Exception e){
				name.setText("[ERROR]");
			}
			
			return _view;
		}
	}
}