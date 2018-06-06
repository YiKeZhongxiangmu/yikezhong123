package com.example.yikezhong123.ui.Recommend.Presenter;

import com.example.yikezhong123.bean.AdBean;
import com.example.yikezhong123.bean.JokesBean;
import com.example.yikezhong123.net.AdApi;
import com.example.yikezhong123.net.JokesApi;
import com.example.yikezhong123.ui.Recommend.contract.GetAdContract;
import com.example.yikezhong123.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GetAdPresenter extends BasePresenter<GetAdContract.View> implements GetAdContract.Presenter {
    private AdApi adApi;
    private JokesApi jokesApi;
    @Inject
    public GetAdPresenter(AdApi adApi, JokesApi jokesApi) {
        this.adApi = adApi;
        this.jokesApi = jokesApi;
    }




    @Override
    public void getAd() {
        adApi.getAd()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AdBean adBean) {
                        if (mView!=null){
                            mView.onSuccess(adBean);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getJokes() {
        jokesApi.getJokes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<JokesBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JokesBean jokesBean) {
                        if (mView!=null){
                            mView.onJokesSuccess(jokesBean);
                        }
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
