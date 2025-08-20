package com.a525team.weekbrowser;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.os.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

import android.webkit.WebView;
import android.webkit.JavascriptInterface;

import java.net.URLEncoder;

import java.nio.charset.StandardCharsets;

import android.widget.Toast;

public class HomePageGen {
	private static final String TAG = "HomePageGen";
	
	public static String generateHtml(Context context/*, String content*/) {
		ExtendedDataHolder dh = ExtendedDataHolder.getInstance();
		if(!dh.containsKey("chtm")||dh.getData("chtm").length()<2){
			if(!FileUtil.isExistFile(context.getCacheDir().getPath().concat("/bm.html")) || FileUtil.readFile(context.getCacheDir().getPath()+"/bm.html").length()<2){
				SharedPreferences sf = context.getSharedPreferences("sf", Context.MODE_PRIVATE);
				String content = FileUtil.readFile(context.getFilesDir().getPath()+"/bookmark.json");
				StringBuilder bodyContent = new StringBuilder();
				try {
					JSONArray items = new JSONArray(content);
					processItems(items, bodyContent, "", sf, 0);
				} catch (JSONException e) {
					Log.e(TAG, "Error parsing JSON", e);
				}
				String htm = buildFullHtml(sf, bodyContent.toString()); 
				//			new Thread(new Runnable() {
				//				@Override
				//				public void run() {
				// Виконання фонової роботи
				FileUtil.writeFile(context.getCacheDir().getPath()+"/bm.html", htm);
				//				}
				//			}).start();
				dh.setData("chtm", htm);
				return htm;
			}else{
				dh.setData("chtm", FileUtil.readFile(context.getCacheDir().getPath()+"/bm.html"));
				return dh.getData("chtm");
			}
		}else return dh.getData("chtm");
	}
	
	private static void processItems(JSONArray items, StringBuilder sb, 
	String parentPath, 
	SharedPreferences sf, int depth) throws JSONException {
		String divider = sf.getString("cssdiv", " ❖ ");
		String divColor = sf.getString("cssdivcolor", "ff0000");
		
		for (int i = 0; i < items.length(); i++) {
			JSONObject item = items.getJSONObject(i);
			String type = item.optString("type", "link");
			
			if ("link".equals(type)) {
				appendLink(item, sb, parentPath, i, sf);
				if(i<items.length()-1)sb.append(String.format("<font color=\"#%s\">%s</font>", divColor, divider));
			} else if ("folder".equals(type)) {
				appendFolder(item, sb, parentPath, i, sf, depth + 1);
			}
			else if("search".equals(type)){
				appendSearch(item, sb, parentPath, i, sf);
			}else if("html".equals(type)){
				appendHtml(item, sb, parentPath, i, sf);
			}
		}
	}
	
