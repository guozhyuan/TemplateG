package com.psychological.cxks.ui.activity;

import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;

import com.psychological.cxks.R;

public class EIncomeActivity extends BaseActivity {
    @Override
    public int setLayoutId() {
        return R.layout.activity_e_income;
    }

    @Override
    public void findView() {
        ImageView back = findViewById(R.id.back);
        ConstraintLayout history = findViewById(R.id.history);
        ConstraintLayout desc = findViewById(R.id.desc);
        ConstraintLayout rule = findViewById(R.id.rule);
        ConstraintLayout setting = findViewById(R.id.setting);
    }

    @Override
    public void initListener() {

    }
}
