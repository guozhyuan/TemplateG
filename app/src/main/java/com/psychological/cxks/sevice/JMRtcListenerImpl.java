package com.psychological.cxks.sevice;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.SurfaceView;

import com.psychological.cxks.Constant;
import com.psychological.cxks.ui.activity.RtcActivity;

import java.util.List;

import cn.jiguang.jmrtc.api.JMRtcClient;
import cn.jiguang.jmrtc.api.JMRtcListener;
import cn.jiguang.jmrtc.api.JMRtcSession;
import cn.jpush.im.android.api.callback.RequestCallback;
import cn.jpush.im.android.api.model.UserInfo;
import cn.jpush.im.android.eventbus.EventBus;

public class JMRtcListenerImpl extends JMRtcListener {
    private final String TAG = "JMRtcListenerImpl";
    private Context ctx;

    public JMRtcListenerImpl(Context ctx) {
        super();
        this.ctx = ctx;
    }

    @Override
    public void onEngineInitComplete(int i, String s) {
        super.onEngineInitComplete(i, s);
        // 初始化完成
        Log.e(TAG, "onEngineInitComplete");
        Log.e(TAG, s);
        Log.e(TAG, "" + i);

    }

    @Override
    public void onCallOutgoing(JMRtcSession jmRtcSession) {
        super.onCallOutgoing(jmRtcSession);
        // 发起语音
        Log.e(TAG, "onCallOutgoing");
        Intent intent = new Intent(ctx, RtcActivity.class);
//        intent.putExtra(Constant.RTC_TYPE, Constant.RTC_TYPE_SEND);
        ctx.startActivity(intent);
    }

    @Override
    public void onCallInviteReceived(JMRtcSession jmRtcSession) {
        super.onCallInviteReceived(jmRtcSession);
        // 收到语音邀请
        Log.e(TAG, "onCallInviteReceived");
        Intent intent = new Intent(ctx, RtcActivity.class);
//        intent.putExtra(Constant.RTC_TYPE, Constant.RTC_TYPE_RECV);
        ctx.startActivity(intent);
    }

    @Override
    public void onCallConnected(JMRtcSession jmRtcSession, SurfaceView surfaceView) {
        super.onCallConnected(jmRtcSession, surfaceView);
        // 建立语音连接
        Log.e(TAG, "onCallMemberJoin");
        EventBus.getDefault().post(new CallConnEvent());
    }

    @Override
    public void onCallDisconnected(JMRtcClient.DisconnectReason disconnectReason) {
        super.onCallDisconnected(disconnectReason);
        // 断开语音连接
        Log.e(TAG, "onCallDisconnected");
        EventBus.getDefault().post(new CallDisconnEvent());
    }

    @Override
    public void onCallOtherUserInvited(UserInfo userInfo, List<UserInfo> list, JMRtcSession jmRtcSession) {
        super.onCallOtherUserInvited(userInfo, list, jmRtcSession);
        Log.e(TAG, "onCallOtherUserInvited");
    }

    @Override
    public void onCallMemberJoin(UserInfo userInfo, SurfaceView surfaceView) {
        super.onCallMemberJoin(userInfo, surfaceView);
        Log.e(TAG, "onCallMemberJoin");
    }

    @Override
    public void onCallMemberOffline(UserInfo userInfo, JMRtcClient.DisconnectReason disconnectReason) {
        super.onCallMemberOffline(userInfo, disconnectReason);
        Log.e(TAG, "onCallMemberOffline");
    }

    @Override
    public void onCallError(int i, String s) {
        super.onCallError(i, s);
        Log.e(TAG, "onCallError" + i + s);
    }

    @Override
    public void onPermissionNotGranted(String[] strings) {
        super.onPermissionNotGranted(strings);
        Log.e(TAG, "onPermissionNotGranted");

    }

    @Override
    public void onRemoteVideoMuted(UserInfo userInfo, boolean b) {
        super.onRemoteVideoMuted(userInfo, b);
    }
}
