package com.udacity.tabletop.data.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "player")
data class PlayerDTO(
    @ColumnInfo(name = "name") var name: String?,
    @PrimaryKey @ColumnInfo(name = "player_id") val id: String = UUID.randomUUID().toString()
) : Serializable