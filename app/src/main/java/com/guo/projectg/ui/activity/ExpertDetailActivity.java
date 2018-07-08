package com.guo.projectg.ui.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.guo.projectg.R;

public class ExpertDetailActivity extends BaseActivity {
    @Override
    public int setLayoutId() {
        return R.layout.activity_expert;
    }

    @Override
    public void findView() {
        ImageView back = findViewById(R.id.back);
        TextView message = findViewById(R.id.message);
        TextView talk = findViewById(R.id.talk);
        TextView order = findViewById(R.id.order);
        TextView peer_name = findViewById(R.id.peer_name);
    }

    @Override
    public void initListener() {

    }
}
