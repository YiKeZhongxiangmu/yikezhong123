package com.example.yikezhong123.net;

import com.example.yikezhong123.bean.AdBean;
import com.example.yikezhong123.bean.DuanZiBean;

import io.reactivex.Observable;

public class DuanZiApi {
    private static DuanZiApi duanZiApi;
    private DuanZiApiService duanZiApiService;

    public DuanZiApi(DuanZiApiService duanZiApiService) {
        this.duanZiApiService = duanZiApiService;
    }
    public static DuanZiApi getDuanZiApi(DuanZiApiService duanZiApiService){
        if (duanZiApi==null){
            duanZiApi=new DuanZiApi(duanZiApiService);
        }
        return duanZiApi;
    }
    public Observable<DuanZiBean> getDuanzi(){
        return duanZiApiService.getDuanZi();
    }
}
