package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.psychological.cxks.R;

public class IncomeHistoryAdapter extends RecyclerView.Adapter<IncomeHistoryAdapter.VH> {
    private Context ctx;

    public IncomeHistoryAdapter(Context ctx) {
        this.ctx = ctx;
    }


    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_income_history, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class VH extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView money;
        private final TextView time;
        private final TextView left;

        public VH(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            money = itemView.findViewById(R.id.money);
            time = itemView.findViewById(R.id.time);
            left = itemView.findViewById(R.id.left);
        }
    }
}
