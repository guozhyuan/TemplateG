package com.guo.projectg.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guo.projectg.R;

public class DropDownGridAdapter extends RecyclerView.Adapter<DropDownGridAdapter.VH> {

    private String[] list;
    private Context ctx;
    private int size;

    public DropDownGridAdapter(Context ctx, int size) {
        this.list = list;
        this.ctx = ctx;
        this.size = size;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_dropdown_grid, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return size;
    }

    class VH extends RecyclerView.ViewHolder {
        private TextView tv;

        public VH(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
