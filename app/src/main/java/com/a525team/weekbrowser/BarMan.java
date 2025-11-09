package com.a525team.weekbrowser;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.app.AlertDialog;
import android.widget.ArrayAdapter;
import android.view.Window;
import android.view.WindowManager;

public class BarMan {
	private LinearLayout layout;
	private SharedPreferences sf;
	private Activity activity;
	private int tabsCount = 0;
	private ExtendedDataHolder DataHolder;
	private int btnNum = 0;
	private Skin skin = new Skin();
	// Єдина структура даних для всіх дій
	private final ArrayList<HashMap<String, Object>> ACTION_CONFIGS = new ArrayList<>();
	
	private void initActionConfigs() {
		// Ініціалізація всіх доступних дій з локалізованими назвами
		addAction(-990, R.string.donothing, "|");
		addAction(-991, R.string.divider2, "|");
		addAction(-1, R.string.bmkbtn, "");
		addAction(-2, R.string.searchonpagebtn, "A");
		addAction(-3, R.string.exit, "");
		addAction(-4, R.string.historybtn, "");
		addAction(-5, R.string.tabs, "[?tabs?]");
		addAction(-6, R.string.multiwindow, "");
		addAction(-7, R.string.positionbtn, "");
		addAction(-8, R.string.closetabbtn, "");
		addAction(-10, R.string.newtabbtn, "");
		addAction(-11, R.string.background_tab, "");
		
		addAction(1, R.string.backbtn, "");
		addAction(2, R.string.forwardbtn, "");
		addAction(3, R.string.homebtn, "");
		addAction(4, R.string.endbtn, "");
		addAction(5, R.string.reloadbtn, "");
		addAction(10, R.string.download_page, "");
		addAction(13, R.string.home, "");
		addAction(14, R.string.skipvidbtn, "");
		addAction(30, R.string.find_on_site, "s");
		addAction(31, R.string.previous_found, "");
		addAction(32, R.string.next_found, "");
		addAction(200, R.string.previous_tab, "[]");
		addAction(201, R.string.next_tab, "[]");
		addAction(301, R.string.save_position_1, "1");
		addAction(302, R.string.save_position_2, "2");
		addAction(303, R.string.save_position_3, "3");
		addAction(401, R.string.load_position_1, "1");
		addAction(402, R.string.load_position_2, "2");
		addAction(403, R.string.load_position_3, "3");
		addAction(1998, R.string.allow_image_download_once, "1");
		addAction(2000, R.string.save_site_mht, "");
		addAction(100001, R.string.back_or_close, "");
	}
	
	private void addAction(int code, int nameResId, String icon) {
		HashMap<String, Object> action = new HashMap<>();
		action.put("code", code);
		action.put("nameResId", nameResId);
		action.put("icon", icon);
		ACTION_CONFIGS.add(action);
	}
	
	public String getActionName(int code) {
		for (HashMap<String, Object> action : ACTION_CONFIGS) {
			if ((int)action.get("code") == code) {
				int resId = (int) action.get("nameResId");
				return activity.getString(resId);
			}
		}
		return "???";
	}
	
	// Додано масив для зберігання конфігурацій кнопок
	private ArrayList<HashMap<String, Object>> buttonConfigs = new ArrayList<>();
	
	public BarMan(LinearLayout layout, Activity activity) {
		this.layout = layout;
		this.activity = activity;
		DataHolder = ExtendedDataHolder.getInstance();
		this.sf = activity.getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		// ДОДАЙ ЦЕЙ РЯДОК:
		initActionConfigs();
		
		init();
	}
	
	public void init() {
		btnNum = 0;
		layout.removeAllViews();
		String config = sf.getString("toolbar", "");
		
		buttonConfigs = sfToArray(config);
		for (HashMap<String, Object> buttonConfig : buttonConfigs) {
			addButtonToLayout(buttonConfig);
		}
	}
	
	public ArrayList<HashMap<String, Object>> sfToArray(String config) {
		ArrayList<HashMap<String, Object>> result = new ArrayList<>();
		if (config.isEmpty()) return result;
		
		String[] buttons = config.split("%");
		
		for (String btn : buttons) {
			if (btn.isEmpty()) continue;
			String[] parts = btn.split("&");
			HashMap<String, Object> map = new HashMap<>();
			
			if (parts.length > 0) map.put("click", parts[0]);
			if (parts.length > 1) map.put("long", parts[1]);
			if (parts.length > 2) map.put("icon", parts[2]);
			if (parts.length > 3) map.put("clickarg", parts[3]);
			if (parts.length > 4) map.put("longarg", parts[4]);
			
			result.add(map);
		}
		return result;
	}
	
