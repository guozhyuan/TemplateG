package com.psychological.cxks.bean.param;

/**
 * Created by cqc on 2018/8/5.
 * 主页设置
 */

public class UserInfoParam {
    /**
     token	√	string	100	用户登录成功时返回的token
     realName		string	16	姓名/昵称
     sex		int		性别
     img		string	200	本人头像
     rank		string	200	头衔
     workTime		int		从业时长
     labels		string	64	擅长领域，多个用逗号分隔
     addr		string	100	所在地
     therapy		string	500	擅长疗法
     diploma		string	500	资质证书
     educationBackground		string	500	教育背景
     trainingExperience		string	500	培训经历
     workExprience		string	500	从业经历
     aptitude		string	500	资质介绍
     detail		string		个人介绍
     */
    private String token;
    private String realName;
    private int sex;
//    private String img;
    private String rank;
    private String workTime;
    private String labels;
    private String addr;
    private String therapy;
    private String diploma;
    private String educationBackground;
    private String trainingExperience;
    private String workExprience;
    private String aptitude;
    private String detail;

}
