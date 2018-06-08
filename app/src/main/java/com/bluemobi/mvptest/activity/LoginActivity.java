package com.bluemobi.mvptest.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bluemobi.mvptest.R;
import com.bluemobi.mvptest.bean.LoginBean;
import com.bluemobi.mvptest.model.LoginModel;
import com.bluemobi.mvptest.presenter.LoginPresenter;
import com.bluemobi.mvptest.util.ToastUtil;
import com.bluemobi.mvptest.view.LoginView;

import butterknife.BindView;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginView> implements LoginView {
    @BindView(R.id.userName)
    public EditText mUserName;
    @BindView(R.id.password)
    public EditText mUserPwd;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected LoginPresenter getModelView() {
        return new LoginPresenter(new LoginModel());
    }

    public void onLogin(View view) {
        mPresenter.login();
    }

    @Override
    public void showResult(String result) {
        ToastUtil.showBottomShort(result);
    }

    @Override
    public LoginBean getLoginData() {
        LoginBean bean = new LoginBean();
        bean.setUserName(mUserName.getText().toString());
        bean.setUserPassword(mUserPwd.getText().toString());
        return bean;
    }

    public void onRegister(View view) {
        mPresenter.register();
    }
}
