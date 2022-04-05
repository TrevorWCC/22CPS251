package com.example.recycleradaptertb22.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel()
{

        companion object
        {
            var title = arrayOf("")
            var detail = arrayOf("")
            var image = intArrayOf(0)
            var i = 0
            fun setVals(random: String, random1: String, random2: Int) {

                this.title[i] = random

                this.detail[i] = random1

                this.image[i] = random2
                i +=1
            }
            fun getTitles(): Array<String> {
                return title
            }
            fun getDescs(): Array<String> {
                return detail
            }
            fun getImages(): IntArray {
                return image
            }


    }
}