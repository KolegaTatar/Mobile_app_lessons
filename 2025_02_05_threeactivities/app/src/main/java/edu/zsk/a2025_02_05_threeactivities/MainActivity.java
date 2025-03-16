package edu.zsk.a2025_02_05_threeactivities;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID_HIGH = "high_priority_channel";
    private static final String CHANNEL_ID_LOW = "low_priority_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // Android 13 (API 33) i nowsze
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }

        createNotificationChannels();

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        button1.setOnClickListener(v -> sendNotification(CHANNEL_ID_HIGH, "High Priority", "Go to Activity 2", Activity2.class));
        button2.setOnClickListener(v -> sendNotification(CHANNEL_ID_LOW, "Low Priority", "Go to Activity 3", Activity3.class));
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel highChannel = new NotificationChannel(
                    CHANNEL_ID_HIGH, "High Priority", NotificationManager.IMPORTANCE_HIGH);
            NotificationChannel lowChannel = new NotificationChannel(
                    CHANNEL_ID_LOW, "Low Priority", NotificationManager.IMPORTANCE_LOW);

            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(highChannel);
                manager.createNotificationChannel(lowChannel);
            }
        }
    }

    private void sendNotification(String channelId, String title, String content, Class<?> destination) {
        Intent intent = new Intent(this, destination);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(channelId.equals(CHANNEL_ID_HIGH) ? NotificationCompat.PRIORITY_HIGH : NotificationCompat.PRIORITY_LOW)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify((int) System.currentTimeMillis(), builder.build());
    }
}