package com.example.myapp;

/**
 * Created by Ryan on 19/04/2019.
 */
public class TargetBean {
    private String name;
    private Class activity;

    public TargetBean(String name, Class activity) {
        this.name = name;
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getActivity() {
        return activity;
    }

    public void setActivity(Class activity) {
        this.activity = activity;
    }
}
