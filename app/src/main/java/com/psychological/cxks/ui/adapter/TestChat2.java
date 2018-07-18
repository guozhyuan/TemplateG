package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author : jugg
 * Date   : 2018/6/28
 */
public class TestChat2 implements AbsAdapterDelegate {

    private Context ctx;

    public TestChat2(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(ctx).inflate(R.layout.item_test2, parent, false);
//        return new Holder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, Object o) {

    }


    class Holder extends RecyclerView.ViewHolder {

//        private final TextView tv2;

        public Holder(View itemView) {
            super(itemView);
//            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
}
