package com.wenming.weiswift.app.browser.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.wenming.weiswift.R;
import com.wenming.weiswift.app.browser.constants.Constants;
import com.wenming.weiswift.app.browser.data.BrowserDataManager;
import com.wenming.weiswift.app.browser.fragment.BrowserFragment;
import com.wenming.weiswift.app.browser.presenter.BrowserPresenter;
import com.wenming.weiswift.app.common.base.activity.BaseAppCompatActivity;

/**
 * 内置浏览器模块Activity页实现
 * <p>
 * Created by wenmingvs on 2018/01/09.
 */
public class BrowserActivity extends BaseAppCompatActivity {
    private BrowserFragment mBrowserFragment;

    public static Intent getOpenIntent(Context context, String url) {
        Intent intent = new Intent(context, BrowserActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_OPEN_URL, url);
        intent.putExtra(Constants.EXTRA_OPEN_URL, bundle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        initFragment();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mBrowserFragment != null) {
            return mBrowserFragment.onKeyDown(keyCode, event);
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    private void initFragment() {
        String openUrl = getIntent().getBundleExtra(Constants.EXTRA_OPEN_URL).getString(Constants.EXTRA_OPEN_URL);
        mBrowserFragment = (BrowserFragment) getSupportFragmentManager().findFragmentByTag(BrowserFragment.TAG);
        if (mBrowserFragment == null) {
            mBrowserFragment = BrowserFragment.newInstance(openUrl);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_fl, mBrowserFragment, BrowserFragment.TAG)
                    .commit();
        }
        new BrowserPresenter(mBrowserFragment, new BrowserDataManager());
    }

}
