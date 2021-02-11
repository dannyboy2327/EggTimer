package com.example.eggtimer.ui

import android.app.Activity
import android.app.Application
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.eggtimer.R
import com.example.eggtimer.databinding.EggTimerFragmentBinding

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

        return binding.root
    }

    private fun createChannel(channelId: String, channelName: String) {

    }

    companion object {
        fun newInstance() = EggTimerFragment()
    }

}