package com.example.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class SuiviPlantes extends AppCompatActivity {
    private ImageView logoImageView;
    private Button buttonActions;
    private Button buttonJournalisation;
    private Spinner spinnerIndicateurs;
    private EditText editTextNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suivi_plantes);
        logoImageView = findViewById(R.id.logoImageView);
        buttonActions = findViewById(R.id.button_actions);
        buttonJournalisation = findViewById(R.id.button_journalisation);
        spinnerIndicateurs = findViewById(R.id.spinner_indicateurs);
        editTextNote = findViewById(R.id.editText1);

        // Définition des actions des boutons
        buttonActions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtenez la date système
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
                String currentDate = dateFormat.format(new Date());

                // Créez un AlertDialog pour afficher le tableau et le champ de texte
                AlertDialog.Builder builder = new AlertDialog.Builder(SuiviPlantes.this);
                builder.setTitle("Informations");

                // Créez une mise en page pour le contenu de l'AlertDialog
                LinearLayout layout = new LinearLayout(SuiviPlantes.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                // Ajoutez un TextView pour afficher la date système
                TextView dateTextView = new TextView(SuiviPlantes.this);
                dateTextView.setText("Date: " + currentDate);
                layout.addView(dateTextView);

                // Ajoutez des cases à cocher pour les actions
                CheckBox arrosageCheckBox = new CheckBox(SuiviPlantes.this);
                arrosageCheckBox.setText("Arrosage");
                layout.addView(arrosageCheckBox);

                CheckBox engraisCheckBox = new CheckBox(SuiviPlantes.this);
                engraisCheckBox.setText("Engrais");
                layout.addView(engraisCheckBox);

                CheckBox checkBox3 = new CheckBox(SuiviPlantes.this);
                checkBox3.setText("XXXX");
                layout.addView(checkBox3);

                CheckBox checkBox4 = new CheckBox(SuiviPlantes.this);
                checkBox4.setText("YYYYY");
                layout.addView(checkBox4);

                // Ajoutez un champ de texte pour saisir les informations
                final EditText infoEditText = new EditText(SuiviPlantes.this);
                infoEditText.setHint("Saisissez les informations ici");
                layout.addView(infoEditText);

                // Définissez la vue personnalisée pour l'AlertDialog
                builder.setView(layout);

                // Ajoutez un bouton "OK" pour fermer l'AlertDialog
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Récupérez les informations saisies par l'utilisateur
                        String info = infoEditText.getText().toString();

                        // Vérifiez quelles cases à cocher sont cochées
                        StringBuilder checkedActions = new StringBuilder();
                        if (arrosageCheckBox.isChecked()) {
                            checkedActions.append("Arrosage, ");
                        }
                        if (engraisCheckBox.isChecked()) {
                            checkedActions.append("Engrais, ");
                        }
                        if (checkBox3.isChecked()) {
                            checkedActions.append("XXXX, ");
                        }
                        if (checkBox4.isChecked()) {
                            checkedActions.append("YYYYY, ");
                        }

                        // Faites ce que vous devez avec les informations saisies
                        // Par exemple, vous pouvez les enregistrer dans une base de données ou les afficher autrement

                        // Affichez un toast pour indiquer que l'action est terminée
                        Toast.makeText(SuiviPlantes.this, "Informations enregistrées: " + info + "\nActions sélectionnées: " + checkedActions.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

                // Affichez l'AlertDialog
                builder.show();
            }
        });




    }
}