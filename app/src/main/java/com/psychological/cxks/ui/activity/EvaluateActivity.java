package com.psychological.cxks.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.hedgehog.ratingbar.RatingBar;

import java.util.ArrayList;
import java.util.List;

import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;

public class EvaluateActivity extends BaseActivity {

    private List<String> tagList = new ArrayList<>();
    private List<String> chosenTags;
    private TextView tvEvaluate;
    private TagContainerLayout tagLayout;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chosenTags = new ArrayList<>();
        tagList.add("非常专业");
        tagList.add("有耐心");
        tagList.add("态度很好啊");
        tagList.add("巴拉巴拉");
        tagList.add("非常");
        tagList.add("专业");
        tagLayout.setTags(tagList);


    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_evaluate;
    }

    @Override
    public void findView() {
        tvEvaluate = findViewById(R.id.tv_evaluate);
        tagLayout = findViewById(R.id.tagLayout);
        ratingBar = findViewById(R.id.ratingbar);
    }

    @Override
    public void initListener() {
        tvEvaluate.setOnClickListener((view) -> {
            finish();
        });
        tagLayout.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text) {
                if (chosenTags.contains(text)) {
                    chosenTags.remove(text);
                    tagLayout.getTags().get(position).setChosen(false);
                } else {
                    chosenTags.add(text);
                    tagLayout.getTags().get(position).setChosen(true);
                }
            }

            @Override
            public void onTagLongClick(int position, String text) {

            }

            @Override
            public void onTagCrossClick(int position) {

            }
        });

        ratingBar.setOnRatingChangeListener(new RatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float RatingCount) {

            }
        });
    }
}