	private static void appendLink(JSONObject item, StringBuilder sb, 
	String parentPath, int index, 
	SharedPreferences sf) throws JSONException {
		String name = escapeHtml(item.getString("name"));
		String url = escapeHtml(item.optString("url", "#"));
		String color = item.optString("color", "#000000");
		
		String fullId = parentPath.isEmpty() ? String.valueOf(index) : parentPath + "-" + index;
		
		sb.append("<a href=\"" + url + "\" data-id=\"" + fullId + "\" onclick=\"Android.onClick('" + fullId + "');event.stopPropagation()\">" +
		"<font color=\"" + color + "\">" + name + "</font></a>");
		
	}
	
/*	private static void appendHtml(JSONObject item, StringBuilder sb,
	String parentPath, int index,
	SharedPreferences sf) throws JSONException {
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		
		// Отримання HTML-коду
		String rawHtml = item.optString("code", "").trim();
		String color = item.optString("bbg", "000000");
		try{
			color = item.optString("bbg", dataHolder.getData("bbg").substring(2,8) + dataHolder.getData("bbg").substring(0,2));
		}catch(Exception e){}
		if (rawHtml.isEmpty()) rawHtml = "<h1>Empty</h1>";
		
		// Унікальний ID
		String fullId = parentPath.isEmpty() ? String.valueOf(index) : parentPath + "-" + index;
		
		// Обгортка, яка реагує тільки на зовнішній div
		sb.append("<div ")
		.append("data-id=\"").append(fullId).append("\" ")
		.append("style=\"margin:0;padding:0 50px;border: 2px solid #"+color+";\" ")
		.append("onclick=\"Android.onClick('").append(fullId).append("');event.stopPropagation()\">")
		
		// Вміст без кліка
		.append("<div onclick=\"event.stopPropagation()\">")
		.append(rawHtml)
		.append("</div>")
		
		.append("</div>");
	}*/
	
private static void appendHtml(JSONObject item, StringBuilder sb,
	String parentPath, int index,
	SharedPreferences sf) throws JSONException {

	ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();

	// Отримання HTML-коду
	String rawHtml = item.optString("code", "").trim();
	String color = item.optString("bbg", "000000");
	try {
		String bbg = dataHolder.getData("bbg");
		color = bbg.substring(2, 8) + bbg.substring(0, 2);
	} catch (Exception ignored) {}

	if (rawHtml.isEmpty()) rawHtml = "<h1>Empty</h1>";

	// Унікальний ID
	String fullId = parentPath.isEmpty() ? String.valueOf(index) : parentPath + "-" + index;
	String iframeId = "iframe_" + fullId.replace("-", "_");

	// Додаємо до HTML JavaScript, який підлаштовує висоту iframe
	StringBuilder htmlWithAutoHeight = new StringBuilder();
	htmlWithAutoHeight.append("<!DOCTYPE html><html><head><meta name='viewport' content='width=device-width'>")
		.append("<style>body{margin:0;padding:0;}</style>")
		.append("</head><body onload=\"parent.postMessage('height:' + document.body.scrollHeight, '*')\">")
		.append(rawHtml)
		.append("</body></html>");

	String quotedHtml = JSONObject.quote(htmlWithAutoHeight.toString());

	// JavaScript для вставки + слухача postMessage
	sb.append("<div ")
		.append("data-id=\"").append(fullId).append("\" ")
		.append("style=\"margin:0;padding:0 50px;border:2px solid #").append(color).append(";\" ")
		.append("onclick=\"Android.onClick('").append(fullId).append("');event.stopPropagation()\">")

		.append("<iframe id='").append(iframeId).append("' ")
		.append("style='width:100%;border:none;min-height:200px;' ")
		.append("scrolling='no' ")
		.append("onclick='event.stopPropagation()'></iframe>")

		.append("<script>")
		// слухач повідомлень від iframe
		.append("window.addEventListener('message', function(e){")
		.append("if(e.data && e.data.indexOf('height:')===0){")
		.append("var h=parseInt(e.data.replace('height:',''));")
		.append("document.getElementById('").append(iframeId).append("').style.height=h+'px';")
		.append("}});")

		// вставка контенту в iframe
		.append("setTimeout(function(){")
		.append("var iframe=document.getElementById('").append(iframeId).append("');")
		.append("var doc=iframe.contentWindow.document;")
		.append("doc.open();doc.write(").append(quotedHtml).append(");doc.close();")
		.append("}, 0);")

		.append("</script>")

		.append("</div>");
}


	
	private static void appendFolder(JSONObject item, StringBuilder sb, 
	String parentPath, int index, 
	SharedPreferences sf, int depth) throws JSONException {
		String name = escapeHtml(item.getString("name"));
		String color = item.optString("color", "#000000");
		String divider = sf.getString("cssdiv", " ❖ ");
		String divColor = sf.getString("cssdivcolor", "ff0000");
		JSONArray content = item.getJSONArray("content");
		
		String fullId = parentPath.isEmpty() ? String.valueOf(index) : parentPath + "-" + index;
		
		sb.append(String.format(
		"<div class=\"folder\" data-id=\"%s\" " +
		"onclick=\"var content=this.querySelector('.folder-content');" +
		"content.style.display=content.style.display==='none'?'block':'none';" +
		"Android.onFolderClick('%s-'+(content.style.display==='none'?'0':'1'));" +
		"event.stopPropagation();\" " +
		"style=\"cursor:pointer;\">" +
		"<font color=\"%s\">📁 %s</font>" +
		"<div class=\"folder-content\" style=\"display:none;margin-bottom:10px;margin-left:%dpx;\">",
		fullId, fullId, color, name, 20 * (depth + 1)
		));
		
		for (int i = 0; i < content.length(); i++) {
			JSONObject innerItem = content.getJSONObject(i);
			String type = innerItem.optString("type", "link");
			
			if ("link".equals(type)) {
				appendLink(innerItem, sb, fullId, i, sf);
				if(i < content.length() - 1) {
					sb.append(String.format("<font color=\"#%s\">%s</font>", divColor, divider));
				}
			} else if ("folder".equals(type)) {
				appendFolder(innerItem, sb, fullId, i, sf, depth + 1);
			} else if ("search".equals(type)) {
				appendSearch(innerItem, sb, fullId, i, sf);
				if(i < content.length() - 1) {
					sb.append(String.format("<font color=\"#%s\">%s</font>", divColor, divider));
				}
			}
		}
		
		sb.append("</div></div>");
	}
	
