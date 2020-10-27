package com.pskovhack.immigrantsocial;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        Button email_next = (Button)  findViewById(R.id.email_button_next);
        final TextView text_email = (TextView) findViewById(R.id.text_email);

        email_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_email.setVisibility(View.VISIBLE);
            }
        });
    }
}
