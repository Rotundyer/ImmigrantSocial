package com.pskovhack.immigrantsocial;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pskovhack.immigrantsocial.firebase.User;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Objects;

import okhttp3.OkHttpClient;

import java.util.concurrent.Executor;

public class DataActivity extends AppCompatActivity {

    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        final String email = Objects.requireNonNull(Objects.requireNonNull(getIntent().getExtras()).get("email")).toString();

        ImageView imageView = (ImageView) findViewById(R.id.first_image);
        imageView.setBackgroundResource(R.drawable.ic_forphotos);

        final EditText first_name = (EditText) findViewById(R.id.reg_first_name);
        final EditText second_name = (EditText) findViewById(R.id.reg_second_name);

        final Button reg_male = (Button) findViewById(R.id.reg_male);
        final Button reg_female = (Button) findViewById(R.id.reg_female);

        Button next = (Button) findViewById(R.id.reg_button_next);

        reg_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg_male.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_button_activate, 0, 0, 0);
                reg_female.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_button_non_activate, 0, 0, 0);
                a = 0;
            }
        });

        reg_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg_female.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_button_activate, 0, 0, 0);
                reg_male.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_button_non_activate, 0, 0, 0);
                a = 1;
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first_name != null && second_name != null) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("message");

                    myRef.setValue("Hello, World!");

                } else {
                    Toast.makeText(DataActivity.this, "Недостаточно данных", Toast.LENGTH_SHORT).show();
                }
            }
        });

        DatePickerDialog.OnDateSetListener Date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = Integer.toString(dayOfMonth) + Integer.toString(month) + Integer.toString(year);
            }
        };
    }
}
