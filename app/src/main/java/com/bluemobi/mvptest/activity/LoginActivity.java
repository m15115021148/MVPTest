package com.bluemobi.mvptest.activity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bluemobi.mvptest.R;
import com.bluemobi.mvptest.bean.LoginBean;
import com.bluemobi.mvptest.model.LoginModel;
import com.bluemobi.mvptest.presenter.LoginPresenter;
import com.bluemobi.mvptest.presenter.loader.PresenterFactory;
import com.bluemobi.mvptest.presenter.loader.PresenterLoader;
import com.bluemobi.mvptest.view.LoginView;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginView> implements LoginView {
    private EditText mUserName;
    private EditText mUserPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUserName = findViewById(R.id.userName);
        mUserPwd = findViewById(R.id.password);
    }

    public void onLogin(View view) {
        mPresenter.login();
    }

    @NonNull
    @Override
    public Loader<LoginPresenter> onCreateLoader(int id, @Nullable Bundle args) {
        return new PresenterLoader<>(this, new PresenterFactory<LoginPresenter>() {
            @Override
            public LoginPresenter create() {
                return new LoginPresenter(new LoginModel());
            }
        });
    }

    @Override
    public void showResult(LoginBean bean) {
        Toast.makeText(this, bean.getUserName() + " -- " + bean.getUserPassword(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public LoginBean getUserBean() {
        LoginBean bean = new LoginBean();
        bean.setUserName(mUserName.getText().toString());
        bean.setUserPassword(mUserPwd.getText().toString());
        return bean;
    }
}
