package com.psychological.cxks.bean.param;

public class GeneDisCodeParam {
   /* 3.2.7.2 生成优惠码(/cp/addPackageCoupon)
    consultId	√	string	32	咨询师id
    obtainId	√	string	32	获取人id(购买者id)
    obtainName	√	string	16	获取人姓名(购买者姓名)
    packageId	√	int		套餐id
    num	√	int		次数(套餐里的次数)*/

    public String consultId;
    public String obtainId;
    public String obtainName;
    public int packageId;
    public int num;
}
