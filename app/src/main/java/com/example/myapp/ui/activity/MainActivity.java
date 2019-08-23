package com.example.myapp.ui.activity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

import com.example.myapp.R;
import com.example.myapp.TargetBean;
import com.example.myapp.base.BaseActivity;
import com.example.myapp.ui.adapter.ButtonAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private List<TargetBean> targetBeans;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

    }

    @Override
    protected void initValue() {
        createTargetList();

        recyclerView.setAdapter(new ButtonAdapter(targetBeans, this));
    }

    private void createTargetList() {
        targetBeans = new ArrayList<>();
        targetBeans.add(new TargetBean("权限申请", RequestPermissionActivity.class));
        targetBeans.add(new TargetBean("相机拍照", TakePhotoActivity.class));
        targetBeans.add(new TargetBean("网络请求", InternetRequestActivity.class));
        targetBeans.add(new TargetBean("列表", ListActivity.class));
        targetBeans.add(new TargetBean("滑动删除", ListSwipeActivity.class));
        targetBeans.add(new TargetBean("仿IOS弹窗", DialogActivity.class));
        targetBeans.add(new TargetBean("抽屉布局", DrawerActivity.class));
        targetBeans.add(new TargetBean("官方导航", BottomNavigationActivity.class));
        targetBeans.add(new TargetBean("自定义导航", MyNavigationActivity.class));
        targetBeans.add(new TargetBean("时间选择", DatePcikerActivity.class));

    }

    @Override
    protected void initEvent() {

    }
}
