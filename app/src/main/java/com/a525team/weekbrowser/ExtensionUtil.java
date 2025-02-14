package com.a525team.weekbrowser;

import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import android.util.Base64;

public class ExtensionUtil {

    private final List<ExtensionConfig> extensions = new ArrayList<>();

    public ExtensionUtil(Context context) {
        loadExtensions(context);
    }

    // Завантаження всіх розширень із директорії
    private void loadExtensions(Context context) {
    File extensionsDir = new File(context.getFilesDir(), "extensions");
    if (extensionsDir.exists() && extensionsDir.isDirectory()) {
        for (File file : extensionsDir.listFiles()) {
            try (InputStream is = new FileInputStream(file);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                 
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                
                String jsonText = stringBuilder.toString();
                JSONObject jsonObject = new JSONObject(jsonText);
                ExtensionConfig config = new ExtensionConfig(jsonObject);
                extensions.add(config);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


    // Метод для обробки події onPageStarted
    public void onPageStarted(WebView webView, String url) {
        for (ExtensionConfig extension : extensions) {
            if (extension.isEnabled()) {
                String script = extension.getOnPageStartScript();
                if (script != null) {
                    webView.evaluateJavascript(script, null);
                }
            }
        }
    }

    // Метод для обробки події onPageFinished
    public void onPageFinished(WebView webView, String url) {
        for (ExtensionConfig extension : extensions) {
            if (extension.isEnabled()) {
                String script = extension.getOnPageFinishScript();
                if (script != null) {
                    webView.evaluateJavascript(script, null);
                }
            }
        }
    }

    // Метод для перехоплення запитів
    public WebResourceResponse onShouldInterceptRequest(WebView webView, WebResourceRequest request) {
        String url = request.getUrl().toString();
        for (ExtensionConfig extension : extensions) {
            if (extension.isEnabled()) {
                List<InterceptionRule> interceptionRules = extension.getInterceptionRules();
                for (InterceptionRule rule : interceptionRules) {
                    if (rule.matches(url)) {
                        return rule.createWebResourceResponse();
                    }
                }
            }
        }
        return null; // якщо перехоплення не потрібне, повертаємо null
    }

    // Внутрішній клас для зберігання налаштувань одного розширення
    private static class ExtensionConfig {
        private boolean enabled;
        private String onPageStartScript;
        private String onPageFinishScript;
        private final List<InterceptionRule> interceptionRules = new ArrayList<>();

        public ExtensionConfig(JSONObject jsonObject) {
            try {
                enabled = "on".equalsIgnoreCase(jsonObject.optString("en"));
                onPageStartScript = jsonObject.optString("ps", null);
                onPageFinishScript = jsonObject.optString("pf", null);
                
                String sirText = jsonObject.optString("sir", "json[]"); // Отримуємо sir як текстовий рядок
                sirText = sirText.substring(4);
                JSONArray sirArray = new JSONArray(sirText);
                
                for (int i = 0; i < sirArray.length(); i++) {
                    JSONObject ruleObject = sirArray.getJSONObject(i);
                    InterceptionRule rule = new InterceptionRule(
                        ruleObject.optString("siu"),
                        ruleObject.optString("ec", "200"),
                        ruleObject.optString("mt", "text/html"),
                        ruleObject.optString("rt", "")
                    );
                    interceptionRules.add(rule);
                }
            } catch (JSONException e) {
                e.printStackTrace(); // Обробка помилки JSON
            }
        }

        public boolean isEnabled() {
            return enabled;
        }

        public String getOnPageStartScript() {
            return onPageStartScript;
        }

        public String getOnPageFinishScript() {
            return onPageFinishScript;
        }

        public List<InterceptionRule> getInterceptionRules() {
            return interceptionRules;
        }
    }

    // Клас для представлення одного правила перехоплення
    private static class InterceptionRule {
    private final Pattern urlPattern;
    private final int statusCode;
    private final String mimeType;
    private final byte[] responseData;

    public InterceptionRule(String urlRegex, String statusCode, String mimeType, String data) {
        this.urlPattern = Pattern.compile(urlRegex);
        this.statusCode = Integer.parseInt(statusCode.replaceAll("\\D", "")); // Видаляємо всі нецифрові символи, якщо є
        this.mimeType = mimeType;

        // Визначаємо, чи дані у форматі Base64
        if (data.startsWith("data:")) {
            // Видаляємо префікс "data:mime;base64,"
            data = data.substring(data.indexOf(",") + 1);
            this.responseData = Base64.decode(data, Base64.DEFAULT); // Декодуємо Base64 у байти
        } else {
            // Вважаємо, що це звичайний текст (наприклад, JSON або HTML)
            this.responseData = data.getBytes(StandardCharsets.UTF_8);
        }
    }

    public boolean matches(String url) {
        return urlPattern.matcher(url).find();
    }

    public WebResourceResponse createWebResourceResponse() {
        return new WebResourceResponse(
            mimeType,              // MIME-тип (image/png, text/html, application/json, тощо)
            "UTF-8",               // Кодировка
            statusCode,            // HTTP-код відповіді
 "WeekBrowser Extension Intercept",// Опис статусу
            null,                  // Заголовки (null для спрощення)
            new ByteArrayInputStream(responseData) // Потік байтів
        );
    }
}

}
