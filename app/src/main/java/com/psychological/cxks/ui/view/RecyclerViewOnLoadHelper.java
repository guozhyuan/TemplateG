package com.psychological.cxks.ui.view;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RecyclerViewOnLoadHelper {

    private static RecyclerViewOnLoadHelper helper;

    private RecyclerViewOnLoadHelper() {
    }

    private OnLoadListener mOnLoadListener;
    private boolean isSlidingToLast = false;

    public static RecyclerViewOnLoadHelper ins() {
        if (helper == null) {
            helper = new RecyclerViewOnLoadHelper();
        }
        return helper;
    }

    public void regist(RecyclerView view) {
        view.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
                if (manager instanceof LinearLayoutManager || manager instanceof GridLayoutManager) {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        int lastVisibleItem = ((LinearLayoutManager) manager).findLastCompletelyVisibleItemPosition();
                        int totalItemCount = manager.getItemCount();
                        if (lastVisibleItem == (totalItemCount - 1) && !isSlidingToLast) {
                            mOnLoadListener.onLoad();
                        }
                    }
                } else {
                    throw new RuntimeException("Only LinearLayoutManager || GridLayoutManager");
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dx > 0) {
                    isSlidingToLast = true;
                } else {
                    isSlidingToLast = false;
                }
            }
        });
    }


    public void setOnLoadListener(OnLoadListener loadListener) {
        mOnLoadListener = loadListener;
    }

    public interface OnLoadListener {
        void onLoad();
    }
}
