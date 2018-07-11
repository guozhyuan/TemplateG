package com.guo.projectg.ui.activity;

import android.bluetooth.BluetoothClass;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.guo.projectg.R;
import com.guo.projectg.ui.adapter.ConsumerEvaluateAdapter;
import com.guo.projectg.util.DeviceUtils;

public class ConsumerEvaluateActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_consumer_evaluate;
    }

    @Override
    public void findView() {
        RecyclerView recyclerView = findViewById(R.id.recycler);
        ConsumerEvaluateAdapter adapter = new ConsumerEvaluateAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                if (parent.getChildAdapterPosition(view) != 1) {
                    outRect.top = DeviceUtils.dip2px(ConsumerEvaluateActivity.this, 10);
                } else {
                    outRect.top = 0;
                }
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initListener() {

    }
}
