package com.psychological.cxks.ui.activity;

import com.psychological.cxks.R;

public class EMySchedulerActivity extends BaseActivity {

    @Override
    public int setLayoutId() {
        return R.layout.activity_e_my_scheduler;
    }

    @Override
    public void findView() {
        findViewById(R.id.back).setOnClickListener(v -> finish());
    }

    @Override
    public void initListener() {

    }
}
