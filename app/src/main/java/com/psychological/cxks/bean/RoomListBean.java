package com.psychological.cxks.bean;

import java.util.List;

public class RoomListBean {

    /**
     * begRow : 0
     * endRow : 20
     * newsPageNo : 0
     * dyPageNo : 0
     * pageNo : 1
     * pageSize : 20
     * totalPage : 0
     * totalCount : 0
     * sort : null
     * order : null
     * condition1 : null
     * condition2 : null
     * result : []
     * footer : null
     * params : {"pageSize":20,"sort":"create_time","type":0,"addr":"","begRow":0,"order":"desc"}
     * collect : null
     * paramsMap : {"pageSize":20,"sort":"create_time","type":0,"addr":"","begRow":0,"order":"desc"}
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
         * sort : create_time
         * type : 0
         * addr :
         * begRow : 0
         * order : desc
         */

        private int pageSize;
        private String sort;
        private int type;
        private String addr;
        private int begRow;
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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
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
         * pageSize : 20
         * sort : create_time
         * type : 0
         * addr :
         * begRow : 0
         * order : desc
         */

        private int pageSize;
        private String sort;
        private int type;
        private String addr;
        private int begRow;
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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
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

    }
}
