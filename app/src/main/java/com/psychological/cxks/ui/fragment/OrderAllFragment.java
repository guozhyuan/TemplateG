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
import com.psychological.cxks.bean.param.OrderListParam;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.activity.LoginActivity;
import com.psychological.cxks.ui.adapter.OrderListAdapter;
import com.psychological.cxks.ui.view.RecyclerViewOnLoadHelper;
import com.psychological.cxks.util.DeviceUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.Disposable;

/**
 * 所有订单
 */
public class OrderAllFragment extends BaseFragment {
    private static final String TAG = "OrderAllFragment";

    private SwipeRefreshLayout swipe;
    private RecyclerView recycler;
    private OrderListAdapter adapter;
    private OrderListParam param = new OrderListParam();
    private boolean isRefresh = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_order, container, false);
        return view;
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
                outRect.top = DeviceUtils.dip2px(getActivity(), 5);
            }
        });
        adapter = new OrderListAdapter(getActivity());
        recycler.setAdapter(adapter);
        swipe.setOnRefreshListener(() -> {
            param = new OrderListParam();
            param.token = App.info.getToken();
            isRefresh = true;
            getOrder();
        });
        RecyclerViewOnLoadHelper.ins().regist(recycler);
        RecyclerViewOnLoadHelper.ins().setOnLoadListener(() -> {
            param.pageNo += 1;
            isRefresh = false;
            getOrder();
        });
        getOrder();
    }

    private void getOrder() {
        if (App.info == null) {
            startActivity(new Intent(getActivity(), LoginActivity.class));
            return;
        }
//        订单状态，-1:已下单；0：已付款；1：已取消；2：已确定接单；3：咨询结束；4：已评价
        param.token = App.info.getToken();
        param.pageSize = 20;
        param.pageNo = 1;
        param.state = -1;

        Disposable disposable = ApiWrapper.getInstance().allOrder2(bean2map()).subscribe(ret -> {
            if (swipe.isRefreshing()) {
                swipe.setRefreshing(false);
            }

        });
        compositeDisposable.add(disposable);

    }

    private Map<String, Object> bean2map() {
        Map<String, Object> p = new HashMap<>();
        p.put("token", param.token);
        p.put("pageSize", param.pageSize);
        p.put("pageNo", param.pageNo);
        p.put("state", param.state);
        return p;
    }

}
