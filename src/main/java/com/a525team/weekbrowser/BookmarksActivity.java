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
import android.content.DialogInterface;
import android.content.Intent;
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
import java.text.DecimalFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.regex.*;
import org.json.*;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;


public class BookmarksActivity extends Activity {
	
	public final int REQ_CD_FP = 101;
	public final int REQ_CD_DES = 102;
	
	private String URL = "";
	private boolean delete = false;
	private String lol = "";
	private String prevImage = "";
	private double iterations = 0;
	private boolean youmaychangesettings = false;
	ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	Colorify colorify = new Colorify();
	
	private ArrayList<String> languag = new ArrayList<>();
	private ArrayList<String> E = new ArrayList<>();
	
	private LinearLayout linear3;
	private WebView webview1;
	private Button hideshow;
	private LinearLayout linear1;
	private HorizontalScrollView hscroll2;
	private LinearLayout linear6;
	private Button deletee;
	private LinearLayout linear10;
	private Button blink;
	private Button bsearch;
	private Button biframe;
	private Button bdesign;
	private Button bhtml;
	private LinearLayout lsearch;
	private LinearLayout llink;
	private LinearLayout liframe;
	private LinearLayout lhtml;
	private LinearLayout design;
	private TextView textview7;
	private AutoCompleteTextView tahint;
	private TextView textview8;
	private AutoCompleteTextView tabef;
	private AutoCompleteTextView taafter;
	private Button pagesearch;
	private LinearLayout linear12;
	private LinearLayout linear15;
	private LinearLayout linear29;
	private Button google;
	private Button bing;
	private Button yahoo;
	private Button duck;
	private Button youtube;
	private Button gimages;
	private Button gvideo;
	private Button gnews;
	private TextView textview2;
	private AutoCompleteTextView name;
	private TextView textview3;
	private AutoCompleteTextView link;
	private LinearLayout linear31;
	private TextView textview5;
	private HorizontalScrollView hscroll1;
	private Button add;
	private Button inslink;
	private Button insmlink;
	private LinearLayout linear2;
	private AutoCompleteTextView color;
	private Button c1;
	private Button c2;
	private Button c3;
	private Button c4;
	private Button c5;
	private Button c6;
	private Button c7;
	private Button c8;
	private TextView textview9;
	private AutoCompleteTextView autocomplete4;
	private TextView textview11;
	private AutoCompleteTextView autocomplete5;
	private TextView textview13;
	private AutoCompleteTextView autocomplete6;
	private Button button4;
	private AutoCompleteTextView html;
	private Button refresh;
	private LinearLayout linear18;
	private ScrollView vscroll1;
	private ScrollView vscroll2;
	private LinearLayout linear19;
	private Button tobg;
	private TextView t1;
	private TextView txtszind;
	private SeekBar txtsz;
	private TextView t2;
	private TextView txtboldind;
	private SeekBar txtbold;
	private CheckBox italic;
	private TextView t3;
	private TextView txtintind;
	private SeekBar txtint;
	private TextView t4;
	private RadioGroup radiogroup2;
	private TextView t5;
	private RadioGroup radiogroup3;
	private TextView t6;
	private HorizontalScrollView hscroll10;
	private TextView t7;
	private TextView shadxind;
	private SeekBar shadx;
	private TextView t8;
	private TextView shadyind;
	private SeekBar shady;
	private TextView t9;
	private TextView shadbind;
	private SeekBar shadb;
	private TextView t10;
	private HorizontalScrollView hscroll6;
	private TextView t11;
	private TextView shadalpind;
	private SeekBar shadalp;
	private TextView t12;
	private TextView txtstrszind;
	private SeekBar txtstrsz;
	private TextView t13;
	private HorizontalScrollView hscroll7;
	private TextView t14;
	private TextView stralpind;
	private SeekBar stralp;
	private TextView t15;
	private TextView wrdstrszind;
	private SeekBar wrdstr;
	private TextView t16;
	private TextView wstrstind;
	private SeekBar wstrst;
	private TextView t17;
	private HorizontalScrollView hscroll8;
	private TextView t18;
	private TextView wstralpind;
	private SeekBar wstralp;
	private TextView t19;
	private TextView txtbrind;
	private SeekBar txtbr;
	private TextView t20;
	private TextView txtcontind;
	private SeekBar txtcont;
	private TextView t21;
	private TextView txtsaturind;
	private SeekBar txtsatur;
	private TextView t22;
	private TextView txtsepiaind;
	private SeekBar txtsepia;
	private TextView t23;
	private TextView txtinvind;
	private SeekBar txtinv;
	private TextView t24;
	private TextView txthueind;
	private SeekBar txthue;
	private TextView t25;
	private TextView txtblurind;
	private SeekBar txtblur;
	private TextView t26;
	private TextView txtalpind;
	private SeekBar txtalp;
	private TextView t27;
	private TextView txtblendind;
	private SeekBar txtblend;
	private RadioButton sans;
	private RadioButton serif;
	private RadioButton mono;
	private RadioButton courier;
	private RadioButton cursive;
	private RadioButton std;
	private RadioButton allbig;
	private RadioButton allsmall;
	private RadioButton capit;
	private RadioGroup radiogroup4;
	private RadioButton left;
	private RadioButton center;
	private RadioButton right;
	private RadioButton justify;
	private LinearLayout linear24;
	private AutoCompleteTextView shadc;
	private Button sc1;
	private Button sc2;
	private Button sc3;
	private Button sc4;
	private Button sc5;
	private Button sc6;
	private Button sc7;
	private Button sc8;
	private LinearLayout linear25;
	private AutoCompleteTextView strcol;
	private Button wsc1;
	private Button wsc2;
	private Button wsc3;
	private Button wsc4;
	private Button wsc5;
	private Button wsc6;
	private Button wsc7;
	private Button wsc8;
	private LinearLayout linear26;
	private AutoCompleteTextView wstrcol;
	private Button wstc1;
	private Button wstc2;
	private Button wstc3;
	private Button wstc4;
	private Button wstc5;
	private Button wstc6;
	private Button wstc7;
	private Button wstc8;
	private LinearLayout linear20;
	private Button totxt;
	private LinearLayout linear17;
	private TextView t28;
	private HorizontalScrollView hscroll3;
	private TextView t29;
	private RadioGroup radiogroup1;
	private TextView bgsizepercind;
	private SeekBar bgsizeperc;
	private TextView t30;
	private TextView bgstrszind;
	private SeekBar bgstrsz;
	private TextView t31;
	private TextView bgstrstind;
	private SeekBar bgstrst;
	private TextView t32;
	private HorizontalScrollView hscroll4;
	private TextView t33;
	private TextView bgsaind;
	private SeekBar bgsa;
	private TextView t34;
	private TextView bgbrind;
	private SeekBar bgbr;
	private TextView t35;
	private TextView bgcontrind;
	private SeekBar bgcontr;
	private TextView t36;
	private TextView bgsaturind;
	private SeekBar bgsatur;
	private TextView t37;
	private TextView bgsepind;
	private SeekBar bgsep;
	private TextView t38;
	private TextView bginverind;
	private SeekBar bginver;
	private TextView t39;
	private TextView bghueind;
	private SeekBar bghue;
	private TextView t40;
	private TextView bgblurind;
	private SeekBar bgblur;
	private TextView t41;
	private TextView bgalpind;
	private SeekBar bgalp;
	private TextView t42;
	private TextView bgblendind;
	private SeekBar bgblend;
	private EditText designname;
	private LinearLayout linear32;
	private Button pickphoto;
	private Button delphoto;
	private Button button1;
	private LinearLayout linear21;
	private AutoCompleteTextView bgcol;
	private Button bgc1;
	private Button bgc2;
	private Button bgc3;
	private Button bgc4;
	private Button bgc5;
	private Button bgc6;
	private Button bgc7;
	private Button bgc8;
	private RadioButton maintain;
	private RadioButton cover;
	private RadioButton bgsizecustom;
	private LinearLayout linear23;
	private AutoCompleteTextView bgstrcol;
	private Button bgsc1;
	private Button bgsc2;
	private Button bgsc3;
	private Button bgsc4;
	private Button bgsc5;
	private Button bgsc6;
	private Button bgsc7;
	private Button bgsc8;
	private Button importt;
	private Button export;
	
