package com.project.asms1.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.project.asms1.R;
import com.project.asms1.Utils.PopupMessage;
import com.project.asms1.Utils.SecurityLogic;
import com.project.asms1.model.User;
import com.project.asms1.network.UserUIService;

public class CreateAccountActivity extends AppCompatActivity {
    String username,password,confirm,email,name;
    CheckBox chkrole;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    public void clickToCreateAccount(View view) {
        int roleid;
        username = ((EditText)findViewById(R.id.edtUsernameCreateAccount)).getText().toString();
        password = ((EditText)findViewById(R.id.edtPassWordCreateAccount)).getText().toString();
        confirm = ((EditText)findViewById(R.id.edtConfirmPasswordCreateAccount)).getText().toString();
        email = ((EditText)findViewById(R.id.edtEmailCreateAccount)).getText().toString();
        name = ((EditText)findViewById(R.id.edtNameCreateAccount)).getText().toString();
        chkrole = findViewById(R.id.chkrolecreateaccount);

        if(chkrole.isChecked()){
            roleid = 1;
        }else {
            roleid = 2;
        }


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
        if (name.length() < 4) {
            error += "Name lenght is too short\n";
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
            String passwordnew = SecurityLogic.getMD5(password);
            User adduser = new User(passwordnew,username,name,email,roleid);
            UserUIService.addUser(adduser,CreateAccountActivity.this);
        }
    }

    public void showCustomDialog() {

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

    public void clickToGoBack(View view) {
        finish();
    }
}