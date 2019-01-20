package com.psychological.cxks.ui.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.psychological.cxks.App;
import com.psychological.cxks.R;

import com.psychological.cxks.bean.EvaluateBean;
import com.psychological.cxks.bean.ExpertDetailBean;
import com.psychological.cxks.bean.param.EvaluateParam;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.adapter.ConsumerEvaluateAdapter;
import com.psychological.cxks.ui.view.RecyclerViewOnLoadHelper;
import com.psychological.cxks.util.DeviceUtils;
import com.hedgehog.ratingbar.RatingBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.lujun.androidtagview.TagContainerLayout;
import io.reactivex.disposables.Disposable;

public class ConsumerEvaluateActivity extends BaseActivity {


    private RecyclerView recyclerView;
    private TagContainerLayout tagLayout;
    private ConsumerEvaluateAdapter adapter;
    private List<EvaluateBean> list = new ArrayList<>();
    private EvaluateParam param = new EvaluateParam();

    private RatingBar ratingBar;
    private SwipeRefreshLayout swipe;
    private ImageView back;

    private boolean isRefresh = false;
    private String userId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userId = getIntent().getStringExtra("userId");
        if (TextUtils.isEmpty(userId)) {
            if (App.info != null && App.info.getType() == 2) {
                userId = App.info.getUserId();
            }
        }
        if (TextUtils.isEmpty(userId)) return;
        getEvaluateList();
        getScore();
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_consumer_evaluate;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        recyclerView = findViewById(R.id.recycler);
        swipe = findViewById(R.id.swipe);
        swipe.setOnRefreshListener(() -> {
            isRefresh = true;
            param = new EvaluateParam();
            getEvaluateList();
        });
        RecyclerViewOnLoadHelper.ins().regist(recyclerView);
        RecyclerViewOnLoadHelper.ins().setOnLoadListener(() -> {
            isRefresh = false;
            param.pageNo += 1;
            getEvaluateList();
        });
        adapter = new ConsumerEvaluateAdapter(this, list);
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
//        ArrayList<String> tagList = new ArrayList<>(Arrays.asList(detailBean.getLabels().split(",")));
//        tagLayout.setTags(tagList);
        ratingBar = findViewById(R.id.ratingbar);

    }

    @Override
    public void initListener() {
        back.setOnClickListener(v -> finish());
    }

    private void getEvaluateList() {
        param.consultId = userId;
        Disposable subscribe = ApiWrapper.getInstance().evaluateList(param).subscribe(ret -> {
            swipe.setRefreshing(false);
            if (isRefresh) {
                list.clear();
            }
            list.addAll(ret);
            adapter.notifyDataSetChanged();
        }, err -> {

        });
        compositeDisposable.add(subscribe);
    }

    private void getScore() {
        Disposable d = ApiWrapper.getInstance().getScore(userId).subscribe(ret -> {
            //TODO
            ratingBar.setStar(3);
            ratingBar.setmClickable(false);
        }, err -> {

        });
        compositeDisposable.add(d);
    }
}
