package com.example.lifecycleawaretb.ui.main

import android.util.Log
import androidx.core.content.PackageManagerCompat.LOG_TAG
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {
    private var String = ""
    private var output: MutableLiveData<String> = MutableLiveData()
    private val LOG_TAG = "MainViewModel"

    companion object {
        private val LOG_TAG = "MainViewModel"
        private var String = ""
        private var output: MutableLiveData<String> = MutableLiveData()
        fun setOut(output: String) {
            String += "${output}"
            this.output.value = String
            Log.i(LOG_TAG, this.output.value.toString())
        }
    }
    fun setOut(output: String) {
        String += "${output}"
            this.output.value = String
        Log.i(LOG_TAG, this.output.value.toString())
    }

    fun getResult(): MutableLiveData<String> {
        return output
    }
}
