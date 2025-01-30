package com.a525team.weekbrowser;

import android.animation.*;
import android.animation.Animator;
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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import android.net.Uri;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.io.IOException;
import android.webkit.URLUtil;
import android.os.Bundle;
import android.app.Activity;
import android.webkit.ValueCallback;
//import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.content.pm.ActivityInfo;
import android.view.inputmethod.EditorInfo;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import android.view.inputmethod.InputMethodManager;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.concurrent.atomic.AtomicBoolean;
import android.widget.FrameLayout;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import android.os.Debug;
import android.app.ActivityManager.MemoryInfo;
import android.content.ClipData;
import java.util.LinkedHashSet;
//import com.a525team.weekbrowser.MyWebViewClient;
import android.content.Context;

public class MainActivity extends Activity {
	
	private Timer _timer = new Timer();
	
	private String URL = "";
	private String info = "";
	private boolean cookie = false;
	private double theme = 0;
	private boolean cache = false;
	private boolean Internet = false;
	private double curnum = 0;
	private double allnum = 0;
	private String temp = "";
	private String previntent = "";
	private boolean focused = false;
	private boolean selected = false;
	private String url = "";
	private boolean is1window = false;
	private boolean is1touch = false;
	private boolean issu = false;
	private String tempurl = "";
	private String copy = "";
	private boolean statush = false;
	private boolean kbd = false;
	private boolean isshowpan = false;
	private boolean ismovedpanels = false;
	private boolean isshowed = false;
	private boolean swipetorefresh = false;
	private boolean local1 = false;
	private boolean local2 = false;
	private boolean ALLOWSWIPE = false;
	private boolean isnotchfullscreen = false;
	private double buttoncolors = 0;
	private String designbmlcache = "";
	private String fffff = "";
	private double adsblockedd = 0;
	private String themebml = "";
	int T;
	int Tt;
	int ATt;
	private Timer times;
	private TimerTask timerTask;
	private double load = 0;
	int time;
	private String memoryUsageText = "";
	int usedMemoryMB;
	private boolean holdsearchtext = false;
	private boolean recentlyreleased = false;
	ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	Colorify Colorify = new Colorify();
	private boolean Foreground = false;
	private String prevCharSeq = "";
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);;
	private boolean posshow = false;
	private double wwpos = 0;
	private boolean adbl = false;
	private boolean notFirst = false;
	private String blockedlineg = "";
	private boolean nf = false;
	private int ticks = 0;
	
	private ArrayList<HashMap<String, Object>> history = new ArrayList<>();
	private ArrayList<String> skin = new ArrayList<>();
	private ArrayList<String> srcsug = new ArrayList<>();
	private ArrayList<String> languag = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> tab = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> sitepermis = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> windowpos = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> srhbuf = new ArrayList<>();
	
	private LinearLayout linear2;
	private TextView textview1;
	private LinearLayout windowsmanager;
	private TextView ramuse;
	private LinearLayout tabscontainer;
	private GridView srhhis;
	private LinearLayout linear14;
	private ScrollView settingspanel;
	private HorizontalScrollView nav;
	private LinearLayout searchpan;
	private LinearLayout linear1;
	private HorizontalScrollView hscroll1;
	private LinearLayout linear9;
	private Button widthm1;
	private Button widthp1;
	private Button heightm1;
	private Button heightp1;
	private GridView tabscont;
	private LinearLayout linear15;
	private Button add;
	private Button closeall;
	private LinearLayout linear3;
	private LinearLayout linear12;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private CheckBox iframe;
	private CheckBox swipetore;
	private TextView textview5;
	private SeekBar dp;
	private TextView textview3;
	private SeekBar font;
	private TextView textview2;
	private SeekBar seekbar1;
	private TextView title;
	private Button copyallurl;
	private Button multilink;
	private Button otherapp;
	private CheckBox themepage;
	private CheckBox js;
	private CheckBox pc;
	private CheckBox incognito;
	private CheckBox image;
	private CheckBox blockad;
	private LinearLayout linear5;
	private Button back;
	private Button forward;
	private Button pgup;
	private Button pgdn;
	private Button bookmarks;
	private Button home;
	private Button histori;
	private Button tabs;
	private Button dual;
	private Button skipvideo;
	private Button pagesearch;
	private Button coordinates;
	private AutoCompleteTextView search;
	private Button sup;
	private TextView num;
	private Button sdown;
	private TextView ssl;
	private AutoCompleteTextView autocomplete1;
	private Button hide;
	private Button refresh;
	private Button button1;
	private Button openpanel;
	private Button button3;
	private LinearLayout linear16;
	private Button closeeditor;
	private Button copyurl;
	private Button pasteurl;
	private Button pastegourl;
	private Button selall;
	private Button cururl;
	private Button pos1;
	private Button pos2;
	private Button pos3;
	
	private TimerTask timer;
	private AlertDialog.Builder dlg;
	private Intent intent = new Intent();
	private Calendar dnt = Calendar.getInstance();
	private Intent intent2 = new Intent();
	private Intent thema = new Intent();
	private ObjectAnimator anim = new ObjectAnimator();
	private ObjectAnimator position = new ObjectAnimator();
	private ObjectAnimator tabanim = new ObjectAnimator();
	private AlertDialog.Builder dial;
	private ObjectAnimator anim2 = new ObjectAnimator();
	private ObjectAnimator srhanim = new ObjectAnimator();
	private AlertDialog.Builder shareurl;
	private Intent shareurll = new Intent();
	private AlertDialog.Builder iframecatcher;
	private AlertDialog.Builder blockads;
	private AlertDialog.Builder this_is_not_a_toast_im_stupid_sorry;
	private SharedPreferences sf;
	private ObjectAnimator searchpan2 = new ObjectAnimator();
	private SharedPreferences sf2;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		_ifex();
		if (!sf.contains("lang")) {
				intent.setClass(getApplicationContext(), GrantActivity.class);
				finishAffinity();
				startActivity(intent);
		}
		else {
				
		}
		ThemeManager.applyTheme(this); // Встановлення теми
		    super.onCreate(_savedInstanceState);
		    setContentView(R.layout.main); // Назва layout залежить від активності
		
		linear2 = findViewById(R.id.linear2);
		textview1 = findViewById(R.id.textview1);
		windowsmanager = findViewById(R.id.windowsmanager);
		ramuse = findViewById(R.id.ramuse);
		tabscontainer = findViewById(R.id.tabscontainer);
		srhhis = findViewById(R.id.srhhis);
		linear14 = findViewById(R.id.linear14);
		settingspanel = findViewById(R.id.settingspanel);
		nav = findViewById(R.id.nav);
		searchpan = findViewById(R.id.searchpan);
		linear1 = findViewById(R.id.linear1);
		hscroll1 = findViewById(R.id.hscroll1);
		linear9 = findViewById(R.id.linear9);
		widthm1 = findViewById(R.id.widthm1);
		widthp1 = findViewById(R.id.widthp1);
		heightm1 = findViewById(R.id.heightm1);
		heightp1 = findViewById(R.id.heightp1);
		tabscont = findViewById(R.id.tabscont);
		linear15 = findViewById(R.id.linear15);
		add = findViewById(R.id.add);
		closeall = findViewById(R.id.closeall);
		linear3 = findViewById(R.id.linear3);
		linear12 = findViewById(R.id.linear12);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		iframe = findViewById(R.id.iframe);
		swipetore = findViewById(R.id.swipetore);
		textview5 = findViewById(R.id.textview5);
		dp = findViewById(R.id.dp);
		textview3 = findViewById(R.id.textview3);
		font = findViewById(R.id.font);
		textview2 = findViewById(R.id.textview2);
		seekbar1 = findViewById(R.id.seekbar1);
		title = findViewById(R.id.title);
		copyallurl = findViewById(R.id.copyallurl);
		multilink = findViewById(R.id.multilink);
		otherapp = findViewById(R.id.otherapp);
		themepage = findViewById(R.id.themepage);
		js = findViewById(R.id.js);
		pc = findViewById(R.id.pc);
		incognito = findViewById(R.id.incognito);
		image = findViewById(R.id.image);
		blockad = findViewById(R.id.blockad);
		linear5 = findViewById(R.id.linear5);
		back = findViewById(R.id.back);
		forward = findViewById(R.id.forward);
		pgup = findViewById(R.id.pgup);
		pgdn = findViewById(R.id.pgdn);
		bookmarks = findViewById(R.id.bookmarks);
		home = findViewById(R.id.home);
		histori = findViewById(R.id.histori);
		tabs = findViewById(R.id.tabs);
		dual = findViewById(R.id.dual);
		skipvideo = findViewById(R.id.skipvideo);
		pagesearch = findViewById(R.id.pagesearch);
		coordinates = findViewById(R.id.coordinates);
		search = findViewById(R.id.search);
		sup = findViewById(R.id.sup);
		num = findViewById(R.id.num);
		sdown = findViewById(R.id.sdown);
		ssl = findViewById(R.id.ssl);
		autocomplete1 = findViewById(R.id.autocomplete1);
		hide = findViewById(R.id.hide);
		refresh = findViewById(R.id.refresh);
		button1 = findViewById(R.id.button1);
		openpanel = findViewById(R.id.openpanel);
		button3 = findViewById(R.id.button3);
		linear16 = findViewById(R.id.linear16);
		closeeditor = findViewById(R.id.closeeditor);
		copyurl = findViewById(R.id.copyurl);
		pasteurl = findViewById(R.id.pasteurl);
		pastegourl = findViewById(R.id.pastegourl);
		selall = findViewById(R.id.selall);
		cururl = findViewById(R.id.cururl);
		pos1 = findViewById(R.id.pos1);
		pos2 = findViewById(R.id.pos2);
		pos3 = findViewById(R.id.pos3);
		dlg = new AlertDialog.Builder(this);
		dial = new AlertDialog.Builder(this);
		shareurl = new AlertDialog.Builder(this);
		iframecatcher = new AlertDialog.Builder(this);
		blockads = new AlertDialog.Builder(this);
		this_is_not_a_toast_im_stupid_sorry = new AlertDialog.Builder(this);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		sf2 = getSharedPreferences("code", Activity.MODE_PRIVATE);
		
		srhhis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				autocomplete1.requestFocus();
				kbd = true;
				focused = true;
				autocomplete1.setText(srhbuf.get((int)_position).get("s").toString());
				_kbdsrh();
				if (sf.getString("searchengine", "").equals("0")) {
					URL = "https://www.google.com/search?q=".concat(srhbuf.get((int)_position).get("s").toString());
				}
				if (sf.getString("searchengine", "").equals("1")) {
					URL = "https://www.bing.com/search?q=".concat(srhbuf.get((int)_position).get("s").toString());
				}
				if (sf.getString("searchengine", "").equals("2")) {
					URL = "https://search.yahoo.com/search?p=".concat(srhbuf.get((int)_position).get("s").toString());
				}
				if (sf.getString("searchengine", "").equals("3")) {
					URL = "https://duckduckgo.com/?t=h_&q=".concat(srhbuf.get((int)_position).get("s").toString());
				}
				_webViewActions(10, URL);
			}
		});
		
		srhhis.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				srcsug.remove((int)((srhbuf.size() - 1) - _position));
				sf.edit().putString("srhhis", new Gson().toJson(srcsug)).commit();
				_srhupd();
				return true;
			}
		});
		
		widthm1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				try{
					if (Integer.parseInt(tab.get((int)Integer.parseInt(sf.getString("activetab", ""))).get("w").toString().replace("s", "")) > 1) {
						tab.get((int)Integer.parseInt(sf.getString("activetab", ""))).put("w", "s".concat(String.valueOf((long)(Integer.parseInt(tab.get((int)Integer.parseInt(sf.getString("activetab", ""))).get("w").toString().replace("s", "")) - 1))));
					}
				}catch(Exception e){
					tab.get((int)Integer.parseInt(sf.getString("activetab", ""))).put("w", "s1");
				}
				_restorewindowparam();
			}
		});
		
		widthp1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				try{
					if (Integer.parseInt(tab.get((int)Integer.parseInt(sf.getString("activetab", ""))).get("w").toString().replace("s", "")) < 4) {
						tab.get((int)Integer.parseInt(sf.getString("activetab", ""))).put("w", "s".concat(String.valueOf((long)(Integer.parseInt(tab.get((int)Integer.parseInt(sf.getString("activetab", ""))).get("w").toString().replace("s", "")) - -1))));
					}
				}catch(Exception e){
					tab.get((int)Integer.parseInt(sf.getString("activetab", ""))).put("w", "s3");
				}
				_restorewindowparam();
			}
		});
		
		heightm1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				try{
					if (Integer.parseInt(tab.get((int)Integer.parseInt(sf.getString("activetab", ""))).get("h").toString().replace("s", "")) > 1) {
						tab.get((int)Integer.parseInt(sf.getString("activetab", ""))).put("h", "s".concat(String.valueOf((long)(Integer.parseInt(tab.get((int)Integer.parseInt(sf.getString("activetab", ""))).get("h").toString().replace("s", "")) - 1))));
					}
				}catch(Exception e){
					tab.get((int)Integer.parseInt(sf.getString("activetab", ""))).put("h", "s1");
				}
				_restorewindowparam();
			}
		});
		
		heightp1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				try{
					if (Integer.parseInt(tab.get((int)Integer.parseInt(sf.getString("activetab", ""))).get("h").toString().replace("s", "")) < 4) {
						tab.get((int)Integer.parseInt(sf.getString("activetab", ""))).put("h", "s".concat(String.valueOf((long)(Integer.parseInt(tab.get((int)Integer.parseInt(sf.getString("activetab", ""))).get("h").toString().replace("s", "")) - -1))));
					}
				}catch(Exception e){
					tab.get((int)Integer.parseInt(sf.getString("activetab", ""))).put("h", "s3");
				}
				_restorewindowparam();
			}
		});
		
		//OnTouch
		add.setOnTouchListener(new View.OnTouchListener(){
				@Override
				public boolean onTouch(View v, MotionEvent event){
						int ev = event.getAction();
						switch (ev) {
								case MotionEvent.ACTION_DOWN:
								
								 final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
					notFirst = true;
					_newTab(sf.getString("firstpage", ""), true);
								
								break;
								case MotionEvent.ACTION_UP:
								
								 
								
								break;
						} return true;
				}
		});
		
		//OnTouch
		closeall.setOnTouchListener(new View.OnTouchListener(){
				@Override
				public boolean onTouch(View v, MotionEvent event){
						int ev = event.getAction();
						switch (ev) {
								case MotionEvent.ACTION_DOWN:
								
								 final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
					
					int childCount = tabscontainer.getChildCount();
					
					try {
						    // Ініціалізація змінної T
						    T = 0;
						
						    // Видалення вкладок з масиву і запис в файл перед видаленням з контейнера
						    notFirst = true;
						
						    // Видалення вкладок з контейнера
						    for (int i = childCount - 1; i >= 0; i--) {
							        View child = tabscontainer.getChildAt(i);
							
							        if (child instanceof LinearLayout) {
								            LinearLayout childLinearLayout = (LinearLayout) child;
								
								            for (int j = 0; j < childLinearLayout.getChildCount(); j++) {
									                View nestedChild = childLinearLayout.getChildAt(j);
									                if (nestedChild instanceof WebView) {
										                    WebView webView = (WebView) nestedChild;
										
										                    webView.stopLoading();
										                    webView.clearHistory();
										                    webView.loadUrl("about:blank");
										                    webView.onPause();
										                    webView.removeAllViews();
										
										                    childLinearLayout.removeView(webView);
										                    webView.destroy();
										                    webView = null;
										                    break;
										                }
									            }
								
								            tabscontainer.removeView(childLinearLayout);
								        }
							    }
						
					} catch (Exception e) {
						    e.printStackTrace();
					} finally {
						    // Оновлення тексту або будь-яка інша логіка в finally
					}
					
					tab.clear();
					notFirst = true;
					_newTab(sf.getString("firstpage", ""), true);
					
								
								break;
								case MotionEvent.ACTION_UP:
								
								 
								
								break;
						} return true;
				}
		});
		
		iframe.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				dlg.setTitle(_geturl());
				dlg.setMessage(getString(R.string.iframeexcept));
				dlg.setPositiveButton(getString(R.string.turnon), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						for (int i = 0; i < (int)(sitepermis.size()); i++) {
							if (sitepermis.get((int)i).get("url").toString().equals(_geturl())) {
								sitepermis.get((int)i).put("if", "1");
								issu = true;
								break;
							}
						}
						if (!issu) {
							{
								HashMap<String, Object> _item = new HashMap<>();
								_item.put("url", _geturl());
								sitepermis.add(_item);
							}
							
							sitepermis.get((int)sitepermis.size() - 1).put("if", "1");
						}
						issu = false;
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", new Gson().toJson(sitepermis));
						_webViewActions(1999, "");
					}
				});
				dlg.setNegativeButton(getString(R.string.turnoff), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						for (int i = 0; i < (int)(sitepermis.size()); i++) {
							if (sitepermis.get((int)i).get("url").toString().equals(_geturl())) {
								sitepermis.get((int)i).put("if", "0");
								issu = true;
								break;
							}
						}
						if (!issu) {
							{
								HashMap<String, Object> _item = new HashMap<>();
								_item.put("url", _geturl());
								sitepermis.add(_item);
							}
							
							sitepermis.get((int)sitepermis.size() - 1).put("if", "0");
						}
						issu = false;
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", new Gson().toJson(sitepermis));
						_webViewActions(1999, "");
					}
				});
				dlg.setNeutralButton(getString(R.string.exdefault), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						for (int i = 0; i < (int)(sitepermis.size()); i++) {
							if (sitepermis.get((int)i).get("url").toString().equals(_geturl())) {
								sitepermis.get((int)i).put("if", "2");
								issu = true;
								break;
							}
						}
						if (!issu) {
							{
								HashMap<String, Object> _item = new HashMap<>();
								_item.put("url", _geturl());
								sitepermis.add(_item);
							}
							
							sitepermis.get((int)sitepermis.size() - 1).put("if", "2");
						}
						issu = false;
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", new Gson().toJson(sitepermis));
						_webViewActions(1999, "");
					}
				});
				dlg.create().show();
				return true;
			}
		});
		
		iframe.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("iframeblock", "").equals("0")) {
					iframe.setChecked(true);
					sf.edit().putString("iframeblock", "1").commit();
				}
				else {
					iframe.setChecked(false);
					sf.edit().putString("iframeblock", "0").commit();
				}
			}
		});
		
		swipetore.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				dlg.setTitle(_geturl());
				dlg.setMessage(getString(R.string.swipeexcept));
				dlg.setPositiveButton(getString(R.string.turnon), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						for (int i = 0; i < (int)(sitepermis.size()); i++) {
							if (sitepermis.get((int)i).get("url").toString().equals(_geturl())) {
								sitepermis.get((int)i).put("sr", "1");
								issu = true;
								break;
							}
						}
						if (!issu) {
							{
								HashMap<String, Object> _item = new HashMap<>();
								_item.put("url", _geturl());
								sitepermis.add(_item);
							}
							
							sitepermis.get((int)sitepermis.size() - 1).put("sr", "1");
						}
						issu = false;
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", new Gson().toJson(sitepermis));
						_webViewActions(1999, "");
						_Reopentab();
					}
				});
				dlg.setNegativeButton(getString(R.string.turnoff), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						for (int i = 0; i < (int)(sitepermis.size()); i++) {
							if (sitepermis.get((int)i).get("url").toString().equals(_geturl())) {
								sitepermis.get((int)i).put("sr", "0");
								issu = true;
								break;
							}
						}
						if (!issu) {
							{
								HashMap<String, Object> _item = new HashMap<>();
								_item.put("url", _geturl());
								sitepermis.add(_item);
							}
							
							sitepermis.get((int)sitepermis.size() - 1).put("sr", "0");
						}
						issu = false;
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", new Gson().toJson(sitepermis));
						_webViewActions(1999, "");
						_Reopentab();
					}
				});
				dlg.setNeutralButton(getString(R.string.exdefault), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						for (int i = 0; i < (int)(sitepermis.size()); i++) {
							if (sitepermis.get((int)i).get("url").toString().equals(_geturl())) {
								sitepermis.get((int)i).put("sr", "2");
								issu = true;
								break;
							}
						}
						if (!issu) {
							{
								HashMap<String, Object> _item = new HashMap<>();
								_item.put("url", _geturl());
								sitepermis.add(_item);
							}
							
							sitepermis.get((int)sitepermis.size() - 1).put("sr", "2");
						}
						issu = false;
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", new Gson().toJson(sitepermis));
						_webViewActions(1999, "");
						_Reopentab();
					}
				});
				dlg.create().show();
				return true;
			}
		});
		
		swipetore.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("swipetore", "").equals("0")) {
					swipetore.setChecked(true);
					sf.edit().putString("swipetore", "1").commit();
				}
				else {
					swipetore.setChecked(false);
					sf.edit().putString("swipetore", "0").commit();
				}
				_Reopentab();
			}
		});
		
		dp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				textview5.setText(getString(R.string.qs_uisize).concat(" (").concat(String.valueOf((long)(dp.getProgress() * 10)).concat(")")));
				sf.edit().putString("dp", String.valueOf((long)(_progressValue))).commit();
				if (is1window) {
					        // Знаходимо головний LinearLayout з id "tabscontainer"
					        LinearLayout tabscontainer = findViewById(R.id.tabscontainer);
					
					        // Ініціалізуємо стек для обходу
					        java.util.Stack<ViewGroup> stack = new java.util.Stack<>();
					        stack.push(tabscontainer);
					
					        while (!stack.isEmpty()) {
						            ViewGroup parent = stack.pop();
						
						            // Проходимо по всіх дочірніх елементах parent
						            for (int i = 0; i < parent.getChildCount(); i++) {
							                View child = parent.getChildAt(i);
							
							                if (child instanceof WebView) {
								                    // Якщо дочірній елемент є WebView, виконуємо необхідну команду
								                    WebView webView = (WebView) child;
								
								if (Integer.parseInt(sf.getString("pc","")) == 1) {
										webView.setInitialScale(_progressValue*5);
								}
								else {
										webView.setInitialScale(_progressValue*10);
								}
								            
								                } else if (child instanceof ViewGroup) {
								                    // Якщо дочірній елемент є ViewGroup (наприклад, LinearLayout), додаємо його до стеку для подальшого оброблення
								                    stack.push((ViewGroup) child);
								                }
							            }
						        }
					
				}
				else {
					_webViewActions(20, String.valueOf((long)(_progressValue)));
				}
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		font.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				textview3.setText(getString(R.string.qs_fontsize).concat(" (").concat(String.valueOf((long)(_progressValue * 10)).concat("%)")));
				sf.edit().putString("fontsize", String.valueOf((long)(_progressValue))).commit();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				textview2.setText(getString(R.string.qs_minfont).concat(" (").concat(String.valueOf((long)(_progressValue)).concat(")")));
				sf.edit().putString("minfont", String.valueOf((long)(_progressValue))).commit();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		title.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", title.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Скопійовано!");
			}
		});
		
		copyallurl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				/*
if (!"".equals("about:blank")) {
copy = copy.concat("\n════════\n".concat(""));
}
((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", copy));
copy = "";
*/
			}
		});
		
		multilink.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", dataHolder.getData("ml")));
			}
		});
		
		otherapp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				openInOtherApps(autocomplete1.getText().toString());
			}
		});
		
		themepage.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				dlg.setTitle(_geturl());
				dlg.setMessage(getString(R.string.colexcept).concat(" ("));
				dlg.setPositiveButton(getString(R.string.change), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						for (int i = 0; i < (int)(sitepermis.size()); i++) {
							if (sitepermis.get((int)i).get("url").toString().equals(_geturl())) {
								sitepermis.get((int)i).put("th", "1");
								issu = true;
								break;
							}
						}
						if (!issu) {
							{
								HashMap<String, Object> _item = new HashMap<>();
								_item.put("url", _geturl());
								sitepermis.add(_item);
							}
							
							sitepermis.get((int)sitepermis.size() - 1).put("th", "1");
						}
						issu = false;
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", new Gson().toJson(sitepermis));
						_webViewActions(1999, "");
					}
				});
				dlg.setNegativeButton(getString(R.string.nochange), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						for (int i = 0; i < (int)(sitepermis.size()); i++) {
							if (sitepermis.get((int)i).get("url").toString().equals(_geturl())) {
								sitepermis.get((int)i).put("th", "0");
								issu = true;
								break;
							}
						}
						if (!issu) {
							{
								HashMap<String, Object> _item = new HashMap<>();
								_item.put("url", _geturl());
								sitepermis.add(_item);
							}
							
							sitepermis.get((int)sitepermis.size() - 1).put("th", "0");
						}
						issu = false;
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", new Gson().toJson(sitepermis));
						_webViewActions(1999, "");
					}
				});
				dlg.setNeutralButton(getString(R.string.exdefault), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						for (int i = 0; i < (int)(sitepermis.size()); i++) {
							if (sitepermis.get((int)i).get("url").toString().equals(_geturl())) {
								sitepermis.get((int)i).put("th", "2");
								issu = true;
								break;
							}
						}
						if (!issu) {
							{
								HashMap<String, Object> _item = new HashMap<>();
								_item.put("url", _geturl());
								sitepermis.add(_item);
							}
							
							sitepermis.get((int)sitepermis.size() - 1).put("th", "2");
						}
						issu = false;
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", new Gson().toJson(sitepermis));
						_webViewActions(1999, "");
					}
				});
				dlg.create().show();
				return true;
			}
		});
		
		themepage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("themepage", "").equals("0")) {
					themepage.setChecked(true);
					sf.edit().putString("themepage", "1").commit();
				}
				else {
					sf.edit().putString("themepage", "0").commit();
				}
			}
		});
		
		js.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				dlg.setTitle(_geturl());
				dlg.setMessage(getString(R.string.jsexcept));
				dlg.setPositiveButton(getString(R.string.turnon), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						for (int i = 0; i < (int)(sitepermis.size()); i++) {
							if (sitepermis.get((int)i).get("url").toString().equals(_geturl())) {
								sitepermis.get((int)i).put("js", "1");
								issu = true;
								break;
							}
						}
						if (!issu) {
							{
								HashMap<String, Object> _item = new HashMap<>();
								_item.put("url", _geturl());
								sitepermis.add(_item);
							}
							
							sitepermis.get((int)sitepermis.size() - 1).put("js", "1");
						}
						issu = false;
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", new Gson().toJson(sitepermis));
						_webViewActions(1999, "");
					}
				});
				dlg.setNegativeButton(getString(R.string.turnoff), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						for (int i = 0; i < (int)(sitepermis.size()); i++) {
							if (sitepermis.get((int)i).get("url").toString().equals(_geturl())) {
								sitepermis.get((int)i).put("js", "0");
								issu = true;
								break;
							}
						}
						if (!issu) {
							{
								HashMap<String, Object> _item = new HashMap<>();
								_item.put("url", _geturl());
								sitepermis.add(_item);
							}
							
							sitepermis.get((int)sitepermis.size() - 1).put("js", "0");
						}
						issu = false;
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", new Gson().toJson(sitepermis));
						_webViewActions(1999, "");
					}
				});
				dlg.setNeutralButton(getString(R.string.exdefault), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						for (int i = 0; i < (int)(sitepermis.size()); i++) {
							if (sitepermis.get((int)i).get("url").toString().equals(_geturl())) {
								sitepermis.get((int)i).put("js", "2");
								issu = true;
								break;
							}
						}
						if (!issu) {
							{
								HashMap<String, Object> _item = new HashMap<>();
								_item.put("url", _geturl());
								sitepermis.add(_item);
							}
							
							sitepermis.get((int)sitepermis.size() - 1).put("js", "2");
						}
						issu = false;
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", new Gson().toJson(sitepermis));
						_webViewActions(1999, "");
					}
				});
				dlg.create().show();
				return true;
			}
		});
		
		js.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("js", "").equals("0")) {
					js.setChecked(true);
					sf.edit().putString("js", "1").commit();
				}
				else {
					js.setChecked(false);
					sf.edit().putString("js", "0").commit();
				}
			}
		});
		
		pc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("pc", "").equals("0")) {
					pc.setChecked(true);
					sf.edit().putString("pc", "1").commit();
				}
				else {
					pc.setChecked(false);
					sf.edit().putString("pc", "0").commit();
				}
			}
		});
		
		incognito.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
				
				if (sf.getString("incognito", "").equals("0")) {
					incognito.setChecked(true);
					sf.edit().putString("incognito", "1").commit();
					openpanel.setText("");
					Skin skin = new Skin();
					skin.setBG(openpanel, 1, true);
					openpanel.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
					if (sf.getString("noscreen", "").equals("1")) {
						getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
					}
				}
				else {
					incognito.setChecked(false);
					sf.edit().putString("incognito", "0").commit();
					openpanel.setText("");
					getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
					Skin skin = new Skin();
					skin.setBG(openpanel, 0, true);
					openpanel.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
				}
			}
		});
		
		image.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("loadimages", "").equals("0")) {
					image.setChecked(true);
					sf.edit().putString("loadimages", "1").commit();
					_webViewActions(1998, "");
				}
				else {
					image.setChecked(false);
					sf.edit().putString("loadimages", "0").commit();
				}
			}
		});
		
		blockad.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				dlg.setTitle(_geturl());
				dlg.setMessage(getString(R.string.bladexcept).concat(" ").concat(String.valueOf((long)(adsblockedd)).concat(" ".concat(getString(R.string.ads)))));
				dlg.setPositiveButton(getString(R.string.turnon), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						for (int i = 0; i < (int)(sitepermis.size()); i++) {
							if (sitepermis.get((int)i).get("url").toString().equals(_geturl())) {
								sitepermis.get((int)i).put("ad", "1");
								issu = true;
								break;
							}
						}
						if (!issu) {
							{
								HashMap<String, Object> _item = new HashMap<>();
								_item.put("url", _geturl());
								sitepermis.add(_item);
							}
							
							sitepermis.get((int)sitepermis.size() - 1).put("ad", "1");
						}
						issu = false;
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", new Gson().toJson(sitepermis));
						_webViewActions(1999, "");
					}
				});
				dlg.setNegativeButton(getString(R.string.turnoff), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						for (int i = 0; i < (int)(sitepermis.size()); i++) {
							if (sitepermis.get((int)i).get("url").toString().equals(_geturl())) {
								sitepermis.get((int)i).put("ad", "0");
								issu = true;
								break;
							}
						}
						if (!issu) {
							{
								HashMap<String, Object> _item = new HashMap<>();
								_item.put("url", _geturl());
								sitepermis.add(_item);
							}
							
							sitepermis.get((int)sitepermis.size() - 1).put("ad", "0");
						}
						issu = false;
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", new Gson().toJson(sitepermis));
						_webViewActions(1999, "");
					}
				});
				dlg.setNeutralButton(getString(R.string.exdefault), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						for (int i = 0; i < (int)(sitepermis.size()); i++) {
							if (sitepermis.get((int)i).get("url").toString().equals(_geturl())) {
								sitepermis.get((int)i).put("ad", "2");
								issu = true;
								break;
							}
						}
						if (!issu) {
							{
								HashMap<String, Object> _item = new HashMap<>();
								_item.put("url", _geturl());
								sitepermis.add(_item);
							}
							
							sitepermis.get((int)sitepermis.size() - 1).put("ad", "2");
						}
						issu = false;
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", new Gson().toJson(sitepermis));
						_webViewActions(1999, "");
					}
				});
				dlg.create().show();
				return true;
			}
		});
		
		blockad.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("blockad", "").equals("0")) {
					blockad.setChecked(true);
					sf.edit().putString("blockad", "1").commit();
				}
				else {
					blockad.setChecked(false);
					sf.edit().putString("blockad", "0").commit();
				}
			}
		});
		
		back.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.backbtn));
				return true;
			}
		});
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webViewActions(1, "");
			}
		});
		
		forward.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.forwardbtn));
				return true;
			}
		});
		
		forward.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webViewActions(2, "");
			}
		});
		
		pgup.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.homebtn));
				return true;
			}
		});
		
		pgup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webViewActions(3, "");
			}
		});
		
		pgdn.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.endbtn));
				return true;
			}
		});
		
		pgdn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webViewActions(4, "");
			}
		});
		
		bookmarks.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				dial.setTitle("?");
				dial.setMessage(getString(R.string.wantexit));
				dial.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						finish();
					}
				});
				dial.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				dial.create().show();
				return true;
			}
		});
		
		bookmarks.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), BookmarksActivity.class);
				intent.setData(Uri.parse(autocomplete1.getText().toString()));
				intent.putExtra("n", title.getText().toString());
				intent.putExtra("m", _getMultilink());
				/*
if (is1window) {

}
else {
intent.putExtra("m", "https://multilink.weekbrowser.com/".concat("%%%%%".concat("".concat("%%%%%")).concat("".concat("%%%%%").concat("".concat("%%%%%").concat("".concat("%%%%%").concat("".concat("%%%%%").concat("")))))));
}
*/
				startActivity(intent);
			}
		});
		
		home.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				_webViewActions(10, getFilesDir().getPath().concat("/bookmark.html"));
				return true;
			}
		});
		
		home.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				_webViewActions(10, sf.getString("firstpage", ""));
			}
		});
		
		histori.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.historybtn));
				return true;
			}
		});
		
		histori.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), HistoryActivity.class);
				startActivity(intent);
			}
		});
		
		tabs.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				notFirst = true;
				_newTab(sf.getString("firstpage",""), true);
				((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();
				return true;
			}
		});
		
		tabs.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (linear14.getVisibility() == View.VISIBLE) {
					linear14.setVisibility(View.GONE);
				}
				else {
					linear14.setVisibility(View.VISIBLE);
					tabanim.setTarget(linear14);
					tabanim.setPropertyName("scaleY");
					tabanim.setFloatValues((float)(0), (float)(1));
					tabanim.setDuration((int)(500));
					tabanim.start();
				}
			}
		});
		
		dual.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "В розробці (мало б сховати вікно)");
				return true;
			}
		});
		
		dual.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (is1window) {
					windowpos = new Gson().fromJson(sf.getString("windows", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
					// Ініціалізуємо стек для обходу
					java.util.Stack<ViewGroup> stack = new java.util.Stack<>();
					stack.push(tabscontainer);
					
					while (!stack.isEmpty()) {
						    ViewGroup parent = stack.pop();
						
						    // Проходимо по всіх дочірніх елементах parent
						    for (int h = 0; h < parent.getChildCount(); h++) {
							        View child = parent.getChildAt(h);
							
							        if (child instanceof LinearLayout && child.getTag() != null && child.getTag().toString().startsWith("ll")) {
								            // Якщо дочірній елемент є LinearLayout з тегом, що починається на "ll"
								            LinearLayout linearLayout = (LinearLayout) child;
								
								            // linearLayout
								            linearLayout.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
								linearLayout.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
								((LinearLayout.LayoutParams) linearLayout.getLayoutParams()).weight = 1; // або будь-яке інше значення, яке вам потрібно
								linearLayout.requestLayout();
								linearLayout.setX(0);
								linearLayout.setY(0);
								
								
								        
								_setTopPadding(linearLayout, 0);
							} else if (child instanceof ViewGroup) {
								            // Якщо дочірній елемент є ViewGroup (наприклад, LinearLayout), додаємо його до стеку для подальшого оброблення
								            stack.push((ViewGroup) child);
								        }
							    }
					}
					
					windowsmanager.setVisibility(View.GONE);
					is1window = false;
					sf.edit().putString("windows", new Gson().toJson(windowpos)).commit();
				}
				else {
					is1window = true;
					_restorewindowparam();
					windowpos = new Gson().fromJson(sf.getString("windows", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
					sf.edit().putString("windows", new Gson().toJson(windowpos)).commit();
				}
				/*
LinearLayout tabscontainer = findViewById(R.id.tabscontainer);

        // Ініціалізуємо стек для обходу
        java.util.Stack<ViewGroup> stack = new java.util.Stack<>();
        stack.push(tabscontainer);

        while (!stack.isEmpty()) {
            ViewGroup parent = stack.pop();

            // Проходимо по всіх дочірніх елементах parent
            for (int h = 0; h < parent.getChildCount(); h++) {
                View child = parent.getChildAt(h);

                if (child instanceof WebView) {
                    // Якщо дочірній елемент є WebView, виконуємо необхідну команду
                    WebView webView = (WebView) child;
    
            //webView
            
     
               
if (Integer.parseInt(sf.getString("pc", "")) == 1) {
webView.setInitialScale((int)Integer.parseInt(sf.getString("dp",""))*5);
}
else {
webView.setInitialScale((int)Integer.parseInt(sf.getString("dp",""))*10);
}
 } else if (child instanceof ViewGroup) {
                    // Якщо дочірній елемент є ViewGroup (наприклад, LinearLayout), додаємо його до стеку для подальшого оброблення
                    stack.push((ViewGroup) child);
                }
            }
        }
    
*/
				_Reopentab();
			}
		});
		
		skipvideo.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.skipvidbtn));
				return true;
			}
		});
		
		skipvideo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webViewActions(10, "javascript:(function() {     var videos = document.querySelectorAll('video, [src*=\".mp4\"], [src*=\".webm\"], [src*=\".ogv\"], [type*=\"video\"]');     for (var i = 0; i < videos.length; i++) {         var video = videos[i];         if (typeof video.currentTime !== 'undefined') {             video.currentTime = 65535;         }     } })();");
			}
		});
		
		pagesearch.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.searchonpagebtn));
				return true;
			}
		});
		
		pagesearch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (searchpan.getVisibility() == View.GONE) {
					searchpan.setVisibility(View.VISIBLE);
					srhanim.setTarget(searchpan);
					srhanim.setPropertyName("alpha");
					srhanim.setFloatValues((float)(0), (float)(1));
					srhanim.setDuration((int)(500));
					srhanim.start();
					_webViewActions(30, search.getText().toString());
				}
				else {
					searchpan.setVisibility(View.GONE);
					_webViewActions(30, "");
				}
			}
		});
		
		coordinates.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.positionbtn));
				return true;
			}
		});
		
		coordinates.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (linear9.getVisibility() == View.VISIBLE) {
					linear9.setVisibility(View.GONE);
				}
				else {
					linear9.setVisibility(View.VISIBLE);
					position.setTarget(linear9);
					position.setPropertyName("alpha");
					position.setFloatValues((float)(0), (float)(1));
					position.setDuration((int)(500));
					position.start();
					if (!posshow) {
						pos1.setText("(".concat(sf.getString("pos1x", "").concat("; ".concat(sf.getString("pos1y", "").concat(")")))));
						pos2.setText("(".concat(sf.getString("pos2x", "").concat("; ".concat(sf.getString("pos2y", "").concat(")")))));
						pos3.setText("(".concat(sf.getString("pos3x", "").concat("; ".concat(sf.getString("pos3y", "").concat(")")))));
						posshow = true;
					}
				}
			}
		});
		
		search.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				_webViewActions(30, _charSeq);
				/*
webview1.findAll(_charSeq);
curnum = 1;
*/
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		//OnTouch
		sup.setOnTouchListener(new View.OnTouchListener(){
				@Override
				public boolean onTouch(View v, MotionEvent event){
						int ev = event.getAction();
						switch (ev) {
								case MotionEvent.ACTION_DOWN:
								
								 _webViewActions(31, "");
								
								break;
								case MotionEvent.ACTION_UP:
								
								 
								
								break;
						} return true;
				}
		});
		
		//OnTouch
		sdown.setOnTouchListener(new View.OnTouchListener(){
				@Override
				public boolean onTouch(View v, MotionEvent event){
						int ev = event.getAction();
						switch (ev) {
								case MotionEvent.ACTION_DOWN:
								
								 _webViewActions(32, "");
								
								break;
								case MotionEvent.ACTION_UP:
								
								 
								
								break;
						} return true;
				}
		});
		
		autocomplete1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				autocomplete1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, srcsug));
				if (_charSeq.replace(prevCharSeq, "").equals("\n")) {
					button1.performClick();
				}
				prevCharSeq = _charSeq;
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		hide.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				autocomplete1.setText(autocomplete1.getText().toString().replaceAll("", ""));
				_webViewActions(10, autocomplete1.getText().toString());
				return true;
			}
		});
		
		hide.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear1.setVisibility(View.GONE);
				linear5.setVisibility(View.GONE);
				SafeMarginUtils.setFullscreenMode(MainActivity.this, 2);
				isnotchfullscreen = true;
			}
		});
		
		refresh.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webViewActions(5, "");
			}
		});
		
		button1.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				autocomplete1.setText(autocomplete1.getText().toString().replaceAll("", ""));
				return true;
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (autocomplete1.getText().toString().startsWith("javascript:")||autocomplete1.getText().toString().contains(".")) {
					URL = autocomplete1.getText().toString();
					if (URL.startsWith("https://extensions.weekbrowser.com")||URL.startsWith("https://skins.weekbrowser.com")||URL.startsWith("https://bmkskins.weekbrowser.com")||URL.startsWith("https://multilink2.weekbrowser.com")) {
						intent.setClass(getApplicationContext(), IntentActivity.class);
						intent.setData(Uri.parse(URL));
						startActivity(intent);
						closeeditor.performClick();
						prevCharSeq = "";
					}
					else {
						_webViewActions(10, URL);
						closeeditor.performClick();
						prevCharSeq = "";
					}
				}
				else {
					if (sf.getString("searchengine", "").equals("0")) {
						URL = "https://www.google.com/search?q=".concat(autocomplete1.getText().toString());
					}
					if (sf.getString("searchengine", "").equals("1")) {
						URL = "https://www.bing.com/search?q=".concat(autocomplete1.getText().toString());
					}
					if (sf.getString("searchengine", "").equals("2")) {
						URL = "https://search.yahoo.com/search?p=".concat(autocomplete1.getText().toString());
					}
					if (sf.getString("searchengine", "").equals("3")) {
						URL = "https://duckduckgo.com/?t=h_&q=".concat(autocomplete1.getText().toString());
					}
					if (sf.getString("incognito", "").equals("0")) {
						srcsug = new Gson().fromJson(sf.getString("search", ""), new TypeToken<ArrayList<String>>(){}.getType());
						srcsug.add(autocomplete1.getText().toString().trim());
						Set<String> uniqueValues = new LinkedHashSet<>(srcsug);
						        srcsug.clear();
						        srcsug.addAll(uniqueValues);
						sf.edit().putString("search", new Gson().toJson(srcsug)).commit();
						_srhupd();
					}
					_webViewActions(10, URL);
					closeeditor.performClick();
					prevCharSeq = "";
				}
			}
		});
		
		openpanel.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.quicksettingsbtn));
				return true;
			}
		});
		
		openpanel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (settingspanel.getVisibility() == View.VISIBLE) {
					settingspanel.setVisibility(View.GONE);
					if (Integer.parseInt(sf.getString("navpan", "")) == 0) {
						linear5.setVisibility(View.GONE);
					}
				}
				else {
					settingspanel.setVisibility(View.VISIBLE);
					linear5.setVisibility(View.VISIBLE);
					anim.setTarget(settingspanel);
					anim.setPropertyName("scaleY");
					anim.setFloatValues((float)(0), (float)(1));
					anim.setDuration((int)(500));
					anim.start();
					if (Integer.parseInt(sf.getString("navpan", "")) == 0) {
						anim2.setTarget(linear5);
						anim2.setPropertyName("alpha");
						anim2.setFloatValues((float)(0), (float)(1));
						anim2.setDuration((int)(500));
						anim2.start();
					}
				}
			}
		});
		
		button3.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.settingsbtn));
				return true;
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), SettingsActivity.class);
				startActivity(intent);
			}
		});
		
		closeeditor.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.closebtn));
				return true;
			}
		});
		
		closeeditor.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (kbd) {
					SketchwareUtil.hideKeyboard(getApplicationContext());
				}
				holdsearchtext = false;
				prevCharSeq = "";
				search.requestFocus();
			}
		});
		
		copyurl.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copybtn));
				return true;
			}
		});
		
		copyurl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", autocomplete1.getText().toString()));
			}
		});
		
		pasteurl.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.pastebtn));
				return true;
			}
		});
		
		pasteurl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
				
				// Перевіряємо, чи є в буфері дані
				if (clipboard.hasPrimaryClip()) {
					    ClipData clip = clipboard.getPrimaryClip();
					    if (clip != null && clip.getItemCount() > 0) {
						        // Отримуємо текст з буфера
						        CharSequence textToPaste = clip.getItemAt(0).getText();
						        // Встановлюємо текст в AutoCompleteTextView
						        autocomplete1.setText(textToPaste);
						    }
				}
			}
		});
		
		pastegourl.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.pastesearchbtn));
				return true;
			}
		});
		
		pastegourl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				pasteurl.performClick();
				button1.performClick();
			}
		});
		
		selall.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.selallbtn));
				return true;
			}
		});
		
		selall.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				autocomplete1.requestFocus();
				((EditText)autocomplete1).selectAll();
			}
		});
		
		cururl.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.geturlbtn));
				return true;
			}
		});
		
		cururl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webViewActions(0, "");
			}
		});
		
		pos1.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				_webViewActions(301, "");
				return true;
			}
		});
		
		pos1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webViewActions(401, "");
			}
		});
		
		pos2.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				_webViewActions(302, "");
				return true;
			}
		});
		
		pos2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webViewActions(402, "");
			}
		});
		
		pos3.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				_webViewActions(303, "");
				return true;
			}
		});
		
		pos3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webViewActions(403, "");
			}
		});
		
		anim2.addListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator _param1) {
				
			}
			
			@Override
			public void onAnimationEnd(Animator _param1) {
				
			}
			
			@Override
			public void onAnimationCancel(Animator _param1) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animator _param1) {
				
			}
		});
		
		searchpan2.addListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator _param1) {
				
			}
			
			@Override
			public void onAnimationEnd(Animator _param1) {
				
			}
			
			@Override
			public void onAnimationCancel(Animator _param1) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animator _param1) {
				
			}
		});
	}
	
	private void initializeLogic() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		SafeMarginUtils.init(this, findViewById(android.R.id.content));
		
		Skin skin = new Skin();
		skin.colorToRam(this);
		//autocomplete1.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
		
		autocomplete1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			    @Override
			    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				        if (actionId == EditorInfo.IME_ACTION_SEARCH ||
				            actionId == EditorInfo.IME_ACTION_DONE ||
				            actionId == EditorInfo.IME_ACTION_NEXT ||
				            actionId == EditorInfo.IME_NULL) { // IME_NULL може бути використаний для Enter на деяких клавіатурах
					            button1.performClick();
					            return true; // Сигналізуємо, що подія оброблена
					        }
				        return false;
				    }
		});
		
		autocomplete1.setOnKeyListener(new View.OnKeyListener() {
			    @Override
			    public boolean onKey(View v, int keyCode, KeyEvent event) {
				        if (event.getAction() == KeyEvent.ACTION_DOWN && 
				            (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_DPAD_CENTER)) {
					            if (!event.isShiftPressed()) {
						                button1.performClick();
						                return true; // Сигналізуємо, що подія оброблена
						            }
					        }
				        return false;
				    }
		});
		
		_fonts();
		searchpan.setVisibility(View.GONE);
		linear9.setVisibility(View.GONE);
		linear14.setVisibility(View.GONE);
		windowsmanager.setVisibility(View.GONE);
		button1.setVisibility(View.GONE);
		linear16.setVisibility(View.GONE);
		srhhis.setVisibility(View.GONE);
		sitepermis = new Gson().fromJson(FileUtil.readFile(getFilesDir().getPath()+"/sitepermis.json"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		history = new Gson().fromJson(FileUtil.readFile(getFilesDir().getPath()+"/history.json"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		if (sf.getString("incognito", "").equals("1")) {
			sf.edit().putString("tabs", "[{\"name\":\"home\", \"url\"=\"".concat(sf.getString("firstpage", "").concat("\"}]"))).commit();
			sf.edit().putString("activetab", "0").commit();
			sf.edit().putString("incognito", "0").commit();
		}
		info = "";
		textview1.setText(info);
		_clearonexit();
		_settabswindow();
		_restorewindowparam();
		tab = new Gson().fromJson(sf.getString("tabs", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		srcsug = new Gson().fromJson(sf.getString("search", ""), new TypeToken<ArrayList<String>>(){}.getType());
		srhhis.setAdapter(new SrhhisAdapter(srhbuf));
		_srhupd();
		for (HashMap<String, Object> map : tab) {
			            map.remove("tab");
			            map.remove("time");
			        }
		if (Integer.parseInt(sf.getString("activetab", "")) > (tab.size() - 1)) {
			sf.edit().putString("activetab", String.valueOf((long)(tab.size() - 1))).commit();
		}
		            T++;
		    Tt++;
		    time++;
		    tabs.setText("[" + tab.size() + "]•");
		
		  //  if (notFirst) {
		     //   int currentActive_dataIndex = _data.size() + 1;
		        int _position = Integer.parseInt(sf.getString("activetab", ""));
		
		        // Перевірка розміру списку перед доступом
		 tab.get(_position).put("tab", Tt);
		tab.get(_position).put("time", time);
		
		
		    
		 //   notFirst = true;
		
		    LinearLayout newWebViewContainer = new LinearLayout(MainActivity.this);
		    newWebViewContainer.setTag("ll" + String.valueOf(Tt));
		    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
		            ViewGroup.LayoutParams.MATCH_PARENT,
		            ViewGroup.LayoutParams.MATCH_PARENT
		    );
		    layoutParams.weight = 1; // Встановлення ваги
		    newWebViewContainer.setLayoutParams(layoutParams);
		
		    WebView newWebView = new WebView(MainActivity.this);
		newWebView.getSettings().setJavaScriptEnabled(true);
		    setupWebView(newWebView, MainActivity.this);
		
		    newWebView.loadUrl(tab.get((int) _position).get("url").toString());  // Завантаження початкового URL для нової вкладки
		
		    newWebViewContainer.addView(newWebView, new LinearLayout.LayoutParams(
		            ViewGroup.LayoutParams.MATCH_PARENT,
		            ViewGroup.LayoutParams.MATCH_PARENT
		    ));
		
		    tabscontainer.addView(newWebViewContainer);
		
		_Reopentab();
		tabscont.setAdapter(new TabscontAdapter(tab));
		font.setProgress((int)Integer.parseInt(sf.getString("fontsize", "")));
		seekbar1.setProgress((int)Integer.parseInt(sf.getString("minfont", "")));
		dp.setProgress((int)Integer.parseInt(sf.getString("dp", "")));
		textview5.setText(getString(R.string.qs_uisize).concat(" (").concat(String.valueOf((long)(dp.getProgress() * 10)).concat(")")));
		textview3.setText(getString(R.string.qs_fontsize).concat(" (").concat(String.valueOf((long)(font.getProgress() * 10)).concat("%)")));
		textview2.setText(getString(R.string.qs_minfont).concat(" (").concat(String.valueOf((long)(seekbar1.getProgress())).concat(")")));
		settingspanel.setVisibility(View.GONE);
		((EditText)autocomplete1).setMaxLines((int)1);
		((EditText)search).setMaxLines((int)3);
		if (sf.getString("blockad", "").equals("1")) {
			blockad.setChecked(true);
		}
		else {
			blockad.setChecked(false);
		}
		if (sf.getString("iframeblock", "").equals("1")) {
			iframe.setChecked(true);
		}
		else {
			iframe.setChecked(false);
		}
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (Foreground) {
							_loading();
							num.setText(String.valueOf((long)(curnum)).concat("/".concat(String.valueOf((long)(allnum)))));
							if (ticks%20 == 0) {
								        // Знаходимо головний LinearLayout з id "tabscontainer"
								        LinearLayout tabscontainer = findViewById(R.id.tabscontainer);
								
								        // Ініціалізуємо стек для обходу
								        java.util.Stack<ViewGroup> stack = new java.util.Stack<>();
								        stack.push(tabscontainer);
								
								        while (!stack.isEmpty()) {
									            ViewGroup parent = stack.pop();
									
									            // Проходимо по всіх дочірніх елементах parent
									            for (int h = 0; h < parent.getChildCount(); h++) {
										                View child = parent.getChildAt(h);
										
										                if (child instanceof WebView) {
											                    // Якщо дочірній елемент є WebView, виконуємо необхідну команду
											                    WebView webView = (WebView) child;
											    
											            _setAll(webView);
											            
											     
											                } else if (child instanceof ViewGroup) {
											                    // Якщо дочірній елемент є ViewGroup (наприклад, LinearLayout), додаємо його до стеку для подальшого оброблення
											                    stack.push((ViewGroup) child);
											                }
										            }
									        }
								    
								new Thread(new Runnable() {
									            @Override
									            public void run() {
										                    // Виконання фонової роботи
										                   
										try {
											        int timeoutMs = 3000;
											        Socket sock = new Socket();
											        SocketAddress sockaddr = new InetSocketAddress("8.8.8.8", 53);
											
											        sock.connect(sockaddr, timeoutMs);
											        sock.close();
											
											        Internet=false;
											    } catch (IOException e) {Internet=true;}
										
										
										            }
									        }).start();
								_webViewActions(1999, "");
							}
							if (ticks%20 == 0) {
								if (statush) {
									getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_FULLSCREEN
									        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
									        | View.SYSTEM_UI_FLAG_IMMERSIVE);
									isnotchfullscreen = true;
								}
								new Thread(new Runnable() {
									            @Override
									            public void run() {
										                    // Виконання фонової роботи
										                   
										
										                Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
										                Debug.getMemoryInfo(memoryInfo);
										
										                // Використовувана пам'ять в KB
										                int usedMemory = memoryInfo.getTotalPss();
										
										                // Перетворення в MB
										                usedMemoryMB = usedMemory / 1024;
										
										                memoryUsageText = "UsedRAM: " + usedMemoryMB + "MB";
										                
										          //      publishProgress(memoryUsageText);
										
										                
										            
										
										
										            }
									        }).start();
								if (sf.getString("usedram", "").equals("1")) {
									ramuse.setText(memoryUsageText);
								}
							}
							if (!focused) {
								if (!ismovedpanels) {
									if (sf.getString("navpanpos", "").equals("1")) {
										linear2.removeView(linear14);
										    linear2.addView(linear14, 0);
										
										linear2.removeView(searchpan);
										    linear2.addView(searchpan, 0);
										
										linear2.removeView(linear9);
										    linear2.addView(linear9, 0);
										
										linear2.removeView(nav);
										    linear2.addView(nav, 0);
									}
									else {
										linear2.removeView(linear14);
										    linear2.addView(linear14);
										
										linear2.removeView(linear9);
										    linear2.addView(linear9);
										
										linear2.removeView(nav);
										    linear2.addView(nav);
										
										linear2.removeView(searchpan);
										    linear2.addView(searchpan);
									}
									if (sf.getString("searchpanelpos", "").equals("1")) {
										linear2.removeView(srhhis);
										    linear2.addView(srhhis, 0);
										
										linear2.removeView(settingspanel);
										    linear2.addView(settingspanel, 0);
										
										linear2.removeView(linear1);
										    linear2.addView(linear1, 0);
										
										linear2.removeView(hscroll1);
										    linear2.addView(hscroll1, 0);
									}
									else {
										linear2.removeView(srhhis);
										    linear2.addView(srhhis);
										
										linear2.removeView(settingspanel);
										    linear2.addView(settingspanel);
										
										linear2.removeView(linear1);
										    linear2.addView(linear1);
										
										linear2.removeView(hscroll1);
										    linear2.addView(hscroll1);
									}
								}
								ismovedpanels = true;
							}
						}
						if (ticks%20 == 0) {
							_ramoptimizer();
						}
						ticks++;
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(149), (int)(150));
		_swipe();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		super.onActivityResult(_requestCode, _resultCode, _data);
				
				switch (_requestCode) {
							case 101:
							if (_resultCode == Activity.RESULT_OK) {
										ArrayList<String> _filePath = new ArrayList<>();
										if (_data != null) {
													if (_data.getClipData() != null) {
																for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
																			ClipData.Item _item = _data.getClipData().getItemAt(_index);
																			_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
																}
													}
													else {
																_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
													}
										}
							}
							break;
							
							case REQUEST_SELECT_FILE:
							if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
										if (uploadMessage == null) return; uploadMessage.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(_resultCode, _data)); uploadMessage = null; }
							break;
							
							case FILECHOOSER_RESULTCODE:
							if (null == mUploadMessage){
										return; }
							Uri result = _data == null || _resultCode != RESULT_OK ? null : _data.getData(); mUploadMessage.onReceiveValue(result);
							mUploadMessage = null;
							
							if (true){
							}
							else {
										
							}
							break;
							default:
							break;
				}
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		_webViewActions(100001, "");
	}
	
	@Override
	public void onResume() {
		super.onResume();
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		final SharedPreferences sf2 = getSharedPreferences("code", Context.MODE_PRIVATE);
		Skin skin = new Skin();
		if(nf)skin.colorToRam(this);
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		/*bml5.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));bml4.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));bml3.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));bml2.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));*/	multilink.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		 
		 Colorify.setSeekBarColors(seekbar1, Color.parseColor("#" + dataHolder.getData("tpc")), Color.parseColor("#" + dataHolder.getData("tc")));           
		 Colorify.setSeekBarColors(dp, Color.parseColor("#" + dataHolder.getData("tpc")), Color.parseColor("#" + dataHolder.getData("tc")));           
		 Colorify.setSeekBarColors(font, Color.parseColor("#" + dataHolder.getData("tpc")), Color.parseColor("#" + dataHolder.getData("tc")));           
		            
		            Colorify.setButtonColor(pc, Color.parseColor("#" + dataHolder.getData("cb")));pc.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
					
					title.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		otherapp.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		selall.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		closeall.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		closeeditor.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		blockad.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		num.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		iframe.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		
		Colorify.setButtonColor(image, Color.parseColor("#" + dataHolder.getData("cb")));
		image.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
					js.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		            Colorify.setButtonColor(incognito, Color.parseColor("#" + dataHolder.getData("cb")));
				incognito.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		        add.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					back.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		hide.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					forward.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		pagesearch.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		copyurl.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		pasteurl.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		pastegourl.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		copyallurl.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		sup.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		sdown.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					pgup.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		refresh.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					pgdn.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					home.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		tabs.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					dual.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					histori.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					skipvideo.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					autocomplete1.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		search.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		textview2.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
					textview5.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
					textview3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
					autocomplete1.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		search.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
					refresh.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					button1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					    if(sf.getString("incognito","").equals("1")){openpanel.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));}else{openpanel.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			                        }
					bookmarks.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					button3.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					textview1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		coordinates.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		pos1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		pos2.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		pos3.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					
					
					
		
		
		/*
bml1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));*/
		
		
		
		
		widthp1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		
		widthm1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		
		heightp1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		
		heightm1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		
		cururl.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		
		// Приклад використання класу Skin для встановлення фонів
		
		skin.setBG(heightm1, 0, true);
		skin.setBG(selall, 0, true);
		skin.setBG(back, 0, true);
		skin.setBG(heightp1, 0, true);
		skin.setBG(widthm1, 0, true);
		skin.setBG(widthp1, 0, true);
		/*skin.setBG(bml1, 0, false);
skin.setBG(bml2, 0, false);
skin.setBG(bml3, 0, false);
skin.setBG(bml4, 0, false);
skin.setBG(bml5, 0, false);*/
		skin.setBG(pos1, 0, false);
		skin.setBG(pos2, 0, false);
		skin.setBG(pos3, 0, false);
		skin.setBG(skipvideo, 0, true);
		skin.setBG(hide, 0, true);
		skin.setBG(button1, 0, true);
		
		if(sf.getString("incognito","").equals("1")) {
			    skin.setBG(openpanel, 1, true);
		} else {
			    skin.setBG(openpanel, 0, true);
		}
		
		skin.setBG(button3, 0, true);
		skin.setBG(refresh, 0, true);
		skin.setBG(coordinates, 0, true);
		skin.setBG(pgup, 0, true);
		skin.setBG(pgdn, 0, true);
		skin.setBG(bookmarks, 0, true);
		skin.setBG(home, 0, true);
		skin.setBG(histori, 0, true);
		skin.setBG(tabs, 0, true);
		skin.setBG(dual, 0, true);
		skin.setBG(textview1, 0, false);
		skin.setBG(copyallurl, 0, false);
		skin.setBG(pagesearch, 0, true);
		skin.setBG(sup, 0, true);
		skin.setBG(sdown, 0, true);
		skin.setBG(forward, 0, true);
		skin.setBG(multilink, 0, false);
		skin.setBG(otherapp, 0, false);
		skin.setBG(add, 0, false);
		skin.setBG(closeall, 1, false);
		skin.setBG(closeeditor, 1, true);
		skin.setBG(copyurl, 0, true);
		skin.setBG(pasteurl, 0, true);
		skin.setBG(pastegourl, 0, true);
		skin.setBG(cururl, 0, true);
		
		       
		  /*          skin.setBG(tabscontainer, 2, true);
            skin.setBG(tabscont, 2, true);
            skin.setBG(windowsmanager, 2, true);
            skin.setBG(settingspanel, 2, true);
            skin.setBG(srhhis, 2, true);
            skin.setBG(nav, 2, true);
            skin.setBG(searchpan, 2, true);
            skin.setBG(linear1, 2, true);
            */
		            
		            skin.setBG(linear2, 2, true);
		if (sf.getString("monoforta", "").equals("1")) {
			autocomplete1.setTypeface(Typeface.MONOSPACE);
			search.setTypeface(Typeface.MONOSPACE);
		}
		else {
			autocomplete1.setTypeface(Typeface.DEFAULT);
			search.setTypeface(Typeface.DEFAULT);
		}
		sitepermis = new Gson().fromJson(FileUtil.readFile(getFilesDir().getPath()+"/sitepermis.json"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		if (sf.getString("js", "").equals("1")) {
			js.setChecked(true);
		}
		if (sf.getString("usedram", "").equals("0")) {
			ramuse.setVisibility(View.GONE);
		}
		else {
			ramuse.setVisibility(View.VISIBLE);
		}
		if (!(sf.getString("incognito", "").equals("1") && sf.getString("noscreen", "").equals("1"))) {
			getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
		}
		if (dataHolder.getData("idtxt")!=null) {
			_webViewActions(10, "javascript:(function() {var textField = document.getElementById('".concat(dataHolder.getData("idtxt")).concat("');\n					    if(textField) {\n					    textField.value = '".concat(dataHolder.getData("txt").concat("';\n					    }})();"))));
			dataHolder.setData("idtxt", null);
			dataHolder.setData("txt", null);
		}
		if ((dataHolder.getData("safe")==null || !dataHolder.getData("safe").equals("1")) && (sf2.contains("en") && (sf2.getString("en", "").equals("2") || (sf2.getString("en", "").equals("1") && sf.getString("incognito", "").equals("1"))))) {
			intent.setClass(getApplicationContext(), LockActivity.class);
			startActivity(intent);
		}
		else {
			dataHolder.setData("safe", "0");
		}
		Foreground = true;
		synchronized(tab) {
			if (dataHolder.getData("url")!=null) {
				if (dataHolder.getData("bgtab")==null && dataHolder.getData("sametab")==null) {
					_newTab(dataHolder.getData("url"), true);
				}
				if (dataHolder.getData("bgtab")==null && dataHolder.getData("sametab")!=null) {
					_webViewActions(10, dataHolder.getData("url"));
				}
				if (dataHolder.getData("bgtab")!=null && dataHolder.getData("sametab")==null) {
					_newTab(dataHolder.getData("url"), false);
				}
				sf.edit().putString("tabs", new Gson().toJson(tab)).commit();
				dataHolder.setData("bgtab", null);
				dataHolder.setData("sametab", null);
				dataHolder.setData("url", null);
				tabscont.setAdapter(new TabscontAdapter(tab));
				((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();
				_Reopentab();
			}
		}
		themebml = JSutil.replaceInstruction("javascript:(function(){var n=function(w){(function(d){var bg='$bggrad$';var btn='$buttongrad$';var btnFocus='$redgrad$';var text='$coltext$';var inputText='$colfield$';var border='$coladd$';var link='$colcomp$';var linkVisited='$coltrack$';var linkHover='$colthumb$';var inputBorder='$coladd$';var focusOutline='$colhint$';var focusBg='#00000000';var focusBorder='$coladd$';var scrollBase='$colhint$';var scrollFace='$colthumb$';var scrollShadow='$colcomp$';var scrollDarkShadow='$coladd$';var scrollTrack='$coltrack$';var scrollArrow='$coltext$';var scroll3dLight='$colhint$';var btnText='$colbtxt$';var btnFocusText='$colrbtxt$';var borderRadius='$buttonround$';var css=`html{background:${bg}!important}html *{background:none!important;color:${text}!important;border-color:${border}!important;border-width:0!important;border-radius:${borderRadius}!important}html a,html a *{color:${link}!important;text-decoration:underline!important}html a:visited,html a:visited *,html a:active,html a:active *{color:${linkVisited}!important}html a:hover,html a:hover *{color:${text}!important;background:${linkHover}!important}html input,html select,html button,html textarea{background:transparent!important;color:${inputText}!important;border:1px solid ${inputBorder}!important;border-radius:${borderRadius}!important}html input[type=button],html input[type=submit],html input[type=reset],html input[type=image],html button{background:${btn}!important;color:${btnText}!important;border:none!important}html input:focus,html select:focus,html option:focus,html button:focus,html textarea:focus{background:${focusBg}!important;color:${inputText}!important;border-color:${focusBorder}!important;outline:2px solid ${focusOutline}!important}html input[type=button]:focus,html input[type=submit]:focus,html input[type=reset]:focus,html input[type=image]:focus,html button:focus{background:${btnFocus}!important;color:${btnFocusText}!important;border:none!important}html input[type=radio]{background:none!important;border-color:${focusBorder}!important;border-width:0!important}html img[src],html input[type=image]{opacity:.9!important}html img[src]:hover,html input[type=image]:hover{opacity:1!important}html,html body{scrollbar-base-color:${scrollBase}!important;scrollbar-face-color:${scrollFace}!important;scrollbar-shadow-color:${scrollShadow}!important;scrollbar-darkshadow-color:${scrollDarkShadow}!important;scrollbar-track-color:${scrollTrack}!important;scrollbar-arrow-color:${scrollArrow}!important;scrollbar-3dlight-color:${scroll3dLight}!important}html span,html p,html div,html a{color:${text}!important}html button svg,html button svg path{fill:${btnText}!important}html button *{color:${btnText}!important}`;var s=d.getElementsByTagName('style');for(var i=0,si;si=s[i];i++){if(si.innerHTML==css){return}}var heads=d.getElementsByTagName('head');if(heads.length){var node=d.createElement('style');node.type='text/css';node.appendChild(d.createTextNode(css));heads[0].appendChild(node)}})(w.document);for(var i=0,f;f=w.frames[i];i++){try{arguments.callee(f)}catch(e){}}};n(window)})();"
		) ;
		designbmlcache = "javascript:(function() {" +
		        "document.charset = 'utf-8';" + // Примусове використання кодування utf-8
		
		        // Створення фону для суцільного кольору
		        "var colorDiv = document.createElement('div');" +
		        "colorDiv.style.position = 'fixed';" +
		        "colorDiv.style.top = '0';" +
		        "colorDiv.style.left = '0';" +
		        "colorDiv.style.width = '100%';" +
		        "colorDiv.style.height = '100%';" +
		        "colorDiv.style.backgroundColor = '" + sf.getString("cssbgcol", "#FFFFFF") + "';" +
		        "colorDiv.style.zIndex = '-2';" +
		        "document.body.appendChild(colorDiv);" +
		
		        // Створення фону для зображення
		        "var imageDiv = document.createElement('div');" +
		        "imageDiv.style.position = 'fixed';" +
		        "imageDiv.style.top = '0';" +
		        "imageDiv.style.left = '0';" +
		        "imageDiv.style.width = '100%';" +
		        "imageDiv.style.height = '100%';" +
		        "imageDiv.style.backgroundImage = 'url(" + sf.getString("cssbg", "") + ")';" +
		        "imageDiv.style.backgroundSize = '" + sf.getString("cssbgsize", "cover") + "';" +
		        "imageDiv.style.filter = 'blur(" + sf.getString("cssbgblur", "0") + "px) " +
		            "invert(" + sf.getString("cssbginvert", "0") + ") " +
		            "contrast(" + sf.getString("cssbgcontr", "100%") + ") " +
		            "brightness(" + sf.getString("cssbgbright", "100%") + ") " +
		            "sepia(" + sf.getString("cssbgsepia", "0%") + ") " +
		            "hue-rotate(" + sf.getString("cssbghue", "0") + "deg) " +
		            "saturate(" + sf.getString("cssbgsatur", "100%") + ") " +
		            "opacity(" + sf.getString("cssbgopacity", "100%") + ")';" +
		        "imageDiv.style.mixBlendMode = '" + sf.getString("cssbgblend", "normal") + "';" +
		        "imageDiv.style.zIndex = '-1';" +
		        "document.body.appendChild(imageDiv);" +
		
		        // Застосування стилів до елементів <font>
		        "var contentElements = document.querySelectorAll('font');" +
		        "contentElements.forEach(function(element) {" +
		            "element.style.lineHeight = '" + sf.getString("csstextline", "1.5") + "';" +
		            "element.style.fontFamily = '" + sf.getString("csstextfont", "Arial") + "';" +
		            "element.style.fontSize = '" + sf.getString("csstextsize", "16") + "px';" +
		            "element.style.fontWeight = '" + sf.getString("csstextweight", "normal") + "';" +
		            "element.style.textTransform = '" + sf.getString("csstexttrans", "none") + "';" +
		            "element.style.fontStyle = '" + sf.getString("csstextstyle", "normal") + "';" +
		            "element.style.filter = 'blur(" + sf.getString("csstextblur", "0") + "px) " +
		                "invert(" + sf.getString("csstextinvert", "0") + ") " +
		                "contrast(" + sf.getString("csstextcontr", "100%") + ") " +
		                "brightness(" + sf.getString("csstextbright", "100%") + ") " +
		                "sepia(" + sf.getString("csstextsepia", "0%") + ") " +
		                "hue-rotate(" + sf.getString("csstexthue", "0") + "deg) " +
		                "saturate(" + sf.getString("csstextsatur", "100%") + ") " +
		                "opacity(" + sf.getString("csstextopacity", "100%") + ")';" +
		            "element.style.textShadow = '" + sf.getString("csstextshadowx", "0") + "px " +
		                sf.getString("csstextshadowy", "0") + "px " +
		                sf.getString("csstextshadowb", "0") + "px #" +
		                sf.getString("csstextshadowc", "000000") + "';" +
		            "element.style.mixBlendMode = '" + sf.getString("csstextblend", "normal") + "';" +
		            "element.style.border = '" + sf.getString("csstextbordersize", "0") + "px " +
		                sf.getString("csstextborderstyle", "none") + " #" +
		                sf.getString("csstextbordercolor", "000000") + "';" +
		            "element.style.webkitTextStroke = '" + sf.getString("csstextstrokesize", "0") + "px #" +
		                sf.getString("csstextstrokecolor", "000000") + "';" +
		        "});" +
		
		        // Стилі для body
		        "document.body.style.border = '" + sf.getString("cssbgstrokesize", "0") + "px " +
		            sf.getString("cssbgstrokestyle", "none") + " #" +
		            sf.getString("cssbgstrokecolor", "000000") + "';" +
		        "document.body.style.textAlign = '" + sf.getString("csstextalign", "left") + "';" +
		    "})();";
		ismovedpanels = false;
		isnotchfullscreen = false;
		nf = true;
		_buttonsizeset();
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
		
		linear1.setVisibility(View.VISIBLE);
		if (sf.getString("infotext", "").equals("1")) {
			textview1.setGravity(Gravity.CENTER_HORIZONTAL);
		}
		else {
			textview1.setGravity(Gravity.LEFT);
		}
		if (sf.getString("pc", "").equals("1")) {
			pc.setChecked(true);
		}
		else {
			pc.setChecked(false);
		}
		if (sf.getString("loadimages", "").equals("1")) {
			image.setChecked(true);
		}
		else {
			image.setChecked(false);
		}
		if (sf.getString("themepage", "").equals("1")) {
			themepage.setChecked(true);
		}
		else {
			themepage.setChecked(false);
		}
		if (sf.getString("swipetore", "").equals("1")) {
			swipetore.setChecked(true);
		}
		else {
			swipetore.setChecked(false);
		}
		if (sf.getString("navpan", "").equals("1")) {
			linear5.setVisibility(View.VISIBLE);
		}
		else {
			linear5.setVisibility(View.GONE);
		}
		if (sf.getString("incognito", "").equals("1")) {
			openpanel.setText("");
			incognito.setChecked(true);
		}
		else {
			openpanel.setText("");
			incognito.setChecked(false);
		}
	}
	
	
	@Override
	public void onPause() {
		super.onPause();
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		if (sf.getString("nopreview", "").equals("1") && sf.getString("incognito", "").equals("1")) {
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
		}
		Foreground = false;
		_Reopentab();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		if (sf.getString("incognito", "").equals("1")) {
			sf.edit().putString("activetab", "0").commit();
			sf.edit().putString("tabs", "[{\"name\":\"home\", \"url\"=\"".concat(sf.getString("firstpage", "").concat("\"}]"))).commit();
		}
		_clearonexit();
	}
	
	    public void onLowMemory() {
		        super.onLowMemory();
		        SketchwareUtil.showMessage(getApplicationContext(), "WeekBrowser:\nМало оперативної пам'яті. Оптимізація сайтів. Є ризик вильоту браузера");
		
		        }
	public void _ifex() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		if (sf == null) {
			
			SketchwareUtil.showMessage(getApplicationContext(), "SharedPreferences Error");
			    
		} else {
			if (!FileUtil.isExistFile(getFilesDir().getPath()+"/history.json")) {
						FileUtil.writeFile(getFilesDir().getPath()+"/history.json", "[]");
				}
			
			if (!FileUtil.isExistFile(getFilesDir().getPath()+"/sitepermis.json")) {
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", "[]");
				}
				if (FileUtil.readFile(getFilesDir().getPath().concat("/bookmark.html")).length() < 5) {
						FileUtil.writeFile(getFilesDir().getPath().concat("/bookmark.html"), "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\n<body style=\"background-color:#000000\">\n<a href=\"https://www.google.com\"><font color=\"#00ff00\">Google</font></a>\n<font color=\"#ff0000\"> ❖ </font>");
				}
			if (!sf.contains("usedram")) {
				sf.edit().putString("usedram", "0").commit();
			}
			if (!sf.contains("maxhistory")) {
				sf.edit().putString("maxhistory", "1000").commit();
			}
			if (!sf.contains("Sizesbutton")) {
				sf.edit().putString("Sizesbutton", "0").commit();
			}
			if (!sf.contains("maxram")) {
				sf.edit().putString("maxram", String.valueOf((long)((_totalMem() * 3) / 4))).commit();
			}
			if (!sf.contains("firstpage")) {
				sf.edit().putString("firstpage", "file://" + getFilesDir().getPath().concat("/bookmark.html")).commit();
			}
			if (!sf.contains("autofirstpage")) {
				sf.edit().putString("autofirstpage", "0").commit();
			}
			if (!sf.contains("autocleansearch")) {
				sf.edit().putString("autocleansearch", "0").commit();
			}
			if (!sf.contains("autocleancache")) {
				sf.edit().putString("autocleancache", "0").commit();
			}
			if (!sf.contains("autocleancookie")) {
				sf.edit().putString("autocleancookie", "0").commit();
			}
			if (!sf.contains("autocleanform")) {
				sf.edit().putString("autocleanform", "0").commit();
			}
			if (!sf.contains("search")) {
				sf.edit().putString("search", "[]").commit();
			}
			if (!sf.contains("positions")) {
				sf.edit().putString("positions", "[]").commit();
			}
			if (!sf.contains("fontsize")) {
				sf.edit().putString("fontsize", "10").commit();
			}
			if (!sf.contains("searchpanelpos")) {
				sf.edit().putString("searchpanelpos", "0").commit();
			}
			if (!sf.contains("loadimages")) {
				sf.edit().putString("loadimages", "1").commit();
			}
			if (!sf.contains("minfont")) {
				sf.edit().putString("minfont", "0").commit();
			}
			if (!sf.contains("blockad")) {
				sf.edit().putString("blockad", "1").commit();
			}
			if (!sf.contains("iframeblock")) {
				sf.edit().putString("iframeblock", "0").commit();
			}
			if (!sf.contains("hidepanels")) {
				sf.edit().putString("hidepanels", "0").commit();
			}
			if (!sf.contains("searchengine")) {
				sf.edit().putString("searchengine", "0").commit();
			}
			if (!sf.contains("nointernet")) {
				sf.edit().putString("nointernet", "1").commit();
			}
			if (!sf.contains("iframer")) {
				sf.edit().putString("iframer", "1").commit();
			}
			if (!sf.contains("infotext")) {
				sf.edit().putString("infotext", "0").commit();
			}
			if (!sf.contains("bg")) {
				sf.edit().putString("bg", "FF000000FF000080").commit();
			}
			if (!sf.contains("bbg")) {
				sf.edit().putString("bbg", "FF00FF00FF00FFFF").commit();
			}
			if (!sf.contains("rbg")) {
				sf.edit().putString("rbg", "FFFF0000FFFF00FF").commit();
			}
			if (!sf.contains("t")) {
				sf.edit().putString("t", "FF00FF00").commit();
			}
			if (!sf.contains("tf")) {
				sf.edit().putString("tf", "FF00FFFF").commit();
			}
			if (!sf.contains("add")) {
				sf.edit().putString("add", "FFFF0070").commit();
			}
			if (!sf.contains("h")) {
				sf.edit().putString("h", "FF7000FF").commit();
			}
			if (!sf.contains("bt")) {
				sf.edit().putString("bt", "FF000000").commit();
			}
			if (!sf.contains("rbt")) {
				sf.edit().putString("rbt", "FF000000").commit();
			}
			if (!sf.contains("style")) {
				sf.edit().putString("style", "5").commit();
			}
			if (!sf.contains("savehistory")) {
				sf.edit().putString("savehistory", "1000").commit();
			}
			if (!sf.contains("uapc")) {
				sf.edit().putString("uapc", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36").commit();
			}
			if (!sf.contains("ua")) {
				sf.edit().putString("ua", "").commit();
			}
			if (!sf.contains("incognito")) {
				sf.edit().putString("incognito", "0").commit();
			}
			if (!sf.contains("theme")) {
				sf.edit().putString("theme", "1").commit();
			}
			if (!sf.contains("js")) {
				sf.edit().putString("js", "1").commit();
			}
			if (!sf.contains("dp")) {
				sf.edit().putString("dp", "20").commit();
			}
			if (!sf.contains("loadingstyle")) {
				sf.edit().putString("loadingstyle", "1").commit();
			}
			if (!sf.contains("cache")) {
				sf.edit().putString("cache", "0").commit();
			}
			if (!sf.contains("pc")) {
				sf.edit().putString("pc", "0").commit();
			}
			if (!sf.contains("cache")) {
				sf.edit().putString("cache", "0").commit();
			}
			if (!sf.contains("button")) {
				sf.edit().putString("button", "40").commit();
			}
			if (!sf.contains("activetab")) {
				sf.edit().putString("activetab", "0").commit();
			}
			if (!sf.contains("noscreen")) {
				sf.edit().putString("noscreen", "0").commit();
			}
			if (!sf.contains("nopreview")) {
				sf.edit().putString("nopreview", "1").commit();
			}
			if (!sf.contains("monoforta")) {
				sf.edit().putString("monoforta", "0").commit();
			}
			if (!sf.contains("except")) {
				sf.edit().putString("except", "[{\"url\":\"file://\",\"im\"=\"1\",\"js\"=\"1\"}]").commit();
			}
			if (!sf.contains("themepage")) {
				sf.edit().putString("themepage", "0").commit();
			}
			if (!sf.contains("rou")) {
				sf.edit().putString("rou", "0").commit();
			}
			if (!sf.contains("zoombutton")) {
				sf.edit().putString("zoombutton", "0").commit();
			}
			if (!sf.contains("activetab")) {
				sf.edit().putString("activetab", "0").commit();
			}
			if (!sf.contains("noscreen")) {
				sf.edit().putString("noscreen", "0").commit();
			}
			if (!sf.contains("nopreview")) {
				sf.edit().putString("nopreview", "1").commit();
			}
			if (!sf.contains("blockredir")) {
				sf.edit().putString("blockredir", "1").commit();
			}
			if (!sf.contains("windows")) {
				sf.edit().putString("windows", "[{\"e\":\"0\",\"px\":\"0\",\"py\":\"0\",\"sx\":\"2\",\"sy\":\"2\"},{\"e\":\"0\",\"px\":\"2\",\"py\":\"0\",\"sx\":\"2\",\"sy\":\"2\"},\n{\"e\":\"0\",\"px\":\"0\",\"py\":\"2\",\"sx\":\"2\",\"sy\":\"1\"},{\"e\":\"0\",\"px\":\"2\",\"py\":\"2\",\"sx\":\"2\",\"sy\":\"1\"},{\"e\":\"0\",\"px\":\"0\",\"py\":\"3\",\"sx\":\"2\",\"sy\":\"1\"},{\"e\":\"0\",\"px\":\"2\",\"py\":\"3\",\"sx\":\"2\",\"sy\":\"1\"},{\"w\":\"0\"}]").commit();
			}
			if (!sf.contains("navpanpos")) {
				sf.edit().putString("navpanpos", "0").commit();
			}
			if (!sf.contains("swipetore")) {
				sf.edit().putString("swipetore", "0").commit();
			}
			if (!sf.contains("searchpan")) {
				sf.edit().putString("searchpan", "1").commit();
			}
			if (!sf.contains("navpan")) {
				sf.edit().putString("navpan", "1").commit();
			}
			if (!sf.contains("adhosts")) {
				sf.edit().putString("adhosts", "").commit();
			}
			if (!sf.contains("pos1x")) {
				sf.edit().putString("pos1x", "0").commit();
			}
			if (!sf.contains("pos2x")) {
				sf.edit().putString("pos2x", "0").commit();
			}
			if (!sf.contains("pos3x")) {
				sf.edit().putString("pos3x", "0").commit();
			}
			if (!sf.contains("pos1y")) {
				sf.edit().putString("pos1y", "0").commit();
			}
			if (!sf.contains("pos2y")) {
				sf.edit().putString("pos2y", "0").commit();
			}
			if (!sf.contains("pos3y")) {
				sf.edit().putString("pos3y", "0").commit();
			}
			if (!sf.contains("videopatterns")) {
				sf.edit().putString("videopatterns", "Пропустити через|Реклама •|Реклама закінчиться|Реклама [0-9]|Відео незабаром почне відтворюватися|Видео скоро начнется|Вы cможете перейти\\nк видео через").commit();
			}
			if (!sf.contains("listanimp")) {
				sf.edit().putString("listanimp", "0").commit();
			}
			if (!sf.contains("listanimi")) {
				sf.edit().putString("listanimi", "0").commit();
			}
			_ifex2();
			if (!sf.contains("tabs") || (sf.getString("tabs", "").length() < 5)) {
				sf.edit().putString("tabs", "[{\"name\":\"home\", \"url\"=\"".concat(sf.getString("firstpage", "").concat("\"}]"))).commit();
			}
		}
	}
	
	
	public void _language() {
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
	
	
	public void _Reopentab() {
		try{
			final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
			final AtomicBoolean isu = new AtomicBoolean(false);
			
			int childCount = tabscontainer.getChildCount();
			
			    String tag = "ll" + tab.get(Integer.parseInt(sf.getString("activetab", ""))).get("tab").toString(); // отримуємо тег
			
			    for (int h = 0; h < childCount; h++) {
				        LinearLayout childLinearLayout = (LinearLayout) tabscontainer.getChildAt(h);
				        // Перевірка за тегом
				        if (childLinearLayout.getTag() != null && childLinearLayout.getTag().equals(tag)) {
					            // показати цей лінійний макет
					            childLinearLayout.setVisibility(View.VISIBLE);
					            WebView _w = null;
					for (int j = 0; j < childLinearLayout.getChildCount(); j++) {
						                    View nestedChild = childLinearLayout.getChildAt(j);
						                    if (nestedChild instanceof WebView) {
							                        _w = (WebView) nestedChild;
							                        break;
							                    }}
					try{
						for (int i = 0; i < (int)(sitepermis.size()); i++) {
							if (_w.getUrl().contains(sitepermis.get((int)i).get("url").toString())) {
								switch(sitepermis.get((int)i).get("sr").toString()) {
									case "1": {
										ALLOWSWIPE = true;
										break;
									}
									case "2": {
										if (sf.getString("swipetore", "").equals("1")) {
											ALLOWSWIPE = true;
										}
										else {
											ALLOWSWIPE = false;
										}
										break;
									}
									case "0": {
										ALLOWSWIPE = false;
										break;
									}
								}
								isu.set(true);
							}
						}
						if (!isu.get()) {
							if (sf.getString("swipetore", "").equals("1")) {
								ALLOWSWIPE = true;
							}
							else {
								ALLOWSWIPE = false;
							}
						}
						isu.set(false);
					}catch(Exception e){
						if (sf.getString("swipetore", "").equals("1")) {
							ALLOWSWIPE = true;
						}
						else {
							ALLOWSWIPE = false;
						}
						isu.set(false);
					}
					        } else if (childLinearLayout.getTag() != null) {
					            // сховати всі інші лінійні макети
					          if(!is1window)childLinearLayout.setVisibility(View.GONE);
					        }
				    }
			    
			            
			                
			_webViewActions(100, "");
			_webViewActions(30, ((searchpan.getVisibility() == View.VISIBLE) ? (search.getText().toString()) : ("")));
			if (image.isChecked()) {
				_webViewActions(1998, "");
			}
			if (is1window) {
				ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
				Skin skin = new Skin();
				
				String activeTabContent = sf.getString("activetab", "");
				String tabTag = "";
				int activeTabIndex = Integer.parseInt(activeTabContent);
				
				for(int _position = 0; _position < tab.size(); _position++){
					if (tab.get((int)_position) != null) {
						        Object tabValue = tab.get((int)_position).get("tab");
						        if (tabValue != null && is1window) {
							            tabTag = "ll" + tabValue.toString();
							       }else{tabTag="";}}
					
					for (int i = 0; i < childCount; i++) {
						    LinearLayout childLinearLayout = (LinearLayout) tabscontainer.getChildAt(i);
						    
						    // Перевірка за тегом
						    if (childLinearLayout.getTag() != null && childLinearLayout.getTag().equals(tabTag)) {
							        
							        if(activeTabIndex == (int)_position){
								        // Знайдено потрібний LinearLayout
								     //   name.setText("тойво");
								        skin.setBG(childLinearLayout, 1, false);
								break;
							}else{
								   // name.setText("не тойво");
								            skin.setBG(childLinearLayout, 0, false);
								
								break;
								    }
							    }else{
							     // childLinearLayout.setBackgroundColor(Color.TRANSPARENT);
							        }
					}
				}
			}
		}catch(Exception e){
			 
		}
	}
	
	
	public void _loading() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		if (isnotchfullscreen) {
			textview1.setPadding(0, SafeMarginUtils.getTopCutoutHeight(this), 0, 0);
		}
		else {
			textview1.setPadding(0, 0, 0, 0);
			
		}
		if (isshowed && !swipetorefresh) {
			info = info.concat("[          ]\n");
		}
		if (swipetorefresh) {
			info = info.concat("[          ]\n");
		}
		if (load < 100) {
			if (Integer.parseInt(sf.getString("loadingstyle", "")) < 2) {
				info = getString(R.string.loading) + " ";
			}
			if ((Integer.parseInt(sf.getString("loadingstyle", "")) == 0) || (Integer.parseInt(sf.getString("loadingstyle", "")) == 2)) {
				for(int _repeat32 = 0; _repeat32 < (int)(load); _repeat32++) {
					info = info.concat("/");
				}
			}
			else {
				if (Integer.parseInt(sf.getString("loadingstyle", "")) == 4) {
					for(int _repeat41 = 0; _repeat41 < (int)((load / 2)); _repeat41++) {
						info = info.concat("/");
					}
					info = info.concat(String.valueOf((long)(load)).concat("%"));
					for(int _repeat53 = 0; _repeat53 < (int)((load / 2)); _repeat53++) {
						info = info.concat("/");
					}
				}
				else {
					info = info.concat(String.valueOf((long)(load)).concat("%"));
				}
			}
			refresh.setText("");
		}
		else {
			refresh.setText("");
		}
		if (Internet) {
			info = info.concat(getString(R.string.nointernet));
		}
		if (info.trim().equals("")) {
			textview1.setVisibility(View.GONE);
		}
		else {
			textview1.setVisibility(View.VISIBLE);
		}
		textview1.setText(info);
		info = "";
	}
	
	
	public void _titl() {
		
	}
	
	
	public void _settabswindow() {
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (Foreground) {
							if (!is1window) {
								windowsmanager.setVisibility(View.GONE);
								// Ініціалізуємо стек для обходу
								java.util.Stack<ViewGroup> stack = new java.util.Stack<>();
								stack.push(tabscontainer);
								
								while (!stack.isEmpty()) {
									    ViewGroup parent = stack.pop();
									
									    // Проходимо по всіх дочірніх елементах parent
									    for (int h = 0; h < parent.getChildCount(); h++) {
										        View child = parent.getChildAt(h);
										
										        if (child instanceof LinearLayout && child.getTag() != null && child.getTag().toString().startsWith("ll")) {
											            // Якщо дочірній елемент є LinearLayout з тегом, що починається на "ll"
											            LinearLayout linearLayout = (LinearLayout) child;
											
											_setTopPadding(linearLayout, 0);
											linearLayout.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
											linearLayout.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
											((LinearLayout.LayoutParams) linearLayout.getLayoutParams()).weight = 1; // або будь-яке інше значення, яке вам потрібно
											linearLayout.setX(0);
											linearLayout.setY(0);
											linearLayout.requestLayout();
										} else if (child instanceof ViewGroup) {
											            // Якщо дочірній елемент є ViewGroup (наприклад, LinearLayout), додаємо його до стеку для подальшого оброблення
											            stack.push((ViewGroup) child);
											        }
										    }
								}
								
							}
							if (is1window) {
								// Ініціалізуємо стек для обходу
								java.util.Stack<ViewGroup> stack = new java.util.Stack<>();
								stack.push(tabscontainer);
								
								while (!stack.isEmpty()) {
									    ViewGroup parent = stack.pop();
									
									    // Проходимо по всіх дочірніх елементах parent
									    for (int g = 0; g < parent.getChildCount(); g++) {
										        View child = parent.getChildAt(g);
										
										        if (child instanceof LinearLayout && child.getTag() != null && child.getTag().toString().startsWith("ll")) {
											            // Якщо дочірній елемент є LinearLayout з тегом, що починається на "ll"
											            LinearLayout linearLayout = (LinearLayout) child;
											int tag=0;
											            // linearLayout
											for (int i = 0; i < (int)(tab.size()); i++) {
													if (tab.get((int)i).get("tab")!=null && tab.get((int)i).get("tab").toString().equals(child.getTag().toString().replace("ll", ""))) {
															tag = i;break;
													}
											}
											int ti = tab.get(tag).get("x") != null ? Integer.parseInt(tab.get(tag).get("x").toString().replace("s", "")) : 0;
											int th = tab.get(tag).get("y") != null ? Integer.parseInt(tab.get(tag).get("y").toString().replace("s", "")) : 0;
											
											int w = tab.get(tag).get("w") != null ? Integer.parseInt(tab.get(tag).get("w").toString().replace("s", "")) : 2;
											int h = tab.get(tag).get("h") != null ? Integer.parseInt(tab.get(tag).get("h").toString().replace("s", "")) : 2;
											
											try{
												linearLayout.getLayoutParams().width = (int)(w*(tabscontainer.getWidth()/4));
												linearLayout.requestLayout();
												linearLayout.getLayoutParams().height = (int)(h*(tabscontainer.getHeight()/4));
												linearLayout.requestLayout();
												if (is1touch) {
													tab.get((int)tag).put("x", "s".concat(String.valueOf((long)((int)((linearLayout.getX() / (int)(tabscontainer.getWidth() / 4))+.5)))));
													tab.get((int)tag).put("y", "s".concat(String.valueOf((long)((int)((linearLayout.getY() / (int)(tabscontainer.getHeight() / 4))+.5)))));
													tab.get((int)tag).put("w", "s".concat(String.valueOf((long)(((int)linearLayout.getWidth() / (int)(tabscontainer.getWidth() / 4))))));
													tab.get((int)tag).put("h", "s".concat(String.valueOf((long)(((int)linearLayout.getHeight() / (int)(tabscontainer.getHeight() / 4))))));
													recentlyreleased = true;
												}
												else {
													linearLayout.setY((int)th * (int)(tabscontainer.getHeight() / 4));
													linearLayout.setX((int)ti * (int)(tabscontainer.getWidth() / 4));
													
													linearLayout.setX(((int)linearLayout.getX() / (int)(tabscontainer.getWidth() / 4)) * (int)(tabscontainer.getWidth() / 4));
													linearLayout.setY( ((int)linearLayout.getY() / (int)(tabscontainer.getHeight() / 4)) * (int)(tabscontainer.getHeight() / 4));
													_restorewindowparam();
													if (recentlyreleased) {
														dataHolder.setData("ml", "https://multilink2.weekbrowser.com/".concat(encodeUrl(new Gson().toJson(tab))));
														sf.edit().putString("tabs", new Gson().toJson(tab)).commit();
														recentlyreleased = false;
													}
												}
											}catch(Exception e){
												 
											}
										} else if (child instanceof ViewGroup) {
											            // Якщо дочірній елемент є ViewGroup (наприклад, LinearLayout), додаємо його до стеку для подальшого оброблення
											            stack.push((ViewGroup) child);
											        }
										    }
								}
								
							}
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(99), (int)(100));
	}
	
	
	public void _setTopPadding(final View _view, final double _topPadding) {
		int topPaddingInPx = (int) ((int)_topPadding * getResources().getDisplayMetrics().density + 0.5f);
		
		    if(topPaddingInPx>0){_view.setPadding(1, (int)topPaddingInPx, 1, 1);}else
		{_view.setPadding(0,0,0,0);}
	}
	
	
	public String _geturl() {
		String baseUrl = "";
		        String fullUrl = autocomplete1.getText().toString();
		        try {
			            URL url = new URL(fullUrl);
			             baseUrl = url.getProtocol() + "://" + url.getHost();
			        } catch (MalformedURLException e) {
			            e.printStackTrace();
			        }
		return (baseUrl);
	}
	
	
	public void _buttonsizeset() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		back.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		back.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		back.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		back.requestLayout();
		
		pgup.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		pgup.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		pgup.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		pgup.requestLayout();
		
		forward.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		forward.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		forward.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		forward.requestLayout();
		
		pgdn.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		pgdn.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		pgdn.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		pgdn.requestLayout();
		
		//════════
		
		bookmarks.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		bookmarks.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		bookmarks.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		bookmarks.requestLayout();
		
		histori.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		histori.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		histori.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		histori.requestLayout();
		
		home.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		home.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		home.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		home.requestLayout();
		
		tabs.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		tabs.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		tabs.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		tabs.requestLayout();
		
		//════════════════════════════════
		
		dual.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		dual.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		dual.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		dual.requestLayout();
		
		skipvideo.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		skipvideo.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		skipvideo.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		skipvideo.requestLayout();
		
		pagesearch.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		pagesearch.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		pagesearch.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		pagesearch.requestLayout();
		
		coordinates.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		coordinates.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		coordinates.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		coordinates.requestLayout();
		
		//════════
		
		/*addshortcut.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
addshortcut.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
addshortcut.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
addshortcut.requestLayout();*/
		
		hide.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		hide.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		hide.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		hide.requestLayout();
		
		openpanel.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		openpanel.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		openpanel.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		openpanel.requestLayout();
		
		refresh.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		refresh.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		refresh.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		refresh.requestLayout();
		
		 button1.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		button1.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		button1.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		button1.requestLayout();
		
		button3.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		button3.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		button3.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		button3.requestLayout();
		
		widthp1.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		widthp1.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		widthp1.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		widthp1.requestLayout();
		
		widthm1.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		widthm1.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		widthm1.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		widthm1.requestLayout();
		
		
		heightp1.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		heightp1.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		heightp1.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		heightp1.requestLayout();
		
		heightm1.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		heightm1.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		heightm1.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		heightm1.requestLayout();
		
		
		
		closeeditor.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		closeeditor.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		closeeditor.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		closeeditor.requestLayout();
		
		
		
		copyurl.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		copyurl.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		copyurl.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		copyurl.requestLayout();
		
		
		
		pasteurl.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		pasteurl.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		pasteurl.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		pasteurl.requestLayout();
		
		
		
		pastegourl.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		pastegourl.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		pastegourl.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		pastegourl.requestLayout();
		
		
		selall.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		selall.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		selall.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		selall.requestLayout();
		
		
		
		
		cururl.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		cururl.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		cururl.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		cururl.requestLayout();
		
		
		
		
		ssl.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		ssl.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		ssl.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		ssl.requestLayout();
		
		
		
		
		
	}
	
	
	public void _swipe() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		autocomplete1.setOnFocusChangeListener(new OnFocusChangeListener() { @Override public void onFocusChange(View v, boolean hasFocus) {
						  if (hasFocus) { 
					
					focused = true;
						} 
						 else { 
					focused = false;
						} } });
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (Foreground) {
							_kbdsrh();
							if ((autocomplete1.getText().toString().equals(getFilesDir().getPath().concat("/bookmark.html")) || autocomplete1.getText().toString().equals(sf.getString("firstpage", ""))) && sf.getString("searchpan", "").equals("1")) {
								srhhis.setVisibility(View.VISIBLE);
							}
							else {
								srhhis.setVisibility(View.GONE);
							}
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(199), (int)(200));
	}
	
	
	public void _restorewindowparam() {
		// Ініціалізуємо стек для обходу
		java.util.Stack<ViewGroup> stack = new java.util.Stack<>();
		stack.push(tabscontainer);
		
		while (!stack.isEmpty()) {
			    ViewGroup parent = stack.pop();
			
			    // Проходимо по всіх дочірніх елементах parent
			    for (int g = 0; g < parent.getChildCount(); g++) {
				        View child = parent.getChildAt(g);
				
				        if (child instanceof LinearLayout && child.getTag() != null && child.getTag().toString().startsWith("ll")) {
					            // Якщо дочірній елемент є LinearLayout з тегом, що починається на "ll"
					            final LinearLayout linearLayout = (LinearLayout) child;
					
					            // linearLayout
					            
					int tag = 0;
					for (int i = 0; i < (int)(tab.size()); i++) {
							if (tab.get((int)i).get("tab") != null && tab.get((int)i).get("tab").toString().equals(child.getTag().toString().replace("ll", ""))) {
									tag = i;break;
							}
						
					}
					int ti = tab.get(tag).get("x") != null ? Integer.parseInt(tab.get(tag).get("x").toString().replace("s", "")) : 0;
					int th = tab.get(tag).get("y") != null ? Integer.parseInt(tab.get(tag).get("y").toString().replace("s", "")) : 0;
					
					int w = tab.get(tag).get("w") != null ? Integer.parseInt(tab.get(tag).get("w").toString().replace("s", "")) : 2;
					int h = tab.get(tag).get("h") != null ? Integer.parseInt(tab.get(tag).get("h").toString().replace("s", "")) : 2;
					
					if (is1window) {
						linearLayout.setOnTouchListener(new OnTouchListener() {
							    PointF DownPT = new PointF();
							    PointF StartPT = new PointF();
							
							    @Override
							    public boolean onTouch(View v, MotionEvent event) {
								        int eid = event.getAction();
								        switch (eid) {
									            case MotionEvent.ACTION_MOVE:
									                PointF mv = new PointF(event.getX() - DownPT.x, event.getY() - DownPT.y);
									
									                // Використовуємо getWidth() та getHeight() для отримання розмірів
									                int maxw = tabscontainer.getWidth() - linearLayout.getWidth();
									                int maxh = tabscontainer.getHeight() - linearLayout.getHeight();
									
									                // Обчислення нових координат
									                int setx = (int)(StartPT.x + mv.x);
									                int sety = (int)(StartPT.y + mv.y);
									
									                // Перевірка меж
									                linearLayout.setX(Math.max(0, Math.min(setx, maxw)));
									                linearLayout.setY(Math.max(0, Math.min(sety, maxh)));
									
									                StartPT = new PointF(linearLayout.getX(), linearLayout.getY());
									                break;
									
									            case MotionEvent.ACTION_DOWN:
									                DownPT.x = event.getX();
									                DownPT.y = event.getY();
									                StartPT = new PointF(linearLayout.getX(), linearLayout.getY());
									                is1touch = true; // При дотику встановлюємо is1touch в true
									                break;
									
									            case MotionEvent.ACTION_UP:
									                is1touch = false;
									                linearLayout.bringToFront();
									                // При відпусканні встановлюємо is1touch в false
									                for(int i = 0; i < tab.size(); i++) {
										                    if(linearLayout.getTag() != null) {
											                        if(tab.get(i).get("tab") != null && tab.get(i).get("tab").toString().equals(linearLayout.getTag().toString().replace("ll",""))) {
												       
												final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
												sf.edit().putString("activetab", String.valueOf(i)).commit();
												                            _Reopentab();
												                            ((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();
												                            break;
												                        }
											                    }
										                }
									                break;
									
									            default:
									                break;
									        }
								        return true;
								    }
						});
						
						_setTopPadding(linearLayout, 30);
						linearLayout.getLayoutParams().width = (int)w*(tabscontainer.getWidth() / 4);
						linearLayout.getLayoutParams().height = (int)h*(tabscontainer.getHeight() / 4);
						((LinearLayout.LayoutParams) linearLayout.getLayoutParams()).weight = 0; // або будь-яке інше значення, яке вам потрібно
						
						linearLayout.requestLayout();
						windowsmanager.setVisibility(View.VISIBLE);
						try{
							linearLayout.setY((int)th * (int)(tabscontainer.getHeight() / 4));
							
							linearLayout.setX((int)ti * (int)(tabscontainer.getWidth() / 4));
							
							linearLayout.setX(((int)linearLayout.getX() / (int)(tabscontainer.getWidth() / 4)) * (int)(tabscontainer.getWidth() / 4));
							linearLayout.setY( ((int)linearLayout.getY() / (int)(tabscontainer.getHeight() / 4)) * (int)(tabscontainer.getHeight() / 4));
							
						}catch(Exception e){
							 
						}
					}
					else {
						_setTopPadding(linearLayout, 0);
						linearLayout.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
						linearLayout.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
						((LinearLayout.LayoutParams) linearLayout.getLayoutParams()).weight = 1; // або будь-яке інше значення, яке вам потрібно
						linearLayout.requestLayout();
						linearLayout.setX(0);
						linearLayout.setY(0);
						windowsmanager.setVisibility(View.GONE);
					}
				} else if (child instanceof ViewGroup) {
					            // Якщо дочірній елемент є ViewGroup (наприклад, LinearLayout), додаємо його до стеку для подальшого оброблення
					            stack.push((ViewGroup) child);
					        }
				    }
		}
		
		/*
ti = Integer.parseInt(tab.get((int)tag).get("x").toString().replace("s", ""));
th = Integer.parseInt(tab.get((int)tag).get("y").toString().replace("s", ""));
*/
	}
	
	
	public String _clearram() {
		return ("javascript:(function() {\n    var elements = document.querySelectorAll('*');\n    for (var i = 0; i < elements.length; i++) {\n        elements[i].style.border = 'none';\n        elements[i].style.boxShadow = 'none';\n        elements[i].style.transition = 'none';\n        elements[i].style.animation = 'none';\n        elements[i].style.backgroundImage = 'none';\n        elements[i].style.textShadow = 'none';\n    }\n})();\n");
	}
	
	
	public void _onscroll(final WebView _w) {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		final Activity thiss = this;
		_w.setOnTouchListener(new View.OnTouchListener() {
			    private float startY;
			
			    @Override
			    public boolean onTouch(View v, MotionEvent event) {
				        switch (event.getAction()) {
					            case MotionEvent.ACTION_DOWN:
					                startY = event.getRawY();
					                break;
					            case MotionEvent.ACTION_UP:
					                float endY = event.getRawY();
					                float touchSlop = ViewConfiguration.get(_w.getContext()).getScaledTouchSlop();
													isshowed=false;local1=false;local2=false;
													if(swipetorefresh){
														_refreshh();swipetorefresh=false;}
					                if (Math.abs(startY - endY) < touchSlop) {
						                   /* if(is1window)
                    // Це був простий дотик
                    {if (_w == webview1) {
                        tab1.performClick();
                    } else if (_w == webview2) {
                        tab2.performClick();
                    } else if (_w == webview3) {
                        tab3.performClick();
                    } else if (_w == webview4) {
                        tab4.performClick();
                    } else if (_w == webview5) {
                        tab5.performClick();
                    } else if (_w == webview6) {
                        tab6.performClick();
                    }
                }*/}
					                break;
					            case MotionEvent.ACTION_MOVE:
					                float currentY = event.getRawY();
					                if (startY+SketchwareUtil.getDip(getApplicationContext(), (int)(50)) < currentY) {
						
						if (sf.getString("hidepanels", "").equals("1") && !is1window) {
							linear1.setVisibility(View.VISIBLE);
							if (sf.getString("navpan", "").equals("1")) {
								linear5.setVisibility(View.VISIBLE);
							}
							SafeMarginUtils.setFullscreenMode(thiss, 0);
							isnotchfullscreen = false;
						}
						if (!local2 && (ALLOWSWIPE && !is1window)) {
							if (_w.getScrollY() == 0) {
								isshowed = true;
								local1 = true;
							}
						}
						local2 = true;
						if ((startY+SketchwareUtil.getDip(getApplicationContext(), (int)(250)) < currentY && local1) && ALLOWSWIPE) {
							swipetorefresh = true;
						}
						else {
							swipetorefresh = false;
						}
						                } else if (startY-SketchwareUtil.getDip(getApplicationContext(), (int)(50)) > currentY) {
						                    
						if (!kbd && (sf.getString("hidepanels", "").equals("1") && !is1window)) {
							linear1.setVisibility(View.GONE);
							
							linear5.setVisibility(View.GONE);
							if ((_Orientation() == 0) || (_Orientation() == 2)) {
								SafeMarginUtils.setFullscreenMode(thiss, 2);
								isnotchfullscreen = true;
							}
							else {
								if ((_Orientation() == 1) || (_Orientation() == 3)) {
									SafeMarginUtils.setFullscreenMode(thiss, 1);
									isnotchfullscreen = false;
								}
								else {
									
								}
							}
						}
						 }
					                break;
					        }
				        return false; // Повертаємо false, щоб інші обробники подій дотику також були викликані, якщо вони є
				    }
		});
		
	}
	
	
	public void _clearonexit() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		if (sf.getString("autocleansearch", "").equals("1")) {
			sf.edit().putString("search", "[]").commit();
		}
		if (sf.getString("autocleancache", "").equals("1")) {
			FileUtil.deleteFile(getFilesDir().getPath().concat("/cache"));
		}
		if (sf.getString("autocleancookie", "").equals("1")) {
			CookieManager.getInstance().removeAllCookies(null);
		}
		if (sf.getString("autocleanform", "").equals("1")) {
			/*
webview1.clearFormData();
*/
		}
	}
	
	
	public void _extrc() {
	}
	
	
	public void setupWebView(final WebView webView, final Activity activity) 
	{
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		_setAll(webView);
		_onscroll(webView);
		_download(webView);
		_restorewindowparam();
		webView.addJavascriptInterface(new JavaScriptInterface(activity), "AndroidInterface");
		    //webView.addJavascriptInterface(new BLOBloader(), "Blobload");
		    // Вимкнення відкриття посилань в сторонніх браузерах
		    webView.setWebViewClient(new MyWebViewClient(activity));
		    
		    // Додання WebChromeClient для підтримки JavaScript та інших можливостей
		    webView.setWebChromeClient(new CustomWebClient(activity){
			        // For 3.0+ Devices
			        protected void openFileChooser(ValueCallback uploadMsg, String acceptType) {
				            mUploadMessage = uploadMsg;
				            Intent i = new Intent(Intent.ACTION_GET_CONTENT);
				            i.addCategory(Intent.CATEGORY_OPENABLE);
				            i.setType("image/*");
				            startActivityForResult(Intent.createChooser(i, "File Browser"), FILECHOOSER_RESULTCODE);
				        }
			
			        // For Lollipop 5.0+ Devices
			        public boolean onShowFileChooser(WebView mWebView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
				            if (uploadMessage != null) {
					                uploadMessage.onReceiveValue(null);
					                uploadMessage = null;
					            }
				            uploadMessage = filePathCallback;
				            Intent intent = fileChooserParams.createIntent();
				            try {
					                startActivityForResult(intent, REQUEST_SELECT_FILE);
					            } catch (ActivityNotFoundException e) {
					                uploadMessage = null;
					                Toast.makeText(getApplicationContext(), "Cannot Open File Chooser", Toast.LENGTH_LONG).show();
					                return false;
					            }
				            return true;
				        }
			
			        //For Android 4.1 only
			        protected void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
				            mUploadMessage = uploadMsg;
				            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
				            intent.addCategory(Intent.CATEGORY_OPENABLE);
				            intent.setType("image/*");
				            startActivityForResult(Intent.createChooser(intent, "File Browser"), FILECHOOSER_RESULTCODE);
				        }
			
			        protected void openFileChooser(ValueCallback<Uri> uploadMsg) {
				            mUploadMessage = uploadMsg;
				            Intent i = new Intent(Intent.ACTION_GET_CONTENT);
				            i.addCategory(Intent.CATEGORY_OPENABLE);
				            i.setType("image/*");
				            startActivityForResult(Intent.createChooser(i, "File Chooser"), FILECHOOSER_RESULTCODE);
				        }
			
			@Override
			public boolean onCreateWindow(final WebView view, boolean dialog, boolean userGesture, android.os.Message resultMsg) {
				    try {
					        final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
					        WebView.HitTestResult result = view.getHitTestResult();
					        String targetUrl = result.getExtra(); // Отримання targetUrl
					
					        boolean isAd = false;
					        String blockedline = "";
					
					        // Перевірка на блокування
					        isAd = checkIfUrlBlocked(targetUrl);
					        if (isAd) {
						            SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.adblocked));
						            return false; // Нічого не робимо, просто повертаємо false
						        } else {
						            T++;
						            Tt++;
						            time++;
						            int currentActiveTabIndex = tab.size();
						            sf.edit().putString("activetab", String.valueOf(currentActiveTabIndex)).commit();
						
						            // Додавання нового елементу до списку, якщо індекс перевищує розмір списку
						            HashMap<String, Object> newTabMap = new HashMap<>();
						            newTabMap.put("tab", String.valueOf((long) (Tt)));
						            newTabMap.put("url", "about_blank");
						            newTabMap.put("time", time);
						            tab.add(newTabMap);
						            dataHolder.setData("ml", "https://multilink2.weekbrowser.com/".concat(encodeUrl(new Gson().toJson(tab))));
						            
						            // Створюємо новий LinearLayout для нового WebView
						            LinearLayout newWebViewContainer = new LinearLayout(activity);
						            newWebViewContainer.setTag("ll" + String.valueOf(Tt));
						            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
						                ViewGroup.LayoutParams.MATCH_PARENT,
						                ViewGroup.LayoutParams.MATCH_PARENT
						            );
						            layoutParams.weight = 1; // Встановлення ваги
						            newWebViewContainer.setLayoutParams(layoutParams);
						
						            // Створюємо новий WebView
						            WebView newWebView = new WebView(activity);
						            // newWebView.loadUrl("about:blank");
						            // Застосовуємо налаштування до нового WebView
						            newWebView.getSettings().setJavaScriptEnabled(true);
						            setupWebView(newWebView, activity);
						
						            // Додаємо WebView до його контейнера
						            newWebViewContainer.addView(newWebView, new LinearLayout.LayoutParams(
						                ViewGroup.LayoutParams.MATCH_PARENT,
						                ViewGroup.LayoutParams.MATCH_PARENT
						            ));
						
						            // Додаємо контейнер до tabsContainer
						            tabscontainer.addView(newWebViewContainer);
						
						            // Повертаємо WebView для обробки посилання
						            WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
						            transport.setWebView(newWebView);
						            resultMsg.sendToTarget();
						            tabs.setText("[" + tab.size() + "]•");
						            return true;
						        }
					    } catch (Exception e) {
					        ((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", e.toString()));
					        return false; // Можна повернути false, якщо сталася помилка
					    }
			}
		});
	}
	    
	    
	    
	private String getFileExtensionFromMimeType(String mimeType) {
		    String[] parts = mimeType.split("/");
		    if (parts.length == 2) {
			        return parts[1];
			    }
		    return null;
	}
	
	/*private ValueCallback<Uri> mUploadMessage;
public ValueCallback<Uri[]> uploadMessage;
public static final int REQUEST_SELECT_FILE = 100;

private final static int FILECHOOSER_RESULTCODE = 1;*/
	
	public void openInOtherApps(String url) {
		        Intent intent = new Intent(Intent.ACTION_VIEW);
		        intent.setData(Uri.parse(url));
		
		        PackageManager packageManager = getPackageManager();
		        List<ResolveInfo> resolveInfoList = packageManager.queryIntentActivities(intent, 0);
		
		        List<Intent> targetIntents = new ArrayList<>();
		        for (ResolveInfo resolveInfo : resolveInfoList) {
			            String packageName = resolveInfo.activityInfo.packageName;
			            if (!packageName.equals(getPackageName())) {
				                Intent targetIntent = new Intent(Intent.ACTION_VIEW);
				                targetIntent.setData(Uri.parse(url));
				                targetIntent.setPackage(packageName);
				                targetIntents.add(targetIntent);
				            }
			        }
		
		        if (!targetIntents.isEmpty()) {
			            Intent chooserIntent = Intent.createChooser(targetIntents.remove(0), getString(R.string.openwith));
			            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetIntents.toArray(new Intent[0]));
			            startActivity(chooserIntent);
			        }
		    }
	
	
	private ValueCallback<Uri> mUploadMessage;
	public ValueCallback<Uri[]> uploadMessage;
	public static final int REQUEST_SELECT_FILE = 100;
	
	private final static int FILECHOOSER_RESULTCODE = 1;
	
	
	/*

private void startSetAllTimer(WebView webView) {
    final WebView finalWebView = webView;
    final Handler handler = new Handler();
    final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            _setAll(finalWebView);
            handler.postDelayed(this, 150); // Використання інтервалу 150 мс
        }
    };
    handler.post(runnable);
}
*/
	
	public static String decodeUrl(String url) {
		        try {
			            return URLDecoder.decode(url, "UTF-8");
			        } catch (UnsupportedEncodingException e) {
			            e.printStackTrace();
			            return url; // Повертаємо оригінальний URL у випадку помилки
			        }
		    }
	    public static String encodeUrl(String url) {
		        try {
			            return URLEncoder.encode(url, "UTF-8");
			        } catch (UnsupportedEncodingException e) {
			            e.printStackTrace();
			            return url; // Повертаємо оригінальний URL у випадку помилки
			        }
		    }
	    
	
	private boolean checkIfUrlBlocked(String url) {
		    AdBlocker adBlocker = new AdBlocker(this);
		    return adBlocker.isBlocked(url);
	}
	
	
	
	    public static String extractColor(String inputText, String prefix) {
		        String regex = prefix + "0x" + "([a-fA-F0-9]+)";
		        
		        Pattern pattern = Pattern.compile(regex);
		        Matcher matcher = pattern.matcher(inputText);
		        
		        if (matcher.find()) {
			            return matcher.group(1);
			        } else {
			           regex = prefix + "#" + "([a-fA-F0-9]+)";
			        
			        pattern = Pattern.compile(regex);
			        matcher = pattern.matcher(inputText);
			        
			        if (matcher.find()) {
				            return matcher.group(1);
				        } else {return null;} 
			        }
		    }
	
	public static String extractColo(String inputText, String prefix) {
		        String regex = prefix + "([a-fA-F0-9]+)";
		        
		        Pattern pattern = Pattern.compile(regex);
		        Matcher matcher = pattern.matcher(inputText);
		        
		        if (matcher.find()) {
			            return matcher.group(1);
			        } else {
			        return null;
			        }
		    }
	
	{
	}
	
	
	public void _refreshh() {
		_webViewActions(5, "");
	}
	
	
	public void _fonts() {
		back.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		forward.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		pgup.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		pgdn.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		bookmarks.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		home.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		histori.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		tabs.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		dual.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		skipvideo.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		sup.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		sdown.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		hide.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		refresh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		openpanel.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		button3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		closeeditor.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		copyurl.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		pasteurl.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		pastegourl.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		widthm1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		widthp1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		heightm1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		heightp1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		add.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		closeall.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		selall.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		cururl.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		ssl.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		pagesearch.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		coordinates.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
	}
	
	
	public void _ifex2() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		if (sf == null) {
			
			SketchwareUtil.showMessage(getApplicationContext(), "SharedPreferences Error");
			    
		} else {
			if (!sf.contains("cssbg")) {
				sf.edit().putString("cssbg", "000000").commit();
			}
			if (!sf.contains("cssbgcol")) {
				sf.edit().putString("cssbgcol", "000000").commit();
			}
			if (!sf.contains("cssbgblend")) {
				sf.edit().putString("cssbgblend", "normal").commit();
			}
			if (!sf.contains("cssbgblur")) {
				sf.edit().putString("cssbgblur", "0.0").commit();
			}
			if (!sf.contains("cssbgbright")) {
				sf.edit().putString("cssbgbright", "1.0").commit();
			}
			if (!sf.contains("cssbgcontr")) {
				sf.edit().putString("cssbgcontr", "1.0").commit();
			}
			if (!sf.contains("cssbghue")) {
				sf.edit().putString("cssbghue", "0").commit();
			}
			if (!sf.contains("cssbginvert")) {
				sf.edit().putString("cssbginvert", "0.0").commit();
			}
			if (!sf.contains("cssbgopacity")) {
				sf.edit().putString("cssbgopacity", "0.0").commit();
			}
			if (!sf.contains("cssbgsatur")) {
				sf.edit().putString("cssbgsatur", "1.0").commit();
			}
			if (!sf.contains("cssbgsepia")) {
				sf.edit().putString("cssbgsepia", "0.0").commit();
			}
			if (!sf.contains("cssbgsize")) {
				sf.edit().putString("cssbgsize", "cover").commit();
			}
			if (!sf.contains("cssbgstrokecolor")) {
				sf.edit().putString("cssbgstrokecolor", "0000FFFF").commit();
			}
			if (!sf.contains("cssbgstrokesize")) {
				sf.edit().putString("cssbgstrokesize", "0.0").commit();
			}
			if (!sf.contains("cssbgstrokestyle")) {
				sf.edit().putString("cssbgstrokestyle", "solid").commit();
			}
			if (!sf.contains("csstextalign")) {
				sf.edit().putString("csstextalign", "left").commit();
			}
			if (!sf.contains("csstextblur")) {
				sf.edit().putString("csstextblur", "0.0").commit();
			}
			if (!sf.contains("csstextbordercolor")) {
				sf.edit().putString("csstextbordercolor", "FF0000FF").commit();
			}
			if (!sf.contains("csstextbordersize")) {
				sf.edit().putString("csstextbordersize", "0.0").commit();
			}
			if (!sf.contains("csstextborderstyle")) {
				sf.edit().putString("csstextborderstyle", "solid").commit();
			}
			if (!sf.contains("csstextbright")) {
				sf.edit().putString("csstextbright", "1.0").commit();
			}
			if (!sf.contains("csstextcontr")) {
				sf.edit().putString("csstextcontr", "1.0").commit();
			}
			if (!sf.contains("csstextfont")) {
				sf.edit().putString("csstextfont", "sans").commit();
			}
			if (!sf.contains("csstexthue")) {
				sf.edit().putString("csstexthue", "0").commit();
			}
			if (!sf.contains("csstextinvert")) {
				sf.edit().putString("csstextinvert", "0.0").commit();
			}
			if (!sf.contains("csstextline")) {
				sf.edit().putString("csstextline", "1.3").commit();
			}
			if (!sf.contains("csstextopacity")) {
				sf.edit().putString("csstextopacity", "1.0").commit();
			}
			if (!sf.contains("csstextsatur")) {
				sf.edit().putString("csstextsatur", "1.0").commit();
			}
			if (!sf.contains("csstextsepia")) {
				sf.edit().putString("csstextsepia", "0.0").commit();
			}
			if (!sf.contains("csstextshadowb")) {
				sf.edit().putString("csstextshadowb", "0.0").commit();
			}
			if (!sf.contains("csstextblend")) {
				sf.edit().putString("csstextblend", "normal").commit();
			}
			if (!sf.contains("csstextshadowc")) {
				sf.edit().putString("csstextshadowc", "FF00FFFF").commit();
			}
			if (!sf.contains("csstextshadowx")) {
				sf.edit().putString("csstextshadowx", "1.0").commit();
			}
			if (!sf.contains("csstextshadowy")) {
				sf.edit().putString("csstextshadowy", "1.0").commit();
			}
			if (!sf.contains("csstextsize")) {
				sf.edit().putString("csstextsize", "20").commit();
			}
			if (!sf.contains("csstextstrokecolor")) {
				sf.edit().putString("csstextstrokecolor", "00FFFFFF").commit();
			}
			if (!sf.contains("csstextstrokesize")) {
				sf.edit().putString("csstextstrokesize", "0.0").commit();
			}
			if (!sf.contains("csstextstyle")) {
				sf.edit().putString("csstextstyle", "initial").commit();
			}
			if (!sf.contains("csstexttrans")) {
				sf.edit().putString("csstexttrans", "initial").commit();
			}
			if (!sf.contains("csstextweight")) {
				sf.edit().putString("csstextweight", "500").commit();
			}
			if (!sf.contains("videopatterns")) {
				sf.edit().putString("videopatterns", "Пропустити через|Реклама •|Реклама закінчиться|Реклама [0-9]|Відео незабаром почне відтворюватися|Видео скоро начнется|Вы cможете перейти\\nк видео через").commit();
			}
			if (!sf.contains("skipvideoad")) {
				sf.edit().putString("skipvideoad", "1").commit();
			}
			if (!sf.contains("cb")) {
				sf.edit().putString("cb", "FF44BBFF").commit();
			}
			if (!sf.contains("tpc")) {
				sf.edit().putString("tpc", "FF44BBFF").commit();
			}
			if (!sf.contains("tc")) {
				sf.edit().putString("tc", "FF44BBFF").commit();
			}
			if (!sf.contains("jslog")) {
				sf.edit().putString("jslog", "0").commit();
			}
			if (!sf.contains("hidepass")) {
				sf.edit().putString("hidepass", "0").commit();
			}
			if (!sf.contains("hidepass2")) {
				sf.edit().putString("hidepass2", "0").commit();
			}
			if (!sf.contains("rgrad")) {
				sf.edit().putString("rgrad", "2").commit();
			}
			if (!sf.contains("grad")) {
				sf.edit().putString("grad", "2").commit();
			}
			if (!sf.contains("bgrad")) {
				sf.edit().putString("bgrad", "2").commit();
			}
			if (!sf.contains("strcou")) {
				sf.edit().putString("strcou", "2").commit();
			}
			if (!sf.contains("y")) {
				sf.edit().putString("y", "0.5").commit();
			}
			if (!sf.contains("x")) {
				sf.edit().putString("x", "0.5").commit();
			}
			if (!sf.contains("rad")) {
				sf.edit().putString("rad", "1").commit();
			}
			if (!sf.contains("rstrcou")) {
				sf.edit().putString("rstrcou", "2").commit();
			}
			if (!sf.contains("rx")) {
				sf.edit().putString("rx", "0.5").commit();
			}
			if (!sf.contains("ry")) {
				sf.edit().putString("ry", "0.5").commit();
			}
			if (!sf.contains("rrad")) {
				sf.edit().putString("rrad", "1").commit();
			}
			if (!sf.contains("bstrcou")) {
				sf.edit().putString("bstrcou", "2").commit();
			}
			if (!sf.contains("by")) {
				sf.edit().putString("by", "0.5").commit();
			}
			if (!sf.contains("bx")) {
				sf.edit().putString("bx", "0.5").commit();
			}
			if (!sf.contains("brad")) {
				sf.edit().putString("brad", "1").commit();
			}
			if (!sf.contains("rrou")) {
				sf.edit().putString("rrou", "0").commit();
			}
			if (!sf.contains("rsrou")) {
				sf.edit().putString("rsrou", "0").commit();
			}
			if (!sf.contains("srou")) {
				sf.edit().putString("srou", "0").commit();
			}
			if (!sf.contains("rrad")) {
				sf.edit().putString("rrad", "1").commit();
			}
			if (!sf.contains("bstrcou")) {
				sf.edit().putString("bstrcou", "2").commit();
			}
			if (!sf.contains("tm")) {
				sf.edit().putString("tm", "2").commit();
			}
			if (!sf.contains("rtm")) {
				sf.edit().putString("rtm", "2").commit();
			}
			if (!sf.contains("btm")) {
				sf.edit().putString("btm", "2").commit();
			}
			_ifex3();
		}
	}
	
	
	public void _download(final WebView _w) {
		FileDownloader fileDownloader = new FileDownloader(this, _w);
	}
	
	
	public void _onpagefinish(final WebView _w) {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		_w.evaluateJavascript(
		    "(function() {" +
		    "    var sButton = null;" +
		    "    var fButton = null;" +
		    "    function createButton(e, doc, isIframe) {" +
		    "        if (sButton) {" +
		    "            sButton.remove();" +
		    "        }" +
		    "        if (fButton) {" +
		    "            fButton.remove();" +
		    "        }" +
		    "        sButton = doc.createElement('button');" +
		    "        sButton.innerText = '[S]';" +
		    "        sButton.style.position = 'fixed';" +
		    "        sButton.style.top = (e.clientY + 20) + 'px';" +
		    "        sButton.style.left = (e.clientX + 20) + 'px';" +
		    "        sButton.style.zIndex = '99999999';" +
		    "        sButton.style.background = 'yellow';" +
		    "        sButton.style.color = 'black';" +
		    "        sButton.style.padding = '10.27052005px';" +
		    "        sButton.style.fontSize = '16px';" +
		    "        sButton.onclick = function() {" +
		    "            var element = e.target;" +
		    "            var elementCode = element.outerHTML;" +
		    "            var elementText = element.innerText;" +
		    "            var elementId = element.id;" +
		    "            var elementSrc = element.src || '';" +
		    "            var elementHref = '';" +
		    "            var elementType = element.tagName.toLowerCase();" +
		    "            var pageText = document.body.innerText;" +
		    "            var pageCode = document.documentElement.outerHTML;" +
		    "            var purl = window.location.href;" +
		    "            var title = document.title;" +  // Get the page title
		    "            if (element.tagName === 'A') {" +
		    "                elementHref = element.href;" +
		    "            } else {" +
		    "                var parent = element.closest('a');" +
		    "                if (parent) {" +
		    "                    elementHref = parent.href;" +
		    "                }" +
		    "            }" +
		    "            var data = {" +
		    "                code: elementCode," +
		    "                text: elementText," +
		    "                src: elementSrc," +
		    "                href: elementHref," +
		    "                wtext: pageText," +
		    "                wcode: pageCode," +
		    "                taid: elementId," +
		    "                url: purl," +
		    "                type: elementType," +
		    "                title: title" +  // Add the title to the data object
		    "            };" +
		    "            window.AndroidInterface.processElementInfo(JSON.stringify(data));" +
		    "        };" +
		    "        doc.body.appendChild(sButton);" +
		    "        if (isIframe) {" +
		    "            fButton = doc.createElement('button');" +
		    "            fButton.innerText = '[[F]]';" +
		    "            fButton.style.position = 'fixed';" +
		    "            fButton.style.top = (e.clientY + 50) + 'px';" +
		    "            fButton.style.left = (e.clientX + 20) + 'px';" +
		    "            fButton.style.zIndex = '99999999';" +
		    "            fButton.style.background = 'lime';" +
		    "            fButton.style.color = 'black';" +
		    "            fButton.style.padding = '10.27052005px';" +
		    "            fButton.style.fontSize = '16px';" +
		    "            fButton.onclick = function() {" +
		    "                var iframe = e.target.closest('iframe');" +
		    "                if (iframe) {" +
		    "                    var iframeDoc = iframe.contentDocument || iframe.contentWindow.document;" +
		    "                    var iframeCode = iframe.outerHTML;" +
		    "                    var iframeText = iframeDoc.body.innerText;" +
		    "                    var iframeSrc = iframe.src || '';" +
		    "                    var iframeHref = iframe.src || '';" +
		    "                    var pageText = document.body.innerText;" +
		    "                    var pageCode = document.documentElement.outerHTML;" +
		    "                    var purl = window.location.href;" +
		    "                    var title = document.title;" +  // Get the page title
		    "                    var data = {" +
		    "                        code: iframeCode," +
		    "                        text: iframeText," +
		    "                        src: iframeSrc," +
		    "                        href: iframeHref," +
		    "                        wtext: pageText," +
		    "                        wcode: pageCode," +
		    "                        taid: iframe.id," +
		    "                        url: purl," +
		    "                        type: 'iframe'," +
		    "                        title: title" +  // Add the title to the data object
		    "                    };" +
		    "                    window.AndroidInterface.processElementInfo(JSON.stringify(data));" +
		    "                }" +
		    "            };" +
		    "            doc.body.appendChild(fButton);" +
		    "        }" +
		    "    }" +
		    "    function handleContextMenu(e, doc) {" +
		    "        createButton(e, doc, doc !== document);" +
		    "    }" +
		    "    function addContextMenuListener(doc) {" +
		    "        if (!doc.contextMenuListenerAdded) {" +
		    "            doc.contextMenuListenerAdded = true;" +
		    "            doc.addEventListener('contextmenu', function(e) {" +
		    "                handleContextMenu(e, doc);" +
		    "            }, true);" + // Use capture phase
		    "        }" +
		    "        doc.addEventListener('click', function(e) {" +
		    "            if (sButton && !sButton.contains(e.target) && (!fButton || !fButton.contains(e.target))) {" +
		    "                sButton.remove();" +
		    "                if (fButton) {" +
		    "                    fButton.remove();" +
		    "                }" +
		    "            }" +
		    "        });" +
		    "    }" +
		    "    function addListenersToIframes(doc) {" +
		    "        var iframes = doc.querySelectorAll('iframe');" +
		    "        iframes.forEach(function(iframe) {" +
		    "            try {" +
		    "                var iframeDoc = iframe.contentDocument || iframe.contentWindow.document;" +
		    "                if (iframeDoc && !iframeDoc.contextMenuListenerAdded) {" +
		    "                    addContextMenuListener(iframeDoc);" +
		    "                    var observer = new MutationObserver(function(mutations) {" +
		    "                        mutations.forEach(function(mutation) {" +
		    "                            if (mutation.addedNodes.length > 0) {" +
		    "                                addContextMenuListener(iframeDoc);" +
		    "                            }" +
		    "                        });" +
		    "                    });" +
		    "                    observer.observe(iframeDoc.body, { childList: true, subtree: true });" +
		    "                    iframe.contentWindow.addEventListener('contextmenu', function(e) {" +
		    "                        handleContextMenu(e, iframeDoc);" +
		    "                    }, true);" + // Use capture phase
		    "                }" +
		    "            } catch (e) {" +
		    "                console.error('Error accessing iframe content: ', e);" +
		    "            }" +
		    "        });" +
		    "    }" +
		    "    function initialize() {" +
		    "        addContextMenuListener(document);" +
		    "        addListenersToIframes(document);" +
		    "        var observer = new MutationObserver(function(mutations) {" +
		    "            mutations.forEach(function(mutation) {" +
		    "                mutation.addedNodes.forEach(function(node) {" +
		    "                    if (node.nodeName === 'IFRAME') {" +
		    "                        try {" +
		    "                            var iframeDoc = node.contentDocument || node.contentWindow.document;" +
		    "                            if (iframeDoc) {" +
		    "                                addContextMenuListener(iframeDoc);" +
		    "                                addListenersToIframes(iframeDoc);" +
		    "                            }" +
		    "                        } catch (e) {" +
		    "                            console.error('Error accessing iframe content: ', e);" +
		    "                        }" +
		    "                    }" +
		    "                });" +
		    "                addContextMenuListener(document);" +
		    "                addListenersToIframes(document);" +
		    "            });" +
		    "        });" +
		    "        observer.observe(document.body, { childList: true, subtree: true });" +
		    "    }" +
		    "    if (document.readyState === 'loading') {" +
		    "        document.addEventListener('DOMContentLoaded', initialize);" +
		    "    } else {" +
		    "        initialize();" +
		    "    }" +
		    "})();",
		    null
		);
		
		if (sf.getString("skipvideoad", "").equals("1")) {
			_w.loadUrl("javascript:(function() {\n" +
			    "    var adsSkipped = false;\n\n" +
			    "    function skipAds() {\n" +
			    "        var videos = document.querySelectorAll('video, [src*=\".mp4\"], [src*=\".webm\"], [src*=\".ogv\"], [type*=\"video\"]');\n" +
			    "        for (var i = 0; i < videos.length; i++) {\n" +
			    "            var video = videos[i];\n" +
			    "            if (typeof video.currentTime !== 'undefined') {\n" +
			    "                video.currentTime = 65535;\n" +
			    "            }\n" +
			    "        }\n" +
			    "    }\n\n" +
			    "    function checkForKeywords() {\n" +
			    "        var regex = new RegExp(\"" + sf.getString("videopatterns", "") + "\");\n" +  // Тут було виправлено метод створення регулярного виразу
			    "        var found = regex.test(document.body.innerText);\n" +
			    "        if (found && !adsSkipped) {\n" +
			    "            adsSkipped = true;\n" +
			    "            setTimeout(function() {\n" +
			    "                adsSkipped = false;\n" +
			    "            }, 2000);\n" +
			    "            skipAds();\n" +
			    "        }\n" +
			    "    }\n\n" +
			    "    function hasVideo() {\n" +
			    "        return document.querySelector('video') || document.querySelector('[src*=\".mp4\"]') || document.querySelector('[src*=\".webm\"]') || document.querySelector('[src*=\".ogv\"]') || document.querySelector('[type*=\"video\"]');\n" +
			    "    }\n\n" +
			    "    if (hasVideo()) {\n" +
			    "        var observer = new MutationObserver(function(mutations) {\n" +
			    "            mutations.forEach(function(mutation) {\n" +
			    "                if (mutation.type === 'childList' || mutation.type === 'characterData') {\n" +
			    "                    checkForKeywords();\n" +
			    "                }\n" +
			    "            });\n" +
			    "        });\n\n" +
			    "        var config = { childList: true, subtree: true, characterData: true, characterDataOldValue: true };\n" +
			    "        observer.observe(document.body, config);\n\n" +
			    "        checkForKeywords();\n" +
			    "    }\n" +
			"})();");
			
		}
		try{
			if (sf.getString("iframer", "").equals("1") && !_w.getUrl().contains("accounts.google.com")) {
				_w.loadUrl("javascript:(function() {\n    var iframes = document.querySelectorAll('iframe');\n    if (iframes.length === 0) {\n        return;\n    }\n    \n    iframes.forEach(function(iframe, index) {\n        var src = iframe.src || iframe.getAttribute('data-src');\n        if (src) {\n            var button = document.createElement('button');\n            button.textContent = '[]↗';\n            button.style.position = 'absolute';\n            button.style.bottom = '-25.2705px';\n            button.style.right = '10.2005px';\n            button.style.backgroundColor = '#00ffff';\n            button.style.color = '#000000';\n            button.style.padding = '10px';\n            button.style.fontSize = '16px';\n            button.style.cursor = 'pointer';\n            button.style.zIndex = '9999999';\n            button.onclick = function() {\n                window.open(src, '_blank');\n            };\n\n            var iframeWrapper = document.createElement('div');\n            iframeWrapper.style.position = 'relative';\n            iframe.style.position = 'relative';\n\n            iframe.parentNode.insertBefore(iframeWrapper, iframe);\n            iframeWrapper.appendChild(iframe);\n            iframeWrapper.appendChild(button);\n        }\n    });\n})();\n");
			}
		}catch(Exception e){
			 
		}
		try{
			View parentView = (View) _w.getParent();
			    if (parentView instanceof LinearLayout) {
				        LinearLayout linearLayout = (LinearLayout) parentView;
				        
				List<HashMap<String, Object>> tabCopy;
				        synchronized(tab) {
					            tabCopy = new ArrayList<>(tab);
					        }
				        
				        for (int i = 0; i < tabCopy.size(); i++) {
					            Object tag = linearLayout.getTag();
					            if (tag != null) {
						                Object tabValue = tabCopy.get(i).get("tab");
						                if (tabValue != null && tabValue.toString().equals(tag.toString().replace("ll", ""))) {
							                    String url = _w.getUrl();
							                    String title = _w.getTitle();
							                    String fav = _w.getFavicon()!=null?BitmapEncoderDecoder.encodeToBase64(_w.getFavicon()):"no";
							                    
							                    if (url != null && title != null) {
								                        synchronized(tab) {
																                            tab.get(i).put("url", url);
																                            tab.get(i).put("name", title);
																                            tab.get(i).put("fav", fav);
																                        }
								                    }
							                    break;
							                }
						            }
					        }
				    }
		}catch(Exception e){
			SketchwareUtil.showMessage(getApplicationContext(), e.toString());
		}
		sf.edit().putString("tabs", new Gson().toJson(tab)).commit();
		((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();
		dataHolder.setData("ml", "https://multilink2.weekbrowser.com/".concat(encodeUrl(new Gson().toJson(tab))));
		_webViewActions(100, "");
		_setAll(_w);
		try{
			if (sf.getString("incognito", "").equals("0")) {
				final String tit = _w.getTitle();
				new Thread(new Runnable() {
					    @Override
					    public void run() {
						        if (!(tit.equals("bookmark.html") || tit.equals("about:blank"))) {
							            if (sf.getString("incognito","").equals("0")) {
								                synchronized (history) {
									                    if (!history.isEmpty()) {
										                        HashMap<String, Object> lastItem = history.get(history.size() - 1);
										                        lastItem.put("name", tit);
										                    }
									                    FileUtil.writeFile(getFilesDir().getPath()+"/history.json", new Gson().toJson(history));
									                }
								            }
							        }
						    }
				}).start();
			}
		}catch(Exception e){
			/*
SketchwareUtil.showMessage(getApplicationContext(), e.toString());
*/
		}
	}
	
	
	public boolean _adblck(final WebView _w) {
		return adbl;
	}
	
	
	public boolean _isaccess() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		return (sf.getString("blockredir", "").equals("1"));
	}
	
	
	public void _adsblocked() {
		adsblockedd++;
	}
	
	
	public void _accessdenied(final String _reg) {
		SketchwareUtil.showMessage(getApplicationContext(), getApplicationContext().getString(R.string.adblocked));
		SketchwareUtil.showMessage(getApplicationContext(),_reg);
	}
	
	
	public void _onpagefail(final WebView _w, final String _e) {
		SketchwareUtil.showMessage(getApplicationContext(), _e);
		_Reopentab();
		_w.evaluateJavascript(
		    "(function() {" +
		    "    var sButton = null;" +
		    "    var fButton = null;" +
		    "    function createButton(e, doc, isIframe) {" +
		    "        if (sButton) {" +
		    "            sButton.remove();" +
		    "        }" +
		    "        if (fButton) {" +
		    "            fButton.remove();" +
		    "        }" +
		    "        sButton = doc.createElement('button');" +
		    "        sButton.innerText = '[S]';" +
		    "        sButton.style.position = 'fixed';" +
		    "        sButton.style.top = (e.clientY + 20) + 'px';" +
		    "        sButton.style.left = (e.clientX + 20) + 'px';" +
		    "        sButton.style.zIndex = '99999999';" +
		    "        sButton.style.background = 'yellow';" +
		    "        sButton.style.color = 'black';" +
		    "        sButton.style.padding = '10.27052005px';" +
		    "        sButton.style.fontSize = '16px';" +
		    "        sButton.onclick = function() {" +
		    "            var element = e.target;" +
		    "            var elementCode = element.outerHTML;" +
		    "            var elementText = element.innerText;" +
		    "            var elementId = element.id;" +
		    "            var elementSrc = element.src || '';" +
		    "            var elementHref = '';" +
		    "            var elementType = element.tagName.toLowerCase();" +
		    "            var pageText = document.body.innerText;" +
		    "            var pageCode = document.documentElement.outerHTML;" +
		    "            var purl = window.location.href;" +
		    "            var title = document.title;" +  // Get the page title
		    "            if (element.tagName === 'A') {" +
		    "                elementHref = element.href;" +
		    "            } else {" +
		    "                var parent = element.closest('a');" +
		    "                if (parent) {" +
		    "                    elementHref = parent.href;" +
		    "                }" +
		    "            }" +
		    "            var data = {" +
		    "                code: elementCode," +
		    "                text: elementText," +
		    "                src: elementSrc," +
		    "                href: elementHref," +
		    "                wtext: pageText," +
		    "                wcode: pageCode," +
		    "                taid: elementId," +
		    "                url: purl," +
		    "                type: elementType," +
		    "                title: title" +  // Add the title to the data object
		    "            };" +
		    "            window.AndroidInterface.processElementInfo(JSON.stringify(data));" +
		    "        };" +
		    "        doc.body.appendChild(sButton);" +
		    "        if (isIframe) {" +
		    "            fButton = doc.createElement('button');" +
		    "            fButton.innerText = '[[F]]';" +
		    "            fButton.style.position = 'fixed';" +
		    "            fButton.style.top = (e.clientY + 50) + 'px';" +
		    "            fButton.style.left = (e.clientX + 20) + 'px';" +
		    "            fButton.style.zIndex = '99999999';" +
		    "            fButton.style.background = 'lime';" +
		    "            fButton.style.color = 'black';" +
		    "            fButton.style.padding = '10.27052005px';" +
		    "            fButton.style.fontSize = '16px';" +
		    "            fButton.onclick = function() {" +
		    "                var iframe = e.target.closest('iframe');" +
		    "                if (iframe) {" +
		    "                    var iframeDoc = iframe.contentDocument || iframe.contentWindow.document;" +
		    "                    var iframeCode = iframe.outerHTML;" +
		    "                    var iframeText = iframeDoc.body.innerText;" +
		    "                    var iframeSrc = iframe.src || '';" +
		    "                    var iframeHref = iframe.src || '';" +
		    "                    var pageText = document.body.innerText;" +
		    "                    var pageCode = document.documentElement.outerHTML;" +
		    "                    var purl = window.location.href;" +
		    "                    var title = document.title;" +  // Get the page title
		    "                    var data = {" +
		    "                        code: iframeCode," +
		    "                        text: iframeText," +
		    "                        src: iframeSrc," +
		    "                        href: iframeHref," +
		    "                        wtext: pageText," +
		    "                        wcode: pageCode," +
		    "                        taid: iframe.id," +
		    "                        url: purl," +
		    "                        type: 'iframe'," +
		    "                        title: title" +  // Add the title to the data object
		    "                    };" +
		    "                    window.AndroidInterface.processElementInfo(JSON.stringify(data));" +
		    "                }" +
		    "            };" +
		    "            doc.body.appendChild(fButton);" +
		    "        }" +
		    "    }" +
		    "    function handleContextMenu(e, doc) {" +
		    "        createButton(e, doc, doc !== document);" +
		    "    }" +
		    "    function addContextMenuListener(doc) {" +
		    "        if (!doc.contextMenuListenerAdded) {" +
		    "            doc.contextMenuListenerAdded = true;" +
		    "            doc.addEventListener('contextmenu', function(e) {" +
		    "                handleContextMenu(e, doc);" +
		    "            }, true);" + // Use capture phase
		    "        }" +
		    "        doc.addEventListener('click', function(e) {" +
		    "            if (sButton && !sButton.contains(e.target) && (!fButton || !fButton.contains(e.target))) {" +
		    "                sButton.remove();" +
		    "                if (fButton) {" +
		    "                    fButton.remove();" +
		    "                }" +
		    "            }" +
		    "        });" +
		    "    }" +
		    "    function addListenersToIframes(doc) {" +
		    "        var iframes = doc.querySelectorAll('iframe');" +
		    "        iframes.forEach(function(iframe) {" +
		    "            try {" +
		    "                var iframeDoc = iframe.contentDocument || iframe.contentWindow.document;" +
		    "                if (iframeDoc && !iframeDoc.contextMenuListenerAdded) {" +
		    "                    addContextMenuListener(iframeDoc);" +
		    "                    var observer = new MutationObserver(function(mutations) {" +
		    "                        mutations.forEach(function(mutation) {" +
		    "                            if (mutation.addedNodes.length > 0) {" +
		    "                                addContextMenuListener(iframeDoc);" +
		    "                            }" +
		    "                        });" +
		    "                    });" +
		    "                    observer.observe(iframeDoc.body, { childList: true, subtree: true });" +
		    "                    iframe.contentWindow.addEventListener('contextmenu', function(e) {" +
		    "                        handleContextMenu(e, iframeDoc);" +
		    "                    }, true);" + // Use capture phase
		    "                }" +
		    "            } catch (e) {" +
		    "                console.error('Error accessing iframe content: ', e);" +
		    "            }" +
		    "        });" +
		    "    }" +
		    "    function initialize() {" +
		    "        addContextMenuListener(document);" +
		    "        addListenersToIframes(document);" +
		    "        var observer = new MutationObserver(function(mutations) {" +
		    "            mutations.forEach(function(mutation) {" +
		    "                mutation.addedNodes.forEach(function(node) {" +
		    "                    if (node.nodeName === 'IFRAME') {" +
		    "                        try {" +
		    "                            var iframeDoc = node.contentDocument || node.contentWindow.document;" +
		    "                            if (iframeDoc) {" +
		    "                                addContextMenuListener(iframeDoc);" +
		    "                                addListenersToIframes(iframeDoc);" +
		    "                            }" +
		    "                        } catch (e) {" +
		    "                            console.error('Error accessing iframe content: ', e);" +
		    "                        }" +
		    "                    }" +
		    "                });" +
		    "                addContextMenuListener(document);" +
		    "                addListenersToIframes(document);" +
		    "            });" +
		    "        });" +
		    "        observer.observe(document.body, { childList: true, subtree: true });" +
		    "    }" +
		    "    if (document.readyState === 'loading') {" +
		    "        document.addEventListener('DOMContentLoaded', initialize);" +
		    "    } else {" +
		    "        initialize();" +
		    "    }" +
		    "})();",
		    null
		);
		
		_w.loadUrl(themebml);
		((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();
		final String tit = _w.getTitle();
		new Thread(new Runnable() {
			    @Override
			    public void run() {
				        if (!(tit.equals("bookmark.html") || tit.equals("about:blank"))) {
					            if (sf.getString("incognito", "").equals("0")) {
						                synchronized (history) {
							                    if (!history.isEmpty()) {
								                        HashMap<String, Object> lastItem = history.get(history.size() - 1);
								                        lastItem.put("name", tit);
								                    }
							                   FileUtil.writeFile(getFilesDir().getPath()+"/history.json", new Gson().toJson(history));
							                }
						            }
					        }
				    }
		}).start();
	}
	
	
	public double _Orientation() {
		int orientation = getApplicationContext().getResources().getConfiguration().orientation;
		        int rotation = getApplicationContext().getResources().getConfiguration().smallestScreenWidthDp;
		
		        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
			            return 0;
			        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
			            return 1;
			        } else if (orientation == Configuration.ORIENTATION_UNDEFINED && rotation % 180 == 0) {
			            return 2; // Перевернутий портрет
			        } else if (orientation == Configuration.ORIENTATION_UNDEFINED && rotation % 180 != 0) {
			            return 3; // Перевернутий ландшафт
			        } else {
			            return -1; // Якщо не вдалося визначити орієнтацію, повертаємо -1
			        }
	}
	
	
	public void _statushs(final boolean _a) {
		statush = _a;
	}
	
	
	public void _setAll(final WebView _w) {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE); final AtomicBoolean isu = new AtomicBoolean(false);
		_w.getSettings().setBuiltInZoomControls(true);
		_w.getSettings().setDisplayZoomControls(false);
		_w.getSettings().setLoadWithOverviewMode(true);
		_w.getSettings().setUseWideViewPort(false);
		_w.getSettings().setSaveFormData(true);
		    _w.getSettings().setAllowFileAccess(true);
		    _w.getSettings().setAllowContentAccess(true);
		    _w.getSettings().setDatabaseEnabled(true);
		    _w.getSettings().setDomStorageEnabled(true);
		    _w.getSettings().setSupportMultipleWindows(true);
		    _w.getSettings().setGeolocationEnabled(true);
		    _w.getSettings().setAllowFileAccessFromFileURLs(true);
		    _w.getSettings().setAllowUniversalAccessFromFileURLs(true);
		    _w.getSettings().setPluginState(WebSettings.PluginState.ON);
		   
		_w.getSettings().setMediaPlaybackRequiresUserGesture(false);
		 _w.setLayerType(View.LAYER_TYPE_HARDWARE, null);
		    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			        
			    _w.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);}
		         
		    if(sf.getString("incognito", "").equals("1")){
			        CookieManager.getInstance().setAcceptCookie(false);
			        if (android.os.Build.VERSION.SDK_INT >= 21) { CookieManager.getInstance().setAcceptThirdPartyCookies(_w, false);}
			        }else{
			        CookieManager.getInstance().setAcceptCookie(true);
			        if (android.os.Build.VERSION.SDK_INT >= 21) { CookieManager.getInstance().setAcceptThirdPartyCookies(_w, true);}
			        }
		
		
		_w.setFindListener(new WebView.FindListener() {
			    @Override
			    public void onFindResultReceived(int activeMatchOrdinal, int numberOfMatches, boolean isDoneCounting) {
				        if (isDoneCounting) {
					            allnum = numberOfMatches;
					            curnum = activeMatchOrdinal+1;
					            // Можна додати логіку для використання allnum
					        }
				    }
		});
		
		_w.getSettings().setMinimumFontSize(Integer.parseInt(sf.getString("minfont", "")));
		
		_w.getSettings().setTextZoom(Integer.parseInt(sf.getString("fontsize", ""))*10);
		
		if (sf.getString("pc", "").equals("1")) {
			_w.setInitialScale((int)Integer.parseInt(sf.getString("dp", ""))*5);_w.getSettings().setUserAgentString(sf.getString("uapc",""));
			
		}
		else {
			_w.setInitialScale((int)Integer.parseInt(sf.getString("dp", ""))*10);_w.getSettings().setUserAgentString(sf.getString("ua",""));
			
		}
		try{
			for (int i = 0; i < (int)(sitepermis.size()); i++) {
				if (_w.getUrl().contains(sitepermis.get((int)i).get("url").toString())) {
					switch(sitepermis.get((int)i).get("if").toString()) {
						case "1": {
							_w.loadUrl("javascript:(function() {     var iframes = document.querySelectorAll('iframe');     if (iframes) {         for (var i = 0; i < iframes.length; i++) {             iframes[i].parentNode.removeChild(iframes[i]);         }     } })(); ");
							break;
						}
						case "2": {
							if (sf.getString("iframeblock", "").equals("1")) {
								_w.loadUrl("javascript:(function() {     var iframes = document.querySelectorAll('iframe');     if (iframes) {         for (var i = 0; i < iframes.length; i++) {             iframes[i].parentNode.removeChild(iframes[i]);         }     } })(); ");
							}
							break;
						}
						case "0": {
							 
							break;
						}
					}
					isu.set(true);
				}
			}
			if (!isu.get()) {
				if (sf.getString("iframeblock", "").equals("1")) {
					_w.loadUrl("javascript:(function() {     var iframes = document.querySelectorAll('iframe');     if (iframes) {         for (var i = 0; i < iframes.length; i++) {             iframes[i].parentNode.removeChild(iframes[i]);         }     } })(); ");
				}
			}
			isu.set(false);
		}catch(Exception e){
			if (sf.getString("iframeblock", "").equals("1")) {
				_w.loadUrl("javascript:(function() {     var iframes = document.querySelectorAll('iframe');     if (iframes) {         for (var i = 0; i < iframes.length; i++) {             iframes[i].parentNode.removeChild(iframes[i]);         }     } })(); ");
			}
			isu.set(false);
		}
		_webViewActions(100, "");
		try{
			View parentView = (View) _w.getParent();
			    if (parentView instanceof LinearLayout) {
				        LinearLayout linearLayout = (LinearLayout) parentView;
				        
				List<HashMap<String, Object>> tabCopy;
				        synchronized(tab) {
					            tabCopy = new ArrayList<>(tab);
					        }
				        
				        for (int i = 0; i < tabCopy.size(); i++) {
					            Object tag = linearLayout.getTag();
					            if (tag != null) {
						                Object tabValue = tabCopy.get(i).get("tab");
						                if (tabValue != null && tabValue.toString().equals(tag.toString().replace("ll", ""))) {
							                    String url = _w.getUrl();
							                    String title = _w.getTitle();
							                    String fav = _w.getFavicon()!=null?BitmapEncoderDecoder.encodeToBase64(_w.getFavicon()):"no";
							                    
							                    if (url != null && title != null) {
								                        synchronized(tab) {
									                            tab.get(i).put("url", url);
									                            tab.get(i).put("name", title);
									                            tab.get(i).put("fav", fav);
									                        }
								                    }
							                    break;
							                }
						            }
					        }
				    }
			    ((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();
		}catch(Exception e){
			 
		}
	}{
	}
	
	
	public void _progresser(final WebView _w, final double _p) {
		load = _p;
	}
	
	
	public void _prog11(final WebView _w) {
		final AtomicBoolean isu = new AtomicBoolean(false);
		
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		ExtensionUtil extensionUtil = new ExtensionUtil(this);
		try{
			try{
				for (int i = 0; i < (int)(sitepermis.size()); i++) {
					if (_w.getUrl().contains(sitepermis.get((int)i).get("url").toString())) {
						switch(sitepermis.get((int)i).get("th").toString()) {
							case "1": {
								_w.loadUrl(themebml);
								break;
							}
							case "2": {
								if (sf.getString("themepage", "").equals("1")) {
									_w.loadUrl(themebml);
								}
								break;
							}
							case "0": {
								 
								break;
							}
						}
						isu.set(true);
					}
				}
				if (!isu.get()) {
					if (sf.getString("themepage", "").equals("1")) {
						_w.loadUrl(themebml);
					}
				}
				isu.set(false);
			}catch(Exception e){
				if (sf.getString("themepage", "").equals("1")) {
					_w.loadUrl(themebml);
				}
			}
			isu.set(false);
			if (_w.getUrl().contains(getFilesDir().getPath().concat("/bookmark.html"))) {
				_w.loadUrl(designbmlcache);
			}
			try{
				View parentView = (View) _w.getParent();
				    if (parentView instanceof LinearLayout) {
					        LinearLayout linearLayout = (LinearLayout) parentView;
					        Object tag = linearLayout.getTag();
					        if (tag != null) {
						for (int i = 0; i < (int)(tab.size()); i++) {
										if (tab.get((int)i).get("tab").toString().equals(tag.toString().replace("ll",""))) {
												tab.get((int)i).put("url", _w.getUrl());
												tab.get((int)i).put("name", _w.getTitle());
												break;
										}
										else {
												
										}
								}
								        } else {
								            // Тег не встановлений
								        }}else{
						    }
			}catch(Exception e){
				 
			}
			((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();
			sf.edit().putString("tabs", new Gson().toJson(tab)).commit();
			extensionUtil.onPageStarted(_w, _w.getUrl());
		}catch(Exception e){
			 
		}
	}
	
	
	public void _webViewActions(final double _a, final String _s) {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		int childCount = tabscontainer.getChildCount();
		    String activeTabContent = sf.getString("activetab", "");
		
		    // Перевірка на null і коректність формату вмісту файлу
		    if (activeTabContent == null || activeTabContent.isEmpty()) {
			        return; // Або обробіть помилку відповідним чином
			    }
		
		    int activeTabIndex;
		    try {
			        activeTabIndex = Integer.parseInt(activeTabContent);
			    } catch (NumberFormatException e) {
			        e.printStackTrace();
			        return; // Або обробіть помилку відповідним чином
			    }
		
		    // Перевірка на null і коректність структури даних
		    if (activeTabIndex < 0 || activeTabIndex >= tab.size()) {
			        return; // Або обробіть помилку відповідним чином
			    }
		
		    Map<String, Object> tabData = tab.get(activeTabIndex);
		    if (tabData == null || !tabData.containsKey("tab") || tabData.get("tab") == null) {
			        return; // Або обробіть помилку відповідним чином
			    }
		
		    String tabTag = "ll" + tabData.get("tab").toString(); // отримуємо тег
		
		    for (int i = 0; i < childCount; i++) {
			        View child = tabscontainer.getChildAt(i);
			        if (child instanceof LinearLayout) {
				            LinearLayout childLinearLayout = (LinearLayout) child;
				            
				            // Перевірка за тегом
				            if (childLinearLayout.getTag() != null && childLinearLayout.getTag().equals(tabTag)) {
					                // Знайдено потрібний LinearLayout
					                WebView targetWebView = null;
					                
					                for (int j = 0; j < childLinearLayout.getChildCount(); j++) {
						                    View nestedChild = childLinearLayout.getChildAt(j);
						                    if (nestedChild instanceof WebView) {
							                        targetWebView = (WebView) nestedChild;
							                        break;
							                    }
						                }
					
					                if (targetWebView != null) {
						                    // Виконати дії з знайденим WebView
						                    switch((int) _a) {
							                        case 0:
							                            try{autocomplete1.setText(decodeUrl(targetWebView.getUrl()));
								        }
							                            catch(Exception e){
								             autocomplete1.setText(targetWebView.getUrl());
								         ;
								                                             }
							                            break;
							                        case 1:
							                            if (targetWebView.canGoBack()) {
								                                targetWebView.goBack();
								                            }
							                            break;
							                        case 2:
							                            if (targetWebView.canGoForward()) {
								                                targetWebView.goForward();
								                            }
							                            break;
							                        case 3:
							                            targetWebView.scrollTo(0, 0);
							                            break;
							                        case 4:
							                            targetWebView.scrollTo(0, Integer.MAX_VALUE);
							                            break;
							                        case 5:
							                            if (targetWebView.getProgress() == 100) {
								                                targetWebView.reload();
								                            } else {
								                                targetWebView.stopLoading();
								                            }
							                            break;
							                        case 10:
							                            targetWebView.loadUrl(_s);
							                            holdsearchtext = false;
							                            break;
							                        case 11:
							                            wwpos = targetWebView.getScrollX();
							                            break;
							                        case 12:
							                            wwpos = targetWebView.getScrollY();
							                            break;
							                        case 20:
							     if (Integer.parseInt(sf.getString("pc", "")) == 1) {
									targetWebView.setInitialScale(Integer.parseInt(_s)*5);
							}
							else {
									targetWebView.setInitialScale(Integer.parseInt(_s)*10);
							}
							                        break;
							                        case 30:
							                        targetWebView.findAllAsync(_s);
							                        break;
							                        case 31:
							num.setText(String.valueOf((int) curnum) + "/" + String.valueOf((int) allnum));
							targetWebView.findNext(false);
							break;
							case 32:
							num.setText(String.valueOf((int) curnum) + "/" + String.valueOf((int) allnum));
							targetWebView.findNext(true);
							break;
							                        case 100:
							                            title.setText(targetWebView.getTitle());
							                            break;
							                        case 101:
							                            load = targetWebView.getProgress();
							                            break;
							                        case 1998:
							                            targetWebView.getSettings().setBlockNetworkImage(false);targetWebView.getSettings().setLoadsImagesAutomatically(true);
							                            
							                            break;
							                        case 1999:
							                                tempurl = targetWebView.getUrl();
							
							        new Thread(new Runnable() {
								            @Override
								            public void run() {
									                    // Виконання фонової роботи
									                    _bgexec();
									
									                    // Оновлення UI
									                    runOnUiThread(new Runnable() {
										                        @Override
										                        public void run() {
											                            _postexec();
											                        }
										                    });
									            }
								        }).start();
							                            
							                            break;
							                            case 100001:
							                            if (targetWebView.canGoBack()) {
								                                targetWebView.goBack();
								                            }else{
								        // tab.remove((int)(_position));
								         
								                            }
							                            break;
							                        
							case ((int)301): {
								sf.edit().putString("pos1x", String.valueOf((long)(targetWebView.getScrollX()))).commit();
								sf.edit().putString("pos1y", String.valueOf((long)(targetWebView.getScrollY()))).commit();
								pos1.setText("(".concat(sf.getString("pos1x", "").concat("; ".concat(sf.getString("pos1y", "").concat(")")))));
								break;
							}
							case ((int)302): {
								sf.edit().putString("pos2x", String.valueOf((long)(targetWebView.getScrollX()))).commit();
								sf.edit().putString("pos2y", String.valueOf((long)(targetWebView.getScrollY()))).commit();
								pos2.setText("(".concat(sf.getString("pos2x", "").concat("; ".concat(sf.getString("pos2y", "").concat(")")))));
								break;
							}
							case ((int)303): {
								sf.edit().putString("pos3x", String.valueOf((long)(targetWebView.getScrollX()))).commit();
								sf.edit().putString("pos3y", String.valueOf((long)(targetWebView.getScrollY()))).commit();
								pos3.setText("(".concat(sf.getString("pos3x", "").concat("; ".concat(sf.getString("pos3y", "").concat(")")))));
								break;
							}
							case ((int)401): {
								targetWebView.scrollTo(Integer.parseInt(sf.getString("pos1x","")),Integer.parseInt(sf.getString("pos1y","")));
								break;
							}
							case ((int)402): {
								targetWebView.scrollTo(Integer.parseInt(sf.getString("pos2x","")),Integer.parseInt(sf.getString("pos2y","")));
								break;
							}
							case ((int)403): {
								targetWebView.scrollTo(Integer.parseInt(sf.getString("pos3x","")),Integer.parseInt(sf.getString("pos3y","")));
								break;
							}
							case ((int)500): {
								/*
targetWebView.updateExtensions();
*/
								break;
							}
							default:
							                            // Невідомий код дії
							                            break;
							                    }
						                }
					                break; // Знайдено потрібний LinearLayout, вихід з циклу
					            }
				        }
			    }
	}
	
	
	public void _newTab(final String _url, final boolean _move) {
		try{
			final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
			    T++;
			    Tt++;
			        time++;
			   // if (notFirst) {
			        int currentActiveTabIndex = tab.size();
			   if(_move){     
				sf.edit().putString("activetab", String.valueOf(currentActiveTabIndex)).commit();
			}
			
			
			            // Додавання нового елементу до списку, якщо індекс перевищує розмір списку
			            HashMap<String, Object> newTabMap = new HashMap<>();
			            newTabMap.put("tab", String.valueOf((long) (Tt)));
			            newTabMap.put("url", _url);
			            newTabMap.put("time", time);
			            tab.add(newTabMap);
			        
			dataHolder.setData("ml", "https://multilink2.weekbrowser.com/".concat(encodeUrl(new Gson().toJson(tab))));
			      
			  //  }
			    notFirst = true;
			
			    LinearLayout newWebViewContainer = new LinearLayout(MainActivity.this);
			    newWebViewContainer.setTag("ll" + String.valueOf(Tt));
			    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
			            ViewGroup.LayoutParams.MATCH_PARENT,
			            ViewGroup.LayoutParams.MATCH_PARENT
			    );
			    layoutParams.weight = 1; // Встановлення ваги
			    newWebViewContainer.setLayoutParams(layoutParams);
			
			    WebView newWebView = new WebView(MainActivity.this);
			
			    
			
			    newWebViewContainer.addView(newWebView, new LinearLayout.LayoutParams(
			            ViewGroup.LayoutParams.MATCH_PARENT,
			            ViewGroup.LayoutParams.MATCH_PARENT
			    ));
			
			    tabscontainer.addView(newWebViewContainer);
			    tabs.setText("[" + tab.size() + "]•");
			newWebView.getSettings().setJavaScriptEnabled(true);
			setupWebView(newWebView, MainActivity.this);
			
			newWebView.loadUrl(_url);  // Завантаження початкового URL для нової вкладки
			((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();
			sf.edit().putString("tabs", new Gson().toJson(tab)).commit();
			_Reopentab();
		}catch(Exception e){
			((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", e.toString()));
		}
	}
	
	
	public double _totalMem() {
		ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
		        MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
		        activityManager.getMemoryInfo(memoryInfo);
		
		        // Загальна кількість доступної пам'яті
		        return memoryInfo.totalMem / 1048576L; // в MB
		
	}
	
	
	public void _ramoptimizer() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		try{
			if (usedMemoryMB > Integer.parseInt(sf.getString("maxram", ""))) {
				int mintime = Integer.MAX_VALUE;
				int minind = 0;
				for (int i = 0; i < (int)(tab.size()); i++) {
					try{
						if (Integer.parseInt(tab.get((int)i).get("time").toString()) < mintime) {
							mintime = Integer.parseInt(tab.get((int)i).get("time").toString());
							minind = i;
						}
					}catch(Exception e){
						 
					}
				}
				int childCount = tabscontainer.getChildCount();
				sf.edit().putString("activetab", String.valueOf(0)).commit();
				
				try {
					    // Безпечне отримання значення для tagToMatch
					    Object tabValue = tab.get(minind).get("tab");
					    String tagToMatch = tabValue != null ? "ll" + tabValue.toString() : "";
					
					    if (!tagToMatch.isEmpty()) {
						        T--;
						        for (int i = childCount - 1; i >= 0; i--) {
							            View child = tabscontainer.getChildAt(i);
							
							            // Перевірка, чи є це LinearLayout і чи має він відповідний тег
							            if (child instanceof LinearLayout) {
								                LinearLayout childLinearLayout = (LinearLayout) child;
								
								                // Перевірка за тегом
								                if (tagToMatch.equals(childLinearLayout.getTag()) && childLinearLayout.getVisibility() == View.GONE) {
									                    // Пошук WebView всередині LinearLayout
									                    for (int j = 0; j < childLinearLayout.getChildCount(); j++) {
										                        View nestedChild = childLinearLayout.getChildAt(j);
										                        if (nestedChild instanceof WebView) {
											                            WebView webView = (WebView) nestedChild;
											
											                            // Зупиняємо завантаження та очищуємо WebView
											                            webView.stopLoading();
											                            webView.clearHistory();
											                            webView.loadUrl("about:blank");
											                            webView.onPause();
											                            webView.removeAllViews();
											
											                            // Видаляємо WebView з LinearLayout перед його знищенням
											                            childLinearLayout.removeView(webView);
											                            webView.destroy();
											                            webView = null;
											                            break;
											                        }
										                    }
									
									                    // Видаляємо LinearLayout з контейнера
									                    tabscontainer.removeView(childLinearLayout);
									                    
									
									tab.get((int)minind).put("time", "");
									tab.get((int)minind).put("tab", "");
									((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();
									sf.edit().putString("tabs", new Gson().toJson(tab)).commit();
									break;
									                }
								            }
							        }
						    }
				} catch (Exception e) {
					    // Логування помилки для діагностики
					    e.printStackTrace();
				} finally {
					    
					    // Оновлюємо текст
					    tabs.setText("[" + tab.size() + "]");
				}
				
				
			}
		}catch(Exception e){
			 
		}
	}
	
	
	public void _bgexec() {
		buttoncolors = 100000000;
		try{
			for (int i = 0; i < (int)(sitepermis.size()); i++) {
				if (tempurl.contains(sitepermis.get((int)i).get("url").toString())) {
					switch(sitepermis.get((int)i).get("ad").toString()) {
						case "1": {
							buttoncolors = buttoncolors + 1;
							break;
						}
						case "2": {
							buttoncolors = buttoncolors + 2;
							break;
						}
					}
					issu = true;
				}
			}
			if (!issu) {
				buttoncolors = buttoncolors + 2;
			}
		}catch(Exception e){
			buttoncolors = buttoncolors + 2;
		}
		issu = false;
		try{
			for (int i = 0; i < (int)(sitepermis.size()); i++) {
				if (tempurl.contains(sitepermis.get((int)i).get("url").toString())) {
					switch(sitepermis.get((int)i).get("if").toString()) {
						case "1": {
							buttoncolors = buttoncolors + 10;
							break;
						}
						case "2": {
							buttoncolors = buttoncolors + 20;
							break;
						}
					}
					issu = true;
				}
			}
			if (!issu) {
				buttoncolors = buttoncolors + 20;
			}
		}catch(Exception e){
			buttoncolors = buttoncolors + 20;
		}
		issu = false;
		try{
			for (int i = 0; i < (int)(sitepermis.size()); i++) {
				if (tempurl.contains(sitepermis.get((int)i).get("url").toString())) {
					switch(sitepermis.get((int)i).get("js").toString()) {
						case "1": {
							buttoncolors = buttoncolors + 100;
							break;
						}
						case "2": {
							buttoncolors = buttoncolors + 200;
							break;
						}
					}
					issu = true;
				}
			}
			if (!issu) {
				buttoncolors = buttoncolors + 200;
			}
		}catch(Exception e){
			buttoncolors = buttoncolors + 200;
		}
		issu = false;
		try{
			for (int i = 0; i < (int)(sitepermis.size()); i++) {
				if (tempurl.contains(sitepermis.get((int)i).get("url").toString())) {
					switch(sitepermis.get((int)i).get("th").toString()) {
						case "1": {
							buttoncolors = buttoncolors + 1000;
							break;
						}
						case "2": {
							buttoncolors = buttoncolors + 2000;
							break;
						}
					}
					issu = true;
				}
			}
			if (!issu) {
				buttoncolors = buttoncolors + 2000;
			}
		}catch(Exception e){
			buttoncolors = buttoncolors + 2000;
		}
		issu = false;
		try{
			for (int i = 0; i < (int)(sitepermis.size()); i++) {
				if (tempurl.contains(sitepermis.get((int)i).get("url").toString())) {
					switch(sitepermis.get((int)i).get("sr").toString()) {
						case "1": {
							buttoncolors = buttoncolors + 10000;
							break;
						}
						case "2": {
							buttoncolors = buttoncolors + 20000;
							break;
						}
					}
					issu = true;
				}
			}
			if (!issu) {
				buttoncolors = buttoncolors + 20000;
			}
		}catch(Exception e){
			buttoncolors = buttoncolors + 20000;
		}
		issu = false;
	}
	
	
	public void _postexec() {
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		switch(String.valueOf((long)(buttoncolors)).substring((int)(8), (int)(9))) {
			case "1": {
				Colorify.setButtonColor(blockad, Color.parseColor("#" + dataHolder.getData("bt")));
				blockad.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
							Skin skin = new Skin();
				skin.setBG(blockad, 0, false);
				break;
			}
			case "2": {
				Colorify.setButtonColor(blockad, Color.parseColor("#" + dataHolder.getData("cb")));			blockad.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
				blockad.setBackgroundColor(Color.TRANSPARENT);
				break;
			}
			case "0": {
				Colorify.setButtonColor(blockad, Color.parseColor("#" + dataHolder.getData("rbt")));			blockad.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
							Skin skin = new Skin();
				skin.setBG(blockad, 1, false);
				break;
			}
		}
		switch(String.valueOf((long)(buttoncolors)).substring((int)(7), (int)(8))) {
			case "1": {
				Colorify.setButtonColor(iframe, Color.parseColor("#" + dataHolder.getData("bt")));			iframe.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
							Skin skin = new Skin();
				skin.setBG(iframe, 0, false);
				break;
			}
			case "2": {
				Colorify.setButtonColor(iframe, Color.parseColor("#" + dataHolder.getData("cb")));					 iframe.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
				iframe.setBackgroundColor(Color.TRANSPARENT);
				break;
			}
			case "0": {
				Colorify.setButtonColor(iframe, Color.parseColor("#" + dataHolder.getData("rbt")));					iframe.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
							Skin skin = new Skin();
				skin.setBG(iframe, 1, false);
				break;
			}
		}
		switch(String.valueOf((long)(buttoncolors)).substring((int)(6), (int)(7))) {
			case "1": {
				Colorify.setButtonColor(js, Color.parseColor("#" + dataHolder.getData("bt")));					js.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
							Skin skin = new Skin();
				skin.setBG(js, 0, false);
				break;
			}
			case "2": {
						Colorify.setButtonColor(js, Color.parseColor("#" + dataHolder.getData("cb")));					js.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
				js.setBackgroundColor(Color.TRANSPARENT);
				break;
			}
			case "0": {
						Colorify.setButtonColor(js, Color.parseColor("#" + dataHolder.getData("rbt")));					js.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
							Skin skin = new Skin();
				skin.setBG(js, 1, false);
				break;
			}
		}
		switch(String.valueOf((long)(buttoncolors)).substring((int)(5), (int)(6))) {
			case "1": {
						Colorify.setButtonColor(themepage, Color.parseColor("#" + dataHolder.getData("bt")));					themepage.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
							Skin skin = new Skin();
				skin.setBG(themepage, 0, false);
				break;
			}
			case "2": {
						Colorify.setButtonColor(themepage, Color.parseColor("#" + dataHolder.getData("cb")));					themepage.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
				themepage.setBackgroundColor(Color.TRANSPARENT);
				break;
			}
			case "0": {
						Colorify.setButtonColor(themepage, Color.parseColor("#" + dataHolder.getData("rbt")));					themepage.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
							Skin skin = new Skin();
				skin.setBG(themepage, 1, false);
				break;
			}
		}
		switch(String.valueOf((long)(buttoncolors)).substring((int)(4), (int)(5))) {
			case "1": {
						Colorify.setButtonColor(swipetore, Color.parseColor("#" + dataHolder.getData("bt")));					swipetore.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
							Skin skin = new Skin();
				skin.setBG(swipetore, 0, false);
				break;
			}
			case "2": {
						Colorify.setButtonColor(swipetore, Color.parseColor("#" + dataHolder.getData("cb")));					swipetore.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
				swipetore.setBackgroundColor(Color.TRANSPARENT);
				break;
			}
			case "0": {
							Colorify.setButtonColor(swipetore, Color.parseColor("#" + dataHolder.getData("rbt")));				 swipetore.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
							Skin skin = new Skin();
				skin.setBG(swipetore, 1, false);
				break;
			}
		}
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
	
	
	public void _srhupd() {
		srhbuf.clear();
		for (int i = 0; i < (int)(srcsug.size()); i++) {
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("s", srcsug.get((int)(i)));
				srhbuf.add(_item);
			}
			
		}
		Collections.reverse(srhbuf);
		((BaseAdapter)srhhis.getAdapter()).notifyDataSetChanged();
	}
	
	
	public void _kbdsrh() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		
		if ((SafeMarginUtils.isKeyboardVisible(this) && focused) && selected) {
			if (!holdsearchtext) {
				holdsearchtext = true;
				((EditText)autocomplete1).setMaxLines((int)5);
				hide.setVisibility(View.GONE);
				refresh.setVisibility(View.GONE);
				openpanel.setVisibility(View.GONE);
				button3.setVisibility(View.GONE);
				linear16.setVisibility(View.VISIBLE);
				button1.setVisibility(View.VISIBLE);
				ssl.setVisibility(View.GONE);
			}
		}
		else {
			if (!holdsearchtext) {
				((EditText)autocomplete1).setMaxLines((int)1);
				button3.setVisibility(View.VISIBLE);
				linear16.setVisibility(View.GONE);
				button1.setVisibility(View.GONE);
				hide.setVisibility(View.VISIBLE);
				refresh.setVisibility(View.VISIBLE);
				openpanel.setVisibility(View.VISIBLE);
				ssl.setVisibility(View.VISIBLE);
			}
		}
		if (SafeMarginUtils.isKeyboardVisible(this) && focused) {
			if (!selected) {
				((EditText)autocomplete1).selectAll();
				selected = true;
			}
		}
		else {
			if (!holdsearchtext) {
				_webViewActions(0, "");
				selected = false;
			}
		}
		if (SafeMarginUtils.isKeyboardVisible(this) && !focused) {
			linear1.setVisibility(View.GONE);
			
			linear5.setVisibility(View.GONE);
			SafeMarginUtils.setFullscreenMode(this, 1);
			isshowpan = false;
		}
		else {
			if (!isshowpan) {
				linear1.setVisibility(View.VISIBLE);
				if (sf.getString("navpan", "").equals("1")) {
					linear5.setVisibility(View.VISIBLE);
				}
				SafeMarginUtils.setFullscreenMode(this, 0);
				isshowpan = true;
			}
		}
	}
	
	
	public String _getMultilink() {
		return ("https://multilink2.weekbrowser.com/".concat(encodeUrl(new Gson().toJson(tab))));
	}
	
	
	public void _openToast(final String _url) {
		try{
			this_is_not_a_toast_im_stupid_sorry.setTitle("?");
			this_is_not_a_toast_im_stupid_sorry.setMessage(getString(R.string.wantopen));
			this_is_not_a_toast_im_stupid_sorry.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					openInOtherApps(_url);
				}
			});
			this_is_not_a_toast_im_stupid_sorry.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			this_is_not_a_toast_im_stupid_sorry.create().show();
		}catch(Exception e){
			SketchwareUtil.showMessage(getApplicationContext(), "най го шляк трафе");
			((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", e.toString()));
		}
	}
	
	
	public void _sslerror() {
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		
		Skin skin = new Skin();
		skin.setBG(ssl, 1, true);
		ssl.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
	}
	
	
	public void _ifex3() {
		
	}
	
	
	public void _overrideload(final WebView _w, final String _url) {
		//final AtomicBoolean isu = new AtomicBoolean(false);
		//SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
	}
	
	
	public void _ops() {
	}void _onpagestart(WebView _w, String _url, Bitmap favicon){
		
		
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		Skin skin = new Skin();
		skin.setBG(ssl, 0, true);
		ssl.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		final AtomicBoolean isu = new AtomicBoolean(false);
		
		_w.getSettings().setSaveFormData(true);
		    _w.getSettings().setAllowFileAccess(true);
		    _w.getSettings().setAllowContentAccess(true);
		    _w.getSettings().setDatabaseEnabled(true);
		    _w.getSettings().setDomStorageEnabled(true);
		    _w.getSettings().setSupportMultipleWindows(true);
		        _setAll(_w);
		if (sf.getString("incognito", "").equals("0")) {
			final String url = _w.getUrl(); // Замість _w.getUrl() використовуйте відповідний метод для отримання URL
			        new Thread(new Runnable() {
				            @Override
				            public void run() {
					                if (url != null) {
						                    Calendar dnt = Calendar.getInstance();
						                    if (!(url.equals(getFilesDir().getPath()+"/bookmark.htm") || url.equals("about:blank"))) {
							                        if (sf.getString("incognito","").equals("0")) {
								                            synchronized (history) {
									                                HashMap<String, Object> _item = new HashMap<>();
									                                _item.put("name", "UNTITLED :-/");
									                                _item.put("url", url);
									                                _item.put("date", new SimpleDateFormat("dd/MM EE HH:mm").format(dnt.getTime()));
									                                history.add(_item);
									                                if (history.size() > Integer.parseInt(sf.getString("maxhistory", ""))) {
										                                    int numberOfItemsToRemove = history.size() - Integer.parseInt(sf.getString("maxhistory", ""));
										                                    history.subList(0, numberOfItemsToRemove).clear();
										                                }
									                            }
								                            synchronized (history) {
									                                FileUtil.writeFile(getFilesDir().getPath()+"/history.json", new Gson().toJson(history));
									                            }
								                        }
							                    }
						                }
					            }
				        }).start();
		}
		_Reopentab();
		try{
			if (Integer.parseInt(sf.getString("pc", "")) == 1) {
				_w.setInitialScale((int)Integer.parseInt(sf.getString("dp", ""))*5);_w.getSettings().setUserAgentString(sf.getString("uapc", ""));
				
			}
			else {
				_w.setInitialScale((int)Integer.parseInt(sf.getString("dp", ""))*10);_w.getSettings().setUserAgentString(sf.getString("ua", ""));
				
			}
			
			if (Internet && sf.getString("nointernet", "").equals("1")) {
				_w.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY);
			}
			else {
				if (Integer.parseInt(sf.getString("cache", "")) == 0) {
					_w.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
				}
				else {
					if (Integer.parseInt(sf.getString("cache", "")) == 1) {
						_w.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
					}
					else {
						if (Integer.parseInt(sf.getString("cache", "")) == 2) {
							_w.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
						}
						else {
							_w.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY);
						}
					}
				}
			}
			if (sf.getString("autofirstpage", "").equals("1") && (!_w.getUrl().equals("about:blank") && sf.getString("incognito", "").equals("0"))) {
				sf.edit().putString("firstpage", _url).commit();
			}
		}catch(Exception e){
			sf.edit().putString("firstpage", getFilesDir().getPath().concat("/bookmark.html")).commit();
		}
		((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();
		try{
			for (int i = 0; i < (int)(sitepermis.size()); i++) {
				if (_url.contains(sitepermis.get((int)i).get("url").toString())) {
					switch(sitepermis.get((int)i).get("js").toString()) {
						case "1": {
							_w.getSettings().setJavaScriptEnabled(true);
							_w.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
							if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
								    _w.getSettings().setAllowFileAccessFromFileURLs(true);
								    _w.getSettings().setAllowUniversalAccessFromFileURLs(true);
							}
							break;
						}
						case "2": {
							if (sf.getString("js", "").equals("1")) {
								_w.getSettings().setJavaScriptEnabled(true);
								_w.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
								if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
									    _w.getSettings().setAllowFileAccessFromFileURLs(true);
									    _w.getSettings().setAllowUniversalAccessFromFileURLs(true);
								}
							}
							else {
								_w.getSettings().setJavaScriptEnabled(false);
								_w.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
								if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
									    _w.getSettings().setAllowFileAccessFromFileURLs(true);
									    _w.getSettings().setAllowUniversalAccessFromFileURLs(true);
								}
								
							}
							break;
						}
						case "0": {
							_w.getSettings().setJavaScriptEnabled(false);
							_w.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
							if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
								    _w.getSettings().setAllowFileAccessFromFileURLs(true);
								    _w.getSettings().setAllowUniversalAccessFromFileURLs(true);
							}
							
							break;
						}
					}
					isu.set(true);
				}
			}
			if (!isu.get()) {
				if (sf.getString("js", "").equals("1")) {
					_w.getSettings().setJavaScriptEnabled(true);
					_w.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
					if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
						    _w.getSettings().setAllowFileAccessFromFileURLs(true);
						    _w.getSettings().setAllowUniversalAccessFromFileURLs(true);
					}
				}
				else {
					_w.getSettings().setJavaScriptEnabled(false);
					_w.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
					if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
						    _w.getSettings().setAllowFileAccessFromFileURLs(true);
						    _w.getSettings().setAllowUniversalAccessFromFileURLs(true);
					}
					
				}
			}
			isu.set(false);
		}catch(Exception e){
			if (sf.getString("js", "").equals("1")) {
				_w.getSettings().setJavaScriptEnabled(true);
				_w.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
				if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
					    _w.getSettings().setAllowFileAccessFromFileURLs(true);
					    _w.getSettings().setAllowUniversalAccessFromFileURLs(true);
				}
			}
			else {
				_w.getSettings().setJavaScriptEnabled(false);
				_w.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
				if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
					    _w.getSettings().setAllowFileAccessFromFileURLs(true);
					    _w.getSettings().setAllowUniversalAccessFromFileURLs(true);
				}
				
			}
			isu.set(false);
		}
		try{
			for (int i = 0; i < (int)(sitepermis.size()); i++) {
				if (_url.contains(sitepermis.get((int)i).get("url").toString())) {
					switch(sitepermis.get((int)i).get("ad").toString()) {
						case "1": {
							adbl = true;
							break;
						}
						case "2": {
							if (sf.getString("blockad", "").equals("1")) {
								adbl = true;
							}
							else {
								adbl = false;
							}
							break;
						}
						case "0": {
							adbl = false;
							break;
						}
					}
					isu.set(true);
				}
			}
			if (!isu.get()) {
				if (sf.getString("blockad", "").equals("1")) {
					adbl = true;
				}
				else {
					adbl = false;
				}
			}
			isu.set(false);
		}catch(Exception e){
			if (sf.getString("blockad", "").equals("1")) {
				adbl = true;
			}
			else {
				adbl = false;
			}
			isu.set(false);
		}
		if (sf.getString("loadimages", "").equals("1")) {
			_w.getSettings().setBlockNetworkImage(false);
			
			_w.getSettings().setLoadsImagesAutomatically(true);
		}
		else {
			_w.getSettings().setBlockNetworkImage(true);
			_w.getSettings().setLoadsImagesAutomatically(false);
		}
	}{
	}
	
	public class SrhhisAdapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public SrhhisAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.search, null);
			}
			
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			Animator2.anim(getApplicationContext(), textview1, 0, 100);
			textview1.setText(_data.get((int)_position).get("s").toString());
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			Skin skin = new Skin();
			
			skin.setBG(textview1, 0, false);
			
			textview1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			
			return _view;
		}
	}
	
	public class TabscontAdapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public TabscontAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.tab, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView fav = _view.findViewById(R.id.fav);
			final TextView name = _view.findViewById(R.id.name);
			final TextView close = _view.findViewById(R.id.close);
			
			int childCount;
			final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
			name.setText(((_data.get((int)_position).get("name")!=null) ? (_data.get((int)_position).get("name").toString()) : ("-")));
			try{
				if(_data.get((int)_position).get("fav")!=null && !_data.get((int)_position).get("fav").toString().equals("no")){
					   fav.setImageBitmap(BitmapEncoderDecoder.decodeFromBase64(_data.get((int)_position).get("fav").toString()));
					  }else{
					fav.setImageResource(R.drawable.default_image);}
			}catch(Exception e){
				fav.setImageResource(R.drawable.default_image);
			}
			close.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					int childCount = tabscontainer.getChildCount();
					sf.edit().putString("activetab", String.valueOf(0)).commit();
					
					try {
						    // Безпечне отримання значення для tagToMatch
						    Object tabValue = _data.get((int) _position).get("tab");
						    String tagToMatch = tabValue != null ? "ll" + tabValue.toString() : "";
						
						    if (!tagToMatch.isEmpty()) {
							        T--;
							        for (int i = childCount - 1; i >= 0; i--) {
								            View child = tabscontainer.getChildAt(i);
								
								            // Перевірка, чи є це LinearLayout і чи має він відповідний тег
								            if (child instanceof LinearLayout) {
									                LinearLayout childLinearLayout = (LinearLayout) child;
									
									                // Перевірка за тегом
									                if (tagToMatch.equals(childLinearLayout.getTag())) {
										                    // Пошук WebView всередині LinearLayout
										                    for (int j = 0; j < childLinearLayout.getChildCount(); j++) {
											                        View nestedChild = childLinearLayout.getChildAt(j);
											                        if (nestedChild instanceof WebView) {
												                            WebView webView = (WebView) nestedChild;
												
												                            // Зупиняємо завантаження та очищуємо WebView
												                            webView.stopLoading();
												                            webView.clearHistory();
												                            webView.loadUrl("about:blank");
												                            webView.onPause();
												                            webView.removeAllViews();
												
												                            // Видаляємо WebView з LinearLayout перед його знищенням
												                            childLinearLayout.removeView(webView);
												                            webView.destroy();
												                            webView = null;
												                            break;
												                        }
											                    }
										
										                    // Видаляємо LinearLayout з контейнера
										                    tabscontainer.removeView(childLinearLayout);
										                    break;
										                }
									            }
								        }
							    }
					} catch (Exception e) {
						    // Логування помилки для діагностики
						    e.printStackTrace();
					} finally {
						    
						    // Оновлюємо текст
						    tabs.setText("[" + (tab.size()-1) + "]•");
					}
					
					
					
					_data.remove((int)(_position));
					((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();
					try{
						int maxtime = 0;
						int maxind = 0;
						for (int i = 0; i < (int)(tab.size()); i++) {
							try{
								if (maxtime < Integer.parseInt(tab.get((int)i).get("time").toString())) {
									maxtime = Integer.parseInt(tab.get((int)i).get("time").toString());
									maxind = i;
								}
							}catch(Exception g){}
						}
						time++;
						tab.get((int)maxind).put("time", String.valueOf((long)(time)));
						sf.edit().putString("activetab", String.valueOf((long)(maxind))).commit();
						sf.edit().putString("tabs", new Gson().toJson(tab)).commit();
						dataHolder.setData("ml", "https://multilink2.weekbrowser.com/".concat(encodeUrl(new Gson().toJson(tab))));
					}catch(Exception e){
						notFirst = true;
						_newTab(sf.getString("firstpage", ""), true);
						
						dataHolder.setData("ml", "https://multilink2.weekbrowser.com/".concat(encodeUrl(new Gson().toJson(tab))));
					}
					_Reopentab();
				}
			});
			name.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					try{
						int prevpos = Integer.parseInt(sf.getString("activetab", ""));
						notFirst = false;
						int childCount = tabscontainer.getChildCount();
						boolean tabExists = false; // змінна для відстеження існування вкладки
						    time++;
						// Перевіряємо, чи існує відповідний тег
						String _dataKey = _data.get((int) _position).get("tab") != null ? _data.get((int) _position).get("tab").toString() : null;
						
						if (_dataKey != null) {
							    String tag = "ll" + _dataKey; // отримуємо тег
							
							    for (int i = 0; i < childCount; i++) {
								        LinearLayout childLinearLayout = (LinearLayout)tabscontainer.getChildAt(i);
								        // Перевірка за тегом
								        if (childLinearLayout.getTag() != null && childLinearLayout.getTag().equals(tag)) {
									            tabExists = true; // встановлюємо, що вкладка існує
									            break; // виходимо з циклу, якщо знайшли відповідний тег
									        }
								    }
						}
						
						// Якщо тег не знайдено або був null, створюємо нову вкладку
						if (!tabExists) {
							    if(_data.get((int)_position).get("url")!=null){
								        
								        
								            T++;
								    Tt++;
								    tabs.setText("[" + tab.size() + "]•");
								
								  //  if (notFirst) {
								     //   int currentActive_dataIndex = _data.size() + 1;
								sf.edit().putString("activetab", String.valueOf((long)(_position))).commit();
								
								        // Перевірка розміру списку перед доступом
								 _data.get((int)_position).put("tab", Tt);
								
								
								    
								 //   notFirst = true;
								
								    LinearLayout newWebViewContainer = new LinearLayout(MainActivity.this);
								    newWebViewContainer.setTag("ll" + String.valueOf(Tt));
								    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
								            ViewGroup.LayoutParams.MATCH_PARENT,
								            ViewGroup.LayoutParams.MATCH_PARENT
								    );
								    layoutParams.weight = 1; // Встановлення ваги
								    newWebViewContainer.setLayoutParams(layoutParams);
								
								    final WebView newWebView = new WebView(MainActivity.this);
								newWebView.getSettings().setJavaScriptEnabled(true);
								    setupWebView(newWebView, MainActivity.this);
								
								        newWebView.loadUrl(_data.get((int) _position).get("url").toString());  // Завантаження початкового URL для нової вкладки
								
								
								    newWebViewContainer.addView(newWebView, new LinearLayout.LayoutParams(
								            ViewGroup.LayoutParams.MATCH_PARENT,
								            ViewGroup.LayoutParams.MATCH_PARENT
								    ));
								
								    tabscontainer.addView(newWebViewContainer);
								
								        
								        }else{
								    
								    
								        T++;
								    Tt++;
								    tabs.setText("[" + (_data.size() - 1) + "]");
								int currentActivetabIndex = _data.size();
								
								 /*   if (notFirst) {
        
        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/activeTab.txt", String.valueOf(currentActivetabIndex));

        _Reopentab();
    }
    notFirst = true;*/
								
								    LinearLayout newWebViewContainer = new LinearLayout(MainActivity.this);
								    newWebViewContainer.setTag("ll" + String.valueOf(Tt));
								    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
								            ViewGroup.LayoutParams.MATCH_PARENT,
								            ViewGroup.LayoutParams.MATCH_PARENT
								    );
								    layoutParams.weight = 1; // Встановлення ваги
								    newWebViewContainer.setLayoutParams(layoutParams);
								
								    final WebView newWebView = new WebView(MainActivity.this);
								newWebView.getSettings().setJavaScriptEnabled(true);
								    setupWebView(newWebView, MainActivity.this);
								
								newWebView.loadUrl(sf.getString("firstpage", ""));  // Завантаження початкового URL для нової вкладки
								  
								
								    newWebViewContainer.addView(newWebView, new LinearLayout.LayoutParams(
								            ViewGroup.LayoutParams.MATCH_PARENT,
								            ViewGroup.LayoutParams.MATCH_PARENT
								    ));
								
								    tabscontainer.addView(newWebViewContainer);
								
								    
								    
								{
									HashMap<String, Object> _item = new HashMap<>();
									_item.put("tab", String.valueOf((long)(Tt)));
									_data.add(_item);
								}
								
								{
									HashMap<String, Object> _item = new HashMap<>();
									_item.put("url", sf.getString("firstpage", ""));
									_data.add(_item);
								}
								
							}}
						//if(prevpos == Integer.parseInt(sf.getString("activetab","")));
						tab.get(_position).put("time", time);
						((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();
						sf.edit().putString("activetab", String.valueOf((long)(_position))).commit();
						sf.edit().putString("tabs", new Gson().toJson(tab)).commit();
						dataHolder.setData("ml", "https://multilink2.weekbrowser.com/".concat(encodeUrl(new Gson().toJson(tab))));
					}catch(Exception e){
						SketchwareUtil.showMessage(getApplicationContext(), "error");
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", e.toString()));
					}
					_Reopentab();
				}
			});
			close.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					try{
						blockads.setTitle("?");
						blockads.setMessage(getString(R.string.blocksite1).concat(_extractDomain(_data.get((int)_position).get("url").toString())).concat(getString(R.string.blocksite2).concat(_data.get((int)_position).get("url").toString())));
						blockads.setPositiveButton("[    1    ]", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								sf.edit().putString("adhosts", sf.getString("adhosts", "").concat("\n").concat(_extractDomain(_data.get((int)_position).get("url").toString()).replace(".", "\\."))).commit();
								close.performClick();
							}
						});
						blockads.setNegativeButton("[    2    ]", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								sf.edit().putString("adhosts", sf.getString("adhosts", "").concat("\n%".concat(_data.get((int)_position).get("url").toString().replace(".", "\\.")))).commit();
								close.performClick();
							}
						});
						blockads.setNeutralButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						blockads.create().show();
					}catch(Exception e){
						SketchwareUtil.showMessage(getApplicationContext(), "error");
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", e.toString()));
					}
					return true;
				}
			});
			name.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					int childCount = tabscontainer.getChildCount();
					sf.edit().putString("activetab", String.valueOf(0)).commit();
					
					try {
						    // Безпечне отримання значення для tagToMatch
						    Object tabValue = _data.get((int) _position).get("tab");
						    String tagToMatch = tabValue != null ? "ll" + tabValue.toString() : "";
						
						    if (!tagToMatch.isEmpty()) {
							        T--;
							        for (int i = childCount - 1; i >= 0; i--) {
								            View child = tabscontainer.getChildAt(i);
								
								            // Перевірка, чи є це LinearLayout і чи має він відповідний тег
								            if (child instanceof LinearLayout) {
									                LinearLayout childLinearLayout = (LinearLayout) child;
									
									                // Перевірка за тегом
									                if (tagToMatch.equals(childLinearLayout.getTag())) {
										                    // Пошук WebView всередині LinearLayout
										                    for (int j = 0; j < childLinearLayout.getChildCount(); j++) {
											                        View nestedChild = childLinearLayout.getChildAt(j);
											                        if (nestedChild instanceof WebView) {
												                            WebView webView = (WebView) nestedChild;
												
												                            // Зупиняємо завантаження та очищуємо WebView
												                            webView.stopLoading();
												                            webView.clearHistory();
												                            webView.loadUrl("about:blank");
												                            webView.onPause();
												                            webView.removeAllViews();
												
												                            // Видаляємо WebView з LinearLayout перед його знищенням
												                            childLinearLayout.removeView(webView);
												                            webView.destroy();
												                            webView = null;
												                            break;
												                        }
											                    }
										
										                    // Видаляємо LinearLayout з контейнера
										                    tabscontainer.removeView(childLinearLayout);
										                    break;
										                }
									            }
								        }
							    }
					} catch (Exception e) {
						    // Логування помилки для діагностики
						    e.printStackTrace();
					} finally{
						_Reopentab();
						ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
						final int roundness = Integer.parseInt(dataHolder.getData("rou"));
						Skin skin = new Skin();
						skin.setBG(close, 1, false);
						close.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
						skin.setBG(linear1, 0, false);
						
						childCount = tabscontainer.getChildCount();
						String activeTabContent = sf.getString("activetab","");
						String tabTag = "";
						int activeTabIndex = Integer.parseInt(activeTabContent);
						if (_data.get((int)_position) != null) {
							        Object tabValue = _data.get((int)_position).get("tab");
							        if (tabValue != null) {
								            tabTag = "ll" + tabValue.toString();
								       }else{tabTag="";}}
						
						for (int i = 0; i < childCount; i++) {
							    LinearLayout childLinearLayout = (LinearLayout) tabscontainer.getChildAt(i);
							    
							    // Перевірка за тегом
							    if (childLinearLayout.getTag() != null && childLinearLayout.getTag().equals(tabTag)) {
								        
								        if(activeTabIndex == (int)_position){
									        // Знайдено потрібний LinearLayout
									     //   name.setText("тойво");
									        skin.setBG(name, 1, false);
									name.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
									break;
								}else{
									   // name.setText("не тойво");
									    skin.setBG(name, 0, false);
									    name.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
									
									break;
									    }
								    }else{
								       // name.setText("клоун бля");
								        skin.setBG(name, 2, false);
								        name.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
								
								        }
						}
						
						
					}
					return true;
				}
			});
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			final int roundness = Integer.parseInt(dataHolder.getData("rou"));
			Skin skin = new Skin();
			skin.setBG(close, 1, false);
			close.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			skin.setBG(linear1, 0, false);
			
			childCount = tabscontainer.getChildCount();
			String activeTabContent = sf.getString("activetab", "");
			String tabTag = "";
			int activeTabIndex = Integer.parseInt(activeTabContent);
			if (_data.get((int)_position) != null) {
				        Object tabValue = _data.get((int)_position).get("tab");
				        if (tabValue != null) {
					            tabTag = "ll" + tabValue.toString();
					       }else{tabTag="";}}
			
			for (int i = 0; i < childCount; i++) {
				    LinearLayout childLinearLayout = (LinearLayout) tabscontainer.getChildAt(i);
				    
				    // Перевірка за тегом
				    if (childLinearLayout.getTag() != null && childLinearLayout.getTag().equals(tabTag)) {
					        
					        if(activeTabIndex == (int)_position){
						        // Знайдено потрібний LinearLayout
						     //   name.setText("тойво");
						        skin.setBG(name, 1, false);
						name.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
						break;
					}else{
						   // name.setText("не тойво");
						    skin.setBG(name, 0, false);
						    name.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
						
						break;
						    }
					    }else{
					       // name.setText("клоун бля");
					        skin.setBG(name, 2, false);
					        name.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
					
					        }
			}
			
			
			return _view;
		}
	}
}