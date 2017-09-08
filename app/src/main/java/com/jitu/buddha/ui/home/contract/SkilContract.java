package com.jitu.buddha.ui.home.contract;

import com.jitu.buddha.common.base.BaseView;
import com.jitu.buddha.ui.home.SkilBean;

import java.util.List;

/**
 * Created by lxy
 */

public interface SkilContract {

    interface View extends BaseView{

        void showResust(List<SkilBean.RealBean> list);
        void showNoData();
        void showError(String msg);
    }
}
