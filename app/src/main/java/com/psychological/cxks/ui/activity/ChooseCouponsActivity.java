package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.psychological.cxks.R;

import com.psychological.cxks.bean.MyCouponPackgeBean;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.adapter.ChooseCouponsAdapter;
import com.psychological.cxks.util.DeviceUtils;
import com.psychological.cxks.util.SPUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

public class ChooseCouponsActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "ChooseCouponsActivity";


    private ImageView back;
    private CheckBox cb;
    private TextView confirm;


    private RecyclerView recyclerView;
    private ChooseCouponsAdapter adapter;
    private List<MyCouponPackgeBean> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getAllCoupnList();
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_choose_coupons;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        cb = findViewById(R.id.none);
        confirm = findViewById(R.id.confirm);


        recyclerView = findViewById(R.id.recycler);
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
        adapter = new ChooseCouponsAdapter(this, list);
        adapter.setOnItemCheck(() -> {
            if (cb.isChecked()) {
                cb.setChecked(false);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initListener() {
        back.setOnClickListener(this);
        confirm.setOnClickListener(this);
        cb.setOnCheckedChangeListener((checkBox, isChecked) -> {
            if (isChecked) {
//                adapter.unCheckAll();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;

            case R.id.confirm:

                break;
        }
    }

    private void getAllCoupnList() {
        String userId = SPUtil.getString(this, "userId");
        if (TextUtils.isEmpty(userId)) {
            Toast.makeText(this, "请登录", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
        }
        Disposable disposable = ApiWrapper.getInstance().getAllCouponList(userId).subscribe(ret -> {
            Log.e(TAG, "getAllCoupnList: " + ret);
        });
        compositeDisposable.add(disposable);
    }
}
