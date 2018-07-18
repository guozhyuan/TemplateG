package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.google.gson.Gson;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.JsonBean;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;

public class ReservationActivity extends BaseActivity implements View.OnClickListener {
    private int RESERVATION_MODE = 0;
    private static final int REQ_CODE_TIME = 0;
    private static final int REQ_CODE_DISCOUNTS = 1;
    private static final int REQ_CODE_PRICE = 2;
    private static final int REQ_CODE_CITY = 3;
    private ArrayList<String> chosenTags;


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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chosenTags = new ArrayList<>();
        ArrayList<String> tagList = new ArrayList<>();
        tagList.add("非常专业");
        tagList.add("有耐心");
        tagList.add("态度很好啊");
        tagList.add("巴拉巴拉");
        tagList.add("非常");
        tagList.add("专业");
        tagLayout.setTags(tagList);
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
        price = findViewById(R.id.price);
        mode_meeting = findViewById(R.id.mode_meeting);
        mode_phone = findViewById(R.id.mode_phone);
        mode_message = findViewById(R.id.mode_message);
        real_name = findViewById(R.id.real_name);
        city = findViewById(R.id.city);
        phone = findViewById(R.id.phone);
        tagLayout = findViewById(R.id.tagLayout);
        feedback = findViewById(R.id.feedback);
        feedbackLen = findViewById(R.id.descLength);
        submit = findViewById(R.id.submit);
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
                if (chosenTags.contains(text)) {
                    chosenTags.remove(text);
                    tagLayout.getTags().get(position).setChosen(ContextCompat.getColor(ReservationActivity.this, R.color.main_bottom_text_release),
                            ContextCompat.getColor(ReservationActivity.this, R.color.stroke_gray));
                } else {
                    chosenTags.add(text);
                    tagLayout.getTags().get(position).setChosen(ContextCompat.getColor(ReservationActivity.this, R.color.main_bottom_text_press),
                            ContextCompat.getColor(ReservationActivity.this, R.color.main_bottom_text_press));
                }
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
            case R.id.price:
                break;
            case R.id.discounts:
                intent = new Intent(this, ChooseCouponsActivity.class);
                //对象必须实现Serializable
                bundle = new Bundle();
                bundle.putSerializable("", "");
                startActivityForResult(intent, REQ_CODE_DISCOUNTS);
                break;
            case R.id.reservation_time:
                intent = new Intent(this, ReservationTimeActivity.class);
                //对象必须实现Serializable
                bundle = new Bundle();
                bundle.putSerializable("", "");
                startActivityForResult(intent, REQ_CODE_TIME);
                break;
            case R.id.city:
                showPicker();
                break;
            case R.id.submit:
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
                break;
            case R.id.mode_meeting:
                mode_message.setSelected(false);
                mode_phone.setSelected(false);
                mode_meeting.setSelected(true);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
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

            OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
                @Override
                public void onOptionsSelect(int options1, int options2, int options3, View v) {
                    //返回的分别是三个级别的选中位置
                    String tx = options1Items.get(options1).getPickerViewText() +
                            options2Items.get(options1).get(options2) +
                            options3Items.get(options1).get(options2).get(options3);

//                    Toast.makeText(ReservationActivity.this, tx, Toast.LENGTH_SHORT).show();
                    city.setText(tx);
                }
            })

                    .setTitleText("城市选择")
                    .setDividerColor(Color.BLACK)
                    .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                    .setContentTextSize(18)
                    .build();

            // pvOptions.setPicker(options1Items);//一级选择器
//            pvOptions.setPicker(options1Items, options2Items);//二级选择器
            pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
            pvOptions.show();

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }


    }

}