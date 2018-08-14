package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.psychological.cxks.bean.CouponPackgeBean;
import com.psychological.cxks.ui.activity.CouponsDetailActivity;

import java.util.List;

public class OnSalePackgeAdapter extends RecyclerView.Adapter<OnSalePackgeAdapter.VH> {
    private List<CouponPackgeBean> list;
    private Context context;

    public OnSalePackgeAdapter(Context context, List<CouponPackgeBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_on_sale_packge, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        CouponPackgeBean bean = list.get(position);
        holder.name.setText(bean.getTaocan());
        holder.price.setText(String.format("套餐价格:%s/%s次", bean.getPrice(), bean.getNum()));
        holder.total.setText(String.format("销量:"));

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPackgeClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView price;
        private final TextView total;
        private final LinearLayout root;

        public VH(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.packge_name);
            price = itemView.findViewById(R.id.packge_price);
            total = itemView.findViewById(R.id.packge_total);
            root = itemView.findViewById(R.id.root);
        }
    }

    private OnPackgeClickListener listener;

    public interface OnPackgeClickListener {
        void onPackgeClick(int position);
    }

    public void setOnPackgeClickListener(OnPackgeClickListener listener) {
        this.listener = listener;
    }
}
