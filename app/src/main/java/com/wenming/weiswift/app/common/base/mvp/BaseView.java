package com.wenming.weiswift.app.common.base.mvp;

/**
 * MVP的View层接口定义, 业务实现MVP
 * View层需要实现.Presenter层见{@link BasePresenter}
 *
 * Created by wenmingvs on 1/6/16.
 */
public interface BaseView<T> {
    /**
     * 给View设置Presenter实现.
     *
     * @param presenter {@link BasePresenter}的实现
     */
    void setPresenter(T presenter);
}
