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
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class UseragentActivity extends Activity {
	
	private ArrayList<String> langua = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> ua = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> uapc = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private TextView name;
	private TextView textview2;
	private Spinner spinner1;
	private AutoCompleteTextView autocomplete1;
	private TextView textview3;
	private Spinner spinner2;
	private AutoCompleteTextView autocomplete3;
	
	private SharedPreferences sf;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		ThemeManager.applyTheme(this);
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.useragent);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		name = findViewById(R.id.name);
		textview2 = findViewById(R.id.textview2);
		spinner1 = findViewById(R.id.spinner1);
		autocomplete1 = findViewById(R.id.autocomplete1);
		textview3 = findViewById(R.id.textview3);
		spinner2 = findViewById(R.id.spinner2);
		autocomplete3 = findViewById(R.id.autocomplete3);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (!(_position == 0)) {
					autocomplete1.setText(ua.get((int)_position).get("u").toString());
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		autocomplete1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("ua", _charSeq).commit();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (!uapc.get((int)_position).get("u").toString().isEmpty()) {
					autocomplete3.setText(uapc.get((int)_position).get("u").toString());
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		autocomplete3.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("uapc", _charSeq).commit();
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
		SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		
		_ualist();
		_uapclist();
		spinner1.setAdapter(new Spinner1Adapter(ua));
		spinner2.setAdapter(new Spinner2Adapter(uapc));
		autocomplete1.setText(sf.getString("ua", ""));
		autocomplete3.setText(sf.getString("uapc", ""));
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
		skin.setBG(getWindow().getDecorView(), 2, false);
		skin.setBG(vscroll1, 2, false);
		
		/*skin.setBG(std, 0, false);
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
*/
		if (sf.getString("monoforta", "").equals("1")) {
			autocomplete1.setTypeface(Typeface.MONOSPACE);
			autocomplete3.setTypeface(Typeface.MONOSPACE);
		} else {
			autocomplete1.setTypeface(Typeface.DEFAULT);
			autocomplete3.setTypeface(Typeface.DEFAULT);
		}
	}
	
	@Override
	public void onBackPressed() {
		finish();
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
	
	
	public void _ualist() {
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"-- Choose useragent --"
			
			);_item.put("u", 
			
			""
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"Your standard useragent"
			
			);_item.put("u", 
			
			""
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(V)Android 16 (Smartphone | Firefox 136)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (Android 16; Mobile; rv:136.0) Gecko/136.0 Firefox/136.0"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(V)Android 15 (Smartphone | Chrome 131.0.6778)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (Linux; Android 15) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.6778.200 Mobile Safari/537.36"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(V)Android 15 (Pixel 7A | WebView 131.0.6778.135)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (Linux; Android 15; Pixel 7a Build/AP3A.241105.007; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/131.0.6778.135 Mobile Safari/537.36 Lark/7.32.8 LarkLocale/en_US ChannelName/Lark"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(V)Android 14 (Smartphone | Chrome 118.0.5993)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (Linux; Android 14) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.5993.111 Mobile Safari/537.36"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(V)Android 13 (Samsung Galaxy S22 5G | Chrome 112.0.0)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (Linux; Android 13; SM-S901B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(V)Android 10 (K | Chrome 114.0.0)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(?)Android 8.1 (Asus Zenfone 4 Max | Chrome 76.0.3809.89)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (Linux; Android 8.1.0; ASUS_X00ID) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.89 Mobile Safari/537.36"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(?)Android 6.0 (Nexus 5 | Chrome 79)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (Linux; Android 8.1.0; ASUS_X00ID) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.89 Mobile Safari/537.36"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(X)Android 4.4.2 (Samsung Galaxy Tab 3 | Android Browser 4.0)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (Linux; U; Android 4.4.2; en-gb; GT-P5210 Build/KOT49H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(X)Android 4.0.4 (Tablet | Android Browser 4.0)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (Linux; U; Android 4.0.4; pt-pt; SPNG9716DC Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(X)Android 2.2 (Samsung Galaxy Tab P1000 | Android Browser 4.0)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (Linux; U; Android 2.2; en-gb; GT-P1000 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(E)Android 99 (Smartphone | Chrome 999.0.6778.200)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (Linux; Android 99) AppleWebKit/999.36 (KHTML, like Gecko) Chrome/999.0.6778.200 Mobile Safari/999.36"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(V)iOS 17.1 (iPhone | Safari 17.0)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (iPhone; CPU iPhone OS 17_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Mobile/15E148 Safari/604.1"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(V)iOS 17.2.1 (iPhone | Safari 14)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (iPhone; CPU iPhone OS 17_2_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0.0 Mobile/15E148 Safari/605.1.15"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(V)iOS 17.1 (iPad | Safari 17.1)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (iPad; CPU OS 17_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/21B74 [FBAN/FBIOS;FBDV/iPad14,5;FBMD/iPad;FBSN/iPadOS;FBSV/17.1;FBSS/2;FBID/tablet;FBLC/it_IT;FBOP/5]"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(?)iOS 14.0 (iPhone 11 | Instagram 147.0.0.30.121)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 Instagram 147.0.0.30.121 (iPhone11,6; iOS 14_0; en_US; en-US; scale=3.00; 1242x2688; 224680684)"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(X)iOS 5 (iPad | Safari 5.1)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (iPad; CPU OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(X)iOS 3.2 (iPad | Safari 4.0.4)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (iPad; U; CPU OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B367 Safari/531.21.10"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(?)Windows Phone 10.0 (Microsoft Lumia 650 | Edge 15.15254)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (Windows Phone 10.0; Android 6.0.1; Microsoft; RM-1152) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Mobile Safari/537.36 Edge/15.15254"
			
			);ua.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(X)Symbian 9.4 (Nokia N97 | Nokia Browser 7.1.18124)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (SymbianOS/9.4; Series60/5.0 NokiaN97-1/20.0.019; Profile/MIDP-2.1 Configuration/CLDC-1.1) AppleWebKit/525 (KHTML, like Gecko) BrowserNG/7.1.18124"
			
			);ua.add(_item);}
	}
	
	
	public void _uapclist() {
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"-- Choose useragent --"
			
			);_item.put("u", 
			
			""
			
			);uapc.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(V)Windows 11 (Chrome 86)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (Windows NT 11.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.111 Safari/537.36 OPR/72.0.3815.178"
			
			);uapc.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(V)Windows 10 (Chrome 58)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36"
			
			);uapc.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(X)Windows XP (Chrome 73)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (Windows XP) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36"
			
			);uapc.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(?)MacOS 14.1 (Safari 17)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 14_1) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Safari/605.1.15"
			
			);uapc.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(?)Linux i686 (Firefox 116.0)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (X11; Linux i686; rv:109.0) Gecko/20100101 Firefox/116.0"
			
			);uapc.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(V)Google ADT-2 (Android 9)"
			
			);_item.put("u", 
			
			"Dalvik/2.1.0 (Linux; U; Android 9; ADT-2 Build/PTT5.181126.002)"
			
			);uapc.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(?)Chromecast (Chrome 31.0.1650.0)"
			
			);_item.put("u", 
			
			"Mozilla/5.0 (CrKey armv7l 1.5.16041) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.0 Safari/537.36"
			
			);uapc.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(V)Apple TV 6th Gen 4K"
			
			);_item.put("u", 
			
			"AppleTV11,1/11.1"
			
			);uapc.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(V)Apple TV 5th Gen 4K"
			
			);_item.put("u", 
			
			"AppleTV6,2/11.1"
			
			);uapc.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(V)Apple TV 4th Gen"
			
			);_item.put("u", 
			
			"AppleTV5,3/9.1.1"
			
			);uapc.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(E)[B]Python 3.8.1"
			
			);_item.put("u", 
			
			"Python/3.7aiohttp/3.8.1"
			
			);uapc.add(_item);}
		{HashMap<String, Object> _item = new HashMap<>();
			
			_item.put("n", 
			"(E)[B]GoogleBot"
			
			);_item.put("u", 
			
			"Mozilla/5.0 AppleWebKit/537.36 (KHTML, like Gecko; compatible; Googlebot/2.1; +http://www.google.com/bot.html) Chrome/108.0.0.0 Safari/537.36"
			
			);uapc.add(_item);}
	}
	
	public class Spinner1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Spinner1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.useragentt, null);
			}
			
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			Animator2.anim(getApplicationContext(), textview1, 0, 100);
			
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			
			// Ініціалізація Skin
			Skin skin = new Skin();
			
			skin.setBG(textview1, 0, false);
			textview1.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
			textview1.setText(_data.get((int)_position).get("n").toString());
			
			return _view;
		}
	}
	
	public class Spinner2Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Spinner2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.useragentt, null);
			}
			
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			Animator2.anim(getApplicationContext(), textview1, 0, 100);
			
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			
			// Ініціалізація Skin
			Skin skin = new Skin();
			
			skin.setBG(textview1, 0, false);
			textview1.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
			textview1.setText(_data.get((int)_position).get("n").toString());
			
			return _view;
		}
	}
}