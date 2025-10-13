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
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LoadresActivity extends Activity {
	
	ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	private boolean load = false;
	
	private ArrayList<HashMap<String, Object>> lr = new ArrayList<>();
	
	private Button button1;
	private ListView listview1;
	
	private AlertDialog.Builder blockad;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		ThemeManager.applyTheme(this);
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.loadres);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		button1 = findViewById(R.id.button1);
		listview1 = findViewById(R.id.listview1);
		blockad = new AlertDialog.Builder(this);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				load = true;
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
		});
	}
	
	private void initializeLogic() {
		Skin skin = new Skin();
		    skin.setBG(findViewById(android.R.id.content), 2, true);
		    skin.setBG(button1, 1, false);
		
		    ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		    button1.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		
		    // Захист від null після десеріалізації
		    String jsonData = dataHolder.getData("loadres");
		    if (jsonData != null && !jsonData.isEmpty()) {
			        try {
				            lr = new Gson().fromJson(jsonData, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				        } catch (Exception e) {
				            lr = new ArrayList<>(); // Якщо помилка — створюємо пустий список
				        }
			    } else {
			        lr = new ArrayList<>(); // Якщо дані null/порожні
			    }
		
		    // Перевірка на null перед встановленням адаптера
		    listview1.setAdapter(new Listview1Adapter(lr != null ? lr : new ArrayList<>()));
	}
	
	
	@Override
	public void onResume() {
		super.onResume();
		SafeMarginUtils.init(this, findViewById(android.R.id.content));
	}
	
	@Override
	public void onPause() {
		super.onPause();
		SafeMarginUtils.cleanup();
	}
	public boolean _check(final String _url) {
		AdBlocker adBlocker = new AdBlocker(this);
		return adBlocker.isBlocked(_url);
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
			final WebView webview1 = _view.findViewById(R.id.webview1);
			final TextView request = _view.findViewById(R.id.request);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView url = _view.findViewById(R.id.url);
			final TextView method = _view.findViewById(R.id.method);
			final TextView headers = _view.findViewById(R.id.headers);
			final TextView ismf = _view.findViewById(R.id.ismf);
			final TextView response = _view.findViewById(R.id.response);
			final TextView mime = _view.findViewById(R.id.mime);
			final TextView errc = _view.findViewById(R.id.errc);
			final TextView errp = _view.findViewById(R.id.errp);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final Button adv = _view.findViewById(R.id.adv);
			final Button download = _view.findViewById(R.id.download);
			
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
			// Ініціалізація Skin
			Skin skin = new Skin();
			
			//Colorify Colorify = new Colorify();
			
			//Colorify.setButtonColor(enable, Color.parseColor("#" + dataHolder.getData("cb")));
			
			url.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			
			method.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			headers.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			ismf.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			
			mime.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			errc.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			errp.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			
			request.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			response.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			
			adv.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			skin.setBG(adv, 1, false);
			
			download.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			skin.setBG(download, 0, false);
			
			Animator2.anim(getApplicationContext(), bg, 0, 200);
			try{
				try{
					url.setText(_data.get((int)_position).get("url").toString());
				}catch(Exception e){
					 
				}
				try{
					method.setText(_data.get((int)_position).get("method").toString());
				}catch(Exception e){
					 
				}
				try{
					mime.setText(_data.get((int)_position).get("mime").toString());
				}catch(Exception e){
					 
				}
				try{
					errc.setText(_data.get((int)_position).get("err").toString());
				}catch(Exception e){
					 
				}
				try{
					errp.setText(_data.get((int)_position).get("phrase").toString());
				}catch(Exception e){
					 
				}
				try{
					headers.setText(_data.get((int)_position).get("headers").toString());
				}catch(Exception e){
					 
				}
				try{
					ismf.setText(_data.get((int)_position).get("isMainFrame").toString());
				}catch(Exception e){
					 
				}
				url.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _data.get((int)_position).get("url").toString()));
						SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
					}
				});
				method.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _data.get((int)_position).get("method").toString()));
						SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
					}
				});
				mime.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _data.get((int)_position).get("mime").toString()));
						SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
					}
				});
				errc.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _data.get((int)_position).get("err").toString()));
						SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
					}
				});
				errp.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _data.get((int)_position).get("phrase").toString()));
						SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
					}
				});
				headers.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _data.get((int)_position).get("headers").toString()));
						SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
					}
				});
				ismf.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _data.get((int)_position).get("isMainFrame").toString()));
						SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
					}
				});
				adv.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						String adHosts = sf.getString("adhosts","");
						if (_check(_data.get((int)_position).get("url").toString())) {
							String[] adHostsLines = adHosts.split("\n");
							//StringBuilder updatedAdHosts = new StringBuilder();
							
							for (int h = 0; h < adHostsLines.length; h++) {
								    String line = adHostsLines[h].trim();
								    if (line.startsWith("%")) {
									        // Якщо рядок починається з "%", то шукаємо конкретне посилання
									        if (_data.get((int)_position).get("url").toString().matches(".*" + line.substring(1).trim() + ".*")) {
										            // Видаляємо рядок
										            final int ltr = h;
										            String updatedAdHosts = Arrays.stream(adHostsLines)
										                .filter(l -> !l.equals(adHostsLines[ltr]))
										                .collect(Collectors.joining("\n"));
										
										            // Зберігаємо оновлений результат
										            sf.edit().putString("adhosts", updatedAdHosts).apply();
										
										            SketchwareUtil.showMessage(getApplicationContext(), "This element isn't blocked anymore! (Maybe)");
										
										        }
									    } else {
									        // Якщо це домен, то перевіряємо як раніше
									        if (_extractDomain(_data.get((int)_position).get("url").toString()).matches(".*" + line + ".*")) {
										            final int ltr = h;
										            String updatedAdHosts = Arrays.stream(adHostsLines)
										                .filter(l -> !l.equals(adHostsLines[ltr]))
										                .collect(Collectors.joining("\n"));
										
										            // Зберігаємо оновлений результат
										            sf.edit().putString("adhosts", updatedAdHosts).apply();
										
										            SketchwareUtil.showMessage(getApplicationContext(), "This element isn't blocked anymore! (Maybe)");
										
										        }
									    }
							}
							
							adv.setText(((_check(_data.get((int)_position).get("url").toString())) ? (getString(R.string.is_not_ad)) : (getString(R.string.is_ad))));
						} else {
							try{
								blockad.setTitle("?");
								blockad.setMessage(getString(R.string.blocksite1).concat(_extractDomain(_data.get((int)_position).get("url").toString())).concat(getString(R.string.blocksite2).concat(_data.get((int)_position).get("url").toString())));
								blockad.setPositiveButton("[    1    ]", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										sf.edit().putString("adhosts", sf.getString("adhosts", "").concat("\n").concat(_extractDomain(_data.get((int)_position).get("url").toString()).replace(".", "\\."))).commit();
										adv.setText(((_check(_data.get((int)_position).get("url").toString())) ? (getString(R.string.is_not_ad)) : (getString(R.string.is_ad))));
									}
								});
								blockad.setNegativeButton("[    2    ]", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										sf.edit().putString("adhosts", sf.getString("adhosts", "").concat("\n%".concat(_data.get((int)_position).get("url").toString().replace(".", "\\.")))).commit();
										adv.setText(((_check(_data.get((int)_position).get("url").toString())) ? (getString(R.string.is_not_ad)) : (getString(R.string.is_ad))));
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
				if (load) {
					webview1.getSettings().setBuiltInZoomControls(true);
					webview1.getSettings().setDisplayZoomControls(false);
					webview1.getSettings().setLoadWithOverviewMode(true);
					webview1.getSettings().setUseWideViewPort(false);
					webview1.getSettings().setSaveFormData(true);
					    webview1.getSettings().setAllowFileAccess(true);
					    webview1.getSettings().setAllowContentAccess(true);
					    webview1.getSettings().setDatabaseEnabled(true);
					    webview1.getSettings().setDomStorageEnabled(true);
					    webview1.getSettings().setGeolocationEnabled(true);
					    webview1.getSettings().setAllowFileAccessFromFileURLs(true);
					    webview1.getSettings().setAllowUniversalAccessFromFileURLs(true);
					    webview1.getSettings().setPluginState(WebSettings.PluginState.ON);
					    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
						    webview1.setRendererPriorityPolicy(WebView.RENDERER_PRIORITY_IMPORTANT, true);
					}
					   
					webview1.getSettings().setMediaPlaybackRequiresUserGesture(false);
					 webview1.setLayerType(View.LAYER_TYPE_HARDWARE, null);
					    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
						        
						    webview1.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);}
					         
					    if(sf.getString("incognito", "").equals("1")){
						        CookieManager.getInstance().setAcceptCookie(false);
						        if (android.os.Build.VERSION.SDK_INT >= 21) { CookieManager.getInstance().setAcceptThirdPartyCookies(webview1, false);}
						        }else{
						        CookieManager.getInstance().setAcceptCookie(true);
						        if (android.os.Build.VERSION.SDK_INT >= 21) { CookieManager.getInstance().setAcceptThirdPartyCookies(webview1, true);}
						        }
					
					webview1.setWebViewClient(new WebViewClient() {
						    @Override
						    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
							        view.loadUrl(request.getUrl().toString());
							        return true;
							    }
					});
					webview1.setWebChromeClient(new WebChromeClient());
					
					webview1.loadUrl(_data.get((int)_position).get("url").toString());
				} else {
					webview1.setVisibility(View.GONE);
				}
				adv.setText(((_check(_data.get((int)_position).get("url").toString())) ? (getString(R.string.is_not_ad)) : (getString(R.string.is_ad))));
				download.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						String buffer = _data.get((int)_position).get("url").toString();
						
						if (buffer != null && !buffer.isEmpty()) {
							FileDownloader fileDownloader = new FileDownloader(LoadresActivity.this, webview1);
							fileDownloader.handleBlobFromOtherActivity(buffer);
							
						} else {
							    Toast.makeText(getApplicationContext(), "Посилання на елемент відсутнє", Toast.LENGTH_SHORT).show();
						}
						
					}
				});
			}catch(Exception e){
				 
			}
			
			return _view;
		}
	}
}