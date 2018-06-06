package com.example.yikezhong123.net;

import com.example.yikezhong123.bean.DuanZiBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface DuanZiApiService {
    @GET("quarter/getJokes")
    Observable<DuanZiBean> getDuanZi();
}
