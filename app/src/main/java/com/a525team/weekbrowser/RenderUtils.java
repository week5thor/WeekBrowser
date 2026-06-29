package com.a525team.weekbrowser;

import android.app.Activity;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class RenderUtils {

    // Приватний конструктор, щоб заборонити створення екземплярів (new RenderUtils())
    private RenderUtils() {
    }

    public static boolean isOn() {
        ExtendedDataHolder dh = ExtendedDataHolder.getInstance();
        return dh.getData("don").equals("1") && dh.getData("batsav").equals("0");
    }

    public static void on(Activity activity) {
        if (WTF.SDK_INT() >= 31 && isOn() && activity != null) {
            View root = activity.getWindow().getDecorView().getRootView();
            root.setRenderEffect(null);

            ExtendedDataHolder dh = ExtendedDataHolder.getInstance();
            float blurX = safeParseFloat(dh.getData("dblurx"), 30f);
            float blurY = safeParseFloat(dh.getData("dblury"), 30f);
            float rotateR = safeParseFloat(dh.getData("drred"), 0f);
            float rotateG = safeParseFloat(dh.getData("drgreen"), 0f);
            float rotateB = safeParseFloat(dh.getData("drblue"), 0f);
            float satur = safeParseFloat(dh.getData("dsatur"), 0f);
            float scaleR = safeParseFloat(dh.getData("dvred"), 0.8f);
            float scaleG = safeParseFloat(dh.getData("dvgreen"), 0.8f);
            float scaleB = safeParseFloat(dh.getData("dvblue"), 0.8f);

            ColorMatrix cm = new ColorMatrix();
            cm.setRotate(0, rotateR);
            ColorMatrix cmG = new ColorMatrix();
            cmG.setRotate(1, rotateG);
            ColorMatrix cmB = new ColorMatrix();
            cmB.setRotate(2, rotateB);
            cm.postConcat(cmG);
            cm.postConcat(cmB);

            ColorMatrix cmSat = new ColorMatrix();
            cmSat.setSaturation(satur);
            cm.postConcat(cmSat);

            ColorMatrix cmScale = new ColorMatrix();
            cmScale.setScale(scaleR, scaleG, scaleB, 1f);
            cm.postConcat(cmScale);

            RenderEffect blur = RenderEffect.createBlurEffect(blurX, blurY, Shader.TileMode.CLAMP);
            RenderEffect color = RenderEffect.createColorFilterEffect(new ColorMatrixColorFilter(cm));
            RenderEffect chain = RenderEffect.createChainEffect(blur, color);

            root.setRenderEffect(chain);
        }
    }

    public static void off(Activity activity) {
        if (WTF.SDK_INT() >= 31 && activity != null) {
            View root = activity.getWindow().getDecorView().getRootView();
            root.setRenderEffect(null);
        }
    }

    // Передаємо і Activity (щоб розмити її фон), і сам Dialog
    // 1. Метод для AlertDialog (уже відредагований тобою)
public static void setupDialogDim(Activity activity, android.app.AlertDialog dialog) {
    setupGeneralDialogDim(activity, dialog);
}

// 2. Метод для базового Dialog (для твого IconPickerDialog)
public static void setupDialogDim(Activity activity, android.app.Dialog dialog) {
    setupGeneralDialogDim(activity, dialog);
}

// 3. Спільна логіка, щоб не дублювати код
private static void setupGeneralDialogDim(Activity activity, android.app.Dialog dialog) {
    dialog.setOnShowListener(d -> {
        android.view.Window window = dialog.getWindow();
        if (window != null) {
            if (WTF.SDK_INT() >= 31 && isOn()) {
                on(activity);
                window.clearFlags(android.view.WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                window.setDimAmount(0f);
            } else {
                ExtendedDataHolder dh = ExtendedDataHolder.getInstance();
                float dimAmount = 0.5f;
                try {
                    dimAmount = Float.parseFloat(dh.getData("dvalp"));
                } catch (Exception ignored) {}
                window.setDimAmount(dimAmount);
            }
        }
    });

    dialog.setOnDismissListener(d -> {
        off(activity);
    });
}

    private static float safeParseFloat(String data, float defaultValue) {
        try {
            return Float.parseFloat(data);
        } catch (Exception e) {
            return defaultValue;
        }
    }
}