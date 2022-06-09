package com.udacity.tabletop.data.dto

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

/**
 * data class acts as a data mapper between the DB and the UI
 */
@Entity(tableName = "game")
data class GameDTO(
    @ColumnInfo(name = "title") var title: String?,
    @Embedded var master: PlayerDTO?,
//    var game: String = "cthulhu death may die",
    @ColumnInfo(name = "status") var status: String?,
    @ColumnInfo(name = "daysOfTheWeek") var daysOfTheWeek: String?,
    @ColumnInfo(name = "time") var time: Date?,
//    var guests: List<Player>?,
    @PrimaryKey @ColumnInfo(name = "game_id") val id: String = UUID.randomUUID().toString()
) : Serializable