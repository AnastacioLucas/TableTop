package com.udacity.tabletop.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.TaskStackBuilder
import com.udacity.tabletop.BuildConfig
import com.udacity.tabletop.R
import com.udacity.tabletop.view.mainScreen.Game

private const val TAG = "GeofenceTransitionsJobIntentService"
private const val NOTIFICATION_CHANNEL_ID = BuildConfig.APPLICATION_ID + ".channel"

fun sendNotification(context: Context, game: Game) {
    val notificationManager = context
        .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


    Log.e(TAG, "sendNotification 01" )

    // We need to create a NotificationChannel associated with our CHANNEL_ID before sending a notification.
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
        && notificationManager.getNotificationChannel(NOTIFICATION_CHANNEL_ID) == null
    ) {
        val name = context.getString(R.string.app_name)
        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            name,
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationManager.createNotificationChannel(channel)
    }

//    val intent = TableTopDescriptionActivity.newIntent(context.applicationContext, tableTopDataItem)

    //create a pending intent that opens TableTopDescriptionActivity when the user clicks on the notification
    val stackBuilder = TaskStackBuilder.create(context)
//        .addParentStack(TableTopDescriptionActivity::class.java)
//        .addNextIntent(intent)
    val notificationPendingIntent = stackBuilder
        .getPendingIntent(getUniqueId(), PendingIntent.FLAG_UPDATE_CURRENT)

//    build the notification object with the data to be shown
    val notification = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
        .setSmallIcon(R.mipmap.ic_launcher)
//        .setContentTitle(tableTopDataItem.title)
//        .setContentText(tableTopDataItem.location)
        .setContentIntent(notificationPendingIntent)
        .setAutoCancel(true)
        .build()


    Log.e(TAG, "sendNotification 02" )
    notificationManager.notify(getUniqueId(), notification)
}

private fun getUniqueId() = ((System.currentTimeMillis() % 10000).toInt())