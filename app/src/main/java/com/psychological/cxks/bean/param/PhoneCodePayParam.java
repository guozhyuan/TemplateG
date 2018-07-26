package com.psychological.cxks.bean.param;

public class PhoneCodePayParam {
    // 3.2.5.5 电询、面询优惠码支付(/mc/couponPay)
//    only	√	int		咨询师365标记(用于判断咨询师是否是365咨询师)
//    type	√	int		咨询方式(判断优惠类型是否与咨询方式一致)
    public int only;
    public int type;
}
