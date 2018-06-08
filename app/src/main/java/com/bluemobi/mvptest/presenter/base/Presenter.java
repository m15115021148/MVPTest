package com.bluemobi.mvptest.presenter.base;

import com.bluemobi.mvptest.view.BaseView;

/**
 * Created by ${chenM} on ${2017}.
 */
public interface Presenter<V extends BaseView> {
    void attachView(V baseView);//binding
    void detachView();//unbinding
}
