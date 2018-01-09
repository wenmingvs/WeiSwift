package com.wenming.weiswift.app.common.application.process;

import android.app.Application;

import com.wenming.weiswift.app.common.application.IApplication;

/**
 * Created by wenmingvs on 2018/1/9.
 */
public class BaseProcess implements IApplication {
    public Application mApplication;

    @Override
    public void onCreate() {

    }

    @Override
    public void onTerminate() {

    }
}
