package com.guo.projectg.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guo.projectg.R;
import com.guo.projectg.ui.adapter.DropDownGridAdapter;
import com.guo.projectg.util.DeviceUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : jugg
 * Date   : 2018/6/26
 * onAttach -> onCreate -> onCreateView -> onDestroyView -> onDestroy -> onDetach
 */
public class MainFragment extends BaseFragment {
    private static final String TAG = "MainFragment";
    private String headers[] = {"地区", "领域", "性别"};
    private String citys[] = {"不限", "武汉", "北京", "上海", "成都", "广州", "深圳", "重庆", "天津", "西安", "南京", "杭州"};
    private String ages[] = {"不限", "18岁以下", "18-22岁", "23-26岁", "27-35岁", "35岁以上"};
    private String sexs[] = {"不限", "男", "女"};
    private int currentSelectedPos = -1;
    private RelativeLayout dropdownMenus;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
//        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_main, container, false);
//        View view = View.inflate(getActivity(), R.layout.fragment_main, container);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dropdownMenus = view.findViewById(R.id.dropdownMenus);

        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        DropDownGridAdapter gridAdapter = new DropDownGridAdapter(getActivity(), 100);
        recyclerView.setAdapter(gridAdapter);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1);
        LinearLayout tabs = view.findViewById(R.id.tabs);
        RelativeLayout v1 = view.findViewById(R.id.rl_area);
        RelativeLayout v2 = view.findViewById(R.id.rl_cate);
        RelativeLayout v3 = view.findViewById(R.id.rl_gender);
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDropDownMenus(0);
            }
        });
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDropDownMenus(1);
            }
        });
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDropDownMenus(2);
            }
        });


//        TabLayout tabLayout = view.findViewById(R.id.tablayout);
//        tabLayout.addTab(tabLayout.newTab().setCustomView(getCustomTabView("地区")));
//        tabLayout.addTab(tabLayout.newTab().setCustomView(getCustomTabView("领域")));
//        tabLayout.addTab(tabLayout.newTab().setCustomView(getCustomTabView("性别")));
//        tabLayout.setSelected(false);
//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                tab.getPosition();
//                TextView tv = tab.getCustomView().findViewById(R.id.tv);
//                Log.e(TAG, "onTabSelected: " + tv.getText().toString());
//                Log.e(TAG, "getPosition: " +   tab.getPosition());
//                if (tab.isSelected()) {
//                    dropdownMenus.setVisibility(View.INVISIBLE);
//                } else {
//                    dropdownMenus.removeAllViews();
//                    dropdownMenus.setVisibility(View.VISIBLE);
//                    View popWindows = LayoutInflater.from(getActivity()).inflate(R.layout.view_dropdown_content, null, false);
//                    RecyclerView dropdownRecycler = popWindows.findViewById(R.id.dropdownRecycler);
//                    dropdownRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 3));
//                    DropDownGridAdapter gridAdapter = new DropDownGridAdapter(getActivity(), citys);
//                    dropdownRecycler.setAdapter(gridAdapter);
//                    dropdownMenus.addView(popWindows);
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                TextView tv = tab.getCustomView().findViewById(R.id.tv);
//                Log.e(TAG, "onTabUnselected: " + tv.getText().toString());
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private View getCustomTabView(String text) {
        View tabView = LayoutInflater.from(getActivity()).inflate(R.layout.view_main_tabitem, null, false);
        TextView textView = tabView.findViewById(R.id.tv);
        textView.setText(text);
        return tabView;
    }

    private void setDropDownMenus(int pos) {
        if (pos == currentSelectedPos) {
            dropdownMenus.setVisibility(View.INVISIBLE);
            currentSelectedPos = -1;
            return;
        } else {
            dropdownMenus.removeAllViews();
            dropdownMenus.setVisibility(View.VISIBLE);
            View popWindows = LayoutInflater.from(getActivity()).inflate(R.layout.view_dropdown_content, dropdownMenus, false);
            RecyclerView dropdownRecycler = popWindows.findViewById(R.id.dropdownRecycler);
            dropdownRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 3));
            DropDownGridAdapter gridAdapter = new DropDownGridAdapter(getActivity(), 10);
            dropdownRecycler.setAdapter(gridAdapter);
            dropdownMenus.addView(popWindows);
        }
        currentSelectedPos = pos;
    }
}
