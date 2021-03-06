package com.psychological.cxks.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.psychological.cxks.R;
import com.psychological.cxks.ui.fragment.ECodeGenerateFragment;
import com.psychological.cxks.ui.fragment.ECodeListFragment;
import com.psychological.cxks.ui.fragment.ECodeMyFragment;

import java.util.ArrayList;
import java.util.List;

public class EDiscountCodeActivity extends BaseActivity {

    private ViewPager viewPager;
    private TabLayout tabs;
    private String[] titles = {"生成优惠码", "优惠码列表", "我的优惠码"};
    private ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Fragment> list = new ArrayList<>();
        ECodeGenerateFragment codeGenerateFragment = new ECodeGenerateFragment();
        ECodeListFragment codeListFragment = new ECodeListFragment();
        ECodeMyFragment codeMyFragment = new ECodeMyFragment();
        list.add(codeGenerateFragment);
        list.add(codeListFragment);
        list.add(codeMyFragment);
        Adapter adapter = new Adapter(getSupportFragmentManager(), list);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);
        tabs.addTab(tabs.newTab().setText("生成优惠码"));
        tabs.addTab(tabs.newTab().setText("优惠码列表"));
        tabs.addTab(tabs.newTab().setText("我的优惠码"));
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_e_discount_code;
    }

    @Override
    public void findView() {
        viewPager = findViewById(R.id.viewpager);
        tabs = findViewById(R.id.tabs);
        back = findViewById(R.id.back);

    }

    @Override
    public void initListener() {
        back.setOnClickListener(v -> {
            finish();
        });

    }

    class Adapter extends FragmentPagerAdapter {
        List<Fragment> list;

        public Adapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
