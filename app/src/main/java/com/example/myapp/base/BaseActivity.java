package com.example.myapp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.KeyEvent;

import com.example.myapp.util.ActivityUtil;

import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;


/**
 * Created by Ryan on 18/03/2019.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUtil.getInstance().addActivity(this);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        initValue();
        initEvent();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initValue();

    protected abstract void initEvent();


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 点击手机上的返回键，返回上一层
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 移除Activity
            ActivityUtil.getInstance().removeActivity(this);
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        ActivityUtil.getInstance().removeActivity(this);
        super.onDestroy();
        unsubscribe();
    }


    protected void unsubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

}
