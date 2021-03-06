package com.example.recycleradaptertb22.ui.main

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleradaptertb22.R
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random
import com.example.recycleradaptertb22.ui.main.MainViewModel

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    val values = MainViewModel
    //MainViewModel.randomizer()
    private val request_code = 5
    private val titles = values.getTitles()
    private val details = values.getDescs()
    private val images = values.getImages()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])

    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)


            //startActivityForResult(in, 5)
            itemView.setOnClickListener { v: View  ->
                var position: Int = getAdapterPosition()
                val inte = Intent(v.context, MainActivity2::class.java)
                inte.putExtra("qString", itemDetail.text.toString())
                inte.putExtra("qString2",itemTitle.text.toString())
                inte.putExtra("getImage",MainViewModel.image[position])
                v.context.startActivity(inte)
                Snackbar.make(v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }
    }
}