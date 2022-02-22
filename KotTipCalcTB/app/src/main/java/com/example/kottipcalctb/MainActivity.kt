package com.example.kottipcalctb

import android.icu.util.Output
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kottipcalctb.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { "calTip()" }


    }


    fun calTip(view: View) {
        val victory = " "
        if(binding.billIn.text.isNotEmpty()){
            val billTot = binding.billIn.text.toString().toFloat()
            val tip10 = billTot*1.1
            val tip15 = billTot*1.15
            val tip20 = billTot*1.2
            val formal10 = NumberFormat.getCurrencyInstance().format(tip10)
            val formal15 = NumberFormat.getCurrencyInstance().format(tip15)
            val formal20 = NumberFormat.getCurrencyInstance().format(tip20)
            binding.billOut.text = "Would give Calulations"

        }else{
            binding.billOut.text = "Please Enter A Bill Amount"
        }
    }
}