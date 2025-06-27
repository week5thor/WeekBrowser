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
import android.content.pm.PackageManager;

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
		ThemeManager.applyTheme(this);
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.grant);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
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
				i = getPackageManager().getLaunchIntentForPackage(getPackageName());
				if (i != null) {
					 startActivity(i);
				}
				finish();
			}
		});
		
		storage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
					    // Android 11+ — перевіряємо MANAGE_EXTERNAL_STORAGE
					    try {
						        if (!Environment.isExternalStorageManager()) {
							            Intent i = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
							            i.setData(Uri.parse("package:" + getPackageName()));
							            startActivity(i);
							        }
						    } catch (Throwable t) {
						        // Запасний варіант, якщо щось піде не так
						        Intent i = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
						        startActivity(i);
						    }
				} else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
					    // Android 6–10 — перевірка WRITE_EXTERNAL_STORAGE
					    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED ||
					        checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
						        
						        requestPermissions(new String[] {
							            Manifest.permission.WRITE_EXTERNAL_STORAGE,
							            Manifest.permission.READ_EXTERNAL_STORAGE
							        }, 1000);
						    }
				} else {
					    // Android до 6.0 — дозволи видаються автоматично при встановленні
					    // Нічого не робимо
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
				} else {
					
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
				} else {
					
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
		if (sf.contains("lang")) {
			
		} else {
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
		ThemeManager.setSpinner(GrantActivity.this, languages, lang);
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						int color = 0xFFFFFFFF; // default: білий
						
						if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
							    try {
								        if (Environment.isExternalStorageManager()) {
									            color = 0xFF00FF00;
									        }
								    } catch (Throwable ignored) {}
						} else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
							    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
								        color = 0xFF00FF00;
								    }
						} else {
							    color = 0xFF00FF00;
						}
						
						storage.setTextColor(color);
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
							} else {
								overlay.setTextColor(0xFFFFFFFF);
							}
							if (checkSelfPermission(android.Manifest.permission.RECORD_AUDIO) == android.content.pm.PackageManager.PERMISSION_DENIED) {
								mic.setTextColor(0xFFFFFFFF);
							} else {
								mic.setTextColor(0xFF00FF00);
							}
							if (checkSelfPermission(android.Manifest.permission.CAMERA) == android.content.pm.PackageManager.PERMISSION_DENIED) {
								camera.setTextColor(0xFFFFFFFF);
							} else {
								camera.setTextColor(0xFF00FF00);
							}
							if (checkSelfPermission(android.Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS) == android.content.pm.PackageManager.PERMISSION_DENIED) {
								ignorebat.setTextColor(0xFFFFFFFF);
							} else {
								ignorebat.setTextColor(0xFF00FF00);
							}
						} else {
							overlay.setTextColor(0xFF00FF00);
							mic.setTextColor(0xFF00FF00);
							camera.setTextColor(0xFF00FF00);
							ignorebat.setTextColor(0xFF00FF00);
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
	
	
	@Override
	public void onResume() {
		super.onResume();
		SafeMarginUtils.init(this, linear1);
	}
	
	@Override
	public void onPause() {
		super.onPause();
		SafeMarginUtils.cleanup();
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