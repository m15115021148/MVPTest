package com.bluemobi.mvptest.model;


import android.os.Handler;
import android.os.Looper;

import com.bluemobi.mvptest.bean.UserBean;
import com.bluemobi.mvptest.interfaces.UserCallBack;

/**
 * Created by ${chenM} on ${2017}.
 */
public class UserModel {
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public void login(final UserBean bean, final UserCallBack callBack){
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (bean.getUserName().equals("cmm") && bean.getUserPassword().equals("123456")){
                    callBack.onSuccess();
                }else {
                    callBack.onFailure("用户名不存在");
                }
            }
        },3000);
    }

}
