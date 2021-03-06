package com.psychological.cxks.bean;

import java.util.List;

public class OrderListBean {
    /**
     * begRow : 0
     * endRow : 2
     * newsPageNo : 0
     * dyPageNo : 0
     * pageNo : 1
     * pageSize : 2
     * totalPage : 4
     * totalCount : 7
     * sort : null
     * order : null
     * condition1 : null
     * condition2 : null
     * result : [{"id":408,"userId":"qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N","csId":"EU5544SsWzmAKiMOrKdr78cZA1LxOIYG","orderId":"155500299821539278022057","serialId":"20181012011342711620","method":1,"field":7,"money":null,"name":"","sex":1,"addr":"","mobile":"","need":null,"time":9,"day":"2018年10月20日","state":0,"dealTime":"2018-10-12 01:13:42","operator":null,"remark":"","refund":null,"condition":null,"startDate":null,"endDate":null,"token":null,"counselor":"蔡绮文","img":null,"dizhi":null},{"id":407,"userId":"qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N","csId":"EU5544SsWzmAKiMOrKdr78cZA1LxOIYG","orderId":"155500299821539277928549","serialId":"20181012011208055499","method":1,"field":7,"money":null,"name":"","sex":1,"addr":"","mobile":"","need":null,"time":9,"day":"2018年10月20日","state":0,"dealTime":"2018-10-12 01:12:08","operator":null,"remark":"","refund":null,"condition":null,"startDate":null,"endDate":null,"token":null,"counselor":"蔡绮文","img":null,"dizhi":null}]
     * footer : null
     * params : {"endDate":null,"pageSize":2,"state":null,"sort":"a.id","begRow":0,"userId":"qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N","startDate":null,"order":"desc"}
     * collect : null
     * paramsMap : {"endDate":null,"pageSize":2,"state":null,"sort":"a.id","begRow":0,"userId":"qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N","startDate":null,"order":"desc"}
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
         * endDate : null
         * pageSize : 2
         * state : null
         * sort : a.id
         * begRow : 0
         * userId : qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N
         * startDate : null
         * order : desc
         */

        private Object endDate;
        private int pageSize;
        private Object state;
        private String sort;
        private int begRow;
        private String userId;
        private Object startDate;
        private String order;

        public Object getEndDate() {
            return endDate;
        }

        public void setEndDate(Object endDate) {
            this.endDate = endDate;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public Object getState() {
            return state;
        }

        public void setState(Object state) {
            this.state = state;
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

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Object getStartDate() {
            return startDate;
        }

        public void setStartDate(Object startDate) {
            this.startDate = startDate;
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
         * endDate : null
         * pageSize : 2
         * state : null
         * sort : a.id
         * begRow : 0
         * userId : qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N
         * startDate : null
         * order : desc
         */

        private Object endDate;
        private int pageSize;
        private Object state;
        private String sort;
        private int begRow;
        private String userId;
        private Object startDate;
        private String order;

        public Object getEndDate() {
            return endDate;
        }

        public void setEndDate(Object endDate) {
            this.endDate = endDate;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public Object getState() {
            return state;
        }

        public void setState(Object state) {
            this.state = state;
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

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Object getStartDate() {
            return startDate;
        }

        public void setStartDate(Object startDate) {
            this.startDate = startDate;
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
         * id : 408
         * userId : qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N
         * csId : EU5544SsWzmAKiMOrKdr78cZA1LxOIYG
         * orderId : 155500299821539278022057
         * serialId : 20181012011342711620
         * method : 1
         * field : 7
         * money : null
         * name :
         * sex : 1
         * addr :
         * mobile :
         * need : null
         * time : 9
         * day : 2018年10月20日
         * state : 0
         * dealTime : 2018-10-12 01:13:42
         * operator : null
         * remark :
         * refund : null
         * condition : null
         * startDate : null
         * endDate : null
         * token : null
         * counselor : 蔡绮文
         * img : null
         * dizhi : null
         */

        private int id;
        private String userId;
        private String csId;
        private String orderId;
        private String serialId;
        private int method;
        private int field;
        private Object money;
        private String name;
        private int sex;
        private String addr;
        private String mobile;
        private Object need;
        private int time;
        private String day;
        private int state;
        private String dealTime;
        private Object operator;
        private String remark;
        private Object refund;
        private Object condition;
        private Object startDate;
        private Object endDate;
        private Object token;
        private String counselor;
        private Object img;
        private Object dizhi;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public int getMethod() {
            return method;
        }

        public void setMethod(int method) {
            this.method = method;
        }

        public int getField() {
            return field;
        }

        public void setField(int field) {
            this.field = field;
        }

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
            this.money = money;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getNeed() {
            return need;
        }

        public void setNeed(Object need) {
            this.need = need;
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

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getDealTime() {
            return dealTime;
        }

        public void setDealTime(String dealTime) {
            this.dealTime = dealTime;
        }

        public Object getOperator() {
            return operator;
        }

        public void setOperator(Object operator) {
            this.operator = operator;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public Object getRefund() {
            return refund;
        }

        public void setRefund(Object refund) {
            this.refund = refund;
        }

        public Object getCondition() {
            return condition;
        }

        public void setCondition(Object condition) {
            this.condition = condition;
        }

        public Object getStartDate() {
            return startDate;
        }

        public void setStartDate(Object startDate) {
            this.startDate = startDate;
        }

        public Object getEndDate() {
            return endDate;
        }

        public void setEndDate(Object endDate) {
            this.endDate = endDate;
        }

        public Object getToken() {
            return token;
        }

        public void setToken(Object token) {
            this.token = token;
        }

        public String getCounselor() {
            return counselor;
        }

        public void setCounselor(String counselor) {
            this.counselor = counselor;
        }

        public Object getImg() {
            return img;
        }

        public void setImg(Object img) {
            this.img = img;
        }

        public Object getDizhi() {
            return dizhi;
        }

        public void setDizhi(Object dizhi) {
            this.dizhi = dizhi;
        }
    }
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
//    private int id ;
//    private String orderId ;
//    private String serialId ;
//    private String userId ;
//    private String csId ;
//    private int method ;
//    private double money ;
//    private String name ;
//    private int time ;
//    private String day ;
//    private String state ;
//    private String counselor ;
//    private String img ;
//    private int refund ;



}
