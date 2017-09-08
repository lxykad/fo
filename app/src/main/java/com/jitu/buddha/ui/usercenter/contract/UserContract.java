package com.jitu.buddha.ui.usercenter.contract;

import com.jitu.buddha.common.User;
import com.jitu.buddha.common.base.BaseView;

/**
 * Created by lxy
 */

public interface UserContract {

    interface View extends BaseView{

        void showResust(User user);
        void showNoData();
        void showError(String msg);
    }

}
