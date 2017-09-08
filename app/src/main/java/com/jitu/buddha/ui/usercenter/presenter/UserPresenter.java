package com.jitu.buddha.ui.usercenter.presenter;

import com.jitu.buddha.common.User;
import com.jitu.buddha.common.base.BasePresenter;
import com.jitu.buddha.common.rx.RxHttpResponse;
import com.jitu.buddha.common.rx.observer.ProgressObserver;
import com.jitu.buddha.ui.usercenter.UserModel;
import com.jitu.buddha.ui.usercenter.contract.UserContract;

import javax.inject.Inject;

/**
 * Created by lxy
 */

public class UserPresenter extends BasePresenter<UserModel,UserContract.View> {

    @Inject
    public UserPresenter(UserModel mModel, UserContract.View mView) {
        super(mModel, mView);
    }

    public void getUserInfo(){
        mModel.getUserInfo()
                .compose(RxHttpResponse.<User>handResult())
                .subscribe(new ProgressObserver<User>(mContext,mView) {
                    @Override
                    public void onNext(User user) {

                    }
                });
    }

}
