package com.example.yikezhong123.ui.duanzi;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yikezhong123.Component.DaggerHttpComponent;
import com.example.yikezhong123.R;
import com.example.yikezhong123.bean.DuanZiBean;
import com.example.yikezhong123.ui.base.BaseFragment;
import com.example.yikezhong123.ui.duanzi.adapter.DuanZiAdapter;
import com.example.yikezhong123.ui.duanzi.contract.DuanZiContract;
import com.example.yikezhong123.ui.duanzi.presenter.DuanZiPresenter;

public class Frag_duanzi extends BaseFragment<DuanZiPresenter> implements DuanZiContract.View{
    private View view;
    private RecyclerView mRlv;

    @Override
    public int getContentLayout() {
        return R.layout.frag_duanzi;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);

    }

    @Override
    public void initView(View view) {

        mRlv = (RecyclerView) view.findViewById(R.id.rlv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRlv.setLayoutManager(linearLayoutManager);
        mPresenter.getDuanZi();
    }


    @Override
    public void onSuccess(DuanZiBean duanZiBean) {
        DuanZiAdapter duanZiAdapter = new DuanZiAdapter(getContext(), duanZiBean.getData());
        mRlv.setAdapter(duanZiAdapter);

    }
}

