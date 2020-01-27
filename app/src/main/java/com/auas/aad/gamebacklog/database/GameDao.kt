package com.auas.aad.gamebacklog.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.auas.aad.gamebacklog.model.Game

@Dao
interface GameDao {
    @Insert
    suspend fun insertGame(game: Game)

    @Query("SELECT * FROM Games ORDER BY releaseDate")
    fun getGames(): LiveData<List<Game>>

    @Delete
    suspend fun deleteGame(game: Game)

    @Query("DELETE FROM Games")
    suspend fun deleteAllGames()
}