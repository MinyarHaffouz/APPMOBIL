package com.example.test;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Action extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor temperatureSensor;
    private Sensor humiditySensor;
    private Sensor lightSensor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        TextView textView = findViewById(R.id.text_view_data);
        String data = getIntent().getStringExtra("data");
        textView.setText(data);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        humiditySensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        // Check if data contains temperature, humidity, or sunlight information and handle it accordingly
        if (data != null) {
            if (data.contains("Température")) {
                String[] parts = data.split(": ");
                if (parts.length == 2) {
                    String temperature = parts[1];
                    handleTemperature(Double.parseDouble(temperature.replaceAll("[^0-9]", "")));
                }
            } else if (data.contains("Humidité")) {
                String[] parts = data.split(": ");
                if (parts.length == 2) {
                    String humidite = parts[1];
                    handleHumidite(Double.parseDouble(humidite.replaceAll("[^0-9]", "")));
                }
            } else if (data.contains("État du soleil")) {
                // Handle sunlight information if needed
            }
        }

        // Register sensor listeners if available
        if (temperatureSensor != null) {
            sensorManager.registerListener(this, temperatureSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (humiditySensor != null) {
            sensorManager.registerListener(this, humiditySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (lightSensor != null) {
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

        // Define actions for buttons
        Button buttonActions = findViewById(R.id.button_actions);
        buttonActions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click actions here
            }
        });
    }

    private void handleTemperature(double temperature) {
        TextView textViewMessage = findViewById(R.id.text_view_message);

        // Example logic for handling temperature data
        if (temperature > 15) {
            textViewMessage.setText("Allumer la ventilation");
        } else {
            textViewMessage.setText("Éteindre la ventilation");
        }
    }

    private void handleHumidite(double humidite) {
        TextView textViewMessage = findViewById(R.id.text_view_message);

        // Example logic for handling humidity data
        if (humidite < 15) {
            textViewMessage.setText("Irrigation de 2 minutes");
        } else if (humidite >= 12 && humidite <= 15) {
            textViewMessage.setText("Irrigation de 5 minutes");
        } else {
            textViewMessage.setText("Irrigation de 10 minutes");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            float temperatureValue = event.values[0];
            startActionActivity("Température: " + temperatureValue + "°C");
        } else if (event.sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY) {
            float humidityValue = event.values[0];
            startActionActivity("Humidité: " + humidityValue + "%");
        } else if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            float lightValue = event.values[0];
            if (lightValue > 5000) {
                startActionActivity("État du soleil: Ensoleillé");
            } else {
                startActionActivity("État du soleil: Nuageux");
            }
        }
    }

    private void startActionActivity(String data) {
        if (data != null) {
            TextView textViewData = findViewById(R.id.text_view_data);
            textViewData.setText(data); // Afficher les données dans le TextView

            if (data.contains("Température")) {
                String[] parts = data.split(": ");
                if (parts.length == 2) {
                    String temperature = parts[1];
                    handleTemperature(Double.parseDouble(temperature.replaceAll("[^0-9]", "")));
                }
            } else if (data.contains("Humidité")) {
                String[] parts = data.split(": ");
                if (parts.length == 2) {
                    String humidite = parts[1];
                    handleHumidite(Double.parseDouble(humidite.replaceAll("[^0-9]", "")));
                }
            }
        }
    }




    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Handle sensor accuracy changes here if needed
    }
}
