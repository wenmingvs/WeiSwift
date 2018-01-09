package com.wenming.weiswift.app.common.base.eventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * 注册eventBus 监听的基类
 * <p>
 * Created by wenmingvs on 12/26/17.
 */
public class BaseEventSubscribe {

    public void register() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    public void unregister() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
