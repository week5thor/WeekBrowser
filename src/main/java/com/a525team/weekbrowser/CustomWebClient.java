package com.a525team.weekbrowser;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.graphics.Typeface;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.Manifest;
import android.content.pm.PackageManager;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import java.util.Arrays;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.List;
import java.util.Arrays;


public class CustomWebClient extends WebChromeClient {
    private Skin skin = new Skin();
    private View mCustomView;
    private CustomViewCallback mCustomViewCallback;
    private int mOriginalOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
    private int mOriginalSystemUiVisibility;
    private Activity activity;
    private boolean bml = false;
    private WindowManager.LayoutParams params;
    private WindowManager wm;
    private FrameLayout container;
    private Button toggleButton;
    private boolean isHidden = false;
    private int lx;
    private int ly;
    private boolean moved = false;
    private int statusBarHeight;
    private ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
    private PermissionRequest pendingRequest;

    private static final int[][] SIZES = {
        {50, 28},
        {67, 38},
        {85, 48},
        {100, 56},
        {18, 33},
        {28, 50},
        {38, 67},
        {48, 85},
        {56, 100},
        {33, 18}
    };
    private int currentSizeIndex = 0;

    private static final int REQUEST_CODE_OVERLAY_PERMISSION = 1001;

    public CustomWebClient(Activity activity) {
        this.activity = activity;
        this.statusBarHeight = getStatusBarHeight(activity.getApplicationContext());
    }

    @Override
    public void onShowCustomView(View paramView, CustomViewCallback viewCallback) {
        if (mCustomView != null) {
            onHideCustomView();
            return;
        }

        mCustomView = paramView;
        mOriginalSystemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();

        showModeSelectionDialog(paramView, viewCallback);
    }

    private void showModeSelectionDialog(final View paramView, final CustomViewCallback viewCallback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(activity.getString(R.string.choosemode))
               .setItems(new CharSequence[]{activity.getString(R.string.fullscreen), activity.getString(R.string.overlay)},
                          new DialogInterface.OnClickListener() {
                              @Override
                              public void onClick(DialogInterface dialog, int which) {
                                  switch (which) {
                                      case 0: // Звичайний повноекранний режим
                                          enterFullScreenMode(paramView, viewCallback);
                                          break;
                                      case 1: // Поверх інших вікон
                                          if (!checkOverlayPermission()) {
                                              requestOverlayPermission();
                                          } else {
                                              enterOverlayMode(paramView, viewCallback);
                                          }
                                          break;
                                  }
                              }
                          });
        builder.setCancelable(false).create().show();
    }

