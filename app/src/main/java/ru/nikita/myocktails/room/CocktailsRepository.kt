package ru.nikita.myocktails.room

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.nikita.myocktails.data.CocktailEntity
import javax.inject.Inject

@InstallIn(SingletonComponent::class)
@Module
class CocktailsRepository @Inject constructor(private val cocktailsRoomDao: CocktailsRoomDao) {

    suspend fun insertNewCocktailEntity(cocktailEntity: CocktailEntity) {
        cocktailsRoomDao.insertNewCocktailEntity(cocktailEntity)
    }

    suspend fun getAllCocktails(): List<CocktailEntity> {
        return cocktailsRoomDao.getAllCocktails()
    }

    suspend fun getCocktailEntityByName(name: String): CocktailEntity {
        return cocktailsRoomDao.getCocktailEntityByName(name)
    }

    suspend fun deleteCocktailEntityByName(name: String) {
        cocktailsRoomDao.deleteCocktailEntityByName(name)
    }
}