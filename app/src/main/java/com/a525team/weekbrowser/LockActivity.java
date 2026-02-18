package com.a525team.weekbrowser;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.widget.Toast;

public class LockActivity extends Activity {
	
	private String pin = "";
	private double adder = 0;
	
	private TextView title;
	private TextView ucan;
	private TextView code;
	private LinearLayout linear7;
	private LinearLayout linear2;
	private LinearLayout linear1;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private Button k1;
	private Button k2;
	private Button k3;
	private Button k4;
	private Button k5;
	private Button k6;
	private Button k7;
	private Button k8;
	private Button k9;
	private Button erase;
	private Button k0;
	private Button done;
	
	private Intent intent = new Intent();
	private SharedPreferences sf;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		ThemeManager.applyTheme(this);
		setContentView(R.layout.lock);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		title = findViewById(R.id.title);
		ucan = findViewById(R.id.ucan);
		code = findViewById(R.id.code);
		linear7 = findViewById(R.id.linear7);
		linear2 = findViewById(R.id.linear2);
		linear1 = findViewById(R.id.linear1);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		k1 = findViewById(R.id.k1);
		k2 = findViewById(R.id.k2);
		k3 = findViewById(R.id.k3);
		k4 = findViewById(R.id.k4);
		k5 = findViewById(R.id.k5);
		k6 = findViewById(R.id.k6);
		k7 = findViewById(R.id.k7);
		k8 = findViewById(R.id.k8);
		k9 = findViewById(R.id.k9);
		erase = findViewById(R.id.erase);
		k0 = findViewById(R.id.k0);
		done = findViewById(R.id.done);
		sf = getSharedPreferences("code", Activity.MODE_PRIVATE);
		
