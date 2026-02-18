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
import android.webkit.WebSettings;
import android.webkit.WebView;
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
import java.text.DecimalFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import java.io.FileOutputStream;
import java.io.IOException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONObject;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import java.util.stream.Collectors;
import android.os.Build;
import android.annotation.TargetApi;
import java.net.URLEncoder;

import android.content.ContentUris;
import android.content.Context;
import android.os.Environment;
import android.provider.DocumentsContract;

public class BookmarksActivity extends Activity {
	
	private Timer _timer = new Timer();
	
	private String URL = "";
	private boolean delete = false;
	private String lol = "";
	private String prevImage = "";
	private double iterations = 0;
	private boolean youmaychangesettings = false;
	ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	private String nURL = "";
	private String hurl = "";
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	int[] curfol = new int[0];
	private boolean updateweb = false;
	RenderUtils ru;
	Skin skin = new Skin();
	
	private ArrayList<String> languag = new ArrayList<>();
	private ArrayList<String> E = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> divs = new ArrayList<>();
	
	private WebView webview1;
	private Button hideshow;
	private HorizontalScrollView hscroll2;
	private LinearLayout linear6;
	private Button deletee;
	private LinearLayout linear10;
	private Button blink;
	private Button bhtml2;
	private Button bsearch;
	private Button bdesign;
	private Button bhtml;
	private ScrollView htmls;
	private ScrollView links;
	private ScrollView lsearchs;
	private LinearLayout lhtml;
	private LinearLayout design;
	private LinearLayout lhtml2;
	private ScrollView html2s;
	private Button htmla;
	private EditText htmlt;
	private LinearLayout llink;
	private TextView textview2;
	private AutoCompleteTextView name;
	private TextView textview3;
	private AutoCompleteTextView link;
	private LinearLayout linear31;
	private TextView textview5;
	private HorizontalScrollView hscroll1;
	private Button add;
	private Button newfolder;
	private Button inslink;
	private Button insmlink;
	private LinearLayout linear2;
	private AutoCompleteTextView color;
	private Button button5;
	private Button c1;
	private Button c2;
	private Button c3;
	private Button c4;
	private Button c5;
	private Button c6;
	private Button c7;
	private Button c8;
	private LinearLayout lsearch;
	private TextView textview7;
	private AutoCompleteTextView tahint;
	private TextView textview8;
	private AutoCompleteTextView tabef;
	private AutoCompleteTextView taafter;
	private Button pagesearch;
	private LinearLayout linear12;
	private LinearLayout linear15;
	private Button google;
	private Button bing;
	private Button yahoo;
	private Button duck;
	private Button youtube;
	private Button gimages;
	private Button gvideo;
	private Button gnews;
	private ScrollView vscroll4;
	private Button refresh;
	private AutoCompleteTextView html;
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
	private TextView div;
	private LinearLayout linear34;
	private HorizontalScrollView hscroll11;
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
	private EditText divt;
	private Spinner divv;
	private LinearLayout linear33;
	private AutoCompleteTextView divcol;
	private Button divc0;
	private Button divc1;
	private Button divc2;
	private Button divc3;
	private Button divc4;
	private Button divc5;
	private Button divc6;
	private Button divc7;
	private Button divc8;
	private LinearLayout linear24;
	private AutoCompleteTextView shadc;
	private Button button8;
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
	private Button button9;
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
	private Button button10;
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
	private Button export;
	private Button pickphoto;
	private Button delphoto;
	private Button button1;
	private LinearLayout linear21;
	private AutoCompleteTextView bgcol;
	private Button button15;
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
	private Button button16;
	private Button bgsc1;
	private Button bgsc2;
	private Button bgsc3;
	private Button bgsc4;
	private Button bgsc5;
	private Button bgsc6;
	private Button bgsc7;
	private Button bgsc8;
	
	private Intent intent = new Intent();
	private ObjectAnimator anim = new ObjectAnimator();
	private AlertDialog.Builder lowopacitywarning;
	private SharedPreferences sf;
	private AlertDialog.Builder compress;
	private AlertDialog.Builder delet;
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		ThemeManager.applyTheme(this);
		setContentView(R.layout.bookmarks);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		ru = new RenderUtils(BookmarksActivity.this);
		
		fp.setType("image/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false);
		
		webview1 = findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		hideshow = findViewById(R.id.hideshow);
		hscroll2 = findViewById(R.id.hscroll2);
		linear6 = findViewById(R.id.linear6);
		deletee = findViewById(R.id.deletee);
		linear10 = findViewById(R.id.linear10);
		blink = findViewById(R.id.blink);
		bhtml2 = findViewById(R.id.bhtml2);
		bsearch = findViewById(R.id.bsearch);
		bdesign = findViewById(R.id.bdesign);
		bhtml = findViewById(R.id.bhtml);
		htmls = findViewById(R.id.htmls);
		links = findViewById(R.id.links);
		lsearchs = findViewById(R.id.lsearchs);
		lhtml = findViewById(R.id.lhtml);
		design = findViewById(R.id.design);
		lhtml2 = findViewById(R.id.lhtml2);
		html2s = findViewById(R.id.html2s);
		htmla = findViewById(R.id.htmla);
		htmlt = findViewById(R.id.htmlt);
		llink = findViewById(R.id.llink);
		textview2 = findViewById(R.id.textview2);
		name = findViewById(R.id.name);
		textview3 = findViewById(R.id.textview3);
		link = findViewById(R.id.link);
		linear31 = findViewById(R.id.linear31);
		textview5 = findViewById(R.id.textview5);
		hscroll1 = findViewById(R.id.hscroll1);
		add = findViewById(R.id.add);
		newfolder = findViewById(R.id.newfolder);
		inslink = findViewById(R.id.inslink);
		insmlink = findViewById(R.id.insmlink);
		linear2 = findViewById(R.id.linear2);
		color = findViewById(R.id.color);
		button5 = findViewById(R.id.button5);
		c1 = findViewById(R.id.c1);
		c2 = findViewById(R.id.c2);
		c3 = findViewById(R.id.c3);
		c4 = findViewById(R.id.c4);
		c5 = findViewById(R.id.c5);
		c6 = findViewById(R.id.c6);
		c7 = findViewById(R.id.c7);
		c8 = findViewById(R.id.c8);
		lsearch = findViewById(R.id.lsearch);
		textview7 = findViewById(R.id.textview7);
		tahint = findViewById(R.id.tahint);
		textview8 = findViewById(R.id.textview8);
		tabef = findViewById(R.id.tabef);
		taafter = findViewById(R.id.taafter);
		pagesearch = findViewById(R.id.pagesearch);
		linear12 = findViewById(R.id.linear12);
		linear15 = findViewById(R.id.linear15);
		google = findViewById(R.id.google);
		bing = findViewById(R.id.bing);
		yahoo = findViewById(R.id.yahoo);
		duck = findViewById(R.id.duck);
		youtube = findViewById(R.id.youtube);
		gimages = findViewById(R.id.gimages);
		gvideo = findViewById(R.id.gvideo);
		gnews = findViewById(R.id.gnews);
		vscroll4 = findViewById(R.id.vscroll4);
		refresh = findViewById(R.id.refresh);
		html = findViewById(R.id.html);
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
		div = findViewById(R.id.div);
		linear34 = findViewById(R.id.linear34);
		hscroll11 = findViewById(R.id.hscroll11);
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
		divt = findViewById(R.id.divt);
		divv = findViewById(R.id.divv);
		linear33 = findViewById(R.id.linear33);
		divcol = findViewById(R.id.divcol);
		divc0 = findViewById(R.id.divc0);
		divc1 = findViewById(R.id.divc1);
		divc2 = findViewById(R.id.divc2);
		divc3 = findViewById(R.id.divc3);
		divc4 = findViewById(R.id.divc4);
		divc5 = findViewById(R.id.divc5);
		divc6 = findViewById(R.id.divc6);
		divc7 = findViewById(R.id.divc7);
		divc8 = findViewById(R.id.divc8);
		linear24 = findViewById(R.id.linear24);
		shadc = findViewById(R.id.shadc);
		button8 = findViewById(R.id.button8);
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
		button9 = findViewById(R.id.button9);
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
		button10 = findViewById(R.id.button10);
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
		export = findViewById(R.id.export);
		pickphoto = findViewById(R.id.pickphoto);
		delphoto = findViewById(R.id.delphoto);
		button1 = findViewById(R.id.button1);
		linear21 = findViewById(R.id.linear21);
		bgcol = findViewById(R.id.bgcol);
		button15 = findViewById(R.id.button15);
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
		button16 = findViewById(R.id.button16);
		bgsc1 = findViewById(R.id.bgsc1);
		bgsc2 = findViewById(R.id.bgsc2);
		bgsc3 = findViewById(R.id.bgsc3);
		bgsc4 = findViewById(R.id.bgsc4);
		bgsc5 = findViewById(R.id.bgsc5);
		bgsc6 = findViewById(R.id.bgsc6);
		bgsc7 = findViewById(R.id.bgsc7);
		bgsc8 = findViewById(R.id.bgsc8);
		lowopacitywarning = new AlertDialog.Builder(this);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		compress = new AlertDialog.Builder(this);
		delet = new AlertDialog.Builder(this);
		
		//webviewOnProgressChanged
		webview1.setWebChromeClient(new WebChromeClient() {
			@Override public void onProgressChanged(WebView view, int _newProgress) {
				
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
				} else {
					linear6.setVisibility(View.VISIBLE);
					hscroll2.setVisibility(View.VISIBLE);
					deletee.setVisibility(View.VISIBLE);
					hideshow.setText("▽▼▼▼▼▼▽");
					Animator2.anim(getApplicationContext(), linear6, 1, 300);
				}
			}
		});
		
