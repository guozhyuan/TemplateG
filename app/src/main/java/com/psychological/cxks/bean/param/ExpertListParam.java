package com.psychological.cxks.bean.param;

public class ExpertListParam {
//    sex		int		性别(1:男，2:女)
//    addr		string	100	地区
//    labels		string	100	领域
//    pageSize	√	int		页面数量
//    pageNo	√	int		页码

    public Integer sex;
    public String addr;
    public String labels;
    public int pageSize = 20;
    public int pageNo = 1;
}
