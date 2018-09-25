package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.psychological.cxks.App;
import com.psychological.cxks.R;

import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.util.SPUtil;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.model.UserInfo;
import cn.jpush.im.api.BasicCallback;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";
    private TabLayout tabs;
    private TextView reg;
    private TextView login;
    private EditText phone;
    private EditText pwd;
    private EditText code;
    private TextView send;
    private LinearLayout layoutCode;
    private ConstraintLayout layoutPwd;
    private TextView forgetPwd;
    private TextView hint;

    private static int loginMode = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutPwd.setVisibility(View.GONE);
        forgetPwd.setVisibility(View.GONE);

    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void findView() {
        tabs = findViewById(R.id.tabs);
        reg = findViewById(R.id.reg);
        login = findViewById(R.id.login);
        phone = findViewById(R.id.et_phone);
        pwd = findViewById(R.id.et_pwd);
        code = findViewById(R.id.et_code);
        send = findViewById(R.id.send);

        layoutCode = findViewById(R.id.layout_code);
        layoutPwd = findViewById(R.id.layout_pwd);

        forgetPwd = findViewById(R.id.tv_forget_pwd);
        hint = findViewById(R.id.tv_hint);
        SpannableString hintStr = new SpannableString("温馨提示:未注册过从心开始的手机号,登录时会自动注册从心开始账号,且代表您已同意<从心开始服务条款>");
        hintStr.setSpan(new ForegroundColorSpan(Color.parseColor("#47bb44")), 41, 49, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        hint.setText(hintStr);

        tabs.addTab(tabs.newTab().setText("手机登录"));
        tabs.addTab(tabs.newTab().setText("密码登录"));

    }

    @Override
    public void initListener() {
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        layoutPwd.setVisibility(View.GONE);
                        layoutCode.setVisibility(View.VISIBLE);
                        forgetPwd.setVisibility(View.GONE);
                        hint.setVisibility(View.VISIBLE);
                        loginMode = 0;
                        break;
                    case 1:
                        layoutPwd.setVisibility(View.VISIBLE);
                        layoutCode.setVisibility(View.GONE);
                        forgetPwd.setVisibility(View.VISIBLE);
                        hint.setVisibility(View.GONE);
                        loginMode = 1;
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        send.setOnClickListener((v) -> {
            if (TextUtils.isEmpty(code.getText())) {
                Toast.makeText(this, "电话不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            ApiWrapper.getInstance().send(code.getText().toString()).subscribe(c -> {

                    },
                    err -> {

                    });
        });

        forgetPwd.setOnClickListener((v) -> {
            // startActivity(new Intent(this,ForgetPwdActivity.class));
        });

        reg.setOnClickListener((v) -> {
            startActivity(new Intent(LoginActivity.this, RegistActivity.class));
        });


        login.setOnClickListener((v) -> {
            switch (loginMode) {
                case 0:
                    if (TextUtils.isEmpty(phone.getText())) {
                        Toast.makeText(LoginActivity.this, "电话不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (TextUtils.isEmpty(code.getText())) {
                        Toast.makeText(LoginActivity.this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    ApiWrapper.getInstance().rgsAndLog(phone.getText().toString(), code.getText().toString()).subscribe(
                            ret -> {
                                App.info = ret;
                                SPUtil.saveString(LoginActivity.this, "token", ret.getToken());
                                SPUtil.saveInt(LoginActivity.this, "type", ret.getType());
                                SPUtil.saveString(LoginActivity.this, "mobil", ret.getMobil());
                                SPUtil.saveString(LoginActivity.this, "name", ret.getUsername());
                                SPUtil.saveString(LoginActivity.this, "userId", ret.getUserId());
                                SPUtil.saveString(LoginActivity.this, "img", ret.getImg());
                                // TODO 极光信息时候需要存储?
                                SPUtil.saveInt(LoginActivity.this, "jg_id", ret.getJiguang().getId());
                                SPUtil.saveString(LoginActivity.this, "jg_nickname", ret.getJiguang().getNickname());
                                SPUtil.saveString(LoginActivity.this, "jg_password", ret.getJiguang().getPassword());
                                SPUtil.saveString(LoginActivity.this, "jg_username", ret.getJiguang().getUsername());
                                JMessageClient.login(ret.getJiguang().getUsername(), ret.getJiguang().getPassword(), new BasicCallback() {
                                    @Override
                                    public void gotResult(int responseCode, String responseMessage) {
                                        if (responseCode == 0) {
                                            Log.e(TAG, "登录极光成功");
                                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                            finish();
                                        } else {
                                            Log.e(TAG, "登录极光失败");
                                        }
                                    }
                                });

                            },
                            err -> {

                            });
                    break;

                case 1:
                    ApiWrapper.getInstance().login(TextUtils.isEmpty(phone.getText()) ? "15550029982" : phone.getText().toString(),
                            TextUtils.isEmpty(pwd.getText()) ? "123456" : pwd.getText().toString()).subscribe(
                            ret -> {
                                App.info = ret;
                                SPUtil.saveString(LoginActivity.this, "token", ret.getToken());
                                SPUtil.saveInt(LoginActivity.this, "type", ret.getType());
                                SPUtil.saveString(LoginActivity.this, "mobil", ret.getMobil());
                                SPUtil.saveString(LoginActivity.this, "name", ret.getUsername());
                                SPUtil.saveString(LoginActivity.this, "userId", ret.getUserId());
                                SPUtil.saveString(LoginActivity.this, "img", ret.getImg());
                                // TODO 极光信息时候需要存储?
                                SPUtil.saveInt(LoginActivity.this, "jg_id", ret.getJiguang().getId());
                                SPUtil.saveString(LoginActivity.this, "jg_nickname", ret.getJiguang().getNickname());
                                SPUtil.saveString(LoginActivity.this, "jg_password", ret.getJiguang().getPassword());
                                SPUtil.saveString(LoginActivity.this, "jg_username", ret.getJiguang().getUsername());
                                JMessageClient.login(ret.getJiguang().getUsername(), ret.getJiguang().getPassword(), new BasicCallback() {
                                    @Override
                                    public void gotResult(int responseCode, String responseMessage) {
                                        if (responseCode == 0) {
                                            Log.e(TAG, "登录极光成功");
                                            startActivity(new Intent(LoginActivity.this, ret.getType() == 1 ? MainActivity.class : EMainActivity.class));
                                            finish();
                                        } else {
                                            Log.e(TAG, "登录极光失败");
                                        }
                                    }
                                });


                            },
                            err -> {

                            });
                    break;
            }

        });
    }
}
