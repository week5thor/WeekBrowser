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
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class DbgActivity extends Activity {
	
	RenderUtils ru;
	
	private ScrollView vscroll2;
	private LinearLayout linear1;
	private TextView name;
	private CheckBox don;
	private TextView blur;
	private TextView bxind;
	private SeekBar bx;
	private TextView byind;
	private SeekBar by;
	private TextView huerotate;
	private TextView rrind;
	private SeekBar rr;
	private TextView rgind;
	private SeekBar rg;
	private TextView rbind;
	private SeekBar rb;
	private TextView saturation;
	private TextView satind;
	private SeekBar sat;
	private TextView brightness;
	private TextView vrind;
	private SeekBar vr;
	private TextView vgind;
	private SeekBar vg;
	private TextView vbind;
	private SeekBar vb;
	private TextView alpha;
	private TextView alpind;
	private SeekBar alp;
	
	private SharedPreferences sf;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		ThemeManager.applyTheme(this);
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.dbg);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll2 = findViewById(R.id.vscroll2);
		linear1 = findViewById(R.id.linear1);
		name = findViewById(R.id.name);
		don = findViewById(R.id.don);
		blur = findViewById(R.id.blur);
		bxind = findViewById(R.id.bxind);
		bx = findViewById(R.id.bx);
		byind = findViewById(R.id.byind);
		by = findViewById(R.id.by);
		huerotate = findViewById(R.id.huerotate);
		rrind = findViewById(R.id.rrind);
		rr = findViewById(R.id.rr);
		rgind = findViewById(R.id.rgind);
		rg = findViewById(R.id.rg);
		rbind = findViewById(R.id.rbind);
		rb = findViewById(R.id.rb);
		saturation = findViewById(R.id.saturation);
		satind = findViewById(R.id.satind);
		sat = findViewById(R.id.sat);
		brightness = findViewById(R.id.brightness);
		vrind = findViewById(R.id.vrind);
		vr = findViewById(R.id.vr);
		vgind = findViewById(R.id.vgind);
		vg = findViewById(R.id.vg);
		vbind = findViewById(R.id.vbind);
		vb = findViewById(R.id.vb);
		alpha = findViewById(R.id.alpha);
		alpind = findViewById(R.id.alpind);
		alp = findViewById(R.id.alp);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		
		don.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				ExtendedDataHolder dh = ExtendedDataHolder.getInstance();
				if (sf.getString("don", "").equals("0")) {
					sf.edit().putString("don", "1").commit();
					don.setChecked(true);
					dh.setData("don", "1");
				} else {
					sf.edit().putString("don", "0").commit();
					don.setChecked(false);
					dh.setData("don", "0");
				}
			}
		});
		
		bx.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("dblurx", _progressValue);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		by.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("dblury", _progressValue);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		rr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("drred", _progressValue);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		rg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("drgreen", _progressValue);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		rb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("drblue", _progressValue);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		sat.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("dsatur", _progressValue / 10.d);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		vr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("dvred", _progressValue / 10.d);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		vg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("dvgreen", _progressValue / 10.d);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		vb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("dvblue", _progressValue / 10.d);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
		
		alp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				_dlgset("dvalp", _progressValue / 100.d);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				ru.off();
			}
		});
	}
	
	private void initializeLogic() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		ru = new RenderUtils(DbgActivity.this);
		don.setChecked(sf.getString("don", "").equals("1"));
		bx.setProgress((int)Double.parseDouble(sf.getString("dblurx", "")));
		by.setProgress((int)Double.parseDouble(sf.getString("dblury", "")));
		rr.setProgress((int)Double.parseDouble(sf.getString("drred", "")));
		rg.setProgress((int)Double.parseDouble(sf.getString("drgreen", "")));
		rb.setProgress((int)Double.parseDouble(sf.getString("drblue", "")));
		sat.setProgress((int)Double.parseDouble(sf.getString("dsatur", "")) * 10);
		vr.setProgress((int)Double.parseDouble(sf.getString("dvred", "")) * 10);
		vg.setProgress((int)Double.parseDouble(sf.getString("dvgreen", "")) * 10);
		vb.setProgress((int)Double.parseDouble(sf.getString("dvblue", "")) * 10);
		alp.setProgress((int)Double.parseDouble(sf.getString("dvalp", "")) * 100);
		_updind();
		ru.off();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		SafeMarginUtils.init(this, vscroll2);
		try{
			Skin skin = new Skin();
			
			skin.setBG(findViewById(android.R.id.content), 2, false);
			
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			name.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			don.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			blur.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			bxind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			byind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			huerotate.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			rrind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			rgind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			rbind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			saturation.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			satind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			brightness.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			vrind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			vgind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			vbind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			alpha.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			alpind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			colorify.applyColorifyToAll(getWindow().getDecorView().getRootView());
		}catch(Exception e){
			 
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		SafeMarginUtils.cleanup();
	}
	public void _dlgset(final String _n, final double _v) {
		ExtendedDataHolder dh = ExtendedDataHolder.getInstance();
			dh.setData(_n, String.valueOf(_v));
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		sf.edit().putString(_n, String.valueOf(_v)).commit();
		ru.on();
		_updind();
	}
	
	
	public void _updind() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		bxind.setText(sf.getString("dblurx", ""));
		byind.setText(sf.getString("dblury", ""));
		rrind.setText(sf.getString("drred", ""));
		rgind.setText(sf.getString("drgreen", ""));
		rbind.setText(sf.getString("drblue", ""));
		satind.setText(sf.getString("dsatur", ""));
		vrind.setText(sf.getString("dvred", ""));
		vgind.setText(sf.getString("dvgreen", ""));
		vbind.setText(sf.getString("dvblue", ""));
		alpind.setText(sf.getString("dvalp", ""));
	}
	
}