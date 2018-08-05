package com.psychological.cxks.ui.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.psychological.cxks.R;

/**
 * Created by cqc on 2018/8/5.
 * 图片上传
 */

public class UploadPhotoActivity extends BaseActivity {
    @Override
    public int setLayoutId() {
        return R.layout.activity_upload_photo;
    }

    @Override
    public void findView() {
        ImageView ivPhoto = findViewById(R.id.iv_photo);
        ivPhoto.setOnClickListener((v) -> {

        });
        TextView submit = findViewById(R.id.submit);
        submit.setOnClickListener((v) -> {
            finish();
        });
    }

    @Override
    public void initListener() {

    }
}
