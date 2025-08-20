package com.a525team.weekbrowser;

import android.app.Activity;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class JsBridge {
    private final Activity activity;
    private final WebView webView;

    public JsBridge(Context context, WebView webView) {
        this.activity = (Activity) context;
        this.webView = webView;
    }

    @JavascriptInterface
    public void openColorPicker(String inputSelector, String currentColor) {
        activity.runOnUiThread(() -> {
            ColorPickerDialog colorPickerDialog = new ColorPickerDialog(activity);
            colorPickerDialog.setColorPickerListener(new ColorPickerDialog.ColorPickerListener() {
                @Override
                public void onColorPicked(String colorHex) {
                    // Очікувано: colorHex = "ff112233", беремо "112233"
                    if (colorHex != null && colorHex.length() >= 8) {
                        String rrggbb = colorHex.substring(2); // відкидаємо альфа
                        String js = "javascript:(function() {" +
                                "try {" +
                                "  var el = document.querySelector('" + inputSelector + "');" +
                                "  if (el) {" +
                                "    el.value = '#" + rrggbb + "';" +
                                "    el.dispatchEvent(new Event('input'));" +
                                "    el.dispatchEvent(new Event('change'));" +
                                "  }" +
                                "} catch(e) { console.error(e); }" +
                                "})()";
                        webView.loadUrl(js);
                    }
                }
            });

            try {
                colorPickerDialog.show("ff" + currentColor); // додаємо альфа ff
            } catch (Exception e) {
                colorPickerDialog.show("ff000000");
            }
        });
    }
}
