package com.psychological.cxks.ui.activity;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.psychological.cxks.Constant;
import com.psychological.cxks.Manifest;
import com.psychological.cxks.R;
import com.psychological.cxks.sevice.CallConnEvent;
import com.psychological.cxks.sevice.CallDisconnEvent;


import cn.jiguang.jmrtc.api.JMRtcClient;
import cn.jiguang.jmrtc.api.JMRtcSession;
import cn.jpush.im.android.eventbus.EventBus;
import cn.jpush.im.android.eventbus.ThreadMode;
import cn.jpush.im.api.BasicCallback;

public class RtcActivity extends BaseActivity implements View.OnClickListener {
    private static final int REQUEST_RECORD = 0x1000;
    private TextView peer;
    private TextView time;
    private TextView tvAccpet;
    private TextView tvRefuse;
    private ImageView accept;
    private ImageView refuse;
    private ImageView calling;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{android.Manifest.permission.RECORD_AUDIO}, REQUEST_RECORD);
        }


        EventBus.getDefault().register(this);
//        int rtcType = getIntent().getIntExtra(Constant.RTC_TYPE, 1);
        JMRtcSession.SessionRole sessionRole = JMRtcClient.getInstance().getSession().getSessionRole();
        if (sessionRole == JMRtcSession.SessionRole.inviter) {
            // 发起者
            accept.setVisibility(View.INVISIBLE);
            tvAccpet.setVisibility(View.INVISIBLE);
            refuse.setVisibility(View.INVISIBLE);
            tvRefuse.setVisibility(View.INVISIBLE);
            time.setVisibility(View.VISIBLE);
            calling.setVisibility(View.VISIBLE);
            time.setText("正在接通");

        } else {
            // 接受者
            accept.setVisibility(View.VISIBLE);
            tvAccpet.setVisibility(View.VISIBLE);
            refuse.setVisibility(View.VISIBLE);
            tvRefuse.setVisibility(View.VISIBLE);
            time.setVisibility(View.INVISIBLE);
            calling.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_RECORD) {
            int grantResult = grantResults[0];
            if (grantResult == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "需要麦克风权限!", Toast.LENGTH_SHORT).show();
                JMRtcClient.getInstance().hangup(new BasicCallback() {
                    @Override
                    public void gotResult(int i, String s) {

                    }
                });
            }
        }
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_rtc;
    }

    @Override
    public void findView() {
        peer = findViewById(R.id.peer);
        time = findViewById(R.id.time);
        tvAccpet = findViewById(R.id.tv_accept);
        tvRefuse = findViewById(R.id.tv_refuse);
        accept = findViewById(R.id.accept);
        refuse = findViewById(R.id.refuse);
        calling = findViewById(R.id.calling);
    }

    @Override
    public void initListener() {
        accept.setOnClickListener(this);
        refuse.setOnClickListener(this);
        calling.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.accept:
                JMRtcClient.getInstance().accept(new BasicCallback() {
                    @Override
                    public void gotResult(int i, String s) {

                    }
                });
                break;

            case R.id.refuse:
                JMRtcClient.getInstance().refuse(new BasicCallback() {
                    @Override
                    public void gotResult(int i, String s) {

                    }
                });
                break;
            case R.id.calling:
                JMRtcClient.getInstance().hangup(new BasicCallback() {
                    @Override
                    public void gotResult(int i, String s) {

                    }
                });
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) { //监控/拦截/屏蔽返回键
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    public void onEvent(CallConnEvent event) {

    }

    public void onEvent(CallDisconnEvent event) {

    }

}
