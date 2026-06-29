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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.a525team.weekbrowser.SkinCheckBox;
import com.a525team.weekbrowser.SkinSeekBar;
import com.a525team.weekbrowser.SkinTextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class DbgActivity extends Activity {
	
	private ScrollView vscroll2;
	private LinearLayout linear1;
	private SkinTextView name;
	private SkinCheckBox don;
	private TextView blur;
	private SkinTextView bxind;
	private SkinSeekBar bx;
	private SkinTextView byind;
	private SkinSeekBar by;
	private TextView huerotate;
	private SkinTextView rrind;
	private SkinSeekBar rr;
	private SkinTextView rgind;
	private SkinSeekBar rg;
	private SkinTextView rbind;
	private SkinSeekBar rb;
	private TextView saturation;
	private SkinTextView satind;
	private SkinSeekBar sat;
	private TextView brightness;
	private SkinTextView vrind;
	private SkinSeekBar vr;
	private SkinTextView vgind;
	private SkinSeekBar vg;
	private SkinTextView vbind;
	private SkinSeekBar vb;
	private TextView alpha;
	private SkinTextView alpind;
	private SkinSeekBar alp;
	
	private SharedPreferences sf;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		ThemeManager.applyTheme(this);
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
				RenderUtils.off(DbgActivity.this);
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
				RenderUtils.off(DbgActivity.this);
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
				RenderUtils.off(DbgActivity.this);
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
				RenderUtils.off(DbgActivity.this);
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
				RenderUtils.off(DbgActivity.this);
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
				RenderUtils.off(DbgActivity.this);
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
				RenderUtils.off(DbgActivity.this);
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
				RenderUtils.off(DbgActivity.this);
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
				RenderUtils.off(DbgActivity.this);
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
				RenderUtils.off(DbgActivity.this);
			}
		});
	}
	
	private void initializeLogic() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
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
		RenderUtils.off(DbgActivity.this);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		SafeMarginUtils.init(this, vscroll2);
		
		Skin.getInstance().setStaticBG(this, 2, false);
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
		RenderUtils.on(DbgActivity.this);
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