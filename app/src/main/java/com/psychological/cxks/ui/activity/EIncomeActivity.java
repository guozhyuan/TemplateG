package com.psychological.cxks.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.http.ApiWrapper;

import io.reactivex.disposables.Disposable;

public class EIncomeActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back;
    private TextView money;
    private TextView extract;
    private TextView extractMoney;
    private ConstraintLayout history;
    private ConstraintLayout desc;
    private ConstraintLayout rule;
    private ConstraintLayout setting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Disposable d = ApiWrapper.getInstance().balanceQuery(App.info.getUserId()).subscribe(
//                ret -> {
//
//                }, err -> {
//
//                }
//        );
//        compositeDisposable.add(d);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_e_income;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        money = findViewById(R.id.money);
        extract = findViewById(R.id.extract);
        extractMoney = findViewById(R.id.extractMoney);

        history = findViewById(R.id.history);
        desc = findViewById(R.id.desc);
        rule = findViewById(R.id.rule);
        setting = findViewById(R.id.setting);
    }

    @Override
    public void initListener() {
        back.setOnClickListener(this);
        extract.setOnClickListener(this);
        history.setOnClickListener(this);
        desc.setOnClickListener(this);
        rule.setOnClickListener(this);
        setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;

            case R.id.extract:
                intent = new Intent(this, EExtractMoneyActivity.class);
                startActivity(intent);
                break;
            case R.id.history:
                intent = new Intent(this, EExtractHistoryActivity.class);
                startActivity(intent);
                break;

            case R.id.desc:
                intent = new Intent(this, EIncomHistoryActivity.class);
                startActivity(intent);
                break;

            case R.id.rule:

                break;
            case R.id.setting:

                break;

        }
    }
}
