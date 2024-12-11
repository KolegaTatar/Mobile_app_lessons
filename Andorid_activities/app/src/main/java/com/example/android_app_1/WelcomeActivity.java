package com.example.android_app_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private TextView welcomeText;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome); // Layout dla WelcomeActivity

        welcomeText = findViewById(R.id.welcomeTextLarge);
        logoutButton = findViewById(R.id.button);

        // Odbierz dane z MainActivity (e-mail użytkownika)
        String email = getIntent().getStringExtra("email");
        welcomeText.setText("Witaj w aplikacji! Zalogowano jako " + email);

        // Nasłuchiwanie na kliknięcie przycisku "Wyloguj"
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Powrót do MainActivity
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Zakończ działalność WelcomeActivity
            }
        });
    }
}
