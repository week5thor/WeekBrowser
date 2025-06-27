package com.a525team.weekbrowser;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.view.View;
import android.app.Activity;

public class RenderUtils {

    ExtendedDataHolder dh = ExtendedDataHolder.getInstance();
    View root;
    Activity a;

    public RenderUtils(Activity a) {
        this.a = a;
        if (WTF.SDK_INT() >= 31) { // 31 = Android 12 (S)
            root = a.getWindow().getDecorView().getRootView();
        }
    }

    public void on() {
        if (WTF.SDK_INT() >= 31 && isOn()) {
            root.setRenderEffect(null);

            float blurX = safeParseFloat(dh.getData("dblurx"), 30f);
            float blurY = safeParseFloat(dh.getData("dblury"), 30f);
            float rotateR = safeParseFloat(dh.getData("drred"), 0f);
            float rotateG = safeParseFloat(dh.getData("drgreen"), 0f);
            float rotateB = safeParseFloat(dh.getData("drblue"), 0f);
            float satur = safeParseFloat(dh.getData("dsatur"), 0f);
            float scaleR = safeParseFloat(dh.getData("dvred"), 0.8f);
            float scaleG = safeParseFloat(dh.getData("dvgreen"), 0.8f);
            float scaleB = safeParseFloat(dh.getData("dvblue"), 0.8f);
            float scaleA = safeParseFloat(dh.getData("dvalp"), 1f);

            // Основна матриця
            ColorMatrix cm = new ColorMatrix();
            cm.setRotate(0, rotateR);
            ColorMatrix cmG = new ColorMatrix();
            cmG.setRotate(1, rotateG);
            ColorMatrix cmB = new ColorMatrix();
            cmB.setRotate(2, rotateB);
            cm.postConcat(cmG);
            cm.postConcat(cmB);

            // Насиченість
            ColorMatrix cmSat = new ColorMatrix();
            cmSat.setSaturation(satur);
            cm.postConcat(cmSat);

            // Масштаб
            ColorMatrix cmScale = new ColorMatrix();
            cmScale.setScale(scaleR, scaleG, scaleB, scaleA);
            cm.postConcat(cmScale);

            // Ефекти
            RenderEffect blur = RenderEffect.createBlurEffect(blurX, blurY, Shader.TileMode.CLAMP);
            RenderEffect color = RenderEffect.createColorFilterEffect(new ColorMatrixColorFilter(cm));
            RenderEffect chain = RenderEffect.createChainEffect(blur, color);

            root.setRenderEffect(chain);
        }
    }

    public void off() {
        if (WTF.SDK_INT() >= 31) {
            root.setRenderEffect(null);
        }
    }

    public boolean isOn() {
        return dh.getData("don").equals("1")&&dh.getData("batsav").equals("0");
    }

    private float safeParseFloat(String data, float defaultValue) {
        try {
            return Float.parseFloat(data);
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