	private static void appendSearch(JSONObject item, StringBuilder sb, 
	String parentPath, int index, 
	SharedPreferences sf) throws JSONException {
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		String name = escapeHtml(item.optString("name", "Пошук"));
		String pre = escapeHtml(item.optString("pre", ""));
		String post = escapeHtml(item.optString("post", ""));
		String bgColor = item.optString("bg", "000000");
		String textColor = item.optString("tf", "ffffff");
		//String hintColor = item.optString("h", "808080");
		try{
			bgColor = item.optString("bg", dataHolder.getData("bg").substring(2,8) + dataHolder.getData("bg").substring(0,2));
			textColor = item.optString("tf", dataHolder.getData("tf").substring(2,8) + dataHolder.getData("tf").substring(0,2));
			//	hintColor = item.optString("h", dataHolder.getData("h").substring(2,8) + dataHolder.getData("h").substring(0,2));
		}
		catch(Exception e){}
		String radius = item.optString("rou", dataHolder.getData("rou"));
		int fontSize = Integer.parseInt(sf.getString("csstextsize", "16"));
		
		String fullId = parentPath.isEmpty() ? String.valueOf(index) : parentPath + "-" + index;
		
		// Розраховуємо ширину кнопки на основі розміру шрифту
		int buttonWidth = fontSize * 3; // Ширина кнопки в 3 рази більше розміру шрифту
		
		sb.append("<div class=\"search-box\" data-id=\"" + fullId + "\" style=\"width:100%;max-width:100%;\">" +
		"<form onsubmit=\"event.preventDefault();" +
		"window.location.href='" + pre + "'+encodeURIComponent(this.query.value)+'" + post + "'\" " +
		"style=\"display:flex;width:100%;max-width:100%;margin:2px 0;pointer-events:auto;\">" +
		
		// В input id = fullId (без пробілів! переконайся що fullId не має пробілів)
		"<input type=\"text\" id=\"" + fullId + "\" name=\"query\" placeholder=\"" + name + "\" " +
		"onclick=\"event.stopPropagation();event.preventDefault();\" " +
		"style=\"flex:1 1 auto;min-width:0;background:#" + bgColor + ";color:#" + textColor + 
		";border:2px solid #" + textColor + ";" +
		"border-radius:" + radius + "px 0 0 " + radius + "px;outline:none;padding:4px 8px;font-size:" + fontSize + "px;\">" +
		
		"<button class=\"done\" type=\"submit\" onclick=\"Android.onClick('" + fullId + "');event.stopPropagation();event.preventDefault();\" " +
		"style=\"flex:0 0 " + buttonWidth + "px;background:#" + textColor + ";color:#" + bgColor + 
		";border:2px solid #" + textColor + ";" +
		"border-radius:0 " + radius + "px " + radius + "px 0;padding:4px 8px;cursor:pointer;font-size:" + fontSize + "px;\">" +
		"🔍</button>" +
		
		"</form></div>");
	}
	
	
	private static String buildFullHtml(SharedPreferences sf, String bodyContent) {
		return "<!DOCTYPE html><html><head>" +
		"<meta charset=\"UTF-8\">" +
		"<style>" +
		generateStyles(sf) +
		"</style>" +
		"<script>" +
		"function toggleFolder(element) {" +
		"  var content = element.querySelector('.folder-content');" +
		"  content.style.display = content.style.display === 'none' ? 'block' : 'none';" +
		"}" +
		"</script>" +
		"</head>" +
		"<body>" +
		"<div id=\"colorDiv\"></div>" +
		"<div id=\"imageDiv\"></div>" +
		bodyContent +
		"</body></html>";
	}
	
