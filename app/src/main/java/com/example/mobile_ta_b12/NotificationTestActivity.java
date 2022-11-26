package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NotificationTestActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "test_channel" ;
    private Button buttonShow;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_test);

        // 1. Ambil notification manager
        notificationManager = NotificationManagerCompat.from(this);

        // 2b. Buat channel notifikasi
        createNotificationChannel();

        buttonShow = findViewById(R.id.buttonShow);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent resultIntent = new Intent(NotificationTestActivity.this, PersetujuanTugasAkhirActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(NotificationTestActivity.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                // 3. Buat builder untuk membuat notifikasi
                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationTestActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_baseline_warning_24)
                        .setContentTitle("Notifikasi ke activity Persetujuan TA")
                        .setContentText("Klik notifikasi ini untuk pergi ke activity Persetujuan TA")
//                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.ic_baseline_warning_24, "PERGI", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                // 4. Buat objek notifikasi
                Notification notification = builder.build();

                // 5. Tampilkan notifikasi
                notificationManager.notify(101, notification);
            }
        });
    }

    // 2a. Buat channel
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Channel Contoh", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Ini hanya channel untuk contoh notifikasi");
            notificationManager.createNotificationChannel(channel);
        }
    }
}