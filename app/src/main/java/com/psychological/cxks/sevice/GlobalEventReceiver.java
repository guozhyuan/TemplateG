package com.psychological.cxks.sevice;

import android.content.Context;
import android.content.Intent;

import com.psychological.cxks.ui.activity.LoginActivity;
import com.psychological.cxks.util.ToastUtil;

import cn.jpush.im.android.eventbus.EventBus;


public class GlobalEventReceiver {

    private Context ctx;

    public GlobalEventReceiver(Context ctx) {
        this.ctx = ctx;
        EventBus.getDefault().register(this);
    }

    public void onEvent(HttpExceptionEvent event) {
        switch (event.code) {
            case 300:
            case 500:
            case 1001:
            case 1002:
            case 1003:
            case 1004:
            case 1005:
            case 1006:
            case 1007:
            case 1008:
                break;
            case 501:
            case 502:
                Intent intent = new Intent(ctx, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                ctx.startActivity(intent);
                break;
            case 503:
            case 504:
            case 505:
            case 506:
                break;
        }

        ToastUtil.shortMsg(ctx, event.msg);

    }
}
