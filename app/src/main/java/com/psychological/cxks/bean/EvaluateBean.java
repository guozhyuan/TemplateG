package com.psychological.cxks.bean;

public class EvaluateBean {
//    id	√	int	主键
//    consultId	√	string	咨询师id
//    consultName	√	string	咨询师姓名
//    userId	√	string	用户id
//    username	√	string	用户姓名
//    content	√	string	评论内容
//    level	√	int	总体印象(0-5颗星)
//    label	√	string	评论标签
//    title	√	string	咨询主题
//    state	√	int	审核状态(默认0：未审核；1：审核通过；2：审核不通过)
//    time	√		评论时间
//    img	√	string	用户头像
//    addr	√	string	咨询师地址


    private int id;
    private String consultId;
    private String consultName;
    private String userId;
    private String username;
    private String content;
    private int level;
    private String label;
    private String title;
    private int state;
    private String time;
    private String img;
    private String addr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConsultId() {
        return consultId;
    }

    public void setConsultId(String consultId) {
        this.consultId = consultId;
    }

    public String getConsultName() {
        return consultName;
    }

    public void setConsultName(String consultName) {
        this.consultName = consultName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