	public String arrayToSf(ArrayList<HashMap<String, Object>> list) {
		StringBuilder result = new StringBuilder("");
		for (int i = 0; i < list.size(); i++) {
			if (i > 0) result.append("%");
			HashMap<String, Object> btn = list.get(i);
			result.append(btn.get("click")).append("&")
			.append(btn.get("long")).append("&")
			.append(btn.get("icon")).append("&")
			.append(btn.get("clickarg") != null ? btn.get("clickarg") : "").append("&")
			.append(btn.get("longarg") != null ? btn.get("longarg") : "");
		}
		return result.toString();
	}
	
	private void addButtonToLayout(HashMap<String, Object> config) {
		float baseSizeDp = Float.parseFloat(sf.getString("button", "40"));
		float density = activity.getResources().getDisplayMetrics().density;
		
		try{
			Button button = new Button(activity);
			boolean isdiv = "-991".equals(config.get("click"));
			setupButtonAppearance(button, isdiv, btnNum);
			
			// Обробка іконки з заміною ?tabs?
			String icon = (String) config.get("icon");
			icon = icon == null ? "" : icon;
			// Заміна ?tabs? на кількість вкладок
			if (icon != null && icon.contains("?tabs?")) {
				icon = icon.replace("?tabs?", String.valueOf(tabsCount));
			}
			
			icon += (config.get("long").equals("-990") ||
			sf.getString("toolbardot", "1").equals("0"))?"":"•";
			/*icon = String.valueOf(btnNum) + icon +
			(activity instanceof BarsActivity ?
			String.valueOf(((BarsActivity) activity)._getBtnNum())
			: "");*/
			button.setText(icon);
			
			// Зберігаємо індекс кнопки в тег
			button.setTag(btnNum);
			
			// Параметри розміщення
			LinearLayout.LayoutParams lp;
			int width = 0;
			
			// Фіксовані розміри
			width = (int) (baseSizeDp * density * 1.27f);
			if(isdiv)width /= 2;
			
			int height = (int) (baseSizeDp * density);
			lp = new LinearLayout.LayoutParams(width, height, 0f);
			
			lp.gravity = Gravity.CENTER;
			button.setLayoutParams(lp);
			
			Typeface typeface = Typeface.createFromAsset(activity.getAssets(), "fonts/icons.ttf");
			button.setTypeface(typeface);
			
			// Обробник кліку - передаємо коректний індекс
			final int currentBtnIndex = btnNum;
			button.setOnClickListener(v -> handleClick(
			(String) config.get("click"),
			(String) config.get("clickarg"),
			(String) config.get("icon"),
			currentBtnIndex  // Додаємо індекс кнопки
			));
			
			// Обробник довгого кліку
			button.setOnLongClickListener(v -> {
				String longClick = (String) config.get("long");
				String longArg = (String) config.get("longarg");
				if ("-990".equals(longClick)) {
					showTooltip((String) config.get("click"));
					return true;
				}
				handleClick(longClick, longArg, (String) config.get("icon"), currentBtnIndex);
				return true;
			});
			
			layout.addView(button);
		}catch(Exception e){
			Button button = new Button(activity);
			setupButtonAppearance(button, false, btnNum);
			button.setText(e.toString());
			int height = (int) (baseSizeDp * density);
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, height, 0f);
			layout.addView(button);
		}
		btnNum++;
	}
	
	private void setupButtonAppearance(Button button, boolean invis, int buttonIndex) {
		float baseSizeDp = Float.parseFloat(sf.getString("button", "40"));
		float density = activity.getResources().getDisplayMetrics().density;
		
		/*ViewGroup.LayoutParams lp = button.getLayoutParams();
		if (lp == null) {
		lp = new LinearLayout.LayoutParams(
		(int) (baseSizeDp * density * 1.27f),
		(int) (baseSizeDp * density)
		);
		} else {
		lp.width = (int) (baseSizeDp * density * 1.27f);
		lp.height = (int) (baseSizeDp * density);
		}
		button.setLayoutParams(lp);*/
		
		button.setTextSize(baseSizeDp / 2.5f);
		button.setGravity(Gravity.CENTER);
		button.setPadding(0, 0, 0, 0);
		
		// Виправлено: порівнюємо з правильним індексом
		if (activity instanceof BarsActivity &&
		((BarsActivity) activity)._getBtnNum() == buttonIndex){
			skin.setBG(button, 1, true);
			button.setTextColor((int) Long.parseLong(
			DataHolder.getData("rbt"), 16
			));
		}else{
			setColor(button, invis, skin);
		}
	}
	
	private void setColor(Button button, boolean invis, Skin skin){
		if(invis){button.setBackgroundColor(0x00000000);
			button.setTextColor((int) Long.parseLong(
			DataHolder.getData("h"), 16
			));
		}else{
			skin.setBG(button, 0, true);
			button.setTextColor((int) Long.parseLong(
			DataHolder.getData("bt"), 16
			));
		}
	}
	
	// Додано параметр buttonIndex
	private void handleClick(String actionCode, String argument, String icon, int buttonIndex) {
		
		// Обробка спеціальних кодів
		if ("?tabs?".equals(icon)) {
			actionCode = String.valueOf(tabsCount);
		}
		
		if (activity instanceof MainActivity) {
			if (actionCode == null || "-990".equals(actionCode)) return;
			((MainActivity) activity)._webViewActions(
			Integer.parseInt(actionCode),
			argument != null ? argument : ""
			);
		} else if (activity instanceof BarsActivity){
			// Виправлено: передаємо коректний індекс кнопки
			((BarsActivity) activity)._setBtnNum(buttonIndex);
			// Оновлюємо зовнішній вигляд всіх кнопок
			updateButtonsAppearance();
		}
	}
	
	// Новий метод для оновлення вигляду всіх кнопок
	private void updateButtonsAppearance() {
		for (int i = 0; i < layout.getChildCount(); i++) {
			View child = layout.getChildAt(i);
			if (child instanceof Button) {
				Button button = (Button) child;
				Integer buttonIndex = (Integer) button.getTag();
				if (buttonIndex != null) {
					boolean isdiv = "-991".equals(buttonConfigs.get(buttonIndex).get("click"));
					setupButtonAppearance(button, isdiv, buttonIndex);
				}
			}
		}
	}
	
	private void showTooltip(String actionCode) {
		String tooltip = getTooltip(actionCode);
		if (tooltip != null) {
			Toast.makeText(activity, tooltip, Toast.LENGTH_SHORT).show();
		}
	}
	
	private String getTooltip(String actionCode) {
		try {
			int code = Integer.parseInt(actionCode);
			return getActionName(code);
		} catch (Exception e) {
			return null;
		}
	}
	
	public void updateTabs(int count) {
		try{
			this.tabsCount = count;
			// Оновлення всіх кнопок, що містять ?tabs?
			for (int i = 0; i < layout.getChildCount(); i++) {
				View child = layout.getChildAt(i);
				if (child instanceof Button) {
					Button btn = (Button) child;
					String tag = btn.getTag().toString();
					if(tag != null && !tag.isEmpty()){
						String currentText = buttonConfigs.get(Integer.parseInt(tag)).get("icon").toString();
						String longC = buttonConfigs.get(Integer.parseInt(tag)).get("long").toString();
						// Заміна ?tabs? на кількість вкладок у всьому тексті
						if (currentText.contains("?tabs?")) {
							String newText = currentText.replace("?tabs?", String.valueOf(count));
							newText += (longC.equals("-990") ||
							sf.getString("toolbardot", "1").equals("0"))?"":"•";
							btn.setText(newText);
						}
					}
				}
			}
		}catch(Exception e){}
	}
	
	// Діалог вибору дій
	public void showActionSelectionDialog(Activity activity, final ActionSelectionCallback callback) {
		if (activity == null || (activity instanceof Activity && 
		((Activity) activity).isFinishing())) {
			return;
		}
		
		RenderUtils ru = new RenderUtils(activity);
		ArrayList<String> actionNames = new ArrayList<>();
		final ArrayList<Integer> actionCodes = new ArrayList<>();
		
		for (HashMap<String, Object> action : ACTION_CONFIGS) {
			int resId = (int) action.get("nameResId");
			actionNames.add(activity.getString(resId));
			actionCodes.add((Integer) action.get("code"));
		}
		
		AlertDialog.Builder builder = new AlertDialog.Builder(activity);
		builder.setTitle(activity.getString(R.string.select_action));
		builder.setAdapter(new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1, actionNames), 
		(dialog, which) -> {
			if (callback != null) {
				callback.onActionSelected(actionCodes.get(which));
			}
		});
		builder.setNegativeButton(activity.getString(R.string.cancel), null);
		
		try {
			AlertDialog dialog = builder.create();
			// Додаткова перевірка перед показом
			if (!((Activity) activity).isFinishing()) {
				dialog.setOnDismissListener(d -> {
					ru.off();
				});
				
				dialog.setOnShowListener(d -> {
					Window window = dialog.getWindow();
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
				
				dialog.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Інтерфейс для повернення результату вибору
	public interface ActionSelectionCallback {
		void onActionSelected(int actionCode);
	}
	
	// Метод рекомендації іконок
	public String iconRecom(int code) {
		for (HashMap<String, Object> action : ACTION_CONFIGS) {
			if ((int)action.get("code") == code) {
				return (String) action.get("icon");
			}
		}
		return "?";
	}
	
	public String hint(int code) {
		for (HashMap<String, Object> action : ACTION_CONFIGS) {
			if ((int)action.get("code") == code) {
				int resId = (int) action.get("nameResId");
				return activity.getString(resId); // Повертає локалізовану назву
			}
		}
		return "???";
	}
	
	// Метод для отримання всіх конфігурацій дій
	public ArrayList<HashMap<String, Object>> getActionConfigs() {
		return ACTION_CONFIGS;
	}
}
