package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.http.ApiWrapper;

import io.reactivex.disposables.Disposable;

public class ECustomerDetailActivity extends BaseActivity {

    private ImageView back;
    private ImageView head;
    private ImageView gender;
    private TextView nick;
    private TextView addr;
    private TextView chat;

    private ConstraintLayout histroy;
    private TextView count;             //咨询次数
    private ConstraintLayout info;
    private ConstraintLayout report;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO 暂时写死
        Disposable dis = ApiWrapper.getInstance().getCustomerInfo("qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N").subscribe(
                ret -> {

                },
                err -> {

                }
        );

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
        chat = findViewById(R.id.chat);

        histroy = findViewById(R.id.history);
        count = findViewById(R.id.count);
        info = findViewById(R.id.visitor_info);
        report = findViewById(R.id.report);
    }

    @Override
    public void initListener() {
        back.setOnClickListener((v) -> {
            finish();
        });
        chat.setOnClickListener((v) -> {
        });
        histroy.setOnClickListener((v) -> {
            if (App.info == null) {
                startActivity(new Intent(this, LoginActivity.class));
                return;
            }
            //TODO 暂时写死
            Disposable dis = ApiWrapper.getInstance().getConsultNum(App.info.getUserId(), "qWpz8EbK8VQ91EKzdcyYdrGVx9oNtY5N").subscribe(
                    ret -> {

                    },
                    err -> {

                    }
            );
        });
        info.setOnClickListener((v) -> {

        });
        report.setOnClickListener((v) -> {
        });
    }
}
