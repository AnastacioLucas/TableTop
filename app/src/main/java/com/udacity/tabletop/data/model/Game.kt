package com.udacity.tabletop.data.model

import java.io.Serializable
import java.util.*

/**
 * data class acts as a data mapper between the DB and the UI
 */
data class Game(
    var title: String?,
    var master: Player?,
//    var game: String = "cthulhu death may die",
    var status: String?,
    var daysOfTheWeek: String?,
    var time: Date?,
//    var guests: List<Player>?,
    val id: String = UUID.randomUUID().toString()
) : Serializable