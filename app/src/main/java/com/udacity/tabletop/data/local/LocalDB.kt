package com.udacity.tabletop.data.local

import android.content.Context
import androidx.room.Room


/**
 * Singleton class that is used to create a tableTop db
 */
object LocalDB {
    /**
     * static method that creates a tableTop class and returns the DAO of the tableTop
     */
    fun createTableTopsDao(context: Context): TableTopDao {
        return Room.databaseBuilder(
            context.applicationContext,
            TableTopDatabase::class.java, "tableTop.db"
        ).build().tableTopDao()
    }
}