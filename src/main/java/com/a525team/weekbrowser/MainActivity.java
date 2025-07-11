package com.a525team.weekbrowser;

import android.Manifest;
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
import android.content.pm.PackageManager;
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

public class MainActivity extends Activity {
	
	public final int REQ_CD_FP = 101;
	
	private Timer _timer = new Timer();
	
	private String URL = "";
	private String info = "";
	private double i = 0;
	private String imageUrl = "";
	private double not = 0;
	private boolean cookie = false;
	private double minsiz = 0;
	private boolean PC = false;
	private double theme = 0;
	private double buttonId = 0;
	private boolean cache = false;
	private boolean Internet = false;
	private String content = "";
	private String filePath = "";
	private double curnum = 0;
	private double allnum = 0;
	private String searchText = "";
	private double prevY = 0;
	private boolean isSuper = false;
	private String temp = "";
	private String clip = "";
	private double notemptytab = 0;
	private String previntent = "";
	private boolean focused = false;
	private boolean selected = false;
	private String url = "";
	private double width1 = 0;
	private double height1 = 0;
	private boolean is1window = false;
	private double width2 = 0;
	private double height2 = 0;
	private double width3 = 0;
	private double height3 = 0;
	private double width4 = 0;
	private double height4 = 0;
	private double width5 = 0;
	private double height5 = 0;
	private double width6 = 0;
	private double height6 = 0;
	private boolean is1touch = false;
	private boolean is2touch = false;
	private boolean is3touch = false;
	private boolean is4touch = false;
	private boolean is5touch = false;
	private boolean is6touch = false;
	private boolean issu = false;
	private String tempurl = "";
	private String copy = "";
	private boolean statush = false;
	private boolean wininit = false;
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
	private boolean isredrawbuttons = false;
	private String designbmlcache = "";
	private String fffff = "";
	private boolean adbl = false;
	private boolean adbl2 = false;
	private boolean adbl3 = false;
	private boolean adbl4 = false;
	private boolean adbl5 = false;
	private boolean adbl6 = false;
	private double adsblockedd = 0;
	private String themebml = "";
	private String bml01 = "";
	private String bml02 = "";
	private String bml03 = "";
	private String bml04 = "";
	private String bml05 = "";
	private String bml06 = "";
	private String bml11 = "";
	private String bml12 = "";
	int T;
	int Tt;
	private boolean notFirst = false;
	int ATt;
	private Timer times;
	private TimerTask timerTask;
	private double load = 0;
	private double wwpos = 0;
	int time;
	private String memoryUsageText = "";
	int usedMemoryMB;
	private boolean holdsearchtext = false;
	private String blockedlineg = "";
	private boolean recentlyreleased = false;
	ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	private boolean isAd = false;
	private String blockedline = "";
	Colorify Colorify = new Colorify();
	private boolean Foreground = false;
	private String prevCharSeq = "";
	
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
	private LinearLayout linear11;
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
	private Button bml1;
	private Button bml2;
	private Button bml3;
	private Button bml4;
	private Button bml5;
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
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
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
		SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		if (_ispermission() || !sf.contains("lang")) {
				intent.setClass(getApplicationContext(), GrantActivity.class);
				finishAffinity();
				startActivity(intent);
		}
		try{
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
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
						            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
						            layoutParams.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
						            getWindow().setAttributes(layoutParams);
						        }
				   
				        
				        super.onCreate(_savedInstanceState);
				
