package com.psychological.cxks.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ExpertBean {

    //    userId	√	string	用户id
//    name	√	string	用户姓名
//    img	√	string	用户头像
//    addr	√	string	地址
//    sex	√	int	性别，1：男，2：女
//    personalDesc	√	string	咨询经历的自我描述
//    labels	√	string	标签，倾向于哪方面的咨询，咨询师可有不超过3个的标签，普通用户为1个
//    serial	√	int	排序序号
//    isGuild	√	int	是否为公会成员，0-否，1-是，默认值0
//    only	√	int	365标识—咨询师(默认为0：不是；1：是)
//    ioState	√	int	咨询师在线/离线状态(默认为0：离线；1：在线)
    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable{
        private String userId;
        private String name;
        private String img;
        private String addr;
        private int sex;
        private String personalDesc;
        private String labels;
        private int serial;
        private int isGuild;
        private int only;
        private int ioState;
        private int price;

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

        public String getPersonalDesc() {
            return personalDesc;
        }

        public void setPersonalDesc(String personalDesc) {
            this.personalDesc = personalDesc;
        }

        public String getLabels() {
            return labels;
        }

        public void setLabels(String labels) {
            this.labels = labels;
        }

        public int getSerial() {
            return serial;
        }

        public void setSerial(int serial) {
            this.serial = serial;
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

        public int getIoState() {
            return ioState;
        }

        public void setIoState(int ioState) {
            this.ioState = ioState;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "userId='" + userId + '\'' +
                    ", name='" + name + '\'' +
                    ", img='" + img + '\'' +
                    ", addr='" + addr + '\'' +
                    ", sex=" + sex +
                    ", personalDesc='" + personalDesc + '\'' +
                    ", labels='" + labels + '\'' +
                    ", serial=" + serial +
                    ", isGuild=" + isGuild +
                    ", only=" + only +
                    ", ioState=" + ioState +
                    '}';
        }
    }
}
