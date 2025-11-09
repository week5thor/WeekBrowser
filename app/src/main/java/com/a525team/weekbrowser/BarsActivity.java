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
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class BarsActivity extends Activity {
	
	RenderUtils ru;
	BarMan bm;
	private double btn = 0;
	
	private ArrayList<HashMap<String, Object>> btns = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear8;
	private TextView title;
	private TextView st1;
	private CheckBox showsearch;
	private CheckBox searchtop;
	private LinearLayout linear10;
	private TextView sst;
	private SeekBar size;
	private TextView st2;
	private CheckBox showtool;
	private CheckBox tooltop;
	private CheckBox dots;
	private HorizontalScrollView hscroll2;
	private LinearLayout divider3;
	private LinearLayout linear4;
	private EditText clickarg;
	private LinearLayout divider;
	private LinearLayout linear5;
	private EditText longarg;
	private LinearLayout divider2;
	private LinearLayout linear6;
	private LinearLayout linear3;
	private EditText direct;
	private LinearLayout linear11;
	private CheckBox hidescroll;
	private Button hidehint;
	private LinearLayout linear9;
	private TextView sst2;
	private EditText click;
	private Button clickmore;
	private TextView clickhint;
	private TextView sst3;
	private EditText longclick;
	private Button longclickmore;
	private TextView longclickhint;
	private TextView sst4;
	private EditText icon;
	private Button iconmore;
	private Button recicon;
	private Button left;
	private Button right;
	private Button add;
	private Button remove;
	
	private SharedPreferences sf;
	private AlertDialog.Builder hints;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		ThemeManager.applyTheme(this);
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.bars);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		ru = new RenderUtils(BarsActivity.this);
		vscroll1 = findViewById(R.id.vscroll1);
		linear8 = findViewById(R.id.linear8);
		title = findViewById(R.id.title);
		st1 = findViewById(R.id.st1);
		showsearch = findViewById(R.id.showsearch);
		searchtop = findViewById(R.id.searchtop);
		linear10 = findViewById(R.id.linear10);
		sst = findViewById(R.id.sst);
		size = findViewById(R.id.size);
		st2 = findViewById(R.id.st2);
		showtool = findViewById(R.id.showtool);
		tooltop = findViewById(R.id.tooltop);
		dots = findViewById(R.id.dots);
		hscroll2 = findViewById(R.id.hscroll2);
		divider3 = findViewById(R.id.divider3);
		linear4 = findViewById(R.id.linear4);
		clickarg = findViewById(R.id.clickarg);
		divider = findViewById(R.id.divider);
		linear5 = findViewById(R.id.linear5);
		longarg = findViewById(R.id.longarg);
		divider2 = findViewById(R.id.divider2);
		linear6 = findViewById(R.id.linear6);
		linear3 = findViewById(R.id.linear3);
		direct = findViewById(R.id.direct);
		linear11 = findViewById(R.id.linear11);
		hidescroll = findViewById(R.id.hidescroll);
		hidehint = findViewById(R.id.hidehint);
		linear9 = findViewById(R.id.linear9);
		sst2 = findViewById(R.id.sst2);
		click = findViewById(R.id.click);
		clickmore = findViewById(R.id.clickmore);
		clickhint = findViewById(R.id.clickhint);
		sst3 = findViewById(R.id.sst3);
		longclick = findViewById(R.id.longclick);
		longclickmore = findViewById(R.id.longclickmore);
		longclickhint = findViewById(R.id.longclickhint);
		sst4 = findViewById(R.id.sst4);
		icon = findViewById(R.id.icon);
		iconmore = findViewById(R.id.iconmore);
		recicon = findViewById(R.id.recicon);
		left = findViewById(R.id.left);
		right = findViewById(R.id.right);
		add = findViewById(R.id.add);
		remove = findViewById(R.id.remove);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		hints = new AlertDialog.Builder(this);
		
		showsearch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("searchpan", "").equals("0")) {
					sf.edit().putString("searchpan", "1").commit();
					showsearch.setChecked(true);
				} else {
					sf.edit().putString("searchpan", "0").commit();
					showsearch.setChecked(false);
				}
			}
		});
		
		searchtop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("searchpanelpos", "").equals("0")) {
					sf.edit().putString("searchpanelpos", "1").commit();
					searchtop.setChecked(true);
				} else {
					sf.edit().putString("searchpanelpos", "0").commit();
					searchtop.setChecked(false);
				}
			}
		});
		
		size.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("button", String.valueOf((long)(_progressValue + 20))).commit();
				sst.setText(getString(R.string.buttons_size).concat(" (").concat(String.valueOf((long)(_progressValue + 20)).concat(" dp)")));
				_init();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		showtool.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("navpan", "").equals("0")) {
					sf.edit().putString("navpan", "1").commit();
					showtool.setChecked(true);
				} else {
					sf.edit().putString("navpan", "0").commit();
					showtool.setChecked(false);
				}
			}
		});
		
		tooltop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("navpanpos", "").equals("0")) {
					sf.edit().putString("navpanpos", "1").commit();
					tooltop.setChecked(true);
				} else {
					sf.edit().putString("navpanpos", "0").commit();
					tooltop.setChecked(false);
				}
			}
		});
		
		dots.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("toolbardot", "").equals("0")) {
					sf.edit().putString("toolbardot", "1").commit();
					dots.setChecked(true);
				} else {
					sf.edit().putString("toolbardot", "0").commit();
					dots.setChecked(false);
				}
				_init();
			}
		});
		
		clickarg.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				btns.get((int)btn).put("clickarg", _charSeq);
				_upd();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		longarg.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				btns.get((int)btn).put("longarg", _charSeq);
				_upd();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		direct.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				sf.edit().putString("toolbar", _charSeq).commit();
				_init();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		hidescroll.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				if (sf.getString("hidepanels", "").equals("0")) {
					sf.edit().putString("hidepanels", "1").commit();
					hidescroll.setChecked(true);
				} else {
					sf.edit().putString("hidepanels", "0").commit();
					hidescroll.setChecked(false);
				}
			}
		});
		
		hidehint.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				hints.setTitle("?");
				hints.setMessage(getString(R.string.hide_panel_hint));
				hints.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = hints.create();
				dddddd.setOnShowListener(d -> {
					            Window window = dddddd.getWindow();
							if (window != null) {
							if(WTF.SDK_INT() > 31 && ru.isOn()){
							        ru.on();
										window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
										window.setDimAmount(0f);
								} else {
							        ExtendedDataHolder datah = ExtendedDataHolder.getInstance();
							            window.setDimAmount(Float.parseFloat(datah.getData("dvalp")));
							        }
						}
				});
				dddddd.setOnDismissListener(d -> {
						ru.off();
				});
				dddddd.show();
				
			}
		});
		
		click.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				try{
					btns.get((int)btn).put("click", _charSeq);
					recicon.setText(bm.iconRecom(Integer.parseInt(_charSeq)));
					clickhint.setText(bm.hint(Integer.parseInt(_charSeq)));
					_upd();
				}catch(Exception e){
					 
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		clickmore.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bm.showActionSelectionDialog(BarsActivity.this, actionCode -> {  
					click.setText(String.valueOf(actionCode)); 
				});
			}
		});
		
		longclick.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				try{
					btns.get((int)btn).put("long", _charSeq);
					longclickhint.setText(bm.hint(Integer.parseInt(_charSeq)));
					_upd();
				}catch(Exception e){
					 
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		longclickmore.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bm.showActionSelectionDialog(BarsActivity.this, actionCode -> {  
					longclick.setText(String.valueOf(actionCode)); 
				});
			}
		});
		
		icon.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				btns.get((int)btn).put("icon", _charSeq);
				_upd();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		iconmore.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				IconPickerDialog.show(BarsActivity.this, selectedIcon -> {
					        icon.setText(icon.getText().toString() + selectedIcon);     icon.setSelection(icon.getText().length());
					    });
			}
		});
		
		recicon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				icon.setText(recicon.getText().toString());
			}
		});
		
		left.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try{
					Collections.swap(btns, (int)(btn), (int)(btn - 1));
					btn--;
					_upd();
				}catch(Exception e){
					 
				}
			}
		});
		
		right.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try{
					Collections.swap(btns, (int)(btn), (int)(btn + 1));
					btn++;
					_upd();
				}catch(Exception e){
					 
				}
			}
		});
		
		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try{
					{HashMap<String, Object> _item = new HashMap<>();
						
						_item.put("click", "-990");
						_item.put("long", "-990");
						_item.put("icon", "?");
						btns.add(_item);}
					_setBtnNum(btns.size() - 1);
					_upd();
				}catch(Exception e){
					 
				}
			}
		});
		
		remove.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try{
					btns.remove((int)(btn));
					if (btn >= btns.size()) {
						btn = btn - 1;
					}
					_upd();
				}catch(Exception e){
					 
				}
			}
		});
	}
	
	private void initializeLogic() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		try{
			showtool.setChecked(sf.getString("navpan", "").equals("1"));
			showsearch.setChecked(sf.getString("searchpan", "").equals("1"));
			hidescroll.setChecked(sf.getString("hidepanels", "").equals("1"));
			searchtop.setChecked(sf.getString("searchpanelpos", "").equals("1"));
			tooltop.setChecked(sf.getString("navpanpos", "").equals("1"));
			dots.setChecked(sf.getString("toolbardot", "").equals("1"));
			size.setProgress((int)Integer.parseInt(sf.getString("button", "")) - 20);
		}catch(Exception e){}
		sst.setText(getString(R.string.buttons_size).concat(" (").concat(String.valueOf((long)(size.getProgress() + 20)).concat(" dp)")));
		direct.setText(sf.getString("toolbar", ""));
		btns = bm.sfToArray(sf.getString("toolbar", ""));
		_setBtnNum(0);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		_init();
		colorify.applyColorifyToAll(getWindow().getDecorView().getRootView());
		
		SafeMarginUtils.init(this, linear8);
		
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		
		SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		// Ініціалізація Skin
		Skin skin = new Skin();
		
		skin.setBG(getWindow().getDecorView(), 2, false);
		
		skin.setBG(divider, 0, false);
		skin.setBG(divider2, 0, false);
		skin.setBG(divider3, 0, false);
		
		skin.setBG(clickmore, 0, false);
		skin.setBG(longclickmore, 0, false);
		skin.setBG(iconmore, 0, false);
		
		skin.setBG(left, 0, false);
		skin.setBG(right, 0, false);
		skin.setBG(add, 0, false);
		skin.setBG(remove, 1, false);
		skin.setBG(recicon, 1, false);
		
		skin.setBG(hidehint, 1, false);
		
		title.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		st1.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		st2.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		sst.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		sst2.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		sst3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		sst4.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		
		direct.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		direct.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		
		click.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		longclick.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		icon.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		clickarg.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		longarg.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		
		click.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		longclick.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		icon.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		clickarg.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		longarg.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		
		clickhint.setTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		longclickhint.setTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		
		clickmore.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		longclickmore.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		iconmore.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		
		left.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		right.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		add.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		remove.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		recicon.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		
		hidehint.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		
		showtool.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		tooltop.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		showsearch.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		searchtop.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		hidescroll.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		dots.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		
		if (sf.getString("monoforta", "").equals("1")) {
				click.setTypeface(Typeface.MONOSPACE);
			    clickarg.setTypeface(Typeface.MONOSPACE);
			    longarg.setTypeface(Typeface.MONOSPACE);
				longclick.setTypeface(Typeface.MONOSPACE);
				direct.setTypeface(Typeface.MONOSPACE);
		} else {
				click.setTypeface(Typeface.DEFAULT);
			    clickarg.setTypeface(Typeface.DEFAULT);
			    longarg.setTypeface(Typeface.DEFAULT);
				longclick.setTypeface(Typeface.DEFAULT);
				direct.setTypeface(Typeface.DEFAULT);
		}
		clickmore.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		longclickmore.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		icon.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		iconmore.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		left.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		right.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		add.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		remove.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		recicon.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
	}
	
	@Override
	public void onPause() {
		super.onPause();
		SafeMarginUtils.cleanup();
	}
	public void _init() {
		bm = new BarMan(linear9, BarsActivity.this);
	}
	
	
	public void _setBtnNum(final double _v) {
		btn = _v;
		try{
			click.setText(btns.get((int)_v).get("click").toString());
		}catch(Exception e){
			click.setText("-990");
		}
		try{
			longclick.setText(btns.get((int)_v).get("long").toString());
		}catch(Exception e){
			longclick.setText("-990");
		}
		try{
			icon.setText(btns.get((int)_v).get("icon").toString());
		}catch(Exception e){
			icon.setText("");
		}
		try{
			clickarg.setText(btns.get((int)_v).get("clickarg").toString());
		}catch(Exception e){
			clickarg.setText("");
		}
		try{
			longarg.setText(btns.get((int)_v).get("longarg").toString());
		}catch(Exception e){
			longarg.setText("");
		}
		_init();
	}
	
	
	public double _getBtnNum() {
		return (btn);
	}
	
	
	public void _upd() {
		String x = bm.arrayToSf(btns);
		sf.edit().putString("toolbar", x).commit();
		direct.setText(x);
		bm.init();
	}
	
	
	public void _Languag() {
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