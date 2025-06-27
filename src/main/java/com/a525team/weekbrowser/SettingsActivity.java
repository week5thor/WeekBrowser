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
import android.graphics.Typeface;
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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import android.app.ActivityManager.MemoryInfo;
import java.io.*;
import java.util.zip.*;
import android.os.Build;

public class SettingsActivity extends Activity {
	
	private String alarm = "";
	private String douwant = "";
	private String yes = "";
	private String no = "";
	private String cacheisclear = "";
	ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	private String fffff = "";
	RenderUtils ru;
	
	private ArrayList<HashMap<String, Object>> skins = new ArrayList<>();
	private  List<Bitmap> icons = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> icons2 = new ArrayList<>();
	private ArrayList<String> blred = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private TextView name;
	private Button first;
	private LinearLayout linear7;
	private HorizontalScrollView hscroll1;
	private TextView textview3;
	private CheckBox srhhis;
	private CheckBox navpan;
	private CheckBox pnup;
	private CheckBox srup;
	private LinearLayout linear5;
	private CheckBox zoombtns;
	private CheckBox screen;
	private LinearLayout linear21;
	private CheckBox mono;
	private Button button4;
	private Button useragent;
	private Button replacer;
	private Button except;
	private LinearLayout linear9;
	private SeekBar seekbar1;
	private TextView navset;
	private CheckBox prevexit;
	private LinearLayout linear6;
	private RadioGroup radiogroup2;
	private CheckBox onnointernet;
	private LinearLayout linear22;
	private SeekBar maxram;
	private TextView textview6;
	private Spinner spinner1;
	private Button opentheme;
	private Button animation;
	private TextView textview14;
	private TextView scwarn;
	private GridView gridview1;
	private TextView loadstyle;
	private RadioGroup radiogroup4;
	private CheckBox infogravity;
	private TextView textview8;
	private CheckBox auto;
	private LinearLayout linear4;
	private LinearLayout linear16;
	private LinearLayout linear13;
	private Button history;
	private LinearLayout linear15;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private TextView bladtxt;
	private TextView setaccess;
	private Spinner spinner2;
	private LinearLayout linear23;
	private CheckBox videoad;
	private LinearLayout linear24;
	private EditText keywords;
	private TextView conftitle;
	private LinearLayout linear25;
	private TextView about;
	private TextView developerinfo;
	private LinearLayout linear20;
	private LinearLayout linear27;
	private LinearLayout linear28;
	private Button privat;
	private TextView devopt;
	private CheckBox useram;
	private CheckBox jslog;
	private CheckBox monitorres;
	private LinearLayout linear29;
	private Button importbak;
	private Button exportbak;
	private LinearLayout linear31;
	private CheckBox batsav;
	private TextView Info;
	private Button add;
	private Button crash;
	private EditText edittext1;
	private EditText adhosts;
	private TextView td1;
	private RadioGroup radiogroup5;
	private RadioButton google;
	private RadioButton bing;
	private RadioButton yahoo;
	private RadioButton duck;
	private CheckBox hide;
	private Button panhint;
	private CheckBox preview;
	private Button hidehint;
	private TextView hintt;
	private Button e1;
	private Button e2;
	private TextView textview2;
	private Button cachehint;
	private RadioButton std;
	private RadioButton dts;
	private RadioButton ionl;
	private RadioButton conl;
	private TextView maxramt;
	private Button ramdef;
	private Button ramhint;
	private RadioButton loadingslash;
	private RadioButton percent;
	private RadioButton loadingpercent;
	private RadioButton slash;
	private RadioButton slpercentash;
	private RadioButton slashpercent;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private AutoCompleteTextView startpage;
	private Button bookmarks;
	private Button googl;
	private Button bng;
	private Button yaho;
	private Button duckgo;
	private TextView textview7;
	private TextView textview11;
	private Button srccln;
	private CheckBox srha;
	private Button clrcache;
	private CheckBox cachea;
	private Button cookieclr;
	private CheckBox cookiea;
	private Button formclr;
	private CheckBox forma;
	private CheckBox iframer;
	private Button ifrhint;
	private TextView textview12;
	private Button defadfilters;
	private LinearLayout linear26;
	private TextView textview13;
	private Button showpass;
	private Button passhint;
	private CheckBox lock;
	private CheckBox lock2;
	private CheckBox hidepass;
	private CheckBox hidepass2;
	private EditText pass;
	private Button tgk;
	private Button tgkc;
	private Button skintg;
	private Button skintgc;
	private Button exttg;
	private Button exttgc;
	private LinearLayout linear30;
	private Button hardhint;
	private CheckBox hard;
	private CheckBox webhard;
	private CheckBox don;
	private TextView textview15;
	private SeekBar blurxd;
	private SeekBar bluryd;
	private TextView textview16;
	private SeekBar rotatered;
	private SeekBar rotategreen;
	private SeekBar rotateblue;
	private TextView textview17;
	private SeekBar saturation;
	private TextView textview18;
	private SeekBar valuered;
	private SeekBar valuegreen;
	private SeekBar valueblue;
	private TextView textview19;
	private SeekBar alpd;
	
