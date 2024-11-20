package com.example.android_app_1;

import android.os.Bundle;
import android.view.View;
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
        final Button btn = findViewById(R.id.button);
        final EditText email = findViewById(R.id.editTextTextEmailAddress);
        final EditText pass1 = findViewById(R.id.editTextTextPassword);
        final EditText pass2 = findViewById(R.id.editTextTextPassword2);
        final TextView Komunikat = findViewById(R.id.textView7);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_T = email.getText().toString();
                String pass_T = pass1.getText().toString();
                String pass2_T = pass2.getText().toString();
                if (!email_T.contains("@")) {
                    Komunikat.setText("Nieprawidłowy adres e-mail");
                }
                else if (!pass_T.equals(pass2_T) ) {
                    Komunikat.setText("Hasła się różnią");
                }
                else {
                    Komunikat.setText("Witaj "+email_T );
                }

            }
        });
    }


}