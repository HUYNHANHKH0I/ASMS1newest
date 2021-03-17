package com.project.asms1.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;
import com.project.asms1.daos.UserDAO;
import com.project.asms1.model.User;

public class AdminHomeActivity extends AppCompatActivity {
    private static User user = UserDAO.currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        ((TextView)findViewById(R.id.txtWelcome)).setText("Welcome, " + user.getName());
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