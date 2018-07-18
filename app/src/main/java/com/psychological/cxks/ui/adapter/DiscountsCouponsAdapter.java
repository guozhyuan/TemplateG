package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.psychological.cxks.R;

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
                Log.e("TAG", "点击复制");
            }
        });

    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class VH extends RecyclerView.ViewHolder {
        private TextView copy;

        public VH(View itemView) {
            super(itemView);
            copy = itemView.findViewById(R.id.copy);
        }
    }
}
