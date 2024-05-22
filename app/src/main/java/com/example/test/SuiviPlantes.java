package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class SuiviPlantes extends AppCompatActivity {
    private ImageView logoImageView;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suivi_plantes);
        logoImageView = findViewById(R.id.imageView);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
// Récupération de l'ID de l'image à partir de l'intent
        int imageResId = getIntent().getIntExtra("imageResId", 0);
        if (imageResId != 0) {
            // Affichage de l'image dans l'ImageView
            logoImageView.setImageResource(imageResId);
        }
        // Ajouter un écouteur de clic à l'image de température
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Définir l'intent pour démarrer l'activité Action avec les données de température
                Intent intent = new Intent(SuiviPlantes.this, Action.class);

                startActivity(intent);
            }
        });

        // Ajouter un écouteur de clic à l'image d'humidité
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Définir l'intent pour démarrer l'activité Action avec les données d'humidité
                Intent intent = new Intent(SuiviPlantes.this, Action.class);

                startActivity(intent);
            }
        });

        // Ajouter un écouteur de clic à l'image de luminosité
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Définir l'intent pour démarrer l'activité Action avec les données de luminosité
                Intent intent = new Intent(SuiviPlantes.this, Action.class);

                startActivity(intent);
            }
        });
    }
}




