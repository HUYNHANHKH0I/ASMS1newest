package com.project.asms1.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.project.asms1.R;

public class AccountDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail);

        Intent intent = getIntent();


        ((TextView)findViewById(R.id.txtUsername)).setText("");
        ((TextView)findViewById(R.id.txtPassword)).setText("");
        ((TextView)findViewById(R.id.txtEmail)).setText("");
        ((TextView)findViewById(R.id.txtPhone)).setText("");

    }

    public void clickToGoBack(View view) {
        finish();
    }
}