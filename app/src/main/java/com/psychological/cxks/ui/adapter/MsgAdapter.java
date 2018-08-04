package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.psychological.cxks.R;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.VH> {

    private Context ctx;

    public MsgAdapter(Context ctx) {
        this.ctx = ctx;
    }


    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_msg_list, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class VH extends RecyclerView.ViewHolder {

        private final ImageView head;
        private final TextView name;
        private final TextView msg;
        private final TextView time;

        public VH(View itemView) {
            super(itemView);
            head = itemView.findViewById(R.id.head);
            name = itemView.findViewById(R.id.name);
            msg = itemView.findViewById(R.id.msg);
            time = itemView.findViewById(R.id.time);

        }
    }
}
