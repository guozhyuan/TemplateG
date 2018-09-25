package com.psychological.cxks.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.bean.JsonBean;
import com.psychological.cxks.bean.param.EProfileParam;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.util.GlideEngine;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.callback.GetUserInfoCallback;
import cn.jpush.im.android.api.model.UserInfo;
import cn.jpush.im.api.BasicCallback;
import io.reactivex.disposables.Disposable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

public class EMyInfoActivity extends BaseActivity implements View.OnClickListener {


    private ImageView back;
    private ImageView head;
    private EditText name;
    private EditText rank;
    private RadioButton male;
    private RadioButton female;
    private EditText time;
    //
    private TextView addr;
    private LinearLayout ll_address;
    private RelativeLayout rl_cyzz; //从业资质
    //
    private SwitchCompat chat;
    private SwitchCompat voice;
    private SwitchCompat meet;
    //
    private TextView save;
    private TextView preview;
    private TextView submit;

    private final int REQUEST_READ_CONTACTS = 100;
    private final int REQUEST_CODE_AVATAR = 101;

    private EProfileParam param = new EProfileParam();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_READ_CONTACTS);
        }
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_e_my_info;
    }

    @Override
    public void findView() {
        back = findViewById(R.id.back);
        head = findViewById(R.id.head);
        name = findViewById(R.id.name);
        rank = findViewById(R.id.rank);
        male = findViewById(R.id.radio_male);
        female = findViewById(R.id.radio_female);
        time = findViewById(R.id.time);

        //
        addr = findViewById(R.id.addr);
        ll_address = findViewById(R.id.ll_address);
        rl_cyzz = findViewById(R.id.rl_cyzz);

        //
        chat = findViewById(R.id.chat);
        voice = findViewById(R.id.voice);
        meet = findViewById(R.id.meet);

        //
        save = findViewById(R.id.save);
        preview = findViewById(R.id.preview);
        submit = findViewById(R.id.submit);
    }

    @Override
    public void initListener() {
        back.setOnClickListener(this);
        head.setOnClickListener(this);
        ll_address.setOnClickListener(this);
        save.setOnClickListener(this);
        preview.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.head:
                Matisse.from(EMyInfoActivity.this)
                        .choose(MimeType.of(MimeType.PNG))
                        .countable(true)
                        .maxSelectable(1)
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f)
                        .imageEngine(new GlideEngine())
                        .forResult(REQUEST_CODE_AVATAR);
                break;
            case R.id.ll_address:
                showPicker();
                break;

            case R.id.save:

                break;
            case R.id.preview:

                break;
            case R.id.submit:

                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) return;
        switch (requestCode) {
            case REQUEST_CODE_AVATAR:
                handleImg(data, true);
                break;

        }
    }

    private void handleImg(Intent data, boolean isAvatar) {
        List<String> strings = Matisse.obtainPathResult(data);
        Glide.with(this).load(strings.get(0)).apply(RequestOptions.circleCropTransform()).into(head);
        Luban.with(this)
                .load(strings.get(0))
                .ignoreBy(100)
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(File file) {
                        RequestBody moduleid = RequestBody.create(MediaType.parse("text/plain"), "1");
                        RequestBody oldImg = RequestBody.create(MediaType.parse("text/plain"), "1");
                        RequestBody img = RequestBody.create(MediaType.parse("image/png"), file);
                        MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), img);
                        Disposable d = ApiWrapper.getInstance().uploadFile3(moduleid, oldImg, part).subscribe(ret -> {
                            param.img = ret;
                            if (isAvatar) {
                                JMessageClient.getUserInfo(App.info.getJiguang().getUsername(), new GetUserInfoCallback() {
                                    @Override
                                    public void gotResult(int i, String s, UserInfo userInfo) {
                                        userInfo.setUserExtras("avatar", ret);
                                        JMessageClient.updateMyInfo(UserInfo.Field.extras, userInfo, new BasicCallback() {
                                            @Override
                                            public void gotResult(int i, String s) {
                                                Log.e("updateMyInfo", "Success");
                                            }
                                        });
                                    }
                                });
                            }
                        }, err -> {

                        });
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                }).launch();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_READ_CONTACTS:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    finish();
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
                                    options2Items.get(options1).get(options2) +
                                    options3Items.get(options1).get(options2).get(options3);
                            String provinceStr = options1Items.get(options1).getPickerViewText();
                            String cityStr = options2Items.get(options1).get(options2);
                            addr.setText(String.format("%s  %s", provinceStr, cityStr));
                            param.addr = String.format("%s  %s", provinceStr, cityStr);
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
}
