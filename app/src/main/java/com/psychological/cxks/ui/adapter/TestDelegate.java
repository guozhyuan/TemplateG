package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.psychological.cxks.bean.TestBean;

/**
 * Author : jugg
 * Date   : 2018/6/28
 */
public class TestDelegate implements AbsAdapterDelegate {
    private Holder holder;
    private Context ctx;

    public TestDelegate(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_chat_text_mine, parent, false);
        Holder holder = new Holder(view);
        this.holder = holder;
        return holder;
    }

    @Override
    public <T, H extends RecyclerView.ViewHolder> void onBindViewHolder(H holder, int position, T t) {
        Holder h = (Holder) holder;
        h.content.setText("哈哈哈哈" + position);
    }


    @Override
    public Holder getHolder() {
        return holder;
    }

    private class Holder extends RecyclerView.ViewHolder {

        private final ImageView avatar;
        private final TextView content;

        private Holder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.mine_avatar);
            content = itemView.findViewById(R.id.mine_content);
        }
    }

}
