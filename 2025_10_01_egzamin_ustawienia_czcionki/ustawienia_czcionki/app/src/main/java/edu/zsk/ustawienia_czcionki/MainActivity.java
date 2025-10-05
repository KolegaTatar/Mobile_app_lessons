package edu.zsk.ustawienia_czcionki;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String[] cytaty ={"Dzień dobry", "Good morning", "Buenos dias"};

    private TextView napis;
    private TextView trescRozmiaru;
    private Button nastepny;
    private SeekBar seakbar;

    private int index = 0;



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

        napis= findViewById(R.id.napis);
        nastepny = findViewById(R.id.nastepny);
        seakbar = findViewById(R.id.seakbar);
        trescRozmiaru = findViewById(R.id.tresc_rozmiaru);

        napis.setText(cytaty[0]);
        int rozmiarCzcionki =10;
        napis.setTextSize(rozmiarCzcionki);

        seakbar.setMax(40);
        seakbar.setMin(0);
        seakbar.setProgress(rozmiarCzcionki);

        seakbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int nowyRozmiar = progress;
                if (nowyRozmiar <= 0) {
                    nowyRozmiar = 1;
                }
                trescRozmiaru.setText("Rozmiar: " + nowyRozmiar);
                napis.setTextSize(nowyRozmiar);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }

        });


        nastepny.setOnClickListener(v->{
            if(index != 2){
                index++;
                napis.setText(cytaty[index]);
            }
            else{
                index=0;
                napis.setText(cytaty[index]);
            }
        });
    }



}