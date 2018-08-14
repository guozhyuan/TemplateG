package com.psychological.cxks;

import android.support.multidex.MultiDexApplication;

import com.psychological.cxks.bean.UserInfoBean;
import com.psychological.cxks.dao.DBManager;
import com.psychological.cxks.http.HttpX;
import com.psychological.cxks.wxapi.WXSDKHelper;

/**
 * Author : jugg
 * Date   : 2018/6/25
 */
public class App extends MultiDexApplication {
    private static App instance;
    public UserInfoBean info;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        HttpX.Instance().init();
        DBManager.getInstance().init(this);
        WXSDKHelper.getInstance().init(this);
    }

    public static App Instance() {
        return instance;
    }
}
