package com.a525team.weekbrowser;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.a525team.weekbrowser.SkinTextView;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.regex.*;
import org.json.*;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
//import java.util.Arrays;
import android.graphics.Bitmap;
import java.net.URL;

public class UtilsActivity extends Activity {
	
	private ArrayList<String> utilList = new ArrayList<>();
	
	private LinearLayout linear2;
	private SkinTextView textview2;
	private SkinTextView textview3;
	private LinearLayout linear1;
	private ListView listview1;
	
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		ThemeManager.applyTheme(this);
		setContentView(R.layout.utils);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear2 = findViewById(R.id.linear2);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		linear1 = findViewById(R.id.linear1);
		listview1 = findViewById(R.id.listview1);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				switch((int)_position) {
					case ((int)0): {
						ColorPickerDialog colorPickerDialog = new ColorPickerDialog(UtilsActivity.this);
						
						colorPickerDialog.setColorPickerListener(new ColorPickerDialog.ColorPickerListener() {
							@Override
							public void onColorPicked(String colorHex) {
								try{
									colorPickerDialog.show(colorHex); 
								}catch(Exception e){colorPickerDialog.show("ff000000");}
							}
							
							@Override
							public void onCancel() {
							}
						});
						
						// Перший запуск
						colorPickerDialog.show("ff000000");
						break;
					}
					case ((int)1): {
						intent.setClass(getApplicationContext(), TextActivity.class);
						startActivity(intent);
						finish();
						break;
					}
				}
			}
		});
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				try{
					String targetUrl;
					String targetName;
					int iconResId;
					
					switch (_position) {
						case 0:
						targetUrl = "https://colorpicker.weekbrowser.com";
						targetName = getString(R.string.colorpicker);
						iconResId = R.mipmap.colpick;
						break;
						case 1:
						targetUrl = "https://texteditor.weekbrowser.com";
						targetName = getString(R.string.texteditor);
						iconResId = R.mipmap.text;
						break;
						default:
						targetUrl = "about:blank";
						targetName = "Unnamed";
						iconResId = R.mipmap.ic_launcher;
						break;
					}
					
					Bitmap bmp = BitmapFactory.decodeResource(getResources(), iconResId);
					
					// Створюємо інтент і прив'язуємо його суто до нашого пакету
					Intent shortcutIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(targetUrl));
					shortcutIntent.setPackage(getPackageName()); // ТАКЕ ОБМЕЖЕННЯ
					shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
					
					if (WTF.SDK_INT() >= Build.VERSION_CODES.O) {
						ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
						if (shortcutManager != null && shortcutManager.isRequestPinShortcutSupported()) {
							
							ShortcutInfo shortcut = new ShortcutInfo.Builder(getApplicationContext(), targetUrl)
							.setIntent(shortcutIntent) // Передаємо наш обмежений інтент
							.setShortLabel(targetName)
							.setIcon(Icon.createWithBitmap(bmp))
							.build();
							
							shortcutManager.requestPinShortcut(shortcut, null);
							SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.added));
						}
					} else {
						// Для старіших Android
						Intent addIntent = new Intent();
						addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent); // Передаємо наш обмежений інтент
						addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, targetName);
						addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON, bmp);
						addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
						
						sendBroadcast(addIntent);
						SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.added));
					}
				}catch(Exception e){
					SketchwareUtil.showMessage(getApplicationContext(), e.toString());
				}
				return true;
			}
		});
	}
	
	private void initializeLogic() {
		utilList.add(getString(R.string.colorpicker));
		utilList.add(getString(R.string.texteditor));
		ThemeManager.setList(UtilsActivity.this, utilList, listview1);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		SafeMarginUtils.init(this, linear2);
		
		Skin.getInstance().setStaticBG(this, 2, false);
	}
	
	@Override
	public void onPause() {
		super.onPause();
		SafeMarginUtils.cleanup();
	}
	
	public void _Languag() {
	}
	
	@Override
	protected void attachBaseContext(Context newBase) {
		if (newBase != null) {
			SharedPreferences sf = newBase.getSharedPreferences("sf", Context.MODE_PRIVATE);
			String languageCode = sf.getString("lang", "en");
			Context context = LocaleHelper.setLocale(newBase, languageCode);
			super.attachBaseContext(context);
		} else {
			super.attachBaseContext(newBase);
		}
	}
	
	{
	}
	
}