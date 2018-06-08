package com.bluemobi.mvptest.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bluemobi.mvptest.R;
import com.bluemobi.mvptest.bean.UserBean;
import com.bluemobi.mvptest.model.UserModel;
import com.bluemobi.mvptest.presenter.LoginPresenter;
import com.bluemobi.mvptest.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {
    private EditText mUserName;
    private EditText mUserPwd;
    private ProgressDialog progressDialog;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserName = findViewById(R.id.userName);
        mUserPwd = findViewById(R.id.password);
        progressDialog = new ProgressDialog(this);
        mPresenter = new LoginPresenter(new UserModel(),this);
    }

    public void onLogin(View view) {
        mPresenter.login();
    }

    @Override
    public void showLoading(String msg) {
        progressDialog.setMessage(msg);
        if (!progressDialog.isShowing())progressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (progressDialog.isShowing())progressDialog.dismiss();
    }

    @Override
    public void showResult(UserBean bean) {
        Toast.makeText(this,bean.getUserName()+" -- " + bean.getUserPassword(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public UserBean getUserBean() {
        UserBean bean = new UserBean();
        bean.setUserName(mUserName.getText().toString());
        bean.setUserPassword(mUserPwd.getText().toString());
        return bean;
    }
}
