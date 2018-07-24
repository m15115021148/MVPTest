package com.bluemobi.mvptest.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.alibaba.fastjson.JSON;
import com.bluemobi.mvptest.R;
import com.bluemobi.mvptest.application.MyApplication;
import com.bluemobi.mvptest.config.RequestCode;
import com.bluemobi.mvptest.mvp.model.LoginModel;
import com.bluemobi.mvptest.mvp.presenter.presenter.LoginPresenter;
import com.bluemobi.mvptest.util.ToastUtil;
import com.bluemobi.mvptest.mvp.view.LoginView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginView> implements LoginView {
    private LoginActivity mContext;
    @BindView(R.id.userName)
    public EditText mUserName;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        mContext = this;
    }

    @Override
    protected LoginPresenter getModelView() {
        return new LoginPresenter(new LoginModel(this));
    }

    public void onLogin(View view) {
        mPresenter.login();
    }

    public void onDownload(View view) {
        Intent intent = new Intent(mContext,DownloadActivity.class);
        startActivity(intent);
    }

    @Override
    public void showResult(String result) {
        ToastUtil.showBottomShort(result);
    }

    @Override
    public String getLogin() {
        Map<String,Object> map = new HashMap<>();
        map.put("token",MyApplication.getInstance().getDeviceID(this));
        map.put("lang", RequestCode.USER_LANG);
        map.put("bundle_id",RequestCode.USER_BUNDLE_ID);
        map.put("name",mUserName.getText().toString());
        map.put("versionCode", MyApplication.getInstance().getVersionCode());
        map.put("versionName",MyApplication.getInstance().getVersionName());
        map.put("appKey",RequestCode.APP_KEY);
        map.put("appSecret",RequestCode.APP_SECRET);
        return JSON.toJSONString(map);
    }

    @Override
    public void onBackPressed() {
        exitApp();
        super.onBackPressed();
    }

}
