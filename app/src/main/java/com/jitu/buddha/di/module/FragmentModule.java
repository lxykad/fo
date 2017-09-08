package com.jitu.buddha.di.module;

import com.jitu.buddha.data.api.ApiService;
import com.jitu.buddha.ui.home.SkilModel;
import com.jitu.buddha.ui.home.contract.SkilContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lxy
 */

@Module
public class FragmentModule {

    private SkilContract.View mView;

    public FragmentModule(SkilContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public SkilContract.View provideView(){

        return mView;
    }

    @Provides
    public SkilModel provideModel(ApiService apiService){

        return new SkilModel(apiService);
    }

}
