package com.jitu.buddha.common.base;

import android.app.Application;

import com.jitu.buddha.R;
import com.jitu.buddha.common.http.Repository;
import com.jitu.buddha.di.component.AppComponent;
import com.jitu.buddha.di.component.DaggerAppComponent;
import com.jitu.buddha.di.module.AppModule;
import com.jitu.buddha.di.module.HttpModule;
import com.orhanobut.hawk.Hawk;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by lxy
 */

public class BaseApplication extends Application {

    private static BaseApplication sInstance;
    private AppComponent mAppComponent;
    private Repository mRepository;

    public static BaseApplication getInstance() {

        return sInstance;
    }
    public Repository getRepository() {

        return mRepository;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).httpModule(new HttpModule()).build();
        Hawk.init(this).build();

        mRepository = Repository.init(getCacheDir());
        Logger.addLogAdapter(new AndroidLogAdapter(){
            @Override
            public boolean isLoggable(int priority, String tag) {

               return getResources().getBoolean(R.bool.DEBUG);
            }
        });

    }

    public AppComponent getAppComponent() {

        return mAppComponent;
    }

}
