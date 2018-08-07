package com.psychological.cxks.ui.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.param.OrderDetailParam;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.adapter.OrderListAdapter;
import com.psychological.cxks.util.DeviceUtils;

import io.reactivex.disposables.Disposable;

/**
 * 所有订单
 */
public class OrderAllFragment extends BaseFragment {
    private static final String TAG = "OrderAllFragment";

    private SwipeRefreshLayout swipe;
    private RecyclerView recycler;
    private OrderListAdapter adapter;

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
        OrderDetailParam param = new OrderDetailParam();
        param.pageNo = 1;
        param.pageSize = 20;
        param.token = App.Instance().info.getToken();
        Disposable disposable = ApiWrapper.getInstance().allOrder2(App.Instance().info.getToken()).subscribe(ret -> {

        });
        compositeDisposable.add(disposable);
    }

}
