package com.psychological.cxks.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.guo.projectg.R;
import com.psychological.cxks.ui.adapter.OrderVpAdapter;
import com.psychological.cxks.ui.fragment.OrderAllFragment;
import com.psychological.cxks.ui.fragment.OrderCompleteFragment;
import com.psychological.cxks.ui.fragment.OrderDoubtFragment;
import com.psychological.cxks.ui.fragment.OrderNotPayFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderListActivity extends BaseActivity {
    private ViewPager viewPager;
    private TabLayout tabs;
    private String[] titles = {"全部", "待付款", "待咨询", "已完成"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Fragment> list = new ArrayList<>();
        OrderAllFragment allFragment = new OrderAllFragment();
        OrderNotPayFragment notPayFragment = new OrderNotPayFragment();
        OrderDoubtFragment doubtFragment = new OrderDoubtFragment();
        OrderCompleteFragment completeFragment = new OrderCompleteFragment();
        list.add(allFragment);
        list.add(notPayFragment);
        list.add(doubtFragment);
        list.add(completeFragment);
        OrderVpAdapter adapter = new OrderVpAdapter(getSupportFragmentManager(), list, titles);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        tabs.addTab(tabs.newTab().setText("全部"));
        tabs.addTab(tabs.newTab().setText("待付款"));
        tabs.addTab(tabs.newTab().setText("待咨询"));
        tabs.addTab(tabs.newTab().setText("已完成"));
        tabs.setupWithViewPager(viewPager);

    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_order_list;
    }

    @Override
    public void findView() {
        viewPager = findViewById(R.id.viewpager);
        tabs = findViewById(R.id.tabs);
    }

    @Override
    public void initListener() {

    }
}
