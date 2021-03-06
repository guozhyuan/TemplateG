package com.psychological.cxks.bean.param;

public class ReservationParam {
//    userId	√	string	100	用户id
//    orderId	√	string	50	订单号(总订单返回的订单号)
//    csId	√	string	32	咨询师ID
//    method	√	int		咨询方式(1-电询；2-面询；3-文字)
//    state 状态，-1:已下单；0：已付款(已预约)；1：已取消；2：已确定接单；3：咨询结束；4：已评价
//    field	√	int		咨询方面（标签）
//    money	√	double	32	订单金额
//    name	√	string	20	联系人
//    sex		int		性别
//    addr		string	30	所在城市
//    mobile	string	11	手机号码
//    need		string	300	用户需求
//    time	√	int		时间段序号
//    day	√	string		日期，例如：XXXX-XX-XX
//    remark		string		需求(如果是用优惠码支付的请备注：通过免费优惠码预约)


    public String userId;
    public String orderId;
    public String csId;
    public int method;
    public int state;
    public int field;
    public double money;
    public String name;
    public int sex;
    public String addr;
    public String mobile;
    public String need;
    public int time;
    public String day;
    public String remark;
}
