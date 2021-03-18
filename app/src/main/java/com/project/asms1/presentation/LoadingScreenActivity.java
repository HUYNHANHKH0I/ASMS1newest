package com.project.asms1.presentation;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.content.ContextCompat;

import com.project.asms1.R;
import com.project.asms1.Utils.SecurityLogic;
import com.project.asms1.config.MyConfig;
import com.project.asms1.model.Token;
import com.project.asms1.model.User;
import com.project.asms1.network.NetworkProvider;
import com.project.asms1.network.UserUIService;
import com.project.asms1.network.service.APIService;

import java.io.IOException;
import java.security.GeneralSecurityException;

import br.com.simplepass.loadingbutton.customViews.CircularProgressButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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