package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.psychological.cxks.R;

public class DropDownGridAdapter extends RecyclerView.Adapter<DropDownGridAdapter.VH> {

    private String[] list;
    private Context ctx;

    public DropDownGridAdapter(Context ctx, String[] list) {
        this.list = list;
        this.ctx = ctx;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_dropdown_grid, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.tv.setText(list[position]);
    }

    @Override
    public int getItemCount() {
        Log.e("", "getItemCount : " + list.length);
        return list.length;
    }

    class VH extends RecyclerView.ViewHolder {
        private TextView tv;

        public VH(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
