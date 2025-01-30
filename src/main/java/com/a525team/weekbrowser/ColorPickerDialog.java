package com.a525team.weekbrowser;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.EditText;
import android.text.Editable;
import android.text.TextWatcher;
//import android.view.inputmethod.InputMethodManager;
import android.view.WindowManager;
import android.graphics.drawable.GradientDrawable;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.SeekBar;


public class ColorPickerDialog {
	private final Context context;
	private String hexRed = "00";
	private String hexGreen = "00";
	private String hexBlue = "00";
	private String hexAlpha = "00";
	private ColorPickerListener listener;
	private Bitmap bitmap;// = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);;
    private boolean hsvc;
	SeekBar red;
	SeekBar green;
	SeekBar blue;
	SeekBar alpha;
	SeekBar hue;
	SeekBar satur;
	SeekBar val;
    EditText medit;
	
	int[] colors = {
		Color.parseColor("#FF0000"), // червоний
		Color.parseColor("#FFFF00"), // жовтий
		Color.parseColor("#00FF00"), // зелений
		Color.parseColor("#808080"), // сірий
		Color.parseColor("#00FFFF"), // блакитний
		Color.parseColor("#0000FF"), // синій
		Color.parseColor("#FF00FF"), // пурпурний
		Color.parseColor("#000000"), // чорний
		Color.parseColor("#FFFFFF"), // білий
		Color.parseColor("#804000"), // коричневий
		Color.parseColor("#FF0000")  // червоний (повтор, щоб замкнути градієнт)
	};
	
	public interface ColorPickerListener {
		void onColorPicked(String colorHex);
	}
	
	public ColorPickerDialog(Context context) {
		this.context = context;
	}
	
	public void setColorPickerListener(ColorPickerListener listener) {
		this.listener = listener;
	}
	
	public void show(String colhex) {
		
		// Перевірка на формат Monet або шістнадцятковий код
		if (colhex.startsWith("m__")) {
			// Обробка кольору Monet
			// TODO: Реалізуйте перетворення кольору Monet у шістнадцятковий формат
			// Наприклад: колір = processColor(colhex, false, isAndroid12OrHigher);
			// Встановити hexRed, hexGreen, hexBlue на відповідні значення
			hexRed = "00"; // Змінити на отримане значення
			hexGreen = "00"; // Змінити на отримане значення
			hexBlue = "00"; // Змінити на отримане значення
			hexAlpha = "00"; // Змінити на отримане значення
		} else {
			// Обробка шістнадцяткового коду
			hexRed = colhex.substring(2, 4);
			hexGreen = colhex.substring(4, 6);
			hexBlue = colhex.substring(6, 8);
			hexAlpha = colhex.substring(0, 2);
		}
		
		final AlertDialog dialog2 = new AlertDialog.Builder(context).create();
		View inflate = LayoutInflater.from(context).inflate(R.layout.colorpick, null);
		dialog2.setView(inflate);
		dialog2.setTitle("Color");
		
		red = inflate.findViewById(R.id.red);
		green = inflate.findViewById(R.id.green);
		blue = inflate.findViewById(R.id.blue);
		alpha = inflate.findViewById(R.id.alpha);
		hue = inflate.findViewById(R.id.hue);
		satur = inflate.findViewById(R.id.satur);
		val = inflate.findViewById(R.id.val);
		Button ok = inflate.findViewById(R.id.ok);
		Button dismiss = inflate.findViewById(R.id.dismiss);
		medit = inflate.findViewById(R.id.medit);
		LinearLayout preview = inflate.findViewById(R.id.preview);
		LinearLayout palette = inflate.findViewById(R.id.palette);
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			red.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#00ffff")));
			red.setThumbTintList(ColorStateList.valueOf(Color.parseColor("#00ffff")));
			green.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#ff00ff")));
			green.setThumbTintList(ColorStateList.valueOf(Color.parseColor("#ff00ff")));
			blue.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#ffff00")));
			blue.setThumbTintList(ColorStateList.valueOf(Color.parseColor("#ffff00")));
			hue.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
			hue.setThumbTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
			satur.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#00ffff")));
			satur.setThumbTintList(ColorStateList.valueOf(Color.parseColor("#00ffff")));
			val.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#00ffff")));
			val.setThumbTintList(ColorStateList.valueOf(Color.parseColor("#00ffff")));
		} else {
			// Для API < 21 немає підтримки ColorStateList для SeekBar
			// Можливо, ви захочете додати обробку для цих версій тут.
		}
		
