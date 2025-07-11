package com.a525team.weekbrowser;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.ClipData;
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
import java.io.InputStream;
import java.text.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class CustomthemeActivity extends Activity {
	
	public final int REQ_CD_F = 101;
	
	private String lol = "";
	ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
	Colorify colorify = new Colorify();
	private double state = 0;
	private String buffer = "";
	private String currentColorHex = "";
	private String fffff = "";
	String[] colors = parseColorArray(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt"));
	String[] rcolors = parseColorArray(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt"));
	String[] bcolors = parseColorArray(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt"));
	
	private ArrayList<String> skin = new ArrayList<>();
	private ArrayList<String> languag = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> col = new ArrayList<>();
	
	private LinearLayout linear5;
	private HorizontalScrollView hscroll1;
	private ScrollView vscroll1;
	private LinearLayout linear3;
	private LinearLayout prevbtn;
	private LinearLayout prevcomp;
	private Button prev2;
	private TextView styletitle;
	private TextView stylename;
	private SeekBar style;
	private EditText edittext1;
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
	private SeekBar seekbar7;
	private CheckBox prevcheck;
	private RadioGroup radiogroup1;
	private RadioButton prevradio;
	private RadioButton prevradip;
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
	private Intent f = new Intent(Intent.ACTION_GET_CONTENT);
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.customtheme);
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
						        }}
		
		        super.onCreate(_savedInstanceState);
		        setContentView(R.layout.customtheme);
		linear5 = findViewById(R.id.linear5);
		hscroll1 = findViewById(R.id.hscroll1);
		vscroll1 = findViewById(R.id.vscroll1);
		linear3 = findViewById(R.id.linear3);
		prevbtn = findViewById(R.id.prevbtn);
		prevcomp = findViewById(R.id.prevcomp);
		prev2 = findViewById(R.id.prev2);
		styletitle = findViewById(R.id.styletitle);
		stylename = findViewById(R.id.stylename);
		style = findViewById(R.id.style);
		edittext1 = findViewById(R.id.edittext1);
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
		seekbar7 = findViewById(R.id.seekbar7);
		prevcheck = findViewById(R.id.prevcheck);
		radiogroup1 = findViewById(R.id.radiogroup1);
		prevradio = findViewById(R.id.prevradio);
		prevradip = findViewById(R.id.prevradip);
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
		f.setType("*/*");
		f.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		prev2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
				
				                switch ((int) state) {
					                    case 0:
					                    currentColorHex = FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttontext.txt");
					                        break;
					                    case 1:
					                        currentColorHex = FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttontext.txt");
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
							                FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttontext.txt", colorHex);
							                break;
							            case 1:
							                FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttontext.txt", colorHex);
							                break;              }
						                                _updcol();
						                _colToRAM();
						
						            }
					        });
				
				        colorPickerDialog.show(currentColorHex);
			}
		});
		
		style.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				switch((int)_progressValue) {
					case ((int)0): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/style.txt", "1");
						stylename.setText("Android 1");
						break;
					}
					case ((int)1): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/style.txt", "3");
						stylename.setText("Holo Dark");
						break;
					}
					case ((int)2): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/style.txt", "4");
						stylename.setText("Holo Light");
						break;
					}
					case ((int)3): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/style.txt", "5");
						stylename.setText("Material Dark (Android 5.0+)");
						break;
					}
					case ((int)4): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/style.txt", "6");
						stylename.setText("Material Light (Android 5.0+)");
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
				if (edittext1.getText().toString().isEmpty()) {
					SketchwareUtil.showMessage(getApplicationContext(), "БУДЬТЕ УВАЖНІШІ! Немає назви скіна");
				}
				else {
					if (!FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/CUSTOMDESIGNLIBRARY")) {
						FileUtil.makeDir("/storage/emulated/0/WeekBrowser/CUSTOMSKINLIBRARY");
					}
					try {
						Zip.zipFolder("/storage/emulated/0/WeekBrowser/CustomTheme","/storage/emulated/0/WeekBrowser/CUSTOMSKINLIBRARY/" + edittext1.getText().toString().concat(".wesk2"));
					} catch(Exception e) {}
					SketchwareUtil.showMessage(getApplicationContext(), "Збережено!");
				}
			}
		});
		
		grad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				switch((int)state) {
					case ((int)0): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradient.txt", String.valueOf((long)(_progressValue)));
						break;
					}
					case ((int)1): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redgradient.txt", String.valueOf((long)(_progressValue)));
						break;
					}
					case ((int)2): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradient.txt", String.valueOf((long)(_progressValue)));
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
				switch((int)state) {
					case ((int)0): {
						if (_progressValue < 20) {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/stripecount.txt", String.valueOf((long)(_progressValue + 2)));
						}
						else {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/stripecount.txt", String.valueOf((long)(((_progressValue - 20) * 4) + 21)));
						}
						break;
					}
					case ((int)1): {
						if (_progressValue < 20) {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/rstripecount.txt", String.valueOf((long)(_progressValue + 2)));
						}
						else {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/rstripecount.txt", String.valueOf((long)(((_progressValue - 20) * 4) + 21)));
						}
						break;
					}
					case ((int)2): {
						if (_progressValue < 20) {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bstripecount.txt", String.valueOf((long)(_progressValue + 2)));
						}
						else {
							FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bstripecount.txt", String.valueOf((long)(((_progressValue - 20) * 4) + 21)));
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
				switch((int)state) {
					case ((int)0): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/tilemode.txt", String.valueOf((long)(Math.pow(2, _progressValue))));
						break;
					}
					case ((int)1): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redtilemode.txt", String.valueOf((long)(Math.pow(2, _progressValue))));
						break;
					}
					case ((int)2): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgtilemode.txt", String.valueOf((long)(Math.pow(2, _progressValue))));
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
				switch((int)state) {
					case ((int)0): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradrad.txt", String.valueOf(_progressValue / 20.d));
						break;
					}
					case ((int)1): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradrad.txt", String.valueOf(_progressValue / 20.d));
						break;
					}
					case ((int)2): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradrad.txt", String.valueOf(_progressValue / 20.d));
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
				switch((int)state) {
					case ((int)0): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradX.txt", String.valueOf((_progressValue - 40) / 20.d));
						break;
					}
					case ((int)1): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradX.txt", String.valueOf((_progressValue - 40) / 20.d));
						break;
					}
					case ((int)2): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradX.txt", String.valueOf((_progressValue - 40) / 20.d));
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
				switch((int)state) {
					case ((int)0): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradY.txt", String.valueOf((_progressValue - 40) / 20.d));
						break;
					}
					case ((int)1): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradY.txt", String.valueOf((_progressValue - 40) / 20.d));
						break;
					}
					case ((int)2): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradY.txt", String.valueOf((_progressValue - 40) / 20.d));
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
				switch((int)state) {
					case ((int)0): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/roundness.txt", String.valueOf((long)(_progressValue)));
						break;
					}
					case ((int)1): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/rroundness.txt", String.valueOf((long)(_progressValue)));
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
				switch((int)state) {
					case ((int)0): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/sroundness.txt", String.valueOf((long)(_progressValue)));
						break;
					}
					case ((int)1): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/rsroundness.txt", String.valueOf((long)(_progressValue)));
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
				switch((int)state) {
					case ((int)0): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt").concat("FFFF0000"));
						break;
					}
					case ((int)1): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt").concat("FFFF0000"));
						break;
					}
					case ((int)2): {
						FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt").concat("FFFF0000"));
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
				buffer = "";
				                for (int i = 0; i < col.size(); i++) {
					                    buffer = buffer.concat(col.get(i).get("c").toString());
					                }
				                switch ((int) state) {
					                    case 0:
					                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt", buffer);
					                        break;
					                    case 1:
					                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt", buffer);
					                        break;
					                    case 2:
					                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt", buffer);
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
				buffer = "";
				                for (int i = 0; i < col.size(); i++) {
					                    buffer = buffer.concat(col.get(i).get("c").toString());
					                }
				                switch ((int) state) {
					                    case 0:
					                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt", buffer);
					                        break;
					                    case 1:
					                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt", buffer);
					                        break;
					                    case 2:
					                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt", buffer);
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
				for (int i = ((int) col.size() - 1 - 1); i > -1; i--) {
					Collections.swap(col, (int)(i), (int)(i+1));
				}
				col.get((int)0).put("c", buffer2);
				buffer = "";
				                for (int i = 0; i < col.size(); i++) {
					                    buffer = buffer.concat(col.get(i).get("c").toString());
					                }
				                switch ((int) state) {
					                    case 0:
					                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt", buffer);
					                        break;
					                    case 1:
					                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt", buffer);
					                        break;
					                    case 2:
					                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt", buffer);
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
				                for (int i = 0; i < col.size(); i++) {
					                    buffer = buffer.concat(col.get(i).get("c").toString());
					                }
				                switch ((int) state) {
					                    case 0:
					                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt", buffer);
					                        break;
					                    case 1:
					                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt", buffer);
					                        break;
					                    case 2:
					                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt", buffer);
					                        break;
					                }
				                                _updcol();
				                _colToRAM();
			}
		});
	}
	
	private void initializeLogic() {
		gridcol.setAdapter(new GridcolAdapter(col));
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
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_F:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				j.setClass(getApplicationContext(), IntentActivity.class);
				j.setData(Uri.parse(_filePath.get((int)(0))));
				startActivity(j);
			}
			else {
				
			}
			break;
			default:
			break;
		}
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
	
	
	public void _language() {
		try{
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
			}
			else {
				
			}
		}
		try{
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
			}
			else {
				
			}
		}
		try{
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
			}
			else {
				
			}
		}
		try{
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
			}
			else {
				
			}
		}
		try{
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
			}
			else {
				
			}
		}
		try{
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
			}
			else {
				
			}
		}
		try{
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
			}
			else {
				
			}
		}
		try{
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
			}
			else {
				
			}
		}
		try{
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
			}
			else {
				
			}
		}
		try{
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
			}
			else {
				
			}
		}
		try{
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
			}
			else {
				
			}
		}
		try{
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
			}
			else {
				
			}
		}
		try{
			
		}catch(Exception e){
			if (FileUtil.isExistFile("/storage/emulated/0/WeekBrowser/Language.welang")) {
				
			}
			else {
				
			}
		}
	}
	
	
	public double _fromHex(final String _str) {
		        int decimalValue = (int)Long.parseLong(_str, 16);
		        return decimalValue;
	}
	
	
	public void _extra() {
	}
	
	
	/*MADE BY ARAB WARE CHANNEL*/
	/*WHAT IS MADE ? ===>ADD FOLDER TO ZIP*/
	
	public void ArabWareAddFolderToZip (String _from,String _to) {
		if (FileUtil.isExistFile(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"))) {
				new UnZip().unZipIt(_to, _to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
				new java.io.File(_from).renameTo(new java.io.File(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/").concat(Uri.parse(_from).getLastPathSegment())));
				try {
						Zip.zipFolder(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"),_to.replace(Uri.parse(_to).getLastPathSegment(), "") + Uri.parse(_to).getLastPathSegment());
				} catch(Exception e) {}
				FileUtil.deleteFile(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
		}
		else {
				FileUtil.makeDir(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
				new UnZip().unZipIt(_to, _to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
				new java.io.File(_from).renameTo(new java.io.File(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/").concat(Uri.parse(_from).getLastPathSegment())));
				try {
						Zip.zipFolder(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"),_to.replace(Uri.parse(_to).getLastPathSegment(), "") + Uri.parse(_to).getLastPathSegment());
				} catch(Exception e) {}
				FileUtil.deleteFile(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
		}
	}
	
	
	
	public void addFilesToZip(java.io.File source, java.io.File files)
	{
		    try
		    {
			
			   
			        byte[] buffer = new byte[1024];
			        java.util.zip.ZipInputStream zin = new java.util.zip.ZipInputStream(new java.io.FileInputStream(files));
			        java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(source));
			            java.io.InputStream in = new java.io.FileInputStream(files);
			            out.putNextEntry(new java.util.zip.ZipEntry(files.getName()));
			            for(int read = in.read(buffer); read > -1; read = in.read(buffer))
			            {
				                out.write(buffer, 0, read);
				            }
			            out.closeEntry();
			            in.close();
			
			        for(java.util.zip.ZipEntry ze = zin.getNextEntry(); ze != null; ze = zin.getNextEntry())
			        {
				            out.putNextEntry(ze);
				            for(int read = zin.read(buffer); read > -1; read = zin.read(buffer))
				            {
					                out.write(buffer, 0, read);
					            }
				            out.closeEntry();
				        }
			
			        out.close();
			      
			    }
		    catch(Exception e)
		    {
			       showMessage(e.getMessage());
			    }
	}
	public static class Zip {
		
		public static void zipFolder(String str, String str2) throws Exception {
			            java.util.zip.ZipOutputStream zipOutputStream = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(str2));
			            addFolderToZip("", str, zipOutputStream);
			            zipOutputStream.flush();
			            zipOutputStream.close();
			        }
		
		
		public static void addFolderToZip(String str, String str2, java.util.zip.ZipOutputStream zipOutputStream) throws Exception {
			            java.io.File file = new java.io.File(str2);
			            for (String str3 : file.list()) {
				                if (str.equals("")) {
					                    addFileToZip(file.getName(), new StringBuilder(String.valueOf(str2)).append("/").append(str3).toString(), zipOutputStream);
					                } else {
					                    addFileToZip(new StringBuilder(String.valueOf(str)).append("/").append(file.getName()).toString(), new StringBuilder(String.valueOf(str2)).append("/").append(str3).toString(), zipOutputStream);
					                }
				            }
			        }
		
		
		
		  public static void addFileToZip(String path, String srcFile, java.util.zip.ZipOutputStream zip)
		      throws Exception {
			    java.io.File folder = new java.io.File(srcFile);
			    if (folder.isDirectory()) {
				      
				    } else {
				      byte[] buf = new byte[1024];
				      int len;
				      java.io.FileInputStream in = new java.io.FileInputStream(srcFile);
				      zip.putNextEntry(new java.util.zip.ZipEntry(path + "/" + folder.getName()));
				      while ((len = in.read(buf)) > 0) {
					        zip.write(buf, 0, len);
					      }
				    }
		}
		  }
	
	public static class UnZip {
		List<String> fileList;
		
		public void unZipIt(String zipFile, String outputFolder){
			byte[] buffer = new byte[1024];
			try{
				java.util.zip.ZipInputStream zis = new java.util.zip.ZipInputStream(new java.io.FileInputStream(zipFile));
				java.util.zip.ZipEntry ze = zis.getNextEntry();
				while(ze!=null){
					String fileName = ze.getName();
					java.io.File newFile = new java.io.File(outputFolder + java.io.File.separator + fileName);
					new java.io.File(newFile.getParent()).mkdirs();
					java.io.FileOutputStream fos = new java.io.FileOutputStream(newFile);
					int len;
					while ((len = zis.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}
					fos.close();
					ze = zis.getNextEntry(); 
				}
				zis.closeEntry();
				zis.close();
			}catch(java.io.IOException ex){
				ex.printStackTrace();
			}
		}
	}
	String[] parseColorArray(String colorString) {
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
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		
		switch(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Themes/theme.txt")) {
			case "0": {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
					
					dataHolder.setData("bg", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_10)).toUpperCase());
					dataHolder.setData("bbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("bbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("rbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("rbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("t", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase());
					dataHolder.setData("tf", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase());
					dataHolder.setData("add", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("h", Integer.toHexString(getResources().getColor(android.R.color.system_accent2_600)).toUpperCase());
					dataHolder.setData("cb", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("tpc", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("tc", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("bt", "ffffffff");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("tm", "2");
					dataHolder.setData("rtm", "2");
					dataHolder.setData("btm", "2");
					
				}else{
					dataHolder.setData("bg", "ffffffff");
					dataHolder.setData("bbg", "ff018577");
					dataHolder.setData("bbg2", "ff018577");
					dataHolder.setData("rbg", "fff44336");
					dataHolder.setData("rbg2", "ff44336");
					dataHolder.setData("t", "ff000000");
					dataHolder.setData("tf", "ff000000");
					dataHolder.setData("add", "ff018577");
					dataHolder.setData("h", "ff888888");
					dataHolder.setData("bt", "ffffffff");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", "ff018577");
					dataHolder.setData("tpc", "ff018577");
					dataHolder.setData("tc", "ff018577");
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("tm", "2");
					dataHolder.setData("rtm", "2");
					dataHolder.setData("btm", "2");
					
				}
				break;
			}
			case "1": {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
					
					dataHolder.setData("bg", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_900)).toUpperCase());
					dataHolder.setData("bbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("bbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("rbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("rbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("t", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase());
					dataHolder.setData("tf", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase());
					dataHolder.setData("add", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("h", Integer.toHexString(getResources().getColor(android.R.color.system_accent2_200)).toUpperCase());
					dataHolder.setData("bt", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_800)).toUpperCase());
					dataHolder.setData("rbt", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_800)).toUpperCase());
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("tpc", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("tc", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("tm", "2");
					dataHolder.setData("rtm", "2");
					dataHolder.setData("btm", "2");
					
					
				}else{
					dataHolder.setData("bg", "ff303030");
					dataHolder.setData("bbg", "ff80cbc4");
					dataHolder.setData("bbg2", "ff80cbc4");
					dataHolder.setData("rbg", "fff44336");
					dataHolder.setData("rbg2", "fff44336");
					dataHolder.setData("t", "ffffffff");
					dataHolder.setData("tf", "ffffffff");
					dataHolder.setData("add", "ff80cbc4");
					dataHolder.setData("h", "ff888888");
					dataHolder.setData("bt", "ff000000");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", "ff80cbc4");
					dataHolder.setData("tpc", "ff80cbc4");
					dataHolder.setData("tc", "ff80cbc4");
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("tm", "2");
					dataHolder.setData("rtm", "2");
					dataHolder.setData("btm", "2");
					
				}
				break;
			}
			case "2": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ff00ffff");
				dataHolder.setData("bbg2", "ff00ffff");
				dataHolder.setData("rbg", "ffff0000");
				dataHolder.setData("rbg2", "ffff0000");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff00ffff");
				dataHolder.setData("h", "ffffff00");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ffffff00");
				dataHolder.setData("tpc", "ff00ff00");
				dataHolder.setData("tc", "ff00ffff");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "2");
				dataHolder.setData("rtm", "2");
				dataHolder.setData("btm", "2");
				
				break;
			}
			case "4": {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
					
					dataHolder.setData("bg", "ffffffff");
					dataHolder.setData("bbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("bbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("rbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("rbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("t", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase());
					dataHolder.setData("tf", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase());
					dataHolder.setData("add", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase());
					dataHolder.setData("h", Integer.toHexString(getResources().getColor(android.R.color.system_accent2_600)).toUpperCase());
					dataHolder.setData("bt", "ffffffff");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("tpc", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					dataHolder.setData("tc", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase());
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					dataHolder.setData("tm", "2");
					dataHolder.setData("rtm", "2");
					dataHolder.setData("btm", "2");
					
					
				}else{
					dataHolder.setData("bg", "ffffffff");
					dataHolder.setData("bbg", "ff018577");
					dataHolder.setData("bbg2", "ff018577");
					dataHolder.setData("rbg", "fff44336");
					dataHolder.setData("rbg2", "fff44336");
					dataHolder.setData("t", "ff000000");
					dataHolder.setData("tf", "ff000000");
					dataHolder.setData("add", "ff018577");
					dataHolder.setData("h", "ff888888");
					dataHolder.setData("bt", "ffffffff");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", "ff018577");
					dataHolder.setData("tpc", "ff018577");
					dataHolder.setData("tc", "ff018577");
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("tm", "2");
					dataHolder.setData("rtm", "2");
					dataHolder.setData("btm", "2");
					
					dataHolder.setData("tmy", "2");
					dataHolder.setData("rtmy", "2");
					dataHolder.setData("btmy", "2");
					
					
				}
				break;
			}
			case "5": {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
					
					dataHolder.setData("bg", "ff000000");
					dataHolder.setData("bbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("bbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("rbg", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("rbg2", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("t", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase());
					dataHolder.setData("tf", Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase());
					dataHolder.setData("add", Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase());
					dataHolder.setData("h", Integer.toHexString(getResources().getColor(android.R.color.system_accent2_200)).toUpperCase());
					dataHolder.setData("bt", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_800)).toUpperCase());
					dataHolder.setData("rbt", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_800)).toUpperCase());
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("tpc", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					dataHolder.setData("tc", Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase());
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("tm", "2");
					dataHolder.setData("rtm", "2");
					dataHolder.setData("btm", "2");
					
					
				}else{
					dataHolder.setData("bg", "ff000000");
					dataHolder.setData("bbg", "ff80cbc4");
					dataHolder.setData("bbg2", "ff80cbc4");
					dataHolder.setData("rbg", "fff44336");
					dataHolder.setData("rbg2", "fff44336");
					dataHolder.setData("t", "ffffffff");
					dataHolder.setData("tf", "ffffffff");
					dataHolder.setData("add", "ff80cbc4");
					dataHolder.setData("h", "ff888888");
					dataHolder.setData("bt", "ff000000");
					dataHolder.setData("rbt", "ffffffff");
					dataHolder.setData("rou", "12");
					dataHolder.setData("cb", "ff80cbc4");
					dataHolder.setData("tpc", "ff80cbc4");
					dataHolder.setData("tc", "ff80cbc4");
					dataHolder.setData("grad", "0");
					dataHolder.setData("rgrad", "0");
					dataHolder.setData("bgrad", "0");
					
					dataHolder.setData("rad", "1");
					dataHolder.setData("x", "0.5");
					dataHolder.setData("y", "0.5");
					dataHolder.setData("strcou", "2");
					
					dataHolder.setData("rrad", "1");
					dataHolder.setData("rx", "0.5");
					dataHolder.setData("ry", "0.5");
					dataHolder.setData("rstrcou", "2");
					
					dataHolder.setData("brad", "1");
					dataHolder.setData("bx", "0.5");
					dataHolder.setData("by", "0.5");
					dataHolder.setData("bstrcou", "2");
					
					dataHolder.setData("rrou", "4");
					dataHolder.setData("srou", "6");
					dataHolder.setData("rsrou", "2");
					
					dataHolder.setData("tm", "2");
					dataHolder.setData("rtm", "2");
					dataHolder.setData("btm", "2");
					
				}
				break;
			}
			case "6": {
				dataHolder.setData("bg", "ffffffff");
				dataHolder.setData("bbg", "ff33b5e5");
				dataHolder.setData("bbg2", "ff33b5e5");
				dataHolder.setData("rbg", "ffb71c1c");
				dataHolder.setData("rbg2", "ffb71c1c");
				dataHolder.setData("t", "ff000000");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff35b5e5");
				dataHolder.setData("h", "ff757575");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ff33b5e5");
				dataHolder.setData("tpc", "ff33b5e5");
				dataHolder.setData("tc", "ff33b5e5");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "2");
				dataHolder.setData("rtm", "2");
				dataHolder.setData("btm", "2");
				
				
				break;
			}
			case "7": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ff33b5e5");
				dataHolder.setData("bbg2", "ff33b5e5");
				dataHolder.setData("rbg", "ffb71c1c");
				dataHolder.setData("rbg2", "ffb71c1c");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ffffffff");
				dataHolder.setData("add", "ff35b5e5");
				dataHolder.setData("h", "ffbdbdbd");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ff33b5e5");
				dataHolder.setData("tpc", "ff33b5e5");
				dataHolder.setData("tc", "ff33b5e5");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "2");
				dataHolder.setData("rtm", "2");
				dataHolder.setData("btm", "2");
				
				
				break;
			}
			case "8": {
				dataHolder.setData("bg", "ffffffff");
				dataHolder.setData("bbg", "ff018577");
				dataHolder.setData("bbg2", "ff018577");
				dataHolder.setData("rbg", "fff44336");
				dataHolder.setData("rbg2", "fff44336");
				dataHolder.setData("t", "ff000000");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff018577");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ffffffff");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "12");
				dataHolder.setData("cb", "ff018577");
				dataHolder.setData("tpc", "ff018577");
				dataHolder.setData("tc", "ff018577");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "4");
				dataHolder.setData("srou", "6");
				dataHolder.setData("rsrou", "2");
				
				dataHolder.setData("tm", "2");
				dataHolder.setData("rtm", "2");
				dataHolder.setData("btm", "2");
				
				break;
			}
			case "9": {
				dataHolder.setData("bg", "ff303030");
				dataHolder.setData("bbg", "ff80cbc4");
				dataHolder.setData("bbg2", "ff80cbc4");
				dataHolder.setData("rbg", "fff44336");
				dataHolder.setData("rbg2", "fff44336");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ffffffff");
				dataHolder.setData("add", "ff80cbc4");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "12");
				dataHolder.setData("cb", "ff80cbc4");
				dataHolder.setData("tpc", "ff80cbc4");
				dataHolder.setData("tc", "ff80cbc4");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "4");
				dataHolder.setData("srou", "6");
				dataHolder.setData("rsrou", "2");
				
				dataHolder.setData("tm", "2");
				dataHolder.setData("rtm", "2");
				dataHolder.setData("btm", "2");
				
				break;
			}
			case "10": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ff80cbc4");
				dataHolder.setData("bbg2", "ff80cbc4");
				dataHolder.setData("rbg", "fff44336");
				dataHolder.setData("rbg2", "fff44336");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ffffffff");
				dataHolder.setData("add", "ff80cbc4");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffffffff");
				dataHolder.setData("rou", "12");
				dataHolder.setData("cb", "ff80cbc4");
				dataHolder.setData("tpc", "ff80cbc4");
				dataHolder.setData("tc", "ff80cbc4");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "4");
				dataHolder.setData("srou", "6");
				dataHolder.setData("rsrou", "2");
				
				dataHolder.setData("tm", "2");
				dataHolder.setData("rtm", "2");
				dataHolder.setData("btm", "2");
				
				break;
			}
			case "11": {
				dataHolder.setData("bg", "ffffffff");
				dataHolder.setData("bbg", "ffeaeaea");
				dataHolder.setData("bbg2", "ffb8b8b8");
				dataHolder.setData("rbg", "ffeaeaea");
				dataHolder.setData("rbg2", "ffb8b8b8");
				dataHolder.setData("t", "ff000000");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff68B200");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffff0000");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ff68B200");
				dataHolder.setData("tpc", "ffffbb00");
				dataHolder.setData("tc", "ff9b9b9b");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "2");
				dataHolder.setData("rtm", "2");
				dataHolder.setData("btm", "2");
				
				break;
			}
			case "12": {
				dataHolder.setData("bg", "ff000000");
				dataHolder.setData("bbg", "ffeaeaea");
				dataHolder.setData("bbg2", "ffb8b8b8");
				dataHolder.setData("rbg", "ffeaeaea");
				dataHolder.setData("rbg2", "ffb8b8b8");
				dataHolder.setData("t", "ffffffff");
				dataHolder.setData("tf", "ff000000");
				dataHolder.setData("add", "ff90ff22");
				dataHolder.setData("h", "ff888888");
				dataHolder.setData("bt", "ff000000");
				dataHolder.setData("rbt", "ffff0000");
				dataHolder.setData("rou", "0");
				dataHolder.setData("cb", "ff90ff22");
				dataHolder.setData("tpc", "ffffbb00");
				dataHolder.setData("tc", "ff9b9b9b");
				dataHolder.setData("grad", "0");
				dataHolder.setData("rgrad", "0");
				dataHolder.setData("bgrad", "0");
				
				dataHolder.setData("rad", "1");
				dataHolder.setData("x", "0.5");
				dataHolder.setData("y", "0.5");
				dataHolder.setData("strcou", "2");
				
				dataHolder.setData("rrad", "1");
				dataHolder.setData("rx", "0.5");
				dataHolder.setData("ry", "0.5");
				dataHolder.setData("rstrcou", "2");
				
				dataHolder.setData("brad", "1");
				dataHolder.setData("bx", "0.5");
				dataHolder.setData("by", "0.5");
				dataHolder.setData("bstrcou", "2");
				
				dataHolder.setData("rrou", "0");
				dataHolder.setData("srou", "0");
				dataHolder.setData("rsrou", "0");
				
				dataHolder.setData("tm", "2");
				dataHolder.setData("rtm", "2");
				dataHolder.setData("btm", "2");
				
				break;
			}
			case "3": {
				
				
				// Призначення кольорів
				if (isAndroid12OrHigher) {
					    dataHolder.setData("bg", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt"), true, true));
					    dataHolder.setData("bbg", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt"), true, true));
					    dataHolder.setData("rbg", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt"), true, true));
					    dataHolder.setData("t", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/text.txt"), false, true));
					    dataHolder.setData("tf", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/textfield.txt"), false, true));
					    dataHolder.setData("add", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/additional.txt"), false, true));
					    dataHolder.setData("h", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/hint.txt"), false, true));
					    dataHolder.setData("bt", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttontext.txt"), false, true));
					    dataHolder.setData("rbt", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttontext.txt"), false, true));
					    dataHolder.setData("cb", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/composebuttoncolor.txt"), false, true));
					dataHolder.setData("tpc", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/trackpadcolor.txt"), false, true));
					dataHolder.setData("tc", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/thumbcolor.txt"), false, true));
				} else {
					    // Стандартні кольори для версій нижче Android 12 з урахуванням відтінку
					    dataHolder.setData("bg", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt"), true, false));
					    dataHolder.setData("bbg", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt"), true, false));
					    dataHolder.setData("rbg", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt"), true, false));
					        dataHolder.setData("t", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/text.txt"), false, false));
					    dataHolder.setData("tf", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/textfield.txt"), false, false));
					    dataHolder.setData("add", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/additional.txt"), false, false));
					    dataHolder.setData("h", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/hint.txt"), false, false));
					    dataHolder.setData("bt", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttontext.txt"), false, false));
					    dataHolder.setData("rbt", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttontext.txt"), false, false));
					    dataHolder.setData("cb", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/composebuttoncolor.txt"), false, false));
					dataHolder.setData("tpc", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/trackpadcolor.txt"), false, false));
					dataHolder.setData("tc", processColor(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/thumbcolor.txt"), false, false));
				}
				
				
				dataHolder.setData("rou", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/roundness.txt"));
				
				dataHolder.setData("grad", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradient.txt"));
				dataHolder.setData("rgrad", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redgradient.txt"));
				dataHolder.setData("bgrad", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradient.txt"));
				
				dataHolder.setData("rad", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradrad.txt"));
				dataHolder.setData("x", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradX.txt"));
				dataHolder.setData("y", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradY.txt"));
				dataHolder.setData("strcou", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/stripecount.txt"));
				
				dataHolder.setData("rrad", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradrad.txt"));
				dataHolder.setData("rx", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradX.txt"));
				dataHolder.setData("ry", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradY.txt"));
				dataHolder.setData("rstrcou", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rstripecount.txt"));
				
				dataHolder.setData("brad", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradrad.txt"));
				dataHolder.setData("bx", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradX.txt"));
				dataHolder.setData("by", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradY.txt"));
				dataHolder.setData("bstrcou", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bstripecount.txt"));
				
				dataHolder.setData("rrou", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rroundness.txt"));
				dataHolder.setData("srou", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/sroundness.txt"));
				dataHolder.setData("rsrou", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rsroundness.txt"));
				
				dataHolder.setData("tm", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/tilemode.txt"));
				dataHolder.setData("rtm", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redtilemode.txt"));
				dataHolder.setData("btm", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgtilemode.txt"));
				
				break;
			}
		}
		dataHolder = ExtendedDataHolder.getInstance();
		Skin skin = new Skin();
		
		
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
	
	// Метод для перевірки і заміни кольорів
	String processColor(String color, boolean isMultiColor, boolean isAndroid12OrHigher) {
		    StringBuilder result = new StringBuilder();
		
		    for (int i = 0; i < color.length(); i += 8) {
			        String part = color.substring(i, i + 8);
			
			        if (part.startsWith("m__")) {
				            if (isAndroid12OrHigher) {
					                // Використання методу для парсингу Monet кольору
					                result.append(selcol(part.substring(3)));
					            } else {
					                // Парсинг відтінку на старіших версіях Android
					                result.append(getLegacyColor(part.substring(3)));
					            }
				        } else {
				            // Додавання кольору як є
				            result.append(part);
				        }
			    }
		
		    return result.toString();
	}
	
	String getLegacyColor(String shade) {
		    switch (shade) {
			case "n1010": return "0xFFFEFAFE";
			case "n1050": return "0xFFFAFAFA";
			case "n1100": return "0xFFF5F5F5";
			case "n1200": return "0xFFEEEEEE";
			case "n1300": return "0xFFE0E0E0";
			case "n1400": return "0xFFBDBDBD";
			case "n1500": return "0xFF9E9E9E";
			case "n1600": return "0xFF757575";
			case "n1700": return "0xFF616161";
			case "n1800": return "0xFF424242";
			case "n1900": return "0xFF212121";
			
			//neutral 2
			case "n2010": return "0xFFF2F3F6";
			case "n2050": return "0xFFECEFF1";
			case "n2100": return "0xFFCFD8DC";
			case "n2200": return "0xFFB0BEC5";
			case "n2300": return "0xFF90A4AE";
			case "n2400": return "0xFF78909C";
			case "n2500": return "0xFF607D8B";
			case "n2600": return "0xFF546E7A";
			case "n2700": return "0xFF455A64";
			case "n2800": return "0xFF37474F";
			case "n2900": return "0xFF263238";
			
			//accent 1
			case "a1010": return "0xFFE9F6FB";
			case "a1050": return "0xFFE0F2F1";
			case "a1100": return "0xFFB2DFDB";
			case "a1200": return "0xFF80CBC4";
			case "a1300": return "0xFF4DB6AC";
			case "a1400": return "0xFF26A69A";
			case "a1500": return "0xFF009688";
			case "a1600": return "0xFF00897B";
			case "a1700": return "0xFF00796B";
			case "a1800": return "0xFF00695C";
			case "a1900": return "0xFF004D40";
			
			//accent 2
			case "a2010": return "0xFFF2FFFC";
			case "a2050": return "0xFFDAF7F3";
			case "a2100": return "0xFFCCE8E4";
			case "a2200": return "0xFFB0CCC8";
			case "a2300": return "0xFF96B1AD";
			case "a2400": return "0xFF7B9693";
			case "a2500": return "0xFF617B78";
			case "a2600": return "0xFF4A6360";
			case "a2700": return "0xFF324B49";
			case "a2800": return "0xFF1C3532";
			case "a2900": return "0xFF051F1D";
			
			//accent 3
			case "a3010": return "0xFFFCFCFF";
			case "a3050": return "0xFFE9F1FF";
			case "a3100": return "0xFFCFE5FF";
			case "a3200": return "0xFFAFC9E7";
			case "a3300": return "0xFF94AECB";
			case "a3400": return "0xFF7A93AF";
			case "a3500": return "0xFF607893";
			case "a3600": return "0xFF48617B";
			case "a3700": return "0xFF304962";
			case "a3800": return "0xFF18324A";
			case "a3900": return "0xFF001D34";
		}return "FFFF0000";}
	
	String selcol(String _col){
		
		try{
				switch(_col) {
						case "n1010": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_10)).toUpperCase();
								break;
						}
						case "n1050": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_50)).toUpperCase();
								break;
						}
						case "n1100": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_100)).toUpperCase();
								break;
						}
						case "n1200": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_200)).toUpperCase();
								break;
						}
						case "n1300": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_300)).toUpperCase();
								break;
						}
						case "n1400": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_400)).toUpperCase();
								break;
						}
						case "n1500": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_500)).toUpperCase();
								break;
						}
						case "n1600": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_600)).toUpperCase();
								break;
						}
						case "n1700": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_700)).toUpperCase();
								break;
						}
						case "n1800": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_800)).toUpperCase();
								break;
						}
						case "n1900": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral1_900)).toUpperCase();
								break;
						}
						case "n2010": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_10)).toUpperCase();
								break;
						}
						case "n2050": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_50)).toUpperCase();
								break;
						}
						case "n2100": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_100)).toUpperCase();
								break;
						}
						case "n2200": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_200)).toUpperCase();
								break;
						}
						case "n2300": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_300)).toUpperCase();
								break;
						}
						case "n2400": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_400)).toUpperCase();
								break;
						}
						case "n2500": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_500)).toUpperCase();
								break;
						}
						case "n2600": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_600)).toUpperCase();
								break;
						}
						case "n2700": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_700)).toUpperCase();
								break;
						}
						case "n2800": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_800)).toUpperCase();
								break;
						}
						case "n2900": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_neutral2_900)).toUpperCase();
								break;
						}
						case "a1010": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_10)).toUpperCase();
								break;
						}
						case "a1050": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_50)).toUpperCase();
								break;
						}
						case "a1100": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_100)).toUpperCase();
								break;
						}
						case "a1200": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_200)).toUpperCase();
								break;
						}
						case "a1300": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_300)).toUpperCase();
								break;
						}
						case "a1400": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_400)).toUpperCase();
								break;
						}
						case "a1500": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_500)).toUpperCase();
								break;
						}
						case "a1600": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_600)).toUpperCase();
								break;
						}
						case "a1700": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_700)).toUpperCase();
								break;
						}
						case "a1800": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_800)).toUpperCase();
								break;
						}
						case "a1900": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent1_900)).toUpperCase();
								break;
						}
						case "a2010": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_10)).toUpperCase();
								break;
						}
						case "a2050": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_50)).toUpperCase();
								break;
						}
						case "a2100": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_100)).toUpperCase();
								break;
						}
						case "a2200": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_200)).toUpperCase();
								break;
						}
						case "a2300": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_300)).toUpperCase();
								break;
						}
						case "a2400": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_400)).toUpperCase();
								break;
						}
						case "a2500": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_500)).toUpperCase();
								break;
						}
						case "a2600": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_600)).toUpperCase();
								break;
						}
						case "a2700": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_700)).toUpperCase();
								break;
						}
						case "a2800": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_800)).toUpperCase();
								break;
						}
						case "a2900": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent2_900)).toUpperCase();
								break;
						}
						case "a3010": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_10)).toUpperCase();
								break;
						}
						case "a3050": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_50)).toUpperCase();
								break;
						}
						case "a3100": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_100)).toUpperCase();
								break;
						}
						case "a3200": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_200)).toUpperCase();
								break;
						}
						case "a3300": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_300)).toUpperCase();
								break;
						}
						case "a3400": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_400)).toUpperCase();
								break;
						}
						case "a3500": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_500)).toUpperCase();
								break;
						}
						case "a3600": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_600)).toUpperCase();
								break;
						}
						case "a3700": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_700)).toUpperCase();
								break;
						}
						case "a3800": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_800)).toUpperCase();
								break;
						}
						case "a3900": {
								fffff = Integer.toHexString(getResources().getColor(android.R.color.system_accent3_900)).toUpperCase();
								break;
						}
						
				}
		}catch(Exception e){
				SketchwareUtil.showMessage(getApplicationContext(), "Monet error");return("ffff0000");
		}
		return (fffff);
		
	}
	
	boolean isAndroid12OrHigher = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S;
	{
	}
	
	
	public void _updcol() {
		colors = parseColorArray(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt"));
		rcolors = parseColorArray(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt"));
		bcolors = parseColorArray(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt"));
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
					_item.put("c", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/text.txt"));
					col.add(_item);
				}
				
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("c", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/textfield.txt"));
					col.add(_item);
				}
				
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("c", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/additional.txt"));
					col.add(_item);
				}
				
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("c", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/hint.txt"));
					col.add(_item);
				}
				
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("c", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/composebuttoncolor.txt"));
					col.add(_item);
				}
				
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("c", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/trackpadcolor.txt"));
					col.add(_item);
				}
				
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("c", FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/thumbcolor.txt"));
					col.add(_item);
				}
				
				break;
			}
		}
		((BaseAdapter)gridcol.getAdapter()).notifyDataSetChanged();
	}
	
	
	public void _sizeset(final TextView _btn) {
		_btn.getLayoutParams().width = (int) ((Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density * 1.27));
		_btn.getLayoutParams().height = (int) (Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) * getResources().getDisplayMetrics().density);
		_btn.setTextSize( Float.parseFloat(FileUtil.readFile("/storage/emulated/0/WeekBrowser/Sizes/button.txt")) / 2.5f);
		_btn.requestLayout();
	}
	
	
	public void _updind() {
		switch(((state == 2) ? (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradient.txt")) : (((state == 1) ? (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redgradient.txt")) : (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradient.txt")))))) {
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
		segmentsind.setText(((state == 2) ? (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bstripecount.txt")) : (((state == 1) ? (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rstripecount.txt")) : (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/stripecount.txt"))))));
		sharpnessind.setText(((state == 2) ? (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgtilemode.txt")) : (((state == 1) ? (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redtilemode.txt")) : (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/tilemode.txt"))))));
		radiusind.setText(((state == 2) ? (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradrad.txt")) : (((state == 1) ? (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradrad.txt")) : (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradrad.txt"))))));
		centerxind.setText(((state == 2) ? (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradX.txt")) : (((state == 1) ? (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradX.txt")) : (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradX.txt"))))));
		centeryind.setText(((state == 2) ? (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradY.txt")) : (((state == 1) ? (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradY.txt")) : (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradY.txt"))))));
		if (!(state == 2)) {
			bigroundind.setText(((state == 1) ? (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rroundness.txt")) : (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/roundness.txt"))));
			smallroundind.setText(((state == 1) ? (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rsroundness.txt")) : (FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/sroundness.txt"))));
		}
	}
	
	
	public void _setseekbars() {
		grad.setProgress((int)((state == 2) ? ((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradient.txt"))) : ((int)((state == 1) ? ((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redgradient.txt"))) : ((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradient.txt")))))));
		segm.setProgress((int)((state == 2) ? ((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bstripecount.txt"))) : ((int)((state == 1) ? ((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rstripecount.txt"))) : ((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/stripecount.txt")))))) - 2);
		switch((int)((state == 2) ? ((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgtilemode.txt"))) : ((int)((state == 1) ? ((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/redtilemode.txt"))) : ((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/tilemode.txt"))))))) {
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
		rad.setProgress((int)((state == 2) ? ((int)Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradrad.txt"))) : ((int)((state == 1) ? ((int)Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradrad.txt"))) : ((int)Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradrad.txt")))))));
		x.setProgress((int)((state == 2) ? ((int)Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradX.txt"))) : ((int)((state == 1) ? ((int)Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradX.txt"))) : ((int)Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradX.txt")))))));
		y.setProgress((int)((state == 2) ? ((int)Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/bgradY.txt"))) : ((int)((state == 1) ? ((int)Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rgradY.txt"))) : ((int)Double.parseDouble(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/gradY.txt")))))));
		if (!(state == 2)) {
			bb.setProgress((int)((state == 1) ? ((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rroundness.txt"))) : ((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/roundness.txt")))));
			sb.setProgress((int)((state == 1) ? ((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/rsroundness.txt"))) : ((int)Integer.parseInt(FileUtil.readFile("/storage/emulated/0/WeekBrowser/CustomTheme/sroundness.txt")))));
		}
		_updind();
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
							                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt", buffer);
							                        break;
							                    case 1:
							                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt", buffer);
							                        break;
							                    case 2:
							                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt", buffer);
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
							                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt", buffer);
							                        break;
							                    case 1:
							                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt", buffer);
							                        break;
							                    case 2:
							                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt", buffer);
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
							        color = (int)Long.parseLong(processColor(colorString, false, isAndroid12OrHigher),16);
							        
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
					switch((int)_position) {
						case ((int)0): {
							preview.setText(getString(R.string.textcol));
							String colorString = _data.get((int)_position).get("c").toString();
							int color;
							
							try {
								    // Перевірка на формат Monet або шістнадцятковий код
								    if (colorString.startsWith("m__")) {
									        color = (int)Long.parseLong(processColor(colorString, false, isAndroid12OrHigher),16);
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
									color = (int)Long.parseLong(processColor(colorString, false, isAndroid12OrHigher),16);
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
									color = (int)Long.parseLong(processColor(colorString, false, isAndroid12OrHigher),16);
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
									        color = (int)Long.parseLong(processColor(colorString, false, isAndroid12OrHigher),16);
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
									        color = (int)Long.parseLong(processColor(colorString, false, isAndroid12OrHigher),16);
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
									        color = (int)Long.parseLong(processColor(colorString, false, isAndroid12OrHigher),16);
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
									        color = (int)Long.parseLong(processColor(colorString, false, isAndroid12OrHigher),16);
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
								                FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt", buffer);
								                break;
								            case 1:
								                FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt", buffer);
								                break;
								            case 2:
								                FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt", buffer);
								                break;
								case 3:
								switch((int)_position) {
									case ((int)0): {
										FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/text.txt", col.get((int)0).get("c").toString());
										break;
									}
									case ((int)1): {
										FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/textfield.txt", col.get((int)1).get("c").toString());
										break;
									}
									case ((int)2): {
										FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/additional.txt", col.get((int)2).get("c").toString());
										break;
									}
									case ((int)3): {
										FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/hint.txt", col.get((int)3).get("c").toString());
										break;
									}
									case ((int)4): {
										FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/composebuttoncolor.txt", col.get((int)4).get("c").toString());
										break;
									}
									case ((int)5): {
										FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/trackpadcolor.txt", col.get((int)5).get("c").toString());
										break;
									}
									case ((int)6): {
										FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/thumbcolor.txt", col.get((int)6).get("c").toString());
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
								                FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt", buffer);
								                break;
								            case 1:
								                FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt", buffer);
								                break;
								            case 2:
								                FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt", buffer);
								                break;
								case 3:
								switch((int)_position) {
									case ((int)0): {
										FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/text.txt", col.get((int)0).get("c").toString());
										break;
									}
									case ((int)1): {
										FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/textfield.txt", col.get((int)1).get("c").toString());
										break;
									}
									case ((int)2): {
										FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/additional.txt", col.get((int)2).get("c").toString());
										break;
									}
									case ((int)3): {
										FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/hint.txt", col.get((int)3).get("c").toString());
										break;
									}
									case ((int)4): {
										FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/composebuttoncolor.txt", col.get((int)4).get("c").toString());
										break;
									}
									case ((int)5): {
										FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/trackpadcolor.txt", col.get((int)5).get("c").toString());
										break;
									}
									case ((int)6): {
										FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/thumbcolor.txt", col.get((int)6).get("c").toString());
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
							                    buffer = buffer.concat(col.get(i).get("c").toString());
							                }
						                switch ((int) state) {
							                    case 0:
							                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt", buffer);
							                        break;
							                    case 1:
							                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt", buffer);
							                        break;
							                    case 2:
							                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt", buffer);
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
							                    buffer = buffer.concat(col.get(i).get("c").toString());
							                }
						                switch ((int) state) {
							                    case 0:
							                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/buttonbg.txt", buffer);
							                        break;
							                    case 1:
							                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/redbuttonbg.txt", buffer);
							                        break;
							                    case 2:
							                        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/CustomTheme/bg.txt", buffer);
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