package com.a525team.weekbrowser;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class BitmapEncoderDecoder {

    /**
     * Метод для кодування Bitmap у Base64
     *
     * @param bitmap Bitmap, який потрібно закодувати
     * @return Строка Base64 або null, якщо bitmap == null
     */
    public static String encodeToBase64(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // Стиснення Bitmap у формат PNG (можна використовувати JPEG)
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        byte[] byteArray = outputStream.toByteArray();
        // Кодування в Base64
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    /**
     * Метод для розкодування Base64 у Bitmap
     *
     * @param base64String Строка Base64
     * @return Об'єкт Bitmap або null, якщо рядок некоректний
     */
    public static Bitmap decodeFromBase64(String base64String) {
        if (base64String == null || base64String.isEmpty()) {
            return null;
        }
        try {
            byte[] decodedBytes = Base64.decode(base64String, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }
}
