package com.techsoldev.tictactoegame;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout start_EDT_email;
    private TextInputLayout start_EDT_password;
    private MaterialButton start_BTN_login;
    private MaterialTextView start_TXT_forgot;
    private TextInputLayout[] loginFields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Cade-Hub

        findViews();
        initBTNs();


    }



    private void initBTNs() {

        start_BTN_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { login();}
        });

    }


    private void login() {
        if (isValid()) {
            String email, password;
            email = start_EDT_email.getEditText().getText().toString().trim();
            password = start_EDT_password.getEditText().getText().toString().trim();

            // on success:
            finish();
            Intent intent = new Intent(LoginActivity.this, OfflineGameMenuActivity.class);
            startActivity(intent);

        }

        else
            Toast.makeText(this, "One or more field are invalid!", Toast.LENGTH_LONG).show();

    }


    private boolean isValid() {
        for (TextInputLayout field : loginFields) {
            if (field.getError() != null || field.getEditText().getText().toString().isEmpty())
                return false;
        }
        return true;
    }





    private void findViews() {
        start_EDT_email = findViewById(R.id.start_EDT_email);
        start_EDT_password = findViewById(R.id.start_EDT_password);
        start_BTN_login = findViewById(R.id.start_BTN_login);
        start_TXT_forgot = findViewById(R.id.start_TXT_forgot);
        loginFields = new TextInputLayout[] {
                start_EDT_email,
                start_EDT_password
        };
    }
}
