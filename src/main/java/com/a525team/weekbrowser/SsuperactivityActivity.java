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
import android.webkit.WebViewClient;
import android.widget.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;

public class SsuperactivityActivity extends Activity {
	
	private Timer _timer = new Timer();
	
	private String imgURL = "";
	private double type = 0;
	private String sUrl = "";
	private HashMap<String, Object> Datas = new HashMap<>();
	private String html = "";
	private boolean isblackbg = false;
	private String temp = "";
	private boolean elcode = false;
	private boolean txtpag = false;
	private boolean eltxt = false;
	private boolean hreff = false;
	private boolean pgecode = false;
	private String taid = "";
	private boolean isAd = false;
	private String buffer = "";
	ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();;
	private String largeText = "";
	
	private ArrayList<String> languag = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> Data = new ArrayList<>();
	
	private TextView textview1;
	private TextView prop;
	private LinearLayout linear3;
	private LinearLayout linear10;
	private WebView webview1;
	private LinearLayout linear8;
	private Button changbg;
	private Button third;
	private Button half;
	private Button twothird;
	private Button full;
	private ScrollView vscroll1;
	private ScrollView vscroll2;
	private LinearLayout linear1;
	private LinearLayout linear5;
	private Button topage;
	private TextView textareaid;
	private EditText txtarea;
	private Button txtready;
	private TextView a1;
	private AutoCompleteTextView img;
	private Button downloadImageButton;
	private LinearLayout linear6;
	private LinearLayout srcbuttons2;
	private Button ad;
	private TextView a2;
	private EditText href;
	private LinearLayout urlbuttons;
	private LinearLayout callbuttons;
	private LinearLayout urlbuttons2;
	private TextView a5;
	private EditText eltext;
	private LinearLayout textutils;
	private TextView a3;
	private AutoCompleteTextView elementhtml;
	private Button add;
	private Button temproarystd;
	private Button sametab;
	private Button bgtab;
	private Button copysrc;
	private Button button1;
	private Button hnew;
	private Button hthis;
	private Button hbg;
	private Button call;
	private Button sms;
	private Button copyhref;
	private Button share;
	private Button copyeltxt;
	private Button shareeltxt;
	private LinearLayout linear12;
	private Button toelem;
	private AutoCompleteTextView autocomplete1;
	private Button wayback;
	private LinearLayout linear13;
	private Button addshortcut;
	private TextView a4;
	private EditText txtpage;
	private TextView hint;
	private LinearLayout linear7;
	private LinearLayout linear4;
	private TextView a6;
	private EditText pagecode;
	private Button copyurl;
	private Button sharesite;
	private Button w30;
	private Button w120;
	private Button w240;
	private Button ab1;
	private Button ab3;
	private AutoCompleteTextView fn;
	private Button savehtml;
	
