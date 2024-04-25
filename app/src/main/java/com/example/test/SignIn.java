package com.example.test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView rememberTextView;
    private TextView forgetPasswordTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // Initialize views
        emailEditText = findViewById(R.id.editText2);
        passwordEditText = findViewById(R.id.editText3);
        loginButton = findViewById(R.id.button);
        rememberTextView = findViewById(R.id.textView3);
        forgetPasswordTextView = findViewById(R.id.textView4);

        // Set onClickListener for loginButton
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your loginButton logic here
                Intent intent = new Intent(SignIn.this, Plantes.class);
                startActivity(intent);
            }
        });

        // Set onClickListener for rememberTextView
        rememberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your rememberTextView logic here
                // For example, toggle remember me functionality
            }
        });

        // Set onClickListener for forgetPasswordTextView
        forgetPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your forgetPasswordTextView logic here
                // For example, navigate to forgot password activity
            }
        });
    }
}
