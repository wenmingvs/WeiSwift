package com.wenming.weiswift.app.common.application;

import android.app.Application;
import android.content.Context;

/**
 * 自定义的Application
 * <p>
 * Created by wenmingvs on 2017/5/31.
 */
public class AppApplication extends Application {
    private ApplicationDelegate mDelegate;

    @Override
    public void onCreate() {
        super.onCreate();
        mDelegate.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mDelegate = new ApplicationDelegate(this, base.toString());
        mDelegate.onBaseContextAttached(base);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        mDelegate.onTerminate();
    }
}