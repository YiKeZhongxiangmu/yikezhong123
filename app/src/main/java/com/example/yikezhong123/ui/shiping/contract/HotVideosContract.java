package com.example.yikezhong123.ui.shiping.contract;

import com.example.yikezhong123.bean.AdBean;
import com.example.yikezhong123.bean.HotVideosBean;
import com.example.yikezhong123.bean.JokesBean;
import com.example.yikezhong123.ui.Recommend.contract.GetAdContract;
import com.example.yikezhong123.ui.base.BaseContract;

public interface HotVideosContract {
    interface View extends BaseContract.BaseView{
        void onHotVideosSuccess(HotVideosBean hotVideosBean);

    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getHotVideos(String page, String token);

    }
}
