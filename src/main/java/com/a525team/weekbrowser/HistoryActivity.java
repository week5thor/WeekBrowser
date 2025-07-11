package com.a525team.weekbrowser;

import android.Manifest;
import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class HistoryActivity extends Activity {
	
	private double date = 0;
	private double itemCount = 0;
	private double date1 = 0;
	private double date2 = 0;
	private double size = 0;
	private String sze = "";
	private double historysize = 0;
	private String sizeitem = "";
	private double timeleft = 0;
	Colorify colorify = new Colorify();
	
	private ArrayList<HashMap<String, Object>> history = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> searchedhistory = new ArrayList<>();
	private ArrayList<String> languag = new ArrayList<>();
	
	private LinearLayout linear3;
	private LinearLayout linear1;
	private Button showhide;
	private ListView listview1;
	private ListView listview2;
	private TextView numofelem;
	private TextView hintt;
	private SeekBar seekbar1;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private Button deletee;
	private TextView textview3;
	private AutoCompleteTextView autocomplete1;
	private TextView remaining;
	private AutoCompleteTextView autocomplete2;
	
	private Intent i = new Intent();
	private AlertDialog.Builder dlg;
	private ObjectAnimator show = new ObjectAnimator();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.history);
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
		        setContentView(R.layout.history);
		linear3 = findViewById(R.id.linear3);
		linear1 = findViewById(R.id.linear1);
		showhide = findViewById(R.id.showhide);
		listview1 = findViewById(R.id.listview1);
		listview2 = findViewById(R.id.listview2);
		numofelem = findViewById(R.id.numofelem);
		hintt = findViewById(R.id.hintt);
		seekbar1 = findViewById(R.id.seekbar1);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		deletee = findViewById(R.id.deletee);
		textview3 = findViewById(R.id.textview3);
		autocomplete1 = findViewById(R.id.autocomplete1);
		remaining = findViewById(R.id.remaining);
		autocomplete2 = findViewById(R.id.autocomplete2);
		dlg = new AlertDialog.Builder(this);
		
		//OnTouch
		showhide.setOnTouchListener(new View.OnTouchListener(){
				@Override
				public boolean onTouch(View v, MotionEvent event){
						int ev = event.getAction();
						switch (ev) {
								case MotionEvent.ACTION_DOWN:
								
								 if (linear1.getVisibility() == View.VISIBLE) {
						linear1.setVisibility(View.GONE);
						showhide.setText("▽▼▼▼▼▼▽");
					}
					else {
						linear1.setVisibility(View.VISIBLE);
						showhide.setText("△▲▲▲▲▲△");
						show.setTarget(linear1);
						show.setPropertyName("scaleY");
						show.setFloatValues((float)(0), (float)(1));
						show.setDuration((int)(500));
						show.start();
					}
								
								break;
								case MotionEvent.ACTION_UP:
								
								 
								
								break;
						} return true;
				}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				i.setClass(getApplicationContext(), IntentActivity.class);
				i.setData(Uri.parse(history.get((int)_position).get("url").toString()));
				startActivity(i);
				finish();
			}
		});
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				history.remove((int)(_position));
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/history.json", new Gson().toJson(history));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				return true;
			}
		});
		
		listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				i.setClass(getApplicationContext(), IntentActivity.class);
				i.setData(Uri.parse(searchedhistory.get((int)_position).get("url").toString()));
				startActivity(i);
				finish();
			}
		});
		
		seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (_progressValue == 0) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt", "5");
				}
				if (_progressValue == 1) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt", "10");
				}
				if (_progressValue == 2) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt", "20");
				}
				if (_progressValue == 3) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt", "50");
				}
				if (_progressValue == 4) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt", "100");
				}
				if (_progressValue == 5) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt", "200");
				}
				if (_progressValue == 6) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt", "500");
				}
				if (_progressValue == 7) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt", "1000");
				}
				if (_progressValue == 8) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt", "2000");
				}
				if (_progressValue == 9) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt", "5000");
				}
				if (_progressValue == 10) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt", "10000");
				}
				if (_progressValue == 11) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt", "20000");
				}
				if (_progressValue == 12) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt", "50000");
				}
				if (_progressValue == 13) {
					FileUtil.writeFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt", "100000");
				}
				double savedNum = Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt"));
				double historySize = history.size();
				double fileLength = FileUtil.getFileLength("/storage/emulated/0/WeekBrowser/history.json");
				
				double result = savedNum * (fileLength / historySize);
				
				String[] suffixes;
				try {
					    suffixes = new String[]{languag.get((int)(27)), languag.get((int)(28)), languag.get((int)(29))};
				} catch (Exception e) {
					    if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
						        suffixes = new String[]{" B", " KiB", " MiB"};
						    } else {
						        suffixes = new String[]{" Б", " КіБ", " МіБ"};
						    }
				}
				
				int suffixIndex = 0;
				
				while (result >= 1024 && suffixIndex < suffixes.length - 1) {
					    result /= 1024;
					    suffixIndex++;
				}
				
				// Закруглення до двох знаків після коми
				size = Math.round(result * 100.0) / 100.0;
				sze = suffixes[suffixIndex];
				
				try{
					timeleft = Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) / Double.parseDouble(autocomplete1.getText().toString());
				}catch(Exception e){
					autocomplete1.setText("50");
				}
				timeleft = Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) / Double.parseDouble(autocomplete1.getText().toString());
				try{
					remaining.setText(languag.get((int)(25)) + (long)(timeleft) +  languag.get((int)(26)) + size + sze + languag.get((int)(30)));
					
				}catch(Exception e){
					if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
						remaining.setText("sites on day is remain to " + (long)(timeleft) + " days and drain approximately " + size + sze + " of device ROM");
						
					}
					else {
						remaining.setText("сайтів на добу історії вистачить на " + (long)(timeleft) + " днів та займатиме орієнтовно " + size + sze + " внутрішньої пам'яті");
						
					}
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 5) {
					seekbar1.setProgress((int)0);
					try{
						numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)))));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements")));
						}
						else {
							numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів")));
						}
					}
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 10) {
					seekbar1.setProgress((int)1);
					try{
						numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)))));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements")));
						}
						else {
							numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів")));
						}
					}
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 20) {
					seekbar1.setProgress((int)2);
					try{
						numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)))));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements")));
						}
						else {
							numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів")));
						}
					}
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 50) {
					seekbar1.setProgress((int)3);
					try{
						numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)))));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements")));
						}
						else {
							numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів")));
						}
					}
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 100) {
					seekbar1.setProgress((int)4);
					try{
						numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)))));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements")));
						}
						else {
							numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів")));
						}
					}
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 200) {
					seekbar1.setProgress((int)5);
					try{
						numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)))));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements")));
						}
						else {
							numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів")));
						}
					}
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 500) {
					seekbar1.setProgress((int)6);
					try{
						numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)))));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements")));
						}
						else {
							numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів")));
						}
					}
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 1000) {
					seekbar1.setProgress((int)7);
					try{
						numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)))));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements")));
						}
						else {
							numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів")));
						}
					}
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 2000) {
					seekbar1.setProgress((int)8);
					try{
						numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)).concat(languag.get((int)(20))))));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements (not recomended on low-end device)")));
						}
						else {
							numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів (на слабких пристроях не рекомендовано)")));
						}
					}
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 5000) {
					seekbar1.setProgress((int)9);
					try{
						numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)).concat(languag.get((int)(20))))));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements (not recomended on low-end device)")));
						}
						else {
							numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів (на слабких пристроях не рекомендовано)")));
						}
					}
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 10000) {
					seekbar1.setProgress((int)10);
					try{
						numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)).concat(languag.get((int)(21))))));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements (not recomended on low-end & medium device)")));
						}
						else {
							numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів (на слабких та середніх пристроях не рекомендовано)")));
						}
					}
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 20000) {
					seekbar1.setProgress((int)11);
					try{
						numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)).concat(languag.get((int)(21))))));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements (not recomended on low-end & medium device)")));
						}
						else {
							numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів (на слабких та середніх пристроях не рекомендовано)")));
						}
					}
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 50000) {
					seekbar1.setProgress((int)12);
					try{
						numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)).concat(languag.get((int)(113))))));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements (not recomended)")));
						}
						else {
							numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів (не рекомендовано)")));
						}
					}
				}
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 100000) {
					seekbar1.setProgress((int)13);
					try{
						numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)).concat(languag.get((int)(113))))));
					}catch(Exception e){
						if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
							numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements (not recomended)")));
						}
						else {
							numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів (не рекомендовано)")));
						}
					}
				}
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		deletee.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dlg.setTitle("!!!");
				dlg.setMessage(getString(R.string.do_you_want_delete_all));
				dlg.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/history.json", "[{\"date\":\"very long ago\",\"name\":\"༺YOUR HISTORY༻\",\"url\":\"\"}]");
						history = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/history.json"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
				});
				dlg.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				dlg.create().show();
			}
		});
		
		autocomplete1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				try{
					timeleft = Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) / Double.parseDouble(_charSeq);
				}catch(Exception e){
					 
				}
				try{
					remaining.setText(languag.get((int)(25)) + (long)(timeleft) +  languag.get((int)(26)) + size + sze + languag.get((int)(30)));
					
				}catch(Exception e){
					if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
						remaining.setText("sites on day is remain to " + (long)(timeleft) + " days and drain approximately " + size + sze + " of device ROM");
						
					}
					else {
						remaining.setText("сайтів на добу історії вистачить на " + (long)(timeleft) + " днів та займатиме орієнтовно " + size + sze + " внутрішньої пам'яті");
						
					}
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		autocomplete2.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (!_charSeq.isEmpty()) {
					searchedhistory.clear();
					for (int i = 0; i < (int)(history.size()); i++) {
						if (history.get((int)i).get("name").toString().toLowerCase().contains(_charSeq.toLowerCase()) || (history.get((int)i).get("date").toString().toLowerCase().contains(_charSeq.toLowerCase()) || history.get((int)i).get("url").toString().toLowerCase().contains(_charSeq.toLowerCase()))) {
							searchedhistory.add(history.get((int)(i)));
						}
					}
					((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
					listview2.setVisibility(View.VISIBLE);
					listview1.setVisibility(View.GONE);
					itemCount = listview2.getCount();
					listview2.setSelection((int)itemCount);
				}
				else {
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					listview2.setVisibility(View.GONE);
					listview1.setVisibility(View.VISIBLE);
					itemCount = listview1.getCount();
					listview1.setSelection((int)itemCount);
				}
				/*
if (history.get((int)i).get("name").toString().contains(_charSeq) || (history.get((int)i).get("date").toString().contains(_charSeq) || history.get((int)i).get("url").toString().contains(_charSeq))) {
searchedhistory.add(history.get((int)(i)));
}
*/
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
		linear1.setVisibility(View.GONE);
		if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
			languag = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Language.welang"), new TypeToken<ArrayList<String>>(){}.getType());
		}
		history = new Gson().fromJson(FileUtil.readFile("/storage/emulated/0/WeekBrowser/history.json"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		listview1.setAdapter(new Listview1Adapter(history));
		listview2.setAdapter(new Listview2Adapter(searchedhistory));
		applyColorsToViews(findViewById(android.R.id.content));
		itemCount = listview1.getCount();
		listview1.setSelection((int)itemCount);
		if (FileUtil.getFileLength("/storage/emulated/0/WeekBrowser/history.json") < 1024) {
			historysize = FileUtil.getFileLength("/storage/emulated/0/WeekBrowser/history.json");
			try{
				sizeitem = languag.get((int)(27));
			}catch(Exception e){
				if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
					sizeitem = " B";
				}
				else {
					sizeitem = " Б";
				}
			}
		}
		else {
			if (FileUtil.getFileLength("/storage/emulated/0/WeekBrowser/history.json") < 1048576) {
				historysize = FileUtil.getFileLength("/storage/emulated/0/WeekBrowser/history.json") / 1024.d;
				try{
					sizeitem = languag.get((int)(28));
				}catch(Exception e){
					if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
						sizeitem = " kiB";
					}
					else {
						sizeitem = " КіБ";
					}
				}
			}
			else {
				historysize = FileUtil.getFileLength("/storage/emulated/0/WeekBrowser/history.json") / 1048576.d;
				try{
					sizeitem = languag.get((int)(29));
				}catch(Exception e){
					if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
						sizeitem = " MiB";
					}
					else {
						sizeitem = " МіБ";
					}
				}
			}
		}
		historysize = Math.round(historysize * 100.d) / 100.d;
		try{
			hintt.setText(languag.get((int)(22)).concat(String.valueOf((long)(itemCount)).concat(languag.get((int)(23)).concat(String.valueOf(historysize).concat(sizeitem)))));
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				hintt.setText("Currently saved ".concat(String.valueOf((long)(itemCount)).concat(" elements, and their size is ".concat(String.valueOf(historysize).concat(sizeitem)))));
			}
			else {
				hintt.setText("Наразі збережено ".concat(String.valueOf((long)(itemCount)).concat(" елементів, та займають ".concat(String.valueOf(historysize).concat(sizeitem)))));
			}
		}
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		Skin skin = new Skin();
		
		skin.setBG(linear1, 2, false);
		skin.setBG(getWindow().getDecorView(), 2, false);
		
		deletee.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
		showhide.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		autocomplete1.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		autocomplete1.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		autocomplete2.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		autocomplete2.setHintTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		hintt.setTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
		numofelem.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		remaining.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		
		
		
		skin.setBG(showhide, 0, false);
		skin.setBG(deletee, 1, false);
		double savedNum = Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt"));
		double historySize = history.size();
		double fileLength = FileUtil.getFileLength("/storage/emulated/0/WeekBrowser/history.json");
		
		double result = savedNum * (fileLength / historySize);
		
		String[] suffixes;
		try {
			    suffixes = new String[]{languag.get((int)(27)), languag.get((int)(28)), languag.get((int)(29))};
		} catch (Exception ex) {
			    if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				        suffixes = new String[]{" B", " KiB", " MiB"};
				    } else {
				        suffixes = new String[]{" Б", " КіБ", " МіБ"};
				    }
		}
		
		int suffixIndex = 0;
		
		while (result >= 1024 && suffixIndex < suffixes.length - 1) {
			    result /= 1024;
			    suffixIndex++;
		}
		
		// Закруглення до двох знаків після коми
		size = Math.round(result * 100.0) / 100.0;
		sze = suffixes[suffixIndex];
		
		try{
			timeleft = Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) / Double.parseDouble(autocomplete1.getText().toString());
		}catch(Exception e){
			autocomplete1.setText("50");
		}
		timeleft = Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) / Double.parseDouble(autocomplete1.getText().toString());
		try{
			remaining.setText(languag.get((int)(25)) + (long)(timeleft) +  languag.get((int)(26)) + size + sze + languag.get((int)(30)));
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				remaining.setText("sites on day is remain to  ".concat(String.valueOf((long)(timeleft)).concat(" days and drain approximately ".concat(String.valueOf(size).concat(sze).concat(" of device ROM")))));
			}
			else {
				remaining.setText("сайтів на добу історії вистачить на ".concat(String.valueOf((long)(timeleft)).concat(" днів та займатиме орієнтовно ".concat(String.valueOf(size).concat(sze).concat(" внутрішньої пам'яті")))));
			}
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 5) {
			seekbar1.setProgress((int)0);
			try{
				numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)))));
			}catch(Exception e){
				if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
					numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements")));
				}
				else {
					numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів")));
				}
			}
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 10) {
			seekbar1.setProgress((int)1);
			try{
				numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)))));
			}catch(Exception e){
				if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
					numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements")));
				}
				else {
					numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів")));
				}
			}
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 20) {
			seekbar1.setProgress((int)2);
			try{
				numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)))));
			}catch(Exception e){
				if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
					numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements")));
				}
				else {
					numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів")));
				}
			}
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 50) {
			seekbar1.setProgress((int)3);
			try{
				numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)))));
			}catch(Exception e){
				if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
					numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements")));
				}
				else {
					numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів")));
				}
			}
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 100) {
			seekbar1.setProgress((int)4);
			try{
				numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)))));
			}catch(Exception e){
				if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
					numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements")));
				}
				else {
					numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів")));
				}
			}
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 200) {
			seekbar1.setProgress((int)5);
			try{
				numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)))));
			}catch(Exception e){
				if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
					numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements")));
				}
				else {
					numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів")));
				}
			}
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 500) {
			seekbar1.setProgress((int)6);
			try{
				numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)))));
			}catch(Exception e){
				if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
					numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements")));
				}
				else {
					numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів")));
				}
			}
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 1000) {
			seekbar1.setProgress((int)7);
			try{
				numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)))));
			}catch(Exception e){
				if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
					numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements")));
				}
				else {
					numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів")));
				}
			}
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 2000) {
			seekbar1.setProgress((int)8);
			try{
				numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)).concat(languag.get((int)(20))))));
			}catch(Exception e){
				if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
					numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements (not recomended on low-end device)")));
				}
				else {
					numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів (на слабких пристроях не рекомендовано)")));
				}
			}
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 5000) {
			seekbar1.setProgress((int)9);
			try{
				numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)).concat(languag.get((int)(20))))));
			}catch(Exception e){
				if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
					numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements (not recomended on low-end device)")));
				}
				else {
					numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів (на слабких пристроях не рекомендовано)")));
				}
			}
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 10000) {
			seekbar1.setProgress((int)10);
			try{
				numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)).concat(languag.get((int)(21))))));
			}catch(Exception e){
				if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
					numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements (not recomended on low-end & medium device)")));
				}
				else {
					numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів (на слабких та середніх пристроях не рекомендовано)")));
				}
			}
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 20000) {
			seekbar1.setProgress((int)11);
			try{
				numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)).concat(languag.get((int)(21))))));
			}catch(Exception e){
				if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
					numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements (not recomended on low-end & medium device)")));
				}
				else {
					numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів (на слабких та середніх пристроях не рекомендовано)")));
				}
			}
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 50000) {
			seekbar1.setProgress((int)12);
			try{
				numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)).concat(languag.get((int)(113))))));
			}catch(Exception e){
				if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
					numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements (not recomended)")));
				}
				else {
					numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів (не рекомендовано)")));
				}
			}
		}
		if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt")) == 100000) {
			seekbar1.setProgress((int)13);
			try{
				numofelem.setText(languag.get((int)(18)).concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(languag.get((int)(19)).concat(languag.get((int)(113))))));
			}catch(Exception e){
				if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
					numofelem.setText("Save ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" elements (not recomended)")));
				}
				else {
					numofelem.setText("Зберігати ".concat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/SaveNumOfHistory.txt").concat(" елементів (не рекомендовано)")));
				}
			}
		}
		try{
			deletee.setText(languag.get((int)(32)));
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				deletee.setText("CLEAR ALL");
			}
			else {
				deletee.setText("ОЧИСТИТИ ВСЕ");
			}
		}
		try{
			textview3.setText(languag.get((int)(24)));
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				textview3.setText("If you will visit");
			}
			else {
				textview3.setText("При");
			}
		}
		try{
			autocomplete2.setHint(languag.get((int)(31)));
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				autocomplete2.setHint("Search");
			}
			else {
				autocomplete2.setHint("Пошук");
			}
		}
		try{
			autocomplete1.setHint(languag.get((int)(114)));
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				autocomplete1.setHint("q-ty");
			}
			else {
				autocomplete1.setHint("к-ть");
			}
		}
		if (FileUtil.readFile("/storage/emulated/0/WeekBrowser/monofortextarea.txt").equals("1")) {
			autocomplete1.setTypeface(Typeface.MONOSPACE);
			autocomplete2.setTypeface(Typeface.MONOSPACE);
		}
		else {
			autocomplete1.setTypeface(Typeface.DEFAULT);
			autocomplete2.setTypeface(Typeface.DEFAULT);
		}
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
				_view = _inflater.inflate(R.layout.histori, null);
			}
			
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			
			
			
			if (history != null) {
				    textview1.setText(history.get(_position).get("name").toString());
				    textview2.setText(history.get(_position).get("url").toString());
				    textview3.setText(history.get(_position).get("date").toString());
			}
			
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			textview1.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			textview2.setTextColor((int)Long.parseLong(dataHolder.getData("h"),16));
			textview3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			
			return _view;
		}
	}
	
	public class Listview2Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.histori, null);
			}
			
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			
			
			
			if (searchedhistory != null) {
				    textview1.setText(searchedhistory.get(_position).get("name").toString());
				    textview2.setText(searchedhistory.get(_position).get("url").toString());
				    textview3.setText(searchedhistory.get(_position).get("date").toString());
			}
			
			if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 0) {
				getWindow().getDecorView().setBackgroundColor(Color.parseColor("#ffffff"));
				textview1.setTextColor(0xFF000000);
				textview2.setTextColor(0xFF000000);
				textview3.setTextColor(0xFF000000);
			}
			else {
				if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 1) {
					textview1.setTextColor(0xFFFFFFFF);
					textview2.setTextColor(0xFFFFFFFF);
					textview3.setTextColor(0xFFFFFFFF);
				}
				else {
					if (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) == 2) {
						getWindow().getDecorView().setBackgroundColor(Color.parseColor("#000000"));
						textview1.setTextColor(0xFF00FF00);
						textview2.setTextColor(0xFF7000FF);
						textview3.setTextColor(0xFFFF0070);
					}
					else {
						textview1.setTextColor((int)Long.parseLong(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/text.txt"),16));
						textview2.setTextColor((int)Long.parseLong(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/hint.txt"),16));
						textview3.setTextColor((int)Long.parseLong(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/additional.txt"),16));
					}
				}
			}
			
			return _view;
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