package com.guo.projectg.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.guo.projectg.R;
import com.guo.projectg.bean.TestBean;
import com.guo.projectg.ui.adapter.ChatAdapter;
import com.guo.projectg.ui.adapter.GirdDropDownAdapter;
import com.guo.projectg.ui.adapter.ListDropDownAdapter;
import com.guo.projectg.ui.view.DropDownMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author : jugg
 * Date   : 2018/6/26
 * onAttach -> onCreate -> onCreateView -> onDestroyView -> onDestroy -> onDetach
 */
public class MainFragment extends BaseFragment {
    private DropDownMenu dropDown;
    private String headers[] = {"地区", "领域", "性别"};
    private String citys[] = {"不限", "武汉", "北京", "上海", "成都", "广州", "深圳", "重庆", "天津", "西安", "南京", "杭州"};
    private String ages[] = {"不限", "18岁以下", "18-22岁", "23-26岁", "27-35岁", "35岁以上"};
    private String sexs[] = {"不限", "男", "女"};
    private List<View> menuList = new ArrayList<>();
    private GirdDropDownAdapter cityAdapter;
    private GirdDropDownAdapter categoryAdapter;
    private ListDropDownAdapter genderAdapter;

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

        final ListView cityView = new ListView(getActivity());
        cityAdapter = new GirdDropDownAdapter(getActivity(), Arrays.asList(citys));
        cityView.setDividerHeight(0);
        cityView.setAdapter(cityAdapter);

        final ListView categoryView = new ListView(getActivity());
        categoryView.setDividerHeight(0);
        categoryAdapter = new GirdDropDownAdapter(getActivity(), Arrays.asList(ages));
        categoryView.setAdapter(categoryAdapter);

        final ListView genderView = new ListView(getActivity());
        genderView.setDividerHeight(0);
        genderAdapter = new ListDropDownAdapter(getActivity(), Arrays.asList(sexs));
        genderView.setAdapter(genderAdapter);

        menuList.add(cityView);
        menuList.add(categoryView);
        menuList.add(genderView);

        dropDown = view.findViewById(R.id.dropdown);
        View contentView = getActivity().getLayoutInflater().inflate(R.layout.view_dropdown_holder, null);
        dropDown.setDropDownMenu(Arrays.asList(headers), menuList, contentView);

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
}
