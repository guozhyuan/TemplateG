package com.psychological.cxks.bean.param;

public class EvaluateParam {
    //    consultId	√	string	32	咨询师id
//    state	√	int		审核状态(默认0：未审核；1：审核通过；2：审核不通过)
//    pageSize	√	int		页面数量
//    pageNo	√	int		页码
    public String consultId;
    public int state = 1;
    public int pageSize = 20;
    public int pageNo = 1;
}
