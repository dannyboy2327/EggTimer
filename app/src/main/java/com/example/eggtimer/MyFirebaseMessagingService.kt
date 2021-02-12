package com.example.eggtimer

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {

    override fun onMessageReceived(p0: RemoteMessage) {
        Log.d("MyFirebase", "From ${p0.from}")

        p0?.data?.let {
            Log.d("MyFirebase", "Message data payload: " + p0.data)
        }
    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        Log.d("MyFirebase", p0)
    }
}