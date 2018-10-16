package com.psychological.cxks.util;

import android.text.TextUtils;

public enum OrderStateEnum {
    // 订单状态，-1:已下单；0：已付款；1：已取消；2：已确定接单；3：咨询结束；4：已评价

    OTHER("已下单", -1), ZERO("已付款", 0), ONE("已取消", 1), TWO("已确定接单", 2), THREE("咨询结束", 3), FOUR("已评价", 4);
    private String name;
    private int index;

    // 构造方法
    private OrderStateEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (OrderStateEnum c : OrderStateEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public static int getIndex(String name) {
        for (OrderStateEnum c : OrderStateEnum.values()) {
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
