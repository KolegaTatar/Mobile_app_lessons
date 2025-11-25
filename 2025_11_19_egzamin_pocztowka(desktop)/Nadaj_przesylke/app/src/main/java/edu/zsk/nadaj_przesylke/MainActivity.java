package edu.zsk.nadaj_przesylke;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btn_zatwierdz, btn_cena;
    private EditText miasto, kod_pocztowy, nr_ulicy;
    private TextView cenaText;
    private ImageView obrazView;
    private RadioGroup radio_group;
    private RadioButton pocztowkaRadio, listRadio, paczkaRadio;
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

        btn_zatwierdz = findViewById(R.id.btn_zatwierdz);
        btn_cena = findViewById(R.id.btn_cena);

        miasto = findViewById(R.id.miasto);
        kod_pocztowy = findViewById(R.id.kod_pocztowy);
        nr_ulicy = findViewById(R.id.nr_ulicy);

        obrazView = findViewById(R.id.zdjecie);
        cenaText = findViewById(R.id.cena_text);

        radio_group = findViewById(R.id.radio_group);
        pocztowkaRadio = findViewById(R.id.pocztowka);
        listRadio = findViewById(R.id.list);
        paczkaRadio = findViewById(R.id.paczka);

        pocztowkaRadio.setChecked(true);
        obrazView.setImageResource(R.drawable.pocztowka);
        cenaText.setText("Cena: 1 zł");

        btn_zatwierdz.setOnClickListener(v->Zatwierdz());
        btn_cena.setOnClickListener(v->Sprawdz_cene());
    }
    protected void Sprawdz_cene(){
        if(pocztowkaRadio.isChecked()){
            obrazView.setImageResource(R.drawable.pocztowka);
            cenaText.setText("Cena: 1 zł");
        }
        else if(listRadio.isChecked()){
            obrazView.setImageResource(R.drawable.list);
            cenaText.setText("Cena: 1,5 zł");
        }
        else if(paczkaRadio.isChecked()){
            obrazView.setImageResource(R.drawable.paczka);
            cenaText.setText("Cena: 10 zł");
        }
    }

    protected void Zatwierdz(){
        String KodPocztowy = kod_pocztowy.getText().toString().trim();

        try {
            Integer.parseInt(KodPocztowy);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Kod pocztowy powinien się składać z samych cyfr", Toast.LENGTH_SHORT).show();
            return;
        }
        if(KodPocztowy.length()!=5){
            Toast.makeText(this,"Nieprawidłowa liczba cyfr w kodzie pocztowym",Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Dane przesyłki zostały wprowadzone",Toast.LENGTH_SHORT).show();

    }

}