	private static String generateStyles(SharedPreferences sf) {
		ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
		return "body {" +
		"margin:0;" +
		"padding:0;" +
		"border:" + sf.getString("cssbgstrokesize", "0") + "px " +
		sf.getString("cssbgstrokestyle", "none") + " #" +
		sf.getString("cssbgstrokecolor", "000000") + ";" +
		"text-align:" + sf.getString("csstextalign", "left") + ";" +
		"min-height:100vh;" +
		"}" +
		"#colorDiv {" +
		"position:fixed;" +
		"top:0;" +
		"left:0;" +
		"right:0;" +
		"bottom:0;" +
		"background-color:#" + sf.getString("cssbgcol", "FFFFFF") + ";" +
		"z-index:-2;" +
		"}" +
		"#imageDiv {" +
		"position:fixed;" +
		"top:0;" +
		"left:0;" +
		"right:0;" +
		"bottom:0;" +
		"background-image:url(" + sf.getString("cssbg", "") + ");" +
		"background-size:" + sf.getString("cssbgsize", "cover") + ";" +
		"opacity:" + (Float.parseFloat(sf.getString("cssbgopacity", "100"))) + ";" +
		"filter:" + buildFilterWithoutOpacity(sf, "bg") + ";" +
		"mix-blend-mode:" + sf.getString("cssbgblend", "normal") + ";" +
		"z-index:-1;" +
		"}" +
		"font {" +
		"line-height:" + sf.getString("csstextline", "1.5") + ";" +
		"font-family:" + sf.getString("csstextfont", "Arial") + ";" +
		"font-size:" + sf.getString("csstextsize", "16") + "px;" +
		"font-weight:" + sf.getString("csstextweight", "normal") + ";" +
		"text-transform:" + sf.getString("csstexttrans", "none") + ";" +
		"font-style:" + sf.getString("csstextstyle", "normal") + ";" +
		"filter:" + buildFilter(sf, "text") + ";" +
		"text-shadow:" + sf.getString("csstextshadowx", "0") + "px " +
		sf.getString("csstextshadowy", "0") + "px " +
		sf.getString("csstextshadowb", "0") + "px #" +
		sf.getString("csstextshadowc", "000000") + ";" +
		"mix-blend-mode:" + sf.getString("csstextblend", "normal") + ";" +
		"border:" + sf.getString("csstextbordersize", "0") + "px " +
		sf.getString("csstextborderstyle", "none") + " #" +
		sf.getString("csstextbordercolor", "000000") + ";" +
		"-webkit-text-stroke:" + sf.getString("csstextstrokesize", "0") + "px #" +
		sf.getString("csstextstrokecolor", "000000") + ";" +
		"}" +
		".search-box input {" +
		"line-height:" + sf.getString("csstextline", "1.5") + ";" +
		"font-family:" + sf.getString("csstextfont", "Arial") + ";" +
		"font-size:" + sf.getString("csstextsize", "16") + "px;" +
		"font-weight:" + sf.getString("csstextweight", "normal") + ";" +
		"text-transform:" + sf.getString("csstexttrans", "none") + ";" +
		"font-style:" + sf.getString("csstextstyle", "normal") + ";" +
		"filter:" + buildFilter(sf, "text") + ";" +
		"text-shadow:" + sf.getString("csstextshadowx", "0") + "px " +
		sf.getString("csstextshadowy", "0") + "px " +
		sf.getString("csstextshadowb", "0") + "px #" +
		sf.getString("csstextshadowc", "000000") + ";" +
		"mix-blend-mode:" + sf.getString("csstextblend", "normal") + ";" +
		"border:" + sf.getString("csstextbordersize", "0") + "px " +
		sf.getString("csstextborderstyle", "none") + " #" +
		sf.getString("csstextbordercolor", "000000") + ";" +
		"-webkit-text-stroke:" + sf.getString("csstextstrokesize", "0") + "px #" +
		sf.getString("csstextstrokecolor", "000000") + ";" +
		"}" +
		".done {" +
		"line-height:" + sf.getString("csstextline", "1.5") + ";" +
		"font-family:" + sf.getString("csstextfont", "Arial") + ";" +
		"font-size:" + sf.getString("csstextsize", "16") + "px;" +
		"font-weight:" + sf.getString("csstextweight", "normal") + ";" +
		"text-transform:" + sf.getString("csstexttrans", "none") + ";" +
		"font-style:" + sf.getString("csstextstyle", "normal") + ";" +
		"filter:" + buildFilter(sf, "text") + ";" +
		"text-shadow:" + sf.getString("csstextshadowx", "0") + "px " +
		sf.getString("csstextshadowy", "0") + "px " +
		sf.getString("csstextshadowb", "0") + "px #" +
		sf.getString("csstextshadowc", "000000") + ";" +
		"mix-blend-mode:" + sf.getString("csstextblend", "normal") + ";" +
		"border:" + sf.getString("csstextbordersize", "0") + "px " +
		sf.getString("csstextborderstyle", "none") + " #" +
		sf.getString("csstextbordercolor", "000000") + ";" +
		"-webkit-text-stroke:" + sf.getString("csstextstrokesize", "0") + "px #" +
		sf.getString("csstextstrokecolor", "000000") + ";" +
		"}" +
		".folder-highlight {" +
		"background-color: rgba(255, 255, 0, 0.3);" +
		"border-radius: 4px;" +
		"border: 4px solid #0000ff80;" +
		"}";
	}
	
