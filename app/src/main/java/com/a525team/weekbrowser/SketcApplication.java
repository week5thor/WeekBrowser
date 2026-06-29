package com.a525team.weekbrowser;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SketcApplication extends Application {

    private static Context mApplicationContext;

    public static Context getContext() {
        return mApplicationContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = getApplicationContext();

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                Intent intent = new Intent(getApplicationContext(), DebugActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("error", Log.getStackTraceString(throwable));

                getApplicationContext().startActivity(intent);

                // Завершити потік аварійного завершення
                System.exit(1);
            }
        });
    }
}
