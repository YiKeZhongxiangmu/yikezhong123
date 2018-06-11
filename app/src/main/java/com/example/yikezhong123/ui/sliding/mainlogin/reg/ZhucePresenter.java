package com.example.yikezhong123.ui.sliding.mainlogin.reg;

import com.example.yikezhong123.bean.RegBean;
import com.example.yikezhong123.net.ProjectApi;
import com.example.yikezhong123.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ZhucePresenter extends BasePresenter<ZhuceContract.View> implements ZhuceContract.Presenter{
    ProjectApi projectApi;
    @Inject
    public ZhucePresenter(ProjectApi projectApi) {
        this.projectApi = projectApi;
    }

    @Override
    public void reg(String mobile, String password) {
        projectApi.reg(mobile,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RegBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegBean regBean) {
                        mView.regSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
