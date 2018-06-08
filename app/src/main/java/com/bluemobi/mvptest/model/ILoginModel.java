package com.bluemobi.mvptest.model;

import com.bluemobi.mvptest.bean.LoginBean;
import com.bluemobi.mvptest.presenter.http.HttpRequestCallBack;

/**
 * Created by ${chenM} on ${2017}.
 */
public interface ILoginModel {
    void login(LoginBean bean , HttpRequestCallBack callBack);
    void register(String userName,String password,HttpRequestCallBack callBack);
}
