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
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import com.a525team.weekbrowser.SkinAutoCompleteTextView;
import com.a525team.weekbrowser.SkinButton;
import com.a525team.weekbrowser.SkinCheckBox;
import com.a525team.weekbrowser.SkinEditText;
import com.a525team.weekbrowser.SkinRadioButton;
import com.a525team.weekbrowser.SkinSeekBar;
import com.a525team.weekbrowser.SkinTextView;
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
import android.webkit.WebViewDatabase;

public class SettingsActivity extends Activity {
	
	private String alarm = "";
	private String douwant = "";
	private String yes = "";
	private String no = "";
	private String cacheisclear = "";
	ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	private String fffff = "";
	private boolean wrapScroll = false;
	
	private ArrayList<HashMap<String, Object>> skins = new ArrayList<>();
	private  List<Bitmap> icons = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> icons2 = new ArrayList<>();
	private ArrayList<String> blred = new ArrayList<>();
	private ArrayList<String> sm = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private SkinTextView name;
	private SkinButton first;
	private SkinButton utils;
	private LinearLayout linear7;
	private HorizontalScrollView hscroll1;
	private SkinTextView textview3;
	private SkinCheckBox zoombtns;
	private SkinCheckBox screen;
	private LinearLayout linear21;
	private SkinCheckBox mono;
	private LinearLayout linear33;
	private LinearLayout linear34;
	private SkinButton toolspan;
	private SkinTextView textview15;
	private HorizontalScrollView hscroll2;
	private SkinTextView navset;
	private SkinCheckBox prevexit;
	private LinearLayout linear6;
	private RadioGroup radiogroup2;
	private SkinCheckBox onnointernet;
	private LinearLayout linear22;
	private SkinSeekBar maxram;
	private SkinTextView textview6;
	private Spinner spinner1;
	private SkinButton opentheme;
	private SkinButton animation;
	private SkinButton dbg;
	private SkinTextView textview14;
	private SkinTextView scwarn;
	private GridView gridview1;
	private SkinTextView loadstyle;
	private RadioGroup radiogroup4;
	private SkinCheckBox infogravity;
	private SkinTextView textview8;
	private SkinCheckBox auto;
	private LinearLayout linear4;
	private LinearLayout linear16;
	private LinearLayout linear13;
	private SkinButton history;
	private LinearLayout linear32;
	private LinearLayout linear15;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private SkinTextView bladtxt;
	private SkinTextView setaccess;
	private Spinner spinner2;
	private LinearLayout linear23;
	private SkinCheckBox videoad;
	private LinearLayout linear24;
	private SkinEditText keywords;
	private SkinTextView st_open_ads;
	private LinearLayout linear35;
	private SkinTextView conftitle;
	private LinearLayout linear25;
	private SkinTextView about;
	private SkinTextView developerinfo;
	private LinearLayout linear20;
	private LinearLayout linear27;
	private LinearLayout linear28;
	private LinearLayout linear31;
	private SkinButton privat;
	private SkinTextView devopt;
	private SkinCheckBox useram;
	private SkinCheckBox jslog;
	private SkinTextView smss;
	private Spinner supermenumode;
	private LinearLayout linear29;
	private SkinButton importbak;
	private SkinButton exportbak;
	private SkinCheckBox batsav;
	private TextView Info;
	private SkinButton add;
	private SkinButton crash;
	private SkinEditText edittext2;
	private SkinEditText edittext1;
	private SkinTextView td1;
	private RadioGroup radiogroup5;
	private SkinRadioButton google;
	private SkinRadioButton bing;
	private SkinRadioButton yahoo;
	private SkinRadioButton duck;
	private SkinCheckBox preview;
	private SkinButton hidehint;
	private SkinButton button4;
	private SkinButton useragent;
	private SkinButton except;
	private SkinButton replacer;
	private RadioGroup radiogroup6;
	private SkinRadioButton title;
	private SkinRadioButton domain;
	private SkinRadioButton url;
	private SkinTextView textview2;
	private SkinButton cachehint;
	private SkinRadioButton quicknav;
	private SkinRadioButton std;
	private SkinRadioButton dts;
	private SkinRadioButton ionl;
	private SkinRadioButton conl;
	private SkinTextView maxramt;
	private SkinButton ramdef;
	private SkinButton ramhint;
	private SkinRadioButton loadingslash;
	private SkinRadioButton percent;
	private SkinRadioButton loadingpercent;
	private SkinRadioButton slash;
	private SkinRadioButton slpercentash;
	private SkinRadioButton slashpercent;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private SkinAutoCompleteTextView startpage;
	private SkinButton bookmarks;
	private SkinButton googl;
	private SkinButton bng;
	private SkinButton yaho;
	private SkinButton duckgo;
	private SkinTextView textview7;
	private SkinTextView textview11;
	private SkinButton srccln;
	private SkinCheckBox srha;
	private SkinButton clrfav;
	private SkinCheckBox clrfava;
	private SkinButton clrcache;
	private SkinCheckBox cachea;
	private SkinButton cookieclr;
	private SkinCheckBox cookiea;
	private SkinButton formclr;
	private SkinCheckBox forma;
	private SkinCheckBox iframer;
	private SkinButton ifrhint;
	private SkinTextView textview12;
	private SkinButton defadfilters;
	private SkinButton blacklist;
	private SkinButton whitelist;
	private LinearLayout linear26;
	private TextView textview13;
	private SkinButton showpass;
	private SkinButton passhint;
	private SkinCheckBox lock;
	private SkinCheckBox lock2;
	private SkinCheckBox fingerprint;
	private SkinCheckBox hidepass;
	private SkinCheckBox hidepass2;
	private SkinEditText pass;
	private SkinButton tgk;
	private SkinButton tgkc;
	private SkinButton skintg;
	private SkinButton skintgc;
	private SkinButton exttg;
	private SkinButton exttgc;
	private SkinButton github;
	private SkinButton githubc;
	private LinearLayout linear30;
	private SkinButton hardhint;
	private SkinCheckBox hard;
	private SkinCheckBox webhard;
	
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
		super.onCreate(_savedInstanceState);
		ThemeManager.applyTheme(this);
		setContentView(R.layout.settings);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		name = findViewById(R.id.name);
		first = findViewById(R.id.first);
		utils = findViewById(R.id.utils);
		linear7 = findViewById(R.id.linear7);
		hscroll1 = findViewById(R.id.hscroll1);
		textview3 = findViewById(R.id.textview3);
		zoombtns = findViewById(R.id.zoombtns);
		screen = findViewById(R.id.screen);
		linear21 = findViewById(R.id.linear21);
		mono = findViewById(R.id.mono);
		linear33 = findViewById(R.id.linear33);
		linear34 = findViewById(R.id.linear34);
		toolspan = findViewById(R.id.toolspan);
		textview15 = findViewById(R.id.textview15);
		hscroll2 = findViewById(R.id.hscroll2);
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
		dbg = findViewById(R.id.dbg);
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
		linear32 = findViewById(R.id.linear32);
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
		st_open_ads = findViewById(R.id.st_open_ads);
		linear35 = findViewById(R.id.linear35);
		conftitle = findViewById(R.id.conftitle);
		linear25 = findViewById(R.id.linear25);
		about = findViewById(R.id.about);
		developerinfo = findViewById(R.id.developerinfo);
		linear20 = findViewById(R.id.linear20);
		linear27 = findViewById(R.id.linear27);
		linear28 = findViewById(R.id.linear28);
		linear31 = findViewById(R.id.linear31);
		privat = findViewById(R.id.privat);
		devopt = findViewById(R.id.devopt);
		useram = findViewById(R.id.useram);
		jslog = findViewById(R.id.jslog);
		smss = findViewById(R.id.smss);
		supermenumode = findViewById(R.id.supermenumode);
		linear29 = findViewById(R.id.linear29);
		importbak = findViewById(R.id.importbak);
		exportbak = findViewById(R.id.exportbak);
		batsav = findViewById(R.id.batsav);
		Info = findViewById(R.id.Info);
		add = findViewById(R.id.add);
		crash = findViewById(R.id.crash);
		edittext2 = findViewById(R.id.edittext2);
		edittext1 = findViewById(R.id.edittext1);
		td1 = findViewById(R.id.td1);
		radiogroup5 = findViewById(R.id.radiogroup5);
		google = findViewById(R.id.google);
		bing = findViewById(R.id.bing);
		yahoo = findViewById(R.id.yahoo);
		duck = findViewById(R.id.duck);
		preview = findViewById(R.id.preview);
		hidehint = findViewById(R.id.hidehint);
		button4 = findViewById(R.id.button4);
		useragent = findViewById(R.id.useragent);
		except = findViewById(R.id.except);
		replacer = findViewById(R.id.replacer);
		radiogroup6 = findViewById(R.id.radiogroup6);
		title = findViewById(R.id.title);
		domain = findViewById(R.id.domain);
		url = findViewById(R.id.url);
		textview2 = findViewById(R.id.textview2);
		cachehint = findViewById(R.id.cachehint);
		quicknav = findViewById(R.id.quicknav);
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
		clrfav = findViewById(R.id.clrfav);
		clrfava = findViewById(R.id.clrfava);
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
		blacklist = findViewById(R.id.blacklist);
		whitelist = findViewById(R.id.whitelist);
		linear26 = findViewById(R.id.linear26);
		textview13 = findViewById(R.id.textview13);
		showpass = findViewById(R.id.showpass);
		passhint = findViewById(R.id.passhint);
		lock = findViewById(R.id.lock);
		lock2 = findViewById(R.id.lock2);
		fingerprint = findViewById(R.id.fingerprint);
		hidepass = findViewById(R.id.hidepass);
		hidepass2 = findViewById(R.id.hidepass2);
		pass = findViewById(R.id.pass);
		tgk = findViewById(R.id.tgk);
		tgkc = findViewById(R.id.tgkc);
		skintg = findViewById(R.id.skintg);
		skintgc = findViewById(R.id.skintgc);
		exttg = findViewById(R.id.exttg);
		exttgc = findViewById(R.id.exttgc);
		github = findViewById(R.id.github);
		githubc = findViewById(R.id.githubc);
		linear30 = findViewById(R.id.linear30);
		hardhint = findViewById(R.id.hardhint);
		hard = findViewById(R.id.hard);
		webhard = findViewById(R.id.webhard);
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
		
