package com.guo.projectg.bean;

import java.util.List;

public class BannerBean {
    private String id;
    private String link;
    private String descp;
    private int sn; // 是否推荐到首页，0：不推荐，1：推荐，默认为0
    private int isRecommend;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public int getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(int isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
