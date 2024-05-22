package com.example.test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageView ingenieurImageView = findViewById(R.id.ingenieur_image_view);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageView imageviewouvrier= findViewById(R.id.imageviewouvrier);
        ingenieurImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent pour ouvrir MainActivity
                Intent intent = new Intent(User.this, MainActivity.class);
                startActivity(intent);
            }
        });

        imageviewouvrier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent pour ouvrir MainActivity
                Intent intent = new Intent(User.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
