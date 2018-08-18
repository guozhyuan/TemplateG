package com.psychological.cxks.util;

import android.text.TextUtils;

public enum CSTypeEnum {
    PHONE("电询", 1), MEET("面询", 2),

    BOTH("电询、面询", 3), TEXT("文字咨询", 4);
    private String name;
    private int index;

    // 构造方法
    private CSTypeEnum(String name, int index) {
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
        for (CSTypeEnum c : CSTypeEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public static int getIndex(String name) {
        for (CSTypeEnum c : CSTypeEnum.values()) {
            if (TextUtils.equals(c.getName(), name)) {
                return c.index;
            }
        }
        return 0;
    }

}
