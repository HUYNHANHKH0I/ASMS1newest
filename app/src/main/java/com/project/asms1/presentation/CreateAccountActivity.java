package com.project.asms1.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;
import com.project.asms1.Utils.PopupMessage;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    public void clickToCreateAccount(View view) {
        String username = ((EditText)findViewById(R.id.edtUsername)).getText().toString();
        String password = ((EditText)findViewById(R.id.edtPassWord)).getText().toString();
        String confirm = ((EditText)findViewById(R.id.edtConfirmPassword)).getText().toString();
        String email = ((EditText)findViewById(R.id.edtEmail)).getText().toString();
        String phone = ((EditText)findViewById(R.id.edtMobileNumber)).getText().toString();

        String error = "";
        if (username.length() < 6) {
            error += "Username must have at least 6 characters.\n";
        }
        if (password.length() < 6) {
            error += "Password must have at least 6 characters.\n";
        }
        if (!password.equals(confirm)) {
            error += "Password must match confirm.\n";
        }
        if (email.length() < 1) {
            error += "Email is invalid.\n";
        }
        if (phone.length() < 10) {
            error += "Invalid phone number\n";
        }
        if (!error.isEmpty()) {
            final PopupMessage popup = new PopupMessage();
            popup.showPopupWindow(view,error);

            ((Button)popup.getPopupView().findViewById(R.id.btnClosePopup)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.getPopupWindow().dismiss();
            }
        });

//            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        } else {
            //TODO : insert create account code here
        }
    }

    public void clickToGoBack(View view) {
        finish();
    }
}