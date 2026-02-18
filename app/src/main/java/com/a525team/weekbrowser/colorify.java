package com.a525team.weekbrowser;

import android.content.res.ColorStateList;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.view.*;
import android.graphics.Color;

public class colorify {

    public static void setSeekBarColors(SeekBar seekBar, int progressColor, int thumbColor) {
        if (WTF.SDK_INT() >= 21) {
            ColorStateList progressTint = ColorStateList.valueOf(progressColor);
            ColorStateList thumbTint = ColorStateList.valueOf(thumbColor);

            seekBar.setProgressTintList(progressTint);
            seekBar.setThumbTintList(thumbTint);
        }
    }

    public static void setButtonColor(CompoundButton button, int color) {
        if (WTF.SDK_INT() >= 21) {
            ColorStateList tint = ColorStateList.valueOf(color);
            button.setButtonTintList(tint);
        }
    }
    
    public static void applyColorifyToAll(View rootView) {
    if (rootView == null) return;
    
    ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();

    if (rootView instanceof ViewGroup) {
        ViewGroup group = (ViewGroup) rootView;
        for (int i = 0; i < group.getChildCount(); i++) {
            View child = group.getChildAt(i);
            applyColorifyToAll(child);
        }
    }

    if (rootView instanceof CompoundButton && WTF.SDK_INT() >= 21) {
        String hex = dataHolder.getData("cb");
        int color = parseColorSafe(hex, 0xFF000000);
        setButtonColor((CompoundButton) rootView, color);
    } else if (rootView instanceof SeekBar && WTF.SDK_INT() >= 21) {
        String pHex = dataHolder.getData("tpc");
        String tHex = dataHolder.getData("tc");
        int pColor = parseColorSafe(pHex, 0xFF000000);
        int tColor = parseColorSafe(tHex, 0xFF000000);
        setSeekBarColors((SeekBar) rootView, pColor, tColor);
    }
}

private static int parseColorSafe(String hex, int fallback) {
    try {
        if (hex == null) return fallback;
        if (!hex.startsWith("#")) hex = "#" + hex;
        return Color.parseColor(hex);
    } catch (Exception e) {
        return fallback;
    }
}


}







