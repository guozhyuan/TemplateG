package com.psychological.cxks.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.psychological.cxks.R;

public class ProfileActivity extends BaseActivity {

    private ImageView head;
    private TextView id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_profile;
    }

    @Override
    public void findView() {
        head = findViewById(R.id.head);
        id = findViewById(R.id.id);
    }

    @Override
    public void initListener() {

    }
}
