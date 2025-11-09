package com.a525team.weekbrowser;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.webkit.WebResourceResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class AdBlocker {
    private Pattern hostPattern;
    private Pattern urlPattern;
    private static AdBlocker instance;
    private Context context;
    
    public AdBlocker(Context context) {
        this.context = context;
        loadBlockedHosts(context);
    }
    
    public static synchronized AdBlocker getInstance(Context context) {
        if (instance == null) {
            instance = new AdBlocker(context);
        }
        return instance;
    }
    
    public void loadBlockedHosts(Context context) {
        // Збираємо всі патерни з обох джерел перед компіляцією
        Set<String> allHostPatterns = new HashSet<>();
        Set<String> allUrlPatterns = new HashSet<>();
        
        loadBlockedHostsFromSharedPreferences(context, allHostPatterns, allUrlPatterns);
        loadStdBlockedHosts(context, allHostPatterns, allUrlPatterns);
        
        compilePatterns(allHostPatterns, allUrlPatterns);
    }
    
    private void loadBlockedHostsFromSharedPreferences(Context context, Set<String> hostPatterns, Set<String> urlPatterns) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("sf", Context.MODE_PRIVATE);
        String adHosts = sharedPreferences.getString("adhosts", "");
        if (adHosts != null && !adHosts.isEmpty()) {
            parseAdList(adHosts, hostPatterns, urlPatterns);
        }
    }
    
    private void loadStdBlockedHosts(Context context, Set<String> hostPatterns, Set<String> urlPatterns) {
        try {
            String stdAdList = loadAdListFromAssets(context);
            parseAdList(stdAdList, hostPatterns, urlPatterns);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private String loadAdListFromAssets(Context context) throws IOException {
        try (InputStream inputStream = context.getAssets().open("ad_list.txt")) {
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            return new String(buffer, "UTF-8");
        }
    }
    
    private void parseAdList(String adList, Set<String> hostPatterns, Set<String> urlPatterns) {
        if (adList == null || adList.isEmpty()) {
            return;
        }
        
        String[] lines = adList.split("\n");
        for (String line : lines) {
            line = line.trim();
            if (line.startsWith("#") || line.startsWith("//") || line.isEmpty()) {
                continue;
            }
            
            if (line.startsWith("%")) {
                // URL pattern (full URL match)
                urlPatterns.add(Pattern.quote(line.substring(1).trim()));
            } else {
                // Host pattern (partial match)
                hostPatterns.add(Pattern.quote(line.trim()));
            }
        }
    }
    
    private void compilePatterns(Set<String> hostPatterns, Set<String> urlPatterns) {
        // Compile mega-regex for hosts
        if (!hostPatterns.isEmpty()) {
            String hostRegex = ".*(?:" + String.join("|", hostPatterns) + ").*";
            hostPattern = Pattern.compile(hostRegex);
        } else {
            hostPattern = null;
        }
        
        // Compile mega-regex for URLs
        if (!urlPatterns.isEmpty()) {
            String urlRegex = ".*(?:" + String.join("|", urlPatterns) + ").*";
            urlPattern = Pattern.compile(urlRegex);
        } else {
            urlPattern = null;
        }
    }
    
    public boolean isBlocked(String url) {
        if (url == null) {
            return false;
        }
        
        // Check URL patterns first (full URL match)
        if (urlPattern != null && urlPattern.matcher(url).matches()) {
            return true;
        }
        
        // Check host patterns
        String domain = Uri.parse(url).getHost();
        if (domain != null && hostPattern != null) {
            return hostPattern.matcher(domain).matches();
        }
        
        return false;
    }
    
    // Статичний метод для створення псевдо-відповіді для реклами
    public static WebResourceResponse pseudoAd(String url) {
    try {
        String mimeType = "text/plain";
        String content = "";
        
        if (url.endsWith(".js")) {
            mimeType = "application/javascript";
            content = "//";
        } else if (url.endsWith(".css")) {
            mimeType = "text/css";
            content = "/**/";
        } else if (url.endsWith(".html") || url.contains("iframe") || url.contains("adframe")) {
            mimeType = "text/html";
            content = "<!DOCTYPE html><html><body></body></html>";
        } else if (url.endsWith(".svg")) {
            mimeType = "image/svg+xml";
            content = "<svg xmlns='http://www.w3.org/2000/svg'></svg>";
        } else if (url.endsWith(".jpg") || url.endsWith(".jpeg")) {
            mimeType = "image/jpeg";
            byte[] jpgHeader = {(byte)0xFF, (byte)0xD8, (byte)0xFF};
            return new WebResourceResponse(
                    mimeType,
                    "utf-8",
                    200,
                    "OK",
                    java.util.Collections.singletonMap("Content-Type", mimeType),
                    new ByteArrayInputStream(jpgHeader)
            );
        } else if (url.endsWith(".png")) {
            mimeType = "image/png";
            byte[] pngHeader = {(byte)0x89, 0x50, 0x4E, 0x47};
            return new WebResourceResponse(
                    mimeType,
                    "utf-8",
                    200,
                    "OK",
                    java.util.Collections.singletonMap("Content-Type", mimeType),
                    new ByteArrayInputStream(pngHeader)
            );
        }

        // Заголовки — мінімальні, але валідні
        java.util.Map<String, String> headers = new java.util.HashMap<>();
        headers.put("Content-Type", mimeType);
        headers.put("Cache-Control", "no-store");
        headers.put("Access-Control-Allow-Origin", "*");

        return new WebResourceResponse(
                mimeType,
                "utf-8",
                200,
                "OK",
                headers,
                new ByteArrayInputStream(content.getBytes("utf-8"))
        );
    } catch (UnsupportedEncodingException e) {
        return null;
    }
}
    
    // Метод для перевірки, чи потрібно блокувати редіректи
    public boolean blockRedir() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("sf", Context.MODE_PRIVATE);
        int blockRedirect = Integer.parseInt(sharedPreferences.getString("blockredir", "0"));
        int blockAd = Integer.parseInt(sharedPreferences.getString("blockad", "0"));
        return blockRedirect == 2 || (blockRedirect == 1 && blockAd == 1);
    }
    
    // Додаткові утилітні методи
    public void clearCache() {
        hostPattern = null;
        urlPattern = null;
    }
    
    public void reloadBlockedHosts() {
        loadBlockedHosts(context);
    }
    
    public boolean isInitialized() {
        return hostPattern != null || urlPattern != null;
    }
}