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

import com.google.gson.Gson;

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
    public void onUrlChanged(final String url, final String title) {
        if (!"0".equals(sf.getString("incognito", "")) || url == null) return;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Calendar dnt = Calendar.getInstance();
                    long nowMillis = dnt.getTimeInMillis();

                    if (!url.equals(activityRef.get().getFilesDir().getPath() + "/bookmark.json") && !url.equals("about:blank")) {
                        synchronized (history) {
                            HashMap<String, Object> item = new HashMap<>();
                            String name = (title != null && !title.trim().isEmpty()) ? title : "UNTITLED :-/";
                            item.put("name", name);
                            item.put("url", url);
                            item.put("date", String.valueOf(nowMillis));
                            history.add(item);

                            // Ліміти історії
                            int maxhistory = 150000;
                            boolean maxhistoryt = false;
                            try {
                                maxhistory = Integer.parseInt(sf.getString("maxhistory", "150000"));
                            } catch (NumberFormatException ignored) {}
                            try {
                                maxhistoryt = "1".equals(sf.getString("maxhistoryt", "0"));
                            } catch (Exception ignored) {}

                            if (maxhistoryt) {
                                long threshold = nowMillis - maxhistory * 1000L;

                                Iterator<HashMap<String, Object>> it = history.iterator();
                                while (it.hasNext()) {
                                    HashMap<String, Object> h = it.next();
                                    Object dateObj = h.get("date");
                                    if (dateObj != null) {
                                        try {
                                            long time = Long.parseLong(dateObj.toString());
                                            if (time < threshold) it.remove();
                                        } catch (NumberFormatException ignored) {}
                                    }
                                }

                                if (history.size() > 150000) {
                                    int remove = history.size() - 150000;
                                    history.subList(0, remove).clear();
                                }
                            } else {
                                if (history.size() > maxhistory) {
                                    int remove = history.size() - maxhistory;
                                    history.subList(0, remove).clear();
                                }
                            }
                        }

                        synchronized (history) {
                            String json = new Gson().toJson(history);
                            FileUtil.writeFile(activityRef.get().getFilesDir().getPath() + "/history.json", json);
                        }
                    }
                } catch (Exception e) {
                    Log.e("HistoryInterface", "Error saving history: " + e.getMessage());
                }
            }
        }).start();
    }

    @JavascriptInterface
    public void processElementInfo(String jsonData) {
                if(activity!=null){
        activity.runOnUiThread(() -> {
            try {
                // Якщо клавіатура відкрита — не створюємо кнопку
                if (SafeMarginUtils.isKeyboardVisible()) {
                    removeButton(true);
                    return;
                }

				ExtendedDataHolder.getInstance().setData("info", jsonData);
                
                // Отримуємо координати натискання
                int x = (int) Float.parseFloat(ExtendedDataHolder.getInstance().getData("touch_x"));
                int y = (int) Float.parseFloat(ExtendedDataHolder.getInstance().getData("touch_y"));

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
            } catch (Exception e) {
                e.printStackTrace();
            }
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






