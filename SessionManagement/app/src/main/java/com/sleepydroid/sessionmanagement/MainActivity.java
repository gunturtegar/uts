package com.sleepydroid.sessionmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

        TextView txtUsername;
        Button btnLogout, btnDatabase;
        SessionManagement sessionManagement;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            sessionManagement = new SessionManagement(MainActivity.this);
            btnLogout = findViewById(R.id.btnLogout);
            txtUsername = findViewById(R.id.txtUsername);
            btnDatabase = findViewById(R.id.btnDatabase);

            btnDatabase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, EditableListView.class);
                    startActivity(intent);
                }
            });

            if(sessionManagement.isLoggedIn())
            {
                HashMap<String,String> loginUser = sessionManagement.getUserInformation();
                txtUsername.setText(loginUser.get(sessionManagement.KEY_EMAIL));
            }
            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sessionManagement.logoutUser();
                }
            });
        }



}

