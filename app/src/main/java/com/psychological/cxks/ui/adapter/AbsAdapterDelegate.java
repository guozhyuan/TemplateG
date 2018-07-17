package com.psychological.cxks.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Author : jugg
 * Date   : 2018/6/28
 * RecyclerView.Adapter delegate
 */
public interface AbsAdapterDelegate {
    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    <T> void onBindViewHolder(RecyclerView.ViewHolder holder, int position, T t);

}
