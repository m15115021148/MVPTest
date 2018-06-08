package com.bluemobi.mvptest.model;


import android.os.Handler;
import android.os.Looper;

import com.bluemobi.mvptest.bean.LoginBean;
import com.bluemobi.mvptest.presenter.http.HttpRequestCallBack;

/**
 * Created by ${chenM} on ${2017}.
 */
public class LoginModel implements ILoginModel{
    private Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public void login(final LoginBean bean, final HttpRequestCallBack callBack){
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (bean.getUserName().equals("cmm") && bean.getUserPassword().equals("123456")){
                    callBack.onSuccess("注册成功");
                }else {
                    callBack.onFailure("用户名不存在");
                }
            }
        },5000);
    }

}
