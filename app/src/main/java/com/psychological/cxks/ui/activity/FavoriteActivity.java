package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.psychological.cxks.App;
import com.psychological.cxks.R;

import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.adapter.FavoriteAdapter;
import com.psychological.cxks.util.DeviceUtils;

import io.reactivex.disposables.Disposable;

public class FavoriteActivity extends BaseActivity {


    private ImageView back;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.top = DeviceUtils.dip2px(FavoriteActivity.this, 5);
            }
        });
        FavoriteAdapter adapter = new FavoriteAdapter(this);
        recyclerView.setAdapter(adapter);
        if (App.info == null) {
            startActivity(new Intent(FavoriteActivity.this, LoginActivity.class));
            return;
        }
        Disposable disposable = ApiWrapper.getInstance().collectList(App.info.getUserId()).subscribe(ret -> {

        });
        compositeDisposable.add(disposable);


    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_favorite;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        recyclerView = findViewById(R.id.recycler);
    }

    @Override
    public void initListener() {
        back.setOnClickListener((view) -> {
            finish();
        });
    }
}
