package com.bluemobi.mvptest.presenter;

import android.content.Context;
import android.content.Intent;

import com.bluemobi.mvptest.activity.SecondActivity;
import com.bluemobi.mvptest.application.MyApplication;
import com.bluemobi.mvptest.presenter.http.HttpRequestCallBack;
import com.bluemobi.mvptest.model.LoginModel;
import com.bluemobi.mvptest.presenter.base.BasePresenter;
import com.bluemobi.mvptest.view.LoginView;

/**
 * Created by ${chenM} on ${2017}.
 */
public class LoginPresenter extends BasePresenter<LoginView> implements ILoginPresenter {
    private LoginModel mLoginModel;
    private LoginView mLoginView;
    private Context mContext;

    public LoginPresenter(Context context,LoginModel model){
        this.mContext = context;
        this.mLoginModel = model;
    }

    @Override
    public void login(){
        checkViewAttach();
        mLoginView = getView();
        mLoginView.showLoading("Loading...");
        mLoginModel.login(mLoginView.getLoginData(), new HttpRequestCallBack() {
            @Override
            public void onSuccess(String result) {
                mLoginView.hideLoading();
                mLoginView.showResult(result);
                Intent intent = new Intent(mContext,SecondActivity.class);
                mContext.startActivity(intent);
            }

            @Override
            public void onFailure(String error) {
                mLoginView.hideLoading();
                mLoginView.showError(error);
            }

            @Override
            public void onCancel() {

            }
        });
    }

    @Override
    public void register() {
        checkViewAttach();
        mLoginView = getView();
        mLoginView.showLoading("登录中...");
        mLoginModel.register(mLoginView.getLoginData().getUserName(), mLoginView.getLoginData().getUserPassword(), new HttpRequestCallBack() {
            @Override
            public void onSuccess(String result) {
                mLoginView.hideLoading();
                mLoginView.showResult(result);
            }

            @Override
            public void onFailure(String error) {
                mLoginView.hideLoading();
                mLoginView.showError(error);
            }

            @Override
            public void onCancel() {

            }
        });
    }
}
