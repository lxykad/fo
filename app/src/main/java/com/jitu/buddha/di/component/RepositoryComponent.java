package com.jitu.buddha.di.component;

import com.jitu.buddha.di.module.RepositoryModule;
import com.jitu.buddha.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by lxy
 */

@ActivityScope
@Component(modules = RepositoryModule.class, dependencies = AppComponent.class)
public interface RepositoryComponent {
//    void injectActivity(TestActivity activity);
//    void injectFragment(BaseFragment fragment);
}
