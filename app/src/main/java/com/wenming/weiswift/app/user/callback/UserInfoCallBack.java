package com.wenming.weiswift.app.user.callback;

import com.wenming.weiswift.app.common.entity.UserEntity;

/**
 * 请求用户信息回调接口
 * <p>
 * Created by wenmingvs on 2017/8/12.
 */
public interface UserInfoCallBack {
    void onSuccess(UserEntity user);

    void onFail();
}
