package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.guo.projectg.R;
import com.psychological.cxks.bean.DiscountsPackgeBean;

import java.util.List;

public class DiscountsPackgeAdapter extends RecyclerView.Adapter<DiscountsPackgeAdapter.VH> {

    private Context ctx;
    private List<DiscountsPackgeBean> list;
    private int viewHeight;

    public DiscountsPackgeAdapter(Context ctx, List<DiscountsPackgeBean> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.item_discounts_packge_list, parent, false);
        VH viewHolder = new VH(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        DiscountsPackgeBean bean = list.get(position);
        holder.expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bean.isExpand()) {
                    holder.discountContainer.removeAllViews();
                    bean.setExpand(false);
                } else {
                    bean.setExpand(true);
                    for (int i = 0; i < bean.getSunTypeCnt(); i++) {
                        View discountsItem = LayoutInflater.from(ctx).inflate(R.layout.view_discount_packge_expand, holder.discountContainer, false);
                        holder.discountContainer.addView(discountsItem);
                        TextView code = discountsItem.findViewById(R.id.discount_code);
                        TextView state = discountsItem.findViewById(R.id.discount_state);
                    }
                }
                notifyDataSetChanged();
            }
        });
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


}
