package com.example.yikezhong123.ui.Recommend;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.yikezhong123.Component.DaggerHttpComponent;
import com.example.yikezhong123.R;
import com.example.yikezhong123.bean.AdBean;
import com.example.yikezhong123.bean.JokesBean;
import com.example.yikezhong123.ui.Recommend.Presenter.GetAdPresenter;
import com.example.yikezhong123.ui.Recommend.adapter.RecommendAdapter;
import com.example.yikezhong123.ui.Recommend.contract.GetAdContract;
import com.example.yikezhong123.ui.base.BaseFragment;

public class GuanZhuFragment extends BaseFragment<GetAdPresenter> implements GetAdContract.View {
    private View view;
    private ImageView mImage;
    private RecyclerView mRlv;

    @Override
    public int getContentLayout() {
        return R.layout.guanzhu_layout;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);

    }

    @Override
    public void initView(View view) {

        mImage = (ImageView) view.findViewById(R.id.image);
        mRlv = (RecyclerView) view.findViewById(R.id.rlv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRlv.setLayoutManager(linearLayoutManager);
        mImage.setBackgroundResource(R.drawable.belle);

        mPresenter.getJokes();
    }

    @Override
    public void onSuccess(AdBean adBean) {

    }

    @Override
    public void onJokesSuccess(JokesBean jokesBean) {
        RecommendAdapter recommendAdapter = new RecommendAdapter(getContext(), jokesBean.getData());
        mRlv.setAdapter(recommendAdapter);

    }


}
