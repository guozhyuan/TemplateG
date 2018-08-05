package com.psychological.cxks.ui.activity;


import com.psychological.cxks.R;

import java.util.ArrayList;
import java.util.List;

import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;

public class LabelsActivity extends BaseActivity {

    private List<String> tagList = new ArrayList<>();
    private List<String> chosenTags ;

    private TagContainerLayout tagLayout;


    @Override
    public int setLayoutId() {
        return R.layout.activity_labels;
    }

    @Override
    public void findView() {
        tagLayout = findViewById(R.id.tagLayout);
        tagLayout = findViewById(R.id.tagLayout);
    }

    @Override
    public void initListener() {
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

        getLabelsList();
    }

    private void getLabelsList() {
        chosenTags = new ArrayList<>();
        tagList.add("非常专业");
        tagList.add("有耐心");
        tagList.add("态度很好啊");
        tagList.add("巴拉巴拉");
        tagList.add("非常");
        tagList.add("专业");
        tagLayout.setTags(tagList);
    }
}
