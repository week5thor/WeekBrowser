package com.a525team.weekbrowser;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.regex.*;
import org.json.*;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
//import java.util.Arrays;

public class ShortcutActivity extends Activity {
	
	ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	
	private ArrayList<String> languag = new ArrayList<>();
	
	private LinearLayout linear1;
	private Button add;
	private TextView nam;
	private EditText name;
	private TextView ur;
	private EditText url;
	private LinearLayout linear2;
	private Button inslink;
	private Button insmlink;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.shortcut);
		initialize(_savedInstanceState);
		
		if (Build.VERSION.SDK_INT >= 23) {
			if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
				requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
			} else {
				initializeLogic();
			}
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		int themeValue = Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt"));
		
		        switch (themeValue) {
				            case 0:
				                setTheme(android.R.style.Theme_Material_Light);
				                break;
				            case 1:
				                setTheme(android.R.style.Theme_Material);
				                break;
				            case 2:
				                setTheme(android.R.style.Theme_Light);
				                break;
				            case 3:
				                
				        String styleValue = FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/style.txt");
				
				        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
						            setTheme(android.R.style.Theme_Black);
						        } else {
						            switch (styleValue) {
								                case "1":
								                    setTheme(android.R.style.Theme_Black);
								                    break;
								                case "2":
								                    setTheme(android.R.style.Theme_Light);
								                    break;
								                case "3":
								                    setTheme(android.R.style.Theme_Holo);
								                    break;
								                case "4":
								                    setTheme(android.R.style.Theme_Holo_Light);
								                    break;
								                case "5":
								                    setTheme(android.R.style.Theme_Material);
								                    break;
								                case "6":
								                    setTheme(android.R.style.Theme_Material_Light);
								                    break;
								                default:
								                    setTheme(android.R.style.Theme_Light);
								                    break;
								            }
						        }
				                
				                break;
				            case 4:
				                setTheme(android.R.style.Theme_Material_Light);
				                break;
				            case 5:
				                setTheme(android.R.style.Theme_Material);
				                break;
				            case 6:
				                setTheme(android.R.style.Theme_Holo_Light);
				                break;
				            case 7:
				                setTheme(android.R.style.Theme_Holo);
				                break;
				            case 8:
				                setTheme(android.R.style.Theme_Material_Light);
				                break;
				            case 9:
				                setTheme(android.R.style.Theme_Material);
				                break;
				            case 10:
				                setTheme(android.R.style.Theme_Material);
				                break;
				                case 11:
				                setTheme(android.R.style.Theme_Light);
				                break;
				                case 12:
				                setTheme(android.R.style.Theme_Light);
				                break;
				
				            default:
				                setTheme(android.R.style.Theme_Light);
				                break;
				        }
		
		        super.onCreate(_savedInstanceState);
		        setContentView(R.layout.shortcut);
		linear1 = findViewById(R.id.linear1);
		add = findViewById(R.id.add);
		nam = findViewById(R.id.nam);
		name = findViewById(R.id.name);
		ur = findViewById(R.id.ur);
		url = findViewById(R.id.url);
		linear2 = findViewById(R.id.linear2);
		inslink = findViewById(R.id.inslink);
		insmlink = findViewById(R.id.insmlink);
		
		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
					            // Додавання ярлика для Android 8.0 і вище
					            ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
					            if (shortcutManager != null) {
						                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url.getText().toString()));
						               intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						ShortcutInfo shortcut = new ShortcutInfo.Builder(getApplicationContext(), url.getText().toString())
						                        .setIntent(intent)
						                        .setShortLabel(name.getText().toString())
						                        .setIcon(Icon.createWithResource(getApplicationContext(), R.drawable.app_icon))
						                        .build();
						                shortcutManager.requestPinShortcut(shortcut, null);
						                
						try{
								SketchwareUtil.showMessage(getApplicationContext(), languag.get((int)(152)));
						}catch(Exception e){
								if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
										SketchwareUtil.showMessage(getApplicationContext(), "Added");
								}
								else {
										SketchwareUtil.showMessage(getApplicationContext(), "Додано");
								}
						}
						            }
					        } else {
					            // Додавання ярлика для Android версій нижче 8.0
					            Intent shortcutIntent = new Intent();
					            shortcutIntent.putExtra(Intent.EXTRA_TEXT, url.getText().toString());
					            shortcutIntent.setAction(Intent.ACTION_VIEW);
					
					            Intent addIntent = new Intent();
					            addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
					            addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, name.getText().toString());
					            addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
					                    Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.drawable.app_icon));
					            addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
					            sendBroadcast(addIntent);
					            try{
							SketchwareUtil.showMessage(getApplicationContext(), languag.get((int)(152)));
					}catch(Exception e){
							if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
									SketchwareUtil.showMessage(getApplicationContext(), "Added");
							}
							else {
									SketchwareUtil.showMessage(getApplicationContext(), "Додано");
							}
						        }}
			}
		});
		
		inslink.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				url.setText(getIntent().getStringExtra("url"));
			}
		});
		
		insmlink.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				url.setText(dataHolder.getData("ml"));
			}
		});
	}
	
	private void initializeLogic() {
		name.setText(getIntent().getStringExtra("name"));
		url.setText(getIntent().getStringExtra("url"));
		if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
			languag = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Language.welang"), new TypeToken<ArrayList<String>>(){}.getType());
		}
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		
		
		
		
		// Застосування фону з кольором "bg" через метод setBG
		Skin skin = new Skin();
		
		skin.setBG(linear1, 2, false); // Застосування кольору "bg" до linear1
		
		// Застосування градієнтного фону до інших елементів
		skin.setBG(add, 0, false);       // add
		skin.setBG(inslink, 0, false);   // inslink
		skin.setBG(insmlink, 0, false);  // insmlink
		
		
			name.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
					name.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		url.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
					url.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		nam.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		ur.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		add.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		inslink.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		insmlink.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
					
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/monofortextarea.txt").equals("1")) {
			name.setTypeface(Typeface.MONOSPACE);
			url.setTypeface(Typeface.MONOSPACE);
		}
		else {
			name.setTypeface(Typeface.DEFAULT);
			url.setTypeface(Typeface.DEFAULT);
		}
	}
	
	public void _extra() {
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
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}