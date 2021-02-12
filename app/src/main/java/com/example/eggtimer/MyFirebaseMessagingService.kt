package com.example.eggtimer

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {

    override fun onMessageReceived(p0: RemoteMessage) {

    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        Log.d("MyFirebase", p0)
    }
}