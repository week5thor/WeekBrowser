# ====== Агресивна обфускація та оптимізація ======
-optimizationpasses 99
-overloadaggressively
-allowaccessmodification
-repackageclasses ''
-flattenpackagehierarchy ''
-mergeinterfacesaggressively
-dontpreverify
-ignorewarnings
-verbose

# ====== Атрибути, які потрібні Android (мінімум для стабільності) ======
-keepattributes Signature, RuntimeVisibleAnnotations

# ====== Життєвий цикл Activity ======
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Service

-keepclassmembers class * extends android.app.Activity {
    public void *(android.os.Bundle);
    void onCreate(...);
    void onResume(...);
    void onPause(...);
    void onStop(...);
    void onDestroy(...);
    void onSaveInstanceState(...);
    void onRestoreInstanceState(...);
}

# ====== Підтримка кастомних View ======
-keep class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
}

# ====== JavascriptInterface (WebView) ======
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}

# ====== WebView: мінімальний набір для стабільності ======
-keep public class android.webkit.WebView { 
    public *; 
    protected *;
}
-dontwarn android.webkit.**

# ====== Видалення логів у релізі ======
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
    public static *** w(...);
    public static *** e(...);
}
