package com.a525team.weekbrowser;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
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
import android.widget.CheckBox;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class CustomthemeActivity extends Activity {
	
	private String lol = "";
	ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	Colorify colorify = new Colorify();
	private double state = 0;
	private String buffer = "";
	private String currentColorHex = "";
	private String fffff = "";
	String[] colors;
	String[] rcolors;
	String[] bcolors;
	
	private ArrayList<String> skin = new ArrayList<>();
	private ArrayList<String> languag = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> col = new ArrayList<>();
	
	private LinearLayout linear5;
	private HorizontalScrollView hscroll1;
	private ScrollView vscroll1;
	private LinearLayout linear3;
	private LinearLayout prevbtn;
	private LinearLayout prevcomp;
	private LinearLayout linear7;
	private TextView styletitle;
	private TextView stylename;
	private SeekBar style;
	private LinearLayout linear6;
	private Button prev9;
	private Button prev10;
	private Button prev1;
	private Button prev3;
	private Button prev4;
	private Button prev5;
	private Button prev6;
	private Button prev7;
	private Button prev8;
	private CheckBox prevcheck;
	private RadioGroup radiogroup1;
	private RadioButton prevradio;
	private RadioButton prevradip;
	private Button prev2;
	private Button autogen;
	private LinearLayout linear1;
	private Button buttonpar;
	private Button button3;
	private Button button6;
	private Button button4;
	private Button export;
	private LinearLayout linear2;
	private TextView textview1;
	private TextView gradientind;
	private SeekBar grad;
	private TextView textview2;
	private TextView segmentsind;
	private SeekBar segm;
	private TextView textview9;
	private TextView sharpnessind;
	private SeekBar sharp;
	private TextView textview3;
	private TextView radiusind;
	private SeekBar rad;
	private TextView textview4;
	private TextView centerxind;
	private SeekBar x;
	private TextView textview5;
	private TextView centeryind;
	private SeekBar y;
	private TextView textview6;
	private TextView bigroundind;
	private SeekBar bb;
	private TextView textview7;
	private TextView smallroundind;
	private SeekBar sb;
	private GridView gridcol;
	private HorizontalScrollView hscroll2;
	private LinearLayout linear4;
	private Button button7;
	private Button button8;
	private Button allup;
	private Button alldown;
	private Button shuffle;
	
	private Intent j = new Intent();
	private AlertDialog.Builder d;
	private SharedPreferences sf;
	private AlertDialog.Builder generator;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.customtheme);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		ThemeManager.applyTheme(this); // Встановлення теми
		    super.onCreate(_savedInstanceState);
		 
		        setContentView(R.layout.customtheme);
		colors = parseColorArray(sf.getString("bbg", ""));
		rcolors = parseColorArray(sf.getString("rbg", ""));
		bcolors = parseColorArray(sf.getString("bg", ""));
		linear5 = findViewById(R.id.linear5);
		hscroll1 = findViewById(R.id.hscroll1);
		vscroll1 = findViewById(R.id.vscroll1);
		linear3 = findViewById(R.id.linear3);
		prevbtn = findViewById(R.id.prevbtn);
		prevcomp = findViewById(R.id.prevcomp);
		linear7 = findViewById(R.id.linear7);
		styletitle = findViewById(R.id.styletitle);
		stylename = findViewById(R.id.stylename);
		style = findViewById(R.id.style);
		linear6 = findViewById(R.id.linear6);
		prev9 = findViewById(R.id.prev9);
		prev10 = findViewById(R.id.prev10);
		prev1 = findViewById(R.id.prev1);
		prev3 = findViewById(R.id.prev3);
		prev4 = findViewById(R.id.prev4);
		prev5 = findViewById(R.id.prev5);
		prev6 = findViewById(R.id.prev6);
		prev7 = findViewById(R.id.prev7);
		prev8 = findViewById(R.id.prev8);
		prevcheck = findViewById(R.id.prevcheck);
		radiogroup1 = findViewById(R.id.radiogroup1);
		prevradio = findViewById(R.id.prevradio);
		prevradip = findViewById(R.id.prevradip);
		prev2 = findViewById(R.id.prev2);
		autogen = findViewById(R.id.autogen);
		linear1 = findViewById(R.id.linear1);
		buttonpar = findViewById(R.id.buttonpar);
		button3 = findViewById(R.id.button3);
		button6 = findViewById(R.id.button6);
		button4 = findViewById(R.id.button4);
		export = findViewById(R.id.export);
		linear2 = findViewById(R.id.linear2);
		textview1 = findViewById(R.id.textview1);
		gradientind = findViewById(R.id.gradientind);
		grad = findViewById(R.id.grad);
		textview2 = findViewById(R.id.textview2);
		segmentsind = findViewById(R.id.segmentsind);
		segm = findViewById(R.id.segm);
		textview9 = findViewById(R.id.textview9);
		sharpnessind = findViewById(R.id.sharpnessind);
		sharp = findViewById(R.id.sharp);
		textview3 = findViewById(R.id.textview3);
		radiusind = findViewById(R.id.radiusind);
		rad = findViewById(R.id.rad);
		textview4 = findViewById(R.id.textview4);
		centerxind = findViewById(R.id.centerxind);
		x = findViewById(R.id.x);
		textview5 = findViewById(R.id.textview5);
		centeryind = findViewById(R.id.centeryind);
		y = findViewById(R.id.y);
		textview6 = findViewById(R.id.textview6);
		bigroundind = findViewById(R.id.bigroundind);
		bb = findViewById(R.id.bb);
		textview7 = findViewById(R.id.textview7);
		smallroundind = findViewById(R.id.smallroundind);
		sb = findViewById(R.id.sb);
		gridcol = findViewById(R.id.gridcol);
		hscroll2 = findViewById(R.id.hscroll2);
		linear4 = findViewById(R.id.linear4);
		button7 = findViewById(R.id.button7);
		button8 = findViewById(R.id.button8);
		allup = findViewById(R.id.allup);
		alldown = findViewById(R.id.alldown);
		shuffle = findViewById(R.id.shuffle);
		d = new AlertDialog.Builder(this);
		sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
		generator = new AlertDialog.Builder(this);
		
		style.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				switch((int)_progressValue) {
					case ((int)0): {
						sf.edit().putString("style", "1").commit();
						stylename.setText("Android 1");
						break;
					}
					case ((int)1): {
						sf.edit().putString("style", "3").commit();
						stylename.setText("Holo Dark");
						break;
					}
					case ((int)2): {
						sf.edit().putString("style", "4").commit();
						stylename.setText("Holo Light");
						break;
					}
					case ((int)3): {
						sf.edit().putString("style", "5").commit();
						stylename.setText("Material Dark (Android 5.0+)");
						break;
					}
					case ((int)4): {
						sf.edit().putString("style", "6").commit();
						stylename.setText("Material Light (Android 5.0+)");
						break;
					}
					case ((int)5): {
						sf.edit().putString("style", "7").commit();
						stylename.setText("Device Default Dark (Material You (Android 12+))");
						break;
					}
					case ((int)6): {
						sf.edit().putString("style", "8").commit();
						stylename.setText("Device Default Light (Material You (Android 12+))");
						break;
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
		
		prev1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		prev2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				
				                switch ((int) state) {
					                    case 0:
					                    currentColorHex = sf.getString("bt", "");
					                        break;
					                    case 1:
					                        currentColorHex = sf.getString("rbt", "");
					                        break;
					                    case 2:
					                        
					                        break;
					                }
				                
				                
				
				        ColorPickerDialog colorPickerDialog = new ColorPickerDialog(CustomthemeActivity.this);
				        colorPickerDialog.setColorPickerListener(new ColorPickerDialog.ColorPickerListener() {
					                @Override
					    public void onColorPicked(String colorHex) {
						        switch ((int) state) {
							            case 0:
							                sf.edit().putString("bt", colorHex).commit();
							                break;
							            case 1:
							                sf.edit().putString("rbt", colorHex).commit();
							                break;              }
						                                _updcol();
						                _colToRAM();
						
						            }
					        });
				
				        colorPickerDialog.show(currentColorHex);
			}
		});
		
		autogen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				generator.setTitle("?");
				generator.setMessage("Яку тему Ви хочете згенерувати?");
				generator.setPositiveButton(getString(R.string.light), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						_generate(false);
					}
				});
				generator.setNegativeButton(getString(R.string.dark), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						_generate(true);
					}
				});
				generator.setNeutralButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				generator.create().show();
			}
		});
		
		buttonpar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				state = 0;
				_colToRAM();
				_updcol();
				_setseekbars();
				bb.setVisibility(View.VISIBLE);
				bigroundind.setVisibility(View.VISIBLE);
				sb.setVisibility(View.VISIBLE);
				smallroundind.setVisibility(View.VISIBLE);
				textview6.setVisibility(View.VISIBLE);
				textview7.setVisibility(View.VISIBLE);
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				state = 1;
				_colToRAM();
				_updcol();
				_setseekbars();
				bb.setVisibility(View.VISIBLE);
				bigroundind.setVisibility(View.VISIBLE);
				sb.setVisibility(View.VISIBLE);
				smallroundind.setVisibility(View.VISIBLE);
				textview6.setVisibility(View.VISIBLE);
				textview7.setVisibility(View.VISIBLE);
			}
		});
		
		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				state = 2;
				_colToRAM();
				_updcol();
				_setseekbars();
				bb.setVisibility(View.GONE);
				bigroundind.setVisibility(View.GONE);
				sb.setVisibility(View.GONE);
				smallroundind.setVisibility(View.GONE);
				textview6.setVisibility(View.GONE);
				textview7.setVisibility(View.GONE);
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				state = 3;
				_colToRAM();
				_updcol();
				_setseekbars();
			}
		});
		
		export.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "https://skins.weekbrowser.com/general/".concat(sf.getString("t", "") + "%" + sf.getString("tf", "") + "%" + sf.getString("add", "") + "%" + sf.getString("h", "") + "%" + sf.getString("cb", "") + "%" + sf.getString("tpc", "") + "%" + sf.getString("tc", "") + "%" + sf.getString("bt", "") + "%" + sf.getString("rbt", "") + "%" + sf.getString("bg", "") + "%" + sf.getString("bbg", "") + "%" + sf.getString("rbg", "") + "%" + sf.getString("grad", "") + "%" + sf.getString("rgrad", "") + "%" + sf.getString("bgrad", "") + "%" + sf.getString("strcou", "") + "%" + sf.getString("rstrcou", "") + "%" + sf.getString("bstrcou", "") + "%" + sf.getString("tm", "") + "%" + sf.getString("rtm", "") + "%" + sf.getString("btm", "") + "%" + sf.getString("rad", "") + "%" + sf.getString("rrad", "") + "%" + sf.getString("brad", "") + "%" + sf.getString("x", "") + "%" + sf.getString("rx", "") + "%" + sf.getString("bx", "") + "%" + sf.getString("y", "") + "%" + sf.getString("ry", "") + "%" + sf.getString("by", "") + "%" + sf.getString("rou", "") + "%" + sf.getString("rrou", "") + "%" + sf.getString("srou", "") + "%" + sf.getString("rsrou", "") + "%" + sf.getString("style", ""))));
				SketchwareUtil.showMessage(getApplicationContext(), "Скопійовано в буфер обміну");
			}
		});
		
		grad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				switch((int)state) {
					case ((int)0): {
						sf.edit().putString("grad", String.valueOf((long)(_progressValue))).commit();
						break;
					}
					case ((int)1): {
						sf.edit().putString("rgrad", String.valueOf((long)(_progressValue))).commit();
						break;
					}
					case ((int)2): {
						sf.edit().putString("bgrad", String.valueOf((long)(_progressValue))).commit();
						break;
					}
				}
				_colToRAM();
				_updind();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		segm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				switch((int)state) {
					case ((int)0): {
						if (_progressValue < 20) {
							sf.edit().putString("strcou", String.valueOf((long)(_progressValue + 2))).commit();
						}
						else {
							sf.edit().putString("strcou", String.valueOf((long)(((_progressValue - 20) * 4) + 21))).commit();
						}
						break;
					}
					case ((int)1): {
						if (_progressValue < 20) {
							sf.edit().putString("rstrcou", String.valueOf((long)(_progressValue + 2))).commit();
						}
						else {
							sf.edit().putString("rstrcou", String.valueOf((long)(((_progressValue - 20) * 4) + 21))).commit();
						}
						break;
					}
					case ((int)2): {
						if (_progressValue < 20) {
							sf.edit().putString("bstrcou", String.valueOf((long)(_progressValue + 2))).commit();
						}
						else {
							sf.edit().putString("bstrcou", String.valueOf((long)(((_progressValue - 20) * 4) + 21))).commit();
						}
						break;
					}
				}
				_colToRAM();
				_updind();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		sharp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				switch((int)state) {
					case ((int)0): {
						sf.edit().putString("tm", String.valueOf((long)(Math.pow(2, _progressValue)))).commit();
						break;
					}
					case ((int)1): {
						sf.edit().putString("rtm", String.valueOf((long)(Math.pow(2, _progressValue)))).commit();
						break;
					}
					case ((int)2): {
						sf.edit().putString("btm", String.valueOf((long)(Math.pow(2, _progressValue)))).commit();
						break;
					}
				}
				_colToRAM();
				_updind();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		rad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				switch((int)state) {
					case ((int)0): {
						sf.edit().putString("rad", String.valueOf(_progressValue / 20.d)).commit();
						break;
					}
					case ((int)1): {
						sf.edit().putString("rrad", String.valueOf(_progressValue / 20.d)).commit();
						break;
					}
					case ((int)2): {
						sf.edit().putString("brad", String.valueOf(_progressValue / 20.d)).commit();
						break;
					}
				}
				_colToRAM();
				_updind();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		x.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				switch((int)state) {
					case ((int)0): {
						sf.edit().putString("x", String.valueOf((_progressValue - 40) / 20.d)).commit();
						break;
					}
					case ((int)1): {
						sf.edit().putString("rx", String.valueOf((_progressValue - 40) / 20.d)).commit();
						break;
					}
					case ((int)2): {
						sf.edit().putString("bx", String.valueOf((_progressValue - 40) / 20.d)).commit();
						break;
					}
				}
				_colToRAM();
				_updind();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		y.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				switch((int)state) {
					case ((int)0): {
						sf.edit().putString("y", String.valueOf((_progressValue - 40) / 20.d)).commit();
						break;
					}
					case ((int)1): {
						sf.edit().putString("ry", String.valueOf((_progressValue - 40) / 20.d)).commit();
						break;
					}
					case ((int)2): {
						sf.edit().putString("by", String.valueOf((_progressValue - 40) / 20.d)).commit();
						break;
					}
				}
				_colToRAM();
				_updind();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		bb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				switch((int)state) {
					case ((int)0): {
						sf.edit().putString("rou", String.valueOf((long)(_progressValue))).commit();
						break;
					}
					case ((int)1): {
						sf.edit().putString("rrou", String.valueOf((long)(_progressValue))).commit();
						break;
					}
				}
				_colToRAM();
				_updind();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				switch((int)state) {
					case ((int)0): {
						sf.edit().putString("srou", String.valueOf((long)(_progressValue))).commit();
						break;
					}
					case ((int)1): {
						sf.edit().putString("rsrou", String.valueOf((long)(_progressValue))).commit();
						break;
					}
				}
				_colToRAM();
				_updind();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		gridcol.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				
			}
		});
		
		gridcol.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				
				return true;
			}
		});
		
		button7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				switch((int)state) {
					case ((int)0): {
						sf.edit().putString("bbg", sf.getString("bbg", "").concat("FFFF0000")).commit();
						break;
					}
					case ((int)1): {
						sf.edit().putString("rbg", sf.getString("rbg", "").concat("FFFF0000")).commit();
						break;
					}
					case ((int)2): {
						sf.edit().putString("bg", sf.getString("bg", "").concat("FFFF0000")).commit();
						break;
					}
				}
				_colToRAM();
				_updcol();
			}
		});
		
		button8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Collections.reverse(col);
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				
				buffer = "";
				                for (int i = 0; i < col.size(); i++) {
					                    try{buffer = buffer.concat(_toHexStr((int) Long.parseLong(col.get(i).get("c").toString())));}
					                        catch(Exception e){
						                    buffer = buffer.concat(col.get(i).get("c").toString());        
						                            }
					                }
				                switch ((int) state) {
					                    case 0:
					                        sf.edit().putString("bbg", buffer).commit();
					                        break;
					                    case 1:
					                        sf.edit().putString("rbg", buffer).commit();
					                        break;
					                    case 2:
					                        sf.edit().putString("bg", buffer).commit();
					                        break;
					                }
				                                _updcol();
				                _colToRAM();
			}
		});
		
		allup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				String buffer2 = col.get(0).get("c").toString();
				for (int i = 0; i < (int)(col.size() - 1); i++) {
					Collections.swap(col, (int)(i+1), (int)(i));
				}
				col.get((int)col.size() - 1).put("c", buffer2);
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				
				buffer = "";
				                for (int i = 0; i < col.size(); i++) {
					                    try{buffer = buffer.concat(_toHexStr((int) Long.parseLong(col.get(i).get("c").toString())));}
					                        catch(Exception e){
						                    buffer = buffer.concat(col.get(i).get("c").toString());        
						                            }
					                }
				                switch ((int) state) {
					                    case 0:
					                        sf.edit().putString("bbg", buffer).commit();
					                        break;
					                    case 1:
					                        sf.edit().putString("rbg", buffer).commit();
					                        break;
					                    case 2:
					                        sf.edit().putString("bg", buffer).commit();
					                        break;
					                }
				                                _updcol();
				                _colToRAM();
			}
		});
		
		alldown.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				String buffer2 = col.get(col.size()-1).get("c").toString();
				
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				for (int i = ((int) col.size() - 1 - 1); i > -1; i--) {
					Collections.swap(col, (int)(i), (int)(i+1));
				}
				col.get((int)0).put("c", buffer2);
				buffer = "";
				                for (int i = 0; i < col.size(); i++) {
					                    try{buffer = buffer.concat(_toHexStr((int) Long.parseLong(col.get(i).get("c").toString())));}
					                        catch(Exception e){
						                    buffer = buffer.concat(col.get(i).get("c").toString());        
						                            }
					                }
				                switch ((int) state) {
					                    case 0:
					                        sf.edit().putString("bbg", buffer).commit();
					                        break;
					                    case 1:
					                        sf.edit().putString("rbg", buffer).commit();
					                        break;
					                    case 2:
					                        sf.edit().putString("bg", buffer).commit();
					                        break;
					                }
				                                _updcol();
				                _colToRAM();
			}
		});
		
		shuffle.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Collections.shuffle(col);
				buffer = "";
				
				final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
				
				
				                for (int i = 0; i < col.size(); i++) {
					                    try{buffer = buffer.concat(_toHexStr((int) Long.parseLong(col.get(i).get("c").toString())));}
					                        catch(Exception e){
						                    buffer = buffer.concat(col.get(i).get("c").toString());        
						                            }
					                }
				                switch ((int) state) {
					                    case 0:
					                        sf.edit().putString("bbg", buffer).commit();
					                        break;
					                    case 1:
					                        sf.edit().putString("rbg", buffer).commit();
					                        break;
					                    case 2:
					                        sf.edit().putString("bg", buffer).commit();
					                        break;
					                }
				                                _updcol();
				                _colToRAM();
			}
		});
	}
	
	private void initializeLogic() {
		gridcol.setAdapter(new GridcolAdapter(col));
		SafeMarginUtils.init(this, findViewById(android.R.id.content));
		
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		Skin skin = new Skin();
		skin.setBG(getWindow().getDecorView(), 2, true);
		textview1.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview2.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview4.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview5.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview6.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview7.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview9.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		
		prevcheck.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		prevradio.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		prevradip.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		_colToRAM();
		_updcol();
		_sizeset(prev1);
		_sizeset(prev3);
		_sizeset(prev4);
		_sizeset(prev5);
		_sizeset(prev6);
		_sizeset(prev7);
		_sizeset(prev8);
		_sizeset(prev9);
		_sizeset(prev10);
		_setseekbars();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		applyColorsToViews(findViewById(android.R.id.content));
	}
	public String _toHexStr(final double _num) {
		int num = (int)_num; // Приводимо число до типу int
		String lol = String.format("%08X", num); // Форматуємо число в 8-значний шістнадцятковий рядок
		return lol;
		
	}
	
	
	public double _fromHex(final String _str) {
		        int decimalValue = (int)Long.parseLong(_str, 16);
		        return decimalValue;
	}
	
	
	public void _extra() {
	}String[] parseColorArray(String colorString) {
		    int length = colorString.length();
		    String[] colors = new String[length / 8];
		    for (int i = 0; i < length; i += 8) {
			        colors[i / 8] = colorString.substring(i, i + 8);
			    }
		    return colors;
	}
	
	
	private void applyColorsToViews(View view) {
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
	
	
	{
	}
	
	
	public void _colToRAM() {
		Skin skin = new Skin();
		skin.colorToRam(this);
		skin = null;
		skin = new Skin();
		
		dataHolder = ExtendedDataHolder.getInstance();
		
		switch((int)state){
			    case 0:
			prev1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			skin.setBG(prev1, 0, true);
			prev2.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			skin.setBG(prev2, 0, false);
			prev3.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			skin.setBG(prev3, 0, true);
			prev4.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			skin.setBG(prev4, 0, true);
			prev5.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			skin.setBG(prev5, 1, true);
			prev6.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			skin.setBG(prev6, 0, true);
			prev7.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			skin.setBG(prev7, 0, true);
			prev8.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			skin.setBG(prev8, 1, true);
			prev9.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			skin.setBG(prev9, 0, true);
			prev10.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			skin.setBG(prev10, 1, true);break;
			
			
			case 1:
			prev1.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			skin.setBG(prev1, 1, true);
			prev2.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			skin.setBG(prev2, 1, false);
			prev3.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			skin.setBG(prev3, 1, true);
			prev4.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			skin.setBG(prev4, 1, true);
			prev5.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			skin.setBG(prev5, 0, true);
			prev6.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			skin.setBG(prev6, 1, true);
			prev7.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			skin.setBG(prev7, 1, true);
			prev8.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			skin.setBG(prev8, 0, true);
			prev9.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			skin.setBG(prev9, 1, true);
			prev10.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			skin.setBG(prev10, 0, true);break;
			
			
			case 2:
			skin.setBG(getWindow().getDecorView(), 2, true);
			skin.setBG(getWindow().getDecorView(), 2, false);break;
			case 3:
			prevcheck.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			prevradio.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			prevradip.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));break;
		}
		
		gradientind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		segmentsind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		sharpnessind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		radiusind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		centerxind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		centeryind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		bigroundind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		smallroundind.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		styletitle.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		stylename.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		textview1.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview2.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview4.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview5.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview6.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview7.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview9.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		
	}
	
	
	public void _updcol() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		colors = parseColorArray(sf.getString("bbg", ""));
		rcolors = parseColorArray(sf.getString("rbg", ""));
		bcolors = parseColorArray(sf.getString("bg", ""));
		col.clear();
		switch((int)state) {
			case ((int)0): {
				for (int i = 0; i < (int)(colors.length); i++) {
					prevbtn.setVisibility(View.VISIBLE);
					prev2.setVisibility(View.VISIBLE);
					prevcomp.setVisibility(View.GONE);
					{
						HashMap<String, Object> _item = new HashMap<>();
						_item.put("c", colors[i]);
						col.add(_item);
					}
					
					hscroll2.setVisibility(View.VISIBLE);
					vscroll1.setVisibility(View.VISIBLE);
				}
				break;
			}
			case ((int)1): {
				for (int i = 0; i < (int)(rcolors.length); i++) {
					hscroll2.setVisibility(View.VISIBLE);
					prevbtn.setVisibility(View.VISIBLE);
					prev2.setVisibility(View.VISIBLE);
					prevcomp.setVisibility(View.GONE);
					{
						HashMap<String, Object> _item = new HashMap<>();
						_item.put("c", rcolors[i]);
						col.add(_item);
					}
					
					vscroll1.setVisibility(View.VISIBLE);
				}
				break;
			}
			case ((int)2): {
				for (int i = 0; i < (int)(bcolors.length); i++) {
					hscroll2.setVisibility(View.VISIBLE);
					prevbtn.setVisibility(View.GONE);
					prev2.setVisibility(View.GONE);
					prevcomp.setVisibility(View.GONE);
					{
						HashMap<String, Object> _item = new HashMap<>();
						_item.put("c", bcolors[i]);
						col.add(_item);
					}
					
					vscroll1.setVisibility(View.VISIBLE);
				}
				break;
			}
			case ((int)3): {
				hscroll2.setVisibility(View.VISIBLE);
				prevbtn.setVisibility(View.GONE);
				prev2.setVisibility(View.GONE);
				prevcomp.setVisibility(View.VISIBLE);
				vscroll1.setVisibility(View.GONE);
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("c", sf.getString("t", ""));
					col.add(_item);
				}
				
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("c", sf.getString("tf", ""));
					col.add(_item);
				}
				
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("c", sf.getString("add", ""));
					col.add(_item);
				}
				
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("c", sf.getString("h", ""));
					col.add(_item);
				}
				
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("c", sf.getString("cb", ""));
					col.add(_item);
				}
				
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("c", sf.getString("tpc", ""));
					col.add(_item);
				}
				
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("c", sf.getString("tc", ""));
					col.add(_item);
				}
				
				break;
			}
		}
		((BaseAdapter)gridcol.getAdapter()).notifyDataSetChanged();
	}
	
	
	public void _sizeset(final TextView _btn) {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		
		_btn.getLayoutParams().width = (int) ((Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density * 1.27));
		_btn.getLayoutParams().height = (int) (Integer.parseInt(sf.getString("button", "")) * getResources().getDisplayMetrics().density);
		_btn.setTextSize( Float.parseFloat(sf.getString("button", "")) / 2.5f);
		_btn.requestLayout();
	}
	
	
	public void _updind() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		switch(((state == 2) ? (sf.getString("bgrad", "")) : (((state == 1) ? (sf.getString("rgrad", "")) : (sf.getString("grad", "")))))) {
			case "0": {
				gradientind.setText(getString(R.string.udlinear));
				rad.setVisibility(View.GONE);
				radiusind.setVisibility(View.GONE);
				x.setVisibility(View.GONE);
				centerxind.setVisibility(View.GONE);
				y.setVisibility(View.GONE);
				centeryind.setVisibility(View.GONE);
				textview3.setVisibility(View.GONE);
				textview4.setVisibility(View.GONE);
				textview5.setVisibility(View.GONE);
				break;
			}
			case "1": {
				gradientind.setText(getString(R.string.lrlinear));
				rad.setVisibility(View.GONE);
				radiusind.setVisibility(View.GONE);
				x.setVisibility(View.GONE);
				centerxind.setVisibility(View.GONE);
				y.setVisibility(View.GONE);
				centeryind.setVisibility(View.GONE);
				textview3.setVisibility(View.GONE);
				textview4.setVisibility(View.GONE);
				textview5.setVisibility(View.GONE);
				break;
			}
			case "2": {
				gradientind.setText(getString(R.string.diaglin1));
				rad.setVisibility(View.GONE);
				radiusind.setVisibility(View.GONE);
				x.setVisibility(View.GONE);
				centerxind.setVisibility(View.GONE);
				y.setVisibility(View.GONE);
				centeryind.setVisibility(View.GONE);
				textview3.setVisibility(View.GONE);
				textview4.setVisibility(View.GONE);
				textview5.setVisibility(View.GONE);
				break;
			}
			case "3": {
				gradientind.setText(getString(R.string.diaglin2));
				rad.setVisibility(View.GONE);
				radiusind.setVisibility(View.GONE);
				x.setVisibility(View.GONE);
				centerxind.setVisibility(View.GONE);
				y.setVisibility(View.GONE);
				centeryind.setVisibility(View.GONE);
				textview3.setVisibility(View.GONE);
				textview4.setVisibility(View.GONE);
				textview5.setVisibility(View.GONE);
				break;
			}
			case "4": {
				gradientind.setText(getString(R.string.radial));
				rad.setVisibility(View.VISIBLE);
				radiusind.setVisibility(View.VISIBLE);
				x.setVisibility(View.VISIBLE);
				centerxind.setVisibility(View.VISIBLE);
				y.setVisibility(View.VISIBLE);
				centeryind.setVisibility(View.VISIBLE);
				textview3.setVisibility(View.VISIBLE);
				textview4.setVisibility(View.VISIBLE);
				textview5.setVisibility(View.VISIBLE);
				break;
			}
			case "5": {
				gradientind.setText(getString(R.string.sweep));
				rad.setVisibility(View.GONE);
				radiusind.setVisibility(View.GONE);
				x.setVisibility(View.VISIBLE);
				centerxind.setVisibility(View.VISIBLE);
				y.setVisibility(View.VISIBLE);
				centeryind.setVisibility(View.VISIBLE);
				textview3.setVisibility(View.GONE);
				textview4.setVisibility(View.VISIBLE);
				textview5.setVisibility(View.VISIBLE);
				break;
			}
		}
		segmentsind.setText(((state == 2) ? (sf.getString("bstrcou", "")) : (((state == 1) ? (sf.getString("rstrcou", "")) : (sf.getString("strcou", ""))))));
		sharpnessind.setText(((state == 2) ? (sf.getString("btm", "")) : (((state == 1) ? (sf.getString("rtm", "")) : (sf.getString("tm", ""))))));
		radiusind.setText(((state == 2) ? (sf.getString("brad", "")) : (((state == 1) ? (sf.getString("rrad", "")) : (sf.getString("rad", ""))))));
		centerxind.setText(((state == 2) ? (sf.getString("bx", "")) : (((state == 1) ? (sf.getString("rx", "")) : (sf.getString("x", ""))))));
		centeryind.setText(((state == 2) ? (sf.getString("by", "")) : (((state == 1) ? (sf.getString("ry", "")) : (sf.getString("y", ""))))));
		if (!(state == 2)) {
			bigroundind.setText(((state == 1) ? (sf.getString("rrou", "")) : (sf.getString("rou", ""))));
			smallroundind.setText(((state == 1) ? (sf.getString("rsrou", "")) : (sf.getString("srou", ""))));
		}
	}
	
	
	public void _setseekbars() {
		final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
		grad.setProgress((int)((state == 2) ? ((int)Integer.parseInt(sf.getString("bgrad", ""))) : ((int)((state == 1) ? ((int)Integer.parseInt(sf.getString("rgrad", ""))) : ((int)Integer.parseInt(sf.getString("grad", "")))))));
		switch((int)state) {
			case ((int)2): {
				if (Integer.parseInt(sf.getString("bstrcou", "")) > 21) {
					segm.setProgress((int)((Integer.parseInt(sf.getString("bstrcou", "")) - 21) / 4.d) + 20);
				}
				else {
					segm.setProgress((int)Integer.parseInt(sf.getString("bstrcou", "")) - 2);
				}
				break;
			}
			case ((int)1): {
				if (Integer.parseInt(sf.getString("rstrcou", "")) > 21) {
					segm.setProgress((int)((Integer.parseInt(sf.getString("rstrcou", "")) - 21) / 4.d) + 20);
				}
				else {
					segm.setProgress((int)Integer.parseInt(sf.getString("rstrcou", "")) - 2);
				}
				break;
			}
			case ((int)0): {
				if (Integer.parseInt(sf.getString("strcou", "")) > 21) {
					segm.setProgress((int)((Integer.parseInt(sf.getString("strcou", "")) - 21) / 4.d) + 20);
				}
				else {
					segm.setProgress((int)Integer.parseInt(sf.getString("strcou", "")) - 2);
				}
				break;
			}
		}
		switch((int)((state == 2) ? ((int)Integer.parseInt(sf.getString("btm", ""))) : ((int)((state == 1) ? ((int)Integer.parseInt(sf.getString("rtm", ""))) : ((int)Integer.parseInt(sf.getString("tm", ""))))))) {
			case ((int)1): {
				sharp.setProgress((int)0);
				break;
			}
			case ((int)2): {
				sharp.setProgress((int)1);
				break;
			}
			case ((int)4): {
				sharp.setProgress((int)2);
				break;
			}
			case ((int)8): {
				sharp.setProgress((int)3);
				break;
			}
			case ((int)16): {
				sharp.setProgress((int)4);
				break;
			}
			case ((int)32): {
				sharp.setProgress((int)5);
				break;
			}
			case ((int)64): {
				sharp.setProgress((int)6);
				break;
			}
		}
		rad.setProgress((int)((state == 2) ? ((int)Double.parseDouble(sf.getString("brad", "")) * 20.d) : ((int)((state == 1) ? ((int)Double.parseDouble(sf.getString("rrad", "")) * 20.d) : ((int)Double.parseDouble(sf.getString("rad", "")) * 20.d)))));
		x.setProgress((int)((state == 2) ? ((int)(Double.parseDouble(sf.getString("bx", "")) * 20) + 40) : ((int)((state == 1) ? ((int)(Double.parseDouble(sf.getString("rx", "")) * 20) + 40) : ((int)(Double.parseDouble(sf.getString("x", "")) * 20) + 40)))));
		y.setProgress((int)((state == 2) ? ((int)(Double.parseDouble(sf.getString("by", "")) * 20) + 40) : ((int)((state == 1) ? ((int)(Double.parseDouble(sf.getString("ry", "")) * 20) + 40) : ((int)(Double.parseDouble(sf.getString("y", "")) * 20) + 40)))));
		if (!(state == 2)) {
			bb.setProgress((int)((state == 1) ? ((int)Integer.parseInt(sf.getString("rrou", ""))) : ((int)Integer.parseInt(sf.getString("rou", "")))));
			sb.setProgress((int)((state == 1) ? ((int)Integer.parseInt(sf.getString("rsrou", ""))) : ((int)Integer.parseInt(sf.getString("srou", "")))));
		}
		switch(sf.getString("style", "")) {
			case "1": {
				style.setProgress((int)0);
				stylename.setText("Android 1");
				break;
			}
			case "3": {
				style.setProgress((int)1);
				stylename.setText("Holo Dark");
				break;
			}
			case "4": {
				style.setProgress((int)2);
				stylename.setText("Holo Light");
				break;
			}
			case "5": {
				style.setProgress((int)3);
				stylename.setText("Material Dark (Android 5.0+)");
				break;
			}
			case "6": {
				style.setProgress((int)4);
				stylename.setText("Material Light (Android 5.0+)");
				break;
			}
			case "7": {
				style.setProgress((int)5);
				stylename.setText("Device Default Dark (Material You (Android 12+))");
				break;
			}
			case "8": {
				style.setProgress((int)6);
				stylename.setText("Device Default Light (Material You (Android 12+))");
				break;
			}
		}
		_updind();
	}
	
	
	public void _generate(final boolean _dark) {
		try{
			final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
			double tmp = _myRandom(1, 8, 0);
			while((int)tmp==2||(_dark?((int)tmp==4||(int)tmp==6||(int)tmp==8):((int)tmp==3||(int)tmp==5||(int)tmp==7))) {
				tmp = _myRandom(1, 8, 0);
			}
			sf.edit().putString("style", String.valueOf((long)(tmp))).commit();
			sf.edit().putString("t", ((_dark) ? (_lightcolor(true)) : (_darkcolor(true)))).commit();
			sf.edit().putString("tf", ((_dark) ? (_lightcolor(true)) : (_darkcolor(true)))).commit();
			sf.edit().putString("add", ((_dark) ? (_lightcolor(true)) : (_darkcolor(true)))).commit();
			sf.edit().putString("h", ((_dark) ? (_lightcolor(true)) : (_darkcolor(true)))).commit();
			sf.edit().putString("cb", ((_dark) ? (_lightcolor(true)) : (_darkcolor(true)))).commit();
			sf.edit().putString("tpc", ((_dark) ? (_lightcolor(true)) : (_darkcolor(true)))).commit();
			sf.edit().putString("tc", ((_dark) ? (_lightcolor(true)) : (_darkcolor(true)))).commit();
			sf.edit().putString("bt", ((_dark) ? (_darkcolor(true)) : (_lightcolor(true)))).commit();
			sf.edit().putString("rbt", ((_dark) ? (_darkcolor(true)) : (_lightcolor(true)))).commit();
			sf.edit().putString("bg", ((_dark) ? (_darkcolor(false)) : (_lightcolor(false)))).commit();
			sf.edit().putString("bbg", ((_dark) ? (_lightcolor(false)) : (_darkcolor(false)))).commit();
			sf.edit().putString("rbg", ((_dark) ? (_lightcolor(false)) : (_darkcolor(false)))).commit();
			sf.edit().putString("grad", String.valueOf((long)(_myRandom(0, 5, 0)))).commit();
			sf.edit().putString("rgrad", String.valueOf((long)(_myRandom(0, 5, 0)))).commit();
			sf.edit().putString("bgrad", String.valueOf((long)(_myRandom(0, 5, 0)))).commit();
			sf.edit().putString("strcou", String.valueOf((long)(_myRandom(1, 10, 0)))).commit();
			sf.edit().putString("rstrcou", String.valueOf((long)(_myRandom(1, 10, 0)))).commit();
			sf.edit().putString("bstrcou", String.valueOf((long)(_myRandom(1, 40, 0)))).commit();
			sf.edit().putString("tm", String.valueOf((long)(Math.pow(2, _myRandom(0, 6, 0))))).commit();
			sf.edit().putString("rtm", String.valueOf((long)(Math.pow(2, _myRandom(0, 6, 0))))).commit();
			sf.edit().putString("btm", String.valueOf((long)(Math.pow(2, _myRandom(0, 6, 0))))).commit();
			sf.edit().putString("rad", String.valueOf(_myRandom(0, 5, 0))).commit();
			sf.edit().putString("rrad", String.valueOf(_myRandom(0, 5, 0))).commit();
			sf.edit().putString("brad", String.valueOf(_myRandom(0, 5, 0))).commit();
			sf.edit().putString("x", String.valueOf(_myRandom(-2, 3, 0))).commit();
			sf.edit().putString("rx", String.valueOf(_myRandom(-2, 3, 0))).commit();
			sf.edit().putString("bx", String.valueOf(_myRandom(-2, 3, 0))).commit();
			sf.edit().putString("y", String.valueOf(_myRandom(-2, 3, 0))).commit();
			sf.edit().putString("ry", String.valueOf(_myRandom(-2, 3, 0))).commit();
			sf.edit().putString("by", String.valueOf(_myRandom(-2, 3, 0))).commit();
			tmp = _myRandom(0, 30, 0);
			sf.edit().putString("rou", String.valueOf((long)(tmp))).commit();
			sf.edit().putString("rrou", String.valueOf((long)(tmp / _myRandom(1, 3, 0)))).commit();
			tmp = tmp / _myRandom(1, 3, 0);
			sf.edit().putString("srou", String.valueOf((long)(tmp))).commit();
			sf.edit().putString("rsrou", String.valueOf((long)(tmp / _myRandom(1, 3, 0)))).commit();
			_colToRAM();
			j.setClass(getApplicationContext(), CustomthemeActivity.class);
			startActivity(j);
			finish();
		}catch(Exception e){
			((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", e.toString()));
			SketchwareUtil.showMessage(getApplicationContext(), "Error");
		}
	}
	
	
	public String _lightcolor(final boolean _one) {
		int r;
		int g;
		int b;
		
		r = (int) _myRandom(0, 255, 0);
		g = (int) _myRandom(0, 255, 0);
		b = (int) _myRandom(0, 255, 0);
		
		while (Math.max(Math.max(r, g), b/1.5) < 192) {
			    r = (int) _myRandom(0, 255, 0);
			    g = (int) _myRandom(0, 255, 0);
			    b = (int) _myRandom(0, 255, 0);
		}
		
		if (_one) {
			    return String.format("FF%02X%02X%02X", r, g, b);
		} else {
			    StringBuilder c = new StringBuilder(); // Ініціалізація змінної
			
			    for (int i = 0; i < (int) _myRandom(1, 10, 0); i++) {
				        do {
					            r = (int) _myRandom(0, 255, 0);
					            g = (int) _myRandom(0, 255, 0);
					            b = (int) _myRandom(0, 255, 0);
					        } while (Math.max(Math.max(r, g), b/1.5) < 192);
				
				        c.append(String.format("FF%02X%02X%02X", r, g, b));
				    }
			
			    return c.toString();
		}
		
	}
	
	
	public String _darkcolor(final boolean _one) {
		int r;
		int g;
		int b;
		
		r = (int) _myRandom(0, 255, 0);
		g = (int) _myRandom(0, 255, 0);
		b = (int) _myRandom(0, 255, 0);
		
		while (Math.max(Math.max(r, g), b/1.5) > 64) {
			    r = (int) _myRandom(0, 255, 0);
			    g = (int) _myRandom(0, 255, 0);
			    b = (int) _myRandom(0, 255, 0);
		}
		
		if (_one) {
			    return String.format("FF%02X%02X%02X", r, g, b);
		} else {
			    StringBuilder c = new StringBuilder(); // Ініціалізація змінної
			
			    for (int i = 0; i < (int) _myRandom(1, 10, 0); i++) {
				        do {
					            r = (int) _myRandom(0, 255, 0);
					            g = (int) _myRandom(0, 255, 0);
					            b = (int) _myRandom(0, 255, 0);
					        } while (Math.max(Math.max(r, g), b/1.5) > 64);
				
				        c.append(String.format("FF%02X%02X%02X", r, g, b));
				    }
			
			    return c.toString();
		}
		
	}
	
	
	public double _myRandom(final double _from, final double _to, final double _seed) {
		if (_seed == 0) {
			return (SketchwareUtil.getRandom((int)(_from), (int)(_to)));
		}
		else {
			return (0);
		}
	}
	
	public class GridcolAdapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public GridcolAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.colorss, null);
			}
			
			final TextView preview = _view.findViewById(R.id.preview);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final TextView colr = _view.findViewById(R.id.colr);
			final Button up = _view.findViewById(R.id.up);
			final Button down = _view.findViewById(R.id.down);
			
			final SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
			
			Skin skin = new Skin();
			
				boolean isAndroid12OrHigher = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S;
			
			// Приклад коду для методу onBindCustomView або відповідного місця у вашому адаптері GridView:
			
			if(!(_data.get((int)_position).get("c").toString().startsWith("m__"))){
				colr.setText(_data.get((int)_position).get("c").toString());
			}else{
				    colr.setText("✦ | "+ _data.get((int)_position).get("c").toString().substring(3));
				    }
			up.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (!(_position == 0)) {
						Collections.swap(col, (int)(_position), (int)(_position + -1));
						buffer = "";
						                for (int i = 0; i < col.size(); i++) {
							                    try{buffer = buffer.concat(_toHexStr((int) Long.parseLong(col.get(i).get("c").toString())));}
							                        catch(Exception e){
								                    buffer = buffer.concat(col.get(i).get("c").toString());        
								                            }
							                }
						                switch ((int) state) {
							                    case 0:
							                        sf.edit().putString("bbg", buffer).commit();
							                        break;
							                    case 1:
							                        sf.edit().putString("rbg", buffer).commit();
							                        break;
							                    case 2:
							                        sf.edit().putString("bg", buffer).commit();
							                        break;
							                }
						                                _updcol();
						                _colToRAM();
					}
				}
			});
			down.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (!(_position == (col.size() - 1))) {
						Collections.swap(col, (int)(_position), (int)(_position + 1));
						buffer = "";
						                for (int i = 0; i < col.size(); i++) {
							                    try{buffer = buffer.concat(_toHexStr((int) Long.parseLong(col.get(i).get("c").toString())));}
							                        catch(Exception e){
								                    buffer = buffer.concat(col.get(i).get("c").toString());        
								                            }
							                }
						                switch ((int) state) {
							                    case 0:
							                        sf.edit().putString("bbg", buffer).commit();
							                        break;
							                    case 1:
							                        sf.edit().putString("rbg", buffer).commit();
							                        break;
							                    case 2:
							                        sf.edit().putString("bg", buffer).commit();
							                        break;
							                }
						                                _updcol();
						                _colToRAM();
					}
				}
			});
			switch((int)state) {
				case ((int)0):
				case ((int)1):
				case ((int)2): {
					preview.setText(getString(R.string.color_no).concat(String.valueOf((long)(_position + 1))));
					// Отримання кольору для preview
					String colorString = _data.get((int)_position).get("c").toString();
					int color;
					try {
						    // Перевірка на формат Monet або шістнадцятковий код
						    if (colorString.startsWith("m__")) {
							        color = (int)Long.parseLong(skin.processColor(colorString, false, isAndroid12OrHigher, getApplicationContext()),16);
							        
							    } else {
							        color = (int) Long.parseLong(colorString, 16);
							    }
					} catch (Exception e) {
						    
						    color = Color.BLACK; // Значення за замовчуванням, якщо щось пішло не так
					}
					
					preview.setBackgroundColor(color);
					colr.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
					
					break;
				}
				case ((int)3): {
					preview.setBackgroundColor(0x00000000);
					colr.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
					switch((int)_position) {
						case ((int)0): {
							preview.setText(getString(R.string.textcol));
							String colorString = _data.get((int)_position).get("c").toString();
							int color;
							
							try {
								    // Перевірка на формат Monet або шістнадцятковий код
								    if (colorString.startsWith("m__")) {
									        color = (int)Long.parseLong(skin.processColor(colorString, false, isAndroid12OrHigher, getApplicationContext()),16);
									    } else {
									        color = (int) Long.parseLong(colorString, 16);
									    }
							} catch (Exception e) {
								    color = Color.BLACK; // Значення за замовчуванням у разі помилки
							}
							
							// Встановлення кольору тексту
							preview.setTextColor(color);
							
							break;
						}
						case ((int)1): {
							preview.setText(getString(R.string.textareacol));
							String colorString = _data.get((int)_position).get("c").toString();
							int color;
							
							try {
								    // Перевірка на формат Monet або шістнадцятковий код
								    if (colorString.startsWith("m__")) {
									color = (int)Long.parseLong(skin.processColor(colorString, false, isAndroid12OrHigher, getApplicationContext()),16);
									    } else {
									        color = (int) Long.parseLong(colorString, 16);
									    }
							} catch (Exception e) {
								    color = Color.BLACK; // Значення за замовчуванням у разі помилки
							}
							
							// Встановлення кольору тексту
							preview.setTextColor(color);
							
							break;
						}
						case ((int)2): {
							preview.setText(getString(R.string.addtextcol));
							String colorString = _data.get((int)_position).get("c").toString();
							int color;
							
							try {
								    // Перевірка на формат Monet або шістнадцятковий код
								    if (colorString.startsWith("m__")) {
									color = (int)Long.parseLong(skin.processColor(colorString, false, isAndroid12OrHigher, getApplicationContext()),16);
									    } else {
									        color = (int) Long.parseLong(colorString, 16);
									    }
							} catch (Exception e) {
								    color = Color.BLACK; // Значення за замовчуванням у разі помилки
							}
							
							// Встановлення кольору тексту
							preview.setTextColor(color);
							
							break;
						}
						case ((int)3): {
							preview.setText(getString(R.string.hintcol));
							String colorString = _data.get((int)_position).get("c").toString();
							int color;
							
							try {
								    // Перевірка на формат Monet або шістнадцятковий код
								    if (colorString.startsWith("m__")) {
									        color = (int)Long.parseLong(skin.processColor(colorString, false, isAndroid12OrHigher, getApplicationContext()),16);
									    } else {
									        color = (int) Long.parseLong(colorString, 16);
									    }
							} catch (Exception e) {
								    color = Color.BLACK; // Значення за замовчуванням у разі помилки
							}
							
							// Встановлення кольору тексту
							preview.setTextColor(color);
							
							break;
						}
						case ((int)4): {
							preview.setText(getString(R.string.compcol));
							String colorString = _data.get((int)_position).get("c").toString();
							int color;
							
							try {
								    // Перевірка на формат Monet або шістнадцятковий код
								    if (colorString.startsWith("m__")) {
									        color = (int)Long.parseLong(skin.processColor(colorString, false, isAndroid12OrHigher, getApplicationContext()),16);
									    } else {
									        color = (int) Long.parseLong(colorString, 16);
									    }
							} catch (Exception e) {
								    color = Color.BLACK; // Значення за замовчуванням у разі помилки
							}
							
							// Встановлення кольору тексту
							preview.setTextColor(color);
							applyColorsToViews(findViewById(android.R.id.content));
							break;
						}
						case ((int)5): {
							preview.setText(getString(R.string.trackcol));
							String colorString = _data.get((int)_position).get("c").toString();
							int color;
							
							try {
								    // Перевірка на формат Monet або шістнадцятковий код
								    if (colorString.startsWith("m__")) {
									        color = (int)Long.parseLong(skin.processColor(colorString, false, isAndroid12OrHigher, getApplicationContext()),16);
									    } else {
									        color = (int) Long.parseLong(colorString, 16);
									    }
							} catch (Exception e) {
								    color = Color.BLACK; // Значення за замовчуванням у разі помилки
							}
							
							// Встановлення кольору тексту
							preview.setTextColor(color);
							applyColorsToViews(findViewById(android.R.id.content));
							break;
						}
						case ((int)6): {
							preview.setText(getString(R.string.thumbcol));
							String colorString = _data.get((int)_position).get("c").toString();
							int color;
							
							try {
								    // Перевірка на формат Monet або шістнадцятковий код
								    if (colorString.startsWith("m__")) {
									        color = (int)Long.parseLong(skin.processColor(colorString, false, isAndroid12OrHigher, getApplicationContext()),16);
									    } else {
									        color = (int) Long.parseLong(colorString, 16);
									    }
							} catch (Exception e) {
								    color = Color.BLACK; // Значення за замовчуванням у разі помилки
							}
							
							// Встановлення кольору тексту
							preview.setTextColor(color);
							applyColorsToViews(findViewById(android.R.id.content));
							break;
						}
					}
					break;
				}
			}
			preview.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					ColorPickerDialog colorPickerDialog = new ColorPickerDialog(CustomthemeActivity.this);
					colorPickerDialog.setColorPickerListener(new ColorPickerDialog.ColorPickerListener() {
						    @Override
						    public void onColorPicked(String colorHex) {
							        // Оновлення кольору у колекції
							        col.get((int)_position).put("c", colorHex);
							
							        // Оновлення буфера після вибору кольору
							        buffer = "";
							        for (int i = 0; i < col.size(); i++) {
								            String colorString = col.get(i).get("c").toString();
								            // Обробка кольору з урахуванням можливого формату Monet
								            buffer = buffer + colorString;
								        }
							        switch ((int) state) {
								            case 0:
								                sf.edit().putString("bbg", buffer).commit();
								                break;
								            case 1:
								                sf.edit().putString("rbg", buffer).commit();
								                break;
								            case 2:
								                sf.edit().putString("bg", buffer).commit();
								                break;
								case 3:
								switch((int)_position) {
									case ((int)0): {
										sf.edit().putString("t", col.get((int)0).get("c").toString()).commit();
										break;
									}
									case ((int)1): {
										sf.edit().putString("tf", col.get((int)1).get("c").toString()).commit();
										break;
									}
									case ((int)2): {
										sf.edit().putString("add", col.get((int)2).get("c").toString()).commit();
										break;
									}
									case ((int)3): {
										sf.edit().putString("h", col.get((int)3).get("c").toString()).commit();
										break;
									}
									case ((int)4): {
										sf.edit().putString("cb", col.get((int)4).get("c").toString()).commit();
										break;
									}
									case ((int)5): {
										sf.edit().putString("tpc", col.get((int)5).get("c").toString()).commit();
										break;
									}
									case ((int)6): {
										sf.edit().putString("tc", col.get((int)6).get("c").toString()).commit();
										break;
									}
								}
								                }
							                                _updcol();
							                _colToRAM();
							
							            }
						        });
					
					        colorPickerDialog.show(col.get(_position).get("c").toString());
				}
			});
			colr.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					ColorPickerDialog colorPickerDialog = new ColorPickerDialog(CustomthemeActivity.this);
					colorPickerDialog.setColorPickerListener(new ColorPickerDialog.ColorPickerListener() {
						    @Override
						    public void onColorPicked(String colorHex) {
							        // Оновлення кольору у колекції
							        col.get((int)_position).put("c", colorHex);
							
							        // Оновлення буфера після вибору кольору
							        buffer = "";
							        for (int i = 0; i < col.size(); i++) {
								            String colorString = col.get(i).get("c").toString();
								            // Обробка кольору з урахуванням можливого формату Monet
								            buffer = buffer + colorString;
								        }
							        switch ((int) state) {
								            case 0:
								                sf.edit().putString("bbg", buffer).commit();
								                break;
								            case 1:
								                sf.edit().putString("rbg", buffer).commit();
								                break;
								            case 2:
								                sf.edit().putString("bg", buffer).commit();
								                break;
								case 3:
								switch((int)_position) {
									case ((int)0): {
										sf.edit().putString("t", col.get((int)0).get("c").toString()).commit();
										break;
									}
									case ((int)1): {
										sf.edit().putString("tf", col.get((int)1).get("c").toString()).commit();
										break;
									}
									case ((int)2): {
										sf.edit().putString("add", col.get((int)2).get("c").toString()).commit();
										break;
									}
									case ((int)3): {
										sf.edit().putString("h", col.get((int)3).get("c").toString()).commit();
										break;
									}
									case ((int)4): {
										sf.edit().putString("cb", col.get((int)4).get("c").toString()).commit();
										break;
									}
									case ((int)5): {
										sf.edit().putString("tpc", col.get((int)5).get("c").toString()).commit();
										break;
									}
									case ((int)6): {
										sf.edit().putString("tc", col.get((int)6).get("c").toString()).commit();
										break;
									}
								}
								                }
							                                _updcol();
							                _colToRAM();
							
							            }
						        });
					
					        colorPickerDialog.show(col.get(_position).get("c").toString());
				}
			});
			preview.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					if (col.size() > 1) {
						col.remove((int)(_position));
						buffer = "";
						                for (int i = 0; i < col.size(); i++) {
							                    try{buffer = buffer.concat(_toHexStr((int) Long.parseLong(col.get(i).get("c").toString())));}
							                        catch(Exception e){
								                    buffer = buffer.concat(col.get(i).get("c").toString());        
								                            }
							                }
						                switch ((int) state) {
							                    case 0:
							                        sf.edit().putString("bbg", buffer).commit();
							                        break;
							                    case 1:
							                        sf.edit().putString("rbg", buffer).commit();
							                        break;
							                    case 2:
							                        sf.edit().putString("bg", buffer).commit();
							                        break;
							                }
						                                _updcol();
						                _colToRAM();
					}
					return true;
				}
			});
			colr.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					if (col.size() > 1) {
						col.remove((int)(_position));
						buffer = "";
						                for (int i = 0; i < col.size(); i++) {
							                    try{buffer = buffer.concat(_toHexStr((int) Long.parseLong(col.get(i).get("c").toString())));}
							                        catch(Exception e){
								                    buffer = buffer.concat(col.get(i).get("c").toString());        
								                            }
							                }
						                switch ((int) state) {
							                    case 0:
							                        sf.edit().putString("bbg", buffer).commit();
							                        break;
							                    case 1:
							                        sf.edit().putString("rbg", buffer).commit();
							                        break;
							                    case 2:
							                        sf.edit().putString("bg", buffer).commit();
							                        break;
							                }
						                                _updcol();
						                _colToRAM();
					}
					return true;
				}
			});
			
			return _view;
		}
	}
}