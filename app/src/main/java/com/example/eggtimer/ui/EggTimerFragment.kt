package com.example.eggtimer.ui

import android.app.Activity
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.eggtimer.R
import com.example.eggtimer.databinding.EggTimerFragmentBinding
import com.google.firebase.messaging.FirebaseMessaging

class EggTimerFragment : Fragment() {

    private val TOPIC = "breakfast"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: EggTimerFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.egg_timer_fragment,
            container,
            false
        )

        val viewModel = activity?.let { ViewModelProvider.AndroidViewModelFactory(it.application).create(EggTimerViewModel::class.java) }

        binding.eggTimerViewModel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner

        createChannel(getString(R.string.egg_notification_channel_id),
                        getString(R.string.breakfast_notification_channel_name))

        createChannel(
            getString(R.string.breakfast_notification_channel_id),
            getString(R.string.breakfast_notification_channel_name)
        )
        subscribeTopic()

        return binding.root
    }

    private fun createChannel(channelId: String, channelName: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_HIGH
            )

            notificationChannel.apply {
                enableLights(true)
                lightColor = Color.RED
                enableVibration(true)
                notificationChannel.description = "Time for breakfast"
                setShowBadge(false)
            }

            val notificationManager = requireActivity().getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }

    private fun subscribeTopic() {
        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC)
            .addOnCompleteListener { task ->
                var msg = getString(R.string.message_subscribed)
                if (!task.isSuccessful) {
                    msg = getString(R.string.message_subscribe_failed)
                }
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
            }
    }

    companion object {
        fun newInstance() = EggTimerFragment()
    }

}