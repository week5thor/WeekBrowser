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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.media.MediaScannerConnection;

public class FileDownloader {
    private Context context;
    private WebView webView;
    private String fileName;
    private int networkPreference;
    private String downloadUrl;
    private String userAgent;
    private String mimeType;
    private Spinner networkSpinner;

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

    public FileDownloader(Context context, WebView webView) {
        this.context = context;
        this.webView = webView;
        setupWebViewDownloadListener();
    }

    private void setupWebViewDownloadListener() {
        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long contentLength) {
                showDownloadDialog(url, userAgent, contentDisposition, mimeType, contentLength);
            }
        });

        webView.addJavascriptInterface(new BlobLoader(), "Blobload");
    }

    private void showDownloadDialog(String url, String userAgent, String contentDisposition, String mimeType, long contentLength) {
        fileName = URLUtil.guessFileName(url, contentDisposition, mimeType);
        String fileSize = (contentLength > 0) ? android.text.format.Formatter.formatFileSize(context, contentLength) : context.getString(R.string.unknown_size);
        boolean isBase64 = url.startsWith("data:");
        boolean isBlob = url.startsWith("blob:");

        ScrollView scroll = new ScrollView(context);
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(50, 40, 50, 10);
        scroll.addView(layout);

        TextView title = new TextView(context);
        title.setText(context.getString(R.string.name) + ":");
        layout.addView(title);

        EditText name = new EditText(context);
        name.setText(fileName);
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
                fileName = _param1.toString();
            }

            @Override
            public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {}

            @Override
            public void afterTextChanged(Editable _param1) {}
        });
        layout.addView(name);

        Spinner formatSpinner = new Spinner(context);
        ArrayAdapter<String> adapter0 = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, formats);
        formatSpinner.setAdapter(adapter0);
        layout.addView(formatSpinner);

        formatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position != 0) {
                    name.setText(fileName.replaceFirst("\\.[^.]+$", "." + formats[position]));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {}
        });

        TextView infoText = new TextView(context);
        
        if (isBase64) {
            // Для base64 показуємо спеціальний текст замість URL
            infoText.setText(context.getString(R.string.base64_data) + "\n\n" +
                           context.getString(R.string.format) + ": " + mimeType + "\n\n" +
                           context.getString(R.string.size) + ": " + fileSize);
        } else if (isBlob) {
            // Для blob показуємо спеціальний текст
            infoText.setText(context.getString(R.string.blob_data) + "\n\n" +
                           context.getString(R.string.format) + ": " + mimeType + "\n\n" +
                           context.getString(R.string.size) + ": " + fileSize);
        } else {
            // Для звичайних URL показуємо посилання
            infoText.setText(context.getString(R.string.url) + ": " + url + "\n\n" +
                           context.getString(R.string.format) + ": " + mimeType + "\n\n" +
                           context.getString(R.string.size) + ": " + fileSize);
        }
        
        infoText.setTextIsSelectable(true);
        layout.addView(infoText);

        // Для base64 та blob не показуємо вибір мережі
        networkSpinner = null;
        if (!isBase64 && !isBlob) {
            networkSpinner = new Spinner(context);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item,
                    new String[]{context.getString(R.string.anynet), context.getString(R.string.wifionly), context.getString(R.string.mobonly)});
            networkSpinner.setAdapter(adapter);
            layout.addView(networkSpinner);
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.download));
        builder.setView(scroll);

        builder.setPositiveButton(context.getString(R.string.download), (dialog, which) -> {
            if (networkSpinner != null) {
                networkPreference = networkSpinner.getSelectedItemPosition();
            }
            this.downloadUrl = url;
            this.userAgent = userAgent;
            this.mimeType = mimeType;
            startDownload();
        });

        builder.setNegativeButton(context.getString(R.string.cancel), (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    private void startDownload() {
        if (downloadUrl.startsWith("data:")) {
            handleBase64Download();
        } else if (downloadUrl.startsWith("http")) {
            downloadHttpFile();
        } else if (downloadUrl.startsWith("blob:")) {
            loadBlobUrl();
        }
    }

    private void downloadHttpFile() {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadUrl));
        request.setMimeType(mimeType);
        String cookies = CookieManager.getInstance().getCookie(downloadUrl);
        request.addRequestHeader("cookie", cookies);
        request.addRequestHeader("User-Agent", userAgent);
        request.setDescription(context.getString(R.string.dstart));
        request.setTitle(fileName);
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);

        switch (networkPreference) {
            case 0: // Будь-яка мережа
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                break;
            case 1: // Лише Wi-Fi
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
                break;
            case 2: // Лише мобільний інтернет
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE);
                break;
        }

        DownloadManager dm = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        if (dm != null) {
            dm.enqueue(request);
            Toast.makeText(context, context.getString(R.string.dstart), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, context.getString(R.string.download_manager_error), Toast.LENGTH_LONG).show();
        }
    }

    private void handleBase64Download() {
        try {
            // Розбір data URL
            String[] parts = downloadUrl.split(",", 2);
            String metaInfo = parts[0];
            String base64Data = parts[1];
            
            // Визначення MIME-типу
            String mimeType = "application/octet-stream";
            if (metaInfo.contains(";")) {
                mimeType = metaInfo.split(";")[0].substring(5);
            }
            
            // Генерація розширення
            String extension = MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeType);
            if (extension == null) extension = "bin";
            
            // Корекція імені файлу
            if (!fileName.contains(".")) {
                fileName = fileName + "." + extension;
            }
            
            // Декодування та збереження
            byte[] fileData = Base64.decode(base64Data, Base64.DEFAULT);
            saveFile(fileData, fileName);
            Toast.makeText(context, context.getString(R.string.loaddone), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Log.e("Base64Download", "Error: " + e.getMessage());
            Toast.makeText(context, context.getString(R.string.base64_error), Toast.LENGTH_LONG).show();
        }
    }

