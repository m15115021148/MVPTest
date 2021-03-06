package com.bluemobi.mvptest.mvp.presenter.presenter;

import android.text.TextUtils;

import com.bluemobi.mvptest.mvp.model.DownloadModel;
import com.bluemobi.mvptest.mvp.presenter.base.BasePresenter;
import com.bluemobi.mvptest.mvp.presenter.callback.HttpRequestProgressCallBack;
import com.bluemobi.mvptest.mvp.view.DownloadView;

import java.io.File;

/**
 * Created by ${chenM} on 2018/7/24.
 */
public class DownloadPresenter extends BasePresenter<DownloadView> implements IDownloadPresenter{
    private DownloadModel mModel;
    private DownloadView mView;

    public DownloadPresenter(DownloadModel model){
        this.mModel = model;
    }

    @Override
    public void onStartDownload() {
        checkViewAttach();
        mView = getView();
        mModel.startDownload(mView.getDownloadUrl(), mView.getDownloadFilePath(), mView.getDownloadFileName(), new HttpRequestProgressCallBack<File>() {
            @Override
            public void onProgress(long byteReads, long contentReads) {
                mView.onDownloadProgress(byteReads, contentReads);
            }

            @Override
            public void onSuccess(File file) {
                mView.onDownloadSuccess(file);
            }

            @Override
            public void onFailure(String error) {
                mView.onDownloadFailure(error);
            }
        });
    }

    @Override
    public void onCancelDownload() {
        checkViewAttach();
        mView = getView();
        mModel.cancelDownload();
        mView.cancelDownload();
    }

}
