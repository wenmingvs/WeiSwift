package com.wenming.weiswift.app.common.preference;

import android.content.SharedPreferences;

import com.wenming.weiswift.app.common.application.ApplicationHelper;

import static android.content.Context.MODE_PRIVATE;

/**
 * 用户相关的sp
 * <p>
 * Created by wenmingvs on 2017/5/31.
 */
public class UserPreference {
    private static final String FILE_NAME_SUFFIX = "_user_preference";
    //用户分组信息
    private static final String ACCOUNT_GOURPS = "account_groups";
    //用户uid
    private static final String ACCOUNT_UID = "account_uid";
    //用户token
    private static final String ACCOUNT_ACCESS_TOKEN = "account_access_token";
    //用户刷新token
    private static final String ACCOUNT_REFRESH_TOKEN = "account_refresh_token";
    //用户token超时时间
    private static final String ACCOUNT_EXPIRES_TIME = "account_expires_time";

    public static void setUid(long uid) {
        setLong(uid, ACCOUNT_UID, uid);
    }

    public static String getUid(long uid) {
        return getSp(uid).getString(ACCOUNT_UID, "");
    }

    public static void setAccessToken(long uid, String accessToken) {
        setString(uid, ACCOUNT_ACCESS_TOKEN, accessToken);
    }

    public static String getAccessToken(long uid) {
        return getSp(uid).getString(ACCOUNT_ACCESS_TOKEN, "");
    }

    public static void setRefreshAccessToken(long uid, String refreshToken) {
        setString(uid, ACCOUNT_REFRESH_TOKEN, refreshToken);
    }

    public static String getRefreshAccessToken(long uid) {
        return getSp(uid).getString(ACCOUNT_REFRESH_TOKEN, "");
    }

    public static void setExpiresTime(long uid, long expires) {
        setLong(uid, ACCOUNT_EXPIRES_TIME, expires);
    }

    public static long getExpiresTime(long uid) {
        return getSp(uid).getLong(ACCOUNT_EXPIRES_TIME, 0);
    }

    private static SharedPreferences getSp(long uid) {
        return ApplicationHelper.getInstance().getContext().getSharedPreferences(uid + FILE_NAME_SUFFIX, MODE_PRIVATE);
    }

    public static void setUserGroups(long uid, String jsonString) {
        setString(uid, ACCOUNT_GOURPS, jsonString);
    }

    public static String getUserGroups(long uid) {
        return getSp(uid).getString(ACCOUNT_GOURPS, "");
    }

    protected static void setString(long uid, String key, String value) {
        final SharedPreferences.Editor settingsEditor = getSp(uid).edit();
        settingsEditor.putString(key, value);
        settingsEditor.apply();
    }

    protected static void setBoolean(long uid, String key, boolean value) {
        final SharedPreferences.Editor settingsEditor = getSp(uid).edit();
        settingsEditor.putBoolean(key, value);
        settingsEditor.apply();
    }

    protected static void setInt(long uid, String key, int value) {
        final SharedPreferences.Editor settingsEditor = getSp(uid).edit();
        settingsEditor.putInt(key, value);
        settingsEditor.apply();
    }

    protected static void setFloat(long uid, String key, float value) {
        final SharedPreferences.Editor settingsEditor = getSp(uid).edit();
        settingsEditor.putFloat(key, value);
        settingsEditor.apply();
    }

    protected static void setLong(long uid, String key, long value) {
        final SharedPreferences.Editor settingsEditor = getSp(uid).edit();
        settingsEditor.putLong(key, value);
        settingsEditor.apply();
    }
}
