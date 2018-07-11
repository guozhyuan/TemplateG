package com.guo.projectg.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.guo.projectg.R;
import com.guo.projectg.ui.activity.CouponsDetailActivity;

public class OnSalePackgeAdapter extends RecyclerView.Adapter<OnSalePackgeAdapter.VH> {

    private Context context;

    public OnSalePackgeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_on_sale_packge, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, CouponsDetailActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
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
}