		// Встановити початкові значення SeekBar згідно з поточним кольором
		red.setProgress(Integer.parseInt(hexRed, 16));
		green.setProgress(Integer.parseInt(hexGreen, 16));
		blue.setProgress(Integer.parseInt(hexBlue, 16));
		alpha.setProgress(Integer.parseInt(hexAlpha, 16));
		preview.setBackgroundColor(Color.parseColor("#" + hexAlpha + hexRed + hexGreen + hexBlue));
		medit.setText(hexAlpha + hexRed + hexGreen + hexBlue);
					rehsv();
		GradientDrawable drawable = new GradientDrawable();
		drawable.setShape(GradientDrawable.RECTANGLE);
		drawable.setGradientType(GradientDrawable.SWEEP_GRADIENT);
		drawable.setColors(colors);
		drawable.setGradientCenter(0.5f, 0.5f);  // Центр градієнта
		palette.setBackground(drawable);
		{
			GradientDrawable hued = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{
				Color.parseColor("#FF0000"), // червоний
				Color.parseColor("#FFFF00"), // жовтий
				Color.parseColor("#00FF00"), // зелений
				Color.parseColor("#00FFFF"), // блакитний
				Color.parseColor("#0000FF"), // синій
				Color.parseColor("#FF00FF"), // рожевий
				Color.parseColor("#FF0000"), // червоний
			});
			hue.setBackground(hued);
		}{
			GradientDrawable saturd = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{
				Color.parseColor("#FFFFFF"), // білий
				Color.parseColor("#FF0000"), // червоний
			});
			satur.setBackground(saturd);
		}{
			GradientDrawable vald = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{
				Color.parseColor("#000000"), // чорний
				Color.parseColor("#FF0000"), // червоний
			});
			val.setBackground(vald);
		}		
		palette.setOnTouchListener((view, event) -> {
			if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
				int width = palette.getWidth();
				int height = palette.getHeight();
				
				// Переконайтесь, що палітра має правильний розмір
				bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
				Canvas canvas = new Canvas(bitmap);
				drawable.draw(canvas);
				// Отримання координат натискання
				int x = (int) event.getX();
				int y = (int) event.getY();
				
				// Перевірка, чи знаходяться координати в межах палітри
				if (x >= 0 && x < bitmap.getWidth() && y >= 0 && y < bitmap.getHeight()) {
					try {
						// Отримання кольору пікселя
						int pixelColor = bitmap.getPixel(x, y);
						String hexColor = String.format("#%08X", pixelColor); // Приведення до шістнадцяткового формату
						
						// Встановлення значення в EditText
						medit.setText(hexColor.substring(1));
					} catch (Exception e) {
						e.printStackTrace();  // Додано для налагодження
					}
				}
			}
			return true;
		});
		
		SeekBar.OnSeekBarChangeListener colorChangeListener = new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if(fromUser){
					hexRed = String.format("%02X", red.getProgress());
					hexGreen = String.format("%02X", green.getProgress());
					hexBlue = String.format("%02X", blue.getProgress());
					hexAlpha = String.format("%02X", alpha.getProgress());
					preview.setBackgroundColor(Color.parseColor("#" + hexAlpha + hexRed + hexGreen + hexBlue));
					
					medit.setText(hexAlpha + hexRed + hexGreen + hexBlue);}
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {}
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {}
		};
		
		View.OnClickListener buttonClickListener = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Отримуємо колір фону кнопки
				int color = ((ColorDrawable) v.getBackground()).getColor();
				
				// Перетворюємо колір в формат AARRGGBB
				String colorHex = String.format("#%08X", color);
				
				// Встановлюємо колір в EditText
				medit.setText(colorHex.substring(1)); // Виводимо тільки частину без #
			}
		};
		
        setupHsvListeners();

		Button c0 = inflate.findViewById(R.id.c0);
		Button c1 = inflate.findViewById(R.id.c1);
		Button c2 = inflate.findViewById(R.id.c2);
		Button c3 = inflate.findViewById(R.id.c3);
		Button c4 = inflate.findViewById(R.id.c4);
		Button c5 = inflate.findViewById(R.id.c5);
		Button c6 = inflate.findViewById(R.id.c6);
		Button c7 = inflate.findViewById(R.id.c7);
		Button c8 = inflate.findViewById(R.id.c8);
		Button c9 = inflate.findViewById(R.id.c9);
		Button c10 = inflate.findViewById(R.id.c10);
		Button c11 = inflate.findViewById(R.id.c11);
		Button c12 = inflate.findViewById(R.id.c12);
		Button c13 = inflate.findViewById(R.id.c13);
		Button c14 = inflate.findViewById(R.id.c14);
		Button c15 = inflate.findViewById(R.id.c15);
		Button c16 = inflate.findViewById(R.id.c16);
		Button c17 = inflate.findViewById(R.id.c17);
		Button c18 = inflate.findViewById(R.id.c18);
		Button c19 = inflate.findViewById(R.id.c19);
		Button c20 = inflate.findViewById(R.id.c20);
		Button c21 = inflate.findViewById(R.id.c21);
		Button c22 = inflate.findViewById(R.id.c22);
		Button c23 = inflate.findViewById(R.id.c23);
		Button c24 = inflate.findViewById(R.id.c24);
		Button c25 = inflate.findViewById(R.id.c25);
		Button c26 = inflate.findViewById(R.id.c26);
		Button c27 = inflate.findViewById(R.id.c27);
		Button c28 = inflate.findViewById(R.id.c28);
		Button c29 = inflate.findViewById(R.id.c29);
		Button c30 = inflate.findViewById(R.id.c30);
		Button c31 = inflate.findViewById(R.id.c31);
		Button c32 = inflate.findViewById(R.id.c32);
		Button c33 = inflate.findViewById(R.id.c33);
		Button c34 = inflate.findViewById(R.id.c34);
		Button c35 = inflate.findViewById(R.id.c35);
		Button c36 = inflate.findViewById(R.id.c36);
		Button c37 = inflate.findViewById(R.id.c37);
		Button c38 = inflate.findViewById(R.id.c38);
		Button c39 = inflate.findViewById(R.id.c39);
		Button c40 = inflate.findViewById(R.id.c40);
		Button c41 = inflate.findViewById(R.id.c41);
		Button c42 = inflate.findViewById(R.id.c42);
		Button c43 = inflate.findViewById(R.id.c43);
		Button c44 = inflate.findViewById(R.id.c44);
		Button c45 = inflate.findViewById(R.id.c45);
		Button c46 = inflate.findViewById(R.id.c46);
		Button c47 = inflate.findViewById(R.id.c47);
		Button c48 = inflate.findViewById(R.id.c48);
		Button c49 = inflate.findViewById(R.id.c49);
		Button c50 = inflate.findViewById(R.id.c50);
		Button c51 = inflate.findViewById(R.id.c51);
		Button c52 = inflate.findViewById(R.id.c52);
		Button c53 = inflate.findViewById(R.id.c53);
		Button c54 = inflate.findViewById(R.id.c54);
		Button c55 = inflate.findViewById(R.id.c55);
		Button c56 = inflate.findViewById(R.id.c56);
		Button c57 = inflate.findViewById(R.id.c57);
		Button c58 = inflate.findViewById(R.id.c58);
		Button c59 = inflate.findViewById(R.id.c59);
		Button c60 = inflate.findViewById(R.id.c60);
		Button c61 = inflate.findViewById(R.id.c61);
		Button c62 = inflate.findViewById(R.id.c62);
		Button c63 = inflate.findViewById(R.id.c63);
		Button c64 = inflate.findViewById(R.id.c64);
		Button c65 = inflate.findViewById(R.id.c65);
		Button c66 = inflate.findViewById(R.id.c66);
		Button c67 = inflate.findViewById(R.id.c67);
		Button c68 = inflate.findViewById(R.id.c68);
		Button c69 = inflate.findViewById(R.id.c69);
		Button c70 = inflate.findViewById(R.id.c70);
		Button c71 = inflate.findViewById(R.id.c71);
		Button c72 = inflate.findViewById(R.id.c72);
		Button c73 = inflate.findViewById(R.id.c73);
		Button c74 = inflate.findViewById(R.id.c74);
		Button c75 = inflate.findViewById(R.id.c75);
		Button c76 = inflate.findViewById(R.id.c76);
		Button c77 = inflate.findViewById(R.id.c77);
		Button c78 = inflate.findViewById(R.id.c78);
		Button c79 = inflate.findViewById(R.id.c79);
		Button c80 = inflate.findViewById(R.id.c80);
		Button c81 = inflate.findViewById(R.id.c81);
		Button c82 = inflate.findViewById(R.id.c82);
		Button c83 = inflate.findViewById(R.id.c83);
		Button c84 = inflate.findViewById(R.id.c84);
		Button c85 = inflate.findViewById(R.id.c85);
		Button c86 = inflate.findViewById(R.id.c86);
		Button c87 = inflate.findViewById(R.id.c87);
		Button c88 = inflate.findViewById(R.id.c88);
		Button c89 = inflate.findViewById(R.id.c89);
		Button c90 = inflate.findViewById(R.id.c90);
		Button c91 = inflate.findViewById(R.id.c91);
		Button c92 = inflate.findViewById(R.id.c92);
		Button c93 = inflate.findViewById(R.id.c93);
		Button c94 = inflate.findViewById(R.id.c94);
		Button c95 = inflate.findViewById(R.id.c95);
		Button c96 = inflate.findViewById(R.id.c96);
		Button c97 = inflate.findViewById(R.id.c97);
		Button c98 = inflate.findViewById(R.id.c98);
		Button c99 = inflate.findViewById(R.id.c99);
		Button c100 = inflate.findViewById(R.id.c100);
		Button c101 = inflate.findViewById(R.id.c101);
		Button c102 = inflate.findViewById(R.id.c102);
		Button c103 = inflate.findViewById(R.id.c103);
		Button c104 = inflate.findViewById(R.id.c104);
		Button c105 = inflate.findViewById(R.id.c105);
		Button c106 = inflate.findViewById(R.id.c106);
		Button c107 = inflate.findViewById(R.id.c107);
		Button c108 = inflate.findViewById(R.id.c108);
		Button c109 = inflate.findViewById(R.id.c109);
		Button c110 = inflate.findViewById(R.id.c110);
		Button c111 = inflate.findViewById(R.id.c111);
		
		c0.setOnClickListener(buttonClickListener);
		c1.setOnClickListener(buttonClickListener);
		c2.setOnClickListener(buttonClickListener);
		c3.setOnClickListener(buttonClickListener);
		c4.setOnClickListener(buttonClickListener);
		c5.setOnClickListener(buttonClickListener);
		c6.setOnClickListener(buttonClickListener);
		c7.setOnClickListener(buttonClickListener);
		c8.setOnClickListener(buttonClickListener);
		c9.setOnClickListener(buttonClickListener);
		c10.setOnClickListener(buttonClickListener);
		c11.setOnClickListener(buttonClickListener);
		c12.setOnClickListener(buttonClickListener);
		c13.setOnClickListener(buttonClickListener);
		c14.setOnClickListener(buttonClickListener);
		c15.setOnClickListener(buttonClickListener);
		c16.setOnClickListener(buttonClickListener);
		c17.setOnClickListener(buttonClickListener);
		c18.setOnClickListener(buttonClickListener);
		c19.setOnClickListener(buttonClickListener);
		c20.setOnClickListener(buttonClickListener);
		c21.setOnClickListener(buttonClickListener);
		c22.setOnClickListener(buttonClickListener);
		c23.setOnClickListener(buttonClickListener);
		c24.setOnClickListener(buttonClickListener);
		c25.setOnClickListener(buttonClickListener);
		c26.setOnClickListener(buttonClickListener);
		c27.setOnClickListener(buttonClickListener);
		c28.setOnClickListener(buttonClickListener);
		c29.setOnClickListener(buttonClickListener);
		c30.setOnClickListener(buttonClickListener);
		c31.setOnClickListener(buttonClickListener);
		c32.setOnClickListener(buttonClickListener);
		c33.setOnClickListener(buttonClickListener);
		c34.setOnClickListener(buttonClickListener);
		c35.setOnClickListener(buttonClickListener);
		c36.setOnClickListener(buttonClickListener);
		c37.setOnClickListener(buttonClickListener);
		c38.setOnClickListener(buttonClickListener);
		c39.setOnClickListener(buttonClickListener);
		c40.setOnClickListener(buttonClickListener);
		c41.setOnClickListener(buttonClickListener);
		c42.setOnClickListener(buttonClickListener);
		c43.setOnClickListener(buttonClickListener);
		c44.setOnClickListener(buttonClickListener);
		c45.setOnClickListener(buttonClickListener);
		c46.setOnClickListener(buttonClickListener);
		c47.setOnClickListener(buttonClickListener);
		c48.setOnClickListener(buttonClickListener);
		c49.setOnClickListener(buttonClickListener);
		c50.setOnClickListener(buttonClickListener);
		c51.setOnClickListener(buttonClickListener);
		c52.setOnClickListener(buttonClickListener);
		c53.setOnClickListener(buttonClickListener);
		c54.setOnClickListener(buttonClickListener);
		c55.setOnClickListener(buttonClickListener);
		c56.setOnClickListener(buttonClickListener);
		c57.setOnClickListener(buttonClickListener);
		c58.setOnClickListener(buttonClickListener);
		c59.setOnClickListener(buttonClickListener);
		c60.setOnClickListener(buttonClickListener);
		c61.setOnClickListener(buttonClickListener);
		c62.setOnClickListener(buttonClickListener);
		c63.setOnClickListener(buttonClickListener);
		c64.setOnClickListener(buttonClickListener);
		c65.setOnClickListener(buttonClickListener);
		c66.setOnClickListener(buttonClickListener);
		c67.setOnClickListener(buttonClickListener);
		c68.setOnClickListener(buttonClickListener);
		c69.setOnClickListener(buttonClickListener);
		c70.setOnClickListener(buttonClickListener);
		c71.setOnClickListener(buttonClickListener);
		c72.setOnClickListener(buttonClickListener);
		c73.setOnClickListener(buttonClickListener);
		c74.setOnClickListener(buttonClickListener);
		c75.setOnClickListener(buttonClickListener);
		c76.setOnClickListener(buttonClickListener);
		c77.setOnClickListener(buttonClickListener);
		c78.setOnClickListener(buttonClickListener);
		c79.setOnClickListener(buttonClickListener);
		c80.setOnClickListener(buttonClickListener);
		c81.setOnClickListener(buttonClickListener);
		c82.setOnClickListener(buttonClickListener);
		c83.setOnClickListener(buttonClickListener);
		c84.setOnClickListener(buttonClickListener);
		c85.setOnClickListener(buttonClickListener);
		c86.setOnClickListener(buttonClickListener);
		c87.setOnClickListener(buttonClickListener);
		c88.setOnClickListener(buttonClickListener);
		c89.setOnClickListener(buttonClickListener);
		c90.setOnClickListener(buttonClickListener);
		c91.setOnClickListener(buttonClickListener);
		c92.setOnClickListener(buttonClickListener);
		c93.setOnClickListener(buttonClickListener);
		c94.setOnClickListener(buttonClickListener);
		c95.setOnClickListener(buttonClickListener);
		c96.setOnClickListener(buttonClickListener);
		c97.setOnClickListener(buttonClickListener);
		c98.setOnClickListener(buttonClickListener);
		c99.setOnClickListener(buttonClickListener);
		c100.setOnClickListener(buttonClickListener);
		c101.setOnClickListener(buttonClickListener);
		c102.setOnClickListener(buttonClickListener);
		c103.setOnClickListener(buttonClickListener);
		c104.setOnClickListener(buttonClickListener);
		c105.setOnClickListener(buttonClickListener);
		c106.setOnClickListener(buttonClickListener);
		c107.setOnClickListener(buttonClickListener);
		c108.setOnClickListener(buttonClickListener);
		c109.setOnClickListener(buttonClickListener);
		c110.setOnClickListener(buttonClickListener);
		c111.setOnClickListener(buttonClickListener);
		
		red.setOnSeekBarChangeListener(colorChangeListener);
		green.setOnSeekBarChangeListener(colorChangeListener);
		blue.setOnSeekBarChangeListener(colorChangeListener);
		alpha.setOnSeekBarChangeListener(colorChangeListener);
		
		medit.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String cs = _param1.toString();
				try{
					hexRed = cs.substring(2, 4);
					hexGreen = cs.substring(4, 6);
					hexBlue = cs.substring(6, 8);
					hexAlpha = cs.substring(0, 2);
					red.setProgress(Integer.parseInt(hexRed, 16));
					green.setProgress(Integer.parseInt(hexGreen, 16));
					blue.setProgress(Integer.parseInt(hexBlue, 16));
					alpha.setProgress(Integer.parseInt(hexAlpha, 16));
					preview.setBackgroundColor(Color.parseColor("#" + hexAlpha + hexRed + hexGreen + hexBlue));
					if(!hsvc)rehsv();
                    }
				catch(Exception e){
					
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		dismiss.setOnClickListener(view -> dialog2.dismiss());
		
		ok.setOnClickListener(view -> {
			String selectedColorHex = hexAlpha + hexRed + hexGreen + hexBlue;
			if (listener != null) {
				listener.onColorPicked(selectedColorHex);
			}
			dialog2.dismiss();
		});
		
		dialog2.show();
		
		// Ініціалізація кольорів Monet
		fillmonet(inflate, dialog2);
		
	}
	
	private void rehsv() {
    int r = red.getProgress();
    int g = green.getProgress();
    int b = blue.getProgress();

    // Перетворення в діапазон [0; 1]
    double rNorm = r / 255.0;
    double gNorm = g / 255.0;
    double bNorm = b / 255.0;

    // Обчислення Max і Min
    double max = Math.max(rNorm, Math.max(gNorm, bNorm));
    double min = Math.min(rNorm, Math.min(gNorm, bNorm));
    double delta = max - min;

    // Обчислення яскравості (Value)
    double v = max * 255;
    val.setProgress((int) v);

    // Обчислення насиченості (Saturation)
    double s = (max == 0) ? 0 : (delta / max) * 255;
    satur.setProgress((int) s);

    // Обчислення відтінку (Hue)
    double h = 0;
    if (delta != 0) {
        if (max == rNorm) {
            h = (gNorm - bNorm) / delta;
        } else if (max == gNorm) {
            h = 2.0 + (bNorm - rNorm) / delta;
        } else {
            h = 4.0 + (rNorm - gNorm) / delta;
        }

        h *= 60; // Перетворення в градуси
        if (h < 0) {
            h += 360; // Переклад у позитивний діапазон
        }
    }

    // Перетворення Hue у ваш діапазон [0; 1530]
    h = h / 360.0 * 1530.0;
    hue.setProgress((int) h);
}


