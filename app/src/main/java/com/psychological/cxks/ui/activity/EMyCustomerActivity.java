package com.psychological.cxks.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.param.CustomerParam;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.adapter.CustomersAdapter;

import io.reactivex.disposables.Disposable;

public class EMyCustomerActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private CustomerParam param = new CustomerParam();
    private ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        param.csId = App.info.getUserId();
        Disposable dis = ApiWrapper.getInstance().getCustomerList(param).subscribe(
                ret -> {

                }, err -> {

                });
        compositeDisposable.add(dis);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_e_my_customer;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomersAdapter adapter = new CustomersAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initListener() {
        back.setOnClickListener(v -> {
            finish();
        });
    }
}
