package com.project.asms1.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;

public class SellerHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_home);
    }

    public void clickToGoToPost(View view) {
        Intent intent = new Intent(SellerHomeActivity.this, ManagePostActivity.class);
        startActivity(intent);

    }

    public void clickToGoToStore(View view) {
        Intent intent = new Intent(SellerHomeActivity.this, ManageStoreActivity.class);
        startActivity(intent);

    }

    public void clickToLogout(View view) {

    }
}