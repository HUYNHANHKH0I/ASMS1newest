package com.project.asms1.presentation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;
import com.project.asms1.daos.UserDAO;
import com.project.asms1.model.User;
import com.project.asms1.network.UserUIService;

public class AdminHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        if(UserDAO.currentUser != null) {
            ((TextView)findViewById(R.id.txtWelcome)).setText("Welcome, " + UserDAO.currentUser.getName());
        }
    }

    public void clickToCreateAccount(View view) {
        Intent intent = new Intent(AdminHomeActivity.this, CreateAccountActivity.class);
        startActivity(intent);
    }

    public void clickToLogout(View view) {
        new AlertDialog.Builder(AdminHomeActivity.this).setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("LOGOUT").setMessage("Are you sure you want to LOGOUT?")
                    .setPositiveButton("No", null).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                UserUIService.deleteToken(AdminHomeActivity.this);
                Intent intent = new Intent(AdminHomeActivity.this, LoginActivity.class);
                startActivity(intent);
                AdminHomeActivity.this.finish();
            }
        }).show();
    }

    public void clickToManageAccount(View view) {
        Intent intent = new Intent(AdminHomeActivity.this, ManageAccountActivity.class);
        startActivity(intent);
    }
}