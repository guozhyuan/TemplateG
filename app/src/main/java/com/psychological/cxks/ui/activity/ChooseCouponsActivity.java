package com.psychological.cxks.ui.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.psychological.cxks.R;
import com.psychological.cxks.ui.adapter.ChooseCouponsAdapter;
import com.psychological.cxks.util.DeviceUtils;

public class ChooseCouponsActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_choose_coupons;
    }

    @Override
    public void findView() {
        ImageView back = findViewById(R.id.back);
        CheckBox cb = findViewById(R.id.none);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                if (parent.getChildAdapterPosition(view) != 0) {
                    outRect.top = DeviceUtils.dip2px(ChooseCouponsActivity.this, 5);
                } else {
                    outRect.top = 0;
                }
            }
        });
        ChooseCouponsAdapter adapter = new ChooseCouponsAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initListener() {

    }
}