    private void enterFullScreenMode(View paramView, CustomViewCallback viewCallback) {
        ((MainActivity) activity)._statushs(true);

        FrameLayout decor = (FrameLayout) activity.getWindow().getDecorView();
        decor.addView(paramView, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        mCustomViewCallback = viewCallback;
    }

    private void enterOverlayMode(View paramView, CustomViewCallback viewCallback) {
        DisplayMetrics metrics = activity.getResources().getDisplayMetrics();
        final int maxsize = Math.min(metrics.widthPixels - statusBarHeight, metrics.heightPixels);

        container = new FrameLayout(activity);
        FrameLayout.LayoutParams containerParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        containerParams.topMargin = (int) (30 * activity.getResources().getDisplayMetrics().density);
        containerParams.bottomMargin = (int) (1 * activity.getResources().getDisplayMetrics().density);
        containerParams.leftMargin = (int) (1 * activity.getResources().getDisplayMetrics().density);
        containerParams.rightMargin = (int) (1 * activity.getResources().getDisplayMetrics().density);
        container.addView(paramView, containerParams);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            params = new WindowManager.LayoutParams(
                    (int) (SIZES[currentSizeIndex][0] * maxsize / 100f),
                    (int) (SIZES[currentSizeIndex][1] * maxsize / 100f),
                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                    WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH |
                    WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                    WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR |
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    PixelFormat.TRANSLUCENT);
        } else {
            params = new WindowManager.LayoutParams(
                    (int) (SIZES[currentSizeIndex][0] * maxsize / 100f),
                    (int) (SIZES[currentSizeIndex][1] * maxsize / 100f),
                    WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                    WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH |
                    WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                    WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR |
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    PixelFormat.TRANSLUCENT);
        }
params.gravity = Gravity.TOP | Gravity.START;
params.y = statusBarHeight;
        wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        wm.addView(container, params);

        container.setOnTouchListener(new View.OnTouchListener() {
            private float initialTouchX;
            private float initialTouchY;
            private int initialX;
            private int initialY;
            private long lastTouchTime = 0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                moved = false;

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        lastTouchTime = System.currentTimeMillis();
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);
                        if (params.y < statusBarHeight) {
                            params.y = statusBarHeight;
                        }
    wm.updateViewLayout(container, params);
                        return true;
                    case MotionEvent.ACTION_UP:
                        if (params.x < lx - 2 || params.x > lx + 2 || params.y < ly - 2 || params.y > ly + 2) {
                            moved = true;
                        }
                        lx = params.x;
                        ly = params.y;

                        if (!moved) {
                            if (System.currentTimeMillis() - lastTouchTime < 200) {
                                currentSizeIndex = (currentSizeIndex + 1) % SIZES.length;
                                params.width = (int) (SIZES[currentSizeIndex][0] * maxsize / 100f);
                                params.height = (int) (SIZES[currentSizeIndex][1] * maxsize / 100f);
                                if (params.y < statusBarHeight) {
                            params.y = statusBarHeight;
                        }
                                updateView();
                            } else {
                                hideWindow();
                            }
                            return true;
                        }
                }
                return false;
            }
        });

        skin.setBG(container, 0, false);

        toggleButton = new Button(activity);
        toggleButton.setTypeface(Typeface.createFromAsset(activity.getAssets(), "fonts/icons.ttf"), 0);
        toggleButton.setText("");
        toggleButton.setVisibility(View.GONE);
        skin.setBG(toggleButton, 1, true);
        toggleButton.setTextColor((int) Long.parseLong(dataHolder.getData("rbt"), 16));
        WindowManager.LayoutParams buttonParams = new WindowManager.LayoutParams(
                (int) (40 * activity.getResources().getDisplayMetrics().density),
                (int) (50 * activity.getResources().getDisplayMetrics().density),
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ? WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY : WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH |
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        buttonParams.gravity = Gravity.RIGHT | Gravity.TOP;
        buttonParams.y = (int) (50 * activity.getResources().getDisplayMetrics().density);
        wm.addView(toggleButton, buttonParams);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWindow();
            }
        });

        mCustomViewCallback = viewCallback;
    }

    @Override
    public void onHideCustomView() {
        FrameLayout decor = (FrameLayout) activity.getWindow().getDecorView();
        decor.removeView(mCustomView);
        if (mCustomView == null) {
            return;
        }
        try {
            if (container != null) {
                wm.removeViewImmediate(container);
            }
            if (toggleButton != null) {
                wm.removeViewImmediate(toggleButton);
            }
        } catch (Exception e) {
            // Handle exception
        }
        mCustomView = null;

        ((MainActivity) activity)._statushs(false);
        activity.getWindow().getDecorView().setSystemUiVisibility(mOriginalSystemUiVisibility);

        if (mCustomViewCallback != null) {
            mCustomViewCallback.onCustomViewHidden();
            mCustomViewCallback = null;
        }
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);

        ((MainActivity) activity)._progresser(view, newProgress);
        if (newProgress >= 11 && newProgress <= 100 && !bml) {
            ((MainActivity) activity)._prog11(view);
            bml = true;
        } else {
            bml = false;
        }
    }

    private void hideWindow() {
        
        params.width = 1;
        params.height = 1;
        params.x = 99999;
        params.y = 99999;
        container.setBackgroundColor(0x00000000);
        updateView();
        toggleButton.setVisibility(View.VISIBLE);
        isHidden = true;
    }

    private void showWindow() {
        DisplayMetrics metrics = activity.getResources().getDisplayMetrics();
        final int maxsize = Math.min(metrics.widthPixels - statusBarHeight, metrics.heightPixels);
        currentSizeIndex = (currentSizeIndex) % SIZES.length;
        params.width = (int) (SIZES[currentSizeIndex][0] * maxsize / 100f);
        params.height = (int) (SIZES[currentSizeIndex][1] * maxsize / 100f);
        params.x = lx;
        params.y = ly;
        skin.setBG(container, 0, false);
        updateView();
        toggleButton.setVisibility(View.GONE);
        isHidden = false;
    }

    public boolean checkOverlayPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return Settings.canDrawOverlays(activity);
        }
        return true;
    }

    public void requestOverlayPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + activity.getPackageName()));
            activity.startActivityForResult(intent, REQUEST_CODE_OVERLAY_PERMISSION);
        }
    }

    public int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    
        @Override public void onConsoleMessage(String message, int lineNumber, String sourceID) {
            SharedPreferences sf = activity.getSharedPreferences("sf", Context.MODE_PRIVATE);
            if(sf.getString("jslog", "").equals("1")){
        String fileCont = FileUtil.readFile("/storage/emulated/0/WeekBrowser/dev/JavaScriptLog.txt");
        FileUtil.writeFile("/storage/emulated/0/WeekBrowser/dev/JavaScriptLog.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/dev/JavaScriptLog.txt") + sourceID + ":" + lineNumber + ": " + message + "\n\n════════════════\n\n");}
    }


