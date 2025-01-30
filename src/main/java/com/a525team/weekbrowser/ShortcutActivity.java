package com.a525team.weekbrowser;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.SharedPreferences;
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
	
	private SharedPreferences sf;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.shortcut);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		ThemeManager.applyTheme(this); // Встановлення теми
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
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		
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
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		SafeMarginUtils.init(this, findViewById(android.R.id.content));
		name.setText(getIntent().getStringExtra("name"));
		url.setText(getIntent().getStringExtra("url"));
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
					
		if (sf.getString("monoforta", "").equals("1")) {
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
	
}