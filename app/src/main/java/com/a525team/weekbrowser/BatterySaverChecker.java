package com.a525team.weekbrowser;

import android.content.Context;
import android.os.PowerManager;

public class BatterySaverChecker {

    public static boolean isBatterySaverOn(Context context) {
            PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            if (powerManager != null) {
                return powerManager.isPowerSaveMode();
            }
        return false;
    }
}
