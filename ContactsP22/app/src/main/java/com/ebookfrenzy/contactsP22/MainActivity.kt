package com.ebookfrenzy.contactsP22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.contactsP22.ui.main.MainFragment
//import com.ebookfrenzy.contactsP22.R
import com.ebookfrenzy.roomdemo.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}