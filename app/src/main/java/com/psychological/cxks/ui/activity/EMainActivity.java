package com.psychological.cxks.ui.activity;

import android.os.Bundle;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;

import com.psychological.cxks.R;
import com.psychological.cxks.bean.TestBean;
import com.psychological.cxks.dao.DBManager;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.adapter.MainVpAdapter;
import com.psychological.cxks.ui.fragment.MeFragment;
import com.psychological.cxks.ui.fragment.MsgFragment;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class EMainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    private BottomNavigationView bottomView;
    private Badge badge;
    private ViewPager vp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomView.getChildAt(0);
        BottomNavigationItemView itemView = (BottomNavigationItemView) menuView.getChildAt(1);
//        badge = new QBadgeView(this).bindTarget(itemView).setBadgeNumber(4).setBadgeGravity(Gravity.END | Gravity.TOP).setGravityOffset(40, 0, true);

        EWorkspaceFragment mainFragment = new EWorkspaceFragment();
        MsgFragment msgFragment = new MsgFragment();
        MeFragment meFragment = new MeFragment();
        List<Fragment> list = new ArrayList<>();
        list.add(mainFragment);
        list.add(msgFragment);
        list.add(meFragment);
        MainVpAdapter adapter = new MainVpAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(2);
    }


    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void findView() {
        statusbarCover = findViewById(R.id.statusbar_cover);
        bottomView = findViewById(R.id.bottom);
        vp = findViewById(R.id.vp);


    }

    @Override
    public void initListener() {
        // BottomNavigationViewHelper.disableShiftMode(bottomView); //超过3个,默认附带动画,此方法取消动画
        bottomView.setOnNavigationItemSelectedListener(item -> {
            Log.e(TAG, "Check : " + item.getTitle());
            switch (item.getItemId()) {
                case R.id.navi_main:
                    vp.setCurrentItem(0);
                    break;
                case R.id.navi_msg:
                    vp.setCurrentItem(1);
                    break;
                case R.id.navi_me:
                    vp.setCurrentItem(2);
                    break;
            }
            return true;
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void test() {
        TestBean bean = new TestBean();
        bean.setDetail("DETAIL");
        bean.setStatus(1);
        DBManager.getInstance().getDaoSession().getTestBeanDao().insert(bean);
        Disposable disposable = ApiWrapper.getInstance()
                .test()
                .subscribe(testBean -> Log.e("MainActivity", testBean.toString()),
                        throwable -> Log.e("MainActivity", throwable.getMessage()));

        compositeDisposable.add(disposable);
    }
}
