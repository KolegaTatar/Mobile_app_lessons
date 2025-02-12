package edu.zsk.a2025_02_05_threeactivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        ImageView image1 = findViewById(R.id.image1);
        ImageView image2 = findViewById(R.id.image2);
        ImageView image3 = findViewById(R.id.image3);
        Button button4 = findViewById(R.id.button4);


        image1.setImageResource(R.drawable.image1);
        image2.setImageResource(R.drawable.image2);
        image3.setImageResource(R.drawable.image3);

        button4.setOnClickListener(v -> {
            Intent intent = new Intent(Activity3.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
