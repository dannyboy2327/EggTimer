package com.example.eggtimer.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.eggtimer.R

class AlarmReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context, p1: Intent) {
        Toast.makeText(p0, p0.getText(R.string.eggs_ready), Toast.LENGTH_SHORT).show()
    }

}