package com.udacity.tabletop.locationreminders.data.local

import android.content.Context
import androidx.room.Room


/**
 * Singleton class that is used to create a reminder db
 */
object LocalDB {

    /**
     * static method that creates a reminder class and returns the DAO of the reminder
     */
    fun createRemindersDao(context: Context): TableTopDao {
        return Room.databaseBuilder(
            context.applicationContext,
            TableTopDatabase::class.java, "locationReminders.db"
        ).build().reminderDao()
    }

}