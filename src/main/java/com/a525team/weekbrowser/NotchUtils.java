package com.a525team.weekbrowser;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.View;

public class NotchUtils {

    public static int getNotchHeightDp(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            WindowManager windowManager = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
            if (windowManager != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    // Для Android 11 і вище використовуємо getCurrentWindowMetrics
                    WindowInsets windowInsets = windowManager.getCurrentWindowMetrics().getWindowInsets();
                    DisplayCutout displayCutout = windowInsets.getDisplayCutout();
                    if (displayCutout != null) {
                        int notchHeightPixels = displayCutout.getSafeInsetTop();
                        return pxToDp(activity, notchHeightPixels);
                    }
                } else {
                    // Для Android 9 і 10
                    View rootView = activity.getWindow().getDecorView().getRootView();
                    WindowInsets windowInsets = rootView.getRootWindowInsets();
                    if (windowInsets != null) {
                        DisplayCutout displayCutout = windowInsets.getDisplayCutout();
                        if (displayCutout != null) {
                            int notchHeightPixels = displayCutout.getSafeInsetTop();
                            return pxToDp(activity, notchHeightPixels);
                        }
                    }
                }
            }
        }
        return 0; // Немає вирізу або Android версія нижче P
    }

    private static int pxToDp(Context context, int px) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
