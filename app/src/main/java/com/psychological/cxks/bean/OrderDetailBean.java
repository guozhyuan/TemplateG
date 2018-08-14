package com.psychological.cxks.bean;

public class OrderDetailBean {
//    id	√	int	主键
//    orderId	√	string	订单号
//    serialId	√	string	预约流水号
//    userId	√	string	用户id
//    csId	√	string	咨询师ID
//    method	√	int	咨询方式，1—电话咨询，2—见面咨询
//    money	√	double	订单金额
//    name	√	string	姓名
//    time	√	int	预约时间段(具体时间看状态码说明)
//    day	√	string	日期
//    state	√	string	状态，0：已预约，1：咨询结束，2：已取消
//    counselor	√	string	咨询师姓名
//    img	√	string	咨询师头像
//    refund	√	int	退款状态，0：未退款，1：退款中，2：已退款，-1：退款失败
//    field	√	int	咨询方面(具体范围看状态码说明)
//    sex	√	int	用户性别，1—男，2—女
//    addr	√	string	用户所在城市
//    need	√	string	问题描述
//    remark	√	string	备注
//    dizhi	√	string	咨询师地址

    private int id;
    private String orderId;
    private String serialId;
    private String userId;
    private String csId;
    private int method;
    private double money;
    private String name;
    private int time;
    private String day;
    private String state;
    private String counselor;
    private String img;
    private int refund;
    private int field;
    private int sex;
    private String addr;
    private String need;
    private String remark;
    private String dizhi;

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

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCsId() {
        return csId;
    }

    public void setCsId(String csId) {
        this.csId = csId;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounselor() {
        return counselor;
    }

    public void setCounselor(String counselor) {
        this.counselor = counselor;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getRefund() {
        return refund;
    }

    public void setRefund(int refund) {
        this.refund = refund;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }
}
