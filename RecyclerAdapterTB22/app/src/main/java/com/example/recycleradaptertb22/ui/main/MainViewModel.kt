package com.example.recycleradaptertb22.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel()
{

    var title = arrayOf("", "")
    var detail = arrayOf("")
    var image = intArrayOf(0, 0, 0, 0, 0, 0)
    var i = 0
    fun randomizer() {
        val pass = ViewVariables
        for( i in 1..8)

            this.setVals(
                pass.titles.random(), pass.details.random(),
                pass.images.random())
                Log.i("tag", title[i]);
    }

    fun setVals(random: String, random1: String, random2: Int) {

        this.title[i] = random

        this.detail[i] = random1

        this.image[i] = random2
        i += 1
        print(i)
    }
    companion object {
            //var rand = ViewVariables
            var title = arrayOf("", "")
            var detail = arrayOf("")
            var image = intArrayOf(0, 0, 0, 0, 0, 0)
            var i = 0
            fun setVals(random: String, random1: String, random2: Int) {

                this.title[i] = random

                this.detail[i] = random1

                this.image[i] = random2
                i += 1
                print(i)
            }

            fun getTitles(): Array<String> {
                //randomizer()
                return title
            }

            fun getDescs(): Array<String> {
                //randomizer()
                return detail
            }

            fun getImages(): IntArray {
                //randomizer()
                return image
            }

            fun randomizer()
            { val pass = ViewVariables
                for( i in 1..8)

                this.setVals(
                    pass.titles.random(), pass.details.random(),
                    pass.images.random())

            }

    }
}