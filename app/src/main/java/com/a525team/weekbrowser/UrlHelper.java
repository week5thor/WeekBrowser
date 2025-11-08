package com.a525team.weekbrowser;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlHelper {

    /**
     * Розкодовує URL та замінює пробіли на +
     */
    public static String decode(String url) {
        if (url == null || url.isEmpty()) return url;
        
        try {
            // Розкодовуємо URL (кирилиця стане читабельною, пробіли будуть як звичайні пробіли)
            String decoded = URLDecoder.decode(url, "UTF-8");
            
            // Замінюємо всі пробіли на +
            return decoded.replace(" ", "+");
            
        } catch (UnsupportedEncodingException e) {
            return url;
        }
    }

    /**
     * Кодує URL (пробіли стають +)
     */
    public static String encode(String text) {
        if (text == null || text.isEmpty()) return text;
        try {
            return URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return text;
        }
    }
}