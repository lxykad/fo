package com.jitu.buddha.di.component;

import com.jitu.buddha.di.module.ActivityModule;
import com.jitu.buddha.di.module.RepositoryModule;
import com.jitu.buddha.di.scope.ActivityScope;
import com.jitu.buddha.ui.usercenter.UsercenterActivity;

import dagger.Component;

/**
 * Created by lxy
 */

@ActivityScope
@Component(modules = {ActivityModule.class, RepositoryModule.class}, dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(UsercenterActivity activity);
}
