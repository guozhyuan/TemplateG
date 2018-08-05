package com.psychological.cxks.bean;

public class CouponPackgeBean {
//    id	√	int	主键
//    consultId	√	string	咨询师id
//    coupon	√	string	优惠码
//    couponState	√	int	优惠卷状态(默认为0：未使用；1：已使用)
//    time	√	string	获取优惠码时间
//    obtainId	√	string	获取人id
//    obtainName	√	string	获取人姓名
//    useId	√	string	使用人id
//    useTime	√	string	使用时间
//    packageId	√	int	套餐id
//    name	√	string	咨询师姓名
//    content	√	string	套餐名

    private int id;
    private int consultId;
    private int coupon;
    private int couponState;
    private int time;
    private int obtainId;
    private int obtainName;
    private int useId;
    private int useTime;
    private int packageId;
    private int name;
    private int content;
    private boolean checked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConsultId() {
        return consultId;
    }

    public void setConsultId(int consultId) {
        this.consultId = consultId;
    }

    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }

    public int getCouponState() {
        return couponState;
    }

    public void setCouponState(int couponState) {
        this.couponState = couponState;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getObtainId() {
        return obtainId;
    }

    public void setObtainId(int obtainId) {
        this.obtainId = obtainId;
    }

    public int getObtainName() {
        return obtainName;
    }

    public void setObtainName(int obtainName) {
        this.obtainName = obtainName;
    }

    public int getUseId() {
        return useId;
    }

    public void setUseId(int useId) {
        this.useId = useId;
    }

    public int getUseTime() {
        return useTime;
    }

    public void setUseTime(int useTime) {
        this.useTime = useTime;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
