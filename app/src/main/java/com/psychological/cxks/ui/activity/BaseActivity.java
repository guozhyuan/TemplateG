package com.psychological.cxks.ui.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.psychological.cxks.R;

import com.psychological.cxks.util.BarUtil;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.event.LoginStateChangeEvent;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Author : jugg
 * Date   : 2018/6/21
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseActivity {

    public CompositeDisposable compositeDisposable;
    public LinearLayout statusbarCover;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        compositeDisposable = new CompositeDisposable();
        // Content出现在StatusBar后面<透明>
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) return;
//        getWindow().getDecorView().setFitsSystemWindows(true);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        } else {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }

        setContentView(setLayoutId());
        JMessageClient.registerEventReceiver(this);
        findView();
        initListener();
//        setStatusbarCover();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
        JMessageClient.unRegisterEventReceiver(this);
    }

    public void onEventMainThread(LoginStateChangeEvent event) {
        Log.e("BaseActivity", "LoginStateChangeEvent changed ");
    }

    /**
     * 设置StatusBar背后的View,可重写以修改默认颜色&高度
     */
    public void setStatusbarCover() {
        statusbarCover = findViewById(R.id.statusbar_cover);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, BarUtil.getStatusBarHeight(this));
        statusbarCover.setLayoutParams(params);
//        BarUtil.setStatusBarCoverColor(statusbarCover, 0xff213444);
    }

}
