package com.wenming.weiswift.app.common.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

/**
 * Application帮助类，用于获取context，区分app在前台还是后台
 * <p>
 * Created by wenmingvs on 2018/1/9.
 */
public class ApplicationHelper implements Application.ActivityLifecycleCallbacks {
    private Application mApplication;
    private int mForegroundActivityCount;
    private static ApplicationHelper sInstance;

    private ApplicationHelper() {
    }

    public static ApplicationHelper getInstance() {
        if (sInstance == null) {
            synchronized (ApplicationHelper.class) {
                if (sInstance == null) {
                    sInstance = new ApplicationHelper();
                }
            }
        }
        return sInstance;
    }

    public void init(Application context) {
        mApplication = context;
        mApplication.registerActivityLifecycleCallbacks(this);
    }

    public Application getApplication() {
        return mApplication;
    }

    public Context getContext() {
        return mApplication;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityStarted(Activity activity) {
        mForegroundActivityCount++;
    }

    @Override
    public void onActivityResumed(Activity activity) {
    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivityStopped(Activity activity) {
        mForegroundActivityCount--;
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
    }

    /**
     * 判断app是否在前台，手动管理
     *
     * @return true if running foreground
     */
    public boolean isRunningForeground() {
        return mForegroundActivityCount > 0;
    }
}
