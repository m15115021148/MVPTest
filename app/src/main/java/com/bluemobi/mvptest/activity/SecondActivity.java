package com.bluemobi.mvptest.activity;

import android.support.annotation.NonNull;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bluemobi.mvptest.R;
import com.bluemobi.mvptest.presenter.base.Presenter;

public class SecondActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_second;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected Presenter getModelView() {
        return null;
    }

}
