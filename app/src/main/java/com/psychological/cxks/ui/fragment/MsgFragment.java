package com.psychological.cxks.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psychological.cxks.R;
import com.psychological.cxks.ui.adapter.MsgAdapter;
import com.psychological.cxks.util.DeviceUtils;

import java.lang.ref.WeakReference;
import java.util.List;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.enums.ConversationType;
import cn.jpush.im.android.api.event.MessageEvent;
import cn.jpush.im.android.api.event.OfflineMessageEvent;
import cn.jpush.im.android.api.model.Conversation;
import cn.jpush.im.android.api.model.Message;
import cn.jpush.im.android.api.model.UserInfo;

/**
 * Author : jugg
 * Date   : 2018/6/26
 */
public class MsgFragment extends BaseFragment {

    private List<Conversation> conversationList;
    private RecyclerView recyclerView;
    private MsgAdapter adapter;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            if (adapter != null) {
                switch (msg.what) {
                    case 1:
                        adapter.notifyDataSetChanged();
                        break;
                }
            }
        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_msg, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler);
        initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void initData() {
        conversationList = JMessageClient.getConversationList();
        initView();
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.top = DeviceUtils.dip2px(getActivity(), 5);
            }
        });

        adapter = new MsgAdapter(getActivity(), conversationList);
        recyclerView.setAdapter(adapter);

    }

    public void onEvent(MessageEvent event) {
        Message message = event.getMessage();
        // 单人回话类型
        if (message.getTargetType() == ConversationType.single) {
            switch (message.getContentType()) {
                case text:
                    UserInfo userInfo = (UserInfo) message.getTargetInfo();
                    String userName = userInfo.getUserName();
                    Conversation singleConversation = JMessageClient.getSingleConversation(userName);
                    if (singleConversation == null) {
                        singleConversation = Conversation.createSingleConversation(userName);
                        adapter.insertConv(singleConversation);
                    } else {
                        // adapter.updateTargetConv(conversation);
                        // recyclerView.findViewHolderForAdapterPosition(conversationList.indexOf(singleConversation));
                        handler.sendEmptyMessage(1);
                    }

            }
        }
    }


    // 离线消息
    public void onEvent(OfflineMessageEvent offlineEvent) {
        Conversation conversation = offlineEvent.getConversation();
        if (conversation.getType().equals(ConversationType.single)) {
            if (conversationList.indexOf(conversation) != 0) {
                handler.sendEmptyMessage(1);
            } else {
                adapter.insertConv(conversation);
            }
        }
    }


}
