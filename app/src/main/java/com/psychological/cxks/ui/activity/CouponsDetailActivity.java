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

import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
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
        name.setText(tranBean.getId() + "");
        price.setText(tranBean.getPrice() + "");
        num.setText(tranBean.getNum() + "");
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_coupons_detail;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        name = findViewById(R.id.packge_name);
        price = findViewById(R.id.price);
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
            param.nick = App.info.getName();
            param.body = tranBean.getTaocan();
            param.price = tranBean.getPrice();
            param.isPay = 0;
            ApiWrapper.getInstance().addAllOrder(param).flatMap((Function<Object, ObservableSource<Boolean>>) orderId -> {
                BuyPackgeParam param1 = new BuyPackgeParam();
                param1.consultId = consultId;
                param1.orderId = orderId.toString();
                param1.userId = App.info.getUserId();
                param1.username = App.info.getName();
                param1.packageId = tranBean.getId();
                param1.state = 0;
                // 2.购买套餐
                return ApiWrapper.getInstance().buyPackge(param1);
            }).subscribe(boo -> {
                // 3.发起付款
            }, err -> {
                Toast.makeText(this, "未知错误", Toast.LENGTH_SHORT).show();
            });
        });
    }


}
