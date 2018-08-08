package com.psychological.cxks.http;

import com.psychological.cxks.bean.BannerBean;
import com.psychological.cxks.bean.CouponPackgeBean;
import com.psychological.cxks.bean.EvaluateBean;
import com.psychological.cxks.bean.ExpertBean;
import com.psychological.cxks.bean.ExpertDetailBean;
import com.psychological.cxks.bean.UserInfoBean;
import com.psychological.cxks.bean.QueryOrderStateBean;
import com.psychological.cxks.bean.TestBean;
import com.psychological.cxks.bean.param.AddAllOrderParam;
import com.psychological.cxks.bean.param.AddVisitorInfoParam;
import com.psychological.cxks.bean.param.BuyPackgeParam;
import com.psychological.cxks.bean.param.ChangeOrderStateParam;
import com.psychological.cxks.bean.param.CouponPackgeParam;
import com.psychological.cxks.bean.param.DisCodePayParam;
import com.psychological.cxks.bean.param.DisPackgeParam;
import com.psychological.cxks.bean.param.EvaluateParam;
import com.psychological.cxks.bean.param.ExpertListParam;
import com.psychological.cxks.bean.param.FirstCodePayParam;
import com.psychological.cxks.bean.param.FreeCodePayParam;
import com.psychological.cxks.bean.param.GeneDisCodeParam;
import com.psychological.cxks.bean.param.LockParam;
import com.psychological.cxks.bean.param.OrderDetailParam;
import com.psychological.cxks.bean.param.PhoneCodePayParam;
import com.psychological.cxks.bean.param.QueryOrderStateParam;
import com.psychological.cxks.bean.param.ReservationParam;
import com.psychological.cxks.bean.param.UnlockParam;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.List;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import retrofit2.http.Field;


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
                        if (r.data == null) {
//                            try {
//                                throw new HttpDataNullException("httpResp data is null.");
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                            return;
                            emitter.onError(new HttpDataNullException("httpResp data is null."));
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

    public Observable<UserInfoBean> login(String account, String password) {
        Observable<HttpResp<UserInfoBean>> observable = HttpX.Instance().Api().login(account, password).compose(HttpScheduler.<HttpResp<UserInfoBean>>applyIO());
        return transform(observable);
    }

    public Observable<UserInfoBean> rgsAndLog(String mobile, String code) {
        Observable<HttpResp<UserInfoBean>> observable = HttpX.Instance().Api().rgsAndLog(mobile, code).compose(HttpScheduler.applyIO());
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

    //主页Banner
    public Observable<List<BannerBean>> bannerList() {
        Observable<HttpResp<List<BannerBean>>> observable = HttpX.Instance().Api().bannerList().compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    // 咨询师列表
    public Observable<ExpertBean> expertList(ExpertListParam param) {
        Observable<HttpResp<ExpertBean>> observable = HttpX.Instance().Api().expertList(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    //咨询师详情
    public Observable<ExpertDetailBean> expertDetail(String userId) {
        Observable<HttpResp<ExpertDetailBean>> observable = HttpX.Instance().Api().expertDetail(userId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    //评价列表
    public Observable<List<EvaluateBean>> evaluateList(EvaluateParam param) {
        Observable<HttpResp<List<EvaluateBean>>> observable = HttpX.Instance().Api().evaluateList(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    //总评分
    public Observable<String> getScore(String consultId) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().getScore(consultId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    //添加总订单
    public Observable<Object> addAllOrder(AddAllOrderParam param) {
        Observable<HttpResp<Object>> observable = HttpX.Instance().Api().addAllOrder(param).compose(HttpScheduler.applyIO());
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

    public Observable<List<ExpertBean.ResultBean>> search(String keyWord) {
        Observable<HttpResp<List<ExpertBean.ResultBean>>> observable = HttpX.Instance().Api().search(keyWord).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    //所有订单
    public Observable<String> allOrder(OrderDetailParam param) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().allOrder(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<Object> allOrder2(String token) {
        Observable<HttpResp<Object>> observable = HttpX.Instance().Api().allOrder2(token).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    //添加收藏
    public Observable<Boolean> addCollect(String uId, String consultId) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().addCollect(uId, consultId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    //收藏列表
    public Observable<Object> collectList(String uId) {
        Observable<HttpResp<Object>> observable = HttpX.Instance().Api().collectList(uId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }


    // 3.8.2 购买者获取购买咨询师套餐后所得的优惠码列表(/cp/selectPcList)
    public Observable<Object> couponPackgeList(CouponPackgeParam param) {
        Observable<HttpResp<Object>> observable = HttpX.Instance().Api().couponPackgeList(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    // 3.8.3 用户获取电询、面询优惠卷列表(/mc/CcList)
    public Observable<Object> couponCodeList(String creator) {
        Observable<HttpResp<Object>> observable = HttpX.Instance().Api().couponCodeList(creator).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    //预约时的优惠码选择
    public Observable<Object> getAllCouponList(String userId) {
        Observable<HttpResp<Object>> observable = HttpX.Instance().Api().getAllCouponList(userId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }


    // 3.12.1 获取套餐产品(/cp/getTcAll)
    public Observable<List<CouponPackgeBean>> getCouponPackge() {
        Observable<HttpResp<List<CouponPackgeBean>>> observable = HttpX.Instance().Api().getCouponPackge().compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    // 3.12.2 获取咨询师发布的套餐(/cp/selectCpList)
    public Observable<List<CouponPackgeBean>> getExpertCouponPackge(String consultId, int packageState) {
        Observable<HttpResp<List<CouponPackgeBean>>> observable = HttpX.Instance().Api().getExpertCouponPackge(consultId, packageState).compose(HttpScheduler.applyIO());
        return transform(observable);
    }
}
