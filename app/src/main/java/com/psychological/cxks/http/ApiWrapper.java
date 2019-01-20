package com.psychological.cxks.http;

import com.psychological.cxks.bean.BannerBean;
import com.psychological.cxks.bean.CouponCodeListBean;
import com.psychological.cxks.bean.CouponPackageListBean;
import com.psychological.cxks.bean.CouponPackgeBean;
import com.psychological.cxks.bean.CustomerInfoBean;
import com.psychological.cxks.bean.CustomerListBean;
import com.psychological.cxks.bean.EvaluateBean;
import com.psychological.cxks.bean.ExpertBean2;
import com.psychological.cxks.bean.ExpertDetailBean2;
import com.psychological.cxks.bean.FavoriteBean;
import com.psychological.cxks.bean.OrderDetailBean;
import com.psychological.cxks.bean.OrderListBean;
import com.psychological.cxks.bean.RoomListBean;
import com.psychological.cxks.bean.UseableCouponBean;
import com.psychological.cxks.bean.UserInfoBean;
import com.psychological.cxks.bean.QueryOrderStateBean;
import com.psychological.cxks.bean.TestBean;
import com.psychological.cxks.bean.ZiXunShiOrderListBean;
import com.psychological.cxks.bean.param.AddAllOrderParam;
import com.psychological.cxks.bean.param.AddVisitorInfoParam;
import com.psychological.cxks.bean.param.BuyPackgeParam;
import com.psychological.cxks.bean.param.ChangeOrderStateParam;
import com.psychological.cxks.bean.param.CustomerParam;
import com.psychological.cxks.bean.param.DisCodePayParam;
import com.psychological.cxks.bean.param.EvaluateParam;
import com.psychological.cxks.bean.param.ExpertListParam;
import com.psychological.cxks.bean.param.ExtractParam;
import com.psychological.cxks.bean.param.FirstCodePayParam;
import com.psychological.cxks.bean.param.FreeCodePayParam;
import com.psychological.cxks.bean.param.GeneDisCodeParam;
import com.psychological.cxks.bean.param.LockParam;
import com.psychological.cxks.bean.param.ModifyCouponParam;
import com.psychological.cxks.bean.param.OrderListParam;
import com.psychological.cxks.bean.param.PhoneCodePayParam;
import com.psychological.cxks.bean.param.QueryOrderStateParam;
import com.psychological.cxks.bean.param.ReservationParam;
import com.psychological.cxks.bean.param.RoomOrderParam;
import com.psychological.cxks.bean.param.UnlockParam;
import com.psychological.cxks.sevice.HttpExceptionEvent;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.List;
import java.util.Map;