	private static String buildFilter(SharedPreferences sf, String prefix) {
		return String.format(
		"blur(%spx) invert(%s) contrast(%s) brightness(%s) sepia(%s) hue-rotate(%sdeg) saturate(%s) opacity(%s)",
		sf.getString("css" + prefix + "blur", "0"),
		sf.getString("css" + prefix + "invert", "0"),
		sf.getString("css" + prefix + "contr", "100%"),
		sf.getString("css" + prefix + "bright", "100%"),
		sf.getString("css" + prefix + "sepia", "0%"),
		sf.getString("css" + prefix + "hue", "0"),
		sf.getString("css" + prefix + "satur", "100%"),
		sf.getString("css" + prefix + "opacity", "100%")
		);
	}
	
	public static String getHighlightScript(int[] path) {
		if (path == null || path.length == 0) {
			return "javascript:(function(){" +
			"document.querySelectorAll('.folder-highlight').forEach(el=>{" +
			"el.classList.remove('folder-highlight');});})()";
		}
		
		StringBuilder sb = new StringBuilder("javascript:(function(){");
		// Видалити попередню підсвітку
		sb.append("document.querySelectorAll('.folder-highlight').forEach(el=>{");
		sb.append("el.classList.remove('folder-highlight');});");
		
		// Додати нову підсвітку
		sb.append("const folder=document.querySelector('[data-id=\"");
		for (int i = 0; i < path.length; i++) {
			if (i > 0) sb.append("-");
			sb.append(path[i]);
		}
		sb.append("\"]');");
		sb.append("if(folder)folder.classList.add('folder-highlight');})()");
		
		return sb.toString();
	}
	
	private static String buildFilterWithoutOpacity(SharedPreferences sf, String prefix) {
		return String.format(
		"blur(%spx) invert(%s) contrast(%s) brightness(%s) sepia(%s) hue-rotate(%sdeg) saturate(%s)",
		sf.getString("css" + prefix + "blur", "0"),
		sf.getString("css" + prefix + "invert", "0"),
		sf.getString("css" + prefix + "contr", "100%"),
		sf.getString("css" + prefix + "bright", "100%"),
		sf.getString("css" + prefix + "sepia", "0%"),
		sf.getString("css" + prefix + "hue", "0"),
		sf.getString("css" + prefix + "satur", "100%")
		);
	}
	
	private static String escapeHtml(String input) {
		return TextUtils.htmlEncode(input);
	}
	
