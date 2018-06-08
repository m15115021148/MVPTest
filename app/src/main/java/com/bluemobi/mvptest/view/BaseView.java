package com.bluemobi.mvptest.view;

/**
 * Created by ${chenM} on ${2017}.
 */
public interface BaseView {
    void showLoading(String msg);
    void hideLoading();
    void showError(String error);
}
