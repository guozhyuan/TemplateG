package com.psychological.cxks.bean;

import java.io.Serializable;
import java.util.List;

public class CustomerListBean {

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
         * csId : Gi24CWFuueQBUHPdP3PJir87nwYG4UIC
         * pageSize : 20
         * begRow : 0
         */

        private String csId;
        private int pageSize;
        private int begRow;

        public String getCsId() {
            return csId;
        }

        public void setCsId(String csId) {
            this.csId = csId;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getBegRow() {
            return begRow;
        }

        public void setBegRow(int begRow) {
            this.begRow = begRow;
        }
    }

    public static class ParamsMapBean {
        /**
         * csId : Gi24CWFuueQBUHPdP3PJir87nwYG4UIC
         * pageSize : 20
         * begRow : 0
         */

        private String csId;
        private int pageSize;
        private int begRow;

        public String getCsId() {
            return csId;
        }

        public void setCsId(String csId) {
            this.csId = csId;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getBegRow() {
            return begRow;
        }

        public void setBegRow(int begRow) {
            this.begRow = begRow;
        }
    }

    public static class ResultBean implements Serializable{
        /**
         * userId : 87BaHeSDfx0TI4FmigWCRcskIOjywoyQ
         * mobile : null
         * type : null
         * name : 12121
         * img :
         * email : null
         * addr : 广东省肇庆市鼎湖区
         * sex : null
         * birth : null
         * balance : null
         * labels : null
         * state : null
         * creator : null
         * createTime : null
         * operator : null
         * operateTime : null
         * remark : null
         * positive : null
         * negative : null
         * degree : null
         * personalDesc : null
         * price : 0
         * eduImg : null
         * postCertificate : null
         * trainMaterial : null
         * caseDesc : null
         * supMaterial : null
         * teamTutorProve : null
         * relatedThesis : null
         * relatedThesisMaterial : null
         * account : null
         * csType : null
         * csLevel : null
         * phone : 0
         * meet : 0
         * starLevel : null
         * mostSkilled : null
         * auditState : null
         * reason : null
         * serial : null
         * detail : null
         * token : null
         * isGuild : null
         * cancelNum : null
         * cancelTime : null
         * only : null
         * modifynum : null
         * modifytime : null
         * ioState : null
         * recommendCode : null
         * rank : null
         * path : null
         * workTime : null
         * therapy : null
         * diploma : null
         * educationBackground : null
         * trainingExperience : null
         * workExprience : null
         * aptitude : null
         * jg : null
         * pwd : false
         */

        private String userId;
        private Object mobile;
        private Object type;
        private String name;
        private String img;
        private Object email;
        private String addr;
        private Object sex;
        private Object birth;
        private Object balance;
        private Object labels;
        private Object state;
        private Object creator;
        private Object createTime;
        private Object operator;
        private Object operateTime;
        private Object remark;
        private Object positive;
        private Object negative;
        private Object degree;
        private Object personalDesc;
        private int price;
        private Object eduImg;
        private Object postCertificate;
        private Object trainMaterial;
        private Object caseDesc;
        private Object supMaterial;
        private Object teamTutorProve;
        private Object relatedThesis;
        private Object relatedThesisMaterial;
        private Object account;
        private Object csType;
        private Object csLevel;
        private int phone;
        private int meet;
        private Object starLevel;
        private Object mostSkilled;
        private Object auditState;
        private Object reason;
        private Object serial;
        private Object detail;
        private Object token;
        private Object isGuild;
        private Object cancelNum;
        private Object cancelTime;
        private Object only;
        private Object modifynum;
        private Object modifytime;
        private Object ioState;
        private Object recommendCode;
        private Object rank;
        private Object path;
        private Object workTime;
        private Object therapy;
        private Object diploma;
        private Object educationBackground;
        private Object trainingExperience;
        private Object workExprience;
        private Object aptitude;
        private Object jg;
        private boolean pwd;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Object getMobile() {
            return mobile;
        }

