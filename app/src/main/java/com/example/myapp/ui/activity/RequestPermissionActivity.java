package com.example.myapp.ui.activity;

import android.Manifest;
import androidx.annotation.NonNull;

import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.base.BaseActivity;

import java.util.List;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by Ryan on 19/04/2019.
 */
public class RequestPermissionActivity extends BaseActivity  implements  EasyPermissions.PermissionCallbacks {

    //https://developer.android.google.cn/training/permissions/requesting 官网介绍
    //https://github.com/googlesamples/easypermissions 例子
    private TextView permissionsTV;
    private static final int RC_CAMERA_PERM = 123;
    private static final int RC_LOCATION_CONTACTS_PERM = 124;
    private String[] permissions = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.INTERNET
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_request_permission;
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
                    RC_LOCATION_CONTACTS_PERM,
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


    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this)
                    .setTitle("提醒")
                    .setRationale("此app需要这些权限才能正常使用")
                    .build()
                    .show();
        }
    }
}