		deletee.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				
				Skin skin = new Skin();
				
				ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
				if (delete) {
					delete = false;
					deletee.setText(getString(R.string.delete));
					skin.setBG(hideshow, 0, false);
					hideshow.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
				} else {
					delete = true;
					deletee.setText(getString(R.string.choose_delete));
					skin.setBG(hideshow, 1, false);
					hideshow.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
				}
			}
		});
		
		blink.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				links.setVisibility(View.VISIBLE);
				lsearchs.setVisibility(View.GONE);
				htmls.setVisibility(View.GONE);
				lhtml.setVisibility(View.GONE);
				design.setVisibility(View.GONE);
			}
		});
		
		bhtml2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				links.setVisibility(View.GONE);
				lsearchs.setVisibility(View.GONE);
				htmls.setVisibility(View.VISIBLE);
				lhtml.setVisibility(View.GONE);
				design.setVisibility(View.GONE);
			}
		});
		
		bsearch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				links.setVisibility(View.GONE);
				lsearchs.setVisibility(View.VISIBLE);
				htmls.setVisibility(View.GONE);
				lhtml.setVisibility(View.GONE);
				design.setVisibility(View.GONE);
			}
		});
		
		bdesign.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				lsearchs.setVisibility(View.GONE);
				links.setVisibility(View.GONE);
				htmls.setVisibility(View.GONE);
				lhtml.setVisibility(View.GONE);
				design.setVisibility(View.VISIBLE);
			}
		});
		
		bhtml.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				lsearchs.setVisibility(View.GONE);
				links.setVisibility(View.GONE);
				htmls.setVisibility(View.GONE);
				lhtml.setVisibility(View.VISIBLE);
				design.setVisibility(View.GONE);
				if (html.getText().toString().equals("")) {
					html.setText(FileUtil.readFile(getFilesDir().getPath().concat("/bookmark.json")));
				}
			}
		});
		
		htmla.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				HomePageGen.addHtml(getApplicationContext(), curfol, htmlt.getText().toString());
				webview1.loadUrl("file://"+getFilesDir().getPath()+"/bookmark.json");
			}
		});
		
		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				HomePageGen.addBM(getApplicationContext(), curfol, name.getText().toString(), link.getText().toString(), "#"+color.getText().toString());
				webview1.loadUrl("file://"+getFilesDir().getPath()+"/bookmark.json");
			}
		});
		
		newfolder.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				HomePageGen.addFOL(getApplicationContext(), curfol, name.getText().toString(), color.getText().toString());
				webview1.loadUrl("file://"+getFilesDir().getPath()+"/bookmark.json");
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
		
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_colorpick(color);
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
		
		pagesearch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				HomePageGen.addSRH(getApplicationContext(), curfol,
				tahint.getText().toString(),
				tabef.getText().toString(),
				taafter.getText().toString());
				webview1.loadUrl("file://"+getFilesDir().getPath()+"/bookmark.json");
			}
		});
		
		google.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tabef.setText("https://www.google.com/search?q=");
				taafter.setText("");
				tahint.setText("Google");
			}
		});
		
		bing.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tabef.setText("https://www.bing.com/search?q=");
				taafter.setText("");
				tahint.setText("Bing");
			}
		});
		
		yahoo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tabef.setText("https://www.yahoo.com/search?q=");
				taafter.setText("");
				tahint.setText("Yahoo");
			}
		});
		
		duck.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tabef.setText("https://www.duckduckgo.com/search?q=");
				taafter.setText("");
				tahint.setText("DuckDuckGo");
			}
		});
		
		youtube.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tabef.setText("https://www.youtube.com/search?q=");
				taafter.setText("");
				tahint.setText("YouTube");
			}
		});
		
		gimages.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tabef.setText("https://www.google.com/search?sca_esv=99636c5107a06ae2&q=");
				taafter.setText("&uds=AMwkrPuAtCsJx0yzkuE0014ksXt9UJoHu3DMczwo_HsBKWFeY85C4qTrzQUb61phTZjohbN8SjYe_a3xHALisl_CSZnN66nOANsLk0s-AkXzEgHeOJnAWHKMOwSV8bycYbBADhoL-z2nuhwTSR0zr91iQ5hdQQev-2oLtGabTHICA1uND5eakZixmLj-V0X2Q02-SpJs31QeoE3HvaANjDCZTijMsorKErPUmGJmnRbyZA7CIQ4fB2e5rJ9r-w6sEjvHnnFYSpx3T5mwelcO6wmbhMbYoWXn9_0oNcOFl7YODSyPoUcxup5FUb7aoMKlFxe4TcdRvajy7yU_9l08CBiKjLH835Zr4g&udm=2&prmd=visnmbtz&sa=X&ved=2ahUKEwjdnZ-lvcaFAxWlFxAIHV9EAlUQtKgLegQIDRAB&biw=480&bih=739&dpr=3");
				tahint.setText("Google Images");
			}
		});
		
		gvideo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tabef.setText("https://www.google.com/search?sca_esv=99636c5107a06ae2&q=");
				taafter.setText("&tbm=vid&source=lnms&prmd=visnmbtz&sa=X&ved=2ahUKEwjw_aW1vcaFAxXUGBAIHW4aCLQQ0pQJegQIExAB&biw=480&bih=760&dpr=3");
				tahint.setText("Google Video");
			}
		});
		
		gnews.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				tabef.setText("https://www.google.com/search?sca_esv=99636c5107a06ae2&q=");
				taafter.setText("&tbm=nws&source=lnms&prmd=ivsnmbtz&sa=X&ved=2ahUKEwj1wd2xvsaFAxXDPxAIHXtEDs0Q0pQJegQIBxAB&biw=480&bih=739&dpr=3");
				tahint.setText("Google News");
			}
		});
		
		//OnTouch
		refresh.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event){
				int ev = event.getAction();
				switch (ev) {
					case MotionEvent.ACTION_DOWN:
					
					FileUtil.writeFile(getFilesDir().getPath().concat("/bookmark.json"), html.getText().toString());
					HomePageGen.cc(getApplicationContext());
					webview1.loadUrl("file://"+getFilesDir().getPath()+"/bookmark.json");
					
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
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextsize", String.valueOf((long)(_progressValue))).commit();
					_designing();
				}
				txtszind.setText(String.valueOf((long)(_progressValue)));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		txtbold.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextweight", String.valueOf((long)(_progressValue * 100))).commit();
					_designing();
				}
				txtboldind.setText(String.valueOf((long)(_progressValue * 100)));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		italic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					if (italic.isChecked()) {
						sf.edit().putString("csstextstyle", "italic").commit();
					} else {
						sf.edit().putString("csstextstyle", "initial").commit();
					}
					_designing();
				}
			}
		});
		
		txtint.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextline", String.valueOf(_progressValue / 10.d)).commit();
					_designing();
				}
				txtintind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		shadx.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextshadowx", String.valueOf((_progressValue - 50) / 5.d)).commit();
					_designing();
				}
				shadxind.setText(String.valueOf((_progressValue - 50) / 5.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		shady.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextshadowy", String.valueOf((_progressValue - 50) / 5.d)).commit();
					_designing();
				}
				shadyind.setText(String.valueOf((_progressValue - 50) / 5.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		shadb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextshadowb", String.valueOf(_progressValue / 10.d)).commit();
					_designing();
				}
				shadbind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		shadalp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextshadowc", shadc.getText().toString().concat(_toHexStr(_progressValue))).commit();
					_designing();
				}
				shadalpind.setText(String.valueOf((long)(_progressValue)));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		txtstrsz.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextstrokesize", String.valueOf(_progressValue / 10.d)).commit();
					_designing();
				}
				txtstrszind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		stralp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextstrokecolor", strcol.getText().toString().concat(_toHexStr(_progressValue))).commit();
					_designing();
				}
				stralpind.setText(String.valueOf((long)(_progressValue)));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		wrdstr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextbordersize", String.valueOf(_progressValue / 10.d)).commit();
					_designing();
				}
				wrdstrszind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		wstrst.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					switch((int)_progressValue) {
						case ((int)0): {
							sf.edit().putString("csstextborderstyle", "solid").commit();
							break;
						}
						case ((int)1): {
							sf.edit().putString("csstextborderstyle", "dashed").commit();
							break;
						}
						case ((int)2): {
							sf.edit().putString("csstextborderstyle", "dotted").commit();
							break;
						}
						case ((int)3): {
							sf.edit().putString("csstextborderstyle", "double").commit();
							break;
						}
						case ((int)4): {
							sf.edit().putString("csstextborderstyle", "groove").commit();
							break;
						}
						case ((int)5): {
							sf.edit().putString("csstextborderstyle", "ridge").commit();
							break;
						}
						case ((int)6): {
							sf.edit().putString("csstextborderstyle", "inset").commit();
							break;
						}
						case ((int)7): {
							sf.edit().putString("csstextborderstyle", "outset").commit();
							break;
						}
					}
					_designing();
				}
				wstrstind.setText(sf.getString("csstextborderstyle", ""));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		wstralp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextbordercolor", wstrcol.getText().toString().concat(_toHexStr(_progressValue))).commit();
					_designing();
				}
				wstralpind.setText(String.valueOf((long)(_progressValue)));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		txtbr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextbright", String.valueOf(_progressValue / 10.d)).commit();
					_designing();
				}
				txtbrind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		txtcont.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextcontr", String.valueOf(_progressValue / 10.d)).commit();
					_designing();
				}
				txtcontind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		txtsatur.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextsatur", String.valueOf(_progressValue / 10.d)).commit();
					_designing();
				}
				txtsaturind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		txtsepia.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextsepia", String.valueOf(_progressValue / 100.d)).commit();
					_designing();
				}
				txtsepiaind.setText(String.valueOf(_progressValue / 100.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		txtinv.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextinvert", String.valueOf(_progressValue / 100.d)).commit();
					_designing();
				}
				txtinvind.setText(String.valueOf(_progressValue / 100.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		txthue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstexthue", String.valueOf((long)(_progressValue))).commit();
					_designing();
				}
				txthueind.setText(String.valueOf((long)(_progressValue)).concat("°"));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		txtblur.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextblur", String.valueOf(_progressValue / 10.d)).commit();
					_designing();
				}
				txtblurind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		txtalp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextopacity", String.valueOf(_progressValue / 100.d)).commit();
					_designing();
				}
				txtalpind.setText(String.valueOf(_progressValue / 100.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		txtblend.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					switch((int)_progressValue) {
						case ((int)0): {
							sf.edit().putString("csstextblend", "normal").commit();
							break;
						}
						case ((int)1): {
							sf.edit().putString("csstextblend", "multiply").commit();
							break;
						}
						case ((int)2): {
							sf.edit().putString("csstextblend", "screen").commit();
							break;
						}
						case ((int)3): {
							sf.edit().putString("csstextblend", "overlay").commit();
							break;
						}
						case ((int)4): {
							sf.edit().putString("csstextblend", "darken").commit();
							break;
						}
						case ((int)5): {
							sf.edit().putString("csstextblend", "lighten").commit();
							break;
						}
						case ((int)6): {
							sf.edit().putString("csstextblend", "color-dodge").commit();
							break;
						}
						case ((int)7): {
							sf.edit().putString("csstextblend", "color-burn").commit();
							break;
						}
						case ((int)8): {
							sf.edit().putString("csstextblend", "hard-light").commit();
							break;
						}
						case ((int)9): {
							sf.edit().putString("csstextblend", "soft-light").commit();
							break;
						}
						case ((int)10): {
							sf.edit().putString("csstextblend", "difference").commit();
							break;
						}
						case ((int)11): {
							sf.edit().putString("csstextblend", "exclusion").commit();
							break;
						}
						case ((int)12): {
							sf.edit().putString("csstextblend", "hue").commit();
							break;
						}
						case ((int)13): {
							sf.edit().putString("csstextblend", "saturation").commit();
							break;
						}
						case ((int)14): {
							sf.edit().putString("csstextblend", "color").commit();
							break;
						}
						case ((int)15): {
							sf.edit().putString("csstextblend", "luminosity").commit();
							break;
						}
					}
					_designing();
				}
				txtblendind.setText(sf.getString("csstextblend", ""));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		sans.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextfont", "sans").commit();
					_designing();
				}
			}
		});
		
		serif.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextfont", "serif").commit();
					_designing();
				}
			}
		});
		
		mono.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextfont", "monospace").commit();
					_designing();
				}
			}
		});
		
		courier.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextfont", "courier new").commit();
					_designing();
				}
			}
		});
		
		cursive.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextfont", "cursive").commit();
					_designing();
				}
			}
		});
		
		std.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstexttrans", "initial").commit();
					_designing();
				}
			}
		});
		
		allbig.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstexttrans", "uppercase").commit();
					_designing();
				}
			}
		});
		
		allsmall.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstexttrans", "lowercase").commit();
					_designing();
				}
			}
		});
		
		capit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstexttrans", "capitalize").commit();
					_designing();
				}
			}
		});
		
		left.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextalign", "left").commit();
					_designing();
				}
			}
		});
		
		center.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextalign", "center").commit();
					_designing();
				}
			}
		});
		
		right.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextalign", "right").commit();
					_designing();
				}
			}
		});
		
		justify.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextalign", "justify").commit();
					_designing();
				}
			}
		});
		
		divt.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssdiv", _charSeq).commit();
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
		
		divv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (!(_position == 0)) {
					divt.setText(divs.get((int)_position).get("ua").toString());
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		divcol.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssdivcolor", _charSeq).commit();
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
		
		divc0.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_colorpick(divcol);
			}
		});
		
		divc1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				divcol.setText("FF0000");
			}
		});
		
		divc2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				divcol.setText("FFFF00");
			}
		});
		
		divc3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				divcol.setText("00FF00");
			}
		});
		
		divc4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				divcol.setText("00FFFF");
			}
		});
		
		divc5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				divcol.setText("FF00FF");
			}
		});
		
		divc6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				divcol.setText("FFFFFF");
			}
		});
		
		divc7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				divcol.setText("000000");
			}
		});
		
		divc8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				divcol.setText("0000FF");
			}
		});
		
		shadc.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextshadowc", _charSeq.concat(_toHexStr(shadalp.getProgress()))).commit();
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
		
		button8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_colorpick(shadc);
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
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextstrokecolor", _charSeq.concat(_toHexStr(stralp.getProgress()))).commit();
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
		
		button9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_colorpick(strcol);
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
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("csstextbordercolor", _charSeq.concat(_toHexStr(wstralp.getProgress()))).commit();
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
		
		button10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_colorpick(wstrcol);
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
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssbgsize", String.valueOf((long)(bgsizeperc.getProgress())).concat("%")).commit();
					_designing();
				}
				bgsizepercind.setText(String.valueOf((long)(bgsizeperc.getProgress())).concat("%"));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		bgstrsz.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssbgstrokesize", String.valueOf(_progressValue / 10.d)).commit();
					_designing();
				}
				bgstrszind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		bgstrst.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					switch((int)_progressValue) {
						case ((int)0): {
							sf.edit().putString("cssbgstrokestyle", "solid").commit();
							break;
						}
						case ((int)1): {
							sf.edit().putString("cssbgstrokestyle", "dashed").commit();
							break;
						}
						case ((int)2): {
							sf.edit().putString("cssbgstrokestyle", "dotted").commit();
							break;
						}
						case ((int)3): {
							sf.edit().putString("cssbgstrokestyle", "double").commit();
							break;
						}
						case ((int)4): {
							sf.edit().putString("cssbgstrokestyle", "groove").commit();
							break;
						}
						case ((int)5): {
							sf.edit().putString("cssbgstrokestyle", "ridge").commit();
							break;
						}
						case ((int)6): {
							sf.edit().putString("cssbgstrokestyle", "inset").commit();
							break;
						}
						case ((int)7): {
							sf.edit().putString("cssbgstrokestyle", "outset").commit();
							break;
						}
					}
					_designing();
				}
				bgstrstind.setText(sf.getString("cssbgstrokestyle", ""));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		bgsa.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssbgstrokecolor", bgstrcol.getText().toString().concat(_toHexStr(_progressValue))).commit();
					_designing();
				}
				bgsaind.setText(String.valueOf((long)(_progressValue)));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		bgbr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssbgbright", String.valueOf(_progressValue / 10.d)).commit();
					_designing();
				}
				bgbrind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		bgcontr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssbgcontr", String.valueOf(_progressValue / 10.d)).commit();
					_designing();
				}
				bgcontrind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		bgsatur.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssbgsatur", String.valueOf(_progressValue / 10.d)).commit();
					_designing();
				}
				bgsaturind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		bgsep.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssbgsepia", String.valueOf(_progressValue / 100.d)).commit();
					_designing();
				}
				bgsepind.setText(String.valueOf(_progressValue / 100.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		bginver.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssbginvert", String.valueOf(_progressValue / 100.d)).commit();
					_designing();
				}
				bginverind.setText(String.valueOf(_progressValue / 100.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		bghue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssbghue", String.valueOf((long)(_progressValue))).commit();
					_designing();
				}
				bghueind.setText(String.valueOf((long)(_progressValue)).concat("°"));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		bgblur.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssbgblur", String.valueOf(_progressValue / 10.d)).commit();
					_designing();
				}
				bgblurind.setText(String.valueOf(_progressValue / 10.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		bgalp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssbgopacity", String.valueOf(_progressValue / 100.d)).commit();
					_designing();
				}
				bgalpind.setText(String.valueOf(_progressValue / 100.d));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		bgblend.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					switch((int)_progressValue) {
						case ((int)0): {
							sf.edit().putString("cssbgblend", "normal").commit();
							break;
						}
						case ((int)1): {
							sf.edit().putString("cssbgblend", "multiply").commit();
							break;
						}
						case ((int)2): {
							sf.edit().putString("cssbgblend", "screen").commit();
							break;
						}
						case ((int)3): {
							sf.edit().putString("cssbgblend", "overlay").commit();
							break;
						}
						case ((int)4): {
							sf.edit().putString("cssbgblend", "darken").commit();
							break;
						}
						case ((int)5): {
							sf.edit().putString("cssbgblend", "lighten").commit();
							break;
						}
						case ((int)6): {
							sf.edit().putString("cssbgblend", "color-dodge").commit();
							break;
						}
						case ((int)7): {
							sf.edit().putString("cssbgblend", "color-burn").commit();
							break;
						}
						case ((int)8): {
							sf.edit().putString("cssbgblend", "hard-light").commit();
							break;
						}
						case ((int)9): {
							sf.edit().putString("cssbgblend", "soft-light").commit();
							break;
						}
						case ((int)10): {
							sf.edit().putString("cssbgblend", "difference").commit();
							break;
						}
						case ((int)11): {
							sf.edit().putString("cssbgblend", "exclusion").commit();
							break;
						}
						case ((int)12): {
							sf.edit().putString("cssbgblend", "hue").commit();
							break;
						}
						case ((int)13): {
							sf.edit().putString("cssbgblend", "saturation").commit();
							break;
						}
						case ((int)14): {
							sf.edit().putString("cssbgblend", "color").commit();
							break;
						}
						case ((int)15): {
							sf.edit().putString("cssbgblend", "luminosity").commit();
							break;
						}
					}
					_designing();
				}
				bgblendind.setText(sf.getString("cssbgblend", ""));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		export.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getApplicationContext().getSharedPreferences("sf", Context.MODE_PRIVATE);
				_skinlegacy();
				
				// Створення JSON-об'єкту для зберігання всіх параметрів
				JSONObject json = new JSONObject();
				try {
					json.put("cssbgcol", sf.getString("cssbgcol", "FFFFFF"));
					json.put("cssbg", sf.getString("cssbg", ""));
					json.put("cssbgsize", sf.getString("cssbgsize", "cover"));
					json.put("cssbgblur", sf.getString("cssbgblur", "0"));
					json.put("cssbginvert", sf.getString("cssbginvert", "0"));
					json.put("cssbgcontr", sf.getString("cssbgcontr", "100%"));
					json.put("cssbgbright", sf.getString("cssbgbright", "100%"));
					json.put("cssbgsepia", sf.getString("cssbgsepia", "0%"));
					json.put("cssbghue", sf.getString("cssbghue", "0"));
					json.put("cssbgsatur", sf.getString("cssbgsatur", "100%"));
					json.put("cssbgopacity", sf.getString("cssbgopacity", "100%"));
					json.put("cssbgblend", sf.getString("cssbgblend", "normal"));
					json.put("csstextline", sf.getString("csstextline", "1.5"));
					json.put("csstextfont", sf.getString("csstextfont", "Arial"));
					json.put("csstextsize", sf.getString("csstextsize", "16"));
					json.put("csstextweight", sf.getString("csstextweight", "normal"));
					json.put("csstexttrans", sf.getString("csstexttrans", "none"));
					json.put("csstextstyle", sf.getString("csstextstyle", "normal"));
					json.put("csstextblur", sf.getString("csstextblur", "0"));
					json.put("csstextinvert", sf.getString("csstextinvert", "0"));
					json.put("csstextcontr", sf.getString("csstextcontr", "100%"));
					json.put("csstextbright", sf.getString("csstextbright", "100%"));
					json.put("csstextsepia", sf.getString("csstextsepia", "0%"));
					json.put("csstexthue", sf.getString("csstexthue", "0"));
					json.put("csstextsatur", sf.getString("csstextsatur", "100%"));
					json.put("csstextopacity", sf.getString("csstextopacity", "100%"));
					json.put("csstextshadowx", sf.getString("csstextshadowx", "0"));
					json.put("csstextshadowy", sf.getString("csstextshadowy", "0"));
					json.put("csstextshadowb", sf.getString("csstextshadowb", "0"));
					json.put("csstextshadowc", sf.getString("csstextshadowc", "000000"));
					json.put("csstextblend", sf.getString("csstextblend", "normal"));
					json.put("csstextbordersize", sf.getString("csstextbordersize", "0"));
					json.put("csstextborderstyle", sf.getString("csstextborderstyle", "none"));
					json.put("csstextbordercolor", sf.getString("csstextbordercolor", "000000"));
					json.put("csstextstrokesize", sf.getString("csstextstrokesize", "0"));
					json.put("csstextstrokecolor", sf.getString("csstextstrokecolor", "000000"));
					json.put("cssbgstrokesize", sf.getString("cssbgstrokesize", "0"));
					json.put("cssbgstrokestyle", sf.getString("cssbgstrokestyle", "none"));
					json.put("cssbgstrokecolor", sf.getString("cssbgstrokecolor", "000000"));
					json.put("csstextalign", sf.getString("csstextalign", "left"));
					json.put("cssdiv", sf.getString("cssdiv", " ❖ "));
					json.put("cssdivcolor", sf.getString("cssdivcolor", "ff0000"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				// Формування URL
				String url = "https://skins.weekbrowser.com/bookmarks/" + json.toString();
				
				// Копіювання в буфер обміну
				ClipboardManager clipboard = (ClipboardManager) getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
				ClipData clip = ClipData.newPlainText("URL", url);
				if (clipboard != null) {
					clipboard.setPrimaryClip(clip);
				}
				
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
			}
		});
		
		pickphoto.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(fp, 101);
			}
		});
		
		delphoto.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("cssbg", "initial").commit();
				FileUtil.deleteFile(getFilesDir().getPath().concat("/background.gif"));
				_designing();
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (WTF.SDK_INT() > 21) {
					bgcol.setText(JSutil.replaceInstruction("000000;background:$bggradne$").replace("javascript:", ""));
				} else {
					bgcol.setText(_toHexStr(skin.avgbg()).substring(3,9));
				}
				_designing();
			}
		});
		
		bgcol.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssbgcol", _charSeq).commit();
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
		
		button15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_colorpick(bgcol);
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
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssbgsize", "maintain").commit();
					bgsizepercind.setVisibility(View.GONE);
					bgsizeperc.setVisibility(View.GONE);
					_designing();
				}
			}
		});
		
		cover.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssbgsize", "cover").commit();
					bgsizepercind.setVisibility(View.GONE);
					bgsizeperc.setVisibility(View.GONE);
					_designing();
				}
			}
		});
		
		bgsizecustom.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssbgsize", String.valueOf((long)(bgsizeperc.getProgress())).concat("%")).commit();
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
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (youmaychangesettings) {
					sf.edit().putString("cssbgstrokecolor", _charSeq.concat(_toHexStr(bgsa.getProgress()))).commit();
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
		
		button16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_colorpick(bgstrcol);
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
	}
	
	private void initializeLogic() {
		hurl = "file://"+getFilesDir().getPath()+"/bookmark.json";
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		webview1.setInitialScale((int)Integer.parseInt(sf.getString("dp", ""))*10);
		webview1.getSettings().setMinimumFontSize(Integer.parseInt(sf.getString("minfont", "")));
		webview1.getSettings().setTextZoom(Integer.parseInt(sf.getString("fontsize", ""))*10);
		
		final Activity activity = BookmarksActivity.this;
		colorify.applyColorifyToAll(getWindow().getDecorView().getRootView());
		Intent intent = getIntent();
		Uri data = intent.getData();
		
		if (data != null) {
			// Завантажуємо URL в WebView
			URL=data.toString();     link.setText(data.toString());
		}
		webview1.setLayerType(sf.getString("hardware2", "1")
		.equals("1")?
		View.LAYER_TYPE_HARDWARE:View.LAYER_TYPE_SOFTWARE, null);
		
		webview1.getSettings().setAllowFileAccess(true);
		webview1.getSettings().setAllowContentAccess(true);
		webview1.getSettings().setAllowFileAccessFromFileURLs(true);
		webview1.getSettings().setAllowUniversalAccessFromFileURLs(true);
		webview1.setWebViewClient(new WebViewClient() {
			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request){
				String url = request.getUrl().toString();
				_onpagestart(url);
				return true;
			}
			
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
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
			
			@Override
			@TargetApi(Build.VERSION_CODES.LOLLIPOP)
			public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
				String url = request.getUrl().toString();
				
				if (url.equals("file://"+getFilesDir().getPath()+"/bookmark.json")) {
					try {
						// 2. Згенерувати HTML
						String html = HomePageGen.generateHtml(BookmarksActivity.this);
						
						// 3. Повернути як HTML
						return new WebResourceResponse(
						"text/html",
						"UTF-8",
						new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8))
						);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return super.shouldInterceptRequest(view, request);
			}
			
			@Override
			public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
				
				if (url.equals("file://"+getFilesDir().getPath()+"/bookmark.json")) {
					try {
						// 2. Згенерувати HTML
						String html = HomePageGen.generateHtml(BookmarksActivity.this);
						
						// 3. Повернути як HTML
						return new WebResourceResponse(
						"text/html",
						"UTF-8",
						new ByteArrayInputStream(html.getBytes("utf-8"))
						);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return super.shouldInterceptRequest(view, url);
			}
		});
		/*
webview1.setWebChromeClient(new WebChromeClient() {
    private boolean issu=false;
    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);

        String url = view.getUrl(); // Отримуємо поточний URL
        if (newProgress >= 11 && newProgress <= 100) {
            if(!issu){
            issu = true;}
        }else issu = false;
    }
});
*/
		webview1.loadUrl("file://"+getFilesDir().getPath()+"/bookmark.json");
		name.setText(getIntent().getStringExtra("n"));
		link.setLines(4);
		((EditText)bgcol).setMaxLines((int)10);
		links.setVisibility(View.VISIBLE);
		lsearchs.setVisibility(View.GONE);
		design.setVisibility(View.GONE);
		lhtml.setVisibility(View.GONE);
		htmls.setVisibility(View.GONE);
		linear6.setVisibility(View.GONE);
		hscroll2.setVisibility(View.GONE);
		deletee.setVisibility(View.GONE);
		vscroll2.setVisibility(View.GONE);
		if (WTF.SDK_INT() < 21) {
			t7.setVisibility(View.GONE);
			shadxind.setVisibility(View.GONE);
			shadx.setVisibility(View.GONE);
			t8.setVisibility(View.GONE);
			shadyind.setVisibility(View.GONE);
			shady.setVisibility(View.GONE);
			t9.setVisibility(View.GONE);
			shadbind.setVisibility(View.GONE);
			shadb.setVisibility(View.GONE);
			t10.setVisibility(View.GONE);
			hscroll6.setVisibility(View.GONE);
			t11.setVisibility(View.GONE);
			shadalpind.setVisibility(View.GONE);
			shadalp.setVisibility(View.GONE);
			t12.setVisibility(View.GONE);
			txtstrszind.setVisibility(View.GONE);
			txtstrsz.setVisibility(View.GONE);
			t13.setVisibility(View.GONE);
			hscroll7.setVisibility(View.GONE);
			t14.setVisibility(View.GONE);
			stralpind.setVisibility(View.GONE);
			stralp.setVisibility(View.GONE);
			t15.setVisibility(View.GONE);
			wrdstrszind.setVisibility(View.GONE);
			wrdstr.setVisibility(View.GONE);
			t16.setVisibility(View.GONE);
			wstrstind.setVisibility(View.GONE);
			wstrst.setVisibility(View.GONE);
			t17.setVisibility(View.GONE);
			hscroll8.setVisibility(View.GONE);
			t18.setVisibility(View.GONE);
			wstralpind.setVisibility(View.GONE);
			wstralp.setVisibility(View.GONE);
			t19.setVisibility(View.GONE);
			txtbrind.setVisibility(View.GONE);
			txtbr.setVisibility(View.GONE);
			t20.setVisibility(View.GONE);
			txtcontind.setVisibility(View.GONE);
			txtcont.setVisibility(View.GONE);
			t21.setVisibility(View.GONE);
			txtsaturind.setVisibility(View.GONE);
			txtsatur.setVisibility(View.GONE);
			t22.setVisibility(View.GONE);
			txtsepiaind.setVisibility(View.GONE);
			txtsepia.setVisibility(View.GONE);
			t23.setVisibility(View.GONE);
			txtinvind.setVisibility(View.GONE);
			txtinv.setVisibility(View.GONE);
			t24.setVisibility(View.GONE);
			txthueind.setVisibility(View.GONE);
			txthue.setVisibility(View.GONE);
			t25.setVisibility(View.GONE);
			txtblurind.setVisibility(View.GONE);
			txtblur.setVisibility(View.GONE);
			t26.setVisibility(View.GONE);
			txtalpind.setVisibility(View.GONE);
			txtalp.setVisibility(View.GONE);
			t27.setVisibility(View.GONE);
			txtblendind.setVisibility(View.GONE);
			txtblend.setVisibility(View.GONE);
			t30.setVisibility(View.GONE);
			bgstrszind.setVisibility(View.GONE);
			bgstrsz.setVisibility(View.GONE);
			t31.setVisibility(View.GONE);
			bgstrstind.setVisibility(View.GONE);
			bgstrst.setVisibility(View.GONE);
			t32.setVisibility(View.GONE);
			hscroll4.setVisibility(View.GONE);
			t33.setVisibility(View.GONE);
			bgsaind.setVisibility(View.GONE);
			bgsa.setVisibility(View.GONE);
			t34.setVisibility(View.GONE);
			bgbrind.setVisibility(View.GONE);
			bgbr.setVisibility(View.GONE);
			t35.setVisibility(View.GONE);
			bgcontrind.setVisibility(View.GONE);
			bgcontr.setVisibility(View.GONE);
			t36.setVisibility(View.GONE);
			bgsaturind.setVisibility(View.GONE);
			bgsatur.setVisibility(View.GONE);
			t37.setVisibility(View.GONE);
			bgsepind.setVisibility(View.GONE);
			bgsep.setVisibility(View.GONE);
			t38.setVisibility(View.GONE);
			bginverind.setVisibility(View.GONE);
			bginver.setVisibility(View.GONE);
			t39.setVisibility(View.GONE);
			bghueind.setVisibility(View.GONE);
			bghue.setVisibility(View.GONE);
			t40.setVisibility(View.GONE);
			bgblurind.setVisibility(View.GONE);
			bgblur.setVisibility(View.GONE);
			t42.setVisibility(View.GONE);
			bgblendind.setVisibility(View.GONE);
			bgblend.setVisibility(View.GONE);
		}
		webview1.addJavascriptInterface(new WebAppInterface(), "Android");
		HomePageGen.prepareWebViewWithTempInterface(this, url -> {
			runOnUiThread(() -> {
				intent.setClass(getApplicationContext(), IntentActivity.class);
				intent.setData(Uri.parse(url));
				startActivity(intent);
				finish();}
			);
		});
		try{
			shadc.setText(sf.getString("csstextshadowc", "").substring((int)(0), (int)(6)));
			strcol.setText(sf.getString("csstextstrokecolor", "").substring((int)(0), (int)(6)));
			wstrcol.setText(sf.getString("csstextbordercolor", "").substring((int)(0), (int)(6)));
			bgstrcol.setText(sf.getString("cssbgstrokecolor", "").substring((int)(0), (int)(6)));
			italic.setChecked(sf.getString("csstextstyle", "").equals("italic"));
			txtsz.setProgress((int)Integer.parseInt(sf.getString("csstextsize", "")));
			txtbold.setProgress((int)Integer.parseInt(sf.getString("csstextweight", "")) / 100);
			txtint.setProgress((int)(Double.parseDouble(sf.getString("csstextline", "")) * 10) / 1);
			shadx.setProgress((int)((Double.parseDouble(sf.getString("csstextshadowx", "")) * 5) + 50) / 1);
			shady.setProgress((int)((Double.parseDouble(sf.getString("csstextshadowy", "")) * 5) + 50) / 1);
			shadb.setProgress((int)(Double.parseDouble(sf.getString("csstextshadowb", "")) * 10) / 1);
			shadalp.setProgress((int)_fromHex(sf.getString("csstextshadowc", "").substring((int)(6), (int)(8))));
			stralp.setProgress((int)_fromHex(sf.getString("csstextstrokecolor", "").substring((int)(6), (int)(8))));
			wstralp.setProgress((int)_fromHex(sf.getString("csstextbordercolor", "").substring((int)(6), (int)(8))));
			bgsa.setProgress((int)_fromHex(sf.getString("cssbgstrokecolor", "").substring((int)(6), (int)(8))));
			bgcol.setText(sf.getString("cssbgcol", ""));
			divt.setText(sf.getString("cssdiv", ""));
			divcol.setText(sf.getString("cssdivcolor", ""));
			bgstrsz.setProgress((int)(Double.parseDouble(sf.getString("cssbgstrokesize", "")) * 10.d) / 1);
			wrdstr.setProgress((int)(Double.parseDouble(sf.getString("csstextbordersize", "")) * 10.d) / 1);
			txtbr.setProgress((int)(Double.parseDouble(sf.getString("csstextbright", "")) * 10.d) / 1);
			txtcont.setProgress((int)(Double.parseDouble(sf.getString("csstextcontr", "")) * 10.d) / 1);
			txtsatur.setProgress((int)(Double.parseDouble(sf.getString("csstextsatur", "")) * 10.d) / 1);
			txtsepia.setProgress((int)(Double.parseDouble(sf.getString("csstextsepia", "")) * 100.d) / 1);
			txtinv.setProgress((int)(Double.parseDouble(sf.getString("csstextinvert", "")) * 100.d) / 1);
			txthue.setProgress((int)Integer.parseInt(sf.getString("csstexthue", "")));
			txtblur.setProgress((int)(Double.parseDouble(sf.getString("csstextblur", "")) * 10.d) / 1);
			txtalp.setProgress((int)(Double.parseDouble(sf.getString("csstextopacity", "")) * 100.d) / 1);
			bgbr.setProgress((int)(Double.parseDouble(sf.getString("cssbgbright", "")) * 10.d) / 1);
			bgcontr.setProgress((int)(Double.parseDouble(sf.getString("cssbgcontr", "")) * 10.d) / 1);
			bgsatur.setProgress((int)(Double.parseDouble(sf.getString("cssbgsatur", "")) * 10.d) / 1);
			bgsep.setProgress((int)(Double.parseDouble(sf.getString("cssbgsepia", "")) * 100.d) / 1);
			bginver.setProgress((int)(Double.parseDouble(sf.getString("cssbginvert", "")) * 100.d) / 1);
			bghue.setProgress((int)Integer.parseInt(sf.getString("cssbghue", "")));
			bgblur.setProgress((int)(Double.parseDouble(sf.getString("cssbgblur", "")) * 10.d) / 1);
			bgalp.setProgress((int)(Double.parseDouble(sf.getString("cssbgopacity", "")) * 100.d) / 1);
			sans.setChecked("sans".equals(sf.getString("csstextfont", "")));
			serif.setChecked("serif".equals(sf.getString("csstextfont", "")));
			mono.setChecked("monospace".equals(sf.getString("csstextfont", "")));
			courier.setChecked("courier new".equals(sf.getString("csstextfont", "")));
			cursive.setChecked("cursive".equals(sf.getString("csstextfont", "")));
			std.setChecked("initial".equals(sf.getString("csstexttrans", "")));
			allbig.setChecked("uppercase".equals(sf.getString("csstexttrans", "")));
			allsmall.setChecked("lowercase".equals(sf.getString("csstexttrans", "")));
			capit.setChecked("capitalize".equals(sf.getString("csstexttrans", "")));
			left.setChecked("left".equals(sf.getString("csstextalign", "")));
			center.setChecked("center".equals(sf.getString("csstextalign", "")));
			right.setChecked("right".equals(sf.getString("csstextalign", "")));
			justify.setChecked("justify".equals(sf.getString("csstextalign", "")));
			if ("maintain".equals(sf.getString("cssbgsize", ""))) {
				maintain.setChecked(true);
				bgsizepercind.setVisibility(View.GONE);
				bgsizeperc.setVisibility(View.GONE);
			}
			else {
				if ("cover".equals(sf.getString("cssbgsize", ""))) {
					cover.setChecked(true);
					bgsizepercind.setVisibility(View.GONE);
					bgsizeperc.setVisibility(View.GONE);
				}
				else {
					bgsizecustom.setChecked(true);
					bgsizepercind.setVisibility(View.VISIBLE);
					bgsizeperc.setVisibility(View.VISIBLE);
					bgsizeperc.setProgress((int)Integer.parseInt(sf.getString("cssbgsize", "").replace("%", "")));
				}
			}
			wstrstind.setText(sf.getString("csstextborderstyle", ""));
			switch(sf.getString("csstextborderstyle", "")) {
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
			bgstrstind.setText(sf.getString("cssbgstrokestyle", ""));
			switch(sf.getString("cssbgstrokestyle", "")) {
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
			bgblendind.setText(sf.getString("cssbgblend", ""));
			switch(sf.getString("cssbgblend", "")) {
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
			txtblendind.setText(sf.getString("csstextblend", ""));
			switch(sf.getString("csstextblend", "")) {
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
			SketchwareUtil.showMessage(getApplicationContext(), "Error");
			((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", e.toString()));
		}
		youmaychangesettings = true;
		_onscroll(vscroll1);
		_onscroll(vscroll2);
		left.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		center.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		right.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		justify.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		button5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		button8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		button9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		button10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		button15.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		button16.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		_ualist();
		divv.setAdapter(new DivvAdapter(divs));
		webview1.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		super.onActivityResult(_requestCode, _resultCode, _data);
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
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
						_filePath.add(convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				else {
					
				}
				if (Double.parseDouble(sf.getString("cssbgopacity", "")) < 0.3d) {
					lowopacitywarning.setTitle("!!!");
					lowopacitywarning.setMessage(getString(R.string.lowopacity));
					lowopacitywarning.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							bgalp.setProgress(100);
							sf.edit().putString("cssbgopacity", "1.0").commit();
							bgalpind.setText("1.0");
							_designing();
						}
					});
					lowopacitywarning.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							_designing();	
						}
					});
					AlertDialog dddddd = lowopacitywarning.create();
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
					ru.on();
					dddddd.show();
				}
				sf.edit().putString("cssbg", getFilesDir().getPath().concat("/background.gif")).commit();
				compress.setTitle("?");
				compress.setMessage(getString(R.string.compressbg));
				compress.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), getFilesDir().getPath().concat("/background.gif"), SketchwareUtil.getDisplayWidthPixels(getApplicationContext()));
						webview1.loadUrl(getFilesDir().getPath().concat("/bookmark.json"));
						webview1.clearCache(true);
						_designing();
					}
				});
				compress.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FileUtil.copyFile(_filePath.get((int)(0)), getFilesDir().getPath().concat("/background.gif"));
						webview1.loadUrl(getFilesDir().getPath().concat("/bookmark.json"));
						webview1.clearCache(true);
						_designing();
					}
				});
				compress.setNeutralButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = compress.create();
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
				ru.on();
				dddddd.show();
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
		_skinlegacy();
		finish();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		SafeMarginUtils.init(this, findViewById(android.R.id.content));
		
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		skin.setBG(bdesign, 0, false);
		skin.setBG(export, 0, false);
		skin.setBG(inslink, 0, false);
		skin.setBG(insmlink, 0, false);
		skin.setBG(delphoto, 0, false);
		skin.setBG(hideshow, 0, false);
		skin.setBG(refresh, 0, false);
		skin.setBG(pickphoto, 0, false);
		skin.setBG(newfolder, 0, false);
		skin.setBG(add, 0, false);
		skin.setBG(bhtml2, 0, false);
		skin.setBG(htmla, 0, false);
		skin.setBG(button1, 0, false);
		skin.setBG(deletee, 1, false);
		skin.setBG(blink, 0, false);
		skin.setBG(bsearch, 0, false);
		skin.setBG(bhtml, 0, false);
		skin.setBG(tobg, 1, false);
		skin.setBG(totxt, 1, false);
		skin.setBG(pagesearch, 0, false);
		skin.setBG(google, 1, false);
		skin.setBG(bing, 1, false);
		skin.setBG(youtube, 1, false);
		skin.setBG(yahoo, 1, false);
		skin.setBG(duck, 1, false);
		skin.setBG(gimages, 1, false);
		skin.setBG(gvideo, 1, false);
		skin.setBG(gnews, 1, false);
		
		
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		colorify.applyColorifyToAll(getWindow().getDecorView().getRootView());
		skin.setBG(getWindow().getDecorView(), 2, false);
		
		name.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		link.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		color.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		html.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		tahint.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		tabef.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		taafter.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		
		htmlt.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		
		textview2.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview5.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		name.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		link.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		color.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		html.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		tahint.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		tabef.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		taafter.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		textview7.setTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		textview8.setTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		htmlt.setTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		add.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		export.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		delphoto.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		
		inslink.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		
		insmlink.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		
		button1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		newfolder.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		bdesign.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		blink.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		bsearch.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		refresh.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		hideshow.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		bhtml.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		pickphoto.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		bhtml2.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		htmla.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		deletee.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		
		pagesearch.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		google.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		bing.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		yahoo.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		duck.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		youtube.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		gimages.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		gvideo.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		gnews.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		
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
		div.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
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
		divt.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		divcol.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		if (sf.getString("monoforta", "").equals("1")) {
			name.setTypeface(Typeface.MONOSPACE);
			link.setTypeface(Typeface.MONOSPACE);
			color.setTypeface(Typeface.MONOSPACE);
			html.setTypeface(Typeface.MONOSPACE);
			tahint.setTypeface(Typeface.MONOSPACE);
			tabef.setTypeface(Typeface.MONOSPACE);
			taafter.setTypeface(Typeface.MONOSPACE);
			html.setTypeface(Typeface.MONOSPACE);
			divt.setTypeface(Typeface.MONOSPACE);
			divcol.setTypeface(Typeface.MONOSPACE);
			shadc.setTypeface(Typeface.MONOSPACE);
			strcol.setTypeface(Typeface.MONOSPACE);
			wstrcol.setTypeface(Typeface.MONOSPACE);
			bgcol.setTypeface(Typeface.MONOSPACE);
			bgstrcol.setTypeface(Typeface.MONOSPACE);
			htmlt.setTypeface(Typeface.MONOSPACE);
		} else {
			name.setTypeface(Typeface.DEFAULT);
			link.setTypeface(Typeface.DEFAULT);
			color.setTypeface(Typeface.DEFAULT);
			html.setTypeface(Typeface.DEFAULT);
			tahint.setTypeface(Typeface.DEFAULT);
			tabef.setTypeface(Typeface.DEFAULT);
			taafter.setTypeface(Typeface.DEFAULT);
			html.setTypeface(Typeface.DEFAULT);
			divt.setTypeface(Typeface.DEFAULT);
			divcol.setTypeface(Typeface.DEFAULT);
			shadc.setTypeface(Typeface.DEFAULT);
			strcol.setTypeface(Typeface.DEFAULT);
			wstrcol.setTypeface(Typeface.DEFAULT);
			bgcol.setTypeface(Typeface.DEFAULT);
			bgstrcol.setTypeface(Typeface.DEFAULT);
			htmlt.setTypeface(Typeface.DEFAULT);
		}
		_timer = new Timer();
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (updateweb) {
							webview1.loadUrl("file://"+getFilesDir().getPath()+"/bookmark.json");
							HomePageGen.cc(getApplicationContext());
							updateweb = false;
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t, (int)(99), (int)(100));
	}
	
	
	@Override
	public void onPause() {
		super.onPause();
		SafeMarginUtils.cleanup();
		if (_timer != null) {
			_timer.cancel();
			_timer = null;
		}
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
		updateweb = true;
	}
	
	
	public String _toHexStr(final double _num) {
		if (_num < 16) {
			lol="0".concat(Integer.toHexString((int)_num));
		} else {
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
	
	public WebView _getWebView(){
		return webview1;
	}
	
	class WebAppInterface {
		@JavascriptInterface
		public void onClick(String fullId) {
			// fullId містить повний шлях, наприклад "1-3-0"
			String[] path = fullId.split("-");
			
			// Конвертуємо в масив чисел
			int[] ids = new int[path.length];
			for (int i = 0; i < path.length; i++) {
				ids[i] = Integer.parseInt(path[i]);
			}
			
			if (delete) {
				runOnUiThread(() -> {
					delet.setTitle("!!!");
					delet.setMessage(getString(R.string.dellink) + " " + readName(ids) + "?");
					delet.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							HomePageGen.delBM(getApplicationContext(), ids);
							new Handler().postDelayed(() -> {
								webview1.loadUrl("file://"+getFilesDir().getPath()+"/bookmark.json");
							}, 100);
						}
					});
					delet.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					delet.setNegativeButton(getString(R.string.deldisable), new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							HomePageGen.delBM(getApplicationContext(), ids);
							new Handler().postDelayed(() -> {
								webview1.loadUrl("file://"+getFilesDir().getPath()+"/bookmark.json");
							}, 100);
							deletee.performClick();
						}
					});
					AlertDialog dddddd = delet.create();
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
				);
			} else {
				HomePageGen.getUrlBMAsync(BookmarksActivity.this, ids, url -> {
					runOnUiThread(() -> {
						intent.setClass(getApplicationContext(), IntentActivity.class);
						intent.setData(Uri.parse(url));
						startActivity(intent);
						finish();}
					);
				});
			}
			
			/*	runOnUiThread(() -> SketchwareUtil.showMessage(getApplicationContext(), Arrays.toString(ids)));*/
		}
		
		@JavascriptInterface
		public void onFolderClick(String folderIdWithAction) {
			try {
				// Розділяємо шлях і дію
				String[] parts = folderIdWithAction.split("-");
				int action = Integer.parseInt(parts[parts.length-1]); // -1 або -2
				int[] path = new int[parts.length-1];
				
				// Конвертуємо шлях в масив чисел
				for (int i = 0; i < parts.length-1; i++) {
					path[i] = Integer.parseInt(parts[i]);
				}
				
				// Оновлюємо curfol тільки при відкритті папки (action == -1)
				if (action == 1) {
					curfol = path; // Зберігаємо повний шлях до відкритої папки
				} else {
					// При закритті - зберігаємо шлях до батьківської папки
					curfol = Arrays.copyOf(path, Math.max(0, path.length-1));
				}
				
				if (delete) {
					runOnUiThread(() -> {
						if(action == 0){
							
							delet.setTitle("!!!");
							delet.setMessage(getString(R.string.delfolder) + " " + readName(path) + "?");
							delet.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									HomePageGen.delBM(getApplicationContext(), path);
									
									new Handler().postDelayed(() -> {
										webview1.loadUrl("file://"+getFilesDir().getPath()+"/bookmark.json");
									}, 100);
								}
							});
							delet.setNeutralButton(getString(R.string.no), new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							delet.setNegativeButton(getString(R.string.deldisable), new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									HomePageGen.delBM(getApplicationContext(), path);
									
									new Handler().postDelayed(() -> {
										webview1.loadUrl("file://"+getFilesDir().getPath()+"/bookmark.json");
									}, 100);
									deletee.performClick();
								}
							});
							AlertDialog dddddd = delet.create();
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
							
						}}
					);
				} else {
					
				}
				runOnUiThread(() -> {
					webview1.loadUrl(HomePageGen.getHighlightScript(curfol));
				}
				);
				
				/*       runOnUiThread(() -> {
boolean isOpening = (action == 1);
String message = "Шлях: " + Arrays.toString(curfol) + 
(isOpening ? " (відкрито)" : " (закрито)");
SketchwareUtil.showMessage(getApplicationContext(), message);
});*/
				
			} catch (Exception e) {
				Log.e("FolderClick", "Помилка обробки кліку", e);
			}
		}
		
	}
	
	
	public String readName(int[] path) {
		try {
			Context context = getApplicationContext();
			// 1. Завантажуємо JSON з файлу
			String json = FileUtil.readFile(context.getFilesDir().getPath() + "/bookmark.json");
			JSONArray bookmarks = new JSONArray(json);
			
			// 2. Проходимо по шляху до цільового елемента
			JSONObject current = null;
			JSONArray currentArray = bookmarks;
			
			for (int i = 0; i < path.length; i++) {
				current = currentArray.getJSONObject(path[i]);
				
				// Якщо це не останній елемент шляху, заглиблюємось далі
				if (i < path.length - 1) {
					currentArray = current.getJSONArray("content");
				}
			}
			
			// 3. Повертаємо значення поля "name"
			return current != null ? current.optString("name", "") : "";
			
		} catch (Exception e) {
			Log.e("readName", "Помилка читання назви", e);
			return "";
		}
	}
	
	public static String convertUriToFilePath(Context context, Uri uri) {
		if (uri == null) return null;
		
		if (WTF.SDK_INT() >= Build.VERSION_CODES.KITKAT && DocumentsContract.isDocumentUri(context, uri)) {
			// Для нових версій Android, API 19+
			if (isExternalStorageDocument(uri)) {
				final String docId = DocumentsContract.getDocumentId(uri);
				final String[] split = docId.split(":");
				final String type = split[0];
				if ("primary".equalsIgnoreCase(type)) {
					return Environment.getExternalStorageDirectory() + "/" + split[1];
				}
			} else if (isDownloadsDocument(uri)) {
				final String id = DocumentsContract.getDocumentId(uri);
				if (id != null && id.startsWith("raw:")) {
					return id.substring(4);
				}
				Uri contentUri = ContentUris.withAppendedId(
				Uri.parse("content://downloads/public_downloads"), Long.parseLong(id));
				return getDataColumn(context, contentUri, null, null);
			} else if (isMediaDocument(uri)) {
				final String docId = DocumentsContract.getDocumentId(uri);
				final String[] split = docId.split(":");
				final String type = split[0];
				Uri contentUri = null;
				if ("image".equals(type)) {
					contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
				} else if ("video".equals(type)) {
					contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
				} else if ("audio".equals(type)) {
					contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
				}
				final String selection = "_id=?";
				final String[] selectionArgs = new String[] { split[1] };
				return getDataColumn(context, contentUri, selection, selectionArgs);
			}
		} else if ("content".equalsIgnoreCase(uri.getScheme())) {
			// Для API < 19 або звичайних content-схем
			return getDataColumn(context, uri, null, null);
		} else if ("file".equalsIgnoreCase(uri.getScheme())) {
			return uri.getPath();
		}
		
		return null;
	}
	
	private static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
		Cursor cursor = null;
		final String column = "_data";
		final String[] projection = { column };
		try {
			cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
			if (cursor != null && cursor.moveToFirst()) {
				final int index = cursor.getColumnIndexOrThrow(column);
				return cursor.getString(index);
			}
		} finally {
			if (cursor != null) cursor.close();
		}
		return null;
	}
	
	private static boolean isExternalStorageDocument(Uri uri) {
		return "com.android.externalstorage.documents".equals(uri.getAuthority());
	}
	
	private static boolean isDownloadsDocument(Uri uri) {
		return "com.android.providers.downloads.documents".equals(uri.getAuthority());
	}
	
	private static boolean isMediaDocument(Uri uri) {
		return "com.android.providers.media.documents".equals(uri.getAuthority());
	}
	
	
	{
		
		
	}
	
	
	public void _onpagefinish(final String _url) {
		// Формуємо список шляхів для кожного рівня, включно з останнім
		List<String> pathsToOpen = new ArrayList<>();
		StringBuilder pathBuilder = new StringBuilder();
		for (int i = 0; i < curfol.length; i++) {
			if (i > 0) pathBuilder.append("-");
			pathBuilder.append(curfol[i]);
			pathsToOpen.add(pathBuilder.toString());
		}
		
		// Формуємо JavaScript для відкриття всіх папок
		StringBuilder jsOpenAll = new StringBuilder("(function() {");
		for (String partialPath : pathsToOpen) {
			jsOpenAll.append(
			"var folder = document.querySelector('[data-id=\"" + partialPath + "\"]');" +
			"if (folder) {" +
			"  var content = folder.querySelector('.folder-content');" +
			"  if (content) content.style.display = 'block';" +
			"}"
			);
		}
		jsOpenAll.append("})();");
		
		// Виконуємо JavaScript для відкриття папок
		webview1.loadUrl("javascript:" + jsOpenAll.toString());
		
		// Підсвічуємо останню
		webview1.loadUrl(HomePageGen.getHighlightScript(curfol));
	}
	
	
	public void _onpagefail() {
		webview1.loadUrl("file://"+getFilesDir().getPath()+"/bookmark.json");
	}
	
	
	public void _onpagestart(final String _url) {
		
	}
	
	
	public void _colorpick(final TextView _t) {
		ColorPickerDialog colorPickerDialog = new ColorPickerDialog(BookmarksActivity.this);
		colorPickerDialog.setColorPickerListener(new ColorPickerDialog.ColorPickerListener() {
			@Override
			public void onColorPicked(String colorHex) {
				_t.setText(colorHex.substring(2));
			}
		});
		try{
			colorPickerDialog.show("ff"+_t.getText().toString());
		}catch(Exception e){
			colorPickerDialog.show("ff000000");
		}
	}
	
	
	public void _ualist() {
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", "Choose");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ❖ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " • ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⬤ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◯ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⌾ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⊕ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⊙ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ❐ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⬚ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " □ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ■ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◯ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◩ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " △ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ▲ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ▷ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ▶ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ▽ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ▼ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◁ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◀ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◭ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⎊ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⎉ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⎋ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⎔ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⏣ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⌬ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⬦ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⬥ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⬨ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⬧ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◇ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𖨠 ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⬠ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⬟ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◧ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◰ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◱ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◲ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◳ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⏥ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◘ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◙ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ▤ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ▥ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ▦ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ▧ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ▨ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ▩ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ▣ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⚀ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⚁ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⚂ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⚃ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⚄ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⚅ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♔ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♕ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♖ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♘ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♗ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♙ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♚ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♛ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♜ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♝ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♞ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♟ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♡ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♢ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♤ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♧ ");
			divs.add(_item);
		}
		
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⎈ ");
			divs.add(_item);
		}
		
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⏅ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ࿊ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☥ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ྾ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ￼ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⛶ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ➤ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ➢ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ➲ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ➪ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ➫ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ➭ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ➯ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ➳ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ➟ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⇄ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⎆ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⎇ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⏚ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⏛ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𐊵 ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⎓ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⏦ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⊗ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⊘ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⊖ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⊝ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⊜ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⊛ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⌸ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⌹ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⌺ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⌻ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " シ︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ㋛︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ツ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ᧬ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⁏‐⧘ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ت ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☹︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☻︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☺︎︎ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⛑ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 〠 ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ඞ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⍢ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⍣ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⍤ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⍥ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⍨ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⍩ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☠︎︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⍦ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ྾ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⿴ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◌ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◐ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◔ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ◷ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✧ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✦ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ★ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☆ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⛤ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⛧ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⛦ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✰ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✫ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✬ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✭ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✮ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✪ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⍟ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✱ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✲ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✳ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✴ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✵ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✶ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✷ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✸ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✹ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✺ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𖣔 ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✻ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✽ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✾ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✿ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ❀ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ꕥ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𑁍 ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ᯽ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ᪥ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☾︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☽︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⛭ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☀︎︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ❂ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☄ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☁︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⛈ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𒀭 ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ❅ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ❆ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⁂ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☃︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☂︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☔︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☘︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⍚ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⎒ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⎎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⎍ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♥︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ❤︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ❣︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ❥︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ꨄ︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ❦︎ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✖ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✔ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✕ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✓ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☒ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☑ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⚠ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⚿ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☮ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☢ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ☣ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𓀀 ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♲ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♻ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♼ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ♽ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𖣘 ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ❭ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ❯ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ❱ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✄ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✁ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✂ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ✃ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ❡ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ¶ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ¤ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⌘ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ❘ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ❙ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ❚ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", "❭ ❬");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", "❯❮");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", "❱ ❰");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", "\", \"");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", "❞, ❠");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𝄞 ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𝄢 ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𝅝 ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𝅗𝅥 ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𝅘𝅥 ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𝅘𝅥𝅮 ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𝅘𝅥𝅯 ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𝅘𝅥𝅰 ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𝅘𝅥𝅱 ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𝅘𝅥𝅲 ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⌦ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⌧ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⌫ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⌨ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⌂ ");
			divs.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⌲ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⌀ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𐬺 ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𐬻 ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𐬼 ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𐬽 ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𐬾 ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " 𐬿 ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ∴ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ∵ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ∶ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ∷ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ߷ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", "⌋ ⌈");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⋰ ");
			divs.add(_item);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("ua", " ⋱ ");
			divs.add(_item);
		}
		
		/*261*/
	}
	
	
	public void _skinlegacy() {
		if (WTF.SDK_INT() < 21) {
			sf.edit().putString("cssbgblur", "0").commit();
			sf.edit().putString("cssbginvert", "0").commit();
			sf.edit().putString("cssbgcontr", "1").commit();
			sf.edit().putString("cssbgbright", "1").commit();
			sf.edit().putString("cssbgsepia", "0").commit();
			sf.edit().putString("cssbgsatur", "1").commit();
			sf.edit().putString("cssbghue", "0").commit();
			sf.edit().putString("cssbgblend", "normal").commit();
			sf.edit().putString("csstextblur", "0").commit();
			sf.edit().putString("csstextinvert", "0").commit();
			sf.edit().putString("csstextcontr", "1").commit();
			sf.edit().putString("csstextbright", "1").commit();
			sf.edit().putString("csstextsepia", "0").commit();
			sf.edit().putString("csstexthue", "0").commit();
			sf.edit().putString("csstextsatur", "1").commit();
			sf.edit().putString("csstextopacity", "1").commit();
			sf.edit().putString("csstextshadowx", "0").commit();
			sf.edit().putString("csstextshadowy", "0").commit();
			sf.edit().putString("csstextshadowb", "0").commit();
			sf.edit().putString("csstextshadowc", "FF000000").commit();
			sf.edit().putString("csstextblend", "normal").commit();
			sf.edit().putString("csstextbordersize", "0").commit();
			sf.edit().putString("csstextborderstyle", "solid").commit();
			sf.edit().putString("csstextbordercolor", "FF000000").commit();
			sf.edit().putString("csstextstrokesize", "0").commit();
			sf.edit().putString("csstextstrokecolor", "FF000000").commit();
			sf.edit().putString("cssbgstrokestyle", "solid").commit();
		}
	}
	
	public class DivvAdapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public DivvAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
			textview1.setText(_data.get((int)_position).get("ua").toString());
			textview1.setTextSize((int)25);
			
			return _view;
		}
	}
}