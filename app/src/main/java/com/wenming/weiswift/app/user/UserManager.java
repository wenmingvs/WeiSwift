package com.wenming.weiswift.app.user;

import android.text.TextUtils;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.wenming.weiswift.app.common.constants.APIConstants;
import com.wenming.weiswift.app.common.entity.UserEntity;
import com.wenming.weiswift.app.common.net.HttpManager;
import com.wenming.weiswift.app.common.thread.ThreadHelper;
import com.wenming.weiswift.app.user.callback.UserInfoCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户信息管理类
 * Created by wenmingvs on 2018/1/10.
 */
public class UserManager {
    private static UserManager sInstance;
    private UserEntity mUser;

    private UserManager() {
    }

    public static UserManager getInstance() {
        if (sInstance == null) {
            synchronized (UserManager.class) {
                if (sInstance == null) {
                    sInstance = new UserManager();
                }
            }
        }
        return sInstance;
    }

    public UserEntity getUser() {
        return mUser;
    }

    public void setUser(UserEntity user) {
        this.mUser = user;
    }

    /**
     * 获取登录用户的信息
     *
     * @param accessToken      登录token
     * @param source           app key
     * @param uid              用户uid
     * @param userInfoCallBack 网络请求回调
     */
    public void requestUserInfo(String accessToken, String source, final long uid, final UserInfoCallBack userInfoCallBack) {
        Map<String, String> params = new HashMap<>();
        params.put("access_token", accessToken);
        if (!TextUtils.isEmpty(source)) {
            params.put("source", source);
        }
        if (uid != 0) {
            params.put("uid", String.valueOf(uid));
        }
        HttpManager.getInstance().httpStringGetRequest(APIConstants.USER_SHOW, params, new Object(), new Response.Listener<String>() {
            @Override
            public void onResponse(final String response) {
                mUser = UserEntity.parse(response);
                if (mUser != null) {
                    ThreadHelper.instance().runOnWorkThread(new ThreadHelper.Task() {
                        @Override
                        public void onRun() {
                            TextSaveUtils.write(UserInfoCacheConfig.getUserInfoDir(uid), UserInfoCacheConfig.FILE_USER_INFO, response);
                        }
                    });
                }
                userInfoCallBack.onSuccess(mUser);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                userInfoCallBack.onFail();
            }
        });
    }

    /**
     * 读取用户缓存信息
     */
    public void loadUserInfo(final long uid, final UserInfoCallBack callBack) {
        ThreadHelper.instance().runOnWorkThread(new ThreadHelper.Task() {
            @Override
            public void onRun() {
                String json = TextSaveUtils.read(UserInfoCacheConfig.getUserInfoDir(uid), UserInfoCacheConfig.FILE_USER_INFO);
                if (!TextUtils.isEmpty(json)) {
                    mUser = UserEntity.parse(json);
                    callBack.onSuccess(mUser);
                } else {
                    callBack.onFail();
                }
            }
        });
    }
}
