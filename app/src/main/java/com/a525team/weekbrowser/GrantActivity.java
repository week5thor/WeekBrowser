package com.a525team.weekbrowser;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import android.Manifest;
import android.provider.Settings;

public class GrantActivity extends Activity {
	
	private Timer _timer = new Timer();
	
	private String prevLang = "";
	private String language = "";
	
	private ArrayList<String> languages = new ArrayList<>();
	
	private LinearLayout linear1;
	private Spinner lang;
	private Button done;
	private TextView name;
	private TextView hint;
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private TextView storage;
	private TextView location;
	private TextView overlay;
	private TextView mic;
	private TextView camera;
	private TextView ignorebat;
	
	private TimerTask t;
	private Intent i = new Intent();
	private SharedPreferences sf;
	private AlertDialog.Builder restart;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.grant);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		setTheme(android.R.style.Theme_Holo);
		super.onCreate(_savedInstanceState);
		
		        setContentView(R.layout.grant);
		linear1 = findViewById(R.id.linear1);
		lang = findViewById(R.id.lang);
		done = findViewById(R.id.done);
		name = findViewById(R.id.name);
		hint = findViewById(R.id.hint);
		vscroll1 = findViewById(R.id.vscroll1);
		linear2 = findViewById(R.id.linear2);
		storage = findViewById(R.id.storage);
		location = findViewById(R.id.location);
		overlay = findViewById(R.id.overlay);
		mic = findViewById(R.id.mic);
		camera = findViewById(R.id.camera);
		ignorebat = findViewById(R.id.ignorebat);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		restart = new AlertDialog.Builder(this);
		
		lang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				language = languages.get((int)(_position)).substring((int)(0), (int)(2));
				if (!prevLang.isEmpty() && !language.equals(prevLang)) {
					sf.edit().putString("lang", language).commit();
					Intent intent = getIntent();
					    
					    finishAffinity();
					    
					    startActivity(intent);
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		done.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), MainActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		storage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R || Environment.isExternalStorageManager()) {
					if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M || !(checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED)) {
						
					}
					else {
						requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
						requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
					}
				}
				else {
					i.setAction("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
					i.setData(Uri.parse("package:" + getPackageName()));
					
					startActivity(i);
				}
			}
		});
		
		location.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
			}
		});
		
		overlay.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
					            startActivityForResult(intent, 1001);}
			}
		});
		
		mic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
					if (checkSelfPermission(android.Manifest.permission.RECORD_AUDIO) == android.content.pm.PackageManager.PERMISSION_DENIED) {
						requestPermissions(new String[] {android.Manifest.permission.RECORD_AUDIO}, 1000);
					}
				}
				else {
					
				}
			}
		});
		
		camera.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
					if (checkSelfPermission(android.Manifest.permission.CAMERA) == android.content.pm.PackageManager.PERMISSION_DENIED) {
						requestPermissions(new String[] {android.Manifest.permission.CAMERA}, 1000);
					}
				}
				else {
					
				}
			}
		});
		
		ignorebat.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { // Перевірка для Android 6.0 і вище
					    Intent intent = new Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
					    intent.setData(Uri.parse("package:" + getPackageName()));
					    startActivity(intent);
				}
				
			}
		});
	}
	
	private void initializeLogic() {
		SafeMarginUtils.init(this, findViewById(android.R.id.content));
		
		if (sf.contains("lang")) {
			
		}
		else {
			sf.edit().putString("lang", LocaleHelper.getCurrentLanguage(getApplicationContext())).commit();
			Intent intent = getIntent();
			    
			    finishAffinity();
			    
			    startActivity(intent);
		}
		prevLang = sf.getString("lang", "");
		language = sf.getString("lang", "");
		languages.add("en English");
		languages.add("ru Русский");
		languages.add("uk Українська");
		lang.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, languages));
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
							if (Environment.isExternalStorageManager()) {
								storage.setTextColor(0xFF00FF00);
							}
							else {
								storage.setTextColor(0xFFFFFFFF);
							}
						}
						else {
							if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
								if (Build.VERSION.SDK_INT >= 23) {
												if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED) {
														storage.setTextColor(0xFFFFFFFF);
												}
												else {
										storage.setTextColor(0xFF00FF00);
												}
										}
										else {
									storage.setTextColor(0xFF00FF00);
										}
							}
							else {
								storage.setTextColor(0xFF00FF00);
							}
						}
						if (Build.VERSION.SDK_INT >= 23) {
										if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) == android.content.pm.PackageManager.PERMISSION_DENIED) {
												location.setTextColor(0xFFFFFFFF);
										}
										else {
								location.setTextColor(0xFF00FF00);
										}
								}
								else {
							location.setTextColor(0xFF00FF00);
								}
						if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
							if (checkOverlayPermission()) {
								overlay.setTextColor(0xFF00FF00);
							}
							else {
								overlay.setTextColor(0xFFFFFFFF);
							}
							if (checkSelfPermission(android.Manifest.permission.RECORD_AUDIO) == android.content.pm.PackageManager.PERMISSION_DENIED) {
								mic.setTextColor(0xFFFFFFFF);
							}
							else {
								mic.setTextColor(0xFF00FF00);
							}
							if (checkSelfPermission(android.Manifest.permission.CAMERA) == android.content.pm.PackageManager.PERMISSION_DENIED) {
								camera.setTextColor(0xFFFFFFFF);
							}
							else {
								camera.setTextColor(0xFF00FF00);
							}
							if (checkSelfPermission(android.Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS) == android.content.pm.PackageManager.PERMISSION_DENIED) {
								ignorebat.setTextColor(0xFFFFFFFF);
							}
							else {
								ignorebat.setTextColor(0xFF00FF00);
							}
						}
						else {
							overlay.setTextColor(0xFF00FF00);
							mic.setTextColor(0xFF00FF00);
							camera.setTextColor(0xFF00FF00);
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t, (int)(0), (int)(300));
		switch(language) {
			case "en": {
				lang.setSelection((int)(0));
				break;
			}
			case "ru": {
				lang.setSelection((int)(1));
				break;
			}
			case "uk": {
				lang.setSelection((int)(2));
				break;
			}
		}
	}
	
	public void _extra() {
	}
	public boolean checkOverlayPermission() {
		        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			            return Settings.canDrawOverlays(this);
			        }
		        return true;
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