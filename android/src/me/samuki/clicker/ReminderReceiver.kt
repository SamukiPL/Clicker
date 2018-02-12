package me.samuki.clicker

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.BitmapFactory


class ReminderReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, p1: Intent?) {
        val intent = Intent(context, AndroidLauncher::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        val notification = Notification.Builder(context)
                .setContentTitle(context?.getString(R.string.notification_title))
                .setContentText(context?.getString(R.string.notification_text))
                .setSmallIcon(R.drawable.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context?.resources, R.drawable.ic_launcher))
                .setAutoCancel(true)
                .setContentIntent(pendingIntent).build()

        val notificationManager = context?.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(0, notification)
    }
}