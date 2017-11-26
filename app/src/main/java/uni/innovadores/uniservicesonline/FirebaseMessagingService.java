package uni.innovadores.uniservicesonline;

/**
 * Created by Javier Gutierrez on 25/11/2017.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.Html;

import com.google.firebase.messaging.RemoteMessage;

import java.io.UnsupportedEncodingException;
import java.util.Date;


public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    int idnt = (int) System.currentTimeMillis();
    public String destino;
    public String versionc;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String msg = remoteMessage.getData().get("message");
        String tt = remoteMessage.getData().get("title");
        destino = remoteMessage.getData().get("dest");
        versionc = remoteMessage.getData().get("update");
        String fmsg = null;
        String ftt = null;


        if (Build.VERSION.SDK_INT >= 24)
        {
            try {
                fmsg = Html.fromHtml(new String(msg.getBytes("UTF-8")), Html.FROM_HTML_MODE_LEGACY).toString();
                ftt = Html.fromHtml(new String(tt.getBytes("UTF-8")), Html.FROM_HTML_MODE_LEGACY).toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
        else
        {
            try {
                fmsg = Html.fromHtml(new String(msg.getBytes("UTF-8"))).toString();
                ftt= Html.fromHtml(new String(tt.getBytes("UTF-8"))).toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        showNotification(ftt, fmsg);
    }


    private void showNotification(String title, String message ) {
        Intent i = new Intent(this,NotifiActivity.class);
        i.putExtra("title", title);
        i.putExtra("message", message);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        final String packageName = getPackageName();
        int icon = R.mipmap.ic_launcher;

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification = builder.setSmallIcon(icon).setTicker(title)
                .setAutoCancel(true)
                .setContentTitle(title)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                .setContentIntent(pendingIntent)
                .setSound(Uri.parse("android.resource://" + packageName + "/"  +R.raw.notification))
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher))
                .setWhen((new Date()).getTime())
                //.setShowWhen(true)
                .setContentText(message).build();


        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(idnt,builder.build());


    }

}