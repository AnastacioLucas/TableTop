package com.udacity.tabletop.data.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * Immutable model class for a TableTop. In order to compile with Room
 *
 * @param title         title of the tableTop
 * @param description   description of the tableTop
 * @param location      location name of the tableTop
 * @param latitude      latitude of the tableTop location
 * @param longitude     longitude of the tableTop location
 * @param id          id of the tableTop
 */

@Entity(tableName = "tableTop")
data class TableTopDTO(
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "description") var description: String?,
    @ColumnInfo(name = "location") var location: String?,
    @ColumnInfo(name = "latitude") var latitude: Double?,
    @ColumnInfo(name = "longitude") var longitude: Double?,
    @PrimaryKey @ColumnInfo(name = "entry_id") val id: String = UUID.randomUUID().toString()
)
