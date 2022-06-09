package com.udacity.tabletop.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.udacity.tabletop.data.dto.GameDTO
import com.udacity.tabletop.data.dto.PlayerDTO
import com.udacity.tabletop.utils.TableTopTypeConverters

/**
 * The Room Database that contains the tableTops table.
 */
@Database(entities = [GameDTO::class, PlayerDTO::class], version = 1, exportSchema = false)
@TypeConverters(TableTopTypeConverters::class)
abstract class TableTopDatabase : RoomDatabase() {
    abstract fun tableTopDao(): TableTopDao
}