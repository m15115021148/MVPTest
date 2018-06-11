package com.bluemobi.mvptest.mvp.model;


import android.os.Handler;
import android.os.Looper;

import com.alibaba.fastjson.JSON;
import com.bluemobi.mvptest.bean.ClientBean;
import com.bluemobi.mvptest.http.rxjava.observer.BaseObserver;
import com.bluemobi.mvptest.http.service.HttpManager;
import com.bluemobi.mvptest.mvp.presenter.callback.HttpRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ${chenM} on ${2017}.
 */
public class LoginModel implements ILoginModel{
    private Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public void login(String data, final HttpRequestCallBack callBack){
        HttpManager.getApiService().registerApp(HttpManager.getParameter(data))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<ClientBean>() {
                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(e.getMessage());
                    }

                    @Override
                    protected void onSuccess(ClientBean model) {
                        if (model.getResult()==200){
                            callBack.onSuccess(JSON.toJSONString(model));
                        }else{
                            callBack.onFailure(model.getReason());
                        }
                    }
                });
    }

}
