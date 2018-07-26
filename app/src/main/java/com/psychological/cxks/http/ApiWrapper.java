package com.psychological.cxks.http;

import android.util.Log;

import com.psychological.cxks.bean.BannerBean;
import com.psychological.cxks.bean.ExpertBean;
import com.psychological.cxks.bean.LoginBean;
import com.psychological.cxks.bean.QueryOrderStateBean;
import com.psychological.cxks.bean.TestBean;
import com.psychological.cxks.bean.param.AddAllOrderParam;
import com.psychological.cxks.bean.param.AddVisitorInfoParam;
import com.psychological.cxks.bean.param.BuyPackgeParam;
import com.psychological.cxks.bean.param.ChangeOrderStateParam;
import com.psychological.cxks.bean.param.DisCodePayParam;
import com.psychological.cxks.bean.param.DisPackgeParam;
import com.psychological.cxks.bean.param.ExpertListParam;
import com.psychological.cxks.bean.param.FirstCodePayParam;
import com.psychological.cxks.bean.param.FreeCodePayParam;
import com.psychological.cxks.bean.param.GeneDisCodeParam;
import com.psychological.cxks.bean.param.LockParam;
import com.psychological.cxks.bean.param.PhoneCodePayParam;
import com.psychological.cxks.bean.param.QueryOrderStateParam;
import com.psychological.cxks.bean.param.ReservationParam;
import com.psychological.cxks.bean.param.UnlockParam;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.List;
import java.util.Objects;

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
//                        Log.e("ApiWrapper", "code: " + r.code + "  message:" + r.message + "  data:" + r.data.toString());
//                        if (r.code == 200) {
//                            emitter.onError(new Throwable("code : " + r.code));
//                        }
                        if (r.data == null) {
                            emitter.onError(new Throwable("httpResp data is null."));
                            return;
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

    public Observable<String> rgsAndLog(String mobile, String code) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().rgsAndLog(mobile, code).compose(HttpScheduler.applyIO());
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

    public Observable<ExpertBean> expertList(ExpertListParam param) {
        Observable<HttpResp<ExpertBean>> observable = HttpX.Instance().Api().expertList(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<String> addAllOrder(AddAllOrderParam param) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().addAllOrder(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<Boolean> lockTime(LockParam param) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().lockTime(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<Boolean> unlockTime(UnlockParam param) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().unlockTime(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }


    public Observable<String> reservation(ReservationParam param) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().reservation(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }


    public Observable<Boolean> cashDivid(String serialId) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().cashDivid(serialId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<Boolean> cancelAppt(ChangeOrderStateParam param) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().cancelAppt(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }


    public Observable<String> discountCodePay(DisCodePayParam param) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().discountCodePay(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }


    public Observable<String> couponInfo(String discountCode) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().couponInfo(discountCode).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<Boolean> freeCodePay(FreeCodePayParam param) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().freeCodePay(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<Boolean> couponPackgePay(DisPackgeParam param) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().couponPackgePay(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<Boolean> phoneCodePay(PhoneCodePayParam param) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().phoneCodePay(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<Boolean> firstCodePay(FirstCodePayParam param) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().firstCodePay(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<QueryOrderStateBean> queryOrderState(QueryOrderStateParam param) {
        Observable<HttpResp<QueryOrderStateBean>> observable = HttpX.Instance().Api().queryOrderState(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<QueryOrderStateBean> closeOrder(String orderId) {
        Observable<HttpResp<QueryOrderStateBean>> observable = HttpX.Instance().Api().closeOrder(orderId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<Boolean> verifyVisitorInfo(String name) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().verifyVisitorInfo(name).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<Boolean> addVisitorInfo(AddVisitorInfoParam param) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().addVisitorInfo(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<Boolean> buyPackge(BuyPackgeParam param) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().buyPackge(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<String> generateDisCode(GeneDisCodeParam param) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().generateDisCode(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<String> search(String keyWord) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().search(keyWord).compose(HttpScheduler.applyIO());
        return transform(observable);
    }


}
