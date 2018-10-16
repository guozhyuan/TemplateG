package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.psychological.cxks.App;
import com.psychological.cxks.Constant;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.ExpertDetailBean;
import com.psychological.cxks.bean.ExpertDetailBean2;
import com.psychological.cxks.bean.JsonBean;
import com.psychological.cxks.bean.param.AddAllOrderParam;
import com.psychological.cxks.bean.param.DisCodePayParam;
import com.psychological.cxks.bean.param.FreeCodePayParam;
import com.psychological.cxks.bean.param.LockParam;
import com.psychological.cxks.bean.param.PhoneCodePayParam;
import com.psychological.cxks.bean.param.ReservationParam;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.util.CSLevelEnum;
import com.psychological.cxks.util.CSTypeEnum;
import com.psychological.cxks.util.CategoryEnum;
import com.psychological.cxks.util.TimeEnum;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class ReservationActivity extends BaseActivity implements View.OnClickListener {
    private int RESERVATION_MODE = 0;
    private static final int REQ_CODE_TIME = 0;
    private static final int REQ_CODE_DISCOUNTS = 1;
    private static final int REQ_CODE_PRICE = 2;
    private static final int REQ_CODE_CITY = 3;
    private ExpertDetailBean2.ExpertBean transData; //传递的咨询师信息
    private ArrayList<String> chosenTags;
    private ReservationParam param = new ReservationParam();
    private String chosenTag;
    private int lastPos = -1;
    private String resultTime;
    private String resultDay;
    private String resultCoupon;  // 选择的优惠码
    private int resultPayType;   // 选择优惠码后对应的支付类型
    private int resultDiscount;  // 输入优惠码的折扣
//    private String orderId;       // 订单号


    private ImageView back;
    private ImageView head;
    private TextView nick;
    private TextView jobTitle;
    private TextView reservation_time; // 预约时间
    private TextView discounts;         // 选择优惠
    private TextView price;              // 价格
    private TextView mode_meeting;      // 咨询方式:会面
    private TextView mode_phone;        // 咨询方式:电话
    private TextView mode_message;      // 咨询方式:文字
    private EditText real_name;
    private TextView city;
    private EditText phone;
    private EditText feedback;
    private TagContainerLayout tagLayout;
    private TextView feedbackLen;
    private TextView submit;
    private CheckBox checkBox;

    private TextWatcher textWatcher = new TextWatcher() {
        private CharSequence content;

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            content = s;
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (content.length() > 300) return;
            feedbackLen.setText(String.format("%s/300", content.length()));
        }
    };
    private RadioButton btnMan;
    private RadioButton btnWoman;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        transData = (ExpertDetailBean2.ExpertBean) getIntent().getSerializableExtra("expert");
        chosenTags = new ArrayList<>();
        ArrayList<String> tagList = new ArrayList<>();
        for (CategoryEnum e : CategoryEnum.values()) {
            tagList.add(e.getName());
        }
        tagLayout.setTags(tagList);
        Glide.with(this).load(transData.getImg()).apply(RequestOptions.circleCropTransform()).into(head);
        nick.setText(transData.getName());
        jobTitle.setText(transData.getRank() + "");
        mode_phone.setSelected(true);
        price.setText(transData.getPhone() + "");
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_reservation;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        head = findViewById(R.id.head);
        nick = findViewById(R.id.nick);
        jobTitle = findViewById(R.id.jobTitle);
        reservation_time = findViewById(R.id.reservation_time);
        discounts = findViewById(R.id.discounts);
        price = findViewById(R.id.time);
        mode_meeting = findViewById(R.id.mode_meeting);
        mode_phone = findViewById(R.id.mode_phone);
        mode_message = findViewById(R.id.mode_message);
        btnMan = findViewById(R.id.btnMan);
        btnWoman = findViewById(R.id.btnWoman);

        real_name = findViewById(R.id.real_name);
        city = findViewById(R.id.city);
        phone = findViewById(R.id.phone);
        tagLayout = findViewById(R.id.tagLayout);
        feedback = findViewById(R.id.feedback);
        feedbackLen = findViewById(R.id.descLength);
        submit = findViewById(R.id.submit);
        checkBox = findViewById(R.id.checkBox);
    }

    @Override
    public void initListener() {
        mode_meeting.setOnClickListener(this);
        mode_phone.setOnClickListener(this);
        mode_message.setOnClickListener(this);
        back.setOnClickListener(this);
        reservation_time.setOnClickListener(this);
        discounts.setOnClickListener(this);
        price.setOnClickListener(this);
        city.setOnClickListener(this);
        submit.setOnClickListener(this);
        feedback.addTextChangedListener(textWatcher);
        tagLayout.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text) {
                if (TextUtils.equals(text, chosenTag)) {
                    chosenTag = "";
                    tagLayout.getTags().get(position).setChosen(ContextCompat.getColor(ReservationActivity.this, R.color.main_bottom_text_release),
                            ContextCompat.getColor(ReservationActivity.this, R.color.stroke_gray));
                } else {
                    if (lastPos != -1) {
                        tagLayout.getTags().get(lastPos).setChosen(ContextCompat.getColor(ReservationActivity.this, R.color.main_bottom_text_release),
                                ContextCompat.getColor(ReservationActivity.this, R.color.stroke_gray));
                    }
                    chosenTag = text;
                    tagLayout.getTags().get(position).setChosen(ContextCompat.getColor(ReservationActivity.this, R.color.main_bottom_text_press),
                            ContextCompat.getColor(ReservationActivity.this, R.color.main_bottom_text_press));
                }
                lastPos = position;
            }

            @Override
            public void onTagLongClick(int position, String text) {

            }

            @Override
            public void onTagCrossClick(int position) {

            }
        });

    }


    @Override
    public void onClick(View v) {
        Intent intent;
        Bundle bundle;
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.time:

                break;
            case R.id.discounts:
                intent = new Intent(this, ChooseCouponsActivity.class);
                startActivityForResult(intent, REQ_CODE_DISCOUNTS);
                break;
            case R.id.reservation_time:
                intent = new Intent(this, ReservationTimeActivity.class);
                intent.putExtra("id", transData.getUserId());
                startActivityForResult(intent, REQ_CODE_TIME);
                break;
            case R.id.city:
                showPicker();
                break;

            case R.id.submit:
                // 1、首先调用下总订单接口 addAllOrder
                // 2、再调用预约咨询师接口 reservation，通知调用锁定和解锁时间段接口 lockTime
                // 3、如果是用APP支付(包括折扣优惠码)，支付完后不用调用任何接口(满足APP的短生命周期的要求)，我这边再回调接口解决后续问题；
                //    如果是使用免费优惠码支付(不走APP支付)，需要调用3.2.5.7 查询订单状态(/wxPay/appPayState)
                if (!checkBox.isChecked()) return;
                if (App.info == null) {
                    startActivity(new Intent(this, LoginActivity.class));
                    return;
                }
                AddAllOrderParam addAllOrderParam = new AddAllOrderParam();
                addAllOrderParam.mobile = App.info.getMobil();
                addAllOrderParam.nick = App.info.getUsername();
                addAllOrderParam.body = CSLevelEnum.getName(transData.getCsLevel()) + "-" + CSTypeEnum.getName(transData.getCsType());
                if (mode_phone.isSelected()) {
                    addAllOrderParam.price = transData.getPhone();
                } else if (mode_phone.isSelected()) {
                    addAllOrderParam.price = transData.getMeet();
                }
                addAllOrderParam.isPay = 0; // TODO isPay????

                Map<String, Object> addAllOrderMap = new HashMap<>();
                addAllOrderMap.put("mobile", addAllOrderParam.mobile == null ? "" : addAllOrderParam.mobile);
                addAllOrderMap.put("nick", addAllOrderParam.nick == null ? "" : addAllOrderParam.nick);
                addAllOrderMap.put("body", addAllOrderParam.body == null ? "" : addAllOrderParam.body);
                addAllOrderMap.put("price", addAllOrderParam.price);
                addAllOrderMap.put("isPay", 0);
                ApiWrapper.getInstance().addAllOrder2(addAllOrderMap)
                        .subscribe(
                                orderId -> {   // orderId:  订单号
                                    reservate(orderId);
                                },
                                err -> {
                                    Log.e("ApiWrapper", "addAllOrder2: err" + err);
                                }
                        );
                break;
            case R.id.mode_message:
                mode_message.setSelected(true);
                mode_phone.setSelected(false);
                mode_meeting.setSelected(false);
                break;
            case R.id.mode_phone:
                mode_message.setSelected(false);
                mode_phone.setSelected(true);
                mode_meeting.setSelected(false);
                price.setText(transData.getPhone() + "");
                break;
            case R.id.mode_meeting:
                mode_message.setSelected(false);
                mode_phone.setSelected(false);
                mode_meeting.setSelected(true);
                price.setText(transData.getMeet() + "");
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQ_CODE_DISCOUNTS:
                    resultPayType = data.getIntExtra(Constant.PAY_KEY, 0);
                    switch (resultPayType) {
                        case Constant.PAY_TYPE_DIRECT:
                            resultCoupon = "";
                            if (mode_phone.isSelected()) {
                                price.setText(String.valueOf(transData.getPhone()));
                            } else if (mode_meeting.isSelected()) {
                                price.setText(String.valueOf(transData.getMeet()));
                            }
                            break;
                        case Constant.PAY_TYPE_INPUT_FREE:
                            resultCoupon = data.getStringExtra("coupon");
                            price.setText("免费");
                            break;
                        case Constant.PAY_TYPE_INPUT_DISCOUNT:
                            resultCoupon = data.getStringExtra("coupon");
                            resultDiscount = data.getIntExtra("discount", 0);
                            if (mode_phone.isSelected()) {
                                price.setText(String.valueOf(transData.getPhone() * 8 / 10));
                            } else if (mode_meeting.isSelected()) {
                                price.setText(String.valueOf(transData.getMeet() * 8 / 10));
                            }
                            break;
                        case Constant.PAY_TYPE_CODE:
                            resultCoupon = data.getStringExtra("coupon");
                            price.setText("免费");
                            break;
                        case Constant.PAY_TYPE_PACKGE:
                            resultCoupon = data.getStringExtra("coupon");
                            price.setText("免费");
                            break;
                    }
                    break;
                case REQ_CODE_TIME:
                    resultTime = data.getStringExtra("time");
                    resultDay = param.day = data.getStringExtra("day");
                    param.time = TimeEnum.getIndex(data.getStringExtra("time"));
                    reservation_time.setText(resultDay + resultTime);
                    break;
            }
        }
    }


    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();

    private void showPicker() {
        try {
            InputStream is = getAssets().open("province.json");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] bs = new byte[1024];
            while ((len = is.read(bs)) != -1) {
                bos.write(bs, 0, len);
            }
            String ret = new String(bos.toByteArray(), "UTF-8");
            ArrayList<JsonBean> jsonBean = new ArrayList<>();
            JSONArray data = new JSONArray(ret);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                jsonBean.add(entity);
            }
            options1Items = jsonBean;
            for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
                ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
                ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）
                for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                    String CityName = jsonBean.get(i).getCityList().get(c).getName();
                    CityList.add(CityName);//添加城市
                    ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表
                    //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                    if (jsonBean.get(i).getCityList().get(c).getArea() == null
                            || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                        City_AreaList.add("");
                    } else {
                        City_AreaList.addAll(jsonBean.get(i).getCityList().get(c).getArea());
                    }
                    Province_AreaList.add(City_AreaList);//添加该省所有地区数据
                }
                //添加城市数据
                options2Items.add(CityList);
                //添加地区数据
                options3Items.add(Province_AreaList);
            }

            OptionsPickerView pvOptions = new OptionsPickerBuilder(this,
                    new OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int options2, int options3, View v) {
                            //返回的分别是三个级别的选中位置
                            String tx = options1Items.get(options1).getPickerViewText() +
                                    options2Items.get(options1).get(options2);
                            // + options3Items.get(options1).get(options2).get(options3);
                            city.setText(tx);
                            param.addr = tx;
                        }
                    })
                    .setTitleText("城市选择")
                    .setDividerColor(Color.TRANSPARENT)
                    .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                    .setContentTextSize(18)
                    .build();

            // pvOptions.setPicker(options1Items);//一级选择器
            pvOptions.setPicker(options1Items, options2Items);//二级选择器
