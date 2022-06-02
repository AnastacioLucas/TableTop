package com.udacity.tabletop.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.tabletop.data.dto.TableTopDTO

/**
 * Data Access Object for the tableTops table.
 */
@Dao
interface TableTopDao {
    /**
     * @return all tableTops.
     */
    @Query("SELECT * FROM tableTop")
    suspend fun getTableTops(): List<TableTopDTO>

    /**
     * @param tableTopId the id of the tableTop
     * @return the tableTop object with the tableTopId
     */
    @Query("SELECT * FROM tableTop where entry_id = :tableTopId")
    suspend fun getTableTopById(tableTopId: String): TableTopDTO?

    /**
     * Insert a tableTop in the database. If the tableTop already exists, replace it.
     *
     * @param tableTop the tableTop to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTableTop(tableTop: TableTopDTO)

    /**
     * Delete all tableTops.
     */
    @Query("DELETE FROM tableTop")
    suspend fun deleteAllTableTops()

}