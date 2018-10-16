package com.psychological.cxks.ui.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psychological.cxks.R;
import com.psychological.cxks.util.DeviceUtils;

public class ECodeListFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_e_code_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.top = DeviceUtils.dip2px(getActivity(), 5);
            }
        });
        Adapter adapter = new Adapter();
        recyclerView.setAdapter(adapter);
        // TODO 对用什么接口?
    }


    class Adapter extends RecyclerView.Adapter<VH> {

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_e_code_list, parent, false);
            return new VH(view);
        }

        @Override
        public void onBindViewHolder(VH holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    class VH extends RecyclerView.ViewHolder {

        public VH(View itemView) {
            super(itemView);
        }
    }
}
