package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.psychological.cxks.App;
import com.psychological.cxks.R;

import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.util.SPUtil;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void findView() {
        Button reg = findViewById(R.id.reg);
        Button login = findViewById(R.id.login);
        EditText phone = findViewById(R.id.et_phone);
        EditText pwd = findViewById(R.id.et_pwd);

        reg.setOnClickListener((v) -> {
            startActivity(new Intent(LoginActivity.this, RegistActivity.class));
            finish();
        });


        login.setOnClickListener((v) -> {
            ApiWrapper.getInstance().login(TextUtils.isEmpty(phone.getText()) ? "15550029982" : phone.getText().toString(),
                    TextUtils.isEmpty(pwd.getText()) ? "123456" : pwd.getText().toString()).subscribe(
                    ret -> {
                        App.info = ret;
                        SPUtil.saveString(LoginActivity.this, "token", ret.getToken());
                        SPUtil.saveInt(LoginActivity.this, "type", ret.getType());
                        SPUtil.saveString(LoginActivity.this, "mobil", ret.getMobil());
                        SPUtil.saveString(LoginActivity.this, "name", ret.getName());
                        SPUtil.saveString(LoginActivity.this, "userId", ret.getUserId());
                        // startActivity(new Intent(LoginActivity.this, EMainActivity.class));
                        startActivity(new Intent(LoginActivity.this, ret.getType() == 1 ? MainActivity.class : EMainActivity.class));
                        finish();
                    },
                    err -> {

                    });

        });
    }

    @Override
    public void initListener() {

    }
}
