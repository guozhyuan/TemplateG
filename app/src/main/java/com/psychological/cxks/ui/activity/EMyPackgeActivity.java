package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.psychological.cxks.ui.adapter.PackgeAdapter;
import com.psychological.cxks.util.DeviceUtils;

public class EMyPackgeActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private ImageView back;
    private TextView addPackge;

    @Override
    public int setLayoutId() {
        return R.layout.activity_e_my_packge;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        addPackge = findViewById(R.id.add_packge);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.top = DeviceUtils.dip2px(EMyPackgeActivity.this, 5);
            }
        });
        PackgeAdapter adapter = new PackgeAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initListener() {
        back.setOnClickListener(v -> finish());
        addPackge.setOnClickListener(v -> {
            Intent intent = new Intent(this, EEditPackgeActivity.class);
            intent.putExtra("packge", "publish");
            startActivity(intent);
        });
    }
}
