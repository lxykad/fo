package com.jitu.buddha.di.module;

import com.jitu.buddha.common.base.BaseApplication;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by lxy
 */

@Module
public class AppModule {

    private BaseApplication mApplication;

    public AppModule(BaseApplication application) {
        mApplication = application;
    }

    @Provides
    public BaseApplication getBaseApplication(Retrofit retrofit){

        return mApplication;
    }
}
