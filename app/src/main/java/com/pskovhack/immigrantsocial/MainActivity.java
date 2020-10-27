package com.pskovhack.immigrantsocial;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button register = (Button) findViewById(R.id.register);
        Button login = (Button) findViewById(R.id.login);
        ImageButton out = (ImageButton) findViewById(R.id.out);

        LayoutInflater factory = LayoutInflater.from(this);
        final View DialogView = factory.inflate(R.layout.dialog_out, null);
        final AlertDialog Dialog = new AlertDialog.Builder(this).create();
        Dialog.setView(DialogView);
        DialogView.findViewById(R.id.yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.super.onDestroy();
            }
        });
        DialogView.findViewById(R.id.no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog.dismiss();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog.show();
            }
        });
    }
}