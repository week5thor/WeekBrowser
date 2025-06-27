package com.a525team.weekbrowser;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;

public class BatterySaverChecker {

    public static boolean isBatterySaverOn(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            if (powerManager != null) {
                return powerManager.isPowerSaveMode();
            }
        }
        return false; // На старих версіях Android (< API 21) Battery Saver не підтримується
    }
}
