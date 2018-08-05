package com.psychological.cxks.bean;

public class CouponCodeBean {
    //    id	√	int	主键
//    orderId	√	string	订单号
//    type	√	int	优惠类型:1代表电询；2代表面询
//    coupon	√	string	优惠码
//    couponState	√	int	优惠码状态：默认为0，未使用；1为已使用
    private int id;
    private String orderId;
    private int type;
    private String coupon;
    private int couponState;
    private boolean checked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
