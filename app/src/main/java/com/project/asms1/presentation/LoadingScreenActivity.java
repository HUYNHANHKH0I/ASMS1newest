package com.project.asms1.presentation;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;
import com.project.asms1.network.UserUIService;

import br.com.simplepass.loadingbutton.customViews.CircularProgressButton;

public class LoadingScreenActivity extends AppCompatActivity {

    private static final String TAG = LoadingScreenActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadingscreen);
        initData();
    }

    private void initData() {
        CircularProgressButton btn = (CircularProgressButton) findViewById(R.id.btnLoading);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.startAnimation();
                UserUIService.checkTokens(LoadingScreenActivity.this, btn);
            }
        });
    }
}