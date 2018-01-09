package com.wenming.weiswift.app.common.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.wenming.weiswift.app.common.application.ApplicationHelper;


/**
 * 通用SP
 * <p>
 * Created by wenmingvs on 2017/5/31.
 */
public class CommonPreference {
    private static final String FILE_NAME = "common_preference";
    //当前登录用户的uid
    private static final String CURRENT_USER_UID = "current_user_uid";
    //当前登录用户的token
    private static final String CURRENT_USER_ACCESS_TOKEN = "current_user_access_token";
    //当前登录用户的刷新token
    private static final String CURRENT_USER_REFRESH_TOKEN = "current_user_refresh_token";
    //当前登录用户的token超时时间
    private static final String CURRENT_USER_EXPIRESIN = "current_user_expiresin";

    private static SharedPreferences getSp() {
        return ApplicationHelper.getInstance().getContext().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    public static void setUid(long uid) {
        setLong(CURRENT_USER_UID, uid);
    }

    public static long getUid() {
        return getSp().getLong(CURRENT_USER_UID, 0);
    }

    public static void setAccessToken(String accessToken) {
        setString(CURRENT_USER_ACCESS_TOKEN, accessToken);
    }

    public static String getAccessToken() {
        return getSp().getString(CURRENT_USER_ACCESS_TOKEN, "");
    }

    public static void setRefreshAccessToken(String refreshToken) {
        setString(CURRENT_USER_REFRESH_TOKEN, refreshToken);
    }

    public static String getRefreshAccessToken() {
        return getSp().getString(CURRENT_USER_REFRESH_TOKEN, "");
    }

    public static void setExpiresTime(long expires) {
        setLong(CURRENT_USER_EXPIRESIN, expires);
    }

    public static long getExpiresIn() {
        return getSp().getLong(CURRENT_USER_EXPIRESIN, 0);
    }

    private static void setString(String key, String value) {
        final SharedPreferences.Editor settingsEditor = getSp().edit();
        settingsEditor.putString(key, value);
        settingsEditor.apply();
    }

    public static void setBoolean(String key, boolean value) {
        final SharedPreferences.Editor settingsEditor = getSp().edit();
        settingsEditor.putBoolean(key, value);
        settingsEditor.apply();
    }

    private static void setInt(String key, int value) {
        final SharedPreferences.Editor settingsEditor = getSp().edit();
        settingsEditor.putInt(key, value);
        settingsEditor.apply();
    }

    private static void setLong(String key, long value) {
        final SharedPreferences.Editor settingsEditor = getSp().edit();
        settingsEditor.putLong(key, value);
        settingsEditor.apply();
    }

    private static void setFloat(String key, float value) {
        final SharedPreferences.Editor settingsEditor = getSp().edit();
        settingsEditor.putFloat(key, value);
        settingsEditor.apply();
    }
}
