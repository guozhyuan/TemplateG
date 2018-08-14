package com.psychological.cxks.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.psychological.cxks.R;
import com.psychological.cxks.ui.fragment.ZiXunShiShareFragment;

import java.util.ArrayList;
import java.util.List;

public class EZiXunShiShareActivity extends BaseActivity implements View.OnClickListener {

    private String[] titles = {"全部", "北京", "上海", "东莞", "武汉"};
    private List<Fragment> fragments;
    private ImageView back;
    private TabLayout tabs;
    private ViewPager vp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragments = new ArrayList<>();
        for (String str : titles) {
            tabs.addTab(tabs.newTab().setText(str));
            ZiXunShiShareFragment fragment = new ZiXunShiShareFragment();
            fragments.add(fragment);
        }
        vp.setAdapter(new Adapter(getSupportFragmentManager()));
        tabs.setupWithViewPager(vp);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_e_zixunshi_share;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        tabs = findViewById(R.id.tabs);
        vp = findViewById(R.id.vp);


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

    class Adapter extends FragmentPagerAdapter {

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
