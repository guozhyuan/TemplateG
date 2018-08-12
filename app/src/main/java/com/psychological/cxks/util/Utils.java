package com.psychological.cxks.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Author : jugg
 * Date   : 2018/6/29
 */
public class Utils {

    public static void handleErr(Context ctx, String msg) {
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
        //TODO 根据错误码跳转
    }

}
