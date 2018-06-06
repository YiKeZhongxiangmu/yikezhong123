package com.example.yikezhong123.ui.Recommend.contract;


import com.example.yikezhong123.bean.AdBean;
import com.example.yikezhong123.bean.JokesBean;
import com.example.yikezhong123.ui.base.BaseContract;

public interface GetAdContract {
    interface View extends BaseContract.BaseView{
        void onSuccess(AdBean adBean);

        void onJokesSuccess(JokesBean jokesBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getAd();

        void getJokes();
    }
}
