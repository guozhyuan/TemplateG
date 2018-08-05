package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.psychological.cxks.R;
import com.psychological.cxks.bean.CouponPackgeBean;

import java.util.List;

public class ChooseCouponsAdapter extends RecyclerView.Adapter<ChooseCouponsAdapter.VH> {
    private List<CouponPackgeBean> list;
    private Context ctx;

    public ChooseCouponsAdapter(Context ctx, List<CouponPackgeBean> list) {
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
//        CouponPackgeBean bean = list.get(position);
//        holder.cb.setChecked(bean.isChecked());
//
//        holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (!isChecked) {
//                    unCheckAll();
//                    bean.setChecked(true);
//                    onItemCheck.call();
//                } else {
//                    bean.setChecked(false);
//                }
//                notifyDataSetChanged();
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class VH extends RecyclerView.ViewHolder {

        private final CheckBox cb;

        public VH(View itemView) {
            super(itemView);
            cb = itemView.findViewById(R.id.cb);
        }
    }

    public void unCheckAll() {
        for (CouponPackgeBean bean : list) {
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
