package com.bluemobi.mvptest.model;

import com.bluemobi.mvptest.bean.LoginBean;
import com.bluemobi.mvptest.interfaces.LoginCallBack;

/**
 * Created by ${chenM} on ${2017}.
 */
public interface ILoginModel {
    void login(LoginBean bean , LoginCallBack callBack);
}
