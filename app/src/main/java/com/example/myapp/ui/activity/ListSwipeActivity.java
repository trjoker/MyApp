package com.example.myapp.ui.activity;

import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.base.BaseActivity;
import com.example.myapp.ui.adapter.ListSwipeAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Created by Ryan on 23/04/2019.
 */
public class ListSwipeActivity extends BaseActivity {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout smartRefreshLayout;

    ListSwipeAdapter listSwipeAdapter;

    private List<String> datas;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_list_swipe;
    }

    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

    }

    @Override
    protected void initValue() {
        datas = new ArrayList<>();
        addDatas();
    }

    private void addDatas() {
        for (int i = 0; i < 10; i++) {
            datas.add("第" + i + "条数据");
        }
    }

    @Override
    protected void initEvent() {
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                datas.clear();
                smartRefreshLayout.finishRefresh(500);
                addDatas();
                listSwipeAdapter.notifyDataSetChanged();
                Toast.makeText(ListSwipeActivity.this, "下拉刷新", Toast.LENGTH_SHORT).show();

            }
        });

        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                smartRefreshLayout.finishLoadMore(500);
                addDatas();
                listSwipeAdapter.notifyDataSetChanged();
                Toast.makeText(ListSwipeActivity.this, "上拉加载更多", Toast.LENGTH_SHORT).show();

            }
        });


        listSwipeAdapter = new ListSwipeAdapter(datas,this);
        recyclerView.setAdapter(listSwipeAdapter);

    }


}