import cn.jpush.im.android.eventbus.EventBus;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Part;


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

                        if (r.code == 300
                                || r.code == 500
                                || r.code == 1001
                                || r.code == 1002
                                || r.code == 1003
                                || r.code == 1004
                                || r.code == 1005
                                || r.code == 1006
                                || r.code == 1007
                                || r.code == 1008
                                || r.code == 501
                                || r.code == 502
                                || r.code == 503
                                || r.code == 504
                                || r.code == 505
                                || r.code == 506) {
                            EventBus.getDefault().post(new HttpExceptionEvent(r.code, r.message));
//                            emitter.onError(new HttpDataNullException(r.code + " : " + r.message));
                            return;
                        }
                        if (r.data == null) {
                            emitter.onError(new HttpDataNullException("httpResp data is null."));
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

    // 3.2.0 所有咨询师的地址(/expert/getCustomerAddr)
    public Observable<Object> getCustomerAddr() {
        Observable<HttpResp<Object>> observable = HttpX.Instance().Api().getCustomerAddr().compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    //主页Banner
    public Observable<List<BannerBean>> bannerList() {
        Observable<HttpResp<List<BannerBean>>> observable = HttpX.Instance().Api().bannerList().compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    // 咨询师列表
    public Observable<List<ExpertBean2>> expertList(ExpertListParam param) {
        Observable<HttpResp<List<ExpertBean2>>> observable = HttpX.Instance().Api().expertList(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    //咨询师详情
    public Observable<ExpertDetailBean2> expertDetail(String userId) {
        Observable<HttpResp<ExpertDetailBean2>> observable = HttpX.Instance().Api().expertDetail(userId).compose(HttpScheduler.applyIO());
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
    public Observable<String> addAllOrder(AddAllOrderParam param) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().addAllOrder(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<String> addAllOrder2(Map<String, Object> param) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().addAllOrder2(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    //锁定时间
    public Observable<Boolean> lockTime(LockParam param) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().lockTime(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<Boolean> lockTime2(Map<String, Object> param) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().lockTime2(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    //解锁时间
    public Observable<Boolean> unlockTime(UnlockParam param) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().unlockTime(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }


    public Observable<String> reservation(ReservationParam param) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().reservation(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<String> reservation2(Map<String, Object> param) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().reservation2(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    @Deprecated
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

    public Observable<String> discountCodePay2(Map<String, String> map) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().discountCodePay2(map).compose(HttpScheduler.applyIO());
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

    public Observable<Boolean> couponPackgePay(String coupon, String operator, int price) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().couponPackgePay(coupon, operator, price).compose(HttpScheduler.applyIO());
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

    public Observable<Boolean> buyPackge2(Map<String, Object> map) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().buyPackge2(map).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<Object> generateDisCode(GeneDisCodeParam param) {
        Observable<HttpResp<Object>> observable = HttpX.Instance().Api().generateDisCode(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<List<ExpertBean2>> search(String keyWord) {
        Observable<HttpResp<List<ExpertBean2>>> observable = HttpX.Instance().Api().search(keyWord).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    //所有订单
    public Observable<OrderListBean> allOrder(OrderListParam param) {
        Observable<HttpResp<OrderListBean>> observable = HttpX.Instance().Api().allOrder(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<OrderListBean> allOrder2(Map<String, Object> param) {
        Observable<HttpResp<OrderListBean>> observable = HttpX.Instance().Api().allOrder2(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    //   // 3.5.1.1 订单详情(/verify/getApptOrder)
    public Observable<Object> orderDetail(String serialId) {
        Observable<HttpResp<Object>> observable = HttpX.Instance().Api().orderDetail(serialId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    //添加收藏
    public Observable<Boolean> addCollect(String uId, String consultId) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().addCollect(uId, consultId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    //收藏列表
    public Observable<FavoriteBean> collectList(String uId) {
        Observable<HttpResp<FavoriteBean>> observable = HttpX.Instance().Api().collectList(uId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }


    // 3.8.2 购买者获取购买咨询师套餐后所得的优惠码列表(/cp/selectPcList)
    public Observable<CouponPackageListBean> couponPackgeList(String obtainId) {
        Observable<HttpResp<CouponPackageListBean>> observable = HttpX.Instance().Api().couponPackgeList(obtainId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    // 3.8.3 用户获取电询、面询优惠卷列表(/mc/CcList)
    public Observable<CouponCodeListBean> couponCodeList(String creator) {
        Observable<HttpResp<CouponCodeListBean>> observable = HttpX.Instance().Api().couponCodeList(creator).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    //预约时的优惠码选择
    public Observable<UseableCouponBean> getAllCouponList(String userId) {
        Observable<HttpResp<UseableCouponBean>> observable = HttpX.Instance().Api().getAllCouponList(userId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }


    // 3.14.3 查询预约时间段状态(/expert/time)(咨询师详情页)
    public Observable<Object> getExpertTimes(String userId) {
        Observable<HttpResp<Object>> observable = HttpX.Instance().Api().getExpertTimes(userId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    // #######################################################  咨询师 ##################################################################################

    public Observable<String> uploadFile(RequestBody body) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().uploadFile(body).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<String> uploadFile2(Map<String, RequestBody> params, MultipartBody.Part p) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().uploadFile2(params, p).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<String> uploadFile3(@Part RequestBody moduleid, @Part RequestBody oldImg, @Part MultipartBody.Part p) {
        Observable<HttpResp<String>> observable = HttpX.Instance().Api().uploadFile3(moduleid, oldImg, p).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    // 3.10.8 客户列表(/getCustomerList)
    public Observable<CustomerListBean> getCustomerList(CustomerParam param) {
        Observable<HttpResp<CustomerListBean>> observable = HttpX.Instance().Api().getCustomerList(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    public Observable<CustomerListBean> getCustomerList2(Map<String, Object> param) {
        Observable<HttpResp<CustomerListBean>> observable = HttpX.Instance().Api().getCustomerList2(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    // 3.10.9 咨询记录(/getConsultNum)
    public Observable<Object> getConsultNum(String csId, String userId) {
        Observable<HttpResp<Object>> observable = HttpX.Instance().Api().getConsultNum(csId, userId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    // 3.10.10 根据用户id查询用户填写的来访者信息(/client/selectClientAll)
    public Observable<List<CustomerInfoBean>> getCustomerInfo(String userId) {
        Observable<HttpResp<List<CustomerInfoBean>>> observable = HttpX.Instance().Api().getCustomerInfo(userId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    /**
     * 3.11.1 获取咨询室列表(/room/list)
     */
    public Observable<RoomListBean> roomList(int type, String addr) {
        Observable<HttpResp<RoomListBean>> observable = HttpX.Instance().Api().roomList(type, addr).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    /**
     * 3.11.2 咨询室详情(/room/detail)
     */
    public Observable<Object> roomDetail(String serialNo) {
        Observable<HttpResp<Object>> observable = HttpX.Instance().Api().roomDetail(serialNo).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    // 3.11.3 我的咨询室预约(/verify/queryRoomList)
    public Observable<ZiXunShiOrderListBean> getRoomOrderList(RoomOrderParam param) {
        Observable<HttpResp<ZiXunShiOrderListBean>> observable = HttpX.Instance().Api().getRoomOrderList(param).compose(HttpScheduler.applyIO());
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

    // 3.12.3 设置咨询师套餐(/cp/addConsultPackage)
    public Observable<Object> addConsultPackage(String consultId, int tcId) {
        Observable<HttpResp<Object>> observable = HttpX.Instance().Api().addConsultPackage(consultId, tcId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    /**
     * 3.12.4 修改套餐内容、更改套餐排序、发布/下架套餐(/cp/setCpState)
     */
    public Observable<Boolean> setCpState(ModifyCouponParam param) {
        Observable<HttpResp<Boolean>> observable = HttpX.Instance().Api().setCpState(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    /*
     3.11.12 查询订单状态(/expert/query/state)
      */
    public Observable<OrderDetailBean> queryOrderState(String serialId) {
        Observable<HttpResp<OrderDetailBean>> observable = HttpX.Instance().Api().queryOrderState(serialId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    /**
     * 3.13.1 收支明细列表(/balance/query)  consultId
     */
    public Observable<Object> balanceListQuery(String consultId) {
        Observable<HttpResp<Object>> observable = HttpX.Instance().Api().balanceListQuery(consultId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    // 3.13.2 申请提现(/cash/insert)
    public Observable<Object> cashExtract(ExtractParam param) {
        Observable<HttpResp<Object>> observable = HttpX.Instance().Api().cashExtract(param).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    // 3.13.3 获取提现记录(/cash/query)
    public Observable<Object> queryExtract(String counselorId) {
        Observable<HttpResp<Object>> observable = HttpX.Instance().Api().queryExtract(counselorId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }

    // 3.13.4 获取提现信息(/bank/query)
    public Observable<Object> balanceQuery(String userId) {
        Observable<HttpResp<Object>> observable = HttpX.Instance().Api().bankQuery(userId).compose(HttpScheduler.applyIO());
        return transform(observable);
    }
}
