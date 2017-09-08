package com.jitu.buddha.ui.temple;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.jitu.buddha.R;
import com.jitu.buddha.common.base.BaseActivity;
import com.jitu.buddha.di.component.AppComponent;
import com.jitu.buddha.ui.buddhaobj.ObjectActivity;

/**
 * Created by lxy on 2017/9/8.
 */

public class TempleActivity extends BaseActivity {

    public static void goToPage(Context context){
        Intent intent = new Intent(context,TempleActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onEmptyClick(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_temple;
    }

    @Override
    public void initChildBinding() {

    }

    @Override
    protected void setActivityComponent(AppComponent appComponent) {

    }
}
