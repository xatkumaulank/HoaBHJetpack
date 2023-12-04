package com.example.hoabhjetpack.utils

import java.text.SimpleDateFormat
import java.util.*

object DatetimeUtil {

    fun getTimeFromMillisecond(milliSeconds: Long, dateFormat: String?): String? {
        val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds
        return formatter.format(calendar.time)
    }

}