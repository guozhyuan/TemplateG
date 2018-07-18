package com.psychological.cxks.ui.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.psychological.cxks.R;

import com.psychological.cxks.ui.adapter.ConsumerEvaluateAdapter;
import com.psychological.cxks.util.DeviceUtils;
import com.hedgehog.ratingbar.RatingBar;

import java.util.ArrayList;

import co.lujun.androidtagview.TagContainerLayout;

public class ConsumerEvaluateActivity extends BaseActivity {


    private RecyclerView recyclerView;
    private TagContainerLayout tagLayout;

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
        recyclerView = findViewById(R.id.recycler);
        ConsumerEvaluateAdapter adapter = new ConsumerEvaluateAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                if (parent.getChildAdapterPosition(view) != 0) {
                    outRect.top = DeviceUtils.dip2px(ConsumerEvaluateActivity.this, 10);
                } else {
                    outRect.top = 0;
                }
            }
        });
        recyclerView.setAdapter(adapter);

        tagLayout = findViewById(R.id.tagLayout);
        ArrayList<String> tagList = new ArrayList<>();
        tagList.add("非常专业");
        tagList.add("有耐心");
        tagList.add("态度很好啊");
        tagList.add("巴拉巴拉");
        tagList.add("非常");
        tagList.add("专业");
        tagLayout.setTags(tagList);

        RatingBar ratingBar = findViewById(R.id.ratingbar);
        ratingBar.setStar(3);
        ratingBar.setmClickable(false);
    }

    @Override
    public void initListener() {

    }
}
