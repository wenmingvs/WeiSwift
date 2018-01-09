package com.wenming.weiswift.app.common.application.process;

import android.content.Context;

/**
 * 主进程加载资源
 * <p>
 * Created by wenmingvs on 2018/1/9.
 */
public class MainProcess extends BaseProcess{
    private static final String TAG = "MainProfile";
    private static MainProcess sInstance;

    private MainProcess() {
    }

    public static MainProcess getInstance() {
        if (sInstance == null) {
            synchronized (MainProcess.class) {
                if (sInstance == null) {
                    sInstance = new MainProcess();
                }
            }
        }
        return sInstance;
    }

    public static String getMainProcessName(Context context) {
        return context.getPackageName();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
