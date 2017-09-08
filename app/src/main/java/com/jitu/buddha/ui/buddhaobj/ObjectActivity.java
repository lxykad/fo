package com.jitu.buddha.ui.buddhaobj;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.jitu.buddha.R;
import com.jitu.buddha.common.base.BaseActivity;
import com.jitu.buddha.di.component.AppComponent;

/**
 * Created by lxy
 */

public class ObjectActivity extends BaseActivity {

    public static void goToPage(Context context){
        Intent intent = new Intent(context,ObjectActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onEmptyClick(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_object;
    }

    @Override
    public void initChildBinding() {

    }

    @Override
    protected void setActivityComponent(AppComponent appComponent) {

    }
}
