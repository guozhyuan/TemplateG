package com.guo.projectg.http;

import com.guo.projectg.bean.TestBean;

import org.greenrobot.greendao.annotation.NotNull;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;


/**
 * Author : jugg
 * Date   : 2018/6/21
 */
public class ApiWrapper {
    private static ApiWrapper wrapper;

    public static ApiWrapper getInstance() {
        if (wrapper == null)
            wrapper = new ApiWrapper();
        return wrapper;
    }


    public Observable<TestBean> test() {
        Observable<HttpResp<TestBean>> observable = HttpX.Instance().Api().test().compose(HttpScheduler.<HttpResp<TestBean>>applyIO());
        return transform(observable);
    }

    private <R extends HttpResp<T>, T> Observable<T> transform(@NotNull Observable<R> observable) {
        return observable.flatMap(new Function<R, ObservableSource<T>>() {
            @Override
            public ObservableSource<T> apply(final R r) throws Exception {
                return Observable.create(new ObservableOnSubscribe<T>() {
                    @Override
                    public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                        // Log.e("ApiWrapper", "code: " + r.code +"  message:"+ r.message +"  data:"+ r.data.toString());
                        if (r.code == -1) {
                            emitter.onError(new Throwable("code : " + r.code));
                        }
                        emitter.onNext(r.data);
                    }
                });
            }
        });
    }
}
