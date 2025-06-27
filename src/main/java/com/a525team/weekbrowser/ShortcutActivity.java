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
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
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
import android.graphics.Bitmap;
import java.net.URL;
import java.net.HttpURLConnection;

public class ShortcutActivity extends Activity {
	
	ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	public static Bitmap favicon = null;
	int id = 1;
	
	private ArrayList<String> languag = new ArrayList<>();
	private  List<Bitmap> icons = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> icons2 = new ArrayList<>();
	
	private ScrollView vscroll1;
	private Button add;
	private LinearLayout linear1;
	private TextView nam;
	private EditText name;
	private TextView ur;
	private EditText url;
	private LinearLayout linear2;
	private GridView gridview1;
	private Button inslink;
	private Button insmlink;
	
	private SharedPreferences sf;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		ThemeManager.applyTheme(this);
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.shortcut);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		add = findViewById(R.id.add);
		linear1 = findViewById(R.id.linear1);
		nam = findViewById(R.id.nam);
		name = findViewById(R.id.name);
		ur = findViewById(R.id.ur);
		url = findViewById(R.id.url);
		linear2 = findViewById(R.id.linear2);
		gridview1 = findViewById(R.id.gridview1);
		inslink = findViewById(R.id.inslink);
		insmlink = findViewById(R.id.insmlink);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		
		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try{
					Bitmap bmp = null;
					if(id!=0){
						    int id2 = IconSwitcher.getAllIconsID()[id-1];
							    bmp = BitmapFactory.decodeResource(getResources(), id2);
						    }else{
						        bmp = favicon;
						        }
					
					if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
							// Додавання ярлика для Android 8.0 і вище
							ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
							if (shortcutManager != null) {
									Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url.getText().toString().equals("")?"about:blank":url.getText().toString()));
									intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
									ShortcutInfo shortcut = new ShortcutInfo.Builder(getApplicationContext(), url.getText().toString())
									.setIntent(intent)
									.setShortLabel(name.getText().toString().equals("") ? "Unnamed" : name.getText().toString())
									.setIcon(Icon.createWithBitmap(bmp))
									.build();
									shortcutManager.requestPinShortcut(shortcut, null);
									
									SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.added));
							}
					} else {
							// Додавання ярлика для Android версій нижче 8.0
							Intent shortcutIntent = new Intent(Intent.ACTION_VIEW);
							shortcutIntent.setData(Uri.parse(url.getText().toString().equals("")?"about:blank":url.getText().toString()));
							//shortcutIntent.addCategory(Intent.CATEGORY_BROWSABLE);
							shortcutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
							
							Intent addIntent = new Intent();
							addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
							addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, name.getText().toString().equals("")?"Unnamed":name.getText().toString());
							addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON, bmp);
							addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
							
							sendBroadcast(addIntent);
							SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.added));
					}
					
				}catch(Exception e){
					SketchwareUtil.showMessage(getApplicationContext(), "Error");
				}
			}
		});
		
		gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if(_position==0)
				loadFavicon(url.getText().toString());
				
				id = _position;
				((BaseAdapter) gridview1.getAdapter()).notifyDataSetChanged();
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
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("", "");
			icons2.add(_item);
		}
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		icons = IconSwitcher.getAllIconsBitmaps(getApplicationContext());
		
		for(int i=0; i<icons.size(); i++){
				HashMap<String, Object> _item = new HashMap<>();
			icons2.add(_item);
		}
		gridview1.setAdapter(new Gridview1Adapter(icons2));
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
		} else {
			name.setTypeface(Typeface.DEFAULT);
			url.setTypeface(Typeface.DEFAULT);
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
	
	public void loadFavicon(final String websiteUrl) {
			new Thread(() -> {
					try {
							Uri uri = Uri.parse(websiteUrl);
							String baseUrl = uri.getScheme() + "://" + uri.getHost();
							
							URL url = new URL(baseUrl + "/favicon.ico");
							HttpURLConnection connection = (HttpURLConnection) url.openConnection();
							connection.setConnectTimeout(5000);
							connection.setReadTimeout(5000);
							connection.setInstanceFollowRedirects(true);
							
							if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
									InputStream input = connection.getInputStream();
									Bitmap bmp = BitmapFactory.decodeStream(input);
									if (bmp != null) {
											favicon = bmp;
											
											// Оновлюємо адаптер у головному потоці
											new Handler(Looper.getMainLooper()).post(() -> {
													((BaseAdapter) gridview1.getAdapter()).notifyDataSetChanged();
											});
									}
									input.close();
							}
							connection.disconnect();
					} catch (Exception e) {
							e.printStackTrace();
					}
			}).start();
	}
	
	{
			
	}
	
	public class Gridview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Gridview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.draws, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			if(_position!=0){
				imageview1.setImageBitmap(icons.get(_position-1));
				textview1.setText(IconSwitcher.getName(ShortcutActivity.this, _position-1));
			}else{
				textview1.setText(getString(R.string.load_fav));
				if(favicon!=null){
					imageview1.setImageBitmap(favicon);
				}else{
					imageview1.setImageResource(R.drawable.default_image);
				}
			}
			
			Animator2.anim(getApplicationContext(), linear1, 0, 100);
			
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			
			// Ініціалізація Skin
			Skin skin = new Skin();
			
			if(id == _position){
				    skin.setBG(linear1, 1, false);
				textview1.setTextColor((int) Long.parseLong(dataHolder.getData("rbt"), 16));
				    }else{
				skin.setBG(linear1, 0, false);
				textview1.setTextColor((int) Long.parseLong(dataHolder.getData("bt"), 16));
			}
			
			return _view;
		}
	}
}