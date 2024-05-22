package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Create extends AppCompatActivity {

    private EditText fullNameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button signUpButton;
    private TextView rememberTextView;
    private TextView forgetPasswordTextView;
    private Button connectGmailButton;
    private Button connectFacebookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        // Initialize views
        fullNameEditText = findViewById(R.id.editText1);
        emailEditText = findViewById(R.id.editText2);
        passwordEditText = findViewById(R.id.editText3);
        signUpButton = findViewById(R.id.button);
        rememberTextView = findViewById(R.id.textView3);
        forgetPasswordTextView = findViewById(R.id.textView4);
        connectGmailButton = findViewById(R.id.btnConnectGmail);
        connectFacebookButton = findViewById(R.id.btnConnectFacebook);

        // Set onClickListener for signUpButton
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your signUpButton logic here
                Intent intent = new Intent(Create.this, SignIn.class);
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

        // Set onClickListener for connectGmailButton
        connectGmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your connectGmailButton logic here
                // For example, handle sign up with Gmail
            }
        });

        // Set onClickListener for connectFacebookButton
        connectFacebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your connectFacebookButton logic here
                // For example, handle sign up with Facebook
            }
        });
    }
}
