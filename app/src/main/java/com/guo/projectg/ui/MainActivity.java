package com.guo.projectg.ui;

import android.os.Bundle;
import android.util.Log;

import com.guo.projectg.R;
import com.guo.projectg.http.ApiWrapper;
import com.guo.projectg.http.HttpX;

import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpX.Instance().init();
        findViewById(R.id.btn).setOnClickListener(view -> test());

    }


    private void test() {
        Disposable disposable = ApiWrapper.getInstance().test()
                .subscribe(
                        testBean -> Log.e("MainActivity", testBean.toString()),
                        throwable -> Log.e("MainActivity", throwable.getMessage()));
        compositeDisposable.add(disposable);
    }
}
