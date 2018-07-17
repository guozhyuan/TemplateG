package com.guo.projectg.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.guo.projectg.R;

public class ECustomerDetailActivity extends BaseActivity {

    private ImageView back;
    private ImageView head;
    private ImageView gender;
    private TextView nick;
    private TextView addr;
    private TextView msg;
    private ConstraintLayout histroy;
    private ConstraintLayout info;
    private ConstraintLayout report;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_e_customer_detail;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        head = findViewById(R.id.head);
        gender = findViewById(R.id.gender);
        nick = findViewById(R.id.nick);
        msg = findViewById(R.id.msg);
        histroy = findViewById(R.id.history);
        info = findViewById(R.id.visitor_info);
        report = findViewById(R.id.report);
    }

    @Override
    public void initListener() {
        back.setOnClickListener((v) -> {
            finish();
        });
        msg.setOnClickListener((v) -> {
        });
        histroy.setOnClickListener((v) -> {

        });
        info.setOnClickListener((v) -> {
            Intent intent = new Intent(this, VisitorInfoActivity.class);
            startActivity(intent);
        });
        report.setOnClickListener((v) -> {
        });
    }
}
