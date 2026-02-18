package com.a525team.weekbrowser;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class JSutil {
	private static final String TAG = "JSutil";
	private static String bgb64c = "";
	private static String rbgb64c = "";
	private static String bbgb64c = "";
	
	public static void clearCache(){
        bgb64c = "";
        rbgb64c = "";
        bbgb64c = "";
        }
    
	public static String replaceInstruction(String jsCode) {
		if (jsCode == null || jsCode.isEmpty()) return "";
		
		if (!jsCode.startsWith("javascript:")) {
			jsCode = "javascript:" + jsCode;
		}
		
		ExtendedDataHolder dh = ExtendedDataHolder.getInstance();
		if (dh == null) {
			Log.e(TAG, "ExtendedDataHolder is null");
			return jsCode;
		}
		
		String result = jsCode
		.replace("$bggrad$", generatePattern(dh, "bg"))
        .replace("$bggradne$", generatePattern(dh, "bg").replace("\\'", "'"))
		.replace("$buttongrad$", generatePattern(dh, "button"))
        .replace("$buttongradne$", generatePattern(dh, "button").replace("\\'", "'"))
		.replace("$redgrad$", generatePattern(dh, "red"))
        .replace("$redgradne$", generatePattern(dh, "red").replace("\\'", "'"))
		.replace("$coltext$", convertColor(dh.getData("t")))
		.replace("$colfield$", convertColor(dh.getData("tf")))
		.replace("$coladd$", convertColor(dh.getData("add")))
		.replace("$colhint$", convertColor(dh.getData("h")))
		.replace("$colcomp$", convertColor(dh.getData("cb")))
		.replace("$coltrack$", convertColor(dh.getData("tpc")))
		.replace("$colthumb$", convertColor(dh.getData("tc")))
		.replace("$buttonround$", dh.getData("rou"))
		.replace("$redround$", dh.getData("rrou"))
		.replace("$colbtxt$", convertColor(dh.getData("bt")))
		.replace("$colrbtxt$", convertColor(dh.getData("rbt")));
		
		return minifyJS(result);
	}
	
	private static String generatePattern(ExtendedDataHolder dh, String type) {
    String[] params = getParams(dh, type);
    int patternType = Integer.parseInt(params[3]);
    
    // ЗМІНА ТУТ: було < 5, стало <= 5 (щоб включити кутовий градієнт)
    if (patternType <= 5 && dh.getData("batsav").equals("0")) {
        return generateCssGradient(params, patternType);
    }
    
    return bitmapToDataUrl(type);
}
	
	private static String bitmapToDataUrl(String type) {
		switch(type){
			case "bg":
			if(bgb64c.equals("")){
				Bitmap bitmap;
				try {
					BitmapDrawable drawable = getDrawableForType(type);
					if (drawable == null) return "green";
					bitmap = drawable.getBitmap();
				} catch (Exception e) {
					Log.e(TAG, "Error generating pattern for type: " + type, e);
					return "red";
				}
				bgb64c = getBase64(bitmap);}
			return bgb64c;
            
			case "red":
			if(rbgb64c.equals("")){
				Bitmap bitmap;
				try {
					BitmapDrawable drawable = getDrawableForType(type);
					if (drawable == null) return "green";
					bitmap = drawable.getBitmap();
				} catch (Exception e) {
					Log.e(TAG, "Error generating pattern for type: " + type, e);
					return "red";
				}
				rbgb64c = getBase64(bitmap);}
			return rbgb64c;
			
			case "button":
			if(bbgb64c.equals("")){
                Bitmap bitmap;
				try {
					BitmapDrawable drawable = getDrawableForType(type);
					if (drawable == null) return "green";
					bitmap = drawable.getBitmap();
				} catch (Exception e) {
					Log.e(TAG, "Error generating pattern for type: " + type, e);
					return "red";
				}
				bbgb64c = getBase64(bitmap);}
			return bbgb64c;
			
			default: return "yellow";
		}
	}
	
	private static String getBase64(Bitmap bitmap){
		try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
			bitmap.compress(Bitmap.CompressFormat.WEBP, 100, output);
			String base64 = Base64.encodeToString(output.toByteArray(), Base64.NO_WRAP);
			return "url(\\'data:image/webp;base64," + base64 + "\\') center center/100% 100%";
		} catch (Exception e) {
			Log.e(TAG, "Bitmap to DataURL conversion failed", e);
			return "blue";
		}
	}
	
	private static BitmapDrawable getDrawableForType(String type) {
		switch (type) {
			case "bg": return BitmapHolder.getBitmapDrawable("bg");
			case "button": return BitmapHolder.getBitmapDrawable("bbg");
			case "red": return BitmapHolder.getBitmapDrawable("rbg");
			default: return null;
		}
	}
	
	private static String generateCssGradient(String[] params, int patternType) {
    String[] colors = splitColors(params[0]);
    if (colors.length == 0) return "transparent";
    
    String gradientType = "";
    switch (patternType) {
        case 0: gradientType = "to bottom"; break;
        case 1: gradientType = "to right"; break;
        case 2: gradientType = "to bottom right"; break;
        case 3: gradientType = "to top right"; break;
        case 4: gradientType = "circle"; break;     // Радіальний
        case 5: gradientType = "from 0deg"; break;  // ДОДАНО: Кутовий (Conic)
        default: return "transparent";
    }
    
    String colorStops = buildColorStops(
        colors,
        Integer.parseInt(params[1]),
        Integer.parseInt(params[2])
    );
    
    // ЗМІНЕНА ЛОГІКА ПОВЕРНЕННЯ
    if (patternType == 5) {
        return "conic-gradient(" + gradientType + ", " + colorStops + ")";
    }

    return patternType == 4 
        ? "radial-gradient(" + gradientType + ", " + colorStops + ")"
        : "linear-gradient(" + gradientType + ", " + colorStops + ")";
}
	
	private static String[] getParams(ExtendedDataHolder dh, String type) {
		switch (type) {
			case "button": return new String[]{
				dh.getData("bbg"), dh.getData("strcou"), dh.getData("tm"), dh.getData("grad")};
			case "red": return new String[]{
				dh.getData("rbg"), dh.getData("rstrcou"), dh.getData("rtm"), dh.getData("rgrad")};
			default: return new String[]{
				dh.getData("bg"), dh.getData("bstrcou"), dh.getData("btm"), dh.getData("bgrad")};
		}
	}
	
	private static String buildColorStops(String[] colors, int segments, int sharpness) {
    StringBuilder builder = new StringBuilder();

    if (colors == null || colors.length == 0 || segments <= 0) {
        return "transparent";
    }

    int colorsPerSegment = Math.max(1, colors.length / segments);

    // Підготовка списку кольорів з урахуванням sharpness
    List<String> colorList = new ArrayList<>();
    for (int i = 0; i < segments; i++) {
        for (int j = 0; j < colorsPerSegment; j++) {
            String color = colors[(i * colorsPerSegment + j) % colors.length];

            if (sharpness == 0) {
                // додаємо колір один раз
                colorList.add(color);
            } else {
                // додаємо колір `sharpness` разів
                for (int k = 0; k < sharpness; k++) {
                    colorList.add(color);
                }
            }
        }
    }

    // Якщо sharpness == 0, перемішуємо кольори
    if (sharpness == 0) {
        Collections.shuffle(colorList);
    }

    // Формуємо рядок
    for (String color : colorList) {
        builder.append(color).append(", ");
    }

    return builder.length() > 2
        ? builder.substring(0, builder.length() - 2)
        : "transparent";
}

	
	private static String[] splitColors(String colorStr) {
		if (colorStr == null || colorStr.length() % 8 != 0) {
			return new String[0];
		}
		
		String[] result = new String[colorStr.length() / 8];
		for (int i = 0; i < result.length; i++) {
			String hex = colorStr.substring(i * 8, i * 8 + 8);
			result[i] = "#" + hex.substring(2) + hex.substring(0, 2);
		}
		return result;
	}
	
	private static String convertColor(String color) {
		return (color == null || color.length() != 8) 
		? "#FFFFFFFF" 
		: "#" + color.substring(2) + color.substring(0, 2);
	}
	
