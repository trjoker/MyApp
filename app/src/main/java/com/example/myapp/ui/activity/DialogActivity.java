package com.example.myapp.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.base.BaseActivity;
import com.example.myapp.ui.dialog.IOSBottomDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ryan on 23/04/2019.
 */
public class DialogActivity extends BaseActivity implements View.OnClickListener, IOSBottomDialogFragment.ButtomDialogListener {
    private static final String DIALOG_TAG = "buttom_dialog";
    private String[] items = {"选项1", "选项2", "选项3"};

    @BindView(R.id.btn_pop_up)
    Button popupBtn;
    @BindView(R.id.btn_two_button)
    Button twoButtonBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ios_dialog;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initValue() {

    }

    @Override
    protected void initEvent() {
        popupBtn.setOnClickListener(this);
        twoButtonBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pop_up:
                showBottomPopUpdialog();
                break;
            case R.id.btn_two_button:
                break;
            default:
                break;

        }
    }

    private void showBottomPopUpdialog() {
        final IOSBottomDialogFragment fragment = IOSBottomDialogFragment.newInstance(items,this);
        if (!fragment.isAdded()) {
            fragment.show(getSupportFragmentManager(), DIALOG_TAG);
        }
    }

    @Override
    public void onClick(int position) {
        Toast.makeText(this, items[position]+"被点击了。", Toast.LENGTH_SHORT).show();
    }
}
