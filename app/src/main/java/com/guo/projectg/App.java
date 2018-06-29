package com.guo.projectg;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.guo.projectg.dao.DBManager;
import com.guo.projectg.http.HttpX;

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
