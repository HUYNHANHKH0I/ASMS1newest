package com.project.asms1.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;
import com.project.asms1.Utils.PopupMessage;

public class CreateAccountActivity extends AppCompatActivity {
    String username,password,confirm,email,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    public void clickToCreateAccount(View view) {
        username = ((EditText)findViewById(R.id.edtUsernameCreateAccount)).getText().toString();
        password = ((EditText)findViewById(R.id.edtPassWordCreateAccount)).getText().toString();
        confirm = ((EditText)findViewById(R.id.edtConfirmPasswordCreateAccount)).getText().toString();
        email = ((EditText)findViewById(R.id.edtEmailCreateAccount)).getText().toString();
        name = ((EditText)findViewById(R.id.edtNameCreateAccount)).getText().toString();

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
        if (name.isEmpty()) {
            error += "Name cannot be empty.\n";
        }
        if (!error.isEmpty()) {
            final PopupMessage popup = new PopupMessage();
            popup.showPopupWindow(view,error,false);

            ((Button)popup.getPopupView().findViewById(R.id.btnClosePopup)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.getPopupWindow().dismiss();
            }
        });
        } else {
            //TODO : insert create account code here
        }
    }

    public void clickToGoBack(View view) {
        finish();
    }

}