package com.example.android_app_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private EditText email, pass1, pass2;
    private TextView komunikat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        email = findViewById(R.id.editTextTextEmailAddress);
        pass1 = findViewById(R.id.editTextTextPassword);
        pass2 = findViewById(R.id.editTextTextPassword2);
        komunikat = findViewById(R.id.textView7);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_T = email.getText().toString();
                String pass_T = pass1.getText().toString();
                String pass2_T = pass2.getText().toString();


                if (email_T.isEmpty() || pass_T.isEmpty() || pass2_T.isEmpty()) {
                    komunikat.setText("Brak wymaganych danych!");
                    komunikat.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }

                else if (!isValidEmail(email_T)) {
                    komunikat.setText("Nieprawidłowy adres e-mail");
                    komunikat.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }
                else if (!pass_T.equals(pass2_T)) {
                    komunikat.setText("Hasła się różnią");
                    komunikat.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }
                else if (!isValidPassword(pass_T)) {
                    komunikat.setText("Hasło musi zawierać minimum 8 znaków, w tym cyfrę, wielką i małą literę");
                    komunikat.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }
                else {
                    komunikat.setText("Witaj " + email_T);
                    komunikat.setTextColor(getResources().getColor(android.R.color.black));

                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    intent.putExtra("email", email_T);
                    startActivity(intent);
                }
            }
        });
    }


    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}";
        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
