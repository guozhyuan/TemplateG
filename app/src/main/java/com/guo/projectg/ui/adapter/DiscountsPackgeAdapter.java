package com.guo.projectg.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.guo.projectg.R;
import com.guo.projectg.bean.DiscountsPackgeBean;

import java.util.List;

public class DiscountsPackgeAdapter extends RecyclerView.Adapter {

    private Context ctx;
    private List<DiscountsPackgeBean> list;
    private int viewHeight;

    public DiscountsPackgeAdapter(Context ctx, List<DiscountsPackgeBean> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(ctx).inflate(R.layout.item_discounts_packge_list, parent, false);
                viewHolder = new VH(view);
                break;
            case 1:
                view = LayoutInflater.from(ctx).inflate(R.layout.item_discounts_packge_list, parent, false);
                viewHolder = new VH2(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DiscountsPackgeBean bean = list.get(position);
        switch (holder.getItemViewType()) {
            case 0:
                VH vh = (VH) holder;
                vh.expand.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bean.setExpand(true);
                        notifyItemChanged(position);
                    }
                });
                break;
            case 1:
                VH2 vh2 = (VH2) holder;
                vh2.discountContainer.removeAllViews();
                for (int i = 0; i < bean.getSunTypeCnt(); i++) {
                    View discountsItem = LayoutInflater.from(ctx).inflate(R.layout.view_discount_packge_expand, vh2.discountContainer, false);
                    vh2.discountContainer.addView(discountsItem);
                }
                vh2.expand.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bean.setExpand(false);
                        notifyItemChanged(position);
                    }
                });
                break;
        }

//        holder.expand.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("TAG", "onClick: current position status = " + bean.isExpand());
//                if (bean.isExpand()) {
//                    holder.discountContainer.removeAllViews();
//                    bean.setExpand(false);
//                } else {
//                    bean.setExpand(true);
//                    for (int i = 0; i < bean.getSunTypeCnt(); i++) {
//                        View discountsItem = LayoutInflater.from(ctx).inflate(R.layout.view_discount_packge_expand, holder.discountContainer, false);
//                        holder.discountContainer.addView(discountsItem);
//                    }
//                    holder.discountContainer.requestLayout();
//                    holder.root.requestLayout();
//                }
//                notifyDataSetChanged();
//            }
//        });

    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).isExpand() ? 1 : 0;
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class VH extends RecyclerView.ViewHolder {
        private LinearLayout discountContainer;
        private TextView expand;

        public VH(View itemView) {
            super(itemView);
            discountContainer = itemView.findViewById(R.id.discount_holder);
            expand = itemView.findViewById(R.id.tv_expand);
        }
    }

    class VH2 extends RecyclerView.ViewHolder {
        private TextView expand;
        private LinearLayout discountContainer;

        public VH2(View itemView) {
            super(itemView);
            expand = itemView.findViewById(R.id.tv_expand);
            discountContainer = itemView.findViewById(R.id.discount_holder);
        }
    }

}
