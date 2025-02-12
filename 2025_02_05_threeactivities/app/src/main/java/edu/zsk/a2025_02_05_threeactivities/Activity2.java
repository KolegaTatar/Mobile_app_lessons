package edu.zsk.a2025_02_05_threeactivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TextView longText = findViewById(R.id.longText);
        Button button3 = findViewById(R.id.button3);

        longText.setText("To jest długi tekst, który może być częścią aktywności 2. Możesz go dostosować, aby wyświetlić dowolne informacje.");

        button3.setOnClickListener(v -> {
            Intent intent = new Intent(Activity2.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