public void updateView() {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
        wm.updateViewLayout(container, params);
    } else {
        wm.updateViewLayout(container, params);
    }

    // Якщо контейнер змінився, оновимо його
    container.post(new Runnable() {
        @Override
        public void run() {
            container.forceLayout();
        }
    });
}

    @Override
    public void onGeolocationPermissionsShowPrompt(final String origin, final GeolocationPermissions.Callback callback) {
        callback.invoke(origin, true, false);
    }
    //////

@Override
public void onPermissionRequest(final PermissionRequest request) {
    List<String> resources = Arrays.asList((String[]) request.getResources()); // Перетворення в List<String>
    
    if (resources.contains(PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
        showPermissionDialog("Дозволити сайту використовувати мікрофон?", 
                             () -> requestAudioPermission(request), 
                             request::deny);
    } else if (resources.contains(PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
        showPermissionDialog("Дозволити сайту використовувати камеру?", 
                             () -> requestCameraPermission(request), 
                             request::deny);
    } else if (resources.contains(PermissionRequest.RESOURCE_PROTECTED_MEDIA_ID)) {
        showPermissionDialog("Дозволити сайту використовувати захищені медіа-ресурси?", 
                             () -> request.grant(new String[]{PermissionRequest.RESOURCE_PROTECTED_MEDIA_ID}), 
                             request::deny);
    } else {
        request.grant(request.getResources()); // Якщо це інші ресурси, просто надаємо доступ
    }
}

private void requestCameraPermission(final PermissionRequest request) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (activity.checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            pendingRequest = request;
            activity.requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
            return;
        }
    }
    request.grant(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE});
}

private void requestAudioPermission(final PermissionRequest request) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (activity.checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            pendingRequest = request;
            activity.requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 2);
            return;
        }
    }
    request.grant(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE});
}

private void showPermissionDialog(String message, Runnable onAccept, Runnable onDecline) {
    new AlertDialog.Builder(activity)
            .setMessage(message)
            .setPositiveButton("Дозволити", (dialog, which) -> onAccept.run())
            .setNegativeButton("Відхилити", (dialog, which) -> onDecline.run())
            .show();
}


//////


}
