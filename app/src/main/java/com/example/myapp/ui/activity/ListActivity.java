package com.example.myapp.ui.activity;

import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.base.BaseActivity;
import com.example.myapp.ui.adapter.ListTextAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yanzhenjie.recyclerview.OnItemMenuClickListener;
import com.yanzhenjie.recyclerview.SwipeMenu;
import com.yanzhenjie.recyclerview.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.SwipeMenuItem;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;

/**
 * Created by Ryan on 23/04/2019.
 */
public class ListActivity extends BaseActivity {
    @BindView(R.id.recyclerview)
    SwipeRecyclerView recyclerView;
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout smartRefreshLayout;

    ListTextAdapter listTextAdapter;

    private List<String> datas;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_list;
    }

    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        // 创建菜单：
        SwipeMenuCreator mSwipeMenuCreator = new SwipeMenuCreator() {
            @Override
            public void onCreateMenu(SwipeMenu leftMenu, SwipeMenu rightMenu, int position) {
                SwipeMenuItem deleteItem =
                        new SwipeMenuItem(ListActivity.this)
                                .setBackground(R.color.colorAccent)
                                .setImage(R.mipmap.ic_launcher).setText("删除")
                                .setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
                //设置高，这里使用match_parent，就是与item的高相同.setWidth(70);//设置宽
                rightMenu.addMenuItem(deleteItem);
            }
        };
        recyclerView.setSwipeMenuCreator(mSwipeMenuCreator);
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
                listTextAdapter.notifyDataSetChanged();
                Toast.makeText(ListActivity.this, "下拉刷新", Toast.LENGTH_SHORT).show();

            }
        });

        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                smartRefreshLayout.finishLoadMore(500);
                addDatas();
                listTextAdapter.notifyDataSetChanged();
                Toast.makeText(ListActivity.this, "上拉加载更多", Toast.LENGTH_SHORT).show();

            }
        });



        // 菜单点击监听。
        recyclerView.setOnItemMenuClickListener(new OnItemMenuClickListener() {
            @Override
            public void onItemClick(SwipeMenuBridge menuBridge, int position) {
                // 任何操作必须先关闭菜单，否则可能出现Item菜单打开状态错乱。
                menuBridge.closeMenu();

                // 左侧还是右侧菜单：
                int direction = menuBridge.getDirection();
                // 菜单在Item中的Position：
                int menuPosition = menuBridge.getPosition();
                datas.remove(position);
                Toast.makeText(ListActivity.this, "删除第"+position+"项", Toast.LENGTH_SHORT).show();
                listTextAdapter.notifyDataSetChanged();
            }
        });
        listTextAdapter = new ListTextAdapter(datas);
        recyclerView.setAdapter(listTextAdapter);
    }


}
