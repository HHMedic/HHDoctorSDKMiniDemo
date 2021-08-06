package com.hhmedic.sdk.demo;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.hhmedic.android.sdk.HHDoctor;
import com.hhmedic.android.sdk.listener.HHCallListener;
import com.hhmedic.sdk.demo.databinding.ActivityCallBinding;

public class CallAct extends BaseAct {

    private ActivityCallBinding callBinding;

    private String mainUserToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callBinding = DataBindingUtil.setContentView(this,R.layout.activity_call);
        mainUserToken = getIntent().getStringExtra(BaseConfig.KeyUserToken);
        initUI();
    }

    private void initUI() {

        initActionBar(callBinding.toolbar);

        callBinding.editMedicId.setText(BaseConfig.DefaultMedicId);
        callBinding.editForwardUserToken.setText(BaseConfig.DefaultForwardUserToken);

        callBinding.buttonSetExt.setOnClickListener(view -> HHDoctor.setCallExtension(callBinding.editExt.getText().toString()));

        callBinding.buttonCall.setOnClickListener(view -> {
            call();
        });
        callBinding.buttonGetMedic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMedicUrl();
            }
        });
    }

    private void getMedicUrl() {
        String medicId = callBinding.editMedicId.getText().toString().trim();
        String forwardUserToken = callBinding.editForwardUserToken.getText().toString();
        if (TextUtils.isEmpty(medicId)) {
            Toast.makeText(this, getString(R.string.hint_medic_id), Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(forwardUserToken)) {
            Toast.makeText(this, getString(R.string.hint_forward_user_token), Toast.LENGTH_SHORT).show();
            return;
        }
        String url = HHDoctor.getMedicDetailUrl(medicId,mainUserToken,forwardUserToken);
        callBinding.editUrl.setText(url);

    }

    private void call() {
        String userToken = callBinding.editUserToken.getText().toString().trim();
        if (TextUtils.isEmpty(userToken)) {
//            Toast.makeText(this, getString(R.string.tip_input_call_user_token), Toast.LENGTH_SHORT).show();
//            return;
            userToken = mainUserToken;
        }

        HHDoctor.call(this, userToken, new HHCallListener() {
            @Override
            public void onStart(String s) {

            }

            @Override
            public void onFinish(long l) {

            }

            @Override
            public void onCallSuccess() {

            }

            @Override
            public void onFail(int i) {

            }

            @Override
            public void onCancel() {

            }
        });
    }
}