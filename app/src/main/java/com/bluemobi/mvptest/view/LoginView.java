package com.bluemobi.mvptest.view;

import com.bluemobi.mvptest.bean.LoginBean;

/**
 * Created by ${chenM} on ${2017}.
 */
public interface LoginView extends BaseView{
    void showResult(String result);
    LoginBean getLoginData();
}
