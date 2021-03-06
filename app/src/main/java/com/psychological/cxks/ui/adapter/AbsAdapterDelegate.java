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

    <T, H extends RecyclerView.ViewHolder> void onBindViewHolder(H holder, int position, T data);

    <T extends RecyclerView.ViewHolder> T getHolder();
}
