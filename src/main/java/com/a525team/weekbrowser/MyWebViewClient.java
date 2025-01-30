package com.a525team.weekbrowser;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.net.URL;
import java.net.HttpURLConnection;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;


public class MyWebViewClient extends WebViewClient {

    private Activity activity;
    private boolean adlockEnabled = true;
    private final Set<String> blockedHosts;
    private final Set<String> blockedUrls;
    private String currentUrl;
    private ExtensionUtil extensionUtil;
    private final AdBlocker adBlocker;
    private final ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
    private final ArrayList<HashMap<String, Object>> loadedResources = new ArrayList<>();

    public MyWebViewClient(Activity activity) {
        this.activity = activity;
        this.adBlocker = new AdBlocker(activity);
        this.extensionUtil = new ExtensionUtil(activity);
        this.blockedHosts = new HashSet<>();
        this.blockedUrls = new HashSet<>();

    }

@Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        String url = request.getUrl().toString();

        // Перевірка через AdBlocker
        if (adBlocker.isBlocked(url)) {
            ((MainActivity) activity)._adsblocked();
            return new WebResourceResponse("text/plain", "utf-8", new ByteArrayInputStream("".getBytes()));
        }

        // Використання розширень (за наявності)
        WebResourceResponse extResponse = extensionUtil.onShouldInterceptRequest(view, request);
        if (extResponse != null) {
            return extResponse;
        }

        // Звичайна обробка
        WebResourceResponse response = super.shouldInterceptRequest(view, request);
        if (response != null) {
            return removeSecurityHeaders(response);
        }
//        
        HashMap<String, Object> resourceData = new HashMap<>();
        resourceData.put("url", request.getUrl().toString());
        resourceData.put("method", request.getMethod());
        resourceData.put("headers", request.getRequestHeaders());
        resourceData.put("isMainFrame", request.isForMainFrame());

        // Додаємо ресурс до списку
        loadedResources.add(resourceData);
//
        return response;
    }

private WebResourceResponse removeSecurityHeaders(WebResourceResponse response) {
    if (response != null) {
        // Отримуємо поточні заголовки відповіді
        Map<String, String> headers = new HashMap<>(response.getResponseHeaders());

        // Видаляємо заголовки безпеки, які можуть заважати
        headers.remove("X-Frame-Options"); // Дозволяє показувати контент у iframe
        headers.remove("Content-Security-Policy"); // Знімає політики безпеки контенту
        headers.remove("X-Content-Security-Policy"); // Альтернативна версія CSP
        headers.remove("X-WebKit-CSP"); // CSP для WebKit браузерів
        headers.remove("Strict-Transport-Security"); // Забороняє принудительный HTTPS
        headers.remove("Referrer-Policy"); // Контролює відправку заголовка `Referer`

        // Додаємо CORS заголовки для обходу політики Same-Origin
        headers.put("Access-Control-Allow-Headers", "Accept, Accept-Language, Authorization, Cache-Control, Content-Disposition, Content-Encoding, Content-Language, Content-Length, Content-MD5, Content-Range, Content-Type, Date, Host, If-Match, If-Modified-Since, If-None-Match, If-Unmodified-Since, Origin, OriginToken, Pragma, Range, Slug, Transfer-Encoding, Want-Digest, X-MediaBrowser-Token, X-Emby-Token, X-Emby-Client, X-Emby-Client-Version, X-Emby-Device-Id, X-Emby-Device-Name, X-Emby-Authorization");
        headers.put("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, PATCH, OPTIONS");
        headers.put("Access-Control-Allow-Origin", "*");
        headers.put("Access-Control-Allow-Credentials", "true"); // Дозволяє надсилати cookie
        headers.put("Access-Control-Expose-Headers", "Content-Length, X-JSON"); // Дозволяє клієнту отримувати ці заголовки
        headers.put("Access-Control-Allow-Private-Network", "true"); // Доступ до приватних мереж
        headers.put("Cross-Origin-Resource-Policy", "cross-origin"); // Дозволяє доступ до ресурсів з інших доменів
        headers.put("Cross-Origin-Opener-Policy", "same-origin-allow-popups"); // Дозволяє попапам працювати крос-домен
        headers.put("Cross-Origin-Embedder-Policy", "require-corp"); // Дозволяє вбудовування з іншими ресурсами

        // Змінюємо або додаємо Content-Type, якщо він відсутній
        headers.put("Content-Type", response.getMimeType() != null ? response.getMimeType() : "text/html; charset=UTF-8");

        // Створюємо новий WebResourceResponse з оновленими заголовками
        return new WebResourceResponse(
                response.getMimeType(),
                response.getEncoding(),
                response.getStatusCode(),
                response.getReasonPhrase(),
                headers,
                response.getData()
        );
    }
    return response;
}


    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                   
        String url = request.getUrl().toString();
        
            if (url != null && adBlocker.isBlocked(url) && ((MainActivity) activity)._isaccess()) {
                ((MainActivity) activity)._accessdenied(/*blockedHost*/url);
                return true; // Cancel loading this URL
            }
        

        if(url.startsWith("https://")||url.startsWith("http://")||url.startsWith("file://")||url.startsWith("content://")||url.contains("about:blank")){
                ((MainActivity) activity)._overrideload(view, url);
 return super.shouldOverrideUrlLoading(view, request);
                    }else{
            ((MainActivity) activity)._openToast(url);
            return true; // Cancel loading this URL
        }

    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {

                   super.onPageStarted(view, url, favicon);
        currentUrl = url;
        ((MainActivity) activity)._onpagestart(view, url, favicon);
     
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        extensionUtil.onPageFinished(view, url);
        ((MainActivity) activity)._onpagefinish(view);
//
        JSONArray jsonArray = new JSONArray();
            for (HashMap<String, Object> resource : loadedResources) {
                JSONObject jsonObject = new JSONObject(resource);
                jsonArray.put(jsonObject);
            }

            // Зберігаємо дані у ExtendedDataHolder
            dataHolder.setData("loadres", jsonArray.toString());

            // Очищаємо список ресурсів після запису
            loadedResources.clear();
//
    }
    
    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        if (request.isForMainFrame()) {
            ((MainActivity) activity)._onpagefail(view, error.getDescription().toString());
        }
    }


    public void setAdLockEnabled(boolean enabled) {
        this.adlockEnabled = enabled;
    }

    public boolean isAdblEnabled(WebView view) {
        return ((MainActivity) activity)._adblck(view);
    }
    
    @Override
		public void onReceivedSslError(WebView view, SslErrorHandler handler,SslError error) {
                        ((MainActivity) activity)._sslerror();
			handler.proceed();
			//super.onReceivedSslError(view, handler, error);
		}
}
