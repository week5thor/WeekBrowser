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
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.net.URL;
import java.net.HttpURLConnection;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;

public class MyWebViewClient extends WebViewClient {

    private Activity activity;
    private boolean adlockEnabled = true;
    private final Set<String> blockedHosts;
    private final Set<String> blockedUrls;
    private String currentUrl;

    public MyWebViewClient(Activity activity) {
        this.activity = activity;
        this.blockedHosts = new HashSet<>();
        this.blockedUrls = new HashSet<>();
        loadBlockedHosts();

    }

    private void loadBlockedHosts() {
        blockedHosts.clear();
        blockedUrls.clear();
        loadBlockedHostsFromFile("/storage/emulated/0/WeekBrowser/Blockad/domains.txt");
        loadBlockedHostsFromFile("/storage/emulated/0/WeekBrowser/Blockad/userdomains.txt");
    }

    private void loadBlockedHostsFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#") || line.startsWith("//") || line.trim().isEmpty()) {
                    continue;
                }
                if (line.startsWith("%")) {
                    blockedUrls.add(line.substring(1).trim());
                } else {
                    blockedHosts.add(line.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Add some error logging here
        }
    }

    public void updateBlockedHosts() {
        loadBlockedHosts();
    }

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        String url = request.getUrl().toString();
        String domain = Uri.parse(url).getHost();

        if (!isAdblEnabled(view) || (blockedHosts.isEmpty() && blockedUrls.isEmpty())) {
            WebResourceResponse response = super.shouldInterceptRequest(view, request);
            if (response != null) {
                return removeSecurityHeaders(response);
            }
            return response;
        }

        for (String blockedHost : blockedHosts) {
            if (domain != null && domain.matches(".*" + blockedHost + ".*")) {
                ((MainActivity) activity)._adsblocked();
                return new WebResourceResponse("text/plain", "utf-8", new ByteArrayInputStream("".getBytes()));
            }
        }

        for (String blockedUrl : blockedUrls) {
            if (url.matches(".*" + blockedUrl + ".*")) {
                ((MainActivity) activity)._adsblocked();
                return new WebResourceResponse("text/plain", "utf-8", new ByteArrayInputStream("".getBytes()));
            }
        }
        

        WebResourceResponse response = super.shouldInterceptRequest(view, request);
        if (response != null) {
            return removeSecurityHeaders(response);
        }
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
        String domain = Uri.parse(url).getHost();
        for (String blockedHost : blockedHosts) {
            if (domain != null && domain.matches(".*" + blockedHost + ".*") && ((MainActivity) activity)._isaccess()) {
                ((MainActivity) activity)._accessdenied(blockedHost);
                return true; // Cancel loading this URL
            }
        }

        for (String blockedUrl : blockedUrls) {
            if (url.matches(".*" + blockedUrl + ".*") && ((MainActivity) activity)._isaccess()) {
                ((MainActivity) activity)._accessdenied(blockedUrl);
                return true; // Cancel loading this URL
            }
        }
 return super.shouldOverrideUrlLoading(view, request);

    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
               if(url.startsWith("https://")||url.startsWith("http://")||url.startsWith("file://")||url.startsWith("content://")){
                   super.onPageStarted(view, url, favicon);
        currentUrl = url;
        ((MainActivity) activity)._onpagestart(view);
                        }else{
            ((MainActivity) activity)._openToast(url);
        }
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        ((MainActivity) activity)._onpagefinish(view);
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
