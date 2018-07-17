package com.guo.projectg.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.guo.projectg.R;

public class EEditPackgeActivity extends BaseActivity {

    private ImageView back;
    private TextView pushlishPackge;
    private LinearLayout editPackge;
    private TextView update;
    private TextView xiajia;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String extra = getIntent().getStringExtra("packge");
        if (extra.endsWith("publish")) {
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

    }
}
