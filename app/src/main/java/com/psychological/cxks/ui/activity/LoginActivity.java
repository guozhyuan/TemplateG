package com.psychological.cxks.ui.activity;

import android.util.Log;
import android.widget.Button;

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
            ApiWrapper.getInstance().rgsAndLog("15550029982", "5781").subscribe(ret -> {
                if (ret == null) {
                    Log.e(TAG, "rgsAndLog: ret = null");
                } else {
                    Log.e(TAG, "rgsAndLog: " + ret);
                    SPUtil.saveString(LoginActivity.this, "token", ret);
                }
            }, err -> {
                Log.e(TAG, "rgsAndLog: " + err.getMessage());
            });
        });

        code.setOnClickListener((v) -> {
            ApiWrapper.getInstance().send("15550029982").subscribe(c -> {
                Log.e(TAG, "send: " + c);
                msgCode = c;
            });
        });

        login.setOnClickListener((v) -> {
            ApiWrapper.getInstance().login("15550029982", "").subscribe(c -> {
                // ???
            });
        });
    }

    @Override
    public void initListener() {

    }
}
