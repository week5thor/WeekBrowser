package com.a525team.weekbrowser;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowInsets;

public class SafeMarginUtils {
    private static Activity activity;
    private static View targetView;
    private static int currentMode = 0; // Поточний режим (0, 1 або 2)

    public static void init(Activity activity, View targetView) {
        if (activity == null || targetView == null) return;

        SafeMarginUtils.activity = activity;
        SafeMarginUtils.targetView = targetView;

        // Встановлюємо слухач для змін Insets
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            targetView.setOnApplyWindowInsetsListener((v, insets) -> {
                boolean isKeyboardVisible = isKeyboardVisible(activity);
                setSafeMargins(activity, targetView, isKeyboardVisible);
                return insets;
            });
        }

        // Ініціалізація за замовчуванням у режимі 0
        setFullscreenMode(activity, 0);
    }

    public static void setFullscreenMode(Activity activity, int mode) {
    if (activity == null) return;

    currentMode = mode; // Зберігаємо поточний режим
    View decorView = activity.getWindow().getDecorView();

    switch (mode) {
        case 0: // Неповноекранний режим (із відступом під виріз у ландшафті)
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                // Забезпечення відступу під виріз на Android 15+
                WindowInsets windowInsets = decorView.getRootWindowInsets();
                if (windowInsets != null && activity.getResources().getConfiguration().orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE) {
                    int cutoutHeight = getTopCutoutHeight(activity);
                    targetView.setPadding(0, cutoutHeight, 0, 0);
                } else {
                    targetView.setPadding(0, 0, 0, 0);
                }
            } else {
                // Для старих версій Android виріз обробляється системою
                targetView.setPadding(0, 0, 0, 0);
            }
            break;

    /*    case 1: // Повноекранний режим із відступом під виріз
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                // Відступ під виріз на Android 15+
                WindowInsets windowInsets = decorView.getRootWindowInsets();
                if (windowInsets != null) {
                    int cutoutHeight = getTopCutoutHeight(activity);
                    targetView.setPadding(0, cutoutHeight, 0, 0);
                } else {
                    targetView.setPadding(0, 0, 0, 0);
                }
            } else {
                // Для старих версій Android виріз обробляється системою
                targetView.setPadding(0, 0, 0, 0);
            }
            break;
*/
        case 1:
        case 2: // Повноекранний режим без відступів
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            targetView.setPadding(0, 0, 0, 0);
            break;

        default:
            throw new IllegalArgumentException("Невідомий режим: " + mode);
    }

    // Оновлення відступів після зміни режиму
    boolean isKeyboardVisible = isKeyboardVisible(activity);
    setSafeMargins(activity, targetView, isKeyboardVisible);
}



        // Метод для встановлення відступів
    private static void setSafeMargins(Activity activity, View targetView, boolean isKeyboardVisible) {
        if (activity == null || targetView == null) return;

        // Отримуємо конфігурацію екрану (орієнтація)
        boolean isLandscape = activity.getResources().getConfiguration().orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE;

        // Якщо ми в повноекранному режимі 2, не додаємо жодних відступів
        if (currentMode == 2) {
            targetView.setPadding(0, 0, 0, 0);
            return;
        }

        // Використовуємо WindowInsets для точного отримання відступів
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            WindowInsets windowInsets = targetView.getRootWindowInsets();
            if (windowInsets != null) {
                int topInset = windowInsets.getInsets(WindowInsets.Type.systemBars()).top;
                int bottomInset = isKeyboardVisible ? getKeyboardHeight(activity) : windowInsets.getInsets(WindowInsets.Type.systemBars()).bottom;

                // У ландшафтному режимі коригуємо відступи
          //      if (isLandscape) {
          //          int screenHeight = activity.getWindowManager().getDefaultDisplay().getHeight();
          //          topInset = Math.max(topInset, screenHeight / 10); // Встановлюємо відступ на 10% від висоти екрану
          //          bottomInset = Math.max(bottomInset, screenHeight / 10);
          //      }

                // Встановлюємо відступи
                targetView.setPadding(0, topInset, 0, bottomInset);
            }
        } else {
            // Для старих версій Android використовуємо WindowManager для визначення розміру екрана
            Display display = activity.getWindowManager().getDefaultDisplay();
            int screenHeight = display.getHeight();
            int screenWidth = display.getWidth();

            // Якщо орієнтація ландшафтна
            if (isLandscape) {
                int systemBarsHeight = screenHeight - getVisibleFrameHeight(activity);
                int bottomMargin = Math.max(systemBarsHeight, screenHeight / 10);
                targetView.setPadding(0, 0, 0, bottomMargin);
            } else {
                int bottomMargin = isKeyboardVisible&&Build.VERSION.SDK_INT >= 35 ? getKeyboardHeight(activity) : screenHeight - getVisibleFrameHeight(activity);
                targetView.setPadding(0, 0, 0, bottomMargin);
            }
        }

        targetView.requestLayout();
    }

    // Отримуємо висоту видимого фрейму для визначення нижнього відступу
    private static int getVisibleFrameHeight(Activity activity) {
        Rect visibleFrame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(visibleFrame);
        return visibleFrame.bottom;
    }

    // Отримуємо висоту клавіатури
    private static int getKeyboardHeight(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int screenHeight = activity.getWindowManager().getDefaultDisplay().getHeight();
        return screenHeight - rect.bottom;
    }

    // Метод для оновлення режиму
    public static void setMode(int mode) {
        currentMode = mode;
    }


    public static boolean isKeyboardVisible(Activity activity) {
    if (activity == null) return false;

    Rect visibleFrame = new Rect();
    activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(visibleFrame);

    // Отримуємо висоту дисплея з урахуванням конфігурації орієнтації
    Display display = activity.getWindowManager().getDefaultDisplay();
    int realHeight;
    int realWidth;

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        android.util.DisplayMetrics metrics = new android.util.DisplayMetrics();
        activity.getDisplay().getRealMetrics(metrics);
        realHeight = metrics.heightPixels;
        realWidth = metrics.heightPixels;
    } else {
        android.util.DisplayMetrics metrics = new android.util.DisplayMetrics();
        display.getRealMetrics(metrics);
        realHeight = metrics.heightPixels;
        realWidth = metrics.heightPixels;
    }

    // Визначаємо фактичну висоту для розрахунків залежно від орієнтації
    int screenHeight = activity.getResources().getConfiguration().orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE
            ? realWidth
            : realHeight;

    int heightDifference = screenHeight - visibleFrame.height();

    // Поріг для визначення клавіатури
    double threshold = screenHeight * 0.15;
    return heightDifference > threshold;
}


    /**
     * Публічний метод для отримання розміру верхнього вирізу екрана.
     * @return розмір верхнього вирізу (в пікселях).
     */
    public static int getTopCutoutHeight(Activity activity) {
        if (activity == null) return 0;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            WindowInsets windowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            if (windowInsets != null && windowInsets.getDisplayCutout() != null) {
                return windowInsets.getDisplayCutout().getSafeInsetTop();
            }
        }

        // Якщо виріз не підтримується, повертаємо 0
        return 0;
    }
}
