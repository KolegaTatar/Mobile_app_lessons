package edu.zsk.generowanie_hasla;

import android.os.Bundle;
import android.os.Message;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    private EditText imie, nazwisko,ile_znakow;
    private Spinner spiner_stanowisko;
    private CheckBox male_wielkie_litery, cyfry, znaki_specjalne;
    private Button btn_gen_haslo, btn_zatwierdz;

    private String lastGeneratedPassword = "";

    private static final String MALE = "abcdefghijklmnopqrstuvwxyz";
    private static final String WIELKIE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String CYFRY = "0123456789";
    private static final String SPECJALNE = "!@#$%^&*()_+-=";

    private final SecureRandom random = new SecureRandom();

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

        imie = findViewById(R.id.imie);
        nazwisko = findViewById(R.id.nazwisko);
        ile_znakow = findViewById(R.id.ile_znakow);
        male_wielkie_litery = findViewById(R.id.male_wielkie_litery);
        cyfry = findViewById(R.id.cyfry);
        znaki_specjalne = findViewById(R.id.znaki_specjalne);
        btn_zatwierdz = findViewById(R.id.zatwierdz);
        btn_gen_haslo = findViewById(R.id.generuj_haslo);
        spiner_stanowisko = findViewById(R.id.stanowisko);

        String[] positions = {"Kierownik", "Starszy programista", "Młodszy programista", "Tester"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, positions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner_stanowisko.setAdapter(adapter);

        btn_gen_haslo.setOnClickListener(v -> Generuj_haslo());

        btn_zatwierdz.setOnClickListener(v -> Zatwierdz());
        male_wielkie_litery.setChecked(true);


    }

    protected void Generuj_haslo() {
        int ile;
        try {
            ile = Integer.parseInt(ile_znakow.getText().toString());
        } catch (Exception e) {
            ile = 0;
        }

        StringBuilder haslo = new StringBuilder();
        String available = MALE;

        // dodawanie WYMAGANYCH znaków
        if (male_wielkie_litery.isChecked()) {
            haslo.append(WIELKIE.charAt(random.nextInt(WIELKIE.length())));
            available += WIELKIE;
        }

        if (cyfry.isChecked()) {
            haslo.append(CYFRY.charAt(random.nextInt(CYFRY.length())));
            available += CYFRY;
        }

        if (znaki_specjalne.isChecked()) {
            haslo.append(SPECJALNE.charAt(random.nextInt(SPECJALNE.length())));
            available += SPECJALNE;
        }

        while (haslo.length() < ile) {
            int index = random.nextInt(available.length());
            haslo.append(available.charAt(index));
        }

        lastGeneratedPassword = haslo.toString();

        new android.app.AlertDialog.Builder(this)
                .setMessage(lastGeneratedPassword)
                .setPositiveButton("OK", null)
                .show();
    }



    protected void Zatwierdz(){
        String im = imie.getText().toString();
        String naz = nazwisko.getText().toString();
        String st = spiner_stanowisko.getSelectedItem().toString();

        android.app.AlertDialog.Builder dialog =
                new android.app.AlertDialog.Builder(this);

        dialog.setMessage(
                "Dane pracownika: " + im + " " + naz + " " + st + " Hasło: " + lastGeneratedPassword
        );

        dialog.setPositiveButton("OK", null);
        dialog.show();
    }

}