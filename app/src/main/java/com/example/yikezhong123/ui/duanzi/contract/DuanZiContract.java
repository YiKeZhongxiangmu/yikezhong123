package com.example.yikezhong123.ui.duanzi.contract;

import com.example.yikezhong123.bean.AdBean;
import com.example.yikezhong123.bean.DuanZiBean;
import com.example.yikezhong123.bean.JokesBean;
import com.example.yikezhong123.ui.Recommend.contract.GetAdContract;
import com.example.yikezhong123.ui.base.BaseContract;

public interface DuanZiContract {
    interface View extends BaseContract.BaseView{
       void onSuccess(DuanZiBean duanZiBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getDuanZi();

    }
}
