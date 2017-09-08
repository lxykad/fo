package com.jitu.buddha.ui.usercenter;

import com.jitu.buddha.common.User;
import com.jitu.buddha.data.api.ApiService;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by lxy on
 */

public class UserModel {
    private ApiService mApiService;

    public UserModel(ApiService mApiService) {
        this.mApiService = mApiService;
    }

    public Observable<Response<User>> getUserInfo(){

//         return mApiService.getUserInfo("token");//get
        return mApiService.getUserInfo();
    }
}
