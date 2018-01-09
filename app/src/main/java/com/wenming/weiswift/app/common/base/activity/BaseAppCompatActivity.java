package com.wenming.weiswift.app.common.base.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Activity基类
 * <p>
 * Created by wenmingvs on 2017/6/22.
 */
public abstract class BaseAppCompatActivity extends AppCompatActivity {
    private static final String TAG = "BaseAppCompatActivity";
    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }
}