private void loadBlobUrl() {
    String jsCode = "(function() {" +
        "try {" +
        "  var xhr = new XMLHttpRequest();" +
        "  xhr.open('GET', '" + downloadUrl + "', true);" +
        "  xhr.setRequestHeader('Content-type', '" + mimeType + "');" +
        "  xhr.responseType = 'blob';" +
        "  xhr.onload = function(e) {" +
        "    if (this.status == 200) {" +
        "      var blob = this.response;" +
        "      var reader = new FileReader();" +
        "      reader.onloadend = function() {" +
        "        var base64data = reader.result;" +
        "        Blobload.convertBase64StringToFileAndStoreIt(base64data, '" + mimeType + "');" +
        "      };" +
        "      reader.readAsDataURL(blob);" +
        "    } else {" +
        "      Blobload.showToast('Error: ' + this.status);" +
        "    }" +
        "  };" +
        "  xhr.onerror = function() {" +
        "    Blobload.showToast('Request failed');" +
        "  };" +
        "  xhr.send();" +
        "} catch(e) {" +
        "  Blobload.showToast('JS Error: ' + e.message);" +
        "}" +
        "})()";

    webView.evaluateJavascript(jsCode, null);
}

private class BlobLoader {
    @JavascriptInterface
    public void convertBase64StringToFileAndStoreIt(String base64Data, String mimeType) {
        try {
            // Отримуємо розширення файлу з MIME-типу
            String extension = MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeType);
            if (extension == null) {
                extension = "bin";
            }

            // Корегуємо ім'я файлу, якщо потрібно
            if (!fileName.contains(".")) {
                fileName = fileName + "." + extension;
            }

            // Видаляємо префікс data URL
            String pureBase64 = base64Data.substring(base64Data.indexOf(",") + 1);

            // Декодуємо base64
            byte[] fileData = Base64.decode(pureBase64, Base64.DEFAULT);

            // Зберігаємо файл
            File downloadsDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS);
            File file = new File(downloadsDir, fileName);

            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(fileData);
                fos.flush();
            }

            // Оновлюємо медіа-сканер
            MediaScannerConnection.scanFile(
                context,
                new String[]{file.getAbsolutePath()},
                new String[]{mimeType},
                null
            );

            showToast(context.getString(R.string.file_saved) + ": " + file.getAbsolutePath());
        } catch (Exception e) {
            Log.e("BlobSave", "Error: " + e.getMessage());
            showToast(context.getString(R.string.file_save_error));
        }
    }

    @JavascriptInterface
    public void showToast(String message) {
        ((Activity) context).runOnUiThread(() -> 
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        );
    }
}

    private void saveFile(byte[] data, String fileName) {
        try {
            File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            if (!directory.exists() && !directory.mkdirs()) {
                throw new IOException(context.getString(R.string.create_dir_error));
            }

            File file = new File(directory, fileName);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(data);
            }

            // Оновлення медіа-сканера
            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri contentUri = Uri.fromFile(file);
            mediaScanIntent.setData(contentUri);
            context.sendBroadcast(mediaScanIntent);

            Toast.makeText(context, 
                context.getString(R.string.blob_saved) + ": " + file.getAbsolutePath(), 
                Toast.LENGTH_LONG).show();
                
        } catch (IOException e) {
            Log.e("FileSaver", "Error: " + e.getMessage());
            Toast.makeText(context, context.getString(R.string.file_error), Toast.LENGTH_LONG).show();
        }
    }


    public void downloadFromUrl(String url) {
        showDownloadDialog(url, "", "", "*/*", -1);
    }
}