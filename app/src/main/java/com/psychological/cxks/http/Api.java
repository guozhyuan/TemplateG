package com.psychological.cxks.http;


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
import com.psychological.cxks.bean.param.QueryOrderStateParam;
import com.psychological.cxks.bean.param.PhoneCodePayParam;
import com.psychological.cxks.bean.param.ReservationParam;
import com.psychological.cxks.bean.param.UnlockParam;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Author : jugg
 * Date   : 2018/6/20
 */
public interface Api {
    @FormUrlEncoded
    @POST("/")
    Observable<HttpResp<TestBean>> test();

    // 3.1.1 短信验证码一键注册及登录(/rgsAndLog)
    @FormUrlEncoded
    @POST("rgsAndLog")
    Observable<HttpResp<String>> rgsAndLog(@Field("mobile") String mobile, @Field("code") String code);

    // 3.1.2 密码登录(/login_)
    @FormUrlEncoded
    @POST("login_")
    Observable<HttpResp<LoginBean>> login(@Field("account") String account, @Field("password") String password);

    // 3.1.4 退出登录(/index/logout_)
    @FormUrlEncoded
    @POST("index/logout_")
    Observable<HttpResp<Boolean>> logout(@Field("token") String token);

    // 3.1.5 验证手机号(/validate)
    @FormUrlEncoded
    @POST("validate")
    Observable<HttpResp<Boolean>> validate(@Field("phone") String phone);

    // 3.1.6 发送短信验证码(/send)
    @FormUrlEncoded
    @POST("send")
    Observable<HttpResp<String>> send(@Field("phone") String phone);

    //3.1.7 忘记(修改)密码【重置密码】(/reset)
    @FormUrlEncoded
    @POST("reset")
    Observable<HttpResp<Boolean>> reset(@Field("mobile") String mobile, @Field("code") String code, @Field("password") String password);

    // 3.2.1 获取主页的banner图片(/banner/list)
    @POST("banner/list")
    Observable<HttpResp<List<BannerBean>>> bannerList();

    // 3.2.2 根据条件获取默认排序专家列表数据(/expert/list)
    @POST("expert/list")
    Observable<HttpResp<ExpertBean>> expertList(@Body ExpertListParam param);

    // 3.2.3 添加总订单(/wxPay/order) (注：预约或购买产品之前都先调用此接口,以便获取订单号)
    @POST("wxPay/order")
    Observable<HttpResp<String>> addAllOrder(@Body AddAllOrderParam param);

    //3.2.4.1 锁定时间段(/expert/lock)
    @POST("expert/lock")
    Observable<HttpResp<Boolean>> lockTime(@Body LockParam param);

    //3.2.4.2 解锁时间段(/expert/unlock)
    @POST("expert/unlock")
    Observable<HttpResp<Boolean>> unlockTime(@Body UnlockParam param);

    // 3.2.4.3 预约(/verify/expert/oder)
    @POST("verify/expert/oder")
    Observable<HttpResp<String>> reservation(@Body ReservationParam param);

    // 3.2.4.4 咨询师订单金额分成(/expert/recharge)
    @FormUrlEncoded
    @POST("expert/recharge")
    Observable<HttpResp<Boolean>> cashDivid(@Field("serialId") String serialId);

    // 3.2.4.5 更改预约订单状态(/cancelAppt)
    @POST("cancelAppt")
    Observable<HttpResp<Boolean>> cancelAppt(@Body ChangeOrderStateParam param);

    // 3.2.5.1 APP支付(折扣优惠码支付)(/wxPay/appPay)
    @POST("wxPay/appPay")
    Observable<HttpResp<String>> discountCodePay(@Body DisCodePayParam param);


    //    3.2.5.2 查询优惠券信息(/expert/disInfo) (注：用于展示优惠码的折扣)
    //    discountCode	√	string	10	优惠券内容
    @FormUrlEncoded
    @POST("expert/disInfo")
    Observable<HttpResp<String>> couponInfo(@Field("discountCode") String discountCode);


