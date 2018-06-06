package com.example.yikezhong123.net;

import com.example.yikezhong123.bean.JokesBean;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface JokesApiService {
        @GET("quarter/getVideos?page=6")
        Observable<JokesBean> getJokes();
}
