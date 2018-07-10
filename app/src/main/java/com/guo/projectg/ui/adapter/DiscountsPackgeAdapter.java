package com.guo.projectg.ui.adapter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.guo.projectg.R;
import com.guo.projectg.bean.DiscountsPackgeBean;
import com.guo.projectg.ui.activity.OrderDetailActivity;
import com.guo.projectg.ui.view.ExpandLayout;

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
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        DiscountsPackgeBean bean = list.get(position);
        for (int i = 0; i < list.get(position).getSunTypeCnt(); i++) {
            View discountsItem = LayoutInflater.from(ctx).inflate(R.layout.view_discount_packge_expand, null);
            holder.discountContainer.addView(discountsItem);
        }
        viewHeight = holder.discountContainer.getMeasuredHeight();
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) holder.discountContainer.getLayoutParams();
        params.height = 0;
        holder.expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("", "点了EXPAND");
                if (bean.isExpand()) {
                    params.height = 0;
                    bean.setExpand(false);
                } else {
                    params.height = viewHeight;
                    bean.setExpand(true);
                }
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class VH extends RecyclerView.ViewHolder {
        public LinearLayout discountContainer;
        public TextView expand;

        public VH(View itemView) {
            super(itemView);
            discountContainer = itemView.findViewById(R.id.discount_holder);
            expand = itemView.findViewById(R.id.tv_expand);
        }
    }

    private void animateToggle(long animationDuration) {
//        ValueAnimator heightAnimation = isExpand ? ValueAnimator.ofFloat(0f, viewHeight) : ValueAnimator.ofFloat(viewHeight, 0f);
        ValueAnimator heightAnimation = ValueAnimator.ofFloat(0f, viewHeight);
        heightAnimation.setDuration(animationDuration / 2);
        heightAnimation.setStartDelay(animationDuration / 2);

        heightAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float val = (float) animation.getAnimatedValue();

            }
        });
        heightAnimation.start();
    }


    public void collapse() {
        animateToggle(300);
    }


    public void expand() {
        animateToggle(300);
    }
}
