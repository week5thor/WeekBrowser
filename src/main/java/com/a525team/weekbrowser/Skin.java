package com.a525team.weekbrowser;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

public class Skin {
    ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();

    int[] parseColorArray(String colorString) {
        int length = colorString.length();
        int[] colors = new int[length / 8];
        for (int i = 0; i < length; i += 8) {
            colors[i / 8] = (int) Long.parseLong(colorString.substring(i, i + 8), 16);
        }
        return colors;
    }

    int[] color1 = parseColorArray(dataHolder.getData("bbg"));
    int[] rcolor1 = parseColorArray(dataHolder.getData("rbg"));
    int[] bg = parseColorArray(dataHolder.getData("bg"));

    int grad = Integer.parseInt(dataHolder.getData("grad"));
    int rgrad = Integer.parseInt(dataHolder.getData("rgrad"));
    int bgrad = Integer.parseInt(dataHolder.getData("bgrad"));
    final int roundness = Integer.parseInt(dataHolder.getData("rou"));
    final int rroundness = Integer.parseInt(dataHolder.getData("rrou"));
    final int sroundness = Integer.parseInt(dataHolder.getData("srou"));
    final int rsroundness = Integer.parseInt(dataHolder.getData("rsrou"));
    int stripec = Integer.parseInt(dataHolder.getData("strcou"));
    float gradientRadius = Float.parseFloat(dataHolder.getData("rad"));
    float gradientCenterX = Float.parseFloat(dataHolder.getData("x"));
    float gradientCenterY = Float.parseFloat(dataHolder.getData("y"));

    int rstripec = Integer.parseInt(dataHolder.getData("rstrcou"));
    float rgradientRadius = Float.parseFloat(dataHolder.getData("rrad"));
    float rgradientCenterX = Float.parseFloat(dataHolder.getData("rx"));
    float rgradientCenterY = Float.parseFloat(dataHolder.getData("ry"));

    int bstripec = Integer.parseInt(dataHolder.getData("bstrcou"));
    float bgradientRadius = Float.parseFloat(dataHolder.getData("brad"));
    float bgradientCenterX = Float.parseFloat(dataHolder.getData("bx"));
    float bgradientCenterY = Float.parseFloat(dataHolder.getData("by"));
    int tm = Integer.parseInt(dataHolder.getData("tm"));
    int rtm = Integer.parseInt(dataHolder.getData("rtm"));
    int btm = Integer.parseInt(dataHolder.getData("btm"));

    int stripeCount;
    int[] colors;
    float[] positions;

    void stripe(int[] colorArray, int r) {
        int sharp = (r == 2 ? btm : r == 1 ? rtm : tm);
        int stri = r == 2 ? bstripec : r == 1 ? rstripec : stripec;
        stripeCount = (stri >= 2) ? stri : 2; // Кількість смуг
        colors = new int[stripeCount * sharp];
        positions = new float[stripeCount * sharp];

        for (int i = 0; i < stripeCount * sharp; i++) {
            colors[i] = colorArray[i / sharp % colorArray.length]; // Використовуємо кольори з масиву
            positions[i] = (float) i / sharp / (stripeCount * sharp - 1); // Позиції для кольорів
        }
    }

    public void setBG(View v, int r, boolean s) {
        int g = r == 2 ? bgrad : r == 1 ? rgrad : grad;
        int[] colorArray = r == 2 ? bg : r == 1 ? rcolor1 : color1;
        float gradientX = r == 2 ? bgradientCenterX : r == 1 ? rgradientCenterX : gradientCenterX;
        float gradientY = r == 2 ? bgradientCenterY : r == 1 ? rgradientCenterY : gradientCenterY;
        float gradientR = r == 2 ? bgradientRadius : r == 1 ? rgradientRadius : gradientRadius;

        GradientDrawable drawable = null;

        switch (g) {
            case 0: // Смугастий градієнт
            case 1:
            case 2:
            case 3:
                stripe(colorArray, r);
                GradientDrawable.Orientation orientation;
                switch (g) {
                    case 0:
                        orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                        break;
                    case 1:
                        orientation = GradientDrawable.Orientation.LEFT_RIGHT;
                        break;
                    case 2:
                        orientation = GradientDrawable.Orientation.TL_BR;
                        break;
                    case 3:
                        orientation = GradientDrawable.Orientation.TR_BL;
                        break;
                    default:
                        orientation = GradientDrawable.Orientation.LEFT_RIGHT;
                        break;
                }
                drawable = new GradientDrawable(orientation, colors);
                break;

            case 4: // Радіальний градієнт
                stripe(colorArray, r);
                drawable = new GradientDrawable();
                drawable.setShape(GradientDrawable.RECTANGLE);
                drawable.setGradientType(GradientDrawable.RADIAL_GRADIENT);
                drawable.setColors(colors);
                try{drawable.setGradientRadius(Math.max(v.getWidth(), v.getHeight()* gradientR));}
                    catch (Exception e){
                  drawable.setGradientRadius(400* gradientR);
                        }
                drawable.setGradientCenter(gradientX, gradientY);
                break;

            case 5: // Кутовий градієнт
                stripe(colorArray, r);
                drawable = new GradientDrawable();
                drawable.setShape(GradientDrawable.RECTANGLE);
                drawable.setGradientType(GradientDrawable.SWEEP_GRADIENT);
                drawable.setColors(colors);
                drawable.setGradientCenter(gradientX, gradientY);
                break;

            default: // Стандартний лінійний градієнт
                drawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colorArray);
                break;
        }

        // Встановлення заокруглення для drawable, якщо воно не null
        if (drawable != null) {
            drawable.setCornerRadius(r == 2 ? 0 : (r == 1 ? (s ? rsroundness : rroundness) : (s ? sroundness : roundness)) * Resources.getSystem().getDisplayMetrics().density);
            v.setBackground(drawable);
            v.invalidate();
        }
    }
}
