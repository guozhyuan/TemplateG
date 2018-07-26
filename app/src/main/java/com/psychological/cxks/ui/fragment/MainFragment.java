package com.psychological.cxks.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.BannerBean;
import com.psychological.cxks.bean.ExpertBean;
import com.psychological.cxks.bean.param.ExpertListParam;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.activity.SearchActivity;
import com.psychological.cxks.ui.adapter.BannerAdapter;
import com.psychological.cxks.ui.adapter.DropDownGridAdapter;
import com.psychological.cxks.ui.adapter.DropDownLinearAdapter;
import com.psychological.cxks.ui.adapter.MainListAdapter;
import com.psychological.cxks.util.DeviceUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Author : jugg
 * Date   : 2018/6/26
 * onAttach -> onCreate -> onCreateView -> onDestroyView -> onDestroy -> onDetach
 */
public class MainFragment extends BaseFragment {
    private static final String TAG = "MainFragment";
    private String citys[] = {"武汉", "北京", "上海", "成都", "广州", "深圳", "重庆", "天津", "西安", "南京", "杭州"};
    private String cates[] = {"心理", "临床"};
    private String sexs[] = {"男", "女"};
    private int currentSelectedPos = -1;
    private RelativeLayout dropdownMenus;
    private SwipeRefreshLayout swipe;
    private RecyclerView recyclerView;
    private RelativeLayout search;
    private ViewPager banner;
    private TextView tv_area;
    private TextView tv_cate;
    private TextView tv_gender;


    private ExpertListParam expertListParam = new ExpertListParam();
    private MainListAdapter mainListAdapter;
    private List<ExpertBean> expertBeanList = new ArrayList<>();

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
        tv_area = view.findViewById(R.id.tv_area);
        tv_cate = view.findViewById(R.id.tv_cate);
        tv_gender = view.findViewById(R.id.tv_gender);
        banner = view.findViewById(R.id.banner);
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
        mainListAdapter = new MainListAdapter(getActivity(), expertBeanList);
        recyclerView.setAdapter(mainListAdapter);

//        getBannerList();
        getExpertList();
    }

    private void getBannerList() {
        Disposable disposable = ApiWrapper.getInstance().bannerList().subscribe(bannerBeans -> {
            List<ImageView> list = new ArrayList<>();
            for (BannerBean bean : bannerBeans) {
                ImageView img = new ImageView(getActivity());
                Glide.with(getActivity()).load(bean.getUrl()).into(img);
                list.add(img);
            }
            BannerAdapter adapter = new BannerAdapter(getActivity(), list);
            banner.setAdapter(adapter);
        });
        compositeDisposable.add(disposable);
    }

    private void getExpertList() {
        Disposable disposable = ApiWrapper.getInstance().expertList(expertListParam).subscribe(expertBeans -> {
            expertBeanList = expertBeans;
            mainListAdapter.notifyDataSetChanged();
        });
        compositeDisposable.add(disposable);
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
        gridAdapter.setOnItemClickListener((txt, position) -> {
            setDropDownMenus(0);
            tv_area.setText(txt);
            expertListParam.addr = txt;
            expertListParam.pageNo = 1;
            //重新请求数据
        });
        dropdownRecycler.setAdapter(gridAdapter);
        dropdownMenus.addView(popWindows);
    }

    private void setupCateLayout() {
        View popWindows = LayoutInflater.from(getActivity()).inflate(R.layout.view_dropdown_content, dropdownMenus, false);
        RecyclerView dropdownRecycler = popWindows.findViewById(R.id.dropdownRecycler);
        dropdownRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        dropdownRecycler.addItemDecoration(new SpacesItemDecoration(DeviceUtils.dip2px(getActivity(), 15)));
        DropDownGridAdapter gridAdapter = new DropDownGridAdapter(getActivity(), cates);
        gridAdapter.setOnItemClickListener((txt, position) -> {
            setDropDownMenus(1);
            tv_cate.setText(txt);
            expertListParam.labels = txt;
            expertListParam.pageNo = 1;
        });
        dropdownRecycler.setAdapter(gridAdapter);
        dropdownMenus.addView(popWindows);
    }

    private void setupGenderLayout() {
        View popWindows = LayoutInflater.from(getActivity()).inflate(R.layout.view_dropdown_content, dropdownMenus, false);
        RecyclerView dropdownRecycler = popWindows.findViewById(R.id.dropdownRecycler);
        dropdownRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        DropDownLinearAdapter gridAdapter = new DropDownLinearAdapter(getActivity(), sexs);
        gridAdapter.setOnItemClickListener((txt, position) -> {
            setDropDownMenus(2);
            tv_gender.setText(txt);
            expertListParam.sex = TextUtils.equals(txt, "男") ? 1 : 2;
            expertListParam.pageNo = 1;
        });
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
