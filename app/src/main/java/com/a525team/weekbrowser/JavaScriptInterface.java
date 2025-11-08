package com.a525team.weekbrowser;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.widget.Button;
import java.lang.ref.WeakReference;
import android.content.SharedPreferences;
import android.util.Log;

import android.content.Context;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

public class JavaScriptInterface {
    private final Activity activity;
    private WeakReference<Activity> activityRef;
    private final WindowManager wm;
    private Button btn;
    private final SharedPreferences sf;
    private final ArrayList<HashMap<String, Object>> history;

    public JavaScriptInterface(Activity activity) {
        this.activityRef = new WeakReference<>(activity);
        this.activity = activityRef.get();
        this.wm = (WindowManager) activity.getSystemService(Activity.WINDOW_SERVICE);
        this.sf = activity.getSharedPreferences("sf", Context.MODE_PRIVATE);
        this.history = ((MainActivity)activity).getHis();
    }

    @JavascriptInterface
    public void processElementInfo(String jsonData) {
        handleElementInfo(jsonData, true);
    }

    // Це можна викликати з Java без JS
    public void processElementInfoNative(String jsonData) {
        handleElementInfo(jsonData, false);
    }

    // Вся логіка тут — спільна для обох випадків
    private void handleElementInfo(String jsonData, boolean fromJS) {
        if (activity == null) return;

        activity.runOnUiThread(() -> {
            try {
                if (SafeMarginUtils.isKeyboardVisible()) {
                    removeButton(true);
                    return;
                }

                ExtendedDataHolder.getInstance().setData("info", jsonData);

                int x = (int) Float.parseFloat(ExtendedDataHolder.getInstance().getData("touch_x"));
                int y = (int) Float.parseFloat(ExtendedDataHolder.getInstance().getData("touch_y"));

                // решта твого коду зі створенням кнопки [S]
                showFloatingButtonAt(x, y);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void showFloatingButtonAt(int x, int y) {
        if (btn == null) {
                    btn = new Button(activity);
                    btn.setText("[S]");

                    // Стилізація через Skin
                    Skin skin = new Skin();
                    skin.setBG(btn, 1, true);
                    btn.setTextColor((int) Long.parseLong(ExtendedDataHolder.getInstance().getData("rbt"), 16));

                    // Параметри розташування кнопки
                    WindowManager.LayoutParams btnp = new WindowManager.LayoutParams(
                            (int) (50 * activity.getResources().getDisplayMetrics().density),
                            (int) (40 * activity.getResources().getDisplayMetrics().density),
                            WindowManager.LayoutParams.TYPE_APPLICATION_PANEL,
                            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                            PixelFormat.TRANSLUCENT
                    );

                    btnp.gravity = Gravity.TOP | Gravity.LEFT;
                    btnp.x = x + 10; // Трохи правіше натискання
                    btnp.y = y - 10; // Трохи вище натискання

                    wm.addView(btn, btnp);

                    btn.setOnClickListener(view -> {
                        Intent intent = new Intent(activity, SsuperactivityActivity.class);
                        activity.startActivity(intent);
                        removeButton(false);
                    });
                    
                    btn.setOnLongClickListener(view -> {
                        removeButton(true);
                        return true; 
                    });

                }
    }

public void removeButton(boolean delinfo) {
        if(delinfo)
        ExtendedDataHolder.getInstance().setData("info", "");
        if (btn != null) {
            wm.removeView(btn);
            btn = null;
        }
    }
}






