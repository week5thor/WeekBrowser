package com.a525team.weekbrowser;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.content.SharedPreferences;
import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
//import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.content.res.Resources;
import android.graphics.RectF;
import java.util.Random;
import android.graphics.Path;
//import android.view.Gravity;
//import java.util.Arrays;

public class Skin {
	ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	
	int[] parseColorArray(String colorString) {
		try{
			int length = colorString.length();
			int[] colors = new int[length / 8];
			for (int i = 0; i < length; i += 8) {
				colors[i / 8] = (int) Long.parseLong(colorString.substring(i, i + 8), 16);
			}
			return colors;
		}catch (Exception e){return new int[]{0};}
	}
	
	// Допоміжний метод для безпечного парсингу int
	private int safeParseInt(String data, int defaultValue) {
		try {
			return Integer.parseInt(data);
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	// Допоміжний метод для безпечного парсингу float
	private float safeParseFloat(String data, float defaultValue) {
		try {
			return Float.parseFloat(data);
		} catch (Exception e) {
			return defaultValue;
		}
	}
    
    private int avgcol(int[] c) {
    int cl = c.length;
    int a = 0, r = 0, g = 0, b = 0;

    for (int i = 0; i < cl; i++) {
        int cc = c[i];
        a += (cc >> 24) & 0xFF;
        r += (cc >> 16) & 0xFF;
        g += (cc >> 8) & 0xFF;
        b += cc & 0xFF;
    }

    a /= cl;
    r /= cl;
    g /= cl;
    b /= cl;

    return (a << 24) | (r << 16) | (g << 8) | b;
}
    
    public int StatusCol() {
    String colorHex = "ff000000";
    try{
        colorHex = dataHolder.getData("bg").substring(0, 8);
        }catch(Exception e){}
    return (int) Long.parseLong(colorHex, 16);
}

public int NavCol() {
    String colorHex = "ff000000";
    try{
        String bbg = dataHolder.getData("bg");
    colorHex = bbg.substring(bbg.length() - 8);
    } catch (Exception e){}
    return (int) Long.parseLong(colorHex, 16);
}

	
	// Безпечне оголошення змінних
	int[] color1 = parseColorArray(dataHolder.getData("bbg"));
	int[] rcolor1 = parseColorArray(dataHolder.getData("rbg"));
	int[] bg = parseColorArray(dataHolder.getData("bg"));
	
	int grad = safeParseInt(dataHolder.getData("grad"), 0);
	int rgrad = safeParseInt(dataHolder.getData("rgrad"), 0);
	int bgrad = safeParseInt(dataHolder.getData("bgrad"), 0);
	final int roundness = safeParseInt(dataHolder.getData("rou"), 0);
	final int rroundness = safeParseInt(dataHolder.getData("rrou"), 0);
	final int sroundness = safeParseInt(dataHolder.getData("srou"), 0);
	final int rsroundness = safeParseInt(dataHolder.getData("rsrou"), 0);
	int stripec = safeParseInt(dataHolder.getData("strcou"), 0);
	float gradientRadius = safeParseFloat(dataHolder.getData("rad"), 0.0f);
	float gradientCenterX = safeParseFloat(dataHolder.getData("x"), 0.0f);
	float gradientCenterY = safeParseFloat(dataHolder.getData("y"), 0.0f);
	
	int rstripec = safeParseInt(dataHolder.getData("rstrcou"), 0);
	float rgradientRadius = safeParseFloat(dataHolder.getData("rrad"), 0.0f);
	float rgradientCenterX = safeParseFloat(dataHolder.getData("rx"), 0.0f);
	float rgradientCenterY = safeParseFloat(dataHolder.getData("ry"), 0.0f);
	
	int bstripec = safeParseInt(dataHolder.getData("bstrcou"), 0);
	float bgradientRadius = safeParseFloat(dataHolder.getData("brad"), 0.0f);
	float bgradientCenterX = safeParseFloat(dataHolder.getData("bx"), 0.0f);
	float bgradientCenterY = safeParseFloat(dataHolder.getData("by"), 0.0f);
	int tm = safeParseInt(dataHolder.getData("tm"), 0);
	int rtm = safeParseInt(dataHolder.getData("rtm"), 0);
	int btm = safeParseInt(dataHolder.getData("btm"), 0);
	
	
	int stripeCount;
	int[] colors;
	
	void stripe(int[] colorArray, int r) {
		int sharp = (r == 2 ? btm : r == 1 ? rtm : tm);
		int stri = r == 2 ? bstripec : r == 1 ? rstripec : stripec;
		stripeCount = (stri >= 2) ? stri : 2; // Кількість смуг
		if(sharp != 0){
			colors = new int[stripeCount * sharp];
			for (int i = 0; i < stripeCount * sharp; i++) {
				colors[i] = colorArray[i / sharp % colorArray.length]; // Використовуємо кольори з масиву
			}
		}else{
			colors = new int[stri];
			for (int i = 0; i < stri; i++) {
				Random rnd = new Random();
				colors[i] = colorArray[rnd.nextInt(colorArray.length)]; // Використовуємо кольори з масиву
			}
		}
	}
	
	public void setBG(View v, int r, boolean s) {
        try{
        int[] colorArray = r == 2 ? bg : r == 1 ? rcolor1 : color1;
        if(dataHolder.getData("batsav").equals("0")){
		int g = r == 2 ? bgrad : r == 1 ? rgrad : grad;
		float gradientX = r == 2 ? bgradientCenterX : r == 1 ? rgradientCenterX : gradientCenterX;
		float gradientY = r == 2 ? bgradientCenterY : r == 1 ? rgradientCenterY : gradientCenterY;
		float gradientR = r == 2 ? bgradientRadius : r == 1 ? rgradientRadius : gradientRadius;
		
		stripe(colorArray, r);
		Drawable drawable;
		
		switch (g) {
			case 0:
			case 1:
			case 2:
			case 3: {
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
				}
				drawable = new GradientDrawable(orientation, colors);
				break;
			}
			case 4: {
				GradientDrawable radialDrawable = new GradientDrawable();
				radialDrawable.setShape(GradientDrawable.RECTANGLE);
				radialDrawable.setGradientType(GradientDrawable.RADIAL_GRADIENT);
				radialDrawable.setColors(colors);
				radialDrawable.setGradientCenter(gradientX, gradientY);
				try {
					radialDrawable.setGradientRadius(gradientR * Resources.getSystem().getDisplayMetrics().density * 100);
				} catch (Exception e) {
					radialDrawable.setGradientRadius(400 * gradientR);
				}
				drawable = radialDrawable;
				break;
			}
			case 5: {
				GradientDrawable sweepDrawable = new GradientDrawable();
				sweepDrawable.setShape(GradientDrawable.RECTANGLE);
				sweepDrawable.setGradientType(GradientDrawable.SWEEP_GRADIENT);
				sweepDrawable.setColors(colors);
				sweepDrawable.setGradientCenter(gradientX, gradientY);
				drawable = sweepDrawable;
				break;
			}
			case 6: case 7: {
				int size = (int)((gradientX + 2.2) * 20d);
				size = size > 0 ? size : 1;
				int width = 500;
				int height = r == 2 ? 500 : 200;
				Bitmap bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
				Canvas canvas2 = new Canvas(bitmap2);
				if(r==2)canvas2.drawARGB(255, 0, 0, 0);
				Paint paint2 = new Paint();
				paint2.setAntiAlias(true);
				paint2.setFilterBitmap(true);
				paint2.setDither(true);
				paint2.setFlags(0);
				float cornerRadius = (gradientY + 2f) * 10f * Resources.getSystem().getDisplayMetrics().density;
				RectF rect = new RectF();
				int colorIndex = 0;
				for (int y = 0; y < height; y += size) {
					for (int x = 0; x < width; x += size) {
						colorIndex = g == 6 ? ((x / size) + (y / size)) : colorIndex + 1;
						paint2.setColor(colors[colorIndex%colors.length]);
						rect.set(x, y, x + size, y + size);
						canvas2.drawRoundRect(rect, cornerRadius, cornerRadius, paint2);
					}
				}
				drawable = new BitmapDrawable(v.getResources(), bitmap2);
				drawable.setFilterBitmap(true);
				drawable.setDither(true);
				break;
			}
			case 8: {
				int size = (int)((gradientX + 2.2) * 20d);
				size = size > 0 ? size : 1;
				int width = 500;
				int height = r == 2 ? 500 : 200;
				Bitmap bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
				Canvas canvas2 = new Canvas(bitmap2);
				if(r==2)canvas2.drawARGB(255, 0, 0, 0);  // Фон чорний, щоб перекривати прозорість
				Paint paint2 = new Paint();
				paint2.setAntiAlias(true);
				paint2.setFilterBitmap(true);
				paint2.setDither(true);
				paint2.setFlags(0);
				
				//float cornerRadius = (gradientY + 2f) * 10f * Resources.getSystem().getDisplayMetrics().density;
				//RectF rect = new RectF();
				
				int colorIndex = 0;
				for (int y = 0; y < height; y += size) {
					for (int x = -size/2; x < width; x += size/2) {
						// Оновлюємо логіку для розрахунку колірного індексу
						colorIndex++;
						paint2.setColor(colors[colorIndex % colors.length]);
						
						// Малюємо трикутник
						Path path = new Path();
						if(colorIndex%2==0){
							path.moveTo(x, y);  // Вершина трикутника
							path.lineTo(x + size, y);  // Лінія до верхнього правого кута
							path.lineTo(x + size / 2, y + size);  // Лінія до нижнього центру
						}else{
							path.moveTo(x, y + size);  // Вершина трикутника
							path.lineTo(x + size, y + size);  // Лінія до верхнього правого кута
							path.lineTo(x + size / 2, y);  // Лінія до нижнього центру
						}
						path.close();  // Закриваємо трикутник    
						canvas2.drawPath(path, paint2);
					}
				}
				
				drawable = new BitmapDrawable(v.getResources(), bitmap2);
				drawable.setFilterBitmap(true);
				drawable.setDither(true);
				break;
			}
			
			case 9: {
				int size = (int)((gradientX + 2.2) * 20d);
				size = size > 0 ? size : 1;
				int width = 500;
				int height = r == 2 ? 500 : 200;
				Bitmap bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
				Canvas canvas2 = new Canvas(bitmap2);
				if(r==2)canvas2.drawARGB(255, 0, 0, 0);  // Фон чорний, щоб перекривати прозорість
				Paint paint2 = new Paint();
				paint2.setAntiAlias(true);
				paint2.setFilterBitmap(true);
				paint2.setDither(true);
				paint2.setFlags(0);
				
				//float cornerRadius = (gradientY + 2f) * 10f * Resources.getSystem().getDisplayMetrics().density;
				//RectF rect = new RectF();
				int f=0;
				int ff=0;
				int colorIndex = 0;
				for (int y = 0; y < height; y += size) {
					ff=0;
					for (int x = -size/2; x < width; x += size/2) {
						// Оновлюємо логіку для розрахунку колірного індексу
						colorIndex++;
						paint2.setColor(colors[colorIndex % colors.length]);
						f=ff/2*size;
						// Малюємо прямокутний трикутник
						Path path = new Path();
						if(ff%2==0){
							path.moveTo(f, y);  // Вершина трикутника
							path.lineTo(f + size, y);  // Лінія до верхнього правого кута
							path.lineTo(f + size, y + size);  // Лінія до нижнього центру
						}else{
							path.moveTo(f, y + size);  // Вершина трикутника
							path.lineTo(f + size, y + size);  // Лінія до верхнього правого кута
							path.lineTo(f, y);  // Лінія до нижнього центру
						}
						path.close();  // Закриваємо трикутник    
						canvas2.drawPath(path, paint2);
						ff++;
					}
				}
				
				drawable = new BitmapDrawable(v.getResources(), bitmap2);
				drawable.setFilterBitmap(true);
				drawable.setDither(true);
				break;
			}
			
			case 10: {
				int size = (int)((gradientX + 2.2) * 20d);
				size = size > 0 ? size : 1;
				int width = 500;
				int height = r == 2 ? 500 : 200;
				Bitmap bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
				Canvas canvas2 = new Canvas(bitmap2);
				if(r==2)canvas2.drawARGB(255, 0, 0, 0);  // Фон чорний, щоб перекривати прозорість
				Paint paint2 = new Paint();
				paint2.setAntiAlias(true);
				paint2.setFilterBitmap(true);
				paint2.setDither(true);
				paint2.setFlags(0);
				
				//float cornerRadius = (gradientY + 2f) * 10f * Resources.getSystem().getDisplayMetrics().density;
				//RectF rect = new RectF();
				int f = 0;
				int colorIndex = 0;
				for (int y = -size/2; y < height; y += size/2) {
					f++;
					for (int x = f%2==0?(int)(-size*.75):0; x < width; x += size*1.5) {
						// Оновлюємо логіку для розрахунку колірного індексу
						colorIndex+=2;
						paint2.setColor(colors[(colorIndex+f%2) % colors.length]);
						
						// Малюємо шестикутник
						Path path = new Path();
						
						path.moveTo(x, y+size/2);  // Лівий кут шестикутника
						path.lineTo(x+size/4, y+size);  // Лінія до верхнього лівого кута
						path.lineTo(x+(int)(size*.75), y + size);  // Лінія до верхнього правого кута
						path.lineTo(x+size, y + size/2);  // Лінія до правого кута
						path.lineTo(x+(int)(size*.75), y);  // Лінія до нижнього правого кута
						path.lineTo(x+size/4, y);  // Лінія до нижнього лівого кута
						path.close();  // Закриваємо шестикутник   
						canvas2.drawPath(path, paint2);
					}
				}
				
				drawable = new BitmapDrawable(v.getResources(), bitmap2);
				drawable.setFilterBitmap(true);
				drawable.setDither(true);
				break;
			}
			
			case 11: {
				int size = (int)((gradientX + 2.2) * 20d);
				size = size > 0 ? size : 1;
				int width = 500;
				int height = r == 2 ? 500 : 200;
				Bitmap bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
				Canvas canvas2 = new Canvas(bitmap2);
				if(r==2)canvas2.drawARGB(255, 0, 0, 0);  // Фон чорний, щоб перекривати прозорість
				Paint paint2 = new Paint();
				paint2.setAntiAlias(true);
				paint2.setFilterBitmap(true);
				paint2.setDither(true);
				paint2.setFlags(0);
				
				//float cornerRadius = (gradientY + 2f) * 10f * Resources.getSystem().getDisplayMetrics().density;
				//RectF rect = new RectF();
				
				int colorIndex = 0;
				for (int y = 0; y < height; y += size) {
					for (int x = -size/2; x < width; x += size) {
						// Оновлюємо логіку для розрахунку колірного індексу
						colorIndex++;
						paint2.setColor(colors[colorIndex % colors.length]);
						
						// Не баг, а фіча
						Path path = new Path();
						
						path.moveTo(x, y/2*size);  // Лівий кут шестикутника
						path.lineTo(x/4*size + size, y+size);  // Лінія до верхнього лівого кута
						path.lineTo(x/4*3, y + size);  // Лінія до верхнього правого кута
						path.lineTo(x, y + size/2);  // Лінія до правого кута
						path.lineTo(x/4*3, y);  // Лінія до нижнього лівого кута
						path.close();  // Закриваємо трикутник    
						canvas2.drawPath(path, paint2);
					}
				}
				
				drawable = new BitmapDrawable(v.getResources(), bitmap2);
				drawable.setFilterBitmap(true);
				drawable.setDither(true);
				break;
			}
			
			case 12: {
				int size = (int)((gradientX + 2.5) * 100d);
				int den = (int)(((gradientY + 2.5)/4.)*size);
				size = size > 0 ? size : 1;
				int width = 500;
				int height = r == 2 ? 500 : 200;
				Bitmap bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
				Canvas canvas2 = new Canvas(bitmap2);
				if(r==2)canvas2.drawARGB(255, 0, 0, 0);  // Фон чорний, щоб перекривати прозорість
				Paint paint2 = new Paint();
				paint2.setAntiAlias(true);
				paint2.setFilterBitmap(true);
				paint2.setDither(true);
				paint2.setFlags(0);
				Random rnd = new Random();
				//float cornerRadius = (gradientY + 2f) * 10f * Resources.getSystem().getDisplayMetrics().density;
				//RectF rect = new RectF();
				
				int colorIndex = 0;
				for (int y = 0; y < height; y += den) {
					for (int x = -size/2; x < width; x += den) {
						// Оновлюємо логіку для розрахунку колірного індексу
						colorIndex++;
						paint2.setColor(colors[colorIndex % colors.length]);
						
						// Малюємо лютий рандом від 3 до N кутів
						Path path = new Path();
                        int w = (int)(gradientR*10.);
						int rr = 3 + ((w>0)?rnd.nextInt(w):0);
						path.moveTo(x-size/2+rnd.nextInt(size), y-size/2+rnd.nextInt(size));  // Починаємо
						for(int i=0; i<rr; i++){
							path.lineTo(x-size/2+rnd.nextInt(size), y-size/2+rnd.nextInt(size));  // Продовжуємо
						}
						path.close();  // Закриваємо трикутник    
						canvas2.drawPath(path, paint2);
					}
				}
				
				drawable = new BitmapDrawable(v.getResources(), bitmap2);
				drawable.setFilterBitmap(true);
				drawable.setDither(true);
				break;
			}
			
			default: {
				drawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colorArray);
				break;
			}
		}
		if (drawable instanceof GradientDrawable) {
			GradientDrawable gradientDrawable = (GradientDrawable) drawable;
			float cornerRadius = (r == 2 ? 0 : (r == 1 ? (s ? rsroundness : rroundness) : (s ? sroundness : roundness)))
			* Resources.getSystem().getDisplayMetrics().density;
			gradientDrawable.setCornerRadius(cornerRadius);
			v.setBackground(drawable);
		} else {
			BitmapDrawable ddrawable = (BitmapDrawable) drawable;
			ddrawable.setTargetDensity(1);
			v.setBackground(ddrawable);
		}
		v.invalidate();
        }else{
            v.setBackgroundColor(avgcol(colorArray));
            }
       }catch(Exception e){}	
	}
	
	
	public void colorToRam(Context context){
		final SharedPreferences sf = context.getSharedPreferences("sf", Context.MODE_PRIVATE);
		switch(sf.getString("theme", "")) {
			case "0": {
				if (WTF.SDK_INT() >= 31) {
					
					dataHolder.setData("bg", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_10)).toUpperCase());
					dataHolder.setData("bbg", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("rbg", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("t", Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase());
					dataHolder.setData("tf", Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase());
					dataHolder.setData("add", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("h", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent2_600)).toUpperCase());
					dataHolder.setData("cb", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("tpc", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("tc", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("bt", "ffffffff");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("tm", "1");
					dataHolder.setData("rtm", "1");
					dataHolder.setData("btm", "1");
					
				}else{
					dataHolder.setData("bg", "ffffffff");
					dataHolder.setData("bbg", "ff018577");
					dataHolder.setData("rbg", "fff44336");
					dataHolder.setData("t", "ff000000");
					dataHolder.setData("tf", "ff000000");
					dataHolder.setData("add", "ff018577");
					dataHolder.setData("h", "ff888888");
					dataHolder.setData("bt", "ffffffff");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", "ff018577");
					dataHolder.setData("tpc", "ff018577");
					dataHolder.setData("tc", "ff018577");
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("tm", "1");
					dataHolder.setData("rtm", "1");
					dataHolder.setData("btm", "1");
					
				}
				break;
			}
			case "1": {
				if (WTF.SDK_INT() >= 31) {
					
					dataHolder.setData("bg", Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_900)).toUpperCase());
					dataHolder.setData("bbg", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("rbg", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("t", Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase());
					dataHolder.setData("tf", Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase());
					dataHolder.setData("add", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("h", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent2_200)).toUpperCase());
					dataHolder.setData("bt", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_800)).toUpperCase());
					dataHolder.setData("rbt", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_800)).toUpperCase());
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("tpc", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("tc", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("tm", "1");
					dataHolder.setData("rtm", "1");
					dataHolder.setData("btm", "1");
					
					
				}else{
					dataHolder.setData("bg", "ff303030");
					dataHolder.setData("bbg", "ff80cbc4");
					dataHolder.setData("rbg", "fff44336");
					dataHolder.setData("t", "ffffffff");
					dataHolder.setData("tf", "ffffffff");
					dataHolder.setData("add", "ff80cbc4");
					dataHolder.setData("h", "ff888888");
					dataHolder.setData("bt", "ff000000");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", "ff80cbc4");
					dataHolder.setData("tpc", "ff80cbc4");
					dataHolder.setData("tc", "ff80cbc4");
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("tm", "1");
					dataHolder.setData("rtm", "1");
					dataHolder.setData("btm", "1");
					
				}
				break;
			}
			case "2": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ff00ffff");
				dataHolder.setData("rbg", "ffff0000");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff00ffff");
				dataHolder.setData("h", "ffffff00");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ffffff00");
				dataHolder.setData("tpc", "ff00ff00");
				dataHolder.setData("tc", "ff00ffff");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				break;
			}
			case "4": {
				if (WTF.SDK_INT() >= 31) {
					
					dataHolder.setData("bg", "ffffffff");
					dataHolder.setData("bbg", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("rbg", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("t", Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase());
					dataHolder.setData("tf", Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase());
					dataHolder.setData("add", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("h", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent2_600)).toUpperCase());
					dataHolder.setData("bt", "ffffffff");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("tpc", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("tc", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("tm", "1");
					dataHolder.setData("rtm", "1");
					dataHolder.setData("btm", "1");
					
					dataHolder.setData("tmy", "2");
					dataHolder.setData("rtmy", "2");
					dataHolder.setData("btmy", "2");
					
				}else{
					dataHolder.setData("bg", "ffffffff");
					dataHolder.setData("bbg", "ff018577");
					dataHolder.setData("rbg", "fff44336");
					dataHolder.setData("t", "ff000000");
					dataHolder.setData("tf", "ff000000");
					dataHolder.setData("add", "ff018577");
					dataHolder.setData("h", "ff888888");
					dataHolder.setData("bt", "ffffffff");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", "ff018577");
					dataHolder.setData("tpc", "ff018577");
					dataHolder.setData("tc", "ff018577");
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("tm", "1");
					dataHolder.setData("rtm", "1");
					dataHolder.setData("btm", "1");
					
					dataHolder.setData("tmy", "2");
					dataHolder.setData("rtmy", "2");
					dataHolder.setData("btmy", "2");
					
					
				}
				break;
			}
			case "5": {
				if (WTF.SDK_INT() >= 31) {
					
					dataHolder.setData("bg", "ff000000");
					dataHolder.setData("bbg", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("rbg", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("t", Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase());
					dataHolder.setData("tf", Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase());
					dataHolder.setData("add", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("h", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent2_200)).toUpperCase());
					dataHolder.setData("bt", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_800)).toUpperCase());
					dataHolder.setData("rbt", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_800)).toUpperCase());
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("tpc", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("tc", Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("tm", "1");
					dataHolder.setData("rtm", "1");
					dataHolder.setData("btm", "1");
					
					
				}else{
					dataHolder.setData("bg", "ff000000");
					dataHolder.setData("bbg", "ff80cbc4");
					dataHolder.setData("rbg", "fff44336");
					dataHolder.setData("t", "ffffffff");
					dataHolder.setData("tf", "ffffffff");
					dataHolder.setData("add", "ff80cbc4");
					dataHolder.setData("h", "ff888888");
					dataHolder.setData("bt", "ff000000");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", "ff80cbc4");
					dataHolder.setData("tpc", "ff80cbc4");
					dataHolder.setData("tc", "ff80cbc4");
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("tm", "1");
					dataHolder.setData("rtm", "1");
					dataHolder.setData("btm", "1");
					
				}
				break;
			}
			case "6": {
				dataHolder.setData("bg", "ffffffff");
				dataHolder.setData("bbg", "ff33b5e5");
				dataHolder.setData("rbg", "ffb71c1c");
				dataHolder.setData("t", "ff000000");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff35b5e5");
				dataHolder.setData("h", "ff757575");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ff33b5e5");
				dataHolder.setData("tpc", "ff33b5e5");
				dataHolder.setData("tc", "ff33b5e5");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				
				break;
			}
			case "7": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ff33b5e5");
				dataHolder.setData("rbg", "ffb71c1c");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ffffffff");
				dataHolder.setData("add", "ff35b5e5");
				dataHolder.setData("h", "ffbdbdbd");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ff33b5e5");
				dataHolder.setData("tpc", "ff33b5e5");
				dataHolder.setData("tc", "ff33b5e5");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				
				break;
			}
			case "8": {
				dataHolder.setData("bg", "ffffffff");
				dataHolder.setData("bbg", "ff018577");
				dataHolder.setData("rbg", "fff44336");
				dataHolder.setData("t", "ff000000");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff018577");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ffffffff");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "12");
				dataHolder.setData("cb", "ff018577");
				dataHolder.setData("tpc", "ff018577");
				dataHolder.setData("tc", "ff018577");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "4");
				dataHolder.setData("srou", "6");
				dataHolder.setData("rsrou", "2");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				break;
			}
			case "9": {
				dataHolder.setData("bg", "ff303030");
				dataHolder.setData("bbg", "ff80cbc4");
				dataHolder.setData("rbg", "fff44336");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ffffffff");
				dataHolder.setData("add", "ff80cbc4");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "12");
				dataHolder.setData("cb", "ff80cbc4");
				dataHolder.setData("tpc", "ff80cbc4");
				dataHolder.setData("tc", "ff80cbc4");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "4");
				dataHolder.setData("srou", "6");
				dataHolder.setData("rsrou", "2");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				break;
			}
			case "10": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ff80cbc4");
				dataHolder.setData("rbg", "fff44336");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ffffffff");
				dataHolder.setData("add", "ff80cbc4");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "12");
				dataHolder.setData("cb", "ff80cbc4");
				dataHolder.setData("tpc", "ff80cbc4");
				dataHolder.setData("tc", "ff80cbc4");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "4");
				dataHolder.setData("srou", "6");
				dataHolder.setData("rsrou", "2");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				break;
			}
			case "11": {
				dataHolder.setData("bg", "ffffffff");
				dataHolder.setData("bbg", "ffeaeaeaffb8b8b8");
				dataHolder.setData("rbg", "ffeaeaeaffb8b8b8");
				dataHolder.setData("t", "ff000000");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff68B200");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffff0000");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ff68B200");
				dataHolder.setData("tpc", "ffffbb00");
				dataHolder.setData("tc", "ff9b9b9b");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				break;
			}
			case "12": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ffeaeaeaffb8b8b8");
				dataHolder.setData("rbg", "ffeaeaeaffb8b8b8");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff90ff22");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffff0000");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ff90ff22");
				dataHolder.setData("tpc", "ffffbb00");
				dataHolder.setData("tc", "ff9b9b9b");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				break;
			}
            
            case "13": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ffffff00");
				dataHolder.setData("rbg", "ffff0000");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff00ffff");
				dataHolder.setData("h", "ff00ff00");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ffffff00");
				dataHolder.setData("tpc", "ffffff00");
				dataHolder.setData("tc", "ffffff00");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				break;
			}
            
            case "14": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ff00ff00");
				dataHolder.setData("rbg", "ffff0000");
				dataHolder.setData("t", "ff00ff00");
				dataHolder.setData("tf", "ff00ffff");
				dataHolder.setData("add", "ffffff00");
				dataHolder.setData("h", "ffff00ff");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffff00");
				dataHolder.setData("rou", "6");
				dataHolder.setData("cb", "ff00ffff");
				dataHolder.setData("tpc", "ff00ffff");
				dataHolder.setData("tc", "ff00ff00");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "4");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				break;
			}
            
            case "15": {
				dataHolder.setData("bg", "ffffffff");
				dataHolder.setData("bbg", "ff000000");
				dataHolder.setData("rbg", "ff0000ff");
				dataHolder.setData("t", "ff000000");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff0000ff");
				dataHolder.setData("h", "ff880088");
				dataHolder.setData("bt", "ffffffff");
				dataHolder.setData("rbt", "ff00ffff");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ff000000");
				dataHolder.setData("tpc", "ff000000");
				dataHolder.setData("tc", "ff0000ff");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				break;
			}
            
            case "16": {
				dataHolder.setData("bg", "ff000000ff330000");
				dataHolder.setData("bbg", "ff770000ff000000");
				dataHolder.setData("rbg", "ffff0000ffff7777");
				dataHolder.setData("t", "ffffdddd");
				dataHolder.setData("tf", "ffffbbbb");
				dataHolder.setData("add", "ffff7777");
				dataHolder.setData("h", "ffff0000");
				dataHolder.setData("bt", "ffff7777");
				dataHolder.setData("rbt", "ff550000");
				dataHolder.setData("rou", "15");
				dataHolder.setData("cb", "ffff0000");
				dataHolder.setData("tpc", "ffff0000");
				dataHolder.setData("tc", "ffff0000");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "5");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "5");
				
				dataHolder.setData("rrou", "8");
				dataHolder.setData("srou", "8");
				dataHolder.setData("rsrou", "4");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				break;
			}
            
            case "17": {
				dataHolder.setData("bg", "ffffbbbbffffdddd");
				dataHolder.setData("bbg", "ff770000ffbb0000");
				dataHolder.setData("rbg", "ff000000ffff7777");
				dataHolder.setData("t", "ff330000");
				dataHolder.setData("tf", "ff770000");
				dataHolder.setData("add", "ffff0000");
				dataHolder.setData("h", "ffff5555");
				dataHolder.setData("bt", "ffffbbbb");
				dataHolder.setData("rbt", "ff550000");
				dataHolder.setData("rou", "15");
				dataHolder.setData("cb", "ff770000");
				dataHolder.setData("tpc", "ff770000");
				dataHolder.setData("tc", "ff770000");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "5");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "5");
				
				dataHolder.setData("rrou", "8");
				dataHolder.setData("srou", "8");
				dataHolder.setData("rsrou", "4");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				break;
			}
            
            case "18": {
				dataHolder.setData("bg", "ff000000ff331c00");
				dataHolder.setData("bbg", "ffff8700ffce5d00");
				dataHolder.setData("rbg", "ffbb0000ffff0000");
				dataHolder.setData("t", "ffffdead");
				dataHolder.setData("tf", "ffffbf7f");
				dataHolder.setData("add", "ffff8400");
				dataHolder.setData("h", "ff885500");
				dataHolder.setData("bt", "ffffffff");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "10");
				dataHolder.setData("cb", "ffff7a00");
				dataHolder.setData("tpc", "ffff7b00");
				dataHolder.setData("tc", "ffffb100");
				dataHolder.setData("grad", "2");
				dataHolder.setData("rgrad", "1");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "5");
				dataHolder.setData("srou", "5");
				dataHolder.setData("rsrou", "2");
				
				dataHolder.setData("tm", "2");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				break;
			}
            
            case "19": {
				dataHolder.setData("bg", "ff000000ff181400");
				dataHolder.setData("bbg", "ff00ffffff00bbbb");
				dataHolder.setData("rbg", "ffa10000ff770000");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ffffffbb");
				dataHolder.setData("add", "ffffff00");
				dataHolder.setData("h", "ff999900");
				dataHolder.setData("bt", "ff003333");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ffff7a00");
				dataHolder.setData("tpc", "ffff7b00");
				dataHolder.setData("tc", "ffffb100");
				dataHolder.setData("grad", "8");
				dataHolder.setData("rgrad", "8");
				dataHolder.setData("bgrad", "6");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "3.0");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "3.0");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "1.0");
				dataHolder.setData("by", "-2.0");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				break;
			}
            
            case "20": {
				dataHolder.setData("bg", "ff322500");
				dataHolder.setData("bbg", "ffffff00");
				dataHolder.setData("rbg", "ffff7700");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ffffffff");
				dataHolder.setData("add", "ffff8000");
				dataHolder.setData("h", "ffbd5e00");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "20");
				dataHolder.setData("cb", "ffff7a00");
				dataHolder.setData("tpc", "ffff7b00");
				dataHolder.setData("tc", "ffffb100");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "20");
				dataHolder.setData("srou", "10");
				dataHolder.setData("rsrou", "10");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				break;
			}
            
            case "21": {
				dataHolder.setData("bg", "ff003300");
				dataHolder.setData("bbg", "ff000000");
				dataHolder.setData("rbg", "ff330000");
				dataHolder.setData("t", "ff00ff00");
				dataHolder.setData("tf", "ff00ff00");
				dataHolder.setData("add", "ff00ffff");
				dataHolder.setData("h", "ff00bb00");
				dataHolder.setData("bt", "ff00ff00");
				dataHolder.setData("rbt", "ffff0000");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ff00ff00");
				dataHolder.setData("tpc", "ff00ffff");
				dataHolder.setData("tc", "ff00ff00");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				break;
			}
            
            case "22": {
				dataHolder.setData("bg", "ffffffbb");
				dataHolder.setData("bbg", "ffffff00");
				dataHolder.setData("rbg", "ffb8ff77");
				dataHolder.setData("t", "ff000000");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff777700");
				dataHolder.setData("h", "ffbbbb00");
				dataHolder.setData("bt", "ff555500");
				dataHolder.setData("rbt", "ff2e5500");
				dataHolder.setData("rou", "20");
				dataHolder.setData("cb", "ff777700");
				dataHolder.setData("tpc", "ff777700");
				dataHolder.setData("tc", "ff777700");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "20");
				dataHolder.setData("srou", "10");
				dataHolder.setData("rsrou", "10");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				break;
			}
            
            case "23": {
				dataHolder.setData("bg", "ff003300ff000000");
				dataHolder.setData("bbg", "ff005300ff00ff00");
				dataHolder.setData("rbg", "ff000000ffff7300");
				dataHolder.setData("t", "ffddffdd");
				dataHolder.setData("tf", "ffbbff99");
				dataHolder.setData("add", "ff00ff00");
				dataHolder.setData("h", "ff009900");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffff00");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ff00ff00");
				dataHolder.setData("tpc", "ff00ff00");
				dataHolder.setData("tc", "ff00ff00");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "1");
				dataHolder.setData("rtm", "1");
				dataHolder.setData("btm", "1");
				
				break;
			}
            
			case "3": {
				
				// Призначення кольорів
				if (isAndroid12OrHigher) {
					dataHolder.setData("bg", processColor(sf.getString("bg", ""), true, true, context));
					dataHolder.setData("bbg", processColor(sf.getString("bbg", ""), true, true, context));
					dataHolder.setData("rbg", processColor(sf.getString("rbg", ""), true, true, context));
					dataHolder.setData("t", processColor(sf.getString("t", ""), false, true, context));
					dataHolder.setData("tf", processColor(sf.getString("tf", ""), false, true, context));
					dataHolder.setData("add", processColor(sf.getString("add", ""), false, true, context));
					dataHolder.setData("h", processColor(sf.getString("h", ""), false, true, context));
					dataHolder.setData("bt", processColor(sf.getString("bt", ""), false, true, context));
					dataHolder.setData("rbt", processColor(sf.getString("rbt", ""), false, true, context));
					dataHolder.setData("cb", processColor(sf.getString("cb", ""), false, true, context));
					dataHolder.setData("tpc", processColor(sf.getString("tpc", ""), false, true, context));
					dataHolder.setData("tc", processColor(sf.getString("tc", ""), false, true, context));
				} else {
					// Стандартні кольори для версій нижче Android 12 з урахуванням відтінку
					dataHolder.setData("bg", processColor(sf.getString("bg", ""), true, false, context));
					dataHolder.setData("bbg", processColor(sf.getString("bbg", ""), true, false, context));
					dataHolder.setData("rbg", processColor(sf.getString("rbg", ""), true, false, context));
					dataHolder.setData("t", processColor(sf.getString("t", ""), false, false, context));
					dataHolder.setData("tf", processColor(sf.getString("tf", ""), false, false, context));
					dataHolder.setData("add", processColor(sf.getString("add", ""), false, false, context));
					dataHolder.setData("h", processColor(sf.getString("h", ""), false, false, context));
					dataHolder.setData("bt", processColor(sf.getString("bt", ""), false, false, context));
					dataHolder.setData("rbt", processColor(sf.getString("rbt", ""), false, false, context));
					dataHolder.setData("cb", processColor(sf.getString("cb", ""), false, false, context));
					dataHolder.setData("tpc", processColor(sf.getString("tpc", ""), false, false, context));
					dataHolder.setData("tc", processColor(sf.getString("tc", ""), false, false, context));
				}
				
				// Інші дані
				dataHolder.setData("rou", sf.getString("rou", ""));
				dataHolder.setData("grad", sf.getString("grad", ""));
				dataHolder.setData("rgrad", sf.getString("rgrad", ""));
				dataHolder.setData("bgrad", sf.getString("bgrad", ""));
				
				dataHolder.setData("rad", sf.getString("rad", ""));
				dataHolder.setData("x", sf.getString("x", ""));
				dataHolder.setData("y", sf.getString("y", ""));
				dataHolder.setData("strcou", sf.getString("strcou", ""));
				
				dataHolder.setData("rrad", sf.getString("rrad", ""));
				dataHolder.setData("rx", sf.getString("rx", ""));
				dataHolder.setData("ry", sf.getString("ry", ""));
				dataHolder.setData("rstrcou", sf.getString("rstrcou", ""));
				
				dataHolder.setData("brad", sf.getString("brad", ""));
				dataHolder.setData("bx", sf.getString("bx", ""));
				dataHolder.setData("by", sf.getString("by", ""));
				dataHolder.setData("bstrcou", sf.getString("bstrcou", ""));
				
				dataHolder.setData("rrou", sf.getString("rrou", ""));
				dataHolder.setData("srou", sf.getString("srou", ""));
				dataHolder.setData("rsrou", sf.getString("rsrou", ""));
				
				dataHolder.setData("tm", sf.getString("tm", ""));
				dataHolder.setData("rtm", sf.getString("rtm", ""));
				dataHolder.setData("btm", sf.getString("btm", ""));
				
				break;
			}
		}
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
        
        boolean saver = BatterySaverChecker.isBatterySaverOn(context);
