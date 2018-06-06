package com.example.yikezhong123.net;

import com.example.yikezhong123.bean.AdBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface AdApiService {
    @GET("quarter/getAd")
    Observable<AdBean> getAd();
}
