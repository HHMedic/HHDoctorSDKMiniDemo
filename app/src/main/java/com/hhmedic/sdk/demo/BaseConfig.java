package com.hhmedic.sdk.demo;

import android.content.Context;

public class BaseConfig {

    public static String DefaultUserToken = "B0E86BAB0AF0F9E08B8A02969FD7CB553F0D04F68EA2608F6783B874E4F50EEF";//"B0E86BAB0AF0F9E08B8A02969FD7CB553F0D04F68EA2608F6783B874E4F50EEF";

    public static String IsDevelopKey = "isDevelop";

    public static String KeyUserToken = "userToken";

    public static String DefaultSDKProductId = "10350";

    public static String DefaultMedicId = "1625120849154";

    public static String DefaultForwardUserToken = "D768BC785EEA5B9A629470218973DF1D61DD1A68EED4C46CF57BB2FB029350D4";

    public static void setDevelop(Context context, boolean develop) {
        SharedPreferenceUtils.setValue(context,IsDevelopKey,develop);
    }

    public static boolean isDevelop(Context context) {
        return SharedPreferenceUtils.getBooleanValue(context,IsDevelopKey,true);
    }

}
