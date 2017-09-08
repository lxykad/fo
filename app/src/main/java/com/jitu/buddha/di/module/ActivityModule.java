package com.jitu.buddha.di.module;

import com.jitu.buddha.data.api.ApiService;
import com.jitu.buddha.ui.usercenter.UserModel;
import com.jitu.buddha.ui.usercenter.contract.UserContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lxy
 */

@Module
public class ActivityModule {

    private UserContract.View mView;

    public ActivityModule(UserContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public UserContract.View provideView(){

        return mView;
    }

    @Provides
    public UserModel provideModel(ApiService apiService){

        return new UserModel(apiService);
    }
}
