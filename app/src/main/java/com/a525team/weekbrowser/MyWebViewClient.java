package com.a525team.weekbrowser;

import android.app.AlertDialog;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List; // ДОДАНО: імпорт List
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

import java.util.concurrent.*;

//import android.annotation.TargetApi;

public class MyWebViewClient extends WebViewClient {
	private static final ExecutorService jsonExecutor = Executors.newSingleThreadExecutor();
	
	private Activity activity;
	private final Set<String> blockedHosts;
	private final Set<String> blockedUrls;
	private String currentUrl;
	private ExtensionUtil extensionUtil;
	private final AdBlocker adBlocker;
	private final ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	private final SharedPreferences sf;
	private String pUrl;
	private boolean isAd = false;
	
	private static final int MAX_RESOURCES = 1000;
	private final ResourceManager resourceManager = ResourceManager.getInstance();
	public volatile boolean isDetailedLoggingEnabled = false;
	private final SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener;
	
	// Список доменів, яким користувач дозволив SSL у цій сесії
	private final Set<String> sessionTrustedDomains = new HashSet<>();
	
	public MyWebViewClient(Activity activity) {
		this.activity = activity;
		this.adBlocker = AdBlocker.getInstance(this.activity);
		this.extensionUtil = ExtensionUtil.getInstance(this.activity);
		this.blockedHosts = new HashSet<>();
		this.blockedUrls = new HashSet<>();
		this.sf = (this.activity != null)
		? this.activity.getSharedPreferences("sf", Context.MODE_PRIVATE)
		: null;
		this.isDetailedLoggingEnabled = sf.getString("detailed_logs", "0").equals("1");
		// Створюємо слухач, який автоматично оновить змінну, як тільки користувач змінить налаштування
		this.preferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
			@Override
			public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
				if ("detailed_logs".equals(key)) {
					isDetailedLoggingEnabled = sharedPreferences.getString("detailed_logs", "0").equals("1");
					Log.d("WebViewClient", "Детальне логування змінено автоматично на: " + isDetailedLoggingEnabled);
				}
			}
		};
		// Реєструємо слухач
		sf.registerOnSharedPreferenceChangeListener(preferenceChangeListener);
	}
	
	// ВИПРАВЛЕНО: додано boolean isRedirect, boolean hasGesture в параметри
	private WebResourceResponse processRequest(WebView view, WebResourceRequest request) {
		String url = request.getUrl().toString();
		String method = request.getMethod();
		Map<String, String> headers = request.getRequestHeaders();
		boolean isMainFrame = request.isForMainFrame();
		boolean isRedirect = WTF.SDK_INT() >= 24 ? request.isRedirect() : false;
		boolean hasGesture = request.hasGesture();
		
		// Моніторинг ресурсів
		Object tag = view.getTag();
		if (tag != null) {
			logResource(tag, url, method, headers, isMainFrame, isRedirect, hasGesture);
		}
		
		try {
			// 1. Спеціальні випадки (Bookmarks)
			if (activity != null && url.equals("file://" + activity.getFilesDir().getPath() + "/bookmark.json")) {
				return handleBookmarkRequest();
			}
			
			// 2. Реклама
			int adN = adBlocker.isBlocked(url);
			
			if (adBlocker != null && getAd(url, view.getTag()) && adN != 0) {
				if (activity instanceof MainActivity) {
					((MainActivity) activity)._adsblocked();
				}
				return AdBlocker.pseudoAd(url);
			}
			
			// 3. Розширення
			WebResourceResponse response = extensionUtil != null
			? extensionUtil.onShouldInterceptRequest(view, request)
			: null;
			
			if (response == null) {
				response = super.shouldInterceptRequest(view, url);
			}
			
			return response;
		} catch (Exception e) {
			Log.e("WebViewClient", "Error", e);
			return null;
		}
		// ВИПРАВЛЕНО: видалено дублюючий catch-блок, який ламав синтаксис
	}
	
	private boolean getAd(String url, Object tag){
		try{
			if(url.equals(pUrl)) return isAd;
			else
			return resourceManager.getAdForTab(tag);
		}catch(Throwable t){return false;}
	}
	
	// ДОДАНО: повернуто метод обробки закладок
	private WebResourceResponse handleBookmarkRequest() {
		try {
			String html = HomePageGen.generateHtml(activity);
			return new WebResourceResponse("text/html", "utf-8", 
			new ByteArrayInputStream(html.getBytes("utf-8")));
		} catch (Exception e) {
			return new WebResourceResponse("text/plain", "utf-8", 
			new ByteArrayInputStream(e.toString().getBytes()));
		}
	}
	
	private void logResource(Object tag, String url, String method, Map<String, String> headers, boolean isMainFrame, boolean isRedirect, boolean hasGesture) {
		List<Map<String, Object>> resources = resourceManager.getOrCreateResourcesForTab(tag);
		if (resources == null) return;
		
		synchronized (resources) {
			if (resources.size() >= MAX_RESOURCES) {
				resources.remove(0);
			}
			
			HashMap<String, Object> data = new HashMap<>();
			data.put("url", url);
			
			if (isDetailedLoggingEnabled && WTF.SDK_INT() >= 21) {
				data.put("isRedirect", isRedirect);
				data.put("hasGesture", hasGesture);
				data.put("method", method != null ? method : "GET");
				data.put("isMainFrame", isMainFrame);
				data.put("headers", headers != null ? headers : "N/A");
			}
			resources.add(data);
		}
	}
	
	// Сучасна версія (API 21+)
	@Override
	public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
		return processRequest(view, request);
	}
	
	// Для Android 5.0 та вище (API 21+)
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
		return handleUrl(view, request.getUrl().toString());
	}
	
	// Єдиний метод для обробки логіки
	private boolean handleUrl(WebView view, String url) {
		if (activity == null || url == null) return true;
		
		// 1. Блокувальник реклами
		int adN = adBlocker.isBlocked(url);
		if (adN != 0 && adBlocker.blockRedir()) {
			if (activity instanceof MainActivity) {
				((MainActivity) activity)._accessdenied(adN);
			}
			return true;
		}
		
		Uri uri = Uri.parse(url);
		String scheme = uri.getScheme();
		
		// 2. Внутрішні посилання WeekBrowser
		if (isInternalAppUrl(uri)) {
			Intent intent = new Intent(activity, IntentActivity.class);
			intent.setData(uri);
			activity.startActivity(intent);
			if (activity instanceof MainActivity) ((MainActivity) activity)._finish();
			return true;
		}
		
		// 3. Стандартні схеми, які WebView малює сам
		if (scheme != null && (scheme.equals("http") || scheme.equals("https") || 
		scheme.equals("file") || scheme.equals("content") || 
		scheme.equals("data") || url.startsWith("about:"))) {
			//if (activity instanceof MainActivity)
			//((MainActivity) activity)._setAll(view);
			return false; 
		}
		
		// 4. Все інше (tel, mailto, intent, market тощо) — у ваш діалог-чоозер
		// Викликаємо ваш метод openInOtherApps
		if (activity instanceof MainActivity)
		((MainActivity) activity)._openToast(url);
		return true;
	}
	
	// Допоміжний метод для чистішого коду
	private boolean isInternalAppUrl(Uri uri) {
		String host = uri.getHost();
		if (host == null) return false;
		
		return host.equals("extensions.weekbrowser.com") || 
		host.equals("skins.weekbrowser.com") || 
		host.equals("multilink2.weekbrowser.com") ||
		host.equals("colorpicker.weekbrowser.com") ||
		host.equals("texteditor.weekbrowser.com");
	}
	
	@Override
	public void onPageStarted(WebView view, String url, Bitmap favicon) {
		Object tag = view.getTag();
		resourceManager.clearResourcesForTab(tag);
		
		// ВАЖЛИВО: ПРИБИРАЄМО звідси resourceManager.clearSslErrorForTab(tag); !!!
		// Ми більше не видаляємо помилки при старті сторінки
		
		super.onPageStarted(view, url, favicon);
		currentUrl = url;
		
		if (activity instanceof MainActivity) {
			//((MainActivity) activity)._tabupd();
			((MainActivity) activity)._onpagestart(view, url, favicon);
		}
	}
	
	@Override
	public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
		String errorType = "SSL_GENERIC";
		switch (error.getPrimaryError()) {
			case SslError.SSL_EXPIRED: errorType = "SSL_EXPIRED"; break;
			case SslError.SSL_UNTRUSTED: errorType = "SSL_UNTRUSTED"; break;
			case SslError.SSL_IDMISMATCH: errorType = "SSL_IDMISMATCH"; break;
			case SslError.SSL_NOTYETVALID: errorType = "SSL_NOTYETVALID"; break;
			case SslError.SSL_DATE_INVALID: errorType = "SSL_DATE_INVALID"; break;
		}
		
		String url = error.getUrl();
		if (url == null) url = view.getUrl();
		String host = url != null ? Uri.parse(url).getHost() : null;
		
		// 1. ОДРАЗУ записуємо помилку. Якщо юзер натисне "Відхилити", ми залишимось на старій сторінці, 
		// і кнопка не почервоніє. Якщо погодиться - сторінка завантажиться, і кнопка стане червоною.
		if (host != null) {
			ResourceManager.getInstance().setSslErrorForTab(host, errorType);
		}
		
		// Оновлюємо інтерфейс миттєво, якщо це потрібно для поточної активної вкладки
		if (activity instanceof MainActivity) {
			activity.runOnUiThread(() -> ((MainActivity) activity)._tabupd());
		}
		
		// 2. Будуємо детальне повідомлення (використовуємо сертифікат з об'єкта SslError)
		String detailedMessage = SslMessageBuilder.build(activity, url, error.getCertificate(), errorType);
		
		// 3. Показуємо діалог (через runOnUiThread, бо це фоновий потік WebView)
		if (activity != null) {
			activity.runOnUiThread(() -> {
				AlertDialog.Builder builder = new AlertDialog.Builder(activity);
				builder.setTitle("Помилка безпеки SSL");
				
				// Використовуємо наш згенерований текст
				builder.setMessage(detailedMessage);
				
				builder.setNegativeButton("Відхилити", (dialog, which) -> {
					handler.cancel();
				});
				
				builder.setPositiveButton("Продовжити (сесія)", (dialog, which) -> {
					handler.proceed();
				});
				
				builder.setOnCancelListener(dialog -> handler.cancel());
				
				AlertDialog dialog = builder.create();
				
				// Застосовуємо розмиття фону через вашу утиліту
				RenderUtils.setupDialogDim(activity, dialog);
				
				dialog.show();
			});
		} else {
			handler.cancel();
		}
	}
	
	@Override
	public void onPageFinished(WebView view, String url) {
		super.onPageFinished(view, url);
		view.loadUrl(
		"javascript:(function(){" +
		
		"function retryUntilExists(context, selector, cb, tries){" +
		"  if (tries === 0) return console.warn('Element not found:', selector);" +
		"  const el = context.querySelector(selector);" +
		"  if (el) return cb(el);" +
		"  setTimeout(function(){" +
		"    retryUntilExists(context, selector, cb, tries - 1);" +
		"  }, 100);" +
		"}" +
		
		"function getElementFullSelector(el){" +
		"  let path = [];" +
		"  let current = el;" +
		"  let iframeSelector = '';" +
		"  while(current){" +
		"    if(current.tagName === 'IFRAME'){ break; }" +
		"    let selector = current.nodeName.toLowerCase();" +
		"    if(current.id){ selector = '#' + current.id; path.unshift(selector); break; }" +
		"    else if(current.className){ selector += '.' + current.className.trim().replace(/\\s+/g, '.'); }" +
		"    let sibling = current; let nth = 1;" +
		"    while((sibling = sibling.previousElementSibling) != null){" +
		"      if(sibling.nodeName === current.nodeName) nth++;" +
		"    }" +
		"    selector += ':nth-of-type(' + nth + ')';" +
		"    path.unshift(selector);" +
		"    current = current.parentElement;" +
		"  }" +
		"  const rootIframe = el.ownerDocument.defaultView.frameElement;" +
		"  if(rootIframe){" +
		"    if(rootIframe.id) iframeSelector = 'iframe#' + rootIframe.id;" +
		"    else if(rootIframe.name) iframeSelector = 'iframe[name=\"' + rootIframe.name + '\"]';" +
		"    else iframeSelector = 'iframe';" +
		"  }" +
		"  return { iframeSelector: iframeSelector, inputSelector: path.join(' > ') };" +
		"}" +
		
		"function setupColorPickers(doc){" +
		"  doc.querySelectorAll('input[type=color]').forEach(el => {" +
		"    if(el.dataset.customized) return;" +
		"    el.dataset.customized = 'true';" +
		"    el.addEventListener('click', function(e){" +
		"      e.preventDefault();" +
		"      const current = el.value.replace('#','') || '000000';" +
		"      const sel = getElementFullSelector(el);" +
		"      if(window.AndroidColorPicker){" +
		"        AndroidColorPicker.openColorPicker(sel.iframeSelector, sel.inputSelector, current);" +
		"      }" +
		"    });" +
		"  });" +
		"}" +
		
		"function setupAllFrames(win){" +
		"  try{ setupColorPickers(win.document); }catch(e){}" +
		"  for(let i=0; i<win.frames.length; i++){" +
		"    try{ setupAllFrames(win.frames[i]); }catch(e){}" +
		"  }" +
		"}" +
		
		"window.setColorInputValue = function(iframeSelector, inputSelector, newValue){" +
		"  let context = document;" +
		"  if(iframeSelector && iframeSelector.length > 0){" +
		"    const iframe = document.querySelector(iframeSelector);" +
		"    if(!iframe) return console.error('Iframe not found:', iframeSelector);" +
		"    try{ context = iframe.contentDocument || iframe.contentWindow.document; }" +
		"    catch(e){ return console.error('Cannot access iframe content:', e); }" +
		"  }" +
		"  retryUntilExists(context, inputSelector, function(el){" +
		"    el.value = '#' + newValue;" +
		"    el.dispatchEvent(new Event('input', {bubbles:true}));" +
		"    el.dispatchEvent(new Event('change', {bubbles:true}));" +
		"    el.focus(); el.blur();" +
		"  }, 10);" +
		"};" +
		
		"setupAllFrames(window);" +
		
		"})()"
		);
		
		if (activity instanceof MainActivity) {
			((MainActivity) activity)._onpagefinish(view, false);
		}
		
		if (extensionUtil != null) {
			extensionUtil.onPageFinished(view, url);
		}
		
	}
	
	@Override
	public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
		super.doUpdateVisitedHistory(view, url, isReload);
		
		// 1. Одразу відсікаємо сміття за URL, прямо тут
		if (url == null || url.isEmpty() || url.equals("about:blank") || url.contains("bookmark.html")) {
			return;
		}
		
		// 2. Робимо мікрозатримку (наприклад, 400 мс)
		// Це потрібно, щоб WebView встиг отримати актуальний Title сторінки (особливо на YouTube)
		view.postDelayed(() -> {
			try {
				if (activity != null && !activity.isFinishing()) {
					String currentTitle = view.getTitle();
					String finalTitle = (currentTitle != null && !currentTitle.isEmpty()) ? currentTitle : "UNTITLED :/";
					if (activity instanceof MainActivity) {
						// 3. Викликаємо твоє збереження
						((MainActivity) activity).saveToHistory(finalTitle, url);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, 400); 
	}
	
	public void destroy(WebView view) {
		activity = null;
		extensionUtil = null;
		if (view != null) {
			resourceManager.removeTab(view.getTag());
		}
	}
}
