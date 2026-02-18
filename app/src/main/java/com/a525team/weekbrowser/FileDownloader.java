//FileDownloader.java

package com.a525team.weekbrowser;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Window;
import android.view.WindowManager;

import android.media.MediaScannerConnection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDownloader {
	private Activity activity;
	private WebView webView;
	private String fileName;
	private int networkPreference;
	private String downloadUrl;
	private String userAgent;
	private String mimeType;
	private Spinner networkSpinner;
	private RenderUtils ru;
	// Для blob base64
	private String pendingBase64Data = null;
	private String pendingMimeType = null;
	
	private final String[] formats = {
		"-- Choose different format --",
		"• Image", "jpg", "png", "webp", "gif", "svg",
		"• Audio", "mp3", "flac", "m4a", "wav", "ogg",
		"• Video", "mp4", "3gp", "webm", "avi", "wmv", "mkv",
		"• Archive", "zip", "rar", "7z", "tar.gz",
		"• Application", "apk", "jar", "sis", "jad", "exe", "ipa",
		"• Document", "txt", "doc", "docx", "pdf", "ppt", "pptx", "xls", "xlsx", "xlsb",
		"• Code", "xml", "html", "java", "c", "cpp", "py", "php", "js", "json", "db", "bin", "o", "hex", "mht",
		"• Miscellaneous", "torrent", "skin", "flp", "flm", "kdz", "sb", "swb", "macro", "caustic", "xmcd", "cir", "nth"
	};
	
	public FileDownloader(Activity activity, WebView webView) {
		this.activity = activity;
		this.webView = webView;
		setupWebViewDownloadListener();
		ru = new RenderUtils(activity);
	}
	
	private void setupWebViewDownloadListener() {
    webView.setDownloadListener((url, userAgent, contentDisposition, mimeType, contentLength) -> {
        if (url != null && url.startsWith("blob:")) {
            Toast.makeText(activity, activity.getString(R.string.blobload), Toast.LENGTH_LONG).show();
            downloadUrl = url;
                loadBlobUrl();
               // return;
        }else
        showDownloadDialog(url, userAgent, contentDisposition, mimeType, contentLength, null);
    });

    webView.addJavascriptInterface(new BlobLoader(), "Blobload");
}

	
	
    
    private void showDownloadDialog(String url, String userAgent, String contentDisposition, String mimeType, long contentLength, String base64DataForBlob) {
		fileName = URLUtil.guessFileName(url, contentDisposition, mimeType);
		String fileSize = (contentLength > 0)
		? Formater.kimgt(contentLength) + "B"
		: activity.getString(R.string.unknown_size);
		boolean isBase64 = url.startsWith("data:");
		boolean isBlob = url.startsWith("blob:");
		
		ScrollView scroll = new ScrollView(activity);
		LinearLayout layout = new LinearLayout(activity);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.setPadding(50, 40, 50, 10);
		scroll.addView(layout);
		
		TextView title = new TextView(activity);
		title.setText(activity.getString(R.string.name));
		layout.addView(title);
		
		EditText name = new EditText(activity);
		name.setText(fileName);
		name.addTextChangedListener(new TextWatcher() {
			@Override public void onTextChanged(CharSequence s, int start, int before, int count) { fileName = s.toString(); }
			@Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
			@Override public void afterTextChanged(Editable s) {}
		});
		layout.addView(name);
		
		Spinner formatSpinner = new Spinner(activity);
		ArrayAdapter<String> adapter0 = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_dropdown_item, formats);
		formatSpinner.setAdapter(adapter0);
		layout.addView(formatSpinner);
		
		formatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
				if (position != 0) {
					name.setText(fileName.replaceFirst("\\.[^.]+$", "." + formats[position]));
				}
			}
			@Override public void onNothingSelected(AdapterView<?> parentView) {}
		});
		
		TextView infoText = new TextView(activity);
		if (isBase64) {
			infoText.setText("Base64\n\n" + activity.getString(R.string.format) + ": " + mimeType + "\n" + activity.getString(R.string.size) + ": " + fileSize);
		} else {
			infoText.setText(activity.getString(R.string.url) + ": " + url + "\n\n" + activity.getString(R.string.format) + ": " + mimeType + "\n" + activity.getString(R.string.size) + ": " + fileSize);
		}
		infoText.setTextIsSelectable(true);
		layout.addView(infoText);
		
		networkSpinner = null;
		if (!isBase64 && !isBlob) {
			networkSpinner = new Spinner(activity);
			ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_dropdown_item,
			new String[]{activity.getString(R.string.anynet), activity.getString(R.string.wifionly), activity.getString(R.string.mobonly)});
			networkSpinner.setAdapter(adapter);
			layout.addView(networkSpinner);
		}
		
		AlertDialog.Builder builder = new AlertDialog.Builder(activity);
		builder.setTitle(activity.getString(R.string.download));
		builder.setView(scroll);
		
		builder.setPositiveButton(activity.getString(R.string.download), (dialog, which) -> {
			if (networkSpinner != null) {
				networkPreference = networkSpinner.getSelectedItemPosition();
			}
			if (isBlob) {
				// Зберігаємо base64 через внутрішній метод
				pendingBase64Data = base64DataForBlob;
				pendingMimeType = mimeType;
				try {
					String extension = MimeTypeMap.getSingleton().getExtensionFromMimeType(pendingMimeType);
					if (extension == null) extension = "bin";
					if (!fileName.contains(".")) {
						fileName += "." + extension;
					}
					String pureBase64 = pendingBase64Data.substring(pendingBase64Data.indexOf(",") + 1);
					byte[] fileData = Base64.decode(pureBase64, Base64.DEFAULT);
					saveFile(fileData, fileName, pendingMimeType);
					Toast.makeText(activity, activity.getString(R.string.loaddone) + fileName, Toast.LENGTH_LONG).show();
				} catch (Exception e) {
					Log.e("BlobSave", activity.getString(R.string.brerr) + e.getMessage());
					Toast.makeText(activity, activity.getString(R.string.blerr), Toast.LENGTH_LONG).show();
				}
			} else if (isBase64) {
				handleBase64Download();
			} else {
				this.downloadUrl = url;
				this.userAgent = userAgent;
				this.mimeType = mimeType;
				startDownload();
			}
		});
		
		builder.setNegativeButton(activity.getString(R.string.cancel), (dialog, which) -> dialog.dismiss());
		final AlertDialog dialog2 = builder.create();
		dialog2.setOnDismissListener(d -> {
            
		});
		
