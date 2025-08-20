package com.a525team.weekbrowser;

import android.Manifest;
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
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.*;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.regex.*;
import org.json.*;
import android.app.ActivityManager.MemoryInfo;

public class SettingsActivity extends Activity {
	
	public final int REQ_CD_FP = 101;
	
	private String alarm = "";
	private String douwant = "";
	private String yes = "";
	private String no = "";
	private String cacheisclear = "";
	Colorify colorify = new Colorify();
	ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	private String fffff = "";
	
	private ArrayList<String> languag = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private WebView webview1;
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
	private LinearLayout linear6;
	private RadioGroup radiogroup2;
	private CheckBox onnointernet;
	private LinearLayout linear22;
	private SeekBar maxram;
	private TextView textview6;
	private RadioGroup radiogroup3;
	private Button opentheme;
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
	private CheckBox setaccess;
	private LinearLayout linear23;
	private CheckBox videoad;
	private LinearLayout linear24;
	private EditText keywords;
	private TextView conftitle;
	private LinearLayout linear25;
	private TextView about;
	private TextView developerinfo;
	private LinearLayout linear20;
	private LinearLayout linear19;
	private Button privat;
	private TextView devopt;
	private CheckBox useram;
	private CheckBox jslog;
	private Button add;
	private Button crash;
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
	private RadioButton radiobutton1;
	private RadioButton light;
	private RadioButton dark;
	private RadioButton radiobutton2;
	private RadioButton radiobutton5;
	private RadioButton radiobutton6;
	private RadioButton radiobutton7;
	private RadioButton radiobutton3;
	private RadioButton radiobutton4;
	private RadioButton radiobutton9;
	private RadioButton radiobutton10;
	private RadioButton highcontrast;
	private RadioButton customtheme;
	private RadioButton loadingslash;
	private RadioButton percent;
	private RadioButton loadingpercent;
	private RadioButton slash;
	private RadioButton slpercentash;
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
	private EditText pass;
	private Button tgk;
	private Button tgkc;
	private Button tgc;
	private Button tgcc;
	
