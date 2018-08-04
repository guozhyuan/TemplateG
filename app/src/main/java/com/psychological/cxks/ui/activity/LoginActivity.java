package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.psychological.cxks.App;
import com.psychological.cxks.R;

import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.util.SPUtil;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";
    private String msgCode;

    @Override
    public int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void findView() {
        Button user = findViewById(R.id.user);
        Button expert = findViewById(R.id.expert);
        Button reg = findViewById(R.id.reg);
        Button code = findViewById(R.id.code);
        Button login = findViewById(R.id.login);
        user.setOnClickListener((v) -> {
//            startActivity(new Intent(LoginActivity.this,));
        });
        expert.setOnClickListener((v) -> {

        });

        reg.setOnClickListener((v) -> {
            ApiWrapper.getInstance().rgsAndLog("15550029982", "2150").subscribe(ret -> {
                App.Instance().info = ret;
                SPUtil.saveString(LoginActivity.this, "token", ret.getToken());
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            });
        });

        code.setOnClickListener((v) -> {
            ApiWrapper.getInstance().send("15550029982").subscribe(c -> {
                Toast.makeText(this, "验证码已发送", Toast.LENGTH_SHORT).show();
            }, err -> {
                Toast.makeText(this, "验证码发送失败", Toast.LENGTH_SHORT).show();
            });
        });

        login.setOnClickListener((v) -> {
            ApiWrapper.getInstance().login("15550029982", "123456").subscribe(ret -> {
                App.Instance().info = ret;
                SPUtil.saveString(LoginActivity.this, "token", ret.getToken());
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            });
        });
    }

    @Override
    public void initListener() {

    }
}
