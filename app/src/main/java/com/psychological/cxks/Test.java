package com.psychological.cxks;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s = "hello";
        ArrayList<String> tagList = new ArrayList<>(Arrays.asList(s.split("\\s+")));
        System.out.println(tagList);
    }
}
