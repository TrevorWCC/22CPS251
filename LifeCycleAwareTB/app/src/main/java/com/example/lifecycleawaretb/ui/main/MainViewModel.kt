package com.example.lifecycleawaretb.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {
    private var String = ""
    private var output: MutableLiveData<String> = MutableLiveData()

    companion object {
        private var String = ""
        private var output: MutableLiveData<String> = MutableLiveData()
        fun setOut(output: String) {
            String += "${output}"
            this.output.value = String
        }
    }
    fun setOut(output: String) {
        String += "${output}"
            this.output.value = String
    }

    fun getResult(): MutableLiveData<String> {
        return output
    }
}
