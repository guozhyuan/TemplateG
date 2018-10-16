package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.CustomerListBean;
import com.psychological.cxks.bean.param.CustomerParam;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.adapter.CustomersAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.disposables.Disposable;

public class EMyCustomerActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private CustomerParam param = new CustomerParam();
    private ImageView back;
    private CustomersAdapter adapter;
    private List<CustomerListBean.ResultBean> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (App.info == null) {
            startActivity(new Intent(this, LoginActivity.class));
            return;
        }
        param.csId = App.info.getUserId();
        Map<String, Object> map = new HashMap<>();
        map.put("csId", param.csId);
        map.put("pageNo", param.pageNo);
        map.put("pageSize", param.pageSize);
        Disposable dis = ApiWrapper.getInstance().getCustomerList2(map).subscribe(
                ret -> {
                    list.addAll(ret.getResult());
                    adapter.notifyDataSetChanged();
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
        adapter = new CustomersAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initListener() {
        back.setOnClickListener(v -> {
            finish();
        });
    }
}
