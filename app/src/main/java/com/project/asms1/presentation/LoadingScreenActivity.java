package com.project.asms1.presentation;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.content.ContextCompat;

import com.project.asms1.R;
import com.project.asms1.Utils.SecurityLogic;
import com.project.asms1.config.MyConfig;
import com.project.asms1.model.User;
import com.project.asms1.network.NetworkProvider;
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

        CircularProgressButton btn = (CircularProgressButton) findViewById(R.id.buttonTest2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.startAnimation();

                try {
                    SecurityLogic.getPreferenceInstance(LoadingScreenActivity.this);
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String tokens = SecurityLogic.getTokens();

                if (tokens != null) {
                    NetworkProvider nw = NetworkProvider.self();
                    nw.getService(APIService.class).Loading(tokens).enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            if (response.isSuccessful()) {
                                String result = response.body();
                                if (result.equals(MyConfig.SUCCESS)) {
                                    btn.doneLoadingAnimation(ContextCompat.getColor(LoadingScreenActivity.this,R.color.black),
                                            BitmapFactory.decodeResource(getResources(), R.drawable.ic_done_white_48dp));
                                    Intent intent = new Intent(LoadingScreenActivity.this,HomePageActivity.class);
                                    startActivity(intent);

                                }else {
                                    btn.doneLoadingAnimation(ContextCompat.getColor(LoadingScreenActivity.this,R.color.black),
                                            BitmapFactory.decodeResource(getResources(), R.drawable.ic_pregnant_woman_white_48dp));
                                    Intent intent = new Intent(LoadingScreenActivity.this,LoginActivity.class);
                                    startActivity(intent);
                                }



                            }else {

                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Log.e(TAG, t.getMessage());
                        }
                    });
                }else {
                    btn.doneLoadingAnimation(ContextCompat.getColor(LoadingScreenActivity.this,R.color.black),
                            BitmapFactory.decodeResource(getResources(), R.drawable.ic_pregnant_woman_white_48dp));
                    Intent intent = new Intent(LoadingScreenActivity.this,LoginActivity.class);
                    startActivity(intent);
                }


            }
        });






    }
}