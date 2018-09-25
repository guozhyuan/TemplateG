package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.param.AddVisitorInfoParam;
import com.psychological.cxks.http.ApiWrapper;

import io.reactivex.disposables.Disposable;

public class VisitorInfoActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "VisitorInfoActivity";
    private RadioGroup genderGroup;
    private RadioGroup vipGroup;
    private ImageView back;
    private EditText realName;
    private EditText age;
    private EditText national;
    private EditText present_address;
    private TextView marital_status;
    private EditText job;
    private EditText education;
    private EditText native_place;
    private EditText postal_address;
    private EditText phone;
    private EditText pressing_address;
    private EditText pressing_phone;
    //
    private EditText family_status;
    private EditText question;
    private EditText present_status;
    private EditText history;
    private EditText special;
    //
    private TextView submit;
    private CheckBox checkBox;
    private TextView channel;
    private AddVisitorInfoParam param = new AddVisitorInfoParam();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        param.gender = "男";
        param.isVip = "是";
        param.marriage = "已婚";
        param.source = "官网";
        param.userId = App.info.getUserId();
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_visitor_info;
    }

    @Override
    public void findView() {
        genderGroup = findViewById(R.id.radioGroup_gender);
        vipGroup = findViewById(R.id.radioGroup_vip);
        back = findViewById(R.id.back);
        realName = findViewById(R.id.real_name);
        age = findViewById(R.id.age);
        national = findViewById(R.id.national);
        present_address = findViewById(R.id.present_address);
        marital_status = findViewById(R.id.marital_status);
        job = findViewById(R.id.job);
        education = findViewById(R.id.education);
        native_place = findViewById(R.id.native_place);
        postal_address = findViewById(R.id.postal_address);
        phone = findViewById(R.id.phone);
        pressing_address = findViewById(R.id.pressing_address);
        pressing_phone = findViewById(R.id.pressing_phone);

        //
        family_status = findViewById(R.id.family_status);
        question = findViewById(R.id.question);
        present_status = findViewById(R.id.present_status);
        history = findViewById(R.id.history);
        special = findViewById(R.id.special);

        //

        checkBox = findViewById(R.id.checkBox);
        submit = findViewById(R.id.submit);
        channel = findViewById(R.id.channel);
    }


    @Override
    public void initListener() {
        submit.setOnClickListener(this);
        marital_status.setOnClickListener(this);
        channel.setOnClickListener(this);
        genderGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.radio_male:
                    param.gender = "男";
                    Log.e(TAG, "genderGroup checke: radio_male");
                    break;

                case R.id.radio_female:
                    Log.e(TAG, "genderGroup checke: radio_female");
                    param.gender = "女";
                    break;
            }
        });
        vipGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.yes:
                    param.isVip = "是";
                    Log.e(TAG, "vipGroup checke: yes");
                    break;

                case R.id.no:
                    param.isVip = "否";
                    Log.e(TAG, "vipGroup checke: no");
                    break;
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;

            case R.id.marital_status:
                //婚姻状态弹窗
                showMaritalStatus();
                break;
            case R.id.channel:
                //渠道
                showChannel();
                break;
            case R.id.submit:
                if (App.info == null) {
                    startActivity(new Intent(VisitorInfoActivity.this, LoginActivity.class));
                    return;
                }
                if (checkBox.isChecked() && !TextUtils.isEmpty(realName.getText())) {
                    param.name = realName.getText().toString();
                    param.age = TextUtils.isEmpty(age.getText()) ? null : Integer.parseInt(age.getText().toString());
                    param.nation = national.getText().toString();
                    param.addr = present_address.getText().toString();
                    param.marriage = marital_status.getText().toString();
                    param.occupation = job.getText().toString();
                    param.education = education.getText().toString();
                    param.origin = native_place.getText().toString();
                    param.postalAddress = postal_address.getText().toString();
                    param.mobile = phone.getText().toString();
                    param.urgent = pressing_address.getText().toString();
                    param.urgentPhone = pressing_phone.getText().toString();
                    param.family = family_status.getText().toString();
                    param.problem = question.getText().toString();
                    // TODO special
                    param.event = present_status.getText().toString();
                    param.history = history.getText().toString();
                    param.source = channel.getText().toString();
                    Disposable disposable = ApiWrapper.getInstance().addVisitorInfo(param).subscribe(ret -> {
                        Log.e(TAG, "addVisitorInfo ret: " + ret);
                        Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
                    }, err -> {

                    });
                    compositeDisposable.add(disposable);
                }
                break;
        }
    }

    private void showMaritalStatus() {
        View view = LayoutInflater.from(this).inflate(R.layout.view_marital_status, null);
        TextView tv_status1 = view.findViewById(R.id.tv_status1);
        TextView tv_status2 = view.findViewById(R.id.tv_status2);
        TextView tv_status3 = view.findViewById(R.id.tv_status3);
        TextView tv_status4 = view.findViewById(R.id.tv_status4);
        TextView tv_status5 = view.findViewById(R.id.tv_status5);
        TextView tv_status6 = view.findViewById(R.id.tv_status6);

        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(marital_status, marital_status.getMeasuredWidth(), 0);
//                int[] location = new int[2];
//                marital_status.getLocationOnScreen(location);
//                popupWindow.showAtLocation(marital_status, Gravity.NO_GRAVITY, location[0] + popupWindow.getWidth(), location[1] - popupWindow.getHeight());
        tv_status1.setOnClickListener(tv1 -> {
            marital_status.setText("已婚");
            popupWindow.dismiss();
        });
        tv_status2.setOnClickListener(tv1 -> {
            marital_status.setText("未婚");
            popupWindow.dismiss();
        });
        tv_status3.setOnClickListener(tv1 -> {
            marital_status.setText("离异");
            popupWindow.dismiss();
        });
        tv_status4.setOnClickListener(tv1 -> {
            marital_status.setText("丧偶");
            popupWindow.dismiss();
        });
        tv_status5.setOnClickListener(tv1 -> {
            marital_status.setText("单身");
            popupWindow.dismiss();
        });
        tv_status6.setOnClickListener(tv1 -> {
            marital_status.setText("同居");
            popupWindow.dismiss();
        });
    }

    private void showChannel() {
        View channle = LayoutInflater.from(this).inflate(R.layout.view_know_channel, null);
        PopupWindow pop = new PopupWindow(channle, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        pop.setOutsideTouchable(true);
        pop.setFocusable(true);
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.showAsDropDown(channel, channel.getMeasuredWidth(), 0);
        TextView tv_status1 = channle.findViewById(R.id.tv_status1);
        TextView tv_status2 = channle.findViewById(R.id.tv_status2);
        TextView tv_status3 = channle.findViewById(R.id.tv_status3);
        TextView tv_status4 = channle.findViewById(R.id.tv_status4);
        TextView tv_status5 = channle.findViewById(R.id.tv_status5);
        tv_status1.setOnClickListener(tv1 -> {
            channel.setText("其他");
            pop.dismiss();
        });
        tv_status2.setOnClickListener(tv1 -> {
            channel.setText("朋友介绍");
            pop.dismiss();
        });
        tv_status3.setOnClickListener(tv1 -> {
            channel.setText("自媒体");
            pop.dismiss();
        });
        tv_status4.setOnClickListener(tv1 -> {
            channel.setText("公众号");
            pop.dismiss();
        });
        tv_status5.setOnClickListener(tv1 -> {
            channel.setText("官网");
            pop.dismiss();
        });
    }

}
