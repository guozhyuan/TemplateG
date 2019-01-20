package com.psychological.cxks.bean;

import java.io.Serializable;

/**
 * 用户端:  咨询师详情中的套餐列表
 * 咨询师:  我的套餐中套餐
 */
public class CouponPackgeBean implements Serializable{
    /**
     * id : 13
     * tcId : 2
     * consultId : asFsfibeSVxWDz1xV8hsHbQczU5lP7XI
     * state : 0
     * packageState : 1
     * creator : null
     * createTime : null
     * operator : null
     * operateTime : null
     * taocan : 普通级10次咨询套餐
     * price : 850
     * num : 10
     * explain : 电话咨询，面询
     */


    private int id;
    private int tcId;
    private String consultId;
    private int state;
    private int packageState;
    private Object creator;
    private Object createTime;
    private Object operator;
    private Object operateTime;
    private String taocan;
    private int price;
    private int num;
    private String explain;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTcId() {
        return tcId;
    }

    public void setTcId(int tcId) {
        this.tcId = tcId;
    }

    public String getConsultId() {
        return consultId;
    }

    public void setConsultId(String consultId) {
        this.consultId = consultId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getPackageState() {
        return packageState;
    }

    public void setPackageState(int packageState) {
        this.packageState = packageState;
    }

    public Object getCreator() {
        return creator;
    }

    public void setCreator(Object creator) {
        this.creator = creator;
    }

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
        this.createTime = createTime;
    }

    public Object getOperator() {
        return operator;
    }

    public void setOperator(Object operator) {
        this.operator = operator;
    }

    public Object getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Object operateTime) {
        this.operateTime = operateTime;
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

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

}
