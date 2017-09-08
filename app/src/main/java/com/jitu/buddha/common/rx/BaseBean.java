package com.jitu.buddha.common.rx;

import java.io.Serializable;

/**
 * Created by lxy
 */

public class BaseBean<T> implements Serializable {

    public String message;
    public int code;
    public String error;

    public T results;

    @Override
    public String toString() {
        return "BaseBean{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", error='" + error + '\'' +
                ", results=" + results +
                '}';
    }
}
