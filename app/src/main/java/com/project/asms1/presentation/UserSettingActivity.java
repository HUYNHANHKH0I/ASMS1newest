package com.project.asms1.presentation;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.project.asms1.R;
import com.project.asms1.daos.UserDAO;
import com.project.asms1.network.UserUIService;

public class UserSettingActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageButton btnSave;
    private EditText txtupdateusername,txtupdateemail;
    private AlertDialog alertDialog;


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
        findViewById(R.id.touchheresetting).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyboard();
                if (txtupdateemail.getText().toString() != null  && !txtupdateemail.getText().toString().equals("")) {
                    UserDAO.currentUser.setEmail(txtupdateemail.getText().toString());
                }
                if (txtupdateusername.getText().toString() != null && !txtupdateusername.getText().toString().equals("")) {
                    UserDAO.currentUser.setName(txtupdateusername.getText().toString());
                }
                UserUIService.updateUser(UserSettingActivity.this);
                showCustomDialog();
            }
        });

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void showCustomDialog() {

        ViewGroup viewGroup = findViewById(android.R.id.content);

        View dialogView = LayoutInflater.from(this).inflate(R.layout.popupdialoglayout, viewGroup, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setView(dialogView);
        alertDialog = builder.create();
        alertDialog.show();
        Button done = dialogView.findViewById(R.id.btnDone);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                onBackPressed();
            }
        });
    }

    private void closeKeyboard()
    {
        View view = this.getCurrentFocus();
        if (view != null) {
            view.clearFocus();
            InputMethodManager manager
                    = (InputMethodManager)
                    getSystemService(
                            UserSettingActivity.INPUT_METHOD_SERVICE);
            manager
                    .hideSoftInputFromWindow(
                            view.getWindowToken(), 0);
        }
    }
}