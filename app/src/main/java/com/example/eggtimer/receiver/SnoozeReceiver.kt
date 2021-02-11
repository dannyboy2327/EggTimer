package com.example.eggtimer.receiver

import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.text.format.DateUtils
import androidx.core.app.AlarmManagerCompat
import androidx.core.content.ContextCompat

class SnoozeReceiver: BroadcastReceiver() {

    private val REQUEST_CODE = 0

    override fun onReceive(p0: Context, p1: Intent) {
        val triggerTime = SystemClock.elapsedRealtime() + DateUtils.MINUTE_IN_MILLIS

        val notifyIntent = Intent(p0, AlarmReceiver::class.java)
        val notifyPendingIntent = PendingIntent.getBroadcast(
            p0,
            REQUEST_CODE,
            notifyIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val alarmManager = p0.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        AlarmManagerCompat.setExactAndAllowWhileIdle(
            alarmManager,
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            triggerTime,
            notifyPendingIntent
        )

        val notificationManager = ContextCompat.getSystemService(
            p0,
            NotificationManager::class.java
        ) as NotificationManager

        notificationManager.cancelAll()
    }
}