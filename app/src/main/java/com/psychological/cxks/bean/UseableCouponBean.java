package com.psychological.cxks.bean;

import java.util.List;

public class UseableCouponBean {
    private List<MyCouponCodeBean> cc;
    private List<MyCouponPackgeBean> pc;

    public List<MyCouponCodeBean> getCc() {
        return cc;
    }

    public void setCc(List<MyCouponCodeBean> cc) {
        this.cc = cc;
    }

    public List<MyCouponPackgeBean> getPc() {
        return pc;
    }

    public void setPc(List<MyCouponPackgeBean> pc) {
        this.pc = pc;
    }
}
