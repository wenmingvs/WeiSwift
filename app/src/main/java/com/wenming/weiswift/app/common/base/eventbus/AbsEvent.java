package com.wenming.weiswift.app.common.base.eventbus;

/**
 * EventBus事件基类
 * <p>
 * Created by wenmingvs on 2016/5/7 17:36
 */
abstract public class AbsEvent {
    public int mCode;

    public AbsEvent(int code) {
        mCode = code;
    }

    public int getCode() {
        return mCode;
    }

    public void setCode(int code) {
        mCode = code;
    }
}