	private Intent intent = new Intent();
	private AlertDialog.Builder dlg;
	private ObjectAnimator anim = new ObjectAnimator();
	private ObjectAnimator prevcheckbox = new ObjectAnimator();
	private AlertDialog.Builder hints;
	private ObjectAnimator pnupanim = new ObjectAnimator();
	private AlertDialog.Builder scr;
	private AlertDialog.Builder def;
	private SharedPreferences sf;
	private SharedPreferences sf2;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		ThemeManager.applyTheme(this);
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.settings);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		ru = new RenderUtils(SettingsActivity.this);
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		name = findViewById(R.id.name);
		first = findViewById(R.id.first);
		linear7 = findViewById(R.id.linear7);
		hscroll1 = findViewById(R.id.hscroll1);
		textview3 = findViewById(R.id.textview3);
		srhhis = findViewById(R.id.srhhis);
		navpan = findViewById(R.id.navpan);
		pnup = findViewById(R.id.pnup);
		srup = findViewById(R.id.srup);
		linear5 = findViewById(R.id.linear5);
		zoombtns = findViewById(R.id.zoombtns);
		screen = findViewById(R.id.screen);
		linear21 = findViewById(R.id.linear21);
		mono = findViewById(R.id.mono);
		button4 = findViewById(R.id.button4);
		useragent = findViewById(R.id.useragent);
		replacer = findViewById(R.id.replacer);
		except = findViewById(R.id.except);
		linear9 = findViewById(R.id.linear9);
		seekbar1 = findViewById(R.id.seekbar1);
		navset = findViewById(R.id.navset);
		prevexit = findViewById(R.id.prevexit);
		linear6 = findViewById(R.id.linear6);
		radiogroup2 = findViewById(R.id.radiogroup2);
		onnointernet = findViewById(R.id.onnointernet);
		linear22 = findViewById(R.id.linear22);
		maxram = findViewById(R.id.maxram);
		textview6 = findViewById(R.id.textview6);
		spinner1 = findViewById(R.id.spinner1);
		opentheme = findViewById(R.id.opentheme);
		animation = findViewById(R.id.animation);
		textview14 = findViewById(R.id.textview14);
		scwarn = findViewById(R.id.scwarn);
		gridview1 = findViewById(R.id.gridview1);
		loadstyle = findViewById(R.id.loadstyle);
		radiogroup4 = findViewById(R.id.radiogroup4);
		infogravity = findViewById(R.id.infogravity);
		textview8 = findViewById(R.id.textview8);
		auto = findViewById(R.id.auto);
		linear4 = findViewById(R.id.linear4);
		linear16 = findViewById(R.id.linear16);
		linear13 = findViewById(R.id.linear13);
		history = findViewById(R.id.history);
		linear15 = findViewById(R.id.linear15);
		linear17 = findViewById(R.id.linear17);
		linear18 = findViewById(R.id.linear18);
		bladtxt = findViewById(R.id.bladtxt);
		setaccess = findViewById(R.id.setaccess);
		spinner2 = findViewById(R.id.spinner2);
		linear23 = findViewById(R.id.linear23);
		videoad = findViewById(R.id.videoad);
		linear24 = findViewById(R.id.linear24);
		keywords = findViewById(R.id.keywords);
		conftitle = findViewById(R.id.conftitle);
		linear25 = findViewById(R.id.linear25);
		about = findViewById(R.id.about);
		developerinfo = findViewById(R.id.developerinfo);
		linear20 = findViewById(R.id.linear20);
		linear27 = findViewById(R.id.linear27);
		linear28 = findViewById(R.id.linear28);
		privat = findViewById(R.id.privat);
		devopt = findViewById(R.id.devopt);
		useram = findViewById(R.id.useram);
		jslog = findViewById(R.id.jslog);
		monitorres = findViewById(R.id.monitorres);
		linear29 = findViewById(R.id.linear29);
		importbak = findViewById(R.id.importbak);
		exportbak = findViewById(R.id.exportbak);
		linear31 = findViewById(R.id.linear31);
		batsav = findViewById(R.id.batsav);
		Info = findViewById(R.id.Info);
		add = findViewById(R.id.add);
		crash = findViewById(R.id.crash);
		edittext1 = findViewById(R.id.edittext1);
		adhosts = findViewById(R.id.adhosts);
		td1 = findViewById(R.id.td1);
		radiogroup5 = findViewById(R.id.radiogroup5);
		google = findViewById(R.id.google);
		bing = findViewById(R.id.bing);
		yahoo = findViewById(R.id.yahoo);
		duck = findViewById(R.id.duck);
		hide = findViewById(R.id.hide);
		panhint = findViewById(R.id.panhint);
		preview = findViewById(R.id.preview);
		hidehint = findViewById(R.id.hidehint);
		hintt = findViewById(R.id.hintt);
		e1 = findViewById(R.id.e1);
		e2 = findViewById(R.id.e2);
		textview2 = findViewById(R.id.textview2);
		cachehint = findViewById(R.id.cachehint);
		std = findViewById(R.id.std);
		dts = findViewById(R.id.dts);
		ionl = findViewById(R.id.ionl);
		conl = findViewById(R.id.conl);
		maxramt = findViewById(R.id.maxramt);
		ramdef = findViewById(R.id.ramdef);
		ramhint = findViewById(R.id.ramhint);
		loadingslash = findViewById(R.id.loadingslash);
		percent = findViewById(R.id.percent);
		loadingpercent = findViewById(R.id.loadingpercent);
		slash = findViewById(R.id.slash);
		slpercentash = findViewById(R.id.slpercentash);
		slashpercent = findViewById(R.id.slashpercent);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		startpage = findViewById(R.id.startpage);
		bookmarks = findViewById(R.id.bookmarks);
		googl = findViewById(R.id.googl);
		bng = findViewById(R.id.bng);
		yaho = findViewById(R.id.yaho);
		duckgo = findViewById(R.id.duckgo);
		textview7 = findViewById(R.id.textview7);
		textview11 = findViewById(R.id.textview11);
		srccln = findViewById(R.id.srccln);
		srha = findViewById(R.id.srha);
		clrcache = findViewById(R.id.clrcache);
		cachea = findViewById(R.id.cachea);
		cookieclr = findViewById(R.id.cookieclr);
		cookiea = findViewById(R.id.cookiea);
		formclr = findViewById(R.id.formclr);
		forma = findViewById(R.id.forma);
		iframer = findViewById(R.id.iframer);
		ifrhint = findViewById(R.id.ifrhint);
		textview12 = findViewById(R.id.textview12);
		defadfilters = findViewById(R.id.defadfilters);
		linear26 = findViewById(R.id.linear26);
		textview13 = findViewById(R.id.textview13);
		showpass = findViewById(R.id.showpass);
		passhint = findViewById(R.id.passhint);
		lock = findViewById(R.id.lock);
		lock2 = findViewById(R.id.lock2);
		hidepass = findViewById(R.id.hidepass);
		hidepass2 = findViewById(R.id.hidepass2);
		pass = findViewById(R.id.pass);
		tgk = findViewById(R.id.tgk);
		tgkc = findViewById(R.id.tgkc);
		skintg = findViewById(R.id.skintg);
		skintgc = findViewById(R.id.skintgc);
		exttg = findViewById(R.id.exttg);
		exttgc = findViewById(R.id.exttgc);
		linear30 = findViewById(R.id.linear30);
		hardhint = findViewById(R.id.hardhint);
		hard = findViewById(R.id.hard);
		webhard = findViewById(R.id.webhard);
		don = findViewById(R.id.don);
		textview15 = findViewById(R.id.textview15);
		blurxd = findViewById(R.id.blurxd);
		bluryd = findViewById(R.id.bluryd);
		textview16 = findViewById(R.id.textview16);
		rotatered = findViewById(R.id.rotatered);
		rotategreen = findViewById(R.id.rotategreen);
		rotateblue = findViewById(R.id.rotateblue);
		textview17 = findViewById(R.id.textview17);
		saturation = findViewById(R.id.saturation);
		textview18 = findViewById(R.id.textview18);
		valuered = findViewById(R.id.valuered);
		valuegreen = findViewById(R.id.valuegreen);
		valueblue = findViewById(R.id.valueblue);
		textview19 = findViewById(R.id.textview19);
		alpd = findViewById(R.id.alpd);
		dlg = new AlertDialog.Builder(this);
		hints = new AlertDialog.Builder(this);
		scr = new AlertDialog.Builder(this);
		def = new AlertDialog.Builder(this);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		sf2 = getSharedPreferences("code", Activity.MODE_PRIVATE);
		
		first.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), GrantActivity.class);
				startActivity(intent);
			}
		});
		
		srhhis.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("searchpan", "").equals("0")) {
					sf.edit().putString("searchpan", "1").commit();
					srhhis.setChecked(true);
				} else {
					sf.edit().putString("searchpan", "0").commit();
					srhhis.setChecked(false);
				}
			}
		});
		
		navpan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("navpan", "").equals("0")) {
					sf.edit().putString("navpan", "1").commit();
					navpan.setChecked(true);
				} else {
					sf.edit().putString("navpan", "0").commit();
					navpan.setChecked(false);
				}
			}
		});
		
		pnup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("navpanpos", "").equals("0")) {
					sf.edit().putString("navpanpos", "1").commit();
					pnup.setChecked(true);
				} else {
					sf.edit().putString("navpanpos", "0").commit();
					pnup.setChecked(false);
				}
			}
		});
		
		srup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("searchpanelpos", "").equals("0")) {
					sf.edit().putString("searchpanelpos", "1").commit();
					srup.setChecked(true);
				} else {
					sf.edit().putString("searchpanelpos", "0").commit();
					srup.setChecked(false);
				}
			}
		});
		
		zoombtns.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("zoombutton", "").equals("0")) {
					sf.edit().putString("zoombutton", "1").commit();
					zoombtns.setChecked(true);
				} else {
					sf.edit().putString("zoombutton", "0").commit();
					zoombtns.setChecked(false);
				}
			}
		});
		
		screen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("noscreen", "").equals("0")) {
					sf.edit().putString("noscreen", "1").commit();
					screen.setChecked(true);
					linear21.setVisibility(View.GONE);
				} else {
					sf.edit().putString("noscreen", "0").commit();
					screen.setChecked(false);
					linear21.setVisibility(View.VISIBLE);
					Animator2.anim(getApplicationContext(), linear21, 2, 300);
				}
			}
		});
		
		mono.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("monoforta", "").equals("0")) {
					sf.edit().putString("monoforta", "1").commit();
					mono.setChecked(true);
					startpage.setTypeface(Typeface.MONOSPACE);
					keywords.setTypeface(Typeface.MONOSPACE);
					pass.setTypeface(Typeface.MONOSPACE);
					
				} else {
					sf.edit().putString("monoforta", "0").commit();
					mono.setChecked(false);
					startpage.setTypeface(Typeface.DEFAULT);
					keywords.setTypeface(Typeface.DEFAULT);
					pass.setTypeface(Typeface.DEFAULT);
					
				}
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ExtensionsActivity.class);
				startActivity(intent);
			}
		});
		
		useragent.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), UseragentActivity.class);
				startActivity(intent);
			}
		});
		
		replacer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ReplaceActivity.class);
				startActivity(intent);
			}
		});
		
		except.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ExceptionsActivity.class);
				startActivity(intent);
			}
		});
		
		seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("button", String.valueOf((long)(_progressValue + 20))).commit();
				hintt.setText(getString(R.string.buttons_size).concat(" (").concat(String.valueOf((long)(_progressValue + 20)).concat(" dp)")));
				e1.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button","")) * getResources().getDisplayMetrics().density * 1.27));
				e1.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button","")) * getResources().getDisplayMetrics().density);
				e1.setTextSize( Float.parseFloat(sf.getString("button","")) / 2.5f);
				e1.requestLayout();
				
				e2.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button","")) * getResources().getDisplayMetrics().density * 1.27));
				e2.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button","")) * getResources().getDisplayMetrics().density);
				e2.setTextSize( Float.parseFloat(sf.getString("button","")) / 2.5f);
				e2.requestLayout();
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		prevexit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("preventclose", "").equals("0")) {
					sf.edit().putString("preventclose", "1").commit();
					prevexit.setChecked(true);
				} else {
					sf.edit().putString("preventclose", "0").commit();
					prevexit.setChecked(false);
				}
			}
		});
		
		onnointernet.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("nointernet", "").equals("0")) {
					sf.edit().putString("nointernet", "1").commit();
					onnointernet.setChecked(true);
				} else {
					sf.edit().putString("nointernet", "0").commit();
					onnointernet.setChecked(false);
				}
			}
		});
		
		maxram.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("maxram", String.valueOf((long)((_totalMem() / 32.d) * _progressValue))).commit();
				maxramt.setText(getString(R.string.ram_limit).concat(sf.getString("maxram", "").concat(" MiB")));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (!(_position == 0)) {
					SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
					sf.edit().putString("theme", skins.get((int)_position).get("v").toString()).commit();
					_colorToRam();
					_theme();
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		opentheme.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), CustomthemeActivity.class);
				startActivity(intent);
			}
		});
		
		animation.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), AnimActivity.class);
				startActivity(intent);
			}
		});
		
		textview14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (gridview1.getVisibility() == View.VISIBLE) {
					textview14.setText(getString(R.string.app_icon) + " [▼]");
					gridview1.setVisibility(View.GONE);
					scwarn.setVisibility(View.GONE);
				} else {
					gridview1.setVisibility(View.VISIBLE);
					scwarn.setVisibility(View.VISIBLE);
					textview14.setText(getString(R.string.app_icon) + " [▲]");
					Animator2.anim(getApplicationContext(), gridview1, 1, 300);
				}
			}
		});
		
		gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				IconSwitcher.applyIconByIndex(getApplicationContext(), _position);
				((BaseAdapter) gridview1.getAdapter()).notifyDataSetChanged();
			}
		});
		
		infogravity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("infotext", "").equals("0")) {
					sf.edit().putString("infotext", "1").commit();
					infogravity.setChecked(true);
				} else {
					sf.edit().putString("infotext", "0").commit();
					infogravity.setChecked(false);
				}
			}
		});
		
		auto.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("autofirstpage", "").equals("0")) {
					sf.edit().putString("autofirstpage", "1").commit();
					auto.setChecked(true);
					linear4.setVisibility(View.GONE);
				} else {
					sf.edit().putString("autofirstpage", "0").commit();
					auto.setChecked(false);
					linear4.setVisibility(View.VISIBLE);
					linear4.requestFocus();
					Animator2.anim(getApplicationContext(), linear4, 1, 300);
				}
			}
		});
		
		history.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), HistoryActivity.class);
				startActivity(intent);
			}
		});
		
		spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (!(_position == 0)) {
					SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
					sf.edit().putString("blockredir", String.valueOf((long)(_position - 1))).commit();
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		videoad.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("skipvideoad", "").equals("0")) {
					sf.edit().putString("skipvideoad", "1").commit();
					videoad.setChecked(true);
				} else {
					sf.edit().putString("skipvideoad", "0").commit();
					videoad.setChecked(false);
				}
			}
		});
		
		keywords.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				
				sf.edit().putString("videopatterns", _charSeq.replace("\n", "\n")).apply();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		privat.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "4149499091822021"));
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
			}
		});
		
		useram.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("usedram", "").equals("0")) {
					sf.edit().putString("usedram", "1").commit();
					useram.setChecked(true);
				} else {
					sf.edit().putString("usedram", "0").commit();
					useram.setChecked(false);
				}
			}
		});
		
		jslog.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("jslog", "").equals("0")) {
					sf.edit().putString("jslog", "1").commit();
					jslog.setChecked(true);
				} else {
					sf.edit().putString("jslog", "0").commit();
					jslog.setChecked(false);
				}
			}
		});
		
		monitorres.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("monitorres", "").equals("0")) {
					sf.edit().putString("monitorres", "1").commit();
					monitorres.setChecked(true);
				} else {
					sf.edit().putString("monitorres", "0").commit();
					monitorres.setChecked(false);
				}
			}
		});
		
		importbak.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_importbackup();
			}
		});
		
		exportbak.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_exportbackup();
			}
		});
		
		batsav.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("batsav", "").equals("0")) {
					sf.edit().putString("batsav", "1").commit();
					batsav.setChecked(true);
				} else {
					sf.edit().putString("batsav", "0").commit();
					batsav.setChecked(false);
				}
			}
		});
		
		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), HomeActivity.class);
				startActivity(intent);
			}
		});
		
		crash.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear1.addView(linear1);
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("cstyle", _charSeq).commit();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		adhosts.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("adhosts", _charSeq).commit();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		google.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("searchengine", "0").commit();
			}
		});
		
		bing.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("searchengine", "1").commit();
			}
		});
		
		yahoo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("searchengine", "2").commit();
			}
		});
		
		duck.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("searchengine", "3").commit();
			}
		});
		
		hide.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("hidepanels", "").equals("0")) {
					sf.edit().putString("hidepanels", "1").commit();
					hide.setChecked(true);
				} else {
					sf.edit().putString("hidepanels", "0").commit();
					hide.setChecked(false);
				}
			}
		});
		
		panhint.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				hints.setTitle("?");
				hints.setMessage(getString(R.string.hide_panel_hint));
				hints.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = hints.create();
				dddddd.setOnShowListener(d -> {
						if(android.os.Build.VERSION.SDK_INT > 31 && ru.isOn()){
								Window window = dddddd.getWindow();
								if (window != null) {
										window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
										window.setDimAmount(0f);
								}
						}
				});
				dddddd.setOnDismissListener(d -> {
						ru.off();
				});
				ru.on();
				dddddd.show();
				
			}
		});
		
		preview.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("nopreview", "").equals("0")) {
					sf.edit().putString("nopreview", "1").commit();
					preview.setChecked(true);
				} else {
					sf.edit().putString("nopreview", "0").commit();
					preview.setChecked(false);
				}
			}
		});
		
		hidehint.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				scr.setTitle("!!!");
				scr.setMessage(getString(R.string.hide_content_hint));
				scr.setPositiveButton(getString(R.string.forbid_screen), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						screen.performClick();
					}
				});
				scr.setNegativeButton(getString(R.string.no_thanks), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = hints.create();
				dddddd.setOnShowListener(d -> {
						if(android.os.Build.VERSION.SDK_INT > 31 && ru.isOn()){
								Window window = dddddd.getWindow();
								if (window != null) {
										window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
										window.setDimAmount(0f);
								}
						}
				});
				dddddd.setOnDismissListener(d -> {
						ru.off();
				});
				ru.on();
				dddddd.show();
				
			}
		});
		
		e1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		cachehint.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				hints.setTitle("?");
				hints.setMessage(getString(R.string.cache_hint));
				hints.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = hints.create();
				dddddd.setOnShowListener(d -> {
						if(android.os.Build.VERSION.SDK_INT > 31 && ru.isOn()){
								Window window = dddddd.getWindow();
								if (window != null) {
										window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
										window.setDimAmount(0f);
								}
						}
				});
				dddddd.setOnDismissListener(d -> {
						ru.off();
				});
				ru.on();
				dddddd.show();
				
			}
		});
		
		std.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("cache", "0").commit();
			}
		});
		
		dts.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("cache", "1").commit();
			}
		});
		
		ionl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("cache", "2").commit();
			}
		});
		
		conl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("cache", "3").commit();
			}
		});
		
		ramdef.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				maxram.setProgress((int)24);
				/*
sf.edit().putString("maxram", String.valueOf((long)((_totalMem() / 32.d) * maxram.getProgress()))).commit();
maxramt.setText(getString(R.string.ram_limit).concat(sf.getString("maxram", "").concat(" MiB")));
*/
			}
		});
		
		ramhint.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				hints.setTitle("?");
				hints.setMessage(getString(R.string.ram_limit_hint));
				hints.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = hints.create();
				dddddd.setOnShowListener(d -> {
						if(android.os.Build.VERSION.SDK_INT > 31 && ru.isOn()){
								Window window = dddddd.getWindow();
								if (window != null) {
										window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
										window.setDimAmount(0f);
								}
						}
				});
				dddddd.setOnDismissListener(d -> {
						ru.off();
				});
				ru.on();
				dddddd.show();
				
			}
		});
		
		loadingslash.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("loadingstyle", "0").commit();
			}
		});
		
		percent.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("loadingstyle", "3").commit();
			}
		});
		
		loadingpercent.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("loadingstyle", "1").commit();
			}
		});
		
		slash.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("loadingstyle", "2").commit();
			}
		});
		
		slpercentash.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("loadingstyle", "4").commit();
			}
		});
		
		slashpercent.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("loadingstyle", "5").commit();
			}
		});
		
		startpage.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("firstpage", _charSeq).commit();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		bookmarks.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startpage.setText("file://" + getFilesDir().getPath().concat("/bookmark.json"));
			}
		});
		
		googl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startpage.setText("https://www.google.com");
			}
		});
		
		bng.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startpage.setText("https://www.bing.com");
			}
		});
		
		yaho.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startpage.setText("https://www.yahoo.com");
			}
		});
		
		duckgo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startpage.setText("https://www.duckduckgo.com");
			}
		});
		
		srccln.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dlg.setTitle("?");
				dlg.setMessage(getString(R.string.clr_search_dlg));
				dlg.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FileUtil.deleteFile(getFilesDir().getPath().concat("/srhhis.json"));
						SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.searchclr));
						_getFolSize();
					}
				});
				dlg.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = dlg.create();
				dddddd.setOnShowListener(d -> {
						if(android.os.Build.VERSION.SDK_INT > 31 && ru.isOn()){
								Window window = dddddd.getWindow();
								if (window != null) {
										window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
										window.setDimAmount(0f);
								}
						}
				});
				dddddd.setOnDismissListener(d -> {
						ru.off();
				});
				ru.on();
				dddddd.show();
				
			}
		});
		
		srha.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("autocleansearch", "").equals("0")) {
					sf.edit().putString("autocleansearch", "1").commit();
					srha.setChecked(true);
				} else {
					sf.edit().putString("autocleansearch", "0").commit();
					srha.setChecked(false);
				}
			}
		});
		
		clrcache.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dlg.setTitle("?");
				dlg.setMessage(getString(R.string.clr_cache_dlg));
				dlg.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FileUtil.deleteFile(getCacheDir().getPath());
						SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.cookieclr));
						_getFolSize();
					}
				});
				dlg.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = dlg.create();
				dddddd.setOnShowListener(d -> {
						if(android.os.Build.VERSION.SDK_INT > 31 && ru.isOn()){
								Window window = dddddd.getWindow();
								if (window != null) {
										window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
										window.setDimAmount(0f);
								}
						}
				});
				dddddd.setOnDismissListener(d -> {
						ru.off();
				});
				ru.on();
				dddddd.show();
				
			}
		});
		
		cachea.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("autocleancache", "").equals("0")) {
					sf.edit().putString("autocleancache", "1").commit();
					cachea.setChecked(true);
				} else {
					sf.edit().putString("autocleancache", "0").commit();
					cachea.setChecked(false);
				}
			}
		});
		
		cookieclr.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dlg.setTitle("?");
				dlg.setMessage(getString(R.string.clr_cookie_dlg));
				dlg.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						CookieManager.getInstance().removeAllCookies(null);
						SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.cookieclr));
						_getFolSize();
					}
				});
				dlg.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = dlg.create();
				dddddd.setOnShowListener(d -> {
						if(android.os.Build.VERSION.SDK_INT > 31 && ru.isOn()){
								Window window = dddddd.getWindow();
								if (window != null) {
										window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
										window.setDimAmount(0f);
								}
						}
				});
				dddddd.setOnDismissListener(d -> {
						ru.off();
				});
				ru.on();
				dddddd.show();
				
			}
		});
		
		cookiea.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("autocleancookie", "").equals("0")) {
					dlg.setTitle("?");
					dlg.setMessage(getString(R.string.autoclr_cookie_dlg));
					sf.edit().putString("autocleancookie", "0").commit();
					cookiea.setChecked(false);
					dlg.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							sf.edit().putString("autocleancookie", "1").commit();
							cookiea.setChecked(true);
						}
					});
					dlg.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							sf.edit().putString("autocleancookie", "0").commit();
							cookiea.setChecked(false);
						}
					});
					dlg.create().show();
				} else {
					sf.edit().putString("autocleancookie", "0").commit();
					cookiea.setChecked(false);
				}
			}
		});
		
		formclr.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		forma.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("autocleanform", "").equals("0")) {
					sf.edit().putString("autocleanform", "1").commit();
					forma.setChecked(true);
				} else {
					sf.edit().putString("autocleanform", "0").commit();
					forma.setChecked(false);
				}
			}
		});
		
		iframer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("iframer", "").equals("0")) {
					sf.edit().putString("iframer", "1").commit();
					iframer.setChecked(true);
				} else {
					sf.edit().putString("iframer", "0").commit();
					iframer.setChecked(false);
				}
			}
		});
		
		ifrhint.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				hints.setTitle("?");
				hints.setMessage(getString(R.string.iframe_button_hint));
				hints.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = hints.create();
				dddddd.setOnShowListener(d -> {
						if(android.os.Build.VERSION.SDK_INT > 31 && ru.isOn()){
								Window window = dddddd.getWindow();
								if (window != null) {
										window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
										window.setDimAmount(0f);
								}
						}
				});
				dddddd.setOnDismissListener(d -> {
						ru.off();
				});
				ru.on();
				dddddd.show();
				
			}
		});
		
		defadfilters.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				def.setTitle("?");
				def.setMessage("Reset to default? (This may update your ad filters but this also may clear your changes)");
				def.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
						sf.edit().putString("videopatterns", "Пропустити через|Реклама закінчиться|Реклама [0-9]|Відео незабаром почне відтворюватися|Видео скоро начнется|Вы cможете перейти\nк видео через|[0-9] з [0-9]|Перейти на сайт рекламодавця").commit();
						keywords.setText(sf.getString("videopatterns", ""));
					}
				});
				def.setNegativeButton("Decline", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = def.create();
				dddddd.setOnShowListener(d -> {
						if(android.os.Build.VERSION.SDK_INT > 31 && ru.isOn()){
								Window window = dddddd.getWindow();
								if (window != null) {
										window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
										window.setDimAmount(0f);
								}
						}
				});
				dddddd.setOnDismissListener(d -> {
						ru.off();
				});
				ru.on();
				dddddd.show();
				
			}
		});
		
		showpass.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (pass.getVisibility() == View.VISIBLE) {
					showpass.setText("");
					pass.setVisibility(View.GONE);
					lock.setVisibility(View.GONE);
					lock2.setVisibility(View.GONE);
					hidepass.setVisibility(View.GONE);
					hidepass2.setVisibility(View.GONE);
				} else {
					intent.setClass(getApplicationContext(), LockActivity.class);
					startActivity(intent);
				}
			}
		});
		
		passhint.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				hints.setTitle("?");
				hints.setMessage(getString(R.string.pin_requirements));
				hints.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = hints.create();
				dddddd.setOnShowListener(d -> {
						if(android.os.Build.VERSION.SDK_INT > 31 && ru.isOn()){
								Window window = dddddd.getWindow();
								if (window != null) {
										window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
										window.setDimAmount(0f);
								}
						}
				});
				dddddd.setOnDismissListener(d -> {
						ru.off();
				});
				ru.on();
				dddddd.show();
				
			}
		});
		
		lock.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_checklock();
			}
		});
		
		lock2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_checklock();
			}
		});
		
		hidepass.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (hidepass.isChecked()) {
					sf.edit().putString("hidepass", "1").commit();
				} else {
					sf.edit().putString("hidepass", "0").commit();
				}
			}
		});
		
		hidepass2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (hidepass2.isChecked()) {
					sf.edit().putString("hidepass2", "1").commit();
				} else {
					sf.edit().putString("hidepass2", "0").commit();
				}
			}
		});
		
		pass.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				final SharedPreferences sf2 = getSharedPreferences("code", Context.MODE_PRIVATE);
				if ((_charSeq.length() < 101) && (_charSeq.length() > 0)) {
					sf2.edit().putString("code", _charSeq).commit();
				} else {
					
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		tgk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://t.me/a525team/"));
				startActivity(Intent.createChooser(intent, ":)"));
			}
		});
		
		tgkc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "https://t.me/a525team/"));
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
			}
		});
		
		skintg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://t.me/+y_uWob_ngd44NTcy"));
				startActivity(Intent.createChooser(intent, ":)"));
			}
		});
		
		skintgc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "https://t.me/+y_uWob_ngd44NTcy"));
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
			}
		});
		
		exttg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://t.me/+ATG8NrzEEo5hZmFi"));
				startActivity(Intent.createChooser(intent, ":)"));
			}
		});
		
		exttgc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "https://t.me/+ATG8NrzEEo5hZmFi"));
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
			}
		});
		
		hardhint.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				hints.setTitle("?");
				hints.setMessage(getString(R.string.hardware_hint));
				hints.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = hints.create();
				dddddd.setOnShowListener(d -> {
						if(android.os.Build.VERSION.SDK_INT > 31 && ru.isOn()){
								Window window = dddddd.getWindow();
								if (window != null) {
										window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
										window.setDimAmount(0f);
								}
						}
				});
				dddddd.setOnDismissListener(d -> {
						ru.off();
				});
				ru.on();
				dddddd.show();
				
			}
		});
		
		hard.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("hardware", "").equals("0")) {
					sf.edit().putString("hardware", "1").commit();
					hard.setChecked(true);
					getWindow().setFlags(
					    WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
					    WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED
					);
				} else {
					sf.edit().putString("hardware", "0").commit();
					hard.setChecked(false);
					getWindow().clearFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
				}
			}
		});
		
		webhard.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("hardware2", "").equals("0")) {
					sf.edit().putString("hardware2", "1").commit();
					webhard.setChecked(true);
				} else {
					sf.edit().putString("hardware2", "0").commit();
					webhard.setChecked(false);
				}
			}
		});
		
		don.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				ExtendedDataHolder dh = ExtendedDataHolder.getInstance();
				if (sf.getString("don", "").equals("0")) {
					sf.edit().putString("don", "1").commit();
					don.setChecked(true);
					dh.setData("don", "1");
				} else {
					sf.edit().putString("don", "0").commit();
					don.setChecked(false);
					dh.setData("don", "0");
				}
			}
		});
		
		blurxd.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("dblurx", _progressValue);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		bluryd.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("dblury", _progressValue);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		rotatered.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("drred", _progressValue);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		rotategreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("drgreen", _progressValue);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		rotateblue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("drblue", _progressValue);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		saturation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("dsatur", _progressValue / 10.d);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		valuered.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("dvred", _progressValue / 10.d);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		valuegreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("dvgreen", _progressValue / 10.d);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		valueblue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("dvblue", _progressValue / 10.d);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		alpd.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("dvalp", _progressValue / 100.d);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
	}
	
	private void initializeLogic() {
		textview14.setText(getString(R.string.app_icon) + " [▼]");
		gridview1.setVisibility(View.GONE);
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		final SharedPreferences sf2 = getSharedPreferences("code", Context.MODE_PRIVATE);
		
		icons = IconSwitcher.getAllIconsBitmaps(getApplicationContext());
		
		for(int i=0; i<icons.size(); i++){
					HashMap<String, Object> _item = new HashMap<>();
				icons2.add(_item);
		}
		gridview1.setAdapter(new Gridview1Adapter(icons2));
		_info();
		_getFolSize();
		zoombtns.setVisibility(View.GONE);
		scwarn.setVisibility(View.GONE);
		try{
				pass.setVisibility(View.GONE);
				lock.setVisibility(View.GONE);
				lock2.setVisibility(View.GONE);
				hidepass.setVisibility(View.GONE);
				hidepass2.setVisibility(View.GONE);
				navpan.setChecked(sf.getString("navpan", "").equals("1"));
				std.setChecked(sf.getString("cache", "").equals("0"));
				dts.setChecked(sf.getString("cache", "").equals("1"));
				ionl.setChecked(sf.getString("cache", "").equals("2"));
				srha.setChecked(sf.getString("autocleansearch", "").equals("1"));
				cachea.setChecked(sf.getString("autocleancache", "").equals("1"));
				cookiea.setChecked(sf.getString("autocleancookie", "").equals("1"));
				forma.setChecked(sf.getString("autocleanform", "").equals("1"));
				conl.setChecked(sf.getString("cache", "").equals("3"));
				loadingslash.setChecked(sf.getString("loadingstyle", "").equals("0"));
				loadingpercent.setChecked(sf.getString("loadingstyle", "").equals("1"));
				srhhis.setChecked(sf.getString("searchpan", "").equals("1"));
				slash.setChecked(sf.getString("loadingstyle", "").equals("2"));
				percent.setChecked(sf.getString("loadingstyle", "").equals("3"));
				slpercentash.setChecked(sf.getString("loadingstyle", "").equals("4"));
				slashpercent.setChecked(sf.getString("loadingstyle", "").equals("5"));
				infogravity.setChecked(sf.getString("infotext", "").equals("1"));
				onnointernet.setChecked(sf.getString("nointernet", "").equals("1"));
				google.setChecked(sf.getString("searchengine", "").equals("0"));
				bing.setChecked(sf.getString("searchengine", "").equals("1"));
				yahoo.setChecked(sf.getString("searchengine", "").equals("2"));
				duck.setChecked(sf.getString("searchengine", "").equals("3"));
				hide.setChecked(sf.getString("hidepanels", "").equals("1"));
				srup.setChecked(sf.getString("searchpanelpos", "").equals("1"));
				pnup.setChecked(sf.getString("navpanpos", "").equals("1"));
				auto.setChecked(sf.getString("autofirstpage", "").equals("1"));
				zoombtns.setChecked(sf.getString("zoombutton", "").equals("1"));
				screen.setChecked(sf.getString("noscreen", "").equals("1"));
				preview.setChecked(sf.getString("nopreview", "").equals("1"));
				mono.setChecked(sf.getString("monoforta", "").equals("1"));
				videoad.setChecked(sf.getString("skipvideoad", "").equals("1"));
				useram.setChecked(sf.getString("usedram", "").equals("1"));
				iframer.setChecked(sf.getString("iframer", "").equals("1"));
				jslog.setChecked(sf.getString("jslog", "").equals("1"));
				hidepass.setChecked(sf.getString("hidepass", "").equals("1"));
				hidepass2.setChecked(sf.getString("hidepass2", "").equals("1"));
				prevexit.setChecked(sf.getString("preventclose", "").equals("1"));
				hard.setChecked(sf.getString("hardware", "").equals("1"));
				webhard.setChecked(sf.getString("hardware2", "").equals("1"));
				monitorres.setChecked(sf.getString("monitorres", "").equals("1"));
				batsav.setChecked(sf.getString("batsav", "").equals("1"));
				if (sf.getString("autofirstpage", "").equals("1")) {
						linear4.setVisibility(View.GONE);
				}
				if (sf.getString("noscreen", "").equals("1")) {
						linear21.setVisibility(View.GONE);
				}
				startpage.setText(sf.getString("firstpage", ""));
				keywords.setText(sf.getString("videopatterns", ""));
				seekbar1.setProgress((int)Integer.parseInt(sf.getString("button", "")) - 20);
				String maxRamStr = sf.getString("maxram","");
				double maxRam = Double.parseDouble(maxRamStr);
				double totalMem = _totalMem();
				int progress = (int)((maxRam / totalMem * 32)+0.5);
				maxram.setProgress(progress);
				maxramt.setText(getString(R.string.ram_limit).concat(sf.getString("maxram", "").concat(" MiB")));
				hintt.setText(getString(R.string.buttons_size).concat(" (").concat(sf.getString("button", "").concat(" dp)")));
				loadingslash.setText(getString(R.string.loading).concat(" //////////////////////"));
				loadingpercent.setText(getString(R.string.loading).concat(" 35%"));
				edittext1.setText(sf2.getString("cstyle", ""));
				if (sf2.contains("en")) {
						if (sf2.getString("en", "").equals("1")) {
								lock.setChecked(true);
								lock2.setChecked(true);
						} else {
								if (sf2.getString("en", "").equals("2")) {
										lock.setChecked(true);
								}
						}
				} else {
						sf2.edit().putString("en", "0").commit();
						sf2.edit().putString("code", "1111").commit();
				}
				pass.setText(sf2.getString("code", ""));
				adhosts.setText(sf.getString("adhosts", ""));
				ThemeManager.setSpinner(SettingsActivity.this, blred, spinner2);
				spinner2.setSelection((int)(Integer.parseInt(sf.getString("blockredir", "")) + 1));
		}catch(Exception e){
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", e.toString()));
		}
	}
	
	@Override
	public void onBackPressed() {
		finish();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		SafeMarginUtils.init(this, linear1);
		if (sf.getString("monoforta", "").equals("1")) {
			startpage.setTypeface(Typeface.MONOSPACE);
			keywords.setTypeface(Typeface.MONOSPACE);
		} else {
			startpage.setTypeface(Typeface.DEFAULT);keywords.setTypeface(Typeface.DEFAULT);
		}
		_Languag();
		_colorToRam();
		_theme();
		if (dataHolder.getData("safe")!=null && dataHolder.getData("safe").equals("1")) {
			showpass.setText("");
			dataHolder.setData("safe", "0");
			pass.setVisibility(View.VISIBLE);
			lock.setVisibility(View.VISIBLE);
			lock2.setVisibility(View.VISIBLE);
			hidepass.setVisibility(View.VISIBLE);
			hidepass2.setVisibility(View.VISIBLE);
		}
	}
	
	
	@Override
	public void onPause() {
		super.onPause();
		SafeMarginUtils.cleanup();
	}
	public void _Languag() {
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
	
	
	public void _theme() {
		try{
			Skin skin = new Skin();
			
			skin.setBG(button4, 0, false);
			skin.setBG(animation, 0, false);
			skin.setBG(ifrhint, 0, false);
			skin.setBG(importbak, 0, false);
			skin.setBG(exportbak, 0, false);
			skin.setBG(hidehint, 1, false);
			skin.setBG(crash, 1, false);
			skin.setBG(defadfilters, 1, false);
			skin.setBG(showpass, 1, false);
			skin.setBG(passhint, 0, false);
			skin.setBG(tgk, 0, false);
			skin.setBG(tgkc, 0, false);
			skin.setBG(skintg, 0, false);
			skin.setBG(skintgc, 0, false);
			skin.setBG(exttg, 0, false);
			skin.setBG(exttgc, 0, false);
			//skin.setBG(tgc, 0, false);
			//skin.setBG(tgcc, 0, false);
			skin.setBG(privat, 0, false);
			skin.setBG(cookieclr, 0, false);
			skin.setBG(formclr, 0, false);
			skin.setBG(e1, 0, true);
			skin.setBG(e2, 0, true);
			skin.setBG(panhint, 0, false);
			skin.setBG(cachehint, 0, false);
			skin.setBG(clrcache, 0, false);
			skin.setBG(bookmarks, 0, false);
			skin.setBG(googl, 0, false);
			skin.setBG(bng, 0, false);
			skin.setBG(yaho, 0, false);
			skin.setBG(duckgo, 0, false);
			skin.setBG(srccln, 0, false);
			skin.setBG(replacer, 0, false);
			skin.setBG(useragent, 0, false);
			skin.setBG(history, 0, false);
			skin.setBG(except, 0, false);
			skin.setBG(opentheme, 0, false);
			skin.setBG(ramhint, 0, false);
			skin.setBG(ramdef, 1, false);
			skin.setBG(first, 0, false);
			skin.setBG(add, 0, false);
			skin.setBG(hardhint, 0, false);
			
			button4.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			animation.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			importbak.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			exportbak.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			hidehint.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			ramdef.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			cookieclr.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			formclr.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			add.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			e1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			e2.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			hardhint.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			
			//tgc.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			//tgcc.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			tgk.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			tgkc.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			skintg.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			skintgc.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			exttg.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			exttgc.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			privat.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			videoad.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			
			conftitle.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			lock.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			lock2.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			hidepass.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			hidepass2.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			pass.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
			pass.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
			showpass.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			passhint.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			
			monitorres.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			batsav.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			panhint.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			cachehint.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			crash.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			defadfilters.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			textview2.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			textview7.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			textview12.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			td1.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			devopt.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			bladtxt.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			textview3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			textview6.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			scwarn.setTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
			
			textview11.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			textview14.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			startpage.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
			keywords.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
			setaccess.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			jslog.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			iframer.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			ifrhint.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			
			startpage.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
			keywords.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
			std.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			pnup.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			screen.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			preview.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			developerinfo.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			zoombtns.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			slpercentash.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			slashpercent.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			onnointernet.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			mono.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			useram.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			srhhis.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			textview8.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			about.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			keywords.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
			srup.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			dts.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			hide.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			hintt.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			google.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			bing.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			yahoo.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			duck.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			auto.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			infogravity.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			ionl.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			conl.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			name.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			hard.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			webhard.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			
			loadstyle.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			maxramt.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			ramhint.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			clrcache.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			replacer.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			useragent.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			opentheme.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			srccln.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			bookmarks.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			googl.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			bng.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			yaho.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			duckgo.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			history.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			except.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			navpan.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			loadingslash.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			percent.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			loadingpercent.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			slash.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			        skin.setBG(getWindow().getDecorView(), 2, false);
			
			first.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			navset.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			prevexit.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			colorify.applyColorifyToAll(getWindow().getDecorView().getRootView());
		}catch(Exception e){
			 
		}
		showpass.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
	}
	
	
	public void _colorToRam() {
		Skin skin = new Skin();
		skin.colorToRam(this);
	}
	
	
	public double _totalMem() {
		ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
		        MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
		        activityManager.getMemoryInfo(memoryInfo);
		
		        // Загальна кількість доступної пам'яті
		        return memoryInfo.totalMem / 1048576L; // в MB
		
	}
	
	
	public void _checklock() {
		final SharedPreferences sf2 = getSharedPreferences("code", Context.MODE_PRIVATE);
		if (lock.isChecked()) {
			if (lock2.isChecked()) {
				sf2.edit().putString("en", "1").commit();
			} else {
				sf2.edit().putString("en", "2").commit();
			}
		} else {
			sf2.edit().putString("en", "0").commit();
		}
	}
	
	
	public void _exportbackup() {
		new Thread(new Runnable() {
			    @Override
			    public void run() {
				        // Отримуємо папку, яку треба архівувати
				        File sourceDir = new File(getApplicationInfo().dataDir);
				        File destZip = new File(FileUtil.getExternalStorageDir() + "/WeekBrowser/user_backup.zip");
				
				        // Рахуємо загальну кількість файлів для архівації
				        int totalFiles = countFiles(sourceDir);
				        int[] archivedFiles = {0}; // Масив для збереження кількості заархівованих файлів
				
				        // Архівуємо папку з оновленням прогресу
				        zipDirWithProgress(sourceDir, destZip, archivedFiles, totalFiles);
				    }
			
			    // Метод для підрахунку загальної кількості файлів у директорії
			    private int countFiles(File dir) {
				        int count = 0;
				        if (dir.isDirectory()) {
					            File[] files = dir.listFiles();
					            if (files != null) {
						                for (File file : files) {
							                    if (file.isDirectory()) {
								                        count += countFiles(file);
								                    } else {
								                        count++;
								                    }
							                }
						            }
					        }
				        return count;
				    }
			
			    // Метод архівації з оновленням прогресу
			    private void zipDirWithProgress(File srcDir, File destZip, int[] archivedFiles, int totalFiles) {
				        try (FileOutputStream fos = new FileOutputStream(destZip);
				             ZipOutputStream zos = new ZipOutputStream(fos)) {
					            zipFile(srcDir, srcDir, zos, archivedFiles, totalFiles);
					        } catch (IOException e) {
					            e.printStackTrace();
					        }
				    }
			
			    // Метод для архівації файлів
			    private void zipFile(File rootDir, File srcFile, ZipOutputStream zos, int[] archivedFiles, int totalFiles) throws IOException {
				        if (srcFile.isDirectory()) {
					            File[] files = srcFile.listFiles();
					            if (files != null) {
						                for (File file : files) {
							                    zipFile(rootDir, file, zos, archivedFiles, totalFiles);
							                }
						            }
					        } else {
					            try (FileInputStream fis = new FileInputStream(srcFile)) {
						                String zipEntryName = rootDir.toURI().relativize(srcFile.toURI()).getPath();
						                zos.putNextEntry(new ZipEntry(zipEntryName));
						
						                byte[] buffer = new byte[8192];
						                int length;
						                while ((length = fis.read(buffer)) > 0) {
							                    zos.write(buffer, 0, length);
							                }
						                zos.closeEntry();
						                archivedFiles[0]++;
						
						                // Оновлюємо прогрес у TextView через Handler
						                int progress = (int) ((archivedFiles[0] / (float) totalFiles) * 100);
						                exportbak.post(() -> exportbak.setText(progress + "%"));
						            }
					        }
				    }
		}).start();
		
	}
	
	
	public void _importbackup() {
		new Thread(new Runnable() {
				@Override
				public void run() {
						// Визначаємо шляхи
						File destDir = new File(getApplicationInfo().dataDir);
						File sourceZip = new File(FileUtil.getExternalStorageDir() + "/WeekBrowser/user_backup.zip");
						
						// Очищаємо цільову папку
						if (!deleteDirContents(destDir)) {
								showError("Помилка очищення папки");
								return;
						}
						
						// Рахуємо кількість елементів у архіві
						int totalEntries = countZipEntries(sourceZip);
						if (totalEntries == 0) {
								showError("Архів порожній або пошкоджений");
								return;
						}
						
						int[] extractedEntries = {0};
						
						// Розпаковуємо з прогресом
						boolean unzipSuccess = unzipWithProgress(sourceZip, destDir, extractedEntries, totalEntries);
						
						// Перевіряємо результат
						runOnUiThread(() -> {
								if (unzipSuccess && extractedEntries[0] == totalEntries) {
										// Додаємо невелику затримку для гарантії
										new Handler().postDelayed(() -> {
												finishAffinity();
												Intent intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
												if (intent != null) {
														startActivity(intent);
												}
												Runtime.getRuntime().exit(0); // Повне закриття процесу
										}, 300); // 300 мс затримки
								} else {
										importbak.setText("Помилка: розпаковано " + extractedEntries[0] + "/" + totalEntries);
								}
						});
				}
				
				// Метод для відображення помилок
				private void showError(String message) {
						runOnUiThread(() -> {
								importbak.setText(message);
								Toast.makeText(SettingsActivity.this, message, Toast.LENGTH_LONG).show();
						});
				}
				
				// Оновлений метод очищення папки (тепер повертає boolean)
				private boolean deleteDirContents(File dir) {
						try {
								if (dir.exists() && dir.isDirectory()) {
										File[] files = dir.listFiles();
										if (files != null) {
												for (File file : files) {
														if (file.isDirectory()) {
																deleteDirContents(file);
														}
														if (!file.delete()) {
																return false;
														}
												}
										}
								}
								return true;
						} catch (SecurityException e) {
								e.printStackTrace();
								return false;
						}
				}
				
				// Метод підрахунку записів
				private int countZipEntries(File zipFile) {
						int count = 0;
						try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
								while (zis.getNextEntry() != null) {
										count++;
								}
								return count;
						} catch (IOException e) {
								e.printStackTrace();
								return 0;
						}
				}
				
				// Оновлений метод розпакування
				private boolean unzipWithProgress(File zipFile, File destDir, int[] extractedEntries, int totalEntries) {
						try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
								ZipEntry zipEntry;
								byte[] buffer = new byte[8192];
								
								while ((zipEntry = zis.getNextEntry()) != null) {
										File newFile = new File(destDir, zipEntry.getName());
										
										if (zipEntry.isDirectory()) {
												if (!newFile.mkdirs()) return false;
										} else {
												File parent = newFile.getParentFile();
												if (parent != null && !parent.exists() && !parent.mkdirs()) {
														return false;
												}
												
												try (FileOutputStream fos = new FileOutputStream(newFile)) {
														int len;
														while ((len = zis.read(buffer)) > 0) {
																fos.write(buffer, 0, len);
														}
												}
										}
										
										extractedEntries[0]++;
										final int progress = (int) ((extractedEntries[0] / (float) totalEntries) * 100);
										
										runOnUiThread(() -> importbak.setText(progress + "%"));
										zis.closeEntry();
								}
								return true;
						} catch (IOException e) {
								e.printStackTrace();
								return false;
						}
				}
		}).start();
		
	}
	
	
	public void _info() {
		Info.setText(String.format(
		"Version SDK: %d",
		Build.VERSION.SDK_INT));
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", "Choose"
			
			);_item.put("v", 
			
			"-1"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.user_theme)
			
			);_item.put("v", 
			
			"3"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.white).concat(" Monet")
			
			);_item.put("v", 
			
			"4"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.light).concat(" Monet")
			
			);_item.put("v", 
			
			"0"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.dark).concat(" Monet")
			
			);_item.put("v", 
			
			"1"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.black).concat(" Monet")
			
			);_item.put("v", 
			
			"5"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.white).concat(" Material")
			
			);_item.put("v", 
			
			"8"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.dark).concat(" Material")
			
			);_item.put("v", 
			
			"9"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.black).concat(" Material")
			
			);_item.put("v", 
			
			"10"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.white).concat(" Holo")
			
			);_item.put("v", 
			
			"6"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.black).concat(" Holo")
			
			);_item.put("v", 
			
			"7"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.white).concat(" Android 1")
			
			);_item.put("v", 
			
			"11"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.black).concat(" Android 1")
			
			);_item.put("v", 
			
			"12"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.high_contrast) + " " + getString(R.string.black) + " №1"
			
			);_item.put("v", 
			
			"2"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.high_contrast) + " " + getString(R.string.black) + " №2"
			
			);_item.put("v", 
			
			"13"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.high_contrast) + " " + getString(R.string.black) + " №3"
			
			);_item.put("v", 
			
			"14"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.high_contrast) + " " + getString(R.string.white) + " №1"
			
			);_item.put("v", 
			
			"15"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.cherry)
			
			);_item.put("v", 
			
			"16"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.roses)
			
			);_item.put("v", 
			
			"17"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.pumpkin)
			
			);_item.put("v", 
			
			"18"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.diamonds)
			
			);_item.put("v", 
			
			"19"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.min_dark_yellow)
			
			);_item.put("v", 
			
			"20"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.matrix)
			
			);_item.put("v", 
			
			"21"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.banana)
			
			);_item.put("v", 
			
			"22"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.bamboo)
			
			);_item.put("v", 
			
			"23"
			
			);skins.add(_item);}
		spinner1.setAdapter(new Spinner1Adapter(skins));
		blred.add("-- Choose --");
		blred.add(getString(R.string.never));
		blred.add(getString(R.string.blockad_on_only));
		blred.add(getString(R.string.forever));
	}
	
	
	public void _dlgset(final String _n, final double _v) {
		ExtendedDataHolder dh = ExtendedDataHolder.getInstance();
			dh.setData(_n, String.valueOf(_v));
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		sf.edit().putString(_n, String.valueOf(_v)).commit();
		ru.on();
	}
	
	
	public void _getFolSize() {
		SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		srccln.setText(getString(R.string.clear_search) + " (" + Formater.kimgt(FileUtil.getFileLength(getFilesDir().getPath() + "/srhhis.json")) + "B)");
		clrcache.setText(getString(R.string.clear_cache) + " (" + Formater.kimgt(getFolderSize(getCacheDir())) + "B)");
	}
	
	public static long getFolderSize(File folder) {
		    long length = 0;
		    File[] files = folder.listFiles();
		    if (files != null) {
			        for (File file : files) {
				            if (file.isFile()) {
					                length += file.length();
					            } else {
					                length += getFolderSize(file);
					            }
				        }
			    }
		    return length;
	}
	
	
	{
	}
	
	public class Spinner1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Spinner1Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.useragentt, null);
			}
			
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			Animator2.anim(getApplicationContext(), textview1, 0, 100);
			
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			
			// Ініціалізація Skin
			Skin skin = new Skin();
			
			skin.setBG(textview1, 0, false);
			textview1.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
			textview1.setText(_data.get((int)_position).get("n").toString());
			
			return _view;
		}
	}
	
	public class Gridview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Gridview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.draws, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			imageview1.setImageBitmap(icons.get(_position));
			
			Animator2.anim(getApplicationContext(), linear1, 0, 100);
			
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			
			// Ініціалізація Skin
			Skin skin = new Skin();
			
			if(IconSwitcher.getSelectedIconIndex(getApplicationContext()) == _position){
				    skin.setBG(linear1, 1, false);
				textview1.setTextColor((int) Long.parseLong(dataHolder.getData("rbt"), 16));
				    }else{
				skin.setBG(linear1, 0, false);
				textview1.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
			}
			textview1.setText(IconSwitcher.getName(SettingsActivity.this, _position));
			
			return _view;
		}
	}
}