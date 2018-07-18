package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.psychological.cxks.R;

public class ChooseCouponsAdapter extends RecyclerView.Adapter<ChooseCouponsAdapter.VH> {

    private Context ctx;

    public ChooseCouponsAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_choose_coupons, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //重置数据,刷新显示
            }
        });

    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class VH extends RecyclerView.ViewHolder {

        private final CheckBox cb;

        public VH(View itemView) {
            super(itemView);
            cb = itemView.findViewById(R.id.cb);
        }
    }
}
