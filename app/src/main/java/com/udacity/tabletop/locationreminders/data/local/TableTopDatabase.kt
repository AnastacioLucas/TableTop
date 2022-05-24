package com.udacity.tabletop.locationreminders.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.udacity.tabletop.locationreminders.data.dto.TableTopDTO

/**
 * The Room Database that contains the reminders table.
 */
@Database(entities = [TableTopDTO::class], version = 1, exportSchema = false)
abstract class TableTopDatabase : RoomDatabase() {

    abstract fun reminderDao(): TableTopDao
}