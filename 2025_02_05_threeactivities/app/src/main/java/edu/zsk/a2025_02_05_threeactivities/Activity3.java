package edu.zsk.a2025_02_05_threeactivities;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
    }
}