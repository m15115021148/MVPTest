package com.bluemobi.mvptest.mvp.presenter.callback;

import java.io.File;

/**
 * Created by ${chenM} on 2018/7/24.
 */
public interface HttpRequestProgressCallBack<T> extends HttpCallBack<T>{
    void onProgress(long byteReads,long contentReads);
}
