package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.psychological.cxks.bean.MyCouponAssembleBean;
import com.psychological.cxks.util.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChooseCouponsAdapter extends RecyclerView.Adapter<ChooseCouponsAdapter.VH> {
    private List<MyCouponAssembleBean> list;
    private Context ctx;

    public ChooseCouponsAdapter(Context ctx, List<MyCouponAssembleBean> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_choose_coupons, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        MyCouponAssembleBean bean = list.get(position);
        holder.cb.setChecked(bean.isChecked());
        holder.discount.setText("免费");
        if (bean.getCouponType() == 1) {
            holder.method.setText(bean.getType() == null ? "仅限电询,面询" : bean.getType() == 1 ? "仅限电询" : "仅限面询");
            holder.desc.setText("咨询优惠");
            holder.discount_code.setText(bean.getCoupon());
        } else {
            holder.method.setText("仅限电询,面询");
            holder.desc.setText(bean.getContent());
            holder.discount_code.setText(bean.getCoupon());
        }
        Date now = new Date();
        Date endTime = new Date(now.getTime() + (86400000 * 365));
        holder.time.setText(String.format("%s到期", TimeUtils.date2String(endTime, new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault()))));
        holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    unCheckAll();
                    bean.setChecked(true);
                    onItemCheck.call();
                } else {
                    bean.setChecked(false);
                }
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

//    @Override
//    public int getItemViewType(int position) {
//        return list.get(position).getCouponType() == 1 ? 1 : 2;
//    }

    class VH extends RecyclerView.ViewHolder {

        private final CheckBox cb;
        private final TextView discount;
        private final TextView method;
        private final TextView desc;
        private final TextView discount_code;
        private final TextView time;

        public VH(View itemView) {
            super(itemView);
            cb = itemView.findViewById(R.id.cb);
            discount = itemView.findViewById(R.id.discount);
            method = itemView.findViewById(R.id.method);
            desc = itemView.findViewById(R.id.desc);
            discount_code = itemView.findViewById(R.id.discount_code);
            time = itemView.findViewById(R.id.time);
        }
    }

    public void unCheckAll() {
        for (MyCouponAssembleBean bean : list) {
            bean.setChecked(false);
        }
    }

    private OnItemCheck onItemCheck;

    public interface OnItemCheck {
        void call();
    }

    public void setOnItemCheck(OnItemCheck onItemCheck) {
        this.onItemCheck = onItemCheck;
    }
}
