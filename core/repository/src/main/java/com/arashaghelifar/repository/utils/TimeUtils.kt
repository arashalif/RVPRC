package com.arashaghelifar.repository.utils

import java.text.SimpleDateFormat
import java.util.Locale


fun String.extractTime():String{
    val inputFormatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    val date = inputFormatter.parse(this) ?: return ""
    val timeFormatter = SimpleDateFormat("h:mm a", Locale.ENGLISH)
    val time = timeFormatter.format(date)
    return time
}

fun String.extractDate():String{
    val inputFormatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    val date = inputFormatter.parse(this) ?: return ""
    val monthDayFormatter = SimpleDateFormat("MMM dd", Locale.ENGLISH)
    val monthDay = monthDayFormatter.format(date)
    return monthDay
}
