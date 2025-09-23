package edu.zsk.a2025_09_10;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView[] diceViews;
    private Button btnRoll;
    private Button btnReset;
    private TextView tvLastRoll;
    private TextView tvTotalScore;

    private int totalScore =0;

    private final int[] diceDrawableIds = {
            R.drawable.k1,
            R.drawable.k2,
            R.drawable.k3,
            R.drawable.k4,
            R.drawable.k5,
            R.drawable.k6
    };

    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Kosci");


        diceViews = new ImageView[]{
                findViewById(R.id.dice1),
                findViewById(R.id.dice2),
                findViewById(R.id.dice3),
                findViewById(R.id.dice4),
                findViewById(R.id.dice5)
        };

        btnRoll = findViewById(R.id.btnRoll);
        btnReset = findViewById(R.id.btnReset);
        tvLastRoll = findViewById(R.id.tvLastRoll);
        tvTotalScore = findViewById(R.id.tvTotalScore);

        btnRoll.setOnClickListener(v->rollDice());
        btnReset.setOnClickListener(v->resetGame());
    }


    private void rollDice() {
        int[] rolls = new int[5];

        for(int i=0;i<rolls.length;i++){
            rolls[i] = random.nextInt(6)+1;
            diceViews[i].setImageResource(diceDrawableIds[rolls[i] - 1]);
        }

        int rollScore =0;
        for(int value:rolls){
            rollScore+=value;
        }
        totalScore+=rollScore;

        tvTotalScore.setText("Wynik gry: "+totalScore);
        tvLastRoll.setText("Wynik tego losowania: "+rollScore);
    }

    private void resetGame(){
        for(ImageView iv:diceViews){
            iv.setImageResource(R.drawable.question);
        }
        totalScore =0;

        tvTotalScore.setText("Wynik gry: "+totalScore);
        tvLastRoll.setText("Wynik tego losowania: 0");
    }



}