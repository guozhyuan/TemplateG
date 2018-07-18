package com.psychological.cxks.ui.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psychological.cxks.R;
import com.psychological.cxks.bean.DiscountsPackgeBean;
import com.psychological.cxks.ui.adapter.DiscountsPackgeAdapter;
import com.psychological.cxks.util.DeviceUtils;

import java.util.ArrayList;
import java.util.List;

public class DiscountsPackgeFragment extends BaseFragment {
    private SwipeRefreshLayout swipe;
    private RecyclerView recycler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_discounts, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipe = view.findViewById(R.id.swipe);
        recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.top = DeviceUtils.dip2px(getActivity(), 10);
            }
        });
        List<DiscountsPackgeBean> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(new DiscountsPackgeBean());
        }
        DiscountsPackgeAdapter adapter = new DiscountsPackgeAdapter(getActivity(), list);
        recycler.setAdapter(adapter);
    }
}
