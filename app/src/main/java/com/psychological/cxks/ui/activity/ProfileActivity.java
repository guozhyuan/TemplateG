package com.psychological.cxks.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.psychological.cxks.App;
import com.psychological.cxks.R;

public class ProfileActivity extends BaseActivity implements View.OnClickListener {

    private ImageView head;
    private ImageView back;
    private TextView id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id.setText(App.info.getUserId());
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_profile;
    }

    @Override
    public void findView() {
        head = findViewById(R.id.head);
        back = findViewById(R.id.back);
        id = findViewById(R.id.id);

    }

    @Override
    public void initListener() {
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;

            case R.id.head:

                break;
        }
    }
}
