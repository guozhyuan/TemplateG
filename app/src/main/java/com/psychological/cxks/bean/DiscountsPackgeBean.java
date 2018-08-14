package com.psychological.cxks.bean;

public class DiscountsPackgeBean {
    private boolean isExpand = false;
    private int subTypeCnt = 5;

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public int getSubTypeCnt() {
        return subTypeCnt;
    }

    public void setSubTypeCnt(int subTypeCnt) {
        this.subTypeCnt = subTypeCnt;
    }

}
