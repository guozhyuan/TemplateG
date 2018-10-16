package com.psychological.cxks.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psychological.cxks.R;
import com.psychological.cxks.bean.RoomListBean;
import com.psychological.cxks.http.ApiWrapper;
import com.psychological.cxks.ui.activity.EZiXunShiDetailActivity;
import com.psychological.cxks.util.DeviceUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

public class ZiXunShiShareFragment extends BaseFragment {
    private List<RoomListBean.ResultBean> list = new ArrayList<>();
    private Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_e_zixunshi, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.top = DeviceUtils.dip2px(getActivity(), 8);
            }
        });
        adapter = new Adapter();
        recyclerView.setAdapter(adapter);
        getRoomList();
    }

    public void getRoomList() {
        Disposable dis = ApiWrapper.getInstance().roomList(0, "").subscribe(
                ret -> {
                    list.addAll(ret.getResult());
                    adapter.notifyDataSetChanged();
                },
                err -> {

                }
        );
        compositeDisposable.add(dis);
    }


    class Adapter extends RecyclerView.Adapter<VH> {

        @NonNull
        @Override
        public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new VH(LayoutInflater.from(getActivity()).inflate(R.layout.item_zixunshi_list, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull VH holder, int position) {
            holder.root.setOnClickListener(v -> {
                Intent intent = new Intent(getActivity(), EZiXunShiDetailActivity.class);
                startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    class VH extends RecyclerView.ViewHolder {

        private final ConstraintLayout root;

        public VH(View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.root);
        }
    }
}
