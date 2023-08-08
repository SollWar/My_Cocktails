package ru.nikita.myocktails.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.nikita.myocktails.data.CocktailEntity

@Dao
interface CocktailsRoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewCocktailEntity(cocktailEntity: CocktailEntity)

    @Query("SELECT * FROM cocktails")
    suspend fun getAllCocktails(): List<CocktailEntity>

    @Query("SELECT * FROM cocktails WHERE name = :name")
    suspend fun getCocktailEntityByName(name: String): CocktailEntity

    @Query("DELETE FROM cocktails WHERE name = :name")
    suspend fun deleteCocktailEntityByName(name: String)
}