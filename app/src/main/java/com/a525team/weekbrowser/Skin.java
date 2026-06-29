package com.a525team.weekbrowser;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

import java.util.Random;

public class Skin {
	
	// -----------------------------------------------------
	// 1. SINGLETON ТА ІНІЦІАЛІЗАЦІЯ
	// -----------------------------------------------------
	private static volatile Skin instance;
	private final ExtendedDataHolder dataHolder;
	
	// Кешовані змінні
	public int[] color1, rcolor1, bg;
	public int grad, rgrad, bgrad, roundness, rroundness, sroundness, rsroundness;
	public int stripec, rstripec, bstripec, tm, rtm, btm, resol, stripeCount;
	public float gradientRadius, gradientCenterX, gradientCenterY;
	public float rgradientRadius, rgradientCenterX, rgradientCenterY;
	public float bgradientRadius, bgradientCenterX, bgradientCenterY;
	public int[] colors;
	
	private Skin() {
		dataHolder = ExtendedDataHolder.getInstance();
		reload();
	}
	
	public static Skin getInstance() {
		if (instance == null) {
			synchronized (Skin.class) {
				if (instance == null) {
					instance = new Skin();
				}
			}
		}
		return instance;
	}
    
    public void setStaticBG(android.app.Activity activity, int r, boolean wrapInScroll) {
    android.view.ViewGroup rootContent = activity.findViewById(android.R.id.content);
    android.view.View existingContent = rootContent.getChildAt(0);

    if (existingContent == null) return; // Захист від NullPointerException

    // --- КЛЮЧОВИЙ ФІКС №1: ОЧИЩЕННЯ ФОНУ ---
    // Робимо існуючий контент прозорим. Якщо цього не зробити, його власний 
    // фон буде розтягуватися на всю висоту контенту і перекривати наш bgView.
    existingContent.setBackgroundResource(0);
    
    // Якщо existingContent вже є ScrollView (як у налаштуваннях), 
    // варто також очистити фон його внутрішнього контейнера.
    if (existingContent instanceof android.widget.ScrollView) {
        android.view.View scrollChild = ((android.widget.ScrollView) existingContent).getChildAt(0);
        if (scrollChild != null) {
            scrollChild.setBackgroundResource(0);
        }
    }

    android.widget.FrameLayout newRoot = new android.widget.FrameLayout(activity);
    
    // --- СТАТИЧНИЙ ФОН ---
    // Лежить у кореневому FrameLayout з параметрами MATCH_PARENT,
    // тому він ЖОРСТКО прив'язаний до розмірів екрану і ніколи не розтягнеться.
    android.view.View bgView = new android.view.View(activity);
    bgView.setTag("custom_static_bg");
    newRoot.addView(bgView, new android.widget.FrameLayout.LayoutParams(
            android.view.ViewGroup.LayoutParams.MATCH_PARENT, 
            android.view.ViewGroup.LayoutParams.MATCH_PARENT));

    // Логіка обгортання контенту
    if (wrapInScroll) {
        android.widget.ScrollView scrollView = new android.widget.ScrollView(activity);
        scrollView.setFillViewport(true);
        
        rootContent.removeView(existingContent);
        
        // --- КЛЮЧОВИЙ ФІКС №2: ПАРАМЕТРИ ДЛЯ SCROLLVIEW ---
        // Прямий нащадок ScrollView ОБОВ'ЯЗКОВО повинен мати висоту WRAP_CONTENT.
        android.widget.FrameLayout.LayoutParams scrollChildParams = new android.widget.FrameLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT, 
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
                
        scrollView.addView(existingContent, scrollChildParams);
        
        newRoot.addView(scrollView, new android.widget.FrameLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT, 
                android.view.ViewGroup.LayoutParams.MATCH_PARENT));
    } else {
        rootContent.removeView(existingContent);
        newRoot.addView(existingContent, new android.widget.FrameLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT, 
                android.view.ViewGroup.LayoutParams.MATCH_PARENT));
    }

    activity.setContentView(newRoot);
    
    // Встановлюємо графіку (Canvas/Gradient) виключно на статичний bgView
    setBG(bgView, r, false);
}

public void updateBG(android.app.Activity activity, int r) {
    android.view.View bgView = activity.findViewById(android.R.id.content).findViewWithTag("custom_static_bg");
    if (bgView != null) {
        setBG(bgView, r, false);
        bgView.invalidate();
    }
}

