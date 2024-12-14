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
    private  TextView text_view_welcom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeText = findViewById(R.id.welcomeTextLarge);
        logoutButton = findViewById(R.id.button);
        text_view_welcom = findViewById(R.id.welcomeTextSmall);

        String email = getIntent().getStringExtra("email");
        welcomeText.setText("Witaj w aplikacji! Zalogowano jako " + email);
        text_view_welcom.setText("Zalogowano jako "+email);


        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
