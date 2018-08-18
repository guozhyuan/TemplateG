package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.adapter.TimeAdapter;
import com.psychological.cxks.util.DeviceUtils;
import com.psychological.cxks.util.TimeEnum;

import io.reactivex.disposables.Disposable;

public class ReservationTimeActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "ReservationTimeActivity";
    private ImageView back;
    private RecyclerView recyclerView;
    private TimeAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (App.info == null) {
            startActivity(new Intent(ReservationTimeActivity.this, LoginActivity.class));
            return;
        }
        String id = getIntent().getStringExtra("id");
        Log.e(TAG, "id : " + id);
        Disposable dis = ApiWrapper.getInstance().getExpertTimes(id).subscribe(
                ret -> {

                },
                err -> {

                }
        );
        compositeDisposable.add(dis);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_reservation_time;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.top = DeviceUtils.dip2px(ReservationTimeActivity.this, 10);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TimeAdapter(this);
        adapter.setOnTagClick((day, time) -> {
            Intent intent = new Intent();
            intent.putExtra("day", day);
            intent.putExtra("time", time);
            setResult(RESULT_OK, intent);
            finish();
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initListener() {
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }
}
