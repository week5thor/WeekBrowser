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
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class ExceptionsActivity extends Activity {
	
	private ArrayList<HashMap<String, Object>> except = new ArrayList<>();
	
	private LinearLayout bg;
	private ListView listview1;
	
	private AlertDialog.Builder del;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		ThemeManager.applyTheme(this);
		setContentView(R.layout.exceptions);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		bg = findViewById(R.id.bg);
		listview1 = findViewById(R.id.listview1);
		del = new AlertDialog.Builder(this);
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				del.setTitle("?!");
				del.setMessage(getString(R.string.wantdelfromexcept));
				del.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						except.remove((int)(_position));
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", JsonUtils.toJson(except));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
				});
				del.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = del.create();
				RenderUtils.setupDialogDim(ExceptionsActivity.this, dddddd);
				dddddd.show();
				
				return true;
			}
		});
	}
	
	private void initializeLogic() {
		bg = findViewById(R.id.bg);
		listview1 = findViewById(R.id.listview1);
		del = new AlertDialog.Builder(this);
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				del.setTitle("?!");
				del.setMessage(getString(R.string.wantdelfromexcept));
				del.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						except.remove((int)(_position));
						FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", JsonUtils.toJson(except));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
				});
				del.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				AlertDialog dddddd = del.create();
				RenderUtils.setupDialogDim(ExceptionsActivity.this, dddddd);
				dddddd.show();
				
				return true;
			}
		});
		
		try {
			except = JsonUtils.SO(FileUtil.readFile(getFilesDir().getPath()+"/sitepermis.json"));
			listview1.setAdapter(new Listview1Adapter(except));
		} catch(Exception e) {
			// Ігноруємо порожній або бітий файл
		}
		// Виправлено: Skin з великої літери
		Skin.getInstance().setBG(getWindow().getDecorView(), 2, true);
		
	}
	
	@Override
	public void onResume() {
		super.onResume();
		SafeMarginUtils.init(this, listview1);
		Skin.getInstance().setStaticBG(this, 2, false);
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
	
	{
	}
	
	
	public void _setCol(final TextView _blockad, final TextView _iframe, final TextView _js, final TextView _th, final TextView _sr, final double _position) {
		java.util.Map<String, Object> currentItem = except.get((int) _position);
		
		updateToggleState(_blockad, currentItem.get("ad"));
		updateToggleState(_iframe,  currentItem.get("if"));
		updateToggleState(_js,      currentItem.get("js"));
		updateToggleState(_th,      currentItem.get("th"));
		updateToggleState(_sr,      currentItem.get("sr"));
		
	}private void updateToggleState(View buttonView, Object valueObj) {
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		String state = (valueObj != null) ? valueObj.toString() : "2";
		
		if (buttonView instanceof SkinTextView) {
			SkinTextView tv = (SkinTextView) buttonView;
			
			try {
				switch (state) {
					case "1": { // Увімкнено (Звичайна кнопка)
						tv.setSkinKey("bbg", false);
						break;
					}
					case "0": { // Вимкнено (Червона кнопка)
						tv.setSkinKey("rbg", false);
						break;
					}
					case "2":
					default: { // Прозорий стан
						tv.setSkinKey("t", false);
						break;
					}
				}
			} catch (Exception e) {
				// Захист на випадок збою парсингу
				try {
					tv.setSkinKey("t", false);
				} catch (Exception ignored) {}
				tv.setBackground(null);
			}
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
				_view = _inflater.inflate(R.layout.except, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final com.a525team.weekbrowser.SkinTextView url = _view.findViewById(R.id.url);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final com.a525team.weekbrowser.SkinTextView js = _view.findViewById(R.id.js);
			final com.a525team.weekbrowser.SkinTextView blockad = _view.findViewById(R.id.blockad);
			final com.a525team.weekbrowser.SkinTextView sr = _view.findViewById(R.id.sr);
			final com.a525team.weekbrowser.SkinTextView th = _view.findViewById(R.id.th);
			final com.a525team.weekbrowser.SkinTextView iframe = _view.findViewById(R.id.iframe);
			
			Animator2.anim(getApplicationContext(), linear1, 0, 200);
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			
			if (except.get((int)_position).get("url") != null) {
				url.setText(except.get((int)_position).get("url").toString());
			}
			
			try {
				String textColor = dataHolder.getData("t");
				if (textColor != null) {
					url.setTextColor((int) Long.parseLong(textColor, 16));
				}
			} catch (Exception ignored) {}
			
			_setCol(blockad, iframe, js, th, sr, _position);
			
			js.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					try {
						if (except.get((int)_position).get("js").toString().equals("2")) {
							except.get((int)_position).put("js", "0");
						} else {
							if (except.get((int)_position).get("js").toString().equals("0")) {
								except.get((int)_position).put("js", "1");
							} else {
								except.get((int)_position).put("js", "2");
							}
						}
					} catch(Exception e) {
						except.get((int)_position).put("js", "0");
					}
					_setCol(blockad, iframe, js, th, sr, _position);
					FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", JsonUtils.toJson(except));
				}
			});
			
			blockad.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					try {
						if (except.get((int)_position).get("ad").toString().equals("2")) {
							except.get((int)_position).put("ad", "0");
						} else {
							if (except.get((int)_position).get("ad").toString().equals("0")) {
								except.get((int)_position).put("ad", "1");
							} else {
								except.get((int)_position).put("ad", "2");
							}
						}
					} catch(Exception e) {
						except.get((int)_position).put("ad", "0");
					}
					_setCol(blockad, iframe, js, th, sr, _position);
					FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", JsonUtils.toJson(except));
				}
			});
			
			iframe.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					try {
						if (except.get((int)_position).get("if").toString().equals("2")) {
							except.get((int)_position).put("if", "0");
						} else {
							if (except.get((int)_position).get("if").toString().equals("0")) {
								except.get((int)_position).put("if", "1");
							} else {
								except.get((int)_position).put("if", "2");
							}
						}
					} catch(Exception e) {
						except.get((int)_position).put("if", "0");
					}
					_setCol(blockad, iframe, js, th, sr, _position);
					FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", JsonUtils.toJson(except));
				}
			});
			
			th.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					try {
						if (except.get((int)_position).get("th").toString().equals("2")) {
							except.get((int)_position).put("th", "0");
						} else {
							if (except.get((int)_position).get("th").toString().equals("0")) {
								except.get((int)_position).put("th", "1");
							} else {
								except.get((int)_position).put("th", "2");
							}
						}
					} catch(Exception e) {
						except.get((int)_position).put("th", "0");
					}
					_setCol(blockad, iframe, js, th, sr, _position);
					FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", JsonUtils.toJson(except));
				}
			});
			
			sr.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					try {
						if (except.get((int)_position).get("sr").toString().equals("2")) {
							except.get((int)_position).put("sr", "0");
						} else {
							if (except.get((int)_position).get("sr").toString().equals("0")) {
								except.get((int)_position).put("sr", "1");
							} else {
								except.get((int)_position).put("sr", "2");
							}
						}
					} catch(Exception e) {
						except.get((int)_position).put("sr", "0");
					}
					_setCol(blockad, iframe, js, th, sr, _position);
					FileUtil.writeFile(getFilesDir().getPath()+"/sitepermis.json", JsonUtils.toJson(except));
				}
			});
			
			return _view;
		}
	}
}