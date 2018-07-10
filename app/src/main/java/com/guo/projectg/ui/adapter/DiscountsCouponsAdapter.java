package com.guo.projectg.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.guo.projectg.R;
import com.guo.projectg.ui.activity.OrderDetailActivity;

public class DiscountsCouponsAdapter extends RecyclerView.Adapter<DiscountsCouponsAdapter.VH> {

    private Context ctx;

    public DiscountsCouponsAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_discounts_coupons_list, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.copy.setText("COPY");
        holder.copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("", "点击复制");
            }
        });
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("", "点击图片");
            }
        });

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("", "点击ROOT");
            }
        });

    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class VH extends RecyclerView.ViewHolder {

        private TextView copy;
        private final ImageView image;
        private final ConstraintLayout root;

        public VH(View itemView) {
            super(itemView);
            copy = itemView.findViewById(R.id.copy);
            image = itemView.findViewById(R.id.image);
            root = itemView.findViewById(R.id.root);
        }
    }
}
