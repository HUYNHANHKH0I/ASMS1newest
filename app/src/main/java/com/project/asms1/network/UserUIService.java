package com.project.asms1.network;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.project.asms1.R;
import com.project.asms1.Utils.SecurityLogic;
import com.project.asms1.config.MyConfig;
import com.project.asms1.model.Token;
import com.project.asms1.network.service.APIService;
import com.project.asms1.presentation.LoginActivity;
import com.project.asms1.presentation.SellerHomeActivity;

import java.io.IOException;
import java.security.GeneralSecurityException;

import br.com.simplepass.loadingbutton.customViews.CircularProgressButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserUIService {
    private static final String TAG = UserUIService.class.getSimpleName();

    public static void deleteToken(Context context) {
        try {
            SecurityLogic.getPreferenceInstance(context);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String tokens = SecurityLogic.getTokens();

        if (tokens != null) {
            NetworkProvider nw = NetworkProvider.self();
            nw.getService(APIService.class).DeleteToken(tokens).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        String result = response.body();
                        if (result.equals(MyConfig.SUCCESS)) {
                            SecurityLogic.deleteTokens();
                        }else {
                            System.out.println("fail1");
                        }
                    }else {
                        System.out.println("Fail2");
                    }
                }
                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.e(TAG, t.getMessage());
                }
            });
        }else {
            System.out.println("Here2");
        }
    }

    public static void checkTokens(Context context, CircularProgressButton btn) {
        try {
            SecurityLogic.getPreferenceInstance(context);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String tokens = SecurityLogic.getTokens();
        System.out.println(tokens);

        if (tokens != null) {
            NetworkProvider nw = NetworkProvider.self();
            nw.getService(APIService.class).Loading(new Token(tokens)).enqueue(new Callback<Token>() {
                @Override
                public void onResponse(Call<Token> call, Response<Token> response) {
                    if (response.isSuccessful()) {
                        Token result = response.body();
                        System.out.println(tokens);
                        if (result.getResult().equals(MyConfig.SUCCESS)) {
                            btn.doneLoadingAnimation(ContextCompat.getColor(context,R.color.purple),
                                    BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_done_white_48dp));
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent = new Intent(context, SellerHomeActivity.class);
                                    context.startActivity(intent);
                                }
                            }, 1000);
                        }else {
                            System.out.println("Here3");
                            btn.doneLoadingAnimation(ContextCompat.getColor(context,R.color.black),
                                    BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_pregnant_woman_white_48dp));
                            Intent intent = new Intent(context,LoginActivity.class);
                            context.startActivity(intent);
                        }
                    }else {
                        System.out.println("Fail4");
                    }
                }
                @Override
                public void onFailure(Call<Token> call, Throwable t) {
                    Log.e(TAG, t.getMessage());
                }
            });
        }else {
            System.out.println("Here4");
            btn.doneLoadingAnimation(ContextCompat.getColor(context,R.color.black),
                    BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_pregnant_woman_white_48dp));
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(context,LoginActivity.class);
                    context.startActivity(intent);
                }
            }, 1000);
        }
    }
}
