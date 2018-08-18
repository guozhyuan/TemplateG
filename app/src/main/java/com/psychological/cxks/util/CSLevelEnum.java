package com.psychological.cxks.util;

import android.text.TextUtils;

public enum CSLevelEnum {
    LEVEL_1("专家级别", 1), LEVEL_2("主任级", 2), LEVEL_3("副主任", 3), LEVEL_4("资深级", 4), LEVEL_5("高级", 5), LEVEL_6("普通级", 6), LEVEL_7("实习", 7);
    private String name;
    private int index;

    // 构造方法
    private CSLevelEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

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

    public static String getName(int index) {
        for (CSLevelEnum c : CSLevelEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public static int getIndex(String name) {
        for (CSLevelEnum c : CSLevelEnum.values()) {
            if (TextUtils.equals(c.getName(), name)) {
                return c.index;
            }
        }
        return 0;
    }

}
