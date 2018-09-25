package com.psychological.cxks.bean.param;

public class RoomOrderParam {
//    token	√	string	100	用户登录成功时返回的token
//    state		int		订单状态
//    startDate		string	10	下单开始日期
//    endDate		string	10	下单截止日期
//    condition		string	20	订单编号关键字(暂定)
//    pageSize	√	int		页面数量
//    pageNo	√	int		页码
//    sort		string		排序字段
//    order		string		排序方式(正序-asc,倒序-desc)

    public String token;
    public String state;
    public String startDate;
    public String endDate;
    public String condition;
    public int pageSize = 20;
    public int pageNo = 1;
    public String sort;
    public String order;

}
