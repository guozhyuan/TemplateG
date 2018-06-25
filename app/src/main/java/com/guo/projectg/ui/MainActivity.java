package com.guo.projectg.ui;

import android.os.Bundle;
import android.util.Log;

import com.guo.projectg.R;
import com.guo.projectg.bean.TestBean;
import com.guo.projectg.dao.DBManager;
import com.guo.projectg.http.ApiWrapper;
import com.guo.projectg.http.HttpX;

import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(view -> test());

    }


    private void test() {
        TestBean bean = new TestBean();
        bean.setDetail("DETAIL");
        bean.setStatus(1);
        DBManager.getInstance().getDaoSession().getTestBeanDao().insert(bean);
        Disposable disposable = ApiWrapper.getInstance().test()
                .subscribe(
                        testBean -> Log.e("MainActivity", testBean.toString()),
                        throwable -> Log.e("MainActivity", throwable.getMessage()));

        compositeDisposable.add(disposable);
    }
}
