package com.psychological.cxks;

/**
 * Author : jugg
 * Date   : 2018/6/21
 */
public class Constant {


    //    public static final String BASE_URL = "http://192.168.50.210:8080/";
    public static final String BASE_URL = "http://39.108.214.157:8090/cxks_app/";
    public static final String WXAPP_ID = "wx52a3d9c190ff01d6";

    // 微信支付类型
    public static final String WX_PAY_KEY = "WXPayType";
    public static final int WX_PAY_TYPE_YUYUE = 1;
    public static final int WX_PAY_TYPE_PACKGE = 2;

    // 折扣类型 -> 预约时优惠列表项类型
    public static final int COUPON_TYPE_CODE = 1;
    public static final int COUPON_TYPE_PACKGE = 2;

    // 支付类型
    public static final String PAY_KEY = "PayType";
    public static final int PAY_TYPE_DEFAULT = 0;             // 默认
    public static final int PAY_TYPE_DIRECT = 1;              // 无优惠
    public static final int PAY_TYPE_INPUT_FREE = 2;         // 手动输入的优惠码,类型为折扣
    public static final int PAY_TYPE_INPUT_DISCOUNT = 3;    //  手动输入的优惠码,类型为免费
    public static final int PAY_TYPE_CODE = 4;                //  优惠码列表中的优惠码
    public static final int PAY_TYPE_PACKGE = 5;              //  优惠套餐列表中的优惠码


    // 聊天内容类型
    public static final int CHAT_TYPE_TEXT_MINE = 1;
    public static final int CHAT_TYPE_TEXT_PEER = 2;

    // 语音
    public static final String RTC_TYPE = "rtc_type";
    public static final int RTC_TYPE_SEND = 1;
    public static final int RTC_TYPE_RECV = 2;
}
