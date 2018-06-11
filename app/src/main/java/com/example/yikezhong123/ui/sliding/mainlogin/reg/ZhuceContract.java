package com.example.yikezhong123.ui.sliding.mainlogin.reg;

import com.example.yikezhong123.ui.base.BaseContract;

public interface ZhuceContract {
    interface View extends BaseContract.BaseView {
        void regSuccess();
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void reg(String mobile, String password);
    }
}
