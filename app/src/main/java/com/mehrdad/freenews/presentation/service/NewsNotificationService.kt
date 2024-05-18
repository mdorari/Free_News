package com.mehrdad.freenews.presentation.service

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.mehrdad.freenews.MainActivity
import com.mehrdad.freenews.R
import com.mehrdad.freenews.data.remote.model.remote.Article

class NewsNotificationService(
    private val context: Context
) {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun sendNewsNotification(article: Article) {
        val activityIntent = Intent(context, MainActivity::class.java)
        val notificationId = System.currentTimeMillis().toInt()
        val pendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_MUTABLE else 0
        )

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle(article.title)
            .setContentText(article.description)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setStyle(NotificationCompat.BigTextStyle().bigText(article.content))
            .build()

        notificationManager.notify(notificationId, notification)
    }

    companion object{
        const val CHANNEL_ID = "news_channel"
    }
}