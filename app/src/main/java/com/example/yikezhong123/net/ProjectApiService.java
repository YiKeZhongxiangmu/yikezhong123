package com.example.yikezhong123.net;

import com.example.yikezhong123.bean.RegBean;
import com.example.yikezhong123.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ProjectApiService {
    @FormUrlEncoded
    @POST("user/login")
    Observable<UserBean> login(@Field("mobile") String mobile,
                               @Field("password") String password);

    //注册
    @FormUrlEncoded
    @POST("quarter/register")
    Observable<RegBean> reg(@Field("mobile") String mobile,
                            @Field("password") String password);
}
