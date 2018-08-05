package com.psychological.cxks.bean;

public class FavoriteBean {
//    uId	√	string	32	用户id
//    consultId	√	string	32	咨询师id
//    createTime	√			收藏时间
//    name	√	string		咨询师姓名
//    img	√	string		咨询师头像
//    only	√	int		是否是365咨询师(0:否；1：是)
//    workTime	√	int		从业时间
//    addr	√	string		咨询师地址
//    therapy	√	string		擅长疗法
//    diploma	√	string		资质证书

    private String uId;
    private String consultId;
    private String createTime;
    private String name;
    private String img;
    private int only;
    private int workTime;
    private String addr;
    private String therapy;
    private String diploma;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getConsultId() {
        return consultId;
    }

    public void setConsultId(String consultId) {
        this.consultId = consultId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getOnly() {
        return only;
    }

    public void setOnly(int only) {
        this.only = only;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTherapy() {
        return therapy;
    }

    public void setTherapy(String therapy) {
        this.therapy = therapy;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }
}
