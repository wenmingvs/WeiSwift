package com.wenming.weiswift.app.splash.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.wenming.weiswift.R;
import com.wenming.weiswift.app.common.base.fragment.BaseFragment;
import com.wenming.weiswift.app.common.utils.ToastUtil;
import com.wenming.weiswift.app.main.activity.MainActivity;
import com.wenming.weiswift.app.main.constants.Constants;
import com.wenming.weiswift.app.splash.contract.SplashContract;

/**
 * 开屏页模块View层实现
 * <p>
 * Created by wenmingvs on 2018/01/09.
 */
public class SplashFragment extends BaseFragment implements SplashContract.View {
    public static final String TAG = "SplashFragment";
    private SplashContract.Presenter mPresenter;
    private Button mWebAuthBt,mSSOAuthBt;
    private LinearLayout mAuthContainerLl;

    @Override
    public void setPresenter(SplashContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public SplashFragment() {
    }

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareView();
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
        mAuthContainerLl = (LinearLayout) findViewById(R.id.splash_container_ll);
        mSSOAuthBt = (Button) findViewById(R.id.splash_sso_auth_bt);
        mWebAuthBt = (Button) findViewById(R.id.splash_web_auth_bt);
    }

    private void initListener() {
        mSSOAuthBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.ssoAuth(getActivity());
            }
        });
        mWebAuthBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.webAuth(mContext);
            }
        });
    }

    @Override
    public void showCancel() {
        ToastUtil.showShort(mContext, mContext.getString(R.string.splash_web_auth_cancel));
    }

    @Override
    public void showAuthSuccess() {
        ToastUtil.showShort(mContext, mContext.getString(R.string.splash_web_auth_success));
    }

    @Override
    public void showAuthError(String errorText) {
        ToastUtil.showShort(mContext, errorText);
    }

    @Override
    public void goToMainActivity() {
        Intent intent = new Intent(mContext, MainActivity.class);
        intent.putExtra(Constants.EXTRA_REFRESH_TIMELINE, true);
        mContext.startActivity(intent);
    }

    @Override
    public void goToWebAuthActivity() {
//        Intent intent = new Intent(mContext, WebViewActivity.class);
//        intent.putExtra(WebViewActivity.EXTRA_URL, WeicoAuthConstants.AUTHURL);
//        startActivity(intent);
    }

    @Override
    public void finishActivity() {
        super.finishActivity();
    }

    @Override
    public void showAuth() {
        mAuthContainerLl.setVisibility(View.VISIBLE);
        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.splash_btn_animation);
        mAuthContainerLl.setAnimation(animation);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.ssoAuthorizeCallBack(requestCode, resultCode, data);
    }
}
