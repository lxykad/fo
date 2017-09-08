package com.jitu.buddha.di.component;

import com.jitu.buddha.common.base.BaseApplication;
import com.jitu.buddha.common.rx.RxErrorHandler;
import com.jitu.buddha.data.api.ApiService;
import com.jitu.buddha.di.module.AppModule;
import com.jitu.buddha.di.module.HttpModule;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by lxy
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    BaseApplication getBaseApplication();
    ApiService getApiService();
    RxErrorHandler getErrorHander();

}
