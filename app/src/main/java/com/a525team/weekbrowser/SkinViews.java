package com.a525team.weekbrowser;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.*;

public class SkinViews {
	
	public static class SkinViewHelper {
		private final View view;
		private String skinKey = null;
		private boolean isSmall = false; 
		private boolean isPressed = false;
		
		// Зберігаємо оригінальний фон системи (наприклад, для EditText це лінія знизу)
		private final Drawable defaultBackground;
		
		public SkinViewHelper(View view) {
			this.view = view;
			this.defaultBackground = view.getBackground(); // Запам'ятовуємо системний фон
			evaluateDefaultKey();
		}
		
		public SkinViewHelper(View view, AttributeSet attrs) {
			this.view = view;
			this.defaultBackground = view.getBackground(); // Запам'ятовуємо системний фон
			evaluateDefaultKey();
			
			if (attrs != null) {
				Context ctx = view.getContext();
				try {
					int keyId = ctx.getResources().getIdentifier("skinKey", "attr", ctx.getPackageName());
					if (keyId != 0) {
						TypedArray a = ctx.obtainStyledAttributes(attrs, new int[]{keyId});
						String key = a.getString(0);
						a.recycle();
						if (key != null && !key.trim().isEmpty()) {
							this.skinKey = key.trim();
						}
					}
					
					int smallId = ctx.getResources().getIdentifier("isSmall", "attr", ctx.getPackageName());
					if (smallId != 0) {
						TypedArray a = ctx.obtainStyledAttributes(attrs, new int[]{smallId});
						this.isSmall = a.getBoolean(0, false);
						a.recycle();
					}
				} catch (Exception ignored) {}
			}
		}
		
		private void evaluateDefaultKey() {
			if (view instanceof EditText || view instanceof AutoCompleteTextView) {
				this.skinKey = "tf";
			} else if (view instanceof CompoundButton) {
				this.skinKey = "t";
			} else if (view instanceof Button) {
				this.skinKey = "bbg";
			} else {
				this.skinKey = "t";
			}
		}
		
		public void setSkinKey(String key, boolean isSmall) {
			this.skinKey = key != null ? key.trim() : null;
			this.isSmall = isSmall;
			applySkin();
		}
		
		public void setPressedState(boolean pressed) {
			if (this.isPressed != pressed) {
				this.isPressed = pressed;
				applySkin();
			}
		}
		
