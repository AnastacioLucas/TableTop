package com.udacity.tabletop.data.model

import java.io.Serializable
import java.util.*

data class Player(
    var name: String?,
    var phone: String?,
    val id: String = UUID.randomUUID().toString()
) : Serializable