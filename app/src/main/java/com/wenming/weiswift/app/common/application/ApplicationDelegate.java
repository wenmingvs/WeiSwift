package com.wenming.weiswift.app.common.application;

import android.app.Application;
import android.content.Context;

import com.wenming.weiswift.app.common.application.process.BaseProcess;
import com.wenming.weiswift.app.common.application.process.MainProcess;
import com.wenming.weiswift.app.common.utils.ProcessUtils;

/**
 * Application代理类，用于区分进程
 * <p>
 * Created by wenmingvs on 2018/1/9.
 */
public class ApplicationDelegate {
    private String mProcessName;
    private BaseProcess mProcess;
    private Application mApplication;

    public ApplicationDelegate(Application application, String processName) {
        this.mApplication = application;
        this.mProcessName = processName;
    }

    public void onBaseContextAttached(Context base) {
        ApplicationHelper.getInstance().init(mApplication);
    }

    public void onCreate() {
        boolean isMainProcess = isMainProcess(mApplication);
        if (isMainProcess) {
            mProcess = MainProcess.getInstance();
            mProcess.mApplication = mApplication;
            mProcess.onCreate();
        }
    }

    public void onTerminate() {
        if (mProcess != null) {
            mProcess.onTerminate();
        }
    }

    public static boolean isMainProcess(Context context) {
        String mainProcessName = MainProcess.getInstance().getMainProcessName(context);
        return mainProcessName.equals(ProcessUtils.getMyProcessName(context));
    }
}
