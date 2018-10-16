package com.psychological.cxks.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.psychological.cxks.R;
import com.psychological.cxks.bean.CouponPackgeBean;
import com.psychological.cxks.bean.param.ModifyCouponParam;

public class EEditPackgeActivity extends BaseActivity {

    private ImageView back;
    private TextView pushlishPackge;
    private LinearLayout editPackge;
    private TextView update;
    private TextView xiajia;
    private CouponPackgeBean couponPackgeBean;
    private ModifyCouponParam param = new ModifyCouponParam();

    private TextView modePhone;
    private TextView modeMeet;
    private EditText etName;
    private EditText etPrice;
    private EditText etCount;
    private EditText etTime;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        modePhone.setSelected(true); // 默认电话
        String action = getIntent().getStringExtra("action");


        if (TextUtils.equals(action, "publish")) {
            pushlishPackge.setVisibility(View.VISIBLE);
            editPackge.setVisibility(View.GONE);
        } else {
            couponPackgeBean = (CouponPackgeBean) getIntent().getSerializableExtra("packge");
            pushlishPackge.setVisibility(View.GONE);
            editPackge.setVisibility(View.VISIBLE);
            etName.setText(couponPackgeBean.getTaocan());
            etPrice.setText(couponPackgeBean.getPrice() + "");
            etCount.setText(couponPackgeBean.getNum() + "");
            etTime.setText("一年");
            switch (couponPackgeBean.getExplain()) {
                case "电询":
                    modePhone.setSelected(true);
                    modeMeet.setSelected(false);
                    break;
                case "面询":
                    modeMeet.setSelected(true);
                    modePhone.setSelected(false);
                    break;
            }
        }
    }


    @Override
    public int setLayoutId() {
        return R.layout.activity_e_edit_packge;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);

        etName = findViewById(R.id.et_name);
        etPrice = findViewById(R.id.et_price);
        etCount = findViewById(R.id.et_count);
        etTime = findViewById(R.id.et_time);
        modePhone = findViewById(R.id.mode_phone);
        modeMeet = findViewById(R.id.mode_meeting);

        pushlishPackge = findViewById(R.id.publish_packge);
        editPackge = findViewById(R.id.edit_packge);
        update = findViewById(R.id.update);
        xiajia = findViewById(R.id.xiajia);


    }

    @Override
    public void initListener() {
        //0：未发布；1：已发布；2：已下架)
        back.setOnClickListener(v -> finish());
        pushlishPackge.setOnClickListener(v -> {

        });

        update.setOnClickListener(v -> {

        });

        xiajia.setOnClickListener(v -> {

        });

        modePhone.setOnClickListener(v -> {
            modeMeet.setSelected(false);
            modePhone.setSelected(true);
        });

        modeMeet.setOnClickListener(v -> {
            modeMeet.setSelected(true);
            modePhone.setSelected(false);
        });

    }
}