	// Додати посилання
	public static void addBM(Context context, int[] path, String name, String url, String color) {
		try {
			// 1. Завантажуємо поточні закладки
			JSONArray root = loadBookmarks(context);
			
			// 2. Знаходимо цільовий масив
			JSONArray target = root;
			for (int i = 0; i < path.length; i++) {
				JSONObject folder = target.getJSONObject(path[i]);
				target = folder.getJSONArray("content");
			}
			
			// 3. Додаємо новий елемент
			target.put(new JSONObject()
			.put("type", "link")
			.put("name", name)
			.put("url", url)
			.put("color", color.replace("#", "")));
			
			// 4. Зберігаємо зміни
			saveBookmarks(context, root);
			sortBookmarks(context);
		} catch (Exception e) {
			Log.e(TAG, "Помилка додавання закладки", e);
			e.printStackTrace();
		}
	}
	
	// Додати HTML
	public static void addHtml(Context context, int[] path, String html) {
		try {
			// 1. Завантажуємо поточні закладки
			JSONArray root = loadBookmarks(context);
			
			// 2. Знаходимо цільовий масив
			JSONArray target = root;
			for (int i = 0; i < path.length; i++) {
				JSONObject folder = target.getJSONObject(path[i]);
				target = folder.getJSONArray("content");
			}
			
			// 3. Додаємо новий елемент
			target.put(new JSONObject()
			.put("type", "html")
			.put("code", html));
			
			// 4. Зберігаємо зміни
			saveBookmarks(context, root);
			sortBookmarks(context);
		} catch (Exception e) {
			Log.e(TAG, "Помилка додавання html", e);
			e.printStackTrace();
		}
	}
	
	// Додати папку
	public static void addFOL(Context context, int[] path, String name, String color) {
		try {
			JSONArray bookmarks = loadBookmarks(context);
			JSONArray targetArray = getTargetArray(bookmarks, path);
			
			JSONObject newFolder = new JSONObject()
			.put("type", "folder")
			.put("name", name)
			.put("content", new JSONArray())
			.put("color", color);
			
			targetArray.put(newFolder);
			saveBookmarks(context, bookmarks);
			sortBookmarks(context);
		} catch (Exception e) {
			Log.e(TAG, "Помилка додавання папки", e);
		}
	}
	
	// Видалити елемент
	public static void delBM(Context context, int[] path) {
	try {
		// 1. Завантажуємо поточні закладки
		JSONArray root = loadBookmarks(context);

		// 2. Знаходимо батьківський масив
		JSONArray parent = root;
		JSONObject parentObject = null;

		for (int i = 0; i < path.length - 1; i++) {
			parentObject = parent.getJSONObject(path[i]);
			parent = parentObject.getJSONArray("content");
		}

		// 3. Видаляємо елемент
		JSONArray updated = removeFromJSONArray(parent, path[path.length - 1]);

		// 4. Оновлюємо поле "content", якщо не root
		if (parentObject != null) {
			parentObject.put("content", updated);
		} else {
			// root-масив сам оновлюємо, якщо path.length == 1
			root = updated;
		}

		// 5. Зберігаємо зміни
		saveBookmarks(context, root);

	} catch (Exception e) {
		Log.e(TAG, "Помилка видалення закладки", e);
		e.printStackTrace();
	}
}

	
	public static void addSRH(Context context, int[] path, String name, String pre, String post) {
		try {
			JSONArray root = loadBookmarks(context);
			JSONArray target = root;
			
			for (int i = 0; i < path.length; i++) {
				JSONObject folder = target.getJSONObject(path[i]);
				target = folder.getJSONArray("content");
			}
			
			target.put(new JSONObject()
			.put("type", "search")
			.put("name", name)
			.put("pre", pre)
			.put("post", post));
			
			saveBookmarks(context, root);
			sortBookmarks(context);
		} catch (Exception e) {
			Log.e(TAG, "Помилка додавання поля пошуку", e);
		}
	}
	