		//OnTouch
		k1.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event){
				int ev = event.getAction();
				switch (ev) {
					case MotionEvent.ACTION_DOWN:
					
					_impl("1");
					
					break;
					case MotionEvent.ACTION_UP:
					
					
					
					break;
				} return true;
			}
		});
		
		//OnTouch
		k2.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event){
				int ev = event.getAction();
				switch (ev) {
					case MotionEvent.ACTION_DOWN:
					
					_impl("2");
					
					break;
					case MotionEvent.ACTION_UP:
					
					
					
					break;
				} return true;
			}
		});
		
		//OnTouch
		k3.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event){
				int ev = event.getAction();
				switch (ev) {
					case MotionEvent.ACTION_DOWN:
					
					_impl("3");
					
					break;
					case MotionEvent.ACTION_UP:
					
					
					
					break;
				} return true;
			}
		});
		
		//OnTouch
		k4.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event){
				int ev = event.getAction();
				switch (ev) {
					case MotionEvent.ACTION_DOWN:
					
					_impl("4");
					
					break;
					case MotionEvent.ACTION_UP:
					
					
					
					break;
				} return true;
			}
		});
		
		//OnTouch
		k5.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event){
				int ev = event.getAction();
				switch (ev) {
					case MotionEvent.ACTION_DOWN:
					
					_impl("5");
					
					break;
					case MotionEvent.ACTION_UP:
					
					
					
					break;
				} return true;
			}
		});
		
		//OnTouch
		k6.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event){
				int ev = event.getAction();
				switch (ev) {
					case MotionEvent.ACTION_DOWN:
					
					_impl("6");
					
					break;
					case MotionEvent.ACTION_UP:
					
					
					
					break;
				} return true;
			}
		});
		
		//OnTouch
		k7.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event){
				int ev = event.getAction();
				switch (ev) {
					case MotionEvent.ACTION_DOWN:
					
					_impl("7");
					
					break;
					case MotionEvent.ACTION_UP:
					
					
					
					break;
				} return true;
			}
		});
		
		//OnTouch
		k8.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event){
				int ev = event.getAction();
				switch (ev) {
					case MotionEvent.ACTION_DOWN:
					
					_impl("8");
					
					break;
					case MotionEvent.ACTION_UP:
					
					
					
					break;
				} return true;
			}
		});
		
		//OnTouch
		k9.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event){
				int ev = event.getAction();
				switch (ev) {
					case MotionEvent.ACTION_DOWN:
					
					_impl("9");
					
					break;
					case MotionEvent.ACTION_UP:
					
					
					
					break;
				} return true;
			}
		});
		
		erase.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				pin = "";
				code.setText("######");
				return true;
			}
		});
		
		erase.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try{
					pin = pin.substring((int)(0), (int)(pin.length() - 1));
					_impl("");
				}catch(Exception e){
					
				}
				if (pin.equals("")) {
					code.setText("######");
				}
			}
		});
		
		//OnTouch
		k0.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event){
				int ev = event.getAction();
				switch (ev) {
					case MotionEvent.ACTION_DOWN:
					
					_impl("0");
					
					break;
					case MotionEvent.ACTION_UP:
					
					
					
					break;
				} return true;
			}
		});
		
		//OnTouch
		done.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event){
				int ev = event.getAction();
				switch (ev) {
					case MotionEvent.ACTION_DOWN:
					
					final SharedPreferences sf = getSharedPreferences("code", Context.MODE_PRIVATE);
					if (sf.contains("code") && pin.equals(sf.getString("code", ""))) {
						ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
						dataHolder.setData("safe", "1");
						/*
intent.setClass(getApplicationContext(), MainActivity.class);
startActivity(intent);
*/
						finish();
					} else {
						SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.incorrect_password));
					}
					
					break;
					case MotionEvent.ACTION_UP:
					
					
					
					break;
				} return true;
			}
		});
	}
	
	private void initializeLogic() {
		
		
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		Skin skin = new Skin();
		skin.setBG(getWindow().getDecorView(), 2, false);
		
		title.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		code.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		ucan.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		
		k1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		k2.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		k3.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		k4.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		k5.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		k6.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		k7.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		k8.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		k9.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		k0.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		erase.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		done.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		
		
		skin.setBG(k1, 0, false);
		skin.setBG(k2, 0, false);
		skin.setBG(k3, 0, false);
		skin.setBG(k4, 0, false);
		skin.setBG(k5, 0, false);
		skin.setBG(k6, 0, false);
		skin.setBG(k7, 0, false);
		skin.setBG(k8, 0, false);
		skin.setBG(k9, 0, false);
		skin.setBG(k0, 0, false);
		skin.setBG(erase, 1, false);
		skin.setBG(done, 1, false);
		
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M && isBiometricAvailable(this)) {
			startBiometricAuthentication();
		} else {
			
			
			ucan.setVisibility(View.GONE);
		}
		adder = SketchwareUtil.getRandom((int)(0), (int)(9));
	}
	
	
	@Override
	public void onBackPressed() {
		
	}
	
	@Override
	public void onResume() {
		super.onResume();
		SafeMarginUtils.init(this, findViewById(android.R.id.content));
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
	
	private boolean isBiometricAvailable(Context context) {
		KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
		FingerprintManager fingerprintManager = (FingerprintManager) context.getSystemService(Context.FINGERPRINT_SERVICE);
		
		// Check if the device has a fingerprint sensor and if it's configured
		if (fingerprintManager != null && keyguardManager != null) {
			return fingerprintManager.isHardwareDetected() &&
			fingerprintManager.hasEnrolledFingerprints() &&
			keyguardManager.isKeyguardSecure();
		}
		return false;
	}
	
	private void startBiometricAuthentication() {
		FingerprintManager fingerprintManager = (FingerprintManager) getSystemService(Context.FINGERPRINT_SERVICE);
		if (fingerprintManager != null) {
			FingerprintManager.CryptoObject cryptoObject = null;
			FingerprintManager.AuthenticationCallback callback = new FingerprintManager.AuthenticationCallback() {
				@Override
				public void onAuthenticationError(int errorCode, CharSequence errString) {
					super.onAuthenticationError(errorCode, errString);
					showToast("Authentication error: " + errString);
					ucan.setVisibility(View.GONE);
				}
				
				@Override
				public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
					super.onAuthenticationSucceeded(result);
					ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
					dataHolder.setData("safe", "1");
					// intent.setClass(getApplicationContext(), MainActivity.class);
					//   startActivity(intent);
					finish();
				}
				
				@Override
				public void onAuthenticationFailed() {
					super.onAuthenticationFailed();
					showToast(getString(R.string.incorrect_bio));
				}
			};
			
			fingerprintManager.authenticate(cryptoObject, null, 0, callback, null);
		}
	}
	
	private void showToast(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}
	
	
	{
	}
	
	
	public void _impl(final String _add) {
		if (code.getText().toString().equals("######")) {
			code.setText("");
		}
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		if (sf.getString("hidepass2", "").equals("0")) {
			pin = pin.concat(_add);
			if (sf.getString("hidepass", "").equals("0")) {
				code.setText(pin);
			} else {
				if (pin.length()>code.getText().toString().length()) {
					for(int i=code.getText().toString().length(); i<pin.length(); i++){
						code.setText(code.getText().toString().concat(String.valueOf((long)(Math.round(SketchwareUtil.getRandom((int)(0), (int)(9)))))));
					}
				} else {
					code.setText(code.getText().toString().substring(pin.length()));
				}
			}
		} else {
			pin = pin.concat(String.valueOf((long)(((((Integer.parseInt(_add) - adder) % 10) < 0) ? ((int)((Integer.parseInt(_add) - adder) % 10) + 10) : ((int)(Integer.parseInt(_add) - adder) % 10)))));
			if (sf.getString("hidepass", "").equals("0")) {
				code.setText(String.valueOf((long)(((((Integer.parseInt(_add) - adder) % 10) < 0) ? ((int)((Integer.parseInt(_add) - adder) % 10) + 10) : ((int)(Integer.parseInt(_add) - adder) % 10)))));
			} else {
				code.setText("");
				for(int i=0; i<(int)adder; i++){
					code.setText(code.getText().toString().concat(String.valueOf((long)(Math.round(SketchwareUtil.getRandom((int)(0), (int)(9)))))));
				}
			}
		}
	}
	
}