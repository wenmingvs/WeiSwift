package com.wenming.weiswift.app.outh;

import android.text.TextUtils;

import com.wenming.weiswift.app.common.preference.CommonPreference;
import com.wenming.weiswift.app.common.thread.ThreadHelper;

/**
 * 授权的OA管理类
 * <p>
 * Created by wenmingvs on 2018/1/9.
 */
public class AccessTokenHelper {
    private static AccessTokenHelper mInstance;
    private long mUid;
    private String mAccessToken;
    private String mRefreshToken;
    private long mExpiresIn;

    public static AccessTokenHelper getInstance() {
        if (mInstance == null) {
            synchronized (ThreadHelper.class) {
                if (mInstance == null) {
                    mInstance = new AccessTokenHelper();
                }
            }
        }
        return mInstance;
    }

    private AccessTokenHelper() {
        initData();
    }

    private void initData() {
        mUid = CommonPreference.getUid();
        mAccessToken = CommonPreference.getAccessToken();
        mRefreshToken = CommonPreference.getRefreshAccessToken();
        mExpiresIn = CommonPreference.getExpiresIn();
    }

    public long getUid() {
        return mUid;
    }

    public void setUid(long uid) {
        this.mUid = uid;
        CommonPreference.setUid(uid);
    }

    public String getAccessToken() {
        return mAccessToken;
    }

    public void setAccessToken(String accessToken) {
        this.mAccessToken = accessToken;
        CommonPreference.setAccessToken(accessToken);
    }

    public String getRefreshToken() {
        return mRefreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.mRefreshToken = refreshToken;
        CommonPreference.setRefreshAccessToken(refreshToken);
    }

    public long getExpiresTime() {
        return mExpiresIn;
    }

    public void setExpiresTime(long expiresTime) {
        this.mExpiresIn = expiresTime;
        CommonPreference.setExpiresTime(expiresTime);
    }

    public boolean isTokenValid() {
        if (mUid <= 0) {
            return false;
        }
        if (TextUtils.isEmpty(mAccessToken)) {
            return false;
        }
        if (TextUtils.isEmpty(mRefreshToken)) {
            return false;
        }
        if (mExpiresIn <= 0 || isTokenTimeOut()) {
            return false;
        }
        return true;
    }

    private boolean isTokenTimeOut() {
        long currentTime = System.currentTimeMillis();
        long expiresTime = currentTime + mExpiresIn * 1000L;
        return currentTime > expiresTime;
    }
}
