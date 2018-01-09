package com.wenming.weiswift.app.splash.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.wenming.weiswift.app.common.thread.ThreadHelper;
import com.wenming.weiswift.app.outh.AccessTokenHelper;
import com.wenming.weiswift.app.outh.Constants;
import com.wenming.weiswift.app.splash.contract.SplashContract;
import com.wenming.weiswift.app.splash.data.SplashDataSource;

/**
 * 开屏页模块Presenter层实现
 * <p>
 * Created by wenmingvs on 2018/01/09.
 */
public class SplashPresenter implements SplashContract.Presenter {
    private static final String BUDDLE_KEY_UID = "uid";
    private static final String BUDDLE_KEY_ACCESS_TOKEN = "access_token";
    private static final String BUDDLE_KEY_EXPIRES_IN = "expires_in";
    private static final String BUDDLE_KEY_REFRESH_TOKEN = "refresh_token";
    private static final int SPLASH_TIME = 500;

    private SplashContract.View mView;
    private SplashDataSource mDataModel;
    private SsoHandler mSSOHandler;
    private AuthInfo mSSOAuth;
    private Context mContext;

    public SplashPresenter(Context context, SplashContract.View view, SplashDataSource dataModel) {
        this.mView = view;
        this.mDataModel = dataModel;
        this.mContext = context;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {
        ThreadHelper.instance().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (AccessTokenHelper.getInstance().isTokenValid()){
                    mView.goToMainActivity();
                }else {
                    mView.showAuth();
                }
            }
        }, SPLASH_TIME);
    }

    @Override
    public void webAuth(Context context) {
        initAuth();
        mView.goToWebAuthActivity();
    }

    private void initAuth() {
        if (mSSOAuth == null) {
            mSSOAuth = new AuthInfo(mContext, Constants.APP_KEY, Constants.APP_REDIRECT_URL, Constants.APP_SCOPE);
        }
    }

    @Override
    public void ssoAuth(Activity activity) {
        initAuth();
        mSSOHandler = new SsoHandler(activity, mSSOAuth);
        mSSOHandler.authorizeClientSso(new WeiboAuthListener() {
            @Override
            public void onComplete(Bundle bundle) {
                String uid = bundle.getString(BUDDLE_KEY_UID, "");
                String accessToken = bundle.getString(BUDDLE_KEY_ACCESS_TOKEN, "");
                String refreshToken = bundle.getString(BUDDLE_KEY_REFRESH_TOKEN, "");
                String expiresIn = bundle.getString(BUDDLE_KEY_EXPIRES_IN, "");
                AccessTokenHelper.getInstance().setUid(Long.valueOf(uid));
                AccessTokenHelper.getInstance().setAccessToken(accessToken);
                AccessTokenHelper.getInstance().setRefreshToken(refreshToken);
                AccessTokenHelper.getInstance().setExpiresTime(Long.valueOf(expiresIn));
                mView.showAuthSuccess();
                mView.goToMainActivity();
                mView.finishActivity();
            }

            @Override
            public void onWeiboException(WeiboException e) {
                mView.showAuthError(e.getMessage());
            }

            @Override
            public void onCancel() {
                mView.showCancel();
            }
        });
    }

    @Override
    public void ssoAuthorizeCallBack(int requestCode, int resultCode, Intent data) {
        if (mSSOHandler != null) {
            mSSOHandler.authorizeCallBack(requestCode, resultCode, data);
        }
    }
}