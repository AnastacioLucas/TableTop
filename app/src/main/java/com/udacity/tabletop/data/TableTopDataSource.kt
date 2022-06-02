package com.udacity.tabletop.data

import com.udacity.tabletop.data.dto.TableTopDTO
import com.udacity.tabletop.data.dto.Result

/**
 * Main entry point for accessing tableTops data.
 */
interface TableTopDataSource {
    suspend fun getTableTops(): Result<List<TableTopDTO>>
    suspend fun saveTableTop(tableTop: TableTopDTO)
    suspend fun getTableTop(id: String): Result<TableTopDTO>
    suspend fun deleteAllTableTops()
}