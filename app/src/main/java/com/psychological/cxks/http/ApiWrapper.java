package com.psychological.cxks.http;

import com.psychological.cxks.bean.BannerBean;
import com.psychological.cxks.bean.ExpertBean;
import com.psychological.cxks.bean.RegAndLogBean;
import com.psychological.cxks.bean.LoginBean;
import com.psychological.cxks.bean.TestBean;
import com.psychological.cxks.bean.param.AddAllOrderParam;
import com.psychological.cxks.bean.param.ExpertListParam;
import com.psychological.cxks.bean.param.ReservationParam;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.List;

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


    public Observable<TestBean> test() {
        Observable<HttpResp<TestBean>> observable = HttpX.Instance().Api().test().compose(HttpScheduler.<HttpResp<TestBean>>applyIO());
        return transform(observable);
    }

    public Observable<LoginBean> login(String account, String password) {
        Observable<HttpResp<LoginBean>> observable = HttpX.Instance().Api().login(account, password).compose(HttpScheduler.<HttpResp<LoginBean>>applyIO());
        return transform(observable);
    }

    public Observable<RegAndLogBean> rgsAndLog(String mobile, String code) {
        Observable<HttpResp<RegAndLogBean>> observable = HttpX.Instance().Api().rgsAndLog(mobile, code).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<Boolean> logout(String token) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().logout(token).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<Boolean> validate(String phone) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().validate(phone).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<Boolean> reset(String mobile, String code, String password) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().reset(mobile, code, password).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<String> send(String phone) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().send(phone).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<List<BannerBean>> bannerList() {
        Observable<HttpResp<List<BannerBean>>> observable = HttpX.Instance().Api().bannerList().compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<List<ExpertBean>> expertList(ExpertListParam param) {
        Observable<HttpResp<List<ExpertBean>>> observable = HttpX.Instance().Api().expertList(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<String> addAllOrder(AddAllOrderParam param) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().addAllOrder(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<String> reservation(ReservationParam param) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().reservation(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }


}
