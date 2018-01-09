package com.wenming.weiswift.app.browser.contract;

import com.wenming.weiswift.app.common.base.mvp.BasePresenter;
import com.wenming.weiswift.app.common.base.mvp.BaseView;
/**
 * 内置浏览器模块View层与Presenter层接口定义
 * <p>
 * Created by wenmingvs on 2018/01/09.
 */
public interface BrowserContract {
    /**
     * View层接口
     */
    interface View extends BaseView<Presenter> {
        void goToMainActivity();

        void showAuthSuccess();
    }
    /**
     * Presenter层接口
     */
    interface Presenter extends BasePresenter {
        void saveAccessToken(String url);
    }
}