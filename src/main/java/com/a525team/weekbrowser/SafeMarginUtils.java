package com.a525team.weekbrowser;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.graphics.Point;
import java.lang.ref.WeakReference;
import android.graphics.Color;
import android.view.Window;
import android.view.WindowManager;
import android.content.SharedPreferences;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

//import java.lang.reflect.Method;

public class SafeMarginUtils {
	private static WeakReference<Activity> activityRef;
	private static WeakReference<View> targetViewRef;
	private static int currentMode = 0;
	private static final Rect tmpRect = new Rect();
	private static int StatusColor;
	private static int NavColor;
	private static int hardAccel;
	private static final int sdk = WTF.SDK_INT();
	// Ініціалізація
	public static void init(Activity activity, View targetView) {
		Skin skin = new Skin();
		StatusColor = skin.StatusCol();
		NavColor = skin.NavCol();
		cleanup();
		activityRef = new WeakReference<>(activity);
		targetViewRef = new WeakReference<>(targetView);
		
		if (sdk >= 21) {
			targetView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
        @Override
        public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
            applyInsets(insets);
            return insets;
        }
    });
		}
		
		if (sdk >= 28 && sdk < 35) {
			Window window = activity.getWindow();
			WindowManager.LayoutParams attributes = window.getAttributes();
			attributes.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
			window.setAttributes(attributes);
		}
		
		if (sdk >= 35) {
			WindowInsets insets = targetView.getRootWindowInsets();
			if (insets != null) applyInsets(insets);
		}
		currentMode = 0;
		setFullscreenMode(activity, currentMode);
		
		boolean h = activity.getSharedPreferences("sf", Context.MODE_PRIVATE)
		.getString("hardware", "1").equals("1");
		
		if(h){
			activity.getWindow().setFlags(
			WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
			WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED
			);
			activity.findViewById(android.R.id.content).setLayerType(View.LAYER_TYPE_HARDWARE, null);
		} else {
			
			activity.getWindow().setFlags(0, WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
			activity.findViewById(android.R.id.content).setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		}
		
		
		
	}
	
	// Очищення ресурсів
	public static void cleanup() {
		if (targetViewRef != null && targetViewRef.get() != null) {
			if (sdk >= 21) {
				targetViewRef.get().setOnApplyWindowInsetsListener(null);
			}
		}
		activityRef = null;
		targetViewRef = null;
	}
	
	public static int getFullscreenMode() {
		return currentMode;
	}
	
	// Режими повноекранності
	public static void setFullscreenMode(Activity activity, int mode) {
		Activity act = activityRef != null ? activityRef.get() : activity;
		if (act == null || act.isFinishing()) return;
		
		currentMode = mode;
		Window win = act.getWindow();
		View decorView = win.getDecorView();
		int flags = decorView.getSystemUiVisibility();
		
		/*		// Очищення старих прапорців
		flags &= ~(View.SYSTEM_UI_FLAG_FULLSCREEN
		| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
		| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
		| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
		| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
		| View.SYSTEM_UI_FLAG_LOW_PROFILE
		| View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		
		if (sdk >= Build.VERSION_CODES.O) {
		flags &= ~View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
		}
		*/
		flags = 0;
		
		if (sdk >= 19) {
			    // Обробка для API 19+
			    switch (mode) {
				        case 0:
				            flags |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
				            break;
				        case 1:
				            flags |= View.SYSTEM_UI_FLAG_FULLSCREEN
				                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
				                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
				            break;
				        case 2:
				            flags |= View.SYSTEM_UI_FLAG_FULLSCREEN
				                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
				                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
				                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
				                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
				            break;
				    }
		} else {
			    // Для старих версій завжди використовуємо стабільний режим
			    flags |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
		}
		
		try{
			win.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			if (sdk >= 35) {
				win.setStatusBarColor(Color.TRANSPARENT);
				win.setNavigationBarColor(Color.TRANSPARENT);
			} else {
				if (sdk >= 23) {
					if (ThemeManager.getLight()) {
						flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
					}
					win.setStatusBarColor(StatusColor);
				}else win.setStatusBarColor(Color.parseColor("#000000"));
				
				if (sdk >= 26) {
					if (ThemeManager.getLight()) {
						flags |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
					}
					win.setNavigationBarColor(NavColor);
				}else win.setNavigationBarColor(Color.parseColor("#000000"));
			}	
		}catch(Throwable t){}
		
		decorView.setSystemUiVisibility(flags);
		
		try{
			if (sdk >= 35) {
				applyInsets(decorView.getRootWindowInsets());
			}}catch(Throwable t){}
	}
	
	private static void applyInsets(WindowInsets insets) {
		if (sdk >= 35){
			Activity activity = activityRef != null ? activityRef.get() : null;
			View targetView = targetViewRef != null ? targetViewRef.get() : null;
			if (activity == null || targetView == null || insets == null) return;
			
			int left = 0, top = 0, right = 0, bottom = 0;
			
			if (currentMode != 2) {
				//   if (sdk >= Build.VERSION_CODES.P) {
				DisplayCutout cutout = insets.getDisplayCutout();
				if (cutout != null) {
					left = cutout.getSafeInsetLeft();
					top = cutout.getSafeInsetTop();
					right = cutout.getSafeInsetRight();
					bottom = cutout.getSafeInsetBottom();
				}
				//    }
				
				//    if (sdk >= Build.VERSION_CODES.R) {
				android.graphics.Insets systemBars = insets.getInsets(WindowInsets.Type.systemBars());
				left = Math.max(left, systemBars.left);
				top = Math.max(top, systemBars.top);
				right = Math.max(right, systemBars.right);
				bottom = Math.max(bottom, systemBars.bottom);
				//    } else {
				//        top = Math.max(top, getStatusBarHeight(activity));
				//        bottom = Math.max(bottom, getNavigationBarHeight(activity));
				//    }
			}
			
			if (isKeyboardVisible()) bottom = getKeyboardHeight(activity);
			targetView.setPadding(left, top, right, bottom);}
	}
	
	public static boolean isKeyboardVisible() {
		Activity activity = activityRef != null ? activityRef.get() : null;
		if (activity == null) return false;
		
		Rect visibleFrame = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(visibleFrame);
		int heightDifference = getScreenHeight(activity) - visibleFrame.bottom;
		return heightDifference > getScreenHeight(activity) * 0.2;
	}
	
	private static int getStatusBarHeight(Activity activity) {
		int resId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
		return resId > 0 ? activity.getResources().getDimensionPixelSize(resId) : 0;
	}
	
	private static int getNavigationBarHeight(Activity activity) {
		int resId = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
		return resId > 0 ? activity.getResources().getDimensionPixelSize(resId) : 0;
	}
	
	private static int getScreenHeight(Activity activity) {
		if (sdk >= 30) {
			return activity.getWindowManager().getCurrentWindowMetrics().getBounds().height();
		} else {
			Point size = new Point();
			activity.getWindowManager().getDefaultDisplay().getRealSize(size);
			return size.y;
		}
	}
	
	private static int getKeyboardHeight(Activity activity) {
		Rect rect = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
		return getScreenHeight(activity) - rect.bottom;
	}
	
	public static int getCurrentMode() {
		return currentMode;
	}
	
	public static void setMode(int mode) {
		currentMode = mode;
		Activity activity = activityRef != null ? activityRef.get() : null;
		if (activity != null) setFullscreenMode(activity, mode);
	}
	
	public static int getCutoutHeight(int pos) {
		Activity activity = activityRef != null ? activityRef.get() : null;
		if (activity == null) return 0;
		
		if (sdk >= 28) {
			WindowInsets insets = activity.getWindow().getDecorView().getRootWindowInsets();
			if (insets != null && insets.getDisplayCutout() != null) {
				DisplayCutout cutout = insets.getDisplayCutout();
				switch (pos) {
					case 0: return cutout.getSafeInsetTop();
					case 1: return cutout.getSafeInsetBottom();
					case 2: return cutout.getSafeInsetLeft();
					case 3: return cutout.getSafeInsetRight();
				}
			}
		}
		
		return 0;
	}
}
