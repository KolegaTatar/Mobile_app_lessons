package edu.zsk.notatki_tekstowe;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private String[] notatki = {
            "Zakupy: chleb, masło, ser",
            "Do zrobienia: obiad, umyć podłogi",
            "weekend: kino, spacer z psem"
    };
    private EditText notatki_tresc;
    private Button przycisk_dodania_notatki;
    private ListView lista_notatek;

    private ArrayList<String> notesList;
    private ArrayAdapter<String> adapter;

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

        notatki_tresc = findViewById(R.id.tresc_notatki);
        przycisk_dodania_notatki = findViewById(R.id.przycisk);
        lista_notatek= findViewById(R.id.lista_notatek);

        notesList = new ArrayList<>(Arrays.asList(notatki));

        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,notesList);

        lista_notatek.setAdapter(adapter);

        przycisk_dodania_notatki.setOnClickListener(v->onClick());
    }

    protected void onClick(){
        String nowa_notatka =notatki_tresc.getText().toString();
        notesList.add(nowa_notatka);
        adapter.notifyDataSetChanged();
        notatki_tresc.setText("");
    }
}