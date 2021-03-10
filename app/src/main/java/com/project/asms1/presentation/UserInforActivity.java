package com.project.asms1.presentation;

import androidx.appcompat.app.AppCompatActivity;
import com.project.asms1.R;
import com.project.asms1.network.UserUIService;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserInforActivity extends AppCompatActivity {
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_infor);
        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(UserInforActivity.this).setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Closing Activity").setMessage("Are you sure you want to đăng xuất!")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                UserUIService.deleteToken(UserInforActivity.this);
                                Intent intent = new Intent(UserInforActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }).setNegativeButton("No", null).show();
            }
        });

    }
}