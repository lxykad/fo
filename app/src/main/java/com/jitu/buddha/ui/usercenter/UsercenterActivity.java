package com.jitu.buddha.ui.usercenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.jitu.buddha.R;
import com.jitu.buddha.common.User;
import com.jitu.buddha.common.base.BaseActivity;
import com.jitu.buddha.common.http.Repository;
import com.jitu.buddha.databinding.ActivityUsercenterBinding;
import com.jitu.buddha.di.component.AppComponent;
import com.jitu.buddha.di.component.DaggerActivityComponent;
import com.jitu.buddha.di.module.ActivityModule;
import com.jitu.buddha.di.module.RepositoryModule;
import com.jitu.buddha.ui.buddhaobj.ObjectActivity;
import com.jitu.buddha.ui.usercenter.contract.UserContract;
import com.jitu.buddha.ui.usercenter.presenter.UserPresenter;

public class UsercenterActivity extends BaseActivity<UserPresenter> implements UserContract.View {

    private ActivityUsercenterBinding mBinding;
    Repository repository;

    public static void goToPage(Context context){
        Intent intent = new Intent(context,UsercenterActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // mPresenter.getUserInfo();
    }

    @Override
    protected void onEmptyClick(View view) {
        mPresenter.getUserInfo();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_usercenter;
    }

    @Override
    public void initChildBinding() {
        mBinding = (ActivityUsercenterBinding) mChildBinding;
    }

    public void clickTest(View view) {
//        mPresenter.getUserInfo();
        //showToast(BaseApplication.getInstance().getResources().getBoolean(R.bool.DEBUG) + "");
//        startActivity(new Intent(this, TestActivity.class));
    }

    @Override
    protected void setActivityComponent(AppComponent appComponent) {
        DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(new ActivityModule(this))
                .repositoryModule(new RepositoryModule())
                .build()
                .inject(this);
    }

    @Override
    public void showResust(User user) {

    }

    @Override
    public void showNoData() {

    }
}
