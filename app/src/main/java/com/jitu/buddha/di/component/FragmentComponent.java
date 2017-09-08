package com.jitu.buddha.di.component;

import com.jitu.buddha.di.module.FragmentModule;
import com.jitu.buddha.di.scope.ActivityScope;
import com.jitu.buddha.ui.home.fragment.HomeFragment;

import dagger.Component;

/**
 * Created by lxy
 */
@ActivityScope
@Component(modules = FragmentModule.class, dependencies = AppComponent.class)
public interface FragmentComponent {

    //void inject(MainActivity activity);
    void inject(HomeFragment fragment);
}
