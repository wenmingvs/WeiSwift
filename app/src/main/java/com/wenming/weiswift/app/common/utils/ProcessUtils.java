package com.wenming.weiswift.app.common.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Process 进程相关的工具类
 * <p>
 * Created by Jay on 2016/9/2.
 */
public class ProcessUtils {

    public static final String UNKNOWN_PROCESS_NAME = "unknown_process_name";

    /**
     * 获取当前进程的 pid
     *
     * @return pid
     */
    public static int getMyProcessId() {
        return android.os.Process.myPid();
    }

    /**
     * 获取当前的进程名
     *
     * @param context the context
     * @return 进程名
     */
    public static String getMyProcessName(Context context) {
        return getProcessName(context, getMyProcessId());
    }

    /**
     * 通过 pid 获取进程名
     *
     * @param context the context
     * @param pid     进程的 pid
     * @return 进程名
     */
    public static String getProcessName(Context context, int pid) {
        String processName = getProcessNameViaProc(pid);
        if (UNKNOWN_PROCESS_NAME.equals(processName)) {
            return getProcessNameViaActivityManager(context, pid);
        } else {
            return processName;
        }
    }

    /**
     * 通过 pid 获取进程名
     * <p>
     * 通过读取 /proc 中的进程信息文件的方式
     * <p>
     * 相比{@link #getProcessNameViaActivityManager(Context, int)} 更加高效
     *
     * @param pid 进程的 pid
     * @return 进程名
     */
    public static String getProcessNameViaProc(int pid) {
        BufferedReader bufferedReader = null;
        try {
            File file = new File("/proc/" + pid + "/" + "cmdline");
            bufferedReader = new BufferedReader(new FileReader(file));
            String processName = bufferedReader.readLine().trim();
            if (!TextUtils.isEmpty(processName)) {
                return processName;
            } else {
                return UNKNOWN_PROCESS_NAME;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return UNKNOWN_PROCESS_NAME;
    }

    /**
     * 获取进程名
     * <p>
     * 通过 ActivityManager 来获取 RunningAppProcessInfo 的方式。
     * <p>
     * 相对耗时
     *
     * @param context the context
     * @param pid     需要获取进程名的进程 pid
     * @return 进程名
     */
    public static String getProcessNameViaActivityManager(Context context, int pid) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
        if (runningApps == null) {
            return UNKNOWN_PROCESS_NAME;
        }
        for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
            if (procInfo.pid == pid) {
                return procInfo.processName;
            }
        }
        return UNKNOWN_PROCESS_NAME;
    }
}
