package com.wenming.weiswift.app.user.callback;

import com.wenming.weiswift.app.common.entity.User;

/**
 * 请求用户信息回调接口
 * <p>
 * Created by wenmingvs on 2017/8/12.
 */
public interface UserInfoCallBack {
    void onSuccess(User user);

    void onFail();
}
