package com.psychological.cxks.bean.param;

public class PhoneCodePayParam {
    // 3.2.5.5 电询、面询优惠码支付(/mc/couponPay)
//    coupon	√	string	9	优惠码
//    operator	√	string	30	用户id(使用人id)
//    only	√	int		咨询师365标记(用于判断咨询师是否是365咨询师)
//    type	√	int		咨询方式(判断优惠类型是否与咨询方式一致)
    public String coupon;
    public String operator;
    public int only;
    public int type;
}
