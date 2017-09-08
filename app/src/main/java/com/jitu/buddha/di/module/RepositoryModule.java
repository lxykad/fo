package com.jitu.buddha.di.module;

import com.jitu.buddha.common.base.BaseApplication;
import com.jitu.buddha.common.http.Repository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lxy
 */

@Module
public class RepositoryModule {

    @Provides
    public Repository provideRepository(){
      return  Repository.init(BaseApplication.getInstance().getCacheDir());
    }

}
