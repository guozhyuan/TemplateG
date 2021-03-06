package com.psychological.cxks.ui.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.CouponCodeListBean;
import com.psychological.cxks.bean.MyCouponCodeBean;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.activity.LoginActivity;
import com.psychological.cxks.ui.adapter.DiscountsCouponsAdapter;
import com.psychological.cxks.util.DeviceUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * 我的优惠码列表
 */
public class DiscountsCouponsFragment extends BaseFragment {
    private SwipeRefreshLayout swipe;
    private RecyclerView recycler;
    private DiscountsCouponsAdapter adapter;
    private List<CouponCodeListBean.ResultBean> retList;

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
        retList = new ArrayList<>();
        adapter = new DiscountsCouponsAdapter(getActivity(), retList);
        recycler.setAdapter(adapter);
        getCouponCodeList();

    }

    private void getCouponCodeList() {
        if (App.info == null) {
            startActivity(new Intent(getActivity(), LoginActivity.class));
            return;
        }
        Disposable disposable = ApiWrapper.getInstance().couponCodeList(App.info.getUserId()).subscribe(ret -> {
            List<CouponCodeListBean.ResultBean> result = ret.getResult();
            retList.clear();
            retList.addAll(result);
            adapter.notifyDataSetChanged();
        }, err -> {

        });
        compositeDisposable.add(disposable);

    }

}
