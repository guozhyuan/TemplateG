package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.psychological.cxks.ui.activity.OrderDetailActivity;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.VH> {

    private Context ctx;

    public OrderListAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_order_list, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, OrderDetailActivity.class);
                intent.putExtra("serialId","");
                ctx.startActivity(intent);
            }
        });
        holder.method.setText(String.format("咨询方式:%s", ""));
        holder.time.setText(String.format("咨询时间:%s", ""));
        holder.orderNum.setText(String.format("订单号:%s", ""));
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class VH extends RecyclerView.ViewHolder {
        private TextView detail;
        private TextView orderNum;
        private TextView time;
        private TextView orderStatus;
        private TextView method;
        private TextView job;
        private TextView nickname;
        private ImageView head;


        public VH(View itemView) {
            super(itemView);
            detail = itemView.findViewById(R.id.chat);
            orderNum = itemView.findViewById(R.id.orderNum);
            time = itemView.findViewById(R.id.price);
            orderStatus = itemView.findViewById(R.id.orderStatus);
            method = itemView.findViewById(R.id.packge_name);
            job = itemView.findViewById(R.id.job);
            nickname = itemView.findViewById(R.id.nickname);
            head = itemView.findViewById(R.id.head);
        }
    }
}
