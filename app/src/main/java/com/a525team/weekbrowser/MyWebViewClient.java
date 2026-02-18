package com.a525team.weekbrowser;

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
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import android.annotation.TargetApi;

public class MyWebViewClient extends WebViewClient {
	
	private static final int MAX_RESOURCES = 1000;
	private static final ExecutorService jsonExecutor = Executors.newSingleThreadExecutor();
	
	private Activity activity;
	private final Set<String> blockedHosts;
	private final Set<String> blockedUrls;
	private String currentUrl;
	private ExtensionUtil extensionUtil;
	private final AdBlocker adBlocker;
	private final ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	private final ArrayList<HashMap<String, Object>> loadedResources = new ArrayList<>();
	private final SharedPreferences sf;
	private boolean onAd;
	
	public MyWebViewClient(Activity activity) {
		this.activity = activity;
		this.adBlocker = AdBlocker.getInstance(this.activity);
		this.extensionUtil = ExtensionUtil.getInstance(this.activity);
		this.blockedHosts = new HashSet<>();
		this.blockedUrls = new HashSet<>();
		this.sf = (this.activity != null)
		? this.activity.getSharedPreferences("sf", Context.MODE_PRIVATE)
		: null;
	}
	
	@Override
	public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
		
		try {
			String url = request.getUrl().toString();
			
			// Special case for bookmark.json
			if (activity != null && url.equals("file://" + activity.getFilesDir().getPath() + "/bookmark.json")) {
				return handleBookmarkRequest();
			}
			
			// Ad blocking
			if (adBlocker != null && onAd && adBlocker.isBlocked(url)) {
				if (activity instanceof MainActivity) {
					((MainActivity) activity)._adsblocked();
				}
				return AdBlocker.pseudoAd(url);
			}
			
			WebResourceResponse response = extensionUtil != null
			? extensionUtil.onShouldInterceptRequest(view, request)
			: null;
			
			if (response == null) {
				response = super.shouldInterceptRequest(view, request);
			}
			
			// Resource monitoring
				synchronized (loadedResources) {
					if (loadedResources.size() < MAX_RESOURCES) {
						HashMap<String, Object> resourceData = new HashMap<>();
						resourceData.put("url", url);
						resourceData.put("method", request.getMethod() == null ? "N/A" : request.getMethod());
						resourceData.put("headers", request.getRequestHeaders() == null ? "N/A" : request.getRequestHeaders());
						resourceData.put("isMainFrame", request.isForMainFrame());
						
						// getStatusCode() і getReasonPhrase() можуть кидати Exception, тому try-catch
						try {
                            // Обов’язкова перевірка на null для response!
						resourceData.put("mime", response.getMimeType() == null ? "N/A" : response.getMimeType());
							resourceData.put("err", response.getStatusCode());
							resourceData.put("phrase", response.getReasonPhrase() == null ? "N/A" : response.getReasonPhrase());
						} catch (Throwable ignore) {
							resourceData.put("err", "N/A");
							resourceData.put("phrase", "N/A");
						}
						dataHolder.setData("loadres", JsonUtils.toJson(loadedResources));
						loadedResources.add(resourceData);
					}
				}
			
			return response;
		} catch (Exception e) {
			Log.e("WebViewClient", "Intercept error", e);
			return new WebResourceResponse(
			"text/plain", "utf-8",
			new ByteArrayInputStream(("Intercept error: " + e.getMessage()).getBytes())
			);
		}
	}
	
	@Override
	public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
		// Цей метод тепер буде викликатися тільки на API < 21
		if(WTF.SDK_INT()<21){
			try {
				if (activity != null && url.equals("file://" + activity.getFilesDir().getPath() + "/bookmark.json")) {
					return handleBookmarkRequest();
				}
				
				if (adBlocker != null && onAd && adBlocker.isBlocked(url)) {
					if (activity instanceof MainActivity) {
						((MainActivity) activity)._adsblocked();
					}
					return AdBlocker.pseudoAd(url);
				}
				
				WebResourceResponse response = extensionUtil != null
				? extensionUtil.onShouldInterceptRequest(view, url)
				: null;
				
				synchronized (loadedResources) {
					if (loadedResources.size() < MAX_RESOURCES) {
						HashMap<String, Object> resourceData = new HashMap<>();
						resourceData.put("url", url);
						resourceData.put("method", "N/A");
						try {
							resourceData.put("mime", response.getMimeType());
							resourceData.put("err", response.getStatusCode());
							resourceData.put("phrase", response.getReasonPhrase());
						} catch (Throwable ignore) {
							resourceData.put("mime", "N/A");
							resourceData.put("err", "N/A");
							resourceData.put("phrase", "N/A");
						}
						resourceData.put("headers", "N/A");
						resourceData.put("isMainFrame", "N/A");
						loadedResources.add(resourceData);
                        dataHolder.setData("loadres", JsonUtils.toJson(loadedResources));
					}
				}
				
				return response != null ? response : super.shouldInterceptRequest(view, url);
			} catch (Exception e) {
				Log.e("WebViewClient", "Legacy intercept error", e);
				return new WebResourceResponse(
				"text/plain", "utf-8",
				new ByteArrayInputStream(("Legacy intercept error: " + e.getMessage()).getBytes())
				);
			}
		}else return super.shouldInterceptRequest(view, url);
	}
	
	
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
	
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
		if (activity == null) {
			return true;
		}
		
		String url = request.getUrl().toString();
		
		// Ad blocking for redirects
		if (url != null && adBlocker.isBlocked(url) && adBlocker.blockRedir()) {
			if (activity instanceof MainActivity) {
				((MainActivity) activity)._accessdenied(url);
			}
			return true;
		}
		
		if (url.startsWith("https://") || url.startsWith("http://") || 
		url.startsWith("file://") || url.startsWith("content://") || 
		url.contains("about:blank")) {
			
			if (url.startsWith("https://extensions.weekbrowser.com") || 
			url.startsWith("https://skins.weekbrowser.com/general") || 
			url.startsWith("https://skins.weekbrowser.com/bookmarks") || 
			url.startsWith("https://multilink2.weekbrowser.com")) {
				
				Intent intent = new Intent();
				intent.setClass(activity, IntentActivity.class);
				intent.setData(Uri.parse(url));
				activity.startActivity(intent);
				
				if (activity instanceof MainActivity) {
					((MainActivity) activity)._finish();
				}
				return true;
			} else {
				return super.shouldOverrideUrlLoading(view, request);
			}
		} else {
			if (activity instanceof MainActivity) {
				((MainActivity) activity)._openToast(url);
			}
			return true;
		}
	}
	
	@Override
	public void onPageStarted(WebView view, String url, Bitmap favicon) {
        loadedResources.clear();
        dataHolder.setData("loadres", "[]");
		super.onPageStarted(view, url, favicon);
		currentUrl = url;
		if (activity instanceof MainActivity) {
			onAd = ((MainActivity) activity)._onpagestart(view, url, favicon);
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
	public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
		super.onReceivedError(view, request, error);
		if (activity instanceof MainActivity && request.isForMainFrame()) {
			((MainActivity) activity)._onpagefail(view, error.getDescription().toString());
		}
	}
	
	@Override
	public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
		// Always proceed with SSL errors (original behavior)
		if (activity instanceof MainActivity) {
			((MainActivity) activity)._sslerror();
		}
		handler.proceed();
	}
	
	public void destroy() {
		activity = null;
		extensionUtil = null;
		synchronized (loadedResources) {
			loadedResources.clear();
		}
	}
}
