package com.jitu.buddha.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.jakewharton.rxbinding2.view.RxView;
import com.jitu.buddha.R;
import com.jitu.buddha.common.base.BaseActivity;
import com.jitu.buddha.databinding.ActivityMainBinding;
import com.jitu.buddha.di.component.AppComponent;
import com.jitu.buddha.ui.buddhaobj.ObjectActivity;
import com.jitu.buddha.ui.buddhathing.ThingActivity;
import com.jitu.buddha.ui.lesson.LessonActivity;
import com.jitu.buddha.ui.live.LiveActivity;
import com.jitu.buddha.ui.pray.PrayActivity;
import com.jitu.buddha.ui.usercenter.UsercenterActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity {

    private static final int SECOND = 2;
    private ActivityMainBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initEvents(MainActivity.this);
    }

    @Override
    protected void onEmptyClick(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initChildBinding() {
        mBinding = (ActivityMainBinding) mChildBinding;
    }

    @Override
    protected void setActivityComponent(AppComponent appComponent) {

    }

    public void initEvents(final Context context){
        RxView.clicks(mBinding.pray)
                .throttleFirst(SECOND, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        PrayActivity.goToPage(context);
                    }
                });

        RxView.clicks(mBinding.temple)
                .throttleFirst(SECOND, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        ThingActivity.goToPage(context);
                    }
                });
        RxView.clicks(mBinding.object)
                .throttleFirst(SECOND, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        ObjectActivity.goToPage(context);
                    }
                });
        RxView.clicks(mBinding.thing)
                .throttleFirst(SECOND, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        ThingActivity.goToPage(context);
                    }
                });
        RxView.clicks(mBinding.lesson)
                .throttleFirst(SECOND, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        LessonActivity.goToPage(context);
                    }
                });
        RxView.clicks(mBinding.live)
                .throttleFirst(SECOND, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        LiveActivity.goToPage(context);
                    }
                });
        RxView.clicks(mBinding.user)
                .throttleFirst(SECOND, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        UsercenterActivity.goToPage(context);
                    }
                });

    }

}