		public void applySkin() {
			Skin skin = Skin.getInstance();
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			
			String bgKey = null;
			String textKey = null;
			String hintKey = null;
			boolean isButtonColorable = false;
			
			// 1. АНАЛІЗ КЛЮЧІВ
			if ("bbg".equals(skinKey)) {
				bgKey = "bbg";
				textKey = "bt";
				isButtonColorable = true;
			} else if ("rbg".equals(skinKey)) {
				bgKey = "rbg";
				textKey = "rbt";
				isButtonColorable = true;
			} else if ("brg".equals(skinKey)) { //червоний фон, але зі звичайним заокругленням
				bgKey = "brg";
				textKey = "rbt";
				isButtonColorable = true;
			}
			else if ("t".equals(skinKey) || "tf".equals(skinKey) || "add".equals(skinKey) || "h".equals(skinKey)) {
				textKey = skinKey;
				if ("h".equals(skinKey)) hintKey = "h";
			} 
			else if ("twb".equals(skinKey) || "tfwb".equals(skinKey) || "addwb".equals(skinKey) || "hwb".equals(skinKey)) {
				bgKey = "bg"; 
				textKey = skinKey.substring(0, skinKey.length() - 2); 
				if ("hwb".equals(skinKey)) hintKey = "h";
			}
			
			// ПЕРЕВІРКА НА МАГІЧНИЙ КОЛІР (Ігнорування кастомізації при 0x00FF0000)
			boolean useDefaultSystemTheme = false;
			if (bgKey != null) {
				int[] bgColors = skin.getColorsByKey(bgKey);
				if (bgColors != null && bgColors.length > 0 && bgColors[0] == 0x00FF0000) {
					useDefaultSystemTheme = true;
				}
			} else if (textKey != null) {
				int[] textColors = skin.getColorsByKey(textKey);
				if (textColors != null && textColors.length > 0 && textColors[0] == 0x00FF0000) {
					useDefaultSystemTheme = true;
				}
			}
			
			// 2. ОБРОБКА ФОНУ
			if (useDefaultSystemTheme) {
				// Якщо зустріли 0x00FF0000 — повертаємо системний фон (лінію, прозорість, матеріальний стиль)
				if (view.getBackground() != defaultBackground) {
					view.setBackground(defaultBackground);
				}
			} else if (bgKey != null && !"tf".equals(skinKey)) {
				String currentBgKey = bgKey;
				
				if (isPressed && view instanceof SkinButton) {
					if ("bbg".equals(bgKey)) currentBgKey = "rbg";
					else if ("rbg".equals(bgKey)) currentBgKey = "bbg";
                    else if ("brg".equals(bgKey)) currentBgKey = "bbg";
				}
				
				int r = "brg".equals(currentBgKey) ? 3 : "bg".equals(currentBgKey) ? 2 : ("rbg".equals(currentBgKey) ? 1 : 0);
				skin.setBG(view, r, this.isSmall); 
			} else {
				// Для EditText, AutoCompleteTextView та інших текстових полів, у яких немає явного bgKey,
				// ми НЕ ставимо null, а повертаємо їх рідний красивий фон (лінію знизу)
				if (view instanceof EditText || view instanceof AutoCompleteTextView) {
					if (view.getBackground() != defaultBackground) {
						view.setBackground(defaultBackground);
					}
				} else {
					view.setBackground(null); // Для звичайних TextView/LinearLayout фон залишається чистим
				}
			}
			
			// Якщо увімкнено дефолтний системний режим для цього в'ю, 
			// пропускаємо подальше фарбування тексту та підказок
			if (useDefaultSystemTheme) {
				return;
			}
			
			// 3. ОБРОБКА ТЕКСТУ, ПІДКАЗОК ТА КОМПОНЕНТІВ ВИБОРУ
			if (view instanceof TextView) {
				TextView tv = (TextView) view;
				int appliedTextColor = 0;
				
				if (view instanceof EditText || view instanceof AutoCompleteTextView) {
					hintKey = "h";
				}
				
				if (textKey != null) {
					int[] tc = skin.getColorsByKey(textKey);
					if (tc != null && tc.length > 0) {
						appliedTextColor = tc[0];
						tv.setTextColor(appliedTextColor);
					}
				}
				
				if (hintKey != null) {
					int[] hc = skin.getColorsByKey(hintKey);
					if (hc != null && hc.length > 0) {
						tv.setHintTextColor(hc[0]);
					}
				}
				
				if (view instanceof CompoundButton && WTF.SDK_INT() >= 21) {
					CompoundButton cb = (CompoundButton) view;
					if (isButtonColorable && appliedTextColor != 0) {
						cb.setButtonTintList(ColorStateList.valueOf(appliedTextColor));
					} else {
						String cbHex = dataHolder.getData("cb");
						int fallbackColor = 0xFF000000;
						if (cbHex != null) {
							try {
								if (!cbHex.startsWith("#")) cbHex = "#" + cbHex;
								fallbackColor = android.graphics.Color.parseColor(cbHex);
							} catch (Exception ignored) {}
						}
						cb.setButtonTintList(ColorStateList.valueOf(fallbackColor));
					}
				}
			}
			
			// 4. ОБРОБКА ПОВЗУНКІВ (SeekBar)
			if (view instanceof SeekBar) {
				SeekBar seekBar = (SeekBar) view;
				int[] tpcColors = skin.getColorsByKey("tpc");
				int[] tcColors = skin.getColorsByKey("tc");
				
				int progressColor = (tpcColors != null && tpcColors.length > 0) ? tpcColors[0] : 0xFF000000;
				int thumbColor = (tcColors != null && tcColors.length > 0) ? tcColors[0] : 0xFF000000;
				
				seekBar.setProgressTintList(ColorStateList.valueOf(progressColor));
				seekBar.setThumbTintList(ColorStateList.valueOf(thumbColor));
			}
		}
	}
}

