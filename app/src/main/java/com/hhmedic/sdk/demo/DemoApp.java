package com.hhmedic.sdk.demo;

import android.app.Application;
import android.util.Log;

import com.hhmedic.android.sdk.HHDoctor;
import com.hhmedic.android.sdk.config.HHSDKOptions;

public class DemoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initSDK();
    }

    private void initSDK() {
        boolean isDevelop = BaseConfig.isDevelop(this);
        Log.e("isDevelop", "isDevelop=" + isDevelop);
        HHSDKOptions options = new HHSDKOptions(BaseConfig.DefaultSDKProductId,isDevelop,new GlideImageLoader());
        HHDoctor.init(this,options);
    }
}
