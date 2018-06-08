package com.bluemobi.mvptest.presenter;

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

    public LoginPresenter(LoginModel model){
        this.mLoginModel = model;
    }

    @Override
    public void login(){
        checkViewAttach();
        mLoginView = getView();
        mLoginView.showLoading("Loading...");
        mLoginModel.login(mLoginView.getUserBean(), new HttpRequestCallBack() {
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

            @Override
            public void onCancel() {

            }
        });
    }
}
