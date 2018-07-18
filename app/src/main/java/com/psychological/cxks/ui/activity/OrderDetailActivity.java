package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.psychological.cxks.ui.view.stepview.HorizontalStepView;
import com.psychological.cxks.ui.view.stepview.StepBean;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "OrderDetail";
    private TextView tvEvaluate;
    private HorizontalStepView stepView;

    @Override
    public int setLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    public void findView() {
        tvEvaluate = findViewById(R.id.tv_evaluate);
        stepView = findViewById(R.id.stepview);
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
        tvEvaluate.setOnClickListener(this);
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
