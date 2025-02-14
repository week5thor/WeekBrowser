package com.a525team.weekbrowser;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
//import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
//import android.net.ConnectivityManager;
//import android.net.Network;
//import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
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
//import android.net.NetworkInfo;
//import android.annotation.SuppressLint;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDownloader {
    private Context context;
    private WebView webView;
    private String fileName;
    private int networkPreference;
    private String downloadUrl;
    private String userAgent;
    private String mimeType;
 //   private boolean isDownloadPending = false;

    private final String[] formats = {
        "-- Choose different format --",
        "• Image", "jpg", "png", "webp", "gif", "svg",
        "• Audio", "mp3", "flac", "m4a", "wav", "ogg",
        "• Video", "mp4", "3gp", "webm", "avi", "wmv", "mkv",
        "• Archive", "zip", "rar", "7z", "tar.gz",
        "• Application", "apk", "jar", "sis", "jad", "exe", "ipa",
        "• Document", "txt", "doc", "docx", "ppt", "pptx", "xls", "xlsx", "xlsb",
        "• Code", "xml", "html", "java", "c", "cpp", "py", "php", "js", "json", "bin", "o", "hex",
        "• Miscellaneous", "skin", "flp", "flm", "kdz", "sb", "swb", "caustic"
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
        String fileSize = (contentLength > 0) ? android.text.format.Formatter.formatFileSize(context, contentLength) : "Невідомий розмір";

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
        infoText.setText(context.getString(R.string.url) + ": " + url + "\n\n" + context.getString(R.string.format) + ": " + mimeType + "\n\n" + context.getString(R.string.size) + ": " + fileSize);
        infoText.setTextIsSelectable(true);
        layout.addView(infoText);

        Spinner networkSpinner = new Spinner(context);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item,
                new String[]{context.getString(R.string.anynet), context.getString(R.string.wifionly), context.getString(R.string.mobonly)});
        networkSpinner.setAdapter(adapter);
        layout.addView(networkSpinner);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.download));
        builder.setView(scroll);

        builder.setPositiveButton(context.getString(R.string.download), (dialog, which) -> {
            networkPreference = networkSpinner.getSelectedItemPosition();
            this.downloadUrl = url;
            this.userAgent = userAgent;
            this.mimeType = mimeType;
            startDownload();
        });

        builder.setNegativeButton(context.getString(R.string.cancel), (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    private void startDownload() {
if (downloadUrl.startsWith("http")) {
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

        // Визначаємо дозволений тип мережі на основі вибору користувача
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
        dm.enqueue(request);

        Toast.makeText(context, context.getString(R.string.dstart), Toast.LENGTH_LONG).show();
    } else if (downloadUrl.startsWith("blob:")) {
            String jsCode =
                    "var xhr = new XMLHttpRequest();" +
                    "xhr.open('GET', '" + downloadUrl + "', true);" +
                    "xhr.responseType = 'blob';" +
                    "xhr.onload = function() {" +
                    "    if (xhr.status === 200) {" +
                    "        var blob = xhr.response;" +
                    "        var link = document.createElement('a');" +
                    "        link.href = window.URL.createObjectURL(blob);" +
                    "        link.download = '" + fileName + "';" +
                    "        document.body.appendChild(link);" +
                    "        link.click();" +
                    "        document.body.removeChild(link);" +
                    "        Blobload.showToast(' " + context.getString(R.string.loaddone) + " ');" +
                    "    } else {" +
                    "        Blobload.showToast('" + context.getString(R.string.blerr) + "' + xhr.status);" +
                    "    }" +
                    "};" +
                    "xhr.onerror = function() {" +
                    "    Blobload.showToast('" + context.getString(R.string.brerr) + "');" +
                    "};" +
                    "xhr.send();";
            webView.evaluateJavascript(jsCode, null);

            Toast.makeText(context, context.getString(R.string.dstart), Toast.LENGTH_LONG).show();
        }
    }

    private class BlobLoader {
        @JavascriptInterface
        public void saveBlob(String base64Data, String fileName) {
            byte[] fileData = android.util.Base64.decode(base64Data, android.util.Base64.DEFAULT);

            try {
                File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                if (!path.exists() && !path.mkdirs()) {
                    throw new IOException("Не вдалося створити директорію для завантаження.");
                }

                File file = new File(path, fileName);
                try (FileOutputStream fos = new FileOutputStream(file)) {
                    fos.write(fileData);
                }

                ((Activity) context).runOnUiThread(() -> Toast.makeText(context, "Файл збережено: " + file.getAbsolutePath(), Toast.LENGTH_LONG).show());
            } catch (IOException e) {
                e.printStackTrace();
                ((Activity) context).runOnUiThread(() -> Toast.makeText(context, "Помилка збереження файлу", Toast.LENGTH_LONG).show());
            }
        }

        @JavascriptInterface
        public void showToast(final String message) {
            ((Activity) context).runOnUiThread(() -> Toast.makeText(context, message, Toast.LENGTH_LONG).show());
        }
    }

    public void downloadFromUrl(String url) {
        showDownloadDialog(url, "", "", "*/*", -1);
    }
}