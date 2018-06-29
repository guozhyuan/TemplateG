package com.guo.projectg.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;

/**
 * Author : jugg
 * Date   : 2018/6/27
 */
public class BarUtil {

    public static int getStatusBarHeight(Context ctx) {
        Resources resources = ctx.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }

    public static int getNavBarHeight(Context ctx) {
        Resources res = ctx.getResources();
        int resourceId = res.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId != 0) {
            return res.getDimensionPixelSize(resourceId);
        } else {
            return 0;
        }
    }

    public static void addMarginTopEqualStatusBarHeight(Context ctx, @NonNull View view) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) return;
        MarginLayoutParams layoutParams = (MarginLayoutParams) view.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin,
                layoutParams.topMargin + getStatusBarHeight(ctx),
                layoutParams.rightMargin,
                layoutParams.bottomMargin);
    }

    public static void setStatusBarCoverColor(View view, int color) {
        view.setBackgroundColor(color);
    }

    public static void hindStatusBar(AppCompatActivity activity) {
        // 隐藏StatusBar,屏幕发生变化的时候,需要重新设置
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
    }

}
