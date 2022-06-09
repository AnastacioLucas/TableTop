package com.udacity.tabletop.view.mainScreen

import com.udacity.tabletop.data.dto.PlayerDTO
import java.io.Serializable
import java.util.*

data class Player(
    var name: String?,
) : Serializable {
    constructor(playerDTO: PlayerDTO?) : this(playerDTO!!.name)
}