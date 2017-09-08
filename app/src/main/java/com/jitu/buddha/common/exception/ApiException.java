package com.jitu.buddha.common.exception;

/**
 * Created by lxy
 */

public class ApiException extends BaseException{

    public ApiException(int code, String displayMessage) {
        super(code, displayMessage);
    }
}
