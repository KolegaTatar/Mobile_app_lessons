package edu.zsk.a2025_02_05_threeactivities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification(true);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification(false);
            }
        });
    }

    private void showNotification(boolean isHighPriority) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification;

        Intent intent = null;
        if (isHighPriority) {
            intent = new Intent(this, Activity2.class);
        } else {
            intent = new Intent(this, Activity3.class);
        }

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        notification = new Notification.Builder(this)
                .setContentTitle(isHighPriority ? "High Priority Notification" : "Low Priority Notification")
                .setContentText("Click to go to the next activity")
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setPriority(isHighPriority ? Notification.PRIORITY_MAX : Notification.PRIORITY_LOW)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        notificationManager.notify(1, notification);
    }
}
