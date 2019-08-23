package com.example.myapp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapp.R;
import com.example.myapp.TargetBean;
import com.example.myapp.base.BaseRecyclerHolder;

import java.util.List;

/**
 * Created by Ryan on 19/04/2019.
 */
public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.MyViewHolder> {
    private List<TargetBean> datas;
    private Context context;


    public ButtonAdapter(List<TargetBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MyViewHolder holder =
                new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_buttons,
                        viewGroup, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder viewHolder, final int i) {
        viewHolder.button.setText(datas.get(i).getName());
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, datas.get(i).getActivity());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends BaseRecyclerHolder {

        @BindView(R.id.btn) Button button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
