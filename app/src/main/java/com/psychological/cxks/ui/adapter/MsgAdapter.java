package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.psychological.cxks.R;
import com.psychological.cxks.ui.activity.ChatActivity;
import com.psychological.cxks.util.TimeUtils;

import java.util.List;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.content.TextContent;
import cn.jpush.im.android.api.model.Conversation;
import cn.jpush.im.android.api.model.Message;
import cn.jpush.im.android.api.model.UserInfo;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.VH> {

    private Context ctx;
    private List<Conversation> list;

    public MsgAdapter(Context ctx, List<Conversation> list) {
        this.ctx = ctx;
        this.list = list;
    }


    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_msg_list, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Conversation conv = list.get(position);
        holder.name.setText(conv.getTitle());
        Message message = conv.getLatestMessage();
        if (message != null) {
            String avatarUrl = ((UserInfo) conv.getTargetInfo()).getExtra("avatar");
            Glide.with(ctx).load(avatarUrl).apply(RequestOptions.circleCropTransform().placeholder(R.mipmap.launcher)).into(holder.avatar);
            holder.msg.setText(((TextContent) message.getContent()).getText());
            holder.time.setText(TimeUtils.getFriendlyTimeSpanByNow(conv.getLatestMessage().getCreateTime()));
        }
        holder.root.setOnClickListener((v -> {
            UserInfo targetInfo = (UserInfo) conv.getTargetInfo();
            String peer = targetInfo.getUserName();
            Intent intent = new Intent(ctx, ChatActivity.class);
            intent.putExtra("peer", peer);
            ctx.startActivity(intent);

        }));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void insertConv(Conversation conv) {
        list.add(conv);
        notifyDataSetChanged();
    }


    class VH extends RecyclerView.ViewHolder {

        private final ImageView avatar;
        private final TextView name;
        private final TextView msg;
        private final TextView time;
        private final ConstraintLayout root;

        public VH(View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.root);
            avatar = itemView.findViewById(R.id.head);
            name = itemView.findViewById(R.id.name);
            msg = itemView.findViewById(R.id.msg);
            time = itemView.findViewById(R.id.time);
        }
    }
}
