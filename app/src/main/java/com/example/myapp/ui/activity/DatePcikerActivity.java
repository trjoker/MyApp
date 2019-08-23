package com.example.myapp.ui.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Ryan on 24/04/2019.
 */
public class DatePcikerActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.btn_date_picker)
    Button datePickerBtn;
    @BindView(R.id.btn_time_picker)
    Button timePickerBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_date_picker;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initValue() {

    }

    @Override
    protected void initEvent() {

        datePickerBtn.setOnClickListener(this);
        timePickerBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_date_picker:
                new DatePickerDialog(DatePcikerActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month,
                                                  int dayOfMonth) {
                                Toast.makeText(DatePcikerActivity.this,
                                        year + "年" + (month + 1) + "月" + dayOfMonth + "日",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }, 2019, 11, 1).show();
                break;
            case R.id.btn_time_picker:

                new TimePickerDialog(DatePcikerActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(DatePcikerActivity.this,
                                hourOfDay + "小时" +minute + "分钟" ,
                                Toast.LENGTH_SHORT).show();
                    }
                }, 13, 23, true).show();
                break;

        }
    }
}
