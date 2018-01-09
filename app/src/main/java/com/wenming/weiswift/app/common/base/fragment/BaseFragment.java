package com.wenming.weiswift.app.common.base.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;

import com.wenming.weiswift.app.common.thread.ThreadHelper;


/**
 * fragment基类
 * <p>
 * Created by wenmingvs on 1/6/16.
 */
public abstract class BaseFragment extends Fragment {
    private static final String TAG = "BaseFragment";

    protected Context mContext;

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    /**
     * 结束当前Activity
     */
    protected void finishActivity() {
        FragmentActivity activity = getActivity();
        if (null != activity) {
            activity.finish();
        }
    }

    /**
     * 运行一个task在线程里面
     *
     * @param task runnable对象
     */
    protected void runOnWorkThread(ThreadHelper.Task task) {
        ThreadHelper.instance().runOnWorkThread(task);
    }

    protected void runOnUiThread(Runnable action) {
        ThreadHelper.instance().runOnUiThread(action);
    }

    /**
     * 如果Fragment已经跟Activity detach的话，getView就会返回null
     *
     * @param paramInt view resource id
     * @return View or null if the fragment is detached.
     */
    protected View findViewById(int paramInt) {
        if (getView() != null) {
            return getView().findViewById(paramInt);
        }
        return null;
    }
}
