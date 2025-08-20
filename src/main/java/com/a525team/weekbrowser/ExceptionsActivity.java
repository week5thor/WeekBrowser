package com.a525team.weekbrowser;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
	
	private ArrayList<HashMap<String, Object>> except = new ArrayList<>();
	
	private LinearLayout bg;
	private ListView listview1;
	
	private AlertDialog.Builder del;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.exceptions);
		initialize(_savedInstanceState);
		
		if (Build.VERSION.SDK_INT >= 23) {
			if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
			||checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
				requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
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
		int themeValue = Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt"));
		
		        switch (themeValue) {
				            case 0:
				                setTheme(android.R.style.Theme_Material_Light);
				                break;
				            case 1:
				                setTheme(android.R.style.Theme_Material);
				                break;
				            case 2:
				                setTheme(android.R.style.Theme_Light);
				                break;
				            case 3:
				                
				        String styleValue = FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/style.txt");
				
				        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
						            setTheme(android.R.style.Theme_Black);
						        } else {
						            switch (styleValue) {
								                case "1":
								                    setTheme(android.R.style.Theme_Black);
								                    break;
								                case "2":
								                    setTheme(android.R.style.Theme_Light);
								                    break;
								                case "3":
								                    setTheme(android.R.style.Theme_Holo);
								                    break;
								                case "4":
								                    setTheme(android.R.style.Theme_Holo_Light);
								                    break;
								                case "5":
								                    setTheme(android.R.style.Theme_Material);
								                    break;
								                case "6":
								                    setTheme(android.R.style.Theme_Material_Light);
								                    break;
								                default:
								                    setTheme(android.R.style.Theme_Light);
								                    break;
								            }
						        }
				                
				                break;
				            case 4:
				                setTheme(android.R.style.Theme_Material_Light);
				                break;
				            case 5:
				                setTheme(android.R.style.Theme_Material);
				                break;
				            case 6:
				                setTheme(android.R.style.Theme_Holo_Light);
				                break;
				            case 7:
				                setTheme(android.R.style.Theme_Holo);
				                break;
				            case 8:
				                setTheme(android.R.style.Theme_Material_Light);
				                break;
				            case 9:
				                setTheme(android.R.style.Theme_Material);
				                break;
				            case 10:
				                setTheme(android.R.style.Theme_Material);
				                break;
				                case 11:
				                setTheme(android.R.style.Theme_Light);
				                break;
				                case 12:
				                setTheme(android.R.style.Theme_Light);
				                break;
				
				            default:
				                setTheme(android.R.style.Theme_Light);
				                break;
				        }
		
		        super.onCreate(_savedInstanceState);
		        setContentView(R.layout.exceptions);
		bg = findViewById(R.id.bg);
		listview1 = findViewById(R.id.listview1);
		del = new AlertDialog.Builder(this);
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				del.setTitle("ПІДТВЕРДЖЕННЯ");
				del.setMessage("Ви дійсно хочете видалити сайт зі списку винятків?");
				del.setPositiveButton("ТАК", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						if (except.get((int)_position).get("url").toString().equals("file://")) {
							SketchwareUtil.showMessage(getApplicationContext(), "Неможливо видалити");
						}
						else {
							except.remove((int)(_position));
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(except));
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						}
					}
				});
				del.setNegativeButton("НІ", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				del.create().show();
				return true;
			}
		});
	}
	
	private void initializeLogic() {
		except = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SitePermission.json"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		listview1.setAdapter(new Listview1Adapter(except));
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 0) {
			bg.setBackgroundColor(0xFFFFFFFF);
		}
		else {
			if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 1) {
				bg.setBackgroundColor(0xFF111111);
			}
			else {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 2) {
					bg.setBackgroundColor(0xFF000000);
				}
				else {
					ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
					
					skin.setBG(getWindow().getDecorView(), 2, true);
				}
			}
		}
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
					_blockad.setBackgroundColor(Color.TRANSPARENT);
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
			_blockad.setBackgroundColor(Color.TRANSPARENT);
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
					_iframe.setBackgroundColor(Color.TRANSPARENT);
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
			_iframe.setBackgroundColor(Color.TRANSPARENT);
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
					_js.setBackgroundColor(Color.TRANSPARENT);
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
			_js.setBackgroundColor(Color.TRANSPARENT);
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
					_th.setBackgroundColor(Color.TRANSPARENT);
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
			_th.setBackgroundColor(Color.TRANSPARENT);
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
					_sr.setBackgroundColor(Color.TRANSPARENT);
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
			_sr.setBackgroundColor(Color.TRANSPARENT);
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
						}
						else {
							if (except.get((int)_position).get("js").toString().equals("0")) {
								except.get((int)_position).put("js", "1");
							}
							else {
								except.get((int)_position).put("js", "2");
							}
						}
					}catch(Exception e){
						except.get((int)_position).put("js", "0");
					}
					_setCol(blockad, iframe, js, th, sr, _position);
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(except));
				}
			});
			blockad.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					try{
						if (except.get((int)_position).get("ad").toString().equals("2")) {
							except.get((int)_position).put("ad", "0");
						}
						else {
							if (except.get((int)_position).get("ad").toString().equals("0")) {
								except.get((int)_position).put("ad", "1");
							}
							else {
								except.get((int)_position).put("ad", "2");
							}
						}
					}catch(Exception e){
						except.get((int)_position).put("ad", "0");
					}
					_setCol(blockad, iframe, js, th, sr, _position);
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(except));
				}
			});
			iframe.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					try{
						if (except.get((int)_position).get("if").toString().equals("2")) {
							except.get((int)_position).put("if", "0");
						}
						else {
							if (except.get((int)_position).get("if").toString().equals("0")) {
								except.get((int)_position).put("if", "1");
							}
							else {
								except.get((int)_position).put("if", "2");
							}
						}
					}catch(Exception e){
						except.get((int)_position).put("if", "0");
					}
					_setCol(blockad, iframe, js, th, sr, _position);
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(except));
				}
			});
			th.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					try{
						if (except.get((int)_position).get("th").toString().equals("2")) {
							except.get((int)_position).put("th", "0");
						}
						else {
							if (except.get((int)_position).get("th").toString().equals("0")) {
								except.get((int)_position).put("th", "1");
							}
							else {
								except.get((int)_position).put("th", "2");
							}
						}
					}catch(Exception e){
						except.get((int)_position).put("th", "0");
					}
					_setCol(blockad, iframe, js, th, sr, _position);
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(except));
				}
			});
			sr.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					try{
						if (except.get((int)_position).get("sr").toString().equals("2")) {
							except.get((int)_position).put("sr", "0");
						}
						else {
							if (except.get((int)_position).get("sr").toString().equals("0")) {
								except.get((int)_position).put("sr", "1");
							}
							else {
								except.get((int)_position).put("sr", "2");
							}
						}
					}catch(Exception e){
						except.get((int)_position).put("sr", "0");
					}
					_setCol(blockad, iframe, js, th, sr, _position);
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(except));
				}
			});
			
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}