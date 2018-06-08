package com.example.yikezhong123.ui.shiping.presenter;

import com.example.yikezhong123.bean.HotVideosBean;
import com.example.yikezhong123.net.HotVideosApi;
import com.example.yikezhong123.ui.base.BasePresenter;
import com.example.yikezhong123.ui.shiping.contract.HotVideosContract;


import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HotVideosPresenter extends BasePresenter<HotVideosContract.View> implements HotVideosContract.Presenter {
    private HotVideosApi hotVideosApi;
    @Inject
    public HotVideosPresenter(HotVideosApi hotVideosApi) {
        this.hotVideosApi = hotVideosApi;
    }



    @Override
    public void getHotVideos(String page, String token) {
        hotVideosApi.getHotVideos(page,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<HotVideosBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotVideosBean hotVideosBean) {
                      mView.onHotVideosSuccess(hotVideosBean);
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
