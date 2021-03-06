package cs.umass.edu.prepare.reminders;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationPublisher extends BroadcastReceiver {

    public static final String NOTIFICATION_ID = "notification-id";
    public static final String NOTIFICATION = "notification";

    public void onReceive(Context context, Intent intent) {

        if (intent.getAction() != null) {
            if (intent.getAction().equals("reminder")) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

                Notification notification = intent.getParcelableExtra(NOTIFICATION);
                int id = intent.getIntExtra(NOTIFICATION_ID, 0);
                notificationManager.notify(id, notification);
            }
        }

    }
}