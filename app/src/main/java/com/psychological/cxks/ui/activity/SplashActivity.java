package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.UserInfoBean;
import com.psychological.cxks.util.SPUtil;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.api.BasicCallback;

public class SplashActivity extends BaseActivity {
    private String TAG = "SplashActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String token = SPUtil.getString(this, "token");
        int type = SPUtil.getInt(this, "type");
        String mobil = SPUtil.getString(this, "mobil");
        String name = SPUtil.getString(this, "name");
        String userId = SPUtil.getString(this, "userId");
        String img = SPUtil.getString(this, "userId");

        int jg_id = SPUtil.getInt(this, "jg_id");
        String jg_nickname = SPUtil.getString(this, "jg_nickname");
        String jg_password = SPUtil.getString(this, "jg_password");
        String jg_username = SPUtil.getString(this, "jg_username");

        if (App.info != null) {
            startActivity(new Intent(this, type == 1 ? MainActivity.class : EMainActivity.class));
        } else {
            if (!TextUtils.isEmpty(token)) {
                UserInfoBean userInfo = new UserInfoBean();
                userInfo.setToken(token);
                userInfo.setType(type);
                userInfo.setMobil(mobil);
                userInfo.setUsername(name);
                userInfo.setUserId(userId);
                userInfo.setImg(img);
                UserInfoBean.JiguangBean jiguangBean = new UserInfoBean.JiguangBean();
                jiguangBean.setId(jg_id);
                jiguangBean.setNickname(jg_nickname);
                jiguangBean.setPassword(jg_password);
                jiguangBean.setUsername(jg_username);
                userInfo.setJiguang(jiguangBean);
                App.info = userInfo;
                JMessageClient.login(jg_username, jg_password, new BasicCallback() {
                    @Override
                    public void gotResult(int responseCode, String responseMessage) {
                        if (responseCode == 0) {
                            Log.e(TAG, "登录极光成功");
                            startActivity(new Intent(SplashActivity.this, type == 1 ? MainActivity.class : EMainActivity.class));
                        } else {
                            Log.e(TAG, "登录极光失败");
                        }
                    }
                });

            } else {
                startActivity(new Intent(this, LoginActivity.class));
            }
        }
        finish();
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
