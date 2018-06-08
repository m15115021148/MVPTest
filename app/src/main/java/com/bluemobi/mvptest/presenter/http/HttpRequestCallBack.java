package com.bluemobi.mvptest.presenter.http;

/**
 * Created by ${chenM} on ${2017}.
 */
public interface HttpRequestCallBack {
    void onSuccess();
    void onFailure(String error);
    void onCancel();
}
