package com.project.asms1.presentation;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.asms1.R;
import com.project.asms1.Utils.SecurityLogic;
import com.project.asms1.config.MyConfig;
import com.project.asms1.daos.UserDAO;
import com.project.asms1.model.User;
import com.project.asms1.network.NetworkProvider;
import com.project.asms1.network.service.APIService;

import java.io.IOException;
import java.security.GeneralSecurityException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    TextView txtMessage;
    Button btnShow;
    private static final String TAG = LoginActivity.class.getSimpleName();
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassWord);
        txtMessage = findViewById(R.id.txtMessage);
        btnShow = findViewById(R.id.btnLogin);



        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickToLogin();
            }
        });

    }

    private void clickToLogin() {
        String username = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        txtMessage.setVisibility(View.VISIBLE);
        if (SecurityLogic.isValidPassword(password) && SecurityLogic.isValidUserName(username)) {
            String cryptedPassword = SecurityLogic.getMD5(password);
            User user = new User(cryptedPassword, username,MyConfig.productperpage);


            NetworkProvider nw = NetworkProvider.self();
            nw.getService(APIService.class).Login(user).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if(response.isSuccessful()) {
                        User user1 = response.body();
                        if(user1 == null) {
                            System.out.println("ko co du lieu");
                            Toast.makeText(LoginActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
                            txtMessage.setText("Not Exist");
                            txtMessage.setTextColor(getResources().getColor(R.color.colorAccent));
                        }else {
                            System.out.println("Co du lieu");
                            Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                            txtMessage.setText("Login Success");
                            txtMessage.setTextColor(getResources().getColor(R.color.colorPrimary));
                            try {
                                SecurityLogic.getPreferenceInstance(LoginActivity.this);
                                SecurityLogic.storeTokens(user1.getToken());
                                UserDAO.currentUser = user1;
                                UserDAO.listOfProduct = user1.getProductslist();
                                UserDAO.numberOfPage = user1.getNumberOfPage();

                                Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
                                startActivity(intent);

                            } catch (GeneralSecurityException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        System.out.println(response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.e(TAG, t.getMessage());
                }
            });


        }else {
            txtMessage.setText("Email or Password invalid");
            txtMessage.setTextColor(getResources().getColor(R.color.colorAccent));
        }


    }
}