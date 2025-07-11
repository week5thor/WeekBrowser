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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.regex.*;
import org.json.*;

public class UseragentActivity extends Activity {
	
	private ArrayList<String> langua = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private TextView name;
	private TextView textview2;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private AutoCompleteTextView autocomplete1;
	private TextView textview3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private AutoCompleteTextView autocomplete3;
	private Button std;
	private Button android14;
	private Button iphone;
	private Button ipad17;
	private Button ios5;
	private Button iPad;
	private Button Symbian;
	private Button android4;
	private Button windows11;
	private Button macos14;
	private Button linuxi686;
	private Button windows10;
	private Button windowsxp;
	private Button win95;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.useragent);
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
		        setContentView(R.layout.useragent);
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		name = findViewById(R.id.name);
		textview2 = findViewById(R.id.textview2);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		autocomplete1 = findViewById(R.id.autocomplete1);
		textview3 = findViewById(R.id.textview3);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		autocomplete3 = findViewById(R.id.autocomplete3);
		std = findViewById(R.id.std);
		android14 = findViewById(R.id.android14);
		iphone = findViewById(R.id.iphone);
		ipad17 = findViewById(R.id.ipad17);
		ios5 = findViewById(R.id.ios5);
		iPad = findViewById(R.id.iPad);
		Symbian = findViewById(R.id.Symbian);
		android4 = findViewById(R.id.android4);
		windows11 = findViewById(R.id.windows11);
		macos14 = findViewById(R.id.macos14);
		linuxi686 = findViewById(R.id.linuxi686);
		windows10 = findViewById(R.id.windows10);
		windowsxp = findViewById(R.id.windowsxp);
		win95 = findViewById(R.id.win95);
		
		autocomplete1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt", _charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		autocomplete3.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt", _charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		std.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt", "");
				autocomplete1.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt"));
			}
		});
		
		android14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt", "Mozilla/5.0 (Linux; Android 14) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.5993.111 Mobile Safari/537.36");
				autocomplete1.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt"));
			}
		});
		
		iphone.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt", "Mozilla/5.0 (iPhone; CPU iPhone OS 17_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Mobile/15E148 Safari/604.1");
				autocomplete1.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt"));
			}
		});
		
		ipad17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt", "Mozilla/5.0 (iPad; CPU OS 17_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/21B74 [FBAN/FBIOS;FBDV/iPad14,5;FBMD/iPad;FBSN/iPadOS;FBSV/17.1;FBSS/2;FBID/tablet;FBLC/it_IT;FBOP/5]");
				autocomplete1.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt"));
			}
		});
		
		ios5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt", "Mozilla/5.0 (iPad; CPU OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3");
				autocomplete1.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt"));
			}
		});
		
		iPad.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt", "Mozilla/5.0 (iPad; U; CPU OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B367 Safari/531.21.10");
				autocomplete1.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt"));
			}
		});
		
		Symbian.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt", "Mozilla/5.0 (SymbianOS/9.4; Series60/5.0 NokiaN97-1/20.0.019; Profile/MIDP-2.1 Configuration/CLDC-1.1) AppleWebKit/525 (KHTML, like Gecko) BrowserNG/7.1.18124");
				autocomplete1.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt"));
			}
		});
		
		android4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt", "Mozilla/5.0 (Linux; U; Android 4.4.2; en-gb; GT-P5210 Build/KOT49H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30");
				autocomplete1.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt"));
			}
		});
		
		windows11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt", "Mozilla/5.0 (Windows NT 11.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.111 Safari/537.36 OPR/72.0.3815.178");
				autocomplete3.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt"));
			}
		});
		
		macos14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt", "Mozilla/5.0 (Macintosh; Intel Mac OS X 14_1) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Safari/605.1.15");
				autocomplete3.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt"));
			}
		});
		
		linuxi686.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt", "Mozilla/5.0 (X11; Linux i686; rv:109.0) Gecko/20100101 Firefox/116.0");
				autocomplete3.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt"));
			}
		});
		
		windows10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
				autocomplete3.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt"));
			}
		});
		
		windowsxp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt", "Mozilla/5.0 (Windows XP) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36");
				autocomplete3.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt"));
			}
		});
		
		win95.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_4) AppleWebKit/537.77.4 (KHTML, like Gecko) Version/7.0.5 Safari/537.77.4");
				autocomplete3.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt"));
			}
		});
	}
	
	private void initializeLogic() {
		autocomplete1.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/current.txt"));
		autocomplete3.setText(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Useragents/currentpc.txt"));
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		
		// Ініціалізація Skin
		Skin skin = new Skin();
		
		// Установлення фону та кольорів тексту
		
		autocomplete1.setTextColor((int) Long.parseLong(dataHolder.getData("tf"), 16));
		name.setTextColor((int) Long.parseLong(dataHolder.getData("t"), 16));
		autocomplete3.setTextColor((int) Long.parseLong(dataHolder.getData("tf"), 16));
		autocomplete1.setHintTextColor((int) Long.parseLong(dataHolder.getData("h"), 16));
		autocomplete3.setHintTextColor((int) Long.parseLong(dataHolder.getData("h"), 16));
		
		textview2.setTextColor((int) Long.parseLong(dataHolder.getData("add"), 16));
		textview3.setTextColor((int) Long.parseLong(dataHolder.getData("add"), 16));
		
		// Заміна фону з використанням skin.setBG
		skin.setBG(linear1, 2, false);  // bg (фон), використовуючи колірний набір "bg"
		skin.setBG(getWindow().getDecorView(), 2, false);
		
		skin.setBG(std, 0, false);
		std.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
		
		skin.setBG(android14, 0, false);
		android14.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
		
		skin.setBG(iphone, 0, false);
		iphone.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
		
		skin.setBG(ipad17, 0, false);
		ipad17.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
		
		skin.setBG(windows11, 0, false);
		windows11.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
		
		skin.setBG(macos14, 0, false);
		macos14.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
		
		skin.setBG(linuxi686, 0, false);
		linuxi686.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
		
		skin.setBG(windows10, 0, false);
		windows10.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
		
		// Елементи з іншим кольоровим набором
		skin.setBG(ios5, 1, false);
		ios5.setTextColor((int) Long.parseLong(dataHolder.getData("rbt"), 16));
		
		skin.setBG(iPad, 1, false);
		iPad.setTextColor((int) Long.parseLong(dataHolder.getData("rbt"), 16));
		
		skin.setBG(Symbian, 1, false);
		Symbian.setTextColor((int) Long.parseLong(dataHolder.getData("rbt"), 16));
		
		skin.setBG(android4, 1, false);
		android4.setTextColor((int) Long.parseLong(dataHolder.getData("rbt"), 16));
		
		skin.setBG(windowsxp, 1, false);
		windowsxp.setTextColor((int) Long.parseLong(dataHolder.getData("rbt"), 16));
		
		skin.setBG(win95, 1, false);
		win95.setTextColor((int) Long.parseLong(dataHolder.getData("rbt"), 16));
		
		_language();
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/monofortextarea.txt").equals("1")) {
			autocomplete1.setTypeface(Typeface.MONOSPACE);
			autocomplete3.setTypeface(Typeface.MONOSPACE);
		}
		else {
			autocomplete1.setTypeface(Typeface.DEFAULT);
			autocomplete3.setTypeface(Typeface.DEFAULT);
		}
	}
	
	@Override
	public void onBackPressed() {
		finish();
	}
	public void _language() {
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