package com.psychological.cxks.bean;

/**
 * 用户端:优惠套餐列表
 */
public class MyCouponPackgeBean {
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
    private String consultId;
    private String coupon;
    private int couponState;
    private String time;
    private String obtainId;
    private String obtainName;
    private String useId;
    private String useTime;
    private int packageId;
    private String name;
    private String content;
    private boolean checked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConsultId() {
        return consultId;
    }

    public void setConsultId(String consultId) {
        this.consultId = consultId;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public int getCouponState() {
        return couponState;
    }

    public void setCouponState(int couponState) {
        this.couponState = couponState;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getObtainId() {
        return obtainId;
    }

    public void setObtainId(String obtainId) {
        this.obtainId = obtainId;
    }

    public String getObtainName() {
        return obtainName;
    }

    public void setObtainName(String obtainName) {
        this.obtainName = obtainName;
    }

    public String getUseId() {
        return useId;
    }

    public void setUseId(String useId) {
        this.useId = useId;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
