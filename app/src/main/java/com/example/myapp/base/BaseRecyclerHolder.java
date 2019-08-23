package com.example.myapp.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

/**
 * Created by Ryan on 23/04/2019.
 */
public abstract class BaseRecyclerHolder extends RecyclerView.ViewHolder {
    public BaseRecyclerHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
