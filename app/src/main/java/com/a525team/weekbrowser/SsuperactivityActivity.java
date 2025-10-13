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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
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
import java.util.stream.Collectors;
import java.lang.reflect.Method;


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
	private CheckBox incognitosrc;
	private LinearLayout srcbuttons2;
	private Button ad;
	private TextView a2;
	private EditText href;
	private LinearLayout urlbuttons;
	private CheckBox incognitohref;
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
	private Button addbmk;
	private Button addshr;
	private Button share;
	private Button copyeltxt;
	private Button shareeltxt;
	private LinearLayout linear12;
	private Button toelem;
	private AutoCompleteTextView autocomplete1;
	private Button wayback;
	private LinearLayout linear13;
	private Button button4;
	private Button addshortcut;
	private Button button3;
	private TextView a4;
	private EditText txtpage;
	private TextView hint;
	private HorizontalScrollView hscroll1;
	private LinearLayout linear7;
	private LinearLayout linear4;
	private TextView a6;
	private EditText pagecode;
	private Button copyurl;
	private Button sharesite;
	private RadioGroup radiogroup1;
	private RadioButton chatgpt;
	private RadioButton gemini;
	private RadioButton deepseek;
	private RadioButton deepseek2;
	private Button w30;
	private Button w120;
	private Button w240;
	private Button ab1;
	private Button ab3;
	private AutoCompleteTextView fn;
	private Button savehtml;
	private Button mht;
	
	private Intent intent = new Intent();
	private ObjectAnimator anim = new ObjectAnimator();
	private TimerTask prompttimer;
	private AlertDialog.Builder blockad;
	private Calendar dnt = Calendar.getInstance();
	private SharedPreferences sf;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		ThemeManager.applyTheme(this);
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.ssuperactivity);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
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
		incognitosrc = findViewById(R.id.incognitosrc);
		srcbuttons2 = findViewById(R.id.srcbuttons2);
		ad = findViewById(R.id.ad);
		a2 = findViewById(R.id.a2);
		href = findViewById(R.id.href);
		urlbuttons = findViewById(R.id.urlbuttons);
		incognitohref = findViewById(R.id.incognitohref);
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
		addbmk = findViewById(R.id.addbmk);
		addshr = findViewById(R.id.addshr);
		share = findViewById(R.id.share);
		copyeltxt = findViewById(R.id.copyeltxt);
		shareeltxt = findViewById(R.id.shareeltxt);
		linear12 = findViewById(R.id.linear12);
		toelem = findViewById(R.id.toelem);
		autocomplete1 = findViewById(R.id.autocomplete1);
		wayback = findViewById(R.id.wayback);
		linear13 = findViewById(R.id.linear13);
		button4 = findViewById(R.id.button4);
		addshortcut = findViewById(R.id.addshortcut);
		button3 = findViewById(R.id.button3);
		a4 = findViewById(R.id.a4);
		txtpage = findViewById(R.id.txtpage);
		hint = findViewById(R.id.hint);
		hscroll1 = findViewById(R.id.hscroll1);
		linear7 = findViewById(R.id.linear7);
		linear4 = findViewById(R.id.linear4);
		a6 = findViewById(R.id.a6);
		pagecode = findViewById(R.id.pagecode);
		copyurl = findViewById(R.id.copyurl);
		sharesite = findViewById(R.id.sharesite);
		radiogroup1 = findViewById(R.id.radiogroup1);
		chatgpt = findViewById(R.id.chatgpt);
		gemini = findViewById(R.id.gemini);
		deepseek = findViewById(R.id.deepseek);
		deepseek2 = findViewById(R.id.deepseek2);
		w30 = findViewById(R.id.w30);
		w120 = findViewById(R.id.w120);
		w240 = findViewById(R.id.w240);
		ab1 = findViewById(R.id.ab1);
		ab3 = findViewById(R.id.ab3);
		fn = findViewById(R.id.fn);
		savehtml = findViewById(R.id.savehtml);
		mht = findViewById(R.id.mht);
		blockad = new AlertDialog.Builder(this);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		
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
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				if (webview1.getUrl().contains("https://chat.deepseek.com") || (webview1.getUrl().contains("https://gemini.google.com") || webview1.getUrl().contains("https://chatgpt.com"))) {
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
							} else {
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
				} else {
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
				dataHolder.setData("txt", txtarea.getText().toString());
				dataHolder.setData("idtxt", taid);
				finish();
			}
		});
		
		a1.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
		a1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (img.getVisibility() == View.VISIBLE) {
					a1.setText(getString(R.string.src) + " [▼]");
					img.setVisibility(View.GONE);
				} else {
					a1.setText(getString(R.string.src) + " [▲]");
					img.setVisibility(View.VISIBLE);
					Animator2.anim(getApplicationContext(), img, 1, 300);
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
						} else {
							buffer = elementhtml.getText().toString();
						}
						SketchwareUtil.showMessage(getApplicationContext(), "Завантаження векторного зображення в SVG...");
						try{
							FileUtil.writeFile(FileUtil.getPublicDir(Environment.DIRECTORY_DOWNLOADS).concat("/".concat("Vector_".concat(new SimpleDateFormat("E_ddMMyyyy_HHmmss").format(dnt.getTime())).concat(".svg"))), buffer);
						}catch(Exception e){
							SketchwareUtil.showMessage(getApplicationContext(), "error (maybe memory permission denied)");
						}
					} else {
						if (((type > 1) && (type < 3)) || (type == 13)) {
							if (elementhtml.getText().toString().isEmpty()) {
								buffer = Datas.get("code").toString();
							} else {
								buffer = elementhtml.getText().toString();
							}
							SketchwareUtil.showMessage(getApplicationContext(), "Завантаження частини макета сайту в HTML...");
							try{
								FileUtil.writeFile(FileUtil.getPublicDir(Environment.DIRECTORY_DOWNLOADS).concat("/".concat("Vector_".concat(new SimpleDateFormat("E_ddMMyyyy_HHmmss").format(dnt.getTime())).concat(".html"))), buffer);
							}catch(Exception e){
								SketchwareUtil.showMessage(getApplicationContext(), "error (maybe memory permission denied)");
							}
						} else {
							if (((type > 4) && (type < 6)) || (type == 14)) {
								if (eltext.getText().toString().isEmpty()) {
									buffer = Datas.get("text").toString();
								} else {
									buffer = eltext.getText().toString();
								}
								SketchwareUtil.showMessage(getApplicationContext(), "Завантаження тексту в TXT...");
								try{
									FileUtil.writeFile(FileUtil.getPublicDir(Environment.DIRECTORY_DOWNLOADS).concat("/".concat("Vector_".concat(new SimpleDateFormat("E_ddMMyyyy_HHmmss").format(dnt.getTime())).concat(".txt"))), buffer);
								}catch(Exception e){
									SketchwareUtil.showMessage(getApplicationContext(), "error (maybe memory permission denied)");
								}
							} else {
								
							}
						}
					}
				} else {
					if (img.getText().toString().isEmpty()) {
						buffer = Datas.get("src").toString();
					} else {
						buffer = img.getText().toString();
					}
					if (buffer != null && !buffer.isEmpty()) {
						FileDownloader fileDownloader = new FileDownloader(SsuperactivityActivity.this, webview1);
						fileDownloader.handleBlobFromOtherActivity(buffer);
						
					} else {
						    Toast.makeText(getApplicationContext(), "Посилання на елемент відсутнє", Toast.LENGTH_SHORT).show();
					}
					
				}
			}
		});
		
		incognitosrc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("incognito", "").equals("0")) {
					incognitosrc.setChecked(true);
					incognitohref.setChecked(true);
					sf.edit().putString("incognito", "1").commit();
					if (sf.getString("noscreen", "").equals("1")) {
						getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
					}
				} else {
					incognitosrc.setChecked(false);
					incognitohref.setChecked(false);
					sf.edit().putString("incognito", "0").commit();
					getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
				}
			}
		});
		
		ad.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				
				String adHosts = sf.getString("adhosts","");
				if (isAd) {
					String[] adHostsLines = adHosts.split("\n");
					//StringBuilder updatedAdHosts = new StringBuilder();
					
					for (int h = 0; h < adHostsLines.length; h++) {
						    String line = adHostsLines[h].trim();
						    if (line.startsWith("%")) {
							        // Якщо рядок починається з "%", то шукаємо конкретне посилання
							        if (Datas.get("src").toString().matches(".*" + line.substring(1).trim() + ".*")) {
								            // Видаляємо рядок
								            final int ltr = h;
								            String updatedAdHosts = Arrays.stream(adHostsLines)
								                .filter(l -> !l.equals(adHostsLines[ltr]))
								                .collect(Collectors.joining("\n"));
								
								            // Зберігаємо оновлений результат
								            sf.edit().putString("adhosts", updatedAdHosts).apply();
								
								            SketchwareUtil.showMessage(getApplicationContext(), "This element isn't blocked anymore! (Maybe)");
								
								            _checkblock();
								        }
							    } else {
							        // Якщо це домен, то перевіряємо як раніше
							        if (_extractDomain(Datas.get("src").toString()).matches(".*" + line + ".*")) {
								            final int ltr = h;
								            String updatedAdHosts = Arrays.stream(adHostsLines)
								                .filter(l -> !l.equals(adHostsLines[ltr]))
								                .collect(Collectors.joining("\n"));
								
								            // Зберігаємо оновлений результат
								            sf.edit().putString("adhosts", updatedAdHosts).apply();
								
								            SketchwareUtil.showMessage(getApplicationContext(), "This element isn't blocked anymore! (Maybe)");
								
								            _checkblock();
								        }
							    }
					}
					
				} else {
					try{
						blockad.setTitle("?");
						blockad.setMessage(getString(R.string.blocksite1).concat(_extractDomain(Datas.get("src").toString())).concat(getString(R.string.blocksite2).concat(Datas.get("src").toString())));
						blockad.setPositiveButton("[    1    ]", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								sf.edit().putString("adhosts", sf.getString("adhosts", "").concat("\n").concat(_extractDomain(Datas.get("src").toString()).replace(".", "\\."))).commit();
							}
						});
						blockad.setNegativeButton("[    2    ]", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								sf.edit().putString("adhosts", sf.getString("adhosts", "").concat("\n%".concat(Datas.get("src").toString().replace(".", "\\.")))).commit();
							}
						});
						blockad.setNeutralButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						blockad.create().show();
					}catch(Exception e){
						SketchwareUtil.showMessage(getApplicationContext(), "error");
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", e.toString()));
					}
				}
			}
		});
		
		a2.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
		a2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (href.getVisibility() == View.VISIBLE) {
					href.setVisibility(View.GONE);
					a2.setText(getString(R.string.href) + " [▼]");
				} else {
					href.setVisibility(View.VISIBLE);
					a2.setText(getString(R.string.href) + " [▲]");
					if (!hreff) {
						try{
							href.setText(Datas.get("href").toString());
							hreff = true;
						}catch(Exception e){
							 
						}
					}
					Animator2.anim(getApplicationContext(), href, 1, 300);
				}
			}
		});
		
		incognitohref.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("incognito", "").equals("0")) {
					incognitosrc.setChecked(true);
					incognitohref.setChecked(true);
					sf.edit().putString("incognito", "1").commit();
					if (sf.getString("noscreen", "").equals("1")) {
						getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
					}
				} else {
					incognitosrc.setChecked(false);
					incognitohref.setChecked(false);
					sf.edit().putString("incognito", "0").commit();
					getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
				}
			}
		});
		
		a5.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				intent.setClass(getApplicationContext(), TextActivity.class);
				intent.putExtra("dh", "text");
				startActivity(intent);
				return true;
			}
		});
		
		a5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (eltext.getVisibility() == View.VISIBLE) {
					eltext.setVisibility(View.GONE);
					a5.setText(getString(R.string.eltext) + " [▼]");
				} else {
					eltext.setVisibility(View.VISIBLE);
					a5.setText(getString(R.string.eltext) + " [▲]");
					if (!eltxt) {
						try{
							eltext.setText(Datas.get("text").toString());
							eltxt = true;
						}catch(Exception e){
							 
						}
					}
					Animator2.anim(getApplicationContext(), eltext, 1, 300);
				}
			}
		});
		
		a3.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				intent.setClass(getApplicationContext(), TextActivity.class);
				intent.putExtra("dh", "code");
				startActivity(intent);
				return true;
			}
		});
		
		a3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (elementhtml.getVisibility() == View.VISIBLE) {
					elementhtml.setVisibility(View.GONE);
					add.setVisibility(View.GONE);
					a3.setText(getString(R.string.elcode) + " [▼]");
				} else {
					elementhtml.setVisibility(View.VISIBLE);
					add.setVisibility(View.VISIBLE);
					a3.setText(getString(R.string.elcode) + " [▲]");
					if (!elcode) {
						try{
							elementhtml.setText(_correctelHTML());
							elcode = true;
						}catch(Exception e){
							 
						}
					}
					Animator2.anim(getApplicationContext(), elementhtml, 1, 300);
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
					} else {
						buffer = img.getText().toString();
					}
					dataHolder.setData("url", buffer);
					intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
					if (intent != null) {
						 startActivity(intent);
					}
					finish();
				}catch(Exception e){
					SketchwareUtil.showMessage(getApplicationContext(), "ПОМИЛКА!");
					dataHolder.setData("bgtab", null);
					dataHolder.setData("sametab", null);
				}
			}
		});
		
		sametab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dataHolder.setData("sametab", "");
				temproarystd.performClick();
			}
		});
		
		bgtab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dataHolder.setData("bgtab", "");
				temproarystd.performClick();
			}
		});
		
		copysrc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (img.getText().toString().isEmpty()) {
					buffer = Datas.get("src").toString();
				} else {
					buffer = img.getText().toString();
				}
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", buffer));
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_SEND);
				intent.setType("text/plain");
				if (eltext.getText().toString().isEmpty()) {
					buffer = Datas.get("src").toString();
				} else {
					buffer = img.getText().toString();
				}
				intent.putExtra(Intent.EXTRA_TEXT, buffer);
				startActivity(Intent.createChooser(intent, getString(R.string.sharewith)));
			}
		});
		
		hnew.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (href.getText().toString().isEmpty()) {
					buffer = Datas.get("href").toString();
				} else {
					buffer = href.getText().toString();
				}
				dataHolder.setData("url", buffer);
				intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
				if (intent != null) {
					 startActivity(intent);
				}
				finish();
			}
		});
		
		hthis.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dataHolder.setData("sametab", "");
				hnew.performClick();
			}
		});
		
		hbg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dataHolder.setData("bgtab", "");
				hnew.performClick();
			}
		});
		
		call.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (href.getText().toString().isEmpty()) {
					buffer = Datas.get("href").toString();
				} else {
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
				} else {
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
				} else {
					buffer = href.getText().toString();
				}
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", buffer));
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
			}
		});
		
		addbmk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), BookmarksActivity.class);
				if (href.getText().toString().isEmpty()) {
					buffer = Datas.get("href").toString();
				} else {
					buffer = href.getText().toString();
				}
				intent.setData(Uri.parse(buffer));
				if (eltext.getText().toString().isEmpty()) {
					buffer = Datas.get("text").toString();
				} else {
					buffer = eltext.getText().toString();
				}
				intent.putExtra("n", buffer);
				intent.putExtra("m", "");
				startActivity(intent);
			}
		});
		
		addshr.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ShortcutActivity.class);
				if (eltext.getText().toString().isEmpty()) {
					buffer = Datas.get("text").toString();
				} else {
					buffer = eltext.getText().toString();
				}
				intent.putExtra("name", buffer);
				if (href.getText().toString().isEmpty()) {
					buffer = Datas.get("href").toString();
				} else {
					buffer = href.getText().toString();
				}
				intent.putExtra("url", buffer);
				startActivity(intent);
			}
		});
		
		share.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (href.getText().toString().isEmpty()) {
					buffer = Datas.get("href").toString();
				} else {
					buffer = href.getText().toString();
				}
				intent.setAction(Intent.ACTION_SEND);
				intent.setType("text/plain");
				if (buffer.toLowerCase().startsWith("tel")) {
					temp = buffer.replace("%23", "#").replace("tel:", "");
					intent.putExtra(Intent.EXTRA_TEXT, temp);
				} else {
					intent.putExtra(Intent.EXTRA_TEXT, buffer);
				}
				startActivity(Intent.createChooser(intent, getString(R.string.sharewith)));
			}
		});
		
		copyeltxt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (eltext.getText().toString().isEmpty()) {
					buffer = Datas.get("text").toString();
				} else {
					buffer = eltext.getText().toString();
				}
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", buffer));
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
			}
		});
		
		shareeltxt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (eltext.getText().toString().isEmpty()) {
					buffer = Datas.get("text").toString();
				} else {
					buffer = eltext.getText().toString();
				}
				intent.setAction(Intent.ACTION_SEND);
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_TEXT, buffer);
				startActivity(Intent.createChooser(intent, getString(R.string.sharewith)));
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
				} else {
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
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), LoadresActivity.class);
				startActivity(intent);
			}
		});
		
		a4.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				intent.setClass(getApplicationContext(), TextActivity.class);
				intent.putExtra("dh", "wtext");
				startActivity(intent);
				return true;
			}
		});
		
		a4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (txtpage.getVisibility() == View.VISIBLE) {
					txtpage.setVisibility(View.GONE);
					a4.setText(getString(R.string.wtext) + " [▼]");
				} else {
					txtpage.setVisibility(View.VISIBLE);
					a4.setText(getString(R.string.wtext) + " [▲]");
					if (!txtpag) {
						try{
							txtpage.setText(Datas.get("wtext").toString());
							txtpag = true;
						}catch(Exception e){
							 
						}
					}
					Animator2.anim(getApplicationContext(), txtpage, 1, 300);
				}
			}
		});
		
		a6.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				intent.setClass(getApplicationContext(), TextActivity.class);
				intent.putExtra("dh", "wcode");
				startActivity(intent);
				return true;
			}
		});
		
		a6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (pagecode.getVisibility() == View.VISIBLE) {
					pagecode.setVisibility(View.GONE);
					a6.setText(getString(R.string.wcode) + " [▼]");
				} else {
					pagecode.setVisibility(View.VISIBLE);
					a6.setText(getString(R.string.wcode) + " [▲]");
					if (!pgecode) {
						try{
							pagecode.setText(Datas.get("wcode").toString());
							pgecode = true;
						}catch(Exception e){
							 
						}
					}
					Animator2.anim(getApplicationContext(), pagecode, 1, 300);
				}
			}
		});
		
		copyurl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (autocomplete1.getText().toString().isEmpty()) {
					buffer = Datas.get("url").toString();
				} else {
					buffer = autocomplete1.getText().toString();
				}
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", buffer));
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
			}
		});
		
		sharesite.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_SEND);
				intent.setType("text/plain");
				if (autocomplete1.getText().toString().isEmpty()) {
					buffer = Datas.get("url").toString();
				} else {
					buffer = autocomplete1.getText().toString();
				}
				intent.putExtra(Intent.EXTRA_TEXT, buffer);
				startActivity(Intent.createChooser(intent, getString(R.string.sharewith)));
			}
		});
		
		chatgpt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("llm", "1").commit();
			}
		});
		
		gemini.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("llm", "2").commit();
			}
		});
		
		deepseek.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("llm", "3").commit();
			}
		});
		
		deepseek2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("llm", "0").commit();
			}
		});
		
		w30.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_summarize(0);
			}
		});
		
		w120.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_summarize(1);
			}
		});
		
		w240.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_summarize(2);
			}
		});
		
		ab1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_summarize(3);
			}
		});
		
		ab3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_summarize(4);
			}
		});
		
		savehtml.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (pagecode.getText().toString().isEmpty()) {
					buffer = Datas.get("wcode").toString();
				} else {
					buffer = pagecode.getText().toString();
				}
				try{
					FileUtil.writeFile(FileUtil.getPublicDir(Environment.DIRECTORY_DOWNLOADS).concat("/".concat(fn.getText().toString().concat(".html"))), buffer);
					SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.done));
				}catch(Exception e){
					 
				}
			}
		});
		
		mht.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ExtendedDataHolder dh = ExtendedDataHolder.getInstance();
				dh.setData("savemht", FileUtil.getPublicDir(Environment.DIRECTORY_DOWNLOADS).concat("/".concat(fn.getText().toString().concat(".mht"))));
				SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.backmht));
			}
		});
	}
	
	private void initializeLogic() {
		webview1.getSettings().setBuiltInZoomControls(true);
		webview1.getSettings().setDisplayZoomControls(false);
		webview1.getSettings().setLoadWithOverviewMode(true);
		webview1.getSettings().setUseWideViewPort(false);
		webview1.getSettings().setSaveFormData(true);
		    webview1.getSettings().setAllowFileAccess(true);
		    webview1.getSettings().setAllowContentAccess(true);
		    webview1.getSettings().setDatabaseEnabled(true);
		    webview1.getSettings().setDomStorageEnabled(true);
		    webview1.getSettings().setAllowFileAccessFromFileURLs(true);
		    webview1.getSettings().setAllowUniversalAccessFromFileURLs(true);
		    webview1.getSettings().setPluginState(WebSettings.PluginState.ON);
		   
		webview1.getSettings().setMediaPlaybackRequiresUserGesture(false);
		webview1.setLayerType(sf.getString("hardware2", "1")
		 .equals("1")?
		 View.LAYER_TYPE_HARDWARE:View.LAYER_TYPE_SOFTWARE, null);
		    try {
			    WebSettings settings = webview1.getSettings();
			    Method method = settings.getClass().getMethod("setMixedContentMode", int.class);
			    method.invoke(settings, WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
		} catch (Exception e) {
			    // метод не існує — і все ок
		}
		
		         webview1.getSettings().setJavaScriptEnabled(true);
		         
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			    webview1.setRendererPriorityPolicy(WebView.RENDERER_PRIORITY_IMPORTANT, true);
		}
		
		webview1.setInitialScale((int)Integer.parseInt(sf.getString("dp", ""))*10);
		webview1.getSettings().setMinimumFontSize(Integer.parseInt(sf.getString("minfont", "")));
		webview1.getSettings().setTextZoom(Integer.parseInt(sf.getString("fontsize", ""))*10);
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
			Datas = new Gson().fromJson(dataHolder.getData("info"), new TypeToken<HashMap<String, Object>>(){}.getType());
			_getType(Datas.get("type").toString());
			try{
				img.setText(Datas.get("src").toString());
			}catch(Exception e){
				 
			}
			webview1.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY);
			try{
				webview1.loadDataWithBaseURL(getIntent().getStringExtra("url"), _correctelHTML(), "text/html", "UTF-8", null);
			}catch(Exception e){
				 
			}
			try{
				_checkblock();
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
				sUrl = Datas.get("url").toString().replaceAll("[^\\p{L}\\p{N}\\s\\/]", "_");
				fn.setText(sUrl.concat(new SimpleDateFormat("yyyyMMdd_EE_HHmmss").format(dnt.getTime())));
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
				incognitosrc.setVisibility(View.GONE);
			}
			if (!isNotNullOrEmpty(Datas, "href")) {
				a2.setVisibility(View.GONE);
				urlbuttons.setVisibility(View.GONE);
				urlbuttons2.setVisibility(View.GONE);
				callbuttons.setVisibility(View.GONE);
				incognitohref.setVisibility(View.GONE);
			} else {
				if (Datas.get("href").toString().toLowerCase().startsWith("http")) {
					callbuttons.setVisibility(View.GONE);
				} else {
					if (Datas.get("href").toString().toLowerCase().startsWith("tel")) {
						urlbuttons.setVisibility(View.GONE);
					} else {
						if (Datas.get("href").toString().toLowerCase().startsWith("javascript")) {
							callbuttons.setVisibility(View.GONE);
							hnew.setVisibility(View.GONE);
							hbg.setVisibility(View.GONE);
							hthis.setText(getString(R.string.execute));
						} else {
							
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
		}catch(Exception e){
			 
		}
		_onscroll(vscroll1);
		_onscroll(vscroll2);
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		deepseek2.setChecked(sf.getString("llm", "").equals("0"));
		chatgpt.setChecked(sf.getString("llm", "").equals("1"));
		gemini.setChecked(sf.getString("llm", "").equals("2"));
		deepseek.setChecked(sf.getString("llm", "").equals("3"));
	}
	
	
	@Override
	public void onResume() {
		super.onResume();
		
		SafeMarginUtils.init(this, findViewById(android.R.id.content));
		
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		Skin skin = new Skin();
		
		colorify.applyColorifyToAll(getWindow().getDecorView().getRootView());
		
		skin.setBG(getWindow().getDecorView(), 2, false);
		
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		textview1.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		chatgpt.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		gemini.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		deepseek.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		deepseek2.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		incognitosrc.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		incognitohref.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
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
		button3.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		txtready.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		sametab.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		bgtab.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		addshortcut.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					temproarystd.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		call.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		addbmk.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		addshr.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		button4.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
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
		mht.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		skin.setBG(downloadImageButton, 0, false);
		skin.setBG(add, 0, false);
		skin.setBG(savehtml, 0, false);
		skin.setBG(mht, 0, false);
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
		skin.setBG(button3, 0, false);
		
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
		
		skin.setBG(addbmk, 0, false);
		skin.setBG(addshr, 0, false);
		skin.setBG(button4, 0, false);
		if (sf.getString("monoforta", "").equals("1")) {
			autocomplete1.setTypeface(Typeface.MONOSPACE);
			txtarea.setTypeface(Typeface.MONOSPACE);
			img.setTypeface(Typeface.MONOSPACE);
			elementhtml.setTypeface(Typeface.MONOSPACE);
			fn.setTypeface(Typeface.MONOSPACE);
			txtpage.setTypeface(Typeface.MONOSPACE);
			href.setTypeface(Typeface.MONOSPACE);
			eltext.setTypeface(Typeface.MONOSPACE);
			pagecode.setTypeface(Typeface.MONOSPACE);
		} else {
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
		if (sf.getString("incognito", "").equals("1")) {
			incognitosrc.setChecked(true);
			incognitohref.setChecked(true);
			if (sf.getString("noscreen", "").equals("1")) {
				getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
			}
		} else {
			incognitosrc.setChecked(false);
			incognitohref.setChecked(false);
			getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
		}
	}
	
	    public void onLowMemory() {
		        super.onLowMemory();
		        finish();
		        }
	
	@Override
	public void onPause() {
		super.onPause();
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		SafeMarginUtils.cleanup();
		if (sf.getString("nopreview", "").equals("1") && sf.getString("incognito", "").equals("1")) {
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
		}
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
		if (type == 11) {
			html = "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 5000 5000\">".concat(html.concat("</svg>"));
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
	
	
	public void sendChatRequest(int service, String prompt) {
		    new Thread(() -> {
			        String apiKey = ""; // Вставте свій API-ключ
			        HttpURLConnection connection = null;
			        BufferedReader reader = null;
			        StringBuilder response = new StringBuilder();
			        
			        try {
				            // URL API OpenAI
				            URL url = new URL("https://api.openai.com/v1/chat/completions");
				            connection = (HttpURLConnection) url.openConnection();
				            
				            // Налаштування запиту
				            connection.setRequestMethod("POST");
				            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
				            connection.setRequestProperty("Content-Type", "application/json");
				            connection.setRequestProperty("Accept", "application/json");
				            connection.setDoOutput(true);
				            
				            // Тіло запиту (JSON)
				            String jsonInputString = "{"
				                + "\"model\": \"gpt-4o-mini\","
				                + "\"messages\": ["
				                + "{\"role\": \"system\", \"content\": \"Summarize text\"},"
				                + "{\"role\": \"user\", \"content\": \"" + prompt + "\"}"
				                + "],"
				                + "\"temperature\": 0.7"
				                + "}";
				
				            // Відправка тіла запиту
				            try (OutputStream os = connection.getOutputStream()) {
					                byte[] input = jsonInputString.getBytes("utf-8");
					                os.write(input, 0, input.length);
					            }
				
				            // Отримання відповіді
				            int responseCode = connection.getResponseCode();
				            if (responseCode == HttpURLConnection.HTTP_OK) {
					                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
					                String line;
					                while ((line = reader.readLine()) != null) {
						                    response.append(line);
						                }
					            } else {
					                response.append("Помилка: ").append(responseCode);
					            }
				        } catch (IOException e) {
				            e.printStackTrace();
				            response.append("Помилка: ").append(e.getMessage());
				        } finally {
				            // Закриття з'єднання та потоків
				            if (connection != null) connection.disconnect();
				            if (reader != null) {
					                try {
						                    reader.close();
						                } catch (IOException e) {
						                    e.printStackTrace();
						                }
					            }
				            // Відображення відповіді в WebView
				            runOnUiThread(() -> {
					                webview1.loadDataWithBaseURL(getIntent().getStringExtra("url"), response.toString(), "text/plain", "UTF-8", null);
					            });
				        }
			    }).start();
	}
	
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
					textview1.setText(e.toString());
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
	
	
	public void _checkblock() {
		AdBlocker adBlocker = new AdBlocker(this);
		if (isNotNullOrEmpty(Datas, "src")) {
			if(adBlocker.isBlocked(Datas.get("src").toString())){
				    isAd = true; ad.setText(getString(R.string.is_not_ad));
				    }
		} else {
			ad.setVisibility(View.GONE);
		}
	}
	
	
	public void _summarize(final double _w) {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		if (txtpage.getText().toString().isEmpty()) {
			buffer = Datas.get("wtext").toString();
		} else {
			buffer = txtpage.getText().toString();
		}
		if (sf.getString("llm", "").equals("0")) {
			sendChatRequest(0, buffer);
		} else {
			webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
			buffer = "Please, summarize text to ".concat(((_w == 0) ? ("30 words") : (((_w == 1) ? ("120 words") : (((_w == 2) ? ("240 words") : (((_w == 3) ? ("1 paragraph") : ("3 paragraphs")))))))).concat(" on same language as text. Text:  ")).concat(buffer);
			webview1.setVisibility(View.VISIBLE);
			linear3.setVisibility(View.VISIBLE);
			switch(sf.getString("llm", "")) {
				case "1": {
					webview1.loadUrl("https://chatgpt.com/?q=".concat(buffer));
					break;
				}
				case "2": {
					webview1.loadUrl("https://gemini.google.com/chat");
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", buffer));
					SketchwareUtil.showMessage(getApplicationContext(), "Insert prompt from clipboard");
					break;
				}
				case "3": {
					webview1.loadUrl("https://chat.deepseek.com");
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", buffer));
					SketchwareUtil.showMessage(getApplicationContext(), "Insert prompt from clipboard");
					break;
				}
			}
			LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linear3.getLayoutParams();
			
			// Змінити вагу віджета
			params.weight = 1; // Нове значення ваги
			
			// Встановити оновлені параметри вашому віджету
			linear3.setLayoutParams(params);
		}
	}
	
}