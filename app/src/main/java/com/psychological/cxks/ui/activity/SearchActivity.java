package com.psychological.cxks.ui.activity;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.psychological.cxks.bean.ExpertBean;
import com.psychological.cxks.ui.adapter.MainListAdapter;
import com.psychological.cxks.util.DeviceUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchActivity extends BaseActivity {

    private ImageView back;
    private RecyclerView recycler;
    private EditText et;
    private List<ExpertBean.ResultBean> searchBeanList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.top = DeviceUtils.dip2px(SearchActivity.this, 5);
            }
        });
        MainListAdapter gridAdapter = new MainListAdapter(SearchActivity.this, searchBeanList);
        recycler.setAdapter(gridAdapter);

    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        recycler = findViewById(R.id.recycler);
        et = findViewById(R.id.et);
    }

    @Override
    public void initListener() {
        back.setOnClickListener((view) -> {
            finish();
        });

        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String content = et.getText().toString().trim();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    Objects.requireNonNull(imm).hideSoftInputFromWindow(et.getWindowToken(), 0);
                    if (TextUtils.isEmpty(content)) {
                        return true;
                    }
                    Log.e("Search : ", content);
                    return true;
                }
                return false;
            }
        });


    }
}
