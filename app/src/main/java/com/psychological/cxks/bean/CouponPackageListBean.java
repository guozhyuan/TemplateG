package com.psychological.cxks.bean;

import java.util.List;

// 用户端> 我的优惠券>优惠套餐列表
public class CouponPackageListBean {

    /**
     * begRow : 0
     * endRow : 20
     * newsPageNo : 0
     * dyPageNo : 0
     * pageNo : 1
     * pageSize : 20
     * totalPage : 1
     * totalCount : 1
     * sort : null
     * order : null
     * condition1 : null
     * condition2 : null
     * result : [{"id":284,"consultId":"x9lxEQyAHawvngJg3avHuYHCKM2Pk8wC","coupon":"12345678910","couponState":0,"time":"2018-08-18 15:10:23","obtainId":"qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N","obtainName":"cxks_15550029982","useId":null,"useTime":null,"packageId":18,"num":null,"name":"测试账号(勿动)","taocan":"专家级首次体验价","money":null,"price":null}]
     * footer : null
     * params : {"pageSize":20,"sort":"pc.time","begRow":0,"obtainId":"qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N","couponState":null,"order":"desc"}
     * collect : null
     * paramsMap : {"pageSize":20,"sort":"pc.time","begRow":0,"obtainId":"qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N","couponState":null,"order":"desc"}
     * page : true
     */

    private int begRow;
    private int endRow;
    private int newsPageNo;
    private int dyPageNo;
    private int pageNo;
    private int pageSize;
    private int totalPage;
    private int totalCount;
    private Object sort;
    private Object order;
    private Object condition1;
    private Object condition2;
    private Object footer;
    private ParamsBean params;
    private Object collect;
    private ParamsMapBean paramsMap;
    private boolean page;
    private List<ResultBean> result;

    public int getBegRow() {
        return begRow;
    }

    public void setBegRow(int begRow) {
        this.begRow = begRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getNewsPageNo() {
        return newsPageNo;
    }

    public void setNewsPageNo(int newsPageNo) {
        this.newsPageNo = newsPageNo;
    }

    public int getDyPageNo() {
        return dyPageNo;
    }

    public void setDyPageNo(int dyPageNo) {
        this.dyPageNo = dyPageNo;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public Object getSort() {
        return sort;
    }

    public void setSort(Object sort) {
        this.sort = sort;
    }

    public Object getOrder() {
        return order;
    }

    public void setOrder(Object order) {
        this.order = order;
    }

    public Object getCondition1() {
        return condition1;
    }

    public void setCondition1(Object condition1) {
        this.condition1 = condition1;
    }

    public Object getCondition2() {
        return condition2;
    }

    public void setCondition2(Object condition2) {
        this.condition2 = condition2;
    }

    public Object getFooter() {
        return footer;
    }

    public void setFooter(Object footer) {
        this.footer = footer;
    }

    public ParamsBean getParams() {
        return params;
    }

    public void setParams(ParamsBean params) {
        this.params = params;
    }

    public Object getCollect() {
        return collect;
    }

    public void setCollect(Object collect) {
        this.collect = collect;
    }

    public ParamsMapBean getParamsMap() {
        return paramsMap;
    }

    public void setParamsMap(ParamsMapBean paramsMap) {
        this.paramsMap = paramsMap;
    }

    public boolean isPage() {
        return page;
    }

    public void setPage(boolean page) {
        this.page = page;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ParamsBean {
        /**
         * pageSize : 20
         * sort : pc.time
         * begRow : 0
         * obtainId : qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N
         * couponState : null
         * order : desc
         */

        private int pageSize;
        private String sort;
        private int begRow;
        private String obtainId;
        private Object couponState;
        private String order;

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public int getBegRow() {
            return begRow;
        }

        public void setBegRow(int begRow) {
            this.begRow = begRow;
        }

        public String getObtainId() {
            return obtainId;
        }

        public void setObtainId(String obtainId) {
            this.obtainId = obtainId;
        }

        public Object getCouponState() {
            return couponState;
        }

        public void setCouponState(Object couponState) {
            this.couponState = couponState;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }

    public static class ParamsMapBean {
        /**
         * pageSize : 20
         * sort : pc.time
         * begRow : 0
         * obtainId : qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N
         * couponState : null
         * order : desc
         */

        private int pageSize;
        private String sort;
        private int begRow;
        private String obtainId;
        private Object couponState;
        private String order;

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public int getBegRow() {
            return begRow;
        }

        public void setBegRow(int begRow) {
            this.begRow = begRow;
        }

        public String getObtainId() {
            return obtainId;
        }

        public void setObtainId(String obtainId) {
            this.obtainId = obtainId;
        }

        public Object getCouponState() {
            return couponState;
        }

        public void setCouponState(Object couponState) {
            this.couponState = couponState;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }

    public static class ResultBean {
        /**
         * id : 284
         * consultId : x9lxEQyAHawvngJg3avHuYHCKM2Pk8wC
         * coupon : 12345678910
         * couponState : 0
         * time : 2018-08-18 15:10:23
         * obtainId : qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N
         * obtainName : cxks_15550029982
         * useId : null
         * useTime : null
         * packageId : 18
         * num : null
         * name : 测试账号(勿动)
         * taocan : 专家级首次体验价
         * money : null
         * price : null
         */

        private int id;
        private String consultId;
        private String coupon;
        private int couponState;
        private String time;
        private String obtainId;
        private String obtainName;
        private Object useId;
        private Object useTime;
        private int packageId;
        private Object num;
        private String name;
        private String taocan;
        private Object money;
        private Object price;

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

        public String getCoupon() {
            return coupon;
        }

        public void setCoupon(String coupon) {
            this.coupon = coupon;
        }

        public int getCouponState() {
            return couponState;
        }

        public void setCouponState(int couponState) {
            this.couponState = couponState;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getObtainId() {
            return obtainId;
        }

        public void setObtainId(String obtainId) {
            this.obtainId = obtainId;
        }

        public String getObtainName() {
            return obtainName;
        }

        public void setObtainName(String obtainName) {
            this.obtainName = obtainName;
        }

        public Object getUseId() {
            return useId;
        }

        public void setUseId(Object useId) {
            this.useId = useId;
        }

        public Object getUseTime() {
            return useTime;
        }

        public void setUseTime(Object useTime) {
            this.useTime = useTime;
        }

        public int getPackageId() {
            return packageId;
        }

        public void setPackageId(int packageId) {
            this.packageId = packageId;
        }

        public Object getNum() {
            return num;
        }

        public void setNum(Object num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTaocan() {
            return taocan;
        }

        public void setTaocan(String taocan) {
            this.taocan = taocan;
        }

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
            this.money = money;
        }

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }
    }
}
