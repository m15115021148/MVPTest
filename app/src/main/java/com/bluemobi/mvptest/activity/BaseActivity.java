package com.bluemobi.mvptest.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.Toast;

import com.bluemobi.mvptest.presenter.base.Presenter;
import com.bluemobi.mvptest.view.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ${chenM} on ${2017}.
 */
public abstract class BaseActivity<P extends Presenter<V>, V extends BaseView> extends
        AppCompatActivity implements BaseView, LoaderManager.LoaderCallbacks<P> {
    protected static final String TAG_ESC_ACTIVITY = "com.broader.esc";
    private static final int BASE_LOADER_ID = 1000;//loader的id值
    private ProgressDialog mProgressDialog;
    protected P mPresenter;
    protected boolean startBlockKeys = false;
    private MyBroaderEsc receiver;//广播
    private Unbinder butterKnife;//取消绑定

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mProgressDialog = new ProgressDialog(this);
        getSupportLoaderManager().initLoader(BASE_LOADER_ID, null, this);
        receiver = new MyBroaderEsc();
        registerReceiver(receiver, new IntentFilter(TAG_ESC_ACTIVITY));
        butterKnife = ButterKnife.bind(this);
        initData();
    }

    protected abstract int getLayoutId();

    protected abstract void initData();

    private class MyBroaderEsc extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                butterKnife.unbind();
                finish();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.attachView((V) this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        unregisterReceiver(receiver);
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @NonNull
    @Override
    public Loader<P> onCreateLoader(int id, @Nullable Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<P> loader, P data) {
        mPresenter = data;
    }

    @Override
    public void onLoaderReset(@NonNull Loader<P> loader) {
        mPresenter = null;
    }

    @Override
    public void showLoading(String msg) {
        mProgressDialog.setMessage(msg);
        if (!mProgressDialog.isShowing()) mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing()) mProgressDialog.dismiss();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_MENU:
            case KeyEvent.KEYCODE_HOME:
            case KeyEvent.KEYCODE_BACK:
                if (startBlockKeys) return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
