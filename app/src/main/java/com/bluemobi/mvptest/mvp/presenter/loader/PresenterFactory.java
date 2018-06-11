package com.bluemobi.mvptest.mvp.presenter.loader;

import com.bluemobi.mvptest.mvp.presenter.base.Presenter;

/**
 * Created by ${chenM} on ${2017}.
 */
public interface PresenterFactory<P extends Presenter> {
    P create();//create presenter
}
