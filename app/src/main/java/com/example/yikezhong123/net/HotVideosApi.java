package com.example.yikezhong123.net;

import com.example.yikezhong123.bean.DuanZiBean;
import com.example.yikezhong123.bean.HotVideosBean;

import io.reactivex.Observable;

public class HotVideosApi {
    private static HotVideosApi hotVideosApi;
    private HotVideosApiService hotVideosApiService;

    public HotVideosApi(HotVideosApiService hotVideosApiService) {
        this.hotVideosApiService = hotVideosApiService;
    }
    public static HotVideosApi getHotVideosApi(HotVideosApiService hotVideosApiService){
        if (hotVideosApi==null){
            hotVideosApi=new HotVideosApi(hotVideosApiService);
        }
        return hotVideosApi;
    }
    public Observable<HotVideosBean> getHotVideos(String type,String token){
        return hotVideosApiService.getHotVideo(type,token);
    }
}
