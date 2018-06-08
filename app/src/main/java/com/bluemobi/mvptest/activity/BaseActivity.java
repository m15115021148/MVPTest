package com.bluemobi.mvptest.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bluemobi.mvptest.presenter.base.Presenter;
import com.bluemobi.mvptest.view.BaseView;

/**
 * Created by ${chenM} on ${2017}.
 */
public abstract class BaseActivity<P extends Presenter<V>, V extends BaseView> extends
        AppCompatActivity implements BaseView, LoaderManager.LoaderCallbacks<P> {
    private static final int BASE_LOADER_ID = 1000;//loader的id值
    private ProgressDialog mProgressDialog;
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new ProgressDialog(this);
        getSupportLoaderManager().initLoader(BASE_LOADER_ID, null, this);
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
    protected void onDestroy() {
        mPresenter.detachView();
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

}