if (saver) {
    dataHolder.setData("batsav", "1");
} else {
    dataHolder.setData("batsav", sf.getString("batsav", "0"));
}

	}
	
	// Метод для перевірки і заміни кольорів
	String processColor(String color, boolean isMultiColor, boolean isAndroid12OrHigher, Context context) {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < color.length(); i += 8) {
			String part = color.substring(i, i + 8);
			
			if (part.startsWith("m__")) {
				if (isAndroid12OrHigher) {
					// Використання методу для парсингу Monet кольору
					result.append(selcol(part.substring(3), context));
				} else {
					// Парсинг відтінку на старіших версіях Android
					result.append(getLegacyColor(part.substring(3)));
				}
			} else {
				// Додавання кольору як є
				result.append(part);
			}
		}
		
		return result.toString();
	}
	
	String getLegacyColor(String shade) {
		switch (shade) {
			case "n1010": return "0xFFFEFAFE";
			case "n1050": return "0xFFFAFAFA";
			case "n1100": return "0xFFF5F5F5";
			case "n1200": return "0xFFEEEEEE";
			case "n1300": return "0xFFE0E0E0";
			case "n1400": return "0xFFBDBDBD";
			case "n1500": return "0xFF9E9E9E";
			case "n1600": return "0xFF757575";
			case "n1700": return "0xFF616161";
			case "n1800": return "0xFF424242";
			case "n1900": return "0xFF212121";
			
			//neutral 2
			case "n2010": return "0xFFF2F3F6";
			case "n2050": return "0xFFECEFF1";
			case "n2100": return "0xFFCFD8DC";
			case "n2200": return "0xFFB0BEC5";
			case "n2300": return "0xFF90A4AE";
			case "n2400": return "0xFF78909C";
			case "n2500": return "0xFF607D8B";
			case "n2600": return "0xFF546E7A";
			case "n2700": return "0xFF455A64";
			case "n2800": return "0xFF37474F";
			case "n2900": return "0xFF263238";
			
			//accent 1
			case "a1010": return "0xFFE9F6FB";
			case "a1050": return "0xFFE0F2F1";
			case "a1100": return "0xFFB2DFDB";
			case "a1200": return "0xFF80CBC4";
			case "a1300": return "0xFF4DB6AC";
			case "a1400": return "0xFF26A69A";
			case "a1500": return "0xFF009688";
			case "a1600": return "0xFF00897B";
			case "a1700": return "0xFF00796B";
			case "a1800": return "0xFF00695C";
			case "a1900": return "0xFF004D40";
			
			//accent 2
			case "a2010": return "0xFFF2FFFC";
			case "a2050": return "0xFFDAF7F3";
			case "a2100": return "0xFFCCE8E4";
			case "a2200": return "0xFFB0CCC8";
			case "a2300": return "0xFF96B1AD";
			case "a2400": return "0xFF7B9693";
			case "a2500": return "0xFF617B78";
			case "a2600": return "0xFF4A6360";
			case "a2700": return "0xFF324B49";
			case "a2800": return "0xFF1C3532";
			case "a2900": return "0xFF051F1D";
			
			//accent 3
			case "a3010": return "0xFFFCFCFF";
			case "a3050": return "0xFFE9F1FF";
			case "a3100": return "0xFFCFE5FF";
			case "a3200": return "0xFFAFC9E7";
			case "a3300": return "0xFF94AECB";
			case "a3400": return "0xFF7A93AF";
			case "a3500": return "0xFF607893";
			case "a3600": return "0xFF48617B";
			case "a3700": return "0xFF304962";
			case "a3800": return "0xFF18324A";
			case "a3900": return "0xFF001D34";
		}return "FFFF0000";}
	
	String selcol(String _col, Context context) {
		try {
			switch (_col) {
				case "n1010":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral1_10)).toUpperCase();
				
				case "n1050":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral1_50)).toUpperCase();
				
				case "n1100":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral1_100)).toUpperCase();
				
				case "n1200":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral1_200)).toUpperCase();
				
				case "n1300":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral1_300)).toUpperCase();
				
				case "n1400":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral1_400)).toUpperCase();
				
				case "n1500":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral1_500)).toUpperCase();
				
				case "n1600":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral1_600)).toUpperCase();
				
				case "n1700":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral1_700)).toUpperCase();
				
				case "n1800":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral1_800)).toUpperCase();
				
				case "n1900":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral1_900)).toUpperCase();
				
				case "n2010":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_10)).toUpperCase();
				
				case "n2050":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_50)).toUpperCase();
				
				case "n2100":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_100)).toUpperCase();
				
				case "n2200":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase();
				
				case "n2300":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_300)).toUpperCase();
				
				case "n2400":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_400)).toUpperCase();
				
				case "n2500":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_500)).toUpperCase();
				
				case "n2600":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_600)).toUpperCase();
				
				case "n2700":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase();
				
				case "n2800":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_800)).toUpperCase();
				
				case "n2900":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_neutral2_900)).toUpperCase();
				
				case "a1010":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_10)).toUpperCase();
				
				case "a1050":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_50)).toUpperCase();
				
				case "a1100":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_100)).toUpperCase();
				
				case "a1200":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_200)).toUpperCase();
				
				case "a1300":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_300)).toUpperCase();
				
				case "a1400":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_400)).toUpperCase();
				
				case "a1500":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_500)).toUpperCase();
				
				case "a1600":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_600)).toUpperCase();
				
				case "a1700":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_700)).toUpperCase();
				
				case "a1800":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_800)).toUpperCase();
				
				case "a1900":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent1_900)).toUpperCase();
				
				case "a2010":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent2_10)).toUpperCase();
				
				case "a2050":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent2_50)).toUpperCase();
				
				case "a2100":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent2_100)).toUpperCase();
				
				case "a2200":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent2_200)).toUpperCase();
				
				case "a2300":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent2_300)).toUpperCase();
				
				case "a2400":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent2_400)).toUpperCase();
				
				case "a2500":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent2_500)).toUpperCase();
				
				case "a2600":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent2_600)).toUpperCase();
				
				case "a2700":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent2_700)).toUpperCase();
				
				case "a2800":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent2_800)).toUpperCase();
				
				case "a2900":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent2_900)).toUpperCase();
				
				case "a3010":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_10)).toUpperCase();
				
				case "a3050":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_50)).toUpperCase();
				
				case "a3100":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_100)).toUpperCase();
				
				case "a3200":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_200)).toUpperCase();
				
				case "a3300":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_300)).toUpperCase();
				
				case "a3400":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_400)).toUpperCase();
				
				case "a3500":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_500)).toUpperCase();
				
				case "a3600":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_600)).toUpperCase();
				
				case "a3700":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_700)).toUpperCase();
				
				case "a3800":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_800)).toUpperCase();
				
				case "a3900":
				return Integer.toHexString(context.getResources().getColor(android.R.color.system_accent3_900)).toUpperCase();
				
				default:
				return "FFFFFF00";
			}
		} catch (Exception e) {
			SketchwareUtil.showMessage(context, "Monet error");
			return "FFFF0000";
		}
	}
	
	
	boolean isAndroid12OrHigher = WTF.SDK_INT() >= 31;
	
}






