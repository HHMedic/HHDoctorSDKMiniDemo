package com.hhmedic.sdk.demo;

import android.app.Application;

import com.hhmedic.android.sdk.HHDoctor;
import com.hhmedic.android.sdk.config.HHSDKOptions;

public class DemoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initSDK();
    }

    private void initSDK() {
        HHSDKOptions options = new HHSDKOptions("10350",true,new GlideImageLoader());
        HHDoctor.init(this,options);
    }
}
