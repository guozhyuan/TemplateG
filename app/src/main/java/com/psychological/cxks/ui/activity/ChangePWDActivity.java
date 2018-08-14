package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.http.ApiWrapper;

import io.reactivex.disposables.Disposable;

public class ChangePWDActivity extends BaseActivity implements View.OnClickListener {


    private TextView phone;
    private TextView submit;
    private TextView resend;
    private EditText verifyCode;
    private EditText newPwd;
    private EditText confirmPwd;
    private ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (App.info == null) {
            startActivity(new Intent(ChangePWDActivity.this, LoginActivity.class));
            return;
        }
        phone.setText(App.info.getMobil());
        Disposable disposable = ApiWrapper.getInstance().send(App.info.getMobil()).subscribe(c -> {
        }, err -> {

        });
        compositeDisposable.add(disposable);

    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_change_pwd;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        phone = findViewById(R.id.phone);
        submit = findViewById(R.id.tv_submit);
        resend = findViewById(R.id.tv_resend);

        verifyCode = findViewById(R.id.et_verify_code);
        newPwd = findViewById(R.id.et_new_pwd);
        confirmPwd = findViewById(R.id.et_confirm_pwd);


    }

    @Override
    public void initListener() {
        submit.setOnClickListener(this);
        resend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_submit:
                if (TextUtils.isEmpty(verifyCode.getText().toString())) {
                    Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(newPwd.getText().toString())) {
                    Toast.makeText(this, "新密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmPwd.getText().toString())) {
                    Toast.makeText(this, "重复密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!TextUtils.equals(newPwd.getText().toString(), confirmPwd.getText().toString())) {
                    Toast.makeText(this, "密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }
                ApiWrapper.getInstance().reset(App.info.getMobil(), verifyCode.getText().toString(), newPwd.getText().toString()).subscribe(ret -> {
                    Toast.makeText(this, "密码重置成功", Toast.LENGTH_SHORT).show();
                    finish();
                }, err -> {

                });
                break;
            case R.id.tv_resend:
                if (App.info == null) {
                    startActivity(new Intent(ChangePWDActivity.this, LoginActivity.class));
                    return;
                }
                ApiWrapper.getInstance().send(App.info.getMobil()).subscribe(c -> {
                    Toast.makeText(this, "验证码已发送", Toast.LENGTH_SHORT).show();
                }, err -> {

                });


                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
