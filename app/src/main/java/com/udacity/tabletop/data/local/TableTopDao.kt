package com.udacity.tabletop.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.tabletop.data.dto.GameDTO

/**
 * Data Access Object for the tableTops table.
 */
@Dao
interface TableTopDao {
    /**
     * @return all tableTops.
     */
    @Query("SELECT * FROM game")
    suspend fun getTableTops(): List<GameDTO>

    /**
     * @param gameId the id of the game
     * @return the game object with the gameId
     */
    @Query("SELECT * FROM game where game_id = :gameId")
    suspend fun getTableTopById(gameId: String): GameDTO?

    /**
     * Insert a tableTop in the database. If the tableTop already exists, replace it.
     *
     * @param tableTop the tableTop to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTableTop(tableTop: GameDTO)

    /**
     * Delete all tableTops.
     */
    @Query("DELETE FROM game")
    suspend fun deleteAllTableTops()

}