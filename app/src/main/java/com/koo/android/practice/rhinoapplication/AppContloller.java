package com.koo.android.practice.rhinoapplication;

import android.app.Application;

/**
 * Created by koo on 2015/08/12.
 */
public class AppContloller extends Application {
    private static AppContloller sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static synchronized AppContloller getInstance() {
        return sInstance;
    }
}
