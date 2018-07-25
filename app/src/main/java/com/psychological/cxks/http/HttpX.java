package com.psychological.cxks.http;

import com.psychological.cxks.Constant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author : guozhaoyuan
 * Date   : 2018/6/20
 */
public class HttpX {

    private static HttpX httpx;
    private Api apis;

    private HttpX() {
    }

    public static HttpX Instance() {
        if (httpx == null) {
            synchronized (HttpX.class) {
                if (httpx == null) {
                    httpx = new HttpX();
                }
            }
        }
        return httpx;
    }

    public void init() {
        OkHttpClient client = initOkHttp();
        initRetrofit(client);
    }

    private OkHttpClient initOkHttp() {
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        okhttp3.logging.HttpLoggingInterceptor interceptor = new okhttp3.logging.HttpLoggingInterceptor();
        interceptor.setLevel(okhttp3.logging.HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
//                .addInterceptor(headerInterceptor)
                .addInterceptor(interceptor)
                .connectTimeout(HttpConstant.HTTP_TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(HttpConstant.HTTP_READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(HttpConstant.HTTP_WRITE_TIME_OUT, TimeUnit.MILLISECONDS)
                .build();
    }

    private void initRetrofit(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build();
        apis = retrofit.create(Api.class);
    }

    public Api Api() {
        return apis;
    }

    /**
     * Accept代表发送端（客户端）希望接受的数据类型
     * Accept：text/xml（application/json）代表客户端希望接受的数据类型是xml（json ）类型
     * Content-Type代表发送端（客户端|服务器）发送的实体数据的数据类型。
     * Content-Type：text/html（application/json） ;代表发送端发送的数据格式是html（json）。
     */
    private Interceptor headerInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request origin = chain.request();
            Request request = origin.newBuilder()
                    .addHeader("Accept", "application/json")
                    .method(origin.method(), origin.body())
                    .build();
            Response response = chain.proceed(request);
   /*         if (response.code() == 404) {
//                response = response.newBuilder().build();
               return chain.proceed(origin);
            }*/
            return response;
        }
    };
}
