package com.bluemobi.mvptest.mvp.presenter.presenter;

import com.bluemobi.mvptest.mvp.presenter.callback.HttpRequestCallBack;
import com.bluemobi.mvptest.mvp.model.LoginModel;
import com.bluemobi.mvptest.mvp.presenter.base.BasePresenter;
import com.bluemobi.mvptest.mvp.view.LoginView;

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
        mLoginModel.login(mLoginView.getLogin(), new HttpRequestCallBack() {
            @Override
            public void onSuccess(String result) {
                mLoginView.showResult(result);
            }

            @Override
            public void onFailure(String error) {
                mLoginView.onFailure(error);
            }
        });
    }
}
