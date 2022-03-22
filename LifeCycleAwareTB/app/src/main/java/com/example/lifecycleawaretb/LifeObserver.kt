@file:Suppress("DEPRECATION")

package com.example.lifecycleawaretb

import android.icu.util.Output
import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.example.lifecycleawaretb.ui.main.MainViewModel

class LifeObserver: LifecycleObserver {
    var output = ""
    private val LOG_TAG = "LifeObserver"
    private var viewModel = MainViewModel

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i(LOG_TAG, "onResume")
        viewModel.setOut("onResume was fired on this date")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i(LOG_TAG, "onPause")
        viewModel.setOut("onPause was fired on this date")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i(LOG_TAG, "onCreate")
        viewModel.setOut("onCreate was fired on this date")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i(LOG_TAG, "onStart")
        viewModel.setOut("onStart was fired on this date")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i(LOG_TAG, "onStop")
        viewModel.setOut("onStop was fired on this date")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i(LOG_TAG, "onDestroy")
        viewModel.setOut("onDestroy was fired on this date")
    }

}