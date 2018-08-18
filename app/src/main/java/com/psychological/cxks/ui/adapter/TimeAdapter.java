package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.psychological.cxks.util.TimeConstants;
import com.psychological.cxks.util.TimeEnum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.VH> {
    private OnTagClick onTagClick;
    private Context ctx;
    private List<String> chosenTags = new ArrayList<>();
    private Date now = new Date();
    private SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault());

    public TimeAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(ctx).inflate(R.layout.item_time, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.date.setText(format.format(now.getTime() + position * TimeConstants.DAY));
        List<String> tagList = new ArrayList<>();
        for (TimeEnum e : TimeEnum.values()) {
            tagList.add(e.getName());
        }
        holder.tags.setTags(tagList);
        holder.tags.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text) {
//                if (chosenTags.contains(text)) {
//                    chosenTags.remove(text);
//                    holder.tags.getTags().get(position).setChosen(false);
//                } else {
//                    chosenTags.add(text);
//                    holder.tags.getTags().get(position).setChosen(true);
//                }
                onTagClick.onTagClick(format.format(now.getTime() + position * TimeConstants.DAY), text);
            }

            @Override
            public void onTagLongClick(int position, String text) {

            }

            @Override
            public void onTagCrossClick(int position) {

            }
        });
    }


    @Override
    public int getItemCount() {
        return 7;
    }

    class VH extends RecyclerView.ViewHolder {

        private final TagContainerLayout tags;
        private final TextView date;

        public VH(View itemView) {
            super(itemView);
            tags = itemView.findViewById(R.id.tagLayout);
            date = itemView.findViewById(R.id.date);
        }
    }

    public void setOnTagClick(OnTagClick onTagClick) {
        this.onTagClick = onTagClick;
    }

    public interface OnTagClick {
        void onTagClick(String day, String time);
    }


}
