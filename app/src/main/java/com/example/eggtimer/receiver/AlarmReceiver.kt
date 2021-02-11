package com.example.eggtimer.receiver

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.eggtimer.R
import com.example.eggtimer.util.sendNotification

class AlarmReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context, p1: Intent) {
        //Toast.makeText(p0, p0.getText(R.string.eggs_ready), Toast.LENGTH_SHORT).show()

        val notificationManager = ContextCompat.getSystemService(
            p0,
            NotificationManager::class.java
        ) as NotificationManager

        notificationManager.sendNotification(
            p0.getString(R.string.eggs_ready),
            p0
        )
    }



}