//            pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
            pvOptions.show();

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }


    }

    private Map<String, String> bean2map(DisCodePayParam param) {
        Map<String, String> map = new HashMap<>();
        map.put("amount", param.amount + "");
        map.put("title", param.title);
        map.put("orderId", param.orderId);
        map.put("count", param.count + "");
        map.put("ip", param.ip);
        return map;
    }

    /**
     * 预约 & 咨询师订单金额分成 & 锁定时间
     */
    private void reservate(String orderId) {
        param.userId = App.info.getUserId();
        param.orderId = orderId;
        param.csId = transData.getUserId();
        //(1-电询；2-面询；3-文字)
        param.method = mode_phone.isSelected() ? 1 : mode_meeting.isSelected() ? 2 : mode_message.isSelected() ? 3 : -1;
        if (param.method == -1) {
            Toast.makeText(ReservationActivity.this, "咨方式未选择", Toast.LENGTH_SHORT).show();
            return;
        }
        // 状态，-1:已下单；0：已付款(已预约)；1：已取消；2：已确定接单；3：咨询结束；4：已评价
        param.state = -1;
        if (TextUtils.isEmpty(chosenTag)) {
            Toast.makeText(ReservationActivity.this, "咨询分类未选择", Toast.LENGTH_SHORT).show();
            return;
        }
        param.field = CategoryEnum.getIndex(chosenTag);
        param.money = Double.parseDouble(price.getText().toString());
        param.name = real_name.getText().toString();
        // 1：男，2：女
        param.sex = btnMan.isChecked() ? 1 : btnWoman.isChecked() ? 2 : -1;
        param.mobile = phone.getText().toString();
        param.need = feedback.getText().toString();
        if (TextUtils.isEmpty(param.day) | param.time == 0) {
            Toast.makeText(this, "时间未选择", Toast.LENGTH_SHORT).show();
            return;
        }

        Map<String, Object> reservateMap = new HashMap<>();
        reservateMap.put("userId", param.userId == null ? "" : param.userId);
        reservateMap.put("orderId", param.orderId == null ? "" : param.orderId);
        reservateMap.put("csId", param.csId == null ? "" : param.csId);
        reservateMap.put("method", param.method);
        reservateMap.put("state", param.state);
        reservateMap.put("field", param.field);
        reservateMap.put("money", param.money);
        reservateMap.put("name", param.name == null ? "" : param.name);
        reservateMap.put("sex", param.sex);
        reservateMap.put("addr", param.addr == null ? "" : param.addr);
        reservateMap.put("mobile", param.mobile == null ? "" : param.mobile);
        reservateMap.put("time", param.time);
        reservateMap.put("day", param.day == null ? "" : param.day);
        reservateMap.put("remark", "");
        // 预约
        Disposable disposable = ApiWrapper.getInstance().reservation2(reservateMap)
                // 锁定时间
//                .flatMap(new Function<String, ObservableSource<Boolean>>() {
//                    @Override
//                    public ObservableSource<Boolean> apply(String serialId) throws Exception { // serialId 流水号
//                        LockParam lockParam = new LockParam();
//                        lockParam.userId = transData.getUserId();
//                        lockParam.day = resultDay;
//                        lockParam.time = TimeEnum.getIndex(resultTime);
//                        Map<String, Object> lockMap = new HashMap<>();
//                        lockMap.put("userId", lockParam.userId == null ? "" : lockParam.userId);
//                        lockMap.put("day", lockParam.day == null ? "" : lockParam.day);
//                        lockMap.put("time", lockParam.time);
//                        return ApiWrapper.getInstance().lockTime2(lockMap);
//                    }
//                })
                .subscribe(serialId -> {
                            LockParam lockParam = new LockParam();
                            lockParam.userId = transData.getUserId();
                            lockParam.day = resultDay;
                            lockParam.time = TimeEnum.getIndex(resultTime);
                            Map<String, Object> lockMap = new HashMap<>();
                            lockMap.put("userId", lockParam.userId == null ? "" : lockParam.userId);
                            lockMap.put("day", lockParam.day == null ? "" : lockParam.day);
                            lockMap.put("time", lockParam.time);
                            ApiWrapper.getInstance().lockTime2(lockMap).subscribe(lockRet -> {
                                        if (lockRet) {
                                            switch (resultPayType) {
                                                // TODO 支付问题
                                                case Constant.PAY_TYPE_DEFAULT:
                                                case Constant.PAY_TYPE_DIRECT:
                                                    // 3.2.5.1 APP支付(折扣优惠码支付)(/wxPay/appPay)
                                                    DisCodePayParam disCodePayParam = new DisCodePayParam();
                                                    if (mode_phone.isSelected()) {
                                                        disCodePayParam.amount = transData.getPhone();
                                                    } else if (mode_phone.isSelected()) {
                                                        disCodePayParam.amount = transData.getMeet();
                                                    }
                                                    disCodePayParam.title = CSLevelEnum.getName(transData.getCsLevel()) + "-" + CSTypeEnum.getName(transData.getCsType());
                                                    disCodePayParam.orderId = orderId;
                                                    disCodePayParam.count = 1;
                                                    disCodePayParam.ip = "127.0.0.1";
                                                    Map<String, Object> payMap = new HashMap<>();
                                                    payMap.put("amount", disCodePayParam.amount);
                                                    payMap.put("title", disCodePayParam.title);
                                                    payMap.put("orderId", disCodePayParam.orderId);
                                                    payMap.put("count", disCodePayParam.count);
                                                    payMap.put("ip", disCodePayParam.ip);
                                                    ApiWrapper.getInstance().discountCodePay2(bean2map(disCodePayParam)).subscribe(
                                                            prepayIdSign -> {
                                                                // 发起支付
//                                                      WXSDKHelper.getInstance().wxPay();
                                                            },
                                                            err -> {

                                                            }
                                                    );
                                                    break;
                                                case Constant.PAY_TYPE_INPUT_FREE:
                                                    // 3.2.5.3 免费优惠码支付(/mc/discountPay)
                                                    FreeCodePayParam freeCodePayParam = new FreeCodePayParam();
                                                    freeCodePayParam.discountCode = resultCoupon;
                                                    freeCodePayParam.userId = transData.getUserId();  // 咨询师id
                                                    ApiWrapper.getInstance().freeCodePay(freeCodePayParam).subscribe(
                                                            freePayRet -> {
                                                                // reservate();
                                                            },
                                                            err -> {

                                                            }
                                                    );
                                                    break;
                                                case Constant.PAY_TYPE_INPUT_DISCOUNT:
                                                    // 3.2.5.1 APP支付(折扣优惠码支付)(/wxPay/appPay)
                                                    DisCodePayParam disCodePayParam2 = new DisCodePayParam();
                                                    if (mode_phone.isSelected()) {
                                                        disCodePayParam2.amount = transData.getPhone();
                                                    } else if (mode_phone.isSelected()) {
                                                        disCodePayParam2.amount = transData.getMeet();
                                                    }
                                                    disCodePayParam2.title = CSLevelEnum.getName(transData.getCsLevel()) + "-" + CSTypeEnum.getName(transData.getCsType());
                                                    disCodePayParam2.orderId = orderId;
                                                    disCodePayParam2.count = 1;
                                                    disCodePayParam2.ip = "127.0.0.1";
                                                    disCodePayParam2.discount = String.valueOf(resultDiscount);
                                                    disCodePayParam2.userId = String.valueOf(resultDiscount);

                                                    Map<String, Object> payMap2 = new HashMap<>();
                                                    payMap2.put("amount", disCodePayParam2.amount);
                                                    payMap2.put("title", disCodePayParam2.title);
                                                    payMap2.put("orderId", disCodePayParam2.orderId);
                                                    payMap2.put("count", disCodePayParam2.count);
                                                    payMap2.put("ip", disCodePayParam2.ip);
                                                    payMap2.put("discount", disCodePayParam2.discount);
                                                    payMap2.put("userId", disCodePayParam2.userId);
                                                    ApiWrapper.getInstance().discountCodePay(disCodePayParam2).subscribe(
                                                            prepayIdSign -> {
                                                                // 发起支付
//                                                WXSDKHelper.getInstance().wxPay();
                                                            },
                                                            err -> {

                                                            }
                                                    );
                                                    break;
                                                case Constant.PAY_TYPE_CODE:
                                                    // 3.2.5.4 心理顾问套餐优惠码支付(/mc/mcPay)
                                                    ApiWrapper.getInstance().couponPackgePay(resultCoupon, App.info.getUserId(), (int) (mode_phone.isSelected() ? transData.getPhone() : transData.getMeet())).subscribe(
                                                            mcPay -> {
                                                                // reservate();
                                                            }, err -> {
                                                            }
                                                    );
                                                    break;
                                                case Constant.PAY_TYPE_PACKGE:
                                                    // 3.2.5.5 电询、面询优惠码支付(/mc/couponPay)
                                                    PhoneCodePayParam phoneCodePayParam = new PhoneCodePayParam();
                                                    phoneCodePayParam.coupon = resultCoupon;
                                                    phoneCodePayParam.operator = App.info.getUserId();
                                                    phoneCodePayParam.only = transData.getOnly();
                                                    phoneCodePayParam.type = transData.getCsType();
                                                    ApiWrapper.getInstance().phoneCodePay(phoneCodePayParam).subscribe(
                                                            couponPay -> {
                                                                // reservate();
                                                            },
                                                            err -> {

                                                            }
                                                    );
                                                    break;
                                            }
                                        } else {
                                            Log.e("ApiWrapper", "lockTime: failed");
                                        }
                                    },
                                    err -> {
                                        Log.e("ApiWrapper", "lockTime: err" + err);
                                    });


                        },
                        err -> {
                            Log.e("ApiWrapper", "reservation2: err" + err);
                        }
                );
    }
}
