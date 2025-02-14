package com.a525team.weekbrowser;

import android.content.res.ColorStateList;
import android.os.Build;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class Colorify {
		public void setSeekBarColors(SeekBar seekBar, int progressColor, int thumbColor) {
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
						// Зміна кольору прогресу
						seekBar.setProgressTintList(ColorStateList.valueOf(progressColor));
						// Зміна кольору кнопки (thumb)
						seekBar.setThumbTintList(ColorStateList.valueOf(thumbColor));
				} else {
						// Для API < 21 немає підтримки ColorStateList для SeekBar
						// Можливо, ви захочете додати обробку для цих версій тут.
				}
		}
		public void setButtonColor(CompoundButton button, int color) {
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
						ColorStateList colorStateList = ColorStateList.valueOf(color);
						button.setButtonTintList(colorStateList);
				} else {
						// Для API < 21 немає підтримки ColorStateList для кнопок
						// Можливо, ви захочете додати обробку для цих версій тут.
				}
		}    
}
