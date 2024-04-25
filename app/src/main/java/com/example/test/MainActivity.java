package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

public class MainActivity extends AppCompatActivity {

    private TextView titleTextView;
    private ImageView logoImageView;
    private Button signInButton;
    private Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        titleTextView = findViewById(R.id.titleTextView);
        logoImageView = findViewById(R.id.logoImageView);
        signInButton = findViewById(R.id.signInButton);
        createButton = findViewById(R.id.createButton);

        // Set onClickListener for signInButton
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your signInButton logic here
                Intent intent = new Intent(MainActivity.this, SignIn.class);
                startActivity(intent);
            }
        });

        // Set onClickListener for createButton
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the create account activity
                Intent intent = new Intent(MainActivity.this, Create.class);
                startActivity(intent);
            }
        });
    }
}
