package com.psychological.cxks;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.psychological.cxks.bean.MyCouponCodeBean;
import com.psychological.cxks.bean.MyCouponPackgeBean;
import com.psychological.cxks.util.TimeConstants;
import com.psychological.cxks.util.TimeUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class Test {
    public static void main(String[] args) throws ParseException {
//        testParseInt();
        testDate();
    }

    public static void getNow() {
        System.out.println(new Date().getTime() + 86400000 * 365);
    }

    public static JsonObject assembleArray() {
        MyCouponCodeBean codeBean = new MyCouponCodeBean();
        codeBean.setChecked(false);
        codeBean.setCoupon("1231");
        codeBean.setCouponState(1);
        codeBean.setId(111);
        codeBean.setOrderId("12313131");
        codeBean.setType(1);
        MyCouponPackgeBean packgeBean = new MyCouponPackgeBean();
        packgeBean.setChecked(false);
        packgeBean.setConsultId("13131");
        packgeBean.setContent("packge");
        packgeBean.setCoupon("packge12313");
        packgeBean.setCouponState(1);
        packgeBean.setId(12);
        packgeBean.setName("name");
        packgeBean.setObtainId("123141");
        packgeBean.setPackageId(12313);
        packgeBean.setUseId("fa3232r");
        packgeBean.setTime("24124141");
        packgeBean.setUseTime("fa322424242");

        String code = new Gson().toJson(codeBean);
        String packge = new Gson().toJson(packgeBean);
        JsonArray j1 = new JsonArray();
        JsonArray j2 = new JsonArray();
        j1.add(code);
        j1.add(code);
        j1.add(code);
        j1.add(code);
        j1.add(code);
        j1.add(code);
        j2.add(packge);
        j2.add(packge);
        j2.add(packge);
        j2.add(packge);
        j2.add(packge);
        j2.add(packge);
        JsonObject jo = new JsonObject();
        jo.add("cc", j1);
        jo.add("pc", j2);

//        System.out.println(j);
        return jo;
    }

    public static void testParseInt() {
        System.out.println(Double.parseDouble("1600.0"));
    }


    public static void testDate() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String str = "2018-08-18 15:10:23";

        long createTimeMills = TimeUtils.getMillis(str, format, 365, TimeConstants.DAY);
        System.out.println(TimeUtils.millis2String(createTimeMills));
    }
}
