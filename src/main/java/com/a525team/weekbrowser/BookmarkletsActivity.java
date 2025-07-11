package com.a525team.weekbrowser;

import android.Manifest;
import android.animation.*;
import android.animation.ObjectAnimator;
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
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.regex.*;
import org.json.*;

public class BookmarkletsActivity extends Activity {
	
	private boolean g = false;
	Colorify colorify = new Colorify();
	
	private ArrayList<String> language = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private TextView nam;
	private TextView textview2;
	private CheckBox checkbox1;
	private AutoCompleteTextView autocomplete1;
	private CheckBox checkbox2;
	private AutoCompleteTextView autocomplete2;
	private CheckBox checkbox3;
	private AutoCompleteTextView autocomplete3;
	private CheckBox checkbox4;
	private AutoCompleteTextView autocomplete4;
	private CheckBox checkbox5;
	private AutoCompleteTextView autocomplete5;
	private CheckBox checkbox6;
	private AutoCompleteTextView autocomplete6;
	private TextView textview6;
	private CheckBox checkbox10001;
	private AutoCompleteTextView autocomplete10001;
	private CheckBox checkbox10002;
	private AutoCompleteTextView autocomplete10002;
	private TextView textview7;
	private AutoCompleteTextView name20001;
	private AutoCompleteTextView autocomplete20001;
	private LinearLayout linear2;
	private AutoCompleteTextView name20002;
	private AutoCompleteTextView autocomplete20002;
	private LinearLayout linear3;
	private AutoCompleteTextView name20003;
	private AutoCompleteTextView autocomplete20003;
	private LinearLayout linear4;
	private AutoCompleteTextView name20004;
	private AutoCompleteTextView autocomplete20004;
	private LinearLayout linear5;
	private AutoCompleteTextView name20005;
	private AutoCompleteTextView autocomplete20005;
	
