package com.guo.projectg.http;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

/**
 * Author : jugg
 * Date   : 2018/6/21
 */
public class ErrorHandler {

    // 参考 https://blog.csdn.net/jdsjlzx/article/details/51566683
    // 参考 https://blog.csdn.net/jdsjlzx/article/details/51882661
    public static <T> ObservableTransformer<HttpResp<T>, T> errorHandle() {

        return new ObservableTransformer<HttpResp<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<HttpResp<T>> upstream) {
                return null;
            }
        };
    }
}