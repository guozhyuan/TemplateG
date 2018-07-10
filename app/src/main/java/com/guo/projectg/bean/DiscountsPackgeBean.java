package com.guo.projectg.bean;

public class DiscountsPackgeBean {
    private boolean isExpand = false;

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public int getSunTypeCnt() {
        return sunTypeCnt;
    }

    public void setSunTypeCnt(int sunTypeCnt) {
        this.sunTypeCnt = sunTypeCnt;
    }

    private int sunTypeCnt = 5;
}
