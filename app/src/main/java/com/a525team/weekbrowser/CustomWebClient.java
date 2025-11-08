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
//import android.os.Build;
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
import android.widget.LinearLayout;
import android.widget.TextView;
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
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.EditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.webkit.JsResult;
import android.webkit.JsPromptResult;
import android.view.Window;

public class CustomWebClient extends WebChromeClient {
	private Skin skin = new Skin();
	private View mCustomView;
	private CustomViewCallback mCustomViewCallback;
	private int mOriginalOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
	private int mOriginalSystemUiVisibility;
	private Activity activity;
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
	private boolean bml = false;
    RenderUtils ru;
    private ExtensionUtil extensionUtil;
	//String fakefson = "javascript:(function(){try{Object.defineProperty(document,'fullscreenElement',{configurable:true,get:()=>document.body});Object.defineProperty(document,'fullscreenEnabled',{configurable:true,get:()=>true});Object.defineProperty(screen,'height',{configurable:true,get:()=>window.innerHeight});Object.defineProperty(screen,'availHeight',{configurable:true,get:()=>window.innerHeight});if(window.visualViewport){Object.defineProperty(window.visualViewport,'height',{configurable:true,get:()=>window.innerHeight});}document.dispatchEvent(new Event('fullscreenchange'));console.log('[FakeFS] Увімкнено');}catch(e){console.error('[FakeFS] Помилка:',e);}})();";
   // String fakefsoff = "javascript:(function(){try{delete document.fullscreenElement;delete document.fullscreenEnabled;delete screen.height;delete screen.availHeight;if(window.visualViewport){delete window.visualViewport.height;}document.dispatchEvent(new Event('fullscreenchange'));console.log('[FakeFS] Вимкнено');}catch(e){console.error('[FakeFS] Помилка:',e);}})();";
	private static final int[][] SIZES = {
		{100, 56},
		{38, 67},
		{48, 85},
		{56, 100},
		{50, 28},
		{67, 38},
		{85, 48}
	};
	private int currentSizeIndex = 0;
	
	private static final int REQUEST_CODE_OVERLAY_PERMISSION = 1001;
	
	public CustomWebClient(Activity activity) {
        ru = new RenderUtils(activity);
		this.activity = activity;
        this.extensionUtil = ExtensionUtil.getInstance(this.activity);
		if(activity!=null)
		this.statusBarHeight = getStatusBarHeight(activity.getApplicationContext());
	}
	
    @Override
public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
    TextView messageView = new TextView(activity);
    messageView.setText(message);
    messageView.setTextIsSelectable(true);
    int padding = (int) (16 * activity.getResources().getDisplayMetrics().density);
    messageView.setPadding(padding, padding, padding, padding);

    AlertDialog.Builder i = new AlertDialog.Builder(activity)
        .setTitle("!")
        .setView(messageView) // замість setMessage
        .setPositiveButton(activity.getString(R.string.ok), (dialog, which) -> result.confirm())
        .setOnCancelListener(dialog -> result.cancel());

    AlertDialog dialog2 = i.create();
    dialog2.setOnDismissListener(d -> ru.off());
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
    return true;
}

@Override
public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
    TextView messageView = new TextView(activity);
    messageView.setText(message);
    messageView.setTextIsSelectable(true);
    int padding = (int) (16 * activity.getResources().getDisplayMetrics().density);
    messageView.setPadding(padding, padding, padding, padding);

    AlertDialog.Builder i = new AlertDialog.Builder(activity)
        .setTitle("?")
        .setView(messageView) // замість setMessage
        .setPositiveButton(activity.getString(R.string.yes), (dialog, which) -> result.confirm())
        .setNegativeButton(activity.getString(R.string.no), (dialog, which) -> result.cancel())
        .setOnCancelListener(dialog -> result.cancel());

    AlertDialog dialog2 = i.create();
    dialog2.setOnDismissListener(d -> ru.off());
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
    return true;
}

