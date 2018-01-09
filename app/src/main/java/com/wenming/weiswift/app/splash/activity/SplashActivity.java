package com.wenming.weiswift.app.splash.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.wenming.weiswift.R;
import com.wenming.weiswift.app.common.base.activity.BaseAppCompatActivity;
import com.wenming.weiswift.app.splash.data.SplashDataManager;
import com.wenming.weiswift.app.splash.fragment.SplashFragment;
import com.wenming.weiswift.app.splash.presenter.SplashPresenter;

/**
 * 开屏页模块Activity页实现
 * <p>
 * Created by wenmingvs on 2018/01/09.
 */
public class SplashActivity extends BaseAppCompatActivity {
    private SplashFragment mSplashFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initFragment();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mSplashFragment != null) {
            return mSplashFragment.onKeyDown(keyCode, event);
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    private void initFragment() {
        mSplashFragment = (SplashFragment) getSupportFragmentManager().findFragmentByTag(SplashFragment.TAG);
        if (mSplashFragment == null) {
            mSplashFragment = SplashFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_fl, mSplashFragment, SplashFragment.TAG)
                    .commit();
        }
        new SplashPresenter(mContext, mSplashFragment, new SplashDataManager());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mSplashFragment != null && mSplashFragment.isAdded()) {
            mSplashFragment.onActivityResult(requestCode, resultCode, data);
        }
    }
}
