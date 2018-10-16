package com.psychological.cxks.bean.param;

public class ModifyCouponParam {
    //    consultId	√	string	32	咨询师id
//    packageState		int		套餐发布状态(默认为0：未发布；1：已发布；2：已下架)(注：发布、下架时传值)
//    tcId		int		套餐id(套餐主键id)(注：修改套餐内容时传值)
    public String consultId;
    public Integer packageState;
    public Integer tcId;
}
