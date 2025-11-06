package edu.zsk.rgb_app;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView duzy_kwadrat, R_wartosc, G_wartosc, B_wartosc, maly_kwadrat;
    private SeekBar R_suwak,G_suwak,B_suwak;
    private Button przycisk_pobierz;
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

        duzy_kwadrat = findViewById(R.id.duzy_kwadrat);
        maly_kwadrat = findViewById(R.id.maly_kwadrat);
        R_wartosc = findViewById(R.id.R_wartosc);
        G_wartosc = findViewById(R.id.G_wartosc);
        B_wartosc = findViewById(R.id.B_wartosc);
        R_suwak = findViewById(R.id.R_suwak);
        G_suwak = findViewById(R.id.G_suwak);
        B_suwak = findViewById(R.id.B_suwak);
        przycisk_pobierz = findViewById(R.id.przycisk_pobierz);

        R_wartosc.setText("255");
        G_wartosc.setText("255");
        B_wartosc.setText("255");

        R_suwak.setMax(255);
        G_suwak.setMax(255);
        B_suwak.setMax(255);
        R_suwak.setProgress(255);
        G_suwak.setProgress(255);
        B_suwak.setProgress(255);




        R_suwak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                R_wartosc.setText(String.valueOf(progress));
                duzy_kwadrat.setBackgroundColor(Color.rgb(R_suwak.getProgress(),G_suwak.getProgress(),B_suwak.getProgress()));
            }
        });

        G_suwak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                G_wartosc.setText(String.valueOf(progress));
                duzy_kwadrat.setBackgroundColor(Color.rgb(R_suwak.getProgress(),G_suwak.getProgress(),B_suwak.getProgress()));
            }
        });

        B_suwak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                B_wartosc.setText(String.valueOf(progress));
                duzy_kwadrat.setBackgroundColor(Color.rgb(R_suwak.getProgress(),G_suwak.getProgress(),B_suwak.getProgress()));
            }
        });

        przycisk_pobierz.setOnClickListener(v->{
            int R_wartosc_liczbowa = R_suwak.getProgress();
            int G_wartosc_liczbowa = G_suwak.getProgress();
            int B_wartosc_liczbowa = B_suwak.getProgress();

            int colorRGB = Color.rgb(R_suwak.getProgress(),G_suwak.getProgress(),B_suwak.getProgress());
            duzy_kwadrat.setBackgroundColor(colorRGB);
            maly_kwadrat.setBackgroundColor(colorRGB);
            maly_kwadrat.setText(R_wartosc_liczbowa+", "+G_wartosc_liczbowa+", "+B_wartosc_liczbowa );
        });

    }
}