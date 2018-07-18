package com.psychological.cxks.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.psychological.cxks.R;
import com.psychological.cxks.ui.fragment.EZiXunOrderFragment;
import com.psychological.cxks.ui.fragment.EZiXunShiOrderFragment;


import java.util.ArrayList;
import java.util.List;

public class EMyOrdersActivity extends BaseActivity {
    private ViewPager viewPager;
    private TabLayout tabs;
    private String[] titles = {"咨询订单", "咨询室订单"};
    private List<Fragment> fargmentList;

    //    private String[] titles = {"全部","待付款", "待确认", "待咨询", "已完成"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fargmentList = new ArrayList<>();
        EZiXunOrderFragment f1 = new EZiXunOrderFragment();
        EZiXunShiOrderFragment f2 = new EZiXunShiOrderFragment();
        fargmentList.add(f1);
        fargmentList.add(f2);
        Adapter adapter = new Adapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);
        tabs.addTab(tabs.newTab().setText("咨询订单"));
        tabs.addTab(tabs.newTab().setText("咨询室订单"));
        tabs.setupWithViewPager(viewPager);

    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_e_my_oriders;
    }

    @Override
    public void findView() {
        viewPager = findViewById(R.id.viewpager);
        tabs = findViewById(R.id.tabs);
    }

    @Override
    public void initListener() {

    }

    class Adapter extends FragmentPagerAdapter {
        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fargmentList.get(position);
        }

        @Override
        public int getCount() {
            return fargmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

}
