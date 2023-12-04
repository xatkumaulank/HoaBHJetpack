package com.example.hoabhjetpack.utils

import com.example.hoabhjetpack.R

object Constants {
    const val SPLASH_SCREEN_DURATION = 0L

    const val TODO_NEW = 0
    const val TODO_INPROGESS = 1
    const val TODO_DONE = 2

    fun getColorFromStatus(status: Int): Int {
        return when(status){
            TODO_NEW -> R.color.base_color
            TODO_INPROGESS -> R.color.color_inprogress
            TODO_DONE -> R.color.color_done
            else -> R.color.base_color
        }
    }
}