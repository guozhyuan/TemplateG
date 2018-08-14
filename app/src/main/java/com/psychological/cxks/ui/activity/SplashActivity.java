package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.UserInfoBean;
import com.psychological.cxks.util.SPUtil;

public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String token = SPUtil.getString(this, "token");
        int type = SPUtil.getInt(this, "type");
        String mobil = SPUtil.getString(this, "mobil");
        String name = SPUtil.getString(this, "name");
        String userId = SPUtil.getString(this, "userId");
        if (App.info != null) {
            startActivity(new Intent(this, type == 1 ? MainActivity.class : EMainActivity.class));
        } else {
            if (!TextUtils.isEmpty(token)) {
                UserInfoBean userInfo = new UserInfoBean();
                userInfo.setToken(token);
                userInfo.setType(type);
                userInfo.setMobil(mobil);
                userInfo.setName(name);
                userInfo.setUserId(userId);
                App.info = userInfo;
                startActivity(new Intent(this, type == 1 ? MainActivity.class : EMainActivity.class));
            } else {
                startActivity(new Intent(this, RegistActivity.class));
            }
        }
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void findView() {

    }

    @Override
    public void initListener() {

    }
}
