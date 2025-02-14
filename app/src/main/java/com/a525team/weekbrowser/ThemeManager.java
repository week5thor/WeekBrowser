package com.a525team.weekbrowser;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

public class ThemeManager {
    public static void applyTheme(Context context) {
        SharedPreferences sf = context.getSharedPreferences("sf", Context.MODE_PRIVATE);

        int themeValue;
        try {
            themeValue = Integer.parseInt(sf.getString("theme", ""));
        } catch (NumberFormatException e) {
            themeValue = 2; // Значення за замовчуванням, якщо виникла помилка
        }

        String styleValue = sf.getString("style", "");
        int theme;

        switch (themeValue) {
            case 0:
                theme = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) ?
                        android.R.style.Theme_DeviceDefault_Light : android.R.style.Theme_Holo_Light;
                break;
            case 1:
                theme = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) ?
                        android.R.style.Theme_DeviceDefault : android.R.style.Theme_Holo;
                break;
            case 2:
                theme = android.R.style.Theme_Light;
                break;
            case 3:
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
                    theme = android.R.style.Theme_Black;
                } else {
                    theme = getStyleBasedTheme(styleValue);
                }
                break;
            case 4:
                theme = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) ?
                        android.R.style.Theme_DeviceDefault_Light : android.R.style.Theme_Holo_Light;
                break;
            case 5:
                theme = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) ?
                        android.R.style.Theme_DeviceDefault : android.R.style.Theme_Holo;
                break;
            case 6:
                theme = android.R.style.Theme_Holo_Light;
                break;
            case 7:
                theme = android.R.style.Theme_Holo;
                break;
            case 8:
                theme = android.R.style.Theme_Material_Light;
                break;
            case 9:
            case 10:
                theme = android.R.style.Theme_Material;
                break;
            case 11:
            case 12:
            default:
                theme = android.R.style.Theme_Light;
                break;
        }

        context.setTheme(theme);
    }

    private static int getStyleBasedTheme(String styleValue) {
        switch (styleValue) {
            case "1":
                return android.R.style.Theme_Black;
            case "2":
                return android.R.style.Theme_Light;
            case "3":
                return android.R.style.Theme_Holo;
            case "4":
                return android.R.style.Theme_Holo_Light;
            case "5":
                return android.R.style.Theme_Material;
            case "6":
                return android.R.style.Theme_Material_Light;
            case "7":
                return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) ?
                        android.R.style.Theme_DeviceDefault : android.R.style.Theme_Holo;
            case "8":
                return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) ?
                        android.R.style.Theme_DeviceDefault_Light : android.R.style.Theme_Holo_Light;
            default:
                return android.R.style.Theme_Light;
        }
    }
}


