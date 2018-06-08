package com.bluemobi.mvptest.presenter.base;

import com.bluemobi.mvptest.view.BaseView;

/**
 * Created by ${chenM} on ${2017}.
 */
public class BasePresenter<V extends BaseView> implements Presenter<V> {
    private V view;

    @Override
    public void attachView(V baseView) {
        this.view = baseView;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    public boolean isAttachView() {
        return this.view != null;
    }

    public V getView() {
        return this.view;
    }

    public void checkViewAttach() {
        if (!isAttachView()) {
            throw new MvpViewNotAttachedException();
        }
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("not binding view");
        }
    }

}
