package com.project.asms1.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;

public class AdminHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
    }

    public void clickToCreateAccount(View view) {
        Intent intent = new Intent(AdminHomeActivity.this, CreateAccountActivity.class);
        startActivity(intent);
    }

    public void clickToLogout(View view) {
    }

    public void clickToManageAccount(View view) {
        Intent intent = new Intent(AdminHomeActivity.this, ManageAccountActivity.class);
        startActivity(intent);
    }
}