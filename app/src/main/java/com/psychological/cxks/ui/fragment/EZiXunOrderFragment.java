package com.psychological.cxks.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psychological.cxks.R;
import com.psychological.cxks.ui.adapter.OrderVpAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 咨询订单管理
 */
public class EZiXunOrderFragment extends BaseFragment {

    private ViewPager viewPager;
    private TabLayout tabs;
    private String[] titles = {"全部", "待付款", "待确认", "待咨询", "已完成"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_e_zixun_order, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.viewpager);
        tabs = view.findViewById(R.id.tabs);
        List<Fragment> list = new ArrayList<>();
        OrderAllFragment allFragment = new OrderAllFragment();
        OrderNotPayFragment notPayFragment = new OrderNotPayFragment();
        OrderNotConfirmFragment notConfirmFragment = new OrderNotConfirmFragment();
        OrderDoubtFragment doubtFragment = new OrderDoubtFragment();
        OrderCompleteFragment completeFragment = new OrderCompleteFragment();
        list.add(allFragment);
        list.add(notPayFragment);
        list.add(notConfirmFragment);
        list.add(doubtFragment);
        list.add(completeFragment);
        OrderVpAdapter adapter = new OrderVpAdapter(getChildFragmentManager(), list, titles);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        tabs.addTab(tabs.newTab().setText("全部"));
        tabs.addTab(tabs.newTab().setText("待付款"));
        tabs.addTab(tabs.newTab().setText("待确认"));
        tabs.addTab(tabs.newTab().setText("待咨询"));
        tabs.addTab(tabs.newTab().setText("已完成"));
        tabs.setupWithViewPager(viewPager);
    }
}
