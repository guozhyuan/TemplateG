package com.psychological.cxks.ui.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.psychological.cxks.ui.activity.OrderDetailActivity;
import com.psychological.cxks.util.DeviceUtils;

/**
 * 咨询室订单管理
 */
public class EZiXunShiOrderFragment extends BaseFragment {
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

        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.top = DeviceUtils.dip2px(getActivity(), 5);
            }
        });
        Adapter adapter = new Adapter();
        recyclerView.setAdapter(adapter);

    }

    class Adapter extends RecyclerView.Adapter<Adapter.VH> {

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_order_zixunshi, parent, false);
            return new VH(view);
        }

        @Override
        public void onBindViewHolder(VH holder, int position) {
            holder.method.setText(String.format("咨询方式:%s", ""));
            holder.time.setText(String.format("咨询时间:%s", ""));
            holder.orderNum.setText(String.format("订单号:%s", ""));
            holder.detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().startActivity(new Intent(getActivity(), OrderDetailActivity.class));
                }
            });
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        class VH extends RecyclerView.ViewHolder {
            private TextView method;
            private TextView time;
            private TextView orderNum;
            private TextView detail;

            public VH(View itemView) {
                super(itemView);
                method = itemView.findViewById(R.id.packge_name);
                time = itemView.findViewById(R.id.price);
                orderNum = itemView.findViewById(R.id.orderNum);
                detail = itemView.findViewById(R.id.chat);
            }
        }
    }
}
