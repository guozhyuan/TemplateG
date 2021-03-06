package com.psychological.cxks.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.psychological.cxks.R;

import com.psychological.cxks.ui.adapter.DiscountsVPAdapter;
import com.psychological.cxks.ui.fragment.DiscountsCouponsFragment;
import com.psychological.cxks.ui.fragment.DiscountsPackgeFragment;

import java.util.ArrayList;
import java.util.List;

public class CouponsListActivity extends BaseActivity {
    private ViewPager viewPager;
    private TabLayout tabs;
    private String[] titles = {"优惠券", "优惠套餐"};
    private ImageView back;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Fragment> list = new ArrayList<>();
        DiscountsCouponsFragment discountsCouponsFragment = new DiscountsCouponsFragment();
//        DiscountsCouponsFragment discountsPackgeFragment = new DiscountsCouponsFragment();
        DiscountsPackgeFragment discountsPackgeFragment = new DiscountsPackgeFragment();
        list.add(discountsCouponsFragment);
        list.add(discountsPackgeFragment);
        DiscountsVPAdapter adapter = new DiscountsVPAdapter(getSupportFragmentManager(), list, titles);
        viewPager.setAdapter(adapter);
        tabs.addTab(tabs.newTab().setText("优惠券"));
        tabs.addTab(tabs.newTab().setText("优惠套餐"));
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_list_coupons;
    }

    @Override
    public void findView() {
        viewPager = findViewById(R.id.viewpager);
        tabs = findViewById(R.id.tabs);
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(v -> finish());
    }

    @Override
    public void initListener() {

    }
}
