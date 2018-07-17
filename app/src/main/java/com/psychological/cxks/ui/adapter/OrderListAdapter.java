package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guo.projectg.R;
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
                ctx.startActivity(new Intent(ctx, OrderDetailActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class VH extends RecyclerView.ViewHolder {
        private TextView detail;

        public VH(View itemView) {
            super(itemView);
            detail = itemView.findViewById(R.id.detail);
        }
    }
}
