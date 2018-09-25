package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.psychological.cxks.App;
import com.psychological.cxks.Constant;
import com.psychological.cxks.R;

import java.util.Collections;
import java.util.List;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.callback.GetUserInfoCallback;
import cn.jpush.im.android.api.content.TextContent;
import cn.jpush.im.android.api.enums.MessageDirect;
import cn.jpush.im.android.api.model.Conversation;
import cn.jpush.im.android.api.model.Message;
import cn.jpush.im.android.api.model.UserInfo;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context ctx;
    private Conversation conv;
    private List<Message> msgs;

    public ChatAdapter(Context ctx, Conversation conv) {
        this.conv = conv;
        this.ctx = ctx;
        msgs = conv.getAllMessage();
        Collections.reverse(msgs);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == Constant.CHAT_TYPE_TEXT_MINE) {
            view = LayoutInflater.from(ctx).inflate(R.layout.item_chat_text_mine, parent, false);
            return new MineVH(view);
        } else {
            view = LayoutInflater.from(ctx).inflate(R.layout.item_chat_text_peer, parent, false);
            return new PeerVH(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message msg = msgs.get(position);
        if (holder instanceof MineVH) {
            if (App.info != null) {
                JMessageClient.getUserInfo(App.info.getUserId(), new GetUserInfoCallback() {
                    @Override
                    public void gotResult(int i, String s, UserInfo userInfo) {
                        String avatarUrl = userInfo.getExtra("avatar");
                        Glide.with(ctx).load(avatarUrl).apply(RequestOptions.circleCropTransform().placeholder(R.mipmap.launcher)).into(((MineVH) holder).mine_avatar);
                    }
                });
            } else {
                Glide.with(ctx).load(R.mipmap.launcher).apply(RequestOptions.circleCropTransform()).into(((MineVH) holder).mine_avatar);
            }
            ((MineVH) holder).mine_content.setText(((TextContent) msg.getContent()).getText());
        } else {
            String avatarUrl = ((UserInfo) conv.getTargetInfo()).getExtra("avatar");
            Glide.with(ctx).load(avatarUrl).apply(RequestOptions.circleCropTransform().placeholder(R.mipmap.launcher)).into(((PeerVH) holder).peer_avatar);
            ((PeerVH) holder).peer_content.setText(((TextContent) msg.getContent()).getText());
        }
    }

    @Override
    public int getItemCount() {
        return msgs.size();
    }

    @Override
    public int getItemViewType(int position) {
        Message msg = msgs.get(position);
        switch (msg.getContentType()) {
            case text:
                return msg.getDirect() == MessageDirect.send ? Constant.CHAT_TYPE_TEXT_MINE : Constant.CHAT_TYPE_TEXT_PEER;
            default:
                return Constant.CHAT_TYPE_TEXT_MINE;
        }
    }

    public void insertMsg(Message msg) {
        msgs.add(0, msg);
    }

    public int msgSize() {
        return msgs.size();
    }


    class MineVH extends RecyclerView.ViewHolder {

        private final ImageView mine_avatar;
        private final TextView mine_content;

        private MineVH(View itemView) {
            super(itemView);
            mine_avatar = itemView.findViewById(R.id.mine_avatar);
            mine_content = itemView.findViewById(R.id.mine_content);
        }
    }

    class PeerVH extends RecyclerView.ViewHolder {

        private final ImageView peer_avatar;
        private final TextView peer_content;

        private PeerVH(View itemView) {
            super(itemView);
            peer_avatar = itemView.findViewById(R.id.peer_avatar);
            peer_content = itemView.findViewById(R.id.peer_content);
        }
    }
}