    //  3.2.5.3 免费优惠码支付(/mc/discountPay) (注：优惠码位数为10位)
    @POST("mc/discountPay")
    Observable<HttpResp<Boolean>> freeCodePay(@Body FreeCodePayParam param);

    //    3.2.5.4 心理顾问套餐优惠码支付(/mc/mcPay)
    @POST("mc/mcPay")
    Observable<HttpResp<Boolean>> couponPackgePay(@Body DisPackgeParam param);


    // 3.2.5.5 电询、面询优惠码支付(/mc/couponPay)
    @POST("mc/couponPay")
    Observable<HttpResp<Boolean>> phoneCodePay(@Body PhoneCodePayParam param);

    // 3.2.5.6 首次优惠码支付(/mc/codePay)(注：优惠码位数为8位)
    @POST("mc/codePay")
    Observable<HttpResp<Boolean>> firstCodePay(@Body FirstCodePayParam param);

    // 3.2.5.7 查询订单状态(/wxPay/appPayState)
    @POST("wxPay/appPayState")
    Observable<HttpResp<QueryOrderStateBean>> queryOrderState(@Body QueryOrderStateParam param);

    //3.2.5.8 关闭订单(/wxPay/closeOrder)
    @FormUrlEncoded
    @POST("wxPay/closeOrder")
    Observable<HttpResp<QueryOrderStateBean>> closeOrder(@Field("orderId") String orderId);

    // 3.2.6.1 验证来访者信息是否重复添加(/client/selectClient)
    // name 来访者姓名
    @FormUrlEncoded
    @POST("client/selectClient")
    Observable<HttpResp<Boolean>> verifyVisitorInfo(@Field("name") String name);

    //3.2.6.2添加来访者信息(/client/addClient)
    @POST("client/addClient")
    Observable<HttpResp<Boolean>> addVisitorInfo(@Body AddVisitorInfoParam param);

    //3.2.7.1 购买套餐(/cp/addPackageOrder) (注：先添加总订单)
    @POST("cp/addPackageOrder")
    Observable<HttpResp<Boolean>> buyPackge(@Body BuyPackgeParam param);

    //3.2.7.2 生成优惠码(/cp/addPackageCoupon)
    @POST("cp/addPackageCoupon")
    Observable<HttpResp<String>> generateDisCode(@Body GeneDisCodeParam param);

    //3.3.1 搜索(/search)
    @FormUrlEncoded
    @POST("search")
    Observable<HttpResp<String>> search(@Field("keyWord") String keyWord);

    //3.4.1 系统消息列表(/inform/query)

    //3.4.2 系统消息已读(/inform/update)

    //3.4.3 删除系统消息(/inform/delete)


    //3.5.1 用户获取预约订单列表(/verify/sAppt)

    //3.5.3 用户获取购买的咨询师套餐订单列表(/cp/selectPoList)

    //3.5.4 用户获取购买的365心理顾问订单(/verify/morder)

    //3.6.1 查询个人资料(/verify/info/s)

    //3.6.2 修改个人资料(/verify/save/s)

    //3.6.1 添加收藏(/addCollect)

    //3.7.1 获取365心理顾问产品(/mentality/getMentalityCst)

    //3.7.2 心理顾问-添加订单(/mentality/save)

    //3.7.3 心理顾问-获取电询、面询优惠码(/mentality/addCcoupon) (注：用户购买完365心理顾问产品后调用此接口，将优惠码返回给用户)

    //3.7.4 心理顾问-填写365心理顾问服务个人基本资料(/mentality/addmp)

    //3.7.5 心理顾问-获取365咨询档案列表(/mentality/getDescriptionList)

    //3.8.1 用户获取已使用的365心理顾问优惠码列表(/mc/McList)

    //3.8.2 购买者获取购买咨询师套餐后所得的优惠码列表(/cp/selectPcList)

    //3.8.3 用户获取已使用的电询、面询优惠卷列表(/mc/CcList)

    //3.8.4 购买者获取购买优惠套餐后所得的优惠码列表(/cp/selectPcList)


}


