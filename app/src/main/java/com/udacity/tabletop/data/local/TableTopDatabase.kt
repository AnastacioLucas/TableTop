package com.udacity.tabletop.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.udacity.tabletop.data.dto.TableTopDTO

/**
 * The Room Database that contains the tableTops table.
 */
@Database(entities = [TableTopDTO::class], version = 1, exportSchema = false)
abstract class TableTopDatabase : RoomDatabase() {
    abstract fun tableTopDao(): TableTopDao
}