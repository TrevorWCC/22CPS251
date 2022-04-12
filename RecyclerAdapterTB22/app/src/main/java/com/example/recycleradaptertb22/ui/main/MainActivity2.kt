package com.example.recycleradaptertb22.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.recycleradaptertb22.databinding.MainFragmentBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: MainFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return

        val qString = extras.getString("qString")
        val qString2 = extras.getString("qString2")
        val getImage = extras.getInt("getImage")

        val tag: String? = extras.getString("tag")

        Log.i("zzz",tag.toString())

        binding.titleText.text = qString
        binding.detailText.text = qString2
        binding.imageView.setImageResource(getImage)
    }

    fun returnText(view: View) {
        finish()
    }

    override fun finish() {
        val data = Intent()

        //val returnString = binding.editText2.text.toString()

        //ata.putExtra("returnData", returnString)

        setResult(RESULT_OK, data)
        super.finish()
    }
}