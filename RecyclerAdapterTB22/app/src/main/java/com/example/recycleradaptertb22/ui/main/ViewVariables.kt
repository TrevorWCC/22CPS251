package com.example.recycleradaptertb22.ui.main

import com.example.recycleradaptertb22.R
import com.example.recycleradaptertb22.ui.main.MainViewModel.Companion.setVals
import kotlin.random.Random

class ViewVariables
{

    companion object {
                var viewM = MainViewModel()
                public val titles = arrayOf("Chapter One",
                    "Chapter Two", "Chapter Three", "Chapter Four",
                    "Chapter Five", "Chapter Six", "Chapter Seven",
                    "Chapter Eight")

                public val details = arrayOf("Item one details", "Item two details",
                    "Item three details", "Item four details",
                    "Item five details", "Item six details",
                    "Item seven details", "Item eight details")

                public val images = intArrayOf(R.drawable.android_image_1,
                    R.drawable.android_image_2, R.drawable.android_image_3,
                    R.drawable.android_image_4, R.drawable.android_image_5,
                    R.drawable.android_image_6, R.drawable.android_image_7,
                    R.drawable.android_image_8)






    }
}


