package com.example.myapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapp.R;
import com.example.myapp.base.BaseRecyclerHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Created by Ryan on 23/04/2019.
 */
public class ListTextAdapter extends RecyclerView.Adapter<ListTextAdapter.MyViewHolder> {
    private List<String> datas;

    public ListTextAdapter(List<String> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder holder =
                new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,
                        parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
//        return 15;
    }

    class MyViewHolder extends BaseRecyclerHolder {
        @BindView(R.id.tv)
        TextView tv;

        @BindView(R.id.root_layout)
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
