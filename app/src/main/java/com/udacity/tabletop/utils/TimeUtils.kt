/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.udacity.tabletop.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

fun fromLocalDateToDate(localDate : LocalDate) : Date {
    return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
}

@SuppressLint("WeekBasedYear")
fun formatDate(date :Date) : String {
    val dateFormat = SimpleDateFormat(Constants.API_QUERY_DATE_FORMAT, Locale.getDefault())
    return dateFormat.format(date)
}

fun formatTime(date :Date) : String {
    val dateFormat = SimpleDateFormat(Constants.API_QUERY_TIME_FORMAT, Locale.getDefault())
    return dateFormat.format(date)
}

fun formatLocalDate(localDate : LocalDate) : String {
    val date = fromLocalDateToDate(localDate)
    return  formatDate(date)
}

fun getTodayDate(): Date {
    val rawDate = getRawData()
    val stringDate = formatDate(rawDate)
    val localDate = LocalDate.parse(stringDate, DateTimeFormatter.ISO_DATE)
    return fromLocalDateToDate(localDate)
}

private fun getRawData() : Date {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.HOUR_OF_DAY, 0)
    calendar.set(Calendar.MINUTE, 0)
    calendar.set(Calendar.SECOND, 0)
    return calendar.time
}