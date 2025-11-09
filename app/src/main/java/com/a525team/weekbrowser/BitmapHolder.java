package com.a525team.weekbrowser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;

public class BitmapHolder {
    private static final int MAX_CACHE_SIZE = 1024 * 1024 * 1024; // 1 ГБ кешу
    private static final LruCache<String, BitmapDrawable> bitmapCache = new LruCache<String, BitmapDrawable>(MAX_CACHE_SIZE) {
        @Override
        protected int sizeOf(String key, BitmapDrawable value) {
            return value.getBitmap().getByteCount();
        }
    };

    private BitmapHolder() {
        // Приватний конструктор
    }

    public static BitmapDrawable getBitmapDrawable(String key) {
        return bitmapCache.get(key);
    }

    public static void putBitmapDrawable(String key, BitmapDrawable drawable) {
        if (drawable != null && drawable.getBitmap() != null) {
            bitmapCache.put(key, drawable);
           // SketchwareUtil.showMessage(SketcApplication.getContext(), "Bitmap size: " + drawable.getBitmap().getWidth() + "x" + drawable.getBitmap().getHeight());
        }
    }

    public static BitmapDrawable createBitmapDrawable(Bitmap bitmap) {
        if (bitmap == null) return null;
        
        Context context = SketcApplication.getContext();
        if (context == null) return null;
        
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static BitmapDrawable createFromDrawable(Drawable drawable) {
        if (drawable == null) return null;
        
        if (drawable instanceof BitmapDrawable) {
            return (BitmapDrawable) drawable;
        }

        Bitmap bitmap = Bitmap.createBitmap(
            drawable.getIntrinsicWidth(),
            drawable.getIntrinsicHeight(),
            Bitmap.Config.ARGB_8888
        );
        
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        
        return createBitmapDrawable(bitmap);
    }

    public static void clearCache() {
        bitmapCache.evictAll();
    }
}