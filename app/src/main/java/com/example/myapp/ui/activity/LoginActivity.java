package com.example.myapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.base.BaseActivity;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ryan on 24/04/2019.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.btn_login)
    Button loginBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initValue() {

    }

    @Override
    protected void initEvent() {
        loginBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
            default:
                break;

        }
    }

    private void login() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}
