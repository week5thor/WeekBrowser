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
import android.widget.LinearLayout;
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

public class ExtensionsActivity extends Activity {
	
	private ArrayList<HashMap<String, Object>> Listofext = new ArrayList<>();
	private ArrayList<String> stdlist = new ArrayList<>();
	private ArrayList<String> list = new ArrayList<>();
	
	private LinearLayout bg;
	private Spinner spinner1;
	private ListView listview1;
	
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		ThemeManager.applyTheme(this);
		setContentView(R.layout.extensions);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		bg = findViewById(R.id.bg);
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
						extbuffer = "{\"pr\":\"javascript:(function() {\n    const categoriesToInclude = {\n        sponsor: true,\n\\/*Спонсорська реклама*\\/\n\n        selfpromo: true,\n\\/*Самореклама*\\/\n\n        interaction: true,\n\\/*Випрошування лайків і підписок*\\/\n\n        intro: false,\n\\/*Початкова заставка*\\/\n\n        outro: true,\n\\/*Кінцева заставка*\\/\n\n        preview: true,\n\\/*Переказ того, що було\\/буде у відео*\\/\n\n        music_offtopic: true,\n\\/*Зайве в музикальних кліпах*\\/\n\n        filler: false\n\\/*Не дуже важливі моменти (напр. кадри, вставлені заради жарту)*\\/\n    };\n\n    function getVideoId() {\n        var videoIdMatch = window.location.href.match(\\/v=([^&]+)\\/);\n        return videoIdMatch ? videoIdMatch[1] : null;\n    }\n\n    function buildApiUrl(videoId) {\n        var apiUrl = 'https:\\/\\/sponsor.ajay.app\\/api\\/skipSegments?videoID=' + videoId;\n        \n        var categories = Object.keys(categoriesToInclude).filter(cat => categoriesToInclude[cat]);\n        if (categories.length > 0) {\n            apiUrl += '&categories=[\\\\\\\"' + categories.join('\\\\\\\",\\\\\\\"');\napiUrl+=\\\"\\\\\\\"]\\\";\n        }\n\n        return apiUrl;\n    }\n\n    function fetchSegments(videoId) {\n        var apiUrl = buildApiUrl(videoId);\n\n        fetch(apiUrl)\n            .then(response => {\n                if (!response.ok) {\n                    throw new Error('API request failed: ' + response.status + ' ' + response.statusText);\n                }\n                return response.json();\n            })\n            .then(data => {\n                if (Array.isArray(data) && data.length > 0) {\n                    handleSegments(data);\n                } else {\n                    console.log('Немає сегментів для пропуску.');\n                }\n            })\n            .catch(error => {\n                console.error('Error fetching segments:', error);\n            });\n    }\n\n    function handleSegments(segments) {\n        var videoPlayer = document.querySelector('video');\n        if (!videoPlayer) return;\n\n        segments.forEach(segmentData => {\n            if (segmentData.segment && segmentData.segment.length === 2) {\n                var start = segmentData.segment[0];\n                var end = segmentData.segment[1];\n\n                videoPlayer.addEventListener('timeupdate', function() {\n                    if (videoPlayer.currentTime >= start && videoPlayer.currentTime < end) {\n                        videoPlayer.currentTime = end;\n                    }\n                });\n\n                highlightSegment(start, end, videoPlayer.duration);\n            }\n        });\n    }\n\n    function highlightSegment(start, end, duration) {\n    \n}\n\n    if (window.location.hostname.includes('youtube.com')) {\n        var videoId = getVideoId();\n        if (videoId) {\n            fetchSegments(videoId);\n        }\n    } else {\n    }\n})();\",\"ps\":\"\",\"pf\":\"\",\"en\":\"on\",\"sir\":\"json[]\"}";
						FileUtil.writeFile(getFilesDir().getPath() + "/extensions/" + "YouTube SponsorBlock 1.01", 
						extbuffer);
						break;
					}
					case ((int)3): {
						extbuffer = "{\"ps\":\"\",\"pf\":\"javascript:(function() {\n    var inputs \\u003d document.getElementsByTagName(\\u0027input\\u0027);\n    for (var i \\u003d 0; i \\u003c inputs.length; i++) {\n        if (inputs[i].type.toLowerCase() \\u003d\\u003d\\u003d \\u0027password\\u0027) {\n            inputs[i].type \\u003d \\u0027text\\u0027;\n        }\n    }\n})();\",\"en\":\"on\",\"sir\":\"json[]\"}";
						FileUtil.writeFile(getFilesDir().getPath() + "/extensions/" + "Show Hidden Passwords", 
						extbuffer);
						break;
					}
					case ((int)4): {
						extbuffer = "{\"ps\":\"javascript:(function() {\n    function processCssRules(sheet) {\n        try {\n            let rules \\u003d sheet.cssRules;\n            for (let i \\u003d 0; i \\u003c rules.length; i++) {\n                let rule \\u003d rules[i];\n                if (rule.style) {\n                    if (rule.style.mixBlendMode) rule.style.mixBlendMode \\u003d \\\"normal\\\";\n                    if (rule.style.backgroundBlendMode) rule.style.backgroundBlendMode \\u003d \\\"normal\\\";\n                    if (rule.style.filter) rule.style.filter \\u003d \\\"none\\\";\n                    if (rule.style.backdropFilter) rule.style.backdropFilter \\u003d \\\"none\\\";\n                    if (rule.style.webkitFilter) rule.style.webkitFilter \\u003d \\\"none\\\";\n                    if (rule.style.webkitBackdropFilter) rule.style.webkitBackdropFilter \\u003d \\\"none\\\";\n                    if (rule.style.boxShadow) rule.style.boxShadow \\u003d \\\"none\\\";\n                    if (rule.style.textShadow) rule.style.textShadow \\u003d \\\"none\\\";\n                    if (rule.style.border) rule.style.border \\u003d \\\"none\\\";\n                    if (rule.style.webkitTextStroke) rule.style.webkitTextStroke \\u003d \\\"0\\\";\n                }\n            }\n        } catch (e) {\n            console.warn(\\\"Error processing CSS rules:\\\", e);\n        }\n    }\n    document.querySelectorAll(\\u0027style, link[rel\\u003d\\\"stylesheet\\\"]\\u0027).forEach(style \\u003d\\u003e {\n        if (style.sheet) {\n            processCssRules(style.sheet);\n        }\n    });\n    document.querySelectorAll(\\u0027*\\u0027).forEach(el \\u003d\\u003e {\n        el.style.mixBlendMode \\u003d \\\"normal\\\";\n        el.style.backgroundBlendMode \\u003d \\\"normal\\\";\n        el.style.filter \\u003d \\\"none\\\";\n        el.style.backdropFilter \\u003d \\\"none\\\";\n        el.style.webkitFilter \\u003d \\\"none\\\";\n        el.style.webkitBackdropFilter \\u003d \\\"none\\\";\n        el.style.boxShadow \\u003d \\\"none\\\";\n        el.style.textShadow \\u003d \\\"none\\\";\n        el.style.border \\u003d \\\"none\\\";\n        el.style.webkitTextStroke \\u003d \\\"0\\\";\n    });\n    const observer \\u003d new MutationObserver(() \\u003d\\u003e {\n        document.querySelectorAll(\\u0027*\\u0027).forEach(el \\u003d\\u003e {\n            el.style.mixBlendMode \\u003d \\\"normal\\\";\n            el.style.backgroundBlendMode \\u003d \\\"normal\\\";\n            el.style.filter \\u003d \\\"none\\\";\n            el.style.backdropFilter \\u003d \\\"none\\\";\n            el.style.webkitFilter \\u003d \\\"none\\\";\n            el.style.webkitBackdropFilter \\u003d \\\"none\\\";\n            el.style.boxShadow \\u003d \\\"none\\\";\n            el.style.textShadow \\u003d \\\"none\\\";\n            el.style.border \\u003d \\\"none\\\";\n            el.style.webkitTextStroke \\u003d \\\"0\\\";\n        });\n    });\n    observer.observe(document.body, { childList: true, subtree: true });\n})();\n\",\"pf\":\"\",\"en\":\"off\",\"sir\":\"json[{\\\"rt\\\":\\\"\\\\u003ch4\\\\u003eBlocked\\\\u003c/h4\\\\u003e\\\",\\\"mt\\\":\\\"text/html\\\",\\\"siu\\\":\\\".*\\\\\\\\.gif.*\\\",\\\"ec\\\":\\\"200\\\"}]\"}";
						FileUtil.writeFile(getFilesDir().getPath() + "/extensions/" + "Optimizer for low-end device", 
						extbuffer);
						break;
					}
					case ((int)5): {
						extbuffer = "{\"ps\":\"\",\"pf\":\"javascript:(function() {\n  if (document.getElementById(\\u0027google_translate_element\\u0027) \\u003d\\u003d\\u003d null) {\n    var bodies \\u003d document.getElementsByTagName(\\\"body\\\"); \n    if(bodies.length \\u003e 0)\n      bodies[0].insertAdjacentHTML(\\u0027afterbegin\\u0027, \\u0027\\u003cdiv id\\u003d\\\"google_translate_element\\\" align\\u003d\\\"right\\\" style\\u003d\\\"z-index:9999999; position:relative; margin-top: 50px; margin-right: 0px; margin-bottom: 50px;\\\"\\u003e\\u003c/div\\u003e\\u0027);\n    var heads \\u003d document.getElementsByTagName(\\\"head\\\"); \n    if(heads.length \\u003e 0){\n      var s \\u003d document.createElement(\\u0027script\\u0027);\n      s.type \\u003d \\u0027text/javascript\\u0027;\n      s.appendChild(document.createTextNode(\\u0027function googleTranslateElementInit() {new google.translate.TranslateElement({Language: \\\"uk\\\", layout: google.translate.TranslateElement.InlineLayout.VERTICAL}, \\\"google_translate_element\\\");}\\u0027));        \n      heads[0].appendChild(s);\n    }\n    if(bodies.length \\u003e 0) {\n      var s1 \\u003d document.createElement(\\u0027script\\u0027);\n      s1.type \\u003d \\u0027text/javascript\\u0027;\n      s1.src \\u003d \\u0027https://translate.google.com/translate_a/element.js?cb\\u003dgoogleTranslateElementInit\\u0027;\n      bodies[0].appendChild(s1);\n      document.body.scrollTop \\u003d 0;\n      document.documentElement.scrollTop \\u003d 0;\n    }\n  } else {\n    document.body.scrollTop \\u003d 0;\n    document.documentElement.scrollTop \\u003d 0;\n  }\n})();\",\"en\":\"off\",\"sir\":\"json[]\"}";
						FileUtil.writeFile(getFilesDir().getPath() + "/extensions/" + "Google Translate Webpages", 
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
		/*

ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();

// Ініціалізація Skin
Skin skin = new Skin();

skin.setBG(getWindow().getDecorView(), 2, false);

//skin.setBG(spinner1, 0, false);
*/
		stdlist.add("--- Choose new extension ---");
		stdlist.add("Empty");
		stdlist.add("YouTube SponsorBlock 1.01");
		stdlist.add("Show Hidden Passwords");
		stdlist.add("Optimizer for low-end device");
		stdlist.add("Google Translate Webpages");
		ThemeManager.setSpinner(ExtensionsActivity.this, stdlist, spinner1);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		SafeMarginUtils.init(this, bg);
		
		Skin.getInstance().setStaticBG(this, 2, false);
		_update();
	}
	
	
	@Override
	public void onPause() {
		super.onPause();
		SafeMarginUtils.cleanup();
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
			final com.a525team.weekbrowser.SkinTextView name = _view.findViewById(R.id.name);
			final com.a525team.weekbrowser.SkinCheckBox enable = _view.findViewById(R.id.enable);
			final com.a525team.weekbrowser.SkinButton share = _view.findViewById(R.id.share);
			final com.a525team.weekbrowser.SkinButton editname = _view.findViewById(R.id.editname);
			final com.a525team.weekbrowser.SkinButton delete = _view.findViewById(R.id.delete);
			
			Animator2.anim(getApplicationContext(), linear1, 0, 200);
			
			// Ініціалізація Skin та DataHolder
			Skin skin = Skin.getInstance();
			ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
			
			// 1. Для CheckBox (виправлено: замінено colorify на enable)
			if (enable instanceof android.widget.CompoundButton && WTF.SDK_INT() >= 21) {
				String cbHex = dataHolder.getData("cb");
				if (cbHex != null) {
					if (!cbHex.startsWith("#")) cbHex = "#" + cbHex;
					((android.widget.CompoundButton) enable).setButtonTintList(
					android.content.res.ColorStateList.valueOf(android.graphics.Color.parseColor(cbHex))
					);
				}
			}
			
			// 2. Налаштування додаткового тексту (з примусовим приведенням типу для безпеки)
			// Налаштування додаткового тексту (передаємо false як другий аргумент, щоб обійти баг Sketchware)
			if (name instanceof com.a525team.weekbrowser.SkinTextView) {
				((com.a525team.weekbrowser.SkinTextView) name).setSkinKey("add", false);
			}
			
			// 3. Налаштування кнопок з урахуванням того, що вони маленькі (isSmall = true)
			if (share instanceof com.a525team.weekbrowser.SkinButton) {
				((com.a525team.weekbrowser.SkinButton) share).setSkinKey("bbg", true);
			}
			if (editname instanceof com.a525team.weekbrowser.SkinButton) {
				((com.a525team.weekbrowser.SkinButton) editname).setSkinKey("bbg", true);
			}
			if (delete instanceof com.a525team.weekbrowser.SkinButton) {
				((com.a525team.weekbrowser.SkinButton) delete).setSkinKey("rbg", true);
			}
			
			try {
				delete.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
				delete.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						FileUtil.deleteFile(Listofext.get((int)_position).get("name").toString());
						_update();
					}
				});
				
				HashMap<String, Object> content = JsonUtils.M(FileUtil.readFile(Listofext.get((int)_position).get("name").toString()));
				share.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
				editname.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/icons.ttf"), 0);
				
				enable.setChecked(content.get("en").toString().equals("on"));
				name.setText(Listofext.get((int)_position).get("name").toString().replace(getFilesDir().getPath()+"/extensions/", ""));
				
				enable.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						content.put("en", ((content.get("en").toString().equals("on")) ? ("off") : ("on")));
						enable.setChecked(content.get("en").toString().equals("on"));
						FileUtil.writeFile(Listofext.get((int)_position).get("name").toString(), JsonUtils.toJson(content));
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
						BasedDialog.showInput(
						ExtensionsActivity.this, 
						"Rename",                   
						"",                       
						false,                    
						name.getText().toString(),
						userInput -> {            
							File oldFile = new File(Listofext.get((int)_position).get("name").toString());
							File newFile = new File(getFilesDir().getPath() + "/extensions/" + userInput);
							boolean success = oldFile.renameTo(newFile);
							_update();
						}
						);
					}
				});
				
				share.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "https://extensions.weekbrowser.com/"+name.getText().toString()+"/".concat(FileUtil.readFile(Listofext.get((int)_position).get("name").toString()))));
						SketchwareUtil.showMessage(getApplicationContext(), getString(R.string.copied));
					}
				});
				
			} catch(Exception e) {
				name.setText("[ERROR]");
			}
			
			
			
			return _view;
		}
	}
}