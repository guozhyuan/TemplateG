package com.psychological.cxks.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.guo.projectg.R;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.VH> {

    private Context context;

    public FavoriteAdapter(Context context) {
        this.context = context;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_favorite, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class VH extends RecyclerView.ViewHolder {

        private final ImageView head;
        private final TextView nick;
        private final TextView addr;
        private final TextView message;

        public VH(View itemView) {
            super(itemView);
            head = itemView.findViewById(R.id.head);
            nick = itemView.findViewById(R.id.nick);
            addr = itemView.findViewById(R.id.addr);
            message = itemView.findViewById(R.id.message);

        }
    }
}
