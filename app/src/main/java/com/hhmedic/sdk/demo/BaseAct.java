package com.hhmedic.sdk.demo;

import android.os.Build;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class BaseAct extends AppCompatActivity {

    public void initActionBar(Toolbar toolbar) {
        if (toolbar == null) {
            return;
        }
        setSupportActionBar(toolbar);
        initActionBar();
    }

    private void initActionBar() {
        if (getSupportActionBar() == null) {
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getSupportActionBar().setElevation(0f);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void hideBack() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
