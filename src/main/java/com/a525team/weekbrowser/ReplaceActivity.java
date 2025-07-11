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
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
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

public class ReplaceActivity extends Activity {
	
	private ArrayList<String> languag = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private TextView name;
	private TextView hint;
	private TextView a1;
	private AutoCompleteTextView search1;
	private AutoCompleteTextView replace1;
	private TextView a2;
	private AutoCompleteTextView search2;
	private AutoCompleteTextView replace2;
	private TextView a3;
	private AutoCompleteTextView search3;
	private AutoCompleteTextView replace3;
	private TextView a4;
	private AutoCompleteTextView search4;
	private AutoCompleteTextView replace4;
	private TextView a5;
	private AutoCompleteTextView search5;
	private AutoCompleteTextView replace5;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.replace);
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
		        setContentView(R.layout.replace);
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		name = findViewById(R.id.name);
		hint = findViewById(R.id.hint);
		a1 = findViewById(R.id.a1);
		search1 = findViewById(R.id.search1);
		replace1 = findViewById(R.id.replace1);
		a2 = findViewById(R.id.a2);
		search2 = findViewById(R.id.search2);
		replace2 = findViewById(R.id.replace2);
		a3 = findViewById(R.id.a3);
		search3 = findViewById(R.id.search3);
		replace3 = findViewById(R.id.replace3);
		a4 = findViewById(R.id.a4);
		search4 = findViewById(R.id.search4);
		replace4 = findViewById(R.id.replace4);
		a5 = findViewById(R.id.a5);
		search5 = findViewById(R.id.search5);
		replace5 = findViewById(R.id.replace5);
		
		search1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/10.txt", _charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		replace1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/11.txt", _charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		search2.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/20.txt", _charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		replace2.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/21.txt", _charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		search3.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/30.txt", _charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		replace3.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/31.txt", _charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		search4.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/40.txt", _charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		replace4.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/41.txt", _charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		search5.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/50.txt", _charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		replace5.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/replaces/51.txt", _charSeq);
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
		search1.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/10.txt"));
		replace1.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/11.txt"));
		search2.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/20.txt"));
		replace2.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/21.txt"));
		search3.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/30.txt"));
		replace3.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/31.txt"));
		search4.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/40.txt"));
		replace4.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/41.txt"));
		search5.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/50.txt"));
		replace5.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/replaces/51.txt"));
	}
	
	@Override
	public void onResume() {
		super.onResume();
		/*
ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();

getWindow().getDecorView().setBackgroundColor((int)Long.parseLong(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt"),16));

	name.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
hint.setTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
a1.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
a2.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
a3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
a4.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
a5.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));

search1.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
search1.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
search2.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
search2.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
search3.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
search3.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
search4.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
search4.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
search5.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
search5.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
replace1.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
replace1.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
replace2.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
replace3.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
replace3.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
replace4.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
replace4.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
replace5.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
replace5.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
*/
		_language();
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/monofortextarea.txt").equals("1")) {
			search1.setTypeface(Typeface.MONOSPACE);
			replace1.setTypeface(Typeface.MONOSPACE);
			search2.setTypeface(Typeface.MONOSPACE);
			replace2.setTypeface(Typeface.MONOSPACE);
			search3.setTypeface(Typeface.MONOSPACE);
			replace3.setTypeface(Typeface.MONOSPACE);
			search4.setTypeface(Typeface.MONOSPACE);
			replace4.setTypeface(Typeface.MONOSPACE);
			search5.setTypeface(Typeface.MONOSPACE);
			replace5.setTypeface(Typeface.MONOSPACE);
		}
		else {
			search1.setTypeface(Typeface.DEFAULT);
			replace1.setTypeface(Typeface.DEFAULT);
			search2.setTypeface(Typeface.DEFAULT);
			replace2.setTypeface(Typeface.DEFAULT);
			search3.setTypeface(Typeface.DEFAULT);
			replace3.setTypeface(Typeface.DEFAULT);
			search4.setTypeface(Typeface.DEFAULT);
			replace4.setTypeface(Typeface.DEFAULT);
			search5.setTypeface(Typeface.DEFAULT);
			replace5.setTypeface(Typeface.DEFAULT);
		}
	}
	public void _language() {
		if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
			languag = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Language.welang"), new TypeToken<ArrayList<String>>(){}.getType());
		}
		try{
			name.setText(languag.get((int)(82)));
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				name.setText("SEARCH AND REPLACE IN LINKS");
			}
			else {
				name.setText("МЕНЕДЖЕР ПОШУКУ ТА ЗАМІН");
			}
		}
		try{
			hint.setText(languag.get((int)(83)));
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				hint.setText("Here you can set rules for replacement in links that will be executed when you long press the search button [🔍]. For example, to download a video from YouTube, you can search for \"youtube.com\" and replace it with \"ssyoutube.com\" (add \"ss\" before \"youtube\", write everything without double quotes). Regular expressions are supported");
			}
			else {
				hint.setText("Тут ви можете задати правила для заміни у посиланнях, які виконаються при довгому натисканні на кнопку пошуку [🔍]. Наприклад, для завантаження відео з Youtube Ви можете задати у пошук \"youtube.com\", а у заміну \"ssyoutube.com\" (додаєте \"ss\" перед \"youtube\", усе пишете без подвійних лапок). Регулярні вирази підтримуються");
			}
		}
		try{
			a1.setText(languag.get((int)(147)).concat("1"));
			a2.setText(languag.get((int)(147)).concat("2"));
			a3.setText(languag.get((int)(147)).concat("3"));
			a4.setText(languag.get((int)(147)).concat("4"));
			a5.setText(languag.get((int)(147)).concat("5"));
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				a1.setText("REPLACE #1");
				a2.setText("REPLACE #2");
				a3.setText("REPLACE #3");
				a4.setText("REPLACE #4");
				a5.setText("REPLACE #5");
			}
			else {
				a1.setText("ЗАМІНА №1");
				a2.setText("ЗАМІНА №2");
				a3.setText("ЗАМІНА №3");
				a4.setText("ЗАМІНА №4");
				a5.setText("ЗАМІНА №5");
			}
		}
		try{
			search1.setHint(languag.get((int)(33)));
			search2.setHint(languag.get((int)(33)));
			search3.setHint(languag.get((int)(33)));
			search4.setHint(languag.get((int)(33)));
			search5.setHint(languag.get((int)(33)));
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				search1.setHint("Search");
				search2.setHint("Search");
				search3.setHint("Search");
				search4.setHint("Search");
				search5.setHint("Search");
			}
			else {
				search1.setHint("Пошук");
				search2.setHint("Пошук");
				search3.setHint("Пошук");
				search4.setHint("Пошук");
				search5.setHint("Пошук");
			}
		}
		try{
			replace1.setHint(languag.get((int)(85)));
			replace2.setHint(languag.get((int)(85)));
			replace3.setHint(languag.get((int)(85)));
			replace4.setHint(languag.get((int)(85)));
			replace5.setHint(languag.get((int)(85)));
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				replace1.setHint("Replace");
				replace2.setHint("Replace");
				replace3.setHint("Replace");
				replace4.setHint("Replace");
				replace5.setHint("Replace");
			}
			else {
				replace1.setHint("Заміна");
				replace2.setHint("Заміна");
				replace3.setHint("Заміна");
				replace4.setHint("Заміна");
				replace5.setHint("Заміна");
			}
		}
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