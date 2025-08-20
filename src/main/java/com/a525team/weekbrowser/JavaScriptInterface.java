package com.a525team.weekbrowser;

import android.content.Intent;
import android.app.Activity;
import android.webkit.JavascriptInterface;

public class JavaScriptInterface {
    private Activity activity;

    public JavaScriptInterface(Activity activity) {
        this.activity = activity;
    }

    @JavascriptInterface
    public void processElementInfo(String info) {
        try {
            // Зберегти дані у DataHolder
            DataHolder.getInstance().setData(info);

            // Запуск нової активності
            Intent intent = new Intent(activity, SsuperactivityActivity.class);
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
