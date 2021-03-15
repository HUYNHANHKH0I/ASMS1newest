package com.project.asms1.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.project.asms1.R;
import com.project.asms1.daos.UserDAO;
import com.project.asms1.network.UserUIService;

public class UserSettingActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageButton btnSave;
    private EditText txtupdateusername,txtupdateemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);

        initData();




    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void initData(){
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Thiết lập cá nhân");
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        btnSave = findViewById(R.id.btnSaveUserInfor);
        txtupdateemail = findViewById(R.id.updateemail);
        txtupdateusername = findViewById(R.id.updateusername);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDAO.currentUser.setEmail(txtupdateemail.getText().toString());
                UserDAO.currentUser.setName(txtupdateusername.getText().toString());
                UserUIService.updateUser(UserSettingActivity.this);


            }
        });

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}