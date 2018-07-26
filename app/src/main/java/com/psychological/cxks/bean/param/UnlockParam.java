package com.psychological.cxks.bean.param;

public class UnlockParam {

//    userId	√	string	32	咨询师ID
//    day	√	string	15	日期，例如：XXXX-XX-XX
//    time	√	int		用户已选时间段对应序号
//    type		int		是否是自动解锁
//    orderId		string		订单编号(type不为空则该字段必传)

    public String userId;
    public String day;
    public int time;
    public int type;
    public String orderId;
}
