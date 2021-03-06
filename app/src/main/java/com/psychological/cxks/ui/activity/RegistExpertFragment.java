package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.fragment.BaseFragment;
import com.psychological.cxks.util.SPUtil;

public class RegistExpertFragment extends BaseFragment {

    private EditText etPhone;
    private EditText etVerify;
    private EditText etPwd;
    private EditText etPwdReapeat;
    private EditText etName;
    private TextView resend;
    private TextView confirm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_regist_expert, null);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etPhone = view.findViewById(R.id.et_phone);
        etVerify = view.findViewById(R.id.et_verify);
        etPwd = view.findViewById(R.id.et_pwd);
        etPwdReapeat = view.findViewById(R.id.et_pwd_reapeat);
        etName = view.findViewById(R.id.et_name);
        resend = view.findViewById(R.id.resend);
        confirm = view.findViewById(R.id.confirm);
        setupListener();

    }


    private CountDownTimer timer = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            resend.setText(String.format("重新发送(%s)", millisUntilFinished / 1000));
        }

        @Override
        public void onFinish() {
            resend.setClickable(true);
            resend.setText("重新发送");
            resend.setSelected(false);
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }

    private void setupListener() {
        resend.setOnClickListener(v -> {
            if (TextUtils.isEmpty(etPhone.getText())) {
                Toast.makeText(getActivity(), "电话不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            timer.start();
            resend.setClickable(false);
            resend.setSelected(true);
            ApiWrapper.getInstance().send(etPhone.getText().toString()).subscribe(c -> {
            });

        });

        confirm.setOnClickListener(v -> {
            if (TextUtils.isEmpty(etPhone.getText())) {
                Toast.makeText(getActivity(), "电话不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(etVerify.getText())) {
                Toast.makeText(getActivity(), "验证码不能为空", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(etPwd.getText())) {
                Toast.makeText(getActivity(), "密码不能为空", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(etPwdReapeat.getText())) {
                Toast.makeText(getActivity(), "重复密码不能为空", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(etName.getText())) {
                Toast.makeText(getActivity(), "姓名不能为空", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!TextUtils.equals(etPwd.getText(), etPwdReapeat.getText())) {
                Toast.makeText(getActivity(), "密码不一致", Toast.LENGTH_SHORT).show();
                return;
            }

            //TODO 接口需要更改
            ApiWrapper.getInstance().rgsAndLog(etPhone.getText().toString(), etVerify.getText().toString()).subscribe(ret -> {
                App.info = ret;
                SPUtil.saveString(getActivity(), "token", ret.getToken());
                SPUtil.saveInt(getActivity(), "type", ret.getType());
                SPUtil.saveString(getActivity(), "mobil", ret.getMobil());
                SPUtil.saveString(getActivity(), "name", ret.getUsername());
                SPUtil.saveString(getActivity(), "userId", ret.getUserId());
                SPUtil.saveString(getActivity(), "img", ret.getImg());

                SPUtil.saveInt(getActivity(), "jg_id", ret.getJiguang().getId());
                SPUtil.saveString(getActivity(), "jg_nickname", ret.getJiguang().getNickname());
                SPUtil.saveString(getActivity(), "jg_password", ret.getJiguang().getPassword());
                SPUtil.saveString(getActivity(), "jg_username", ret.getJiguang().getUsername());
                startActivity(new Intent(getActivity(), EMainActivity.class));
            }, err -> {

            });
        });
    }
}
