package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Plantes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantes);

        // Création du OnClickListener pour chaque image
        View.OnClickListener imageClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupération de l'ID de l'image à partir du tag de la vue
                int imageResId = (int) v.getTag();

                // Création de l'intent pour ouvrir l'activité SuiviPlantes
                Intent intent = new Intent(Plantes.this, Observations.class);
                // Ajout de l'ID de l'image à l'intent
                intent.putExtra("imageResId", imageResId);
                // Démarrage de l'activité SuiviPlantes
                startActivity(intent);
            }
        };

        // Associer le OnClickListener à chaque ImageView
        ImageView[] imageViews = {findViewById(R.id.imageView1), findViewById(R.id.imageView2), findViewById(R.id.imageView3), findViewById(R.id.imageView4), findViewById(R.id.imageView5), findViewById(R.id.imageView6)};

        // Récupérer les ID des images à partir de leurs tags
        int[] imageIds = {R.drawable.tomate, R.drawable.piment, R.drawable.choux, R.drawable.pommedeterre, R.drawable.melon, R.drawable.concombre};

        for (int i = 0; i < imageViews.length; i++) {
            imageViews[i].setOnClickListener(imageClickListener);
            // Définir l'ID de l'image comme tag pour chaque ImageView
            imageViews[i].setTag(imageIds[i]);
        }
    }
}

