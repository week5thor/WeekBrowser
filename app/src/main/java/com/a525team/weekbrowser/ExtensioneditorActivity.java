package com.a525team.weekbrowser;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import com.a525team.weekbrowser.SkinButton;
import com.a525team.weekbrowser.SkinEditText;
import com.a525team.weekbrowser.SkinTextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class ExtensioneditorActivity extends Activity {
	
	private HashMap<String, Object> ext = new HashMap<>();
	private boolean enabled = false;
	
	private ArrayList<HashMap<String, Object>> ir = new ArrayList<>();
	
	private LinearLayout bg;
	private SkinTextView name;
	private SkinTextView dis;
	private LinearLayout linear2;
	private SkinButton switchtab;
	private ScrollView js;
	private LinearLayout inter;
	private LinearLayout linear1;
	private SkinTextView textview1;
	private SkinEditText edittext1;
	private SkinTextView textview2;
	private SkinEditText edittext2;
	private SkinTextView textview4;
	private SkinEditText edittext3;
	private SkinTextView textview3;
	private SkinButton button1;
	private ListView listview1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		ThemeManager.applyTheme(this);
		setContentView(R.layout.extensioneditor);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		bg = findViewById(R.id.bg);
		name = findViewById(R.id.name);
		dis = findViewById(R.id.dis);
		linear2 = findViewById(R.id.linear2);
		switchtab = findViewById(R.id.switchtab);
		js = findViewById(R.id.js);
		inter = findViewById(R.id.inter);
		linear1 = findViewById(R.id.linear1);
		textview1 = findViewById(R.id.textview1);
		edittext1 = findViewById(R.id.edittext1);
		textview2 = findViewById(R.id.textview2);
		edittext2 = findViewById(R.id.edittext2);
		textview4 = findViewById(R.id.textview4);
		edittext3 = findViewById(R.id.edittext3);
		textview3 = findViewById(R.id.textview3);
		button1 = findViewById(R.id.button1);
		listview1 = findViewById(R.id.listview1);
		
		//OnTouch
		switchtab.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event){
				int ev = event.getAction();
				switch (ev) {
					case MotionEvent.ACTION_DOWN:
					
					if (js.getVisibility() == View.VISIBLE) {
						js.setVisibility(View.GONE);
						inter.setVisibility(View.VISIBLE);
					} else {
						js.setVisibility(View.VISIBLE);
						inter.setVisibility(View.GONE);
					}
					
					break;
					case MotionEvent.ACTION_UP:
					
					
					
					break;
				} return true;
			}
		});
		
		switchtab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("siu", ".*example\\.com.*");
					ir.add(_item);
				}
				ir.get((int)ir.size() - 1).put("ec", "200");
				ir.get((int)ir.size() - 1).put("mt", "text/html");
				ir.get((int)ir.size() - 1).put("rt", "<h4>Blocked</h4>");
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
		});
	}
	
	private void initializeLogic() {
		try{
			inter.setVisibility(View.GONE);
			
			/*
ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();

// Ініціалізація Skin
Skin skin = new Skin();

skin.setBG(getWindow().getDecorView(), 2, false);

name.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
edittext1.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
edittext2.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
edittext3.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));

textview1.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
textview2.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
textview3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
textview4.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));

button1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
skin.setBG(button1, 0, false);

switchtab.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
skin.setBG(switchtab, 0, false);

dis.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
skin.setBG(dis, 1, false);
*/
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
			textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
			textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
			textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
			button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
			name.setText(getIntent().getStringExtra("path").replace(getFilesDir().getPath()+"/extensions/", ""));
			try{
				ext=JsonUtils.M(FileUtil.readFile(getIntent().getStringExtra("path")));
				ir=JsonUtils.SO(ext.get("sir").toString().substring(4));
			}catch(Exception e){
				
			}
			try{
				edittext1.setText(ext.get("ps").toString());
			}catch(Exception e){
				
			}
			try{
				edittext2.setText(ext.get("pf").toString());
			}catch(Exception e){
				
			}
			try{
				edittext3.setText(ext.get("pr").toString());
			}catch(Exception e){
				
			}
			try{
				enabled = ext.get("en").toString().equals("on");
			}catch(Exception e){
				
			}
			listview1.setAdapter(new Listview1Adapter(ir));
			SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
			if (sf.getString("monoforta", "").equals("1")) {
				edittext1.setTypeface(Typeface.MONOSPACE);
				edittext2.setTypeface(Typeface.MONOSPACE);
				edittext3.setTypeface(Typeface.MONOSPACE);
			}
			else {
				edittext1.setTypeface(Typeface.DEFAULT);
				edittext2.setTypeface(Typeface.DEFAULT);
				edittext3.setTypeface(Typeface.DEFAULT);
			}
			if (enabled) {
				dis.setVisibility(View.GONE);
			}
		}catch(Exception e){
			name.setText(e.toString());
		}
	}
	
	@Override
	public void onBackPressed() {
		_save();
		finish();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		SafeMarginUtils.init(this, bg);
		
		Skin.getInstance().setStaticBG(this, 2, false);
	}
	
	@Override
	public void onPause() {
		super.onPause();
		SafeMarginUtils.cleanup();
	}
	public void _save() {
		ext.clear();
		ext.put("en", ((enabled) ? ("on") : ("off")));
		ext.put("ps", edittext1.getText().toString());
		ext.put("pf", edittext2.getText().toString());
		ext.put("pr", edittext3.getText().toString());
		ext.put("sir", "json".concat(JsonUtils.toJson(ir)));
		FileUtil.writeFile(getIntent().getStringExtra("path"), JsonUtils.toJson(ext));
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.intercept, null);
			}
			
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final com.a525team.weekbrowser.SkinTextView siu = _view.findViewById(R.id.siu);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final com.a525team.weekbrowser.SkinTextView rtt = _view.findViewById(R.id.rtt);
			final com.a525team.weekbrowser.SkinTextView rt = _view.findViewById(R.id.rt);
			final com.a525team.weekbrowser.SkinTextView siut = _view.findViewById(R.id.siut);
			final com.a525team.weekbrowser.SkinButton delete = _view.findViewById(R.id.delete);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final com.a525team.weekbrowser.SkinTextView ect = _view.findViewById(R.id.ect);
			final com.a525team.weekbrowser.SkinTextView ec = _view.findViewById(R.id.ec);
			final com.a525team.weekbrowser.SkinTextView mtt = _view.findViewById(R.id.mtt);
			final com.a525team.weekbrowser.SkinTextView mt = _view.findViewById(R.id.mt);
			
			try{
				/*ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();

// Ініціалізація Skin
Skin skin = new Skin();

skin.setBG(siu, 0, false);
skin.setBG(ec, 0, false);
skin.setBG(mt, 0, false);
skin.setBG(rt, 0, false);

siu.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
ec.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
mt.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
rt.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));

siut.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
ect.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
mtt.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
rtt.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));

skin.setBG(delete, 1, false);
delete.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
*/
				rtt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
				siut.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
				ect.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
				mtt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
				delete.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
				siu.setText(ir.get((int)_position).get("siu").toString());
				ec.setText(ir.get((int)_position).get("ec").toString().replace("e", ""));
				mt.setText(ir.get((int)_position).get("mt").toString());
				rt.setText(ir.get((int)_position).get("rt").toString());
				siu.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						BasedDialog.showInput(
						ExtensioneditorActivity.this, 
						"Search",                   // Заголовок
						"",                       // Хінт (підказка)
						false,                    // Тільки цифри? Ні.
						siu.getText().toString(),   // Попередній текст
						userInput -> {            // КОЛБЕК (те, що виконається після натискання ОК)
							ir.get(_position).put("siu", userInput);
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						}
						);
					}
				});
				ec.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						BasedDialog.showInput(
						ExtensioneditorActivity.this, 
						"Error code",                   // Заголовок
						"",                       // Хінт (підказка)
						true,                    // Тільки цифри? Так
						ec.getText().toString(),   // Попередній текст
						userInput -> {            // КОЛБЕК (те, що виконається після натискання ОК)
							ir.get(_position).put("ec", "e"+userInput);
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						}
						);
					}
				});
				mt.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						BasedDialog.showInput(
						ExtensioneditorActivity.this, 
						"MIME type",                   // Заголовок
						"",                       // Хінт (підказка)
						false,                    // Тільки цифри? Ні.
						mt.getText().toString(),   // Попередній текст
						userInput -> {            // КОЛБЕК (те, що виконається після натискання ОК)
							ir.get(_position).put("mt", userInput);
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						}
						);
					}
				});
				rt.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						BasedDialog.showInput(
						ExtensioneditorActivity.this, 
						"Return content",// Заголовок
						"",                       // Хінт (підказка)
						false,                    // Тільки цифри? Ні.
						rt.getText().toString(),   // Попередній текст
						userInput -> {            // КОЛБЕК (те, що виконається після натискання ОК)
							ir.get(_position).put("rt", userInput);
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						}
						);
					}
				});
				delete.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						ir.remove((int)(_position));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
				});
			}catch(Exception e){
				siu.setText("ERROR");
			}
			
			return _view;
		}
	}
}