		utils.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), UtilsActivity.class);
				startActivity(intent);
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
		
		toolspan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), BarsActivity.class);
				startActivity(intent);
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
		
		dbg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), DbgActivity.class);
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
		
		about.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (developerinfo.getVisibility() == View.VISIBLE) {
					about.setText(getString(R.string.about) + " [▼]");
					developerinfo.setVisibility(View.GONE);
				} else {
					developerinfo.setVisibility(View.VISIBLE);
					about.setText(getString(R.string.about) + " [▲]");
					Animator2.anim(getApplicationContext(), developerinfo, 1, 300);
				}
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
		
		supermenumode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (!(_position == 0)) {
					SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
					sf.edit().putString("sm", String.valueOf((long)(_position - 1))).commit();
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
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
				_theme();
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
		
		edittext2.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("resol", _charSeq).commit();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
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
				AlertDialog dddddd = scr.create();
				RenderUtils.setupDialogDim(SettingsActivity.this, dddddd);
				dddddd.show();
				
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
		
		except.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ExceptionsActivity.class);
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
		
		title.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("srhbar", "0").commit();
			}
		});
		
		domain.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("srhbar", "1").commit();
			}
		});
		
		url.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("srhbar", "2").commit();
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
				RenderUtils.setupDialogDim(SettingsActivity.this, dddddd);
				dddddd.show();
				
			}
		});
		
		quicknav.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("cache", "0").commit();
			}
		});
		
		std.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("cache", "4").commit();
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
				RenderUtils.setupDialogDim(SettingsActivity.this, dddddd);
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
				RenderUtils.setupDialogDim(SettingsActivity.this, dddddd);
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
		
		clrfav.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dlg.setTitle("?");
				dlg.setMessage(getString(R.string.clr_fav_dlg));
				dlg.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FileUtil.deleteFile(getFilesDir().getPath()+"/favicons");
						SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.faviconclr));
						_getFolSize();
					}
				});
				dlg.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = dlg.create();
				RenderUtils.setupDialogDim(SettingsActivity.this, dddddd);
				dddddd.show();
				
			}
		});
		
		clrfava.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("autocleanfav", "").equals("0")) {
					sf.edit().putString("autocleanfav", "1").commit();
					clrfava.setChecked(true);
				} else {
					sf.edit().putString("autocleanfav", "0").commit();
					clrfava.setChecked(false);
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
						SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.cacheclr));
						_getFolSize();
					}
				});
				dlg.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = dlg.create();
				RenderUtils.setupDialogDim(SettingsActivity.this, dddddd);
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
				RenderUtils.setupDialogDim(SettingsActivity.this, dddddd);
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
					AlertDialog dddddd = dlg.create();
					RenderUtils.setupDialogDim(SettingsActivity.this, dddddd);
					dddddd.show();
					
				} else {
					sf.edit().putString("autocleancookie", "0").commit();
					cookiea.setChecked(false);
				}
			}
		});
		
		formclr.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				WebViewDatabase db = WebViewDatabase.getInstance(getApplicationContext());
				db.clearFormData();
				db.clearHttpAuthUsernamePassword();
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.formclr));
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
				RenderUtils.setupDialogDim(SettingsActivity.this, dddddd);
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
						sf.edit().putString("videopatterns", "Пропустити через|Реклама закінчиться|Реклама [0-9]|Відео незабаром почне відтворюватися|Видео скоро начнется|Вы cможете перейти\nк видео через|[0-9] з [0-9]|Перейти на сайт рекламодавця|Перейти На Сайт Рекламодавця|This ad will end in").commit();
						keywords.setText(sf.getString("videopatterns", ""));
					}
				});
				def.setNegativeButton("Decline", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = def.create();
				RenderUtils.setupDialogDim(SettingsActivity.this, dddddd);
				dddddd.show();
				
			}
		});
		
		blacklist.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), TextActivity.class);
				
				// Формуємо правильний шлях до файлу всередині папки files додатка
				File blackFile = new File(getFilesDir(), "user_ad_list.txt");
				intent.setData(Uri.fromFile(blackFile)); // Автоматично створить Uri зі схемою file://
				
				startActivity(intent);
			}
		});
		
		whitelist.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), TextActivity.class);
				
				// Формуємо правильний шлях до файлу всередині папки files додатка
				File blackFile = new File(getFilesDir(), "user_white_list.txt");
				intent.setData(Uri.fromFile(blackFile)); // Автоматично створить Uri зі схемою file://
				
				startActivity(intent);
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
					fingerprint.setVisibility(View.GONE);
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
				RenderUtils.setupDialogDim(SettingsActivity.this, dddddd);
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
		
		fingerprint.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("usefingerprint", "").equals("0")) {
					sf.edit().putString("usefingerprint", "1").commit();
					fingerprint.setChecked(true);
				} else {
					sf.edit().putString("usefingerprint", "0").commit();
					fingerprint.setChecked(false);
				}
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
		
		github.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://github.com/week5thor/WeekBrowser"));
				startActivity(Intent.createChooser(intent, ":)"));
			}
		});
		
		githubc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "https://github.com/week5thor/WeekBrowser"));
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
				RenderUtils.setupDialogDim(SettingsActivity.this, dddddd);
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
	}
	
	private void initializeLogic() {
		textview14.setText(getString(R.string.app_icon) + " [▼]");
		gridview1.setVisibility(View.GONE);
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		final SharedPreferences sf2 = getSharedPreferences("code", Context.MODE_PRIVATE);
		showpass.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
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
			fingerprint.setVisibility(View.GONE);
			std.setChecked(sf.getString("cache", "").equals("4"));
			dts.setChecked(sf.getString("cache", "").equals("1"));
			ionl.setChecked(sf.getString("cache", "").equals("2"));
			conl.setChecked(sf.getString("cache", "").equals("3"));
			
			title.setChecked(sf.getString("srhbar", "").equals("0"));
			domain.setChecked(sf.getString("srhbar", "").equals("1"));
			url.setChecked(sf.getString("srhbar", "").equals("2"));
			
			quicknav.setChecked(sf.getString("cache", "").equals("0"));
			srha.setChecked(sf.getString("autocleansearch", "").equals("1"));
			cachea.setChecked(sf.getString("autocleancache", "").equals("1"));
			cookiea.setChecked(sf.getString("autocleancookie", "").equals("1"));
			forma.setChecked(sf.getString("autocleanform", "").equals("1"));
			loadingslash.setChecked(sf.getString("loadingstyle", "").equals("0"));
			loadingpercent.setChecked(sf.getString("loadingstyle", "").equals("1"));
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
			batsav.setChecked(sf.getString("batsav", "").equals("1"));
			if (sf.getString("autofirstpage", "").equals("1")) {
				linear4.setVisibility(View.GONE);
			}
			if (sf.getString("noscreen", "").equals("1")) {
				linear21.setVisibility(View.GONE);
			}
			startpage.setText(sf.getString("firstpage", ""));
			keywords.setText(sf.getString("videopatterns", ""));
			String maxRamStr = sf.getString("maxram","");
			double maxRam = Double.parseDouble(maxRamStr);
			double totalMem = _totalMem();
			int progress = (int)((maxRam / totalMem * 32)+0.5);
			maxram.setProgress(progress);
			maxramt.setText(getString(R.string.ram_limit).concat(sf.getString("maxram", "").concat(" MiB")));
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
				sf2.edit().putString("code", "").commit();
			}
			pass.setText(sf2.getString("code", ""));
			fingerprint.setChecked(sf.getString("usefingerprint", "1").equals("1"));
			ThemeManager.setSpinner(SettingsActivity.this, blred, spinner2);
			spinner2.setSelection((int)(Integer.parseInt(sf.getString("blockredir", "")) + 1));
			ThemeManager.setSpinner(SettingsActivity.this, sm, supermenumode);
			supermenumode.setSelection((int)(Integer.parseInt(sf.getString("sm", "")) + 1));
		}catch(Exception e){
			((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", e.toString()));
		}
		developerinfo.setVisibility(View.GONE);
		about.setText(getString(R.string.about) + " [▼]");
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
		if (dataHolder.getData("safe")!=null && dataHolder.getData("safe").equals("1")) {
			showpass.setText("");
			dataHolder.setData("safe", "0");
			pass.setVisibility(View.VISIBLE);
			lock.setVisibility(View.VISIBLE);
			lock2.setVisibility(View.VISIBLE);
			hidepass.setVisibility(View.VISIBLE);
			hidepass2.setVisibility(View.VISIBLE);
			fingerprint.setVisibility(View.VISIBLE);
		}
		_theme();
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
		Skin s = Skin.getInstance();
		s.colorToRam(this);
		if(wrapScroll)s.updateBG(this, 2);
		else s.setStaticBG(this, 2, true);
		s.notifyObservers();
		wrapScroll = true;
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
			getString(R.string.dark).concat(" Holo")
			
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
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.white).concat(" E-ink")
			
			);_item.put("v", 
			
			"24"
			
			);skins.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			getString(R.string.black).concat(" E-ink")
			
			);_item.put("v", 
			
			"25"
			
			);skins.add(_item);}
		spinner1.setAdapter(new Spinner1Adapter(skins));
		blred.add("-- Choose --");
		blred.add(getString(R.string.never));
		blred.add(getString(R.string.blockad_on_only));
		blred.add(getString(R.string.forever));
		sm.add("-- Choose --");
		sm.add("HitTestResult (Legacy)");
		sm.add("JavascriptInterface");
	}
	
	
	public void _getFolSize() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				
				String searchSize = Formater.kimgt(FileUtil.getFileLength(getFilesDir().getPath() + "/srhhis.json"));
				
				String cacheSize = Formater.kimgt(getFolderSize(getCacheDir()));
				
				String favSize = Formater.kimgt(getFolderSize(new File(getFilesDir().getPath()+"/favicons")));
				
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						srccln.setText(getString(R.string.clear_search) + " (" + searchSize + "B)");
						clrcache.setText(getString(R.string.clear_cache) + " (" + cacheSize + "B)");
						clrfav.setText(getString(R.string.clear_favicon) + " (" + favSize + "B)");
					}
				});
			}
		}).start();
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
			
			final com.a525team.weekbrowser.SkinTextView textview1 = _view.findViewById(R.id.textview1);
			
			Animator2.anim(getApplicationContext(), textview1, 0, 100);
			
			/*ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();

// Ініціалізація Skin
Skin skin = new Skin();

skin.setBG(textview1, 0, false);
textview1.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));*/
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
			
			final com.a525team.weekbrowser.SkinLinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final com.a525team.weekbrowser.SkinTextView textview1 = _view.findViewById(R.id.textview1);
			
			imageview1.setImageBitmap(icons.get(_position));
			
			Animator2.anim(getApplicationContext(), linear1, 0, 100);
			
			if(IconSwitcher.getSelectedIconIndex(getApplicationContext()) == _position){
				linear1.setSkinKey("rbg", false);
				textview1.setSkinKey("rbg", false);
			}else{
				linear1.setSkinKey("bbg", false);
				textview1.setSkinKey("bbg", false);
			}
			textview1.setText(IconSwitcher.getName(SettingsActivity.this, _position));
			
			return _view;
		}
	}
}