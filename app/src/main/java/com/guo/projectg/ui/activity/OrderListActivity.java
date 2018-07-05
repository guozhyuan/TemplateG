package com.guo.projectg.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.guo.projectg.R;
import com.guo.projectg.ui.adapter.OrderVpAdapter;
import com.guo.projectg.ui.fragment.MeFragment;

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
        MeFragment meFragment1 = new MeFragment();
        MeFragment meFragment2 = new MeFragment();
        MeFragment meFragment3 = new MeFragment();
        MeFragment meFragment4 = new MeFragment();
        list.add(meFragment1);
        list.add(meFragment2);
        list.add(meFragment3);
        list.add(meFragment4);
        OrderVpAdapter adapter = new OrderVpAdapter(getSupportFragmentManager(), list, titles);
        viewPager.setAdapter(adapter);
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
