package com.jitu.buddha.ui.home.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jitu.buddha.R;
import com.jitu.buddha.common.base.BaseMainFragment;
import com.jitu.buddha.databinding.FragmentRecommendBinding;
import com.jitu.buddha.di.component.AppComponent;
import com.jitu.buddha.di.component.DaggerFragmentComponent;
import com.jitu.buddha.di.module.FragmentModule;
import com.jitu.buddha.ui.home.AndroidPresenter;
import com.jitu.buddha.ui.home.SkilBean;
import com.jitu.buddha.ui.home.adapter.HomeAdapter;
import com.jitu.buddha.ui.home.contract.SkilContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxy
 */

public class HomeFragment extends BaseMainFragment<AndroidPresenter> implements SkilContract.View {

    private FragmentRecommendBinding mBinding;
    private HomeAdapter mAdapter;
    private List<SkilBean.RealBean> mList;

    @Override
    protected void visiableToUser() {
    }

    @Override
    protected void firstVisiableToUser() {
        init();
        LoadData();
    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {
        DaggerFragmentComponent.builder().appComponent(appComponent)
                .fragmentModule(new FragmentModule(this)).build().inject(this);
    }

    @Override
    public int getLayoutId() {

        return R.layout.fragment_recommend;
    }

    @Override
    public void initChildBinding() {
        mBinding = (FragmentRecommendBinding) mChildBinding;
    }

    @Override
    public void onEmptyClick(View view) {
        LoadData();
    }

    public void init() {
        mList = new ArrayList<>();
        mAdapter = new HomeAdapter(R.layout.list_item_recommend_fragment, mList, getContext());
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                SkilBean.RealBean appBean = mList.get(position);
                Toast.makeText(view.getContext(), appBean.who, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void LoadData() {
//        mPresenter.getAndroidData();//不缓存
        mPresenter.getAndroidDataWithCache("Android", 15, 1, false);

    }

    @Override
    public void showResust(List<SkilBean.RealBean> list) {
        mAdapter.addItems(list);
    }

    @Override
    public void showNoData() {

    }

}
