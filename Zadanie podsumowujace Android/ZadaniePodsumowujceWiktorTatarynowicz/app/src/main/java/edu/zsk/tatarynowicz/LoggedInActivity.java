package edu.zsk.tatarynowicz;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class LoggedInActivity extends AppCompatActivity {
    public static final String CHANNEL_ID = "2137";
    private static final String CHANNEL_NAME = "Zadanie podsumowujące";
    private String activeFragment = "first";
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        fragmentManager = getSupportFragmentManager();
        loadFragment(new FirstFragment(), R.id.fragmentHolder);

        findViewById(R.id.changeFragmentButton).setOnClickListener(v -> changeFragment());
        findViewById(R.id.showNotificationButton).setOnClickListener(v -> sendNotification());
    }

    private void loadFragment(Fragment fragment, int containerId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(containerId, fragment);
        transaction.commit();
    }

    private void changeFragment() {
        if ("first".equals(activeFragment)) {
            activeFragment = "second";
            loadFragment(new SecondFragment(), R.id.fragmentHolder);
        } else {
            activeFragment = "first";
            loadFragment(new FirstFragment(), R.id.fragmentHolder);
        }
    }

    private void sendNotification() {
        createNotificationChannel();

        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Powiadomienie")
                .setContentText("Wiadomość powiadomienia")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.notify(1, builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT);
            getSystemService(NotificationManager.class).createNotificationChannel(channel);
        }
    }

    public void openDialog() {
        AppDialogFragment dialog = new AppDialogFragment();
        dialog.setCancelable(true);
        dialog.show(fragmentManager, "AppDialogFragment");
    }
}