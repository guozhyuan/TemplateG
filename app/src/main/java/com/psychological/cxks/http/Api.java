package com.psychological.cxks.http;


import com.psychological.cxks.bean.BannerBean;
import com.psychological.cxks.bean.CouponCodeListBean;
import com.psychological.cxks.bean.CouponPackageListBean;
import com.psychological.cxks.bean.CouponPackgeBean;
import com.psychological.cxks.bean.CustomerInfoBean;
import com.psychological.cxks.bean.CustomerListBean;
import com.psychological.cxks.bean.EvaluateBean;
import com.psychological.cxks.bean.ExpertBean2;
import com.psychological.cxks.bean.ExpertDetailBean;
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
import com.psychological.cxks.bean.param.QueryOrderStateParam;
import com.psychological.cxks.bean.param.PhoneCodePayParam;
import com.psychological.cxks.bean.param.ReservationParam;
import com.psychological.cxks.bean.param.RoomOrderParam;
import com.psychological.cxks.bean.param.UnlockParam;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

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
    Observable<HttpResp<UserInfoBean>> rgsAndLog(@Field("mobile") String mobile, @Field("code") String code);

    // 3.1.2 密码登录(/login_)
    @FormUrlEncoded
    @POST("login_")
    Observable<HttpResp<UserInfoBean>> login(@Field("account") String account, @Field("password") String password);

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

    // 3.2.0 所有咨询师的地址(/expert/getCustomerAddr)
    @POST("expert/getCustomerAddr")
    Observable<HttpResp<Object>> getCustomerAddr();

    // 3.2.1 获取主页的banner图片(/banner/list)
    @POST("banner/list")
    Observable<HttpResp<List<BannerBean>>> bannerList();

    // 3.2.2 根据条件获取默认排序专家列表数据(/expert/list)
    @POST("expert/list")
    Observable<HttpResp<List<ExpertBean2>>> expertList(@Body ExpertListParam param);

    // 3.2.2.1 咨询师详情(/expert/detail)
    @FormUrlEncoded
    @POST("expert/detail")
    Observable<HttpResp<ExpertDetailBean2>> expertDetail(@Field("userId") String userId);

    // 3.2.3.2 评价列表(/cmt/getCmtList)
    @POST("cmt/getCmtList")
    Observable<HttpResp<List<EvaluateBean>>> evaluateList(@Body EvaluateParam param);

    // 3.2.3.3 咨询师总评分(/cmt/getScore)
    @FormUrlEncoded
    @POST("cmt/getScore")
    Observable<HttpResp<String>> getScore(@Field("consultId") String consultId);

    // 3.2.3 添加总订单(/wxPay/order) (注：预约或购买产品之前都先调用此接口,以便获取订单号)
    @POST("wxPay/order")
    Observable<HttpResp<String>> addAllOrder(@Body AddAllOrderParam param);

    @FormUrlEncoded
    @POST("wxPay/order")
    Observable<HttpResp<String>> addAllOrder2(@FieldMap Map<String, Object> map);

    //3.2.4.1 锁定时间段(/expert/lock)
    @POST("expert/lock")
    Observable<HttpResp<Boolean>> lockTime(@Body LockParam param);

    @FormUrlEncoded
    @POST("expert/lock")
    Observable<HttpResp<Boolean>> lockTime2(@FieldMap Map<String, Object> map);

    //3.2.4.2 解锁时间段(/expert/unlock)
    @POST("expert/unlock")
    Observable<HttpResp<Boolean>> unlockTime(@Body UnlockParam param);

    // 3.2.4.3 预约(/expert/addApptOrder)
    @POST("expert/addApptOrder")
    Observable<HttpResp<String>> reservation(@Body ReservationParam param);

    @FormUrlEncoded
    @POST("expert/addApptOrder")
    Observable<HttpResp<String>> reservation2(@FieldMap Map<String, Object> param);

    // 3.2.4.4 咨询师订单金额分成(/expert/recharge)
    @Deprecated
    @FormUrlEncoded
    @POST("expert/recharge")
    Observable<HttpResp<Boolean>> cashDivid(@Field("serialId") String serialId);

    // 3.2.4.5 更改预约订单状态(/cancelAppt)
    @POST("cancelAppt")
    Observable<HttpResp<Boolean>> cancelAppt(@Body ChangeOrderStateParam param);

    // 3.2.5.1 APP支付(折扣优惠码支付)(/wxPay/appPay)
    @POST("wxPay/appPay")
    Observable<HttpResp<String>> discountCodePay(@Body DisCodePayParam param);

    @POST("wxPay/appPay")
    @FormUrlEncoded
    Observable<HttpResp<String>> discountCodePay2(@FieldMap Map<String, String> map);  //(encoded = false)

    // 3.2.5.2 查询优惠券信息(/expert/disInfo) (注：用于展示优惠码的折扣)
    @FormUrlEncoded
    @POST("expert/disInfo")
    Observable<HttpResp<String>> couponInfo(@Field("discountCode") String discountCode);


    //  3.2.5.3 免费优惠码支付(/mc/discountPay) (注：优惠码位数为10位)
    @POST("mc/discountPay")
    Observable<HttpResp<Boolean>> freeCodePay(@Body FreeCodePayParam param);

    //    3.2.5.4 心理顾问套餐优惠码支付(/mc/mcPay)
    @FormUrlEncoded
    @POST("mc/mcPay")
    Observable<HttpResp<Boolean>> couponPackgePay(@Field("coupon") String coupon, @Field("operator") String operator, @Field("title") int title);


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

    @FormUrlEncoded
    @POST("cp/addPackageOrder")
    Observable<HttpResp<Boolean>> buyPackge2(@FieldMap Map<String, Object> map);

    //3.2.7.2 生成优惠码(/cp/addPackageCoupon)
    @POST("cp/addPackageCoupon")
    Observable<HttpResp<Object>> generateDisCode(@Body GeneDisCodeParam param);

    //3.3.1 搜索(/search)
    @FormUrlEncoded
    @POST("search")
    Observable<HttpResp<List<ExpertBean2>>> search(@Field("keyWord") String keyWord);

    //3.4.1 系统消息列表(/inform/query)

    //3.4.2 系统消息已读(/inform/update)

    //3.4.3 删除系统消息(/inform/delete)


    //3.5.1 用户获取预约订单列表(/verify/sAppt)
    @POST("verify/sAppt")
    Observable<HttpResp<OrderListBean>> allOrder(@Body OrderListParam param);

    // 3.5.1.1 订单详情(/verify/getApptOrder)
    @FormUrlEncoded
    @POST("verify/getApptOrder")
    Observable<HttpResp<Object>> orderDetail(@Field("serialId") String serialId);


    @FormUrlEncoded
    @POST("verify/sAppt")
    Observable<HttpResp<OrderListBean>> allOrder2(@FieldMap Map<String, Object> param);


    //3.5.3 用户获取购买的咨询师套餐订单列表(/cp/selectPoList)

    //3.5.4 用户获取购买的365心理顾问订单(/verify/morder)

    //3.6.1 查询个人资料(/verify/info/s)

    //3.6.2 修改个人资料(/verify/save/s)

    //3.6.1 添加收藏(/addCollect)
    @FormUrlEncoded
    @POST("addCollect")
    Observable<HttpResp<Boolean>> addCollect(@Field("uId") String uId, @Field("consultId") String consultId);

    //3.6.2 收藏列表(/collecttList)
    @FormUrlEncoded
    @POST("collecttList")
    Observable<HttpResp<FavoriteBean>> collectList(@Field("uId") String uId);


    // 3.8.2 购买者获取购买咨询师套餐后所得的优惠码列表(/cp/selectPcList)
    @FormUrlEncoded
    @POST("cp/selectPcList")
    Observable<HttpResp<CouponPackageListBean>> couponPackgeList(@Field("obtainId") String obtainId);

    // 3.8.3 用户获取电询、面询优惠卷列表(/mc/CcList)
    @FormUrlEncoded
    @POST("mc/CcList")
    Observable<HttpResp<CouponCodeListBean>> couponCodeList(@Field("creator") String creator);


    // 3.8.4 预约时的优惠码选择(/mc/getCouponList)
    @FormUrlEncoded
    @POST("mc/getCouponList")
    Observable<HttpResp<UseableCouponBean>> getAllCouponList(@Field("userId") String userId);


    // 3.12 我的套餐


    // 3.14.3 查询预约时间段状态(/expert/time)(咨询师详情页)
    @FormUrlEncoded
    @POST("expert/time")
    Observable<HttpResp<Object>> getExpertTimes(@Field("userId") String userId);


    // ##############################  咨询师  ####################################

    //3.10.3 图片上传(/uploadFile)
    @POST("uploadFile")
    Observable<HttpResp<String>> uploadFile(@Body RequestBody body);

    @Multipart
    @POST("uploadFile")
    Observable<HttpResp<String>> uploadFile2(@PartMap Map<String, RequestBody> params, @Part MultipartBody.Part p);

    @Multipart
    @POST("uploadFile")
    Observable<HttpResp<String>> uploadFile3(@Part("moduleid") RequestBody moduleid, @Part("oldImg") RequestBody oldImg, @Part MultipartBody.Part p);

    // 3.10.8 客户列表(/getCustomerList)
    @POST("getCustomerList")
    Observable<HttpResp<CustomerListBean>> getCustomerList(@Body CustomerParam param);

    @FormUrlEncoded
    @POST("getCustomerList")
    Observable<HttpResp<CustomerListBean>> getCustomerList2(@FieldMap Map<String, Object> param);

    // 3.10.9 咨询记录(/getConsultNum)
    @FormUrlEncoded
    @POST("getConsultNum")
    Observable<HttpResp<Object>> getConsultNum(@Field("csId") String csId, @Field("userId") String userId);

    // 3.10.10 根据用户id查询用户填写的来访者信息(/client/selectClientAll)
    @FormUrlEncoded
    @POST("client/selectClientAll")
    Observable<HttpResp<List<CustomerInfoBean>>> getCustomerInfo(@Field("userId") String userId);

    // 3.11.1 获取咨询室列表(/room/list)
    @FormUrlEncoded
    @POST("room/list")
    Observable<HttpResp<RoomListBean>> roomList(@Field("type") int type, @Field("addr") String addr);


    // 3.11.2 咨询室详情(/room/detail)
    @FormUrlEncoded
    @POST("room/detail")
    Observable<HttpResp<Object>> roomDetail(@Field("serialNo") String serialNo);

    // 3.11.3 我的咨询室预约(/verify/queryRoomList)
    @POST("verify/queryRoomList")
    Observable<HttpResp<ZiXunShiOrderListBean>> getRoomOrderList(@Body RoomOrderParam param);

    // 3.12.1 获取套餐产品(/cp/getTcAll)
    @POST("cp/getTcAll")
    Observable<HttpResp<List<CouponPackgeBean>>> getCouponPackge();


    // 3.12.2 获取咨询师发布的套餐(/cp/selectCpList)
    // packageState:套餐发布状态(默认为0：未发布；1：已发布；2：已下架)
    @FormUrlEncoded
    @POST("cp/selectCpList")
    Observable<HttpResp<List<CouponPackgeBean>>> getExpertCouponPackge(@Field("consultId") String consultId, @Field("packageState") int packageState);

    // 3.12.3 设置咨询师套餐(/cp/addConsultPackage)
    @POST("cp/addConsultPackage")
    Observable<HttpResp<Object>> addConsultPackage(@Field("consultId") String consultId, @Field("tcId") int tcId);

    // 3.12.4 修改套餐内容、发布/下架套餐(/cp/setCpState)
    @POST("cp/setCpState")
    Observable<HttpResp<Object>> setCpState(@Field("consultId") String consultId, @Field("packageState") int packageState, @Field("tcId") int tcId);

    // 3.12.4 修改套餐内容、更改套餐排序、发布/下架套餐(/cp/setCpState)
    @POST("cp/setCpState")
    Observable<HttpResp<Boolean>> setCpState(@Body ModifyCouponParam param);

    //  3.11.12 查询订单状态(/expert/query/state)
    @FormUrlEncoded
    @POST("expert/query/state")
    Observable<HttpResp<OrderDetailBean>> queryOrderState(@Field("serialId") String serialId);

    // 3.13.1 收支明细列表(/balance/query)  consultId
    @FormUrlEncoded
    @POST("balance/query")
    Observable<HttpResp<Object>> balanceListQuery(@Field("consultId") String consultId);

    // 3.13.2 申请提现(/cash/insert)
    @POST("balance/query")
    Observable<HttpResp<Object>> cashExtract(@Body ExtractParam param);

    // 3.13.3 获取提现记录(/cash/query)
    @FormUrlEncoded
    @POST("cash/query")
    Observable<HttpResp<Object>> queryExtract(@Field("counselorId") String counselorId);


    // 3.13.4 获取银行卡信息(/bank/query)
    @FormUrlEncoded
    @POST("bank/query")
    Observable<HttpResp<Object>> bankQuery(@Field("userId") String userId);

    // 3.13.5 添加提现信息(/bank/insert) userId

    // 3.13.6 修改提现信息(/bank/update)


}


