package com.psychological.cxks;

import android.support.multidex.MultiDexApplication;

import com.psychological.cxks.dao.DBManager;
import com.psychological.cxks.http.HttpX;

/**
 * Author : jugg
 * Date   : 2018/6/25
 */
public class App extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpX.Instance().init();
        DBManager.getInstance().init(this);
    }
}
