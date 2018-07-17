package com.psychological.cxks.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.guo.projectg.R;

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
        phone.setOnClickListener(this);
        submit.setOnClickListener(this);
        resend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.phone:

                break;
            case R.id.tv_submit:

                break;
            case R.id.tv_resend:

                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
