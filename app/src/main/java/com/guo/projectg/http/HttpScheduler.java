package com.guo.projectg.http;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Author : jugg
 * Date   : 2018/6/21
 */
public class HttpScheduler {

    public static <T> ObservableTransformer<T, T> applyIO() {

        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}

// upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
