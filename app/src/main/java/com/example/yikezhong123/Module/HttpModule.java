package com.example.yikezhong123.Module;

import com.example.yikezhong123.net.AdApi;
import com.example.yikezhong123.net.AdApiService;
import com.example.yikezhong123.net.Api;
import com.example.yikezhong123.net.DuanZiApi;
import com.example.yikezhong123.net.DuanZiApiService;
import com.example.yikezhong123.net.JokesApi;
import com.example.yikezhong123.net.JokesApiService;
import com.example.yikezhong123.net.MyInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder(){
        return new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS);

    }

    @Provides
    AdApi provideAdApi(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        AdApiService adApiService = retrofit.create(AdApiService.class);
        return AdApi.getAdApi(adApiService);
    }

    @Provides
    JokesApi provideJokesApi(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        JokesApiService jokesApiService = retrofit.create(JokesApiService.class);
        return JokesApi.getJokes(jokesApiService);
    }
    @Provides
    DuanZiApi provideDuanZiApi(OkHttpClient.Builder builder){
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        DuanZiApiService duanZiApiService = retrofit.create(DuanZiApiService.class);
        return DuanZiApi.getDuanZiApi(duanZiApiService);
    }
}
