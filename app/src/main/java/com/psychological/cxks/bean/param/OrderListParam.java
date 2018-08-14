package com.psychological.cxks.bean.param;

public class OrderListParam {
//    token	√	string	100	用户登录成功时返回的token
//    state		int		订单状态，-1:已下单；0：已付款；1：已取消；2：已确定接单；3：咨询结束；4：已评价
//    startDate		string	10	下单开始日期
//    endDate		string	10	下单截止日期
//    pageSize	√	int		页面数量
//    pageNo	√	int		页码
    public String token;
    public Integer state;
    public String startDate;
    public String endDate;
    public int pageSize = 20;
    public int pageNo = 1;
}
