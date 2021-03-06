package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.CouponPackgeBean;
import com.psychological.cxks.bean.param.AddAllOrderParam;
import com.psychological.cxks.bean.param.BuyPackgeParam;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.http.HttpScheduler;
import com.psychological.cxks.http.HttpX;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class CouponsDetailActivity extends BaseActivity {

    private ImageView back;
    private TextView name;
    private TextView price;
    private TextView num;
    private TextView method;
    private TextView valid;
    private TextView buy;
    private String consultId;
    private CouponPackgeBean tranBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tranBean = (CouponPackgeBean) getIntent().getSerializableExtra("taocan");
        consultId = getIntent().getStringExtra("consultId");
        name.setText(tranBean.getTaocan());
        method.setText(tranBean.getExplain());
        price.setText(tranBean.getPrice() + "");
        num.setText(tranBean.getNum() + "");
        valid.setText("一年");
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_coupons_detail;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        name = findViewById(R.id.packge_name);
        price = findViewById(R.id.time);
        num = findViewById(R.id.num);
        method = findViewById(R.id.method);
        valid = findViewById(R.id.valid);
        buy = findViewById(R.id.buy);


    }

    @Override
    public void initListener() {
        back.setOnClickListener(v -> {
            finish();
        });

        buy.setOnClickListener(v -> {
            if (App.info == null) {
                startActivity(new Intent(this, LoginActivity.class));
                return;
            }
            // 1.添加总订单
            AddAllOrderParam param = new AddAllOrderParam();
            param.mobile = App.info.getMobil();
            param.nick = App.info.getUsername();
            param.body = tranBean.getTaocan();
            param.price = tranBean.getPrice();
            param.isPay = 0;

            Map<String, Object> addAllOrderMap = new HashMap<>();
            addAllOrderMap.put("mobile", param.mobile == null ? "" : param.mobile);
            addAllOrderMap.put("nick", param.nick == null ? "" : param.nick);
            addAllOrderMap.put("body", param.body == null ? "" : param.body);
            addAllOrderMap.put("price", param.price);
            addAllOrderMap.put("isPay", 0);
            ApiWrapper.getInstance().addAllOrder2(addAllOrderMap).flatMap((Function<String, ObservableSource<Boolean>>) orderId -> {
                BuyPackgeParam param1 = new BuyPackgeParam();
                param1.consultId = consultId;
                param1.orderId = orderId;
                param1.userId = App.info.getUserId();
                param1.username = App.info.getUsername();
                param1.packageId = tranBean.getId();
                param1.state = 0;

                Map<String, Object> buyMap = new HashMap<>();
                buyMap.put("consultId", consultId);
                buyMap.put("orderId", orderId);
                buyMap.put("userId", App.info.getUserId());
                buyMap.put("username", App.info.getUsername());
                buyMap.put("packageId", tranBean.getId());
                buyMap.put("state", 0);

                // 2.购买套餐
//                return ApiWrapper.getInstance().buyPackge(param1);
                return ApiWrapper.getInstance().buyPackge2(buyMap);
            }).subscribe(boo -> {
                // 3.发起付款
//                WXSDKHelper.getInstance().wxPay();
            }, err -> {
                Toast.makeText(this, "未知错误", Toast.LENGTH_SHORT).show();
            });
        });
    }

    private Map<String, Object> bean2map(AddAllOrderParam param) {
        Map<String, Object> map = new HashMap<>();
        map.put("mobile", param.mobile);
        map.put("nick", param.mobile);
        map.put("body", param.body);
        map.put("price", param.price);
        map.put("isPay", param.isPay);
        return map;

    }


}
