package com.example.myapp.ui.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapp.base.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by Ryan on 24/04/2019.
 */
public class MyFragment1 extends BaseFragment {
    String text = "页面1";

    TextView textView;

    public void setText(String text) {
        textView.setText(text);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        textView = new TextView(getActivity());
        textView.setText(text);
        return textView;

    }
}
