package com.psychological.cxks.ui.activity;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.psychological.cxks.ui.adapter.ChatAdapter;
import com.psychological.cxks.ui.adapter.MsgAdapter;
import com.psychological.cxks.ui.fragment.MsgFragment;
import com.psychological.cxks.util.DeviceUtils;
import com.psychological.cxks.util.KeyboardUtil;

import java.lang.ref.WeakReference;
import java.util.List;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.content.TextContent;
import cn.jpush.im.android.api.enums.ContentType;
import cn.jpush.im.android.api.enums.ConversationType;
import cn.jpush.im.android.api.event.MessageEvent;
import cn.jpush.im.android.api.event.OfflineMessageEvent;
import cn.jpush.im.android.api.model.Conversation;
import cn.jpush.im.android.api.model.Message;
import cn.jpush.im.android.api.model.UserInfo;

public class ChatActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "ChatActivity";
    private String userid;

    private ImageView back;
    private TextView peer;
    private EditText input;
    private TextView send;
    private RecyclerView recycler;
    private ChatAdapter adapter;
    private Conversation conv;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            if (adapter != null) {
                switch (msg.what) {
                    case 1:
                        adapter.notifyItemInserted(0);
                        recycler.scrollToPosition(0);
                        break;
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userid = getIntent().getStringExtra("peer");

        conv = JMessageClient.getSingleConversation(userid);
        if (conv == null) {
            conv = Conversation.createSingleConversation(userid);
        }
        UserInfo targetInfo = (UserInfo) conv.getTargetInfo();
        peer.setText(targetInfo.getNickname());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        recycler.setLayoutManager(layoutManager);
        recycler.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.top = DeviceUtils.dip2px(ChatActivity.this, 5);
            }
        });
        adapter = new ChatAdapter(this, conv);
        recycler.setAdapter(adapter);

    }

    // 在线消息
    public void onEvent(MessageEvent event) {
        Message message = event.getMessage();
        // 单人回话类型
        if (message.getTargetType() == ConversationType.single) {
            switch (message.getContentType()) {
                case text:
                    UserInfo userInfo = (UserInfo) message.getTargetInfo();
                    String userName = userInfo.getUserName();
                    if (TextUtils.equals(userName, userid)) {
                        adapter.insertMsg(message);
                        handler.sendEmptyMessage(1);
                        break;
                    }
            }
        }
    }

    // 离线消息
    public void onEvent(OfflineMessageEvent offlineEvent) {
        Conversation conversation = offlineEvent.getConversation();
        if (conversation.getType().equals(ConversationType.single)) {
            List<Message> list = offlineEvent.getOfflineMessageList();
            for (Message msg : list) {
                if (msg.getContentType().equals(ContentType.text)) {
                    adapter.insertMsg(msg);
                    handler.sendEmptyMessage(1);
                }
            }
        }
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_chat;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        peer = findViewById(R.id.peer_name);
        input = findViewById(R.id.input);
        send = findViewById(R.id.send);
        recycler = findViewById(R.id.recycler);

    }

    @Override
    public void initListener() {
        back.setOnClickListener(this);
        send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.send:
                String mcgContent = input.getText().toString();
                if (mcgContent.equals("")) {
                    return;
                }
                TextContent content = new TextContent(mcgContent);
                Message msg = conv.createSendMessage(content);
                adapter.insertMsg(msg);
                input.setText("");
                handler.sendEmptyMessage(1);
                JMessageClient.sendMessage(msg);
                break;
        }
    }


}
