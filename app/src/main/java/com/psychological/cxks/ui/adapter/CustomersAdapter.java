package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.psychological.cxks.bean.CustomerListBean;
import com.psychological.cxks.ui.activity.ECustomerDetailActivity;

import java.util.List;

public class CustomersAdapter extends RecyclerView.Adapter<CustomersAdapter.VH> {

    private Context context;
    private List<CustomerListBean.ResultBean> list;

    public CustomersAdapter(Context context, List<CustomerListBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public CustomersAdapter.VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_e_customer, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(CustomersAdapter.VH holder, int position) {
        CustomerListBean.ResultBean resultBean = list.get(position);
        holder.name.setText(resultBean.getName());
//        Glide.with(context).load("").apply(RequestOptions.circleCropTransform().placeholder(R.mipmap.launcher)).into(holder.avatar);
        holder.root.setOnClickListener((v) -> {
            Intent intent = new Intent(context, ECustomerDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("customer", resultBean);
            intent.putExtras(bundle);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {

        private final ConstraintLayout root;
        private final ImageView avatar;
        private final TextView name;

        public VH(View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.root);
            avatar = itemView.findViewById(R.id.head);
            name = itemView.findViewById(R.id.name);
        }
    }
}
