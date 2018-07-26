package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.ExpertBean;
import com.psychological.cxks.ui.activity.ExpertDetailActivity;
import com.psychological.cxks.util.DeviceUtils;

import java.util.List;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.VH> {
    private static final String TAG = "MainListAdapter";
    private Context ctx;
    private List<ExpertBean.ResultBean> list;

    public MainListAdapter(Context ctx, List<ExpertBean.ResultBean> list) {
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
        ExpertBean.ResultBean bean = list.get(position);
        holder.root.setOnClickListener((view) -> {
            Intent intent = new Intent(ctx, ExpertDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("expert", bean);
            intent.putExtras(bundle);
            ctx.startActivity(intent);
        });
        Glide.with(ctx).load(bean.getImg()).apply(RequestOptions.circleCropTransform()).into(holder.imageView);
        holder.nickname.setText(bean.getName());
        holder.addr.setText(bean.getAddr());
        holder.evaluation.setText(String.format("好评率:"));
        holder.desc.setText(bean.getPersonalDesc());

        holder.tagLayout.removeAllViews();
        for (String str : bean.getLabels().split(",")) {
            View view = LayoutInflater.from(ctx).inflate(R.layout.view_expert_tag, null);
            TextView tv = view.findViewById(R.id.tv);
            tv.setText(str);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMarginEnd(DeviceUtils.dip2px(ctx, 5));
            view.setLayoutParams(params);
            holder.tagLayout.addView(view);
        }

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
        private TextView desc;
        private LinearLayout tagLayout;
        private TextView evaluation;
        private TextView addr;

        public VH(View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.root);
            imageView = itemView.findViewById(R.id.imageView);
            nickname = itemView.findViewById(R.id.nickname);
            seniority = itemView.findViewById(R.id.seniority);
            desc = itemView.findViewById(R.id.desc);
            tagLayout = itemView.findViewById(R.id.tagLayout);
            evaluation = itemView.findViewById(R.id.evaluation);
            addr = itemView.findViewById(R.id.addr);
        }
    }
}
