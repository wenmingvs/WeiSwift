package com.wenming.weiswift.app.splash.contract;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.wenming.weiswift.app.common.base.mvp.BasePresenter;
import com.wenming.weiswift.app.common.base.mvp.BaseView;
/**
 * 开屏页模块View层与Presenter层接口定义
 * <p>
 * Created by wenmingvs on 2018/01/09.
 */
public interface SplashContract {
    /**
     * View层接口
     */
    interface View extends BaseView<Presenter> {
        void showCancel();

        void showAuthSuccess();

        void showAuthError(String errorText);

        void goToMainActivity();

        void goToWebAuthActivity();

        void finishActivity();

        void showAuth();
    }
    /**
     * Presenter层接口
     */
    interface Presenter extends BasePresenter {

        void webAuth(Context context);

        void ssoAuth(Activity activity);

        void ssoAuthorizeCallBack(int requestCode, int resultCode, Intent data);
    }
}