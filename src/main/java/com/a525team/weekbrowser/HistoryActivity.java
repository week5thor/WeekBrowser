package com.a525team.weekbrowser;

import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class HistoryActivity extends Activity {
	
	private double date = 0;
	private double itemCount = 0;
	private double date1 = 0;
	private double date2 = 0;
	private double size = 0;
	private String sze = "";
	private double historysize = 0;
	private String sizeitem = "";
	private double timeleft = 0;
	Colorify colorify = new Colorify();
	
	private ArrayList<HashMap<String, Object>> history = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> searchedhistory = new ArrayList<>();
	private ArrayList<String> languag = new ArrayList<>();
	
	private LinearLayout linear3;
	private LinearLayout linear1;
	private Button showhide;
	private ListView listview1;
	private ListView listview2;
	private TextView numofelem;
	private TextView hintt;
	private SeekBar seekbar1;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private Button deletee;
	private TextView textview3;
	private AutoCompleteTextView autocomplete1;
	private TextView remaining;
	private AutoCompleteTextView autocomplete2;
	
	private Intent i = new Intent();
	private AlertDialog.Builder dlg;
	private ObjectAnimator show = new ObjectAnimator();
	private SharedPreferences sf;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.history);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		ThemeManager.applyTheme(this); // Встановлення теми
		    super.onCreate(_savedInstanceState);
		         setContentView(R.layout.history);
		linear3 = findViewById(R.id.linear3);
		linear1 = findViewById(R.id.linear1);
		showhide = findViewById(R.id.showhide);
		listview1 = findViewById(R.id.listview1);
		listview2 = findViewById(R.id.listview2);
		numofelem = findViewById(R.id.numofelem);
		hintt = findViewById(R.id.hintt);
		seekbar1 = findViewById(R.id.seekbar1);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		deletee = findViewById(R.id.deletee);
		textview3 = findViewById(R.id.textview3);
		autocomplete1 = findViewById(R.id.autocomplete1);
		remaining = findViewById(R.id.remaining);
		autocomplete2 = findViewById(R.id.autocomplete2);
		dlg = new AlertDialog.Builder(this);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		
		//OnTouch
		showhide.setOnTouchListener(new View.OnTouchListener(){
				@Override
				public boolean onTouch(View v, MotionEvent event){
						int ev = event.getAction();
						switch (ev) {
								case MotionEvent.ACTION_DOWN:
								
								 if (linear1.getVisibility() == View.VISIBLE) {
						linear1.setVisibility(View.GONE);
						showhide.setText("▽▼▼▼▼▼▽");
					}
					else {
						linear1.setVisibility(View.VISIBLE);
						showhide.setText("△▲▲▲▲▲△");
						show.setTarget(linear1);
						show.setPropertyName("scaleY");
						show.setFloatValues((float)(0), (float)(1));
						show.setDuration((int)(500));
						show.start();
					}
								
								break;
								case MotionEvent.ACTION_UP:
								
								 
								
								break;
						} return true;
				}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				i.setClass(getApplicationContext(), IntentActivity.class);
				i.setData(Uri.parse(history.get((int)_position).get("url").toString()));
				startActivity(i);
				finish();
			}
		});
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				history.remove((int)(_position));
				FileUtil.writeFile("/data/data/"+getPackageName()+"/history.json", new Gson().toJson(history));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				return true;
			}
		});
		
		listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				i.setClass(getApplicationContext(), IntentActivity.class);
				i.setData(Uri.parse(searchedhistory.get((int)_position).get("url").toString()));
				startActivity(i);
				finish();
			}
		});
		
		seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				switch((int)_progressValue) {
					case ((int)0): {
						sf.edit().putString("maxhistory", "0").commit();
						break;
					}
					case ((int)1): {
						sf.edit().putString("maxhistory", "3").commit();
						break;
					}
					case ((int)2): {
						sf.edit().putString("maxhistory", "5").commit();
						break;
					}
					case ((int)3): {
						sf.edit().putString("maxhistory", "10").commit();
						break;
					}
					case ((int)4): {
						sf.edit().putString("maxhistory", "20").commit();
						break;
					}
					case ((int)5): {
						sf.edit().putString("maxhistory", "30").commit();
						break;
					}
					case ((int)6): {
						sf.edit().putString("maxhistory", "50").commit();
						break;
					}
					case ((int)7): {
						sf.edit().putString("maxhistory", "75").commit();
						break;
					}
					case ((int)8): {
						sf.edit().putString("maxhistory", "100").commit();
						break;
					}
					case ((int)9): {
						sf.edit().putString("maxhistory", "150").commit();
						break;
					}
					case ((int)10): {
						sf.edit().putString("maxhistory", "200").commit();
						break;
					}
					case ((int)11): {
						sf.edit().putString("maxhistory", "300").commit();
						break;
					}
					case ((int)12): {
						sf.edit().putString("maxhistory", "500").commit();
						break;
					}
					case ((int)13): {
						sf.edit().putString("maxhistory", "750").commit();
						break;
					}
					case ((int)14): {
						sf.edit().putString("maxhistory", "1000").commit();
						break;
					}
					case ((int)15): {
						sf.edit().putString("maxhistory", "1500").commit();
						break;
					}
					case ((int)16): {
						sf.edit().putString("maxhistory", "2000").commit();
						break;
					}
					case ((int)17): {
						sf.edit().putString("maxhistory", "3000").commit();
						break;
					}
					case ((int)18): {
						sf.edit().putString("maxhistory", "5000").commit();
						break;
					}
					case ((int)19): {
						sf.edit().putString("maxhistory", "7500").commit();
						break;
					}
					case ((int)20): {
						sf.edit().putString("maxhistory", "10000").commit();
						break;
					}
					case ((int)21): {
						sf.edit().putString("maxhistory", "20000").commit();
						break;
					}
					case ((int)22): {
						sf.edit().putString("maxhistory", "30000").commit();
						break;
					}
					case ((int)23): {
						sf.edit().putString("maxhistory", "50000").commit();
						break;
					}
					case ((int)24): {
						sf.edit().putString("maxhistory", "75000").commit();
						break;
					}
					case ((int)25): {
						sf.edit().putString("maxhistory", "100000").commit();
						break;
					}
					case ((int)26): {
						sf.edit().putString("maxhistory", "150000").commit();
						break;
					}
				}
				_setText();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		deletee.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dlg.setTitle("!!!");
				dlg.setMessage(getString(R.string.do_you_want_delete_all));
				dlg.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FileUtil.writeFile("/data/data/"+getPackageName()+"/history.json", "[]");
						history = new Gson().fromJson("[]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
				});
				dlg.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				dlg.create().show();
			}
		});
		
		autocomplete1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				try{
					timeleft = Integer.parseInt(sf.getString("maxhistory", "")) / Double.parseDouble(_charSeq);
				}catch(Exception e){
					 
				}
				try{
					//remaining.setText(languag.get((int)(25)) + (long)(timeleft) +  languag.get((int)(26)) + size + sze + languag.get((int)(30)));
					
				}catch(Exception e){
					 
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		autocomplete2.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (!_charSeq.isEmpty()) {
					searchedhistory.clear();
					for (int i = 0; i < (int)(history.size()); i++) {
						if ((history.get((int)i).get("name")!=null && history.get((int)i).get("name").toString().toLowerCase().contains(_charSeq.toLowerCase())) || ((history.get((int)i).get("date")!=null && history.get((int)i).get("date").toString().toLowerCase().contains(_charSeq.toLowerCase())) || (history.get((int)i).get("url")!=null && history.get((int)i).get("url").toString().toLowerCase().contains(_charSeq.toLowerCase())))) {
							searchedhistory.add(history.get((int)(i)));
						}
					}
					((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
					listview2.setVisibility(View.VISIBLE);
					listview1.setVisibility(View.GONE);
					itemCount = listview2.getCount();
					listview2.setSelection((int)itemCount);
				}
				else {
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					listview2.setVisibility(View.GONE);
					listview1.setVisibility(View.VISIBLE);
					itemCount = listview1.getCount();
					listview1.setSelection((int)itemCount);
				}
				/*
if (history.get((int)i).get("name").toString().contains(_charSeq) || (history.get((int)i).get("date").toString().contains(_charSeq) || history.get((int)i).get("url").toString().contains(_charSeq))) {
searchedhistory.add(history.get((int)(i)));
}
*/
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
	}
	
	private void initializeLogic() {
		linear1.setVisibility(View.GONE);
		SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		history = new Gson().fromJson(FileUtil.readFile(getFilesDir().getPath()+"/history.json"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		
		SafeMarginUtils.init(this, findViewById(android.R.id.content));
		
		listview1.setAdapter(new Listview1Adapter(history));
		listview2.setAdapter(new Listview2Adapter(searchedhistory));
		applyColorsToViews(findViewById(android.R.id.content));
		itemCount = listview1.getCount();
		listview1.setSelection((int)itemCount);
		if (sf.getString("monoforta", "").equals("1")) {
			autocomplete1.setTypeface(Typeface.MONOSPACE);
			autocomplete2.setTypeface(Typeface.MONOSPACE);
		}
		else {
			autocomplete1.setTypeface(Typeface.DEFAULT);
			autocomplete2.setTypeface(Typeface.DEFAULT);
		}
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		Skin skin = new Skin();
		
		skin.setBG(linear1, 2, false);
		skin.setBG(getWindow().getDecorView(), 2, false);
		
		deletee.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		showhide.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		autocomplete1.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		autocomplete1.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		autocomplete2.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		autocomplete2.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		hintt.setTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		numofelem.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		remaining.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		
		
		
		skin.setBG(showhide, 0, false);
		skin.setBG(deletee, 1, false);
		/*double savedNum = Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt"));
double historySize = history.size();
double fileLength = FileUtil.getFileLength("/storage/emulated/0/WeekBrowser/history.json");

double result = savedNum * (fileLength / historySize);

String[] suffixes;
try {
    suffixes = new String[]{languag.get((int)(27)), languag.get((int)(28)), languag.get((int)(29))};
} catch (Exception ex) {
    if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
        suffixes = new String[]{" B", " KiB", " MiB"};
    } else {
        suffixes = new String[]{" Б", " КіБ", " МіБ"};
    }
}

int suffixIndex = 0;

while (result >= 1024 && suffixIndex < suffixes.length - 1) {
    result /= 1024;
    suffixIndex++;
}

// Закруглення до двох знаків після коми
size = Math.round(result * 100.0) / 100.0;
sze = suffixes[suffixIndex];
*/
		switch((int)Integer.parseInt(sf.getString("maxhistory", ""))) {
			case ((int)0): {
				seekbar1.setProgress((int)0);
				break;
			}
			case ((int)3): {
				seekbar1.setProgress((int)1);
				break;
			}
			case ((int)5): {
				seekbar1.setProgress((int)2);
				break;
			}
			case ((int)10): {
				seekbar1.setProgress((int)3);
				break;
			}
			case ((int)20): {
				seekbar1.setProgress((int)4);
				break;
			}
			case ((int)30): {
				seekbar1.setProgress((int)5);
				break;
			}
			case ((int)50): {
				seekbar1.setProgress((int)6);
				break;
			}
			case ((int)75): {
				seekbar1.setProgress((int)7);
				break;
			}
			case ((int)100): {
				seekbar1.setProgress((int)8);
				break;
			}
			case ((int)150): {
				seekbar1.setProgress((int)9);
				break;
			}
			case ((int)200): {
				seekbar1.setProgress((int)10);
				break;
			}
			case ((int)300): {
				seekbar1.setProgress((int)11);
				break;
			}
			case ((int)500): {
				seekbar1.setProgress((int)12);
				break;
			}
			case ((int)750): {
				seekbar1.setProgress((int)13);
				break;
			}
			case ((int)1000): {
				seekbar1.setProgress((int)14);
				break;
			}
			case ((int)1500): {
				seekbar1.setProgress((int)15);
				break;
			}
			case ((int)2000): {
				seekbar1.setProgress((int)16);
				break;
			}
			case ((int)3000): {
				seekbar1.setProgress((int)17);
				break;
			}
			case ((int)5000): {
				seekbar1.setProgress((int)18);
				break;
			}
			case ((int)7500): {
				seekbar1.setProgress((int)19);
				break;
			}
			case ((int)10000): {
				seekbar1.setProgress((int)20);
				break;
			}
			case ((int)20000): {
				seekbar1.setProgress((int)21);
				break;
			}
			case ((int)30000): {
				seekbar1.setProgress((int)22);
				break;
			}
			case ((int)50000): {
				seekbar1.setProgress((int)23);
				break;
			}
			case ((int)75000): {
				seekbar1.setProgress((int)24);
				break;
			}
			case ((int)100000): {
				seekbar1.setProgress((int)25);
				break;
			}
			case ((int)150000): {
				seekbar1.setProgress((int)26);
				break;
			}
		}
		_setText();
	}
	
	public void _extra() {
	}
	
	private void applyColorsToViews(View view) {
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		        if (view instanceof ViewGroup) {
			            ViewGroup viewGroup = (ViewGroup) view;
			            for (int i = 0; i < viewGroup.getChildCount(); i++) {
				                View child = viewGroup.getChildAt(i);
				                applyColorsToViews(child); // Рекурсивний виклик для дочірніх елементів
				
				                if (child instanceof CompoundButton) {
					                    CompoundButton button = (CompoundButton) child;
					                    String colorHex = dataHolder.getData("cb"); // Отримання кольору для кнопок
					                    int color = Color.parseColor("#" + (colorHex != null ? colorHex : "000000"));
					                    colorify.setButtonColor(button, color);
					                } else if (child instanceof SeekBar) {
					                    SeekBar seekBar = (SeekBar) child;
					                    String progressColorHex = dataHolder.getData("tpc"); // Отримання кольору для прогресу
					                    String thumbColorHex = dataHolder.getData("tc"); // Отримання кольору для повзунка
					                    int progressColor = Color.parseColor("#" + (progressColorHex != null ? progressColorHex : "000000"));
					                    int thumbColor = Color.parseColor("#" + (thumbColorHex != null ? thumbColorHex : "000000"));
					                    colorify.setSeekBarColors(seekBar, progressColor, thumbColor);
					                }
				            }
			        }
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
	
	
	public void _setText() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		numofelem.setText(getString(R.string.saveh)+" ".concat(sf.getString("maxhistory", "").concat(" "+getString(R.string.elements))));
		if (FileUtil.getFileLength(getFilesDir().getPath().concat("/history.json")) > 1048576) {
			hintt.setText(getString(R.string.cur_saved)+" ".concat(String.valueOf((long)(history.size())).concat(" "+getString(R.string.elements)+getString(R.string.and_size)+" ".concat(String.valueOf(Math.round(FileUtil.getFileLength(getFilesDir().getPath().concat("/history.json"))/10485.76)/100.).concat(" MiB")))));
		}
		else {
			if (FileUtil.getFileLength(getFilesDir().getPath().concat("/history.json")) > 1024) {
				hintt.setText(getString(R.string.cur_saved)+" ".concat(String.valueOf((long)(history.size())).concat(" "+getString(R.string.elements)+getString(R.string.and_size)+" ".concat(String.valueOf(Math.round(FileUtil.getFileLength(getFilesDir().getPath().concat("/history.json"))/10.24)/100.).concat(" KiB")))));
			}
			else {
				hintt.setText(getString(R.string.cur_saved)+" ".concat(String.valueOf((long)(history.size())).concat(" "+getString(R.string.elements)+getString(R.string.and_size)+" ".concat(String.valueOf(FileUtil.getFileLength(getFilesDir().getPath().concat("/history.json"))).concat(" B")))));
			}
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
				_view = _inflater.inflate(R.layout.histori, null);
			}
			
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			
			Animator2.anim(getApplicationContext(), linear2, 0, 200);
			
			
			if (history != null) {
				    textview1.setText(history.get(_position).get("name").toString());
				    textview2.setText(history.get(_position).get("url").toString());
				    try{textview3.setText(history.get(_position).get("time").toString());}catch(Exception e){}
			}
			
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			textview1.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			textview2.setTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
			textview3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			
			return _view;
		}
	}
	
	public class Listview2Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
			
			Animator2.anim(getApplicationContext(), linear2, 0, 200);
			
			
			if (searchedhistory != null) {
				    textview1.setText(searchedhistory.get(_position).get("name").toString());
				    textview2.setText(searchedhistory.get(_position).get("url").toString());
				    try{textview3.setText(history.get(_position).get("time").toString());}catch(Exception e){}
			}
			
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			textview1.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			textview2.setTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
			textview3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			
			return _view;
		}
	}
}