				        setContentView(R.layout.main);
		}catch(Exception e){
				 
		}
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
		linear11 = findViewById(R.id.linear11);
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
		bml1 = findViewById(R.id.bml1);
		bml2 = findViewById(R.id.bml2);
		bml3 = findViewById(R.id.bml3);
		bml4 = findViewById(R.id.bml4);
		bml5 = findViewById(R.id.bml5);
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
		fp.setType("*/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		blockads = new AlertDialog.Builder(this);
		this_is_not_a_toast_im_stupid_sorry = new AlertDialog.Builder(this);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		sf2 = getSharedPreferences("code", Activity.MODE_PRIVATE);
		
		srhhis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				/*
autocomplete1.requestFocus();
kbd = true;
focused = true;
autocomplete1.setText(srhbuf.get((int)_position).get("s").toString());
_kbdsrh();
*/
				if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt").equals("0")) {
					URL = "https://www.google.com/search?q=".concat(srhbuf.get((int)_position).get("s").toString());
				}
				if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt").equals("1")) {
					URL = "https://www.bing.com/search?q=".concat(srhbuf.get((int)_position).get("s").toString());
				}
				if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt").equals("2")) {
					URL = "https://search.yahoo.com/search?p=".concat(srhbuf.get((int)_position).get("s").toString());
				}
				if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt").equals("3")) {
					URL = "https://duckduckgo.com/?t=h_&q=".concat(srhbuf.get((int)_position).get("s").toString());
				}
				_webViewActions(10, URL);
			}
		});
		
		srhhis.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				srcsug.remove((int)((srhbuf.size() - 1) - _position));
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/search.txt", new Gson().toJson(srcsug));
				_srhupd();
				return true;
			}
		});
		
		widthm1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try{
					if (Integer.parseInt(tab.get((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"))).get("w").toString().replace("s", "")) > 1) {
						tab.get((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"))).put("w", "s".concat(String.valueOf((long)(Integer.parseInt(tab.get((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"))).get("w").toString().replace("s", "")) - 1))));
					}
				}catch(Exception e){
					tab.get((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"))).put("w", "s1");
				}
				_restorewindowparam();
			}
		});
		
		widthp1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try{
					if (Integer.parseInt(tab.get((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"))).get("w").toString().replace("s", "")) < 4) {
						tab.get((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"))).put("w", "s".concat(String.valueOf((long)(Integer.parseInt(tab.get((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"))).get("w").toString().replace("s", "")) - -1))));
					}
				}catch(Exception e){
					tab.get((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"))).put("w", "s3");
				}
				_restorewindowparam();
			}
		});
		
		heightm1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try{
					if (Integer.parseInt(tab.get((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"))).get("h").toString().replace("s", "")) > 1) {
						tab.get((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"))).put("h", "s".concat(String.valueOf((long)(Integer.parseInt(tab.get((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"))).get("h").toString().replace("s", "")) - 1))));
					}
				}catch(Exception e){
					tab.get((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"))).put("h", "s1");
				}
				_restorewindowparam();
			}
		});
		
		heightp1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try{
					if (Integer.parseInt(tab.get((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"))).get("h").toString().replace("s", "")) < 4) {
						tab.get((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"))).put("h", "s".concat(String.valueOf((long)(Integer.parseInt(tab.get((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"))).get("h").toString().replace("s", "")) - -1))));
					}
				}catch(Exception e){
					tab.get((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"))).put("h", "s3");
				}
				_restorewindowparam();
			}
		});
		
		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				notFirst = true;
				_newTab(FileUtil.readFile("/storage/emulated/0/WeekBrowser/firstpage.txt"), true);
				((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();_Reopentab();
			}
		});
		
		//OnTouch
		closeall.setOnTouchListener(new View.OnTouchListener(){
				@Override
				public boolean onTouch(View v, MotionEvent event){
						int ev = event.getAction();
						switch (ev) {
								case MotionEvent.ACTION_DOWN:
								
								 SketchwareUtil.showMessage(getApplicationContext(), "В розробці, брат...😔💪🥀");
					/*
int childCount = tabscontainer.getChildCount();

try {
    // Ініціалізація змінної T
    T = 0;

    // Видалення вкладок з масиву і запис в файл перед видаленням з контейнера
    FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Tabs.json", "[]");
    tab = new Gson().fromJson("[]", new TypeToken<ArrayList<HashMap<String, Object>>>() {}.getType());
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

    // Оновлення GridView
    ((BaseAdapter) tabscont.getAdapter()).notifyDataSetChanged();

    // Створення нової вкладки
    _newTab(FileUtil.readFile("/storage/emulated/0/WeekBrowser/firstpage.txt"), true);
    _Reopentab();

} catch (Exception e) {
    e.printStackTrace();
} finally {
    // Оновлення тексту або будь-яка інша логіка в finally
}

int childCount = tabscontainer.getChildCount();
//FileUtil.writeFile("/storage/emulated/0/WeekBrowser/activeTab.txt", String.valueOf(0));

try {
        T=0;
        for (int i = childCount - 1; i >= 0; i--) {
            View child = tabscontainer.getChildAt(i);

            // Перевірка, чи є це LinearLayout і чи має він відповідний тег
            if (child instanceof LinearLayout) {
                LinearLayout childLinearLayout = (LinearLayout) child;

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
    
} catch (Exception e) {
    // Логування помилки для діагностики
    e.printStackTrace();
} finally {
    
    // Оновлюємо текст

}





FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Tabs.json", "[]");
tab = new Gson().fromJson("[]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
notFirst = true;
_newTab(FileUtil.readFile("/storage/emulated/0/WeekBrowser/firstpage.txt"), true);
((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();_Reopentab();
*/
								
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
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(sitepermis));
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
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(sitepermis));
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
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(sitepermis));
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
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/IfameBlock.txt")) == 0) {
					iframe.setChecked(true);
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/IfameBlock.txt", "1");
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/IfameBlock.txt", "0");
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
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(sitepermis));
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
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(sitepermis));
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
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(sitepermis));
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
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Swipetorefresh.txt")) == 0) {
					swipetore.setChecked(true);
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Swipetorefresh.txt", "1");
					_Reopentab();
				}
				else {
					swipetore.setChecked(false);
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Swipetorefresh.txt", "0");
					_Reopentab();
				}
			}
		});
		
		dp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				textview5.setText(getString(R.string.qs_uisize).concat(" (").concat(String.valueOf((long)(dp.getProgress() * 10)).concat(")")));
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Sizes/dp.txt", String.valueOf((long)(_progressValue)));
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
								
								if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/PC.txt")) == 1) {
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
				textview3.setText(getString(R.string.qs_fontsize).concat(" (").concat(String.valueOf((long)(_progressValue * 10)).concat("%)")));
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Sizes/fontsize.txt", String.valueOf((long)(_progressValue)));
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
				textview2.setText(getString(R.string.qs_minfont).concat(" (").concat(String.valueOf((long)(_progressValue)).concat(")")));
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Sizes/minfont.txt", String.valueOf((long)(_progressValue)));
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
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(sitepermis));
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
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(sitepermis));
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
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(sitepermis));
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
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/themepage.txt")) == 0) {
					themepage.setChecked(true);
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/themepage.txt", "1");
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/themepage.txt", "0");
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
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(sitepermis));
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
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(sitepermis));
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
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(sitepermis));
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
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/js.txt")) == 0) {
					js.setChecked(true);
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/js.txt", "1");
				}
				else {
					js.setChecked(false);
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/js.txt", "0");
				}
			}
		});
		
		pc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/PC.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/PC.txt", "1");
					pc.setChecked(true);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/PC.txt", "0");
					pc.setChecked(false);
				}
			}
		});
		
		incognito.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
				
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/incognito.txt")) == 0) {
					incognito.setChecked(true);
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/incognito.txt", "1");
					openpanel.setText("");
					Skin skin = new Skin();
					skin.setBG(openpanel, 1, true);
					openpanel.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
					if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/NoScreen.txt").equals("1")) {
						getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
					}
				}
				else {
					incognito.setChecked(false);
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/incognito.txt", "0");
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
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/LoadImages.txt")) == 0) {
					image.setChecked(true);
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/LoadImages.txt", "1");
					_webViewActions(1998, "");
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/LoadImages.txt", "0");
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
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(sitepermis));
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
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(sitepermis));
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
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", new Gson().toJson(sitepermis));
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
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/BlockAd.txt")) == 0) {
					blockad.setChecked(true);
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/BlockAd.txt", "1");
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/BlockAd.txt", "0");
				}
			}
		});
		
		bml1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webViewActions(10, _replaceInstructions(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20001.txt")));
			}
		});
		
		bml2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webViewActions(10, _replaceInstructions(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20002.txt")));
			}
		});
		
		bml3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webViewActions(10, _replaceInstructions(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20003.txt")));
			}
		});
		
		bml4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webViewActions(10, _replaceInstructions(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20004.txt")));
			}
		});
		
		bml5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webViewActions(10, _replaceInstructions(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20005.txt")));
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
				_webViewActions(10, "file:///storage/emulated/0/WeekBrowser/bookmark.html");
				return true;
			}
		});
		
		home.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webViewActions(10, FileUtil.readFile("/storage/emulated/0/WeekBrowser/firstpage.txt"));
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
				notFirst = true;
				_newTab(FileUtil.readFile("/storage/emulated/0/WeekBrowser/firstpage.txt"), true);
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
				if (is1window) {
					_savewindowparam();
					windowpos = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/windows.json"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
					/*
FileUtil.writeFile("/storage/emulated/0/WeekBrowser/windows.json", new Gson().toJson(windowpos));
*/
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
				}
				else {
					is1window = true;
					_restorewindowparam();
					/*
windowpos = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/windows.json"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
FileUtil.writeFile("/storage/emulated/0/WeekBrowser/windows.json", new Gson().toJson(windowpos));
*/
				}
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
							            
							     
							               
							if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/PC.txt")) == 1) {
								webView.setInitialScale((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/dp.txt"))*5);
							}
							else {
								webView.setInitialScale((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/dp.txt"))*10);
							}
							 } else if (child instanceof ViewGroup) {
							                    // Якщо дочірній елемент є ViewGroup (наприклад, LinearLayout), додаємо його до стеку для подальшого оброблення
							                    stack.push((ViewGroup) child);
							                }
						            }
					        }
				    
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
				autocomplete1.setText(autocomplete1.getText().toString().replaceAll(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/10.txt"), FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/11.txt")));
				autocomplete1.setText(autocomplete1.getText().toString().replaceAll(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/20.txt"), FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/21.txt")));
				autocomplete1.setText(autocomplete1.getText().toString().replaceAll(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/30.txt"), FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/31.txt")));
				autocomplete1.setText(autocomplete1.getText().toString().replaceAll(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/40.txt"), FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/41.txt")));
				autocomplete1.setText(autocomplete1.getText().toString().replaceAll(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/50.txt"), FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/51.txt")));
				_webViewActions(10, autocomplete1.getText().toString());
				return true;
			}
		});
		
		hide.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear1.setVisibility(View.GONE);
				linear5.setVisibility(View.GONE);
				getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_FULLSCREEN
				        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
				        | View.SYSTEM_UI_FLAG_IMMERSIVE);
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
				autocomplete1.setText(autocomplete1.getText().toString().replaceAll(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/10.txt"), FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/11.txt")));
				autocomplete1.setText(autocomplete1.getText().toString().replaceAll(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/20.txt"), FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/21.txt")));
				autocomplete1.setText(autocomplete1.getText().toString().replaceAll(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/30.txt"), FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/31.txt")));
				autocomplete1.setText(autocomplete1.getText().toString().replaceAll(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/40.txt"), FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/41.txt")));
				autocomplete1.setText(autocomplete1.getText().toString().replaceAll(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/50.txt"), FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/51.txt")));
				return true;
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (autocomplete1.getText().toString().startsWith("javascript:")||autocomplete1.getText().toString().contains(".")) {
					URL = autocomplete1.getText().toString();
				}
				else {
					if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt").equals("0")) {
						URL = "https://www.google.com/search?q=".concat(autocomplete1.getText().toString());
					}
					if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt").equals("1")) {
						URL = "https://www.bing.com/search?q=".concat(autocomplete1.getText().toString());
					}
					if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt").equals("2")) {
						URL = "https://search.yahoo.com/search?p=".concat(autocomplete1.getText().toString());
					}
					if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt").equals("3")) {
						URL = "https://duckduckgo.com/?t=h_&q=".concat(autocomplete1.getText().toString());
					}
					if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/incognito.txt").equals("0")) {
						srcsug = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/search.txt"), new TypeToken<ArrayList<String>>(){}.getType());
						srcsug.add(autocomplete1.getText().toString().trim());
						Set<String> uniqueValues = new LinkedHashSet<>(srcsug);
						        srcsug.clear();
						        srcsug.addAll(uniqueValues);
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/search.txt", new Gson().toJson(srcsug));
						_srhupd();
					}
				}
				_webViewActions(10, URL);
				closeeditor.performClick();
				prevCharSeq = "";
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
				if (settingspanel.getVisibility() == View.VISIBLE) {
					settingspanel.setVisibility(View.GONE);
					if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/NavPan.txt")) == 0) {
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
					if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/NavPan.txt")) == 0) {
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
		if (!_ispermission()) {
			_onIntent();
			_colorToRam();
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/incognito.txt").equals("1")) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Tabs.json", "[{\"name\":\"bookmark.html\",\"url\":\"file:///storage/emulated/0/WeekBrowser/bookmark.html\"}]");
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/activeTab.txt", "0");
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/incognito.txt", "0");
			}
			info = "";
			textview1.setText(info);
			_ifex();
			_clearonexit();
			_settabswindow();
			_restorewindowparam();
			tab = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Tabs.json"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			for (HashMap<String, Object> map : tab) {
				            map.remove("tab");
				            map.remove("time");
				        }
			if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt")) > (tab.size() - 1)) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/activeTab.txt", String.valueOf((long)(tab.size() - 1)));
			}
			            T++;
			    Tt++;
			    time++;
			    tabs.setText("[" + tab.size() + "]•");
			
			  //  if (notFirst) {
			     //   int currentActive_dataIndex = _data.size() + 1;
			        int _position = Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"));
			
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
			srhhis.setAdapter(new SrhhisAdapter(srhbuf));
			_srhupd();
			font.setProgress((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/fontsize.txt")));
			seekbar1.setProgress((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/minfont.txt")));
			dp.setProgress((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/dp.txt")));
			textview5.setText(getString(R.string.qs_uisize).concat(" (").concat(String.valueOf((long)(dp.getProgress() * 10)).concat(")")));
			textview3.setText(getString(R.string.qs_fontsize).concat(" (").concat(String.valueOf((long)(font.getProgress() * 10)).concat("%)")));
			textview2.setText(getString(R.string.qs_minfont).concat(" (").concat(String.valueOf((long)(seekbar1.getProgress())).concat(")")));
			settingspanel.setVisibility(View.GONE);
			((EditText)autocomplete1).setMaxLines((int)1);
			((EditText)search).setMaxLines((int)3);
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/NavPan.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/NavPan.txt", "1");
			}
			if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/BlockAd.txt")) == 1) {
				blockad.setChecked(true);
			}
			else {
				blockad.setChecked(false);
			}
			if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/IfameBlock.txt")) == 1) {
				iframe.setChecked(true);
			}
			else {
				iframe.setChecked(false);
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/NavPan.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/NavPan.txt", "1");
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
								_titl();
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(timer, (int)(149), (int)(150));
			timer = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							if (Foreground) {
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
											        int timeoutMs = 1500;
											        Socket sock = new Socket();
											        SocketAddress sockaddr = new InetSocketAddress("8.8.8.8", 53);
											
											        sock.connect(sockaddr, timeoutMs);
											        sock.close();
											
											        Internet=false;
											    } catch (IOException e) {Internet=true;}
										
										
										            }
									        }).start();
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(timer, (int)(1499), (int)(1500));
			pos1.setText("(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posx1.txt").concat("; ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posy1.txt").concat(")")))));
			pos2.setText("(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posx2.txt").concat("; ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posy2.txt").concat(")")))));
			pos3.setText("(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posx3.txt").concat("; ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posy3.txt").concat(")")))));
			timer = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							if (Foreground) {
								if (statush) {
									getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_FULLSCREEN
									        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
									        | View.SYSTEM_UI_FLAG_IMMERSIVE);
									isnotchfullscreen = true;
								}
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
							if (Foreground) {
								if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/dev/usedram.txt").equals("1")) {
									ramuse.setText(memoryUsageText);
								}
							}
							_ramoptimizer();
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(timer, (int)(2999), (int)(3000));
			timer = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							if (Foreground) {
								if (!focused) {
									if (!ismovedpanels) {
										if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Navpanelpos.txt").equals("1")) {
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
										if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Searchpanelpos.txt").equals("1")) {
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
								_webViewActions(1999, "");
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(timer, (int)(0), (int)(1000));
			_swipe();
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FP:
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
	}
	
	@Override
	public void onBackPressed() {
		_webViewActions(100001, "");
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if (!_ispermission()) {
			Foreground = true;
			synchronized(tab) {
				if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/url")) {
					if (!FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/bgtab") && !FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/sametab")) {
						_newTab(FileUtil.readFile("/storage/emulated/0/WeekBrowser/url"), true);
					}
					if (!FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/bgtab") && FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/sametab")) {
						_webViewActions(10, FileUtil.readFile("/storage/emulated/0/WeekBrowser/url"));
					}
					if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/bgtab") && !FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/sametab")) {
						_newTab(FileUtil.readFile("/storage/emulated/0/WeekBrowser/url"), false);
					}
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Tabs.json", new Gson().toJson(tab));
					FileUtil.deleteFile("/storage/emulated/0/WeekBrowser/bgtab");
					FileUtil.deleteFile("/storage/emulated/0/WeekBrowser/sametab");
					FileUtil.deleteFile("/storage/emulated/0/WeekBrowser/url");
					((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();
					_Reopentab();
				}
			}
			srcsug = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/search.txt"), new TypeToken<ArrayList<String>>(){}.getType());
			_srhupd();
			((BaseAdapter)srhhis.getAdapter()).notifyDataSetChanged();
			try{
				
				
				/*
int childCount = tabscontainer.getChildCount();
boolean tabExists = false; // змінна для відстеження існування вкладки
final int _position = Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"));
// Перевіряємо, чи існує відповідний тег
String tabKey = tab.get((int) _position).get("tab") != null ? tab.get((int) _position).get("tab").toString() : null;

if (tabKey != null) {
    String tag = "ll" + tabKey; // отримуємо тег

    for (int i = 0; i < childCount; i++) {
        LinearLayout childLinearLayout = (LinearLayout)tabscontainer.getChildAt(i);
        // Перевірка за тегом
        if (childLinearLayout.getTag() != null && childLinearLayout.getTag(_position).equals(tag)) {
            tabExists = true; // встановлюємо, що вкладка існує
            break; // виходимо з циклу, якщо знайшли відповідний тег
        }
    }
}

// Якщо тег не знайдено або був null, створюємо нову вкладку
if (!tabExists) {
    if(tab.get((int)_position).get("url")!=null){
        
        
            T++;
    Tt++;
    tabs.setText("[" + String.valueOf(T) + "/" + tab.size() + "]");

        // Перевірка розміру списку перед доступом
 tab.get(_position).put("tab", Tt);


    
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
        newWebView.setTag("w" + String.valueOf(Tt));
    setupWebView(newWebView, MainActivity.this);

    newWebView.postDelayed(new Runnable() {
    @Override
    public void run() {
        newWebView.loadUrl(tab.get((int) _position).get("url").toString());  // Завантаження початкового URL для нової вкладки
    }
}, 10);

    newWebViewContainer.addView(newWebView, new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
    ));

    tabscontainer.addView(newWebViewContainer);

        
        }}else{
            
        }
            

_Reopentab();*/
			}catch(Exception e){
				 
			}
			designbmlcache = FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache/bmkdsgn.txt");
			themebml = JSutil.replaceInstruction("javascript:(function(){var n=function(w){(function(d){var bg='$bggrad$';var btn='$buttongrad$';var btnFocus='$redgrad$';var text='$coltext$';var inputText='$colfield$';var border='$coladd$';var link='$colcomp$';var linkVisited='$coltrack$';var linkHover='$colthumb$';var inputBorder='$coladd$';var focusOutline='$colhint$';var focusBg='#00000000';var focusBorder='$coladd$';var scrollBase='$colhint$';var scrollFace='$colthumb$';var scrollShadow='$colcomp$';var scrollDarkShadow='$coladd$';var scrollTrack='$coltrack$';var scrollArrow='$coltext$';var scroll3dLight='$colhint$';var btnText='$colbtxt$';var btnFocusText='$colrbtxt$';var borderRadius='$buttonround$';var css=`html{background:${bg}!important}html *{background:none!important;color:${text}!important;border-color:${border}!important;border-width:0!important;border-radius:${borderRadius}!important}html a,html a *{color:${link}!important;text-decoration:underline!important}html a:visited,html a:visited *,html a:active,html a:active *{color:${linkVisited}!important}html a:hover,html a:hover *{color:${text}!important;background:${linkHover}!important}html input,html select,html button,html textarea{background:transparent!important;color:${inputText}!important;border:1px solid ${inputBorder}!important;border-radius:${borderRadius}!important}html input[type=button],html input[type=submit],html input[type=reset],html input[type=image],html button{background:${btn}!important;color:${btnText}!important;border:none!important}html input:focus,html select:focus,html option:focus,html button:focus,html textarea:focus{background:${focusBg}!important;color:${inputText}!important;border-color:${focusBorder}!important;outline:2px solid ${focusOutline}!important}html input[type=button]:focus,html input[type=submit]:focus,html input[type=reset]:focus,html input[type=image]:focus,html button:focus{background:${btnFocus}!important;color:${btnFocusText}!important;border:none!important}html input[type=radio]{background:none!important;border-color:${focusBorder}!important;border-width:0!important}html img[src],html input[type=image]{opacity:.9!important}html img[src]:hover,html input[type=image]:hover{opacity:1!important}html,html body{scrollbar-base-color:${scrollBase}!important;scrollbar-face-color:${scrollFace}!important;scrollbar-shadow-color:${scrollShadow}!important;scrollbar-darkshadow-color:${scrollDarkShadow}!important;scrollbar-track-color:${scrollTrack}!important;scrollbar-arrow-color:${scrollArrow}!important;scrollbar-3dlight-color:${scroll3dLight}!important}html span,html p,html div,html a{color:${text}!important}html button svg,html button svg path{fill:${btnText}!important}html button *{color:${btnText}!important}`;var s=d.getElementsByTagName('style');for(var i=0,si;si=s[i];i++){if(si.innerHTML==css){return}}var heads=d.getElementsByTagName('head');if(heads.length){var node=d.createElement('style');node.type='text/css';node.appendChild(d.createTextNode(css));heads[0].appendChild(node)}})(w.document);for(var i=0,f;f=w.frames[i];i++){try{arguments.callee(f)}catch(e){}}};n(window)})();"
			) ;
			bml01 = _replaceInstructions(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/1.txt"));
			bml02 = _replaceInstructions(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/2.txt"));
			bml03 = _replaceInstructions(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/3.txt"));
			bml04 = _replaceInstructions(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/4.txt"));
			bml05 = _replaceInstructions(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/5.txt"));
			bml06 = _replaceInstructions(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/6.txt"));
			bml11 = _replaceInstructions(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/10001.txt"));
			bml12 = _replaceInstructions(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/10002.txt"));
			ismovedpanels = false;
			isnotchfullscreen = false;
			_verifynew();
			_buttonsizeset();
			srcsug = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/search.txt"), new TypeToken<ArrayList<String>>(){}.getType());
			getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
			
			linear1.setVisibility(View.VISIBLE);
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/")) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/InfoText.txt")) == 1) {
					textview1.setGravity(Gravity.CENTER_HORIZONTAL);
				}
				else {
					textview1.setGravity(Gravity.LEFT);
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/PC.txt")) == 1) {
					pc.setChecked(true);
				}
				else {
					pc.setChecked(false);
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/LoadImages.txt")) == 1) {
					image.setChecked(true);
				}
				else {
					image.setChecked(false);
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/themepage.txt")) == 1) {
					themepage.setChecked(true);
				}
				else {
					themepage.setChecked(false);
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Swipetorefresh.txt")) == 1) {
					swipetore.setChecked(true);
				}
				else {
					swipetore.setChecked(false);
				}
				
				
			}
			if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/NavPan.txt")) == 1) {
				linear5.setVisibility(View.VISIBLE);
			}
			else {
				linear5.setVisibility(View.GONE);
			}
			_colorToRam();
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			bml5.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));bml4.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));bml3.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));bml2.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));	multilink.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			 
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
						    if(FileUtil.readFile("/storage/emulated/0/WeekBrowser/incognito.txt").equals("1")){openpanel.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));}else{openpanel.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
				                        }
						bookmarks.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
						button3.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
						textview1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			coordinates.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			pos1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			pos2.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			pos3.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
						
						
						
			
			
			
			bml1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			
			
			
			
			widthp1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			
			widthm1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			
			heightp1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			
			heightm1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			
			cururl.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			
			// Приклад використання класу Skin для встановлення фонів
			Skin skin = new Skin();
			
			skin.setBG(heightm1, 0, true);
			skin.setBG(selall, 0, true);
			skin.setBG(back, 0, true);
			skin.setBG(heightp1, 0, true);
			skin.setBG(widthm1, 0, true);
			skin.setBG(widthp1, 0, true);
			skin.setBG(bml1, 0, false);
			skin.setBG(bml2, 0, false);
			skin.setBG(bml3, 0, false);
			skin.setBG(bml4, 0, false);
			skin.setBG(bml5, 0, false);
			skin.setBG(pos1, 0, false);
			skin.setBG(pos2, 0, false);
			skin.setBG(pos3, 0, false);
			skin.setBG(skipvideo, 0, true);
			skin.setBG(hide, 0, true);
			skin.setBG(button1, 0, true);
			
			if(FileUtil.readFile("/storage/emulated/0/WeekBrowser/incognito.txt").equals("1")) {
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
			skin.setBG(pagesearch, 0, false);
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
			bml1.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20001n.txt"));
			bml2.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20002n.txt"));
			bml3.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20003n.txt"));
			bml4.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20004n.txt"));
			bml5.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20005n.txt"));
			_language();
			if (!FileUtil.readFile("/storage/emulated/0/ColorPicker/color.txt").isEmpty()) {
				intent.setClass(getApplicationContext(), CustomthemeActivity.class);
				startActivity(intent);
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/monofortextarea.txt").equals("1")) {
				autocomplete1.setTypeface(Typeface.MONOSPACE);
				search.setTypeface(Typeface.MONOSPACE);
			}
			else {
				autocomplete1.setTypeface(Typeface.DEFAULT);
				search.setTypeface(Typeface.DEFAULT);
			}
			try{
				sitepermis = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SitePermission.json"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			}catch(Exception e){
				 
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/js.txt").equals("1")) {
				js.setChecked(true);
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/dev/usedram.txt").equals("0")) {
				ramuse.setVisibility(View.GONE);
			}
			else {
				ramuse.setVisibility(View.VISIBLE);
			}
			if (!(FileUtil.readFile("/storage/emulated/0/WeekBrowser/incognito.txt").equals("1") && FileUtil.readFile("/storage/emulated/0/WeekBrowser/NoScreen.txt").equals("1"))) {
				getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
			}
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/idtxt")) {
				_webViewActions(10, "javascript:(function() {var textField = document.getElementById('".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/idtxt")).concat("');\n					    if(textField) {\n					    textField.value = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/txt").concat("';\n					    }})();"))));
				FileUtil.deleteFile("/storage/emulated/0/WeekBrowser/idtxt");
				FileUtil.deleteFile("/storage/emulated/0/WeekBrowser/txt");
			}
			if ((dataHolder.getData("safe")==null || !dataHolder.getData("safe").equals("1")) && (sf2.contains("en") && (sf2.getString("en", "").equals("2") || (sf2.getString("en", "").equals("1") && FileUtil.readFile("/storage/emulated/0/WeekBrowser/incognito.txt").equals("1"))))) {
				intent.setClass(getApplicationContext(), LockActivity.class);
				startActivity(intent);
			}
			else {
				dataHolder.setData("safe", "0");
			}
		}
	}
	
	
	@Override
	public void onPause() {
		super.onPause();
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/NoPreview.txt").equals("1") && FileUtil.readFile("/storage/emulated/0/WeekBrowser/incognito.txt").equals("1")) {
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
		}
		Foreground = false;
		_Reopentab();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/incognito.txt").equals("1")) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Tabs.json", "[{\"name\":\"bookmark.html\",\"url\":\"file:///storage/emulated/0/WeekBrowser/bookmark.html\"},{\"name\":\"about:blank\",\"url\":\"about:blank\"},{\"name\":\"about:blank\",\"url\":\"about:blank\"},{\"name\":\"about:blank\",\"url\":\"about:blank\"},{\"name\":\"about:blank\",\"url\":\"about:blank\"},{\"name\":\"about:blank\",\"url\":\"about:blank\"}]");
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/activeTab.txt", "0");
		}
		_clearonexit();
	}
	
	    public void onLowMemory() {
		        super.onLowMemory();
		        SketchwareUtil.showMessage(getApplicationContext(), "WeekBrowser:\nМало оперативної пам'яті. Оптимізація сайтів. Є ризик вильоту браузера");
		
		        }
	public void _ifex() {
		if (!FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache/ifex.txt").equals("n")) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/cache/ifex.txt", "n");
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Supermenu.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Supermenu.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/dev/usedram.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/dev/usedram.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt", "30");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache/maxram.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/cache/maxram.txt", String.valueOf((long)((_totalMem() * 3) / 4)));
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/firstpage.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/firstpage.txt", "file:///storage/emulated/0/WeekBrowser/bookmark.html");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/autofirstpage.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/autofirstpage.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Autoclean/search.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Autoclean/search.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Autoclean/cache.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Autoclean/cache.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Autoclean/cookie.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Autoclean/cookie.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Autoclean/form.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Autoclean/form.txt", "0");
			}
			if (!FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/replaces/10.txt")) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/10.txt", "youtube\\.com");
			}
			if (!FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/replaces/11.txt")) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/11.txt", "ssyoutube.com");
			}
			if (!FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/replaces/20.txt")) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/20.txt", "");
			}
			if (!FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/replaces/21.txt")) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/21.txt", "");
			}
			if (!FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/replaces/30.txt")) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/30.txt", "");
			}
			if (!FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/replaces/31.txt")) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/31.txt", "");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/search.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/search.txt", "[weekbrowser]");
			}
			if (!FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/replaces/40.txt")) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/40.txt", "");
			}
			if (!FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/replaces/41.txt")) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/41.txt", "");
			}
			if (!FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/replaces/50.txt")) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/50.txt", "");
			}
			if (!FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/replaces/51.txt")) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/51.txt", "");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posx1.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Positions/posx1.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posy1.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Positions/posy1.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posx2.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Positions/posx2.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posy2.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Positions/posy2.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posx3.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Positions/posx3.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posy3.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Positions/posy3.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/fontsize.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Sizes/fontsize.txt", "10");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Searchpanelpos.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Searchpanelpos.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/LoadImages.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/LoadImages.txt", "1");
				image.setChecked(true);
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/minfont.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Sizes/minfont.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/BlockAd.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/BlockAd.txt", "1");
				blockad.setChecked(true);
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/IfameBlock.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/IfameBlock.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/HidePanels.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/HidePanels.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/onNoInternet.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/onNoInternet.txt", "1");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/showiframer.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/showiframer.txt", "1");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt", "FF000000FF000080");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/InfoText.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/InfoText.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt", "FF00FF00FF00FFFF");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt", "FFFF0000FFFF00FF");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/text.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/text.txt", "FF00FF00");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/textfield.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/textfield.txt", "FF00FFFF");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/additional.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/additional.txt", "FFFF0070");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/hint.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/hint.txt", "FF7000FF");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttontext.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttontext.txt", "FF000000");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/style.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/style.txt", "5");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttontext.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttontext.txt", "FF000000");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt", "1000");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt", "");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/incognito.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/incognito.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt", "1");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/js.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/js.txt", "1");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/history.json").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/history.json", "[{\"date\":\"до нашої ери\",\"name\":\"༺ВАША ІСТОРІЯ༻\",\"url\":\"\"}]");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/dp.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Sizes/dp.txt", "30");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/loadingstyle.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/loadingstyle.txt", "1");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/bookmark.html").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/bookmark.html", "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\n<body style=\"background-color:#000000\">\n<a href=\"https://www.google.com\"><font color=\"#00ff00\">Google</font></a>\n<font color=\"#ff0000\"> ❖ </font>");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/cache.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/PC.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/PC.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/1.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/1.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/2.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/2.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/3.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/3.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/1.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/1.txt", "");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/2.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/2.txt", "");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/3.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/3.txt", "");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/4.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/4.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/5.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/5.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/6.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/6.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/4.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/4.txt", "");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/5.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/5.txt", "");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/6.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/6.txt", "");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/10001.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/10001.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/10002.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/10002.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20001.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20001.txt", "javascript:(function() {\n    var inputs = document.getElementsByTagName('input');\n    for (var i = 0; i < inputs.length; i++) {\n        if (inputs[i].type.toLowerCase() === 'password') {\n            inputs[i].type = 'text';\n        }\n    }\n})();");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20001n.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20001n.txt", "SHOW PASSWORD");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20002.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20002.txt", "javascript:(function(){\n    for (var i = 0; i < document.styleSheets.length; i++){\n        document.styleSheets.item(i).disabled = true;\n    }\n    var all = document.getElementsByTagName('*');\n    for (var i = 0; i < all.length; i++){\n        var el = all[i];\n        el.style.cssText = '';\n        el.style.width = '';\n        el.style.padding = '0px';\n        el.style.margin = '2px';\n        el.style.backgroundImage = 'none';\n        el.style.backgroundColor = '#$colbg$';\n        el.style.color = '#$coltext$';\n        /* Змінюємо колір посилань */\n        if (el.tagName === 'A') {\n            el.style.color = '#$coladd$';\n        }\n        /* Змінюємо колір нещодавно відвіданих посилань */\n        if (el.tagName === 'A' && el.hasAttribute('visited')) {\n            el.style.color = '#$colhint$';\n        }\n        /* Змінюємо колір підказок текстового поля */\n        if (el.tagName === 'INPUT' && el.type === 'text') {\n            el.style.color = '#$colhint$';\n        }\n        /* Змінюємо колір самого тексту текстового поля */\n        if (el.tagName === 'INPUT' && el.type === 'text') {\n            el.style.backgroundColor = '#$colfield$';\n        }\n    }\n    var images = document.getElementsByTagName('img');\n    for (var i = 0; i < images.length; i++) {\n        images[i].style.width = '140px';\n        images[i].style.height = 'auto';\n    }\n})();\n");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20002n.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20002n.txt", "READING MODE");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20003.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20003.txt", "");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20003n.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20003n.txt", "");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20004.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20004.txt", "");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20004n.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20004n.txt", "");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20005.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20005.txt", "");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20005n.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20005n.txt", "");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/ZoomButton.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/ZoomButton.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/activeTab.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/NoScreen.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/NoScreen.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/NoPreview.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/NoPreview.txt", "1");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/monofortextarea.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/monofortextarea.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/SitePermission.json").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SitePermission.json", "[{\"url\":\"file://\",\"im\"=\"1\",\"js\"=\"1\"}]");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/themepage.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/themepage.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/roundness.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/roundness.txt", "0");
			}
			if (!FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt")) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt", "");
			}
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/domains.txt", "trandgid\nsr?v.*\\.com\nci3\\.googleusercontent\nbitsdujour\ncityclub\nashampoo\nadmixer\nlitres\nlh6\\.googleusercontent\nwisokykulas\nrcvlink\ni\\.4pda\\.ws\nonewaywin\ngamesport\nypls\nprfl\ncunta\narumo\ncdnstatic\ncosmobet\nzpredir17\nunityad\ndalead\nposix\npremier1\ngtblg\nwwwhkinwa\ngoogle_vignette\nforlifecode\nbitcoin\\.site\nnowuive\nadtelligent\nwiimguup\nday\\.alerts\npush-news\ndirectrankcl\nluckyorange\nneloha\nliga-koroliv\npub\\.network\nhadron\n%adclick\n%doubleclick\nstats\\.wp\nfreshmarketer\nadsystem\n%googlead\n%advertising\n%banner\n%google_ad\n%pagead\n%googlesynd\n%googletag\n1xbet\nfavbet\nd2wy8f7a9ursnm\ncasino\npncloudfl\nvbet\nloto\ncloudfrale\noneclick\n%analyti\n%ashlyti\ncriteo\nmetric\nhotjar\n(pixel|an)\\.facebook\nadcolony\n777\nyandex\nmail\\.ru\nsentry\nbugsnag\npari\nmonoslot\nmelbet\nloot\\.bet\nloto-zoloto\\.net\nlottoland\\.com\nlegzocasinoua\\.com\nlegzo\\.casino\nleon\\.bet\nkalmar-ukr-shop\nicanshop\nhelpukr\nct.*\\.biz\ncr.*\\.biz\nwwbm\nlkcl\njsc\\.mgid\nhelp24\nepidtrymka\nbitz-play\ngo\\.redav\nw\\.news\neuropeanchallengeukraine\ndragongold88\nderjavaukraine\nclubdeluxe\\.net\ncoins\\.game\ncashalot\\.bet\nbitfinexgroup\ndopomoga\nblockchain4ukraine\nbetwinner\nbet-boom\n97jokerua\n100bankiv\n24uadopomoga\n23konkurs\n15jokerua\nimasdk\n8slottica\n7goxbet\nslotscity\nlucky-wheel\n%cummerata\n%trafficjunk\nsupergra\ngivemelink\nsteepto\nmixadvert\nservetraff\nkyivstar\\.(?!ua)\nvodafone\\.(?!ua)\nlifecell\\.(?!ua)\nmonobank\\.(?!(ua|com))\nprivat24\\.(?!ua)\nnovapost\\.(?!com)\nukrposhta\\.(?!ua)\ninstagram\\.(?!com)\nfacebook\\.(?!com)\nnovapay\\.(?!com)\nfreecontent\ncoinimp\nhostingcloud\njquery-cdn\njqwww\nheroku\nrand\\.com\nnablabee\nwebmine\nvuryua\ncontaboserver\nwebassembly\\.stream\nmining\nminer\nsunnimiq\nminr\nserv1swork\nsrcip\nstonecalcom\nflashx\nnimiq\nhostcontent\nscaleway\npampopholf\nscaleway\nrocks\\.io\nrock\\.reauthenticator\nrock2\\.authcaptcha\nvidzi\nplay\\.play\nplay\\.on\nplay\\.tercabilis\nplay\\.video\npool\\.hws\npr0gram\npremiumstats\nproofly\nproxy-can\ngramombird\nistlandoll\nplay\\.mine\nplay\\.nexioniect\nplay\\.estream\n1q2w3\npema\nacbp0020171456\nad-miner\nadminer\naeros\nafminer\nanalytics\nandlache\nanybest\napi\\.inwemo\nas\\.cfcdist\nashgrrwt\nauthedmine\nauthedmine\nauthedwebmine\nautologica\naxoncoho\nbablace\nbafybeidravcab5p3acvthxtwosm4rfpl4yypwwm52s7sazgxaezfzn5xn4\nbaiduccdn1\nbecanium\nberateveng\nbesocial\nbestcoinsignals\nbesti\nbestsrv\nbewaslac\nbiberukalap\nbinarybusiness\nbitcoin-cashcard\nbitcoin-pay\nbitcoin-pocket\nbmcm\nbmcm\nbmnr\nbmst\ncandid\ncashbeet\nadless\ncloudcoins\nminescripts\npebx\ncloudflane\ncfcdist\nclgserv\ncloud-miner\ncloudcdn\ncnhv\ncnt\\.statistic\ncoin-have\ncoinblind\ncoinerra\ncoinhiveproxy\ncoinnebula\ncoinpirate\ncoinpot\ncoinrail\ncontribute\\.to\ncryptaloot\ncrypto-loot\ncrypto\\.csgocpu\ncryptoloot\ncpufan\ndark-utilities\nde-mi\nde-ner\ndepttake\ndigger\ncryptobara\nbrowsermine\ndonttbeevils\ndronml\neasyhash\neth-pocket\nxlivrdr\nafcdn\npncloudfl\ntsyndicate\nerling\\.online\nhotline\\.finance\nyt3\\.ggpht\\.com");
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/blockredir.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/blockredir.txt", "1");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/windows.json").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/windows.json", "[{\"e\":\"0\",\"px\":\"0\",\"py\":\"0\",\"sx\":\"2\",\"sy\":\"2\"},{\"e\":\"0\",\"px\":\"2\",\"py\":\"0\",\"sx\":\"2\",\"sy\":\"2\"},\n{\"e\":\"0\",\"px\":\"0\",\"py\":\"2\",\"sx\":\"2\",\"sy\":\"1\"},{\"e\":\"0\",\"px\":\"2\",\"py\":\"2\",\"sx\":\"2\",\"sy\":\"1\"},{\"e\":\"0\",\"px\":\"0\",\"py\":\"3\",\"sx\":\"2\",\"sy\":\"1\"},{\"e\":\"0\",\"px\":\"2\",\"py\":\"3\",\"sx\":\"2\",\"sy\":\"1\"},{\"w\":\"0\"}]");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Navpanelpos.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Navpanelpos.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Swipetorefresh.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Swipetorefresh.txt", "0");
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/SearchPan.txt").isEmpty()) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SearchPan.txt", "1");
			}
			_ifex2();
		}
		else {
			
		}
		srcsug = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/search.txt"), new TypeToken<ArrayList<String>>(){}.getType());
		history = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/history.json"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Tabs.json").length() < 5) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Tabs.json", "[{\"name\":\"bookmark.html\",\"url\":\"file:///storage/emulated/0/WeekBrowser/bookmark.html\"}]");
		}
	}
	
	
	public String _replaceInstructions(final String _javascript) {
		/*
ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
if (!_isNull(dataHolder.getData("rbt"))) {
temp = _javascript;
temp = temp.replace("$colbg$", dataHolder.getData("bg").substring(2));
temp = temp.replace("$colb1$", dataHolder.getData("bbg").substring(2));
temp = temp.replace("$colb2$", dataHolder.getData("bbg2").substring(2));
temp = temp.replace("$colrb1$", dataHolder.getData("rbg").substring(2));
temp = temp.replace("$colrb2$", dataHolder.getData("rbg2").substring(2));
temp = temp.replace("$coltext$", dataHolder.getData("t").substring(2));
temp = temp.replace("$colfield$", dataHolder.getData("tf").substring(2));
temp = temp.replace("$coladd$", dataHolder.getData("add").substring(2));
temp = temp.replace("$colhint$", dataHolder.getData("h").substring(2));
temp = temp.replace("$colbtxt$", dataHolder.getData("bt").substring(2));
temp = temp.replace("$colrbtxt2$", dataHolder.getData("rbt").substring(2));
}
else {

}
*/
		temp = _javascript;
		temp = temp.replace("$$", "$");
		return (temp);
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
			final AtomicBoolean isu = new AtomicBoolean(false);
			
			int childCount = tabscontainer.getChildCount();
			
			    String tag = "ll" + tab.get(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"))).get("tab").toString(); // отримуємо тег
			
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
										if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Swipetorefresh.txt").equals("1")) {
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
							if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Swipetorefresh.txt").equals("1")) {
								ALLOWSWIPE = true;
							}
							else {
								ALLOWSWIPE = false;
							}
						}
						isu.set(false);
					}catch(Exception e){
						if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Swipetorefresh.txt").equals("1")) {
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
				
				String activeTabContent = FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt");
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
		if (isnotchfullscreen) {
			textview1.setPadding(0, NotchUtils.getNotchHeightDp(this), 0, 0);
		}
		else {
			textview1.setPadding(0, 0, 0, 0);
		}
		if (isshowed && !swipetorefresh) {
			info = info.concat("[▽▼🔄🔄🔄▼▽]\n");
		}
		if (swipetorefresh) {
			info = info.concat("[✅✅✅🔄🔄🔄✅✅✅]\n");
		}
		if (load < 100) {
			if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/loadingstyle.txt")) < 2) {
				info = getString(R.string.loading) + " ";
			}
			if ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/loadingstyle.txt")) == 0) || (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/loadingstyle.txt")) == 2)) {
				for(int _repeat32 = 0; _repeat32 < (int)(load); _repeat32++) {
					info = info.concat("/");
				}
			}
			else {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/loadingstyle.txt")) == 4) {
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
	
	
	public boolean _isNull(final String _v) {
		if(_v==null)return true; else return false;
	}
	
	
	public void _newintentt() {
		
	}
	
	
	public void _titl() {
		
	}
	
	
	public boolean _ispermission() {
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R || Environment.isExternalStorageManager()) {
			if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
				return (false);
			}
			else {
				if (Build.VERSION.SDK_INT >= 23) {
								if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED) {
										return (true);
								}
								else {
						return (false);
								}
						}
						else {
					return (false);
						}
			}
		}
		else {
			return (true);
		}
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
													tab.get((int)tag).put("x", "s".concat(String.valueOf((long)(((int)linearLayout.getX() / (int)(tabscontainer.getWidth() / 4))+.5))));
													tab.get((int)tag).put("y", "s".concat(String.valueOf((long)(((int)linearLayout.getY() / (int)(tabscontainer.getHeight() / 4))+.5))));
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
														FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Tabs.json", new Gson().toJson(tab));
														dataHolder.setData("ml", "https://multilink2.weekbrowser.com/".concat(encodeUrl(new Gson().toJson(tab))));
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
	
	
	public void _verifynew() {
		/*
tab = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Tabs.json"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
if (!"".equals(tab.get((int)0).get("url").toString())) {

}
if (!"".equals(tab.get((int)1).get("url").toString())) {

}
if (!"".equals(tab.get((int)2).get("url").toString())) {

}
if (!"".equals(tab.get((int)3).get("url").toString())) {

}
if (!"".equals(tab.get((int)4).get("url").toString())) {

}
if (!"".equals(tab.get((int)5).get("url").toString())) {

}
*/
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
	
	
	public void _Blockad() {
		
	}
	
	
	public void _Blockifr() {
		
	}
	
	
	public void _instantbookmarklets() {
		
	}
	
	
	public void _buttonsizeset() {
		back.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		back.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		back.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		back.requestLayout();
		
		pgup.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		pgup.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		pgup.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		pgup.requestLayout();
		
		forward.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		forward.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		forward.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		forward.requestLayout();
		
		pgdn.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		pgdn.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		pgdn.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		pgdn.requestLayout();
		
		//════════
		
		bookmarks.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		bookmarks.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		bookmarks.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		bookmarks.requestLayout();
		
		histori.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		histori.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		histori.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		histori.requestLayout();
		
		home.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		home.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		home.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		home.requestLayout();
		
		tabs.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		tabs.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		tabs.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		tabs.requestLayout();
		
		//════════════════════════════════
		
		dual.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		dual.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		dual.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		dual.requestLayout();
		
		skipvideo.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		skipvideo.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		skipvideo.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		skipvideo.requestLayout();
		
		pagesearch.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		pagesearch.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		pagesearch.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		pagesearch.requestLayout();
		
		coordinates.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		coordinates.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		coordinates.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		coordinates.requestLayout();
		
		//════════
		
		/*addshortcut.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
addshortcut.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
addshortcut.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
addshortcut.requestLayout();*/
		
		hide.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		hide.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		hide.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		hide.requestLayout();
		
		openpanel.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		openpanel.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		openpanel.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		openpanel.requestLayout();
		
		refresh.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		refresh.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		refresh.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		refresh.requestLayout();
		
		 button1.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		button1.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		button1.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		button1.requestLayout();
		
		button3.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		button3.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		button3.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		button3.requestLayout();
		
		widthp1.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		widthp1.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		widthp1.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		widthp1.requestLayout();
		
		widthm1.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		widthm1.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		widthm1.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		widthm1.requestLayout();
		
		
		heightp1.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		heightp1.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		heightp1.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		heightp1.requestLayout();
		
		heightm1.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		heightm1.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		heightm1.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		heightm1.requestLayout();
		
		
		
		closeeditor.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		closeeditor.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		closeeditor.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		closeeditor.requestLayout();
		
		
		
		copyurl.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		copyurl.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		copyurl.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		copyurl.requestLayout();
		
		
		
		pasteurl.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		pasteurl.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		pasteurl.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		pasteurl.requestLayout();
		
		
		
		pastegourl.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		pastegourl.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		pastegourl.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		pastegourl.requestLayout();
		
		
		selall.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		selall.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		selall.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		selall.requestLayout();
		
		
		
		
		cururl.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		cururl.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		cururl.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		cururl.requestLayout();
		
		
		
		
		ssl.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		ssl.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		ssl.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		ssl.requestLayout();
		
		
		
		
		
	}
	
	
	public void _swipe() {
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
							if ((autocomplete1.getText().toString().equals("/storage/emulated/0/WeekBrowser/bookmark.html") || autocomplete1.getText().toString().equals(FileUtil.readFile("/storage/emulated/0/WeekBrowser/firstpage.txt"))) && FileUtil.readFile("/storage/emulated/0/WeekBrowser/SearchPan.txt").equals("1")) {
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
	
	private ViewTreeObserver.OnGlobalLayoutListener listener;
	
	public void toggleKeyboardListener() {
		    final View activityRootView = getWindow().getDecorView().getRootView();
		
		    if (listener != null) {
			        activityRootView.getViewTreeObserver().removeOnGlobalLayoutListener(listener);
			    }
		
		    listener = new ViewTreeObserver.OnGlobalLayoutListener() {
			        @Override
			        public void onGlobalLayout() {
				            Rect r = new Rect();
				            activityRootView.getWindowVisibleDisplayFrame(r);
				
				            // Отримання висоти екрану за допомогою WindowManager
				            WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
				            Display display = wm.getDefaultDisplay();
				            Point size = new Point();
				            display.getSize(size);
				            int screenHeight = size.y;
				
				            // Розрахунок різниці між висотою екрану і видимою областю екрану
				            int heightDifference = screenHeight - (r.bottom - r.top);
				
				            // Додайте більше логів для відлагодження
				     /*       SketchwareUtil.showMessage(getApplicationContext(), 
                "screenHeight: " + screenHeight + 
                ", r.top: " + r.top + 
                ", r.bottom: " + r.bottom + 
                ", heightDifference: " + heightDifference + 
                ", threshold: " + (screenHeight * 0.15));*/
				
				            if (heightDifference > screenHeight * 0.15) {
					                // Клавіатура відображена на екрані
					                kbd = true;
					            } else {
					                // Клавіатура прихована
					                kbd = false;
					            }
				        }
			    };
		
		    activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(listener);
	}
	
	
	{
	}
	
	
	public void _savewindowparam() {
		/*
try{
windowpos = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/windows.json"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
windowpos.get((int)6).put("w", ((is1window) ? ("1") : ("0")));
if (is1window) {
windowpos.get((int)0).put("e", ((.getVisibility() == View.VISIBLE) ? ("1") : ("0")));
windowpos.get((int)0).put("px", String.valueOf((long)((linwebview1.getX()/tabscontainer.getWidth()*4)+0.5)));
windowpos.get((int)0).put("px", String.valueOf((long)((linwebview1.getX()/tabscontainer.getWidth()*4)+0.5)));
windowpos.get((int)0).put("py", String.valueOf((long)((linwebview1.getY()/tabscontainer.getHeight()*4)+0.5)));
windowpos.get((int)0).put("sx", String.valueOf((long)(width1)));
windowpos.get((int)0).put("sy", String.valueOf((long)(height1)));
}
FileUtil.writeFile("/storage/emulated/0/WeekBrowser/windows.json", new Gson().toJson(windowpos));
}catch(Exception e){
 
}
*/
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
												                            FileUtil.writeFile("/storage/emulated/0/WeekBrowser/activeTab.txt", String.valueOf(i));
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
	
	
	public String _getwindowpos() {
		return (windowpos.get((int)0).get("e").toString().concat(windowpos.get((int)0).get("px").toString().concat(windowpos.get((int)0).get("py").toString().concat(windowpos.get((int)0).get("sx").toString().concat(windowpos.get((int)0).get("sy").toString())))).concat(windowpos.get((int)1).get("e").toString().concat(windowpos.get((int)1).get("px").toString().concat(windowpos.get((int)1).get("py").toString().concat(windowpos.get((int)1).get("sx").toString().concat(windowpos.get((int)1).get("sy").toString())))).concat(windowpos.get((int)2).get("e").toString().concat(windowpos.get((int)2).get("px").toString().concat(windowpos.get((int)2).get("py").toString().concat(windowpos.get((int)2).get("sx").toString().concat(windowpos.get((int)2).get("sy").toString())))).concat(windowpos.get((int)3).get("e").toString().concat(windowpos.get((int)3).get("px").toString().concat(windowpos.get((int)3).get("py").toString().concat(windowpos.get((int)3).get("sx").toString().concat(windowpos.get((int)3).get("sy").toString())))).concat(windowpos.get((int)4).get("e").toString().concat(windowpos.get((int)4).get("px").toString().concat(windowpos.get((int)4).get("py").toString().concat(windowpos.get((int)4).get("sx").toString().concat(windowpos.get((int)4).get("sy").toString())))).concat(windowpos.get((int)5).get("e").toString().concat(windowpos.get((int)5).get("px").toString().concat(windowpos.get((int)5).get("py").toString().concat(windowpos.get((int)5).get("sx").toString().concat(windowpos.get((int)5).get("sy").toString()))))))))));
	}
	
	
	public String _clearram() {
		return ("javascript:(function() {\n    var elements = document.querySelectorAll('*');\n    for (var i = 0; i < elements.length; i++) {\n        elements[i].style.border = 'none';\n        elements[i].style.boxShadow = 'none';\n        elements[i].style.transition = 'none';\n        elements[i].style.animation = 'none';\n        elements[i].style.backgroundImage = 'none';\n        elements[i].style.textShadow = 'none';\n    }\n})();\n");
	}
	
	
	public void _onscroll(final WebView _w) {
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
						
						if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/HidePanels.txt").equals("1") && !is1window) {
							linear1.setVisibility(View.VISIBLE);
							if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/NavPan.txt").equals("1")) {
								linear5.setVisibility(View.VISIBLE);
							}
							getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
							
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
						                    
						if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/HidePanels.txt").equals("1") && !is1window) {
							linear1.setVisibility(View.GONE);
							
							linear5.setVisibility(View.GONE);
							if ((_Orientation() == 0) || (_Orientation() == 2)) {
								getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_FULLSCREEN
								        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
								        | View.SYSTEM_UI_FLAG_IMMERSIVE);
								isnotchfullscreen = true;
							}
							else {
								if ((_Orientation() == 1) || (_Orientation() == 3)) {
									getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
									        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
									        | View.SYSTEM_UI_FLAG_IMMERSIVE);
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
		/*
if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Autoclean/search.txt").equals("1")) {
FileUtil.writeFile("/storage/emulated/0/WeekBrowser/search.txt", "[weekbrowser]");
}
if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Autoclean/cache.txt").equals("1")) {

}
if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Autoclean/cookie.txt").equals("1")) {
CookieManager.getInstance().removeAllCookies(null);
}
if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Autoclean/form.txt").equals("1")) {
webview1.clearFormData();
}
*/
	}
	
	
	public void _extrc() {
	}
	
	
	
	public void setupWebView(final WebView webView, final Activity activity) {
		
		_setAll(webView);
		_onscroll(webView);
		_download(webView);
		_restorewindowparam();
		webView.addJavascriptInterface(new JavaScriptInterface(activity), "AndroidInterface");
		    webView.addJavascriptInterface(new BLOBloader(), "Blobload");
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
				    WebView.HitTestResult result = view.getHitTestResult();
				    String targetUrl = result.getExtra(); // Отримання targetUrl
				
				    boolean isAd = false;
				    String blockedline = "";
				
				    // Перевірка на блокування
				    isAd = checkIfUrlBlocked(targetUrl);
				    if (isAd) {
					        SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.adblocked)+"\n".concat(blockedlineg));
					        return false; // Нічого не робимо, просто повертаємо false
					    } else {
					        T++;
					        Tt++;
					        time++;
					        int currentActiveTabIndex = tab.size();
					        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/activeTab.txt", String.valueOf(currentActiveTabIndex));
					
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
					        //newWebView.loadUrl("about:blank");
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
			}});
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
		    boolean isAd = false;
		    if(FileUtil.readFile("/storage/emulated/0/WeekBrowser/blockad/blockredir.txt").equals("1")){
			    String blockedline = "";
			
			    try {
				List<String> domainLines = new ArrayList<>();
				int domainLinesCount = FileUtils.getFileLines("/storage/emulated/0/WeekBrowser/Blockad/domains.txt");
				for (int i = 0; i < domainLinesCount; i++) {
					    String line = FileUtils.readLinesFromFile("/storage/emulated/0/WeekBrowser/Blockad/domains.txt", i);
					    domainLines.add(line);
				}
				
				List<String> userDomainLines = new ArrayList<>();
				int userDomainLinesCount = FileUtils.getFileLines("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt");
				for (int i = 0; i < userDomainLinesCount; i++) {
					    String line = FileUtils.readLinesFromFile("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt", i);
					    userDomainLines.add(line);
				}
				
				        for (String line : domainLines) {
					            if (line != null) {
						                line = line.replace("\\.", ".");
						                if (!line.isEmpty() && !line.startsWith("//") && !line.startsWith("#")) {
							                    if (url.toLowerCase().startsWith("%")) {
								                        if (url.matches(".*" + line.substring(1) + ".*")) {
									                            isAd = true;
									                            blockedline = line;
									                            break;
									                        }
								                    } else {
								                        if (_extractDomain(url).matches(".*" + line + ".*")) {
									                            isAd = true;
									                            blockedline = line;
									                            break;
									                        }
								                    }
							                }
						            }
					        }
				
				        for (String line : userDomainLines) {
					            if (line != null) {
						                line = line.replace("\\.", ".");
						                if (!line.isEmpty() && !line.startsWith("//") && !line.startsWith("#")) {
							                    if (url.toLowerCase().startsWith("%")) {
								                        if (url.matches(".*" + line.substring(1) + ".*")) {
									                            isAd = true;
									                            blockedline = line;
									                            break;
									                        }
								                    } else {
								                        if (_extractDomain(url).matches(".*" + line + ".*")) {
									                            isAd = true;
									                            blockedline = line;
									                            break;
									                        }
								                    }
							                }
						            }
					        }
				        blockedlineg = blockedline;
				    } catch (Exception e) {
				        Log.e("FileReadError", "Failed to read blocking domains files", e);
				    }
		}
		    return isAd;
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
		pagesearch.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		coordinates.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		
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
	}
	
	
	public void _ifex2() {
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bg.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bg.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt"));
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgcol.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgcol.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt"));
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt", "normal");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgblur.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblur.txt", "0.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgbright.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgbright.txt", "1.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgcontr.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgcontr.txt", "1.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bghue.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bghue.txt", "0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bginvert.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bginvert.txt", "0.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgopacity.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgopacity.txt", "0.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsatur.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgsatur.txt", "1.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsepia.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgsepia.txt", "0.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsize.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgsize.txt", "cover");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokecolor.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgstrokecolor.txt", "FF0000FF");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokesize.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgstrokesize.txt", "0.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokestyle.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgstrokestyle.txt", "solid");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textalign.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textalign.txt", "left");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textblur.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textblur.txt", "0.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbordercolor.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textbordercolor.txt", "FF0000FF");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbordersize.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textbordersize.txt", "0.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textborderstyle.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textborderstyle.txt", "solid");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbright.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textbright.txt", "1.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textcontr.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textcontr.txt", "1.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textfont.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textfont.txt", "sans");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/texthue.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/texthue.txt", "0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textinvert.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textinvert.txt", "0.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textline.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textline.txt", "1.3");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textopacity.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textopacity.txt", "1.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsatur.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textsatur.txt", "1.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsepia.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textsepia.txt", "0.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowb.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowb.txt", "0.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt", "normal");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowc.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowc.txt", "FF0000FF");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowx.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowx.txt", "0.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowy.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowy.txt", "0.0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsize.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textsize.txt", "20");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textstrokecolor.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textstrokecolor.txt", "FF0000FF");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textstyle.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textstyle.txt", "initial");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/texttrans.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/texttrans.txt", "initial");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textweight.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textweight.txt", "500");
		}
		FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/videopatterns.txt", "Пропустити через|Реклама •|Реклама закінчиться|Реклама [0-9]|Відео незабаром почне відтворюватися|Видео скоро начнется|Вы cможете перейти\\nк видео через");
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/skipvideoad.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/skipvideoad.txt", "1");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache/bmkdsgn.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/cache/bmkdsgn.txt", "javascript:(function() {\n    var backgroundDiv = document.createElement('div');\n    backgroundDiv.style.position = 'fixed';\n    backgroundDiv.style.top = '0';\n    backgroundDiv.style.left = '0';\n    backgroundDiv.style.width = '100%';\n    backgroundDiv.style.height = '100%';\n    backgroundDiv.style.zIndex = '-1';\n    backgroundDiv.style.backgroundColor = '#".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgcol.txt").concat("';\n    document.body.appendChild(backgroundDiv);\n\n    var blurDiv = document.createElement('div');\n    blurDiv.style.position = 'fixed';\n    blurDiv.style.top = '0';\n    blurDiv.style.left = '0';\n    blurDiv.style.width = '100%';\n    blurDiv.style.height = '100%';\n    blurDiv.style.backgroundColor = '#".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt").concat("';\n    blurDiv.style.backgroundImage = 'url(file://".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgimage.txt").concat(")';\n    blurDiv.style.backgroundSize = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsize.txt").concat("';\n    blurDiv.style.filter = 'blur(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgblur.txt").concat("px) hue-rotate(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bghue.txt").concat("deg) invert(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bginvert.txt").concat(") contrast(")))))))))))))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgcontr.txt").concat(") brightness(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgbright.txt").concat(") sepia(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsepia.txt").concat(") saturate(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsatur.txt").concat("")))))))).concat("".concat("".concat("".concat("".concat("".concat(") opacity(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgopacity.txt").concat(")';\n    blurDiv.style.mixBlendMode = '")))))))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt").concat("';\n    blurDiv.style.zIndex = '-2';\n    backgroundDiv.appendChild(blurDiv);\n\n    var contentElements = document.querySelectorAll('font');\n    contentElements.forEach(function(element) {\n        \n        element.style.lineHeight = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textline.txt").concat("';\n        element.style.fontFamily = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textfont.txt").concat("';\n        element.style.fontSize = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsize.txt").concat("px';\n        element.style.fontWeight = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textweight.txt").concat("';\n        element.style.textTransform = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/texttrans.txt").concat("';\n        element.style.fontStyle = '")).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textstyle.txt").concat("';\n        element.style.filter = 'blur(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textblur.txt")).concat("px) hue-rotate(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/texthue.txt").concat("deg) invert(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textinvert.txt").concat(") contrast("))))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textcontr.txt").concat(") brightness(")))))))))))))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbright.txt").concat(") sepia(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsepia.txt").concat(") saturate(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsatur.txt").concat("".concat("")))).concat("".concat("".concat("".concat("".concat(") opacity(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textopacity.txt"))))).concat(")';\n        element.style.textShadow = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowx.txt").concat("px ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowy.txt")))))))))).concat("px ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowb.txt")).concat("px #".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowc.txt"))).concat("';\n        element.style.mixBlendMode = '").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt").concat("';\n        element.style.border = '").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbordersize.txt").concat("px ")).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textborderstyle.txt")).concat(" #"))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbordercolor.txt").concat("';\n        element.style.webkitTextStroke = '").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textstrokesize.txt")).concat("px #".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textstrokecolor.txt")))).concat("';\n        \n    });\n    document.body.style.border = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokesize.txt")).concat("px ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokestyle.txt")).concat(" #").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokecolor.txt")).concat("';\n    document.body.style.textAlign = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textalign.txt").concat("';\n})();"))))));
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/composebuttoncolor.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/composebuttoncolor.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/text.txt"));
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/trackpadcolor.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/trackpadcolor.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/text.txt"));
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/thumbcolor.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/thumbcolor.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/textfield.txt"));
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/dev/jslog.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/dev/jslog.txt", "0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/hidepassword.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/hidepassword.txt", "0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css.txt", "1");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/gif.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/gif.txt", "1");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/jsanim.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/jsanim.txt", "1");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redgradient.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redgradient.txt", "2");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradient.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradient.txt", "2");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradient.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradient.txt", "2");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/stripecount.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/stripecount.txt", "2");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradY.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradY.txt", "0.5");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradX.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradX.txt", "0.5");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradrad.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradrad.txt", "1");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rstripecount.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/rstripecount.txt", "2");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradY.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradY.txt", "0.5");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradX.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradX.txt", "0.5");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradrad.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradrad.txt", "1");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bstripecount.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bstripecount.txt", "2");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradY.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradY.txt", "0.5");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradX.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradX.txt", "0.5");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradrad.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradrad.txt", "1");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rroundness.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/rroundness.txt", "0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/sroundness.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/sroundness.txt", "0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rsroundness.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/rsroundness.txt", "0");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/tilemode.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/tilemode.txt", "1");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgtilemode.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgtilemode.txt", "1");
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redtilemode.txt").isEmpty()) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redtilemode.txt", "1");
		}
		_ifex3();
	}
	
	
	public String _selcol(final String _col) {
		try{
			switch(_col) {
				case "n110": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_10)).toUpperCase();
					break;
				}
				case "n150": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_50)).toUpperCase();
					break;
				}
				case "n1100": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_100)).toUpperCase();
					break;
				}
				case "n1200": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_200)).toUpperCase();
					break;
				}
				case "n1300": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_300)).toUpperCase();
					break;
				}
				case "n1400": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_400)).toUpperCase();
					break;
				}
				case "n1500": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_500)).toUpperCase();
					break;
				}
				case "n1600": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_600)).toUpperCase();
					break;
				}
				case "n1700": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_700)).toUpperCase();
					break;
				}
				case "n1800": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_800)).toUpperCase();
					break;
				}
				case "n1900": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_900)).toUpperCase();
					break;
				}
				case "n210": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_10)).toUpperCase();
					break;
				}
				case "n250": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_50)).toUpperCase();
					break;
				}
				case "n2100": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_100)).toUpperCase();
					break;
				}
				case "n2200": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase();
					break;
				}
				case "n2300": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_300)).toUpperCase();
					break;
				}
				case "n2400": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_400)).toUpperCase();
					break;
				}
				case "n2500": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_500)).toUpperCase();
					break;
				}
				case "n2600": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_600)).toUpperCase();
					break;
				}
				case "n2700": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase();
					break;
				}
				case "n2800": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_800)).toUpperCase();
					break;
				}
				case "n2900": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_900)).toUpperCase();
					break;
				}
				case "a110": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_10)).toUpperCase();
					break;
				}
				case "a150": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_50)).toUpperCase();
					break;
				}
				case "a1100": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_100)).toUpperCase();
					break;
				}
				case "a1200": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase();
					break;
				}
				case "a1300": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_300)).toUpperCase();
					break;
				}
				case "a1400": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_400)).toUpperCase();
					break;
				}
				case "a1500": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_500)).toUpperCase();
					break;
				}
				case "a1600": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase();
					break;
				}
				case "a1700": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_700)).toUpperCase();
					break;
				}
				case "a1800": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_800)).toUpperCase();
					break;
				}
				case "a1900": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_900)).toUpperCase();
					break;
				}
				case "a210": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_10)).toUpperCase();
					break;
				}
				case "a250": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_50)).toUpperCase();
					break;
				}
				case "a2100": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_100)).toUpperCase();
					break;
				}
				case "a2200": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_200)).toUpperCase();
					break;
				}
				case "a2300": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_300)).toUpperCase();
					break;
				}
				case "a2400": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_400)).toUpperCase();
					break;
				}
				case "a2500": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_500)).toUpperCase();
					break;
				}
				case "a2600": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_600)).toUpperCase();
					break;
				}
				case "a2700": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_700)).toUpperCase();
					break;
				}
				case "a2800": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_800)).toUpperCase();
					break;
				}
				case "a2900": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_900)).toUpperCase();
					break;
				}
				case "a310": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_10)).toUpperCase();
					break;
				}
				case "a350": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_50)).toUpperCase();
					break;
				}
				case "a3100": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_100)).toUpperCase();
					break;
				}
				case "a3200": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase();
					break;
				}
				case "a3300": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_300)).toUpperCase();
					break;
				}
				case "a3400": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_400)).toUpperCase();
					break;
				}
				case "a3500": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_500)).toUpperCase();
					break;
				}
				case "a3600": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase();
					break;
				}
				case "a3700": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_700)).toUpperCase();
					break;
				}
				case "a3800": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_800)).toUpperCase();
					break;
				}
				case "a3900": {
					fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_900)).toUpperCase();
					break;
				}
				case "no": {
					fffff = "";
					break;
				}
			}
		}catch(Exception e){
			SketchwareUtil.showMessage(getApplicationContext(), "Ой");
		}
		return (fffff);
	}
	
	
	public void _download(final WebView _w) {
		_w.setDownloadListener(new DownloadListener() {
			    @Override
			    public void onDownloadStart(String url, String userAgent, String contentDisposition,
			                                final String mimeType, long contentLength) {
				        final String finalUrl = url;
				        final String finalUserAgent = userAgent;
				        final String fileName = URLUtil.guessFileName(url, contentDisposition, mimeType);
				        final String fileSize = (contentLength > 0) ? android.text.format.Formatter.formatFileSize(getApplicationContext(), contentLength) : "Невідомий розмір";
				
				        // Створення діалогового вікна
				        AlertDialog.Builder builder = new AlertDialog.Builder(_w.getContext());
				        builder.setTitle("Завантаження файлу");
				        builder.setMessage("Назва: " + fileName + "\n\nФормат: " + mimeType + "\n\nРозмір: " + fileSize);
				        builder.setPositiveButton("Завантажити", new DialogInterface.OnClickListener() {
					            @Override
					            public void onClick(DialogInterface dialog, int which) {
						                if (finalUrl.startsWith("http")) {
							                    // Завантаження через HTTP
							                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(finalUrl));
							                    request.setMimeType(mimeType);
							                    String cookies = CookieManager.getInstance().getCookie(finalUrl);
							                    request.addRequestHeader("cookie", cookies);
							                    request.addRequestHeader("User-Agent", finalUserAgent);
							                    request.setDescription("Завантаження файлу");
							                    request.setTitle(fileName);
							                    request.allowScanningByMediaScanner();
							                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
							                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
							                    DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
							                    dm.enqueue(request);
							                    Toast.makeText(getApplicationContext(), "Завантаження файлу...", Toast.LENGTH_LONG).show();
							                } else {
							                    // Запуск JavaScript для завантаження блобу
							           	((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", finalUrl));         
							                    String jsCode = "fetch('" + finalUrl + "')" +
							                                    ".then(response => response.blob())" +
							                                    ".then(blob => {" +
							                                    "    const reader = new FileReader();" +
							                                    "    reader.onload = function() {" +
							                                    "        const base64Data = reader.result.split(',')[1];" +
							                                    "        Blobload.saveBlob(base64Data, '" + fileName + "');" +
							                                    "    };" +
							                                    "    reader.readAsDataURL(blob);" +
							                                    "})" +
							                                    ".catch(error => {" +
							                                    "    console.error('Error:', error);" +
							                                    "    Blobload.showToast('Помилка при завантаженні блобу');" +
							                                    "});";
							                    _w.evaluateJavascript(jsCode, null);
							                    Toast.makeText(getApplicationContext(), "Запущено JavaScript для завантаження блобу..." + finalUrl, Toast.LENGTH_LONG).show();
							                }
						            }
					        });
				        builder.setNegativeButton("Скасувати", new DialogInterface.OnClickListener() {
					            @Override
					            public void onClick(DialogInterface dialog, int which) {
						                // Закриваємо діалогове вікно без додаткових дій
						                dialog.dismiss();
						            }
					        });
				        builder.show();
				    }
		});
	}
	
	private class BLOBloader {
		    @JavascriptInterface
		    public void saveBlob(String base64Data, String fileName) {
			        // Перетворіть base64Data на байти та збережіть файл
			        byte[] fileData = android.util.Base64.decode(base64Data, android.util.Base64.DEFAULT);
			
			        try {
				            java.io.File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
				            java.io.File file = new java.io.File(path, fileName);
				            java.io.FileOutputStream fos = new java.io.FileOutputStream(file);
				            fos.write(fileData);
				            fos.close();
				
				            // Додайте повідомлення користувачу про успішне збереження файлу
				            runOnUiThread(new Runnable() {
					                @Override
					                public void run() {
						                    Toast.makeText(getApplicationContext(), "Файл збережено!", Toast.LENGTH_LONG).show();
						                }
					            });
				        } catch (java.io.IOException e) {
				            e.printStackTrace();
				            // Додайте повідомлення користувачу про помилку збереження файлу
				            runOnUiThread(new Runnable() {
					                @Override
					                public void run() {
						                    Toast.makeText(getApplicationContext(), "Помилка збереження файлу", Toast.LENGTH_LONG).show();
						                }
					            });
				        }
			    }
		
		    @JavascriptInterface
		    public void showToast(final String message) {
			        runOnUiThread(new Runnable() {
				            @Override
				            public void run() {
					                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
					            }
				        });
			    }
	}
	{
	}
	
	
	public void _onpagestart(final WebView _w) {
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
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
		try{
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/incognito.txt").equals("0")) {
				final String url = _w.getUrl(); // Замість _w.getUrl() використовуйте відповідний метод для отримання URL
				        new Thread(new Runnable() {
					            @Override
					            public void run() {
						                if (url != null) {
							                    Calendar dnt = Calendar.getInstance();
							                    if (!(url.equals("file:///storage/emulated/0/WeekBrowser/bookmark.html") || url.equals("about:blank"))) {
								                        if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/incognito.txt")) == 0) {
									                            synchronized (history) {
										                                HashMap<String, Object> _item = new HashMap<>();
										                                _item.put("name", "UNTITLED :-/");
										                                _item.put("url", url);
										                                _item.put("date", new SimpleDateFormat("dd/MM EE HH:mm").format(dnt.getTime()));
										                                history.add(_item);
										                                if (history.size() > Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt"))) {
											                                    int numberOfItemsToRemove = history.size() - Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt"));
											                                    history.subList(0, numberOfItemsToRemove).clear();
											                                }
										                            }
									                            synchronized (history) {
										                                FileUtil.writeFile("/storage/emulated/0/WeekBrowser/history.json", new Gson().toJson(history));
										                            }
									                        }
								                    }
							                }
						            }
					        }).start();
			}
			if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/PC.txt")) == 1) {
				_w.setInitialScale((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/dp.txt"))*5);_w.getSettings().setUserAgentString(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt"));
				
			}
			else {
				_w.setInitialScale((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/dp.txt"))*10);_w.getSettings().setUserAgentString(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt"));
				
			}
			
			if (Internet && FileUtil.readFile("/storage/emulated/0/WeekBrowser/onNoInternet.txt").equals("1")) {
				_w.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY);
			}
			else {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache.txt")) == 0) {
					_w.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
				}
				else {
					if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache.txt")) == 1) {
						_w.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
					}
					else {
						if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache.txt")) == 2) {
							_w.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
						}
						else {
							_w.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY);
						}
					}
				}
			}
			if (_w.getUrl().equals("")) {
				_w.loadUrl(FileUtil.readFile("/storage/emulated/0/WeekBrowser/firstpage.txt"));
			}
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/autofirstpage.txt").equals("1") && (!_w.getUrl().equals("about:blank") && FileUtil.readFile("/storage/emulated/0/WeekBrowser/incognito.txt").equals("0"))) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/firstpage.txt", _w.getUrl());
			}
		}catch(Exception e){
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/firstpage.txt", "file:///storage/emulated/0/WeekBrowser/bookmark.html");
		}
		_Reopentab();
		((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();
		try{
			for (int i = 0; i < (int)(sitepermis.size()); i++) {
				if (_w.getUrl().contains(sitepermis.get((int)i).get("url").toString())) {
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
							if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/js.txt").equals("1")) {
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
				if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/js.txt").equals("1")) {
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
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/js.txt").equals("1")) {
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
				if (_w.getUrl().contains(sitepermis.get((int)i).get("url").toString())) {
					switch(sitepermis.get((int)i).get("ad").toString()) {
						case "1": {
							adbl = true;
							break;
						}
						case "2": {
							if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/BlockAd.txt").equals("1")) {
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
				if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/BlockAd.txt").equals("1")) {
					adbl = true;
				}
				else {
					adbl = false;
				}
			}
			isu.set(false);
		}catch(Exception e){
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/BlockAd.txt").equals("1")) {
				adbl = true;
			}
			else {
				adbl = false;
			}
			isu.set(false);
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/LoadImages.txt").equals("1")) {
			_w.getSettings().setBlockNetworkImage(false);
			
			_w.getSettings().setLoadsImagesAutomatically(true);
		}
		else {
			_w.getSettings().setBlockNetworkImage(true);
			_w.getSettings().setLoadsImagesAutomatically(false);
		}
	}
	
	
	public void _onpagefinish(final WebView _w) {
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/1.txt")) == 1) {
			_w.loadUrl(bml01);
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/2.txt")) == 1) {
			_w.loadUrl(bml02);
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/3.txt")) == 1) {
			_w.loadUrl(bml03);
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/4.txt")) == 1) {
			_w.loadUrl(bml04);
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/5.txt")) == 1) {
			_w.loadUrl(bml05);
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/6.txt")) == 1) {
			_w.loadUrl(bml06);
		}
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
		
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/skipvideoad.txt").equals("1")) {
			_w.loadUrl("javascript:(function() {\n    var adsSkipped = false;\n\n    function skipAds() {\n        var videos = document.querySelectorAll('video, [src*=\".mp4\"], [src*=\".webm\"], [src*=\".ogv\"], [type*=\"video\"]');\n        for (var i = 0; i < videos.length; i++) {\n            var video = videos[i];\n            if (typeof video.currentTime !== 'undefined') {\n                video.currentTime = 65535;\n            }\n        }\n    }\n\n    function checkForKeywords() {\n        var regex = /".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/videopatterns.txt").concat("/;\n        var found = regex.test(document.body.innerText);\n        if (found && !adsSkipped) {\n            adsSkipped = true;\n            setTimeout(function() {\n                adsSkipped = false;\n            }, 2000); \n            skipAds();\n        }\n    }\n\n    function hasVideo() {\n        return document.querySelector('video') || document.querySelector('[src*=\".mp4\"]') || document.querySelector('[src*=\".webm\"]') || document.querySelector('[src*=\".ogv\"]') || document.querySelector('[type*=\"video\"]');\n    }\n\n    if (hasVideo()) {\n        var observer = new MutationObserver(function(mutations) {\n            mutations.forEach(function(mutation) {\n                if (mutation.type === 'childList' || mutation.type === 'characterData') {\n                    checkForKeywords();\n                }\n            });\n        });\n\n        var config = { childList: true, subtree: true, characterData: true, characterDataOldValue: true };\n\n        observer.observe(document.body, config);\n\n        checkForKeywords();\n    }\n})();\n")));
			
		}
		try{
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/showiframer.txt").equals("1") && !_w.getUrl().contains("accounts.google.com")) {
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
							                    
							                    if (url != null && title != null) {
								                        synchronized(tab) {
									                            tab.get(i).put("url", url);
									                            tab.get(i).put("name", title);
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
		FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Tabs.json", new Gson().toJson(tab));
		((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();
		dataHolder.setData("ml", "https://multilink2.weekbrowser.com/".concat(encodeUrl(new Gson().toJson(tab))));
		_webViewActions(100, "");
		_setAll(_w);
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/incognito.txt").equals("0")) {
			final String tit = _w.getTitle();
			new Thread(new Runnable() {
				    @Override
				    public void run() {
					        if (!(tit.equals("bookmark.html") || tit.equals("about:blank"))) {
						            if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/incognito.txt").equals("0")) {
							                synchronized (history) {
								                    if (!history.isEmpty()) {
									                        HashMap<String, Object> lastItem = history.get(history.size() - 1);
									                        lastItem.put("name", tit);
									                    }
								                    FileUtil.writeFile("/storage/emulated/0/WeekBrowser/history.json", new Gson().toJson(history));
								                }
							            }
						        }
					    }
			}).start();
		}
	}
	
	
	public boolean _adblck(final WebView _w) {
		return adbl;
	}
	
	
	public boolean _isaccess() {
		return (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/blockredir.txt").equals("1"));
	}
	
	
	public boolean _issuperm() {
		autocomplete1.setOnFocusChangeListener(new OnFocusChangeListener() { @Override public void onFocusChange(View v, boolean hasFocus) {
						  if (hasFocus) { 
					
					focused = true;
						} 
						 else { 
					focused = false;
						} } });
		/*
toggleKeyboardListener();
*/
		if (kbd && !focused) {
			return (false);
		}
		else {
			return (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Supermenu.txt").equals("1"));
		}
	}
	
	
	public void _adsblocked() {
		adsblockedd++;
	}
	
	
	public void _accessdenied(final String _reg) {
		SketchwareUtil.showMessage(getApplicationContext(), getApplicationContext().getString(R.string.adblocked).concat("\n\n").concat(_reg));
	}
	
	
	public void _onpagefail(final WebView _w, final String _e) {
		SketchwareUtil.showMessage(getApplicationContext(), _e);
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/1.txt")) == 1) {
			_w.loadUrl(bml01);
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/2.txt")) == 1) {
			_w.loadUrl(bml02);
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/3.txt")) == 1) {
			_w.loadUrl(bml03);
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/4.txt")) == 1) {
			_w.loadUrl(bml04);
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/5.txt")) == 1) {
			_w.loadUrl(bml05);
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/6.txt")) == 1) {
			_w.loadUrl(bml06);
		}
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
		
		_w.loadUrl(_replaceInstructions("javascript:(function() {\n\n  var applyNightMode = function(window) {\n    (function(document) {\n      var css = 'html{background:#$colbg$ !important}html *{background:none !important;color:#$coltext$ !important;border-color:#$colbg$ !important;border-width:0 !important}html a,html a *{color:#$coladd$ !important;text-decoration:underline !important}html a:visited,html a:visited *,html a:active,html a:active *{color:#$colhint$ !important}html a:hover,html a:hover *{color:#$colhint$ !important;background:#$colbg$ !important}html input,html select,html button,html textarea{background:#$colbg$ !important;border:1px solid #$colb1$ !important;border-top-color:#$colb2$ !important;border-bottom-color:#$colb1$ !important}html input[type=button],html input[type=submit],html input[type=reset],html input[type=image],html button{border-top-color:#$colb1$ !important;border-bottom-color:#$colb2$ !important}html input:focus,html select:focus,html option:focus,html button:focus,html textarea:focus{background:#$colbg$ !important;color:#$colfield$ !important;border-color:#$colb1$ #$colb2$ #$colrb1$ !important;outline:2px solid #$colrb2$ !important}html input[type=button]:focus,html input[type=submit]:focus,html input[type=reset]:focus,html input[type=image]:focus,html button:focus{border-color:#$colb1$ #$colb2$ #$colrb2$ !important}html input[type=radio]{background:none !important;border-color:#$colb1$ !important;border-width:0 !important}html img[src],html input[type=image]{opacity:1}html img[src]:hover,html input[type=image]:hover{opacity:1}html,html body{scrollbar-base-color:#$colb1$ !important;scrollbar-face-color:#$colb2$ !important;scrollbar-shadow-color:#$colhint$ !important;scrollbar-darkshadow-color:#$colhint$ !important;scrollbar-track-color:#$colrb1$ !important;scrollbar-arrow-color:#$colrb2$ !important;scrollbar-3dlight-color:#$colb1$ !important}';\n      var styleNode = document.createElement('style');\n      styleNode.type = 'text/css';\n      styleNode.appendChild(document.createTextNode(css));\n      var head = document.head || document.getElementsByTagName('head')[0];\n      head.appendChild(styleNode);\n    })(window.document);\n    for (var i = 0, frame; frame = window.frames[i]; i++) {\n      try {\n        applyNightMode(frame);\n      } catch (e) {}\n    }\n  };\n\n  applyNightMode(window);\n\n})();\n"));
		((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();
		final String tit = _w.getTitle();
		new Thread(new Runnable() {
			    @Override
			    public void run() {
				        if (!(tit.equals("bookmark.html") || tit.equals("about:blank"))) {
					            if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/incognito.txt").equals("0")) {
						                synchronized (history) {
							                    if (!history.isEmpty()) {
								                        HashMap<String, Object> lastItem = history.get(history.size() - 1);
								                        lastItem.put("name", tit);
								                    }
							                    FileUtil.writeFile("/storage/emulated/0/WeekBrowser/history.json", new Gson().toJson(history));
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
	
	
	public void _colorToRam() {
		switch(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) {
			case "0": {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
					
					dataHolder.setData("bg", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_10)).toUpperCase());
					dataHolder.setData("bbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("bbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("rbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("rbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("t", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase());
					dataHolder.setData("tf", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase());
					dataHolder.setData("add", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("h", Integer.toHexString(getResources().getColor(android.R.color.system_accent2_600)).toUpperCase());
					dataHolder.setData("cb", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("tpc", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("tc", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("bt", "ffffffff");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("tm", "2");
					dataHolder.setData("rtm", "2");
					dataHolder.setData("btm", "2");
					
				}else{
					dataHolder.setData("bg", "ffffffff");
					dataHolder.setData("bbg", "ff018577");
					dataHolder.setData("bbg2", "ff018577");
					dataHolder.setData("rbg", "fff44336");
					dataHolder.setData("rbg2", "ff44336");
					dataHolder.setData("t", "ff000000");
					dataHolder.setData("tf", "ff000000");
					dataHolder.setData("add", "ff018577");
					dataHolder.setData("h", "ff888888");
					dataHolder.setData("bt", "ffffffff");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", "ff018577");
					dataHolder.setData("tpc", "ff018577");
					dataHolder.setData("tc", "ff018577");
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("tm", "2");
					dataHolder.setData("rtm", "2");
					dataHolder.setData("btm", "2");
					
				}
				break;
			}
			case "1": {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
					
					dataHolder.setData("bg", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_900)).toUpperCase());
					dataHolder.setData("bbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("bbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("rbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("rbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("t", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase());
					dataHolder.setData("tf", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase());
					dataHolder.setData("add", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("h", Integer.toHexString(getResources().getColor(android.R.color.system_accent2_200)).toUpperCase());
					dataHolder.setData("bt", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_800)).toUpperCase());
					dataHolder.setData("rbt", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_800)).toUpperCase());
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("tpc", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("tc", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("tm", "2");
					dataHolder.setData("rtm", "2");
					dataHolder.setData("btm", "2");
					
					
				}else{
					dataHolder.setData("bg", "ff303030");
					dataHolder.setData("bbg", "ff80cbc4");
					dataHolder.setData("bbg2", "ff80cbc4");
					dataHolder.setData("rbg", "fff44336");
					dataHolder.setData("rbg2", "fff44336");
					dataHolder.setData("t", "ffffffff");
					dataHolder.setData("tf", "ffffffff");
					dataHolder.setData("add", "ff80cbc4");
					dataHolder.setData("h", "ff888888");
					dataHolder.setData("bt", "ff000000");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", "ff80cbc4");
					dataHolder.setData("tpc", "ff80cbc4");
					dataHolder.setData("tc", "ff80cbc4");
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("tm", "2");
					dataHolder.setData("rtm", "2");
					dataHolder.setData("btm", "2");
					
				}
				break;
			}
			case "2": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ff00ffff");
				dataHolder.setData("bbg2", "ff00ffff");
				dataHolder.setData("rbg", "ffff0000");
				dataHolder.setData("rbg2", "ffff0000");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff00ffff");
				dataHolder.setData("h", "ffffff00");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ffffff00");
				dataHolder.setData("tpc", "ff00ff00");
				dataHolder.setData("tc", "ff00ffff");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "2");
				dataHolder.setData("rtm", "2");
				dataHolder.setData("btm", "2");
				
				break;
			}
			case "4": {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
					
					dataHolder.setData("bg", "ffffffff");
					dataHolder.setData("bbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("bbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("rbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("rbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("t", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase());
					dataHolder.setData("tf", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase());
					dataHolder.setData("add", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("h", Integer.toHexString(getResources().getColor(android.R.color.system_accent2_600)).toUpperCase());
					dataHolder.setData("bt", "ffffffff");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("tpc", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("tc", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					dataHolder.setData("tm", "2");
					dataHolder.setData("rtm", "2");
					dataHolder.setData("btm", "2");
					
					
				}else{
					dataHolder.setData("bg", "ffffffff");
					dataHolder.setData("bbg", "ff018577");
					dataHolder.setData("bbg2", "ff018577");
					dataHolder.setData("rbg", "fff44336");
					dataHolder.setData("rbg2", "fff44336");
					dataHolder.setData("t", "ff000000");
					dataHolder.setData("tf", "ff000000");
					dataHolder.setData("add", "ff018577");
					dataHolder.setData("h", "ff888888");
					dataHolder.setData("bt", "ffffffff");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", "ff018577");
					dataHolder.setData("tpc", "ff018577");
					dataHolder.setData("tc", "ff018577");
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("tm", "2");
					dataHolder.setData("rtm", "2");
					dataHolder.setData("btm", "2");
					
					dataHolder.setData("tmy", "2");
					dataHolder.setData("rtmy", "2");
					dataHolder.setData("btmy", "2");
					
					
				}
				break;
			}
			case "5": {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
					
					dataHolder.setData("bg", "ff000000");
					dataHolder.setData("bbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("bbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("rbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("rbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("t", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase());
					dataHolder.setData("tf", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase());
					dataHolder.setData("add", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("h", Integer.toHexString(getResources().getColor(android.R.color.system_accent2_200)).toUpperCase());
					dataHolder.setData("bt", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_800)).toUpperCase());
					dataHolder.setData("rbt", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_800)).toUpperCase());
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("tpc", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("tc", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("tm", "2");
					dataHolder.setData("rtm", "2");
					dataHolder.setData("btm", "2");
					
					
				}else{
					dataHolder.setData("bg", "ff000000");
					dataHolder.setData("bbg", "ff80cbc4");
					dataHolder.setData("bbg2", "ff80cbc4");
					dataHolder.setData("rbg", "fff44336");
					dataHolder.setData("rbg2", "fff44336");
					dataHolder.setData("t", "ffffffff");
					dataHolder.setData("tf", "ffffffff");
					dataHolder.setData("add", "ff80cbc4");
					dataHolder.setData("h", "ff888888");
					dataHolder.setData("bt", "ff000000");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", "ff80cbc4");
					dataHolder.setData("tpc", "ff80cbc4");
					dataHolder.setData("tc", "ff80cbc4");
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("tm", "2");
					dataHolder.setData("rtm", "2");
					dataHolder.setData("btm", "2");
					
				}
				break;
			}
			case "6": {
				dataHolder.setData("bg", "ffffffff");
				dataHolder.setData("bbg", "ff33b5e5");
				dataHolder.setData("bbg2", "ff33b5e5");
				dataHolder.setData("rbg", "ffb71c1c");
				dataHolder.setData("rbg2", "ffb71c1c");
				dataHolder.setData("t", "ff000000");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff35b5e5");
				dataHolder.setData("h", "ff757575");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ff33b5e5");
				dataHolder.setData("tpc", "ff33b5e5");
				dataHolder.setData("tc", "ff33b5e5");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "2");
				dataHolder.setData("rtm", "2");
				dataHolder.setData("btm", "2");
				
				
				break;
			}
			case "7": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ff33b5e5");
				dataHolder.setData("bbg2", "ff33b5e5");
				dataHolder.setData("rbg", "ffb71c1c");
				dataHolder.setData("rbg2", "ffb71c1c");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ffffffff");
				dataHolder.setData("add", "ff35b5e5");
				dataHolder.setData("h", "ffbdbdbd");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ff33b5e5");
				dataHolder.setData("tpc", "ff33b5e5");
				dataHolder.setData("tc", "ff33b5e5");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "2");
				dataHolder.setData("rtm", "2");
				dataHolder.setData("btm", "2");
				
				
				break;
			}
			case "8": {
				dataHolder.setData("bg", "ffffffff");
				dataHolder.setData("bbg", "ff018577");
				dataHolder.setData("bbg2", "ff018577");
				dataHolder.setData("rbg", "fff44336");
				dataHolder.setData("rbg2", "fff44336");
				dataHolder.setData("t", "ff000000");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff018577");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ffffffff");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "12");
				dataHolder.setData("cb", "ff018577");
				dataHolder.setData("tpc", "ff018577");
				dataHolder.setData("tc", "ff018577");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "4");
				dataHolder.setData("srou", "6");
				dataHolder.setData("rsrou", "2");
				
				dataHolder.setData("tm", "2");
				dataHolder.setData("rtm", "2");
				dataHolder.setData("btm", "2");
				
				break;
			}
			case "9": {
				dataHolder.setData("bg", "ff303030");
				dataHolder.setData("bbg", "ff80cbc4");
				dataHolder.setData("bbg2", "ff80cbc4");
				dataHolder.setData("rbg", "fff44336");
				dataHolder.setData("rbg2", "fff44336");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ffffffff");
				dataHolder.setData("add", "ff80cbc4");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "12");
				dataHolder.setData("cb", "ff80cbc4");
				dataHolder.setData("tpc", "ff80cbc4");
				dataHolder.setData("tc", "ff80cbc4");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "4");
				dataHolder.setData("srou", "6");
				dataHolder.setData("rsrou", "2");
				
				dataHolder.setData("tm", "2");
				dataHolder.setData("rtm", "2");
				dataHolder.setData("btm", "2");
				
				break;
			}
			case "10": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ff80cbc4");
				dataHolder.setData("bbg2", "ff80cbc4");
				dataHolder.setData("rbg", "fff44336");
				dataHolder.setData("rbg2", "fff44336");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ffffffff");
				dataHolder.setData("add", "ff80cbc4");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "12");
				dataHolder.setData("cb", "ff80cbc4");
				dataHolder.setData("tpc", "ff80cbc4");
				dataHolder.setData("tc", "ff80cbc4");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "4");
				dataHolder.setData("srou", "6");
				dataHolder.setData("rsrou", "2");
				
				dataHolder.setData("tm", "2");
				dataHolder.setData("rtm", "2");
				dataHolder.setData("btm", "2");
				
				break;
			}
			case "11": {
				dataHolder.setData("bg", "ffffffff");
				dataHolder.setData("bbg", "ffeaeaea");
				dataHolder.setData("bbg2", "ffb8b8b8");
				dataHolder.setData("rbg", "ffeaeaea");
				dataHolder.setData("rbg2", "ffb8b8b8");
				dataHolder.setData("t", "ff000000");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff68B200");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffff0000");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ff68B200");
				dataHolder.setData("tpc", "ffffbb00");
				dataHolder.setData("tc", "ff9b9b9b");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "2");
				dataHolder.setData("rtm", "2");
				dataHolder.setData("btm", "2");
				
				break;
			}
			case "12": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ffeaeaea");
				dataHolder.setData("bbg2", "ffb8b8b8");
				dataHolder.setData("rbg", "ffeaeaea");
				dataHolder.setData("rbg2", "ffb8b8b8");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff90ff22");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffff0000");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ff90ff22");
				dataHolder.setData("tpc", "ffffbb00");
				dataHolder.setData("tc", "ff9b9b9b");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "2");
				dataHolder.setData("rtm", "2");
				dataHolder.setData("btm", "2");
				
				break;
			}
			case "3": {
				
				
				// Призначення кольорів
				if (isAndroid12OrHigher) {
					    dataHolder.setData("bg", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt"), true, true));
					    dataHolder.setData("bbg", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt"), true, true));
					    dataHolder.setData("rbg", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt"), true, true));
					    dataHolder.setData("t", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/text.txt"), false, true));
					    dataHolder.setData("tf", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/textfield.txt"), false, true));
					    dataHolder.setData("add", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/additional.txt"), false, true));
					    dataHolder.setData("h", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/hint.txt"), false, true));
					    dataHolder.setData("bt", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttontext.txt"), false, true));
					    dataHolder.setData("rbt", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttontext.txt"), false, true));
					    dataHolder.setData("cb", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/composebuttoncolor.txt"), false, true));
					dataHolder.setData("tpc", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/trackpadcolor.txt"), false, true));
					dataHolder.setData("tc", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/thumbcolor.txt"), false, true));
				} else {
					    // Стандартні кольори для версій нижче Android 12 з урахуванням відтінку
					    dataHolder.setData("bg", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt"), true, false));
					    dataHolder.setData("bbg", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt"), true, false));
					    dataHolder.setData("rbg", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt"), true, false));
					        dataHolder.setData("t", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/text.txt"), false, false));
					    dataHolder.setData("tf", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/textfield.txt"), false, false));
					    dataHolder.setData("add", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/additional.txt"), false, false));
					    dataHolder.setData("h", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/hint.txt"), false, false));
					    dataHolder.setData("bt", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttontext.txt"), false, false));
					    dataHolder.setData("rbt", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttontext.txt"), false, false));
					    dataHolder.setData("cb", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/composebuttoncolor.txt"), false, false));
					dataHolder.setData("tpc", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/trackpadcolor.txt"), false, false));
					dataHolder.setData("tc", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/thumbcolor.txt"), false, false));
				}
				
				
				dataHolder.setData("rou", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/roundness.txt"));
				
				dataHolder.setData("grad", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradient.txt"));
				dataHolder.setData("rgrad", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redgradient.txt"));
				dataHolder.setData("bgrad", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradient.txt"));
				
				dataHolder.setData("rad", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradrad.txt"));
				dataHolder.setData("x", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradX.txt"));
				dataHolder.setData("y", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradY.txt"));
				dataHolder.setData("strcou", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/stripecount.txt"));
				
				dataHolder.setData("rrad", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradrad.txt"));
				dataHolder.setData("rx", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradX.txt"));
				dataHolder.setData("ry", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradY.txt"));
				dataHolder.setData("rstrcou", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rstripecount.txt"));
				
				dataHolder.setData("brad", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradrad.txt"));
				dataHolder.setData("bx", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradX.txt"));
				dataHolder.setData("by", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradY.txt"));
				dataHolder.setData("bstrcou", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bstripecount.txt"));
				
				dataHolder.setData("rrou", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rroundness.txt"));
				dataHolder.setData("srou", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/sroundness.txt"));
				dataHolder.setData("rsrou", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rsroundness.txt"));
				
				dataHolder.setData("tm", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/tilemode.txt"));
				dataHolder.setData("rtm", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redtilemode.txt"));
				dataHolder.setData("btm", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgtilemode.txt"));
				
				break;
			}
		}
	}
	
	// Метод для перевірки і заміни кольорів
	String processColor(String color, boolean isMultiColor, boolean isAndroid12OrHigher) {
		    StringBuilder result = new StringBuilder();
		
		    for (int i = 0; i < color.length(); i += 8) {
			        String part = color.substring(i, i + 8);
			
			        if (part.startsWith("m__")) {
				            if (isAndroid12OrHigher) {
					                // Використання методу для парсингу Monet кольору
					                result.append(selcol(part.substring(3)));
					            } else {
					                // Парсинг відтінку на старіших версіях Android
					                result.append(getLegacyColor(part.substring(3)));
					            }
				        } else {
				            // Додавання кольору як є
				            result.append(part);
				        }
			    }
		
		    return result.toString();
	}
	
	String getLegacyColor(String shade) {
		    switch (shade) {
			case "n1010": return "0xFFFEFAFE";
			case "n1050": return "0xFFFAFAFA";
			case "n1100": return "0xFFF5F5F5";
			case "n1200": return "0xFFEEEEEE";
			case "n1300": return "0xFFE0E0E0";
			case "n1400": return "0xFFBDBDBD";
			case "n1500": return "0xFF9E9E9E";
			case "n1600": return "0xFF757575";
			case "n1700": return "0xFF616161";
			case "n1800": return "0xFF424242";
			case "n1900": return "0xFF212121";
			
			//neutral 2
			case "n2010": return "0xFFF2F3F6";
			case "n2050": return "0xFFECEFF1";
			case "n2100": return "0xFFCFD8DC";
			case "n2200": return "0xFFB0BEC5";
			case "n2300": return "0xFF90A4AE";
			case "n2400": return "0xFF78909C";
			case "n2500": return "0xFF607D8B";
			case "n2600": return "0xFF546E7A";
			case "n2700": return "0xFF455A64";
			case "n2800": return "0xFF37474F";
			case "n2900": return "0xFF263238";
			
			//accent 1
			case "a1010": return "0xFFE9F6FB";
			case "a1050": return "0xFFE0F2F1";
			case "a1100": return "0xFFB2DFDB";
			case "a1200": return "0xFF80CBC4";
			case "a1300": return "0xFF4DB6AC";
			case "a1400": return "0xFF26A69A";
			case "a1500": return "0xFF009688";
			case "a1600": return "0xFF00897B";
			case "a1700": return "0xFF00796B";
			case "a1800": return "0xFF00695C";
			case "a1900": return "0xFF004D40";
			
			//accent 2
			case "a2010": return "0xFFF2FFFC";
			case "a2050": return "0xFFDAF7F3";
			case "a2100": return "0xFFCCE8E4";
			case "a2200": return "0xFFB0CCC8";
			case "a2300": return "0xFF96B1AD";
			case "a2400": return "0xFF7B9693";
			case "a2500": return "0xFF617B78";
			case "a2600": return "0xFF4A6360";
			case "a2700": return "0xFF324B49";
			case "a2800": return "0xFF1C3532";
			case "a2900": return "0xFF051F1D";
			
			//accent 3
			case "a3010": return "0xFFFCFCFF";
			case "a3050": return "0xFFE9F1FF";
			case "a3100": return "0xFFCFE5FF";
			case "a3200": return "0xFFAFC9E7";
			case "a3300": return "0xFF94AECB";
			case "a3400": return "0xFF7A93AF";
			case "a3500": return "0xFF607893";
			case "a3600": return "0xFF48617B";
			case "a3700": return "0xFF304962";
			case "a3800": return "0xFF18324A";
			case "a3900": return "0xFF001D34";
		}return "FFFF0000";}
	
	String selcol(String _col){
		
		try{
				switch(_col) {
						case "n1010": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_10)).toUpperCase();
								break;
						}
						case "n1050": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_50)).toUpperCase();
								break;
						}
						case "n1100": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_100)).toUpperCase();
								break;
						}
						case "n1200": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_200)).toUpperCase();
								break;
						}
						case "n1300": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_300)).toUpperCase();
								break;
						}
						case "n1400": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_400)).toUpperCase();
								break;
						}
						case "n1500": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_500)).toUpperCase();
								break;
						}
						case "n1600": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_600)).toUpperCase();
								break;
						}
						case "n1700": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_700)).toUpperCase();
								break;
						}
						case "n1800": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_800)).toUpperCase();
								break;
						}
						case "n1900": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_900)).toUpperCase();
								break;
						}
						case "n2010": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_10)).toUpperCase();
								break;
						}
						case "n2050": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_50)).toUpperCase();
								break;
						}
						case "n2100": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_100)).toUpperCase();
								break;
						}
						case "n2200": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase();
								break;
						}
						case "n2300": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_300)).toUpperCase();
								break;
						}
						case "n2400": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_400)).toUpperCase();
								break;
						}
						case "n2500": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_500)).toUpperCase();
								break;
						}
						case "n2600": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_600)).toUpperCase();
								break;
						}
						case "n2700": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase();
								break;
						}
						case "n2800": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_800)).toUpperCase();
								break;
						}
						case "n2900": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_900)).toUpperCase();
								break;
						}
						case "a1010": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_10)).toUpperCase();
								break;
						}
						case "a1050": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_50)).toUpperCase();
								break;
						}
						case "a1100": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_100)).toUpperCase();
								break;
						}
						case "a1200": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase();
								break;
						}
						case "a1300": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_300)).toUpperCase();
								break;
						}
						case "a1400": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_400)).toUpperCase();
								break;
						}
						case "a1500": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_500)).toUpperCase();
								break;
						}
						case "a1600": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase();
								break;
						}
						case "a1700": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_700)).toUpperCase();
								break;
						}
						case "a1800": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_800)).toUpperCase();
								break;
						}
						case "a1900": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_900)).toUpperCase();
								break;
						}
						case "a2010": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_10)).toUpperCase();
								break;
						}
						case "a2050": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_50)).toUpperCase();
								break;
						}
						case "a2100": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_100)).toUpperCase();
								break;
						}
						case "a2200": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_200)).toUpperCase();
								break;
						}
						case "a2300": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_300)).toUpperCase();
								break;
						}
						case "a2400": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_400)).toUpperCase();
								break;
						}
						case "a2500": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_500)).toUpperCase();
								break;
						}
						case "a2600": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_600)).toUpperCase();
								break;
						}
						case "a2700": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_700)).toUpperCase();
								break;
						}
						case "a2800": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_800)).toUpperCase();
								break;
						}
						case "a2900": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_900)).toUpperCase();
								break;
						}
						case "a3010": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_10)).toUpperCase();
								break;
						}
						case "a3050": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_50)).toUpperCase();
								break;
						}
						case "a3100": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_100)).toUpperCase();
								break;
						}
						case "a3200": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase();
								break;
						}
						case "a3300": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_300)).toUpperCase();
								break;
						}
						case "a3400": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_400)).toUpperCase();
								break;
						}
						case "a3500": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_500)).toUpperCase();
								break;
						}
						case "a3600": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase();
								break;
						}
						case "a3700": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_700)).toUpperCase();
								break;
						}
						case "a3800": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_800)).toUpperCase();
								break;
						}
						case "a3900": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_900)).toUpperCase();
								break;
						}
						
				}
		}catch(Exception e){
				SketchwareUtil.showMessage(getApplicationContext(), "Monet error");return("ffff0000");
		}
		return (fffff);
		
	}
	
	boolean isAndroid12OrHigher = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S;
	{
	}
	
	
	public void _setAll(final WebView _w) {
		 final AtomicBoolean isu = new AtomicBoolean(false);
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
		    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			        
			    _w.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);}
		    
		    if(FileUtil.readFile("/storage/emulated/0/WeekBrowser/incognito.txt").equals("1")){
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
		
		_w.getSettings().setMinimumFontSize(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/minfont.txt")));
		
		_w.getSettings().setTextZoom(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/fontsize.txt"))*10);
		
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/PC.txt")) == 1) {
			_w.setInitialScale((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/dp.txt"))*5);_w.getSettings().setUserAgentString(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt"));
			
		}
		else {
			_w.setInitialScale((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/dp.txt"))*10);_w.getSettings().setUserAgentString(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt"));
			
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
							if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/IfameBlock.txt").equals("1")) {
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
				if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/IfameBlock.txt").equals("1")) {
					_w.loadUrl("javascript:(function() {     var iframes = document.querySelectorAll('iframe');     if (iframes) {         for (var i = 0; i < iframes.length; i++) {             iframes[i].parentNode.removeChild(iframes[i]);         }     } })(); ");
				}
			}
			isu.set(false);
		}catch(Exception e){
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/IfameBlock.txt").equals("1")) {
				_w.loadUrl("javascript:(function() {     var iframes = document.querySelectorAll('iframe');     if (iframes) {         for (var i = 0; i < iframes.length; i++) {             iframes[i].parentNode.removeChild(iframes[i]);         }     } })(); ");
			}
			isu.set(false);
		}
		_webViewActions(100, "");
	}{
	}
	
	
	public void _progresser(final WebView _w, final double _p) {
		load = _p;
	}
	
	
	public void _prog11(final WebView _w) {
		final AtomicBoolean isu = new AtomicBoolean(false);
		try{
			if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/10001.txt")) == 1) {
				_w.loadUrl(bml11);
			}
			if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/10002.txt")) == 1) {
				_w.loadUrl(bml12);
			}
			try{
				for (int i = 0; i < (int)(sitepermis.size()); i++) {
					if (_w.getUrl().contains(sitepermis.get((int)i).get("url").toString())) {
						switch(sitepermis.get((int)i).get("th").toString()) {
							case "1": {
								_w.loadUrl(themebml);
								break;
							}
							case "2": {
								if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/themepage.txt").equals("1")) {
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
					if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/themepage.txt").equals("1")) {
						_w.loadUrl(themebml);
					}
				}
				isu.set(false);
			}catch(Exception e){
				if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/themepage.txt").equals("1")) {
					_w.loadUrl(themebml);
				}
			}
			isu.set(false);
			if (_w.getUrl().equals("file:///storage/emulated/0/WeekBrowser/bookmark.html")) {
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
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Tabs.json", new Gson().toJson(tab));
			/*
 
*/
		}catch(Exception e){
			 
		}
	}
	
	
	public void _webViewActions(final double _a, final String _s) {
		int childCount = tabscontainer.getChildCount();
		    String activeTabContent = FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt");
		
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
							                            targetWebView.scrollTo(0, targetWebView.getContentHeight());
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
							     if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/PC.txt")) == 1) {
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
								FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Positions/posx1.txt", String.valueOf((long)(targetWebView.getScrollX())));
								FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Positions/posy1.txt", String.valueOf((long)(targetWebView.getScrollY())));
								pos1.setText("(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posx1.txt").concat("; ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posy1.txt").concat(")")))));
								break;
							}
							case ((int)302): {
								FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Positions/posx2.txt", String.valueOf((long)(targetWebView.getScrollX())));
								FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Positions/posy2.txt", String.valueOf((long)(targetWebView.getScrollY())));
								pos2.setText("(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posx2.txt").concat("; ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posy2.txt").concat(")")))));
								break;
							}
							case ((int)303): {
								FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Positions/posx3.txt", String.valueOf((long)(targetWebView.getScrollX())));
								FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Positions/posy3.txt", String.valueOf((long)(targetWebView.getScrollY())));
								pos3.setText("(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posx3.txt").concat("; ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posy3.txt").concat(")")))));
								break;
							}
							case ((int)401): {
								targetWebView.scrollTo(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posx1.txt")),Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posy1.txt")));
								break;
							}
							case ((int)402): {
								targetWebView.scrollTo(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posx2.txt")),Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posy2.txt")));
								break;
							}
							case ((int)403): {
								targetWebView.scrollTo(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posx3.txt")),Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Positions/posy3.txt")));
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
			
			    T++;
			    Tt++;
			        time++;
			   // if (notFirst) {
			        int currentActiveTabIndex = tab.size();
			   if(_move){     FileUtil.writeFile("/storage/emulated/0/WeekBrowser/activeTab.txt", String.valueOf(currentActiveTabIndex));}
			
			
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
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Tabs.json", new Gson().toJson(tab));_Reopentab();
		}catch(Exception e){
			 
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
		try{
			if (usedMemoryMB > Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache/maxram.txt"))) {
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
				//FileUtil.writeFile("/storage/emulated/0/WeekBrowser/activeTab.txt", String.valueOf(0));
				
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
									FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Tabs.json", new Gson().toJson(tab));
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
		toggleKeyboardListener();
		if ((kbd && focused) && selected) {
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
		if (kbd && focused) {
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
		if (kbd && !focused) {
			linear1.setVisibility(View.GONE);
			
			linear5.setVisibility(View.GONE);
			getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
			        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
			        | View.SYSTEM_UI_FLAG_IMMERSIVE);
			isshowpan = false;
		}
		else {
			if (!isshowpan) {
				linear1.setVisibility(View.VISIBLE);
				if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/NavPan.txt").equals("1")) {
					linear5.setVisibility(View.VISIBLE);
				}
				getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
				
				isshowpan = true;
			}
		}
	}
	
	
	public String _getMultilink() {
		return ("https://multilink2.weekbrowser.com/".concat(encodeUrl(new Gson().toJson(tab))));
	}
	
	
	public void _onIntent() {
		intent2 = getIntent();
		if (intent2 != null && intent2.getData() != null) {
			    Uri fileUri = intent2.getData();
			    filePath = fileUri.getPath();
			
			
			if ((!filePath.isEmpty() && filePath.matches("^.*[.]wesk$")) && filePath.contains("/storage")) {
				content = FileUtil.readFile(filePath);
				if (!content.equals("")) {
					skin = new Gson().fromJson(content, new TypeToken<ArrayList<String>>(){}.getType());
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt", skin.get((int)(0)));
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt", skin.get((int)(1)));
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg2.txt", skin.get((int)(2)));
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt", skin.get((int)(3)));
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg2.txt", skin.get((int)(4)));
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/text.txt", skin.get((int)(5)));
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/textfield.txt", skin.get((int)(6)));
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/additional.txt", skin.get((int)(7)));
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/hint.txt", skin.get((int)(8)));
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttontext.txt", skin.get((int)(9)));
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttontext.txt", skin.get((int)(10)));
					try{
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/style.txt", skin.get((int)(11)));
					}catch(Exception e){
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/style.txt", "3");
					}
					try{
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/roundness.txt", skin.get((int)(12)));
					}catch(Exception e){
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/roundness.txt", "0");
					}
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt", "3");
					_colorToRam();
					thema.setClass(getApplicationContext(), SettingsActivity.class);
					startActivity(thema);
					finish();
				}
			}
			if ((!filePath.isEmpty() && filePath.matches("^.*[.]skin$")) && filePath.contains("/storage")) {
				content = FileUtil.readFile(filePath);
				if (!content.equals("")) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt", extractColor(content, "KeyboardBackgroundStartColor="));
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt", extractColor(content, "KeyBackEndColor="));
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg2.txt", extractColor(content, "KeyBackStartColor="));
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt", extractColor(content, "SpecKeyBackEndColor="));
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg2.txt", extractColor(content, "SpecKeyBackStartColor="));
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/text.txt", extractColor(content, "KeyTextColor="));
				}
			}
			if (intent2.getData().toString().startsWith("https://multilink2.weekbrowser.com/")) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/activeTab.txt", "0");
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Tabs.json", decodeUrl(intent2.getData().toString().replace("https://multilink2.weekbrowser.com/", "")));
				finish();
			}
			else {
				for (int i = 0; i < FileUtils.getFileLines("/storage/emulated/0/WeekBrowser/Blockad/domains.txt"); i++) {
					    String line = FileUtils.readLinesFromFile("/storage/emulated/0/WeekBrowser/Blockad/domains.txt", i);
					    if (line != null) {
						        line = line.replace("\\.", ".");
						        if (!line.isEmpty() && !line.startsWith("//") && !line.startsWith("#")) {
							            if (intent2.getData().toString().toLowerCase().startsWith("%")) {
								                if (intent2.getData().toString().matches(".*" + line.substring(1) + ".*")) {
									                    isAd = true;
									                    blockedline = line;
									                    break;
									                }
								            } else {
								                if (_extractDomain(intent2.getData().toString()).matches(".*" + line + ".*")) {
									                    isAd = true;
									                    blockedline = line;
									                    break;
									                }
								            }
							        }
						    } else {
						        Log.e("ReadLineError", "Failed to read line " + i + " from domains.txt");
						   
						    }
				}
				
				for (int i = 0; i < FileUtils.getFileLines("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt"); i++) {
					    String line = FileUtils.readLinesFromFile("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt", i);
					    if (line != null) {
						        line = line.replace("\\.", ".");
						        if (!line.isEmpty() && !line.startsWith("//") && !line.startsWith("#")) {
							            if (intent2.getData().toString().toLowerCase().startsWith("%")) {
								                if (intent2.getData().toString().matches(".*" + line.substring(1) + ".*")) {
									                    isAd = true;
									blockedline = line;
									                    break;
									                }
								            } else {
								                if (_extractDomain(intent2.getData().toString()).matches(".*" + line + ".*")) {
									                    isAd = true;
									blockedline = line;
									                    break;
									                }
								            }
							        }
						    } else {
						        Log.e("ReadLineError", "Failed to read line " + i + " from userdomains.txt");
						       
						    }
				}
				
				if (isAd) {
					SketchwareUtil.showMessage(getApplicationContext(), "Цей сайт заблокований блокувальником реклами\n".concat(blockedline));
					moveTaskToBack(true);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/url", intent2.getData().toString());
				}
			}
		}
	}
	
	
	public void _openToast(final String _url) {
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
	}
	
	
	public void _sslerror() {
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		
		Skin skin = new Skin();
		skin.setBG(ssl, 1, true);
		ssl.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
	}
	
	
	public void _ifex3() {
		if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg2.txt")) {
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg2.txt")));
			FileUtil.deleteFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg2.txt");
			FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg2.txt")));
			FileUtil.deleteFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg2.txt");
		}
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
			final TextView name = _view.findViewById(R.id.name);
			final TextView close = _view.findViewById(R.id.close);
			
			int childCount;
			name.setText(((_data.get((int)_position).get("name")!=null) ? (_data.get((int)_position).get("name").toString()) : ("-")));
			close.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					int childCount = tabscontainer.getChildCount();
					//FileUtil.writeFile("/storage/emulated/0/WeekBrowser/activeTab.txt", String.valueOf(0));
					
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
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Tabs.json", new Gson().toJson(tab));
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
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Tabs.json", new Gson().toJson(tab));
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/activeTab.txt", String.valueOf((long)(maxind)));
						dataHolder.setData("ml", "https://multilink2.weekbrowser.com/".concat(encodeUrl(new Gson().toJson(tab))));
					}catch(Exception e){
						SketchwareUtil.showMessage(getApplicationContext(), "Вкладок немає");
					}
					_Reopentab();
				}
			});
			name.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					try{
						int prevpos = Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt"));
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
								    tabs.setText("[" + tab.size() + "]");
								
								  //  if (notFirst) {
								     //   int currentActive_dataIndex = _data.size() + 1;
								        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/activeTab.txt", String.valueOf(_position));
								
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
								
								newWebView.loadUrl(FileUtil.readFile("/storage/emulated/0/WeekBrowser/firstpage.txt"));  // Завантаження початкового URL для нової вкладки
								  
								
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
									_item.put("url", FileUtil.readFile("/storage/emulated/0/WeekBrowser/firstpage.txt"));
									_data.add(_item);
								}
								
							}}
						if(prevpos == Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt")));
						tab.get(_position).put("time", time);
						((BaseAdapter)tabscont.getAdapter()).notifyDataSetChanged();
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/activeTab.txt", String.valueOf((long)(_position)));
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Tabs.json", new Gson().toJson(tab));
						dataHolder.setData("ml", "https://multilink2.weekbrowser.com/".concat(encodeUrl(new Gson().toJson(tab))));
					}catch(Exception e){
						 
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
								FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt").concat("\n".concat(_extractDomain(_data.get((int)_position).get("url").toString()).replace(".", "\\."))));
								close.performClick();
								MyWebViewClient webViewClient = new MyWebViewClient(MainActivity.this); // Створення екземпляру класу
								webViewClient.updateBlockedHosts(); // Виклик методу на екземплярі
							}
						});
						blockads.setNegativeButton("[    2    ]", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt").concat("\n%".concat(_data.get((int)_position).get("url").toString().replace(".", "\\."))));
								close.performClick();
								MyWebViewClient webViewClient = new MyWebViewClient(MainActivity.this); // Створення екземпляру класу
								webViewClient.updateBlockedHosts(); // Виклик методу на екземплярі
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
					}
					return true;
				}
			});
			name.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					int childCount = tabscontainer.getChildCount();
					//FileUtil.writeFile("/storage/emulated/0/WeekBrowser/activeTab.txt", String.valueOf(0));
					
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
						String activeTabContent = FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt");
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
			String activeTabContent = FileUtil.readFile("/storage/emulated/0/WeekBrowser/activeTab.txt");
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