/*private void stripBackgrounds(android.view.View view) {
    // Робимо прозорими ScrollView та базові контейнери (не чіпаючи кнопки/текст)
    if (view instanceof android.widget.ScrollView || 
        view instanceof android.widget.LinearLayout || 
        view instanceof android.widget.RelativeLayout ||
        view instanceof android.widget.FrameLayout) {
        view.setBackgroundColor(android.graphics.Color.TRANSPARENT);
    }
    
    if (view instanceof android.view.ViewGroup) {
        android.view.ViewGroup vg = (android.view.ViewGroup) view;
        for (int i = 0; i < vg.getChildCount(); i++) {
            stripBackgrounds(vg.getChildAt(i));
        }
    }
}*/
	
	// Оновлення кешованих змінних (викликати після зміни теми)
	public void reload() {
		color1 = parseColorArray(dataHolder.getData("bbg"));
		rcolor1 = parseColorArray(dataHolder.getData("rbg"));
		bg = parseColorArray(dataHolder.getData("bg"));
		
		grad = safeParseInt(dataHolder.getData("grad"), 0);
		rgrad = safeParseInt(dataHolder.getData("rgrad"), 0);
		bgrad = safeParseInt(dataHolder.getData("bgrad"), 0);
		
		roundness = safeParseInt(dataHolder.getData("rou"), 0);
		rroundness = safeParseInt(dataHolder.getData("rrou"), 0);
		sroundness = safeParseInt(dataHolder.getData("srou"), 0);
		rsroundness = safeParseInt(dataHolder.getData("rsrou"), 0);
		
		stripec = safeParseInt(dataHolder.getData("strcou"), 0);
		rstripec = safeParseInt(dataHolder.getData("rstrcou"), 0);
		bstripec = safeParseInt(dataHolder.getData("bstrcou"), 0);
		
		gradientRadius = safeParseFloat(dataHolder.getData("rad"), 0.0f);
		gradientCenterX = safeParseFloat(dataHolder.getData("x"), 0.0f);
		gradientCenterY = safeParseFloat(dataHolder.getData("y"), 0.0f);
		
		rgradientRadius = safeParseFloat(dataHolder.getData("rrad"), 0.0f);
		rgradientCenterX = safeParseFloat(dataHolder.getData("rx"), 0.0f);
		rgradientCenterY = safeParseFloat(dataHolder.getData("ry"), 0.0f);
		
		bgradientRadius = safeParseFloat(dataHolder.getData("brad"), 0.0f);
		bgradientCenterX = safeParseFloat(dataHolder.getData("bx"), 0.0f);
		bgradientCenterY = safeParseFloat(dataHolder.getData("by"), 0.0f);
		
		tm = safeParseInt(dataHolder.getData("tm"), 0);
		rtm = safeParseInt(dataHolder.getData("rtm"), 0);
		btm = safeParseInt(dataHolder.getData("btm"), 0);
		
		resol = safeParseInt(dataHolder.getData("resol"), 500);
	}
	
	// Додай ці змінні до полів класу Skin.java
	private final java.util.ArrayList<SkinObserver> observers = new java.util.ArrayList<>();
	
	// Додай ці три методи в Skin.java:
	
	public void registerObserver(SkinObserver observer) {
		if (!observers.contains(observer)) {
			observers.add(observer);
			observer.onSkinChanged(); // Одразу фарбуємо при появі на екрані
		}
	}
	
	public void unregisterObserver(SkinObserver observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		for (SkinObserver observer : observers) {
			if (observer != null) observer.onSkinChanged();
		}
	}
	
	// Хелпер для динамічного витягування масивів кольорів тексту/підказок
	public int[] getColorsByKey(String key) {
		if (key == null || key.isEmpty()) return null;
		switch (key) {
			case "bg": return this.bg;
			case "bbg": return this.color1;
			case "rbg": return this.rcolor1;
			default:
			// Для всіх інших текстових ключів (t, tf, bt, rbt, h, add...) парсимо на льоту
			return parseColorArray(dataHolder.getData(key));
		}
	}
	
	// -----------------------------------------------------
	// 2. ДОПОМІЖНІ МЕТОДИ (Парсинг, Кольори)
	// -----------------------------------------------------
	private int[] parseColorArray(String colorString) {
		try {
			int length = colorString.length();
			if (length == 0) return new int[]{0};
			int[] c = new int[length / 8];
			for (int i = 0; i < length; i += 8) {
				c[i / 8] = (int) Long.parseLong(colorString.substring(i, i + 8), 16);
			}
			return c;
		} catch (Exception e) {
			return new int[]{0};
		}
	}
	
	private int safeParseInt(String data, int defaultValue) {
		try { return Integer.parseInt(data); } catch (Exception e) { return defaultValue; }
	}
	
	private float safeParseFloat(String data, float defaultValue) {
		try { return Float.parseFloat(data); } catch (Exception e) { return defaultValue; }
	}
	
	private int avgcol(int[] c) {
		int cl = c.length;
		int r = 0, g = 0, b = 0;
		for (int cc : c) {
			r += (cc >> 16) & 0xFF;
			g += (cc >> 8) & 0xFF;
			b += cc & 0xFF;
		}
		r /= cl; g /= cl; b /= cl;
		return (255 << 24) | (r << 16) | (g << 8) | b;
	}
	
	public int StatusCol() {
		try { return (int) Long.parseLong(dataHolder.getData("bg").substring(0, 8), 16); } 
		catch (Exception e) { return Color.BLACK; }
	}
	
	public int NavCol() {
		try { 
			String bbg = dataHolder.getData("bg");
			return (int) Long.parseLong(bbg.substring(bbg.length() - 8), 16); 
		} 
		catch (Exception e) { return Color.BLACK; }
	}
	
	public int avgbg() { return avgcol(bg); }
	public int avgb() { return avgcol(color1); }
	public int avgrb() { return avgcol(rcolor1); }
	
	// -----------------------------------------------------
	// 3. ЛОГІКА ТЕМ ТА КОЛЬОРІВ (Material You + Dark/Light)
	// -----------------------------------------------------
	/*public static boolean isSystemDarkMode(Context context) {
		int nightModeFlags = context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
		return nightModeFlags == Configuration.UI_MODE_NIGHT_YES;
	}*/
	
	private String getSysColor(Context context, int colorResId) {
		return Integer.toHexString(context.getResources().getColor(colorResId)).toUpperCase();
	}
	
	private void applyColors(String bg, String bbg, String rbg, String t, String tf, String add, String h, String cb, String tpc, String tc, String bt, String rbt) {
		dataHolder.setData("bg", bg); dataHolder.setData("bbg", bbg); dataHolder.setData("rbg", rbg);
		dataHolder.setData("t", t); dataHolder.setData("tf", tf); dataHolder.setData("add", add);
		dataHolder.setData("h", h); dataHolder.setData("cb", cb); dataHolder.setData("tpc", tpc);
		dataHolder.setData("tc", tc); dataHolder.setData("bt", bt); dataHolder.setData("rbt", rbt);
	}
	
	private void applyGeometry(String rou, String rrou, String srou, String rsrou, String grad, String rad, String x, String y, String strcou) {
		dataHolder.setData("rou", rou); dataHolder.setData("rrou", rrou);
		dataHolder.setData("srou", srou); dataHolder.setData("rsrou", rsrou);
		dataHolder.setData("grad", grad); dataHolder.setData("rgrad", grad); dataHolder.setData("bgrad", grad);
		dataHolder.setData("rad", rad); dataHolder.setData("rrad", rad); dataHolder.setData("brad", rad);
		dataHolder.setData("x", x); dataHolder.setData("rx", x); dataHolder.setData("bx", x);
		dataHolder.setData("y", y); dataHolder.setData("ry", y); dataHolder.setData("by", y);
		dataHolder.setData("strcou", strcou); dataHolder.setData("rstrcou", strcou); dataHolder.setData("bstrcou", strcou);
		dataHolder.setData("tm", "1"); dataHolder.setData("rtm", "1"); dataHolder.setData("btm", "1");
	}
	
	public void colorToRam(Context context) {
		BitmapHolder.clearCache();
		JSutil.clearCache(); // Якщо JSutil ще використовується
		
		SharedPreferences sf = context.getSharedPreferences("sf", Context.MODE_PRIVATE);
		String themePref = sf.getString("theme", "auto");
		
	/*	if (themePref.isEmpty() || themePref.equals("auto")) {
			themePref = isSystemDarkMode(context) ? "1" : "0";
		}*/
		
		boolean isMonet = WTF.SDK_INT() >= 31;
		
		switch (themePref) {
			case "0": // Світла
			case "8": // Material White fallback
			if (isMonet && themePref.equals("0")) {
				applyColors(
				getSysColor(context, android.R.color.system_accent1_10),
				getSysColor(context, android.R.color.system_accent1_600), "ffD32F2F",
				getSysColor(context, android.R.color.system_neutral2_700), getSysColor(context, android.R.color.system_neutral2_700),
				getSysColor(context, android.R.color.system_accent3_600), getSysColor(context, android.R.color.system_accent2_600),
				getSysColor(context, android.R.color.system_accent1_600), getSysColor(context, android.R.color.system_accent1_600),
				getSysColor(context, android.R.color.system_accent1_600), getSysColor(context, android.R.color.system_accent1_50),
				"ffFFCDD2"
				);
			} else {
				applyColors("ffffffff", "FF00897B", "ffD32F2F", "FF455A64", "FF455A64", "ff388E3C", "FF4A6360", "FF00897B", "FF00897B", "FF00897B", "FFE0F2F1", "ffFFCDD2");
			}
			applyGeometry("12", "4", "6", "2", "0", "1", "0.5", "0.5", "2");
			break;
			
			case "1": // Темна
			case "9": // Material Dark fallback
			if (isMonet && themePref.equals("1")) {
				applyColors(
				getSysColor(context, android.R.color.system_neutral2_900),
				getSysColor(context, android.R.color.system_accent1_700), "ffC62828",
				getSysColor(context, android.R.color.system_neutral2_200), getSysColor(context, android.R.color.system_neutral2_200),
				getSysColor(context, android.R.color.system_accent3_200), getSysColor(context, android.R.color.system_accent2_200),
				getSysColor(context, android.R.color.system_accent1_200), getSysColor(context, android.R.color.system_accent1_200),
				getSysColor(context, android.R.color.system_accent1_200), getSysColor(context, android.R.color.system_accent1_50),
				"ffFFCDD2"
				);
			} else {
				applyColors("FF263238", "FF00796B", "ffC62828", "FFB0BEC5", "FFB0BEC5", "ff81C784", "FFB0CCC8", "FF80CBC4", "FF80CBC4", "FF80CBC4", "FFE0F2F1", "ffFFCDD2");
			}
			applyGeometry("12", "4", "6", "2", "0", "1", "0.5", "0.5", "2");
			break;
			
			case "2": // Контрастна (Hacker)
			applyColors("ff000000", "ff00ffff", "ffff0000", "ffffffff", "ff000000", "ff00ffff", "ffffff00", "ffffff00", "ff00ff00", "ff00ffff", "ff000000", "ffffffff");
			applyGeometry("0", "0", "0", "0", "0", "1", "0.5", "0.5", "2");
			break;
			
			case "4": // Amoled White
			if (isMonet) {
				applyColors("ffffffff", getSysColor(context, android.R.color.system_accent1_600), "ffD32F2F",
				getSysColor(context, android.R.color.system_neutral2_700), getSysColor(context, android.R.color.system_neutral2_700),
				getSysColor(context, android.R.color.system_accent3_600), getSysColor(context, android.R.color.system_accent2_600),
				getSysColor(context, android.R.color.system_accent1_600), getSysColor(context, android.R.color.system_accent1_600),
				getSysColor(context, android.R.color.system_accent1_600), getSysColor(context, android.R.color.system_accent1_50), "ffFFCDD2");
			} else {
				applyColors("ffffffff", "FF00897B", "ffD32F2F", "FF455A64", "FF455A64", "ff388E3C", "FF4A6360", "FF00897B", "FF00897B", "FF00897B", "FFE0F2F1", "ffFFCDD2");
			}
			applyGeometry("12", "4", "6", "2", "0", "1", "0.5", "0.5", "2");
			dataHolder.setData("tmy", "2"); dataHolder.setData("rtmy", "2"); dataHolder.setData("btmy", "2");
			break;
			
			case "5": // Amoled Black
			case "10": // Material Black fallback
			if (isMonet && themePref.equals("5")) {
				applyColors("ff000000", getSysColor(context, android.R.color.system_accent1_700), "ffD32F2F",
				getSysColor(context, android.R.color.system_neutral2_200), getSysColor(context, android.R.color.system_neutral2_200),
				getSysColor(context, android.R.color.system_accent3_200), getSysColor(context, android.R.color.system_accent2_200),
				getSysColor(context, android.R.color.system_accent1_200), getSysColor(context, android.R.color.system_accent1_200),
				getSysColor(context, android.R.color.system_accent1_200), getSysColor(context, android.R.color.system_accent1_50), "ffFFCDD2");
			} else {
				applyColors("ff000000", "FF00796B", "ffC62828", "FFB0BEC5", "FFB0BEC5", "ff81C784", "FFB0CCC8", "FF80CBC4", "FF80CBC4", "FF80CBC4", "FFE0F2F1", "ffFFCDD2");
			}
			applyGeometry("12", "4", "6", "2", "0", "1", "0.5", "0.5", "2");
			break;
			
			case "6":
			applyColors("ffffffff", "ffd6d6d6", "ffd6d6d6", "ff000000", "ff000000", "ff35b5e5", "ff757575", "ff33b5e5", "ff33b5e5", "ff33b5e5", "ff000000", "ffff0000");
			applyGeometry("0", "0", "0", "0", "0", "1", "0.5", "0.5", "2");
			break;
			
			case "7":
			applyColors("ff000000ff282d33", "ff525252", "ff525252", "ffffffff", "ffffffff", "ff35b5e5", "ffbdbdbd", "ff33b5e5", "ff33b5e5", "ff33b5e5", "ffffffff", "ffff8080");
			applyGeometry("0", "0", "0", "0", "0", "1", "0.5", "0.5", "2");
			break;
			
			case "11":
			applyColors("ffffffff", "ffeaeaeaffb8b8b8", "ffeaeaeaffb8b8b8", "ff000000", "ff000000", "ff68B200", "ff888888", "ff68B200", "ffffbb00", "ff9b9b9b", "ff000000", "ffff0000");
			applyGeometry("0", "0", "0", "0", "0", "1", "0.5", "0.5", "2");
			break;
			
			case "12":
			applyColors("ff000000", "ffeaeaeaffb8b8b8", "ffeaeaeaffb8b8b8", "ffffffff", "ff000000", "ff90ff22", "ff888888", "ff90ff22", "ffffbb00", "ff9b9b9b", "ff000000", "ffff0000");
			applyGeometry("0", "0", "0", "0", "0", "1", "0.5", "0.5", "2");
			break;
			
			case "13":
			applyColors("ff000000", "ffffff00", "ffff0000", "ffffffff", "ff000000", "ff00ffff", "ff00ff00", "ffffff00", "ffffff00", "ffffff00", "ff000000", "ffffffff");
			applyGeometry("0", "0", "0", "0", "0", "1", "0.5", "0.5", "2");
			break;
			
			case "14":
			applyColors("ff000000", "ff00ff00", "ffff0000", "ff00ff00", "ff00ffff", "ffffff00", "ffff00ff", "ff00ffff", "ff00ffff", "ff00ff00", "ff000000", "ffffff00");
			applyGeometry("6", "0", "4", "0", "0", "1", "0.5", "0.5", "2");
			break;
			
			case "15":
			applyColors("ffffffff", "ff000000", "ff0000ff", "ff000000", "ff000000", "ff0000ff", "ff880088", "ff000000", "ff000000", "ff0000ff", "ffffffff", "ff00ffff");
			applyGeometry("0", "0", "0", "0", "0", "1", "0.5", "0.5", "2");
			break;
			
			case "16":
			applyColors("ff000000ff330000", "ff770000ff000000", "ffff0000ffff7777", "ffffdddd", "ffffbbbb", "ffff7777", "ffff0000", "ffff0000", "ffff0000", "ffff0000", "ffff7777", "ff550000");
			applyGeometry("15", "8", "8", "4", "0", "1", "0.5", "0.5", "2");
			dataHolder.setData("bgrad", "5"); dataHolder.setData("bstrcou", "5");
			break;
			
			case "17":
			applyColors("ffffbbbbffffdddd", "ff770000ffbb0000", "ff000000ffff7777", "ff330000", "ff770000", "ffff0000", "ffff5555", "ff770000", "ff770000", "ff770000", "ffffbbbb", "ff550000");
			applyGeometry("15", "8", "8", "4", "0", "1", "0.5", "0.5", "2");
			dataHolder.setData("bgrad", "5"); dataHolder.setData("bstrcou", "5");
			break;
			
			case "18":
			applyColors("ff000000ff331c00", "ffff8700ffce5d00", "ffbb0000ffff0000", "ffffdead", "ffffbf7f", "ffff8400", "ff885500", "ffff7a00", "ffff7b00", "ffffb100", "ffffffff", "ffffffff");
			applyGeometry("10", "5", "5", "2", "2", "1", "0.5", "0.5", "2");
			dataHolder.setData("rgrad", "1"); dataHolder.setData("bgrad", "0"); 
			dataHolder.setData("tm", "2");
			break;
			
			case "19":
			applyColors("ff000000ff181400", "ff00ffffff00bbbb", "ffa10000ff770000", "ffffffff", "ffffffbb", "ffffff00", "ff999900", "ffff7a00", "ffff7b00", "ffffb100", "ff003333", "ffffffff");
			applyGeometry("0", "0", "0", "0", "8", "1", "3.0", "0.5", "2");
			dataHolder.setData("bgrad", "6");
			dataHolder.setData("bx", "1.0"); dataHolder.setData("by", "-2.0");
			break;
			
			case "20":
			applyColors("ff322500", "ffffff00", "ffff7700", "ffffffff", "ffffffff", "ffff8000", "ffbd5e00", "ffff7a00", "ffff7b00", "ffffb100", "ff000000", "ffffffff");
			applyGeometry("20", "20", "10", "10", "0", "1", "0.5", "0.5", "2");
			break;
			
			case "21":
			applyColors("ff003300", "ff000000", "ff330000", "ff00ff00", "ff00ff00", "ff00ffff", "ff00bb00", "ff00ff00", "ff00ffff", "ff00ff00", "ff00ff00", "ffff0000");
			applyGeometry("0", "0", "0", "0", "0", "1", "0.5", "0.5", "2");
			break;
			
			case "22":
			applyColors("ffffffbb", "ffffff00", "ffb8ff77", "ff000000", "ff000000", "ff777700", "ffbbbb00", "ff777700", "ff777700", "ff777700", "ff555500", "ff2e5500");
			applyGeometry("20", "20", "10", "10", "0", "1", "0.5", "0.5", "2");
			break;
			
			case "23":
			applyColors("ff003300ff000000", "ff005300ff00ff00", "ff000000ffff7300", "ffddffdd", "ffbbff99", "ff00ff00", "ff009900", "ff00ff00", "ff00ff00", "ff00ff00", "ff000000", "ffffff00");
			applyGeometry("0", "0", "0", "0", "0", "1", "0.5", "0.5", "2");
			break;
			
			case "24":
			applyColors("ffffffff", "ff000000", "ff000000", "ff000000", "ff000000", "ff000000", "ff000000", "ff000000", "ff000000", "ff000000", "ffffffff", "ffffffff");
			applyGeometry("15", "5", "10", "3", "0", "1", "0.5", "0.5", "2");
			break;
			
			case "25":
			applyColors("ff000000", "ffffffff", "ffffffff", "ffffffff", "ffffffff", "ffffffff", "ffffffff", "ffffffff", "ffffffff", "ffffffff", "ff000000", "ff000000");
			applyGeometry("15", "5", "10", "3", "0", "1", "0.5", "0.5", "2");
			break;
			
			case "3": // Користувацька (Custom)
			// Припускаємо, що processColor реалізовано в контексті твого додатку
			dataHolder.setData("bg", processColor(sf.getString("bg", ""), true, isMonet, context));
			dataHolder.setData("bbg", processColor(sf.getString("bbg", ""), true, isMonet, context));
			dataHolder.setData("rbg", processColor(sf.getString("rbg", ""), true, isMonet, context));
			dataHolder.setData("t", processColor(sf.getString("t", ""), false, isMonet, context));
			dataHolder.setData("tf", processColor(sf.getString("tf", ""), false, isMonet, context));
			dataHolder.setData("add", processColor(sf.getString("add", ""), false, isMonet, context));
			dataHolder.setData("h", processColor(sf.getString("h", ""), false, isMonet, context));
			dataHolder.setData("bt", processColor(sf.getString("bt", ""), false, isMonet, context));
			dataHolder.setData("rbt", processColor(sf.getString("rbt", ""), false, isMonet, context));
			dataHolder.setData("cb", processColor(sf.getString("cb", ""), false, isMonet, context));
			dataHolder.setData("tpc", processColor(sf.getString("tpc", ""), false, isMonet, context));
			dataHolder.setData("tc", processColor(sf.getString("tc", ""), false, isMonet, context));
			
			// Інші дані зчитуємо безпосередньо з SharedPreferences
			dataHolder.setData("rou", sf.getString("rou", ""));
			dataHolder.setData("rrou", sf.getString("rrou", ""));
			dataHolder.setData("srou", sf.getString("srou", ""));
			dataHolder.setData("rsrou", sf.getString("rsrou", ""));
			
			dataHolder.setData("grad", sf.getString("grad", ""));
			dataHolder.setData("rgrad", sf.getString("rgrad", ""));
			dataHolder.setData("bgrad", sf.getString("bgrad", ""));
			
			dataHolder.setData("rad", sf.getString("rad", ""));
			dataHolder.setData("rrad", sf.getString("rrad", ""));
			dataHolder.setData("brad", sf.getString("brad", ""));
			
			dataHolder.setData("x", sf.getString("x", ""));
			dataHolder.setData("rx", sf.getString("rx", ""));
			dataHolder.setData("bx", sf.getString("bx", ""));
			
			dataHolder.setData("y", sf.getString("y", ""));
			dataHolder.setData("ry", sf.getString("ry", ""));
			dataHolder.setData("by", sf.getString("by", ""));
			
			dataHolder.setData("strcou", sf.getString("strcou", ""));
			dataHolder.setData("rstrcou", sf.getString("rstrcou", ""));
			dataHolder.setData("bstrcou", sf.getString("bstrcou", ""));
			
			dataHolder.setData("tm", sf.getString("tm", ""));
			dataHolder.setData("rtm", sf.getString("rtm", ""));
			dataHolder.setData("btm", sf.getString("btm", ""));
			break;
		}
		
		// --- Додаткові параметри (Анімації, Ефекти, Енергозбереження) ---
		dataHolder.setData("listanimp", sf.getString("listanimp", ""));
		dataHolder.setData("listanimi", sf.getString("listanimi", ""));
		dataHolder.setData("bpanimp", sf.getString("bpanimp", ""));
		dataHolder.setData("bpanimi", sf.getString("bpanimi", ""));
		dataHolder.setData("spanimp", sf.getString("spanimp", ""));
		dataHolder.setData("spanimi", sf.getString("spanimi", ""));
		
		dataHolder.setData("don", sf.getString("don", ""));
		dataHolder.setData("dblurx", sf.getString("dblurx", ""));
		dataHolder.setData("dblury", sf.getString("dblury", ""));
		dataHolder.setData("drred", sf.getString("drred", ""));
		dataHolder.setData("drgreen", sf.getString("drgreen", ""));
		dataHolder.setData("drblue", sf.getString("drblue", ""));
		dataHolder.setData("dsatur", sf.getString("dsatur", ""));
		dataHolder.setData("dvred", sf.getString("dvred", ""));
		dataHolder.setData("dvgreen", sf.getString("dvgreen", ""));
		dataHolder.setData("dvblue", sf.getString("dvblue", ""));
		dataHolder.setData("dvalp", sf.getString("dvalp", ""));
		
		dataHolder.setData("resol", sf.getString("resol", "500"));
		
		boolean saver = BatterySaverChecker.isBatterySaverOn(context);
		if (saver) {
			dataHolder.setData("batsav", "1");
		} else {
			dataHolder.setData("batsav", sf.getString("batsav", "0"));
		}
		
		// Оновлюємо кеш Skin.java після застосування нових налаштувань
		reload();
	}
	
	// -----------------------------------------------------
	// 4. ВІДМАЛЬОВКА БЕКГРАУНДІВ
	// -----------------------------------------------------
	void stripe(int[] colorArray, int r) {
		int sharp = (r == 2 ? btm : r == 1 ? rtm : tm);
		int stri = r == 2 ? bstripec : r == 1 ? rstripec : stripec;
		stripeCount = Math.max(stri, 2);
		
		if (sharp != 0) {
			colors = new int[stripeCount * sharp];
			for (int i = 0; i < stripeCount * sharp; i++) {
				colors[i] = colorArray[(i / sharp) % colorArray.length];
			}
		} else {
			colors = new int[stri];
			Random rnd = new Random();
			for (int i = 0; i < stri; i++) {
				colors[i] = colorArray[rnd.nextInt(colorArray.length)];
			}
		}
	}
	
	private boolean setCachedBG(View v, int r) {
		String cacheKey = (r == 2) ? "bg" : (r == 1 ? "rbg" : "bbg");
		BitmapDrawable bit = BitmapHolder.getBitmapDrawable(cacheKey);
		if (bit == null) return false;
		bit.setTargetDensity(1);
		v.setBackground(bit);
		v.invalidate();
		return true;
	}
	
	private BitmapDrawable create1x1Drawable(int color, Context context) {
		Bitmap bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
		bitmap.setPixel(0, 0, color);
		return new BitmapDrawable(context.getResources(), bitmap);
	}
	
	public void setBG(View v, int r, boolean s) {
		int[] colorArray = r == 2 ? bg : (r==1 || r==3) ? rcolor1 : color1;
		
		if (dataHolder.getData("batsav") != null && dataHolder.getData("batsav").equals("0")) {
			if (setCachedBG(v, r)) return;
			try {
				int g = r == 2 ? bgrad : r == 1 ? rgrad : grad;
				float gradientX = r == 2 ? bgradientCenterX : r == 1 ? rgradientCenterX : gradientCenterX;
				float gradientY = r == 2 ? bgradientCenterY : r == 1 ? rgradientCenterY : gradientCenterY;
				float gradientR = r == 2 ? bgradientRadius : r == 1 ? rgradientRadius : gradientRadius;
				
				stripe(colorArray, r);
				Drawable drawable = null;
				
				double re = resol / 500.0;
				if (r != 2) {
					re /= 2.0;
					if (s) re /= 5.0;
				}
				re = Math.max(0.3, Math.min(re, 4.0));
				
				switch (g) {
					case 0: case 1: case 2: case 3:
					GradientDrawable.Orientation[] orientations = {
						GradientDrawable.Orientation.TOP_BOTTOM, GradientDrawable.Orientation.LEFT_RIGHT,
						GradientDrawable.Orientation.TL_BR, GradientDrawable.Orientation.TR_BL
					};
					drawable = new GradientDrawable(orientations[g], colors);
					break;
					case 4:
					GradientDrawable radialDrawable = new GradientDrawable();
					radialDrawable.setShape(GradientDrawable.RECTANGLE);
					radialDrawable.setGradientType(GradientDrawable.RADIAL_GRADIENT);
					radialDrawable.setColors(colors);
					radialDrawable.setGradientCenter(gradientX, gradientY);
					radialDrawable.setGradientRadius(Math.max(400 * gradientR, gradientR * Resources.getSystem().getDisplayMetrics().density * 100));
					drawable = radialDrawable;
					break;
					case 5:
					GradientDrawable sweepDrawable = new GradientDrawable();
					sweepDrawable.setShape(GradientDrawable.RECTANGLE);
					sweepDrawable.setGradientType(GradientDrawable.SWEEP_GRADIENT);
					sweepDrawable.setColors(colors);
					sweepDrawable.setGradientCenter(gradientX, gradientY);
					drawable = sweepDrawable;
					break;
					case 6: case 7:
					drawable = drawCheckerboard(v, re, gradientX, gradientY, r, g == 6);
					break;
					case 8:
					drawable = drawIsoscelesTriangles(v, re, gradientX, r);
					break;
					case 9:
					drawable = drawRightTriangles(v, re, gradientX, r);
					break;
					case 10:
					drawable = drawHexagons(v, re, gradientX, r);
					break;
					case 11:
					drawable = drawDragonScales(v, re, gradientX, r);
					break;
					case 12:
					drawable = drawRandomShapes(v, re, gradientX, gradientY, gradientR, r);
					break;
					default:
					drawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colorArray);
					break;
				}
				
				// ... твій switch(g) з відмальовкою патернів ...
				if (drawable instanceof GradientDrawable) {
					float cornerRadius = (r == 2 ? 0 : (r == 1 ? (s ? rsroundness : rroundness) : (s ? sroundness : roundness))) * Resources.getSystem().getDisplayMetrics().density;
					((GradientDrawable) drawable).setCornerRadius(cornerRadius);
					v.setBackground(drawable);
				} else if (drawable != null) {
					BitmapDrawable ddrawable = (BitmapDrawable) drawable;
					ddrawable.setTargetDensity(1);
					v.setBackground(ddrawable);
					
					// ВИПРАВЛЕНО ТУТ:
					String cacheKey = (r == 2) ? "bg" : (r == 1 ? "rbg" : "bbg");
					if (BitmapHolder.getBitmapDrawable(cacheKey) == null) {
						BitmapHolder.putBitmapDrawable(cacheKey, ddrawable);
					}
					v.invalidate();
				}
			} catch (Exception ignored) {}
		} else {
			// Енергозберігаючий режим (1 колір)
			int avgColor = avgcol(colorArray);
			BitmapDrawable onePixelDrawable = create1x1Drawable(avgColor, v.getContext());
			String cacheKey = r == 0 ? "bbg" : r == 1 ? "rbg" : "bg";
			if (BitmapHolder.getBitmapDrawable(cacheKey) == null) {
				BitmapHolder.putBitmapDrawable(cacheKey, onePixelDrawable);
			}
			v.setBackgroundColor(avgColor);
		}
	}
	
	// -----------------------------------------------------
	// 5. ВИТЯГНУТІ МЕТОДИ ДЛЯ ПАТЕРНІВ
	// -----------------------------------------------------
	
	private void setupCanvasBg(Canvas canvas, int r) {
		if (r == 2) {
			canvas.drawColor(ThemeManager.getLight() ? Color.WHITE : Color.BLACK);
		}
	}
	
	private Paint createPatternPaint() {
		Paint p = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG | Paint.DITHER_FLAG);
		p.setFlags(0);
		return p;
	}
	
	private Drawable drawCheckerboard(View v, double re, float gradientX, float gradientY, int r, boolean isDiagonal) {
		int size = Math.max((int) ((gradientX + 2.2) * 20d * re), 3);
		int width = (int) (500 * re), height = r == 2 ? (int) (500 * re) : (int) (200 * re);
		
		Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		setupCanvasBg(canvas, r);
		
		Paint paint = createPatternPaint();
		float cornerRadius = (float) ((gradientY + 2f) * 10f * Resources.getSystem().getDisplayMetrics().density * re);
		RectF rect = new RectF();
		int colorIndex = 0;
		
		for (int y = 0; y < height; y += size) {
			for (int x = 0; x < width; x += size) {
				colorIndex = isDiagonal ? ((x / size) + (y / size)) : colorIndex + 1;
				paint.setColor(colors[colorIndex % colors.length]);
				rect.set(x, y, x + size, y + size);
				canvas.drawRoundRect(rect, cornerRadius, cornerRadius, paint);
			}
		}
		return new BitmapDrawable(v.getResources(), bitmap);
	}
	
	private Drawable drawIsoscelesTriangles(View v, double re, float gradientX, int r) {
		int size = Math.max((int) ((gradientX + 2.2) * 20d * re), 3);
		int width = (int) (500 * re), height = r == 2 ? (int) (500 * re) : (int) (200 * re);
		
		Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		setupCanvasBg(canvas, r);
		Paint paint = createPatternPaint();
		
		int colorIndex = 0;
		for (int y = 0; y < height; y += size) {
			for (int x = -size / 2; x < width; x += size / 2) {
				paint.setColor(colors[++colorIndex % colors.length]);
				Path path = new Path();
				if (colorIndex % 2 == 0) {
					path.moveTo(x, y); path.lineTo(x + size, y); path.lineTo(x + size / 2f, y + size);
				} else {
					path.moveTo(x, y + size); path.lineTo(x + size, y + size); path.lineTo(x + size / 2f, y);
				}
				path.close();
				canvas.drawPath(path, paint);
			}
		}
		return new BitmapDrawable(v.getResources(), bitmap);
	}
	
	private Drawable drawRightTriangles(View v, double re, float gradientX, int r) {
		int size = Math.max((int) ((gradientX + 2.2) * 20d * re), 3);
		int width = (int) (500 * re), height = r == 2 ? (int) (500 * re) : (int) (200 * re);
		
		Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		setupCanvasBg(canvas, r);
		Paint paint = createPatternPaint();
		
		int colorIndex = 0;
		for (int y = 0; y < height; y += size) {
			for (int x = -size / 2; x < width; x += size / 2) {
				paint.setColor(colors[++colorIndex % colors.length]);
				int triangleX = (x / (size / 2)) % 2 == 0 ? x : x - size / 2;
				Path path = new Path();
				if ((x / (size / 2) + y / size) % 2 == 0) {
					path.moveTo(triangleX, y); path.lineTo(triangleX + size, y); path.lineTo(triangleX + size, y + size);
				} else {
					path.moveTo(triangleX, y + size); path.lineTo(triangleX + size, y + size); path.lineTo(triangleX, y);
				}
				path.close();
				canvas.drawPath(path, paint);
			}
		}
		return new BitmapDrawable(v.getResources(), bitmap);
	}
	
	private Drawable drawHexagons(View v, double re, float gradientX, int r) {
		int size = Math.max((int) ((gradientX + 2.2) * 20d * re), 3);
		int width = (int) (500 * re), height = r == 2 ? (int) (500 * re) : (int) (200 * re);
		
		Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		setupCanvasBg(canvas, r);
		Paint paint = createPatternPaint();
		
		int colorIndex = 0;
		for (int y = -size / 2; y < height; y += size / 2) {
			boolean isEvenRow = ((y + size / 2) / (size / 2)) % 2 == 0;
			for (int x = isEvenRow ? (int) (-size * 0.75) : 0; x < width; x += (int) (size * 1.5)) {
				paint.setColor(colors[++colorIndex % colors.length]);
				Path path = new Path();
				path.moveTo(x, y + size / 2f);
				path.lineTo(x + size / 4f, y + size);
				path.lineTo(x + size * 0.75f, y + size);
				path.lineTo(x + size, y + size / 2f);
				path.lineTo(x + size * 0.75f, y);
				path.lineTo(x + size / 4f, y);
				path.close();
				canvas.drawPath(path, paint);
			}
		}
		return new BitmapDrawable(v.getResources(), bitmap);
	}
	
	private Drawable drawDragonScales(View v, double re, float gradientX, int r) {
		int baseSize = (int) ((gradientX + 2.2) * 20d);
		int size = Math.max(baseSize, 3);
		int width = (int) (500 * re), height = r == 2 ? (int) (500 * re) : (int) (200 * re);
		
		Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		setupCanvasBg(canvas, r);
		Paint paint = createPatternPaint();
		
		int colorIndex = 0;
		float re2 = (float) re;
		for (int baseY = 0; baseY * re < height; baseY += size) {
			for (int baseX = -size / 2; baseX * re < width; baseX += size) {
				paint.setColor(colors[++colorIndex % colors.length]);
				Path path = new Path();
				path.moveTo(baseX * re2, (baseY / 2f * size) * re2);
				path.lineTo((baseX / 4f * size + size) * re2, (baseY + size) * re2);
				path.lineTo((baseX / 4f * 3) * re2, (baseY + size) * re2);
				path.lineTo(baseX * re2, (baseY + size / 2f) * re2);
				path.lineTo((baseX / 4f * 3) * re2, baseY * re2);
				path.close();
				canvas.drawPath(path, paint);
			}
		}
		return new BitmapDrawable(v.getResources(), bitmap);
	}
	
	private Drawable drawRandomShapes(View v, double re, float gradientX, float gradientY, float gradientR, int r) {
		int size = Math.max((int) ((gradientX + 2.5) * 100d * re), 3);
		int den = (int) (((gradientY + 2.5) / 4.0) * size);
		if (den <= 0) den = 1; // Запобіжник від зациклення або ділення на нуль
		int width = (int) (500 * re), height = r == 2 ? (int) (500 * re) : (int) (200 * re);
		
		Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		setupCanvasBg(canvas, r);
		Paint paint = createPatternPaint();
		Random rnd = new Random();
		
		int colorIndex = 0;
		int w = (int) (gradientR * 10.0);
		for (int y = 0; y < height; y += den) {
			for (int x = -size / 2; x < width; x += den) {
				paint.setColor(colors[++colorIndex % colors.length]);
				Path path = new Path();
				int rr = 3 + (w > 0 ? rnd.nextInt(w) : 0);
				path.moveTo(x + rnd.nextInt(size), y + rnd.nextInt(size));
				for (int i = 0; i < rr; i++) {
					path.lineTo(x + rnd.nextInt(size), y + rnd.nextInt(size));
				}
				path.close();
				canvas.drawPath(path, paint);
			}
		}
		return new BitmapDrawable(v.getResources(), bitmap);
	}
	
	public String processColor(String colorString, boolean isBg, boolean isMonet, Context context) {
		if (colorString == null || colorString.trim().isEmpty()) {
			return isBg ? "FFFFFFFF" : "FF000000"; // Дефолтні кольори, якщо порожньо
		}
		String cleaned = colorString.trim();
		return cleaned.toUpperCase();
	}
}
