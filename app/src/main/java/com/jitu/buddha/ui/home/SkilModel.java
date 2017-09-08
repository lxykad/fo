package com.jitu.buddha.ui.home;

import com.jitu.buddha.data.api.ApiService;

import io.reactivex.Observable;
import retrofit2.Response;


/**
 * Created by lxy
 */

public class SkilModel {

    public ApiService mApiService;


    public SkilModel(ApiService mApiService) {
        this.mApiService = mApiService;
    }

    public Observable<Response<SkilBean>> getList(String type, int page, int perPage) {

        return mApiService.getSkilList(type, page, perPage);
    }
}
