package com.bluemobi.mvptest.mvp.presenter.presenter;

import android.content.Context;

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
        mLoginModel.login(mLoginView.getLogin(), new HttpRequestCallBack() {
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
