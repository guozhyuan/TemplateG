package com.psychological.cxks.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.psychological.cxks.R;
import com.psychological.cxks.ui.activity.SearchActivity;
import com.psychological.cxks.ui.adapter.DropDownGridAdapter;
import com.psychological.cxks.ui.adapter.DropDownLinearAdapter;
import com.psychological.cxks.ui.adapter.MainListAdapter;
import com.psychological.cxks.util.DeviceUtils;

/**
 * Author : jugg
 * Date   : 2018/6/26
 * onAttach -> onCreate -> onCreateView -> onDestroyView -> onDestroy -> onDetach
 */
public class MainFragment extends BaseFragment {
    private static final String TAG = "MainFragment";
    private String citys[] = {"不限", "武汉", "北京", "上海", "成都", "广州", "深圳", "重庆", "天津", "西安", "南京", "杭州"};
    private String ages[] = {"不限", "18岁以下", "18-22岁", "23-26岁", "27-35岁", "35岁以上"};
    private String sexs[] = {"不限", "男", "女"};
    private int currentSelectedPos = -1;
    private RelativeLayout dropdownMenus;
    private SwipeRefreshLayout swipe;
    private RecyclerView recyclerView;
    private RelativeLayout search;


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
        search = view.findViewById(R.id.rl);
        search.setOnClickListener((v) -> {
            startActivity(new Intent(getActivity(), SearchActivity.class));
        });
        dropdownMenus = view.findViewById(R.id.dropdownMenus);
        dropdownMenus.setOnClickListener((v) -> {
        });
        swipe = view.findViewById(R.id.swipe);
        recyclerView = view.findViewById(R.id.recycler);
        //解决滑动冲突
        swipe.setOnChildScrollUpCallback(new SwipeRefreshLayout.OnChildScrollUpCallback() {
            @Override
            public boolean canChildScrollUp(SwipeRefreshLayout parent, @Nullable View child) {
                if (recyclerView == null) {
                    return false;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                return linearLayoutManager.findFirstCompletelyVisibleItemPosition() != 0;
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.top = DeviceUtils.dip2px(getActivity(), 5);
            }
        });
        MainListAdapter gridAdapter = new MainListAdapter(getActivity());
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


    private void setDropDownMenus(int pos) {
        Log.e(TAG, "setDropDownMenus: " + pos);
        if (pos == currentSelectedPos) {
            dropdownMenus.setVisibility(View.INVISIBLE);
            currentSelectedPos = -1;
            return;
        } else {
            dropdownMenus.removeAllViews();
            dropdownMenus.setVisibility(View.VISIBLE);

            switch (pos) {
                case 0:
                    setupAreaLayout();
                    break;
                case 1:
                    setupCateLayout();
                    break;
                case 2:
                    setupGenderLayout();
                    break;
            }
        }
        currentSelectedPos = pos;
    }

    private void setupAreaLayout() {
        View popWindows = LayoutInflater.from(getActivity()).inflate(R.layout.view_dropdown_content, dropdownMenus, false);
        RecyclerView dropdownRecycler = popWindows.findViewById(R.id.dropdownRecycler);
        dropdownRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        dropdownRecycler.addItemDecoration(new SpacesItemDecoration(DeviceUtils.dip2px(getActivity(), 15)));
        DropDownGridAdapter gridAdapter = new DropDownGridAdapter(getActivity(), citys);
        dropdownRecycler.setAdapter(gridAdapter);
        dropdownMenus.addView(popWindows);
    }

    private void setupCateLayout() {
        View popWindows = LayoutInflater.from(getActivity()).inflate(R.layout.view_dropdown_content, dropdownMenus, false);
        RecyclerView dropdownRecycler = popWindows.findViewById(R.id.dropdownRecycler);
        dropdownRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        dropdownRecycler.addItemDecoration(new SpacesItemDecoration(DeviceUtils.dip2px(getActivity(), 15)));
        DropDownGridAdapter gridAdapter = new DropDownGridAdapter(getActivity(), ages);
        dropdownRecycler.setAdapter(gridAdapter);
        dropdownMenus.addView(popWindows);
    }

    private void setupGenderLayout() {
        View popWindows = LayoutInflater.from(getActivity()).inflate(R.layout.view_dropdown_content, dropdownMenus, false);
        RecyclerView dropdownRecycler = popWindows.findViewById(R.id.dropdownRecycler);
        dropdownRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        DropDownLinearAdapter gridAdapter = new DropDownLinearAdapter(getActivity(), sexs);
        dropdownRecycler.setAdapter(gridAdapter);
        dropdownMenus.addView(popWindows);
    }

    class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.bottom = space;
            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildLayoutPosition(view) % 3 == 2) {
                outRect.right = space;
            } else {
                outRect.right = 0;
            }
            if (parent.getChildAdapterPosition(view) < 3) {
                outRect.top = space;
            } else {
                outRect.top = 0;
            }

        }

    }
}
