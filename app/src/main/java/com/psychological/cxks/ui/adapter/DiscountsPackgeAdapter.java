package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.psychological.cxks.bean.CouponPackageListBean;
import com.psychological.cxks.bean.DiscountsPackgeBean;
import com.psychological.cxks.util.TimeConstants;
import com.psychological.cxks.util.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class DiscountsPackgeAdapter extends RecyclerView.Adapter<DiscountsPackgeAdapter.VH> {

    private Context ctx;
    private List<CouponPackageListBean.ResultBean> list;


    public DiscountsPackgeAdapter(Context ctx, List<CouponPackageListBean.ResultBean> list) {
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
//        DiscountsPackgeBean bean = list.get(position);
//        holder.expand.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (bean.isExpand()) {
//                    holder.discountContainer.removeAllViews();
//                    bean.setExpand(false);
//                } else {
//                    bean.setExpand(true);
//                    for (int i = 0; i < bean.getSubTypeCnt(); i++) {
//                        View discountsItem = LayoutInflater.from(ctx).inflate(R.layout.view_discount_packge_expand, holder.discountContainer, false);
//                        holder.discountContainer.addView(discountsItem);
//                        TextView code = discountsItem.findViewById(R.id.discount_code);
//                        TextView state = discountsItem.findViewById(R.id.discount_state);
//                    }
//                }
//                notifyDataSetChanged();
//            }
//        });

        CouponPackageListBean.ResultBean bean = list.get(position);
        holder.desc.setText("折扣优惠");
        // (1-电询；2-面询；3-文字)
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        long expireTimeMills = TimeUtils.getMillis(bean.getTime(), format, 365, TimeConstants.DAY);
        holder.time.setText(TimeUtils.millis2String(expireTimeMills) + "到期"); // 2018-08-18 11:11:11
        holder.discount.setText("8折"); // TODO ??
        holder.type.setText("");
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {
        private LinearLayout discountContainer;
        private TextView expand;

        private TextView discount;
        private TextView desc;
        private TextView type;
        private TextView time;

        public VH(View itemView) {
            super(itemView);
            discountContainer = itemView.findViewById(R.id.discount_holder);
            expand = itemView.findViewById(R.id.tv_expand);

            discount = itemView.findViewById(R.id.discount);
            desc = itemView.findViewById(R.id.desc);
            type = itemView.findViewById(R.id.type);
            time = itemView.findViewById(R.id.time);
        }
    }


}
