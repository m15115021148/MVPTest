package com.bluemobi.mvptest.view;

import com.bluemobi.mvptest.bean.UserBean;

/**
 * Created by ${chenM} on ${2017}.
 */
public interface LoginView {
    void showLoading(String msg);
    void hideLoading();
    void showResult(UserBean bean);
    void showError(String error);
    UserBean getUserBean();
}
