package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.psychological.cxks.R;

import com.psychological.cxks.bean.ExpertBean;
import com.psychological.cxks.ui.adapter.OnSalePackgeAdapter;

import java.util.ArrayList;
import java.util.Objects;

import co.lujun.androidtagview.TagContainerLayout;

public class ExpertDetailActivity extends BaseActivity implements View.OnClickListener {

    private TextView peer_name;//对方的名字
    private ImageView back;
    private TextView message;
    private TextView talk;
    private TextView order;
    private TextView needMore;
    private ImageView head;
    private TextView nick;
    private TextView jobTitle;
    private TextView jobTime;
    private TagContainerLayout tagLayout;
    private ImageView imgBig;
    private TextView introduction;
    private RecyclerView recyclerPackge;
    private ImageView consumerHead;
    private TextView consumerNick;
    private TextView consumerEvaluate;


    private ExpertBean.ResultBean transData; //传递的咨询师信息


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        transData = (ExpertBean.ResultBean) getIntent().getSerializableExtra("expert");


        ArrayList<String> tagList = new ArrayList<>();
        tagList.add("非常专业");
        tagList.add("有耐心");
        tagList.add("态度很好啊");
        tagList.add("巴拉巴拉");
        tagList.add("非常");
        tagList.add("专业");
        tagLayout.setTags(tagList);

        peer_name.setText(Objects.requireNonNull(transData).getName());
        nick.setText(Objects.requireNonNull(transData).getName());
        Glide.with(this).load(Objects.requireNonNull(transData).getImg()).apply(RequestOptions.circleCropTransform()).into(head);

        OnSalePackgeAdapter onSalePackgeAdapter = new OnSalePackgeAdapter(this);
        recyclerPackge.setLayoutManager(new LinearLayoutManager(this));
        recyclerPackge.setAdapter(onSalePackgeAdapter);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_expert;
    }

    @Override
    public void findView() {
        peer_name = findViewById(R.id.peer_name);
        back = findViewById(R.id.back);
        message = findViewById(R.id.message);
        talk = findViewById(R.id.talk);
        order = findViewById(R.id.order);
        needMore = findViewById(R.id.need_more);

        head = findViewById(R.id.head);
        nick = findViewById(R.id.nick);
        jobTitle = findViewById(R.id.jobTitle);
        jobTime = findViewById(R.id.jobTime);
        tagLayout = findViewById(R.id.tagLayout);
        imgBig = findViewById(R.id.img_big);
        introduction = findViewById(R.id.introduction);
        recyclerPackge = findViewById(R.id.recycler_packge);

        consumerHead = findViewById(R.id.consumer_head);
        consumerNick = findViewById(R.id.consumer_nick);
        consumerEvaluate = findViewById(R.id.consumer_evaluate);

    }

    @Override
    public void initListener() {
        back.setOnClickListener(this);
        message.setOnClickListener(this);
        talk.setOnClickListener(this);
        order.setOnClickListener(this);
        needMore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.message:

                break;
            case R.id.talk:

                break;

            case R.id.order:
                Intent intent = new Intent(ExpertDetailActivity.this, ReservationActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("expert", transData);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.need_more:
                startActivity(new Intent(ExpertDetailActivity.this, ConsumerEvaluateActivity.class));
                break;
        }
    }
}
