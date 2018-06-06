package com.example.yikezhong123.ui.duanzi.presenter;

import com.example.yikezhong123.bean.DuanZiBean;
import com.example.yikezhong123.net.DuanZiApi;
import com.example.yikezhong123.ui.base.BasePresenter;
import com.example.yikezhong123.ui.duanzi.contract.DuanZiContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DuanZiPresenter extends BasePresenter<DuanZiContract.View> implements DuanZiContract.Presenter {
    private DuanZiApi duanZiApi;
    @Inject
    public DuanZiPresenter(DuanZiApi duanZiApi) {
        this.duanZiApi = duanZiApi;
    }

    @Override
    public void getDuanZi() {
        duanZiApi.getDuanzi()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DuanZiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DuanZiBean duanZiBean) {
                     mView.onSuccess(duanZiBean);
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
