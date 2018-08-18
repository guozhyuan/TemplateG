package com.psychological.cxks.bean;

import java.io.Serializable;

/**
 * 用户端:  咨询师详情中的套餐列表
 * 咨询师:  我的套餐中套餐
 */
public class CouponPackgeBean implements Serializable{
    //    id	√	int	套餐主键id
//    taocan	√	string	订单号
//    price	√	int	套餐价格
//    num	√	int	咨询次数
//    level	√	int	咨询师级别
//    explain	√	string	套餐说明
    private int id;
    private String taocan;
    private int price;
    private int num;
    private int level;
    private String explain;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaocan() {
        return taocan;
    }

    public void setTaocan(String taocan) {
        this.taocan = taocan;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
