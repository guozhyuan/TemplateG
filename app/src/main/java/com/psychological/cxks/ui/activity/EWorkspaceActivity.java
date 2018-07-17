package com.psychological.cxks.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.guo.projectg.R;

public class EWorkspaceActivity extends BaseActivity {

    private String[] actionNames = {"主页设置", "我的订单", "客户", "时间设置", "咨询室共享", "套餐设置", "优惠码", "收入", "咨询报告", "评价"};
    private int[] actionImgs = {R.drawable.ic_launcher_background};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_e_workspace;
    }

    @Override
    public void findView() {
        RecyclerView actions = findViewById(R.id.actions);
        actions.setLayoutManager(new GridLayoutManager(this, 4));
        ActionAdapter actionAdapter = new ActionAdapter();
        actions.setAdapter(actionAdapter);


        RecyclerView todo = findViewById(R.id.todo);
        TodoAdapter todoAdapter = new TodoAdapter();
        todo.setLayoutManager(new LinearLayoutManager(this));
        todo.setAdapter(todoAdapter);
    }

    @Override
    public void initListener() {

    }


    class ActionAdapter extends RecyclerView.Adapter<ActionAdapter.VH> {

        @Override
        public ActionAdapter.VH onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(EWorkspaceActivity.this).inflate(R.layout.item_action_list, parent, false);
            return new VH(view);
        }

        @Override
        public void onBindViewHolder(ActionAdapter.VH holder, int position) {
            holder.img.setImageResource(R.mipmap.ic_launcher_round);
            holder.name.setText(actionNames[position]);
            holder.root.setOnClickListener((view) -> {
                // "主页设置", "我的订单", "客户", "时间设置", "咨询室共享", "套餐设置", "优惠码", "收入", "咨询报告", "评价"
                switch (position) {
                    case 0: //主页设置

                        break;
                    case 1: //我的订单
                        startActivity(new Intent(EWorkspaceActivity.this, EMyOrdersActivity.class));
                        break;
                    case 2: // 客户
                        startActivity(new Intent(EWorkspaceActivity.this, EMyCustomerActivity.class));
                        break;
                    case 3:// 时间设置
                        startActivity(new Intent(EWorkspaceActivity.this, EMySchedulerActivity.class));
                        break;
                    case 4:// 咨询室共享
                        startActivity(new Intent(EWorkspaceActivity.this, EZiXunShiShareActivity.class));
                        break;
                    case 5:// 套餐设置
                        startActivity(new Intent(EWorkspaceActivity.this, EPackgeMgrActivity.class));
                        break;
                    case 6: // 优惠码
                        startActivity(new Intent(EWorkspaceActivity.this, EDiscountCodeActivity.class));
                        break;
                    case 7:// 收入
                        startActivity(new Intent(EWorkspaceActivity.this, EIncomeActivity.class));
                        break;
                    case 8:// 咨询报告

                        break;
                    case 9:// 评价

                        break;
                }
            });
        }

        @Override
        public int getItemCount() {
            return actionNames.length;
        }

        class VH extends RecyclerView.ViewHolder {

            private final ImageView img;
            private final TextView name;
            private final ConstraintLayout root;

            public VH(View itemView) {
                super(itemView);
                img = itemView.findViewById(R.id.action_image);
                name = itemView.findViewById(R.id.action_name);
                root = itemView.findViewById(R.id.root);
            }
        }
    }


    class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoVH> {


        @Override
        public TodoAdapter.TodoVH onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(EWorkspaceActivity.this).inflate(R.layout.item_todo_list, parent, false);
            return new TodoVH(view);
        }

        @Override
        public void onBindViewHolder(TodoAdapter.TodoVH holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 2;
        }

        class TodoVH extends RecyclerView.ViewHolder {

            private final TextView desc;
            private final TextView time;

            public TodoVH(View itemView) {
                super(itemView);

                desc = itemView.findViewById(R.id.desc);
                time = itemView.findViewById(R.id.time);
            }
        }
    }
}
