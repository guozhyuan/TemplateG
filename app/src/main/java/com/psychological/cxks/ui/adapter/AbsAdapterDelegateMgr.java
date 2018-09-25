package com.psychological.cxks.ui.adapter;


import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;

/**
 * Author : jugg
 * Date   : 2018/6/28
 */
public class AbsAdapterDelegateMgr<T extends RecyclerView.ViewHolder> {

    private AbsAdapterDelegateMgr() {
    }

    private SparseArray<HolderContainer<T>> maps;

    public AbsAdapterDelegate routing(int viewType) {
        return maps.get(viewType).delegate;
    }


    public static class Builder<T extends RecyclerView.ViewHolder> {
        private SparseArray<HolderContainer<T>> maps;
        private AbsAdapterDelegateMgr mgr;

        public Builder() {
            mgr = new AbsAdapterDelegateMgr();
            maps = new SparseArray<>();

        }

        public Builder regist(int viewType, AbsAdapterDelegate delegate, T holder) {
            HolderContainer container = new HolderContainer<T>();
            container.delegate = delegate;
            container.holder = holder;
            maps.put(viewType, container);
            return this;
        }

        public AbsAdapterDelegateMgr build() {
            mgr.maps = maps;
            return mgr;
        }
    }

    public static class HolderContainer<T extends RecyclerView.ViewHolder> {
        public AbsAdapterDelegate delegate;
        public T holder;
    }
}
