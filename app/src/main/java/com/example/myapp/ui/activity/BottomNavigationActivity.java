package com.example.myapp.ui.activity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.myapp.R;
import com.example.myapp.base.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ryan on 24/04/2019.
 */
public class BottomNavigationActivity extends BaseActivity {
   
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bottom_navigation;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initValue() {

    }

    @Override
    protected void initEvent() {

    }


}