	public static JSONArray removeFromJSONArray(JSONArray array, int index) throws JSONException {
		JSONArray newArray = new JSONArray();
		for (int i = 0; i < array.length(); i++) {
			if (i != index) {
				newArray.put(array.get(i));
			}
		}
		return newArray;
	}
	
	
	/*	public static String getUrlBM(Context context, int[] path) {
	try {
	// 1. Завантажуємо поточні закладки
	JSONArray root = loadBookmarks(context);
	
	// 2. Знаходимо батьківський масив
	JSONArray parent = root;
	for (int i = 0; i < path.length - 1; i++) {
	JSONObject folder = parent.getJSONObject(path[i]);
	parent = folder.getJSONArray("content");
	}
	
	// 3. Отримуємо елемент перед видаленням
	JSONObject itemToDelete = parent.getJSONObject(path[path.length - 1]);
	String url = itemToDelete.optString("url", ""); // Отримуємо URL
	
	return url; // Повертаємо URL видаленого елемента
	} catch (Exception e) {
	Log.e(TAG, "Помилка отримання закладки", e);
	return ""; // Або пустий рядок ""
	}
	}
	*/
	public static interface UrlResultCallback {
		void onResult(String url);
	}
	// Я в рот шатав то жонглювання з інтерфейсами
	// Клоунам в цирку і то більше платять
	// Щей бронь від мобілізації блін є 
	static class TempInterface {
		private final UrlResultCallback callback;
		private final Activity activity;
		
		public TempInterface(Activity activity, UrlResultCallback callback) {
			this.activity = activity;
			this.callback = callback;
		}
		
		@JavascriptInterface
		public void onGetText(String text) {
			activity.runOnUiThread(() -> {
				try {
					String encoded = text;
					callback.onResult(encoded);
				} catch (Exception e) {
					callback.onResult("https://error.encoding/" + e.getMessage());
				}
			});
		}
	}
	
	public static void prepareWebViewWithTempInterface(Activity activity, UrlResultCallback callback) {
		WebView webView = ((BookmarksActivity) activity)._getWebView();
		if (webView != null) {
			webView.addJavascriptInterface(new TempInterface(activity, callback), "tempsearch");
		}
	}
	
	public static void getUrlBMAsync(final Activity activity, int[] path, UrlResultCallback callback) {
		activity.runOnUiThread(() -> {
			try {
				final WebView webView = ((BookmarksActivity) activity)._getWebView();
				if (webView == null) {
					callback.onResult("https://error/null-webview");
					return;
				}
				
				//   webView.addJavascriptInterface(new TempInterface(activity, callback), "tempsearch");
				
				// Затримка на 100мс — щоб tempsearch гарантовано був доступний у JS
				//   new Handler(Looper.getMainLooper()).postDelayed(() -> {
				try {
					webView.loadUrl("javascript:window.AndroidInterfaceReady && AndroidInterfaceReady();");
					
					JSONArray root = loadBookmarks(activity);
					JSONArray parent = root;
					for (int i = 0; i < path.length - 1; i++) {
						JSONObject folder = parent.getJSONObject(path[i]);
						parent = folder.getJSONArray("content");
					}
					final JSONObject item = parent.getJSONObject(path[path.length - 1]);
					
					if (item.has("url")) {
						callback.onResult(item.optString("url", ""));
						return;
					}
					
					if (!"search".equals(item.optString("type"))) {
						callback.onResult("https://error.type/not-link-or-search");
						return;
					}
					
					String pre = item.optString("pre", "");
					String post = item.optString("post", "");
					final String fullId = buildFullId(path);
					
					String js = "javascript:try{"
					+ "tempsearch.onGetText("
					+ "\"" + escapeJSString(pre) + "\" + document.getElementById('" + fullId + "').value + \"" + escapeJSString(post) + "\""
					+ ");"
					+ "}catch(e){alert('JS error: '+e.message);}";
					webView.loadUrl(js);
					
				} catch (JSONException e) {
					callback.onResult("https://error.json/" + e.getMessage());
				} catch (Exception e) {
					callback.onResult("https://error.unexpected/" + e.getMessage());
				}
				//    }, 100);
				
			} catch (Exception e) {
				callback.onResult("https://error.unexpected/" + e.getMessage());
			}
		});
	}
	
	// Допоміжні методи
	
	private static String escapeJSString(String s) {
		return s.replace("\\", "\\\\").replace("\"", "\\\"");
	}
	
