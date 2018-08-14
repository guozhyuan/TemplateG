package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
    private HorizontalStepView stepView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String serialId = getIntent().getStringExtra("serialId");
//        Disposable dis = ApiWrapper.getInstance().orderDetail(serialId).subscribe(ret -> {
//
//        });
//        compositeDisposable.add(dis);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    public void findView() {
        stepView = findViewById(R.id.stepview);
        setupStepView();

        TextView time = findViewById(R.id.time);
        ImageView head = findViewById(R.id.head);
        TextView nick = findViewById(R.id.nick);
        TextView addr = findViewById(R.id.addr);
        TextView title = findViewById(R.id.title);
        TextView chat = findViewById(R.id.chat);

        //
        TextView method = findViewById(R.id.method);                 //咨询方式
        TextView tv_book_field = findViewById(R.id.tv_book_field);  //咨询领域
        TextView tv_reduce_info = findViewById(R.id.tv_reduce_info);//减免金额
        TextView tv_pay = findViewById(R.id.tv_pay);                 //支付金额

        //
        TextView tv_my_name = findViewById(R.id.tv_my_name);
        TextView my_gender = findViewById(R.id.my_gender);
        TextView my_addr = findViewById(R.id.my_addr);
        TextView my_phone = findViewById(R.id.my_phone);

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

    private void setupStepView() {
        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stepBean0 = new StepBean("已下单", 1);
        StepBean stepBean1 = new StepBean("已付款", 1);
        StepBean stepBean2 = new StepBean("待确认", 1);
        StepBean stepBean3 = new StepBean("待咨询", -1);
        StepBean stepBean4 = new StepBean("待评价", -1);
        stepsBeanList.add(stepBean0);
        stepsBeanList.add(stepBean1);
        stepsBeanList.add(stepBean2);
        stepsBeanList.add(stepBean3);
        stepsBeanList.add(stepBean4);

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
        tv_evaluate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_evaluate:
                Log.e(TAG, "onClick: 去评价");
                startActivity(new Intent(OrderDetailActivity.this, EvaluateActivity.class));
                break;
        }
    }
}