	private Intent intent = new Intent();
	private ObjectAnimator anim = new ObjectAnimator();
	private TimerTask prompttimer;
	private AlertDialog.Builder blockad;
	private Calendar dnt = Calendar.getInstance();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.ssuperactivity);
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
		        setContentView(R.layout.ssuperactivity);
		textview1 = findViewById(R.id.textview1);
		prop = findViewById(R.id.prop);
		linear3 = findViewById(R.id.linear3);
		linear10 = findViewById(R.id.linear10);
		webview1 = findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		linear8 = findViewById(R.id.linear8);
		changbg = findViewById(R.id.changbg);
		third = findViewById(R.id.third);
		half = findViewById(R.id.half);
		twothird = findViewById(R.id.twothird);
		full = findViewById(R.id.full);
		vscroll1 = findViewById(R.id.vscroll1);
		vscroll2 = findViewById(R.id.vscroll2);
		linear1 = findViewById(R.id.linear1);
		linear5 = findViewById(R.id.linear5);
		topage = findViewById(R.id.topage);
		textareaid = findViewById(R.id.textareaid);
		txtarea = findViewById(R.id.txtarea);
		txtready = findViewById(R.id.txtready);
		a1 = findViewById(R.id.a1);
		img = findViewById(R.id.img);
		downloadImageButton = findViewById(R.id.downloadImageButton);
		linear6 = findViewById(R.id.linear6);
		srcbuttons2 = findViewById(R.id.srcbuttons2);
		ad = findViewById(R.id.ad);
		a2 = findViewById(R.id.a2);
		href = findViewById(R.id.href);
		urlbuttons = findViewById(R.id.urlbuttons);
		callbuttons = findViewById(R.id.callbuttons);
		urlbuttons2 = findViewById(R.id.urlbuttons2);
		a5 = findViewById(R.id.a5);
		eltext = findViewById(R.id.eltext);
		textutils = findViewById(R.id.textutils);
		a3 = findViewById(R.id.a3);
		elementhtml = findViewById(R.id.elementhtml);
		add = findViewById(R.id.add);
		temproarystd = findViewById(R.id.temproarystd);
		sametab = findViewById(R.id.sametab);
		bgtab = findViewById(R.id.bgtab);
		copysrc = findViewById(R.id.copysrc);
		button1 = findViewById(R.id.button1);
		hnew = findViewById(R.id.hnew);
		hthis = findViewById(R.id.hthis);
		hbg = findViewById(R.id.hbg);
		call = findViewById(R.id.call);
		sms = findViewById(R.id.sms);
		copyhref = findViewById(R.id.copyhref);
		share = findViewById(R.id.share);
		copyeltxt = findViewById(R.id.copyeltxt);
		shareeltxt = findViewById(R.id.shareeltxt);
		linear12 = findViewById(R.id.linear12);
		toelem = findViewById(R.id.toelem);
		autocomplete1 = findViewById(R.id.autocomplete1);
		wayback = findViewById(R.id.wayback);
		linear13 = findViewById(R.id.linear13);
		addshortcut = findViewById(R.id.addshortcut);
		a4 = findViewById(R.id.a4);
		txtpage = findViewById(R.id.txtpage);
		hint = findViewById(R.id.hint);
		linear7 = findViewById(R.id.linear7);
		linear4 = findViewById(R.id.linear4);
		a6 = findViewById(R.id.a6);
		pagecode = findViewById(R.id.pagecode);
		copyurl = findViewById(R.id.copyurl);
		sharesite = findViewById(R.id.sharesite);
		w30 = findViewById(R.id.w30);
		w120 = findViewById(R.id.w120);
		w240 = findViewById(R.id.w240);
		ab1 = findViewById(R.id.ab1);
		ab3 = findViewById(R.id.ab3);
		fn = findViewById(R.id.fn);
		savehtml = findViewById(R.id.savehtml);
		blockad = new AlertDialog.Builder(this);
		
		prop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", prop.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Скопійовано!");
			}
		});
		
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
				if (webview1.getUrl().contains("https://chatgpt.com")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Вставте текст з буфера обміну");
				}
				webview1.evaluateJavascript("javascript:" + getJavaScript(), new android.webkit.ValueCallback<String>() {
					    @Override
					    public void onReceiveValue(String value) {
						        if (value != null && !value.equals("null")) {
							            // Видаляємо лапки з початку і кінця рядка
							            String json = value.substring(1, value.length() - 1).replace("\\\"", "\"");
							
							            try {
								                JSONObject result = new JSONObject(json);
								                StringBuilder sb = new StringBuilder();
								
								                try {
									                    switch (result.getString("type")) {
										                        case "image":
										                            try {
											                                sb.append("Format: ").append(result.getString("format")).append(" • ");
											                            } catch (Exception e) {
											                                sb.append("Format:< N/A • ");
											                            }
										                            try {
											                                sb.append("Resolution: ").append(result.getInt("width")).append("x").append(result.getInt("height")).append(" • ");
											                            } catch (Exception e) {
											                                sb.append("Resolution: N/A • ");
											                            }
										                            break;
										                        case "video":
										                            try {
											                                sb.append("Duration: ").append(result.getDouble("duration")).append(" seconds • ");
											                            } catch (Exception e) {
											                                sb.append("Duration: N/A • ");
											                            }
										                            break;
										                        case "container":
										                            try {
											                                sb.append("Number of elements: ").append(result.getInt("elements")).append(" • ");
											                            } catch (Exception e) {
											                                sb.append("Number of elements: N/A • ");
											                            }
										                            break;
										                        case "text":
										                            try {
											                                sb.append("Length: ").append(result.getInt("length")).append(" characters • ");
											                            } catch (Exception e) {
											                                sb.append("Length: N/A • ");
											                            }
										                            try {
											                                sb.append("Font: ").append(result.getString("font")).append(" • ");
											                            } catch (Exception e) {
											                                sb.append("Font: N/A • ");
											                            }
										                            break;
										                        default:
										                            sb.append("Unknown type • ");
										                            break;
										                    }
									                } catch (Exception e) {
									                    
									                }
								
								                try {
									                    sb.append("Code size: element = ").append(result.getString("size"));
									                } catch (Exception e) {
									                    sb.append("Code size: element = N/A");
									                }
								
								                prop.setText(sb.toString());
								            } catch (Exception e) {
								                prop.setText("Error parsing result");
								            }
							        } else {
							            prop.setText("No element found");
							        }
						    
						try{
							if (pagecode.getText().toString().isEmpty()) {
								prop.setText(prop.getText().toString().concat(", page = ".concat(String.valueOf(Math.round(Datas.get("wcode").toString().length() / 10.24d) / 100.d).concat("KiB"))));
							}
							else {
								prop.setText(prop.getText().toString().concat(", page = ".concat(String.valueOf(Math.round(pagecode.getText().toString().length() / 10.24d) / 100.d).concat("KiB"))));
							}
						}catch(Exception e){
							prop.setText(prop.getText().toString().concat(", page = ".concat(String.valueOf(Math.round(Datas.get("wcode").toString().length() / 10.24d) / 100.d).concat("KiB"))));
						}
					}
				});
				
				if (type == 6) {
					// Метод для виклику JavaScript-коду, який зчитує текст з текстового поля
					String jsCode = "(function() {"
					    + "var textField = document.querySelector('input[type=\"text\"], textarea', 'password');"
					    + "if (textField) {"
					    + "    var text = textField.value || textField.innerText || '';"
					    + "    return text;"
					    + "} else {"
					    + "    return 'No text field found';"
					    + "}"
					    + "})();";
					
					// Виклик JavaScript і обробка результату
					webview1.evaluateJavascript(jsCode, new ValueCallback<String>() {
						    @Override
						    public void onReceiveValue(String value) {
							        // Обробка результату (видалення зайвих лапок, які додає JS)
							        value = value.replace("\\\"", "\"");
							        value = value.substring(1, value.length()-1);
							        // Встановлення результату в текстову область
							        txtarea.setText(value);
							    }
					});
					
				}
				super.onPageFinished(_param1, _param2);
			}
		});
		
		changbg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (isblackbg) {
					webview1.loadUrl("javascript:(function() {document.body.style.backgroundColor = '#ffffff'; })();");
					isblackbg = false;
				}
				else {
					webview1.loadUrl("javascript:(function() {document.body.style.backgroundColor = '#000000'; })();");
					isblackbg = true;
				}
			}
		});
		
		//OnTouch
		third.setOnTouchListener(new View.OnTouchListener(){
				@Override
				public boolean onTouch(View v, MotionEvent event){
						int ev = event.getAction();
						switch (ev) {
								case MotionEvent.ACTION_DOWN:
								
								 LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linear3.getLayoutParams();
					
					// Змінити вагу віджета
					params.weight = 3; // Нове значення ваги
					
					// Встановити оновлені параметри вашому віджету
					linear3.setLayoutParams(params);
								
								break;
								case MotionEvent.ACTION_UP:
								
								 
								
								break;
						} return true;
				}
		});
		
		//OnTouch
		half.setOnTouchListener(new View.OnTouchListener(){
				@Override
				public boolean onTouch(View v, MotionEvent event){
						int ev = event.getAction();
						switch (ev) {
								case MotionEvent.ACTION_DOWN:
								
								 LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linear3.getLayoutParams();
					
					// Змінити вагу віджета
					params.weight = 2; // Нове значення ваги
					
					// Встановити оновлені параметри вашому віджету
					linear3.setLayoutParams(params);
								
								break;
								case MotionEvent.ACTION_UP:
								
								 
								
								break;
						} return true;
				}
		});
		
		//OnTouch
		twothird.setOnTouchListener(new View.OnTouchListener(){
				@Override
				public boolean onTouch(View v, MotionEvent event){
						int ev = event.getAction();
						switch (ev) {
								case MotionEvent.ACTION_DOWN:
								
								 LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linear3.getLayoutParams();
					
					// Змінити вагу віджета
					params.weight = 1; // Нове значення ваги
					
					// Встановити оновлені параметри вашому віджету
					linear3.setLayoutParams(params);
								
								break;
								case MotionEvent.ACTION_UP:
								
								 
								
								break;
						} return true;
				}
		});
		
		//OnTouch
		full.setOnTouchListener(new View.OnTouchListener(){
				@Override
				public boolean onTouch(View v, MotionEvent event){
						int ev = event.getAction();
						switch (ev) {
								case MotionEvent.ACTION_DOWN:
								
								 LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linear3.getLayoutParams();
					
					// Змінити вагу віджета
					params.weight = 0; // Нове значення ваги
					
					// Встановити оновлені параметри вашому віджету
					linear3.setLayoutParams(params);
								
								break;
								case MotionEvent.ACTION_UP:
								
								 
								
								break;
						} return true;
				}
		});
		
		topage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.VISIBLE);
			}
		});
		
		textareaid.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", taid));
			}
		});
		
		txtready.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/idtxt", taid);
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/txt", txtarea.getText().toString());
				finish();
			}
		});
		
		a1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (img.getVisibility() == View.VISIBLE) {
					a1.setText(getApplicationContext().getString(R.string.src) + " [▼]");
					img.setVisibility(View.GONE);
				}
				else {
					a1.setText(getApplicationContext().getString(R.string.src) + " [▲]");
					img.setVisibility(View.VISIBLE);
					anim.setTarget(img);
					anim.setPropertyName("scaleY");
					anim.setFloatValues((float)(0), (float)(1));
					anim.setDuration((int)(500));
					anim.start();
				}
			}
		});
		
		downloadImageButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (img.getText().toString().isEmpty()) {
					dnt = Calendar.getInstance();
					if (type == 10) {
						if (elementhtml.getText().toString().isEmpty()) {
							buffer = Datas.get("code").toString();
						}
						else {
							buffer = elementhtml.getText().toString();
						}
						FileUtil.writeFile(FileUtil.getPublicDir(Environment.DIRECTORY_DOWNLOADS).concat("/".concat("Vector_".concat(new SimpleDateFormat("E_ddMMyyyy_HHmmss").format(dnt.getTime())).concat(".svg"))), buffer);
						SketchwareUtil.showMessage(getApplicationContext(), "Завантаження векторного зображення в SVG...");
					}
					else {
						if (((type > 1) && (type < 3)) || (type == 13)) {
							if (elementhtml.getText().toString().isEmpty()) {
								buffer = Datas.get("code").toString();
							}
							else {
								buffer = elementhtml.getText().toString();
							}
							FileUtil.writeFile(FileUtil.getPublicDir(Environment.DIRECTORY_DOWNLOADS).concat("/".concat("Webpart_".concat(new SimpleDateFormat("E_ddMMyyyy_HHmmss").format(dnt.getTime())).concat(".html"))), buffer);
							SketchwareUtil.showMessage(getApplicationContext(), "Завантаження частини макета сайту в HTML...");
						}
						else {
							if (((type > 4) && (type < 6)) || (type == 14)) {
								if (eltext.getText().toString().isEmpty()) {
									buffer = Datas.get("text").toString();
								}
								else {
									buffer = eltext.getText().toString();
								}
								FileUtil.writeFile(FileUtil.getPublicDir(Environment.DIRECTORY_DOWNLOADS).concat("/".concat("Text_".concat(new SimpleDateFormat("E_ddMMyyyy_HHmmss").format(dnt.getTime())).concat(".txt"))), buffer);
								SketchwareUtil.showMessage(getApplicationContext(), "Завантаження тексту в TXT...");
							}
							else {
								
							}
						}
					}
				}
				else {
					if (img.getText().toString().isEmpty()) {
						buffer = Datas.get("src").toString();
					}
					else {
						buffer = img.getText().toString();
					}
					        if (buffer != null && !buffer.isEmpty()) {
						            if (buffer.startsWith("http://") || buffer.startsWith("https://")) {
							                // Якщо посилання починається з http(s), завантажуємо як є
							                String fileName;
							                int lastSlashIndex = buffer.lastIndexOf('/');
							                int lastDotIndex = buffer.lastIndexOf('.');
							                
							                if (lastDotIndex < lastSlashIndex) {
								                    // Якщо немає крапки після останнього слешу, додаємо розширення ".jpg"
								                    fileName = buffer.substring(lastSlashIndex + 1) + ".jpg";
								                } else {
								                    // Використовуємо розширення файлу з URL
								                    fileName = buffer.substring(lastSlashIndex + 1);
								                }
							
							                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(buffer));
							                request.setMimeType("*");
							                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
							
							                DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
							                downloadManager.enqueue(request);
							
							                Toast.makeText(getApplicationContext(), "Завантаження елементу...", Toast.LENGTH_LONG).show();
							            } else if (buffer.startsWith("data:")) {
							                // Розшифрування base64 та збереження у Download
							                String[] parts = buffer.split(",");
							                if (parts.length > 1) {
								                    String base64Data = parts[1];
								                    byte[] decodedBytes = android.util.Base64.decode(base64Data, android.util.Base64.DEFAULT);
								
								                    String mimeType = parts[0].split(";")[0].split(":")[1];
								                    String format = mimeType.substring(mimeType.lastIndexOf('/') + 1);
								
								                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
								                    String currentDateAndTime = sdf.format(new Date());
								
								                    String fileName = "download_" + currentDateAndTime + "." + format;
								
								                    File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
								                    File imageFile = new File(downloadsDir, fileName);
								
								                    try {
									                        FileOutputStream fos = new FileOutputStream(imageFile);
									                        fos.write(decodedBytes);
									                        fos.close();
									                        Toast.makeText(getApplicationContext(), "Елемент збережено у Download", Toast.LENGTH_LONG).show();
									                    } catch (IOException e) {
									                        e.printStackTrace();
									                        Toast.makeText(getApplicationContext(), "Помилка при збереженні елементу", Toast.LENGTH_SHORT).show();
									                    }
								                }
							            } else {
							                // Якщо посилання не підтримується
							                Toast.makeText(getApplicationContext(), "Непідтримуване посилання", Toast.LENGTH_SHORT).show();
							            }
						        } else {
						            Toast.makeText(getApplicationContext(), "Посилання на елемент відсутнє", Toast.LENGTH_SHORT).show();
						        }
					
				}
			}
		});
		
		ad.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (isAd) {
					for (int h = 0; h < (int)(FileUtils.getFileLines("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt")); h++) {
						if (Datas.get("src").toString().matches(".*".concat(FileUtils.readLinesFromFile("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt", h).concat(".*")))) {
							FileUtils.removeLineFromFile("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt", h);
							SketchwareUtil.showMessage(getApplicationContext(), "Тепер цей елемент не блокуватиметься");
							if (isNotNullOrEmpty(Datas, "src")) {
								for (int i = 0; i < FileUtils.getFileLines("/storage/emulated/0/WeekBrowser/Blockad/domains.txt"); i++) {
									    String line = FileUtils.readLinesFromFile("/storage/emulated/0/WeekBrowser/Blockad/domains.txt", i);
									    if (line != null) {
										        line = line.replace("\\.", ".");
										        if (!line.isEmpty() && !line.startsWith("//") && !line.startsWith("#")) {
											            if (line.toLowerCase().startsWith("%")) {
												                if (Datas.get("src").toString().matches(".*" + line.substring(1) + ".*")) {
													                    ad.setVisibility(View.GONE);
													                    break;
													                }
												            } else {
												                if (_extractDomain(Datas.get("src").toString()).matches(".*" + line + ".*")) {
													                    ad.setVisibility(View.GONE);
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
											            if (line.toLowerCase().startsWith("%")) {
												                if (Datas.get("src").toString().matches(".*" + line.substring(1) + ".*")) {
													                    isAd = true;
													                    ad.setText("ЦЕ НЕ РЕКЛАМА?");
													                    break;
													                }
												            } else {
												                if (_extractDomain(Datas.get("src").toString()).matches(".*" + line + ".*")) {
													                    isAd = true;
													                    ad.setText("ЦЕ НЕ РЕКЛАМА?");
													                    break;
													                }
												            }
											        }
										    } else {
										        Log.e("ReadLineError", "Failed to read line " + i + " from userdomains.txt");
										       
										    }
								}
								
							}
							else {
								ad.setVisibility(View.GONE);
							}
						}
					}
				}
				else {
					blockad.setTitle("ЩО БЛОКУВАТИ?");
					blockad.setMessage("Оберіть найкращий варіант для блокування реклами.\n\nВиберіть варіант 1, щоб блокувати все з цим доменом\n".concat(_extractDomain(Datas.get("src").toString())).concat("\n,\n або \"Варіант 2\", щоб блокувати лише ось цю адресу: \n".concat(Datas.get("src").toString())));
					blockad.setPositiveButton("[    1    ]", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt").concat("\n".concat(_extractDomain(Datas.get("src").toString()).replace(".", "\\."))));
							if (isNotNullOrEmpty(Datas, "src")) {
								for (int i = 0; i < FileUtils.getFileLines("/storage/emulated/0/WeekBrowser/Blockad/domains.txt"); i++) {
									    String line = FileUtils.readLinesFromFile("/storage/emulated/0/WeekBrowser/Blockad/domains.txt", i);
									    if (line != null) {
										        line = line.replace("\\.", ".");
										        if (!line.isEmpty() && !line.startsWith("//") && !line.startsWith("#")) {
											            if (Datas.get("src").toString().toLowerCase().startsWith("%")) {
												                if (Datas.get("src").toString().matches(".*" + line.substring(1) + ".*")) {
													                    ad.setVisibility(View.GONE);
													                    break;
													                }
												            } else {
												                if (_extractDomain(Datas.get("src").toString()).matches(".*" + line + ".*")) {
													                    ad.setVisibility(View.GONE);
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
											            if (Datas.get("src").toString().toLowerCase().startsWith("%")) {
												                if (Datas.get("src").toString().matches(".*" + line.substring(1) + ".*")) {
													                    isAd = true;
													                    ad.setText("ЦЕ НЕ РЕКЛАМА?");
													                    break;
													                }
												            } else {
												                if (_extractDomain(Datas.get("src").toString()).matches(".*" + line + ".*")) {
													                    isAd = true;
													                    ad.setText("ЦЕ НЕ РЕКЛАМА?");
													                    break;
													                }
												            }
											        }
										    } else {
										        Log.e("ReadLineError", "Failed to read line " + i + " from userdomains.txt");
										       
										    }
								}
								
							}
							else {
								ad.setVisibility(View.GONE);
							}
							MyWebViewClient webViewClient = new MyWebViewClient(SsuperactivityActivity.this); // Створення екземпляру класу
							webViewClient.updateBlockedHosts(); // Виклик методу на екземплярі
						}
					});
					blockad.setNegativeButton("[    2    ]", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt").concat("\n%".concat(Datas.get("src").toString().replace(".", "\\."))));
							if (isNotNullOrEmpty(Datas, "src")) {
								for (int i = 0; i < FileUtils.getFileLines("/storage/emulated/0/WeekBrowser/Blockad/domains.txt"); i++) {
									    String line = FileUtils.readLinesFromFile("/storage/emulated/0/WeekBrowser/Blockad/domains.txt", i);
									    if (line != null) {
										        line = line.replace("\\.", ".");
										        if (!line.isEmpty() && !line.startsWith("//") && !line.startsWith("#")) {
											            if (Datas.get("src").toString().toLowerCase().startsWith("%")) {
												                if (Datas.get("src").toString().matches(".*" + line.substring(1) + ".*")) {
													                    ad.setVisibility(View.GONE);
													                    break;
													                }
												            } else {
												                if (_extractDomain(Datas.get("src").toString()).matches(".*" + line + ".*")) {
													                    ad.setVisibility(View.GONE);
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
											            if (Datas.get("src").toString().toLowerCase().startsWith("%")) {
												                if (Datas.get("src").toString().matches(".*" + line.substring(1) + ".*")) {
													                    isAd = true;
													                    ad.setText("ЦЕ НЕ РЕКЛАМА?");
													                    break;
													                }
												            } else {
												                if (_extractDomain(Datas.get("src").toString()).matches(".*" + line + ".*")) {
													                    isAd = true;
													                    ad.setText("ЦЕ НЕ РЕКЛАМА?");
													                    break;
													                }
												            }
											        }
										    } else {
										        Log.e("ReadLineError", "Failed to read line " + i + " from userdomains.txt");
										       
										    }
								}
								
							}
							else {
								ad.setVisibility(View.GONE);
							}
							MyWebViewClient webViewClient = new MyWebViewClient(SsuperactivityActivity.this); // Створення екземпляру класу
							webViewClient.updateBlockedHosts(); // Виклик методу на екземплярі
						}
					});
					blockad.setNeutralButton("Скасувати", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					blockad.create().show();
				}
			}
		});
		
		a2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (href.getVisibility() == View.VISIBLE) {
					href.setVisibility(View.GONE);
					a2.setText(getApplicationContext().getString(R.string.href) + " [▼]");
				}
				else {
					href.setVisibility(View.VISIBLE);
					a2.setText(getApplicationContext().getString(R.string.href) + " [▲]");
					if (!hreff) {
						try{
							href.setText(Datas.get("href").toString());
							hreff = true;
						}catch(Exception e){
							 
						}
					}
					anim.setTarget(href);
					anim.setPropertyName("scaleY");
					anim.setFloatValues((float)(0), (float)(1));
					anim.setDuration((int)(500));
					anim.start();
				}
			}
		});
		
		a5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (eltext.getVisibility() == View.VISIBLE) {
					eltext.setVisibility(View.GONE);
					a5.setText(getApplicationContext().getString(R.string.eltext) + " [▼]");
				}
				else {
					eltext.setVisibility(View.VISIBLE);
					a5.setText(getApplicationContext().getString(R.string.eltext) + " [▲]");
					if (!eltxt) {
						try{
							eltext.setText(Datas.get("text").toString());
							eltxt = true;
						}catch(Exception e){
							 
						}
					}
					anim.setTarget(eltext);
					anim.setPropertyName("scaleY");
					anim.setFloatValues((float)(0), (float)(1));
					anim.setDuration((int)(500));
					anim.start();
				}
			}
		});
		
		a3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (elementhtml.getVisibility() == View.VISIBLE) {
					elementhtml.setVisibility(View.GONE);
					add.setVisibility(View.GONE);
					a3.setText(getApplicationContext().getString(R.string.elcode) + " [▼]");
				}
				else {
					elementhtml.setVisibility(View.VISIBLE);
					add.setVisibility(View.VISIBLE);
					a3.setText(getApplicationContext().getString(R.string.elcode) + " [▲]");
					if (!elcode) {
						try{
							elementhtml.setText(_correctelHTML());
							elcode = true;
						}catch(Exception e){
							 
						}
					}
					anim.setTarget(elementhtml);
					anim.setPropertyName("scaleY");
					anim.setFloatValues((float)(0), (float)(1));
					anim.setDuration((int)(500));
					anim.start();
				}
			}
		});
		
		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.loadDataWithBaseURL(getIntent().getStringExtra("url"), elementhtml.getText().toString(), "text/html", "UTF-8", null);
				_getType(elementhtml.getText().toString());
			}
		});
		
		temproarystd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try{
					if (img.getText().toString().isEmpty()) {
						buffer = Datas.get("src").toString();
					}
					else {
						buffer = img.getText().toString();
					}
					intent.setClass(getApplicationContext(), MainActivity.class);
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/url", buffer);
					startActivity(intent);
					finish();
				}catch(Exception e){
					SketchwareUtil.showMessage(getApplicationContext(), "ПОМИЛКА!");
					FileUtil.deleteFile("/storage/emulated/0/WeekBrowser/sametab");
					FileUtil.deleteFile("/storage/emulated/0/WeekBrowser/bgtab");
				}
			}
		});
		
		sametab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/sametab", "");
				temproarystd.performClick();
			}
		});
		
		bgtab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/bgtab", "");
				temproarystd.performClick();
			}
		});
		
		copysrc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (img.getText().toString().isEmpty()) {
					buffer = Datas.get("src").toString();
				}
				else {
					buffer = img.getText().toString();
				}
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", buffer));
				SketchwareUtil.showMessage(getApplicationContext(), "Скопійовано");
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_SEND);
				intent.setType("text/plain");
				if (eltext.getText().toString().isEmpty()) {
					buffer = Datas.get("src").toString();
				}
				else {
					buffer = img.getText().toString();
				}
				intent.putExtra(Intent.EXTRA_TEXT, buffer);
				startActivity(Intent.createChooser(intent, "Поділитися в..."));
			}
		});
		
		hnew.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (href.getText().toString().isEmpty()) {
					buffer = Datas.get("href").toString();
				}
				else {
					buffer = href.getText().toString();
				}
				intent.setClass(getApplicationContext(), MainActivity.class);
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/url", buffer);
				startActivity(intent);
				finish();
			}
		});
		
		hthis.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/sametab", "");
				hnew.performClick();
			}
		});
		
		hbg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/bgtab", "");
				hnew.performClick();
			}
		});
		
		call.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (href.getText().toString().isEmpty()) {
					buffer = Datas.get("href").toString();
				}
				else {
					buffer = href.getText().toString();
				}
				intent.setAction(Intent.ACTION_DIAL);
				intent.setData(Uri.parse(buffer));
				startActivity(Intent.createChooser(intent, "Виберіть номеронабирач"));
			}
		});
		
		sms.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (href.getText().toString().isEmpty()) {
					buffer = Datas.get("href").toString();
				}
				else {
					buffer = href.getText().toString();
				}
				intent.setAction(Intent.ACTION_SENDTO);
				intent.setData(Uri.parse(buffer));
				startActivity(Intent.createChooser(intent, "Виберіть програму для відправки SMS"));
			}
		});
		
		copyhref.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (href.getText().toString().isEmpty()) {
					buffer = Datas.get("href").toString();
				}
				else {
					buffer = href.getText().toString();
				}
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", buffer));
				SketchwareUtil.showMessage(getApplicationContext(), "Скопійовано");
			}
		});
		
		share.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (href.getText().toString().isEmpty()) {
					buffer = Datas.get("href").toString();
				}
				else {
					buffer = href.getText().toString();
				}
				intent.setAction(Intent.ACTION_SEND);
				intent.setType("text/plain");
				if (buffer.toLowerCase().startsWith("tel")) {
					temp = buffer.replace("%23", "#").replace("tel:", "");
					intent.putExtra(Intent.EXTRA_TEXT, temp);
				}
				else {
					intent.putExtra(Intent.EXTRA_TEXT, buffer);
				}
				startActivity(Intent.createChooser(intent, "Поділитися в..."));
			}
		});
		
		copyeltxt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (eltext.getText().toString().isEmpty()) {
					buffer = Datas.get("text").toString();
				}
				else {
					buffer = eltext.getText().toString();
				}
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", buffer));
				SketchwareUtil.showMessage(getApplicationContext(), "Скопійовано");
			}
		});
		
		shareeltxt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (eltext.getText().toString().isEmpty()) {
					buffer = Datas.get("text").toString();
				}
				else {
					buffer = eltext.getText().toString();
				}
				intent.setAction(Intent.ACTION_SEND);
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_TEXT, buffer);
				startActivity(Intent.createChooser(intent, "Поділитися в..."));
			}
		});
		
		toelem.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll2.setVisibility(View.GONE);
				vscroll1.setVisibility(View.VISIBLE);
			}
		});
		
		wayback.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), IntentActivity.class);
				if (autocomplete1.getText().toString().isEmpty()) {
					buffer = Datas.get("url").toString();
				}
				else {
					buffer = autocomplete1.getText().toString();
				}
				intent.setData(Uri.parse("https://web.archive.org/web/".concat(buffer)));
				startActivity(intent);
				finish();
			}
		});
		
		addshortcut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ShortcutActivity.class);
				intent.putExtra("name", Datas.get("title").toString());
				intent.putExtra("url", Datas.get("url").toString());
				startActivity(intent);
			}
		});
		
		a4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (txtpage.getVisibility() == View.VISIBLE) {
					txtpage.setVisibility(View.GONE);
					a4.setText(getApplicationContext().getString(R.string.wtext) + " [▼]");
				}
				else {
					txtpage.setVisibility(View.VISIBLE);
					a4.setText(getApplicationContext().getString(R.string.wtext) + " [▲]");
					if (!txtpag) {
						try{
							txtpage.setText(Datas.get("wtext").toString());
							txtpag = true;
						}catch(Exception e){
							 
						}
					}
					anim.setTarget(txtpage);
					anim.setPropertyName("scaleY");
					anim.setFloatValues((float)(0), (float)(1));
					anim.setDuration((int)(500));
					anim.start();
				}
			}
		});
		
		a6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (pagecode.getVisibility() == View.VISIBLE) {
					pagecode.setVisibility(View.GONE);
					a6.setText(getApplicationContext().getString(R.string.wcode) + " [▼]");
				}
				else {
					pagecode.setVisibility(View.VISIBLE);
					a6.setText(getApplicationContext().getString(R.string.wcode) + " [▲]");
					if (!pgecode) {
						try{
							pagecode.setText(Datas.get("wcode").toString());
							pgecode = true;
						}catch(Exception e){
							 
						}
					}
					anim.setTarget(pagecode);
					anim.setPropertyName("scaleY");
					anim.setFloatValues((float)(0), (float)(1));
					anim.setDuration((int)(500));
					anim.start();
				}
			}
		});
		
		copyurl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (autocomplete1.getText().toString().isEmpty()) {
					buffer = Datas.get("url").toString();
				}
				else {
					buffer = autocomplete1.getText().toString();
				}
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", buffer));
				SketchwareUtil.showMessage(getApplicationContext(), "Скопійовано");
			}
		});
		
		sharesite.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_SEND);
				intent.setType("text/plain");
				if (autocomplete1.getText().toString().isEmpty()) {
					buffer = Datas.get("url").toString();
				}
				else {
					buffer = autocomplete1.getText().toString();
				}
				intent.putExtra(Intent.EXTRA_TEXT, buffer);
				startActivity(Intent.createChooser(intent, "Поділитися в..."));
			}
		});
		
		w30.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (txtpage.getText().toString().isEmpty()) {
					buffer = Datas.get("wtext").toString();
				}
				else {
					buffer = txtpage.getText().toString();
				}
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "Please, simplify text to 30 words on same language as text. Text:  ".concat(buffer)));
				webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
				webview1.setVisibility(View.VISIBLE);
				linear3.setVisibility(View.VISIBLE);
				webview1.loadUrl("https://chat.openai.com");
				LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linear3.getLayoutParams();
				
				// Змінити вагу віджета
				params.weight = 1; // Нове значення ваги
				
				// Встановити оновлені параметри вашому віджету
				linear3.setLayoutParams(params);
			}
		});
		
		w120.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (txtpage.getText().toString().isEmpty()) {
					buffer = Datas.get("wtext").toString();
				}
				else {
					buffer = txtpage.getText().toString();
				}
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "Please, simplify text to 120 words on same language as text. Text:  ".concat(buffer)));
				webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
				webview1.setVisibility(View.VISIBLE);
				linear3.setVisibility(View.VISIBLE);
				webview1.loadUrl("https://chat.openai.com");
				LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linear3.getLayoutParams();
				
				// Змінити вагу віджета
				params.weight = 1; // Нове значення ваги
				
				// Встановити оновлені параметри вашому віджету
				linear3.setLayoutParams(params);
			}
		});
		
		w240.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (txtpage.getText().toString().isEmpty()) {
					buffer = Datas.get("wtext").toString();
				}
				else {
					buffer = txtpage.getText().toString();
				}
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "Please, simplify text to 240 words on same language as text. Text:  ".concat(buffer)));
				webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
				webview1.setVisibility(View.VISIBLE);
				linear3.setVisibility(View.VISIBLE);
				webview1.loadUrl("https://chat.openai.com");
				LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linear3.getLayoutParams();
				
				// Змінити вагу віджета
				params.weight = 1; // Нове значення ваги
				
				// Встановити оновлені параметри вашому віджету
				linear3.setLayoutParams(params);
			}
		});
		
		ab1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (txtpage.getText().toString().isEmpty()) {
					buffer = Datas.get("wtext").toString();
				}
				else {
					buffer = txtpage.getText().toString();
				}
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "Please, simplify text to 1 paragraph on same language as text. Text: ".concat(buffer)));
				webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
				webview1.setVisibility(View.VISIBLE);
				linear3.setVisibility(View.VISIBLE);
				webview1.loadUrl("https://chat.openai.com");
				LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linear3.getLayoutParams();
				
				// Змінити вагу віджета
				params.weight = 1; // Нове значення ваги
				
				// Встановити оновлені параметри вашому віджету
				linear3.setLayoutParams(params);
			}
		});
		
		ab3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (txtpage.getText().toString().isEmpty()) {
					buffer = Datas.get("wtext").toString();
				}
				else {
					buffer = txtpage.getText().toString();
				}
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "Please, simplify text to 3 paragraphs on same language as text. Text:  ".concat(buffer)));
				webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
				webview1.setVisibility(View.VISIBLE);
				linear3.setVisibility(View.VISIBLE);
				webview1.loadUrl("https://chat.openai.com");
				LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linear3.getLayoutParams();
				
				// Змінити вагу віджета
				params.weight = 1; // Нове значення ваги
				
				// Встановити оновлені параметри вашому віджету
				linear3.setLayoutParams(params);
			}
		});
		
		savehtml.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (pagecode.getText().toString().isEmpty()) {
					buffer = Datas.get("wcode").toString();
				}
				else {
					buffer = pagecode.getText().toString();
				}
				FileUtil.writeFile(FileUtil.getPublicDir(Environment.DIRECTORY_DOWNLOADS).concat("/".concat(fn.getText().toString().concat(".html"))).replace("//", "/"), buffer);
				SketchwareUtil.showMessage(getApplicationContext(), "Сайт завантажено!");
			}
		});
	}
	
	private void initializeLogic() {
		changbg.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		vscroll2.setVisibility(View.GONE);
		a1.setText(getString(R.string.src) + " [▼]");
		a2.setText(getString(R.string.href) + " [▼]");
		a5.setText(getString(R.string.eltext) + " [▼]");
		a3.setText(getString(R.string.elcode) + " [▼]");
		a4.setText(getString(R.string.wtext) + " [▼]");
		a6.setText(getString(R.string.wcode) + " [▼]");
		w30.setText("30 " + getString(R.string.words));
		w120.setText("120 " + getString(R.string.words));
		w240.setText("240 " + getString(R.string.words));
		ab1.setText("1 " + getString(R.string.paragraphs));
		ab3.setText("3 " + getString(R.string.paragraphs));
		try{
			Datas = new Gson().fromJson(DataHolder.getInstance().getData(), new TypeToken<HashMap<String, Object>>(){}.getType());
			try{
				Datas.put("code", Datas.get("code").toString().replace("<button style=\"position: absolute; bottom: -25.2705px; right: 10.2005px; background-color: rgb(0, 255, 255); color: rgb(0, 0, 0); padding: 10px; font-size: 16px; cursor: pointer; z-index: 9999999;\">[]↗</button>", "").replaceAll("<button style=\"position: fixed; top: .*px; left: .*px; z-index: 99999999; background: lime; color: black; padding: 10\\.2705px; font-size: 16px;\">[[F]]</button>", "").replaceAll("<button style=\"position: fixed; top: .*px; left: .*px; z-index: 99999999; background: yellow; color: black; padding: 10\\.2705px; font-size: 16px;\">[S]</button>", ""));
			}catch(Exception e){
				 
			}
			try{
				Datas.put("wcode", Datas.get("wcode").toString().replace("<button style=\"position: absolute; bottom: -25.2705px; right: 10.2005px; background-color: rgb(0, 255, 255); color: rgb(0, 0, 0); padding: 10px; font-size: 16px; cursor: pointer; z-index: 9999999;\">[]↗</button>", "").replaceAll("<button style=\"position: fixed; top: .*px; left: .*px; z-index: 99999999; background: lime; color: black; padding: 10\\.2705px; font-size: 16px;\">[[F]]</button>", "").replaceAll("<button style=\"position: fixed; top: .*px; left: .*px; z-index: 99999999; background: yellow; color: black; padding: 10\\.2705px; font-size: 16px;\">[S]</button>", ""));
			}catch(Exception e){
				 
			}
			try{
				Datas.put("text", Datas.get("text").toString().replace("[S]", "").replace("[[F]]", "").replace("[]↗", ""));
			}catch(Exception e){
				 
			}
			try{
				Datas.put("wtext", Datas.get("wtext").toString().replace("[S]", "").replace("[[F]]", "").replace("[]↗", ""));
			}catch(Exception e){
				 
			}
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				languag = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Language.welang"), new TypeToken<ArrayList<String>>(){}.getType());
			}
			_language();
			_getType(Datas.get("type").toString());
			try{
				img.setText(Datas.get("src").toString());
			}catch(Exception e){
				 
			}
			webview1.setLayerType(View.LAYER_TYPE_HARDWARE, null);webview1.getSettings().setBuiltInZoomControls(true);
			webview1.getSettings().setDisplayZoomControls(false);if(Integer.parseInt(Build.VERSION.SDK)>=20){webview1.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);}
			webview1.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
			webview1.getSettings().setSaveFormData(true);
			webview1.getSettings().setAllowFileAccess(true);
			webview1.getSettings().setAllowContentAccess(true);
			webview1.getSettings().setDatabaseEnabled(true);
			webview1.getSettings().setDomStorageEnabled(true);
			
			webview1.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY);
			try{
				webview1.loadDataWithBaseURL(getIntent().getStringExtra("url"), _correctelHTML(), "text/html", "UTF-8", null);
			}catch(Exception e){
				 
			}
			try{
				 
			}catch(Exception e){
				 
			}
			try{
				taid = Datas.get("taid").toString();
				textareaid.setText("ID: ".concat(taid));
			}catch(Exception e){
				 
			}
			try{
				elementhtml.setVisibility(View.GONE);
				img.setVisibility(View.GONE);
				href.setVisibility(View.GONE);
				add.setVisibility(View.GONE);
				txtpage.setVisibility(View.GONE);
				eltext.setVisibility(View.GONE);
				pagecode.setVisibility(View.GONE);
				sUrl = Datas.get("url").toString().replace("//", "/");
				fn.setText(sUrl);
				autocomplete1.setText(Datas.get("url").toString());
			}catch(Exception e){
				 
			}
			if (!isNotNullOrEmpty(Datas, "text")||type==6) {
				a5.setVisibility(View.GONE);
				textutils.setVisibility(View.GONE);
			}
			if (!isNotNullOrEmpty(Datas, "src")) {
				a1.setVisibility(View.GONE);
				linear6.setVisibility(View.GONE);
				srcbuttons2.setVisibility(View.GONE);
				img.setVisibility(View.GONE);
			}
			if (!isNotNullOrEmpty(Datas, "href")) {
				a2.setVisibility(View.GONE);
				urlbuttons.setVisibility(View.GONE);
				urlbuttons2.setVisibility(View.GONE);
				callbuttons.setVisibility(View.GONE);
			}
			else {
				if (Datas.get("href").toString().toLowerCase().startsWith("http")) {
					callbuttons.setVisibility(View.GONE);
				}
				else {
					if (Datas.get("href").toString().toLowerCase().startsWith("tel")) {
						urlbuttons.setVisibility(View.GONE);
					}
					else {
						if (Datas.get("href").toString().toLowerCase().startsWith("javascript")) {
							callbuttons.setVisibility(View.GONE);
							urlbuttons.setVisibility(View.GONE);
						}
						else {
							
						}
					}
				}
			}
			if (!isNotNullOrEmpty(Datas, "src") && !(((((type == 1) || (type == 2)) || (type == 3)) || ((type == 4) || ((type == 5) || (type == 6)))) || ((type == 10) || ((type == 13) || (type == 14))))) {
				downloadImageButton.setVisibility(View.GONE);
			}
			if (!(type == 6)) {
				textareaid.setVisibility(View.GONE);
				txtarea.setVisibility(View.GONE);
				txtready.setVisibility(View.GONE);
			}
			if (isNotNullOrEmpty(Datas, "src")) {
				for (int i = 0; i < FileUtils.getFileLines("/storage/emulated/0/WeekBrowser/Blockad/domains.txt"); i++) {
					    String line = FileUtils.readLinesFromFile("/storage/emulated/0/WeekBrowser/Blockad/domains.txt", i);
					    if (line != null) {
						        line = line.replace("\\.", ".");
						        if (!line.isEmpty() && !line.startsWith("//") && !line.startsWith("#")) {
							            if (Datas.get("src").toString().toLowerCase().startsWith("%")) {
								                if (Datas.get("src").toString().matches(".*" + line.substring(1) + ".*")) {
									                    ad.setVisibility(View.GONE);
									                    break;
									                }
								            } else {
								                if (_extractDomain(Datas.get("src").toString()).matches(".*" + line + ".*")) {
									                    ad.setVisibility(View.GONE);
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
							            if (Datas.get("src").toString().toLowerCase().startsWith("%")) {
								                if (Datas.get("src").toString().matches(".*" + line.substring(1) + ".*")) {
									                    isAd = true;
									                    ad.setText(getString(R.string.is_not_ad));
									                    break;
									                }
								            } else {
								                if (_extractDomain(Datas.get("src").toString()).matches(".*" + line + ".*")) {
									                    isAd = true;
									                    ad.setText(getString(R.string.is_not_ad));
									                    break;
									                }
								            }
							        }
						    } else {
						        Log.e("ReadLineError", "Failed to read line " + i + " from userdomains.txt");
						       
						    }
				}
				
			}
			else {
				ad.setVisibility(View.GONE);
			}
		}catch(Exception e){
			 
		}
		_onscroll(vscroll1);
		_onscroll(vscroll2);
	}
	
	
	@Override
	public void onResume() {
		super.onResume();
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		Skin skin = new Skin();
		
		skin.setBG(getWindow().getDecorView(), 2, false);
		
		
		textview1.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		textareaid.setTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		hint.setTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		txtarea.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		href.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		txtpage.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		pagecode.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		img.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		fn.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		autocomplete1.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		elementhtml.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		eltext.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		a1.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		a2.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		a3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		a4.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		a5.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		a6.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		prop.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		
					img.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		txtpage.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		pagecode.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		txtarea.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		href.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		autocomplete1.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		fn.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		elementhtml.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		eltext.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
					downloadImageButton.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		savehtml.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		wayback.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		txtready.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		sametab.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		bgtab.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		addshortcut.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					temproarystd.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		call.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		sms.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		share.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		sharesite.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		
		third.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		half.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		twothird.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		full.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		add.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		
		w30.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		w120.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		w240.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		ab1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		ab3.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		changbg.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		button1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		hnew.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		hthis.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		hbg.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		copyeltxt.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		shareeltxt.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		topage.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		toelem.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		ad.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		copyurl.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		copysrc.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		copyhref.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		skin.setBG(downloadImageButton, 0, false);
		skin.setBG(add, 0, false);
		skin.setBG(savehtml, 0, false);
		skin.setBG(wayback, 0, false);
		skin.setBG(temproarystd, 0, false);
		skin.setBG(call, 0, false);
		skin.setBG(sms, 0, false);
		skin.setBG(share, 0, false);
		skin.setBG(sharesite, 0, false);
		skin.setBG(txtready, 0, false);
		skin.setBG(sametab, 0, false);
		skin.setBG(bgtab, 0, false);
		
		skin.setBG(third, 0, false);
		skin.setBG(half, 0, false);
		skin.setBG(twothird, 0, false);
		skin.setBG(full, 0, false);
		
		skin.setBG(w30, 0, false);
		skin.setBG(w120, 0, false);
		skin.setBG(w240, 0, false);
		skin.setBG(ab1, 0, false);
		skin.setBG(ab3, 0, false);
		
		skin.setBG(changbg, 1, false);
		skin.setBG(button1, 0, false);
		
		skin.setBG(hnew, 0, false);
		skin.setBG(hthis, 0, false);
		skin.setBG(hbg, 0, false);
		skin.setBG(copyeltxt, 0, false);
		skin.setBG(shareeltxt, 0, false);
		
		skin.setBG(topage, 1, false);
		skin.setBG(toelem, 1, false);
		skin.setBG(ad, 1, false);
		skin.setBG(copyurl, 0, false);
		skin.setBG(copysrc, 0, false);
		skin.setBG(copyhref, 0, false);
		skin.setBG(addshortcut, 0, false);
		
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/monofortextarea.txt").equals("1")) {
			autocomplete1.setTypeface(Typeface.MONOSPACE);
			txtarea.setTypeface(Typeface.MONOSPACE);
			img.setTypeface(Typeface.MONOSPACE);
			elementhtml.setTypeface(Typeface.MONOSPACE);
			fn.setTypeface(Typeface.MONOSPACE);
			txtpage.setTypeface(Typeface.MONOSPACE);
			href.setTypeface(Typeface.MONOSPACE);
			eltext.setTypeface(Typeface.MONOSPACE);
			pagecode.setTypeface(Typeface.MONOSPACE);
		}
		else {
			autocomplete1.setTypeface(Typeface.DEFAULT);
			txtarea.setTypeface(Typeface.DEFAULT);
			img.setTypeface(Typeface.DEFAULT);
			elementhtml.setTypeface(Typeface.DEFAULT);
			fn.setTypeface(Typeface.DEFAULT);
			txtpage.setTypeface(Typeface.DEFAULT);
			href.setTypeface(Typeface.DEFAULT);
			eltext.setTypeface(Typeface.DEFAULT);
			pagecode.setTypeface(Typeface.DEFAULT);
		}
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		webview1.saveState(outState);
		super.onSaveInstanceState(outState);
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		if (savedInstanceState != null) {
			            webview1.restoreState(savedInstanceState);
			        } else {
			            webview1.loadDataWithBaseURL(getIntent().getStringExtra("url"), elementhtml.getText().toString(), "text/html", "UTF-8", null);
			        }
		super.onRestoreInstanceState(savedInstanceState);
	}
	
	    public void onLowMemory() {
		        super.onLowMemory();
		        finish();
		        }
	public boolean _isNull(final String _v) {
		try{
			if(_v==null)return true; else return false;
		}catch(Exception e){
			return (true);
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
	
	
	public String _correctelHTML() {
		html = Datas.get("code").toString();
		if (!Datas.get("src").toString().isEmpty()) {
			html = html.replaceFirst("src=\".*\"", "src=\"".concat(Datas.get("src").toString().concat("\"")));
		}
		if (!Datas.get("href").toString().isEmpty()) {
			html = "<a href=\"".concat(Datas.get("href").toString().concat("\">")).concat(html.concat("</a>"));
		}
		return (html);
	}
	
	
	public void _extra() {
	}
	public boolean isNotNullOrEmpty(Map<String, Object> datas, String key) {
		    try {
			        Object value = datas.get(key);
			        if (value != null) {
				            String text = value.toString();
				            return !text.isEmpty();
				        } else {
				            return false;
				        }
			    } catch (Exception e) {
			        // Ловимо будь-які винятки і вважаємо значення недійсним
			        return false;
			    }
	}
	
	private String getJavaScript() {
		    return "(function() {"
		            + "var element = document.querySelector('body > *');"
		            + "var result = {};"
		            + "if (element) {"
		            + "if (element.tagName.toLowerCase() === 'img' || element.tagName.toLowerCase() === 'image') {"
		            + "result.type = 'image';"
		            + "var src = element.src;"
		            + "if (src.startsWith('data:')) {"
		            + "result.format = src.split('/')[1].split(';')[0];"
		            + "} else {"
		            + "var url = new URL(src);"
		            + "var pathname = url.pathname;"
		            + "result.format = pathname.substring(pathname.lastIndexOf('.') + 1);"
		            + "}"
		            + "result.width = element.naturalWidth;"
		            + "result.height = element.naturalHeight;"
		            + "fetch(src).then(response => response.blob()).then(blob => {"
		            + "result.size = (blob.size / 1024).toFixed(2) + ' KB';"
		            + "});"
		            + "} else if (element.tagName.toLowerCase() === 'video') {"
		            + "result.type = 'video';"
		            + "result.duration = element.duration;"
		            + "} else if (element.tagName.toLowerCase() === 'iframe' || element.tagName.toLowerCase() === 'div' || element.tagName.toLowerCase() === 'body' || element.tagName.toLowerCase() === 'head' || element.tagName.toLowerCase() === 'header' || element.tagName.toLowerCase() === 'footer') {"
		            + "result.type = 'container';"
		            + "result.elements = element.children.length;"
		            + "} else if (element.tagName.toLowerCase() === 'p' || element.tagName.toLowerCase() === 'span' || element.tagName.toLowerCase() === 'h1' || element.tagName.toLowerCase() === 'h2' || element.tagName.toLowerCase() === 'h3' || element.tagName.toLowerCase() === 'h4' || element.tagName.toLowerCase() === 'h5' || element.tagName.toLowerCase() === 'h6' || element.tagName.toLowerCase() === 'a'|| element.tagName.toLowerCase() === 'text'||element.tagName.toLowerCase() === 'code') {"
		            + "result.type = 'text';"
		            + "result.length = element.textContent.length;"
		            + "result.font = window.getComputedStyle(element).font;"
		            + "}"
		            + "var html = element.outerHTML;"
		            + "var blob = new Blob([html], {type: 'text/html'});"
		            + "result.size = (blob.size / 1024).toFixed(2) + ' KiB';"
		            + "} else {"
		            + "result = null;"
		            + "}"
		            + "return JSON.stringify(result);"
		            + "})();";
	}
	
	/*
private String detectImageType(byte[] bytes) {
    if (bytes.length > 4) {
        if (bytes[0] == (byte) 0xFF && bytes[1] == (byte) 0xD8) {
            return "jpg";
        } else if (bytes[0] == (byte) 0x89 && bytes[1] == (byte) 0x50 && bytes[2] == (byte) 0x4E && bytes[3] == (byte) 0x47) {
            return "png";
        } else if (bytes[0] == (byte) 0x47 && bytes[1] == (byte) 0x49 && bytes[2] == (byte) 0x46 && bytes[3] == (byte) 0x38) {
            return "gif";
        }
    }
    return "jpg"; // Якщо формат не визначений, призначаємо стандартне розширення
}
*/
	
	{
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
	
	
	public void _getType(final String _c) {
		try {
				if (_c.equals("div")) {
						textview1.setText( getString(R.string.container));
						type = 1;
				}
				if (_c.equals("head") || _c.equals("header")) {
						textview1.setText( getString(R.string.header));
						type = 2;
				}
				if (_c.equals("body")) {
						textview1.setText( getString(R.string.body));
						type = 3;
				}
				if (_c.equals("h1") || _c.equals("h2") || _c.equals("h3") || _c.equals("h4") || _c.equals("h5") || _c.equals("h6")) {
						textview1.setText( getString(R.string.htmltitle));
						type = 4;
				}
				if (_c.equals("font") || _c.equals("text") || _c.equals("a") || _c.equals("span") || _c.equals("p") || _c.equals("td") || _c.equals("li")) {
						textview1.setText( getString(R.string.text));
						type = 5;
				}
				if (_c.equals("textarea") || _c.equals("input") || _c.equals("password")) {
						textview1.setText( getString(R.string.textarea));
						type = 6;
				}
				if (_c.equals("button")) {
						textview1.setText( getString(R.string.button));
						type = 7;
				}
				if (_c.equals("select")) {
						textview1.setText( getString(R.string.smselect));
						type = 8;
				}
				if (_c.equals("video")) {
						textview1.setText( getString(R.string.smvideo));
						type = 9;
				}
				if (_c.equals("svg")) {
						textview1.setText( getString(R.string.sm_svg));
						type = 10;
				}
				if (_c.equals("path")) {
						textview1.setText( getString(R.string.sm_path));
						type = 11;
				}
				if (_c.equals("img") || _c.equals("image")) {
						textview1.setText( getString(R.string.sm_img));
						type = 12;
				}
				if (_c.equals("iframe")) {
						textview1.setText( getString(R.string.sm_iframe));
						type = 13;
				}
				if (_c.equals("code")) {
						textview1.setText( getString(R.string.sm_code));
						type = 14;
				}
				if (_c.equals("object")) {
						textview1.setText( getString(R.string.sm_obj));
						type = 15;
				}
				if (type == 0) {
						textview1.setText( getString(R.string.unknown_element));
				}
		} catch (Exception e) {
			
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