package edu.zsk.u_weterynarza;


import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText ownerNameEditText, purposeEditText, inputDateEditText;
    private ListView speciesListView;
    private SeekBar ageSeekBar;
    private TextView ageValueTextView, outputTextView;
    private Button okButton;
    private String selectedSpecies = "Pies"; // Default selection

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ownerNameEditText = findViewById(R.id.owner_name);
        inputDateEditText = findViewById(R.id.date_edit_text);
        purposeEditText = findViewById(R.id.purpose);
        speciesListView = findViewById(R.id.species_list);
        ageSeekBar = findViewById(R.id.age_slider);
        ageValueTextView = findViewById(R.id.age_value);
        outputTextView = findViewById(R.id.output_text);
        okButton = findViewById(R.id.ok_button);


        inputDateEditText.setText("16:00");


        String[] speciesArray = {"Pies", "Kot", "Świnka morska"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, speciesArray);
        speciesListView.setAdapter(adapter);


        speciesListView.setOnItemClickListener((parent, view, position, id) -> {
            selectedSpecies = speciesArray[position];
            switch (selectedSpecies) {
                case "Pies":
                    ageSeekBar.setMax(18);
                    break;
                case "Kot":
                    ageSeekBar.setMax(20);
                    break;
                case "Świnka morska":
                    ageSeekBar.setMax(9);
                    break;
            }
            ageSeekBar.setProgress(0);
            ageValueTextView.setText("0");
        });


        ageSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ageValueTextView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });


        okButton.setOnClickListener(v -> {
            String ownerName = ownerNameEditText.getText().toString();
            int age = ageSeekBar.getProgress();
            String purpose = purposeEditText.getText().toString();
            String dateTime = inputDateEditText.getText().toString();


            String output = String.format("%s, %s, %d, %s, %s", ownerName, selectedSpecies, age, purpose, dateTime);
            outputTextView.setText(output);
        });
    }
}
