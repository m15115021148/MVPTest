package com.bluemobi.mvptest.presenter.loader;

import com.bluemobi.mvptest.presenter.base.Presenter;

/**
 * Created by ${chenM} on ${2017}.
 */
public interface PresenterFactory<P extends Presenter> {
    P create();//create presenter
}
