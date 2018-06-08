package com.bluemobi.mvptest.presenter.http;

/**
 * Created by ${chenM} on ${2017}.
 */
public interface HttpRequestCallBack {
    void onSuccess(String result);
    void onFailure(String error);
    void onCancel();
}
