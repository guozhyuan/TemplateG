package com.psychological.cxks.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static void shortMsg(Context ctx, String msg) {
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
    }
}
