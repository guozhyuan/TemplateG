package com.guo.projectg.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.guo.projectg.R;
import com.guo.projectg.ui.adapter.CustomersAdapter;

public class EMyCustomerActivity extends BaseActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_e_my_customer;
    }

    @Override
    public void findView() {
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomersAdapter adapter = new CustomersAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initListener() {

    }
}