	private Intent intent = new Intent();
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private ObjectAnimator anim = new ObjectAnimator();
	private AlertDialog.Builder lowopacitywarning;
	private Intent des = new Intent(Intent.ACTION_GET_CONTENT);
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.bookmarks);
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
		        setContentView(R.layout.bookmarks);
		linear3 = findViewById(R.id.linear3);
		webview1 = findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		hideshow = findViewById(R.id.hideshow);
		linear1 = findViewById(R.id.linear1);
		hscroll2 = findViewById(R.id.hscroll2);
		linear6 = findViewById(R.id.linear6);
		deletee = findViewById(R.id.deletee);
		linear10 = findViewById(R.id.linear10);
		blink = findViewById(R.id.blink);
		bsearch = findViewById(R.id.bsearch);
		biframe = findViewById(R.id.biframe);
		bdesign = findViewById(R.id.bdesign);
		bhtml = findViewById(R.id.bhtml);
		lsearch = findViewById(R.id.lsearch);
		llink = findViewById(R.id.llink);
		liframe = findViewById(R.id.liframe);
		lhtml = findViewById(R.id.lhtml);
		design = findViewById(R.id.design);
		textview7 = findViewById(R.id.textview7);
		tahint = findViewById(R.id.tahint);
		textview8 = findViewById(R.id.textview8);
		tabef = findViewById(R.id.tabef);
		taafter = findViewById(R.id.taafter);
		pagesearch = findViewById(R.id.pagesearch);
		linear12 = findViewById(R.id.linear12);
		linear15 = findViewById(R.id.linear15);
		linear29 = findViewById(R.id.linear29);
		google = findViewById(R.id.google);
		bing = findViewById(R.id.bing);
		yahoo = findViewById(R.id.yahoo);
		duck = findViewById(R.id.duck);
		youtube = findViewById(R.id.youtube);
		gimages = findViewById(R.id.gimages);
		gvideo = findViewById(R.id.gvideo);
		gnews = findViewById(R.id.gnews);
		textview2 = findViewById(R.id.textview2);
		name = findViewById(R.id.name);
		textview3 = findViewById(R.id.textview3);
		link = findViewById(R.id.link);
		linear31 = findViewById(R.id.linear31);
		textview5 = findViewById(R.id.textview5);
		hscroll1 = findViewById(R.id.hscroll1);
		add = findViewById(R.id.add);
		inslink = findViewById(R.id.inslink);
		insmlink = findViewById(R.id.insmlink);
		linear2 = findViewById(R.id.linear2);
		color = findViewById(R.id.color);
		c1 = findViewById(R.id.c1);
		c2 = findViewById(R.id.c2);
		c3 = findViewById(R.id.c3);
		c4 = findViewById(R.id.c4);
		c5 = findViewById(R.id.c5);
		c6 = findViewById(R.id.c6);
		c7 = findViewById(R.id.c7);
		c8 = findViewById(R.id.c8);
		textview9 = findViewById(R.id.textview9);
		autocomplete4 = findViewById(R.id.autocomplete4);
		textview11 = findViewById(R.id.textview11);
		autocomplete5 = findViewById(R.id.autocomplete5);
		textview13 = findViewById(R.id.textview13);
		autocomplete6 = findViewById(R.id.autocomplete6);
		button4 = findViewById(R.id.button4);
		html = findViewById(R.id.html);
		refresh = findViewById(R.id.refresh);
		linear18 = findViewById(R.id.linear18);
		vscroll1 = findViewById(R.id.vscroll1);
		vscroll2 = findViewById(R.id.vscroll2);
		linear19 = findViewById(R.id.linear19);
		tobg = findViewById(R.id.tobg);
		t1 = findViewById(R.id.t1);
		txtszind = findViewById(R.id.txtszind);
		txtsz = findViewById(R.id.txtsz);
		t2 = findViewById(R.id.t2);
		txtboldind = findViewById(R.id.txtboldind);
		txtbold = findViewById(R.id.txtbold);
		italic = findViewById(R.id.italic);
		t3 = findViewById(R.id.t3);
		txtintind = findViewById(R.id.txtintind);
		txtint = findViewById(R.id.txtint);
		t4 = findViewById(R.id.t4);
		radiogroup2 = findViewById(R.id.radiogroup2);
		t5 = findViewById(R.id.t5);
		radiogroup3 = findViewById(R.id.radiogroup3);
		t6 = findViewById(R.id.t6);
		hscroll10 = findViewById(R.id.hscroll10);
		t7 = findViewById(R.id.t7);
		shadxind = findViewById(R.id.shadxind);
		shadx = findViewById(R.id.shadx);
		t8 = findViewById(R.id.t8);
		shadyind = findViewById(R.id.shadyind);
		shady = findViewById(R.id.shady);
		t9 = findViewById(R.id.t9);
		shadbind = findViewById(R.id.shadbind);
		shadb = findViewById(R.id.shadb);
		t10 = findViewById(R.id.t10);
		hscroll6 = findViewById(R.id.hscroll6);
		t11 = findViewById(R.id.t11);
		shadalpind = findViewById(R.id.shadalpind);
		shadalp = findViewById(R.id.shadalp);
		t12 = findViewById(R.id.t12);
		txtstrszind = findViewById(R.id.txtstrszind);
		txtstrsz = findViewById(R.id.txtstrsz);
		t13 = findViewById(R.id.t13);
		hscroll7 = findViewById(R.id.hscroll7);
		t14 = findViewById(R.id.t14);
		stralpind = findViewById(R.id.stralpind);
		stralp = findViewById(R.id.stralp);
		t15 = findViewById(R.id.t15);
		wrdstrszind = findViewById(R.id.wrdstrszind);
		wrdstr = findViewById(R.id.wrdstr);
		t16 = findViewById(R.id.t16);
		wstrstind = findViewById(R.id.wstrstind);
		wstrst = findViewById(R.id.wstrst);
		t17 = findViewById(R.id.t17);
		hscroll8 = findViewById(R.id.hscroll8);
		t18 = findViewById(R.id.t18);
		wstralpind = findViewById(R.id.wstralpind);
		wstralp = findViewById(R.id.wstralp);
		t19 = findViewById(R.id.t19);
		txtbrind = findViewById(R.id.txtbrind);
		txtbr = findViewById(R.id.txtbr);
		t20 = findViewById(R.id.t20);
		txtcontind = findViewById(R.id.txtcontind);
		txtcont = findViewById(R.id.txtcont);
		t21 = findViewById(R.id.t21);
		txtsaturind = findViewById(R.id.txtsaturind);
		txtsatur = findViewById(R.id.txtsatur);
		t22 = findViewById(R.id.t22);
		txtsepiaind = findViewById(R.id.txtsepiaind);
		txtsepia = findViewById(R.id.txtsepia);
		t23 = findViewById(R.id.t23);
		txtinvind = findViewById(R.id.txtinvind);
		txtinv = findViewById(R.id.txtinv);
		t24 = findViewById(R.id.t24);
		txthueind = findViewById(R.id.txthueind);
		txthue = findViewById(R.id.txthue);
		t25 = findViewById(R.id.t25);
		txtblurind = findViewById(R.id.txtblurind);
		txtblur = findViewById(R.id.txtblur);
		t26 = findViewById(R.id.t26);
		txtalpind = findViewById(R.id.txtalpind);
		txtalp = findViewById(R.id.txtalp);
		t27 = findViewById(R.id.t27);
		txtblendind = findViewById(R.id.txtblendind);
		txtblend = findViewById(R.id.txtblend);
		sans = findViewById(R.id.sans);
		serif = findViewById(R.id.serif);
		mono = findViewById(R.id.mono);
		courier = findViewById(R.id.courier);
		cursive = findViewById(R.id.cursive);
		std = findViewById(R.id.std);
		allbig = findViewById(R.id.allbig);
		allsmall = findViewById(R.id.allsmall);
		capit = findViewById(R.id.capit);
		radiogroup4 = findViewById(R.id.radiogroup4);
		left = findViewById(R.id.left);
		center = findViewById(R.id.center);
		right = findViewById(R.id.right);
		justify = findViewById(R.id.justify);
		linear24 = findViewById(R.id.linear24);
		shadc = findViewById(R.id.shadc);
		sc1 = findViewById(R.id.sc1);
		sc2 = findViewById(R.id.sc2);
		sc3 = findViewById(R.id.sc3);
		sc4 = findViewById(R.id.sc4);
		sc5 = findViewById(R.id.sc5);
		sc6 = findViewById(R.id.sc6);
		sc7 = findViewById(R.id.sc7);
		sc8 = findViewById(R.id.sc8);
		linear25 = findViewById(R.id.linear25);
		strcol = findViewById(R.id.strcol);
		wsc1 = findViewById(R.id.wsc1);
		wsc2 = findViewById(R.id.wsc2);
		wsc3 = findViewById(R.id.wsc3);
		wsc4 = findViewById(R.id.wsc4);
		wsc5 = findViewById(R.id.wsc5);
		wsc6 = findViewById(R.id.wsc6);
		wsc7 = findViewById(R.id.wsc7);
		wsc8 = findViewById(R.id.wsc8);
		linear26 = findViewById(R.id.linear26);
		wstrcol = findViewById(R.id.wstrcol);
		wstc1 = findViewById(R.id.wstc1);
		wstc2 = findViewById(R.id.wstc2);
		wstc3 = findViewById(R.id.wstc3);
		wstc4 = findViewById(R.id.wstc4);
		wstc5 = findViewById(R.id.wstc5);
		wstc6 = findViewById(R.id.wstc6);
		wstc7 = findViewById(R.id.wstc7);
		wstc8 = findViewById(R.id.wstc8);
		linear20 = findViewById(R.id.linear20);
		totxt = findViewById(R.id.totxt);
		linear17 = findViewById(R.id.linear17);
		t28 = findViewById(R.id.t28);
		hscroll3 = findViewById(R.id.hscroll3);
		t29 = findViewById(R.id.t29);
		radiogroup1 = findViewById(R.id.radiogroup1);
		bgsizepercind = findViewById(R.id.bgsizepercind);
		bgsizeperc = findViewById(R.id.bgsizeperc);
		t30 = findViewById(R.id.t30);
		bgstrszind = findViewById(R.id.bgstrszind);
		bgstrsz = findViewById(R.id.bgstrsz);
		t31 = findViewById(R.id.t31);
		bgstrstind = findViewById(R.id.bgstrstind);
		bgstrst = findViewById(R.id.bgstrst);
		t32 = findViewById(R.id.t32);
		hscroll4 = findViewById(R.id.hscroll4);
		t33 = findViewById(R.id.t33);
		bgsaind = findViewById(R.id.bgsaind);
		bgsa = findViewById(R.id.bgsa);
		t34 = findViewById(R.id.t34);
		bgbrind = findViewById(R.id.bgbrind);
		bgbr = findViewById(R.id.bgbr);
		t35 = findViewById(R.id.t35);
		bgcontrind = findViewById(R.id.bgcontrind);
		bgcontr = findViewById(R.id.bgcontr);
		t36 = findViewById(R.id.t36);
		bgsaturind = findViewById(R.id.bgsaturind);
		bgsatur = findViewById(R.id.bgsatur);
		t37 = findViewById(R.id.t37);
		bgsepind = findViewById(R.id.bgsepind);
		bgsep = findViewById(R.id.bgsep);
		t38 = findViewById(R.id.t38);
		bginverind = findViewById(R.id.bginverind);
		bginver = findViewById(R.id.bginver);
		t39 = findViewById(R.id.t39);
		bghueind = findViewById(R.id.bghueind);
		bghue = findViewById(R.id.bghue);
		t40 = findViewById(R.id.t40);
		bgblurind = findViewById(R.id.bgblurind);
		bgblur = findViewById(R.id.bgblur);
		t41 = findViewById(R.id.t41);
		bgalpind = findViewById(R.id.bgalpind);
		bgalp = findViewById(R.id.bgalp);
		t42 = findViewById(R.id.t42);
		bgblendind = findViewById(R.id.bgblendind);
		bgblend = findViewById(R.id.bgblend);
		designname = findViewById(R.id.designname);
		linear32 = findViewById(R.id.linear32);
		pickphoto = findViewById(R.id.pickphoto);
		delphoto = findViewById(R.id.delphoto);
		button1 = findViewById(R.id.button1);
		linear21 = findViewById(R.id.linear21);
		bgcol = findViewById(R.id.bgcol);
		bgc1 = findViewById(R.id.bgc1);
		bgc2 = findViewById(R.id.bgc2);
		bgc3 = findViewById(R.id.bgc3);
		bgc4 = findViewById(R.id.bgc4);
		bgc5 = findViewById(R.id.bgc5);
		bgc6 = findViewById(R.id.bgc6);
		bgc7 = findViewById(R.id.bgc7);
		bgc8 = findViewById(R.id.bgc8);
		maintain = findViewById(R.id.maintain);
		cover = findViewById(R.id.cover);
		bgsizecustom = findViewById(R.id.bgsizecustom);
		linear23 = findViewById(R.id.linear23);
		bgstrcol = findViewById(R.id.bgstrcol);
		bgsc1 = findViewById(R.id.bgsc1);
		bgsc2 = findViewById(R.id.bgsc2);
		bgsc3 = findViewById(R.id.bgsc3);
		bgsc4 = findViewById(R.id.bgsc4);
		bgsc5 = findViewById(R.id.bgsc5);
		bgsc6 = findViewById(R.id.bgsc6);
		bgsc7 = findViewById(R.id.bgsc7);
		bgsc8 = findViewById(R.id.bgsc8);
		importt = findViewById(R.id.importt);
		export = findViewById(R.id.export);
		fp.setType("image/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		lowopacitywarning = new AlertDialog.Builder(this);
		des.setType("*/*");
		des.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
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
		
		hideshow.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (linear6.getVisibility() == View.VISIBLE) {
					linear6.setVisibility(View.GONE);
					hscroll2.setVisibility(View.GONE);
					deletee.setVisibility(View.GONE);
					hideshow.setText("△▲▲▲▲▲△");
				}
				else {
					linear6.setVisibility(View.VISIBLE);
					hscroll2.setVisibility(View.VISIBLE);
					deletee.setVisibility(View.VISIBLE);
					hideshow.setText("▽▼▼▼▼▼▽");
					anim.setTarget(linear6);
					anim.setPropertyName("scaleY");
					anim.setFloatValues((float)(0), (float)(1));
					anim.setDuration((int)(500));
					anim.start();
				}
			}
		});
		
		deletee.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (delete) {
					try{
						deletee.setText(languag.get((int)(17)));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							deletee.setText("DELETE");
						}
						else {
							deletee.setText("ВИДАЛИТИ");
						}
					}
					delete = false;
				}
				else {
					try{
						deletee.setText(languag.get((int)(151)));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							deletee.setText("PICK AN ELEMENTS FOR DELETE");
						}
						else {
							deletee.setText("ВИБЕРІТЬ ЕЛЕМЕНТИ ДЛЯ ВИДАЛЕННЯ");
						}
					}
					delete = true;
				}
			}
		});
		
		blink.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				llink.setVisibility(View.VISIBLE);
				lsearch.setVisibility(View.GONE);
				liframe.setVisibility(View.GONE);
				lhtml.setVisibility(View.GONE);
				design.setVisibility(View.GONE);
			}
		});
		
		bsearch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				llink.setVisibility(View.GONE);
				lsearch.setVisibility(View.VISIBLE);
				liframe.setVisibility(View.GONE);
				lhtml.setVisibility(View.GONE);
				design.setVisibility(View.GONE);
			}
		});
		
		biframe.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				llink.setVisibility(View.GONE);
				lsearch.setVisibility(View.GONE);
				liframe.setVisibility(View.VISIBLE);
				lhtml.setVisibility(View.GONE);
				design.setVisibility(View.GONE);
			}
		});
		
		bdesign.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				llink.setVisibility(View.GONE);
				lsearch.setVisibility(View.GONE);
				liframe.setVisibility(View.GONE);
				lhtml.setVisibility(View.GONE);
				design.setVisibility(View.VISIBLE);
			}
		});
		
		bhtml.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				llink.setVisibility(View.GONE);
				lsearch.setVisibility(View.GONE);
				liframe.setVisibility(View.GONE);
				lhtml.setVisibility(View.VISIBLE);
				design.setVisibility(View.GONE);
			}
		});
		
		google.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tabef.setText("https://www.google.com/search?q=");
				taafter.setText("");
			}
		});
		
		bing.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tabef.setText("https://www.bing.com/search?q=");
				taafter.setText("");
			}
		});
		
		yahoo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tabef.setText("https://www.yahoo.com/search?q=");
				taafter.setText("");
			}
		});
		
		duck.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tabef.setText("https://www.duckduckgo.com/search?q=");
				taafter.setText("");
			}
		});
		
		youtube.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tabef.setText("https://www.youtube.com/search?q=");
				taafter.setText("");
			}
		});
		
		gimages.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tabef.setText("https://www.google.com/search?sca_esv=99636c5107a06ae2&q=");
				taafter.setText("&uds=AMwkrPuAtCsJx0yzkuE0014ksXt9UJoHu3DMczwo_HsBKWFeY85C4qTrzQUb61phTZjohbN8SjYe_a3xHALisl_CSZnN66nOANsLk0s-AkXzEgHeOJnAWHKMOwSV8bycYbBADhoL-z2nuhwTSR0zr91iQ5hdQQev-2oLtGabTHICA1uND5eakZixmLj-V0X2Q02-SpJs31QeoE3HvaANjDCZTijMsorKErPUmGJmnRbyZA7CIQ4fB2e5rJ9r-w6sEjvHnnFYSpx3T5mwelcO6wmbhMbYoWXn9_0oNcOFl7YODSyPoUcxup5FUb7aoMKlFxe4TcdRvajy7yU_9l08CBiKjLH835Zr4g&udm=2&prmd=visnmbtz&sa=X&ved=2ahUKEwjdnZ-lvcaFAxWlFxAIHV9EAlUQtKgLegQIDRAB&biw=480&bih=739&dpr=3");
			}
		});
		
		gvideo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tabef.setText("https://www.google.com/search?sca_esv=99636c5107a06ae2&q=");
				taafter.setText("&tbm=vid&source=lnms&prmd=visnmbtz&sa=X&ved=2ahUKEwjw_aW1vcaFAxXUGBAIHW4aCLQQ0pQJegQIExAB&biw=480&bih=760&dpr=3");
			}
		});
		
		gnews.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tabef.setText("https://www.google.com/search?sca_esv=99636c5107a06ae2&q=");
				taafter.setText("&tbm=nws&source=lnms&prmd=ivsnmbtz&sa=X&ved=2ahUKEwj1wd2xvsaFAxXDPxAIHXtEDs0Q0pQJegQIBxAB&biw=480&bih=739&dpr=3");
			}
		});
		
		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!link.getText().toString().equals("file:///storage/emulated/0/WeekBrowser/bookmark.html") && (!name.getText().toString().equals("") && (link.getText().toString().matches("https://.*") || (link.getText().toString().matches("http://.*") || link.getText().toString().matches("file://.*"))))) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/bookmark.html", FileUtil.readFile("/storage/emulated/0/WeekBrowser/bookmark.html").concat("<a href=\"".concat(link.getText().toString()).concat("\"><font color=\"#".concat(color.getText().toString().concat("\">".concat(name.getText().toString().concat("</font></a>").concat("<font color=\"#ff0000\"> ❖ </font>\n")))))));
					webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "ПОМИЛКА! БУДЬТЕ УВАЖНІШІ, НЕМАЄ НАЗВИ АБО НЕДІЙСНЕ ПОСИЛАННЯ");
				}
			}
		});
		
		inslink.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent intent = getIntent();
				        Uri data = intent.getData();
				
				        if (data != null) {
					            // Завантажуємо URL в WebView
					       URL=data.toString();     link.setText(data.toString());
					        }
			}
		});
		
		insmlink.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				link.setText(dataHolder.getData("ml"));
			}
		});
		
		c1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				color.setText("FF0000");
			}
		});
		
		c2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				color.setText("FFFF00");
			}
		});
		
		c3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				color.setText("00FF00");
			}
		});
		
		c4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				color.setText("00FFFF");
			}
		});
		
		c5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				color.setText("FF00FF");
			}
		});
		
		c6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				color.setText("FFFFFF");
			}
		});
		
		c7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				color.setText("000000");
			}
		});
		
		c8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				color.setText("0000FF");
			}
		});
		
		//OnTouch
		refresh.setOnTouchListener(new View.OnTouchListener(){
				@Override
				public boolean onTouch(View v, MotionEvent event){
						int ev = event.getAction();
						switch (ev) {
								case MotionEvent.ACTION_DOWN:
								
								 FileUtil.writeFile("/storage/emulated/0/WeekBrowser/bookmark.html", html.getText().toString());
					webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
								
								break;
								case MotionEvent.ACTION_UP:
								
								 
								
								break;
						} return true;
				}
		});
		
		tobg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.VISIBLE);
			}
		});
		
		txtsz.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textsize.txt", String.valueOf((long)(_progressValue)));
					_designing();
				}
				txtszind.setText(String.valueOf((long)(_progressValue)));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		txtbold.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textweight.txt", String.valueOf((long)(_progressValue * 100)));
					_designing();
				}
				txtboldind.setText(String.valueOf((long)(_progressValue * 100)));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		italic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (youmaychangesettings) {
					if (italic.isChecked()) {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textstyle.txt", "italic");
					}
					else {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textstyle.txt", "initial");
					}
					_designing();
				}
			}
		});
		
		txtint.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textline.txt", String.valueOf(_progressValue / 10.d));
					_designing();
				}
				txtintind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		shadx.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowx.txt", String.valueOf((_progressValue - 50) / 20.d));
					_designing();
				}
				shadxind.setText(String.valueOf((_progressValue - 50) / 20.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		shady.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowy.txt", String.valueOf((_progressValue - 50) / 20.d));
					_designing();
				}
				shadyind.setText(String.valueOf((_progressValue - 50) / 20.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		shadb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowb.txt", String.valueOf(_progressValue / 10.d));
					_designing();
				}
				shadbind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		shadalp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowc.txt", shadc.getText().toString().concat(_toHexStr(_progressValue)));
					_designing();
				}
				shadalpind.setText(String.valueOf((long)(_progressValue)));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		txtstrsz.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					txtstrszind.setText(String.valueOf(_progressValue / 10.d));
					_designing();
				}
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textstrokesize.txt", String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		stralp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textstrokecolor.txt", strcol.getText().toString().concat(_toHexStr(_progressValue)));
					_designing();
				}
				stralpind.setText(String.valueOf((long)(_progressValue)));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		wrdstr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textbordersize.txt", String.valueOf(_progressValue / 10.d));
					_designing();
				}
				wrdstrszind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		wstrst.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					switch((int)_progressValue) {
						case ((int)0): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textborderstyle.txt", "solid");
							break;
						}
						case ((int)1): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textborderstyle.txt", "dashed");
							break;
						}
						case ((int)2): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textborderstyle.txt", "dotted");
							break;
						}
						case ((int)3): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textborderstyle.txt", "double");
							break;
						}
						case ((int)4): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textborderstyle.txt", "groove");
							break;
						}
						case ((int)5): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textborderstyle.txt", "ridge");
							break;
						}
						case ((int)6): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textborderstyle.txt", "inset");
							break;
						}
						case ((int)7): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textborderstyle.txt", "outset");
							break;
						}
					}
					_designing();
				}
				wstrstind.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textborderstyle.txt"));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		wstralp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textbordercolor.txt", wstrcol.getText().toString().concat(_toHexStr(_progressValue)));
					_designing();
				}
				wstralpind.setText(String.valueOf((long)(_progressValue)));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		txtbr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textbright.txt", String.valueOf(_progressValue / 10.d));
					_designing();
				}
				txtbrind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		txtcont.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textcontr.txt", String.valueOf(_progressValue / 10.d));
					_designing();
				}
				txtcontind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		txtsatur.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textsatur.txt", String.valueOf(_progressValue / 10.d));
					_designing();
				}
				txtsaturind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		txtsepia.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textsepia.txt", String.valueOf(_progressValue / 100.d));
					_designing();
				}
				txtsepiaind.setText(String.valueOf(_progressValue / 100.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		txtinv.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textinvert.txt", String.valueOf(_progressValue / 100.d));
					_designing();
				}
				txtinvind.setText(String.valueOf(_progressValue / 100.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		txthue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/texthue.txt", String.valueOf((long)(_progressValue)));
					_designing();
				}
				txthueind.setText(String.valueOf((long)(_progressValue)).concat("°"));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		txtblur.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textblur.txt", String.valueOf(_progressValue / 10.d));
					_designing();
				}
				txtblurind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		txtalp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textopacity.txt", String.valueOf(_progressValue / 100.d));
					_designing();
				}
				txtalpind.setText(String.valueOf(_progressValue / 100.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		txtblend.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					switch((int)_progressValue) {
						case ((int)0): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt", "normal");
							break;
						}
						case ((int)1): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt", "multiply");
							break;
						}
						case ((int)2): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt", "screen");
							break;
						}
						case ((int)3): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt", "overlay");
							break;
						}
						case ((int)4): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt", "darken");
							break;
						}
						case ((int)5): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt", "lighten");
							break;
						}
						case ((int)6): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt", "color-dodge");
							break;
						}
						case ((int)7): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt", "color-burn");
							break;
						}
						case ((int)8): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt", "hard-light");
							break;
						}
						case ((int)9): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt", "soft-light");
							break;
						}
						case ((int)10): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt", "difference");
							break;
						}
						case ((int)11): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt", "exclusion");
							break;
						}
						case ((int)12): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt", "hue");
							break;
						}
						case ((int)13): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt", "saturation");
							break;
						}
						case ((int)14): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt", "color");
							break;
						}
						case ((int)15): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt", "luminosity");
							break;
						}
					}
					_designing();
				}
				txtblendind.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt"));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		sans.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textfont.txt", "sans");
					_designing();
				}
			}
		});
		
		serif.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textfont.txt", "serif");
					_designing();
				}
			}
		});
		
		mono.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textfont.txt", "monospace");
					_designing();
				}
			}
		});
		
		courier.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textfont.txt", "courier new");
					_designing();
				}
			}
		});
		
		cursive.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textfont.txt", "cursive");
					_designing();
				}
			}
		});
		
		std.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/texttrans.txt", "initial");
					_designing();
				}
			}
		});
		
		allbig.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/texttrans.txt", "uppercase");
					_designing();
				}
			}
		});
		
		allsmall.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/texttrans.txt", "lowercase");
					_designing();
				}
			}
		});
		
		capit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/texttrans.txt", "capitalize");
					_designing();
				}
			}
		});
		
		left.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textalign.txt", "left");
					_designing();
				}
			}
		});
		
		center.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textalign.txt", "center");
					_designing();
				}
			}
		});
		
		right.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textalign.txt", "right");
					_designing();
				}
			}
		});
		
		justify.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textalign.txt", "justify");
					_designing();
				}
			}
		});
		
		shadc.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textshadowc.txt", _charSeq.concat(_toHexStr(shadalp.getProgress())));
					_designing();
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		sc1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shadc.setText("FF0000");
			}
		});
		
		sc2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shadc.setText("FFFF00");
			}
		});
		
		sc3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shadc.setText("00FF00");
			}
		});
		
		sc4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shadc.setText("00FFFF");
			}
		});
		
		sc5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shadc.setText("FF00FF");
			}
		});
		
		sc6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shadc.setText("FFFFFF");
			}
		});
		
		sc7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shadc.setText("000000");
			}
		});
		
		sc8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shadc.setText("0000FF");
			}
		});
		
		strcol.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textstrokecolor.txt", _charSeq.concat(_toHexStr(stralp.getProgress())));
					_designing();
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		wsc1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				strcol.setText("FF0000");
			}
		});
		
		wsc2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				strcol.setText("FFFF00");
			}
		});
		
		wsc3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				strcol.setText("00FF00");
			}
		});
		
		wsc4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				strcol.setText("00FFFF");
			}
		});
		
		wsc5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				strcol.setText("FF00FF");
			}
		});
		
		wsc6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				strcol.setText("FFFFFF");
			}
		});
		
		wsc7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				strcol.setText("000000");
			}
		});
		
		wsc8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				strcol.setText("0000FF");
			}
		});
		
		wstrcol.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/textbordercolor.txt", _charSeq.concat(_toHexStr(wstralp.getProgress())));
					_designing();
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		wstc1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				wstrcol.setText("FF0000");
			}
		});
		
		wstc2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				wstrcol.setText("FFFF00");
			}
		});
		
		wstc3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				wstrcol.setText("00FF00");
			}
		});
		
		wstc4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				wstrcol.setText("00FFFF");
			}
		});
		
		wstc5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				wstrcol.setText("FF00FF");
			}
		});
		
		wstc6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				wstrcol.setText("FFFFFF");
			}
		});
		
		wstc7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				wstrcol.setText("000000");
			}
		});
		
		wstc8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				wstrcol.setText("0000FF");
			}
		});
		
		totxt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.VISIBLE);
				vscroll2.setVisibility(View.GONE);
			}
		});
		
		bgsizeperc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgsize.txt", String.valueOf((long)(bgsizeperc.getProgress())).concat("%"));
					_designing();
				}
				bgsizepercind.setText(String.valueOf((long)(bgsizeperc.getProgress())).concat("%"));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		bgstrsz.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgstrokesize.txt", String.valueOf(_progressValue / 10.d));
					_designing();
				}
				bgstrszind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		bgstrst.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					switch((int)_progressValue) {
						case ((int)0): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgstrokestyle.txt", "solid");
							break;
						}
						case ((int)1): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgstrokestyle.txt", "dashed");
							break;
						}
						case ((int)2): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgstrokestyle.txt", "dotted");
							break;
						}
						case ((int)3): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgstrokestyle.txt", "double");
							break;
						}
						case ((int)4): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgstrokestyle.txt", "groove");
							break;
						}
						case ((int)5): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgstrokestyle.txt", "ridge");
							break;
						}
						case ((int)6): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgstrokestyle.txt", "inset");
							break;
						}
						case ((int)7): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgstrokestyle.txt", "outset");
							break;
						}
					}
					_designing();
				}
				bgstrstind.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokestyle.txt"));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		bgsa.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgstrokecolor.txt", bgstrcol.getText().toString().concat(_toHexStr(_progressValue)));
					_designing();
				}
				bgsaind.setText(String.valueOf((long)(_progressValue)));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		bgbr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgbright.txt", String.valueOf(_progressValue / 10.d));
					_designing();
				}
				bgbrind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		bgcontr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgcontr.txt", String.valueOf(_progressValue / 10.d));
					_designing();
				}
				bgcontrind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		bgsatur.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgsatur.txt", String.valueOf(_progressValue / 10.d));
					_designing();
				}
				bgsaturind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		bgsep.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgsepia.txt", String.valueOf(_progressValue / 100.d));
					_designing();
				}
				bgsepind.setText(String.valueOf(_progressValue / 100.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		bginver.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bginvert.txt", String.valueOf(_progressValue / 100.d));
					_designing();
				}
				bginverind.setText(String.valueOf(_progressValue / 100.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		bghue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bghue.txt", String.valueOf((long)(_progressValue)));
					_designing();
				}
				bghueind.setText(String.valueOf((long)(_progressValue)).concat("°"));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		bgblur.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblur.txt", String.valueOf(_progressValue / 10.d));
					_designing();
				}
				bgblurind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		bgalp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgopacity.txt", String.valueOf(_progressValue / 100.d));
					_designing();
				}
				bgalpind.setText(String.valueOf(_progressValue / 100.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		bgblend.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (youmaychangesettings) {
					switch((int)_progressValue) {
						case ((int)0): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt", "normal");
							break;
						}
						case ((int)1): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt", "multiply");
							break;
						}
						case ((int)2): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt", "screen");
							break;
						}
						case ((int)3): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt", "overlay");
							break;
						}
						case ((int)4): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt", "darken");
							break;
						}
						case ((int)5): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt", "lighten");
							break;
						}
						case ((int)6): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt", "color-dodge");
							break;
						}
						case ((int)7): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt", "color-burn");
							break;
						}
						case ((int)8): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt", "hard-light");
							break;
						}
						case ((int)9): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt", "soft-light");
							break;
						}
						case ((int)10): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt", "difference");
							break;
						}
						case ((int)11): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt", "exclusion");
							break;
						}
						case ((int)12): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt", "hue");
							break;
						}
						case ((int)13): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt", "saturation");
							break;
						}
						case ((int)14): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt", "color");
							break;
						}
						case ((int)15): {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt", "luminosity");
							break;
						}
					}
					_designing();
				}
				bgblendind.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt"));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
				iterations = 0;
			}
		});
		
		pickphoto.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(fp, REQ_CD_FP);
			}
		});
		
		delphoto.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgimage.txt", "initial");
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgopacity.txt", "0.0");
				FileUtil.deleteFile("/storage/emulated/0/WeekBrowser/css/BACKGROUND.png");
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgcol.txt", "ffffff");
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bg.txt", "ffffff");
				}
				else {
					if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 1) {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgcol.txt", "111111");
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bg.txt", "111111");
					}
					else {
						if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 2) {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgcol.txt", "000000");
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bg.txt", "000000");
						}
						else {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgcol.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt").substring((int)(2), (int)(8)));
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bg.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt").substring((int)(2), (int)(8)));
						}
					}
				}
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgopacity.txt", "0.0");
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
			}
		});
		
		bgcol.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgcol.txt", _charSeq);
					_designing();
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		bgc1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bgcol.setText("FF0000");
			}
		});
		
		bgc2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bgcol.setText("FFFF00");
			}
		});
		
		bgc3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bgcol.setText("00FF00");
			}
		});
		
		bgc4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bgcol.setText("00FFFF");
			}
		});
		
		bgc5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bgcol.setText("FF00FF");
			}
		});
		
		bgc6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bgcol.setText("FFFFFF");
			}
		});
		
		bgc7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bgcol.setText("000000");
			}
		});
		
		bgc8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bgcol.setText("0000FF");
			}
		});
		
		maintain.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgsize.txt", "maintain");
					bgsizepercind.setVisibility(View.GONE);
					bgsizeperc.setVisibility(View.GONE);
					_designing();
				}
			}
		});
		
		cover.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgsize.txt", "cover");
					bgsizepercind.setVisibility(View.GONE);
					bgsizeperc.setVisibility(View.GONE);
					_designing();
				}
			}
		});
		
		bgsizecustom.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgsize.txt", String.valueOf((long)(bgsizeperc.getProgress())).concat("%"));
					bgsizepercind.setVisibility(View.VISIBLE);
					bgsizeperc.setVisibility(View.VISIBLE);
					_designing();
				}
			}
		});
		
		bgstrcol.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (youmaychangesettings) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgstrokecolor.txt", _charSeq.concat(_toHexStr(bgsa.getProgress())));
					_designing();
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		bgsc1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bgstrcol.setText("FF0000");
			}
		});
		
		bgsc2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bgstrcol.setText("FFFF00");
			}
		});
		
		bgsc3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bgstrcol.setText("00FF00");
			}
		});
		
		bgsc4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bgstrcol.setText("00FFFF");
			}
		});
		
		bgsc5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bgstrcol.setText("FF00FF");
			}
		});
		
		bgsc6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bgstrcol.setText("FFFFFF");
			}
		});
		
		bgsc7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bgstrcol.setText("000000");
			}
		});
		
		bgsc8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bgstrcol.setText("0000FF");
			}
		});
		
		importt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(des, REQ_CD_DES);
			}
		});
		
		export.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (designname.getText().toString().isEmpty()) {
					SketchwareUtil.showMessage(getApplicationContext(), "БУДЬТЕ УВАЖНІШІ! Немає назви скіна");
				}
				else {
					if (!FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/CUSTOMDESIGNLIBRARY")) {
						FileUtil.makeDir("/storage/emulated/0/WeekBrowser/CUSTOMDESIGNLIBRARY");
					}
					try {
						Zip.zipFolder("/storage/emulated/0/WeekBrowser/css","/storage/emulated/0/WeekBrowser/CUSTOMDESIGNLIBRARY/" + designname.getText().toString().concat(".wedes"));
					} catch(Exception e) {}
					SketchwareUtil.showMessage(getApplicationContext(), "Збережено!");
				}
			}
		});
	}
	
	private void initializeLogic() {
		new kostyli().execute("");
		webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
		final Activity activity = BookmarksActivity.this;
		applyColorsToViews(findViewById(android.R.id.content));
		Intent intent = getIntent();
		        Uri data = intent.getData();
		
		        if (data != null) {
			            // Завантажуємо URL в WebView
			       URL=data.toString();     link.setText(data.toString());
			        }
		webview1.setLayerType(View.LAYER_TYPE_HARDWARE, null);
		
		    webview1.getSettings().setAllowFileAccess(true);
		    webview1.getSettings().setAllowContentAccess(true);
		webview1.getSettings().setAllowFileAccessFromFileURLs(true);
		webview1.getSettings().setAllowUniversalAccessFromFileURLs(true);
		webview1.setWebViewClient(new WebViewClient() {
			    @Override
			    public void onPageStarted(WebView view, String url, Bitmap favicon) {
				        super.onPageStarted(view, url, favicon);
				_onpagestart(url);
				    }
			
			    @Override
			    public void onPageFinished(WebView view, String url) {
				        super.onPageFinished(view, url);
				_onpagefinish(url);
				    }
			
			    @Override
			    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
				        super.onReceivedError(view, request, error);
				        if (request.isForMainFrame()) {
					_onpagefail();}
				    }
		});
		
		name.setText(getIntent().getStringExtra("n"));
		link.setLines(4);
		webview1.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY);
		
		llink.setVisibility(View.VISIBLE);
		lsearch.setVisibility(View.GONE);
		liframe.setVisibility(View.GONE);
		design.setVisibility(View.GONE);
		lhtml.setVisibility(View.GONE);
		linear6.setVisibility(View.GONE);
		hscroll2.setVisibility(View.GONE);
		deletee.setVisibility(View.GONE);
		vscroll2.setVisibility(View.GONE);
		html.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/bookmark.html"));
		try{
			shadc.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowc.txt").substring((int)(0), (int)(6)));
			strcol.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textstrokecolor.txt").substring((int)(0), (int)(6)));
			wstrcol.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbordercolor.txt").substring((int)(0), (int)(6)));
			bgstrcol.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokecolor.txt").substring((int)(0), (int)(6)));
			italic.setChecked(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textstyle.txt").equals("italic"));
			txtsz.setProgress((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsize.txt")));
			txtbold.setProgress((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textweight.txt")) / 100);
			txtint.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textline.txt")) * 10) / 1);
			shadx.setProgress((int)((Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowx.txt")) * 20) + 50) / 1);
			shady.setProgress((int)((Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowy.txt")) * 20) + 50) / 1);
			shadb.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowb.txt")) * 10) / 1);
			shadalp.setProgress((int)_fromHex(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowc.txt").substring((int)(6), (int)(8))));
			stralp.setProgress((int)_fromHex(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textstrokecolor.txt").substring((int)(6), (int)(8))));
			wstralp.setProgress((int)_fromHex(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbordercolor.txt").substring((int)(6), (int)(8))));
			bgsa.setProgress((int)_fromHex(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokecolor.txt").substring((int)(6), (int)(8))));
			bgcol.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgcol.txt"));
			bgstrsz.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokesize.txt")) * 10.d) / 1);
			wrdstr.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbordersize.txt")) * 10.d) / 1);
			txtbr.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbright.txt")) * 10.d) / 1);
			txtcont.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textcontr.txt")) * 10.d) / 1);
			txtsatur.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsatur.txt")) * 10.d) / 1);
			txtsepia.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsepia.txt")) * 100.d) / 1);
			txtinv.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textinvert.txt")) * 100.d) / 1);
			txthue.setProgress((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/texthue.txt")));
			txtblur.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textblur.txt")) * 10.d) / 1);
			txtalp.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textopacity.txt")) * 100.d) / 1);
			bgbr.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgbright.txt")) * 10.d) / 1);
			bgcontr.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgcontr.txt")) * 10.d) / 1);
			bgsatur.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsatur.txt")) * 10.d) / 1);
			bgsep.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsepia.txt")) * 100.d) / 1);
			bginver.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bginvert.txt")) * 100.d) / 1);
			bghue.setProgress((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bghue.txt")));
			bgblur.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgblur.txt")) * 10.d) / 1);
			bgalp.setProgress((int)(Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgopacity.txt")) * 100.d) / 1);
			sans.setChecked("sans".equals(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textfont.txt")));
			serif.setChecked("serif".equals(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textfont.txt")));
			mono.setChecked("monospace".equals(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textfont.txt")));
			courier.setChecked("courier new".equals(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textfont.txt")));
			cursive.setChecked("cursive".equals(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textfont.txt")));
			std.setChecked("initial".equals(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/texttrans.txt")));
			allbig.setChecked("uppercase".equals(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/texttrans.txt")));
			allsmall.setChecked("lowercase".equals(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/texttrans.txt")));
			capit.setChecked("capitalize".equals(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/texttrans.txt")));
			left.setChecked("left".equals(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textalign.txt")));
			center.setChecked("center".equals(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textalign.txt")));
			right.setChecked("right".equals(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textalign.txt")));
			justify.setChecked("justify".equals(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textalign.txt")));
			if ("maintain".equals(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsize.txt"))) {
				maintain.setChecked(true);
				bgsizepercind.setVisibility(View.GONE);
				bgsizeperc.setVisibility(View.GONE);
			}
			else {
				if ("cover".equals(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsize.txt"))) {
					cover.setChecked(true);
					bgsizepercind.setVisibility(View.GONE);
					bgsizeperc.setVisibility(View.GONE);
				}
				else {
					bgsizecustom.setChecked(true);
					bgsizepercind.setVisibility(View.VISIBLE);
					bgsizeperc.setVisibility(View.VISIBLE);
					bgsizeperc.setProgress((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsize.txt").replace("%", "")));
				}
			}
			wstrstind.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textborderstyle.txt"));
			switch(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textborderstyle.txt")) {
				case "solid": {
					wstrst.setProgress((int)0);
					break;
				}
				case "dashed": {
					wstrst.setProgress((int)1);
					break;
				}
				case "dotted": {
					wstrst.setProgress((int)2);
					break;
				}
				case "double": {
					wstrst.setProgress((int)3);
					break;
				}
				case "groove": {
					wstrst.setProgress((int)4);
					break;
				}
				case "ridge": {
					wstrst.setProgress((int)5);
					break;
				}
				case "inset": {
					wstrst.setProgress((int)6);
					break;
				}
				case "outset": {
					wstrst.setProgress((int)7);
					break;
				}
			}
			bgstrstind.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokestyle.txt"));
			switch(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokestyle.txt")) {
				case "solid": {
					bgstrst.setProgress((int)0);
					break;
				}
				case "dashed": {
					bgstrst.setProgress((int)1);
					break;
				}
				case "dotted": {
					bgstrst.setProgress((int)2);
					break;
				}
				case "double": {
					bgstrst.setProgress((int)3);
					break;
				}
				case "groove": {
					bgstrst.setProgress((int)4);
					break;
				}
				case "ridge": {
					bgstrst.setProgress((int)5);
					break;
				}
				case "inset": {
					bgstrst.setProgress((int)6);
					break;
				}
				case "outset": {
					bgstrst.setProgress((int)7);
					break;
				}
			}
			bgblendind.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt"));
			switch(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt")) {
				case "normal": {
					bgblend.setProgress((int)0);
					break;
				}
				case "multiply": {
					bgblend.setProgress((int)1);
					break;
				}
				case "screen": {
					bgblend.setProgress((int)2);
					break;
				}
				case "overlay": {
					bgblend.setProgress((int)3);
					break;
				}
				case "darken": {
					bgblend.setProgress((int)4);
					break;
				}
				case "lighten": {
					bgblend.setProgress((int)5);
					break;
				}
				case "color-dodge": {
					bgblend.setProgress((int)6);
					break;
				}
				case "color-burn": {
					bgblend.setProgress((int)7);
					break;
				}
				case "hard-light": {
					bgblend.setProgress((int)8);
					break;
				}
				case "soft-light": {
					bgblend.setProgress((int)9);
					break;
				}
				case "difference": {
					bgblend.setProgress((int)10);
					break;
				}
				case "exclusion": {
					bgblend.setProgress((int)11);
					break;
				}
				case "hue": {
					bgblend.setProgress((int)12);
					break;
				}
				case "saturation": {
					bgblend.setProgress((int)13);
					break;
				}
				case "color": {
					bgblend.setProgress((int)14);
					break;
				}
				case "luminosity": {
					bgblend.setProgress((int)15);
					break;
				}
			}
			txtblendind.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt"));
			switch(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt")) {
				case "normal": {
					txtblend.setProgress((int)0);
					break;
				}
				case "multiply": {
					txtblend.setProgress((int)1);
					break;
				}
				case "screen": {
					txtblend.setProgress((int)2);
					break;
				}
				case "overlay": {
					txtblend.setProgress((int)3);
					break;
				}
				case "darken": {
					txtblend.setProgress((int)4);
					break;
				}
				case "lighten": {
					txtblend.setProgress((int)5);
					break;
				}
				case "color-dodge": {
					txtblend.setProgress((int)6);
					break;
				}
				case "color-burn": {
					txtblend.setProgress((int)7);
					break;
				}
				case "hard-light": {
					txtblend.setProgress((int)8);
					break;
				}
				case "soft-light": {
					txtblend.setProgress((int)9);
					break;
				}
				case "difference": {
					txtblend.setProgress((int)10);
					break;
				}
				case "exclusion": {
					txtblend.setProgress((int)11);
					break;
				}
				case "hue": {
					txtblend.setProgress((int)12);
					break;
				}
				case "saturation": {
					txtblend.setProgress((int)13);
					break;
				}
				case "color": {
					txtblend.setProgress((int)14);
					break;
				}
				case "luminosity": {
					txtblend.setProgress((int)15);
					break;
				}
			}
		}catch(Exception e){
			SketchwareUtil.showMessage(getApplicationContext(), "Виникла помилка при читанні налаштуваннь дизайну домашньої сторінки");
		}
		youmaychangesettings = true;
		_onscroll(vscroll1);
		_onscroll(vscroll2);
		left.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		center.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		right.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		justify.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
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
				if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgopacity.txt").equals("0.0")) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgopacity.txt", "1.0");
				}
				else {
					if (Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgopacity.txt")) < 0.3d) {
						lowopacitywarning.setTitle("!!!");
						lowopacitywarning.setMessage("У вас стоїть надто низька прозорість фону, Ви можете і не побачити зображення. Чи не хотіли б Ви підняти прозорість до 1.0 ?");
						lowopacitywarning.setPositiveButton("Так", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								bgalp.setProgress((int)100);
							}
						});
						lowopacitywarning.setNegativeButton("Ні, дякую", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						lowopacitywarning.create().show();
					}
				}
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/css/bgimage.txt", "/storage/emulated/0/WeekBrowser/css/BACKGROUND.png");
				FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), "/storage/emulated/0/WeekBrowser/css/BACKGROUND.png", SketchwareUtil.getDisplayWidthPixels(getApplicationContext()));
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
			}
			else {
				
			}
			break;
			
			case REQ_CD_DES:
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
				new UnZip().unZipIt(_filePath.get((int)(0)), "/storage/emulated/0/WeekBrowser/");
				_designing();
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	private class kostyli extends AsyncTask<String, Integer, String> {
		@Override
		protected void onPreExecute() {
			
		}
		
		@Override
		protected String doInBackground(String... params) {
			String _param = params[0];
			if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/bookmark.html").contains("<body style")) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/bookmark.html", FileUtil.readFile("/storage/emulated/0/WeekBrowser/bookmark.html").replaceAll("<body style.*>", ""));
			}
			return ("");
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			int _value = values[0];
			
		}
		
		@Override
		protected void onPostExecute(String _result) {
			
		}
	}
	
	@Override
	public void onBackPressed() {
		finish();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		Skin skin = new Skin();
		
		skin.setBG(bdesign, 0, false);
		skin.setBG(importt, 0, false);
		skin.setBG(export, 0, false);
		skin.setBG(inslink, 0, false);
		skin.setBG(insmlink, 0, false);
		skin.setBG(delphoto, 0, false);
		skin.setBG(hideshow, 0, false);
		skin.setBG(refresh, 0, false);
		skin.setBG(pickphoto, 0, false);
		skin.setBG(add, 0, false);
		skin.setBG(button1, 0, false);
		skin.setBG(deletee, 1, false);
		skin.setBG(blink, 0, false);
		skin.setBG(bsearch, 0, false);
		skin.setBG(biframe, 0, false);
		skin.setBG(bhtml, 0, false);
		skin.setBG(tobg, 1, false);
		skin.setBG(totxt, 1, false);
		
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		applyColorsToViews(findViewById(android.R.id.content));
		        skin.setBG(linear1, 2, false);	name.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		designname.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		link.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		color.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		html.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		textview2.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
					textview5.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
					textview3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
					name.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		link.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		color.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		html.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		designname.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
					add.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		            importt.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));export.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		            delphoto.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		            
		            inslink.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		            
		            insmlink.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		            
		button1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		bdesign.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		blink.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		biframe.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		bsearch.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		refresh.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		hideshow.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		bhtml.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		pickphoto.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					deletee.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
					
		
		tobg.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
					
		
		totxt.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
					
		
		t1.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t2.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t4.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t5.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t6.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t7.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t8.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t9.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t10.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t11.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t12.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t13.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t14.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t15.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t16.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t17.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t18.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t19.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t20.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t21.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t22.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t23.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t24.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t25.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t26.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t27.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t28.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t29.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t30.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t31.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t32.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t33.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t34.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t35.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t36.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t37.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t38.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t39.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t40.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t41.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		t42.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		txtszind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		txtboldind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		txtintind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		shadxind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		shadyind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		shadbind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		shadalpind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		txtstrszind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		stralpind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		wrdstrszind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		wstrstind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		wstralpind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		txtbrind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		txtcontind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		txtsaturind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		txtsepiaind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		txtinvind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		txthueind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		txtblurind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		txtalpind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		txtblendind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		
		bgsizepercind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		bgstrszind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		bgstrstind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		bgsaind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		bgbrind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		bgcontrind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		bgsaturind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		bgsepind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		bginverind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		bghueind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		bgblurind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		bgalpind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		bgblendind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		
		italic.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		sans.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		serif.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		mono.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		courier.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		cursive.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		maintain.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		cover.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		bgsizecustom.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		left.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		center.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		right.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		justify.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		std.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		allbig.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		allsmall.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		capit.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		
		shadc.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		strcol.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		wstrcol.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		bgstrcol.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		bgcol.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/monofortextarea.txt").equals("1")) {
			name.setTypeface(Typeface.MONOSPACE);
			link.setTypeface(Typeface.MONOSPACE);
			color.setTypeface(Typeface.MONOSPACE);
			html.setTypeface(Typeface.MONOSPACE);
		}
		else {
			name.setTypeface(Typeface.DEFAULT);
			link.setTypeface(Typeface.DEFAULT);
			color.setTypeface(Typeface.DEFAULT);
			html.setTypeface(Typeface.DEFAULT);
		}
		_Language();
	}
	
	public void _Language() {
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
	
	
	public void _designing() {
		if (iterations < 10) {
			webview1.loadUrl("javascript:(function() {\n    var backgroundDiv = document.createElement('div');\n    backgroundDiv.style.position = 'fixed';\n    backgroundDiv.style.top = '0';\n    backgroundDiv.style.left = '0';\n    backgroundDiv.style.width = '100%';\n    backgroundDiv.style.height = '100%';\n    backgroundDiv.style.zIndex = '-1';\n    backgroundDiv.style.backgroundColor = '#".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgcol.txt").concat("';\n    document.body.appendChild(backgroundDiv);\n\n    var blurDiv = document.createElement('div');\n    blurDiv.style.position = 'fixed';\n    blurDiv.style.top = '0';\n    blurDiv.style.left = '0';\n    blurDiv.style.width = '100%';\n    blurDiv.style.height = '100%';\n    blurDiv.style.backgroundColor = '#".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt").concat("';\n    blurDiv.style.backgroundImage = 'url(file://".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgimage.txt").concat(")';\n    blurDiv.style.backgroundSize = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsize.txt").concat("';\n    blurDiv.style.filter = 'blur(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgblur.txt").concat("px) ".concat("".concat("invert(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bginvert.txt").concat(") contrast(")))))))))))))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgcontr.txt").concat(") brightness(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgbright.txt").concat(") sepia(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsepia.txt").concat(") hue-rotate(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bghue.txt").concat("deg) saturate(")).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsatur.txt").concat("")))))))).concat("".concat("".concat("".concat("".concat("".concat(") opacity(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgopacity.txt").concat(")';\n    blurDiv.style.mixBlendMode = '")))))))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt").concat("';\n    blurDiv.style.zIndex = '-2';\n    backgroundDiv.appendChild(blurDiv);\n\n    var contentElements = document.querySelectorAll('font');\n    contentElements.forEach(function(element) {\n        \n        element.style.lineHeight = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textline.txt").concat("';\n        element.style.fontFamily = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textfont.txt").concat("';\n        element.style.fontSize = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsize.txt").concat("px';\n        element.style.fontWeight = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textweight.txt").concat("';\n        element.style.textTransform = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/texttrans.txt").concat("';\n        element.style.fontStyle = '")).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textstyle.txt").concat("';\n        element.style.filter = 'blur(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textblur.txt")).concat("px) ".concat("".concat(" invert(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textinvert.txt").concat(") contrast("))))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textcontr.txt").concat(") brightness(")))))))))))))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbright.txt").concat(") sepia(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsepia.txt").concat(") hue-rotate(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/texthue.txt").concat("deg) saturate(")).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsatur.txt").concat("".concat("")))).concat("".concat("".concat("".concat("".concat(") opacity(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textopacity.txt"))))).concat(")';\n        element.style.textShadow = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowx.txt").concat("px ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowy.txt")))))))))).concat("px ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowb.txt")).concat("px #".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowc.txt"))).concat("';\n        element.style.mixBlendMode = '").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt").concat("';\n        element.style.border = '").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbordersize.txt").concat("px ")).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textborderstyle.txt")).concat(" #"))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbordercolor.txt").concat("';\n        element.style.webkitTextStroke = '").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textstrokesize.txt")).concat("px #".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textstrokecolor.txt")))).concat("';\n        \n    });\n    document.body.style.border = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokesize.txt")).concat("px ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokestyle.txt")).concat(" #").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokecolor.txt")).concat("';\n    document.body.style.textAlign = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textalign.txt").concat("';\n})();"))))));
			iterations++;
		}
		else {
			webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
			iterations = 0;
		}
		FileUtil.writeFile("/storage/emulated/0/WeekBrowser/cache/bmkdsgn.txt", "javascript:(function() {\n    var backgroundDiv = document.createElement('div');\n    backgroundDiv.style.position = 'fixed';\n    backgroundDiv.style.top = '0';\n    backgroundDiv.style.left = '0';\n    backgroundDiv.style.width = '100%';\n    backgroundDiv.style.height = '100%';\n    backgroundDiv.style.zIndex = '-1';\n    backgroundDiv.style.backgroundColor = '#".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgcol.txt").concat("';\n    document.body.appendChild(backgroundDiv);\n\n    var blurDiv = document.createElement('div');\n    blurDiv.style.position = 'fixed';\n    blurDiv.style.top = '0';\n    blurDiv.style.left = '0';\n    blurDiv.style.width = '100%';\n    blurDiv.style.height = '100%';\n    blurDiv.style.backgroundColor = '#".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt").concat("';\n    blurDiv.style.backgroundImage = 'url(file://".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgimage.txt").concat(")';\n    blurDiv.style.backgroundSize = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsize.txt").concat("';\n    blurDiv.style.filter = 'blur(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgblur.txt").concat("px) ".concat("".concat("invert(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bginvert.txt").concat(") contrast(")))))))))))))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgcontr.txt").concat(") brightness(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgbright.txt").concat(") sepia(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsepia.txt").concat(") hue-rotate(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bghue.txt").concat("deg) saturate(")).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsatur.txt").concat("")))))))).concat("".concat("".concat("".concat("".concat("".concat(") opacity(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgopacity.txt").concat(")';\n    blurDiv.style.mixBlendMode = '")))))))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt").concat("';\n    blurDiv.style.zIndex = '-2';\n    backgroundDiv.appendChild(blurDiv);\n\n    var contentElements = document.querySelectorAll('font');\n    contentElements.forEach(function(element) {\n        \n        element.style.lineHeight = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textline.txt").concat("';\n        element.style.fontFamily = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textfont.txt").concat("';\n        element.style.fontSize = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsize.txt").concat("px';\n        element.style.fontWeight = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textweight.txt").concat("';\n        element.style.textTransform = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/texttrans.txt").concat("';\n        element.style.fontStyle = '")).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textstyle.txt").concat("';\n        element.style.filter = 'blur(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textblur.txt")).concat("px) ".concat("".concat(" invert(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textinvert.txt").concat(") contrast("))))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textcontr.txt").concat(") brightness(")))))))))))))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbright.txt").concat(") sepia(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsepia.txt").concat(") hue-rotate(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/texthue.txt").concat("deg) saturate(")).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsatur.txt").concat("".concat("")))).concat("".concat("".concat("".concat("".concat(") opacity(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textopacity.txt"))))).concat(")';\n        element.style.textShadow = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowx.txt").concat("px ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowy.txt")))))))))).concat("px ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowb.txt")).concat("px #".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowc.txt"))).concat("';\n        element.style.mixBlendMode = '").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt").concat("';\n        element.style.border = '").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbordersize.txt").concat("px ")).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textborderstyle.txt")).concat(" #"))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbordercolor.txt").concat("';\n        element.style.webkitTextStroke = '").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textstrokesize.txt")).concat("px #".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textstrokecolor.txt")))).concat("';\n        \n    });\n    document.body.style.border = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokesize.txt")).concat("px ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokestyle.txt")).concat(" #").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokecolor.txt")).concat("';\n    document.body.style.textAlign = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textalign.txt").concat("';\n})();"))))));
	}
	
	
	public String _toHexStr(final double _num) {
		if (_num < 16) {
			lol="0".concat(Integer.toHexString((int)_num));
		}
		else {
			lol=Integer.toHexString((int)_num);
		}
		return (lol);
	}
	
	
	public double _fromHex(final String _str) {
		        int decimalValue = Integer.parseInt(_str, 16);
		        return decimalValue;
	}
	
	
	public void _onscroll(final View _w) {
		_w.setOnTouchListener(new View.OnTouchListener() {
			    private float startX;
			    private float startY;
			    boolean scroll=false;
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
					                scroll=false;
					                if (Math.abs(startX - endX) < touchSlop) {
						                    // Ваша логіка для натискання
						                }
					                break;
					            case MotionEvent.ACTION_MOVE:
					                float currentX = event.getRawX();
					                float currentY = event.getRawY();
					                if (startY + SketchwareUtil.getDip(getApplicationContext(), (int) (50)) < currentY||startY - SketchwareUtil.getDip(getApplicationContext(), (int) (50)) > currentY) {
						                    scroll=true;
						                    }
					                if (startX + SketchwareUtil.getDip(getApplicationContext(), (int) (100)) < currentX&&!scroll) {
						                    vscroll2.setVisibility(View.GONE);
						                    vscroll1.setVisibility(View.VISIBLE);
						                } else if (startX - SketchwareUtil.getDip(getApplicationContext(), (int) (100)) > currentX&&!scroll) {
						                    vscroll2.setVisibility(View.VISIBLE);
						                    vscroll1.setVisibility(View.GONE);
						                }
					                break;
					        }
				        return false; // Повертаємо false, щоб інші обробники подій дотику також були викликані, якщо вони є
				    }
		});
		
	}
	
	
	public void _extra() {
	}
	
	
	/*MADE BY ARAB WARE CHANNEL*/
	/*WHAT IS MADE ? ===>ADD FOLDER TO ZIP*/
	
	public void ArabWareAddFolderToZip (String _from,String _to) {
		if (FileUtil.isExistFile(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"))) {
				new UnZip().unZipIt(_to, _to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
				new java.io.File(_from).renameTo(new java.io.File(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/").concat(Uri.parse(_from).getLastPathSegment())));
				try {
						Zip.zipFolder(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"),_to.replace(Uri.parse(_to).getLastPathSegment(), "") + Uri.parse(_to).getLastPathSegment());
				} catch(Exception e) {}
				FileUtil.deleteFile(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
		}
		else {
				FileUtil.makeDir(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
				new UnZip().unZipIt(_to, _to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
				new java.io.File(_from).renameTo(new java.io.File(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/").concat(Uri.parse(_from).getLastPathSegment())));
				try {
						Zip.zipFolder(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"),_to.replace(Uri.parse(_to).getLastPathSegment(), "") + Uri.parse(_to).getLastPathSegment());
				} catch(Exception e) {}
				FileUtil.deleteFile(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
		}
	}
	
	
	
	public void addFilesToZip(java.io.File source, java.io.File files)
	{
		    try
		    {
			
			   
			        byte[] buffer = new byte[1024];
			        java.util.zip.ZipInputStream zin = new java.util.zip.ZipInputStream(new java.io.FileInputStream(files));
			        java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(source));
			            java.io.InputStream in = new java.io.FileInputStream(files);
			            out.putNextEntry(new java.util.zip.ZipEntry(files.getName()));
			            for(int read = in.read(buffer); read > -1; read = in.read(buffer))
			            {
				                out.write(buffer, 0, read);
				            }
			            out.closeEntry();
			            in.close();
			
			        for(java.util.zip.ZipEntry ze = zin.getNextEntry(); ze != null; ze = zin.getNextEntry())
			        {
				            out.putNextEntry(ze);
				            for(int read = zin.read(buffer); read > -1; read = zin.read(buffer))
				            {
					                out.write(buffer, 0, read);
					            }
				            out.closeEntry();
				        }
			
			        out.close();
			      
			    }
		    catch(Exception e)
		    {
			       showMessage(e.getMessage());
			    }
	}
	public static class Zip {
		
		public static void zipFolder(String str, String str2) throws Exception {
			            java.util.zip.ZipOutputStream zipOutputStream = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(str2));
			            addFolderToZip("", str, zipOutputStream);
			            zipOutputStream.flush();
			            zipOutputStream.close();
			        }
		
		
		public static void addFolderToZip(String str, String str2, java.util.zip.ZipOutputStream zipOutputStream) throws Exception {
			            java.io.File file = new java.io.File(str2);
			            for (String str3 : file.list()) {
				                if (str.equals("")) {
					                    addFileToZip(file.getName(), new StringBuilder(String.valueOf(str2)).append("/").append(str3).toString(), zipOutputStream);
					                } else {
					                    addFileToZip(new StringBuilder(String.valueOf(str)).append("/").append(file.getName()).toString(), new StringBuilder(String.valueOf(str2)).append("/").append(str3).toString(), zipOutputStream);
					                }
				            }
			        }
		
		
		
		  public static void addFileToZip(String path, String srcFile, java.util.zip.ZipOutputStream zip)
		      throws Exception {
			    java.io.File folder = new java.io.File(srcFile);
			    if (folder.isDirectory()) {
				      
				    } else {
				      byte[] buf = new byte[1024];
				      int len;
				      java.io.FileInputStream in = new java.io.FileInputStream(srcFile);
				      zip.putNextEntry(new java.util.zip.ZipEntry(path + "/" + folder.getName()));
				      while ((len = in.read(buf)) > 0) {
					        zip.write(buf, 0, len);
					      }
				    }
		}
		  }
	
	public static class UnZip {
		List<String> fileList;
		
		public void unZipIt(String zipFile, String outputFolder){
			byte[] buffer = new byte[1024];
			try{
				java.util.zip.ZipInputStream zis = new java.util.zip.ZipInputStream(new java.io.FileInputStream(zipFile));
				java.util.zip.ZipEntry ze = zis.getNextEntry();
				while(ze!=null){
					String fileName = ze.getName();
					java.io.File newFile = new java.io.File(outputFolder + java.io.File.separator + fileName);
					new java.io.File(newFile.getParent()).mkdirs();
					java.io.FileOutputStream fos = new java.io.FileOutputStream(newFile);
					int len;
					while ((len = zis.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}
					fos.close();
					ze = zis.getNextEntry(); 
				}
				zis.closeEntry();
				zis.close();
			}catch(java.io.IOException ex){
				ex.printStackTrace();
			}
		}
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
	
	
	{
	}
	
	
	public void _onpagefinish(final String _url) {
		
	}
	
	
	public void _onpagefail() {
		webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
	}
	
	
	public void _onpagestart(final String _url) {
		if (!_url.equals("file:///storage/emulated/0/WeekBrowser/bookmark.html")) {
			if (delete) {
				URL = _url;
				webview1.stopLoading();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/bookmark.html", FileUtil.readFile("/storage/emulated/0/WeekBrowser/bookmark.html").replace(URL, ""));
				String fileContents = FileUtil.readFile("/storage/emulated/0/WeekBrowser/bookmark.html");
				
				// Видалення вказаних рядків
				fileContents = fileContents.replaceAll("<a href=\"\".*><font color=\".*\">.*</font></a><font color=\".*\">.*</font>", "");
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/bookmark.html", fileContents);
				webview1.loadUrl("file:///storage/emulated/0/WeekBrowser/bookmark.html");
			}
			else {
				intent.setClass(getApplicationContext(), IntentActivity.class);
				intent.setData(Uri.parse(_url));
				webview1.stopLoading();
				startActivity(intent);
			}
		}
		FileUtil.writeFile("/storage/emulated/0/WeekBrowser/cache/bmkdsgn.txt", "javascript:(function() {\n    var backgroundDiv = document.createElement('div');\n    backgroundDiv.style.position = 'fixed';\n    backgroundDiv.style.top = '0';\n    backgroundDiv.style.left = '0';\n    backgroundDiv.style.width = '100%';\n    backgroundDiv.style.height = '100%';\n    backgroundDiv.style.zIndex = '-1';\n    backgroundDiv.style.backgroundColor = '#".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgcol.txt").concat("';\n    document.body.appendChild(backgroundDiv);\n\n    var blurDiv = document.createElement('div');\n    blurDiv.style.position = 'fixed';\n    blurDiv.style.top = '0';\n    blurDiv.style.left = '0';\n    blurDiv.style.width = '100%';\n    blurDiv.style.height = '100%';\n    blurDiv.style.backgroundColor = '#".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt").concat("';\n    blurDiv.style.backgroundImage = 'url(file://".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgimage.txt").concat(")';\n    blurDiv.style.backgroundSize = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsize.txt").concat("';\n    blurDiv.style.filter = 'blur(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgblur.txt").concat("px) ".concat("".concat("invert(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bginvert.txt").concat(") contrast(")))))))))))))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgcontr.txt").concat(") brightness(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgbright.txt").concat(") sepia(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsepia.txt").concat(") hue-rotate(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bghue.txt").concat("deg) saturate(")).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgsatur.txt").concat("")))))))).concat("".concat("".concat("".concat("".concat("".concat(") opacity(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgopacity.txt").concat(")';\n    blurDiv.style.mixBlendMode = '")))))))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgblend.txt").concat("';\n    blurDiv.style.zIndex = '-2';\n    backgroundDiv.appendChild(blurDiv);\n\n    var contentElements = document.querySelectorAll('font');\n    contentElements.forEach(function(element) {\n        \n        element.style.lineHeight = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textline.txt").concat("';\n        element.style.fontFamily = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textfont.txt").concat("';\n        element.style.fontSize = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsize.txt").concat("px';\n        element.style.fontWeight = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textweight.txt").concat("';\n        element.style.textTransform = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/texttrans.txt").concat("';\n        element.style.fontStyle = '")).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textstyle.txt").concat("';\n        element.style.filter = 'blur(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textblur.txt")).concat("px) ".concat("".concat(" invert(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textinvert.txt").concat(") contrast("))))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textcontr.txt").concat(") brightness(")))))))))))))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbright.txt").concat(") sepia(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsepia.txt").concat(") hue-rotate(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/texthue.txt").concat("deg) saturate(")).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textsatur.txt").concat("".concat("")))).concat("".concat("".concat("".concat("".concat(") opacity(".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textopacity.txt"))))).concat(")';\n        element.style.textShadow = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowx.txt").concat("px ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowy.txt")))))))))).concat("px ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowb.txt")).concat("px #".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowc.txt"))).concat("';\n        element.style.mixBlendMode = '").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textshadowblend.txt").concat("';\n        element.style.border = '").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbordersize.txt").concat("px ")).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textborderstyle.txt")).concat(" #"))).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textbordercolor.txt").concat("';\n        element.style.webkitTextStroke = '").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textstrokesize.txt")).concat("px #".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textstrokecolor.txt")))).concat("';\n        \n    });\n    document.body.style.border = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokesize.txt")).concat("px ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokestyle.txt")).concat(" #").concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/bgstrokecolor.txt")).concat("';\n    document.body.style.textAlign = '".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/css/textalign.txt").concat("';\n})();"))))));
		webview1.loadUrl(FileUtil.readFile("/storage/emulated/0/WeekBrowser/cache/bmkdsgn.txt"));
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