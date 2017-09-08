package com.jitu.buddha.common.rx;

import android.content.Context;

import com.jitu.buddha.common.exception.ApiException;
import com.jitu.buddha.common.exception.BaseException;
import com.jitu.buddha.common.exception.ErrorMessageFactory;

import retrofit2.HttpException;

/**
 * Created by lxy
 */

public class RxErrorHandler {

    private Context mContext;

    public RxErrorHandler(Context context) {

        this.mContext = context;
    }

    public BaseException handleError(Throwable e) {

        BaseException exception = new BaseException();

        if (e instanceof ApiException) {

            exception.setCode(((ApiException) e).getCode());

        } else if (e instanceof HttpException) {

            exception.setCode(((HttpException) e).code());

        }

        exception.setDisplayMessage(ErrorMessageFactory.create(exception.getCode()));

        return exception;
    }

    public void showErrorMessage(BaseException e) {

        //Toast.makeText(mContext, e.getDisplayMessage(), Toast.LENGTH_LONG).show();

    }
}
