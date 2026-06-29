package com.a525team.weekbrowser;

import android.content.SharedPreferences;
import android.app.AlertDialog;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.webkit.WebResourceResponse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AdBlocker {
    private static AdBlocker instance;
    private final Context context;

    private static final String USER_BLACK_FILE = "user_ad_list.txt";
    private static final String USER_WHITE_FILE = "user_white_list.txt";

    private static class ComplexRule {
        Pattern pattern;
        int lineNumber;
        ComplexRule(Pattern pattern, int lineNumber) { this.pattern = pattern; this.lineNumber = lineNumber; }
    }

    private static class SimpleRule {
        String text;
        int lineNumber;
        SimpleRule(String text, int lineNumber) { this.text = text; this.lineNumber = lineNumber; }
    }

    // Списки для чорного списку (Блокування)
    private final List<ComplexRule> complexUrlPatterns = new ArrayList<>();
    private final List<ComplexRule> complexDomainPatterns = new ArrayList<>();
    private final List<SimpleRule> simpleUrlFilters = new ArrayList<>();
    private final List<SimpleRule> simpleDomainFilters = new ArrayList<>();

    // Списки для БІЛОГО списку (Виключення з блокування)
    private final List<ComplexRule> whiteComplexUrl = new ArrayList<>();
    private final List<ComplexRule> whiteComplexDomain = new ArrayList<>();
    private final List<SimpleRule> whiteSimpleUrl = new ArrayList<>();
    private final List<SimpleRule> whiteSimpleDomain = new ArrayList<>();

    public AdBlocker(Context context) {
        this.context = context.getApplicationContext();
        loadBlockedHosts();
    }

    public static synchronized AdBlocker getInstance(Context context) {
        if (instance == null) {
            instance = new AdBlocker(context);
        }
        return instance;
    }

    public void loadBlockedHosts() {
        clearCache();
        
        // 1. Завантажуємо користувацький БІЛИЙ список (Найвищий пріортитет, маркер типу джерела: 10)
        loadRulesFromFile(USER_WHITE_FILE, 10);
        
        // 2. Завантажуємо користувацький ЧОРНИЙ список (Маркер типу джерела: 1)
        loadRulesFromFile(USER_BLACK_FILE, 1);
        
        // 3. Завантажуємо вбудований ЧОРНИЙ список з Assets (Маркер типу джерела: 2)
        loadStdBlockedHosts();
    }

    private void loadRulesFromFile(String fileName, int sourceMarker) {
        File file = new File(context.getFilesDir(), fileName);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNum = 1;
            while ((line = br.readLine()) != null) {
                parseLine(line, lineNum, sourceMarker);
                lineNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadStdBlockedHosts() {
        try (InputStream is = context.getAssets().open("ad_list.txt");
             BufferedReader br = new BufferedReader(new java.io.InputStreamReader(is, "UTF-8"))) {
            String line;
            int lineNum = 1;
            while ((line = br.readLine()) != null) {
                parseLine(line, lineNum, 2);
                lineNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseLine(String line, int lineNum, int sourceMarker) {
        line = line.trim();
        if (line.startsWith("#") || line.startsWith("//") || line.isEmpty()) return;

        // Формуємо фінальний індекс:
        // sourceMarker == 10 -> Білий список (Користувацький)
        // sourceMarker == 1  -> Чорний список (Користувацький): додатнє число
        // sourceMarker == 2  -> Чорний список (Вбудований): від'ємне число
        int finalIndex = (sourceMarker == 2) ? -lineNum : lineNum;

        boolean isUrlRule = line.startsWith("%");
        String rawRegex = isUrlRule ? line.substring(1).trim() : line;

        boolean isComplex = isComplexRegex(rawRegex);

        if (sourceMarker == 10) { // Білий список
            if (isComplex) {
                try {
                    Pattern p = Pattern.compile(rawRegex, Pattern.CASE_INSENSITIVE);
                    if (isUrlRule) whiteComplexUrl.add(new ComplexRule(p, finalIndex));
                    else whiteComplexDomain.add(new ComplexRule(p, finalIndex));
                } catch (Exception ignored) {}
            } else {
                String plain = rawRegex.replace("\\", "").toLowerCase();
                if (isUrlRule) whiteSimpleUrl.add(new SimpleRule(plain, finalIndex));
                else whiteSimpleDomain.add(new SimpleRule(plain, finalIndex));
            }
        } else { // Чорні списки (користувацькі та вбудовані)
            if (isComplex) {
                try {
                    Pattern p = Pattern.compile(rawRegex, Pattern.CASE_INSENSITIVE);
                    if (isUrlRule) complexUrlPatterns.add(new ComplexRule(p, finalIndex));
                    else complexDomainPatterns.add(new ComplexRule(p, finalIndex));
                } catch (Exception ignored) {}
            } else {
                String plain = rawRegex.replace("\\", "").toLowerCase();
                if (isUrlRule) simpleUrlFilters.add(new SimpleRule(plain, finalIndex));
                else simpleDomainFilters.add(new SimpleRule(plain, finalIndex));
            }
        }
    }

    private boolean isComplexRegex(String rule) {
        return rule.contains("*") || rule.contains("+") || rule.contains("?") || 
               rule.contains("|") || rule.contains("(") || rule.contains("[") || 
               rule.contains("^") || rule.contains("$");
    }

    // Головна перевірка блокування
    public int isBlocked(String url) {
        if (url == null || url.isEmpty()) return 0;
        String lowerUrl = url.toLowerCase();
        String domain = Uri.parse(url).getHost();
        String lowerDomain = domain != null ? domain.toLowerCase() : null;

        // --- КРОК А: ПЕРЕВІРКА БІЛОГО СПИСКУ (Якщо збігається — НЕ блокуємо, повертаємо 0) ---
        for (SimpleRule rule : whiteSimpleUrl) {
            if (lowerUrl.contains(rule.text)) return 0;
        }
        for (ComplexRule rule : whiteComplexUrl) {
            if (rule.pattern.matcher(url).find()) return 0;
        }
        if (lowerDomain != null) {
            for (SimpleRule rule : whiteSimpleDomain) {
                if (lowerDomain.contains(rule.text)) return 0;
            }
            for (ComplexRule rule : whiteComplexDomain) {
                if (rule.pattern.matcher(lowerDomain).find()) return 0;
            }
        }

        // --- КРОК Б: ПЕРЕВІРКА ЧОРНИХ СПИСКІВ ---
        for (SimpleRule rule : simpleUrlFilters) {
            if (lowerUrl.contains(rule.text)) return rule.lineNumber;
        }
        for (ComplexRule rule : complexUrlPatterns) {
            if (rule.pattern.matcher(url).find()) return rule.lineNumber;
        }
        if (lowerDomain != null) {
            for (SimpleRule rule : simpleDomainFilters) {
                if (lowerDomain.contains(rule.text)) return rule.lineNumber;
            }
            for (ComplexRule rule : complexDomainPatterns) {
                if (rule.pattern.matcher(lowerDomain).find()) return rule.lineNumber;
            }
        }

        return 0;
    }

    // ПУНКТ 1: Метод автоматичного налаштування кнопки
    public void checkAdButton(TextView button, String url) {
        if (url == null || url.isEmpty()) {
            button.setVisibility(View.GONE);
            return;
        }

        button.setVisibility(View.VISIBLE);
        int blockResult = isBlocked(url);

        if (blockResult != 0) {
            // Елемент розпізнано як рекламу
            String source = (blockResult > 0) ? "User" : "Std";
            int line = Math.abs(blockResult);
            // Виводимо інформацію, наприклад: "Unblock Ad (#Std 42)"
            button.setText(String.format(context.getString(R.string.is_not_ad), source, line));
            button.setTag(true); // Прапорець: зараз це реклама
        } else {
            button.setText(context.getString(R.string.is_ad));
            button.setTag(false); // Прапорець: зараз це звичайний елемент
        }
    }

    // ПУНКТ 2: Покращений діалог блокування / розблокування
    public void showBlockDialog(final Activity activityContext, final String url, final Runnable onUpdateUI) {
    if (url == null || url.isEmpty()) return;
    
    final String domain = extractDomain(url);
    int blockResult = isBlocked(url);
    boolean isCurrentlyBlocked = (blockResult != 0);

    AlertDialog.Builder builder = new AlertDialog.Builder(activityContext);

    if (isCurrentlyBlocked) {
        builder.setTitle(activityContext.getString(R.string.ad_dialog_title_blocked));
        
        // БЕЗПЕЧНО: просто додаємо домен до тексту з ресурсів
        String msg = activityContext.getString(R.string.ad_dialog_msg_blocked) + " " + domain;
        builder.setMessage(msg);
        
        builder.setPositiveButton(activityContext.getString(R.string.ad_dialog_btn_unblock_domain), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                appendToFile(USER_WHITE_FILE, domain);
                finishDialogAction(activityContext.getString(R.string.ad_toast_whitelist_domain), onUpdateUI);
            }
        });
        builder.setNegativeButton(activityContext.getString(R.string.ad_dialog_btn_unblock_url), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                appendToFile(USER_WHITE_FILE, "%" + url);
                finishDialogAction(activityContext.getString(R.string.ad_toast_whitelist_url), onUpdateUI);
            }
        });
    } else {
        builder.setTitle(activityContext.getString(R.string.ad_dialog_title_block));
        
        // БЕЗПЕЧНО: додаємо повний URL до тексту з ресурсів
        String msg = activityContext.getString(R.string.ad_dialog_msg_block) + "\n" + url;
        builder.setMessage(msg);

        builder.setPositiveButton(activityContext.getString(R.string.ad_dialog_btn_block_domain), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String escapedDomain = domain.replace(".", "\\.");
                appendToFile(USER_BLACK_FILE, escapedDomain);
                finishDialogAction(activityContext.getString(R.string.ad_toast_blacklist_domain), onUpdateUI);
            }
        });
        builder.setNegativeButton(activityContext.getString(R.string.ad_dialog_btn_block_url), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String escapedUrl = url.replace(".", "\\.");
                appendToFile(USER_BLACK_FILE, "%" + escapedUrl);
                finishDialogAction(activityContext.getString(R.string.ad_toast_blacklist_url), onUpdateUI);
            }
        });
    }

    builder.setNeutralButton(activityContext.getString(R.string.cancel), null);
    
    AlertDialog dialog = builder.create();
    dialog.setCanceledOnTouchOutside(true);
	RenderUtils.setupDialogDim(activityContext, dialog);
    dialog.show();
}

    private void finishDialogAction(String message, Runnable onUpdateUI) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        loadBlockedHosts(); // Перезавантажуємо списки в пам'ять
        if (onUpdateUI != null) {
            onUpdateUI.run(); // Оновлюємо інтерфейс (наприклад, стан кнопки)
        }
    }

    // Хелпер для швидкого запису в кінець файлу
    private void appendToFile(String fileName, String data) {
        File file = new File(context.getFilesDir(), fileName);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(data);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String extractDomain(String url) {
        try {
            String host = Uri.parse(url).getHost();
            return host != null ? host : url;
        } catch (Exception e) {
            return url;
        }
    }

    public void clearCache() {
        complexUrlPatterns.clear();
        complexDomainPatterns.clear();
        simpleUrlFilters.clear();
        simpleDomainFilters.clear();
        whiteComplexUrl.clear();
        whiteComplexDomain.clear();
        whiteSimpleUrl.clear();
        whiteSimpleDomain.clear();
    }

    // Інші ваші методи (pseudoAd, blockRedir) залишаються без змін нижче...
    public static WebResourceResponse pseudoAd(String url) {
        try {
            String mimeType = "text/plain";
            byte[] data;
            String charset = "utf-8";

            if (url.contains(".js") || url.contains("script")) {
                mimeType = "application/javascript";
                data = ";(function(){})();".getBytes(charset);
            } else if (url.contains(".css")) {
                mimeType = "text/css";
                data = "/* blocked */".getBytes(charset);
            } else if (url.contains(".html") || url.contains("iframe")) {
                mimeType = "text/html";
                data = "<html><head><meta name='robots' content='noindex'></head><body></body></html>".getBytes(charset);
            } else if (url.contains(".png")) {
                mimeType = "image/png";
                data = new byte[]{
                    (byte)0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A, 0x00, 0x00, 0x00, 0x0D, 0x49, 0x48, 0x44, 0x52,
                    0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x01, 0x08, 0x06, 0x00, 0x00, 0x00, 0x1F, 0x15, (byte)0xC4,
                    (byte)0x89, 0x00, 0x00, 0x00, 0x0A, 0x49, 0x44, 0x41, 0x54, 0x08, (byte)0xD7, 0x63, 0x60, 0x00, 0x02,
                    0x00, 0x00, 0x05, 0x00, 0x01, 0x0D, 0x26, (byte)0xE5, 0x2E, 0x00, 0x00, 0x00, 0x00, 0x49, 0x45, 0x4E, 0x44, (byte)0xAE, 0x42, 0x60, (byte)0x82
                };
            } else if (url.contains(".jpg") || url.contains(".jpeg")) {
                mimeType = "image/jpeg";
                data = new byte[]{
                    (byte)0xFF, (byte)0xD8, (byte)0xFF, (byte)0xDB, 0x00, 0x43, 0x00, 0x08, 0x06, 0x06, 0x07, 0x06, 0x05, 0x08, 0x07, 0x07, 0x07, 0x09, 0x09, 0x08, 0x0A, 0x0C, 0x14, 0x0D, 0x0C, 0x0B, 0x0B, 0x0C, 0x19, 0x12, 0x13, 0x0F,
                    0x14, 0x1D, 0x1A, 0x1F, 0x1E, 0x1D, 0x1A, 0x1C, 0x1C, 0x20, 0x24, 0x2E, 0x27, 0x20, 0x22, 0x2C, 0x23, 0x1C, 0x1C, 0x28, 0x37, 0x29, 0x2C, 0x30, 0x31, 0x34, 0x34, 0x34, 0x1F, 0x27, 0x39, 0x3D, 0x38, 0x32, 0x3C, 0x2E,
                    0x33, 0x34, 0x32, (byte)0xFF, (byte)0xC0, 0x00, 0x0B, 0x08, 0x00, 0x01, 0x00, 0x01, 0x01, 0x01, 0x11, 0x00, (byte)0xFF, (byte)0xC4, 0x00, 0x14, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                    0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte)0xFF, (byte)0xC4, 0x00, 0x14, 0x10, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte)0xFF, (byte)0xDA, 0x00, 0x08,
                    0x01, 0x01, 0x00, 0x00, 0x3F, 0x00, 0x37, (byte)0xFF, (byte)0xD9
                };
            } else if (url.contains(".svg")) {
                mimeType = "image/svg+xml";
                data = "<svg xmlns='http://www.w3.org/2000/svg' width='1' height='1'></svg>".getBytes(charset);
            } else {
                data = "<html><head><meta name='robots' content='noindex'></head><body></body></html>".getBytes(charset);
                //data = new byte[0];
            }

            java.util.Map<String, String> headers = new java.util.HashMap<>();
            headers.put("Content-Type", mimeType);
            headers.put("Access-Control-Allow-Origin", "*");
            headers.put("Cache-Control", "public, max-age=31536000");
            headers.put("X-Content-Type-Options", "nosniff");
            
            return new WebResourceResponse(
                    mimeType,
                    charset,
                    200,
                    "OK",
                    headers,
                    new ByteArrayInputStream(data)
            );
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean blockRedir() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("sf", Context.MODE_PRIVATE);
        int blockRedirect = Integer.parseInt(sharedPreferences.getString("blockredir", "0"));
        int blockAd = Integer.parseInt(sharedPreferences.getString("blockad", "0"));
        return blockRedirect == 2 || (blockRedirect == 1 && blockAd == 1);
    }
    
    public void reloadBlockedHosts() {
        loadBlockedHosts();
    }
    
    public boolean isInitialized() {
        return !complexUrlPatterns.isEmpty() || !complexDomainPatterns.isEmpty() || 
               !simpleUrlFilters.isEmpty() || !simpleDomainFilters.isEmpty();
    }
}







