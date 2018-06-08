package com.bluemobi.mvptest.presenter.base;

import com.bluemobi.mvptest.view.BaseView;

/**
 * Created by ${chenM} on ${2017}.
 */
public interface Presenter<V extends BaseView> {
    /**
     * 绑定
     */
    void attachView(V baseView);
    /**
     * 解绑
     */
    void detachView();
}
