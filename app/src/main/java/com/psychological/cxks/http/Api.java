package com.psychological.cxks.http;


import com.psychological.cxks.bean.BannerBean;
import com.psychological.cxks.bean.ExpertBean;
import com.psychological.cxks.bean.RegAndLogBean;
import com.psychological.cxks.bean.LoginBean;
import com.psychological.cxks.bean.TestBean;
import com.psychological.cxks.bean.param.AddAllOrderParam;
import com.psychological.cxks.bean.param.ExpertListParam;
import com.psychological.cxks.bean.param.ReservationParam;

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
    Observable<HttpResp<List<ExpertBean>>> expertList(@Body ExpertListParam param);

    // 3.2.3 添加总订单(/wxPay/order) (注：预约或购买产品之前都先调用此接口,以便获取订单号)
    @POST("wxPay/order")
    Observable<HttpResp<String>> addAllOrder(@Body AddAllOrderParam param);

    // 3.2.4 预约(/verify/expert/oder)
    @POST("verify/expert/oder")
    Observable<HttpResp<String>> reservation(@Body ReservationParam param);


    // 3.2.5.1 APP支付(折扣优惠码支付)(/wxPay/appPay)
//    amount	√	double		商品价格
//    title	√	string		商品名称
//    orderId	√	string	30	订单号
//    count	√	int		数量
//    discount		string	10	如果是使用折扣优惠码就传值
//    userId		string	32	如果是使用折扣优惠码就传值
    @FormUrlEncoded
    @POST("wxPay/appPay")
    Observable<HttpResp<String>> pay(@Field("amount") double amount, @Field("title") String title, @Field("orderId") String orderId,
                                     @Field("count") int count, @Field("discount") String discount, @Field("userId") int userId);


    //    3.2.5.2 查询优惠券信息(/expert/disInfo) (注：用于展示优惠码的折扣)
    //    discountCode	√	string	10	优惠券内容
    @FormUrlEncoded
    @POST("expert/disInfo")
    Observable<HttpResp<String>> couponInfo(@Field("discountCode") String discountCode);


    //  3.2.5.3 免费优惠码支付(/mc/discountPay) (注：优惠码位数为10位)
    //  discountCode	√	string	10	优惠码
    //  userId	√	string	32	咨询师id
    @FormUrlEncoded
    @POST("mc/discountPay")
    Observable<HttpResp<String>> freeCouponPay(@Field("discountCode") String discountCode, @Field("userId") String userId);

    //    3.2.5.4 心理顾问套餐优惠码支付(/mc/mcPay)
    // coupon	√	string	10	优惠码
    // operator	√	string	30	用户id
    // title	√	int		套餐价格
    @FormUrlEncoded
    @POST("mc/mcPay")
    Observable<HttpResp<String>> couponPackgePay(@Field("coupon") String coupon, @Field("operator") String operator, @Field("title") int title);


    // 3.2.5.5 电询、面询优惠码支付(/mc/couponPay)

    // 3.2.5.6 首次优惠码支付(/mc/codePay)(注：优惠码位数为8位)

    // 3.2.5.7 查询订单状态(/wxPay/appPayState)

    //3.2.5.8 关闭订单(/wxPay/closeOrder)

    //3.2.6 来访者信息表

    //3.2.6.2添加来访者信息(/client/addClient)

    //3.2.7.1 购买套餐(/cp/addPackageOrder) (注：先添加总订单)

    //3.2.7.2 生成优惠码(/cp/addPackageCoupon)

    //3.3.1 搜索(/search)

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


