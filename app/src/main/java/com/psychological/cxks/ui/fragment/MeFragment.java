package com.psychological.cxks.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.psychological.cxks.App;
import com.psychological.cxks.R;
import com.psychological.cxks.ui.activity.ChangePWDActivity;
import com.psychological.cxks.ui.activity.CouponsListActivity;
import com.psychological.cxks.ui.activity.FavoriteActivity;
import com.psychological.cxks.ui.activity.LoginActivity;
import com.psychological.cxks.ui.activity.OrderListActivity;
import com.psychological.cxks.ui.activity.ProfileActivity;
import com.psychological.cxks.ui.activity.VisitorInfoActivity;
import com.psychological.cxks.util.SPUtil;

import java.util.Objects;

/**
 * Author : jugg
 * Date   : 2018/6/26
 */
public class MeFragment extends BaseFragment implements View.OnClickListener {
    private int REQ_AVATAR = 1000;

    private LinearLayout order;
    private LinearLayout favorite;
    private LinearLayout coupons;
    private LinearLayout resetpwd;
    private LinearLayout visitor;
    private Button logout;
    private TextView profile;
    private ImageView avatar;
    private TextView username;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_me, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        profile = view.findViewById(R.id.profile);
        order = view.findViewById(R.id.ll_order);
        favorite = view.findViewById(R.id.ll_favorite);
        coupons = view.findViewById(R.id.coupons);
        resetpwd = view.findViewById(R.id.resetpwd);
        visitor = view.findViewById(R.id.visitor);
        logout = view.findViewById(R.id.logout);
        username = view.findViewById(R.id.username);
        avatar = view.findViewById(R.id.avatar);
        order.setOnClickListener(this);
        favorite.setOnClickListener(this);
        coupons.setOnClickListener(this);
        resetpwd.setOnClickListener(this);
        visitor.setOnClickListener(this);
        logout.setOnClickListener(this);
        profile.setOnClickListener(this);

        if (App.info != null) {
            username.setText(App.info.getUsername());
            Glide.with(Objects.requireNonNull(getActivity())).load(App.info.getImg()).apply(RequestOptions.circleCropTransform().placeholder(R.mipmap.launcher)).into(avatar);
        } else {
            Glide.with(Objects.requireNonNull(getActivity())).load(R.mipmap.launcher).apply(RequestOptions.circleCropTransform()).into(avatar);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.profile:
                Intent profileIntent = new Intent(getActivity(), ProfileActivity.class);
                profileIntent.putExtra("avatar", App.info == null ? null : App.info.getImg());
                startActivityForResult(profileIntent, REQ_AVATAR);
                break;
            case R.id.ll_order:
                startActivity(new Intent(getActivity(), OrderListActivity.class));
                break;
            case R.id.ll_favorite:
                startActivity(new Intent(getActivity(), FavoriteActivity.class));
                break;
            case R.id.coupons:
                startActivity(new Intent(getActivity(), CouponsListActivity.class));
                break;
            case R.id.resetpwd:
                startActivity(new Intent(getActivity(), ChangePWDActivity.class));
                break;
            case R.id.visitor:
                startActivity(new Intent(getActivity(), VisitorInfoActivity.class));
                break;

            case R.id.logout:
                App.info = null;
                SPUtil.clean(getActivity());
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                getActivity().finish();
                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_AVATAR && data != null) {
            String ret = data.getStringExtra("avatar");
            if (!TextUtils.isEmpty(ret)) {
                Glide.with(Objects.requireNonNull(getActivity())).load(ret).apply(RequestOptions.circleCropTransform()).into(avatar);
            }
        }
    }
}
