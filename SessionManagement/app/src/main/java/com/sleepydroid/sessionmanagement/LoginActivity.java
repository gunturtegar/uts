package com.sleepydroid.sessionmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editEmail, editPassword;
    Button buttonLogin;
    SessionManagement sessionManagement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManagement = new SessionManagement(LoginActivity.this);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        if (sessionManagement.isLoggedIn()) {
            goToActivity();
        }
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();
                if(email.equals("") || email.trim().isEmpty() || password.equals("") || password.trim().isEmpty() ) {
                    Toast.makeText(LoginActivity.this,"Username Password harus diisi",Toast.LENGTH_LONG).show();
                }
                else
                {
                    sessionManagement.createLoginSession(email, password);
                    goToActivity();
                }
            }
        });
    }
    private void goToActivity(){
        Intent mIntent = new Intent(getApplicationContext(),
                MainActivity.class);
        startActivity(mIntent);
    }

}
