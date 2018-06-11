package com.bluemobi.mvptest.mvp.model;

import com.bluemobi.mvptest.mvp.presenter.callback.HttpRequestCallBack;

/**
 * Created by ${chenM} on ${2017}.
 */
public interface ILoginModel {
    void login(String data , HttpRequestCallBack callBack);
}
