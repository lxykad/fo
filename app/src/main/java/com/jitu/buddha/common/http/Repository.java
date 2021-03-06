package com.jitu.buddha.common.http;

import com.jitu.buddha.data.api.ApiService;
import com.jitu.buddha.data.api.CacheProviders;
import com.jitu.buddha.ui.home.SkilBean;

import java.io.File;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.Reply;
import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lxy
 */

public class Repository {

    private CacheProviders cacheProviders;
    private ApiService mApiService;

    // .useExpiredDataIfLoaderNotAvailable(true)
    public Repository(File cacheDir) {
        cacheProviders = new RxCache.Builder()
                .persistence(cacheDir, new GsonSpeaker())
                .using(CacheProviders.class);
        mApiService = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
    }

    public static Repository init(File cacheDir) {
        return new Repository(cacheDir);
    }

    // 获取 Android 列表
    public Observable<Reply<Response<SkilBean>>> getSkilList(String type, int count, int page, final boolean loadServer) {

        return cacheProviders.getSkilList(mApiService.getSkilList(type, count, page), new DynamicKey(page), new EvictDynamicKey(loadServer));
    }
}
