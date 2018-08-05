package com.psychological.cxks.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.psychological.cxks.http.ApiWrapper;

public class EMyInfoActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_e_my_info;
    }

    @Override
    public void findView() {
        TextView homePriview = findViewById(R.id.home_preview);
        TextView commitCheck = findViewById(R.id.commit_check);

        homePriview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        homePriview.setOnClickListener((v) -> {

        });
        commitCheck.setOnClickListener((v) ->{
        });
    }

    @Override
    public void initListener() {
    }
}
