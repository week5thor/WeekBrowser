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
	private TextView storage;
	private TextView location;
	private TextView overlay;
	
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
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R || Environment.isExternalStorageManager()) {
				if (Build.VERSION.SDK_INT >= 23) {
									if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED) {
												setTheme(android.R.style.Theme_Holo);
								super.onCreate(_savedInstanceState);
								
								        setContentView(R.layout.grant);
									}
									else {
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
								
								        setContentView(R.layout.grant);
									}
						}
						else {
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
						
						        setContentView(R.layout.grant);
						}
		}
		else {
				setTheme(android.R.style.Theme_Holo);
				super.onCreate(_savedInstanceState);
				
				        setContentView(R.layout.grant);
		}
		linear1 = findViewById(R.id.linear1);
		lang = findViewById(R.id.lang);
		done = findViewById(R.id.done);
		name = findViewById(R.id.name);
		hint = findViewById(R.id.hint);
		storage = findViewById(R.id.storage);
		location = findViewById(R.id.location);
		overlay = findViewById(R.id.overlay);
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
				if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M || (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && Environment.isExternalStorageManager() || (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !(checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED && checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED)))) {
					i.setClass(getApplicationContext(), MainActivity.class);
					startActivity(i);
					finish();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.dontgrant));
				}
			}
		});
		
		storage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
				requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
				if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R || Environment.isExternalStorageManager()) {
					
				}
				else {
					i.setAction("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
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
	}
	
	private void initializeLogic() {
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
						if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R || Environment.isExternalStorageManager()) {
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
							storage.setTextColor(0xFFFFFFFF);
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
						}
						else {
							overlay.setTextColor(0xFF00FF00);
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