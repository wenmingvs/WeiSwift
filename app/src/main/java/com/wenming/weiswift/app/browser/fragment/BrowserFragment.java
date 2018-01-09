package com.wenming.weiswift.app.browser.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wenming.weiswift.R;
import com.wenming.weiswift.app.browser.constants.Constants;
import com.wenming.weiswift.app.browser.contract.BrowserContract;
import com.wenming.weiswift.app.common.base.fragment.BaseFragment;
import com.wenming.weiswift.app.common.utils.ToastUtil;
import com.wenming.weiswift.app.main.activity.MainActivity;

/**
 * 内置浏览器模块View层实现
 * <p>
 * Created by wenmingvs on 2018/01/09.
 */
public class BrowserFragment extends BaseFragment implements BrowserContract.View {
    public static final String TAG = "BrowserFragment";
    private BrowserContract.Presenter mPresenter;
    private WebView mWebView;
    private String mOpenUrl;

    @Override
    public void setPresenter(BrowserContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public BrowserFragment() {
    }

    public static BrowserFragment newInstance(String url) {
        BrowserFragment fragment = new BrowserFragment();
        Bundle args = new Bundle();
        args.putString(Constants.ARG_OPEN_URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_browser, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareView();
        initData();
        initView();
        initListener();
        mPresenter.start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finishActivity();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    private void prepareView() {
        mWebView = (WebView) findViewById(R.id.browser_webview);
    }

    private void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            mOpenUrl = arguments.getString(Constants.ARG_OPEN_URL);
        }
    }

    private void initView() {
        initTopBar();
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.loadUrl(mOpenUrl);
    }

    private void initListener() {
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishActivity();
            }
        });
        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == android.view.KeyEvent.ACTION_DOWN) {
                    if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
                        if (mWebView.canGoBack()) {
                            mWebView.goBack();
                        } else {
                            finishActivity();
                        }
                        return true;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void goToMainActivity() {
        Intent intent = new Intent(mContext, MainActivity.class);
        intent.putExtra(com.wenming.weiswift.app.main.constants.Constants.EXTRA_REFRESH_TIMELINE, true);
        mContext.startActivity(intent);
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //登录成功会在URL尾部填充accesstoken等信息，需要人工解析出来
            if (isUrlRedirected(url)) {
                view.stopLoading();
                mPresenter.saveAccessToken(url);
            } else {
                view.loadUrl(url);
            }
            //复写此方法并且返回true，使用内置浏览器来打开URL
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            if (!url.equals("about:blank") && isUrlRedirected(url)) {
                view.stopLoading();
                mPresenter.saveAccessToken(url);
                return;
            }
            super.onPageStarted(view, url, favicon);
        }
    }

    public boolean isUrlRedirected(String url) {
        return url.startsWith(com.wenming.weiswift.app.outh.Constants.WEICO_REDIRECT_URL);
    }

    @Override
    public void showAuthSuccess() {
        ToastUtil.showShort(mContext, mContext.getString(R.string.splash_web_auth_success));
    }
}
