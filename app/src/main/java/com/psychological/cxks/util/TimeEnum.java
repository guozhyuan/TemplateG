package com.psychological.cxks.util;

public enum TimeEnum {
//            1	9:00-10:00
//            2	10:00-11:00
//            3	11:00-12:00
//            4	12:00-13:00
//            5	13:00-14:00
//            6	14:00-15:00
//            7	15:00-16:00
//            8	16:00-17:00
//            9	17:00-18:00
//            10	18:00-19:00
//            11	19:00-20:00
//            12	20:00-21:00
//            13	21:00-22:00

    ONE("9:00-10:00", 1), TWO("10:00-11:00", 2), THREE("11:00-12:00", 3), FOUR("12:00-13:00", 4), FIVE("13:00-14:00", 5), SIX("14:00-15:00", 6), SEVEN("15:00-16:00", 7),
    EIGHT("16:00-17:00", 8), NIGHT("17:00-18:00", 9), TEN("18:00-19:00", 10), ELEVEN("19:00-20:00", 11), TWELVE("20:00-21:00", 12), THIRTEEEN("21:00-22:00", 13);
    private int index;
    private String name;


    // 构造方法
    private TimeEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (TimeEnum c : TimeEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public static int getIndex(String name) {
        for (TimeEnum c : TimeEnum.values()) {
            if (c.getName() == name) {
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
