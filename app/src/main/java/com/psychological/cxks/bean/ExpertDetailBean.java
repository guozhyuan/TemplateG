package com.psychological.cxks.bean;

import java.io.Serializable;

public class ExpertDetailBean implements Serializable{
//    userId	√	string	用户id
//    name	√	string	用户姓名
//    img	√	string	用户头像
//    addr	√	string	地址
//    sex	√	int	性别，1：男，2：女
//    detail	√	string	咨询师详情页内容
//    labels	√	string	擅长领域，倾向于哪方面的咨询，咨询师可有不超过3个的标签，普通用户为1个
//    isGuild	√	int	是否为公会成员，默认值0-否，1-是
//    only	√	int	365标识—咨询师(默认为0：不是；1：是)
//    csType	√	int	咨询方式：1：电询；2：面询；3：电询、面询
//    csLevel	√	int	咨询师等级，1:专家级；2:主任级；3:副主任级；4:资深级；5:高级；6:普通级；7:实习
//    cancelNum	√	int	取消预约的次数(一个月取消两次)
//    cancelTime	√	int	取消预约的时间
//    modifynum	√	int	修改预约的次数(一个月取消两次)
//    modifytime	√	int	修改预约的时间
//    phone	√	double	电询价格
//    meet	√	double	面询价格
//    path	√	string	语音介绍url
//    rank	√	string	头衔
//    workTime	√	int	从业时长
//    therapy	√	string	擅长疗法
//    diploma	√	string	资质证书
//    educationBackground	√	string	教育背景
//    trainingExperience	√	string	培训经历
//    workExprience	√	string	从业经历
//    aptitude	√	string	资质介绍

    private String userId;
    private String name;
    private String img;
    private String addr;
    private int sex;
    private String detail;
    private String labels;
    private int isGuild;
    private int only;
    private int csType;
    private int csLevel;
    private int cancelNum;
    private int cancelTime;
    private int modifynum;
    private int modifytime;
    private double phone;
    private double meet;
    private String path;
    private String rank;
    private int workTime;
    private String therapy;
    private String diploma;
    private String educationBackground;
    private String trainingExperience;
    private String workExprience;
    private String aptitude;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public int getIsGuild() {
        return isGuild;
    }

    public void setIsGuild(int isGuild) {
        this.isGuild = isGuild;
    }

    public int getOnly() {
        return only;
    }

    public void setOnly(int only) {
        this.only = only;
    }

    public int getCsType() {
        return csType;
    }

    public void setCsType(int csType) {
        this.csType = csType;
    }

    public int getCsLevel() {
        return csLevel;
    }

    public void setCsLevel(int csLevel) {
        this.csLevel = csLevel;
    }

    public int getCancelNum() {
        return cancelNum;
    }

    public void setCancelNum(int cancelNum) {
        this.cancelNum = cancelNum;
    }

    public int getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(int cancelTime) {
        this.cancelTime = cancelTime;
    }

    public int getModifynum() {
        return modifynum;
    }

    public void setModifynum(int modifynum) {
        this.modifynum = modifynum;
    }

    public int getModifytime() {
        return modifytime;
    }

    public void setModifytime(int modifytime) {
        this.modifytime = modifytime;
    }

    public double getPhone() {
        return phone;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public double getMeet() {
        return meet;
    }

    public void setMeet(double meet) {
        this.meet = meet;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
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

    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    public String getTrainingExperience() {
        return trainingExperience;
    }

    public void setTrainingExperience(String trainingExperience) {
        this.trainingExperience = trainingExperience;
    }

    public String getWorkExprience() {
        return workExprience;
    }

    public void setWorkExprience(String workExprience) {
        this.workExprience = workExprience;
    }

    public String getAptitude() {
        return aptitude;
    }

    public void setAptitude(String aptitude) {
        this.aptitude = aptitude;
    }
}
