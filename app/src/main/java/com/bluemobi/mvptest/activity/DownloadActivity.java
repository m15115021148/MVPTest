package com.bluemobi.mvptest.activity;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.bluemobi.mvptest.R;
import com.bluemobi.mvptest.log.LogUtil;
import com.bluemobi.mvptest.mvp.model.DownloadModel;
import com.bluemobi.mvptest.mvp.presenter.presenter.DownloadPresenter;
import com.bluemobi.mvptest.mvp.view.DownloadView;
import com.bluemobi.mvptest.util.ToastUtil;
import com.bluemobi.mvptest.view.GADownloadingView;

import java.io.File;

import butterknife.BindView;

public class DownloadActivity extends BaseActivity<DownloadPresenter,DownloadView> implements DownloadView {
    private DownloadActivity mContext;
    @BindView(R.id.loadingView)
    public GADownloadingView mLoadingView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_download;
    }

    @Override
    protected DownloadPresenter getModelView() {
        return new DownloadPresenter(new DownloadModel());
    }

    @Override
    protected void initData() {
        mContext = this;
    }

    public void onDownload(View view) {
        mLoadingView.performAnimation();
        mLoadingView.updateProgress(0);
        mPresenter.onStartDownload();
    }

    public void onCancel(View view) {
        mPresenter.onCancelDownload();
    }

    @Override
    public void onDownloadProgress(long bytesRead, long contentLength) {
        double progress = bytesRead*100.0/contentLength;
        mLoadingView.updateProgress((int) progress);
    }

    @Override
    public void onDownloadSuccess(File file) {
        ToastUtil.showBottomShort(file.getPath());
    }

    @Override
    public void onDownloadFailure(String error) {
        ToastUtil.showBottomShort(error);
    }

    @Override
    public void cancelDownload() {
        mLoadingView.onFail();
        LogUtil.d("chenmeng","download is cancel");
    }

    @Override
    public String getDownloadUrl() {
        return "https://gmbw-photo-bucket.oss-cn-shanghai.aliyuncs.com/backend/photo/1531360124759_app-debug.apk";
    }

    @Override
    public String getDownloadFilePath() {
        String path = Environment.getExternalStorageDirectory() + "/Ahttp";
        return path;
    }

    @Override
    public String getDownloadFileName() {
        return "http.apk";
    }

}