	private static JSONArray loadBookmarks(Context context) throws Exception {
		File file = new File(context.getFilesDir(), "bookmark.json");
		if (!file.exists()) return new JSONArray();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			return new JSONArray(sb.toString());
		}
	}
	
	private static void saveBookmarks(Context context, JSONArray data) throws Exception {
		ExtendedDataHolder dh = ExtendedDataHolder.getInstance();
		File file = new File(context.getFilesDir(), "bookmark.json");
		try (FileWriter writer = new FileWriter(file)) {
			writer.write(data.toString(2)); // З відступами для читабельності
			cc(context);
		}
	}
	
	// Допоміжні методи
	private static JSONArray loadBookmarks(File file) throws Exception {
		if (!file.exists()) return new JSONArray();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			return new JSONArray(sb.toString());
		}
	}
	
	private static JSONArray getTargetArray(JSONArray root, int[] path) throws JSONException {
		JSONArray current = root;
		for (int index : path) {
			JSONObject folder = current.getJSONObject(index);
			current = folder.getJSONArray("content");
		}
		return current;
	}
	
	private static JSONArray getParentArray(JSONArray root, int[] path) throws JSONException {
		if (path.length == 0) return root;
		
		JSONArray current = root;
		for (int i = 0; i < path.length-1; i++) {
			current = current.getJSONObject(path[i]).getJSONArray("content");
		}
		return current;
	}
	
	public static void cc(Context context){
		ExtendedDataHolder dh = ExtendedDataHolder.getInstance();
		dh.removeData("chtm");
		//	new Thread(new Runnable() {
		//		@Override
		//		public void run() {
		// Виконання фонової роботи
		FileUtil.deleteFile(context.getCacheDir().getPath().concat("/bm.html"));
		//		}
		//	}).start();
	}
	
	
	
	
	
	public static void sortBookmarks(Context context) {
		try {
			JSONArray root = loadBookmarks(context);
			JSONArray sortedRoot = sortArrayRecursive(root);
			saveBookmarks(context, sortedRoot);
		} catch (Exception e) {
			Log.e(TAG, "Помилка сортування закладок", e);
		}
	}
	
	private static JSONArray sortArrayRecursive(JSONArray array) throws JSONException {
		// 1. Переносимо об'єкти в список для зручності сортування
		List<JSONObject> items = new ArrayList<>();
		for (int i = 0; i < array.length(); i++) {
			items.add(array.getJSONObject(i));
		}
		
		// 2. Сортуємо список
		Collections.sort(items, new Comparator<JSONObject>() {
			@Override
			public int compare(JSONObject a, JSONObject b) {
				try {
					// Порядок типів: search < folder < link
					int typeOrderA = getTypeOrder(a.getString("type"));
					int typeOrderB = getTypeOrder(b.getString("type"));
					if (typeOrderA != typeOrderB) {
						return Integer.compare(typeOrderA, typeOrderB);
					}
					// Якщо типи однакові — порівнюємо по name
					return a.getString("name").compareToIgnoreCase(b.getString("name"));
				} catch (JSONException e) {
					return 0;
				}
			}
		});
		
		// 3. Рекурсивно сортуємо вміст папок
		for (JSONObject item : items) {
			if (item.has("type") && item.getString("type").equals("folder") && item.has("content")) {
				JSONArray content = item.getJSONArray("content");
				item.put("content", sortArrayRecursive(content));
			}
		}
		
		// 4. Перетворюємо назад у JSONArray
		JSONArray sorted = new JSONArray();
		for (JSONObject item : items) {
			sorted.put(item);
		}
		
		return sorted;
	}
	
	// Повертає числове значення для порядку типів
	private static int getTypeOrder(String type) {
		switch (type) {
			case "html": return 0;
			case "search": return 1;
			case "folder": return 2;
			case "link": return 3;
			default: return 4;
		}
	}
	
	private static String buildFullId(int[] path) {
		StringBuilder idBuilder = new StringBuilder();
		for (int i = 0; i < path.length; i++) {
			if (i > 0) idBuilder.append("-");
			idBuilder.append(path[i]);
		}
		return idBuilder.toString();
	}
	
}
