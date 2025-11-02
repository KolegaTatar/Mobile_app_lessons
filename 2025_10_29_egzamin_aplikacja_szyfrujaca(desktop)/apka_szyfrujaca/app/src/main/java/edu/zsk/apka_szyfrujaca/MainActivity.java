package edu.zsk.apka_szyfrujaca;

import android.os.Bundle;
import android.service.notification.ZenPolicy;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText klucz_do_szyforwania;
    private EditText tekst_jawny;
    private Button przycisk_szyfruj;
    private TextView tekst_zaszyfrowany_tv;
    private Button przycisk_zapisz;

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

        klucz_do_szyforwania = findViewById(R.id.klucz);
        tekst_jawny = findViewById(R.id.tekst_do_szyfrowania);
        przycisk_szyfruj = findViewById(R.id.szyfruj);
        przycisk_zapisz = findViewById(R.id.zapisz);
        tekst_zaszyfrowany_tv = findViewById(R.id.zaszyfrowany);

        przycisk_szyfruj.setOnClickListener(v->{
            String tekst = tekst_jawny.getText().toString().toLowerCase();
            int klucz;
            String kluczStr = klucz_do_szyforwania.getText().toString();

            if(kluczStr.isEmpty()){
                klucz=0;
            }
            else{
                klucz = Integer.parseInt(kluczStr);
            }
            String zaszyfrowany = Szyfrowanie(tekst, klucz);
            tekst_zaszyfrowany_tv.setText(zaszyfrowany);
        });
        przycisk_zapisz.setOnClickListener(v-> {
            String tekstDoZapisu = tekst_zaszyfrowany_tv.getText().toString();

            if (tekstDoZapisu.isEmpty()) {
                Toast.makeText(MainActivity.this, "Najpierw zaszyfruj tekst!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Zapisano tekst: " + tekstDoZapisu, Toast.LENGTH_LONG).show();
            }
        });
    }

    protected String Szyfrowanie(String tekst_jawny, int klucz){
        String tekst_zaszyfrowany = "";

        int pierwsza_wartosc_ascii = 97;
        int ostatnia_wartosc_ascii = 122;
        int dlugosc_alfabetu = 26;

        for (int i = 0; i < tekst_jawny.length(); i++)
        {
            char litera;
            int cyfra_litery = tekst_jawny.charAt(i);

            if (cyfra_litery >= pierwsza_wartosc_ascii && cyfra_litery <= ostatnia_wartosc_ascii)
            {
                int pozycja_oryginalna = cyfra_litery - pierwsza_wartosc_ascii;
                int pozycja_zaszyfrowana = (pozycja_oryginalna + klucz % dlugosc_alfabetu + dlugosc_alfabetu) % dlugosc_alfabetu;


                litera = (char)(pozycja_zaszyfrowana + pierwsza_wartosc_ascii);
            }
            else
            {
                litera = (char)(cyfra_litery);
            }

            tekst_zaszyfrowany += litera;
        }

        return tekst_zaszyfrowany;
    }

}