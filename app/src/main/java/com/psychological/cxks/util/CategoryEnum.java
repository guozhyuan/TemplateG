package com.psychological.cxks.util;

import android.text.TextUtils;

public enum CategoryEnum {
//1	恋爱婚姻
//2	家庭关系
//3	亲子教育
//4	情绪压力
//5	人际关系
//6	职业发展
//7	性心理

    LOVE("恋爱婚姻", 1), FAMILY("家庭关系", 2), EDU("亲子教育", 3), EMOTION("情绪压力", 4), RELATIONSHIP("人际关系", 5), JOB("职业发展", 6), SEX("性心理", 7);
    private String name;
    private int index;

    // 构造方法
    private CategoryEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (CategoryEnum c : CategoryEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public static int getIndex(String name) {
        for (CategoryEnum c : CategoryEnum.values()) {
            if (TextUtils.equals(c.getName(), name)) {
                return c.index;
            }
        }
        return 0;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
