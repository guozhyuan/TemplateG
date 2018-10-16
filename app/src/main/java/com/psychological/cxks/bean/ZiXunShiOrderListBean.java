package com.psychological.cxks.bean;

import java.util.List;

public class ZiXunShiOrderListBean {

    /**
     * begRow : 0
     * endRow : 20
     * newsPageNo : 0
     * dyPageNo : 0
     * pageNo : 1
     * pageSize : 20
     * totalPage : 1
     * totalCount : 7
     * sort : null
     * order : null
     * condition1 : null
     * condition2 : null
     * result : [{"id":214,"orderId":"139233401881538210922908","serialId":"20180929164938116412","userId":"Gi24CWFuueQBUHPdP3PJir87nwYG4UIC","roomId":"gd52501003","day":"2018-10-01","time":7,"name":"测试帐号ken","mobile":"13923340188","state":2,"orderTime":"2018-09-29 16:49:39","dealTime":null,"operator":null,"remark":"","code":null,"startDate":null,"endDate":null,"token":null,"roomName":"东莞咨询室02"},{"id":213,"orderId":"139233401881538210922908","serialId":"20180929164938054195","userId":"Gi24CWFuueQBUHPdP3PJir87nwYG4UIC","roomId":"gd52501003","day":"2018-10-01","time":7,"name":"测试帐号ken","mobile":"13923340188","state":2,"orderTime":"2018-09-29 16:49:39","dealTime":null,"operator":null,"remark":"","code":null,"startDate":null,"endDate":null,"token":null,"roomName":"东莞咨询室02"},{"id":212,"orderId":"189228607601538210629695","serialId":"20180929164442594450","userId":"Gi24CWFuueQBUHPdP3PJir87nwYG4UIC","roomId":"gd52501003","day":"2018-10-01","time":7,"name":"测试帐号ken","mobile":"18922860760","state":2,"orderTime":"2018-09-29 16:44:42","dealTime":null,"operator":null,"remark":"","code":null,"startDate":null,"endDate":null,"token":null,"roomName":"东莞咨询室02"},{"id":211,"orderId":"189228607601538210629695","serialId":"20180929164442963071","userId":"Gi24CWFuueQBUHPdP3PJir87nwYG4UIC","roomId":"gd52501003","day":"2018-10-01","time":7,"name":"测试帐号ken","mobile":"18922860760","state":2,"orderTime":"2018-09-29 16:44:42","dealTime":null,"operator":null,"remark":"","code":null,"startDate":null,"endDate":null,"token":null,"roomName":"东莞咨询室02"},{"id":210,"orderId":"139233401881538209209245","serialId":"20180929162051081843","userId":"Gi24CWFuueQBUHPdP3PJir87nwYG4UIC","roomId":"gd52501003","day":"2018-09-30","time":7,"name":"测试帐号ken","mobile":"13923340188","state":2,"orderTime":"2018-09-29 16:20:51","dealTime":null,"operator":null,"remark":"","code":null,"startDate":null,"endDate":null,"token":null,"roomName":"东莞咨询室02"},{"id":209,"orderId":"139233401881538209209245","serialId":"20180929162051237170","userId":"Gi24CWFuueQBUHPdP3PJir87nwYG4UIC","roomId":"gd52501003","day":"2018-09-30","time":7,"name":"测试帐号ken","mobile":"13923340188","state":0,"orderTime":"2018-09-29 16:20:51","dealTime":null,"operator":null,"remark":"","code":null,"startDate":null,"endDate":null,"token":null,"roomName":"东莞咨询室02"},{"id":186,"orderId":"139233401881531719037626","serialId":"20180716133041004489","userId":"Gi24CWFuueQBUHPdP3PJir87nwYG4UIC","roomId":"sz52501002","day":"2018-07-16","time":9,"name":"测试帐号ken","mobile":"13923340188","state":0,"orderTime":"2018-07-16 13:30:41","dealTime":null,"operator":null,"remark":"通过免费优惠码购买","code":null,"startDate":null,"endDate":null,"token":null,"roomName":"深圳卓悦汇3号咨询室"}]
     * footer : null
     * params : {"serialId":null,"endDate":null,"pageSize":20,"state":null,"sort":"r.id","begRow":0,"userId":"Gi24CWFuueQBUHPdP3PJir87nwYG4UIC","startDate":null,"order":"desc"}
     * collect : null
     * paramsMap : {"serialId":null,"endDate":null,"pageSize":20,"state":null,"sort":"r.id","begRow":0,"userId":"Gi24CWFuueQBUHPdP3PJir87nwYG4UIC","startDate":null,"order":"desc"}
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
         * serialId : null
         * endDate : null
         * pageSize : 20
         * state : null
         * sort : r.id
         * begRow : 0
         * userId : Gi24CWFuueQBUHPdP3PJir87nwYG4UIC
         * startDate : null
         * order : desc
         */

        private Object serialId;
        private Object endDate;
        private int pageSize;
        private Object state;
        private String sort;
        private int begRow;
        private String userId;
        private Object startDate;
        private String order;

        public Object getSerialId() {
            return serialId;
        }

        public void setSerialId(Object serialId) {
            this.serialId = serialId;
        }

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
         * serialId : null
         * endDate : null
         * pageSize : 20
         * state : null
         * sort : r.id
         * begRow : 0
         * userId : Gi24CWFuueQBUHPdP3PJir87nwYG4UIC
         * startDate : null
         * order : desc
         */

        private Object serialId;
        private Object endDate;
        private int pageSize;
        private Object state;
        private String sort;
        private int begRow;
        private String userId;
        private Object startDate;
        private String order;

        public Object getSerialId() {
            return serialId;
        }

        public void setSerialId(Object serialId) {
            this.serialId = serialId;
        }

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
         * id : 214
         * orderId : 139233401881538210922908
         * serialId : 20180929164938116412
         * userId : Gi24CWFuueQBUHPdP3PJir87nwYG4UIC
         * roomId : gd52501003
         * day : 2018-10-01
         * time : 7
         * name : 测试帐号ken
         * mobile : 13923340188
         * state : 2
         * orderTime : 2018-09-29 16:49:39
         * dealTime : null
         * operator : null
         * remark :
         * code : null
         * startDate : null
         * endDate : null
         * token : null
         * roomName : 东莞咨询室02
         */

        private int id;
        private String orderId;
        private String serialId;
        private String userId;
        private String roomId;
        private String day;
        private int time;
        private String name;
        private String mobile;
        private int state;
        private String orderTime;
        private Object dealTime;
        private Object operator;
        private String remark;
        private Object code;
        private Object startDate;
        private Object endDate;
        private Object token;
        private String roomName;

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

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(String orderTime) {
            this.orderTime = orderTime;
        }

        public Object getDealTime() {
            return dealTime;
        }

        public void setDealTime(Object dealTime) {
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

        public Object getCode() {
            return code;
        }

        public void setCode(Object code) {
            this.code = code;
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

        public String getRoomName() {
            return roomName;
        }

        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }
    }
}
