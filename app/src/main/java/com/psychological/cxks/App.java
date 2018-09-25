package com.psychological.cxks;

import android.support.multidex.MultiDexApplication;
import android.view.SurfaceView;

import com.psychological.cxks.bean.UserInfoBean;
import com.psychological.cxks.dao.DBManager;
import com.psychological.cxks.http.HttpX;
import com.psychological.cxks.sevice.JMRtcListenerImpl;
import com.psychological.cxks.wxapi.WXSDKHelper;

import java.util.List;

import cn.jiguang.jmrtc.api.JMRtcClient;
import cn.jiguang.jmrtc.api.JMRtcListener;
import cn.jiguang.jmrtc.api.JMRtcSession;
import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.model.UserInfo;

/**
 * Author : jugg
 * Date   : 2018/6/25
 */
public class App extends MultiDexApplication {
    private static App instance;
    public static UserInfoBean info;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        HttpX.Instance().init();
        DBManager.getInstance().init(this);
        WXSDKHelper.getInstance().init(this);
        JMessageClient.init(this, true);
        JMessageClient.setDebugMode(true);
        JMessageClient.setNotificationFlag(JMessageClient.FLAG_NOTIFY_DISABLE);
        JMRtcClient.getInstance().initEngine(new JMRtcListenerImpl(this));
    }

}
