package com.example.myapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.base.BaseRecyclerHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Created by Ryan on 23/04/2019.
 */
public class ListSwipeAdapter extends RecyclerView.Adapter<ListSwipeAdapter.MyViewHolder> {
    private List<String> datas;
    private Context context;

    public ListSwipeAdapter(List<String> datas, Context context) {
        this.datas = datas;
        this.context =context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder holder =
                new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_swipe,
                        parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv.setText(datas.get(position));
        holder.deleteTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datas.remove(position);
                notifyDataSetChanged();
                Toast.makeText(context, "删除", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
//        return 15;
    }

    class MyViewHolder extends BaseRecyclerHolder {
        @BindView(R.id.tv)
        TextView tv;

        @BindView(R.id.tv_delete)
        TextView deleteTV;

        @BindView(R.id.root_layout)
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
