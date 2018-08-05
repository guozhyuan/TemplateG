package com.psychological.cxks.bean.param;

public class CouponPackgeParam {
    //    obtainId	√	string	32	获取者id
//    pageSize	√	int		页面数量
//    pageNo	√	int		页码

    private String obtainId;
    private int pageSize;
    private int pageNo;

    public String getObtainId() {
        return obtainId;
    }

    public void setObtainId(String obtainId) {
        this.obtainId = obtainId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