	private Intent intent = new Intent();
	private AlertDialog.Builder dlg;
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private ObjectAnimator anim = new ObjectAnimator();
	private ObjectAnimator prevcheckbox = new ObjectAnimator();
	private AlertDialog.Builder hints;
	private ObjectAnimator pnupanim = new ObjectAnimator();
	private AlertDialog.Builder scr;
	private AlertDialog.Builder def;
	private SharedPreferences sf;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.settings);
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
		        setContentView(R.layout.settings);
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		webview1 = findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
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
		linear6 = findViewById(R.id.linear6);
		radiogroup2 = findViewById(R.id.radiogroup2);
		onnointernet = findViewById(R.id.onnointernet);
		linear22 = findViewById(R.id.linear22);
		maxram = findViewById(R.id.maxram);
		textview6 = findViewById(R.id.textview6);
		radiogroup3 = findViewById(R.id.radiogroup3);
		opentheme = findViewById(R.id.opentheme);
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
		linear23 = findViewById(R.id.linear23);
		videoad = findViewById(R.id.videoad);
		linear24 = findViewById(R.id.linear24);
		keywords = findViewById(R.id.keywords);
		conftitle = findViewById(R.id.conftitle);
		linear25 = findViewById(R.id.linear25);
		about = findViewById(R.id.about);
		developerinfo = findViewById(R.id.developerinfo);
		linear20 = findViewById(R.id.linear20);
		linear19 = findViewById(R.id.linear19);
		privat = findViewById(R.id.privat);
		devopt = findViewById(R.id.devopt);
		useram = findViewById(R.id.useram);
		jslog = findViewById(R.id.jslog);
		add = findViewById(R.id.add);
		crash = findViewById(R.id.crash);
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
		radiobutton1 = findViewById(R.id.radiobutton1);
		light = findViewById(R.id.light);
		dark = findViewById(R.id.dark);
		radiobutton2 = findViewById(R.id.radiobutton2);
		radiobutton5 = findViewById(R.id.radiobutton5);
		radiobutton6 = findViewById(R.id.radiobutton6);
		radiobutton7 = findViewById(R.id.radiobutton7);
		radiobutton3 = findViewById(R.id.radiobutton3);
		radiobutton4 = findViewById(R.id.radiobutton4);
		radiobutton9 = findViewById(R.id.radiobutton9);
		radiobutton10 = findViewById(R.id.radiobutton10);
		highcontrast = findViewById(R.id.highcontrast);
		customtheme = findViewById(R.id.customtheme);
		loadingslash = findViewById(R.id.loadingslash);
		percent = findViewById(R.id.percent);
		loadingpercent = findViewById(R.id.loadingpercent);
		slash = findViewById(R.id.slash);
		slpercentash = findViewById(R.id.slpercentash);
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
		pass = findViewById(R.id.pass);
		tgk = findViewById(R.id.tgk);
		tgkc = findViewById(R.id.tgkc);
		tgc = findViewById(R.id.tgc);
		tgcc = findViewById(R.id.tgcc);
		dlg = new AlertDialog.Builder(this);
		fp.setType("*/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		hints = new AlertDialog.Builder(this);
		scr = new AlertDialog.Builder(this);
		def = new AlertDialog.Builder(this);
		sf = getSharedPreferences("code", Activity.MODE_PRIVATE);
		
		//webviewOnProgressChanged
		webview1.setWebChromeClient(new WebChromeClient() {
				@Override public void onProgressChanged(WebView view, int _newProgress) {
					
				}
		});
		
		//OnDownloadStarted
		webview1.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
				DownloadManager.Request webview1a = new DownloadManager.Request(Uri.parse(url));
				String webview1b = CookieManager.getInstance().getCookie(url);
				webview1a.addRequestHeader("cookie", webview1b);
				webview1a.addRequestHeader("User-Agent", userAgent);
				webview1a.setDescription("Downloading file...");
				webview1a.setTitle(URLUtil.guessFileName(url, contentDisposition, mimetype));
				webview1a.allowScanningByMediaScanner(); webview1a.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); webview1a.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, contentDisposition, mimetype));
				
				DownloadManager webview1c = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				webview1c.enqueue(webview1a);
				showMessage("Downloading File....");
				BroadcastReceiver onComplete = new BroadcastReceiver() {
					public void onReceive(Context ctxt, Intent intent) {
						showMessage("Download Complete!");
						unregisterReceiver(this);
						
					}};
				registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
			}
		});
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
		
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
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SearchPan.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SearchPan.txt", "1");
					srhhis.setChecked(true);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SearchPan.txt", "0");
					srhhis.setChecked(false);
				}
			}
		});
		
		navpan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/NavPan.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/NavPan.txt", "1");
					navpan.setChecked(true);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/NavPan.txt", "0");
					navpan.setChecked(false);
				}
			}
		});
		
		pnup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Navpanelpos.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Navpanelpos.txt", "1");
					pnup.setChecked(true);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Navpanelpos.txt", "0");
					pnup.setChecked(false);
				}
			}
		});
		
		srup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Searchpanelpos.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Searchpanelpos.txt", "1");
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Searchpanelpos.txt", "0");
				}
			}
		});
		
		zoombtns.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/ZoomButton.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/ZoomButton.txt", "1");
					auto.setChecked(true);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/ZoomButton.txt", "0");
					auto.setChecked(false);
				}
			}
		});
		
		screen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/NoScreen.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/NoScreen.txt", "1");
					screen.setChecked(true);
					linear21.setVisibility(View.GONE);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/NoScreen.txt", "0");
					screen.setChecked(false);
					linear21.setVisibility(View.VISIBLE);
					prevcheckbox.setTarget(linear21);
					prevcheckbox.setPropertyName("scaleX");
					prevcheckbox.setFloatValues((float)(0), (float)(1));
					prevcheckbox.setDuration((int)(500));
					prevcheckbox.start();
				}
			}
		});
		
		mono.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/monofortextarea.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/monofortextarea.txt", "1");
					startpage.setTypeface(Typeface.MONOSPACE);
					keywords.setTypeface(Typeface.MONOSPACE);
					pass.setTypeface(Typeface.MONOSPACE);
					
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/monofortextarea.txt", "0");
					startpage.setTypeface(Typeface.DEFAULT);
					keywords.setTypeface(Typeface.DEFAULT);
					pass.setTypeface(Typeface.DEFAULT);
					
				}
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), BookmarkletsActivity.class);
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
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt", String.valueOf((long)(_progressValue + 20)));
				hintt.setText(getString(R.string.buttons_size).concat(" (").concat(String.valueOf((long)(_progressValue + 20)).concat(" dp)")));
				e1.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
				e1.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
				e1.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
				e1.requestLayout();
				
				e2.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
				e2.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
				e2.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
				e2.requestLayout();
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		onnointernet.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/onNoInternet.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/onNoInternet.txt", "1");
					onnointernet.setChecked(true);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/onNoInternet.txt", "0");
					onnointernet.setChecked(false);
				}
			}
		});
		
		maxram.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/cache/maxram.txt", String.valueOf((long)((_totalMem() / 32.d) * _progressValue)));
				maxramt.setText(getString(R.string.ram_limit).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache/maxram.txt").concat(" МіБ")));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		opentheme.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), CustomthemeActivity.class);
				startActivity(intent);
			}
		});
		
		infogravity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/InfoText.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/InfoText.txt", "1");
					infogravity.setChecked(true);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/InfoText.txt", "0");
					infogravity.setChecked(false);
				}
			}
		});
		
		auto.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/autofirstpage.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/autofirstpage.txt", "1");
					auto.setChecked(true);
					linear4.setVisibility(View.GONE);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/autofirstpage.txt", "0");
					auto.setChecked(false);
					linear4.setVisibility(View.VISIBLE);
					linear4.requestFocus();
					anim.setTarget(linear4);
					anim.setPropertyName("scaleX");
					anim.setFloatValues((float)(0), (float)(1));
					anim.setDuration((int)(1000));
					anim.start();
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
		
		setaccess.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/blockredir.txt").equals("1")) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/blockredir.txt", "0");
					setaccess.setChecked(false);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/blockredir.txt", "1");
					setaccess.setChecked(true);
				}
			}
		});
		
		videoad.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/skipvideoad.txt").equals("1")) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/skipvideoad.txt", "0");
					videoad.setChecked(false);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/skipvideoad.txt", "1");
					videoad.setChecked(true);
				}
			}
		});
		
		keywords.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/videopatterns.txt", _charSeq.replace("\n", "\n"));
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
			}
		});
		
		useram.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/dev/usedram.txt").equals("1")) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/dev/usedram.txt", "0");
					useram.setChecked(false);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/dev/usedram.txt", "1");
					useram.setChecked(true);
				}
			}
		});
		
		jslog.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/dev/jslog.txt").equals("1")) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/dev/jslog.txt", "0");
					jslog.setChecked(false);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/dev/jslog.txt", "1");
					jslog.setChecked(true);
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
		
		google.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt", "0");
			}
		});
		
		bing.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt", "1");
			}
		});
		
		yahoo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt", "2");
			}
		});
		
		duck.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt", "3");
			}
		});
		
		hide.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/HidePanels.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/HidePanels.txt", "1");
					onnointernet.setChecked(true);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/HidePanels.txt", "0");
					onnointernet.setChecked(false);
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
				hints.create().show();
			}
		});
		
		preview.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/NoPreview.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/NoPreview.txt", "1");
					auto.setChecked(true);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/NoPreview.txt", "0");
					auto.setChecked(false);
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
				scr.create().show();
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
				hints.create().show();
			}
		});
		
		std.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/cache.txt", "0");
			}
		});
		
		dts.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/cache.txt", "1");
			}
		});
		
		ionl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/cache.txt", "2");
			}
		});
		
		conl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/cache.txt", "3");
			}
		});
		
		ramdef.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				maxram.setProgress((int)24);
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/cache/maxram.txt", String.valueOf((long)((_totalMem() / 32.d) * maxram.getProgress())));
				maxramt.setText("Обмеження використання оперативної пам'яті: ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache/maxram.txt").concat(" МіБ")));
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
				hints.create().show();
			}
		});
		
		radiobutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt", "4");
				_colorToRam();
				_theme();
			}
		});
		
		light.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt", "0");
				_colorToRam();
				_theme();
			}
		});
		
		dark.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt", "1");
				_colorToRam();
				_theme();
			}
		});
		
		radiobutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt", "5");
				_colorToRam();
				_theme();
			}
		});
		
		radiobutton5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt", "8");
				_colorToRam();
				_theme();
			}
		});
		
		radiobutton6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt", "9");
				_colorToRam();
				_theme();
			}
		});
		
		radiobutton7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt", "10");
				_colorToRam();
				_theme();
			}
		});
		
		radiobutton3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt", "6");
				_colorToRam();
				_theme();
			}
		});
		
		radiobutton4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt", "7");
				_colorToRam();
				_theme();
			}
		});
		
		radiobutton9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt", "11");
				_colorToRam();
				_theme();
			}
		});
		
		radiobutton10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt", "12");
				_colorToRam();
				_theme();
			}
		});
		
		highcontrast.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt", "2");
				_colorToRam();
				_theme();
			}
		});
		
		customtheme.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt", "3");
				_colorToRam();
				_theme();
			}
		});
		
		loadingslash.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/loadingstyle.txt", "0");
			}
		});
		
		percent.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/loadingstyle.txt", "3");
			}
		});
		
		loadingpercent.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/loadingstyle.txt", "1");
			}
		});
		
		slash.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/loadingstyle.txt", "2");
			}
		});
		
		slpercentash.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Themes/loadingstyle.txt", "4");
			}
		});
		
		startpage.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/firstpage.txt", _charSeq);
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
				startpage.setText("file:///storage/emulated/0/WeekBrowser/bookmark.html");
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
				try{
					alarm = languag.get((int)(109));
				}catch(Exception e){
					if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
						alarm = "ALARM";
					}
					else {
						alarm = "ПОПЕРЕДЖЕННЯ";
					}
				}
				try{
					douwant = languag.get((int)(148));
				}catch(Exception e){
					if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
						douwant = "Afer clicking \"Yes\" button, you will clear history of search. This is not undoable, but you can write search prompt on keyboard again. Do you want this? Think 2 times ;)";
					}
					else {
						douwant = "Після натискання кнопки \"Так\", Ви очистите історію пошуку. Це неможливо відновити, але Ви можете знову набрати пошуковий запит на клавіатурі. Ви хочете цього? Подумайте двічі ;)";
					}
				}
				try{
					yes = languag.get((int)(108));
				}catch(Exception e){
					if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
						yes = "YES";
					}
					else {
						yes = "ТАК";
					}
				}
				try{
					no = languag.get((int)(107));
				}catch(Exception e){
					if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
						no = "NO";
					}
					else {
						no = "НІ";
					}
				}
				dlg.setTitle(alarm);
				dlg.setMessage(douwant);
				dlg.setPositiveButton(yes, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/search.txt", "[weekbrowser]");
						SketchwareUtil.showMessage(getApplicationContext(), "Історію пошуку очищено!");
					}
				});
				dlg.setNegativeButton(no, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				dlg.create().show();
			}
		});
		
		srha.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Autoclean/search.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Autoclean/search.txt", "1");
					srha.setChecked(true);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Autoclean/search.txt", "0");
					srha.setChecked(false);
				}
			}
		});
		
		clrcache.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.clearCache(true);
				try{
					cacheisclear = languag.get((int)(150));
				}catch(Exception e){
					if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
						cacheisclear = "Cache is clean!";
					}
					else {
						cacheisclear = "Кеш очищено!";
					}
				}
				SketchwareUtil.showMessage(getApplicationContext(), cacheisclear);
			}
		});
		
		cachea.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Autoclean/cache.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Autoclean/cache.txt", "1");
					cachea.setChecked(true);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Autoclean/cache.txt", "0");
					cachea.setChecked(false);
				}
			}
		});
		
		cookieclr.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				CookieManager.getInstance().removeAllCookies(null);
				SketchwareUtil.showMessage(getApplicationContext(), "Кукі очищено!");
			}
		});
		
		cookiea.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Autoclean/cookie.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Autoclean/cookie.txt", "1");
					cookiea.setChecked(true);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Autoclean/cookie.txt", "0");
					cookiea.setChecked(false);
				}
			}
		});
		
		formclr.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.clearFormData();
				SketchwareUtil.showMessage(getApplicationContext(), "Дані автозаповнення очищено!");
			}
		});
		
		forma.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Autoclean/form.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Autoclean/form.txt", "1");
					forma.setChecked(true);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Autoclean/form.txt", "0");
					forma.setChecked(false);
				}
			}
		});
		
		iframer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/showiframer.txt").equals("1")) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/showiframer.txt", "0");
					iframer.setChecked(false);
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/showiframer.txt", "1");
					iframer.setChecked(true);
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
				hints.create().show();
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
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/videopatterns.txt", "Пропустити через|Реклама •|Реклама закінчиться|Реклама [0-9]|Відео незабаром почне відтворюватися|Видео скоро начнется|Вы cможете перейти\\nк видео через");
					}
				});
				def.setNegativeButton("Decline", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				def.create().show();
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
				}
				else {
					/*
FileUtil.writeFile("/storage/emulated/0/WeekBrowser/showpassword", "");
*/
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
				hints.create().show();
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
				if (hidepass.isChecked()) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/hidepassword.txt", "1");
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/hidepassword.txt", "0");
				}
			}
		});
		
		pass.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if ((_charSeq.length() < 11) && (_charSeq.length() > 0)) {
					sf.edit().putString("code", _charSeq).commit();
				}
				else {
					
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
				startActivity(Intent.createChooser(intent, "Передача даних СБУ, не вимикайте пристрій..."));
			}
		});
		
		tgkc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "https://t.me/a525team/"));
			}
		});
		
		tgc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://t.me/week_thor/"));
				startActivity(Intent.createChooser(intent, "Інтім не предлагать, могу ні отказаца"));
			}
		});
		
		tgcc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "https://t.me/week_thor/"));
			}
		});
	}
	
	private void initializeLogic() {
		pass.setVisibility(View.GONE);
		lock.setVisibility(View.GONE);
		lock2.setVisibility(View.GONE);
		hidepass.setVisibility(View.GONE);
		navpan.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/NavPan.txt")) == 1);
		std.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache.txt")) == 0);
		dts.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache.txt")) == 1);
		ionl.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache.txt")) == 2);
		srha.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Autoclean/search.txt")) == 1);
		cachea.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Autoclean/cache.txt")) == 1);
		cookiea.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Autoclean/cookie.txt")) == 1);
		forma.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Autoclean/form.txt")) == 1);
		conl.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache.txt")) == 3);
		light.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 0);
		dark.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 1);
		highcontrast.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 2);
		customtheme.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 3);
		radiobutton1.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 4);
		radiobutton2.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 5);
		radiobutton5.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 8);
		radiobutton6.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 9);
		radiobutton7.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 10);
		radiobutton3.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 6);
		radiobutton4.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 7);
		radiobutton9.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 11);
		radiobutton10.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 12);
		loadingslash.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/loadingstyle.txt")) == 0);
		loadingpercent.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/loadingstyle.txt")) == 1);
		srhhis.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SearchPan.txt")) == 1);
		slash.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/loadingstyle.txt")) == 2);
		percent.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/loadingstyle.txt")) == 3);
		slpercentash.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/loadingstyle.txt")) == 4);
		infogravity.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/InfoText.txt")) == 1);
		onnointernet.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/onNoInternet.txt")) == 1);
		google.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt")) == 0);
		bing.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt")) == 1);
		yahoo.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt")) == 2);
		duck.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SearchEngine.txt")) == 3);
		hide.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/HidePanels.txt")) == 1);
		srup.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Searchpanelpos.txt")) == 1);
		pnup.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Navpanelpos.txt")) == 1);
		auto.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/autofirstpage.txt")) == 1);
		zoombtns.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/ZoomButton.txt")) == 1);
		screen.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/NoScreen.txt")) == 1);
		preview.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/NoPreview.txt")) == 1);
		mono.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/monofortextarea.txt")) == 1);
		setaccess.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/blockredir.txt")) == 1);
		videoad.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/skipvideoad.txt")) == 1);
		useram.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/dev/usedram.txt")) == 1);
		iframer.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/showiframer.txt")) == 1);
		jslog.setChecked(FileUtil.readFile("/storage/emulated/0/WeekBrowser/dev/jslog.txt").equals("1"));
		hidepass.setChecked(FileUtil.readFile("/storage/emulated/0/WeekBrowser/hidepassword.txt").equals("1"));
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/autofirstpage.txt").equals("1")) {
			linear4.setVisibility(View.GONE);
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/NoScreen.txt").equals("1")) {
			linear21.setVisibility(View.GONE);
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/NavPan.txt").equals("0")) {
			pnup.setVisibility(View.GONE);
		}
		startpage.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/firstpage.txt"));
		keywords.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/videopatterns.txt"));
		seekbar1.setProgress((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) - 20);
		String maxRamStr = FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache/maxram.txt");
		double maxRam = Double.parseDouble(maxRamStr);
		double totalMem = _totalMem();
		int progress = (int)((maxRam / totalMem * 32)+0.5);
		maxram.setProgress(progress);
		maxramt.setText(getString(R.string.ram_limit).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache/maxram.txt").concat(" МіБ")));
		hintt.setText(getString(R.string.buttons_size).concat(" (").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt").concat(" dp)")));
		loadingslash.setText(getString(R.string.loading).concat(" //////////////////////"));
		loadingpercent.setText(getString(R.string.loading).concat(" 35%"));
		radiobutton1.setText(getString(R.string.white).concat(" Monet"));
		light.setText(getString(R.string.light).concat(" Monet"));
		dark.setText(getString(R.string.dark).concat(" Monet"));
		radiobutton2.setText(getString(R.string.black).concat(" Monet"));
		radiobutton5.setText(getString(R.string.light).concat(" Material"));
		radiobutton6.setText(getString(R.string.dark).concat(" Material"));
		radiobutton7.setText(getString(R.string.black).concat(" Material"));
		radiobutton3.setText(getString(R.string.white).concat(" Holo"));
		radiobutton4.setText(getString(R.string.black).concat(" Holo"));
		radiobutton9.setText(getString(R.string.white).concat(" Android 1"));
		radiobutton10.setText(getString(R.string.black).concat(" Android 1"));
		if (sf.contains("en")) {
			if (sf.getString("en", "").equals("1")) {
				lock.setChecked(true);
				lock2.setChecked(true);
			}
			else {
				if (sf.getString("en", "").equals("2")) {
					lock.setChecked(true);
				}
			}
		}
		else {
			sf.edit().putString("en", "0").commit();
			sf.edit().putString("code", "1111").commit();
		}
		pass.setText(sf.getString("code", ""));
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
				if (_filePath.get((int)(0)).contains(".welang")) {
					FileUtil.copyFile(_filePath.get((int)(0)), "/storage/emulated/0/WeekBrowser/Language.welang");
					intent.setClass(getApplicationContext(), SettingsActivity.class);
					startActivity(intent);
					finishAffinity();
				}
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
		finish();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/monofortextarea.txt").equals("1")) {
			startpage.setTypeface(Typeface.MONOSPACE);
			keywords.setTypeface(Typeface.MONOSPACE);
		}
		else {
			startpage.setTypeface(Typeface.DEFAULT);keywords.setTypeface(Typeface.DEFAULT);
		}
		_Languag();
		_theme();
		if (dataHolder.getData("safe")!=null && dataHolder.getData("safe").equals("1")) {
			showpass.setText("");
			dataHolder.setData("safe", "0");
			pass.setVisibility(View.VISIBLE);
			lock.setVisibility(View.VISIBLE);
			lock2.setVisibility(View.VISIBLE);
			hidepass.setVisibility(View.VISIBLE);
		}
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
			skin.setBG(ifrhint, 0, false);
			skin.setBG(hidehint, 1, false);
			skin.setBG(crash, 1, false);
			skin.setBG(defadfilters, 1, false);
			skin.setBG(showpass, 1, false);
			skin.setBG(passhint, 0, false);
			skin.setBG(tgk, 0, false);
			skin.setBG(tgkc, 0, false);
			skin.setBG(tgc, 0, false);
			skin.setBG(tgcc, 0, false);
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
			
			button4.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			hidehint.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			ramdef.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			cookieclr.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			formclr.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			e1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			e2.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			
			tgc.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			tgcc.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			tgk.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			tgkc.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			privat.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			videoad.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			
			conftitle.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			lock.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			lock2.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			hidepass.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			pass.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
			pass.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
			showpass.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			passhint.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			
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
			
			textview11.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
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
			onnointernet.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			customtheme.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
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
			light.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			dark.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			name.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			
			loadstyle.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			highcontrast.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			radiobutton1.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			radiobutton2.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			radiobutton3.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			radiobutton5.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			radiobutton6.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			radiobutton7.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			radiobutton4.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			radiobutton9.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			radiobutton10.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
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
			applyColorsToViews(findViewById(android.R.id.content));
		}catch(Exception e){
			 
		}
		showpass.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
	}
	
	private void applyColorsToViews(View view) {
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
	
	
	{
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
	
	
	public double _totalMem() {
		ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
		        MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
		        activityManager.getMemoryInfo(memoryInfo);
		
		        // Загальна кількість доступної пам'яті
		        return memoryInfo.totalMem / 1048576L; // в MB
		
	}
	
	
	public void _checklock() {
		if (lock.isChecked()) {
			if (lock2.isChecked()) {
				sf.edit().putString("en", "1").commit();
			}
			else {
				sf.edit().putString("en", "2").commit();
			}
		}
		else {
			sf.edit().putString("en", "0").commit();
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