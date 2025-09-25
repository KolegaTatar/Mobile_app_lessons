package edu.zsk.a2025_09_24_egzamin_urzadzenia_domowe;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btn_device_1;
    private Button btn_device_2;
    private EditText input_device_1;
    private TextView under_text_pralka;
    private TextView under_text_odkurzacz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        btn_device_1 = findViewById(R.id.btn_device_1);
        btn_device_2 = findViewById(R.id.btn_device_2);
        input_device_1 = findViewById(R.id.input_device_1);
        under_text_pralka = findViewById(R.id.under_text_pralka);
        btn_device_2 = findViewById(R.id.btn_device_2);
        under_text_odkurzacz = findViewById(R.id.under_text_odkurzacz);


        btn_device_1.setOnClickListener(v -> onClick_device_1());
        btn_device_2.setOnClickListener(v -> onClick_device_2());

    }

    protected void onClick_device_1() {
        String valueStr = input_device_1.getText().toString();

        if (!valueStr.isEmpty()) {
            int value = Integer.parseInt(valueStr);

            if (value >= 1 && value <= 12) {
                under_text_pralka.setText("Numer prania:" + value);
            }
        }
    }

    protected void onClick_device_2() {
        String valueStr = btn_device_2.getText().toString();

        if (valueStr.equals("Włącz")) {
            btn_device_2.setText("Wyłącz");
            under_text_odkurzacz.setText("Odkurzacz włączony");
        }
        else {
            btn_device_2.setText("Włącz");
            under_text_odkurzacz.setText("Odkurzacz wyłączony");
        }
    }
}