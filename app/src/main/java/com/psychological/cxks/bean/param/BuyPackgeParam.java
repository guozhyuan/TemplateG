package com.psychological.cxks.bean.param;

public class BuyPackgeParam {
    //    3.2.7.1 购买套餐(/cp/addPackageOrder)
//    consultId	√	string	32	咨询师id
//    orderId	√	string	30	订单号
//    userId	√	string	32	购买者id
//    username	√	string	16	购买人姓名
//    packageId	√	int		套餐id
//    state	√	int		支付状态(0:未支付；1:已支付)
//    coupon		string	5000	优惠码(生成的优惠码)
    public String consultId;
    public String orderId;
    public String userId;
    public String username;
    public int packageId;
    public int state;
    public String coupon;
}
