package com.hhmedic.sdk.demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.hhmedic.android.sdk.HHDoctor;
import com.hhmedic.android.sdk.listener.HHLoginListener;
import com.hhmedic.sdk.demo.databinding.ActivityMainBinding;

public class MainActivity extends BaseAct {

    private ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        initActionBar(mainBinding.toolbar);
        hideBack();

        mainBinding.developSwitch.setChecked(BaseConfig.isDevelop(this));
        mainBinding.developSwitch.setOnCheckedChangeListener((compoundButton, b) -> {
            BaseConfig.setDevelop(MainActivity.this,b);
            switchReload();
        } );
        mainBinding.useDefaultUserToken.setOnClickListener(view -> mainBinding.userToken.setText(BaseConfig.DefaultUserToken));
        mainBinding.loginButton.setOnClickListener(view -> login());

    }
    
    private void login() {
        String userToken = mainBinding.userToken.getText().toString().trim();
        if (TextUtils.isEmpty(userToken)) {
            Toast.makeText(this, "请输入需要登录的UserToken", Toast.LENGTH_SHORT).show();
            return;
        }
        HHDoctor.login(this, userToken, new HHLoginListener() {
            @Override
            public void onSuccess() {
                Intent intent = new Intent(MainActivity.this,CallAct.class);
                intent.putExtra(BaseConfig.KeyUserToken,userToken);
                startActivity(intent);
            }

            @Override
            public void onError(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void switchReload() {
        Toast.makeText(this, "切换设置后需要重启打开APP才会生效", Toast.LENGTH_SHORT).show();
        new Handler(getMainLooper()).postDelayed(() -> System.exit(0),1000);
    }
}