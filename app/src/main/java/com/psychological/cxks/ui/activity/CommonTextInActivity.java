package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.psychological.cxks.R;

public class CommonTextInActivity extends BaseActivity {

    private ImageView back;
    private TextView confirm;
    private EditText et;

    @Override
    public int setLayoutId() {
        return R.layout.activity_common_textin;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        confirm = findViewById(R.id.confirm);
        et = findViewById(R.id.et);
    }

    @Override
    public void initListener() {
        back.setOnClickListener((v -> {
            finish();
        }));

        confirm.setOnClickListener((v -> {
            if (TextUtils.isEmpty(et.getText().toString())) {
                finish();
            } else {
                Intent intent = new Intent();
                intent.putExtra("ret", et.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        }));


    }
}
