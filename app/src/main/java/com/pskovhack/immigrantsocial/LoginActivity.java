package com.pskovhack.immigrantsocial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText email = (EditText) findViewById(R.id.log_email);
        final EditText password = (EditText) findViewById(R.id.log_pas);

        Button button_login = (Button) findViewById(R.id.login_button_next);
        Button vost_email = (Button) findViewById(R.id.vost_email);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                LoginActivity.this.startActivity(intent);
                LoginActivity.this.finish();
            }
        });

        vost_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, EmailActivity.class);
                LoginActivity.this.startActivity(intent);
                LoginActivity.this.finish();
            }
        });
    }
}
