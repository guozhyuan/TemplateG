package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.psychological.cxks.App;
import com.psychological.cxks.Constant;
import com.psychological.cxks.R;

import com.psychological.cxks.bean.MyCouponAssembleBean;
import com.psychological.cxks.bean.MyCouponCodeBean;
import com.psychological.cxks.bean.MyCouponPackgeBean;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.adapter.ChooseCouponsAdapter;
import com.psychological.cxks.util.DeviceUtils;
import com.psychological.cxks.util.SPUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

public class ChooseCouponsActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "ChooseCouponsActivity";


    private ImageView back;
    private CheckBox other;
    private CheckBox none;
    private TextView confirm;
    private EditText input;


    private RecyclerView recyclerView;
    private ChooseCouponsAdapter adapter;
    private List<MyCouponAssembleBean> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAllCoupnList();
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_choose_coupons;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        other = findViewById(R.id.other);
        none = findViewById(R.id.none);
        confirm = findViewById(R.id.confirm);
        input = findViewById(R.id.et_input);


        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                if (parent.getChildAdapterPosition(view) != 0) {
                    outRect.top = DeviceUtils.dip2px(ChooseCouponsActivity.this, 5);
                } else {
                    outRect.top = 0;
                }
            }
        });
        adapter = new ChooseCouponsAdapter(this, list);
        adapter.setOnItemCheck(() -> {
            if (other.isChecked()) {
                other.setChecked(false);
            }
            if (none.isChecked()) {
                none.setChecked(false);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initListener() {
        back.setOnClickListener(this);
        confirm.setOnClickListener(this);
        other.setOnCheckedChangeListener((checkBox, isChecked) -> {
            if (isChecked) {
                none.setChecked(false);
                adapter.unCheckAll();
                adapter.notifyDataSetChanged();
            }
        });
        none.setOnCheckedChangeListener((checkBox, isChecked) -> {
            if (isChecked) {
                other.setChecked(false);
                adapter.unCheckAll();
                adapter.notifyDataSetChanged();
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;

            case R.id.confirm:

                if (other.isChecked()) {
                    if (TextUtils.isEmpty(input.getText().toString())) {
                        Toast.makeText(this, "请输入优惠码", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String inputCode = input.getText().toString();
                    // 查询优惠码信息
                    Disposable disposable = ApiWrapper.getInstance().couponInfo(inputCode).subscribe(
                            ret -> {
                                int dis = Integer.parseInt(ret);
                                if (dis == 0) {  // 手选免费 3.2.5.3 免费优惠码支付(/mc/discountPay)  discountCode优惠码  userId咨询师id
                                    Intent intent = new Intent();
                                    intent.putExtra(Constant.PAY_KEY, Constant.PAY_TYPE_INPUT_FREE);
                                    intent.putExtra("coupon", inputCode);
                                    setResult(RESULT_OK, intent);
                                    finish();
                                } else {        // 手选折扣  3.2.5.1 APP支付(折扣优惠码支付)(/wxPay/appPay)
                                    Intent intent = new Intent();
                                    intent.putExtra(Constant.PAY_KEY, Constant.PAY_TYPE_INPUT_DISCOUNT);
                                    intent.putExtra("coupon", inputCode);
                                    intent.putExtra("discount", dis);
                                    setResult(RESULT_OK, intent);
                                    finish();
                                }
                            },
                            err -> {
                                Toast.makeText(this, "优惠码不可用", Toast.LENGTH_SHORT).show();
                            }
                    );
                } else if (none.isChecked()) {
                    // 3.2.5.1 APP支付(折扣优惠码支付)(/wxPay/appPay)
                    Intent intent = new Intent();
                    intent.putExtra(Constant.PAY_KEY, Constant.PAY_TYPE_DIRECT);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    for (MyCouponAssembleBean bean : list) {
                        if (bean.isChecked()) {
                            // 免费优惠码预约,不需要支付
                            if (bean.getCouponType() == Constant.COUPON_TYPE_CODE) {
                                // 3.2.5.4 心理顾问套餐优惠码支付(/mc/mcPay)  coupon优惠码 operator用户id title套餐价格
                                Intent intent = new Intent();
                                intent.putExtra(Constant.PAY_KEY, Constant.PAY_TYPE_CODE);
                                intent.putExtra("coupon", bean.getCoupon());
                                setResult(RESULT_OK, intent);
                                finish();
                            } else if (bean.getCouponType() == Constant.COUPON_TYPE_PACKGE) {
                                // 3.2.5.5 电询、面询优惠码支付(/mc/couponPay)
                                //    coupon	√	string	9	优惠码
                                //    operator	√	string	30	用户id(使用人id)
                                //    only	√	int		咨询师365标记(用于判断咨询师是否是365咨询师)
                                //    type	√	int		咨询方式(判断优惠类型是否与咨询方式一致)
                                Intent intent = new Intent();
                                intent.putExtra(Constant.PAY_KEY, Constant.PAY_TYPE_PACKGE);
                                intent.putExtra("coupon", bean.getCoupon());
                                setResult(RESULT_OK, intent);
                                finish();
                            }
                        }
                    }
                }
                break;
        }
    }

    private void getAllCoupnList() {
        if (App.info == null) {
            Toast.makeText(this, "请登录", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
        }
        String userId = SPUtil.getString(this, "userId");
        Disposable disposable = ApiWrapper.getInstance().getAllCouponList(userId).subscribe(re -> {
            List<MyCouponAssembleBean> assemble = assembleCoupon(re.getCc(), re.getPc());
            list.clear();
            list.addAll(assemble);
            adapter.notifyDataSetChanged();
        }, err -> {
            Log.e(TAG, "getAllCoupnList: failed");
        });
        compositeDisposable.add(disposable);
    }

    private List<MyCouponAssembleBean> assembleCoupon(List<MyCouponCodeBean> codeList, List<MyCouponPackgeBean> packgeList) {
        List<MyCouponAssembleBean> list = new ArrayList<>();
        for (MyCouponCodeBean codeBean : codeList) {
            MyCouponAssembleBean bean = new MyCouponAssembleBean();
            bean.setCouponType(Constant.COUPON_TYPE_CODE);
            bean.setCoupon(codeBean.getCoupon());
            bean.setId(codeBean.getId());
            bean.setType(codeBean.getType());
            bean.setOrderId(codeBean.getOrderId());
            bean.setChecked(codeBean.isChecked());
            list.add(bean);
        }

        for (MyCouponPackgeBean b : packgeList) {
            MyCouponAssembleBean bean = new MyCouponAssembleBean();
            bean.setConsultId(b.getConsultId());
            bean.setId(b.getId());
            bean.setCoupon(b.getCoupon());
            bean.setCouponState(b.getCouponState());
            bean.setTime(b.getTime());
            bean.setObtainId(b.getObtainId());
            bean.setObtainName(b.getObtainName());
            bean.setUseId(b.getUseId());
            bean.setUseTime(b.getUseTime());
            bean.setPackageId(b.getPackageId());
            bean.setName(b.getName());
            bean.setContent(b.getContent());
            bean.setChecked(b.isChecked());
            bean.setCouponType(Constant.COUPON_TYPE_PACKGE);
            list.add(bean);
        }
        return list;
    }
}