@Override
public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, final JsPromptResult result) {
    final EditText input = new EditText(activity);
    input.setText(defaultValue);

    TextView messageView = new TextView(activity);
    messageView.setText(message);
    messageView.setTextIsSelectable(true);
    int padding = (int) (16 * activity.getResources().getDisplayMetrics().density);
    messageView.setPadding(padding, padding, padding, padding);

    // В контейнері LinearLayout розмістимо і повідомлення, і поле вводу
    LinearLayout layout = new LinearLayout(activity);
    layout.setOrientation(LinearLayout.VERTICAL);
    layout.addView(messageView);
    layout.addView(input);

    AlertDialog.Builder i = new AlertDialog.Builder(activity)
        .setTitle("T_")
        .setView(layout)
        .setPositiveButton(activity.getString(R.string.ok), (dialog, which) -> result.confirm(input.getText().toString()))
        .setNegativeButton(activity.getString(R.string.cancel), (dialog, which) -> result.cancel())
        .setOnCancelListener(dialog -> result.cancel());

    AlertDialog dialog2 = i.create();
    dialog2.setOnDismissListener(d -> ru.off());
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
    return true;
}

    
	@Override
	public void onShowCustomView(View paramView, CustomViewCallback viewCallback) {
		if (mCustomView != null) {
			onHideCustomView();
			return;
		}
		
		mCustomView = paramView;
		if(activity!=null)
		mOriginalSystemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
		
		showModeSelectionDialog(paramView, viewCallback);
	}
	
	private void showModeSelectionDialog(final View paramView, final CustomViewCallback viewCallback) {
		if(activity!=null){
			AlertDialog.Builder builder = new AlertDialog.Builder(activity);
			builder.setTitle(activity.getString(R.string.choosemode))
			.setItems(new CharSequence[]{activity.getString(R.string.fullscreen), activity.getString(R.string.overlay)},
			new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					switch (which) {
						case 0: // Звичайний повноекранний режим
						//super.onShowCustomView(paramView, viewCallback);
						enterFullScreenMode(paramView, viewCallback);
						break;
						case 1: // Поверх інших вікон
						if (!checkOverlayPermission()) {
							requestOverlayPermission();
						} else {
							//super.onShowCustomView(paramView, viewCallback);
							enterOverlayMode(paramView, viewCallback);
						}
						break;
					}
				}
			});
			builder.setCancelable(false);
            AlertDialog dialog2 = builder.create();
    dialog2.setOnDismissListener(d -> ru.off());
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
	
	private void enterFullScreenMode(View paramView, CustomViewCallback viewCallback) {
		if(activity!=null){
			SafeMarginUtils.setFullscreenMode(activity, 2);
			
			FrameLayout decor = (FrameLayout) activity.getWindow().getDecorView();
			decor.addView(paramView, new FrameLayout.LayoutParams(
			ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
			
			mCustomViewCallback = viewCallback;
		}
	}
	
	private void enterOverlayMode(View paramView, CustomViewCallback viewCallback) {
    if (activity != null) {
      //  ((MainActivity) activity)._webViewActions(10d, fakefson); // запуск fakeFS

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
        paramView.requestFocus();

        if (WTF.SDK_INT() >= 26) {
            params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED |
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH |
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        } else {
            params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED |
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH |
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        }

        params.gravity = Gravity.TOP | Gravity.START;
        params.y = 0; // для fullscreen
        wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        wm.addView(container, params);

        // Зберігаємо розміри для повернення
        final int normalWidth = (int) (SIZES[currentSizeIndex][0] * maxsize / 100f);
        final int normalHeight = (int) (SIZES[currentSizeIndex][1] * maxsize / 100f);
        final int normalY = statusBarHeight;

        // Повернення до нормального розміру через 500 мс
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    params.width = normalWidth;
                    params.height = normalHeight;
                    params.y = normalY;
                    wm.updateViewLayout(container, params);
                } catch (Exception e) {
                    Log.e("FakeFS", "updateViewLayout (normal) failed: " + e.toString());
                }
            }
        }, 200);

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
            WTF.SDK_INT() >= 26 ? WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY : WindowManager.LayoutParams.TYPE_PHONE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
            WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED |
            WindowManager.LayoutParams.FLAG_SECURE,
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
}

	
	@Override
	public void onHideCustomView() {
		if(activity!=null){
          //  ((MainActivity)activity)._webViewActions(10d, fakefsoff);
			super.onHideCustomView();
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
			
			SafeMarginUtils.setFullscreenMode(activity, 0);
			activity.getWindow().getDecorView().setSystemUiVisibility(mOriginalSystemUiVisibility);
			
			if (mCustomViewCallback != null) {
				mCustomViewCallback.onCustomViewHidden();
				mCustomViewCallback = null;
			}
		}
	}
	
	@Override
	public void onProgressChanged(WebView view, int newProgress) {
		if(activity!=null){
			super.onProgressChanged(view, newProgress);
			((MainActivity) activity)._progresser(view, newProgress);
			if (newProgress >= 11 && newProgress <= 100) {
				if(!bml){((MainActivity) activity)._prog11(view);
                    if(newProgress == 100){
                        if (activity instanceof MainActivity) {
			((MainActivity) activity)._prog100(view);
		}
                    if (extensionUtil != null) {
			extensionUtil.onProgress100(view);
					}
                    
                    }
					bml = true;}
			} else {
				bml = false;
			}
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
		if(activity!=null){
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
	}
	
	public boolean checkOverlayPermission() {
		if(activity!=null){
			if (WTF.SDK_INT() >= 23) {
				return Settings.canDrawOverlays(activity);
			}
			return true;
		} else return true;
	}
	
	public void requestOverlayPermission() {
		if(activity!=null){
			if (WTF.SDK_INT() >= 23) {
				Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + activity.getPackageName()));
				activity.startActivityForResult(intent, REQUEST_CODE_OVERLAY_PERMISSION);
			}
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
		if(activity!=null){
			SharedPreferences sf = activity.getSharedPreferences("sf", Context.MODE_PRIVATE);
			if(sf.getString("jslog", "").equals("1")){
				String fileCont = FileUtil.readFile("/storage/emulated/0/WeekBrowser/dev/JavaScriptLog.txt");
				FileUtil.writeFile("/storage/emulated/0/WeekBrowser/dev/JavaScriptLog.txt", FileUtil.readFile("/storage/emulated/0/WeekBrowser/dev/JavaScriptLog.txt") + "ID = " + sourceID + "\nLine: " + lineNumber + "\nMessage: " + message + "\n\n════════════════\n\n");}
		}
	}
	
	
	public void updateView() {
		if (WTF.SDK_INT() < 26) {
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
		if(activity!=null){
			showPermissionDialog(
			activity.getString(R.string.allowgeo), 
			() -> callback.invoke(origin, true, true), 
			() -> callback.invoke(origin, false, false)
			);
		}
	}
	
	//////
	
	@Override
	public void onPermissionRequest(final PermissionRequest request) {
		if(activity!=null){
			List<String> resources = Arrays.asList((String[]) request.getResources()); // Перетворення в List<String>
			
			if (resources.contains(PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
				showPermissionDialog(activity.getString(R.string.allowmic), 
				() -> requestAudioPermission(request), 
				request::deny);
			} else if (resources.contains(PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
				showPermissionDialog(activity.getString(R.string.allowcam), 
				() -> requestCameraPermission(request), 
				request::deny);
			} else if (resources.contains(PermissionRequest.RESOURCE_PROTECTED_MEDIA_ID)) {
				showPermissionDialog(activity.getString(R.string.allowpmr), 
				() -> request.grant(new String[]{PermissionRequest.RESOURCE_PROTECTED_MEDIA_ID}), 
				request::deny);
			} else if (resources.contains(PermissionRequest.RESOURCE_MIDI_SYSEX)) {
				showPermissionDialog(activity.getString(R.string.allowmidi), 
				() -> request.grant(new String[]{PermissionRequest.RESOURCE_MIDI_SYSEX}), 
				request::deny);
			} else {
				request.grant(request.getResources()); // Якщо це інші ресурси, просто надаємо доступ
			}
		}
	}
	
	private void requestCameraPermission(final PermissionRequest request) {
		if(activity!=null){
			if (WTF.SDK_INT() >= 23) {
				if (activity.checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
					pendingRequest = request;
					activity.requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
					return;
				}
			}
			request.grant(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE});
		}
	}
	
	private void requestAudioPermission(final PermissionRequest request) {
		if(activity!=null){
			if (WTF.SDK_INT() >= 23) {
				if (activity.checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
					pendingRequest = request; // Зберігаємо запит
					activity.requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 2);
					return;
				}
			}
			// Якщо дозвіл вже є - одразу надаємо
			request.grant(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE});
		}
	}
	
	private void showPermissionDialog(String message, Runnable onAccept, Runnable onDecline) {
		if(activity!=null){
			AlertDialog.Builder i = new AlertDialog.Builder(activity)
			.setMessage(message)
			.setPositiveButton(activity.getString(R.string.yes), (dialog, which) -> onAccept.run())
			.setNegativeButton(activity.getString(R.string.no), (dialog, which) -> onDecline.run());
            
            AlertDialog dialog2 = i.create();
    dialog2.setOnDismissListener(d -> ru.off());
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
	
	
	//////
	
	
}

