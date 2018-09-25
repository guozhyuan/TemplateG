package com.psychological.cxks.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.psychological.cxks.R;

import java.util.ArrayList;
import java.util.List;

public class RegistActivity extends BaseActivity {

    private ViewPager vp;
    private TabLayout tabs;
    private List<Fragment> fragments;
    private ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vp.setOffscreenPageLimit(1);

        RegistUserFragment userFragment = new RegistUserFragment();
        RegistExpertFragment expertFragment = new RegistExpertFragment();
        fragments = new ArrayList<>();
        fragments.add(userFragment);
        fragments.add(expertFragment);
        RegistAdapter adapter = new RegistAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
        tabs.addTab(tabs.newTab().setText("用户注册"));
        tabs.addTab(tabs.newTab().setText("咨询师注册"));
        tabs.setupWithViewPager(vp);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_regist;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        vp = findViewById(R.id.vp);
        tabs = findViewById(R.id.tabs);
    }

    @Override
    public void initListener() {
        back.setOnClickListener(v -> {
            finish();
        });
    }

    class RegistAdapter extends FragmentPagerAdapter {
        private String[] titles = {"用户注册", "咨询师注册"};

        public RegistAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
