package com.guo.projectg.http;


import com.guo.projectg.bean.TestBean;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Author : jugg
 * Date   : 2018/6/20
 */
public interface Api {

    @Headers("Accept: application/json")
    @POST("test")
    Observable<HttpResp<TestBean>> test();

}
