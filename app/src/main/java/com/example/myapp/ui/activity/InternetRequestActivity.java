package com.example.myapp.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.base.BaseActivity;
import com.example.myapp.bean.DailyNews;
import com.example.myapp.network.RetrofitHelper;
import com.example.myapp.util.DateUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by Ryan on 19/04/2019.
 */
public class InternetRequestActivity extends BaseActivity implements View.OnClickListener {
    private String[] permissions = new String[]{
            Manifest.permission.INTERNET
    };
    private static final int RC_INTERNET_PERM = 125;


    @BindView(R.id.btn_get)
    Button getRequestBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_internet;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initValue() {

    }

    @Override
    protected void initEvent() {
        checkPermission();
    }

    private void checkPermission() {

        if (!EasyPermissions.hasPermissions(this, permissions)) {
            EasyPermissions.requestPermissions(
                    this,
                    "请允许以下权限",
                    RC_INTERNET_PERM,
                    permissions);
        } else {
            //有权限
            Toast.makeText(this, "所有权限已具备", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @OnClick({R.id.btn_get})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                loadDailyNews(DateUtil.getNowDateFormat("yyyyMMdd"));
                break;
            default:
                break;
        }
    }


    //加载某日的新闻
    private void loadDailyNews(String date) {

        disposable = RetrofitHelper
                .getDouBanApi()
                .getDaily(date)
                .map(new Function<DailyNews, String>() {
                    @Override
                    public String apply(DailyNews dailyNews) {
                        return dailyNews.toString();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String String) {
                        Log.i("taoran", String);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        Log.i("taoran", throwable.getMessage());
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
