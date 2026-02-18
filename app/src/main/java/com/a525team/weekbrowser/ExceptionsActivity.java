package com.a525team.weekbrowser;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.DialogInterface;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class ExceptionsActivity extends Activity {
	
	ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	Skin skin = new Skin();
	RenderUtils ru;
	
	private ArrayList<HashMap<String, Object>> except = new ArrayList<>();
	
	private LinearLayout bg;
	private ListView listview1;
	
	private AlertDialog.Builder del;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		ThemeManager.applyTheme(this);
		setContentView(R.layout.exceptions);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		bg = findViewById(R.id.bg);
		listview1 = findViewById(R.id.listview1);
		del = new AlertDialog.Builder(this);
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				del.setTitle("?!");
				del.setMessage(getString(R.string.wantdelfromexcept));
				del.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						except.remove((int)(_position));
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", JsonUtils.toJson(except));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
				});
				del.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = del.create();
				dddddd.setOnShowListener(d -> {
					Window window = dddddd.getWindow();
					if (window != null) {
						if(WTF.SDK_INT() > 31 && ru.isOn()){
							ru.on();
							window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
							window.setDimAmount(0f);
						} else {
							ExtendedDataHolder datah = ExtendedDataHolder.getInstance();
							window.setDimAmount(Float.parseFloat(datah.getData("dvalp")));
						}
					}
				});
				dddddd.setOnDismissListener(d -> {
					ru.off();
				});
				dddddd.show();
				
				return true;
			}
		});
	}
	
	private void initializeLogic() {
		try{
			except = JsonUtils.SO(FileUtil.readFile(getFilesDir().getPath()+"/sitepermis.json"));
			listview1.setAdapter(new Listview1Adapter(except));
		}catch(Exception e){
			
		}
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		
		skin.setBG(getWindow().getDecorView(), 2, true);
		
		ru = new RenderUtils(ExceptionsActivity.this);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		SafeMarginUtils.init(this, listview1);
	}
	
	@Override
	public void onPause() {
		super.onPause();
		SafeMarginUtils.cleanup();
	}
	public void _extra() {
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
	
	
	public void _setCol(final TextView _blockad, final TextView _iframe, final TextView _js, final TextView _th, final TextView _sr, final double _position) {
		try{
			switch(except.get((int)_position).get("ad").toString()) {
				case "1": {
								_blockad.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					skin.setBG(_blockad, 0, false);
					break;
				}
				case "2": {
								_blockad.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
					_blockad.setBackground(null);
					break;
				}
				case "0": {
							_blockad.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
					skin.setBG(_blockad, 1, false);
					break;
				}
			}
		}catch(Exception e){
			_blockad.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			_blockad.setBackground(null);
		}
		try{
			switch(except.get((int)_position).get("if").toString()) {
				case "1": {
								_iframe.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					skin.setBG(_iframe, 0, false);
					break;
				}
				case "2": {
								_iframe.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
					_iframe.setBackground(null);
					break;
				}
				case "0": {
								_iframe.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
					skin.setBG(_iframe, 1, false);
					break;
				}
			}
		}catch(Exception e){
			_iframe.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			_iframe.setBackground(null);
		}
		try{
			switch(except.get((int)_position).get("js").toString()) {
				case "1": {
								_js.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					skin.setBG(_js, 0, false);
					break;
				}
				case "2": {
								_js.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
					_js.setBackground(null);
					break;
				}
				case "0": {
								_js.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
					skin.setBG(_js, 1, false);
					break;
				}
			}
		}catch(Exception e){
			_js.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			_js.setBackground(null);
		}
		try{
			switch(except.get((int)_position).get("th").toString()) {
				case "1": {
								_th.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					skin.setBG(_th, 0, false);
					break;
				}
				case "2": {
								_th.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
					_th.setBackground(null);
					break;
				}
				case "0": {
								_th.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
					skin.setBG(_th, 1, false);
					break;
				}
			}
		}catch(Exception e){
			_th.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			_th.setBackground(null);
		}
		try{
			switch(except.get((int)_position).get("sr").toString()) {
				case "1": {
								_sr.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					skin.setBG(_sr, 0, false);
					break;
				}
				case "2": {
								_sr.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
					_sr.setBackground(null);
					break;
				}
				case "0": {
								_sr.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
					skin.setBG(_sr, 1, false);
					break;
				}
			}
		}catch(Exception e){
			_sr.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			_sr.setBackground(null);
		}
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
				_view = _inflater.inflate(R.layout.except, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final TextView url = _view.findViewById(R.id.url);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final TextView js = _view.findViewById(R.id.js);
			final TextView blockad = _view.findViewById(R.id.blockad);
			final TextView sr = _view.findViewById(R.id.sr);
			final TextView th = _view.findViewById(R.id.th);
			final TextView iframe = _view.findViewById(R.id.iframe);
			
			Animator2.anim(getApplicationContext(), linear1, 0, 200);
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			Skin skin = new Skin();
			
			url.setText(except.get((int)_position).get("url").toString());
			url.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			_setCol(blockad, iframe, js, th, sr, _position);
			js.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					try{
						if (except.get((int)_position).get("js").toString().equals("2")) {
							except.get((int)_position).put("js", "0");
						} else {
							if (except.get((int)_position).get("js").toString().equals("0")) {
								except.get((int)_position).put("js", "1");
							} else {
								except.get((int)_position).put("js", "2");
							}
						}
					}catch(Exception e){
						except.get((int)_position).put("js", "0");
					}
					_setCol(blockad, iframe, js, th, sr, _position);
					FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", JsonUtils.toJson(except));
				}
			});
			blockad.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					try{
						if (except.get((int)_position).get("ad").toString().equals("2")) {
							except.get((int)_position).put("ad", "0");
						} else {
							if (except.get((int)_position).get("ad").toString().equals("0")) {
								except.get((int)_position).put("ad", "1");
							} else {
								except.get((int)_position).put("ad", "2");
							}
						}
					}catch(Exception e){
						except.get((int)_position).put("ad", "0");
					}
					_setCol(blockad, iframe, js, th, sr, _position);
					FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", JsonUtils.toJson(except));
				}
			});
			iframe.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					try{
						if (except.get((int)_position).get("if").toString().equals("2")) {
							except.get((int)_position).put("if", "0");
						} else {
							if (except.get((int)_position).get("if").toString().equals("0")) {
								except.get((int)_position).put("if", "1");
							} else {
								except.get((int)_position).put("if", "2");
							}
						}
					}catch(Exception e){
						except.get((int)_position).put("if", "0");
					}
					_setCol(blockad, iframe, js, th, sr, _position);
					FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", JsonUtils.toJson(except));
				}
			});
			th.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					try{
						if (except.get((int)_position).get("th").toString().equals("2")) {
							except.get((int)_position).put("th", "0");
						} else {
							if (except.get((int)_position).get("th").toString().equals("0")) {
								except.get((int)_position).put("th", "1");
							} else {
								except.get((int)_position).put("th", "2");
							}
						}
					}catch(Exception e){
						except.get((int)_position).put("th", "0");
					}
					_setCol(blockad, iframe, js, th, sr, _position);
					FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", JsonUtils.toJson(except));
				}
			});
			sr.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					try{
						if (except.get((int)_position).get("sr").toString().equals("2")) {
							except.get((int)_position).put("sr", "0");
						} else {
							if (except.get((int)_position).get("sr").toString().equals("0")) {
								except.get((int)_position).put("sr", "1");
							} else {
								except.get((int)_position).put("sr", "2");
							}
						}
					}catch(Exception e){
						except.get((int)_position).put("sr", "0");
					}
					_setCol(blockad, iframe, js, th, sr, _position);
					FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", JsonUtils.toJson(except));
				}
			});
			
			return _view;
		}
	}
}