package com.a525team.weekbrowser;

import android.content.Context;
import android.content.SharedPreferences;
import android.app.Activity;
import java.util.ArrayList;
import android.widget.*;
import android.view.*;

public class ThemeManager {
	private static boolean light = false;
    private static boolean a1 = false;
	
	public static boolean getLight(){
		return light;
	}
    
    public static boolean getA1(){
		return a1;
	}
	
	public static void setSpinner(Activity activity, ArrayList<String> list, Spinner spinner){
		ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, getLight()?R.layout.spinner_item_light:R.layout.spinner_item, list);
		adapter.setDropDownViewResource(getLight()?R.layout.spinner_item_light:R.layout.spinner_item);
		spinner.setAdapter(adapter);
	}
	
	public static void setAutocomp(Activity activity, ArrayList<String> list, AutoCompleteTextView autocomplete1){
		ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, getLight()?R.layout.spinner_item_light:R.layout.spinner_item, list);
		autocomplete1.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
	
	public static void applyTheme(Context context) {
        a1 = false;
        try{
        SharedPreferences sf = context.getSharedPreferences("sf", Context.MODE_PRIVATE);
		if(sf.getString("cstyle", "").equals("")){
			
			int themeValue;
			try {
				themeValue = Integer.parseInt(sf.getString("theme", ""));
			} catch (NumberFormatException e) {
				themeValue = 2; // Значення за замовчуванням, якщо виникла помилка
			}
			
			String styleValue = sf.getString("style", "1");
			int theme;
			
			switch (themeValue) {
				case 0:
				theme = android.R.style.Theme_DeviceDefault_Light_NoActionBar;
				light = true;
				break;
				case 1:
				theme = android.R.style.Theme_DeviceDefault_NoActionBar;
				light = false;
				break;
				case 2:
                a1 = true;
				theme = android.R.style.Theme_Light_NoTitleBar;
				light = true;
				break;
				case 3:
					theme = getStyleBasedTheme(styleValue);
				break;
				case 4:
				case 22:
				theme = android.R.style.Theme_DeviceDefault_Light_NoActionBar;
				light = true;
				break;
				case 5:
				case 18:
				case 19:
				case 20:
				theme = android.R.style.Theme_DeviceDefault_NoActionBar;
				light = false;
				break;
				case 6:
				case 17:
				theme = android.R.style.Theme_Holo_Light_NoActionBar;
				light = true;
				break;
				case 7:
				case 14:
				case 16:
				case 21:
				case 23:
				theme = android.R.style.Theme_Holo_NoActionBar;
				light = false;
				break;
				case 8:
				theme = android.R.style.Theme_Material_Light_NoActionBar;
				light = true;
				break;
				case 9:
				case 10:
				theme = android.R.style.Theme_Material_NoActionBar;
				light = false;
				break;
				case 11:
				case 12:
				case 13:
				case 15:
				theme = android.R.style.Theme_Black_NoTitleBar;
				light = false;
                a1 = true;
				break;
				default:
				theme = android.R.style.Theme_Black_NoTitleBar;
				light = false;
                a1 = true;
				break;
			}
			
            if(WTF.SDK_INT() < 21){
                switch(theme){
                    case android.R.style.Theme_Material_Light_NoActionBar:
                    theme = android.R.style.Theme_DeviceDefault_Light_NoActionBar;
                    break;
                    case android.R.style.Theme_Material_NoActionBar:
                    theme = android.R.style.Theme_DeviceDefault_NoActionBar;
                    }
                }
			context.setTheme(theme);
		}else{
            if(sf.getString("cstyle", "").equals(""))
			context.setTheme(android.R.style.Theme_Black_NoTitleBar);
            else
            context.setTheme(Integer.parseInt(sf.getString("cstyle", "")));
		}
        }catch(Exception e){
            context.setTheme(android.R.style.Theme_Black_NoTitleBar);
            }
	}
	
	private static int getStyleBasedTheme(String styleValue) {
		switch (styleValue) {
			case "1":
			light = false;
            a1 = true;
			return android.R.style.Theme_Black_NoTitleBar;
			case "2":
			light = true;
            a1 = true;
			return android.R.style.Theme_Light_NoTitleBar;
			case "3":
			light = false;
			return android.R.style.Theme_Holo_NoActionBar;
			case "4":
			light = true;
			return android.R.style.Theme_Holo_Light_NoActionBar;
			case "5":
			light = false;
			return android.R.style.Theme_Material_NoActionBar;
			case "6":
			light = true;
			return android.R.style.Theme_Material_Light_NoActionBar;
			case "7":
			light = false;
			return android.R.style.Theme_DeviceDefault_NoActionBar;
			case "8":
			light = true;
			return android.R.style.Theme_DeviceDefault_Light_NoActionBar;
			default:
			return android.R.style.Theme_Light_NoTitleBar;
		}
	}
}







