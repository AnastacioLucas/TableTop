package com.udacity.tabletop.utils

enum class GameStatus(val color: String) {
    NEW("new"),
    ON_GOING("On_Going"),
    INVITED("invited"),
    CANCELED("canceled"),
    FINISHED("finished")
}