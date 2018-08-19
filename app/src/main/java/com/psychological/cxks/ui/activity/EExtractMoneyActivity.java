package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.param.ExtractParam;
import com.psychological.cxks.http.ApiWrapper;

import io.reactivex.disposables.Disposable;

public class EExtractMoneyActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back;
    private TextView money;
    private TextView account;
    private EditText inputMoney;
    private TextView extract;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Disposable d = ApiWrapper.getInstance().balanceQuery(App.info.getUserId()).subscribe(
                ret -> {

                }, err -> {

                }
        );
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_e_extract_money;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        money = findViewById(R.id.money);
        account = findViewById(R.id.account);
        inputMoney = findViewById(R.id.input_money);
        extract = findViewById(R.id.extract);

    }

    @Override
    public void initListener() {
        back.setOnClickListener(this);
        extract.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.extract:
                // TODO 各种判断
                ExtractParam param = new ExtractParam();
                Disposable d = ApiWrapper.getInstance().cashExtract(param).subscribe(
                        ret -> {

                        },
                        err -> {

                        }
                );
                compositeDisposable.add(d);
                break;
        }
    }
}
