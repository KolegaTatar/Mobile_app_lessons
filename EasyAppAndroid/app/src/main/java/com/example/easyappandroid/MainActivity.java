package com.example.easyappandroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText4 = findViewById(R.id.editText4);
        Button button5 = findViewById(R.id.button5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toastText = editText4.getText().toString();
                Toast.makeText(MainActivity.this, toastText, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onButton2Click(View view) {
        EditText editText1 = findViewById(R.id.editText1);
        TextView textView3 = findViewById(R.id.textView3);
        String inputText = editText1.getText().toString();
        textView3.setText(inputText);
    }
}



