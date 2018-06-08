package com.bluemobi.mvptest.presenter;

import com.bluemobi.mvptest.interfaces.UserCallBack;
import com.bluemobi.mvptest.model.UserModel;
import com.bluemobi.mvptest.view.LoginView;

/**
 * Created by ${chenM} on ${2017}.
 */
public class LoginPresenter {
    private UserModel mUserModel;
    private LoginView mLoginView;

    public LoginPresenter(UserModel model,LoginView view){
        this.mUserModel = model;
        this.mLoginView = view;
    }

    public void login(){
        mLoginView.showLoading("Loading...");
        mUserModel.login(mLoginView.getUserBean(), new UserCallBack() {
            @Override
            public void onSuccess() {
                mLoginView.hideLoading();
                mLoginView.showResult(mLoginView.getUserBean());
            }

            @Override
            public void onFailure(String error) {
                mLoginView.hideLoading();
                mLoginView.showError(error);
            }
        });
    }
}