// =================================================================
// ПУБЛІЧНІ В'Ю-КЛАСИ (Залишилися без змін)
// =================================================================
class SkinTextView extends TextView implements SkinObserver {
	private final SkinViews.SkinViewHelper helper;
	public SkinTextView(Context context) { super(context); helper = new SkinViews.SkinViewHelper(this); }
	public SkinTextView(Context context, AttributeSet attrs) { super(context, attrs); helper = new SkinViews.SkinViewHelper(this, attrs); }
	public void setSkinKey(String key, boolean isSmall) { helper.setSkinKey(key, isSmall); }
	@Override protected void onAttachedToWindow() { super.onAttachedToWindow(); Skin.getInstance().registerObserver(this); }
	@Override protected void onDetachedFromWindow() { Skin.getInstance().unregisterObserver(this); super.onDetachedFromWindow(); }
	@Override public void onSkinChanged() { helper.applySkin(); }
}

class SkinButton extends Button implements SkinObserver {
	private final SkinViews.SkinViewHelper helper;
	public SkinButton(Context context) { super(context); helper = new SkinViews.SkinViewHelper(this); }
	public SkinButton(Context context, AttributeSet attrs) { super(context, attrs); helper = new SkinViews.SkinViewHelper(this, attrs); setPadding(0,0,0,0);}
	public void setSkinKey(String key, boolean isSmall) { helper.setSkinKey(key, isSmall); }
	@Override public void setPressed(boolean pressed) { super.setPressed(pressed); if (helper != null) helper.setPressedState(pressed); }
	@Override protected void onAttachedToWindow() { super.onAttachedToWindow(); Skin.getInstance().registerObserver(this); }
	@Override protected void onDetachedFromWindow() { Skin.getInstance().unregisterObserver(this); super.onDetachedFromWindow(); }
	@Override public void onSkinChanged() { helper.applySkin(); }
}

class SkinEditText extends EditText implements SkinObserver {
	private final SkinViews.SkinViewHelper helper;
	public SkinEditText(Context context) { super(context); helper = new SkinViews.SkinViewHelper(this); }
	public SkinEditText(Context context, AttributeSet attrs) { super(context, attrs); helper = new SkinViews.SkinViewHelper(this, attrs); }
	public void setSkinKey(String key, boolean isSmall) { helper.setSkinKey(key, isSmall); }
	@Override protected void onAttachedToWindow() { super.onAttachedToWindow(); Skin.getInstance().registerObserver(this); }
	@Override protected void onDetachedFromWindow() { Skin.getInstance().unregisterObserver(this); super.onDetachedFromWindow(); }
	@Override public void onSkinChanged() { helper.applySkin(); }
}

class SkinAutoCompleteTextView extends AutoCompleteTextView implements SkinObserver {
	private final SkinViews.SkinViewHelper helper;
	public SkinAutoCompleteTextView(Context context) { super(context); helper = new SkinViews.SkinViewHelper(this); }
	public SkinAutoCompleteTextView(Context context, AttributeSet attrs) { super(context, attrs); helper = new SkinViews.SkinViewHelper(this, attrs); }
	public void setSkinKey(String key, boolean isSmall) { helper.setSkinKey(key, isSmall); }
	@Override protected void onAttachedToWindow() { super.onAttachedToWindow(); Skin.getInstance().registerObserver(this); }
	@Override protected void onDetachedFromWindow() { Skin.getInstance().unregisterObserver(this); super.onDetachedFromWindow(); }
	@Override public void onSkinChanged() { helper.applySkin(); }
}

