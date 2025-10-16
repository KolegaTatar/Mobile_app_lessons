package edu.zsk.egzamin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int licznik_polubien =0;
    private Button przycisk_1;
    private Button przycisk_2;
    private Button przycisk_3;
    private TextView liczba_polubien;

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


        przycisk_1 = findViewById(R.id.przycisk_1);
        przycisk_2 = findViewById(R.id.przycisk_2);
        przycisk_3 = findViewById(R.id.przycisk_3);
        liczba_polubien = findViewById(R.id.liczba_polubien);

        przycisk_1.setOnClickListener(v->dodajPolubienie());
        przycisk_2.setOnClickListener(v->usunPolubienie());

    }

    protected void dodajPolubienie(){
        licznik_polubien++;
        liczba_polubien.setText(licznik_polubien+" polubień");

    }

    protected void usunPolubienie(){
        licznik_polubien--;
        if(licznik_polubien<=0){
            licznik_polubien =0;
        }
        liczba_polubien.setText(licznik_polubien+" polubień");
    }
}