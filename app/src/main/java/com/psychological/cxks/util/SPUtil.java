package com.psychological.cxks.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtil {
    private static final String SP_FILE_NAME = "config";

    /**
     * 将字符串储存到sp
     * @param context 上下文
     * @param key 键
     * @param values 值
     */
    public static void saveString(Context context, String key, String values) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(key,values).apply();
    }

    /**
     * 将布尔值储存到sp
     * @param context
     * @param key
     * @param values
     */
    public static void saveBoolean(Context context, String key, boolean values) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,values).apply();
    }

    /**
     * 保存long值到sp
     * @param context
     * @param key
     * @param values
     */
    public static void saveLong(Context context, String key, long values) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().putLong(key,values).apply();
    }

    /**
     * 保存int值到sp
     * @param context
     * @param key
     * @param values
     */
    public static void saveInt(Context context, String key, int values) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().putInt(key,values).apply();
    }

    /**
     * @param context
     * @param key
     * @return
     * @Description:从sp中获取boolean值,如果不存在,默认值是false
     */
    public static boolean getBoolean_False(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    /**
     * @param context
     * @param key
     * @return
     * @Description:从sp中获取boolean值,如果不存在,默认值是true
     */
    public static boolean getBoolean_True(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, true);
    }

    /**
     * @param context
     * @param key
     * @return
     * @Description:从sp中获取字符串,默认值是 ""空串
     */
    public static String getString(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, "");
    }

    public static Long getLong(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getLong(key,-1);
    }
    public static int getInt(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key,-1);
    }

    /**
     * 检查sp中是否储存了对应键
     * @param context
     * @param key
     * @return
     */
    public static boolean containsKey(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        return sp.contains(key);
    }


    /**
     * 清空SP
     * @param context
     */
    public static void clean(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().clear().commit();
    }
}
