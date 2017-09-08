package com.jitu.buddha.common.rx.observer;

import android.content.Context;

import com.jitu.buddha.common.exception.BaseException;
import com.jitu.buddha.common.rx.RxErrorHandler;

/**
 * Created by lxy
 */

public abstract class ErrorHandObserver<T> extends BaseObserver<T> {

    protected RxErrorHandler mErrorHandler = null;

    public ErrorHandObserver(Context context) {
       mErrorHandler = new RxErrorHandler(context);
    }

    @Override
    public void onError(Throwable e) {

        BaseException baseException = mErrorHandler.handleError(e);

        if (baseException == null) {

            e.printStackTrace();

        } else {
            mErrorHandler.showErrorMessage(baseException);
        }

    }
}
