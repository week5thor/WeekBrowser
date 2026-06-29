package com.a525team.weekbrowser;

import android.animation.*;
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
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.a525team.weekbrowser.SkinCheckBox;
import com.a525team.weekbrowser.SkinTextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Collectors;
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class LoadresActivity extends Activity {
	
	private  List<Map<String, Object>> currentResources = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> test = new ArrayList<>();
	
	private LinearLayout linear1;
	private ListView listview1;
	private SkinTextView infotext;
	private LinearLayout linear2;
	private WebView webview1;
	private SkinCheckBox verbose;
	private SkinCheckBox ends;
	
	private AlertDialog.Builder blockad;
	private SharedPreferences sf;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		ThemeManager.applyTheme(this);
		setContentView(R.layout.loadres);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		linear1 = findViewById(R.id.linear1);
		listview1 = findViewById(R.id.listview1);
		infotext = findViewById(R.id.infotext);
		linear2 = findViewById(R.id.linear2);
		webview1 = findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		verbose = findViewById(R.id.verbose);
		ends = findViewById(R.id.ends);
		blockad = new AlertDialog.Builder(this);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		
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
		
		verbose.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("detailed_logs", "").equals("0")) {
					sf.edit().putString("detailed_logs", "1").commit();
					verbose.setChecked(true);
				} else {
					sf.edit().putString("detailed_logs", "0").commit();
					verbose.setChecked(false);
				}
			}
		});
		
		ends.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
		});
	}
	
	private void initializeLogic() {
		SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		/*
Skin skin = new Skin();
    skin.setBG(findViewById(android.R.id.content), 2, true);

    ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
    verbose.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
    
    ends.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
    
    infotext.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
    */
		//༺Отримання мапи༻//
		
		String tabTag = getIntent().getStringExtra("tag");
		// 1. Отримуємо наш безпечний список (тип List<Map<String, Object>>)
		List<Map<String, Object>> rawResources = ResourceManager.getInstance().getOrCreateResourcesForTab(tabTag);
		
		// 2. Створюємо НОВИЙ порожній ArrayList, який чекає Sketchware
		ArrayList<HashMap<String, Object>> currentResources = new ArrayList<>();
		
		// 3. Безпечно копіюємо дані в новий список
		if (rawResources != null) {
			synchronized (rawResources) {
				for (Map<String, Object> item : rawResources) {
					// Оскільки ми точно знаємо, що в MyWebViewClient створювали HashMap,
					// цей каст (перетворення типу) абсолютно безпечний.
					currentResources.add((HashMap<String, Object>) item);
				}
			}
		}
		
		// 4. Передаємо готову, незалежну копію в Адаптер (без тернарних операторів, бо він вже точно не null)
		listview1.setAdapter(new Listview1Adapter(currentResources));
		verbose.setChecked(sf.getString("detailed_logs", "").equals("1"));
		try{
			infotext.setText("Length = ".concat(String.valueOf((long)(currentResources.size()))).concat(" elements (≈").concat(Formater.kimgt(getSerializedSize(currentResources)).concat("B of RAM)")));
		}catch(Exception e){
			infotext.setText("Length = ".concat(String.valueOf((long)(currentResources.size()))).concat(" elements"));
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		SafeMarginUtils.init(this, findViewById(android.R.id.content));
		
		webview1.onResume();
		webview1.resumeTimers();
		
		Skin.getInstance().setStaticBG(this, 2, false);
	}
	
	@Override
	public void onPause() {
		super.onPause();
		SafeMarginUtils.cleanup();
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		if (dataHolder.getData("ols").equals("0")) {
			webview1.onPause();
			webview1.pauseTimers();
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
	
	
	public void _ex() {
	}
	public static int getSerializedSize(Object obj) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obj);
		oos.flush();
		return baos.toByteArray().length;
	}
	
	{
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.load_res, null);
			}
			
			final LinearLayout bg = _view.findViewById(R.id.bg);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final com.a525team.weekbrowser.SkinTextView request = _view.findViewById(R.id.request);
			final com.a525team.weekbrowser.SkinTextView url = _view.findViewById(R.id.url);
			final com.a525team.weekbrowser.SkinTextView method = _view.findViewById(R.id.method);
			final com.a525team.weekbrowser.SkinTextView headers = _view.findViewById(R.id.headers);
			final com.a525team.weekbrowser.SkinTextView ismf = _view.findViewById(R.id.ismf);
			final com.a525team.weekbrowser.SkinTextView isRedirect = _view.findViewById(R.id.isRedirect);
			final com.a525team.weekbrowser.SkinTextView hasGesture = _view.findViewById(R.id.hasGesture);
			final LinearLayout btns = _view.findViewById(R.id.btns);
			final com.a525team.weekbrowser.SkinButton adv = _view.findViewById(R.id.adv);
			final com.a525team.weekbrowser.SkinButton load = _view.findViewById(R.id.load);
			final com.a525team.weekbrowser.SkinButton download = _view.findViewById(R.id.download);
			
			/*final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);

url.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));

method.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
headers.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
ismf.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));

isRedirect.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
hasGesture.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));

adv.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
skin.setBG(adv, 1, false);

download.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
skin.setBG(download, 0, false);

request.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
skin.setBG(request, 0, false);

load.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
skin.setBG(load, 0, false);

Animator2.anim(getApplicationContext(), bg, 0, 200);
*/
			try{
				AtomicBoolean expanded = new AtomicBoolean(false);
				request.setText("[▲] ".concat(getString(R.string.requestdd)));
				url.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						if (btns.getVisibility() == View.VISIBLE) {
							((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _data.get((int)_position).get("url").toString()));
							SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
						} else {
							btns.setVisibility(View.VISIBLE);
							request.setVisibility(View.VISIBLE);
							method.setVisibility(View.VISIBLE);
							headers.setVisibility(View.VISIBLE);
							ismf.setVisibility(View.VISIBLE);
							isRedirect.setVisibility(View.VISIBLE);
							hasGesture.setVisibility(View.VISIBLE);
							url.setText(_data.get((int)_position).get("url").toString());
							if (!expanded.get()) {
								AdBlocker.getInstance(LoadresActivity.this).checkAdButton(adv, _data.get(_position).get("url").toString());
								if (_data.get(_position).get("headers") != null) {
									headers.setText("Headers: ".concat(_data.get((int)_position).get("headers").toString()));
									headers.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
											((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _data.get((int)_position).get("headers").toString()));
											SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
										}
									});
								} else {
									headers.setVisibility(View.GONE);
								}
								if (_data.get(_position).get("method") != null) {
									method.setText("Method: ".concat(_data.get((int)_position).get("method").toString()));
									method.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
											((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _data.get((int)_position).get("method").toString()));
											SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
										}
									});
								} else {
									method.setVisibility(View.GONE);
								}
								if (_data.get(_position).get("isMainFrame") != null) {
									ismf.setText("isMainFrame: ".concat(_data.get((int)_position).get("isMainFrame").toString()));
									ismf.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
											((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _data.get((int)_position).get("isMainFrame").toString()));
											SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
										}
									});
								} else {
									ismf.setVisibility(View.GONE);
								}
								if (_data.get(_position).get("isRedirect") != null && WTF.SDK_INT() >= 24) {
									isRedirect.setText("isRedirect: ".concat(_data.get((int)_position).get("isRedirect").toString()));
									isRedirect.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
											((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _data.get((int)_position).get("isRedirect").toString()));
											SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
										}
									});
								} else {
									isRedirect.setVisibility(View.GONE);
								}
								if (_data.get(_position).get("hasGesture") != null) {
									hasGesture.setText("hasGesture: ".concat(_data.get((int)_position).get("hasGesture").toString()));
									hasGesture.setOnClickListener(new View.OnClickListener() {
										@Override
										public void onClick(View _view) {
											((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _data.get((int)_position).get("hasGesture").toString()));
											SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
										}
									});
								} else {
									hasGesture.setVisibility(View.GONE);
								}
								adv.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										String checkUrl = _data.get(_position).get("url").toString();
										
										AdBlocker.getInstance(LoadresActivity.this).showBlockDialog(LoadresActivity.this, checkUrl, new Runnable() {
											@Override
											public void run() {
												AdBlocker.getInstance(LoadresActivity.this).checkAdButton(adv, checkUrl);
											}
										});
									}
								});
								download.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										String buffer = _data.get((int)_position).get("url").toString();
										
										if (buffer != null && !buffer.isEmpty()) {
											FileDownloader fileDownloader = new FileDownloader(LoadresActivity.this, LoadresActivity.this.webview1);
											fileDownloader.handleBlobFromOtherActivity(buffer);
											
										} else {
											Toast.makeText(getApplicationContext(), "Посилання на елемент відсутнє", Toast.LENGTH_SHORT).show();
										}
										
									}
								});
								request.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										btns.setVisibility(View.GONE);
										request.setVisibility(View.GONE);
										method.setVisibility(View.GONE);
										headers.setVisibility(View.GONE);
										ismf.setVisibility(View.GONE);
										isRedirect.setVisibility(View.GONE);
										hasGesture.setVisibility(View.GONE);
										if (LoadresActivity.this.ends.isChecked()) {
											url.setText("[▼] ".concat(Formater.rshrinkddd(_data.get((int)_position).get("url").toString(), 50)));
										} else {
											url.setText("[▼] ".concat(Formater.shrinkddd(_data.get((int)_position).get("url").toString(), 50)));
										}
									}
								});
								load.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										LoadresActivity.this.webview1.loadUrl(_data.get((int)_position).get("url").toString());
									}
								});
							}
							expanded.set(true);
						}
					}
				});
				btns.setVisibility(View.GONE);
				request.setVisibility(View.GONE);
				method.setVisibility(View.GONE);
				headers.setVisibility(View.GONE);
				ismf.setVisibility(View.GONE);
				isRedirect.setVisibility(View.GONE);
				hasGesture.setVisibility(View.GONE);
				if (LoadresActivity.this.ends.isChecked()) {
					url.setText("[▼] ".concat(Formater.rshrinkddd(_data.get((int)_position).get("url").toString(), 50)));
				} else {
					url.setText("[▼] ".concat(Formater.shrinkddd(_data.get((int)_position).get("url").toString(), 50)));
				}
			}catch(Exception e){
				
			}
			
			return _view;
		}
	}
}