dialog2.setOnShowListener(d -> {
            Window window = dialog2.getWindow();
		if (window != null) {
	if(WTF.SDK_INT() > 31 && ru.isOn()){
        ru.on();
			window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
			window.setDimAmount(0f);
		} else {
        ExtendedDataHolder datah = ExtendedDataHolder.getInstance();
            window.setDimAmount(Float.parseFloat(datah.getData("dvalp")));
        }
	}
});
dialog2.setOnDismissListener(d -> {
	ru.off();
});
dialog2.show();
	}
    
    
    
	
	private void startDownload() {
		if (downloadUrl.startsWith("data:")) {
			handleBase64Download();
		} else if (downloadUrl.startsWith("http")) {
			downloadHttpFile();
		}
	}
	
	private void downloadHttpFile() {
		DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadUrl));
		request.setMimeType(mimeType);
		String cookies = CookieManager.getInstance().getCookie(downloadUrl);
		request.addRequestHeader("cookie", cookies);
		request.addRequestHeader("User-Agent", userAgent);
		request.setDescription(activity.getString(R.string.dstart));
		request.setTitle(fileName);
		request.allowScanningByMediaScanner();
		request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
		request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
		
		switch (networkPreference) {
			case 0: request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE); break;
			case 1: request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI); break;
			case 2: request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE); break;
		}
		
		DownloadManager dm = (DownloadManager) activity.getSystemService(Activity.DOWNLOAD_SERVICE);
		if (dm != null) {
			dm.enqueue(request);
			Toast.makeText(activity, activity.getString(R.string.dstart), Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(activity, "DownloadManager error", Toast.LENGTH_LONG).show();
		}
	}
	
	private void handleBase64Download() {
		try {
			String[] parts = downloadUrl.split(",", 2);
			String metaInfo = parts[0];
			String base64Data = parts[1];
			String mimeType = "application/octet-stream";
			if (metaInfo.contains(";")) {
				mimeType = metaInfo.split(";")[0].substring(5);
			}
			String extension = MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeType);
			if (extension == null) extension = "bin";
			if (!fileName.contains(".")) {
				fileName += "." + extension;
			}
			byte[] fileData = Base64.decode(base64Data, Base64.DEFAULT);
			saveFile(fileData, fileName, mimeType);
			Toast.makeText(activity, activity.getString(R.string.loaddone) + fileName, Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Log.e("Base64Download", "Error: " + e.getMessage());
			Toast.makeText(activity, "Save error", Toast.LENGTH_LONG).show();
		}
	}

	private void loadBlobUrl() {
    String jsCode =
        "(function() {" +
        "  try {" +
        "    var xhr = new XMLHttpRequest();" +  // Використовуємо XMLHttpRequest замість fetch
        "    xhr.open('GET', '" + downloadUrl.replace("'", "\\'") + "', true);" +
        "    xhr.responseType = 'blob';" +
        "    xhr.onload = function() {" +
        "      if (xhr.status === 200 || xhr.status === 0) {" +  // Обробляємо успішний запит
        "        var blob = xhr.response;" +
        "        var reader = new FileReader();" +
        "        reader.onloadend = function() {" +
        "          Blobload.sendBlobData(reader.result, blob.type, blob.size, '" + downloadUrl.replace("'", "\\'") + "');" +
        "        };" +
        "        reader.readAsDataURL(blob);" +
        "      } else {" +
        "        Blobload.showToast('XHR Error: ' + xhr.status);" +
        "      }" +
        "    };" +
        "    xhr.onerror = function() {" +
        "      Blobload.showToast('XHR Failed');" +
        "    };" +
        "    xhr.send();" +
        "  } catch(e) {" +
        "    Blobload.showToast('JS Error: ' + e.message);" +
        "  }" +
        "})();";
    
    webView.loadUrl("javascript:" + jsCode);
}
	
	private class BlobLoader {
	@JavascriptInterface
public void sendBlobData(String base64Data, String mimeType, long fileSize, String downloadUrl) {
    ((Activity) activity).runOnUiThread(() -> {
        showDownloadDialog(
            downloadUrl, 
            userAgent, 
            "", 
            mimeType, 
            fileSize,  // Тепер передається реальний розмір файлу
            base64Data
        );
    });
}
		@JavascriptInterface
		public void showToast(String message) {
			((Activity) activity).runOnUiThread(() ->
			Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
			);
		}
	}

	private void saveFile(byte[] data, String fileName, String mimeType) throws IOException {
		File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
		if (!dir.exists() && !dir.mkdirs()) throw new IOException("Dir create error");
		File file = new File(dir, fileName);
		try (FileOutputStream fos = new FileOutputStream(file)) {
			fos.write(data);
		}
		MediaScannerConnection.scanFile(activity, new String[]{file.getAbsolutePath()}, new String[]{mimeType}, null);
	}
	
	public void downloadFromUrl(String url) {
		showDownloadDialog(url, "", "", "* /*", -1, null);
	}
	
	public void handleBlobFromOtherActivity(String url) {
		if (url == null || !url.startsWith("blob:")) {
			// Не blob — можна або ігнорувати, або обробити інакше
			downloadFromUrl(url);
            return;
		}
		
		AlertDialog.Builder builder = new AlertDialog.Builder(activity)
		.setTitle("!!!")
		.setMessage(activity.getString(R.string.returtomain))
		.setPositiveButton(activity.getString(R.string.yes), (dialog, which) -> {
			ExtendedDataHolder dh = ExtendedDataHolder.getInstance();
            dh.setData("blob", url);
			activity.finish();
		})
		.setNegativeButton(activity.getString(R.string.no), (dialog, which) -> dialog.dismiss());
		final AlertDialog dialog2 = builder.create();
		dialog2.setOnDismissListener(d -> {
			ru.off();
		});
		ru.on();
		
		dialog2.setOnShowListener(d -> {
            Window window = dialog2.getWindow();
		if (window != null) {
	if(WTF.SDK_INT() > 31 && ru.isOn()){
        ru.on();
			window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
			window.setDimAmount(0f);
		} else {
        ExtendedDataHolder datah = ExtendedDataHolder.getInstance();
            window.setDimAmount(Float.parseFloat(datah.getData("dvalp")));
        }
	}
});
		
		dialog2.show();
	}
	
	
}






