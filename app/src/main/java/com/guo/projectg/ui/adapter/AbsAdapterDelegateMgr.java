package com.guo.projectg.ui.adapter;


import android.util.SparseArray;

/**
 * Author : jugg
 * Date   : 2018/6/28
 */
public class AbsAdapterDelegateMgr {

    private AbsAdapterDelegateMgr() {
    }

    private SparseArray<AbsAdapterDelegate> map;

    public AbsAdapterDelegate routing(int viewType) {
        return map.get(viewType);
    }


    public static class Builder {
        private SparseArray<AbsAdapterDelegate> map;

        private AbsAdapterDelegateMgr mgr;

        @SuppressWarnings("all")
        public Builder() {
            mgr = new AbsAdapterDelegateMgr();
            map = new SparseArray<AbsAdapterDelegate>();
        }

        public Builder regist(int viewType, AbsAdapterDelegate delegate) {
            map.put(viewType, delegate);
            return this;
        }

        public AbsAdapterDelegateMgr build() {
            mgr.map = map;
            return mgr;
        }
    }
}
