package com.example.recycleradaptertb22

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

import androidx.appcompat.app.AppCompatActivity
import com.example.recycleradaptertb22.databinding.ActivityMainBinding
import com.example.recycleradaptertb22.ui.main.MainViewModel

import com.example.recycleradaptertb22.ui.main.RecyclerAdapter
import com.example.recycleradaptertb22.ui.main.ViewVariables

class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val Variables = ViewVariables()
        val Main = MainViewModel()
        Main.randomizer()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        layoutManager = LinearLayoutManager(this)
        binding.contentMain.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        binding.contentMain.recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }


}