package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.ExpertBean;
import com.psychological.cxks.ui.activity.ExpertDetailActivity;
import com.psychological.cxks.util.DeviceUtils;

import java.util.List;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.VH> {

    private Context ctx;
    private List<ExpertBean> list;

    public MainListAdapter(Context ctx, List<ExpertBean> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_main_list, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        ExpertBean bean = list.get(position);
        holder.root.setOnClickListener((view) -> {
            ctx.startActivity(new Intent(ctx, ExpertDetailActivity.class));
        });
        Glide.with(ctx).load(bean.getImg()).into(holder.imageView);
        holder.nickname.setText(bean.getName());
        holder.addr.setText(bean.getAddr());
        holder.evaluation.setText(String.format("好评率:"));

        holder.tagLayout.removeAllViews();
        TextView tv = new TextView(ctx);
        tv.setTextSize(DeviceUtils.sp2px(ctx, 12));
        tv.setGravity(Gravity.CENTER_VERTICAL);
        tv.setBackgroundResource(R.drawable.shape_tag_bg_gray);
        int paddingVal = DeviceUtils.dip2px(ctx, 6);
        tv.setPadding(paddingVal, paddingVal, paddingVal, paddingVal);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMarginStart(DeviceUtils.dip2px(ctx, 5));
        tv.setLayoutParams(params);
        holder.tagLayout.addView(tv);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class VH extends RecyclerView.ViewHolder {
        private ConstraintLayout root;
        private ImageView imageView;
        private TextView nickname;
        private TextView seniority;
        private TextView personalDesc;
        private LinearLayout tagLayout;
        private TextView evaluation;
        private TextView addr;

        public VH(View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.root);
            imageView = itemView.findViewById(R.id.imageView);
            nickname = itemView.findViewById(R.id.nickname);
            seniority = itemView.findViewById(R.id.seniority);
            personalDesc = itemView.findViewById(R.id.personalDesc);
            tagLayout = itemView.findViewById(R.id.tagLayout);
            evaluation = itemView.findViewById(R.id.evaluation);
            addr = itemView.findViewById(R.id.addr);
        }
    }
}
