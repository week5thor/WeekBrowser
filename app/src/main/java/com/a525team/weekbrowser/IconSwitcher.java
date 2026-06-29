package com.a525team.weekbrowser;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

public class IconSwitcher {
	
	// Усі alias-и, їх іконки та назви (важливо: ресурси повинні існувати)
	private static final String[] ICON_ALIASES = {
		"com.a525team.weekbrowser.AliasLogo1",
		"com.a525team.weekbrowser.AliasLogo2",
		"com.a525team.weekbrowser.AliasLogo3",
		"com.a525team.weekbrowser.AliasLogo4",
		"com.a525team.weekbrowser.AliasLogo5",
		"com.a525team.weekbrowser.AliasLogo6",
		"com.a525team.weekbrowser.AliasLogo7",
		"com.a525team.weekbrowser.AliasLogo8",
		"com.a525team.weekbrowser.AliasLogo9",
		"com.a525team.weekbrowser.AliasLogo10",
		"com.a525team.weekbrowser.AliasLogo11",
		"com.a525team.weekbrowser.AliasLogo12",
		"com.a525team.weekbrowser.AliasLogo13",
		"com.a525team.weekbrowser.AliasLogo14",
		"com.a525team.weekbrowser.AliasLogo15",
		"com.a525team.weekbrowser.AliasLogo16",
		"com.a525team.weekbrowser.AliasLogo17",
		"com.a525team.weekbrowser.AliasLogo18",
		"com.a525team.weekbrowser.AliasLogo19",
		"com.a525team.weekbrowser.MainActivity",
    	"com.a525team.weekbrowser.AliasLogo20",
        "com.a525team.weekbrowser.AliasLogo21",
        "com.a525team.weekbrowser.AliasLogo22",
        "com.a525team.weekbrowser.AliasLogo23",
	};
	
	// Відповідні іконки (тут - з mipmap або drawable, як у AndroidManifest.xml)
	private static final int[] ICON_RESOURCE_IDS = {
		R.mipmap.modern_blue,
		R.mipmap.modern_blue_2,
		R.mipmap.modern_blue_3,
		R.mipmap.sunrise,
		R.mipmap.sunset,
		R.mipmap.dark,
		R.mipmap.neon,
		R.mipmap.neon_green,
		R.mipmap.classic,
		R.mipmap.white,
		R.mipmap.black,
		R.mipmap.blackwhite,
		R.mipmap.sepia,
		R.mipmap.lime,
		R.mipmap.colorful,
		R.mipmap.energy_red,
		R.mipmap.cyber_red,
		R.mipmap.pastel,
		R.mipmap.latex,
		R.mipmap.ic_launcher,
        R.mipmap.monet_dark,
        R.mipmap.pixel,
        R.mipmap.pixel_bw,
        R.mipmap.pixel_sepia
	};
	
	private static final String PREF_NAME = "sf";
	private static final String KEY_SELECTED_INDEX = "launchicon";
	
	// Отримати bitmap'и всіх іконок
	public static List<Bitmap> getAllIconsBitmaps(Context context) {
		List<Bitmap> icons = new ArrayList<>();
		for (int resId : ICON_RESOURCE_IDS) {
			try {
				Drawable drawable = context.getResources().getDrawable(resId);
				if (drawable instanceof BitmapDrawable) {
					icons.add(((BitmapDrawable) drawable).getBitmap());
				} else {
					// Якщо це XML vector або інше — малюємо вручну в Bitmap
					Bitmap bmp = Bitmap.createBitmap(96, 96, Bitmap.Config.ARGB_8888);
					drawable.setBounds(0, 0, bmp.getWidth(), bmp.getHeight());
					drawable.draw(new android.graphics.Canvas(bmp));
					icons.add(bmp);
				}
			} catch (Exception e) {
				// Резервна порожня іконка, якщо щось пішло не так
				icons.add(Bitmap.createBitmap(96, 96, Bitmap.Config.ARGB_8888));
			}
		}
		return icons;
	}
	
	public static int[] getAllIconsID(){
		return ICON_RESOURCE_IDS;
	}
	
	// Застосувати іконку за індексом
	public static void applyIconByIndex(Context context, int index) {
		if (index < 0 || index >= ICON_ALIASES.length) return;
		
		PackageManager pm = context.getPackageManager();
		String packageName = context.getPackageName();
		
		// Вимикаємо всі alias-и
		for (String alias : ICON_ALIASES) {
			pm.setComponentEnabledSetting(
			new ComponentName(packageName, alias),
			PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
			PackageManager.DONT_KILL_APP
			);
		}
		
		// Увімкнути обраний alias
		pm.setComponentEnabledSetting(
		new ComponentName(packageName, ICON_ALIASES[index]),
		PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
		PackageManager.DONT_KILL_APP
		);
		
		// Зберігаємо вибір
		context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
		.edit()
		.putInt(KEY_SELECTED_INDEX, index)
		.apply();
	}
	
	// Отримати збережений індекс (або -1, якщо не встановлено)
	public static int getSelectedIconIndex(Context context) {
		return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
		.getInt(KEY_SELECTED_INDEX, -1);
	}
	
	public static String getName(Context context, int n){
		switch(n) {case ((int)0): {
				return context.getString(R.string.modern_blue);
			}
			case 1: {
				return context.getString(R.string.modern_blue_2);
			}
			case 2: {
				return context.getString(R.string.modern_blue_3);
			}
			case 3: {
				return context.getString(R.string.sunrise);
			}
			case 4: {
				return context.getString(R.string.sunset);
			}
			case 5: {
				return context.getString(R.string.darkic);
			}
			case 6: {
				return context.getString(R.string.neon);
			}
			case 7: {
				return context.getString(R.string.neon_green);
			}
			case 8: {
				return context.getString(R.string.classic);
			}
			case 9: {
				return context.getString(R.string.whiteic);
			}
			case 10: {
				return context.getString(R.string.blackic);
			}
			case 11: {
				return context.getString(R.string.blackwhite);
			}
			case 12: {
				return context.getString(R.string.sepia);
			}
			case 13: {
				return context.getString(R.string.lime);
			}
			case 14: {
				return context.getString(R.string.colorful);
			}
			case 15: {
				return context.getString(R.string.energy_red);
			}
			case 16: {
				return context.getString(R.string.cyber_red);
			}
			case 17: {
				return context.getString(R.string.pastel);
			}
            case 18: {
				return context.getString(R.string.latex);
			}
			case 19: {
				return context.getString(R.string.dynamic);
			}
            case 20: {
				return context.getString(R.string.dynamic_dark);
			}
            case 21: {
				return context.getString(R.string.pixel);
			}
            case 22: {
				return context.getString(R.string.pixel_bw);
			}
             default: {
				return context.getString(R.string.pixel_sepia);
			}
		}
	}
}








