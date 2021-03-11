package com.project.asms1.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;

import static com.project.asms1.R.*;

public class HomePageActivity extends AppCompatActivity {
    Button btnUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home_page);
        btnUser = findViewById(id.btnUser);
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this,UserInforActivity.class);
                startActivity(intent);
            }
        });
    }
}