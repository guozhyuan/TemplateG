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
import android.widget.TextView;

import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.ZiXunShiOrderListBean;
import com.psychological.cxks.bean.param.RoomOrderParam;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.activity.LoginActivity;
import com.psychological.cxks.ui.activity.OrderDetailActivity;
import com.psychological.cxks.ui.view.RecyclerViewOnLoadHelper;
import com.psychological.cxks.util.DeviceUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * 咨询室订单管理
 */
public class EZiXunShiOrderFragment extends BaseFragment {

    private Adapter adapter;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipe;
    private RoomOrderParam param = new RoomOrderParam();
    private List<ZiXunShiOrderListBean.ResultBean> list = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_e_zixunshi_order, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipe = view.findViewById(R.id.swipe);
        swipe.setOnRefreshListener(() -> {
            param.pageNo = 1;
            list.clear();
            getRoomOrder();
        });
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.top = DeviceUtils.dip2px(getActivity(), 5);
            }
        });
        RecyclerViewOnLoadHelper.ins().regist(recyclerView);
        RecyclerViewOnLoadHelper.ins().setOnLoadListener(new RecyclerViewOnLoadHelper.OnLoadListener() {
            @Override
            public void onLoad() {
                param.pageNo += 1;
                getRoomOrder();
            }
        });

        adapter = new Adapter();
        recyclerView.setAdapter(adapter);
        if (App.info == null) {
            startActivity(new Intent(getActivity(), LoginActivity.class));
            return;
        }
        param.token = App.info.getToken();
        getRoomOrder();
    }

    private void getRoomOrder() {

        Disposable d = ApiWrapper.getInstance().getRoomOrderList(param).subscribe(
                ret -> {
                    if (swipe.isRefreshing()) {
                        swipe.setRefreshing(false);
                    }
                    list.addAll(ret.getResult());
                    adapter.notifyDataSetChanged();
                },
                err -> {
                    if (swipe.isRefreshing()) {
                        swipe.setRefreshing(false);
                    }
                }
        );
        compositeDisposable.add(d);
    }

    class Adapter extends RecyclerView.Adapter<Adapter.VH> {


        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_order_zixunshi, parent, false);
            return new VH(view);
        }

        @Override
        public void onBindViewHolder(VH holder, int position) {
            ZiXunShiOrderListBean.ResultBean bean = list.get(position);
            holder.name.setText(bean.getRoomName());
            holder.time.setText(String.format("咨询时间:%s", bean.getOrderTime()));
            holder.orderNum.setText(String.format("订单号:%s", bean.getSerialId()));
            holder.detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
                    intent.putExtra("serialId", bean.getSerialId());
                    getActivity().startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class VH extends RecyclerView.ViewHolder {
            private TextView name;
            private TextView time;
            private TextView orderNum;
            private TextView detail;

            public VH(View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.name);
                time = itemView.findViewById(R.id.time);
                orderNum = itemView.findViewById(R.id.orderNum);
                detail = itemView.findViewById(R.id.chat);
            }
        }
    }
}
