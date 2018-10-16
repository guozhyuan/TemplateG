package com.psychological.cxks.sevice;

import android.content.Context;
import android.content.Intent;

import com.psychological.cxks.ui.activity.LoginActivity;

import cn.jpush.im.android.eventbus.EventBus;


public class GlobalEventReceiver {

    private Context ctx;

    public GlobalEventReceiver(Context ctx) {
        this.ctx = ctx;
        EventBus.getDefault().register(this);
    }

    public void onEvent(Http501Event event) {

        Intent intent = new Intent(ctx, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        ctx.startActivity(intent);
    }
}