private int hsvToRgb(int h, int s, int v) {
    double hue = h / 1530.0; // Нормалізуємо hue до [0, 1]
    double saturation = s / 255.0; // Нормалізуємо saturation до [0, 1]
    double value = v / 255.0; // Нормалізуємо value до [0, 1]

    double c = value * saturation; // Хроматичність
    double x = c * (1 - Math.abs((hue * 6) % 2 - 1)); // Другий компонент кольору
    double m = value - c; // Зміщення для отримання RGB у [0, 1]

    double r = 0, g = 0, b = 0;

    if (0 <= hue && hue < 1.0 / 6.0) {
        r = c;
        g = x;
    } else if (1.0 / 6.0 <= hue && hue < 2.0 / 6.0) {
        r = x;
        g = c;
    } else if (2.0 / 6.0 <= hue && hue < 3.0 / 6.0) {
        g = c;
        b = x;
    } else if (3.0 / 6.0 <= hue && hue < 4.0 / 6.0) {
        g = x;
        b = c;
    } else if (4.0 / 6.0 <= hue && hue < 5.0 / 6.0) {
        r = x;
        b = c;
    } else if (5.0 / 6.0 <= hue && hue <= 1) {
        r = c;
        b = x;
    }

    r = (r + m) * 255;
    g = (g + m) * 255;
    b = (b + m) * 255;

    return Color.rgb((int) Math.round(r), (int) Math.round(g), (int) Math.round(b));
}

