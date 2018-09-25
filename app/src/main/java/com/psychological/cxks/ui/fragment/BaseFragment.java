package com.psychological.cxks.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.event.LoginStateChangeEvent;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Author : jugg
 * Date   : 2018/6/25
 */
public class BaseFragment extends Fragment {
    public CompositeDisposable compositeDisposable;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JMessageClient.registerEventReceiver(this);
        compositeDisposable = new CompositeDisposable();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        JMessageClient.unRegisterEventReceiver(this);
        compositeDisposable.dispose();
    }


    public void onEventMainThread(LoginStateChangeEvent event) {
        Log.e("BaseFragment", "LoginStateChangeEvent changed ");
    }
}
