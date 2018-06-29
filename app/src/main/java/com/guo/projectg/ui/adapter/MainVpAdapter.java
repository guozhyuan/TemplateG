package com.guo.projectg.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Author : jugg
 * Date   : 2018/6/26
 */
public class MainVpAdapter extends FragmentPagerAdapter {
    private List<Fragment> l;

    public MainVpAdapter(FragmentManager fm, List<Fragment> l) {
        super(fm);
        this.l = l;
    }

    @Override
    public Fragment getItem(int position) {
        return l.get(position);
    }

    @Override
    public int getCount() {
        return l.size();
    }

}
