package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Plantes extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantes);
        View imageView1 = findViewById(R.id.imageView1);
        // Set onClickListener for loginButton
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your loginButton logic here
                Intent intent = new Intent(Plantes.this, SuiviPlantes.class);
                startActivity(intent);
            }
        });
    }
}