class SkinLinearLayout extends LinearLayout implements SkinObserver {
	private final SkinViews.SkinViewHelper helper;
	public SkinLinearLayout(Context context) { super(context); helper = new SkinViews.SkinViewHelper(this); }
	public SkinLinearLayout(Context context, AttributeSet attrs) { super(context, attrs); helper = new SkinViews.SkinViewHelper(this, attrs); }
	public void setSkinKey(String key, boolean isSmall) { helper.setSkinKey(key, isSmall); }
	@Override protected void onAttachedToWindow() { super.onAttachedToWindow(); Skin.getInstance().registerObserver(this); }
	@Override protected void onDetachedFromWindow() { Skin.getInstance().unregisterObserver(this); super.onDetachedFromWindow(); }
	@Override public void onSkinChanged() { helper.applySkin(); }
}

class SkinFrameLayout extends FrameLayout implements SkinObserver {
	private final SkinViews.SkinViewHelper helper;
	public SkinFrameLayout(Context context) { super(context); helper = new SkinViews.SkinViewHelper(this); }
	public SkinFrameLayout(Context context, AttributeSet attrs) { super(context, attrs); helper = new SkinViews.SkinViewHelper(this, attrs); }
	public void setSkinKey(String key, boolean isSmall) { helper.setSkinKey(key, isSmall); }
	@Override protected void onAttachedToWindow() { super.onAttachedToWindow(); Skin.getInstance().registerObserver(this); }
	@Override protected void onDetachedFromWindow() { Skin.getInstance().unregisterObserver(this); super.onDetachedFromWindow(); }
	@Override public void onSkinChanged() { helper.applySkin(); }
}

class SkinCheckBox extends CheckBox implements SkinObserver {
	private final SkinViews.SkinViewHelper helper;
	public SkinCheckBox(Context context) { super(context); helper = new SkinViews.SkinViewHelper(this); }
	public SkinCheckBox(Context context, AttributeSet attrs) { super(context, attrs); helper = new SkinViews.SkinViewHelper(this, attrs); }
	public void setSkinKey(String key, boolean isSmall) { helper.setSkinKey(key, isSmall); }
	@Override protected void onAttachedToWindow() { super.onAttachedToWindow(); Skin.getInstance().registerObserver(this); }
	@Override protected void onDetachedFromWindow() { Skin.getInstance().unregisterObserver(this); super.onDetachedFromWindow(); }
	@Override public void onSkinChanged() { helper.applySkin(); }
}

class SkinRadioButton extends RadioButton implements SkinObserver {
	private final SkinViews.SkinViewHelper helper;
	public SkinRadioButton(Context context) { super(context); helper = new SkinViews.SkinViewHelper(this); }
	public SkinRadioButton(Context context, AttributeSet attrs) { super(context, attrs); helper = new SkinViews.SkinViewHelper(this, attrs); }
	public void setSkinKey(String key, boolean isSmall) { helper.setSkinKey(key, isSmall); }
	@Override protected void onAttachedToWindow() { super.onAttachedToWindow(); Skin.getInstance().registerObserver(this); }
	@Override protected void onDetachedFromWindow() { Skin.getInstance().unregisterObserver(this); super.onDetachedFromWindow(); }
	@Override public void onSkinChanged() { helper.applySkin(); }
}

class SkinSeekBar extends SeekBar implements SkinObserver {
	private final SkinViews.SkinViewHelper helper;
	public SkinSeekBar(Context context) { super(context); helper = new SkinViews.SkinViewHelper(this); }
	public SkinSeekBar(Context context, AttributeSet attrs) { super(context, attrs); helper = new SkinViews.SkinViewHelper(this, attrs); }
	public void setSkinKey(String key, boolean isSmall) { helper.setSkinKey(key, isSmall); }
	@Override protected void onAttachedToWindow() { super.onAttachedToWindow(); Skin.getInstance().registerObserver(this); }
	@Override protected void onDetachedFromWindow() { Skin.getInstance().unregisterObserver(this); super.onDetachedFromWindow(); }
	@Override public void onSkinChanged() { helper.applySkin(); }
}