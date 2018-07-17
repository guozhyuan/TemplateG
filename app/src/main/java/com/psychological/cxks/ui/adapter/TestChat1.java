package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.psychological.cxks.bean.TestBean;

/**
 * Author : jugg
 * Date   : 2018/6/28
 */
public class TestChat1 implements AbsAdapterDelegate {

    private Context ctx;

    public TestChat1(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(ctx).inflate(R.layout.item_test1, parent, false);
//        return new Holder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, Object o) {
        TestBean bean = (TestBean) o;
    }


    class Holder extends RecyclerView.ViewHolder {

//        private final TextView tv1;

        public Holder(View itemView) {
            super(itemView);
//            tv1 = itemView.findViewById(R.id.tv1);
        }
    }

}
