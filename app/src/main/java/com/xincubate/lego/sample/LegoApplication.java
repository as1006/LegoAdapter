package com.xincubate.lego.sample;

import android.app.Application;

import com.xincubate.lego.sample.utils.LegoUtils;

public class LegoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LegoUtils.init();
    }
}
