package com.guo.projectg.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class DiscountsVPAdapter extends FragmentPagerAdapter {

    private List<Fragment> l;
    private String[] title;

    public DiscountsVPAdapter(FragmentManager fm, List<Fragment> l, String[] titles) {
        super(fm);
        this.l = l;
        this.title = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return l.get(position);
    }

    @Override
    public int getCount() {
        return l.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
