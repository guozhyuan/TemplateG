package com.guo.projectg.bean;

/**
 * Author : jugg
 * Date   : 2018/6/21
 */
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
}
