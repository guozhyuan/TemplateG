package com.psychological.cxks.bean.param;

public class ChangeOrderStateParam {
    //    serialId	√	string	20	预约流水号
//    state	√	int		状态，-1:已下单；0：已付款；1：已取消；2：已确定接单；3：咨询结束；4：已评价
    public String serialId;
    public int state;
}
