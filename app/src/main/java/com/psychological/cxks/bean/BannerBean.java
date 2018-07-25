package com.psychological.cxks.bean;

public class BannerBean {
    /**
     * isRecommend : 1
     * creator : 1
     * img : http://47.93.30.63/banner/15114868478994960ae1b5d1344d3afe8dfcd239e195c.jpg
     * create_time : 2018-07-07 12:15:23
     * link : http://www.525xl.com/qinggan
     * id : 1
     * sn : 2
     * operator : 1
     * operate_time : 2018-07-10 11:01:37
     * descp : banner3
     */

    private int isRecommend;
    private String creator;
    private String img;
    private String create_time;
    private String link;
    private String id;
    private int sn;
    private String operator;
    private String operate_time;
    private String descp;

    public int getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(int isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperate_time() {
        return operate_time;
    }

    public void setOperate_time(String operate_time) {
        this.operate_time = operate_time;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }
//    id	√	string	主键id
//    link	√	string	banner图跳转链接地址
//    descp	√	string	图片文字描述
//    sn	√	int	图片序号
//    isRecommend	√	int	是否推荐到首页，0：不推荐，1：推荐，默认为0


//    private String id;
//    private String link;
//    private String descp;
//    private int sn; // 是否推荐到首页，0：不推荐，1：推荐，默认为0
//    private int isRecommend;
//    private String url;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getLink() {
//        return link;
//    }
//
//    public void setLink(String link) {
//        this.link = link;
//    }
//
//    public String getDescp() {
//        return descp;
//    }
//
//    public void setDescp(String descp) {
//        this.descp = descp;
//    }
//
//    public int getSn() {
//        return sn;
//    }
//
//    public void setSn(int sn) {
//        this.sn = sn;
//    }
//
//    public int getIsRecommend() {
//        return isRecommend;
//    }
//
//    public void setIsRecommend(int isRecommend) {
//        this.isRecommend = isRecommend;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    @Override
//    public String toString() {
//        return "BannerBean{" +
//                "id='" + id + '\'' +
//                ", link='" + link + '\'' +
//                ", descp='" + descp + '\'' +
//                ", sn=" + sn +
//                ", isRecommend=" + isRecommend +
//                ", url='" + url + '\'' +
//                '}';
//    }


}
