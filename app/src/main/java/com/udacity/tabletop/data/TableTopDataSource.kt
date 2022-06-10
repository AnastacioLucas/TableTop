package com.udacity.tabletop.data

import com.udacity.tabletop.data.dto.GameDTO
import com.udacity.tabletop.data.dto.Result

/**
 * Main entry point for accessing tableTops data.
 */
interface TableTopDataSource {
    suspend fun getTableTops(): Result<List<GameDTO>>
    suspend fun saveTableTop(tableTop: GameDTO)

    suspend fun getAllNewAndOngoing(): Result<List<GameDTO>>
    suspend fun getAllInvites(): Result<List<GameDTO>>
    suspend fun getAllFinishedAnCanceled(): Result<List<GameDTO>>

    suspend fun getTableTop(id: String): Result<GameDTO>
    suspend fun deleteAllTableTops()
}