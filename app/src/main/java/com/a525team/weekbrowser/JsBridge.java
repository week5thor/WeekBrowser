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
public void openColorPicker(String iframeSelector, String inputSelector, String currentColor) {
    activity.runOnUiThread(() -> {
        ColorPickerDialog dialog = new ColorPickerDialog(activity);
        dialog.setColorPickerListener(newColor -> {
            if (newColor != null && newColor.length() >= 8) {
                String hex = newColor.substring(2); // skip alpha
                String js = "javascript:setColorInputValue(" +
                        "\"" + iframeSelector + "\", " +
                        "\"" + inputSelector + "\", " +
                        "\"" + hex + "\")";
                webView.loadUrl(js);
            }
        });
        dialog.show("ff" + currentColor);
    });
}


}
