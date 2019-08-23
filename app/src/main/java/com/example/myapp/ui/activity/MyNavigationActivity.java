package com.example.myapp.ui.activity;

import android.os.Bundle;

import com.example.myapp.R;
import com.example.myapp.base.BaseActivity;
import com.example.myapp.ui.Fragment.MyFragment;
import com.example.myapp.ui.Fragment.MyFragment1;
import com.example.myapp.ui.Fragment.MyFragment2;
import com.example.myapp.ui.Fragment.MyFragment3;
import com.example.myapp.ui.view.BottomBar;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ryan on 24/04/2019.
 */
public class MyNavigationActivity extends BaseActivity {
    @BindView(R.id.bottom_bar)
    BottomBar bottomBar;

    private MyFragment1 myFragment1;
    private MyFragment2 myFragment2;
    private MyFragment3 myFragment3;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_navigation;
    }

    @Override
    protected void initView() {
        myFragment1= new MyFragment1();
        myFragment2= new MyFragment2();
        myFragment3= new MyFragment3();

        bottomBar.setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#999999", "#ff5d5e")
                .addItem(myFragment1,
                        "首页",
                        R.mipmap.ic_launcher,
                        R.mipmap.ic_launcher_round)
                .addItem(myFragment2,
                        "订单",
                        R.mipmap.ic_launcher,
                        R.mipmap.ic_launcher_round)
                .addItem(myFragment3,
                        "我的",
                        R.mipmap.ic_launcher,
                        R.mipmap.ic_launcher_round)
                .build();
    }

    @Override
    protected void initValue() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
