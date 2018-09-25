package com.psychological.cxks.ui.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.psychological.cxks.R;
import com.psychological.cxks.bean.CouponCodeListBean;
import com.psychological.cxks.bean.MyCouponCodeBean;
import com.psychological.cxks.util.SPUtil;
import com.psychological.cxks.util.TimeConstants;
import com.psychological.cxks.util.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DiscountsCouponsAdapter extends RecyclerView.Adapter<DiscountsCouponsAdapter.VH> {

    private Context ctx;
    private List<CouponCodeListBean.ResultBean> retList;

    public DiscountsCouponsAdapter(Context ctx, List<CouponCodeListBean.ResultBean> retList) {
        this.ctx = ctx;
        this.retList = retList;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_discounts_coupons_list, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        CouponCodeListBean.ResultBean bean = retList.get(position);
        holder.discount_code.setText("优惠码:" + bean.getCoupon());
        holder.discount.setText("8折"); // TODO ??
        holder.desc.setText("折扣优惠");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        long expireTimeMills = TimeUtils.getMillis(bean.getCreateTime(), format, 365, TimeConstants.DAY);
        holder.time.setText(TimeUtils.millis2String(expireTimeMills) + "到期"); // 2018-08-18 11:11:11
        // (1-电询；2-面询；3-文字)
        holder.type.setText(bean.getType() == 1 ? "电询" : bean.getType() == 2 ? "面询" : "文字");
        holder.copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", "点击复制");
                ClipboardManager clipManager = (ClipboardManager) ctx.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("coupon", bean.getCoupon());
                clipManager.setPrimaryClip(clip);
                Toast.makeText(ctx, "已复制到剪贴板", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return retList.size();
    }

    class VH extends RecyclerView.ViewHolder {
        private TextView copy;
        private TextView discount_code;
        private TextView discount;
        private TextView desc;
        private TextView time;
        private TextView type;

        public VH(View itemView) {
            super(itemView);
            copy = itemView.findViewById(R.id.copy);
            discount_code = itemView.findViewById(R.id.discount_code);
            discount = itemView.findViewById(R.id.discount);
            desc = itemView.findViewById(R.id.desc);
            time = itemView.findViewById(R.id.time);
            type = itemView.findViewById(R.id.type);

        }
    }
}
