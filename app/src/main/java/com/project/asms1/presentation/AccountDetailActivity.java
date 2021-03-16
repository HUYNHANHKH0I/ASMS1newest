package com.project.asms1.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.project.asms1.R;

public class AccountDetailActivity extends AppCompatActivity {
    private boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail);

        Intent intent = getIntent();
        ((TextView)findViewById(R.id.txtUsername)).setText("username");
        ((TextView)findViewById(R.id.txtPassword)).setText("password");
        ((TextView)findViewById(R.id.txtEmail)).setText("email");
        ((TextView)findViewById(R.id.txtPhone)).setText("phone");
        status = true;
        setStatusButton();
    }

    public void clickToGoBack(View view) {
        finish();
    }

    public void clickToEditAccount(View view) {

    }

    public void ClickToChangeAccountStatus(View view) {
        if (status) {
            status = false;
        } else {
            status = true;
        }
        setStatusButton();
    }
    public void setStatusButton() {
        Button btnChangeStatus =  (Button) findViewById(R.id.btnChangeStatus);
        if (!status) {
            btnChangeStatus.setText("Activate");
        } else {
            btnChangeStatus.setText("Deactivate");
        }
    }
}