private void setupHsvListeners() {
    SeekBar.OnSeekBarChangeListener hsvChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                // Отримуємо поточні значення HSV
                int h = hue.getProgress();
                int s = satur.getProgress();
                int v = val.getProgress();

                // Конвертуємо HSV у RGB
                int rgb = hsvToRgb(h, s, v);

                // Отримуємо значення прозорості (alpha)
                int alphaValue = alpha.getProgress();

                // Перетворюємо RGB у шістнадцятковий формат AARRGGBB
                String hexColor = String.format("#%02X%02X%02X%02X",
                        alphaValue,
                        (rgb >> 16) & 0xFF, // Червоний
                        (rgb >> 8) & 0xFF,  // Зелений
                        rgb & 0xFF);        // Синій

                // Встановлюємо значення у текстове поле medit
                medit.setText(hexColor.substring(1));
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {hsvc = true;}

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {hsvc = false;}
    };

    // Призначаємо прослуховувачі для кожного повзунка
    hue.setOnSeekBarChangeListener(hsvChangeListener);
    satur.setOnSeekBarChangeListener(hsvChangeListener);
    val.setOnSeekBarChangeListener(hsvChangeListener);
    alpha.setOnSeekBarChangeListener(hsvChangeListener);
}

	
	private void fillmonet(View inflate, final AlertDialog dialog2) {
		Button n110 = inflate.findViewById(R.id.n110);
		Button n150 = inflate.findViewById(R.id.n150);
		Button n1100 = inflate.findViewById(R.id.n1100);
		Button n1200 = inflate.findViewById(R.id.n1200);
		Button n1300 = inflate.findViewById(R.id.n1300);
		Button n1400 = inflate.findViewById(R.id.n1400);
		Button n1500 = inflate.findViewById(R.id.n1500);
		Button n1600 = inflate.findViewById(R.id.n1600);
		Button n1700 = inflate.findViewById(R.id.n1700);
		Button n1800 = inflate.findViewById(R.id.n1800);
		Button n1900 = inflate.findViewById(R.id.n1900);
		Button n210 = inflate.findViewById(R.id.n210);
		Button n250 = inflate.findViewById(R.id.n250);
		Button n2100 = inflate.findViewById(R.id.n2100);
		Button n2200 = inflate.findViewById(R.id.n2200);
		Button n2300 = inflate.findViewById(R.id.n2300);
		Button n2400 = inflate.findViewById(R.id.n2400);
		Button n2500 = inflate.findViewById(R.id.n2500);
		Button n2600 = inflate.findViewById(R.id.n2600);
		Button n2700 = inflate.findViewById(R.id.n2700);
		Button n2800 = inflate.findViewById(R.id.n2800);
		Button n2900 = inflate.findViewById(R.id.n2900);
		Button a110 = inflate.findViewById(R.id.a110);
		Button a150 = inflate.findViewById(R.id.a150);
		Button a1100 = inflate.findViewById(R.id.a1100);
		Button a1200 = inflate.findViewById(R.id.a1200);
		Button a1300 = inflate.findViewById(R.id.a1300);
		Button a1400 = inflate.findViewById(R.id.a1400);
		Button a1500 = inflate.findViewById(R.id.a1500);
		Button a1600 = inflate.findViewById(R.id.a1600);
		Button a1700 = inflate.findViewById(R.id.a1700);
		Button a1800 = inflate.findViewById(R.id.a1800);
		Button a1900 = inflate.findViewById(R.id.a1900);
		Button a210 = inflate.findViewById(R.id.a210);
		Button a250 = inflate.findViewById(R.id.a250);
		Button a2100 = inflate.findViewById(R.id.a2100);
		Button a2200 = inflate.findViewById(R.id.a2200);
		Button a2300 = inflate.findViewById(R.id.a2300);
		Button a2400 = inflate.findViewById(R.id.a2400);
		Button a2500 = inflate.findViewById(R.id.a2500);
		Button a2600 = inflate.findViewById(R.id.a2600);
		Button a2700 = inflate.findViewById(R.id.a2700);
		Button a2800 = inflate.findViewById(R.id.a2800);
		Button a2900 = inflate.findViewById(R.id.a2900);
		Button a310 = inflate.findViewById(R.id.a310);
		Button a350 = inflate.findViewById(R.id.a350);
		Button a3100 = inflate.findViewById(R.id.a3100);
		Button a3200 = inflate.findViewById(R.id.a3200);
		Button a3300 = inflate.findViewById(R.id.a3300);
		Button a3400 = inflate.findViewById(R.id.a3400);
		Button a3500 = inflate.findViewById(R.id.a3500);
		Button a3600 = inflate.findViewById(R.id.a3600);
		Button a3700 = inflate.findViewById(R.id.a3700);
		Button a3800 = inflate.findViewById(R.id.a3800);
		Button a3900 = inflate.findViewById(R.id.a3900);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
			n110.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_10, context.getTheme()));
			n150.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_50, context.getTheme()));
			n1100.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_100, context.getTheme()));
			n1200.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_200, context.getTheme()));
			n1300.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_300, context.getTheme()));
			n1400.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_400, context.getTheme()));
			n1500.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_500, context.getTheme()));
			n1600.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_600, context.getTheme()));
			n1700.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_700, context.getTheme()));
			n1800.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_800, context.getTheme()));
			n1900.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral1_900, context.getTheme()));
			
			n210.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_10, context.getTheme()));
			n250.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_50, context.getTheme()));
			n2100.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_100, context.getTheme()));
			n2200.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_200, context.getTheme()));
			n2300.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_300, context.getTheme()));
			n2400.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_400, context.getTheme()));
			n2500.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_500, context.getTheme()));
			n2600.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_600, context.getTheme()));
			n2700.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_700, context.getTheme()));
			n2800.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_800, context.getTheme()));
			n2900.setBackgroundColor(context.getResources().getColor(android.R.color.system_neutral2_900, context.getTheme()));
			
			a110.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_10, context.getTheme()));
			a150.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_50, context.getTheme()));
			a1100.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_100, context.getTheme()));
			a1200.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_200, context.getTheme()));
			a1300.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_300, context.getTheme()));
			a1400.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_400, context.getTheme()));
			a1500.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_500, context.getTheme()));
			a1600.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_600, context.getTheme()));
			a1700.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_700, context.getTheme()));
			a1800.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_800, context.getTheme()));
			a1900.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent1_900, context.getTheme()));
			
			a210.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_10, context.getTheme()));
			a250.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_50, context.getTheme()));
			a2100.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_100, context.getTheme()));
			a2200.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_200, context.getTheme()));
			a2300.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_300, context.getTheme()));
			a2400.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_400, context.getTheme()));
			a2500.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_500, context.getTheme()));
			a2600.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_600, context.getTheme()));
			a2700.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_700, context.getTheme()));
			a2800.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_800, context.getTheme()));
			a2900.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent2_900, context.getTheme()));
			
			a310.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_10, context.getTheme()));
			a350.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_50, context.getTheme()));
			a3100.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_100, context.getTheme()));
			a3200.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_200, context.getTheme()));
			a3300.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_300, context.getTheme()));
			a3400.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_400, context.getTheme()));
			a3500.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_500, context.getTheme()));
			a3600.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_600, context.getTheme()));
			a3700.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_700, context.getTheme()));
			a3800.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_800, context.getTheme()));
			a3900.setBackgroundColor(context.getResources().getColor(android.R.color.system_accent3_900, context.getTheme()));
		}else{
			//neutral 1
			n110.setBackgroundColor(0xFFFEFAFE);
			n150.setBackgroundColor(0xFFFAFAFA);
			n1100.setBackgroundColor(0xFFF5F5F5);
			n1200.setBackgroundColor(0xFFEEEEEE);
			n1300.setBackgroundColor(0xFFE0E0E0);
			n1400.setBackgroundColor(0xFFBDBDBD);
			n1500.setBackgroundColor(0xFF9E9E9E);
			n1600.setBackgroundColor(0xFF757575);
			n1700.setBackgroundColor(0xFF616161);
			n1800.setBackgroundColor(0xFF424242);
			n1900.setBackgroundColor(0xFF212121);
			
			//neutral 2
			n210.setBackgroundColor(0xFFF2F3F6);
			n250.setBackgroundColor(0xFFECEFF1);
			n2100.setBackgroundColor(0xFFCFD8DC);
			n2200.setBackgroundColor(0xFFB0BEC5);
			n2300.setBackgroundColor(0xFF90A4AE);
			n2400.setBackgroundColor(0xFF78909C);
			n2500.setBackgroundColor(0xFF607D8B);
			n2600.setBackgroundColor(0xFF546E7A);
			n2700.setBackgroundColor(0xFF455A64);
			n2800.setBackgroundColor(0xFF37474F);
			n2900.setBackgroundColor(0xFF263238);
			
			//accent 1
			a110.setBackgroundColor(0xFFE9F6FB);
			a150.setBackgroundColor(0xFFE0F2F1);
			a1100.setBackgroundColor(0xFFB2DFDB);
			a1200.setBackgroundColor(0xFF80CBC4);
			a1300.setBackgroundColor(0xFF4DB6AC);
			a1400.setBackgroundColor(0xFF26A69A);
			a1500.setBackgroundColor(0xFF009688);
			a1600.setBackgroundColor(0xFF00897B);
			a1700.setBackgroundColor(0xFF00796B);
			a1800.setBackgroundColor(0xFF00695C);
			a1900.setBackgroundColor(0xFF004D40);
			
			//accent 2
			a210.setBackgroundColor(0xFFF2FFFC);
			a250.setBackgroundColor(0xFFDAF7F3);
			a2100.setBackgroundColor(0xFFCCE8E4);
			a2200.setBackgroundColor(0xFFB0CCC8);
			a2300.setBackgroundColor(0xFF96B1AD);
			a2400.setBackgroundColor(0xFF7B9693);
			a2500.setBackgroundColor(0xFF617B78);
			a2600.setBackgroundColor(0xFF4A6360);
			a2700.setBackgroundColor(0xFF324B49);
			a2800.setBackgroundColor(0xFF1C3532);
			a2900.setBackgroundColor(0xFF051F1D);
			
			//accent 3
			a310.setBackgroundColor(0xFFFCFCFF);
			a350.setBackgroundColor(0xFFE9F1FF);
			a3100.setBackgroundColor(0xFFCFE5FF);
			a3200.setBackgroundColor(0xFFAFC9E7);
			a3300.setBackgroundColor(0xFF94AECB);
			a3400.setBackgroundColor(0xFF7A93AF);
			a3500.setBackgroundColor(0xFF607893);
			a3600.setBackgroundColor(0xFF48617B);
			a3700.setBackgroundColor(0xFF304962);
			a3800.setBackgroundColor(0xFF18324A);
			a3900.setBackgroundColor(0xFF001D34);
		}
		
		//Neutral 1
		n110.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n1010");}dialog2.dismiss();}
		});
		n150.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n1050");}dialog2.dismiss();}
		});
		n1100.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n1100");}dialog2.dismiss();}
		});
		n1200.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n1200");}dialog2.dismiss();}
		});
		n1300.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n1300");}dialog2.dismiss();}
		});
		n1400.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n1400");}dialog2.dismiss();}
		});
		n1500.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n1500");}dialog2.dismiss();}
		});
		n1600.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n1600");}dialog2.dismiss();}
		});
		n1700.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n1700");}dialog2.dismiss();}
		});
		n1800.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n1800");}dialog2.dismiss();}
		});
		n1900.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n1900");}dialog2.dismiss();}
		});
		//Neutral 2
		n210.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n2010");}dialog2.dismiss();}
		});
		n250.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n2050");}dialog2.dismiss();}
		});
		n2100.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n2100");}dialog2.dismiss();}
		});
		n2200.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n2200");}dialog2.dismiss();}
		});
		n2300.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n2300");}dialog2.dismiss();}
		});
		n2400.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n2400");}dialog2.dismiss();}
		});
		n2500.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n2500");}dialog2.dismiss();}
		});
		n2600.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n2600");}dialog2.dismiss();}
		});
		n2700.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n2700");}dialog2.dismiss();}
		});
		n2800.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n2800");}dialog2.dismiss();}
		});
		n2900.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__n2900");}dialog2.dismiss();}
		});
		//Accent 1
		a110.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a1010");}dialog2.dismiss();}
		});
		a150.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a1050");}dialog2.dismiss();}
		});
		a1100.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a1100");}dialog2.dismiss();}
		});
		a1200.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a1200");}dialog2.dismiss();}
		});
		a1300.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a1300");}dialog2.dismiss();}
		});
		a1400.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a1400");}dialog2.dismiss();}
		});
		a1500.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a1500");}dialog2.dismiss();}
		});
		a1600.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a1600");}dialog2.dismiss();}
		});
		a1700.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a1700");}dialog2.dismiss();}
		});
		a1800.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a1800");}dialog2.dismiss();}
		});
		a1900.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a1900");}dialog2.dismiss();}
		});
		//Accent 2
		a210.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a2010");}dialog2.dismiss();}
		});
		a250.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a2050");}dialog2.dismiss();}
		});
		a2100.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a2100");}dialog2.dismiss();}
		});
		a2200.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a2200");}dialog2.dismiss();}
		});
		a2300.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a2300");}dialog2.dismiss();}
		});
		a2400.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a2400");}dialog2.dismiss();}
		});
		a2500.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a2500");}dialog2.dismiss();}
		});
		a2600.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a2600");}dialog2.dismiss();}
		});
		a2700.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a2700");}dialog2.dismiss();}
		});
		a2800.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a2800");}dialog2.dismiss();}
		});
		a2900.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a2900");}dialog2.dismiss();}
		});
		//Accent 3
		a310.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a3010");}dialog2.dismiss();}
		});
		a350.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a3050");}dialog2.dismiss();}
		});
		a3100.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a3100");}dialog2.dismiss();}
		});
		a3200.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a3200");}dialog2.dismiss();}
		});
		a3300.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a3300");}dialog2.dismiss();}
		});
		a3400.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a3400");}dialog2.dismiss();}
		});
		a3500.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a3500");}dialog2.dismiss();}
		});
		a3600.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a3600");}dialog2.dismiss();}
		});
		a3700.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a3700");}dialog2.dismiss();}
		});
		a3800.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a3800");}dialog2.dismiss();}
		});
		a3900.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {if (listener != null) {
					listener.onColorPicked("m__a3900");}dialog2.dismiss();}
		});
		
		
	}
	
	
	
	
	
}
