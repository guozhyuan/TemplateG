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

import com.guo.projectg.R;
import com.psychological.cxks.ui.activity.ExpertDetailActivity;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.VH> {

    private Context ctx;

    public MainListAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_main_list, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

        holder.root.setOnClickListener((view) -> {
            ctx.startActivity(new Intent(ctx, ExpertDetailActivity.class));
        });

    }

    @Override
    public int getItemCount() {
        return 50;
    }


    class VH extends RecyclerView.ViewHolder {
        private ConstraintLayout root;
        private ImageView imageView;
        private TextView nickname;
        private TextView seniority;
        private TextView evaluation;
        private TextView addr;

        public VH(View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.root);
            imageView = itemView.findViewById(R.id.imageView);
            nickname = itemView.findViewById(R.id.nickname);
            seniority = itemView.findViewById(R.id.seniority);
            evaluation = itemView.findViewById(R.id.evaluation);
            addr = itemView.findViewById(R.id.addr);
        }
    }
}
