package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.psychological.cxks.Constant;

import cn.jpush.im.android.api.model.Conversation;

/**
 * Author : jugg
 * Date   : 2018/6/28
 */
public class TestAdapter extends RecyclerView.Adapter {
    private AbsAdapterDelegateMgr mgr;
    private Conversation conv;

    public TestAdapter(Context ctx, Conversation conv) {
        this.conv = conv;
        TestDelegate textChatDelegate = new TestDelegate(ctx);
        mgr = new AbsAdapterDelegateMgr.Builder()
                .regist(Constant.CHAT_TYPE_TEXT_MINE, textChatDelegate, textChatDelegate.getHolder())
                .build();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mgr.routing(viewType).onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AbsAdapterDelegate routing = mgr.routing(holder.getItemViewType());
        routing.onBindViewHolder(routing.getHolder(), position, null);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        return Constant.CHAT_TYPE_TEXT_MINE;
    }

}
