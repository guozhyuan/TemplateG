package com.guo.projectg.ui.activity;

import android.util.Log;
import android.widget.Button;

import com.guo.projectg.R;
import com.guo.projectg.http.ApiWrapper;

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
        user.setOnClickListener((v) -> {
//            startActivity(new Intent(LoginActivity.this,));
        });
        expert.setOnClickListener((v) -> {

        });

        reg.setOnClickListener((v) -> {
            ApiWrapper.getInstance().rgsAndLog("15550029982", msgCode).subscribe((ret) -> {
                Log.e(TAG, "rgsAndLog: " + ret);
            });
        });

        code.setOnClickListener((v) -> {
            ApiWrapper.getInstance().send("15550029982").subscribe((c) -> {
                msgCode = c;
            });
        });
    }

    @Override
    public void initListener() {

    }
}