        public void setMobile(Object mobile) {
            this.mobile = mobile;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
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

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public Object getSex() {
            return sex;
        }

        public void setSex(Object sex) {
            this.sex = sex;
        }

        public Object getBirth() {
            return birth;
        }

        public void setBirth(Object birth) {
            this.birth = birth;
        }

        public Object getBalance() {
            return balance;
        }

        public void setBalance(Object balance) {
            this.balance = balance;
        }

        public Object getLabels() {
            return labels;
        }

        public void setLabels(Object labels) {
            this.labels = labels;
        }

        public Object getState() {
            return state;
        }

        public void setState(Object state) {
            this.state = state;
        }

        public Object getCreator() {
            return creator;
        }

        public void setCreator(Object creator) {
            this.creator = creator;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
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

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public Object getPositive() {
            return positive;
        }

        public void setPositive(Object positive) {
            this.positive = positive;
        }

        public Object getNegative() {
            return negative;
        }

        public void setNegative(Object negative) {
            this.negative = negative;
        }

        public Object getDegree() {
            return degree;
        }

        public void setDegree(Object degree) {
            this.degree = degree;
        }

        public Object getPersonalDesc() {
            return personalDesc;
        }

        public void setPersonalDesc(Object personalDesc) {
            this.personalDesc = personalDesc;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public Object getEduImg() {
            return eduImg;
        }

        public void setEduImg(Object eduImg) {
            this.eduImg = eduImg;
        }

        public Object getPostCertificate() {
            return postCertificate;
        }

        public void setPostCertificate(Object postCertificate) {
            this.postCertificate = postCertificate;
        }

        public Object getTrainMaterial() {
            return trainMaterial;
        }

        public void setTrainMaterial(Object trainMaterial) {
            this.trainMaterial = trainMaterial;
        }

        public Object getCaseDesc() {
            return caseDesc;
        }

        public void setCaseDesc(Object caseDesc) {
            this.caseDesc = caseDesc;
        }

        public Object getSupMaterial() {
            return supMaterial;
        }

        public void setSupMaterial(Object supMaterial) {
            this.supMaterial = supMaterial;
        }

        public Object getTeamTutorProve() {
            return teamTutorProve;
        }

        public void setTeamTutorProve(Object teamTutorProve) {
            this.teamTutorProve = teamTutorProve;
        }

        public Object getRelatedThesis() {
            return relatedThesis;
        }

        public void setRelatedThesis(Object relatedThesis) {
            this.relatedThesis = relatedThesis;
        }

        public Object getRelatedThesisMaterial() {
            return relatedThesisMaterial;
        }

        public void setRelatedThesisMaterial(Object relatedThesisMaterial) {
            this.relatedThesisMaterial = relatedThesisMaterial;
        }

        public Object getAccount() {
            return account;
        }

        public void setAccount(Object account) {
            this.account = account;
        }

        public Object getCsType() {
            return csType;
        }

        public void setCsType(Object csType) {
            this.csType = csType;
        }

        public Object getCsLevel() {
            return csLevel;
        }

        public void setCsLevel(Object csLevel) {
            this.csLevel = csLevel;
        }

        public int getPhone() {
            return phone;
        }

        public void setPhone(int phone) {
            this.phone = phone;
        }

        public int getMeet() {
            return meet;
        }

        public void setMeet(int meet) {
            this.meet = meet;
        }

        public Object getStarLevel() {
            return starLevel;
        }

        public void setStarLevel(Object starLevel) {
            this.starLevel = starLevel;
        }

        public Object getMostSkilled() {
            return mostSkilled;
        }

        public void setMostSkilled(Object mostSkilled) {
            this.mostSkilled = mostSkilled;
        }

        public Object getAuditState() {
            return auditState;
        }

        public void setAuditState(Object auditState) {
            this.auditState = auditState;
        }

        public Object getReason() {
            return reason;
        }

        public void setReason(Object reason) {
            this.reason = reason;
        }

        public Object getSerial() {
            return serial;
        }

        public void setSerial(Object serial) {
            this.serial = serial;
        }

        public Object getDetail() {
            return detail;
        }

        public void setDetail(Object detail) {
            this.detail = detail;
        }

        public Object getToken() {
            return token;
        }

        public void setToken(Object token) {
            this.token = token;
        }

        public Object getIsGuild() {
            return isGuild;
        }

        public void setIsGuild(Object isGuild) {
            this.isGuild = isGuild;
        }

        public Object getCancelNum() {
            return cancelNum;
        }

        public void setCancelNum(Object cancelNum) {
            this.cancelNum = cancelNum;
        }

        public Object getCancelTime() {
            return cancelTime;
        }

        public void setCancelTime(Object cancelTime) {
            this.cancelTime = cancelTime;
        }

        public Object getOnly() {
            return only;
        }

        public void setOnly(Object only) {
            this.only = only;
        }

        public Object getModifynum() {
            return modifynum;
        }

        public void setModifynum(Object modifynum) {
            this.modifynum = modifynum;
        }

        public Object getModifytime() {
            return modifytime;
        }

        public void setModifytime(Object modifytime) {
            this.modifytime = modifytime;
        }

        public Object getIoState() {
            return ioState;
        }

        public void setIoState(Object ioState) {
            this.ioState = ioState;
        }

        public Object getRecommendCode() {
            return recommendCode;
        }

        public void setRecommendCode(Object recommendCode) {
            this.recommendCode = recommendCode;
        }

        public Object getRank() {
            return rank;
        }

        public void setRank(Object rank) {
            this.rank = rank;
        }

        public Object getPath() {
            return path;
        }

        public void setPath(Object path) {
            this.path = path;
        }

        public Object getWorkTime() {
            return workTime;
        }

        public void setWorkTime(Object workTime) {
            this.workTime = workTime;
        }

        public Object getTherapy() {
            return therapy;
        }

        public void setTherapy(Object therapy) {
            this.therapy = therapy;
        }

        public Object getDiploma() {
            return diploma;
        }

        public void setDiploma(Object diploma) {
            this.diploma = diploma;
        }

        public Object getEducationBackground() {
            return educationBackground;
        }

        public void setEducationBackground(Object educationBackground) {
            this.educationBackground = educationBackground;
        }

        public Object getTrainingExperience() {
            return trainingExperience;
        }

        public void setTrainingExperience(Object trainingExperience) {
            this.trainingExperience = trainingExperience;
        }

        public Object getWorkExprience() {
            return workExprience;
        }

        public void setWorkExprience(Object workExprience) {
            this.workExprience = workExprience;
        }

        public Object getAptitude() {
            return aptitude;
        }

        public void setAptitude(Object aptitude) {
            this.aptitude = aptitude;
        }

        public Object getJg() {
            return jg;
        }

        public void setJg(Object jg) {
            this.jg = jg;
        }

        public boolean isPwd() {
            return pwd;
        }

        public void setPwd(boolean pwd) {
            this.pwd = pwd;
        }
    }
}
