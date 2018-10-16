package com.psychological.cxks.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.adapter.ExtractHistoryAdapter;

import io.reactivex.disposables.Disposable;

public class EExtractHistoryActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ExtractHistoryAdapter adapter = new ExtractHistoryAdapter(this);
        recyclerView.setAdapter(adapter);
        getExtractHistory();
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_e_extract_history;
    }

    @Override
    public void findView() {
        recyclerView = findViewById(R.id.recycler);
        back = findViewById(R.id.back);
    }

    @Override
    public void initListener() {
        back.setOnClickListener(v -> {
            finish();
        });
    }

    public void getExtractHistory() {
        if (App.info == null) {
            return;
        }
        // TODO 接口访问异常
        Disposable dis = ApiWrapper.getInstance().queryExtract(App.info.getUserId()).subscribe(
                ret -> {

                },
                err -> {

                }
        );
        compositeDisposable.add(dis);
    }
}
