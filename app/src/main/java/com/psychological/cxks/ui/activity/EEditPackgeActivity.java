package com.psychological.cxks.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.psychological.cxks.bean.CouponPackgeBean;

public class EEditPackgeActivity extends BaseActivity {

    private ImageView back;
    private TextView pushlishPackge;
    private LinearLayout editPackge;
    private TextView update;
    private TextView xiajia;
    private CouponPackgeBean couponPackgeBean;

    private TextView modePhone;
    private TextView modeMeet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        modePhone.setSelected(true); // 默认电话
        couponPackgeBean = (CouponPackgeBean) getIntent().getSerializableExtra("packge");
        String action = getIntent().getStringExtra("action");

        if (TextUtils.equals(action, "publish")) {
            pushlishPackge.setVisibility(View.VISIBLE);
            editPackge.setVisibility(View.GONE);
        } else {
            pushlishPackge.setVisibility(View.GONE);
            editPackge.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_e_edit_packge;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);

        modePhone = findViewById(R.id.mode_phone);
        modeMeet = findViewById(R.id.mode_meeting);

        pushlishPackge = findViewById(R.id.publish_packge);
        editPackge = findViewById(R.id.edit_packge);
        update = findViewById(R.id.update);
        xiajia = findViewById(R.id.xiajia);


    }

    @Override
    public void initListener() {
        back.setOnClickListener(v -> finish());
        pushlishPackge.setOnClickListener(v -> {

        });

        update.setOnClickListener(v -> {

        });

        xiajia.setOnClickListener(v -> {

        });

        modePhone.setOnClickListener(v -> {
            modeMeet.setSelected(false);
            modePhone.setSelected(true);
        });

        modeMeet.setOnClickListener(v -> {
            modeMeet.setSelected(true);
            modePhone.setSelected(false);
        });

    }
}
