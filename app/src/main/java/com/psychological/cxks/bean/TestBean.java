package com.psychological.cxks.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Author : jugg
 * Date   : 2018/6/21
 */

@Entity
public class TestBean {
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "status=" + status +
                ", detail='" + detail + '\'' +
                '}';
    }

    private String detail;

    @Generated(hash = 1144986263)
    public TestBean(int status, String detail) {
        this.status = status;
        this.detail = detail;
    }

    @Generated(hash = 2087637710)
    public TestBean() {
    }
}
