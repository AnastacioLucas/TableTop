package com.udacity.tabletop.data.local

import com.udacity.tabletop.data.TableTopDataSource
import com.udacity.tabletop.data.dto.TableTopDTO
import com.udacity.tabletop.data.dto.Result
import kotlinx.coroutines.*

/**
 * Concrete implementation of a data source as a db.
 *
 * The repository is implemented so that you can focus on only testing it.
 *
 * @param tableTopDao the dao that does the Room db operations
 * @param ioDispatcher a coroutine dispatcher to offload the blocking IO tasks
 */
class TableTopLocalRepository(
    private val tableTopDao: TableTopDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : TableTopDataSource {

    /**
     * Get the tableTops list from the local db
     * @return Result the holds a Success with all the tableTops or an Error object with the error message
     */
    override suspend fun getTableTops(): Result<List<TableTopDTO>> = withContext(ioDispatcher) {
        return@withContext try {
            Result.Success(tableTopDao.getTableTops())
        } catch (ex: Exception) {
            Result.Error(ex.localizedMessage)
        }
    }

    /**
     * Insert a tableTop in the db.
     * @param tableTop the tableTop to be inserted
     */
    override suspend fun saveTableTop(tableTop: TableTopDTO) =
        withContext(ioDispatcher) {
            tableTopDao.saveTableTop(tableTop)
        }

    /**
     * Get a tableTop by its id
     * @param id to be used to get the tableTop
     * @return Result the holds a Success object with the TableTop or an Error object with the error message
     */
    override suspend fun getTableTop(id: String): Result<TableTopDTO> = withContext(ioDispatcher) {
        try {
            val tableTop = tableTopDao.getTableTopById(id)
            if (tableTop != null) {
                return@withContext Result.Success(tableTop)
            } else {
                return@withContext Result.Error("TableTop not found!")
            }
        } catch (e: Exception) {
            return@withContext Result.Error(e.localizedMessage)
        }
    }

    /**
     * Deletes all the tableTops in the db
     */
    override suspend fun deleteAllTableTops() {
        withContext(ioDispatcher) {
            tableTopDao.deleteAllTableTops()
        }
    }
}
