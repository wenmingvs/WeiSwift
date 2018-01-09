package com.wenming.weiswift.app.browser.presenter;

import com.wenming.weiswift.app.browser.contract.BrowserContract;
import com.wenming.weiswift.app.browser.data.BrowserDataSource;
import com.wenming.weiswift.app.outh.AccessTokenHelper;

/**
 * 内置浏览器模块Presenter层实现
 * <p>
 * Created by wenmingvs on 2018/01/09.
 */
public class BrowserPresenter implements BrowserContract.Presenter {
    private BrowserContract.View mView;
    private BrowserDataSource mDataModel;

    public BrowserPresenter(BrowserContract.View view, BrowserDataSource dataModel) {
        this.mView = view;
        this.mDataModel = dataModel;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void saveAccessToken(String url) {
        if (!url.contains("error")) {
            int tokenIndex = url.indexOf("access_token=");
            int expiresIndex = url.indexOf("expires_in=");
            int refresh_token_Index = url.indexOf("refresh_token=");
            int uid_Index = url.indexOf("uid=");

            String accessToken = url.substring(tokenIndex + 13, url.indexOf("&", tokenIndex));
            String expiresIn = url.substring(expiresIndex + 11, url.indexOf("&", expiresIndex));
            String refreshToken = url.substring(refresh_token_Index + 14, url.indexOf("&", refresh_token_Index));
            String uid;
            if (url.contains("scope=")) {
                uid = url.substring(uid_Index + 4, url.indexOf("&", uid_Index));
            } else {
                uid = url.substring(uid_Index + 4);
            }
            AccessTokenHelper.getInstance().setAccessToken(accessToken);
            AccessTokenHelper.getInstance().setExpiresIn(Long.valueOf(expiresIn));
            AccessTokenHelper.getInstance().setRefreshToken(refreshToken);
            AccessTokenHelper.getInstance().setUid(Long.valueOf(uid));
            mView.showAuthSuccess();
            mView.goToMainActivity();
        }
    }
}