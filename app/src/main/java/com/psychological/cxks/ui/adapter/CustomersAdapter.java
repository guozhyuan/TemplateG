package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.psychological.cxks.ui.activity.ECustomerDetailActivity;

public class CustomersAdapter extends RecyclerView.Adapter<CustomersAdapter.VH> {

    private Context context;

    public CustomersAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CustomersAdapter.VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_e_customer, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(CustomersAdapter.VH holder, int position) {
        holder.root.setOnClickListener((v) -> {
            Intent intent = new Intent(context, ECustomerDetailActivity.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class VH extends RecyclerView.ViewHolder {

        private final ConstraintLayout root;
        private final ImageView head;
        private final TextView name;

        public VH(View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.root);
            head = itemView.findViewById(R.id.head);
            name = itemView.findViewById(R.id.name);
        }
    }
}