	private ObjectAnimator anim = new ObjectAnimator();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.bookmarklets);
		initialize(_savedInstanceState);
		
		if (Build.VERSION.SDK_INT >= 23) {
			if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
			||checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
				requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
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
		        setContentView(R.layout.bookmarklets);
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		nam = findViewById(R.id.nam);
		textview2 = findViewById(R.id.textview2);
		checkbox1 = findViewById(R.id.checkbox1);
		autocomplete1 = findViewById(R.id.autocomplete1);
		checkbox2 = findViewById(R.id.checkbox2);
		autocomplete2 = findViewById(R.id.autocomplete2);
		checkbox3 = findViewById(R.id.checkbox3);
		autocomplete3 = findViewById(R.id.autocomplete3);
		checkbox4 = findViewById(R.id.checkbox4);
		autocomplete4 = findViewById(R.id.autocomplete4);
		checkbox5 = findViewById(R.id.checkbox5);
		autocomplete5 = findViewById(R.id.autocomplete5);
		checkbox6 = findViewById(R.id.checkbox6);
		autocomplete6 = findViewById(R.id.autocomplete6);
		textview6 = findViewById(R.id.textview6);
		checkbox10001 = findViewById(R.id.checkbox10001);
		autocomplete10001 = findViewById(R.id.autocomplete10001);
		checkbox10002 = findViewById(R.id.checkbox10002);
		autocomplete10002 = findViewById(R.id.autocomplete10002);
		textview7 = findViewById(R.id.textview7);
		name20001 = findViewById(R.id.name20001);
		autocomplete20001 = findViewById(R.id.autocomplete20001);
		linear2 = findViewById(R.id.linear2);
		name20002 = findViewById(R.id.name20002);
		autocomplete20002 = findViewById(R.id.autocomplete20002);
		linear3 = findViewById(R.id.linear3);
		name20003 = findViewById(R.id.name20003);
		autocomplete20003 = findViewById(R.id.autocomplete20003);
		linear4 = findViewById(R.id.linear4);
		name20004 = findViewById(R.id.name20004);
		autocomplete20004 = findViewById(R.id.autocomplete20004);
		linear5 = findViewById(R.id.linear5);
		name20005 = findViewById(R.id.name20005);
		autocomplete20005 = findViewById(R.id.autocomplete20005);
		
		textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (g) {
					g = false;
					try{
						textview2.setText(language.get((int)(75)));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							textview2.setText("Bookmarklets is executable bookmarks. You can write here and this bookmarklets will be execute every time you will be visit a site (actually after loading sites). If you don't want to execute certain bookmarklet, you can simply uncheck checkbox.\n\nBookmarklets are supporting special instructions [PRESS TO SHOW▼]");
						}
						else {
							textview2.setText("Букмарклети — це виконувані закладки. Тут Ви можете вказати такі, що відкриватимуться автоматично при кожному відкриванні сайту (а конкретніше, при завершенні завантаження). Якщо на цей момент Вам не потрібно запуск певного букмарклета, Ви можете просто зняти галочку.\n\nПідтримуються спецінструкції у букмарклетах [НАТИСНІТЬ, ЩОБ ПОКАЗАТИ▼]");
						}
					}
					anim.setTarget(textview2);
					anim.setPropertyName("scaleY");
					anim.setFloatValues((float)(3), (float)(1));
					anim.setDuration((int)(300));
					anim.start();
				}
				else {
					g = true;
					try{
						textview2.setText(language.get((int)(84)));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							textview2.setText("Bookmarklets is executable bookmarks. You can write here and this bookmarklets will be execute every time you will be visit a site (actually after loading sites). If you don't want to execute certain bookmarklet, you can simply uncheck checkbox.\n\nBookmarklets are supporting special instructions\n༺༻\nWhen you are write specinstruction in an bookmarklet, specinstruction will be replace to other text\n༺༻\n❖GENERAL❖\n$$ → $\n\n❖SKINS❖\n$colbg$ → background color of the skin\n$colb1$ → start color button of the skin\n$colb2$ → finish color button of the skin\n$colrb1$ → start color cancel/delete button of the skin\n$colb2$ → finish color cancel/delete button of the skin\n────────\n$coltext$ → text color of the skin\n$colfield$ → textarea color of the skin\n$coladd$ → additional text color of the skin\n$colhint$ → hint text color of the skin\n$colbtxt$ → button text color of the skin\n$colrbtxt$ → cancel/delete button text color of the skin\n\n\n[PRESS TO HIDE▲]");
						}
						else {
							textview2.setText("Букмарклети — це виконувані закладки. Тут Ви можете вказати такі, що відкриватимуться автоматично при кожному відкриванні сайту (а конкретніше, при завершенні завантаження). Якщо на цей момент Вам не потрібно запуск певного букмарклета, Ви можете просто зняти галочку.\n\nПідтримуються спецінструкції у букмарклетах\n༺༻\nКоли Ви пишете спецінструкцію у букмарклеті, спецінструкція заміниться на інший текст\n༺༻\n❖ЗАГАЛЬНЕ❖\n$$ → $\n\n❖СКІНИ❖\n$colbg$ → колір фону скіна\n$colb1$ → початковий колір кнопок скіна\n$colb2$ → кінцевий колір кнопок скіна\n$colrb1$ → початковий колір кнопок видалення/скасування скіна\n$colb2$ → кінцевий колір кнопок видалення/скасування скіна\n────────\n$coltext$ → колір основного тексту скіна\n$colfield$ → колір тексту у текстових полях скіна\n$coladd$ → колір додаткового тексту скіна\n$colhint$ → колір тексту підказок скіна\n$colbtxt$ → колір тексту кнопок\n$colrbtxt$ → колір тексту кнопок видалення/скасування скіна\n\n\n[НАТИСНІТЬ, ЩОБ СХОВАТИ▲]");
						}
					}
					anim.setTarget(textview2);
					anim.setPropertyName("scaleY");
					anim.setFloatValues((float)(0.3d), (float)(1));
					anim.setDuration((int)(625));
					anim.start();
				}
			}
		});
		
		checkbox1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/1.txt")) == 1) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/1.txt", "0");
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/1.txt", "1");
				}
			}
		});
		
		autocomplete1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/1.txt", autocomplete1.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		checkbox2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/2.txt")) == 1) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/2.txt", "0");
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/2.txt", "1");
				}
			}
		});
		
		autocomplete2.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/2.txt", autocomplete2.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		checkbox3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/3.txt")) == 1) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/3.txt", "0");
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/3.txt", "1");
				}
			}
		});
		
		autocomplete3.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/3.txt", autocomplete3.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		checkbox4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/4.txt")) == 1) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/4.txt", "0");
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/4.txt", "1");
				}
			}
		});
		
		autocomplete4.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/4.txt", autocomplete4.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		checkbox5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/5.txt")) == 1) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/5.txt", "0");
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/5.txt", "1");
				}
			}
		});
		
		autocomplete5.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/5.txt", autocomplete5.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		checkbox6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/6.txt")) == 1) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/6.txt", "0");
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/6.txt", "1");
				}
			}
		});
		
		autocomplete6.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/6.txt", autocomplete6.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		checkbox10001.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/10001.txt")) == 1) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/10001.txt", "0");
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/10001.txt", "1");
				}
			}
		});
		
		autocomplete10001.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/10001.txt", autocomplete10001.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		checkbox10002.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/10002.txt")) == 1) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/10002.txt", "0");
				}
				else {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/10002.txt", "1");
				}
			}
		});
		
		autocomplete10002.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/10002.txt", autocomplete10002.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		name20001.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20001n.txt", name20001.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		autocomplete20001.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20001.txt", autocomplete20001.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		name20002.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20002n.txt", name20002.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		autocomplete20002.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20002.txt", autocomplete20002.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		name20003.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20003n.txt", name20003.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		autocomplete20003.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20003.txt", autocomplete20003.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		name20004.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20004n.txt", name20004.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		autocomplete20004.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20004.txt", autocomplete20004.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		name20005.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20005n.txt", name20005.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		autocomplete20005.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20005.txt", autocomplete20005.getText().toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
	}
	
	private void initializeLogic() {
		if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
			language = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Language.welang"), new TypeToken<ArrayList<String>>(){}.getType());
		}
		autocomplete1.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/1.txt"));
		autocomplete2.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/2.txt"));
		autocomplete3.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/3.txt"));
		checkbox1.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/1.txt")) == 1);
		checkbox2.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/2.txt")) == 1);
		checkbox3.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/3.txt")) == 1);
		autocomplete4.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/4.txt"));
		autocomplete5.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/5.txt"));
		autocomplete6.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/6.txt"));
		checkbox4.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/4.txt")) == 1);
		checkbox5.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/5.txt")) == 1);
		checkbox6.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/6.txt")) == 1);
		autocomplete10001.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/10001.txt"));
		autocomplete10002.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/10002.txt"));
		checkbox10001.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/10001.txt")) == 1);
		checkbox10002.setChecked(Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/state/10002.txt")) == 1);
		autocomplete20001.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20001.txt"));
		autocomplete20002.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20002.txt"));
		
		
		autocomplete20003.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20003.txt"));
		autocomplete20004.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20004.txt"));
		
		
		autocomplete20005.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20005.txt"));
		
		name20001.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20001n.txt"));
		name20002.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20002n.txt"));
		name20003.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20003n.txt"));
		name20004.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20004n.txt"));
		name20005.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Bookmarklets/20005n.txt"));
		/*
ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
applyColorsToViews(findViewById(android.R.id.content));
getWindow().getDecorView().setBackgroundColor((int)Long.parseLong(dataHolder.getData("bg"),16));
linear1.setBackgroundColor((int)Long.parseLong(dataHolder.getData("bg"),16));
textview2.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
textview6.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
textview7.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
nam.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
checkbox1.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
checkbox2.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
checkbox3.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
autocomplete1.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
autocomplete1.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
autocomplete2.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
autocomplete2.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
autocomplete3.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
autocomplete3.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
checkbox4.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
checkbox5.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
checkbox6.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
checkbox10001.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
checkbox10002.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
autocomplete4.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
autocomplete4.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
autocomplete5.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
autocomplete5.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
autocomplete6.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
autocomplete6.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
autocomplete10001.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
autocomplete10001.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
autocomplete10002.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
autocomplete10002.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));

autocomplete20001.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
autocomplete20001.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
autocomplete20002.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
autocomplete20002.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
autocomplete20003.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
autocomplete20003.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
autocomplete20004.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
autocomplete20004.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
autocomplete20005.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
autocomplete20005.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));

name20001.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
name20001.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
name20002.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
name20002.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
name20003.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
name20003.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
name20004.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
name20004.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
name20005.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
name20005.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
*/
	}
	
	@Override
	public void onBackPressed() {
		finish();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		try{
			textview2.setText(language.get((int)(75)));
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				textview2.setText("Bookmarklets is executable bookmarks. You can write here and this bookmarklets will be execute every time you will be visit a site (actually after loading sites). If you don't want to execute certain bookmarklet, you can simply uncheck checkbox.\n\nBookmarklets are supporting special instructions [PRESS TO SHOW▼]");
			}
			else {
				textview2.setText("Букмарклети — це виконувані закладки. Тут Ви можете вказати такі, що відкриватимуться автоматично при кожному відкриванні сайту (а конкретніше, при завершенні завантаження). Якщо на цей момент Вам не потрібно запуск певного букмарклета, Ви можете просто зняти галочку.\n\nПідтримуються спецінструкції у букмарклетах [НАТИСНІТЬ, ЩОБ ПОКАЗАТИ▼]");
			}
		}
		_languag();
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/monofortextarea.txt").equals("1")) {
			autocomplete1.setTypeface(Typeface.MONOSPACE);
			autocomplete2.setTypeface(Typeface.MONOSPACE);
			autocomplete3.setTypeface(Typeface.MONOSPACE);
			autocomplete4.setTypeface(Typeface.MONOSPACE);
			autocomplete5.setTypeface(Typeface.MONOSPACE);
			autocomplete6.setTypeface(Typeface.MONOSPACE);
			autocomplete10001.setTypeface(Typeface.MONOSPACE);
			autocomplete10002.setTypeface(Typeface.MONOSPACE);
			autocomplete20001.setTypeface(Typeface.MONOSPACE);
			autocomplete20002.setTypeface(Typeface.MONOSPACE);
			autocomplete20003.setTypeface(Typeface.MONOSPACE);
			autocomplete20004.setTypeface(Typeface.MONOSPACE);
			autocomplete20005.setTypeface(Typeface.MONOSPACE);
			name20001.setTypeface(Typeface.MONOSPACE);
			name20002.setTypeface(Typeface.MONOSPACE);
			name20003.setTypeface(Typeface.MONOSPACE);
			name20004.setTypeface(Typeface.MONOSPACE);
			name20005.setTypeface(Typeface.MONOSPACE);
			
		}
		else {
			autocomplete1.setTypeface(Typeface.DEFAULT);
			autocomplete2.setTypeface(Typeface.DEFAULT);
			autocomplete3.setTypeface(Typeface.DEFAULT);
			autocomplete4.setTypeface(Typeface.DEFAULT);
			autocomplete5.setTypeface(Typeface.DEFAULT);
			autocomplete6.setTypeface(Typeface.DEFAULT);
			autocomplete10001.setTypeface(Typeface.DEFAULT);
			autocomplete10002.setTypeface(Typeface.DEFAULT);
			autocomplete20001.setTypeface(Typeface.DEFAULT);
			autocomplete20002.setTypeface(Typeface.DEFAULT);
			autocomplete20003.setTypeface(Typeface.DEFAULT);
			autocomplete20004.setTypeface(Typeface.DEFAULT);
			autocomplete20005.setTypeface(Typeface.DEFAULT);
			name20001.setTypeface(Typeface.DEFAULT);
			name20002.setTypeface(Typeface.DEFAULT);
			name20003.setTypeface(Typeface.DEFAULT);
			name20004.setTypeface(Typeface.DEFAULT);
			name20005.setTypeface(Typeface.DEFAULT);
			
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
	}
	public void _languag() {
		
	}
	
	
	public void _extra() {
	}
	
	private void applyColorsToViews(View view) {
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		        if (view instanceof ViewGroup) {
			            ViewGroup viewGroup = (ViewGroup) view;
			            for (int i = 0; i < viewGroup.getChildCount(); i++) {
				                View child = viewGroup.getChildAt(i);
				                applyColorsToViews(child); // Рекурсивний виклик для дочірніх елементів
				
				                if (child instanceof CompoundButton) {
					                    CompoundButton button = (CompoundButton) child;
					                    String colorHex = dataHolder.getData("cb"); // Отримання кольору для кнопок
					                    int color = Color.parseColor("#" + (colorHex != null ? colorHex : "000000"));
					                    colorify.setButtonColor(button, color);
					                } else if (child instanceof SeekBar) {
					                    SeekBar seekBar = (SeekBar) child;
					                    String progressColorHex = dataHolder.getData("tpc"); // Отримання кольору для прогресу
					                    String thumbColorHex = dataHolder.getData("tc"); // Отримання кольору для повзунка
					                    int progressColor = Color.parseColor("#" + (progressColorHex != null ? progressColorHex : "000000"));
					                    int thumbColor = Color.parseColor("#" + (thumbColorHex != null ? thumbColorHex : "000000"));
					                    colorify.setSeekBarColors(seekBar, progressColor, thumbColor);
					                }
				            }
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