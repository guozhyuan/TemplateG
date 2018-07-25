package com.psychological.cxks.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class MessageBean {

    /**
     * type : int
     * msg : String
     * sender_name : String
     * sender_img : String
     * receiver_name : String
     * time : long
     * isRead : boolean
     */

    @Id(autoincrement = true)
    private Long id;
    private Integer type;
    private String msg;
    private String sender_name;
    private String sender_img;
    private String receiver_name;
    private Long time;
    private Boolean isRead;

    @Generated(hash = 908622976)
    public MessageBean(Long id, Integer type, String msg, String sender_name,
            String sender_img, String receiver_name, Long time, Boolean isRead) {
        this.id = id;
        this.type = type;
        this.msg = msg;
        this.sender_name = sender_name;
        this.sender_img = sender_img;
        this.receiver_name = receiver_name;
        this.time = time;
        this.isRead = isRead;
    }

    @Generated(hash = 1588632019)
    public MessageBean() {
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getSender_img() {
        return sender_img;
    }

    public void setSender_img(String sender_img) {
        this.sender_img = sender_img;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
