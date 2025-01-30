package com.a525team.weekbrowser;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
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
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import android.content.ClipboardManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ExtensionsActivity extends Activity {
	
	private ArrayList<HashMap<String, Object>> Listofext = new ArrayList<>();
	private ArrayList<String> stdlist = new ArrayList<>();
	private ArrayList<String> list = new ArrayList<>();
	
	private Spinner spinner1;
	private ListView listview1;
	
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.extensions);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		ThemeManager.applyTheme(this); // Встановлення теми
		    super.onCreate(_savedInstanceState);
		 
		        setContentView(R.layout.extensions);
		spinner1 = findViewById(R.id.spinner1);
		listview1 = findViewById(R.id.listview1);
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				String extbuffer;
				switch((int)_position) {
					case ((int)0): {
						 
						break;
					}
					case ((int)1): {
						extbuffer = "{\"ps\":\"\",\"pf\":\"\",\"en\":\"on\",\"sir\":\"json[]\"}";
						FileUtil.writeFile(getFilesDir().getPath() + "/extensions/" + Listofext.size(), 
						extbuffer);
						break;
					}
					case ((int)2): {
						extbuffer = "{\"ps\":\"\",\"pf\":\"javascript:(function() {\n    const categoriesToInclude \\u003d {\n        sponsor: true,\n/*Спонсорська реклама*/\n\n        selfpromo: true,\n/*Самореклама*/\n\n        interaction: true,\n/*Випрошування лайків і підписок*/\n\n        intro: false,\n/*Початкова заставка*/\n\n        outro: true,\n/*Кінцева заставка*/\n\n        preview: true,\n/*Переказ того, що було/буде у відео*/\n\n        music_offtopic: true,\n/*Зайве в музикальних кліпах*/\n\n        filler: false\n/*Не дуже важливі моменти (напр. кадри, вставлені заради жарту)*/\n    };\n\n    function getVideoId() {\n        var videoIdMatch \\u003d window.location.href.match(/v\\u003d([^\\u0026]+)/);\n        return videoIdMatch ? videoIdMatch[1] : null;\n    }\n\n    function buildApiUrl(videoId) {\n        var apiUrl \\u003d \\u0027https://sponsor.ajay.app/api/skipSegments?videoID\\u003d\\u0027 + videoId;\n        \n        var categories \\u003d Object.keys(categoriesToInclude).filter(cat \\u003d\\u003e categoriesToInclude[cat]);\n        if (categories.length \\u003e 0) {\n            apiUrl +\\u003d \\u0027\\u0026categories\\u003d[\\\\\\\"\\u0027 + categories.join(\\u0027\\\\\\\",\\\\\\\"\\u0027);\napiUrl+\\u003d\\\"\\\\\\\"]\\\";\n        }\n\n        return apiUrl;\n    }\n\n    function fetchSegments(videoId) {\n        var apiUrl \\u003d buildApiUrl(videoId);\n\n        fetch(apiUrl)\n            .then(response \\u003d\\u003e {\n                if (!response.ok) {\n                    throw new Error(\\u0027API request failed: \\u0027 + response.status + \\u0027 \\u0027 + response.statusText);\n                }\n                return response.json();\n            })\n            .then(data \\u003d\\u003e {\n                if (Array.isArray(data) \\u0026\\u0026 data.length \\u003e 0) {\n                    handleSegments(data);\n                } else {\n                    console.log(\\u0027Немає сегментів для пропуску.\\u0027);\n                }\n            })\n            .catch(error \\u003d\\u003e {\n                console.error(\\u0027Error fetching segments:\\u0027, error);\n            });\n    }\n\n    function handleSegments(segments) {\n        var videoPlayer \\u003d document.querySelector(\\u0027video\\u0027);\n        if (!videoPlayer) return;\n\n        segments.forEach(segmentData \\u003d\\u003e {\n            if (segmentData.segment \\u0026\\u0026 segmentData.segment.length \\u003d\\u003d\\u003d 2) {\n                var start \\u003d segmentData.segment[0];\n                var end \\u003d segmentData.segment[1];\n\n                videoPlayer.addEventListener(\\u0027timeupdate\\u0027, function() {\n                    if (videoPlayer.currentTime \\u003e\\u003d start \\u0026\\u0026 videoPlayer.currentTime \\u003c end) {\n                        videoPlayer.currentTime \\u003d end;\n                    }\n                });\n\n                highlightSegment(start, end, videoPlayer.duration);\n            }\n        });\n    }\n\n    function highlightSegment(start, end, duration) {\n    \n}\n\n    if (window.location.hostname.includes(\\u0027youtube.com\\u0027)) {\n        var videoId \\u003d getVideoId();\n        if (videoId) {\n            fetchSegments(videoId);\n        }\n    } else {\n    }\n})();\",\"en\":\"on\",\"sir\":\"json[]\"}";
						FileUtil.writeFile(getFilesDir().getPath() + "/extensions/" + "YouTube SponsorBlock", 
						extbuffer);
						break;
					}
				}
				_update();
				spinner1.setSelection((int)(0));
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
	}
	
	private void initializeLogic() {
		SafeMarginUtils.init(this, findViewById(android.R.id.content));
		
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		
		// Ініціалізація Skin
		Skin skin = new Skin();
		
		skin.setBG(getWindow().getDecorView(), 2, false);
		
		//skin.setBG(spinner1, 0, false);
		stdlist.add("--- Choose new extension ---");
		stdlist.add("Empty");
		stdlist.add("YouTube SponsorBlock");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, stdlist));
	}
	
	@Override
	public void onResume() {
		super.onResume();
		_update();
	}
	
	public void _update() {
		Listofext.clear();
		// Отримуємо список файлів у папці "extensions"
		FileUtil.listDir(getFilesDir().getPath() + "/extensions", list);
		
		// Переносимо назви файлів у Listofext
		for (int i = 0; i < list.size(); i++) {
			    String fileName = list.get(i);
			
			    // Створюємо HashMap для кожного файлу
			    HashMap<String, Object> _item = new HashMap<>();
			    _item.put("name", fileName);
			    
			    // Додаємо в список
			    Listofext.add(_item);
		}
		
		listview1.setAdapter(new Listview1Adapter(Listofext));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
	}
	
	
	public void _extra() {
	}
	public static String decodeUrl(String url) {
		        try {
			            return URLDecoder.decode(url, "UTF-8");
			        } catch (UnsupportedEncodingException e) {
			            e.printStackTrace();
			            return url; // Повертаємо оригінальний URL у випадку помилки
			        }
		    }
	    public static String encodeUrl(String url) {
		        try {
			            return URLEncoder.encode(url, "UTF-8");
			        } catch (UnsupportedEncodingException e) {
			            e.printStackTrace();
			            return url; // Повертаємо оригінальний URL у випадку помилки
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
				_view = _inflater.inflate(R.layout.extension, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final TextView name = _view.findViewById(R.id.name);
			final CheckBox enable = _view.findViewById(R.id.enable);
			final Button share = _view.findViewById(R.id.share);
			final Button editname = _view.findViewById(R.id.editname);
			final Button delete = _view.findViewById(R.id.delete);
			
			Animator2.anim(getApplicationContext(), linear1, 0, 200);
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			
			// Ініціалізація Skin
			Skin skin = new Skin();
			
			Colorify Colorify = new Colorify();
			
			Colorify.setButtonColor(enable, Color.parseColor("#" + dataHolder.getData("cb")));
			
			name.setTextColor((int)Long.parseLong(dataHolder.getData("add"),16));
			
			share.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			editname.setTextColor((int)Long.parseLong(dataHolder.getData("bt"),16));
			delete.setTextColor((int)Long.parseLong(dataHolder.getData("rbt"),16));
			
			skin.setBG(share, 0, true);
			skin.setBG(editname, 0, true);
			skin.setBG(delete, 1, true);
			
			HashMap<String, Object> content = new Gson().fromJson(FileUtil.readFile(Listofext.get((int)_position).get("name").toString()), new TypeToken<HashMap<String, Object>>(){}.getType());
			try{
				share.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
				editname.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
				delete.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
				enable.setChecked(content.get("en").toString().equals("on"));
				name.setText(Listofext.get((int)_position).get("name").toString().replace(getFilesDir().getPath()+"/extensions/", ""));
			}catch(Exception e){
				name.setText("[ERROR]");
			}
			enable.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					try{
						content.put("en", ((content.get("en").toString().equals("on")) ? ("off") : ("on")));
						enable.setChecked(content.get("en").toString().equals("on"));
						FileUtil.writeFile(Listofext.get((int)_position).get("name").toString(), new Gson().toJson(content));
					}catch(Exception e){
						SketchwareUtil.showMessage(getApplicationContext(), "Error");
					}
				}
			});
			delete.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					FileUtil.deleteFile(Listofext.get((int)_position).get("name").toString());
					_update();
				}
			});
			name.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), ExtensioneditorActivity.class);
					intent.putExtra("path", Listofext.get((int)_position).get("name").toString());
					startActivity(intent);
				}
			});
			editname.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					        final EditText input = new EditText(ExtensionsActivity.this);
					input.setText(name.getText().toString());
					        // Створимо діалог
					        new AlertDialog.Builder(ExtensionsActivity.this)
					            .setTitle("Введіть текст") // Назва діалогу
					            .setView(input) // Додаємо текстове поле до діалогу
					            .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
						                @Override
						                public void onClick(DialogInterface dialog, int which) {
							String userInput = input.getText().toString();
							
							
							// Отримуємо початковий файл
							File oldFile = new File(Listofext.get((int)_position).get("name").toString());
							
							// Формуємо новий файл з використанням шляху до каталогу додатка і користувацького імені
							File newFile = new File(getFilesDir().getPath() + "/extensions/" + userInput);
							
							// Перейменовуємо файл
							boolean success = oldFile.renameTo(newFile);
							
							_update();
							
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
			share.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "https://extensions.weekbrowser.com/"+name.getText().toString()+"/".concat(FileUtil.readFile(Listofext.get((int)_position).get("name").toString()))));
					SketchwareUtil.showMessage(getApplicationContext(), "Скопійовано!");
				}
			});
			
			return _view;
		}
	}
}