package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.OrderListBean;
import com.psychological.cxks.ui.activity.OrderDetailActivity;
import com.psychological.cxks.util.OrderStateEnum;

import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.VH> {

    private Context ctx;
    private List<OrderListBean.ResultBean> list;

    public OrderListAdapter(Context ctx, List<OrderListBean.ResultBean> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_order_list, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        OrderListBean.ResultBean bean = list.get(position);
        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, OrderDetailActivity.class);
                intent.putExtra("serialId", bean.getSerialId());
                ctx.startActivity(intent);
            }
        });

        Glide.with(ctx).load(bean.getImg()).apply(RequestOptions.circleCropTransform().placeholder(R.mipmap.launcher)).into(holder.head);
        holder.nickname.setText(bean.getCounselor());
        // 1—电话咨询，2—见面咨询
        holder.method.setText(String.format("咨询方式:%s", bean.getTime() == 1 ? "电询" : "面询"));
        holder.time.setText(String.format("咨询时间:%s", bean.getDealTime()));
        holder.orderNum.setText(String.format("订单号:%s", bean.getSerialId()));
        // 订单状态，-1:已下单；0：已付款；1：已取消；2：已确定接单；3：咨询结束；4：已评价
        holder.orderStatus.setText(OrderStateEnum.getName(bean.getState()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {
        private TextView detail;
        private TextView orderNum;
        private TextView time;
        private TextView orderStatus;
        private TextView method;
        private TextView job;
        private TextView nickname;
        private ImageView head;


        public VH(View itemView) {
            super(itemView);
            detail = itemView.findViewById(R.id.chat);
            orderNum = itemView.findViewById(R.id.orderNum);
            time = itemView.findViewById(R.id.time);
            orderStatus = itemView.findViewById(R.id.orderStatus);
            method = itemView.findViewById(R.id.packge_name);
            job = itemView.findViewById(R.id.job);
            nickname = itemView.findViewById(R.id.nickname);
            head = itemView.findViewById(R.id.head);
        }
    }
}
