package com.psychological.cxks.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.http.Api;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.util.FileUtil;
import com.psychological.cxks.util.GlideEngine;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;

import org.w3c.dom.Text;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.callback.GetUserInfoCallback;
import cn.jpush.im.android.api.model.UserInfo;
import cn.jpush.im.api.BasicCallback;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

public class ProfileActivity extends BaseActivity implements View.OnClickListener {

    private ImageView head;
    private ImageView back;
    private TextView id;
    private final int REQUEST_READ_CONTACTS = 100;
    private final int REQUEST_CODE_CHOSEN = 101;
    private String avatar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_READ_CONTACTS);
        }
        String transAvatar = getIntent().getStringExtra("avatar");
        Glide.with(this).load(transAvatar).apply(RequestOptions.circleCropTransform().placeholder(R.mipmap.launcher)).into(head);
        id.setText(App.info == null ? "" : App.info.getUserId());
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_profile;
    }

    @Override
    public void findView() {
        head = findViewById(R.id.head);
        back = findViewById(R.id.back);
        id = findViewById(R.id.id);

    }

    @Override
    public void initListener() {
        back.setOnClickListener(this);
        head.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                if (!TextUtils.isEmpty(avatar)) {
                    Intent i = new Intent();
                    i.putExtra("avatar", avatar);
                    setResult(RESULT_OK, i);
                }
                finish();
                break;

            case R.id.head:
                Matisse.from(ProfileActivity.this)
//                        .choose(MimeType.of(MimeType.JPEG, MimeType.PNG))
                        .choose(MimeType.of(MimeType.PNG))
                        .countable(true)
                        .maxSelectable(1)
//                        .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
//                        .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f)
                        .imageEngine(new GlideEngine())
                        .forResult(REQUEST_CODE_CHOSEN);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOSEN && resultCode == RESULT_OK) {
            if (data == null) return;
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
                            // 1
//                            RequestBody body = new MultipartBody.Builder()
//                                    .setType(MultipartBody.FORM)
//                                    .addFormDataPart("moduleid", "1")
//                                    .addFormDataPart("oldImg", "1")
//                                    .addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("image/png"), file))
//                                    .build();
//                            Disposable dis = ApiWrapper.getInstance().uploadFile(body).subscribe(ret -> {
//
//                            }, err -> {
//
//                            });
//                            compositeDisposable.add(dis);

                            // 2
//                            Map<String, RequestBody> map = new HashMap<>();
//                            map.put("moduleid", RequestBody.create(MediaType.parse("text/plain"), "1"));
//                            map.put("oldImg", RequestBody.create(MediaType.parse("text/plain"), "1"));
////                            map.put("name=\"avatar\"; filename=" + file.getName(), RequestBody.create(MediaType.parse("image/*"), file));
//                            RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
//                            MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
//                            Disposable d = ApiWrapper.getInstance().uploadFile2(map, part).subscribe(ret -> {
//
//                            }, err -> {
//
//                            });
//                            compositeDisposable.add(d);

                            // 3
                            RequestBody moduleid = RequestBody.create(MediaType.parse("text/plain"), "1");
                            RequestBody oldImg = RequestBody.create(MediaType.parse("text/plain"), "1");
                            RequestBody img = RequestBody.create(MediaType.parse("image/png"), file);
                            MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), img);
                            Disposable d = ApiWrapper.getInstance().uploadFile3(moduleid, oldImg, part).subscribe(ret -> {
                                avatar = ret;
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

                            }, err -> {

                            });
                            compositeDisposable.add(d);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    }).launch();
        }
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
}
