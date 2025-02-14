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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ExtensioneditorActivity extends Activity {
	
	private HashMap<String, Object> ext = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> ir = new ArrayList<>();
	
	private TextView name;
	private LinearLayout linear2;
	private Button switchtab;
	private ScrollView js;
	private LinearLayout inter;
	private LinearLayout linear1;
	private TextView textview1;
	private EditText edittext1;
	private TextView textview2;
	private EditText edittext2;
	private TextView textview3;
	private Button button1;
	private ListView listview1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.extensioneditor);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		ThemeManager.applyTheme(this); // Встановлення теми
		    super.onCreate(_savedInstanceState);
		  setContentView(R.layout.extensioneditor);
		name = findViewById(R.id.name);
		linear2 = findViewById(R.id.linear2);
		switchtab = findViewById(R.id.switchtab);
		js = findViewById(R.id.js);
		inter = findViewById(R.id.inter);
		linear1 = findViewById(R.id.linear1);
		textview1 = findViewById(R.id.textview1);
		edittext1 = findViewById(R.id.edittext1);
		textview2 = findViewById(R.id.textview2);
		edittext2 = findViewById(R.id.edittext2);
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
					}
					else {
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
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		edittext2.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
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
		inter.setVisibility(View.GONE);
		SafeMarginUtils.init(this, findViewById(android.R.id.content));
		
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		
		// Ініціалізація Skin
		Skin skin = new Skin();
		
		skin.setBG(getWindow().getDecorView(), 2, false);
		
		name.setTextColor((int)Long.parseLong(dataHolder.getData("t"),16));
		edittext1.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		edittext2.setTextColor((int)Long.parseLong(dataHolder.getData("tf"),16));
		
		textview1.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview2.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		textview3.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
		
		button1.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		skin.setBG(button1, 0, false);
		
		switchtab.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
		skin.setBG(switchtab, 0, false);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
		name.setText(getIntent().getStringExtra("path"));
		ext = new Gson().fromJson(FileUtil.readFile(getIntent().getStringExtra("path")), new TypeToken<HashMap<String, Object>>(){}.getType());
		ir = new Gson().fromJson(ext.get("sir").toString().substring(4), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		edittext1.setText(ext.get("ps").toString());
		edittext2.setText(ext.get("pf").toString());
		listview1.setAdapter(new Listview1Adapter(ir));
	}
	
	
	@Override
	public void onBackPressed() {
		_save();
		finish();
	}
	public void _save() {
		ext.clear();
		ext.put("en", "on");
		ext.put("ps", edittext1.getText().toString());
		ext.put("pf", edittext2.getText().toString());
		ext.put("sir", "json".concat(new Gson().toJson(ir)));
		FileUtil.writeFile(getIntent().getStringExtra("path"), new Gson().toJson(ext));
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
			final TextView siu = _view.findViewById(R.id.siu);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final TextView rtt = _view.findViewById(R.id.rtt);
			final TextView rt = _view.findViewById(R.id.rt);
			final TextView siut = _view.findViewById(R.id.siut);
			final Button delete = _view.findViewById(R.id.delete);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView ect = _view.findViewById(R.id.ect);
			final TextView ec = _view.findViewById(R.id.ec);
			final TextView mtt = _view.findViewById(R.id.mtt);
			final TextView mt = _view.findViewById(R.id.mt);
			
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			
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
					        final EditText input = new EditText(ExtensioneditorActivity.this);
					input.setText(siu.getText().toString());
					        // Створимо діалог
					        new AlertDialog.Builder(ExtensioneditorActivity.this)
					            .setTitle("Введіть текст") // Назва діалогу
					            .setView(input) // Додаємо текстове поле до діалогу
					            .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
						                @Override
						                public void onClick(DialogInterface dialog, int which) {
							String userInput = input.getText().toString();
							                    
							ir.get((int)_position).put("siu", userInput);
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
							                }
						            })
					            .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
						                @Override
						                public void onClick(DialogInterface dialog, int which) {
							                    dialog.cancel(); // Закриваємо діалог при натисканні на "Скасувати"
							                }
						            })
					            .show();
				}
			});
			ec.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					        final EditText input = new EditText(ExtensioneditorActivity.this);
					input.setText(ec.getText().toString());
					        // Створимо діалог
					        new AlertDialog.Builder(ExtensioneditorActivity.this)
					            .setTitle("Введіть текст") // Назва діалогу
					            .setView(input) // Додаємо текстове поле до діалогу
					            .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
						                @Override
						                public void onClick(DialogInterface dialog, int which) {
							String userInput = input.getText().toString();
							                    
							ir.get((int)_position).put("ec", "e".concat(userInput));
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
							                }
						            })
					            .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
						                @Override
						                public void onClick(DialogInterface dialog, int which) {
							                    dialog.cancel(); // Закриваємо діалог при натисканні на "Скасувати"
							                }
						            })
					            .show();
				}
			});
			mt.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					        final EditText input = new EditText(ExtensioneditorActivity.this);
					input.setText(mt.getText().toString());
					        // Створимо діалог
					        new AlertDialog.Builder(ExtensioneditorActivity.this)
					            .setTitle("Введіть текст") // Назва діалогу
					            .setView(input) // Додаємо текстове поле до діалогу
					            .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
						                @Override
						                public void onClick(DialogInterface dialog, int which) {
							String userInput = input.getText().toString();
							                    
							ir.get((int)_position).put("mt", userInput);
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
							                }
						            })
					            .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
						                @Override
						                public void onClick(DialogInterface dialog, int which) {
							                    dialog.cancel(); // Закриваємо діалог при натисканні на "Скасувати"
							                }
						            })
					            .show();
				}
			});
			rt.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					        final EditText input = new EditText(ExtensioneditorActivity.this);
					input.setText(rt.getText().toString());
					        // Створимо діалог
					        new AlertDialog.Builder(ExtensioneditorActivity.this)
					            .setTitle("Введіть текст") // Назва діалогу
					            .setView(input) // Додаємо текстове поле до діалогу
					            .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
						                @Override
						                public void onClick(DialogInterface dialog, int which) {
							String userInput = input.getText().toString();
							                    
							ir.get((int)_position).put("rt", userInput);
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
							                }
						            })
					            .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
						                @Override
						                public void onClick(DialogInterface dialog, int which) {
							                    dialog.cancel(); // Закриваємо діалог при натисканні на "Скасувати"
							                }
						            })
					            .show();
				}
			});
			delete.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					ir.remove((int)(_position));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				}
			});
			
			return _view;
		}
	}
}