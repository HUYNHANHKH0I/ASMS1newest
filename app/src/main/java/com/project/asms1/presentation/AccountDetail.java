package com.project.asms1.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;

public class AccountDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail);

        Intent intent = getIntent();


        ((TextView)findViewById(R.id.txtAccountUsername)).setText("");
        ((TextView)findViewById(R.id.txtAccountPassword)).setText("");
        ((TextView)findViewById(R.id.txtAccountEmail)).setText("");
        ((TextView)findViewById(R.id.txtAccountPhone)).setText("");

    }

    public void clickToGoBack(View view) {
        finish();
    }
}