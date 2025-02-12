package edu.zsk.a12022025_activity2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editName, editEmail;
    private TextView txt1, txt2;
    private Button btnIncrease;
    private int clickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicjalizacja widoków
        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        btnIncrease = findViewById(R.id.btn_increase);

        // Sprawdzenie stanu po obróceniu ekranu
        if (savedInstanceState != null) {
            clickCount = savedInstanceState.getInt("clickCount");
            txt2.setText("Kliknąłeś przycisk " + clickCount + " razy");
            txt1.setText(savedInstanceState.getString("txt1"));
        }

        // Ustawienie akcji na przycisk
        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String email = editEmail.getText().toString();

                // Sprawdzenie czy pola są wypełnione
                if (name.isEmpty() || email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Najpierw uzupełnij swoje dane", Toast.LENGTH_SHORT).show();
                } else {
                    // Aktualizacja liczby kliknięć
                    clickCount++;
                    txt2.setText("Kliknąłeś przycisk " + clickCount + " razy");

                    // Wstawienie danych do pola txt1
                    txt1.setText("Witaj, " + name + "! Twój adres e-mail to: " + email);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("clickCount", clickCount);
        outState.putString("txt1", txt1.getText().toString());
    }
}
