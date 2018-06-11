package com.example.yikezhong123.ui.sliding.mainlogin.login;

import com.example.yikezhong123.bean.UserBean;
import com.example.yikezhong123.ui.base.BaseContract;

public interface LoginContract {
    interface view extends BaseContract.BaseView{
        void loginSuccess(UserBean userBean);

    }
    interface presenter extends BaseContract.BasePresenter<view> {
        void login(String mobile, String password);
    }
}
