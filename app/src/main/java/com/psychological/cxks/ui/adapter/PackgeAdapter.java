package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.psychological.cxks.ui.activity.EEditPackgeActivity;

/**
 * 我的套餐Adpater
 */
public class PackgeAdapter extends RecyclerView.Adapter<PackgeAdapter.VH> {

    private Context ctx;

    public PackgeAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_my_packge, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.edit.setOnClickListener(v -> {
            Intent intent = new Intent(ctx, EEditPackgeActivity.class);
            intent.putExtra("packge", "edit");
            ctx.startActivity(intent);
        });
        holder.price.setText(String.format("套餐价格:%s", ""));
        holder.method.setText(String.format("咨询方式:%s", ""));
        holder.amount.setText(String.format("使用次数:%s", ""));
        holder.valid.setText(String.format("有效期:%s", ""));
        holder.updateTime.setText(String.format("%s更新", ""));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class VH extends RecyclerView.ViewHolder {

        private final TextView packgeName;
        private final TextView price;
        private final TextView method;
        private final TextView amount;
        private final TextView valid;
        private final TextView edit;
        private final TextView updateTime;

        public VH(View itemView) {
            super(itemView);
            packgeName = itemView.findViewById(R.id.packge_name);
            price = itemView.findViewById(R.id.price);
            method = itemView.findViewById(R.id.method);
            amount = itemView.findViewById(R.id.amount);
            valid = itemView.findViewById(R.id.valid);
            edit = itemView.findViewById(R.id.edit);
            updateTime = itemView.findViewById(R.id.update_time);
        }
    }
}
