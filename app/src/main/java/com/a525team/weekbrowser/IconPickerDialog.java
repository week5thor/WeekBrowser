package com.a525team.weekbrowser;

import android.app.Dialog;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class IconPickerDialog {
	
	// Масив символів з Font Awesome
	private static final String[] DEFAULT_ICONS = {
		"", "", "", "", "", "", "", "", "", "", 
		"", "", "", "", "", "", "", "", "", "", 
		"", "", "", "", "", "", "", "", "", "", 
		"", "", "", "", "", "", "", "", "", "", 
		"", "", "", "", "", "", "", "", "", "", 
		"", "", "", "", "", "", "", "", "", "", 
		"", "", "", "", "", "", "", "", "", "", 
		"", "", "", "", "", "", "", "", "", "", 
		"", "", "", "", "", "", "", "", "", "", 
		"", "", "", "", "", "", "", "", ""
	};
	
	public interface IconPickerListener {
		void onIconSelected(String selectedIcon);
	}
	
	public static void show(Activity activity, final IconPickerListener listener) {
		show(activity, DEFAULT_ICONS, listener);
	}
	
	public static void show(Activity activity, String[] icons, final IconPickerListener listener) {
		final Dialog dialog = new Dialog(activity);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		RenderUtils ru = new RenderUtils(activity);
		// Створюємо GridView програмно
		GridView gridView = new GridView(activity);
		gridView.setNumColumns(6); // 6 колонок
		gridView.setVerticalSpacing(16);
		gridView.setHorizontalSpacing(0);
		gridView.setPadding(16, 16, 16, 16);
		
		// Встановлюємо GridView як вміст діалогу
		dialog.setContentView(gridView);
		
		final ArrayList<String> iconList = new ArrayList<>();
		
		// Додаємо символи до списку
		for (String icon : icons) {
			iconList.add(icon);
		}
		
		// Створюємо адаптер з кастомним відображенням
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, iconList) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				TextView textView;
				
				if (convertView == null) {
					textView = new TextView(activity);
					textView.setLayoutParams(new GridView.LayoutParams(
					ViewGroup.LayoutParams.WRAP_CONTENT, 
					ViewGroup.LayoutParams.WRAP_CONTENT
					));
					textView.setGravity(android.view.Gravity.CENTER);
					textView.setPadding(0, 0, 0, 0);
				} else {
					textView = (TextView) convertView;
				}
				
				// Встановлюємо текст іконки
				textView.setText(iconList.get(position));
				
				// Застосовуємо спеціальний шрифт (якщо є)
				try {
					Typeface typeface = Typeface.createFromAsset(activity.getAssets(), "fonts/icons.ttf");
					textView.setTypeface(typeface);
				} catch (Exception e) {
					// Якщо шрифт не знайдено, використовуємо стандартний
					// e.printStackTrace();
				}
				
				// Збільшуємо розмір тексту для кращого відображення
				textView.setTextSize(25);
				
				return textView;
			}
		};
		
		gridView.setAdapter(adapter);
		
		// Обробник вибору іконки
		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				if (listener != null) {
					listener.onIconSelected(iconList.get(position));
				}
				dialog.dismiss();
			}
		});
		
		// Обробник довгого натискання
		gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				// Можна додати попередній перегляд або додаткові дії
				return true;
			}
		});
		
		// Налаштування розміру діалогу
		Window window = dialog.getWindow();
		if (window != null) {
			window.setLayout(
			ViewGroup.LayoutParams.MATCH_PARENT, 
			ViewGroup.LayoutParams.WRAP_CONTENT
			);
			
			dialog.setOnDismissListener(d -> {
				ru.off();
			});
			
			dialog.setOnShowListener(d -> {
				if (window != null) {
					if(WTF.SDK_INT() > 31 && ru.isOn()){
						ru.on();
						window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
						window.setDimAmount(0f);
					} else {
						ExtendedDataHolder datah = ExtendedDataHolder.getInstance();
						window.setDimAmount(Float.parseFloat(datah.getData("dvalp")));
					}
				}
			});
		}
		
		dialog.show();
	}
	
	// Метод для отримання масиву іконок
	public static String[] getDefaultIcons() {
		return DEFAULT_ICONS.clone();
	}
}
