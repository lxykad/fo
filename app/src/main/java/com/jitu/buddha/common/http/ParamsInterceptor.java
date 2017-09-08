package com.jitu.buddha.common.http;

import com.jitu.buddha.common.constant.Constant;
import com.jitu.buddha.common.User;
import com.orhanobut.hawk.Hawk;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lxy
 */

public class ParamsInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request;

        User user = Hawk.get(Constant.GLOBAL_USER);

        if (user == null) {// 未登录
           request = chain.request().newBuilder()
                    .build();
        } else {
            request = chain.request().newBuilder()
                    .addHeader(Constant.TOKEN, user.token)
                    .build();
        }

        return chain.proceed(request);
    }

}
