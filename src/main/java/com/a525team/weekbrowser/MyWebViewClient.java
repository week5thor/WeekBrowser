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

public class MyWebViewClient extends WebViewClient {

    private static final int MAX_RESOURCES = 500;
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
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        try {
            if (activity == null) {
                return super.shouldInterceptRequest(view, url);
            }

            // Special case for bookmark.json
            if (url.equals("file://" + activity.getFilesDir().getPath() + "/bookmark.json")) {
                return handleBookmarkRequest();
            }

            // Ad blocking
            if (sf.getString("blockad", "").equals("1") && adBlocker.isBlocked(url)) {
                if (activity instanceof MainActivity) {
                    ((MainActivity) activity)._adsblocked();
                }
                return AdBlocker.pseudoAd(url);
            }

            WebResourceResponse response = extensionUtil.onShouldInterceptRequest(view, url);
            
            // Resource monitoring
            if (sf.getString("monitorres", "").equals("1")) {
                synchronized (loadedResources) {
                    if (loadedResources.size() < MAX_RESOURCES) {
                        HashMap<String, Object> resourceData = new HashMap<>();
                        resourceData.put("url", url);
                        resourceData.put("method", "N/A");
                        resourceData.put("headers", "N/A");
                        resourceData.put("isMainFrame", "N/A");
                        loadedResources.add(resourceData);
                    }
                }
            }

            return response != null ? response : super.shouldInterceptRequest(view, url);
        } catch (Exception e) {
            Log.e("WebViewClient", "Legacy intercept error", e);
            return new WebResourceResponse("text/plain", "utf-8", 
                    new ByteArrayInputStream(("Legacy intercept error: " + e.getMessage()).getBytes()));
        }
    }

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        try {
            if (activity == null || Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                return super.shouldInterceptRequest(view, request);
            }

            String url = request.getUrl().toString();

            // Special case for bookmark.json
            if (url.equals("file://" + activity.getFilesDir().getPath() + "/bookmark.json")) {
                return handleBookmarkRequest();
            }

            // Ad blocking
            if (sf.getString("blockad", "").equals("1") && adBlocker.isBlocked(url)) {
                if (activity instanceof MainActivity) {
                    ((MainActivity) activity)._adsblocked();
                }
                return AdBlocker.pseudoAd(url);
            }

            WebResourceResponse response = extensionUtil.onShouldInterceptRequest(view, request);
            if (response == null) {
                response = super.shouldInterceptRequest(view, request);
            }

            // Resource monitoring
            if (sf.getString("monitorres", "").equals("1") && response != null) {
                synchronized (loadedResources) {
                    if (loadedResources.size() < MAX_RESOURCES) {
                        HashMap<String, Object> resourceData = new HashMap<>();
                        resourceData.put("url", url);
                        resourceData.put("method", request.getMethod());
                        resourceData.put("headers", request.getRequestHeaders());
                        resourceData.put("isMainFrame", request.isForMainFrame());
                        loadedResources.add(resourceData);
                    }
                }
            }

            return response;
        } catch (Exception e) {
            Log.e("WebViewClient", "Intercept error", e);
            return new WebResourceResponse("text/plain", "utf-8", 
                    new ByteArrayInputStream(("Intercept error: " + e.getMessage()).getBytes()));
        }
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
                if (activity instanceof MainActivity) {
                    ((MainActivity) activity)._overrideload(view, url);
                }
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
        super.onPageStarted(view, url, favicon);
        currentUrl = url;
        if (activity instanceof MainActivity) {
            ((MainActivity) activity)._onpagestart(view, url, favicon);
        }
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        
        view.loadUrl(
    "javascript:(() => {" +
    "  function getElementSelector(el) {" +
    "    if (el.id) return '#' + el.id;" +
    "    if (el.name) return 'input[name=\"' + el.name + '\"]';" +
    "    let path = [];" +
    "    while (el && el.nodeType === Node.ELEMENT_NODE) {" +
    "      let selector = el.nodeName.toLowerCase();" +
    "      if (el.className) {" +
    "        selector += '.' + el.className.trim().replace(/\\s+/g, '.');" +
    "      }" +
    "      let sibling = el;" +
    "      let nth = 1;" +
    "      while ((sibling = sibling.previousElementSibling) != null) {" +
    "        if (sibling.nodeName === el.nodeName) nth++;" +
    "      }" +
    "      selector += ':nth-of-type(' + nth + ')';" +
    "      path.unshift(selector);" +
    "      el = el.parentNode;" +
    "    }" +
    "    return path.join(' > ');" +
    "  }" +
    "  document.querySelectorAll('input[type=color]').forEach(el => {" +
    "    el.addEventListener('click', e => {" +
    "      e.preventDefault();" +
    "      const current = el.value.replace('#', '') || '000000';" +
    "      const selector = getElementSelector(el);" +
    "      AndroidColorPicker.openColorPicker(selector, current);" +
    "    });" +
    "  });" +
    "})()"
);


        if (extensionUtil != null) {
            extensionUtil.onPageFinished(view, url);
        }
        
        if (activity instanceof MainActivity) {
            ((MainActivity) activity)._onpagefinish(view, false);
        }

        if (sf.getString("monitorres", "").equals("1")) {
            processLoadedResources();
        }
    }

    private void processLoadedResources() {
        final ArrayList<HashMap<String, Object>> resourcesCopy;
        synchronized (loadedResources) {
            if (loadedResources.isEmpty()) {
                return;
            }
            resourcesCopy = new ArrayList<>(loadedResources);
            loadedResources.clear();
        }

        jsonExecutor.execute(() -> {
            try {
                JSONArray jsonArray = new JSONArray();
                for (HashMap<String, Object> resource : resourcesCopy) {
                    jsonArray.put(new JSONObject(resource));
                }
                dataHolder.setData("loadres", jsonArray.toString());
            } catch (Exception e) {
                Log.e("WebViewClient", "Failed to serialize resources", e);
            }
        });
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