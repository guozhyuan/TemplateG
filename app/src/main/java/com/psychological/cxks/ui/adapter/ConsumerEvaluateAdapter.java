package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hedgehog.ratingbar.RatingBar;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.EvaluateBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.lujun.androidtagview.TagContainerLayout;

public class ConsumerEvaluateAdapter extends RecyclerView.Adapter<ConsumerEvaluateAdapter.VH> {
    private Context context;
    private List<EvaluateBean> list;

    public ConsumerEvaluateAdapter(Context context, List<EvaluateBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_consumer_evaluate, parent, false);
        return new VH(view);

    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        EvaluateBean bean = list.get(position);
        Glide.with(context).load(bean.getImg()).into(holder.head);
        holder.nick.setText(bean.getConsultName());
        holder.content.setText(bean.getContent());
        holder.time.setText(bean.getTime());
        if (bean.getLabel() != null) {
            ArrayList<String> tagList = new ArrayList<>(Arrays.asList(bean.getLabel().split("\\s+")));
            holder.tags.setTags(tagList);
        }
        holder.bar.setStar(bean.getLevel());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {

        private final ImageView head;
        private final TextView nick;
        private final TextView content;
        private final TagContainerLayout tags;
        private final TextView time;
        private final RatingBar bar;

        public VH(View itemView) {
            super(itemView);
            head = itemView.findViewById(R.id.consumer_head);
            nick = itemView.findViewById(R.id.consumer_nick);
            content = itemView.findViewById(R.id.consumer_evaluate);
            tags = itemView.findViewById(R.id.tagLayout);
            time = itemView.findViewById(R.id.time);
            bar = itemView.findViewById(R.id.ratingbar);
            bar.setmClickable(false);
        }
    }
}
