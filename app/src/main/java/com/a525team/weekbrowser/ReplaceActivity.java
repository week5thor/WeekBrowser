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
import android.widget.Button;
import android.widget.ListView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class ReplaceActivity extends Activity {
	
	RenderUtils ru;
	
	private ArrayList<String> languag = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> rpl = new ArrayList<>();
	
	private Button add;
	private ListView listview1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		ThemeManager.applyTheme(this);
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.replace);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		ru = new RenderUtils(ReplaceActivity.this);
		
		add = findViewById(R.id.add);
		listview1 = findViewById(R.id.listview1);
		
		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				{HashMap<String, Object> _item = new HashMap<>();
					
					_item.put("e", 
					"1"
					
					);_item.put("f", 
					
					""
					
					);_item.put("t", 
					
					""
					
					);_item.put("r", 
					
					"0"
					
					);rpl.add(_item);}
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				_save();
			}
		});
	}
	
	private void initializeLogic() {
		
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		
		// Ініціалізація Skin
		Skin skin = new Skin();
		
		skin.setBG(getWindow().getDecorView(), 2, false);
		
		skin.setBG(add, 0, false);
		
		add.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		try{
			rpl = JsonUtils.SO(FileUtil.readFile(getFilesDir().getPath()+"/replace.json"));
			listview1.setAdapter(new Listview1Adapter(rpl));
		}catch(Exception e){
			 
		}
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
	public void _language() {
		
	}
	
	
	public String _ar(final boolean _a, final boolean _r) {
		return (String.valueOf((long)(((_r) ? ((int)2) : ((int)0)) + ((_a) ? ((int)1) : ((int)0)))));
	}
	
	
	public void _save() {
		FileUtil.writeFile(getFilesDir().getPath()+"/replace.json", JsonUtils.toJson(rpl));
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
				_view = _inflater.inflate(R.layout.replaceitem, null);
			}
			
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final TextView f = _view.findViewById(R.id.f);
			final TextView t1 = _view.findViewById(R.id.t1);
			final TextView t = _view.findViewById(R.id.t);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final CheckBox en = _view.findViewById(R.id.en);
			final Button delete = _view.findViewById(R.id.delete);
			final CheckBox a = _view.findViewById(R.id.a);
			final CheckBox r = _view.findViewById(R.id.r);
			
			Animator2.anim(getApplicationContext(), linear3, 0, 200);
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			
			// Ініціалізація Skin
			Skin skin = new Skin();
			
			colorify.setButtonColor(en, Color.parseColor("#" + dataHolder.getData("cb")));
			colorify.setButtonColor(a, Color.parseColor("#" + dataHolder.getData("cb")));
			colorify.setButtonColor(r, Color.parseColor("#" + dataHolder.getData("cb")));
			
			t1.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			a.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			r.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
			
			f.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			t.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			delete.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			
			skin.setBG(f, 0, true);
			skin.setBG(t, 0, true);
			skin.setBG(delete, 1, true);
			f.setText(_data.get((int)_position).get("f").toString());
			t.setText(_data.get((int)_position).get("t").toString());
			a.setChecked(_data.get((int)_position).get("r").toString().equals("1") || _data.get((int)_position).get("r").toString().equals("3"));
			r.setChecked(_data.get((int)_position).get("r").toString().equals("2") || _data.get((int)_position).get("r").toString().equals("3"));
			en.setChecked(_data.get((int)_position).get("e").toString().equals("1"));
			delete.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
			try{
				f.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						        final EditText input = new EditText(ReplaceActivity.this);
						input.setText(f.getText().toString());
						SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
						if (sf.getString("monoforta", "").equals("1")) {
								input.setTypeface(Typeface.MONOSPACE);
						}
						else {
								input.setTypeface(Typeface.DEFAULT);
						}
						
						        // Створимо діалог
						        AlertDialog.Builder hh = new AlertDialog.Builder(ReplaceActivity.this)
						            .setTitle("From") // Назва діалогу
						            .setView(input) // Додаємо текстове поле до діалогу
						            .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
							                @Override
							                public void onClick(DialogInterface dialog, int which) {
								String userInput = input.getText().toString();
								                    
								_data.get((int)_position).put("f", userInput);
								((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();_save();
								                }
							            })
						            .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
							                @Override
							                public void onClick(DialogInterface dialog, int which) {
								                    dialog.cancel(); // Закриваємо діалог при натисканні на "Скасувати"
								                }
							            });
						
						AlertDialog dddddd = hh.create();
						dddddd.setOnShowListener(d -> {
								if(android.os.Build.VERSION.SDK_INT > 31 && ru.isOn()){
										Window window = dddddd.getWindow();
										if (window != null) {
												window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
												window.setDimAmount(0f);
										}
								}
						});
						dddddd.setOnDismissListener(d -> {
								ru.off();
						});
						ru.on();
						dddddd.show();
						
					}
				});
				t.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						        final EditText input = new EditText(ReplaceActivity.this);
						input.setText(t.getText().toString());
						SharedPreferences sf = getSharedPreferences("sf", Context.MODE_PRIVATE);
						if (sf.getString("monoforta", "").equals("1")) {
								input.setTypeface(Typeface.MONOSPACE);
						}
						else {
								input.setTypeface(Typeface.DEFAULT);
						}
						
						        // Створимо діалог
						        AlertDialog.Builder hh = new AlertDialog.Builder(ReplaceActivity.this)
						            .setTitle("To") // Назва діалогу
						            .setView(input) // Додаємо текстове поле до діалогу
						            .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
							                @Override
							                public void onClick(DialogInterface dialog, int which) {
								String userInput = input.getText().toString();
								                    
								_data.get((int)_position).put("t", userInput);
								((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();_save();
								                }
							            })
						            .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
							                @Override
							                public void onClick(DialogInterface dialog, int which) {
								                    dialog.cancel(); // Закриваємо діалог при натисканні на "Скасувати"
								                }
							            });
						AlertDialog dddddd = hh.create();
						dddddd.setOnShowListener(d -> {
								if(android.os.Build.VERSION.SDK_INT > 31 && ru.isOn()){
										Window window = dddddd.getWindow();
										if (window != null) {
												window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
												window.setDimAmount(0f);
										}
								}
						});
						dddddd.setOnDismissListener(d -> {
								ru.off();
						});
						ru.on();
						dddddd.show();
						
					}
				});
				delete.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_data.remove((int)(_position));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						_save();
					}
				});
				a.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_data.get((int)_position).put("r", _ar(a.isChecked(), r.isChecked()));
						_save();
					}
				});
				r.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_data.get((int)_position).put("r", _ar(a.isChecked(), r.isChecked()));
						_save();
					}
				});
				en.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_data.get((int)_position).put("e", ((en.isChecked()) ? ("1") : ("0")));
						_save();
					}
				});
			}catch(Exception e){
				en.setText("[ERROR]");
			}
			en.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.enable));
					return true;
				}
			});
			a.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.ignorecase));
					return true;
				}
			});
			r.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.regex));
					return true;
				}
			});
			
			return _view;
		}
	}
}