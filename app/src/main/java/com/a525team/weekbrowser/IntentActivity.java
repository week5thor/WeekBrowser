package com.a525team.weekbrowser;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
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
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import org.json.JSONObject;

public class IntentActivity extends Activity {
	
	private String filePath = "";
	private String content = "";
	private boolean isfree = false;
	private boolean isAd = false;
	private String blockedline = "";
	RenderUtils ru;
	
	private ArrayList<String> skin = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> window = new ArrayList<>();
	
	private LinearLayout linear1;
	private TextView textview1;
	
	private Intent thema = new Intent();
	private Intent intent2 = new Intent();
	private AlertDialog.Builder d;
	private SharedPreferences sf;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		ThemeManager.applyTheme(this);
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.intent);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		ru = new RenderUtils(IntentActivity.this);
		
		linear1 = findViewById(R.id.linear1);
		textview1 = findViewById(R.id.textview1);
		d = new AlertDialog.Builder(this);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
	}
	
	private void initializeLogic() {
		Skin s = new Skin();
		s.colorToRam(getApplicationContext());
		
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		
		intent2 = getIntent();
		
		String fullUrl = intent2.getData().toString();
		
		if (fullUrl.startsWith("javascript:")) {
				// Збережи JavaScript-код у dataHolder або передай його в WebView
				dataHolder.setData("url", JSutil.replaceInstruction(fullUrl)); // Наприклад, так
				thema = getPackageManager().getLaunchIntentForPackage(getPackageName());
				if (thema != null) {
						startActivity(thema);
				}
				finish();
				return;
		}
		
		Uri fileUri = intent2.getData();
		
		String filePath = fileUri.getPath(); // Може повернути щось на кшталт "/uid/file:///storage/emulated/0/..."
		
		// Якщо шлях містить "/uid/", спробуйте його також прибрати:
		if (filePath.startsWith("/uid/")) {
			    filePath = filePath.replaceFirst("/uid/", "");
		}
		
		// Якщо шлях містить "file://" спочатку, треба його прибрати:
		if (filePath.startsWith("file://")) {
			    filePath = filePath.replaceFirst("file://", "");
		}
		
		filePath = decodeUrl(filePath);
		
		
		if (intent2.getData().toString().startsWith("https://skins.weekbrowser.com/bookmarks")) {
			try {
				    // Декодування URL
				    String decodedUrl = URLDecoder.decode(filePath, "UTF-8");
				
				    // Виділення JSON-частини
				    String jsonString = decodedUrl.substring(decodedUrl.indexOf("{"));
				
				    // Парсинг JSON
				    JSONObject json = new JSONObject(jsonString);
				    SharedPreferences.Editor editor = sf.edit();
				
				    // Збереження параметрів у SharedPreferences
				    editor.putString("cssbgcol", json.optString("cssbgcol", "000000"));
				    editor.putString("cssbg", json.optString("cssbg", ""));
				    editor.putString("cssbgsize", json.optString("cssbgsize", "cover"));
				    editor.putString("cssbgblur", json.optString("cssbgblur", "0.0"));
				    editor.putString("cssbginvert", json.optString("cssbginvert", "0.0"));
				    editor.putString("cssbgcontr", json.optString("cssbgcontr", "1.0"));
				    editor.putString("cssbgbright", json.optString("cssbgbright", "1.0"));
				    editor.putString("cssbgsepia", json.optString("cssbgsepia", "0.0"));
				    editor.putString("cssbghue", json.optString("cssbghue", "0"));
				    editor.putString("cssbgsatur", json.optString("cssbgsatur", "1.0"));
				    editor.putString("cssbgopacity", json.optString("cssbgopacity", "1.0"));
				    editor.putString("cssbgblend", json.optString("cssbgblend", "normal"));
				    editor.putString("csstextline", json.optString("csstextline", "1.3"));
				    editor.putString("csstextfont", json.optString("csstextfont", "sans"));
				    editor.putString("csstextsize", json.optString("csstextsize", "30"));
				    editor.putString("csstextweight", json.optString("csstextweight", "500"));
				    editor.putString("csstexttrans", json.optString("csstexttrans", "initial"));
				    editor.putString("csstextstyle", json.optString("csstextstyle", "initial"));
				    editor.putString("csstextblur", json.optString("csstextblur", "0.0"));
				    editor.putString("csstextinvert", json.optString("csstextinvert", "0.0"));
				    editor.putString("csstextcontr", json.optString("csstextcontr", "1.0"));
				    editor.putString("csstextbright", json.optString("csstextbright", "1.0"));
				    editor.putString("csstextsepia", json.optString("csstextsepia", "0.0"));
				    editor.putString("csstexthue", json.optString("csstexthue", "0"));
				    editor.putString("csstextsatur", json.optString("csstextsatur", "1.0"));
				    editor.putString("csstextopacity", json.optString("csstextopacity", "1.0"));
				    editor.putString("csstextshadowx", json.optString("csstextshadowx", "0.0"));
				    editor.putString("csstextshadowy", json.optString("csstextshadowy", "0.0"));
				    editor.putString("csstextshadowb", json.optString("csstextshadowb", "0.0"));
				    editor.putString("csstextshadowc", json.optString("csstextshadowc", "000000"));
				    editor.putString("csstextblend", json.optString("csstextblend", "normal"));
				    editor.putString("csstextbordersize", json.optString("csstextbordersize", "0.0"));
				    editor.putString("csstextborderstyle", json.optString("csstextborderstyle", "solid"));
				    editor.putString("csstextbordercolor", json.optString("csstextbordercolor", "000000"));
				    editor.putString("csstextstrokesize", json.optString("csstextstrokesize", "0.0"));
				    editor.putString("csstextstrokecolor", json.optString("csstextstrokecolor", "000000"));
				    editor.putString("cssbgstrokesize", json.optString("cssbgstrokesize", "0.0"));
				    editor.putString("cssbgstrokestyle", json.optString("cssbgstrokestyle", "solid"));
				    editor.putString("cssbgstrokecolor", json.optString("cssbgstrokecolor", "000000"));
				    editor.putString("csstextalign", json.optString("csstextalign", "left"));
				    editor.putString("cssdiv", json.optString("cssdiv", " ❖ "));
				    editor.putString("cssdivcolor", json.optString("cssdivcolor", "ff0000"));
				
				    editor.apply();  // Збереження змін
				    HomePageGen.cc(getApplicationContext());
			} catch (Exception e) {
				    Log.e("PasteSettings", "Error parsing JSON from URL", e);
			}
			
			thema.setClass(getApplicationContext(), BookmarksActivity.class);
			startActivity(thema);
			finish();
		} else {
			if (intent2.getData().toString().startsWith("https://multilink2.weekbrowser.com/")) {
				d.setTitle("?");
				d.setMessage(getString(R.string.open_multilink));
				d.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						sf.edit().putString("activetab", "0").commit();
						String temp = intent2.getData().toString().replace("https://multilink2.weekbrowser.com/", "");
						if(temp.startsWith("w")){
								dataHolder.setData("w", "1");
								temp = temp.substring(1);
						}
						sf.edit().putString("tabs", decodeUrl(temp)).commit();
						thema.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
						dataHolder.setData("window", "1");
						thema = getPackageManager().getLaunchIntentForPackage(getPackageName());
						if (thema != null) {
							finish();
							finishAffinity();
							 startActivity(thema);
						}
					}
				});
				d.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						finish();
					}
				});
				d.setCancelable(false);
				
				AlertDialog dddddd = d.create();
				dddddd.setOnShowListener(d -> {
						if(WTF.SDK_INT() > 31 && ru.isOn()){
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
				
			} else {
				if (intent2.getData().toString().startsWith("https://skins.weekbrowser.com/general")) {
					parseAndSaveSkinUrl(intent2.getData().toString(), sf);
					thema.setClass(getApplicationContext(), SettingsActivity.class);
					startActivity(thema);
					finish();
				} else {
					if (intent2.getData().toString().startsWith("https://extensions.weekbrowser.com")) {
						createExtensionFileFromUrl(intent2.getData().toString(), getApplicationContext());
						thema.setClass(getApplicationContext(), ExtensionsActivity.class);
						thema.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(thema);
						finish();
					} else {
						AdBlocker adBlocker = new AdBlocker(this);
						   // String url = filePath;
						try{
							    if (adBlocker.blockRedir()) {
								isAd = adBlocker.isBlocked(intent2.getData().toString());
								   }} catch (Exception e) {
							            Log.e("FileReadError", "Failed to read blocking domains from _stdadlist or adhosts in SharedPreferences", e);
							        }
						    
						if (isAd) {
							SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.adblocked));
							moveTaskToBack(true);
						} else {
							dataHolder.setData("url", intent2.getData().toString());
							thema = getPackageManager().getLaunchIntentForPackage(getPackageName());
							if (thema != null) {
								 startActivity(thema);
							}
						}
						finish();
					}
				}
			}
		}
	}
	
	public void _extra() {
	}
	
	public void createExtensionFileFromUrl(String url, Context context) {
		    try {
			        // Витягуємо назву файлу між першим і другим слешем після домену
			        int startIndex = url.indexOf("/", url.indexOf("://") + 3) + 1;  // після домену
			        int endIndex = url.indexOf("/", startIndex);  // перший слеш після назви
			        String fileName = url.substring(startIndex, endIndex);
			
			        // Витягуємо вміст, все, що йде після другого слеша
			        String fileContent = url.substring(endIndex + 1);
			
			        // Створюємо директорію "extensions" в getFilesDir()
			        File extensionsDir = new File(context.getFilesDir(), "extensions");
			        if (!extensionsDir.exists()) {
				            extensionsDir.mkdirs();  // Створюємо директорію, якщо її не існує
				        }
			
			        // Створюємо файл у директорії "extensions" з відповідним ім'ям
			        File extensionFile = new File(extensionsDir, fileName);
			
			        // Записуємо вміст у файл
			        try (FileOutputStream fos = new FileOutputStream(extensionFile)) {
				            fos.write(fileContent.getBytes());  // Записуємо байти в файл
				        }
			
			        Log.i("CreateExtensionFile", "Файл створено успішно: " + extensionFile.getPath());
			
			    } catch (Exception e) {
			        Log.e("CreateExtensionFile", "Помилка при створенні файлу", e);
			    }
	}
	
	public void parseAndSaveSkinUrl(String url, SharedPreferences sf) {
		    // Витягуємо дані після "/general/"
		    String data = url.substring(url.lastIndexOf("/general/") + "/general/".length());
		    
		    // Розбиваємо рядок на окремі значення за знаком "%"
		    String[] values = data.split("%");
		
		    if (values.length >= 35) {  // Перевіряємо, що в нас достатньо елементів
			        SharedPreferences.Editor editor = sf.edit();
			
			        // Зберігаємо кожне значення в SharedPreferences
			        editor.putString("t", values[0]);
			        editor.putString("tf", values[1]);
			        editor.putString("add", values[2]);
			        editor.putString("h", values[3]);
			        editor.putString("cb", values[4]);
			        editor.putString("tpc", values[5]);
			        editor.putString("tc", values[6]);
			        editor.putString("bt", values[7]);
			        editor.putString("rbt", values[8]);
			        editor.putString("bg", values[9]);
			        editor.putString("bbg", values[10]);
			        editor.putString("rbg", values[11]);
			        editor.putString("grad", values[12]);
			        editor.putString("rgrad", values[13]);
			        editor.putString("bgrad", values[14]);
			        editor.putString("strcou", values[15]);
			        editor.putString("rstrcou", values[16]);
			        editor.putString("bstrcou", values[17]);
			        editor.putString("tm", values[18]);
			        editor.putString("rtm", values[19]);
			        editor.putString("btm", values[20]);
			        editor.putString("rad", values[21]);
			        editor.putString("rrad", values[22]);
			        editor.putString("brad", values[23]);
			        editor.putString("x", values[24]);
			        editor.putString("rx", values[25]);
			        editor.putString("bx", values[26]);
			        editor.putString("y", values[27]);
			        editor.putString("ry", values[28]);
			        editor.putString("by", values[29]);
			        editor.putString("rou", values[30]);
			        editor.putString("rrou", values[31]);
			        editor.putString("srou", values[32]);
			        editor.putString("rsrou", values[33]);
			        editor.putString("style", values[34]);
			
			        editor.apply();  // Застосовуємо зміни
			    } else {
			        Log.e("ParseSkinUrl", "Недостатньо значень у посиланні.");
			    }
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
	
	
	public void _colorToRam() {
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		switch(sf.getString("theme", "")) {
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
					dataHolder.setData("bt", "ffffffff");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
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
				break;
			}
			case "3": {
				
				
				dataHolder.setData("bg", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/bg.txt"));
				dataHolder.setData("bbg", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt"));
				dataHolder.setData("bbg2", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/buttonbg2.txt"));
				dataHolder.setData("rbg", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt"));
				dataHolder.setData("rbg2", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg2.txt"));
				dataHolder.setData("t", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/text.txt"));
				dataHolder.setData("tf", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/textfield.txt"));
				dataHolder.setData("add", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/additional.txt"));
				dataHolder.setData("h", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/hint.txt"));
				dataHolder.setData("bt", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/buttontext.txt"));
				dataHolder.setData("rbt", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/redbuttontext.txt"));
				dataHolder.setData("rou", FileUtil.readFile("storage/emulated/0/WeekBrowser/CustomTheme/roundness.txt"));
				break;
			}
		}
	}
	
}