private static String minifyJS(String js) {
    if (js == null) return "";

    StringBuilder result = new StringBuilder();

    int length = js.length();
    int i = 0;

    while (i < length) {
        char c = js.charAt(i);
        char next = (i + 1 < length) ? js.charAt(i + 1) : '\0';

        // 🔹 Обробка однорядкових коментарів //...
        if (c == '/' && next == '/') {
            // Пропускаємо до кінця рядка
            i += 2;
            while (i < length && js.charAt(i) != '\n') i++;
            continue;
        }

        // 🔹 Обробка рядків в одинарних лапках
        if (c == '\'' || c == '"' || c == '`') {
            char quote = c;
            result.append(c);
            i++;
            while (i < length) {
                char ch = js.charAt(i);
                result.append(ch);

                if (ch == quote && !isEscaped(js, i)) {
                    i++;
                    break;
                }
                i++;
            }
            continue;
        }

        // 🔹 Інакше — звичайний символ
        result.append(c);
        i++;
    }

    return result.toString();
}

// 🔎 Перевірка, чи символ перед index є escape (\\' або \")
private static boolean isEscaped(String str, int index) {
    int backslashes = 0;
    index--;
    while (index >= 0 && str.charAt(index) == '\\') {
        backslashes++;
        index--;
    }
    return backslashes % 2 == 1;
}


	
}
