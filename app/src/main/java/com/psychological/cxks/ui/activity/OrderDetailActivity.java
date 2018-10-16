package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.view.stepview.HorizontalStepView;
import com.psychological.cxks.ui.view.stepview.StepBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

public class OrderDetailActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "OrderDetail";
    private TextView tv_evaluate;
    private ImageView back;
    private HorizontalStepView stepView;
    private TextView time;
    private ImageView avater;
    private TextView nick;
    private TextView addr;
    private TextView title;
    private TextView chat;
    private TextView method;
    private TextView tv_book_field;
    private TextView tv_reduce_info;
    private TextView tv_pay;
    private TextView tv_my_name;
    private TextView my_gender;
    private TextView my_addr;
    private TextView my_phone;
    private LinearLayout ll_visitor_info;
    private LinearLayout ll_notice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (App.info != null) {
            tv_my_name.setText(App.info.getUsername());
            my_gender.setText("");
            my_addr.setText("");
            my_phone.setText(App.info.getMobil());
        }

        String serialId = getIntent().getStringExtra("serialId");
        Disposable dis = ApiWrapper.getInstance().queryOrderState(serialId).subscribe(
                ret -> {
                    time.setText(ret.getDealTime());
                    Glide.with(OrderDetailActivity.this).load(ret.getImg()).apply(RequestOptions.circleCropTransform().placeholder(R.mipmap.launcher)).into(avater);
                    nick.setText(ret.getName());
                    addr.setText(ret.getDizhi());
                    title.setText("");
                    // 1—电话咨询，2—见面咨询
                    method.setText(ret.getMethod() == 1 ? "电咨" : "面询");
                    tv_book_field.setText("");
                    tv_reduce_info.setText("");
                    tv_pay.setText("");
                    // 订单状态，-1:已下单；0：已付款；1：已取消；2：已确定接单；3：咨询结束；4：已评价
                    setupStepView(ret.getState());
                },
                err -> {
                    Log.e(TAG, "queryOrderState: err " + err);
                });
        compositeDisposable.add(dis);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    public void findView() {
        stepView = findViewById(R.id.stepview);


        back = findViewById(R.id.back);
        time = findViewById(R.id.time);
        avater = findViewById(R.id.head);
        nick = findViewById(R.id.nick);
        addr = findViewById(R.id.addr);
        title = findViewById(R.id.title);
        chat = findViewById(R.id.chat);

        //
        //咨询方式
        method = findViewById(R.id.method);
        //咨询领域
        tv_book_field = findViewById(R.id.tv_book_field);
        //减免金额
        tv_reduce_info = findViewById(R.id.tv_reduce_info);
        //支付金额
        tv_pay = findViewById(R.id.tv_pay);

        //
        tv_my_name = findViewById(R.id.tv_my_name);
        my_gender = findViewById(R.id.my_gender);
        my_addr = findViewById(R.id.my_addr);
        my_phone = findViewById(R.id.my_phone);

        ll_visitor_info = findViewById(R.id.ll_visitor_info);
        ll_notice = findViewById(R.id.ll_notice);

        //
        TextView tv_question = findViewById(R.id.tv_question);

        //
        TextView tv_track_order_num = findViewById(R.id.tv_track_order_num);              //订单号
        TextView tv_track_order_make_time = findViewById(R.id.tv_track_order_make_time); //下单时间
        TextView tv_track_order_pay_time = findViewById(R.id.tv_track_order_pay_time);   //付款时间
        TextView tv_track_order_confirm_time = findViewById(R.id.tv_track_order_confirm_time);   //确认时间
        TextView tv_track_order_ask_time = findViewById(R.id.tv_track_order_ask_time);   //咨询时间

        //
        tv_evaluate = findViewById(R.id.tv_evaluate);

    }

    private void setupStepView(int state) {
        // 订单状态，-1:已下单；0：已付款；1：已取消；2：已确定接单；3：咨询结束；4：已评价
        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stepBean0 = new StepBean("已下单", -1);
        StepBean stepBean1 = new StepBean("已付款", -1);
        StepBean stepBean2 = new StepBean("待确认", -1);
        StepBean stepBean3 = new StepBean("待咨询", -1);
        StepBean stepBean4 = new StepBean("待评价", -1);
        stepsBeanList.add(stepBean0);
        stepsBeanList.add(stepBean1);
        stepsBeanList.add(stepBean2);
        stepsBeanList.add(stepBean3);
        stepsBeanList.add(stepBean4);
        for (int i = 0; i < stepsBeanList.size(); i++) {
            if (state + 1 >= i) {
                stepsBeanList.get(i).setState(1);
            }
        }
        stepView
                .setStepViewTexts(stepsBeanList)//总步骤
                .setTextSize(16)//set textSize
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(this, R.color.completed_color))//设置StepsViewIndicator完成线的颜色
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(this, R.color.uncompleted_color))//设置StepsViewIndicator未完成线的颜色

                .setStepViewComplectedTextColor(ContextCompat.getColor(this, R.color.completed_text_color))//设置StepsView text完成线的颜色
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(this, R.color.uncompleted_text_color))//设置StepsView text未完成线的颜色

                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(this, R.mipmap.complted))//设置StepsViewIndicator CompleteIcon
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(this, R.mipmap.default_icon))//设置StepsViewIndicator DefaultIcon
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(this, R.mipmap.attention));//设置StepsViewIndicator AttentionIcon
    }

    @Override
    public void initListener() {
        back.setOnClickListener(this);
        chat.setOnClickListener(this);
        ll_visitor_info.setOnClickListener(this);
        ll_notice.setOnClickListener(this);
        tv_evaluate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;

            case R.id.tv_evaluate:
                Log.e(TAG, "onClick: 去评价");
                Intent intent = new Intent(OrderDetailActivity.this, EvaluateActivity.class);
                startActivity(intent);
                break;

            case R.id.chat:

                break;
            case R.id.ll_visitor_info:

                break;
            case R.id.ll_notice:

                break;
        }
    }
}
