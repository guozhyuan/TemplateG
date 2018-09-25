package com.psychological.cxks.bean;

import java.util.List;

/**
 * 用户端> 我的优惠券>优惠码列表
 */
public class CouponCodeListBean {

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
     * result : [{"id":136,"orderId":"123","type":1,"coupon":"123456789","couponState":0,"creator":null,"createTime":"2018-08-18 15:08:02","operator":null,"operateTime":null,"only":null,"token":null}]
     * footer : null
     * params : {"creator":"qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N","pageSize":20,"sort":"create_time","begRow":0,"order":"desc"}
     * collect : null
     * paramsMap : {"creator":"qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N","pageSize":20,"sort":"create_time","begRow":0,"order":"desc"}
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
         * creator : qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N
         * pageSize : 20
         * sort : create_time
         * begRow : 0
         * order : desc
         */

        private String creator;
        private int pageSize;
        private String sort;
        private int begRow;
        private String order;

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

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

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }

    public static class ParamsMapBean {
        /**
         * creator : qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N
         * pageSize : 20
         * sort : create_time
         * begRow : 0
         * order : desc
         */

        private String creator;
        private int pageSize;
        private String sort;
        private int begRow;
        private String order;

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

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

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }

    public static class ResultBean {
        /**
         * id : 136
         * orderId : 123
         * type : 1
         * coupon : 123456789
         * couponState : 0
         * creator : null
         * createTime : 2018-08-18 15:08:02
         * operator : null
         * operateTime : null
         * only : null
         * token : null
         */

        private int id;
        private String orderId;
        private int type;
        private String coupon;
        private int couponState;
        private Object creator;
        private String createTime;
        private Object operator;
        private Object operateTime;
        private Object only;
        private Object token;

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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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

        public Object getCreator() {
            return creator;
        }

        public void setCreator(Object creator) {
            this.creator = creator;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getOperator() {
            return operator;
        }

        public void setOperator(Object operator) {
            this.operator = operator;
        }

        public Object getOperateTime() {
            return operateTime;
        }

        public void setOperateTime(Object operateTime) {
            this.operateTime = operateTime;
        }

        public Object getOnly() {
            return only;
        }

        public void setOnly(Object only) {
            this.only = only;
        }

        public Object getToken() {
            return token;
        }

        public void setToken(Object token) {
            this.token = token;
        }
    }
}
