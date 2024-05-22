package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplachScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 5000; // 5 seconds

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach_screen);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        // Create animation for image
        Animation imageAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        imageView.startAnimation(imageAnimation);

        // Create animation for text
        Animation textAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        textView.startAnimation(textAnimation);

        // Start your app main activity after a delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplachScreen.this, User.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
