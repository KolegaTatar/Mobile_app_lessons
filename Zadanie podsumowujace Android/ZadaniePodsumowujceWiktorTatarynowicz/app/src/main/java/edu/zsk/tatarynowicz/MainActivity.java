package edu.zsk.tatarynowicz;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText emailInput, passwordInput;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        Button loginButton = findViewById(R.id.loginButton);

        initDb();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Wypełnij wszystkie pola!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (!checkCredentials(email, password)) {
                    Toast.makeText(MainActivity.this, "Niepoprawne dane logowania!", Toast.LENGTH_LONG).show();
                    passwordInput.setText("");
                    return;
                }

                Toast.makeText(MainActivity.this, "Zalogowano!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, LoggedInActivity.class));
            }
        });
    }

    private void initDb() {
        SQLiteOpenHelper dbHelper = new SQLiteOpenHelper(this, "users.db", null, 1) {
            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, password TEXT)");

                db.execSQL("INSERT INTO users (email, password) VALUES ('admin@example.com', 'admin')");
                db.execSQL("INSERT INTO users (email, password) VALUES ('user1@example.com', 'user1')");
                db.execSQL("INSERT INTO users (email, password) VALUES ('user2@example.com', 'user2')");
                db.execSQL("INSERT INTO users (email, password) VALUES ('user3@example.com', 'user3')");
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL("DROP TABLE IF EXISTS users");
                onCreate(db);
            }
        };

        database = dbHelper.getWritableDatabase();
    }

    private boolean checkCredentials(String email, String password) {
        Cursor cursor = database.rawQuery(
                "SELECT * FROM users WHERE email = ? AND password = ?",
                new String[]{email, password}
        );

        boolean result = cursor.getCount() > 0;
        cursor.close();
        return result;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (database != null) {
            database.close();
        }
    }
}