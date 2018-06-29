package com.guo.projectg.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.guo.projectg.bean.TestBean;

import java.util.List;

/**
 * Author : jugg
 * Date   : 2018/6/28
 */
public class ChatAdapter extends RecyclerView.Adapter {
    private AbsAdapterDelegateMgr mgr;
    private List<TestBean> list;

    public ChatAdapter(Context ctx, List<TestBean> list) {
        this.list = list;
        mgr = new AbsAdapterDelegateMgr.Builder()
                .regist(1, new TestChat1(ctx))
                .regist(2, new TestChat2(ctx))
                .build();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mgr.routing(viewType).onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AbsAdapterDelegate routing = mgr.routing(holder.getItemViewType());
        TestBean testBean = list.get(position);
        routing.onBindViewHolder(holder, position, testBean);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? 1 : 2;
    }

    public static enum ViewType {
        TYPE_1(TestChat1.class.getSimpleName()),
        TYPE_2(TestChat2.class.getSimpleName());

        private String value;

        private ViewType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
