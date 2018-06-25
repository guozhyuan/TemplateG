package com.guo.projectg;

import android.app.Application;

import com.guo.projectg.dao.DBManager;
import com.guo.projectg.http.HttpX;

/**
 * Author : jugg
 * Date   : 2018/6/25
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpX.Instance().init();
        DBManager.getInstance().init(this);
    }
}
