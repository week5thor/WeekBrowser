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
import android.content.ClipData;
import android.content.ClipboardManager;
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
import android.widget.CheckBox;
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
import android.net.Uri;
import java.net.URI;
import java.net.URISyntaxException;

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
	RenderUtils ru;
	
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
	private CheckBox time;
	private LinearLayout linear5;
	private Button deletee;
	private CheckBox regex;
	private AutoCompleteTextView autocomplete2;
	
	private Intent i = new Intent();
	private AlertDialog.Builder dlg;
	private ObjectAnimator show = new ObjectAnimator();
	private SharedPreferences sf;
	private AlertDialog.Builder blockads;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		ThemeManager.applyTheme(this);
		setContentView(R.layout.history);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		ru = new RenderUtils(HistoryActivity.this);
		linear3 = findViewById(R.id.linear3);
		linear1 = findViewById(R.id.linear1);
		showhide = findViewById(R.id.showhide);
		listview1 = findViewById(R.id.listview1);
		listview2 = findViewById(R.id.listview2);
		numofelem = findViewById(R.id.numofelem);
		hintt = findViewById(R.id.hintt);
		seekbar1 = findViewById(R.id.seekbar1);
		time = findViewById(R.id.time);
		linear5 = findViewById(R.id.linear5);
		deletee = findViewById(R.id.deletee);
		regex = findViewById(R.id.regex);
		autocomplete2 = findViewById(R.id.autocomplete2);
		dlg = new AlertDialog.Builder(this);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		blockads = new AlertDialog.Builder(this);
		
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
					} else {
						linear1.setVisibility(View.VISIBLE);
						showhide.setText("△▲▲▲▲▲△");
						Animator2.anim(getApplicationContext(), linear1, 1, 300);
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
				ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				AlertDialog.Builder builder = new AlertDialog.Builder(HistoryActivity.this);
				builder.setTitle(history.get((int)_position).get("name").toString())
				.setItems(new CharSequence[]{
					getString(R.string.add_tab),//0
					getString(R.string.sametab),
					getString(R.string.add_bg_tab),
					getString(R.string.add_tab_incognito),
					getString(R.string.sametab_incognito),//4
					getString(R.string.add_tab_bg_incognito),
					getString(R.string.add_to_bookmark),
					getString(R.string.create_shortcut),
					getString(R.string.delete2),
					getString(R.string.mark_as_ad),//9
					getString(R.string.copy_name),
					getString(R.string.copy_url),
					getString(R.string.copy_nameurl),
					getString(R.string.share_name),
					getString(R.string.share_url),//14
					getString(R.string.share_nameurl)},
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						
						switch((int)which) {
							case ((int)0): {
								i.setClass(getApplicationContext(), IntentActivity.class);
								i.setData(Uri.parse(history.get((int)_position).get("url").toString()));
								startActivity(i);
								finish();
								break;
							}
							case ((int)1): {
								dataHolder.setData("sametab", "");
								i.setClass(getApplicationContext(), IntentActivity.class);
								i.setData(Uri.parse(history.get((int)_position).get("url").toString()));
								startActivity(i);
								finish();
								break;
							}
							case ((int)2): {
								dataHolder.setData("bgtab", "");
								i.setClass(getApplicationContext(), IntentActivity.class);
								i.setData(Uri.parse(history.get((int)_position).get("url").toString()));
								startActivity(i);
								finish();
								break;
							}
							case ((int)3): {
								sf.edit().putString("incognito", "1").commit();
								i.setClass(getApplicationContext(), IntentActivity.class);
								i.setData(Uri.parse(history.get((int)_position).get("url").toString()));
								startActivity(i);
								finish();
								break;
							}
							case ((int)4): {
								sf.edit().putString("incognito", "1").commit();
								dataHolder.setData("sametab", "");
								i.setClass(getApplicationContext(), IntentActivity.class);
								i.setData(Uri.parse(history.get((int)_position).get("url").toString()));
								startActivity(i);
								finish();
								break;
							}
							case ((int)5): {
								sf.edit().putString("incognito", "1").commit();
								dataHolder.setData("bgtab", "");
								i.setClass(getApplicationContext(), IntentActivity.class);
								i.setData(Uri.parse(history.get((int)_position).get("url").toString()));
								startActivity(i);
								finish();
								break;
							}
							case ((int)6): {
								i.setClass(getApplicationContext(), BookmarksActivity.class);
								i.setData(Uri.parse(history.get((int)_position).get("url").toString()));
								i.putExtra("n", history.get((int)_position).get("name").toString());
								i.putExtra("m", dataHolder.getData("ml"));
								startActivity(i);
								break;
							}
							case ((int)7): {
								i.setClass(getApplicationContext(), ShortcutActivity.class);
								i.putExtra("name", history.get((int)_position).get("name").toString());
								i.putExtra("url", history.get((int)_position).get("url").toString());
								startActivity(i);
								break;
							}
							case ((int)8): {
								history.remove((int)(_position));
								FileUtil.writeFile(getFilesDir().getPath()+"/history.json", JsonUtils.toJson(history));
								((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
								_setText();
								break;
							}
							case ((int)9): {
								try{
									blockads.setTitle("?");
									blockads.setMessage(getString(R.string.blocksite1)+"\n".concat(_extractDomain(history.get((int)_position).get("url").toString())).concat(getString(R.string.blocksite2).concat(history.get((int)_position).get("url").toString())));
									blockads.setPositiveButton("[    1    ]", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											sf.edit().putString("adhosts", sf.getString("adhosts", "").concat("\n").concat(_extractDomain(history.get((int)_position).get("url").toString()).replace(".", "\\."))).commit();
										}
									});
									blockads.setNegativeButton("[    2    ]", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											sf.edit().putString("adhosts", sf.getString("adhosts", "").concat("\n%".concat(history.get((int)_position).get("url").toString().replace(".", "\\.")))).commit();
										}
									});
									blockads.setNeutralButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											
										}
									});
									AlertDialog dddddd = blockads.create();
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
									
								}catch(Exception e){
									SketchwareUtil.showMessage(getApplicationContext(), "error");
									((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", e.toString()));
								}
								break;
							}
							case ((int)10): {
								((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", history.get((int)_position).get("name").toString()));
								SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
								break;
							}
							case ((int)11): {
								((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", history.get((int)_position).get("url").toString()));
								SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
								break;
							}
							case ((int)12): {
								((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", history.get((int)_position).get("name").toString().concat("\n────────\n").concat(history.get((int)_position).get("url").toString())));
								SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
								break;
							}
							case ((int)13): {
								i.setAction(Intent.ACTION_SEND);
								i.setType("text/plain");
								i.putExtra(Intent.EXTRA_TEXT, history.get((int)_position).get("name").toString());
								startActivity(Intent.createChooser(i, getString(R.string.sharewith)));
								break;
							}
							case ((int)14): {
								i.setAction(Intent.ACTION_SEND);
								i.setType("text/plain");
								i.putExtra(Intent.EXTRA_TEXT, history.get((int)_position).get("url").toString());
								startActivity(Intent.createChooser(i, getString(R.string.sharewith)));
								break;
							}
							case ((int)15): {
								i.setAction(Intent.ACTION_SEND);
								i.setType("text/plain");
								i.putExtra(Intent.EXTRA_TEXT, history.get((int)_position).get("name").toString().concat("\n────────\n").concat(history.get((int)_position).get("url").toString()));
								startActivity(Intent.createChooser(i, getString(R.string.sharewith)));
								break;
							}
						}
					}
				});
				builder.setCancelable(true);
				
				AlertDialog dddddd = builder.create();
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
		
		listview2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				AlertDialog.Builder builder = new AlertDialog.Builder(HistoryActivity.this);
				builder.setTitle(history.get((int)_position).get("name").toString())
				.setItems(new CharSequence[]{
					getString(R.string.add_tab),//0
					getString(R.string.sametab),
					getString(R.string.add_bg_tab),
					getString(R.string.add_tab_incognito),
					getString(R.string.sametab_incognito),//4
					getString(R.string.add_tab_bg_incognito),
					getString(R.string.add_to_bookmark),
					getString(R.string.create_shortcut),
					getString(R.string.mark_as_ad),//8
					getString(R.string.copy_name),
					getString(R.string.copy_url),
					getString(R.string.copy_nameurl),
					getString(R.string.share_name),
					getString(R.string.share_url),//13
					getString(R.string.share_nameurl)},
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						
						switch((int)which) {
							case ((int)0): {
								i.setClass(getApplicationContext(), IntentActivity.class);
								i.setData(Uri.parse(history.get((int)_position).get("url").toString()));
								startActivity(i);
								finish();
								break;
							}
							case ((int)1): {
								dataHolder.setData("sametab", "");
								i.setClass(getApplicationContext(), IntentActivity.class);
								i.setData(Uri.parse(history.get((int)_position).get("url").toString()));
								startActivity(i);
								finish();
								break;
							}
							case ((int)2): {
								dataHolder.setData("bgtab", "");
								i.setClass(getApplicationContext(), IntentActivity.class);
								i.setData(Uri.parse(history.get((int)_position).get("url").toString()));
								startActivity(i);
								finish();
								break;
							}
							case ((int)3): {
								sf.edit().putString("incognito", "1").commit();
								i.setClass(getApplicationContext(), IntentActivity.class);
								i.setData(Uri.parse(history.get((int)_position).get("url").toString()));
								startActivity(i);
								finish();
								break;
							}
							case ((int)4): {
								sf.edit().putString("incognito", "1").commit();
								dataHolder.setData("sametab", "");
								i.setClass(getApplicationContext(), IntentActivity.class);
								i.setData(Uri.parse(history.get((int)_position).get("url").toString()));
								startActivity(i);
								finish();
								break;
							}
							case ((int)5): {
								sf.edit().putString("incognito", "1").commit();
								dataHolder.setData("bgtab", "");
								i.setClass(getApplicationContext(), IntentActivity.class);
								i.setData(Uri.parse(history.get((int)_position).get("url").toString()));
								startActivity(i);
								finish();
								break;
							}
							case ((int)6): {
								i.setClass(getApplicationContext(), BookmarksActivity.class);
								i.setData(Uri.parse(history.get((int)_position).get("url").toString()));
								i.putExtra("n", history.get((int)_position).get("name").toString());
								i.putExtra("m", dataHolder.getData("ml"));
								startActivity(i);
								break;
							}
							case ((int)7): {
								i.setClass(getApplicationContext(), ShortcutActivity.class);
								i.putExtra("name", history.get((int)_position).get("name").toString());
								i.putExtra("url", history.get((int)_position).get("url").toString());
								startActivity(i);
								break;
							}
							case ((int)8): {
								try{
									blockads.setTitle("?");
									blockads.setMessage(getString(R.string.blocksite1)+"\n".concat(_extractDomain(searchedhistory.get((int)_position).get("url").toString())).concat(getString(R.string.blocksite2).concat(searchedhistory.get((int)_position).get("url").toString())));
									blockads.setPositiveButton("[    1    ]", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											sf.edit().putString("adhosts", sf.getString("adhosts", "").concat("\n").concat(_extractDomain(searchedhistory.get((int)_position).get("url").toString()).replace(".", "\\."))).commit();
										}
									});
									blockads.setNegativeButton("[    2    ]", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											sf.edit().putString("adhosts", sf.getString("adhosts", "").concat("\n%".concat(searchedhistory.get((int)_position).get("url").toString().replace(".", "\\.")))).commit();
										}
									});
									blockads.setNeutralButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											
										}
									});
									AlertDialog dddddd = blockads.create();
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
									
								}catch(Exception e){
									SketchwareUtil.showMessage(getApplicationContext(), "error");
									((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", e.toString()));
								}
								break;
							}
							case ((int)9): {
								((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", history.get((int)_position).get("name").toString()));
								SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
								break;
							}
							case ((int)10): {
								((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", history.get((int)_position).get("url").toString()));
								SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
								break;
							}
							case ((int)11): {
								((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", history.get((int)_position).get("name").toString().concat("\n────────\n").concat(history.get((int)_position).get("url").toString())));
								SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
								break;
							}
							case ((int)12): {
								i.setAction(Intent.ACTION_SEND);
								i.setType("text/plain");
								i.putExtra(Intent.EXTRA_TEXT, history.get((int)_position).get("name").toString());
								startActivity(Intent.createChooser(i, getString(R.string.sharewith)));
								break;
							}
							case ((int)13): {
								i.setAction(Intent.ACTION_SEND);
								i.setType("text/plain");
								i.putExtra(Intent.EXTRA_TEXT, history.get((int)_position).get("url").toString());
								startActivity(Intent.createChooser(i, getString(R.string.sharewith)));
								break;
							}
							case ((int)14): {
								i.setAction(Intent.ACTION_SEND);
								i.setType("text/plain");
								i.putExtra(Intent.EXTRA_TEXT, history.get((int)_position).get("name").toString().concat("\n────────\n").concat(history.get((int)_position).get("url").toString()));
								startActivity(Intent.createChooser(i, getString(R.string.sharewith)));
								break;
							}
						}
					}
				});
				builder.setCancelable(true);
				
				AlertDialog dddddd = builder.create();
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
		
		seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_updseek(false);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		time.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("maxhistoryt", "").equals("0")) {
					sf.edit().putString("maxhistoryt", "1").commit();
					time.setChecked(true);
				} else {
					sf.edit().putString("maxhistoryt", "0").commit();
					time.setChecked(false);
				}
				_updseek(false);
			}
		});
		
		autocomplete2.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (!_charSeq.isEmpty()) {
					searchedhistory.clear();
					String searchQuery = _charSeq.toString();
					String searchQueryLower = searchQuery.toLowerCase();
					
					for (int i = 0; i < history.size(); i++) {
						HashMap<String, Object> historyItem = history.get(i); // Змінили на HashMap
						
						// Форматуємо дату один раз
						String date = "";
						if (historyItem.get("date") != null) {
							try {
								date = new SimpleDateFormat("yyyy/MM/dd\nEE HH:mm:ss")
								.format(new Date(Long.parseLong(historyItem.get("date").toString())));
							} catch (Exception e) {
								// Ігноруємо помилки форматування дати
							}
						}
						
						boolean matches = false;
						
						if (regex.isChecked()) {
							try {
								// Перевіряємо назву
								if (historyItem.get("name") != null && 
								historyItem.get("name").toString().matches(".*" + searchQuery + ".*")) {
									matches = true;
								}
								// Перевіряємо URL
								else if (historyItem.get("url") != null && 
								historyItem.get("url").toString().matches(".*" + searchQuery + ".*")) {
									matches = true;
								}
								// Перевіряємо відформатовану дату
								else if (!date.isEmpty() && date.matches(".*" + searchQuery + ".*")) {
									matches = true;
								}
								
								regex.setBackground(null);
							} catch(Exception e) {
								regex.setBackgroundColor(0xFFFF0000);
								break;
							}
						} else {
							// Звичайний пошук (без regex)
							if (historyItem.get("name") != null && 
							historyItem.get("name").toString().toLowerCase().contains(searchQueryLower)) {
								matches = true;
							}
							else if (historyItem.get("url") != null && 
							historyItem.get("url").toString().toLowerCase().contains(searchQueryLower)) {
								matches = true;
							}
							else if (!date.isEmpty() && date.toLowerCase().contains(searchQueryLower)) {
								matches = true;
							}
						}
						
						if (matches) {
							searchedhistory.add(historyItem);
						}
					}
					
					((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
					listview2.setVisibility(View.VISIBLE);
					listview1.setVisibility(View.GONE);
					itemCount = listview2.getCount();
					listview2.setSelection((int) itemCount); // Додано приведення типів
				} else {
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					listview2.setVisibility(View.GONE);
					listview1.setVisibility(View.VISIBLE);
					regex.setBackground(null);
				}
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
		
		try{
			history = JsonUtils.SO(FileUtil.readFile(getFilesDir().getPath()+"/history.json"));
		}catch(Exception e){}
		listview1.setAdapter(new Listview1Adapter(history));
		listview2.setAdapter(new Listview2Adapter(searchedhistory));
		colorify.applyColorifyToAll(getWindow().getDecorView().getRootView());
		itemCount = listview1.getCount();
		listview1.setSelection((int)itemCount);
		if (sf.getString("monoforta", "").equals("1")) {
			autocomplete2.setTypeface(Typeface.MONOSPACE);
		} else {
			autocomplete2.setTypeface(Typeface.DEFAULT);
		}
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		Skin skin = new Skin();
		
		skin.setBG(linear1, 2, false);
		skin.setBG(getWindow().getDecorView(), 2, false);
		
		deletee.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		showhide.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		autocomplete2.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		autocomplete2.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		hintt.setTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		numofelem.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		time.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		regex.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		
		
		
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
		_updseek(true);
		_onscroll(deletee);
	}
	
	@Override
	public void onPause() {
		super.onPause();
		SafeMarginUtils.cleanup();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		SafeMarginUtils.init(this, linear3);
		
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
	
	
	public void _setText() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		if (FileUtil.getFileLength(getFilesDir().getPath().concat("/history.json")) > 1048576) {
			hintt.setText(getString(R.string.cur_saved)+" ".concat(String.valueOf((long)(history.size())).concat(" "+getString(R.string.elements)+getString(R.string.and_size)+" ".concat(String.valueOf(Math.round(FileUtil.getFileLength(getFilesDir().getPath().concat("/history.json"))/10485.76)/100.).concat(" MiB")))));
		} else {
			if (FileUtil.getFileLength(getFilesDir().getPath().concat("/history.json")) > 1024) {
				hintt.setText(getString(R.string.cur_saved)+" ".concat(String.valueOf((long)(history.size())).concat(" "+getString(R.string.elements)+getString(R.string.and_size)+" ".concat(String.valueOf(Math.round(FileUtil.getFileLength(getFilesDir().getPath().concat("/history.json"))/10.24)/100.).concat(" KiB")))));
			} else {
				hintt.setText(getString(R.string.cur_saved)+" ".concat(String.valueOf((long)(history.size())).concat(" "+getString(R.string.elements)+getString(R.string.and_size)+" ".concat(String.valueOf(FileUtil.getFileLength(getFilesDir().getPath().concat("/history.json"))).concat(" B")))));
			}
		}
		if (time.isChecked()) {
			switch((int)seekbar1.getProgress()) {
				case ((int)0): {
					sf.edit().putString("maxhistory", "0").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 0 "+getString(R.string.seconds)));
					break;
				}
				case ((int)1): {
					sf.edit().putString("maxhistory", "30").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 30 "+getString(R.string.seconds)));
					break;
				}
				case ((int)2): {
					sf.edit().putString("maxhistory", "60").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 1 "+getString(R.string.minute)));
					break;
				}
				case ((int)3): {
					sf.edit().putString("maxhistory", "120").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 2 "+getString(R.string.minutes2)));
					break;
				}
				case ((int)4): {
					sf.edit().putString("maxhistory", "180").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 3 "+getString(R.string.minutes)));
					break;
				}
				case ((int)5): {
					sf.edit().putString("maxhistory", "300").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 5 "+getString(R.string.minutes)));
					break;
				}
				case ((int)6): {
					sf.edit().putString("maxhistory", "600").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 10 "+getString(R.string.minutes)));
					break;
				}
				case ((int)7): {
					sf.edit().putString("maxhistory", "1800").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 30 "+getString(R.string.minutes)));
					break;
				}
				case ((int)8): {
					sf.edit().putString("maxhistory", "3600").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 1 "+getString(R.string.hour)));
					break;
				}
				case ((int)9): {
					sf.edit().putString("maxhistory", "7200").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 2 "+getString(R.string.hours2)));
					break;
				}
				case ((int)10): {
					sf.edit().putString("maxhistory", "14400").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 4 "+getString(R.string.hours2)));
					break;
				}
				case ((int)11): {
					sf.edit().putString("maxhistory", "28800").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 8 "+getString(R.string.hours)));
					break;
				}
				case ((int)12): {
					sf.edit().putString("maxhistory", "86400").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 1 "+getString(R.string.day)));
					break;
				}
				case ((int)13): {
					sf.edit().putString("maxhistory", "172800").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 2 "+getString(R.string.days2)));
					break;
				}
				case ((int)14): {
					sf.edit().putString("maxhistory", "259200").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 3 "+getString(R.string.days2)));
					break;
				}
				case ((int)15): {
					sf.edit().putString("maxhistory", "604800").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 1 "+getString(R.string.week)));
					break;
				}
				case ((int)16): {
					sf.edit().putString("maxhistory", "1209600").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 2 "+getString(R.string.weeks2)));
					break;
				}
				case ((int)17): {
					sf.edit().putString("maxhistory", "2592000").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 1 "+getString(R.string.month)));
					break;
				}
				case ((int)18): {
					sf.edit().putString("maxhistory", "5184000").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 2 "+getString(R.string.months2)));
					break;
				}
				case ((int)19): {
					sf.edit().putString("maxhistory", "7776000").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 3 "+getString(R.string.months2)));
					break;
				}
				case ((int)20): {
					sf.edit().putString("maxhistory", "10368000").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 4 "+getString(R.string.months2)));
					break;
				}
				case ((int)21): {
					sf.edit().putString("maxhistory", "15552000").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 6 "+getString(R.string.months)));
					break;
				}
				case ((int)22): {
					sf.edit().putString("maxhistory", "31104000").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 1 "+getString(R.string.year)));
					break;
				}
				case ((int)23): {
					sf.edit().putString("maxhistory", "62208000").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 2 "+getString(R.string.years2)));
					break;
				}
				case ((int)24): {
					sf.edit().putString("maxhistory", "93312000").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 3 "+getString(R.string.years2)));
					break;
				}
				case ((int)25): {
					sf.edit().putString("maxhistory", "155520000").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 5 "+getString(R.string.years)));
					break;
				}
				case ((int)26): {
					sf.edit().putString("maxhistory", "311040000").commit();
					numofelem.setText(getString(R.string.saveh).concat(" 10 "+getString(R.string.years)));
					break;
				}
			}
		} else {
			numofelem.setText(getString(R.string.saveh)+" ".concat(sf.getString("maxhistory", "").concat(" "+getString(R.string.elements))));
		}
	}
	
	
	public void _updseek(final boolean _r) {
		SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		if (_r) {
			time.setChecked(sf.getString("maxhistoryt", "").equals("1"));
			if (time.isChecked()) {
				switch((int)Integer.parseInt(sf.getString("maxhistory", ""))) {
					case ((int)0): {
						seekbar1.setProgress((int)0);
						break;
					}
					case ((int)30): {
						seekbar1.setProgress((int)1);
						break;
					}
					case ((int)60): {
						seekbar1.setProgress((int)2);
						break;
					}
					case ((int)120): {
						seekbar1.setProgress((int)3);
						break;
					}
					case ((int)180): {
						seekbar1.setProgress((int)4);
						break;
					}
					case ((int)300): {
						seekbar1.setProgress((int)5);
						break;
					}
					case ((int)600): {
						seekbar1.setProgress((int)6);
						break;
					}
					case ((int)1800): {
						seekbar1.setProgress((int)7);
						break;
					}
					case ((int)3600): {
						seekbar1.setProgress((int)8);
						break;
					}
					case ((int)7200): {
						seekbar1.setProgress((int)9);
						break;
					}
					case ((int)14400): {
						seekbar1.setProgress((int)10);
						break;
					}
					case ((int)28800): {
						seekbar1.setProgress((int)11);
						break;
					}
					case ((int)86400): {
						seekbar1.setProgress((int)12);
						break;
					}
					case ((int)172800): {
						seekbar1.setProgress((int)13);
						break;
					}
					case ((int)259200): {
						seekbar1.setProgress((int)14);
						break;
					}
					case ((int)604800): {
						seekbar1.setProgress((int)15);
						break;
					}
					case ((int)1209600): {
						seekbar1.setProgress((int)16);
						break;
					}
					case ((int)2592000): {
						seekbar1.setProgress((int)17);
						break;
					}
					case ((int)5184000): {
						seekbar1.setProgress((int)18);
						break;
					}
					case ((int)7776000): {
						seekbar1.setProgress((int)19);
						break;
					}
					case ((int)10368000): {
						seekbar1.setProgress((int)20);
						break;
					}
					case ((int)15552000): {
						seekbar1.setProgress((int)21);
						break;
					}
					case ((int)31104000): {
						seekbar1.setProgress((int)22);
						break;
					}
					case ((int)62208000): {
						seekbar1.setProgress((int)23);
						break;
					}
					case ((int)93312000): {
						seekbar1.setProgress((int)24);
						break;
					}
					case ((int)155520000): {
						seekbar1.setProgress((int)25);
						break;
					}
					case ((int)311040000): {
						seekbar1.setProgress((int)26);
						break;
					}
				}
			} else {
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
			}
		} else {
			if (time.isChecked()) {
				switch((int)seekbar1.getProgress()) {
					case ((int)0): {
						sf.edit().putString("maxhistory", "0").commit();
						break;
					}
					case ((int)1): {
						sf.edit().putString("maxhistory", "30").commit();
						break;
					}
					case ((int)2): {
						sf.edit().putString("maxhistory", "60").commit();
						break;
					}
					case ((int)3): {
						sf.edit().putString("maxhistory", "120").commit();
						break;
					}
					case ((int)4): {
						sf.edit().putString("maxhistory", "180").commit();
						break;
					}
					case ((int)5): {
						sf.edit().putString("maxhistory", "300").commit();
						break;
					}
					case ((int)6): {
						sf.edit().putString("maxhistory", "600").commit();
						break;
					}
					case ((int)7): {
						sf.edit().putString("maxhistory", "1800").commit();
						break;
					}
					case ((int)8): {
						sf.edit().putString("maxhistory", "3600").commit();
						break;
					}
					case ((int)9): {
						sf.edit().putString("maxhistory", "7200").commit();
						break;
					}
					case ((int)10): {
						sf.edit().putString("maxhistory", "14400").commit();
						break;
					}
					case ((int)11): {
						sf.edit().putString("maxhistory", "28800").commit();
						break;
					}
					case ((int)12): {
						sf.edit().putString("maxhistory", "86400").commit();
						break;
					}
					case ((int)13): {
						sf.edit().putString("maxhistory", "172800").commit();
						break;
					}
					case ((int)14): {
						sf.edit().putString("maxhistory", "259200").commit();
						break;
					}
					case ((int)15): {
						sf.edit().putString("maxhistory", "604800").commit();
						break;
					}
					case ((int)16): {
						sf.edit().putString("maxhistory", "1209600").commit();
						break;
					}
					case ((int)17): {
						sf.edit().putString("maxhistory", "2592000").commit();
						break;
					}
					case ((int)18): {
						sf.edit().putString("maxhistory", "5184000").commit();
						break;
					}
					case ((int)19): {
						sf.edit().putString("maxhistory", "7776000").commit();
						break;
					}
					case ((int)20): {
						sf.edit().putString("maxhistory", "10368000").commit();
						break;
					}
					case ((int)21): {
						sf.edit().putString("maxhistory", "15552000").commit();
						break;
					}
					case ((int)22): {
						sf.edit().putString("maxhistory", "31104000").commit();
						break;
					}
					case ((int)23): {
						sf.edit().putString("maxhistory", "62208000").commit();
						break;
					}
					case ((int)24): {
						sf.edit().putString("maxhistory", "93312000").commit();
						break;
					}
					case ((int)25): {
						sf.edit().putString("maxhistory", "155520000").commit();
						break;
					}
					case ((int)26): {
						sf.edit().putString("maxhistory", "311040000").commit();
						break;
					}
				}
			} else {
				switch((int)seekbar1.getProgress()) {
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
			}
		}
		_setText();
	}
	
	
	public void _onscroll(final View _w) {
		Button w = (Button) _w;
		
		w.setText("▶▷" + getString(R.string.clear_all) + "▶▷");
		w.setOnTouchListener(new View.OnTouchListener() {
			private float startX;
			private float startY;
			boolean scroll=false;
			private float l;
			private final int width = (int)SketchwareUtil.getDisplayWidthPixels(getApplicationContext());
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN:
					startX = event.getRawX();
					startY = event.getRawY();
					break;
					case MotionEvent.ACTION_UP:
					float endX = event.getRawX();
					float endY = event.getRawY();
					float touchSlop = ViewConfiguration.get(_w.getContext()).getScaledTouchSlop();
					if(scroll)delhis((int)l, true, w);
					scroll=false;
					if (Math.abs(startX - endX) < touchSlop) {
						// Ваша логіка для натискання
						
						dlg.setTitle("!!!");
						dlg.setMessage(getString(R.string.do_you_want_delete_all));
						dlg.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								FileUtil.writeFile(getFilesDir().getPath()+"/history.json", "[]");
								history.clear(); // краще використовувати clear() — не створюється новий об'єкт
								((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
								_setText();
							}
						});
						dlg.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						AlertDialog dddddd = dlg.create();
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
						
					}
					break;
					case MotionEvent.ACTION_MOVE:
					float currentX = event.getRawX();
					float currentY = event.getRawY();
					if (startX + SketchwareUtil.getDip(getApplicationContext(), (int) (50)) < currentX) {
						scroll=true;
					}
					if (scroll) {
						l = currentX/(float)(width*0.15);
						delhis((int)l, false, w);
					}
					break;
				}
				return false; // Повертаємо false, щоб інші обробники подій дотику також були викликані, якщо вони є
			}
		});
		
		
	}
	
	private void delhis(int l, boolean t, Button _w) {
		try{
			if (l < 0) return;
			
			if (t) {
				_w.setText("▶▷" + getString(R.string.clear_all) + "▶▷");
				
				long now = Long.parseLong(history.get(history.size()-1).get("date").toString());
				long thresholdMillis;
				
				switch (l) {
					case 0:
					break;
					
					case 1:
					thresholdMillis = now - (5 * 60 * 1000L);
					removeNewerThan(thresholdMillis);
					break;
					
					case 2:
					thresholdMillis = now - (15 * 60 * 1000L);
					removeNewerThan(thresholdMillis);
					break;
					
					case 3:
					thresholdMillis = now - (30 * 60 * 1000L);
					removeNewerThan(thresholdMillis);
					break;
					
					case 4:
					thresholdMillis = now - (60 * 60 * 1000L);
					removeNewerThan(thresholdMillis);
					break;
					
					case 5:
					thresholdMillis = now - (2 * 60 * 60 * 1000L);
					removeNewerThan(thresholdMillis);
					break;
					
					default:
					thresholdMillis = now - (3 * 60 * 60 * 1000L);
					removeNewerThan(thresholdMillis);
					break;
				}
				
				// Зберегти історію
				String path = getFilesDir().getPath() + "/history.json";
				FileUtil.writeFile(path, JsonUtils.toJson(history));
				
				// Оновити список
				runOnUiThread(() -> {
					((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();
				});
				
			} else {
				switch (l) {
					case 0:
					_w.setText("▶▷" + getString(R.string.clear_all) + "▶▷");
					break;
					case 1:
					_w.setText("5 " + getString(R.string.minutes));
					break;
					case 2:
					_w.setText("15 " + getString(R.string.minutes));
					break;
					case 3:
					_w.setText("30 " + getString(R.string.minutes));
					break;
					case 4:
					_w.setText("1 " + getString(R.string.hour));
					break;
					case 5:
					_w.setText("2 " + getString(R.string.hours2));
					break;
					default:
					_w.setText("3 " + getString(R.string.hours2));
					break;
				}
			}
		}catch(Exception ignored){
			//Якщо фляга свисне (таке може бути, коли історія пуста)
		}
	}
	
	private void removeNewerThan(long thresholdMillis) {
		Iterator<HashMap<String, Object>> iterator = history.iterator();
		int removed = 0;
		
		while (iterator.hasNext()) {
			HashMap<String, Object> item = iterator.next();
			Object dateObj = item.get("date");
			
			long itemMillis = -1;
			try {
				if (dateObj instanceof Number) {
					itemMillis = ((Number) dateObj).longValue();
				} else if (dateObj instanceof String) {
					String s = (String) dateObj;
					if (s.contains(".")) s = s.substring(0, s.indexOf('.'));
					itemMillis = Long.parseLong(s);
				}
			} catch (Exception ignored) {
				continue;
			}
			
			try{
				if (itemMillis >= thresholdMillis) {
					iterator.remove();
					removed++;
				}
			}catch(Exception ignored){
				//Якщо вже нічого не залишиться в історії
			}
		}
		_setText();
		//Log.i("HISTORY", "Видалено нових записів: " + removed);
	}
	
	
	
	{
		
		
	}
	
	
	public String _extractDomain(final String _url) {
		try {
			URI uri = new URI(_url);
			final Set<String> COMMON_PREFIXES = new HashSet<>(Arrays.asList("www", "m", "mobile"));
			String domain = uri.getHost();
			if (domain != null) {
				String[] parts = domain.split("\\.");
				if (parts.length > 2 && COMMON_PREFIXES.contains(parts[0])) {
					// Видаляє префікс, якщо він присутній у списку
					domain = String.join(".", Arrays.copyOfRange(parts, 1, parts.length));
				}
				return domain;
			}
		} catch (URISyntaxException e) {
			e.printStackTrace(); // Додайте ваше логування тут
		}
		return null;
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
			final LinearLayout cusdiv = _view.findViewById(R.id.cusdiv);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final ImageView fav = _view.findViewById(R.id.fav);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			
			Animator2.anim(getApplicationContext(), linear2, 0, 200);
			String url = null;
			
			
			if (history != null) {
				textview1.setText(Formater.shrink(history.get(_position).get("name").toString(), 100));
				url = Formater.shrink(history.get(_position).get("url").toString(), 100);
				textview2.setText(url);
				try{
					textview3.setText(
					new SimpleDateFormat("yyyy/MM/dd\nEE HH:mm:ss")
					.format(new Date(Long.parseLong(history.get(_position).get("date").toString())))
					);
					
				}catch(Exception d){
					try{textview3.setText("¶"+history.get(_position).get("date").toString());}catch(Exception e){}
				}
			}
			
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			textview1.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			textview2.setTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
			textview3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			cusdiv.setBackgroundColor((int)Long.parseLong(dataHolder.getData("h"),16));
			
			try{
				fav.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(getFilesDir().getPath()+"/favicons/"+Uri.parse(url).getHost()+".webp", 32, 32));
			}catch(Exception e){
				textview2.setText(e.toString());
			}
			
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
			final LinearLayout cusdiv = _view.findViewById(R.id.cusdiv);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final ImageView fav = _view.findViewById(R.id.fav);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			
			Animator2.anim(getApplicationContext(), linear2, 0, 200);
			String url = null;
			
			
			if (searchedhistory != null) {
				textview1.setText(Formater.shrink(searchedhistory.get(_position).get("name").toString(), 100));
				url = Formater.shrink(searchedhistory.get(_position).get("url").toString(), 100);
				textview2.setText(url);
				try{
					textview3.setText(
					new SimpleDateFormat("yyyy/MM/dd\nEE HH:mm:ss")
					.format(new Date(Long.parseLong(searchedhistory.get(_position).get("date").toString())))
					);
					
				}catch(Exception d){
					try{textview3.setText("¶"+searchedhistory.get(_position).get("date").toString());}catch(Exception e){}
				}
			}
			
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			textview1.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			textview2.setTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
			textview3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			cusdiv.setBackgroundColor((int)Long.parseLong(dataHolder.getData("h"),16));
			
			try{
				fav.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(getFilesDir().getPath()+"/favicons/"+Uri.parse(url).getHost()+".webp", 128, 128));
			}catch(Exception e){
				
			}
			
			return _view;
		}
	}
}